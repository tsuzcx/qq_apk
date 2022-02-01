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
  private TPImageGenerator ahGt;
  private Map<Long, TPCaptureCallBack> mCallBackMap;
  private long mOpaque;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(227304);
    this.mOpaque = 0L;
    this.ahGt = new TPImageGenerator(paramInt, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.ahGt.init();
      AppMethodBeat.o(227304);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(localException));
      AppMethodBeat.o(227304);
    }
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(227291);
    this.mOpaque = 0L;
    this.ahGt = new TPImageGenerator(paramString, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.ahGt.init();
      AppMethodBeat.o(227291);
      return;
    }
    catch (Exception paramString)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(paramString));
      AppMethodBeat.o(227291);
    }
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(227314);
    this.mOpaque += 1L;
    this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPCaptureCallBack);
    try
    {
      this.ahGt.generateImageAsyncAtTime(paramLong, this.mOpaque, paramTPImageGeneratorParams);
      AppMethodBeat.o(227314);
      return;
    }
    catch (Exception paramTPImageGeneratorParams)
    {
      g.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPImageGeneratorParams));
      AppMethodBeat.o(227314);
    }
  }
  
  public final void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(227340);
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
      AppMethodBeat.o(227340);
      return;
      label101:
      paramTPVideoFrame = a.l(paramTPVideoFrame.data[0], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
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
    AppMethodBeat.i(227325);
    try
    {
      this.ahGt.cancelAllImageGenerations();
      this.ahGt.unInit();
      this.mCallBackMap.clear();
      this.ahGt = null;
      AppMethodBeat.o(227325);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.b.d
 * JD-Core Version:    0.7.0.1
 */