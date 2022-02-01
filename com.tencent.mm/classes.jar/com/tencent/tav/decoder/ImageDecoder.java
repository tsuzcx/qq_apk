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
import com.tencent.tav.coremedia.CMSampleState;
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
    AppMethodBeat.i(218227);
    IMAGE_DECODE_SIZE = new CGSize(720.0F, 1280.0F);
    AppMethodBeat.o(218227);
  }
  
  public ImageDecoder()
  {
    AppMethodBeat.i(218214);
    this.preferRotation = 0;
    this.currentDecoderTime = CMTime.CMTimeInvalid;
    this.frameDuration = new CMTime(1L, 30);
    this.threadId = -1L;
    AppMethodBeat.o(218214);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(218220);
    if ((this.threadId != -1L) && (this.threadId != Thread.currentThread().getId())) {
      Logger.e("ImageDecoder", "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
    }
    AppMethodBeat.o(218220);
  }
  
  private TextureInfo createTexture()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(218224);
        Object localObject1;
        if ((this.textureInfo != null) && (!this.textureInfo.isReleased()))
        {
          localObject1 = this.textureInfo;
          AppMethodBeat.o(218224);
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
          AppMethodBeat.o(218224);
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
      AppMethodBeat.o(218224);
    }
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    int i = 1;
    AppMethodBeat.i(218222);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    paramString = BitmapFactory.decodeFile(paramString, localOptions2);
    AppMethodBeat.o(218222);
    return paramString;
  }
  
  public static CGSize getDefaultOutputImageSize(String paramString)
  {
    AppMethodBeat.i(218223);
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
      AppMethodBeat.o(218223);
      return paramString;
    }
    paramString = new CGSize(i, j);
    AppMethodBeat.o(218223);
    return paramString;
  }
  
  private Matrix getImageTextureMatrix()
  {
    AppMethodBeat.i(218225);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    AppMethodBeat.o(218225);
    return localMatrix;
  }
  
  private static int readImagePreferRotation(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(218226);
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
        AppMethodBeat.o(218226);
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
      AppMethodBeat.o(218226);
    }
  }
  
  public long getPreReadCost()
  {
    return 0L;
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
    AppMethodBeat.i(218218);
    paramCMTime = paramCMTime.add(this.frameDuration);
    AppMethodBeat.o(218218);
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
  
  public CMSampleState readSample()
  {
    AppMethodBeat.i(218217);
    CMSampleState localCMSampleState = readSample(this.currentDecoderTime.add(this.frameDuration));
    AppMethodBeat.o(218217);
    return localCMSampleState;
  }
  
  /* Error */
  public CMSampleState readSample(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 252
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 254	com/tencent/tav/decoder/ImageDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   12: invokevirtual 260	com/tencent/tav/coremedia/CMTimeRange:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   15: invokevirtual 264	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   18: ifeq +19 -> 37
    //   21: ldc2_w 68
    //   24: invokestatic 270	com/tencent/tav/coremedia/CMSampleState:fromError	(J)Lcom/tencent/tav/coremedia/CMSampleState;
    //   27: astore_1
    //   28: ldc 252
    //   30: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: invokespecial 272	com/tencent/tav/decoder/ImageDecoder:createTexture	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   41: pop
    //   42: new 266	com/tencent/tav/coremedia/CMSampleState
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 275	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   50: astore_1
    //   51: ldc 252
    //   53: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -23 -> 33
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ImageDecoder
    //   0	64	1	paramCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	33	59	finally
    //   37	56	59	finally
  }
  
  public void release() {}
  
  public void release(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(218221);
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
      AppMethodBeat.o(218221);
      return;
    }
    finally {}
  }
  
  public void seekTo(CMTime paramCMTime) {}
  
  public void seekTo(CMTime paramCMTime, boolean paramBoolean) {}
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218215);
    start(paramCMTimeRange, CMTime.CMTimeZero);
    AppMethodBeat.o(218215);
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    AppMethodBeat.i(218216);
    if (paramCMTimeRange == null)
    {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.frameDuration);
      AppMethodBeat.o(218216);
      return;
    }
    this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
    AppMethodBeat.o(218216);
  }
  
  public void switchFrame() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.ImageDecoder
 * JD-Core Version:    0.7.0.1
 */