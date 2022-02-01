package org.xwalk.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;

public class XWalkInitializer
{
  private static final String TAG = "XWalkInitializer";
  private final Context mContext;
  private final XWalkInitListener mInitListener;
  private boolean mIsCoreReady;
  
  public XWalkInitializer(Context paramContext, XWalkInitListener paramXWalkInitListener)
  {
    this.mContext = paramContext;
    this.mInitListener = paramXWalkInitListener;
  }
  
  public boolean init()
  {
    AppMethodBeat.i(187717);
    if (this.mInitListener != null) {
      this.mInitListener.onXWalkInitStarted();
    }
    l.y(1749L, 67L, 1L);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.getAvailableVersion() == -1) {
        XWalkEnvironment.addXWalkInitializeLog("XWalkInitializer", "init, no available version, need download");
      }
      for (;;)
      {
        if (this.mInitListener != null) {
          this.mInitListener.onXWalkInitCancelled();
        }
        l.y(1749L, 69L, 1L);
        AppMethodBeat.o(187717);
        return false;
        XWalkEnvironment.addXWalkInitializeLog("XWalkInitializer", "init, sdk not support this apk, need update new");
      }
    }
    XWalkReflectionInitHandler.handlePreInit(this.mContext);
    int i = XWalkEnvironment.getAvailableVersion();
    boolean bool = XWalkCoreWrapper.attachXWalkCore(i);
    XWalkEnvironment.addXWalkInitializeLog("XWalkInitializer", "init, attach core result:".concat(String.valueOf(bool)));
    if (bool)
    {
      this.mIsCoreReady = true;
      XWalkCoreWrapper.dockXWalkCore(i);
      XWalkReflectionInitHandler.handlePostInit(this.mContext);
      if (this.mInitListener != null) {
        this.mInitListener.onXWalkInitCompleted();
      }
      l.y(1749L, 70L, 1L);
      AppMethodBeat.o(187717);
      return true;
    }
    if (this.mInitListener != null) {
      this.mInitListener.onXWalkInitFailed();
    }
    l.y(1749L, 68L, 1L);
    AppMethodBeat.o(187717);
    return false;
  }
  
  public boolean isCoreReady()
  {
    return this.mIsCoreReady;
  }
  
  public static abstract interface XWalkInitListener
  {
    public abstract void onXWalkInitCancelled();
    
    public abstract void onXWalkInitCompleted();
    
    public abstract void onXWalkInitFailed();
    
    public abstract void onXWalkInitStarted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer
 * JD-Core Version:    0.7.0.1
 */