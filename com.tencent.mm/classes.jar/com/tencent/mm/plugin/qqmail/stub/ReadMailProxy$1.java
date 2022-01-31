package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.downloader.model.k;

final class ReadMailProxy$1
  implements k
{
  ReadMailProxy$1(ReadMailProxy paramReadMailProxy) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.nfz.CLIENT_CALL("onTaskFailed", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    this.nfz.CLIENT_CALL("onTaskFinished", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void cy(long paramLong) {}
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    this.nfz.CLIENT_CALL("onTaskPaused", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    this.nfz.CLIENT_CALL("onTaskRemoved", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    this.nfz.CLIENT_CALL("onTaskStarted", new Object[] { Long.valueOf(paramLong), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.1
 * JD-Core Version:    0.7.0.1
 */