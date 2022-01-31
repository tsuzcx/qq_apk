package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;

public class XWalkInitializer
{
  private static final String TAG = "XWalkLib";
  private Context mContext;
  private XWalkInitializer.XWalkInitListener mInitListener;
  private boolean mIsXWalkReady;
  
  public XWalkInitializer(XWalkInitializer.XWalkInitListener paramXWalkInitListener, Context paramContext)
  {
    this.mInitListener = paramXWalkInitListener;
    this.mContext = paramContext;
    XWalkLibraryLoader.prepareToInit(this.mContext);
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    XWalkEnvironment.addXWalkInitializeLog(paramString);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    XWalkEnvironment.addXWalkInitializeLog(paramString1, paramString2);
  }
  
  public static String getXWalkInitializeLog()
  {
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForLog();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("log", "");
  }
  
  public boolean initAsync_remove()
  {
    if (this.mIsXWalkReady) {
      return false;
    }
    if ((XWalkLibraryLoader.isInitializing()) || (XWalkLibraryLoader.isDownloading()))
    {
      Log.i("XWalkLib", "Other initialization or download is proceeding");
      return false;
    }
    Log.i("XWalkLib", "Initialized by XWalkInitializer");
    this.mInitListener.onXWalkInitStarted();
    return true;
  }
  
  public boolean isDownloadMode()
  {
    return (this.mIsXWalkReady) && (XWalkEnvironment.isDownloadMode());
  }
  
  public boolean isSharedMode()
  {
    return (this.mIsXWalkReady) && (XWalkLibraryLoader.isSharedLibrary());
  }
  
  public boolean isXWalkReady()
  {
    return this.mIsXWalkReady;
  }
  
  public boolean tryInitSync()
  {
    if (!XWalkEnvironment.hasAvailableVersion()) {
      if (XWalkEnvironment.getAvailableVersion() == -1) {
        addXWalkInitializeLog("no available version ,need download");
      }
    }
    for (;;)
    {
      return false;
      addXWalkInitializeLog("sdk not support this apk, need update new");
      return false;
      if (XWalkCoreWrapper.attachXWalkCore(XWalkEnvironment.getAvailableVersion()) == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        XWalkCoreWrapper.dockXWalkCore();
        XWalkCoreWrapper.getInstance().initNotifyChannnel();
        this.mIsXWalkReady = true;
        XWalkLibraryLoader.finishInit(this.mContext);
        this.mInitListener.onXWalkInitCompleted();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer
 * JD-Core Version:    0.7.0.1
 */