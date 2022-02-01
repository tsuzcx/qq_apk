package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

public class i
  implements e
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected long bxw;
  protected c cUM;
  private int frameCount;
  protected z gnF;
  protected long gnO;
  protected int gnX;
  protected int gqY;
  protected MediaFormat hBj;
  private byte[] hBk;
  protected String hxQ;
  protected int sampleSize;
  protected e.a tFH;
  
  public i(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(107665);
    this.hxQ = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramc, paramMediaFormat, Integer.valueOf(paramInt) });
    this.cUM = paramc;
    this.hBj = paramMediaFormat;
    this.gqY = paramInt;
    AppMethodBeat.o(107665);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(107669);
    if (this.gnF == null)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
      AppMethodBeat.o(107669);
      return true;
    }
    Object localObject = this.gnF.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(107669);
      return false;
    }
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.gnF.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bt.GC();
      bool1 = ajw();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bt.aS(l)) });
      if (bool1)
      {
        AppMethodBeat.o(107669);
        return true;
      }
      i += 1;
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = paramc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      l = paramc.fGK.getSampleTime();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.gnO * 1000L)) {
        break label345;
      }
    }
    label337:
    label345:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.gnF;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bt.GC();
        boolean bool2 = ajw();
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bt.aS(l)) });
        if (!bool2) {
          break label337;
        }
        AppMethodBeat.o(107669);
        return true;
        i = 0;
        break;
        ad.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(107669);
      return bool1;
    }
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(107667);
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
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(107667);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(107667);
    return null;
  }
  
  public final void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(107671);
    this.frameCount = 0;
    while (!a(this.cUM))
    {
      this.cUM.fGK.advance();
      if (this.cUM.fGK.getSampleTrackIndex() != this.gqY) {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
    }
    c localc = this.cUM;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
    Object localObject = this.gnF.getInputBuffers();
    int i = this.gnF.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (ajw()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      long l = localc.fGK.getSampleTime();
      if (i < 0) {
        break label236;
      }
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.gnF.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      ajw();
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107664);
          if (i.this.gnF != null)
          {
            ad.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try
            {
              i.this.gnF.stop();
              i.this.gnF.release();
              i.this.gnF = null;
              AppMethodBeat.o(107664);
              return;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(107664);
        }
      }, 500L);
      paramRunnable.run();
      AppMethodBeat.o(107671);
      return;
      label236:
      ad.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
    }
  }
  
  protected int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(107668);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bt.GC();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (oX(m)) {
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
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(107668);
    return j;
  }
  
  public final void a(e.a parama)
  {
    this.tFH = parama;
  }
  
  public final Point aDh()
  {
    AppMethodBeat.i(107673);
    Point localPoint = new Point(this.hBj.getInteger("width"), this.hBj.getInteger("height"));
    AppMethodBeat.o(107673);
    return localPoint;
  }
  
  public int aDi()
  {
    AppMethodBeat.i(107672);
    int i = this.hBj.getInteger("color-format");
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(107672);
      return 1;
    case 19: 
      AppMethodBeat.o(107672);
      return 2;
    }
    AppMethodBeat.o(107672);
    return 1;
  }
  
  protected boolean ajw()
  {
    AppMethodBeat.i(107670);
    if (this.gnF == null)
    {
      ad.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(107670);
      return true;
    }
    Object localObject1 = this.gnF.getOutputBuffers();
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject1.length) });
    int i = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label102:
      AppMethodBeat.o(107670);
      return false;
    }
    if (i == -3)
    {
      localObject1 = this.gnF.getOutputBuffers();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label102;
      if (i == -2)
      {
        this.hBj = this.gnF.getOutputFormat();
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.hBj);
      }
      else if (i < 0)
      {
        ad.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ad.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          break label102;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.bxw * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.gnF.releaseOutputBuffer(i, false);
          ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.bxw * 1000L) });
          AppMethodBeat.o(107670);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localObject2.position(this.bufferInfo.offset);
          localObject2.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bt.GC();
          localObject1 = this.bufferInfo;
          if (localObject2 == null) {
            ad.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ad.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bt.aS(l2)) });
            this.gnF.releaseOutputBuffer(i, false);
            if ((this.gnO != 1L) && (l1 >= this.gnO * 1000L))
            {
              ad.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(107670);
              return true;
              this.frameCount += 1;
              if ((this.gnX > 1) && (this.frameCount % this.gnX == 0)) {
                continue;
              }
              if (this.hBk == null) {
                this.hBk = new byte[localObject2.remaining()];
              }
              long l3 = bt.GC();
              try
              {
                this.hBj = this.gnF.getOutputFormat();
                localObject2.get(this.hBk, 0, localObject2.remaining());
                ad.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localObject2, localObject1, Integer.valueOf(((MediaCodec.BufferInfo)localObject1).size), Long.valueOf(bt.aS(l3)) });
                if (this.tFH != null) {
                  this.tFH.br(this.hBk);
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ad.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                }
              }
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            ad.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.gnF.stop();
              this.gnF.release();
              this.gnF = null;
              AppMethodBeat.o(107670);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(107670);
          return false;
        }
        this.gnF.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void oV(int paramInt)
  {
    AppMethodBeat.i(107675);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gnX = paramInt;
    AppMethodBeat.o(107675);
  }
  
  protected boolean oX(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  public final int q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107666);
    this.hxQ = paramString;
    this.bxw = paramLong1;
    this.gnO = paramLong2;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.hBj + "]");
    try
    {
      paramString = this.hBj.getString("mime");
      this.gnF = z.pl(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        int i = a(localMediaCodecInfo, paramString);
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
        this.hBj.setInteger("color-format", i);
      }
      this.gnF.a(this.hBj, null, 0);
      this.gnF.start();
      AppMethodBeat.o(107666);
      return 0;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(107666);
    }
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107674);
    if (this.gnF != null) {
      try
      {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.gnF.stop();
        this.gnF.release();
        this.gnF = null;
        AppMethodBeat.o(107674);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(107674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.i
 * JD-Core Version:    0.7.0.1
 */