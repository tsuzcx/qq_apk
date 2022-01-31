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
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j
  extends i
{
  public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";
  
  public j(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, int paramInt)
  {
    super(paramMediaExtractor, paramMediaFormat, paramInt);
    y.i(TAG, "init ");
  }
  
  private static byte[] a(Image paramImage)
  {
    int j = paramImage.getFormat();
    int i3 = paramImage.getWidth();
    int i4 = paramImage.getHeight();
    int i = 0;
    paramImage = paramImage.getPlanes();
    int k = i3 * i4 * ImageFormat.getBitsPerPixel(j) / 8;
    y.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[] { Integer.valueOf(paramImage.length), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(j) });
    byte[] arrayOfByte1 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(k));
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
          break label292;
        }
      }
      byte[] arrayOfByte2;
      int i1;
      label292:
      for (int n = i4;; n = i4 / 2)
      {
        y.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[] { Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i6) });
        arrayOfByte2 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(i5));
        i1 = 0;
        for (;;)
        {
          if (i1 >= n) {
            break label379;
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
      label379:
      com.tencent.mm.plugin.mmsight.model.a.j.mji.z(arrayOfByte2);
      k += 1;
    }
    return arrayOfByte1;
  }
  
  public final int SQ()
  {
    return 2;
  }
  
  protected final boolean ST()
  {
    if (this.eIT == null)
    {
      y.e(TAG, "drainDecoder, decoder is null");
      return true;
    }
    int i = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
    y.i(TAG, "outputBufferIndex-->" + i);
    if (i == -1)
    {
      y.i(TAG, "no output from decoder available, break");
      label67:
      return false;
    }
    if (i == -3) {
      y.i(TAG, "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.eIT.dequeueOutputBuffer(this.eIJ, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label67;
      if (i == -2)
      {
        this.eIS = this.eIT.getOutputFormat();
        y.i(TAG, "decoder output format changed: " + this.eIS);
      }
      else if (i < 0)
      {
        y.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + i);
      }
      else
      {
        y.v(TAG, "perform decoding");
        long l = bk.UZ();
        byte[] arrayOfByte = a(this.eIT.getOutputImage(i));
        y.v(TAG, "perform decoding costImage %s", new Object[] { Long.valueOf(bk.cp(l)) });
        if (arrayOfByte == null) {
          break label67;
        }
        if (arrayOfByte.length != 0)
        {
          MediaCodec.BufferInfo localBufferInfo = this.eIJ;
          if (arrayOfByte == null) {
            y.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            this.eIT.releaseOutputBuffer(i, false);
            l = this.eIJ.presentationTimeUs;
            if ((this.eIR == 1L) || (l < this.eIR * 1000L)) {
              break;
            }
            y.e(TAG, "exceed endTimeMs");
            return true;
            y.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[] { arrayOfByte, localBufferInfo, Integer.valueOf(localBufferInfo.size) });
            this.eIS = this.eIT.getOutputFormat();
            if (this.mlq != null) {
              this.mlq.aD(arrayOfByte);
            }
          }
          if ((this.eIJ.flags & 0x4) != 0)
          {
            y.i(TAG, "receive end of stream");
            try
            {
              this.eIT.stop();
              this.eIT.release();
              this.eIT = null;
              return true;
            }
            catch (Exception localException)
            {
              y.e(TAG, "stop and release decoder error: %s", new Object[] { localException.getMessage() });
              return true;
            }
          }
          return false;
        }
        this.eIT.releaseOutputBuffer(i, false);
      }
    }
  }
  
  protected final int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    y.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bk.UZ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    y.i(TAG, "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    y.i(TAG, "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      y.i(TAG, "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (uf(m)) {
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
    y.i(TAG, "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    return j;
  }
  
  protected final boolean uf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.j
 * JD-Core Version:    0.7.0.1
 */