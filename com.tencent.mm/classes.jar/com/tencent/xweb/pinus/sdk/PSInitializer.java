package com.tencent.xweb.pinus.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import org.xwalk.core.XWalkEnvironment;

public class PSInitializer
{
  private static final String TAG = "PSInitializer";
  private final Context mContext;
  private final PinusInitListener mInitListener;
  private boolean mIsCoreReady;
  
  public PSInitializer(Context paramContext, PinusInitListener paramPinusInitListener)
  {
    this.mContext = paramContext;
    this.mInitListener = paramPinusInitListener;
  }
  
  public boolean init()
  {
    AppMethodBeat.i(213416);
    if (this.mInitListener != null) {
      this.mInitListener.onPinusInitStarted();
    }
    l.y(1749L, 71L, 1L);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.getAvailableVersion() == -1) {
        XWalkEnvironment.addXWalkInitializeLog("PSInitializer", "init, no available version, need download");
      }
      for (;;)
      {
        if (this.mInitListener != null) {
          this.mInitListener.onPinusInitCancelled();
        }
        l.y(1749L, 73L, 1L);
        AppMethodBeat.o(213416);
        return false;
        XWalkEnvironment.addXWalkInitializeLog("PSInitializer", "init, sdk not support this apk, need update new");
      }
    }
    int i = XWalkEnvironment.getAvailableVersion();
    boolean bool = PSCoreWrapper.attachPinusCore(i);
    XWalkEnvironment.addXWalkInitializeLog("PSInitializer", "init, attach core result:".concat(String.valueOf(bool)));
    if (bool)
    {
      this.mIsCoreReady = true;
      PSCoreWrapper.dockPinusCore(i);
      if (this.mInitListener != null) {
        this.mInitListener.onPinusInitCompleted();
      }
      l.y(1749L, 74L, 1L);
      AppMethodBeat.o(213416);
      return true;
    }
    if (this.mInitListener != null) {
      this.mInitListener.onPinusInitFailed();
    }
    l.y(1749L, 72L, 1L);
    AppMethodBeat.o(213416);
    return false;
  }
  
  public boolean isCoreReady()
  {
    return this.mIsCoreReady;
  }
  
  public static abstract interface PinusInitListener
  {
    public abstract void onPinusInitCancelled();
    
    public abstract void onPinusInitCompleted();
    
    public abstract void onPinusInitFailed();
    
    public abstract void onPinusInitStarted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.PSInitializer
 * JD-Core Version:    0.7.0.1
 */