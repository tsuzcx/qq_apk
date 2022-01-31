package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkInitializer
{
  private static final String TAG = "XWalkLib";
  private Context mContext;
  private XWalkInitializer.XWalkInitListener mInitListener;
  private boolean mIsXWalkReady;
  
  public XWalkInitializer(XWalkInitializer.XWalkInitListener paramXWalkInitListener, Context paramContext)
  {
    AppMethodBeat.i(85658);
    this.mInitListener = paramXWalkInitListener;
    this.mContext = paramContext;
    XWalkLibraryLoader.prepareToInit(this.mContext);
    AppMethodBeat.o(85658);
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    AppMethodBeat.i(85661);
    XWalkEnvironment.addXWalkInitializeLog(paramString);
    AppMethodBeat.o(85661);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85660);
    XWalkEnvironment.addXWalkInitializeLog(paramString1, paramString2);
    AppMethodBeat.o(85660);
  }
  
  public static String getXWalkInitializeLog()
  {
    AppMethodBeat.i(85662);
    Object localObject = XWalkEnvironment.getSharedPreferencesForLog();
    if (localObject == null)
    {
      AppMethodBeat.o(85662);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("log", "");
    AppMethodBeat.o(85662);
    return localObject;
  }
  
  public boolean initAsync_remove()
  {
    AppMethodBeat.i(85659);
    if (this.mIsXWalkReady)
    {
      AppMethodBeat.o(85659);
      return false;
    }
    if ((XWalkLibraryLoader.isInitializing()) || (XWalkLibraryLoader.isDownloading()))
    {
      Log.i("XWalkLib", "Other initialization or download is proceeding");
      AppMethodBeat.o(85659);
      return false;
    }
    Log.i("XWalkLib", "Initialized by XWalkInitializer");
    this.mInitListener.onXWalkInitStarted();
    AppMethodBeat.o(85659);
    return true;
  }
  
  public boolean isDownloadMode()
  {
    AppMethodBeat.i(85665);
    if ((this.mIsXWalkReady) && (XWalkEnvironment.isDownloadMode()))
    {
      AppMethodBeat.o(85665);
      return true;
    }
    AppMethodBeat.o(85665);
    return false;
  }
  
  public boolean isSharedMode()
  {
    AppMethodBeat.i(85664);
    if ((this.mIsXWalkReady) && (XWalkLibraryLoader.isSharedLibrary()))
    {
      AppMethodBeat.o(85664);
      return true;
    }
    AppMethodBeat.o(85664);
    return false;
  }
  
  public boolean isXWalkReady()
  {
    return this.mIsXWalkReady;
  }
  
  public boolean tryInitSync()
  {
    AppMethodBeat.i(85663);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.getAvailableVersion() == -1) {
        addXWalkInitializeLog("no available version ,need download");
      }
      for (;;)
      {
        AppMethodBeat.o(85663);
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
      AppMethodBeat.o(85663);
      return true;
    }
    AppMethodBeat.o(85663);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer
 * JD-Core Version:    0.7.0.1
 */