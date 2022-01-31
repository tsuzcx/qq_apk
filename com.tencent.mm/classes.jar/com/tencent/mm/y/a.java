package com.tencent.mm.y;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a
{
  static a dFx;
  private final int dFA = 0;
  private final int dFB = 1;
  public b dFy = new b();
  ArrayList<WeakReference<a.a>> dFz = new ArrayList();
  private ah handler = new a.1(this, Looper.getMainLooper());
  public boolean initialized = false;
  
  private void a(ac.a parama, int paramInt, String paramString)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      return;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    b.a locala2 = localb.f(parama);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = localb.a(parama, paramInt, "", "");
      localb.dFI.put(parama, locala1);
      localb.a(locala1);
    }
    locala1.value = paramString;
    locala1.type = paramInt;
    locala1.bJY = localb.BR();
    localb.a(locala1);
    this.handler.sendMessage(this.handler.obtainMessage(0, new a.b(this, parama, paramInt, paramString)));
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      return;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b.a locala2 = localb.he(paramInt1);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = localb.a(paramInt1, paramInt2, "", "");
      localb.dFH.put(paramInt1, locala1);
      localb.a(locala1);
    }
    locala1.value = paramString;
    locala1.type = paramInt2;
    locala1.bJY = localb.BR();
    localb.a(locala1);
    this.handler.sendMessage(this.handler.obtainMessage(0, new a.b(this, paramInt1, paramInt2, paramString)));
  }
  
  public static int parseInt(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    return bk.ZR(paramString);
  }
  
  public final void a(ac.a parama, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 1, str);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
      return;
    }
    this.dFz.add(new WeakReference(parama));
  }
  
  public final boolean a(ac.a parama)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
    }
    do
    {
      return false;
      parama = this.dFy.f(parama);
    } while ((parama == null) || (parseInt(parama.value) == 0));
    return true;
  }
  
  public final boolean a(ac.a parama, int paramInt)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      return false;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", new Object[] { parama, Integer.valueOf(paramInt), Integer.valueOf(2) });
    b.a locala = localb.f(parama);
    if (locala == null)
    {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      parama = null;
    }
    while (parama == null)
    {
      return false;
      if ((locala.type & 0x2) == 0)
      {
        y.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
        parama = null;
      }
      else
      {
        b.b localb1 = localb.hf(paramInt);
        if (localb1 != null)
        {
          String str = (String)localb1.dFQ.get(parama.name());
          if ((str != null) && (str.equals(locala.bJY)))
          {
            parama = null;
          }
          else
          {
            if (str == null)
            {
              str = localb.BR();
              localb1.dFQ.put(parama.name(), str);
              localb.a(localb1);
            }
            parama = locala;
          }
        }
        else
        {
          y.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
          parama = null;
        }
      }
    }
    return parseInt(parama.value) != 0;
  }
  
  public final boolean a(ac.a parama1, ac.a parama2)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
    }
    do
    {
      return false;
      parama1 = this.dFy.a(parama1, parama2, 1);
    } while ((parama1 == null) || (parseInt(parama1.value) == 0));
    return true;
  }
  
  public final void b(ac.a parama, int paramInt)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      return;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", new Object[] { parama, Integer.valueOf(paramInt) });
    b.a locala = localb.f(parama);
    if (locala == null) {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, paramInt, parama)));
      return;
      b.b localb2 = localb.hf(paramInt);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        y.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.hd(paramInt);
        localb.dFJ.put(paramInt, localb1);
      }
      localb1.dFQ.put(parama.name(), locala.bJY);
      localb.a(localb1);
    }
  }
  
  public final void b(ac.a parama, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 2, str);
      return;
    }
  }
  
  public final void b(a.a parama)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = null;
      int i = 0;
      while (i < this.dFz.size())
      {
        WeakReference localWeakReference = (WeakReference)this.dFz.get(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          localObject2 = localObject1;
          if (localWeakReference.get() != parama) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localWeakReference);
        }
        i += 1;
        localObject1 = localObject2;
      }
    } while (localObject1 == null);
    parama = localObject1.iterator();
    while (parama.hasNext())
    {
      localObject2 = (WeakReference)parama.next();
      this.dFz.remove(localObject2);
    }
    localObject1.clear();
  }
  
  public final boolean b(ac.a parama1, ac.a parama2)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
    }
    do
    {
      return false;
      parama1 = this.dFy.a(parama1, parama2, 2);
    } while ((parama1 == null) || (parseInt(parama1.value) == 0));
    return true;
  }
  
  public final boolean bb(int paramInt1, int paramInt2)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
    }
    b.a locala;
    do
    {
      return false;
      locala = this.dFy.u(paramInt1, paramInt2, 1);
    } while ((locala == null) || (parseInt(locala.value) == 0));
    return true;
  }
  
  public final boolean bc(int paramInt1, int paramInt2)
  {
    if (!this.initialized) {
      y.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
    }
    b.a locala;
    do
    {
      return false;
      locala = this.dFy.u(paramInt1, paramInt2, 2);
    } while ((locala == null) || (parseInt(locala.value) == 0));
    return true;
  }
  
  public final void bd(int paramInt1, int paramInt2)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      return;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b.a locala = localb.he(paramInt1);
    if (locala == null) {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, paramInt2, paramInt1)));
      return;
      b.b localb2 = localb.hf(paramInt2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        y.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.hd(paramInt2);
        localb.dFJ.put(paramInt2, localb1);
      }
      localb1.dFP.put(paramInt1, locala.bJY);
      localb.a(localb1);
    }
  }
  
  public final void c(ac.a parama1, ac.a parama2)
  {
    if (!this.initialized)
    {
      y.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      return;
    }
    b localb = this.dFy;
    y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    b.a locala = localb.f(parama1);
    if (locala == null) {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, parama2, parama1)));
      return;
      b.b localb2 = localb.g(parama2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        y.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.e(parama2);
        localb.dFK.put(parama2, localb1);
      }
      localb1.dFQ.put(parama1.name(), locala.bJY);
      localb.a(localb1);
    }
  }
  
  public final void init()
  {
    this.initialized = true;
    this.dFy.dFM = g.DP().Dz();
  }
  
  public final void v(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      d(paramInt, 1, str);
      return;
    }
  }
  
  public final void w(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      d(paramInt, 2, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.y.a
 * JD-Core Version:    0.7.0.1
 */