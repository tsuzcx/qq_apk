package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j
  extends i
{
  public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";
  
  public j(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, int paramInt)
  {
    super(paramMediaExtractor, paramMediaFormat, paramInt);
    AppMethodBeat.i(3674);
    ab.i(TAG, "init ");
    AppMethodBeat.o(3674);
  }
  
  private static byte[] a(Image paramImage)
  {
    AppMethodBeat.i(3677);
    int j = paramImage.getFormat();
    int i3 = paramImage.getWidth();
    int i4 = paramImage.getHeight();
    int i = 0;
    paramImage = paramImage.getPlanes();
    int k = i3 * i4 * ImageFormat.getBitsPerPixel(j) / 8;
    ab.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[] { Integer.valueOf(paramImage.length), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(j) });
    byte[] arrayOfByte1 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(k));
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
          break label298;
        }
      }
      byte[] arrayOfByte2;
      int i1;
      label298:
      for (int n = i4;; n = i4 / 2)
      {
        ab.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[] { Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i6) });
        arrayOfByte2 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(i5));
        i1 = 0;
        for (;;)
        {
          if (i1 >= n) {
            break label385;
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
      label385:
      com.tencent.mm.plugin.mmsight.model.a.j.oJp.O(arrayOfByte2);
      k += 1;
    }
    AppMethodBeat.o(3677);
    return arrayOfByte1;
  }
  
  protected final boolean UE()
  {
    AppMethodBeat.i(3676);
    if (this.eRD == null)
    {
      ab.e(TAG, "drainDecoder, decoder is null");
      AppMethodBeat.o(3676);
      return true;
    }
    int i = this.eRD.dequeueOutputBuffer(this.eRL, 60000L);
    ab.i(TAG, "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ab.i(TAG, "no output from decoder available, break");
      label72:
      AppMethodBeat.o(3676);
      return false;
    }
    if (i == -3) {
      ab.i(TAG, "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.eRD.dequeueOutputBuffer(this.eRL, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label72;
      if (i == -2)
      {
        this.fYw = this.eRD.getOutputFormat();
        ab.i(TAG, "decoder output format changed: " + this.fYw);
      }
      else if (i < 0)
      {
        ab.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ab.v(TAG, "perform decoding");
        long l = bo.yB();
        byte[] arrayOfByte = a(this.eRD.getOutputImage(i));
        ab.v(TAG, "perform decoding costImage %s", new Object[] { Long.valueOf(bo.av(l)) });
        if (arrayOfByte == null) {
          break label72;
        }
        if (arrayOfByte.length != 0)
        {
          MediaCodec.BufferInfo localBufferInfo = this.eRL;
          if (arrayOfByte == null) {
            ab.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            this.eRD.releaseOutputBuffer(i, false);
            l = this.eRL.presentationTimeUs;
            if ((this.eRN == 1L) || (l < this.eRN * 1000L)) {
              break;
            }
            ab.e(TAG, "exceed endTimeMs");
            AppMethodBeat.o(3676);
            return true;
            ab.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[] { arrayOfByte, localBufferInfo, Integer.valueOf(localBufferInfo.size) });
            this.fYw = this.eRD.getOutputFormat();
            if (this.oKw != null) {
              this.oKw.bb(arrayOfByte);
            }
          }
          if ((this.eRL.flags & 0x4) != 0)
          {
            ab.i(TAG, "receive end of stream");
            try
            {
              this.eRD.stop();
              this.eRD.release();
              this.eRD = null;
              AppMethodBeat.o(3676);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.e(TAG, "stop and release decoder error: %s", new Object[] { localException.getMessage() });
              }
            }
          }
          AppMethodBeat.o(3676);
          return false;
        }
        this.eRD.releaseOutputBuffer(i, false);
      }
    }
  }
  
  protected final int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(3675);
    ab.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bo.yB();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ab.i(TAG, "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    ab.i(TAG, "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      ab.i(TAG, "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (mo(m)) {
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
    ab.i(TAG, "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(3675);
    return j;
  }
  
  public final int amd()
  {
    return 2;
  }
  
  protected final boolean mo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.j
 * JD-Core Version:    0.7.0.1
 */