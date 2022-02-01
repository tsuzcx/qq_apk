package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageDecoder
  implements IVideoDecoder
{
  public static final CGSize IMAGE_DECODE_SIZE;
  private static final String TAG = "ImageDecoder";
  private Bitmap bitmap;
  private CMTime currentDecoderTime;
  private CGSize displaySize;
  private CMTime frameDuration;
  private int preferRotation;
  private String sourceImagePath;
  private TextureInfo textureInfo;
  private long threadId;
  private CMTimeRange timeRange;
  
  static
  {
    AppMethodBeat.i(201805);
    IMAGE_DECODE_SIZE = new CGSize(720.0F, 1280.0F);
    AppMethodBeat.o(201805);
  }
  
  public ImageDecoder()
  {
    AppMethodBeat.i(201792);
    this.preferRotation = 0;
    this.currentDecoderTime = CMTime.CMTimeInvalid;
    this.frameDuration = new CMTime(1L, 30);
    this.threadId = -1L;
    AppMethodBeat.o(201792);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(201798);
    if (this.threadId != Thread.currentThread().getId()) {
      Logger.e("ImageDecoder", "Thread wrong!! ", new RuntimeException());
    }
    AppMethodBeat.o(201798);
  }
  
  private TextureInfo createTexture()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201802);
        Object localObject1;
        if ((this.textureInfo != null) && (!this.textureInfo.isReleased()))
        {
          localObject1 = this.textureInfo;
          AppMethodBeat.o(201802);
          return localObject1;
        }
        if (this.bitmap == null)
        {
          this.bitmap = decodeBitmap(this.sourceImagePath, this.displaySize);
          this.preferRotation = readImagePreferRotation(this.sourceImagePath);
        }
        if (this.bitmap != null)
        {
          this.threadId = Thread.currentThread().getId();
          localObject1 = getImageTextureMatrix();
          this.textureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), (Matrix)localObject1, this.preferRotation);
          GLES20.glBindTexture(3553, this.textureInfo.textureID);
          GLUtils.texImage2D(3553, 0, this.bitmap, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.textureInfo;
          AppMethodBeat.o(201802);
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
      AppMethodBeat.o(201802);
    }
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    int i = 1;
    AppMethodBeat.i(201800);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    paramString = BitmapFactory.decodeFile(paramString, localOptions2);
    AppMethodBeat.o(201800);
    return paramString;
  }
  
  public static CGSize getDefaultOutputImageSize(String paramString)
  {
    AppMethodBeat.i(201801);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inSampleSize = ((int)(localOptions1.outWidth / IMAGE_DECODE_SIZE.width));
    localOptions2.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions2);
    int i = localOptions2.outWidth;
    int j = localOptions2.outHeight;
    if (readImagePreferRotation(paramString) % 2 == 1)
    {
      paramString = new CGSize(j, i);
      AppMethodBeat.o(201801);
      return paramString;
    }
    paramString = new CGSize(i, j);
    AppMethodBeat.o(201801);
    return paramString;
  }
  
  private Matrix getImageTextureMatrix()
  {
    AppMethodBeat.i(201803);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    AppMethodBeat.o(201803);
    return localMatrix;
  }
  
  private static int readImagePreferRotation(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(201804);
    try
    {
      int j = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (j)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(201804);
        return i;
        i = 3;
        continue;
        i = 2;
      }
      return 0;
    }
    catch (IOException paramString)
    {
      Logger.e("ImageDecoder", "readImagePreferRotation", paramString);
      AppMethodBeat.o(201804);
    }
  }
  
  public String getSourcePath()
  {
    return this.sourceImagePath;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public boolean hasTrack()
  {
    return this.sourceImagePath != null;
  }
  
  public void init(String paramString, CGSize paramCGSize, IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    this.sourceImagePath = paramString;
    this.displaySize = paramCGSize;
  }
  
  public boolean isLastFrameValid()
  {
    return true;
  }
  
  public CMTime nextFrameTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(201796);
    paramCMTime = paramCMTime.add(this.frameDuration);
    AppMethodBeat.o(201796);
    return paramCMTime;
  }
  
  public ByteBuffer outputBuffer()
  {
    return null;
  }
  
  public Surface outputSurface()
  {
    return null;
  }
  
  public CMTime readSample()
  {
    AppMethodBeat.i(201795);
    CMTime localCMTime = readSample(this.currentDecoderTime.add(this.frameDuration));
    AppMethodBeat.o(201795);
    return localCMTime;
  }
  
  /* Error */
  public CMTime readSample(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 234	com/tencent/tav/decoder/ImageDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   12: invokevirtual 239	com/tencent/tav/coremedia/CMTimeRange:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   15: invokevirtual 243	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   18: ifeq +16 -> 34
    //   21: getstatic 248	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   24: astore_1
    //   25: ldc 232
    //   27: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: invokespecial 250	com/tencent/tav/decoder/ImageDecoder:createTexture	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   38: pop
    //   39: ldc 232
    //   41: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -14 -> 30
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ImageDecoder
    //   0	52	1	paramCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	30	47	finally
    //   34	44	47	finally
  }
  
  public void release() {}
  
  public void release(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(201799);
      checkThread();
      if (this.textureInfo != null)
      {
        this.textureInfo.release();
        this.textureInfo = null;
      }
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        this.bitmap.recycle();
        this.bitmap = null;
      }
      AppMethodBeat.o(201799);
      return;
    }
    finally {}
  }
  
  public void seekTo(CMTime paramCMTime) {}
  
  public void seekTo(CMTime paramCMTime, boolean paramBoolean) {}
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201793);
    start(paramCMTimeRange, CMTime.CMTimeZero);
    AppMethodBeat.o(201793);
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    AppMethodBeat.i(201794);
    if (paramCMTimeRange == null)
    {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.frameDuration);
      AppMethodBeat.o(201794);
      return;
    }
    this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
    AppMethodBeat.o(201794);
  }
  
  public void switchFrame() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.ImageDecoder
 * JD-Core Version:    0.7.0.1
 */