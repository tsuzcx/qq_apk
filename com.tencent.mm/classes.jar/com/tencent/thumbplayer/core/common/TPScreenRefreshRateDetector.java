package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TPScreenRefreshRateDetector
{
  public static final int DISPLAY_CHANGE = 10001;
  private static String TAG;
  private static boolean isInitted;
  private static List<ScreenRefreshRateChangedListener> listeners;
  private static WeakReference<Context> mContext;
  private static float mCurScreenRefreshRate;
  private static DisplayManager.DisplayListener mDisplayListener;
  private static DisplayManager mDisplayManager;
  private static Handler mHandler;
  private static WindowManager mWindowManager;
  
  static
  {
    AppMethodBeat.i(189807);
    TAG = "TPScreenRefreshRateDetector";
    isInitted = false;
    mContext = null;
    mWindowManager = null;
    listeners = new LinkedList();
    mCurScreenRefreshRate = 60.0F;
    mDisplayManager = null;
    mDisplayListener = new DisplayManager.DisplayListener()
    {
      public final void onDisplayAdded(int paramAnonymousInt) {}
      
      public final void onDisplayChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(189797);
        if (paramAnonymousInt == 0) {
          TPScreenRefreshRateDetector.mHandler.sendEmptyMessage(10001);
        }
        TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "onDisplayChanged displayId:".concat(String.valueOf(paramAnonymousInt)));
        AppMethodBeat.o(189797);
      }
      
      public final void onDisplayRemoved(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(189807);
  }
  
  public static void addListener(ScreenRefreshRateChangedListener paramScreenRefreshRateChangedListener)
  {
    AppMethodBeat.i(189803);
    try
    {
      listeners.add(paramScreenRefreshRateChangedListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(189803);
    }
  }
  
  public static void deinit()
  {
    AppMethodBeat.i(189802);
    try
    {
      if ((!isInitted) || (mContext == null)) {
        return;
      }
      mContext.clear();
      isInitted = false;
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(189802);
    }
  }
  
  private static Looper getLooper()
  {
    AppMethodBeat.i(189798);
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      AppMethodBeat.o(189798);
      return localLooper;
    }
    localLooper = Looper.getMainLooper();
    AppMethodBeat.o(189798);
    return localLooper;
  }
  
  public static float getScreenRefreshRate()
  {
    AppMethodBeat.i(189805);
    if (Build.VERSION.SDK_INT < 23)
    {
      TPNativeLog.printLog(4, TAG, "Current version can not get screen refresh rate, set default.");
      f = mCurScreenRefreshRate;
      AppMethodBeat.o(189805);
      return f;
    }
    if (mContext == null)
    {
      TPNativeLog.printLog(4, TAG, "Current mContext is null, set default.");
      f = mCurScreenRefreshRate;
      AppMethodBeat.o(189805);
      return f;
    }
    Object localObject1 = (Context)mContext.get();
    if (localObject1 != null)
    {
      if (mWindowManager == null) {
        mWindowManager = (WindowManager)((Context)localObject1).getSystemService("window");
      }
      if (mDisplayManager == null)
      {
        localObject1 = (DisplayManager)((Context)localObject1).getSystemService("display");
        mDisplayManager = (DisplayManager)localObject1;
        ((DisplayManager)localObject1).registerDisplayListener(mDisplayListener, mHandler);
      }
      if (mWindowManager != null)
      {
        Object localObject2 = mWindowManager.getDefaultDisplay();
        localObject1 = ((Display)localObject2).getSupportedModes();
        localObject2 = ((Display)localObject2).getMode();
        TPNativeLog.printLog(2, TAG, "getMode width:" + ((Display.Mode)localObject2).getPhysicalWidth() + " height:" + ((Display.Mode)localObject2).getPhysicalHeight() + " refreshRate:" + ((Display.Mode)localObject2).getRefreshRate() + " ModeId:" + ((Display.Mode)localObject2).getModeId());
        TPNativeLog.printLog(2, TAG, "getSupportedModes length:" + localObject1.length);
        int i = 0;
        while (i < localObject1.length)
        {
          TPNativeLog.printLog(2, TAG, "getSupportedModes width:" + localObject1[i].getPhysicalWidth() + " height:" + localObject1[i].getPhysicalHeight() + " refreshRate:" + localObject1[i].getRefreshRate() + " ModeId:" + localObject1[i].getModeId());
          i += 1;
        }
        mCurScreenRefreshRate = ((Display.Mode)localObject2).getRefreshRate();
      }
    }
    float f = mCurScreenRefreshRate;
    AppMethodBeat.o(189805);
    return f;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(189801);
    try
    {
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
      if (isInitted) {
        return;
      }
      mContext = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      initHandleMsg();
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(189801);
    }
  }
  
  public static void initHandleMsg()
  {
    AppMethodBeat.i(189800);
    mHandler = new Handler(getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(189796);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(189796);
          return;
          if (TPScreenRefreshRateDetector.mDisplayManager != null)
          {
            Display localDisplay = TPScreenRefreshRateDetector.mDisplayManager.getDisplay(0);
            String str = localDisplay.getMode().toString();
            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "handleMessage DISPLAY_CHANGE, mode:" + str.toString());
            TPScreenRefreshRateDetector.access$200(localDisplay.getMode().getRefreshRate());
          }
        }
      }
    };
    AppMethodBeat.o(189800);
  }
  
  private static void notifyScreenRefreshRateChange(float paramFloat)
  {
    AppMethodBeat.i(189799);
    int i = 0;
    if (Math.abs(paramFloat - mCurScreenRefreshRate) >= 1.0F)
    {
      TPNativeLog.printLog(2, TAG, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + paramFloat);
      i = 1;
    }
    if (i == 0)
    {
      AppMethodBeat.o(189799);
      return;
    }
    mCurScreenRefreshRate = paramFloat;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((ScreenRefreshRateChangedListener)localIterator.next()).onScreenRefreshRateChanged(paramFloat);
      }
    }
    finally
    {
      AppMethodBeat.o(189799);
    }
    AppMethodBeat.o(189799);
  }
  
  public static void removeListener(ScreenRefreshRateChangedListener paramScreenRefreshRateChangedListener)
  {
    AppMethodBeat.i(189804);
    try
    {
      listeners.remove(paramScreenRefreshRateChangedListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(189804);
    }
  }
  
  static abstract interface ScreenRefreshRateChangedListener
  {
    public abstract void onScreenRefreshRateChanged(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector
 * JD-Core Version:    0.7.0.1
 */