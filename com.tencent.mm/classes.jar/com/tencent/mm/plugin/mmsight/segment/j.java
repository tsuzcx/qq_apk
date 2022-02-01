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
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
    Log.i(TAG, "init ");
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
    Log.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[] { Integer.valueOf(paramImage.length), Integer.valueOf(k), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(j) });
    byte[] arrayOfByte1 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(k));
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
        Log.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[] { Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i6) });
        arrayOfByte2 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(i5));
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
      com.tencent.mm.plugin.mmsight.model.a.j.FbH.as(arrayOfByte2);
      k += 1;
    }
    AppMethodBeat.o(107679);
    return arrayOfByte1;
  }
  
  protected final boolean aUv()
  {
    AppMethodBeat.i(107678);
    if (this.kSN == null)
    {
      Log.e(TAG, "drainDecoder, decoder is null");
      AppMethodBeat.o(107678);
      return true;
    }
    int i = this.kSN.a(this.bufferInfo, 60000L);
    Log.i(TAG, "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      Log.i(TAG, "no output from decoder available, break");
      label70:
      AppMethodBeat.o(107678);
      return false;
    }
    if (i == -3) {
      Log.i(TAG, "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.kSN.a(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label70;
      if (i == -2)
      {
        this.miU = this.kSN.avi();
        Log.i(TAG, "decoder output format changed: " + this.miU);
      }
      else if (i < 0)
      {
        Log.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        Log.v(TAG, "perform decoding");
        long l = Util.currentTicks();
        byte[] arrayOfByte = b(this.kSN.qQ(i));
        Log.v(TAG, "perform decoding costImage %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        if (arrayOfByte == null) {
          break label70;
        }
        if (arrayOfByte.length != 0)
        {
          MediaCodec.BufferInfo localBufferInfo = this.bufferInfo;
          if (arrayOfByte == null) {
            Log.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            this.kSN.releaseOutputBuffer(i, false);
            l = this.bufferInfo.presentationTimeUs;
            if ((this.endTimeMs == 1L) || (l < this.endTimeMs * 1000L)) {
              break;
            }
            Log.e(TAG, "exceed endTimeMs");
            AppMethodBeat.o(107678);
            return true;
            Log.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[] { arrayOfByte, localBufferInfo, Integer.valueOf(localBufferInfo.size) });
            this.miU = this.kSN.avi();
            if (this.Fdr != null) {
              this.Fdr.bZ(arrayOfByte);
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            Log.i(TAG, "receive end of stream");
            try
            {
              this.kSN.stop();
              this.kSN.release();
              this.kSN = null;
              AppMethodBeat.o(107678);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.e(TAG, "stop and release decoder error: %s", new Object[] { localException.getMessage() });
              }
            }
          }
          AppMethodBeat.o(107678);
          return false;
        }
        this.kSN.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final int brh()
  {
    return 2;
  }
  
  protected final boolean isRecognizedFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  protected final int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(107677);
    Log.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = Util.currentTicks();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    Log.i(TAG, "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    Log.i(TAG, "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int k;
    for (int j = 0; i < paramString.colorFormats.length; j = k)
    {
      int m = paramString.colorFormats[i];
      Log.i(TAG, "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
      k = j;
      if (isRecognizedFormat(m)) {
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
    Log.i(TAG, "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(107677);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.j
 * JD-Core Version:    0.7.0.1
 */