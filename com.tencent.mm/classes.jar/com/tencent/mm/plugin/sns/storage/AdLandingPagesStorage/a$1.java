package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

final class a$1
  implements k
{
  a$1(a parama) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = (a.a)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ((a.a)localObject).bCD();
        this.oBY.oBW.remove(Long.valueOf(paramLong));
      }
      this.oBY.N(8, paramLong);
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (paramString != null)
    {
      paramString = (a.a)paramString.get();
      if (paramString != null)
      {
        paramString.bCC();
        this.oBY.oBW.remove(Long.valueOf(paramLong));
      }
      this.oBY.N(3, paramLong);
    }
  }
  
  public final void cy(long paramLong)
  {
    Object localObject = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = (a.a)((WeakReference)localObject).get();
      if (localObject != null)
      {
        FileDownloadTaskInfo localFileDownloadTaskInfo = d.aFP().dd(paramLong);
        if ((localFileDownloadTaskInfo.iPM >= 0L) && (localFileDownloadTaskInfo.hFz > 0L)) {
          ((a.a)localObject).xE((int)(localFileDownloadTaskInfo.iPM * 100L / localFileDownloadTaskInfo.hFz));
        }
      }
    }
  }
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString)
  {
    paramString = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (paramString != null)
    {
      paramString = (a.a)paramString.get();
      if (paramString != null) {
        paramString.bCE();
      }
      this.oBY.N(7, paramLong);
    }
  }
  
  public final void onTaskPaused(long paramLong)
  {
    Object localObject = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = (a.a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a.a)localObject).bCA();
      }
      this.oBY.N(6, paramLong);
    }
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    Object localObject = (WeakReference)this.oBY.oBW.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = (a.a)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ((a.a)localObject).bCB();
        this.oBY.oBW.remove(Long.valueOf(paramLong));
      }
      this.oBY.N(2, paramLong);
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    this.oBY.N(1, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.1
 * JD-Core Version:    0.7.0.1
 */