package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ui
  implements ur.a
{
  private static final TimeUnit a = TimeUnit.SECONDS;
  private static final int b = Runtime.getRuntime().availableProcessors();
  private tn c;
  private Map<String, List<uf>> d = new HashMap();
  private Map<String, List<uf>> e = new HashMap();
  private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
  private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private ExecutorService h;
  private ExecutorService i;
  private ThreadFactory j = new ui.1(this);
  
  public ui(tn paramtn)
  {
    this.c = paramtn;
    int m;
    if (b < 4) {
      m = 3;
    }
    for (int k = 3;; k = 4)
    {
      this.i = new ThreadPoolExecutor(k, m, 30L, TimeUnit.SECONDS, this.g, this.j);
      this.h = new ThreadPoolExecutor(1, 1, 30L, a, this.f);
      return;
      m = 4;
    }
  }
  
  public final void a()
  {
    if (this.f != null) {
      this.f.clear();
    }
    if (this.g != null) {
      this.g.clear();
    }
    if (this.h != null)
    {
      this.h.shutdownNow();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.shutdown();
      this.i = null;
    }
  }
  
  public final void a(ur paramur)
  {
    if (paramur != null)
    {
      Object localObject2 = paramur.b();
      Bitmap localBitmap = paramur.a();
      synchronized (this.d)
      {
        List localList = (List)this.e.remove(localObject2);
        this.d.remove(localObject2);
        if ((localList != null) && (localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (uf)((Iterator)???).next();
            if (!((uf)localObject2).i()) {
              ((uf)localObject2).a(localBitmap.copy(localBitmap.getConfig(), false));
            }
          }
        }
      }
    }
    this.c.c().postInvalidate();
  }
  
  public final void a(final ArrayList<ue> paramArrayList)
  {
    if (ub.a(paramArrayList)) {}
    for (;;)
    {
      return;
      this.f.clear();
      paramArrayList = new Runnable()
      {
        public final void run()
        {
          ui.a(ui.this).clear();
          for (;;)
          {
            int i;
            uf localuf;
            synchronized (ui.b(ui.this))
            {
              ui.b(ui.this).clear();
              ui.b(ui.this).putAll(ui.c(ui.this));
              i = 0;
              if (i >= paramArrayList.size()) {
                break;
              }
              Iterator localIterator = ((ue)paramArrayList.get(i)).b().iterator();
              if (!localIterator.hasNext()) {
                break label448;
              }
              localuf = (uf)localIterator.next();
            }
            uh localuh;
            try
            {
              ??? = ug.a().a(localuf);
              if (??? == null) {
                continue;
              }
              if ((((uh)???).b() != null) && (((uh)???).d() == localuf.l()))
              {
                localuf.a(((uh)???).b());
                if ((localuf.m() == ue.a.a) && (!ui.d(ui.this).r())) {
                  tn.a += 1;
                }
                if (localuf.m() != ue.a.b) {
                  continue;
                }
                tn.b += 1;
                continue;
                localObject2 = finally;
                throw localObject2;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                if (vb.n() != null) {
                  vb.n().a("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + localuf.b() + ",y=" + localuf.c() + ",z=" + localuf.d() + "Exception Info:" + localThrowable.toString());
                }
                localuh = null;
              }
              if ((localuh.b() != null) && (localuh.d() != localuf.l()) && (localuf.m() == ue.a.a))
              {
                new StringBuilder("Have got cache,but version is not ok,tileBitmap.getVersion：").append(localuh.d()).append(",tileData.getVersion:").append(localuf.l());
                ui.a(ui.this, localuf, true, localuh);
              }
            }
            if (localuh.b() == null)
            {
              ui.a(ui.this, localuf, false, null);
              if ((localuf.m() == ue.a.a) && (!ui.d(ui.this).r()))
              {
                ui.d(ui.this);
                tn.c += 1;
              }
              if (localuf.m() == ue.a.b)
              {
                ui.d(ui.this);
                tn.d += 1;
                continue;
                label448:
                ui.d(ui.this).c().postInvalidate();
                i += 1;
              }
            }
          }
        }
      };
      try
      {
        if (!this.h.isShutdown())
        {
          this.h.execute(paramArrayList);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        new StringBuilder("getTiles get error:").append(paramArrayList.getMessage());
      }
    }
  }
  
  public final void b(ur arg1)
  {
    String str;
    if (??? != null) {
      str = ???.b();
    }
    synchronized (this.d)
    {
      List localList = (List)this.d.remove(str);
      this.e.put(str, localList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ui
 * JD-Core Version:    0.7.0.1
 */