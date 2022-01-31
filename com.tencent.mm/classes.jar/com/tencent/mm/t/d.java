package com.tencent.mm.t;

import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements b
{
  public static a dBl = null;
  public c dBm = null;
  
  public static void a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("WXFileDownloaderBridge", bool);
      dBl = parama;
      return;
    }
  }
  
  public final void d(String paramString, int paramInt, boolean paramBoolean)
  {
    y.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.dBm.onTaskFail(paramString, paramInt, paramBoolean);
  }
  
  public final void e(String paramString, long paramLong1, long paramLong2)
  {
    y.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
  }
  
  public final void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    y.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.dBm.onTaskSucc(paramString1, paramString2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.t.d
 * JD-Core Version:    0.7.0.1
 */