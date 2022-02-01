package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;
import java.util.Map;

public class TPVideoCapture
  implements ITPImageGeneratorCallback
{
  private static final String TAG = "TPThumbPlayer[TPVideoCapture.java]";
  private Map<String, TPVideoCaptureCallBack> mCallBackMap;
  private int mHeight;
  private long mOpaque;
  private long mRequestedTimeMsToleranceAfter;
  private long mRequestedTimeMsToleranceBefore;
  private TPImageGenerator mTpImageGenerator;
  private int mWidth;
  
  public TPVideoCapture(String paramString)
  {
    AppMethodBeat.i(219918);
    this.mWidth = 0;
    this.mHeight = 0;
    this.mRequestedTimeMsToleranceBefore = 0L;
    this.mRequestedTimeMsToleranceAfter = 0L;
    this.mOpaque = 0L;
    this.mTpImageGenerator = new TPImageGenerator(paramString, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.mTpImageGenerator.init();
      AppMethodBeat.o(219918);
      return;
    }
    catch (Exception paramString)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "init: " + Log.getStackTraceString(paramString));
      AppMethodBeat.o(219918);
    }
  }
  
  private String generateOpaqueKey(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219931);
    String str = "opaque_" + paramLong1 + "time_" + paramLong2;
    AppMethodBeat.o(219931);
    return str;
  }
  
  private TPImageGeneratorParams getParameters()
  {
    AppMethodBeat.i(219928);
    TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
    localTPImageGeneratorParams.format = 37;
    localTPImageGeneratorParams.width = this.mWidth;
    localTPImageGeneratorParams.height = this.mHeight;
    localTPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
    localTPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
    AppMethodBeat.o(219928);
    return localTPImageGeneratorParams;
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    AppMethodBeat.i(219923);
    this.mOpaque += 1L;
    this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, paramLong), paramTPVideoCaptureCallBack);
    try
    {
      this.mTpImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, getParameters());
      AppMethodBeat.o(219923);
      return;
    }
    catch (Exception paramTPVideoCaptureCallBack)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPVideoCaptureCallBack));
      AppMethodBeat.o(219923);
    }
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    AppMethodBeat.i(219925);
    this.mOpaque += 1L;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, l), paramTPVideoCaptureCallBack);
      i += 1;
    }
    try
    {
      this.mTpImageGenerator.generateImagesAsyncForTimes(paramArrayOfLong, this.mOpaque, getParameters());
      AppMethodBeat.o(219925);
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "generateImagesAsyncForTimes: " + Log.getStackTraceString(paramArrayOfLong));
      AppMethodBeat.o(219925);
    }
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(219933);
    TPVideoCaptureCallBack localTPVideoCaptureCallBack = (TPVideoCaptureCallBack)this.mCallBackMap.get(generateOpaqueKey(paramLong3, paramLong1));
    if (localTPVideoCaptureCallBack != null)
    {
      if ((paramInt != 0) || (paramTPVideoFrame == null)) {
        break label166;
      }
      if ((paramTPVideoFrame.data.length > 0) && (paramTPVideoFrame.height != 0) && (paramTPVideoFrame.width != 0)) {
        break label100;
      }
      paramTPVideoFrame = null;
      localTPVideoCaptureCallBack.onCaptureSuccess(paramTPVideoFrame);
    }
    for (;;)
    {
      this.mCallBackMap.remove(generateOpaqueKey(paramLong3, paramLong1));
      AppMethodBeat.o(219933);
      return;
      label100:
      Bitmap[] arrayOfBitmap = new Bitmap[paramTPVideoFrame.data.length];
      paramInt = 0;
      while (paramInt < paramTPVideoFrame.data.length)
      {
        arrayOfBitmap[paramInt] = a.l(paramTPVideoFrame.data[paramInt], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
        paramInt += 1;
      }
      paramTPVideoFrame = arrayOfBitmap;
      break;
      label166:
      localTPVideoCaptureCallBack.onCaptureError(paramInt);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(219927);
    try
    {
      this.mTpImageGenerator.cancelAllImageGenerations();
      this.mTpImageGenerator.unInit();
      this.mCallBackMap.clear();
      this.mTpImageGenerator = null;
      AppMethodBeat.o(219927);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPVideoCapture.java]", "release: " + Log.getStackTraceString(localException));
      }
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219919);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Size is illegal");
      AppMethodBeat.o(219919);
      throw localIllegalArgumentException;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    AppMethodBeat.o(219919);
  }
  
  public void setTimeMsTolerance(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219921);
    if (paramLong1 > paramLong2)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tolerance is illegal");
      AppMethodBeat.o(219921);
      throw localIllegalArgumentException;
    }
    this.mRequestedTimeMsToleranceBefore = paramLong1;
    this.mRequestedTimeMsToleranceAfter = paramLong2;
    AppMethodBeat.o(219921);
  }
  
  public static abstract interface TPVideoCaptureCallBack
  {
    public abstract void onCaptureError(int paramInt);
    
    public abstract void onCaptureSuccess(Bitmap[] paramArrayOfBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture
 * JD-Core Version:    0.7.0.1
 */