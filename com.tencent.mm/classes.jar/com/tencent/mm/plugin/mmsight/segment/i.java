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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

public class i
  implements e
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected long bvf;
  protected c cSi;
  private int frameCount;
  protected int gOI;
  protected z gOr;
  protected long gOz;
  protected int gRG;
  protected String hYr;
  protected MediaFormat ibK;
  private byte[] ibL;
  protected int sampleSize;
  protected e.a uOc;
  
  public i(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(107665);
    this.hYr = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramc, paramMediaFormat, Integer.valueOf(paramInt) });
    this.cSi = paramc;
    this.ibK = paramMediaFormat;
    this.gRG = paramInt;
    AppMethodBeat.o(107665);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(107669);
    if (this.gOr == null)
    {
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
      AppMethodBeat.o(107669);
      return true;
    }
    Object localObject = this.gOr.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(107669);
      return false;
    }
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.gOr.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bs.Gn();
      bool1 = aqv();
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bs.aO(l)) });
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
      l = paramc.fKr.getSampleTime();
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.gOz * 1000L)) {
        break label345;
      }
    }
    label337:
    label345:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.gOr;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bs.Gn();
        boolean bool2 = aqv();
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bs.aO(l)) });
        if (!bool2) {
          break label337;
        }
        AppMethodBeat.o(107669);
        return true;
        i = 0;
        break;
        ac.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
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
  
  public final void I(Runnable paramRunnable)
  {
    AppMethodBeat.i(107671);
    this.frameCount = 0;
    while (!a(this.cSi))
    {
      this.cSi.fKr.advance();
      if (this.cSi.fKr.getSampleTrackIndex() != this.gRG) {
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
    }
    c localc = this.cSi;
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
    Object localObject = this.gOr.getInputBuffers();
    int i = this.gOr.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (aqv()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      long l = localc.fKr.getSampleTime();
      if (i < 0) {
        break label236;
      }
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.gOr.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      aqv();
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107664);
          if (i.this.gOr != null)
          {
            ac.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try
            {
              i.this.gOr.stop();
              i.this.gOr.release();
              i.this.gOr = null;
              AppMethodBeat.o(107664);
              return;
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(107664);
        }
      }, 500L);
      paramRunnable.run();
      AppMethodBeat.o(107671);
      return;
      label236:
      ac.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
    }
  }
  
  protected int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(107668);
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bs.Gn();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (pM(m)) {
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
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(107668);
    return j;
  }
  
  public final void a(e.a parama)
  {
    this.uOc = parama;
  }
  
  public final Point aJY()
  {
    AppMethodBeat.i(107673);
    Point localPoint = new Point(this.ibK.getInteger("width"), this.ibK.getInteger("height"));
    AppMethodBeat.o(107673);
    return localPoint;
  }
  
  public int aJZ()
  {
    AppMethodBeat.i(107672);
    int i = this.ibK.getInteger("color-format");
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
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
  
  protected boolean aqv()
  {
    AppMethodBeat.i(107670);
    if (this.gOr == null)
    {
      ac.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(107670);
      return true;
    }
    Object localObject1 = this.gOr.getOutputBuffers();
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject1.length) });
    int i = this.gOr.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label102:
      AppMethodBeat.o(107670);
      return false;
    }
    if (i == -3)
    {
      localObject1 = this.gOr.getOutputBuffers();
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.gOr.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label102;
      if (i == -2)
      {
        this.ibK = this.gOr.getOutputFormat();
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.ibK);
      }
      else if (i < 0)
      {
        ac.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ac.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          break label102;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.bvf * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.gOr.releaseOutputBuffer(i, false);
          ac.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.bvf * 1000L) });
          AppMethodBeat.o(107670);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localObject2.position(this.bufferInfo.offset);
          localObject2.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bs.Gn();
          localObject1 = this.bufferInfo;
          if (localObject2 == null) {
            ac.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ac.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bs.aO(l2)) });
            this.gOr.releaseOutputBuffer(i, false);
            if ((this.gOz != 1L) && (l1 >= this.gOz * 1000L))
            {
              ac.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(107670);
              return true;
              this.frameCount += 1;
              if ((this.gOI > 1) && (this.frameCount % this.gOI == 0)) {
                continue;
              }
              if (this.ibL == null) {
                this.ibL = new byte[localObject2.remaining()];
              }
              long l3 = bs.Gn();
              try
              {
                this.ibK = this.gOr.getOutputFormat();
                localObject2.get(this.ibL, 0, localObject2.remaining());
                ac.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localObject2, localObject1, Integer.valueOf(((MediaCodec.BufferInfo)localObject1).size), Long.valueOf(bs.aO(l3)) });
                if (this.uOc != null) {
                  this.uOc.bq(this.ibL);
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ac.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                }
              }
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            ac.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.gOr.stop();
              this.gOr.release();
              this.gOr = null;
              AppMethodBeat.o(107670);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ac.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(107670);
          return false;
        }
        this.gOr.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107666);
    this.hYr = paramString;
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.ibK + "]");
    try
    {
      paramString = this.ibK.getString("mime");
      this.gOr = z.sx(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      ac.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        int i = a(localMediaCodecInfo, paramString);
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
        this.ibK.setInteger("color-format", i);
      }
      this.gOr.a(this.ibK, null, 0);
      this.gOr.start();
      AppMethodBeat.o(107666);
      return 0;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(107666);
    }
    return -1;
  }
  
  public final void pK(int paramInt)
  {
    AppMethodBeat.i(107675);
    ac.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gOI = paramInt;
    AppMethodBeat.o(107675);
  }
  
  protected boolean pM(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107674);
    if (this.gOr != null) {
      try
      {
        ac.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.gOr.stop();
        this.gOr.release();
        this.gOr = null;
        AppMethodBeat.o(107674);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(107674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.i
 * JD-Core Version:    0.7.0.1
 */