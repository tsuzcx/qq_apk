package com.tencent.mm.plugin.webview.modelcache;

import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  private volatile ai edy;
  private final Object hkZ = new Object();
  final e rhA = new e();
  public final byte[] rhB = new byte[0];
  public final SparseArray<Set<Object>> rhC = new SparseArray();
  public final com.tencent.mm.sdk.b.c rhv = new q.1(this);
  public final com.tencent.mm.sdk.b.c rhw = new q.2(this);
  private volatile i rhx;
  final SparseArray<l> rhy = new SparseArray();
  public final c rhz = new c();
  
  public final void Ch(int paramInt)
  {
    if (au.DK()) {
      try
      {
        a.ccy().rhA.Ce(paramInt);
        synchronized (this.rhB)
        {
          Object localObject2 = (Set)this.rhC.get(paramInt);
          if ((localObject2 != null) && (((Set)localObject2).size() > 0))
          {
            ??? = ((Set)localObject2).iterator();
            if (((Iterator)???).hasNext())
            {
              ((Iterator)???).next();
              if (this.rhx == null) {
                this.rhx = new i();
              }
              localObject2 = this.rhx;
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", new Object[] { localException });
      }
    }
  }
  
  public final ai DS()
  {
    if (this.edy == null) {}
    synchronized (this.hkZ)
    {
      if (this.edy == null) {
        this.edy = new q.3(this, "WebViewCacheWorkerManager#WorkerThread");
      }
      return this.edy;
    }
  }
  
  public final void release(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.rhy.size())
    {
      this.rhy.valueAt(i);
      i += 1;
    }
    this.rhy.clear();
    a.clearCache();
    if (this.edy == null) {
      return;
    }
    synchronized (this.hkZ)
    {
      if (this.edy == null) {
        return;
      }
    }
    if (paramBoolean)
    {
      this.edy.mnU.quit();
      return;
    }
    ai localai = this.edy;
    this.edy.O(new q.4(this, localai));
    this.edy = null;
  }
  
  private static final class a
  {
    private static final q rhK = new q((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.q
 * JD-Core Version:    0.7.0.1
 */