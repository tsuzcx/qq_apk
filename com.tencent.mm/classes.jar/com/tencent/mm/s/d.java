package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  implements b
{
  public static a gRd = null;
  public c gRe = null;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(120679);
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("WXFileDownloaderBridge", bool);
      gRd = parama;
      AppMethodBeat.o(120679);
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(120680);
    Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.gRe.onTaskSucc(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(120680);
  }
  
  public final void d(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(120681);
    Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.gRe.onTaskFail(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(120681);
  }
  
  public final void j(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120682);
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    AppMethodBeat.o(120682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.s.d
 * JD-Core Version:    0.7.0.1
 */