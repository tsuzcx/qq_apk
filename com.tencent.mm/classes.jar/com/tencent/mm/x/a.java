package com.tencent.mm.x;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a
{
  static a eCZ;
  public b eDa;
  ArrayList<WeakReference<a.a>> eDb;
  private final int eDc;
  private final int eDd;
  private ak handler;
  public boolean initialized;
  
  public a()
  {
    AppMethodBeat.i(77702);
    this.eDa = new b();
    this.eDb = new ArrayList();
    this.initialized = false;
    this.eDc = 0;
    this.eDd = 1;
    this.handler = new a.1(this, Looper.getMainLooper());
    AppMethodBeat.o(77702);
  }
  
  private void a(ac.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(77709);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      AppMethodBeat.o(77709);
      return;
    }
    this.eDa.b(parama, paramInt, paramString);
    this.handler.sendMessage(this.handler.obtainMessage(0, new a.b(this, parama, paramInt, paramString)));
    AppMethodBeat.o(77709);
  }
  
  private void g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(77708);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      AppMethodBeat.o(77708);
      return;
    }
    this.eDa.h(paramInt1, paramInt2, paramString);
    this.handler.sendMessage(this.handler.obtainMessage(0, new a.b(this, paramInt1, paramInt2, paramString)));
    AppMethodBeat.o(77708);
  }
  
  public static int parseInt(String paramString)
  {
    AppMethodBeat.i(77719);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77719);
      return 0;
    }
    int i = bo.apV(paramString);
    AppMethodBeat.o(77719);
    return i;
  }
  
  public final void a(ac.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(77705);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 1, str);
      AppMethodBeat.o(77705);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(77720);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
      AppMethodBeat.o(77720);
      return;
    }
    this.eDb.add(new WeakReference(parama));
    AppMethodBeat.o(77720);
  }
  
  public final boolean a(ac.a parama)
  {
    AppMethodBeat.i(77718);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
      AppMethodBeat.o(77718);
      return false;
    }
    parama = this.eDa.f(parama);
    if (parama == null)
    {
      AppMethodBeat.o(77718);
      return false;
    }
    if (parseInt(parama.value) == 0)
    {
      AppMethodBeat.o(77718);
      return false;
    }
    AppMethodBeat.o(77718);
    return true;
  }
  
  public final boolean a(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(77714);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(77714);
      return false;
    }
    b localb = this.eDa;
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", new Object[] { parama, Integer.valueOf(paramInt), Integer.valueOf(2) });
    b.a locala = localb.f(parama);
    if (locala == null)
    {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      parama = null;
    }
    while (parama == null)
    {
      AppMethodBeat.o(77714);
      return false;
      if ((locala.type & 0x2) == 0)
      {
        ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
        parama = null;
      }
      else
      {
        b.b localb1 = localb.jv(paramInt);
        if (localb1 != null)
        {
          String str = (String)localb1.eDs.get(parama.name());
          if ((str != null) && (str.equals(locala.crs)))
          {
            parama = null;
          }
          else
          {
            if (str == null)
            {
              str = localb.PH();
              localb1.eDs.put(parama.name(), str);
              localb.a(localb1);
            }
            parama = locala;
          }
        }
        else
        {
          ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
          parama = null;
        }
      }
    }
    if (parseInt(parama.value) == 0)
    {
      AppMethodBeat.o(77714);
      return false;
    }
    AppMethodBeat.o(77714);
    return true;
  }
  
  public final boolean a(ac.a parama1, ac.a parama2)
  {
    AppMethodBeat.i(77711);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      AppMethodBeat.o(77711);
      return false;
    }
    parama1 = this.eDa.a(parama1, parama2, 1);
    if (parama1 == null)
    {
      AppMethodBeat.o(77711);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      AppMethodBeat.o(77711);
      return false;
    }
    AppMethodBeat.o(77711);
    return true;
  }
  
  public final void b(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(77717);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(77717);
      return;
    }
    b localb = this.eDa;
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", new Object[] { parama, Integer.valueOf(paramInt) });
    b.a locala = localb.f(parama);
    if (locala == null) {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, paramInt, parama)));
      AppMethodBeat.o(77717);
      return;
      b.b localb2 = localb.jv(paramInt);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.jt(paramInt);
        localb.eDl.put(paramInt, localb1);
      }
      localb1.eDs.put(parama.name(), locala.crs);
      localb.a(localb1);
    }
  }
  
  public final void b(ac.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(77707);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 2, str);
      AppMethodBeat.o(77707);
      return;
    }
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(77721);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
      AppMethodBeat.o(77721);
      return;
    }
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    while (i < this.eDb.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eDb.get(i);
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
    if (localObject1 != null)
    {
      parama = localObject1.iterator();
      while (parama.hasNext())
      {
        localObject2 = (WeakReference)parama.next();
        this.eDb.remove(localObject2);
      }
      localObject1.clear();
    }
    AppMethodBeat.o(77721);
  }
  
  public final boolean b(ac.a parama1, ac.a parama2)
  {
    AppMethodBeat.i(77713);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(77713);
      return false;
    }
    parama1 = this.eDa.a(parama1, parama2, 2);
    if (parama1 == null)
    {
      AppMethodBeat.o(77713);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      AppMethodBeat.o(77713);
      return false;
    }
    AppMethodBeat.o(77713);
    return true;
  }
  
  public final void c(ac.a parama1, ac.a parama2)
  {
    AppMethodBeat.i(77716);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(77716);
      return;
    }
    b localb = this.eDa;
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    b.a locala = localb.f(parama1);
    if (locala == null) {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, parama2, parama1)));
      AppMethodBeat.o(77716);
      return;
      b.b localb2 = localb.g(parama2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.e(parama2);
        localb.eDm.put(parama2, localb1);
      }
      localb1.eDs.put(parama1.name(), locala.crs);
      localb.a(localb1);
    }
  }
  
  public final boolean cc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77710);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      AppMethodBeat.o(77710);
      return false;
    }
    b.a locala = this.eDa.F(paramInt1, paramInt2, 1);
    if (locala == null)
    {
      AppMethodBeat.o(77710);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      AppMethodBeat.o(77710);
      return false;
    }
    AppMethodBeat.o(77710);
    return true;
  }
  
  public final boolean cd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77712);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(77712);
      return false;
    }
    b.a locala = this.eDa.F(paramInt1, paramInt2, 2);
    if (locala == null)
    {
      AppMethodBeat.o(77712);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      AppMethodBeat.o(77712);
      return false;
    }
    AppMethodBeat.o(77712);
    return true;
  }
  
  public final void ce(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77715);
    if (!this.initialized)
    {
      ab.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(77715);
      return;
    }
    b localb = this.eDa;
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b.a locala = localb.ju(paramInt1);
    if (locala == null) {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new a.c(this, paramInt2, paramInt1)));
      AppMethodBeat.o(77715);
      return;
      b.b localb2 = localb.jv(paramInt2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.jt(paramInt2);
        localb.eDl.put(paramInt2, localb1);
      }
      localb1.eDr.put(paramInt1, locala.crs);
      localb.a(localb1);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(77703);
    this.initialized = true;
    this.eDa.eDo = g.RL().Ru();
    AppMethodBeat.o(77703);
  }
  
  public final void x(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(77704);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      g(paramInt, 1, str);
      AppMethodBeat.o(77704);
      return;
    }
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(77706);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      g(paramInt, 2, str);
      AppMethodBeat.o(77706);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.x.a
 * JD-Core Version:    0.7.0.1
 */