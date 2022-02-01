package com.tencent.xweb.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class WXFileDownloaderBridge
  implements b
{
  public static a aigr = null;
  public c aigs = null;
  
  @Deprecated
  public static void a(a parama)
  {
    AppMethodBeat.i(212520);
    Log.i("WXFileDownloaderBridge", "setFileDownloaderProxy:".concat(String.valueOf(parama)));
    aigr = parama;
    AppMethodBeat.o(212520);
  }
  
  public static boolean isValid()
  {
    return aigr != null;
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(156947);
    Log.i("WXFileDownloaderBridge", "onTaskFinished, save_path=" + paramString2 + ", url=" + paramString1);
    if (this.aigs != null) {
      this.aigs.onTaskFinish(paramString1, paramString2, paramBoolean);
    }
    AppMethodBeat.o(156947);
  }
  
  public final void i(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156948);
    Log.i("WXFileDownloaderBridge", "onTaskFailed, errCode=" + paramInt + ", url=" + paramString);
    if (this.aigs != null) {
      this.aigs.onTaskFail(paramString, paramInt, paramBoolean);
    }
    AppMethodBeat.o(156948);
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(156949);
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, cur_size=" + paramLong1 + ", total_size=" + paramLong2 + ", url=" + paramString);
    if (this.aigs != null) {
      this.aigs.onProgressChange(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(156949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.downloader.WXFileDownloaderBridge
 * JD-Core Version:    0.7.0.1
 */