package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkInitializer
{
  private static final String TAG = "XWalkLib";
  private Context mContext;
  private XWalkInitListener mInitListener;
  private boolean mIsXWalkReady;
  
  public XWalkInitializer(XWalkInitListener paramXWalkInitListener, Context paramContext)
  {
    AppMethodBeat.i(154753);
    this.mInitListener = paramXWalkInitListener;
    this.mContext = paramContext;
    XWalkLibraryLoader.prepareToInit(this.mContext);
    AppMethodBeat.o(154753);
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    AppMethodBeat.i(154756);
    XWalkEnvironment.addXWalkInitializeLog(paramString);
    AppMethodBeat.o(154756);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154755);
    XWalkEnvironment.addXWalkInitializeLog(paramString1, paramString2);
    AppMethodBeat.o(154755);
  }
  
  public static String getXWalkInitializeLog()
  {
    AppMethodBeat.i(154757);
    Object localObject = XWalkEnvironment.getSharedPreferencesForLog();
    if (localObject == null)
    {
      AppMethodBeat.o(154757);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("log", "");
    AppMethodBeat.o(154757);
    return localObject;
  }
  
  public boolean initAsync_remove()
  {
    AppMethodBeat.i(154754);
    if (this.mIsXWalkReady)
    {
      AppMethodBeat.o(154754);
      return false;
    }
    if ((XWalkLibraryLoader.isInitializing()) || (XWalkLibraryLoader.isDownloading()))
    {
      Log.i("XWalkLib", "Other initialization or download is proceeding");
      AppMethodBeat.o(154754);
      return false;
    }
    Log.i("XWalkLib", "Initialized by XWalkInitializer");
    this.mInitListener.onXWalkInitStarted();
    AppMethodBeat.o(154754);
    return true;
  }
  
  public boolean isDownloadMode()
  {
    AppMethodBeat.i(154760);
    if ((this.mIsXWalkReady) && (XWalkEnvironment.isDownloadMode()))
    {
      AppMethodBeat.o(154760);
      return true;
    }
    AppMethodBeat.o(154760);
    return false;
  }
  
  public boolean isSharedMode()
  {
    AppMethodBeat.i(154759);
    if ((this.mIsXWalkReady) && (XWalkLibraryLoader.isSharedLibrary()))
    {
      AppMethodBeat.o(154759);
      return true;
    }
    AppMethodBeat.o(154759);
    return false;
  }
  
  public boolean isXWalkReady()
  {
    return this.mIsXWalkReady;
  }
  
  public boolean tryInitSync()
  {
    AppMethodBeat.i(154758);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.getAvailableVersion() == -1) {
        addXWalkInitializeLog("no available version ,need download");
      }
      for (;;)
      {
        AppMethodBeat.o(154758);
        return false;
        addXWalkInitializeLog("sdk not support this apk, need update new");
      }
    }
    if (XWalkCoreWrapper.attachXWalkCore(XWalkEnvironment.getAvailableVersion()) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      XWalkCoreWrapper.dockXWalkCore();
      XWalkCoreWrapper.getInstance().initNotifyChannnel();
      RuntimeToSdkChannel.initRuntimeToSdkChannel();
      this.mIsXWalkReady = true;
      XWalkLibraryLoader.finishInit(this.mContext);
      this.mInitListener.onXWalkInitCompleted();
      AppMethodBeat.o(154758);
      return true;
    }
    AppMethodBeat.o(154758);
    return false;
  }
  
  public static abstract interface XWalkInitListener
  {
    public abstract void onXWalkInitCancelled();
    
    public abstract void onXWalkInitCompleted();
    
    public abstract void onXWalkInitFailed();
    
    public abstract void onXWalkInitStarted();
  }
  
  class XWalkLibraryListener
    implements XWalkLibraryLoader.ActivateListener, XWalkLibraryLoader.DecompressListener
  {
    private XWalkLibraryListener() {}
    
    public void onActivateCompleted()
    {
      AppMethodBeat.i(154752);
      XWalkInitializer.access$102(XWalkInitializer.this, true);
      XWalkLibraryLoader.finishInit(XWalkInitializer.this.mContext);
      XWalkInitializer.this.mInitListener.onXWalkInitCompleted();
      AppMethodBeat.o(154752);
    }
    
    public void onActivateFailed()
    {
      AppMethodBeat.i(154751);
      XWalkInitializer.this.mInitListener.onXWalkInitFailed();
      AppMethodBeat.o(154751);
    }
    
    public void onActivateStarted() {}
    
    public void onDecompressCancelled()
    {
      AppMethodBeat.i(154750);
      XWalkInitializer.this.mInitListener.onXWalkInitCancelled();
      AppMethodBeat.o(154750);
    }
    
    public void onDecompressCompleted() {}
    
    public void onDecompressStarted() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer
 * JD-Core Version:    0.7.0.1
 */