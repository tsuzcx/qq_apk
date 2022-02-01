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
  protected c ddy;
  private int frameCount;
  protected int hiI;
  protected z hir;
  protected long hiy;
  protected int hjY;
  protected String irN;
  protected MediaFormat ivg;
  private byte[] ivh;
  protected int sampleSize;
  protected long startTimeMs;
  protected e.a vRl;
  
  public i(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(107665);
    this.irN = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramc, paramMediaFormat, Integer.valueOf(paramInt) });
    this.ddy = paramc;
    this.ivg = paramMediaFormat;
    this.hjY = paramInt;
    AppMethodBeat.o(107665);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(107669);
    if (this.hir == null)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
      AppMethodBeat.o(107669);
      return true;
    }
    Object localObject = this.hir.getInputBuffers();
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
      j = this.hir.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bt.HI();
      bool1 = atq();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bt.aO(l)) });
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
      this.sampleSize = paramc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      l = paramc.gdS.getSampleTime();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.hiy * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.hir;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bt.HI();
        boolean bool2 = atq();
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bt.aO(l)) });
        if (!bool2) {
          break label338;
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
  
  public final void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(107671);
    this.frameCount = 0;
    while (!a(this.ddy))
    {
      this.ddy.gdS.advance();
      if (this.ddy.gdS.getSampleTrackIndex() != this.hjY) {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
    }
    c localc = this.ddy;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
    Object localObject = this.hir.getInputBuffers();
    int i = this.hir.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (atq()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      long l = localc.gdS.getSampleTime();
      if (i < 0) {
        break label237;
      }
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.hir.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      atq();
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107664);
          if (i.this.hir != null)
          {
            ad.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try
            {
              i.this.hir.stop();
              i.this.hir.release();
              i.this.hir = null;
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
      label237:
      ad.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
    }
  }
  
  protected int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(107668);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bt.HI();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (qo(m)) {
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
    this.vRl = parama;
  }
  
  public final Point aNh()
  {
    AppMethodBeat.i(107673);
    Point localPoint = new Point(this.ivg.getInteger("width"), this.ivg.getInteger("height"));
    AppMethodBeat.o(107673);
    return localPoint;
  }
  
  public int aNi()
  {
    AppMethodBeat.i(107672);
    int i = this.ivg.getInteger("color-format");
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
  
  protected boolean atq()
  {
    AppMethodBeat.i(107670);
    if (this.hir == null)
    {
      ad.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(107670);
      return true;
    }
    Object localObject1 = this.hir.getOutputBuffers();
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject1.length) });
    int i = this.hir.dequeueOutputBuffer(this.bufferInfo, 60000L);
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
      localObject1 = this.hir.getOutputBuffers();
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.hir.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label102;
      if (i == -2)
      {
        this.ivg = this.hir.getOutputFormat();
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.ivg);
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
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.hir.releaseOutputBuffer(i, false);
          ad.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(107670);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localObject2.position(this.bufferInfo.offset);
          localObject2.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bt.HI();
          localObject1 = this.bufferInfo;
          if (localObject2 == null) {
            ad.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ad.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bt.aO(l2)) });
            this.hir.releaseOutputBuffer(i, false);
            if ((this.hiy != 1L) && (l1 >= this.hiy * 1000L))
            {
              ad.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(107670);
              return true;
              this.frameCount += 1;
              if ((this.hiI > 1) && (this.frameCount % this.hiI == 0)) {
                continue;
              }
              if (this.ivh == null) {
                this.ivh = new byte[localObject2.remaining()];
              }
              long l3 = bt.HI();
              try
              {
                this.ivg = this.hir.getOutputFormat();
                localObject2.get(this.ivh, 0, localObject2.remaining());
                ad.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localObject2, localObject1, Integer.valueOf(((MediaCodec.BufferInfo)localObject1).size), Long.valueOf(bt.aO(l3)) });
                if (this.vRl != null) {
                  this.vRl.bt(this.ivh);
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
              this.hir.stop();
              this.hir.release();
              this.hir = null;
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
        this.hir.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107666);
    this.irN = paramString;
    this.startTimeMs = paramLong1;
    this.hiy = paramLong2;
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.ivg + "]");
    try
    {
      paramString = this.ivg.getString("mime");
      this.hir = z.vm(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      ad.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        int i = a(localMediaCodecInfo, paramString);
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
        this.ivg.setInteger("color-format", i);
      }
      this.hir.a(this.ivg, null, 0);
      this.hir.start();
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
  
  public final void qm(int paramInt)
  {
    AppMethodBeat.i(107675);
    ad.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hiI = paramInt;
    AppMethodBeat.o(107675);
  }
  
  protected boolean qo(int paramInt)
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
    if (this.hir != null) {
      try
      {
        ad.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.hir.stop();
        this.hir.release();
        this.hir = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.i
 * JD-Core Version:    0.7.0.1
 */