package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public class i
  implements e
{
  protected long aRW;
  protected String eFp = null;
  protected MediaCodec.BufferInfo eIJ = new MediaCodec.BufferInfo();
  protected MediaExtractor eIP;
  protected long eIR;
  protected MediaFormat eIS;
  protected MediaCodec eIT;
  protected int eIU;
  protected int eIV;
  private byte[] eIW;
  private int frameCount = 0;
  protected e.a mlq;
  protected int sampleSize;
  
  public i(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, int paramInt)
  {
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramMediaExtractor, paramMediaFormat, Integer.valueOf(paramInt) });
    this.eIP = paramMediaExtractor;
    this.eIS = paramMediaFormat;
    this.eIU = paramInt;
  }
  
  private static MediaCodecInfo ol(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final Point SP()
  {
    return new Point(this.eIS.getInteger("width"), this.eIS.getInteger("height"));
  }
  
  public int SQ()
  {
    int i = this.eIS.getInteger("color-format");
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 21: 
    case 2130706688: 
    default: 
      return 1;
    }
    return 2;
  }
  
  protected boolean ST()
  {
    if (this.eIT == null)
    {
      y.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      return true;
    }
    Object localObject1 = this.eIT.getOutputBuffers();
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject1.length) });
    int i = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->" + i);
    if (i == -1)
    {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label93:
      return false;
    }
    if (i == -3)
    {
      localObject1 = this.eIT.getOutputBuffers();
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label93;
      if (i == -2)
      {
        this.eIS = this.eIT.getOutputFormat();
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.eIS);
      }
      else if (i < 0)
      {
        y.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: " + i);
      }
      else
      {
        y.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          break label93;
        }
        long l1 = this.eIJ.presentationTimeUs;
        if ((l1 < this.aRW * 1000L) && ((this.eIJ.flags & 0x4) == 0))
        {
          this.eIT.releaseOutputBuffer(i, false);
          y.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.aRW * 1000L) });
          return false;
        }
        if (this.eIJ.size != 0)
        {
          localObject2.position(this.eIJ.offset);
          localObject2.limit(this.eIJ.offset + this.eIJ.size);
          long l2 = bk.UZ();
          localObject1 = this.eIJ;
          if (localObject2 == null) {
            y.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            y.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bk.cp(l2)) });
            this.eIT.releaseOutputBuffer(i, false);
            if ((this.eIR != 1L) && (l1 >= this.eIR * 1000L))
            {
              y.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              return true;
              this.frameCount += 1;
              if ((this.eIV > 1) && (this.frameCount % this.eIV == 0)) {
                continue;
              }
              if (this.eIW == null) {
                this.eIW = new byte[localObject2.remaining()];
              }
              long l3 = bk.UZ();
              try
              {
                this.eIS = this.eIT.getOutputFormat();
                localObject2.get(this.eIW, 0, localObject2.remaining());
                y.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localObject2, localObject1, Integer.valueOf(((MediaCodec.BufferInfo)localObject1).size), Long.valueOf(bk.cp(l3)) });
                if (this.mlq != null) {
                  this.mlq.aD(this.eIW);
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  y.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                }
              }
            }
          }
          if ((this.eIJ.flags & 0x4) != 0)
          {
            y.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.eIT.stop();
              this.eIT.release();
              this.eIT = null;
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                y.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          return false;
        }
        this.eIT.releaseOutputBuffer(i, false);
      }
    }
  }
  
  protected int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bk.UZ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (uf(m)) {
        if (m <= j)
        {
          k = j;
          if (m != 21) {}
        }
        else
        {
          k = m;
        }
      }
      i += 1;
    }
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    return j;
  }
  
  public final void a(e.a parama)
  {
    this.mlq = parama;
  }
  
  public final int i(String paramString, long paramLong1, long paramLong2)
  {
    this.eFp = paramString;
    this.aRW = paramLong1;
    this.eIR = paramLong2;
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.eIS + "]");
    try
    {
      paramString = this.eIS.getString("mime");
      this.eIT = MediaCodec.createDecoderByType(paramString);
      MediaCodecInfo localMediaCodecInfo = ol(paramString);
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        int i = a(localMediaCodecInfo, paramString);
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
        this.eIS.setInteger("color-format", i);
      }
      this.eIT.configure(this.eIS, null, null, 0);
      this.eIT.start();
      return 0;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
    }
    return -1;
  }
  
  public final void ju(int paramInt)
  {
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eIV = paramInt;
  }
  
  public final void r(Runnable paramRunnable)
  {
    this.frameCount = 0;
    Object localObject1 = this.eIP;
    if (this.eIT == null) {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
    }
    Object localObject2;
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        this.eIP.advance();
        if (this.eIP.getSampleTrackIndex() == this.eIU) {
          break;
        }
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
      localObject1 = this.eIP;
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
      localObject2 = this.eIT.getInputBuffers();
      i = this.eIT.dequeueInputBuffer(60000L);
      if (i < 0)
      {
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        if (ST()) {}
      }
      else
      {
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
          ((ByteBuffer)localObject2).position(0);
          l = ((MediaExtractor)localObject1).getSampleTime();
          if (i < 0) {
            break label560;
          }
          y.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          this.eIT.queueInputBuffer(i, 0, 0, l * 1000L, 4);
        }
        label217:
        ST();
      }
      ai.l(new i.1(this), 500L);
      paramRunnable.run();
      return;
      localObject2 = this.eIT.getInputBuffers();
      if (localObject2 != null) {
        break label263;
      }
    }
    label263:
    y.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject2.length) });
    int i = 0;
    int j;
    for (;;)
    {
      j = this.eIT.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break label359;
      }
      l = bk.UZ();
      bool1 = ST();
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bk.cp(l)) });
      if (bool1)
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    label359:
    if (j >= 0)
    {
      localObject2 = localObject2[j];
      ((ByteBuffer)localObject2).clear();
      this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
      ((ByteBuffer)localObject2).position(0);
      l = ((MediaExtractor)localObject1).getSampleTime();
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.eIR * 1000L)) {
        break label571;
      }
    }
    label560:
    label571:
    for (bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = this.eIT;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        label484:
        ((MediaCodec)localObject1).queueInputBuffer(j, 0, k, l, i);
      }
      for (;;)
      {
        l = bk.UZ();
        boolean bool2 = ST();
        y.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bk.cp(l)) });
        if (!bool2) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label484;
        y.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
        bool1 = false;
      }
      y.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
      break label217;
    }
  }
  
  public final void stop()
  {
    if (this.eIT != null) {}
    try
    {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
      this.eIT.stop();
      this.eIT.release();
      this.eIT = null;
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  protected boolean uf(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.i
 * JD-Core Version:    0.7.0.1
 */