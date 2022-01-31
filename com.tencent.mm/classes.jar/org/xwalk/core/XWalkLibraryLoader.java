package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkLibraryLoader
{
  private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
  private static final int DOWNLOAD_TYPE_CDN = 2;
  private static final int DOWNLOAD_TYPE_HTTP = 1;
  private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
  private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
  private static final int ERROR_CODE_EXCEPTION = -101;
  private static final int ERROR_CODE_FAILED = -1;
  private static final int ERROR_CODE_SUCCESS = 0;
  private static final int ERROR_TYPE_DOWNLOADER = 1;
  private static final int ERROR_TYPE_NONE = 0;
  private static final int ERROR_TYPE_USER = 2;
  private static final String TAG = "XWalkLib";
  private static AsyncTask<Void, Integer, Integer> sActiveTask;
  
  public static boolean cancelHttpDownload()
  {
    AppMethodBeat.i(85701);
    if ((sActiveTask != null) && ((sActiveTask instanceof XWalkLibraryLoader.HttpDownloadTask)) && (sActiveTask.cancel(true)))
    {
      AppMethodBeat.o(85701);
      return true;
    }
    AppMethodBeat.o(85701);
    return false;
  }
  
  public static void finishInit(Context paramContext)
  {
    AppMethodBeat.i(85699);
    XWalkCoreWrapper.handlePostInit(paramContext.getClass().getName());
    AppMethodBeat.o(85699);
  }
  
  public static int getLibraryStatus()
  {
    AppMethodBeat.i(85697);
    int i = XWalkCoreWrapper.getCoreStatus();
    AppMethodBeat.o(85697);
    return i;
  }
  
  public static boolean isDownloading()
  {
    return (sActiveTask != null) && ((sActiveTask instanceof XWalkLibraryLoader.HttpDownloadTask));
  }
  
  public static boolean isInitializing()
  {
    return false;
  }
  
  public static boolean isLibraryReady()
  {
    AppMethodBeat.i(85696);
    if (XWalkCoreWrapper.getInstance() != null)
    {
      AppMethodBeat.o(85696);
      return true;
    }
    AppMethodBeat.o(85696);
    return false;
  }
  
  public static boolean isSharedLibrary()
  {
    AppMethodBeat.i(85695);
    boolean bool = XWalkCoreWrapper.getInstance().isSharedMode();
    AppMethodBeat.o(85695);
    return bool;
  }
  
  public static void prepareToInit(Context paramContext)
  {
    AppMethodBeat.i(85698);
    XWalkEnvironment.init(paramContext);
    XWalkCoreWrapper.handlePreInit(paramContext.getClass().getName());
    AppMethodBeat.o(85698);
  }
  
  public static void startHttpDownload(XWalkLibraryLoader.DownloadListener paramDownloadListener, Context paramContext, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(85700);
    paramContext = new XWalkLibraryLoader.WXFileDownloaderTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath(), paramUpdateConfig.getUpdateBizType());
    if ((paramUpdateConfig.bUseCdn) && (paramContext.isValid()))
    {
      Log.i("XWalkLib", "use wx file downloader");
      paramContext.execute(new Void[0]);
      AppMethodBeat.o(85700);
      return;
    }
    Log.i("XWalkLib", "use default file downloader");
    new XWalkLibraryLoader.HttpDownloadTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath()).execute(new Void[0]);
    AppMethodBeat.o(85700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader
 * JD-Core Version:    0.7.0.1
 */