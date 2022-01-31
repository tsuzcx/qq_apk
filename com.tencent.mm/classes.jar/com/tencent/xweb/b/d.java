package com.tencent.xweb.b;

import org.xwalk.core.Log;

public final class d
  implements b
{
  public static a xhB = null;
  public c xhC = null;
  
  public static void a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder("XWalkLib SetFileDownloaderProxy:");
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("WXFileDownloaderBridge", bool);
      xhB = parama;
      return;
    }
  }
  
  public static boolean isValid()
  {
    return xhB != null;
  }
  
  public final void d(String paramString, int paramInt, boolean paramBoolean)
  {
    Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + paramString + ", errCode=" + paramInt);
    this.xhC.onTaskFail(paramString, paramInt, paramBoolean);
  }
  
  public final void e(String paramString, long paramLong1, long paramLong2)
  {
    Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    this.xhC.onProgressChange(paramString, paramLong1, paramLong2);
  }
  
  public final void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + paramString1 + ", save_path=" + paramString2);
    this.xhC.onTaskSucc(paramString1, paramString2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.b.d
 * JD-Core Version:    0.7.0.1
 */