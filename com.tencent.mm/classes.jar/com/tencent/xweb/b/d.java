package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class d
  implements b
{
  public static a BEO = null;
  public c BEP = null;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(3963);
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("WXFileDownloaderBridge", bool);
      BEO = parama;
      AppMethodBeat.o(3963);
      return;
    }
  }
  
  public static boolean isValid()
  {
    return BEO != null;
  }
  
  public final void d(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(3965);
    Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.BEP.onTaskFail(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(3965);
  }
  
  public final void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(3964);
    Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.BEP.onTaskSucc(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(3964);
  }
  
  public final void l(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(3966);
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    this.BEP.onProgressChange(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(3966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.b.d
 * JD-Core Version:    0.7.0.1
 */