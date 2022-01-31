package com.tencent.mm.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  implements b
{
  public static a euM = null;
  public c euN = null;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(128598);
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("WXFileDownloaderBridge", bool);
      euM = parama;
      AppMethodBeat.o(128598);
      return;
    }
  }
  
  public final void d(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(128600);
    ab.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.euN.onTaskFail(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(128600);
  }
  
  public final void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(128599);
    ab.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.euN.onTaskSucc(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(128599);
  }
  
  public final void l(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(128601);
    ab.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    AppMethodBeat.o(128601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.t.d
 * JD-Core Version:    0.7.0.1
 */