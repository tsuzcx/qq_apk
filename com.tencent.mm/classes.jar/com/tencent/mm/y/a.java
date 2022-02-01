package com.tencent.mm.y;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a
{
  static a gzb;
  public b gzc;
  private final int gzd;
  private final int gze;
  private aq handler;
  public boolean initialized;
  ArrayList<WeakReference<a>> listeners;
  
  public a()
  {
    AppMethodBeat.i(150038);
    this.gzc = new b();
    this.listeners = new ArrayList();
    this.initialized = false;
    this.gzd = 0;
    this.gze = 1;
    this.handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(150037);
        if ((paramAnonymousMessage.what == 0) && ((paramAnonymousMessage.obj instanceof a.b)))
        {
          paramAnonymousMessage = (a.b)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.gzh != null)
          {
            a locala = a.this;
            Object localObject2 = paramAnonymousMessage.gzh;
            paramAnonymousMessage = null;
            Iterator localIterator = locala.listeners.iterator();
            Object localObject1;
            while (localIterator.hasNext())
            {
              WeakReference localWeakReference = (WeakReference)localIterator.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null))
              {
                ((a.a)localWeakReference.get()).b((am.a)localObject2);
              }
              else
              {
                localObject1 = paramAnonymousMessage;
                if (paramAnonymousMessage == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(localWeakReference);
                paramAnonymousMessage = (Message)localObject1;
              }
            }
            if (paramAnonymousMessage != null)
            {
              localObject1 = paramAnonymousMessage.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (WeakReference)((Iterator)localObject1).next();
                locala.listeners.remove(localObject2);
              }
              paramAnonymousMessage.clear();
            }
            AppMethodBeat.o(150037);
            return;
          }
          a.a(a.this, paramAnonymousMessage.gzg, paramAnonymousMessage.value);
        }
        AppMethodBeat.o(150037);
      }
    };
    AppMethodBeat.o(150038);
  }
  
  private void a(am.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(150045);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      AppMethodBeat.o(150045);
      return;
    }
    this.gzc.b(parama, paramInt, paramString);
    this.handler.sendMessage(this.handler.obtainMessage(0, new b(parama, paramInt, paramString)));
    AppMethodBeat.o(150045);
  }
  
  private void f(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150044);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      AppMethodBeat.o(150044);
      return;
    }
    this.gzc.g(paramInt1, paramInt2, paramString);
    this.handler.sendMessage(this.handler.obtainMessage(0, new b(paramInt1, paramInt2, paramString)));
    AppMethodBeat.o(150044);
  }
  
  public static int parseInt(String paramString)
  {
    AppMethodBeat.i(150055);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150055);
      return 0;
    }
    int i = bu.aSB(paramString);
    AppMethodBeat.o(150055);
    return i;
  }
  
  public final void a(am.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150041);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 1, str);
      AppMethodBeat.o(150041);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150056);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
      AppMethodBeat.o(150056);
      return;
    }
    this.listeners.add(new WeakReference(parama));
    AppMethodBeat.o(150056);
  }
  
  public final boolean a(am.a parama)
  {
    AppMethodBeat.i(150054);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
      AppMethodBeat.o(150054);
      return false;
    }
    parama = this.gzc.f(parama);
    if (parama == null)
    {
      AppMethodBeat.o(150054);
      return false;
    }
    if (parseInt(parama.value) == 0)
    {
      AppMethodBeat.o(150054);
      return false;
    }
    AppMethodBeat.o(150054);
    return true;
  }
  
  public final boolean a(am.a parama, int paramInt)
  {
    AppMethodBeat.i(150050);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(150050);
      return false;
    }
    b localb = this.gzc;
    ae.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", new Object[] { parama, Integer.valueOf(paramInt), Integer.valueOf(2) });
    b.a locala = localb.f(parama);
    if (locala == null)
    {
      ae.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      parama = null;
    }
    while (parama == null)
    {
      AppMethodBeat.o(150050);
      return false;
      if ((locala.type & 0x2) == 0)
      {
        ae.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
        parama = null;
      }
      else
      {
        b.b localb1 = localb.mz(paramInt);
        if (localb1 != null)
        {
          String str = (String)localb1.gzt.get(parama.name());
          if ((str != null) && (str.equals(locala.dqk)))
          {
            parama = null;
          }
          else
          {
            if (str == null)
            {
              str = localb.ahG();
              localb1.gzt.put(parama.name(), str);
              localb.a(localb1);
            }
            parama = locala;
          }
        }
        else
        {
          ae.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
          parama = null;
        }
      }
    }
    if (parseInt(parama.value) == 0)
    {
      AppMethodBeat.o(150050);
      return false;
    }
    AppMethodBeat.o(150050);
    return true;
  }
  
  public final boolean a(am.a parama1, am.a parama2)
  {
    AppMethodBeat.i(150047);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      AppMethodBeat.o(150047);
      return false;
    }
    parama1 = this.gzc.a(parama1, parama2, 1);
    if (parama1 == null)
    {
      AppMethodBeat.o(150047);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      AppMethodBeat.o(150047);
      return false;
    }
    AppMethodBeat.o(150047);
    return true;
  }
  
  public final void b(am.a parama, int paramInt)
  {
    AppMethodBeat.i(150053);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(150053);
      return;
    }
    b localb = this.gzc;
    ae.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", new Object[] { parama, Integer.valueOf(paramInt) });
    b.a locala = localb.f(parama);
    if (locala == null) {
      ae.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new c(paramInt, parama)));
      AppMethodBeat.o(150053);
      return;
      b.b localb2 = localb.mz(paramInt);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        ae.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.mx(paramInt);
        localb.gzm.put(paramInt, localb1);
      }
      localb1.gzt.put(parama.name(), locala.dqk);
      localb.a(localb1);
    }
  }
  
  public final void b(am.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150043);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 2, str);
      AppMethodBeat.o(150043);
      return;
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(150057);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
      AppMethodBeat.o(150057);
      return;
    }
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    while (i < this.listeners.size())
    {
      WeakReference localWeakReference = (WeakReference)this.listeners.get(i);
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
        this.listeners.remove(localObject2);
      }
      localObject1.clear();
    }
    AppMethodBeat.o(150057);
  }
  
  public final boolean b(am.a parama1, am.a parama2)
  {
    AppMethodBeat.i(150049);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(150049);
      return false;
    }
    parama1 = this.gzc.a(parama1, parama2, 2);
    if (parama1 == null)
    {
      AppMethodBeat.o(150049);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      AppMethodBeat.o(150049);
      return false;
    }
    AppMethodBeat.o(150049);
    return true;
  }
  
  public final void c(am.a parama1, am.a parama2)
  {
    AppMethodBeat.i(150052);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(150052);
      return;
    }
    this.gzc.d(parama1, parama2);
    this.handler.sendMessage(this.handler.obtainMessage(1, new c(parama2, parama1)));
    AppMethodBeat.o(150052);
  }
  
  public final boolean cI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150046);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      AppMethodBeat.o(150046);
      return false;
    }
    b.a locala = this.gzc.K(paramInt1, paramInt2, 1);
    if (locala == null)
    {
      AppMethodBeat.o(150046);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      AppMethodBeat.o(150046);
      return false;
    }
    AppMethodBeat.o(150046);
    return true;
  }
  
  public final boolean cJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150048);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      AppMethodBeat.o(150048);
      return false;
    }
    b.a locala = this.gzc.K(paramInt1, paramInt2, 2);
    if (locala == null)
    {
      AppMethodBeat.o(150048);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      AppMethodBeat.o(150048);
      return false;
    }
    AppMethodBeat.o(150048);
    return true;
  }
  
  public final void cK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150051);
    if (!this.initialized)
    {
      ae.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      AppMethodBeat.o(150051);
      return;
    }
    b localb = this.gzc;
    ae.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b.a locala = localb.my(paramInt1);
    if (locala == null) {
      ae.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new c(paramInt2, paramInt1)));
      AppMethodBeat.o(150051);
      return;
      b.b localb2 = localb.mz(paramInt2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        ae.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.mx(paramInt2);
        localb.gzm.put(paramInt2, localb1);
      }
      localb1.gzs.put(paramInt1, locala.dqk);
      localb.a(localb1);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(150039);
    this.initialized = true;
    this.gzc.gzp = g.ajR().ajA();
    AppMethodBeat.o(150039);
  }
  
  public final void w(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150040);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      f(paramInt, 1, str);
      AppMethodBeat.o(150040);
      return;
    }
  }
  
  public final void x(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150042);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      f(paramInt, 2, str);
      AppMethodBeat.o(150042);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void B(int paramInt, String paramString);
    
    public abstract void b(am.a parama);
  }
  
  final class b
  {
    int gzg;
    am.a gzh;
    int type;
    String value;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      this.gzg = paramInt1;
      this.type = paramInt2;
      this.value = paramString;
    }
    
    public b(am.a parama, int paramInt, String paramString)
    {
      this.gzh = parama;
      this.type = paramInt;
      this.value = paramString;
    }
  }
  
  final class c
  {
    int gzg;
    am.a gzh;
    int gzi;
    am.a gzj;
    
    public c(int paramInt1, int paramInt2)
    {
      this.gzi = paramInt1;
      this.gzg = paramInt2;
    }
    
    public c(int paramInt, am.a parama)
    {
      this.gzi = paramInt;
      this.gzh = parama;
    }
    
    public c(am.a parama1, am.a parama2)
    {
      this.gzj = parama1;
      this.gzh = parama2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.y.a
 * JD-Core Version:    0.7.0.1
 */