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
    AppMethodBeat.i(189050);
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
      AppMethodBeat.o(189050);
      return;
    }
    catch (Exception paramString)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "init: " + Log.getStackTraceString(paramString));
      AppMethodBeat.o(189050);
    }
  }
  
  private String generateOpaqueKey(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189057);
    String str = "opaque_" + paramLong1 + "time_" + paramLong2;
    AppMethodBeat.o(189057);
    return str;
  }
  
  private TPImageGeneratorParams getParameters()
  {
    AppMethodBeat.i(189056);
    TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
    localTPImageGeneratorParams.format = 37;
    localTPImageGeneratorParams.width = this.mWidth;
    localTPImageGeneratorParams.height = this.mHeight;
    localTPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
    localTPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
    AppMethodBeat.o(189056);
    return localTPImageGeneratorParams;
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    AppMethodBeat.i(189053);
    this.mOpaque += 1L;
    this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, paramLong), paramTPVideoCaptureCallBack);
    try
    {
      this.mTpImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, getParameters());
      AppMethodBeat.o(189053);
      return;
    }
    catch (Exception paramTPVideoCaptureCallBack)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPVideoCaptureCallBack));
      AppMethodBeat.o(189053);
    }
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, TPVideoCaptureCallBack paramTPVideoCaptureCallBack)
  {
    AppMethodBeat.i(189054);
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
      AppMethodBeat.o(189054);
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      g.e("TPThumbPlayer[TPVideoCapture.java]", "generateImagesAsyncForTimes: " + Log.getStackTraceString(paramArrayOfLong));
      AppMethodBeat.o(189054);
    }
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(189058);
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
      AppMethodBeat.o(189058);
      return;
      label100:
      Bitmap[] arrayOfBitmap = new Bitmap[paramTPVideoFrame.data.length];
      paramInt = 0;
      while (paramInt < paramTPVideoFrame.data.length)
      {
        arrayOfBitmap[paramInt] = a.k(paramTPVideoFrame.data[paramInt], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
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
    AppMethodBeat.i(189055);
    try
    {
      this.mTpImageGenerator.cancelAllImageGenerations();
      this.mTpImageGenerator.unInit();
      this.mCallBackMap.clear();
      this.mTpImageGenerator = null;
      AppMethodBeat.o(189055);
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
    AppMethodBeat.i(189051);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Size is illegal");
      AppMethodBeat.o(189051);
      throw localIllegalArgumentException;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    AppMethodBeat.o(189051);
  }
  
  public void setTimeMsTolerance(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189052);
    if (paramLong1 > paramLong2)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Tolerance is illegal");
      AppMethodBeat.o(189052);
      throw localIllegalArgumentException;
    }
    this.mRequestedTimeMsToleranceBefore = paramLong1;
    this.mRequestedTimeMsToleranceAfter = paramLong2;
    AppMethodBeat.o(189052);
  }
  
  public static abstract interface TPVideoCaptureCallBack
  {
    public abstract void onCaptureError(int paramInt);
    
    public abstract void onCaptureSuccess(Bitmap[] paramArrayOfBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoCapture
 * JD-Core Version:    0.7.0.1
 */