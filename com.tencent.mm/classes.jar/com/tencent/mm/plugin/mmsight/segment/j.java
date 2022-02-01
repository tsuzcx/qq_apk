package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j
  extends i
{
  public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";
  
  public j(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    super(paramc, paramMediaFormat, paramInt);
    AppMethodBeat.i(107676);
    ad.i(TAG, "init ");
    AppMethodBeat.o(107676);
  }
  
  private static byte[] b(Image paramImage)
  {
    AppMethodBeat.i(107679);
    int j = paramImage.getFormat();
    int i3 = paramImage.getWidth();
    int i4 = paramImage.getHeight();
    int i = 0;
    paramImage = paramImage.getPlanes();
    int k = i3 * i4 * ImageFormat.getBitsPerPixel(j) / 8;
    ad.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[] { Integer.valueOf(paramImage.length), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(j) });
    byte[] arrayOfByte1 = com.tencent.mm.plugin.mmsight.model.a.j.tEA.g(Integer.valueOf(k));
    k = 0;
    while (k < paramImage.length)
    {
      ByteBuffer localByteBuffer = paramImage[k].getBuffer();
      int i5 = paramImage[k].getRowStride();
      int i6 = paramImage[k].getPixelStride();
      int m;
      if (k == 0)
      {
        m = i3;
        if (k != 0) {
          break label297;
        }
      }
      byte[] arrayOfByte2;
      int i1;
      label297:
      for (int n = i4;; n = i4 / 2)
      {
        ad.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[] { Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i6) });
        arrayOfByte2 = com.tencent.mm.plugin.mmsight.model.a.j.tEA.g(Integer.valueOf(i5));
        i1 = 0;
        for (;;)
        {
          if (i1 >= n) {
            break label384;
          }
          j = ImageFormat.getBitsPerPixel(35) / 8;
          if (i6 != j) {
            break;
          }
          j *= m;
          localByteBuffer.get(arrayOfByte1, i, j);
          if (n - i1 != 1) {
            localByteBuffer.position(localByteBuffer.position() + i5 - j);
          }
          i += j;
          i1 += 1;
        }
        m = i3 / 2;
        break;
      }
      if (n - i1 == 1) {
        localByteBuffer.get(arrayOfByte2, 0, i3 - i6 + 1);
      }
      for (;;)
      {
        int i2 = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (i2 >= m) {
            break;
          }
          arrayOfByte1[j] = arrayOfByte2[(i2 * i6)];
          i2 += 1;
          j += 1;
        }
        localByteBuffer.get(arrayOfByte2, 0, i5);
      }
      label384:
      com.tencent.mm.plugin.mmsight.model.a.j.tEA.k(arrayOfByte2);
      k += 1;
    }
    AppMethodBeat.o(107679);
    return arrayOfByte1;
  }
  
  protected final int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(107677);
    ad.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bt.GC();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i(TAG, "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    ad.i(TAG, "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      ad.i(TAG, "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (oX(m)) {
        if (m <= j)
        {
          k = j;
          if (m != 2135033992) {}
        }
        else
        {
          k = m;
        }
      }
      i += 1;
    }
    ad.i(TAG, "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(107677);
    return j;
  }
  
  public final int aDi()
  {
    return 2;
  }
  
  protected final boolean ajw()
  {
    AppMethodBeat.i(107678);
    if (this.gnF == null)
    {
      ad.e(TAG, "drainDecoder, decoder is null");
      AppMethodBeat.o(107678);
      return true;
    }
    int i = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ad.i(TAG, "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ad.i(TAG, "no output from decoder available, break");
      label70:
      AppMethodBeat.o(107678);
      return false;
    }
    if (i == -3) {
      ad.i(TAG, "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label70;
      if (i == -2)
      {
        this.hBj = this.gnF.getOutputFormat();
        ad.i(TAG, "decoder output format changed: " + this.hBj);
      }
      else if (i < 0)
      {
        ad.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ad.v(TAG, "perform decoding");
        long l = bt.GC();
        byte[] arrayOfByte = b(this.gnF.getOutputImage(i));
        ad.v(TAG, "perform decoding costImage %s", new Object[] { Long.valueOf(bt.aS(l)) });
        if (arrayOfByte == null) {
          break label70;
        }
        if (arrayOfByte.length != 0)
        {
          MediaCodec.BufferInfo localBufferInfo = this.bufferInfo;
          if (arrayOfByte == null) {
            ad.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            this.gnF.releaseOutputBuffer(i, false);
            l = this.bufferInfo.presentationTimeUs;
            if ((this.gnO == 1L) || (l < this.gnO * 1000L)) {
              break;
            }
            ad.e(TAG, "exceed endTimeMs");
            AppMethodBeat.o(107678);
            return true;
            ad.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[] { arrayOfByte, localBufferInfo, Integer.valueOf(localBufferInfo.size) });
            this.hBj = this.gnF.getOutputFormat();
            if (this.tFH != null) {
              this.tFH.br(arrayOfByte);
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            ad.i(TAG, "receive end of stream");
            try
            {
              this.gnF.stop();
              this.gnF.release();
              this.gnF = null;
              AppMethodBeat.o(107678);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.e(TAG, "stop and release decoder error: %s", new Object[] { localException.getMessage() });
              }
            }
          }
          AppMethodBeat.o(107678);
          return false;
        }
        this.gnF.releaseOutputBuffer(i, false);
      }
    }
  }
  
  protected final boolean oX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.j
 * JD-Core Version:    0.7.0.1
 */