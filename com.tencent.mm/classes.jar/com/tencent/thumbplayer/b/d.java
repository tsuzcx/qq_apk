package com.tencent.thumbplayer.b;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements com.tencent.thumbplayer.a.a.a, ITPImageGeneratorCallback
{
  private TPImageGenerator RYG;
  private Map<Long, TPCaptureCallBack> mCallBackMap;
  private long mOpaque;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(189099);
    this.mOpaque = 0L;
    this.RYG = new TPImageGenerator(paramInt, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.RYG.init();
      AppMethodBeat.o(189099);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(localException));
      AppMethodBeat.o(189099);
    }
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(189098);
    this.mOpaque = 0L;
    this.RYG = new TPImageGenerator(paramString, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.RYG.init();
      AppMethodBeat.o(189098);
      return;
    }
    catch (Exception paramString)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(paramString));
      AppMethodBeat.o(189098);
    }
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(189100);
    this.mOpaque += 1L;
    this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPCaptureCallBack);
    try
    {
      this.RYG.generateImageAsyncAtTime(paramLong, this.mOpaque, paramTPImageGeneratorParams);
      AppMethodBeat.o(189100);
      return;
    }
    catch (Exception paramTPImageGeneratorParams)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPImageGeneratorParams));
      AppMethodBeat.o(189100);
    }
  }
  
  public final void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(189102);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Long.valueOf(paramLong3));
    if (localTPCaptureCallBack != null)
    {
      if ((paramInt != 0) || (paramTPVideoFrame == null)) {
        break label143;
      }
      if ((paramTPVideoFrame.data.length > 0) && (paramTPVideoFrame.height != 0) && (paramTPVideoFrame.width != 0)) {
        break label101;
      }
      paramTPVideoFrame = null;
      if (paramTPVideoFrame == null) {
        break label131;
      }
      localTPCaptureCallBack.onCaptureVideoSuccess(paramTPVideoFrame);
    }
    for (;;)
    {
      this.mCallBackMap.remove(Long.valueOf(paramLong3));
      AppMethodBeat.o(189102);
      return;
      label101:
      paramTPVideoFrame = a.k(paramTPVideoFrame.data[0], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
      break;
      label131:
      localTPCaptureCallBack.onCaptureVideoFailed(1000001);
      continue;
      label143:
      localTPCaptureCallBack.onCaptureVideoFailed(paramInt);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(189101);
    try
    {
      this.RYG.cancelAllImageGenerations();
      this.RYG.unInit();
      this.mCallBackMap.clear();
      this.RYG = null;
      AppMethodBeat.o(189101);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPThumbCapture.java]", "release: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.d
 * JD-Core Version:    0.7.0.1
 */