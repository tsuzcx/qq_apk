package com.tencent.xweb.pinus.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class PSInitializerWrapper
{
  private static final String TAG = "PSInitializerWrapper";
  private boolean mHasInited = false;
  private PSInitializer mPinusInitializer;
  
  public static PSInitializerWrapper getInstance()
  {
    AppMethodBeat.i(213483);
    PSInitializerWrapper localPSInitializerWrapper = SingletonHolder.sInstance;
    AppMethodBeat.o(213483);
    return localPSInitializerWrapper;
  }
  
  private boolean initPinus()
  {
    AppMethodBeat.i(213490);
    Log.i("PSInitializerWrapper", "initPinus, init start");
    if (this.mPinusInitializer.init())
    {
      Log.i("PSInitializerWrapper", "initPinus, init success");
      AppMethodBeat.o(213490);
      return true;
    }
    Log.w("PSInitializerWrapper", "initPinus, init fail");
    AppMethodBeat.o(213490);
    return false;
  }
  
  public void initPinus(Context paramContext)
  {
    AppMethodBeat.i(213518);
    if (this.mHasInited)
    {
      AppMethodBeat.o(213518);
      return;
    }
    this.mHasInited = true;
    this.mPinusInitializer = new PSInitializer(paramContext, new PSInitializer.PinusInitListener()
    {
      public void onPinusInitCancelled()
      {
        AppMethodBeat.i(213367);
        Log.i("PSInitializerWrapper", "onPinusInitCancelled");
        AppMethodBeat.o(213367);
      }
      
      public void onPinusInitCompleted()
      {
        AppMethodBeat.i(213386);
        Log.i("PSInitializerWrapper", "onPinusInitCompleted");
        AppMethodBeat.o(213386);
      }
      
      public void onPinusInitFailed()
      {
        AppMethodBeat.i(213376);
        Log.i("PSInitializerWrapper", "onPinusInitFailed");
        AppMethodBeat.o(213376);
      }
      
      public void onPinusInitStarted()
      {
        AppMethodBeat.i(213357);
        Log.i("PSInitializerWrapper", "onPinusInitStarted");
        AppMethodBeat.o(213357);
      }
    });
    XWalkEnvironment.init(paramContext);
    initPinus();
    AppMethodBeat.o(213518);
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(213507);
    if (!this.mHasInited)
    {
      AppMethodBeat.o(213507);
      return false;
    }
    boolean bool = this.mPinusInitializer.isCoreReady();
    AppMethodBeat.o(213507);
    return bool;
  }
  
  static class SingletonHolder
  {
    private static final PSInitializerWrapper sInstance;
    
    static
    {
      AppMethodBeat.i(213435);
      sInstance = new PSInitializerWrapper(null);
      AppMethodBeat.o(213435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.PSInitializerWrapper
 * JD-Core Version:    0.7.0.1
 */