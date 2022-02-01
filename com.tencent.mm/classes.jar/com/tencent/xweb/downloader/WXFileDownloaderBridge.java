package com.tencent.xweb.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class WXFileDownloaderBridge
  implements b
{
  public static a MqX = null;
  public c MqY = null;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(156946);
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("WXFileDownloaderBridge", bool);
      MqX = parama;
      AppMethodBeat.o(156946);
      return;
    }
  }
  
  public static boolean isValid()
  {
    return MqX != null;
  }
  
  public final void c(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156948);
    Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.MqY.onTaskFail(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(156948);
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(156947);
    Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.MqY.onTaskSucc(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(156947);
  }
  
  public final void j(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(156949);
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    this.MqY.onProgressChange(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(156949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.downloader.WXFileDownloaderBridge
 * JD-Core Version:    0.7.0.1
 */