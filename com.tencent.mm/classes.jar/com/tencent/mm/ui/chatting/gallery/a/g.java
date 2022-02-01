package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "actionTypeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "detectResult", "minPriorityActionType", "pendingRunTasks", "Lcom/tencent/threadpool/runnable/FutureEx;", "canShow", "", "type", "cancelAction", "", "cancelLowerPriorityAction", "checkOnOverTime", "disableAction", "forEachAction", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentAction", "targetAction", "getMinPriorityActionType", "getStatus", "(I)Ljava/lang/Integer;", "defaultStatus", "isAllValid", "isValid", "postAction", "action", "Ljava/lang/Runnable;", "removeStatus", "reset", "setHigherPriorityActionOverTime", "updateAllStatusIfNeedOnOverTime", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "SearchHotImageAction", "SearchNormalImageAction", "app_release"})
public final class g
{
  public static final g.b PCo;
  public HashSet<Integer> PCj;
  public HashMap<Integer, a> PCk;
  public final HashMap<Integer, Integer> PCl;
  private HashMap<Integer, d<?>> PCm;
  private int PCn;
  
  static
  {
    AppMethodBeat.i(231258);
    PCo = new g.b((byte)0);
    AppMethodBeat.o(231258);
  }
  
  public g()
  {
    AppMethodBeat.i(231257);
    this.PCj = new HashSet();
    this.PCk = new HashMap();
    this.PCl = new HashMap();
    this.PCm = new HashMap();
    this.PCj.add(Integer.valueOf(1));
    ((Map)this.PCk).put(Integer.valueOf(1), new e(this));
    if (e.gTr())
    {
      this.PCj.add(Integer.valueOf(2));
      ((Map)this.PCk).put(Integer.valueOf(2), new d(this));
    }
    if (e.gTs())
    {
      this.PCj.add(Integer.valueOf(4));
      ((Map)this.PCk).put(Integer.valueOf(4), new g(this));
    }
    if (e.gTt())
    {
      this.PCj.add(Integer.valueOf(3));
      ((Map)this.PCk).put(Integer.valueOf(3), new f(this));
    }
    this.PCn = gTw();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo init minPriorityActionType: %d", new Object[] { Integer.valueOf(this.PCn) });
    AppMethodBeat.o(231257);
  }
  
  private final void a(int paramInt, m<? super a, ? super a, x> paramm)
  {
    AppMethodBeat.i(231256);
    a locala1 = (a)this.PCk.get(Integer.valueOf(paramInt));
    if (locala1 == null)
    {
      AppMethodBeat.o(231256);
      return;
    }
    Iterator localIterator = ((Iterable)this.PCj).iterator();
    while (localIterator.hasNext())
    {
      paramInt = ((Number)localIterator.next()).intValue();
      a locala2 = (a)this.PCk.get(Integer.valueOf(paramInt));
      if (locala2 != null) {
        paramm.invoke(locala1, locala2);
      }
    }
    AppMethodBeat.o(231256);
  }
  
  private final void anw(int paramInt)
  {
    AppMethodBeat.i(231255);
    a(paramInt, (m)new h(this));
    AppMethodBeat.o(231255);
  }
  
  private final int gTw()
  {
    AppMethodBeat.i(231253);
    Object localObject1 = (Integer)j.f((Iterable)this.PCj);
    Object localObject2;
    if (localObject1 != null)
    {
      ((Integer)localObject1).intValue();
      localObject2 = (a)this.PCk.get(localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(231253);
        return 0;
      }
    }
    else
    {
      AppMethodBeat.o(231253);
      return 0;
    }
    int i = ((a)localObject2).gTy();
    int k = ((Integer)localObject1).intValue();
    localObject1 = ((Iterable)this.PCj).iterator();
    int j = 0;
    for (;;)
    {
      int m;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        m = j + 1;
        if (j < 0) {
          j.hxH();
        }
        int n = ((Number)localObject2).intValue();
        if (j == 0) {
          break label199;
        }
        localObject2 = (a)this.PCk.get(Integer.valueOf(n));
        if (localObject2 == null) {
          break label199;
        }
        if (((a)localObject2).gTy() >= i) {
          break label196;
        }
        i = ((a)localObject2).gTy();
        k = n;
      }
      label196:
      for (;;)
      {
        j = m;
        break;
        AppMethodBeat.o(231253);
        return k;
      }
      label199:
      j = m;
    }
  }
  
  public final int ans(int paramInt)
  {
    AppMethodBeat.i(231246);
    Integer localInteger = (Integer)this.PCl.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      localInteger.intValue();
      paramInt = localInteger.intValue();
      AppMethodBeat.o(231246);
      return paramInt;
    }
    AppMethodBeat.o(231246);
    return 2;
  }
  
  public final Integer ant(int paramInt)
  {
    AppMethodBeat.i(231247);
    Integer localInteger = (Integer)this.PCl.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(231247);
    return localInteger;
  }
  
  public final void anu(int paramInt)
  {
    AppMethodBeat.i(231250);
    d locald = (d)this.PCm.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d", new Object[] { Integer.valueOf(paramInt) });
      locald.cancel(false);
      AppMethodBeat.o(231250);
      return;
    }
    AppMethodBeat.o(231250);
  }
  
  public final void anv(int paramInt)
  {
    AppMethodBeat.i(231254);
    this.PCl.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(231254);
  }
  
  public final void e(final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(231249);
    p.h(paramRunnable, "action");
    a locala = (a)this.PCk.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(231249);
      return;
    }
    if (locala.enable())
    {
      localObject = ant(paramInt);
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 4)
      {
        if (!locala.valid()) {
          break;
        }
        Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid and run action type: %d", new Object[] { Integer.valueOf(paramInt) });
        anw(paramInt);
        paramRunnable.run();
        AppMethodBeat.o(231249);
        return;
      }
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction action not enable or overTimeLimit: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(231249);
    return;
    Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", new Object[] { Integer.valueOf(paramInt), paramRunnable, Long.valueOf(locala.gTz()) });
    anu(paramInt);
    Object localObject = (Map)this.PCm;
    paramRunnable = h.RTc.n((Runnable)new i(this, paramInt, paramRunnable), locala.gTz());
    p.g(paramRunnable, "ThreadPool.INSTANCE.uiDe…ntAction.delayDuration())");
    ((Map)localObject).put(Integer.valueOf(paramInt), paramRunnable);
    AppMethodBeat.o(231249);
  }
  
  public final boolean gTv()
  {
    AppMethodBeat.i(231252);
    boolean bool = isValid(this.PCn);
    AppMethodBeat.o(231252);
    return bool;
  }
  
  public final boolean isValid(int paramInt)
  {
    AppMethodBeat.i(231251);
    a locala = (a)this.PCk.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(231251);
      return false;
    }
    if ((locala.enable()) && (locala.valid()))
    {
      AppMethodBeat.o(231251);
      return true;
    }
    AppMethodBeat.o(231251);
    return false;
  }
  
  public final void li(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231245);
    if ((a)this.PCk.get(Integer.valueOf(paramInt1)) == null)
    {
      AppMethodBeat.o(231245);
      return;
    }
    Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Integer localInteger = ant(paramInt1);
    if (localInteger == null) {}
    while (localInteger.intValue() != 4)
    {
      ((Map)this.PCl).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(231245);
      return;
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d over time limit", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(231245);
  }
  
  public final boolean oe(int paramInt)
  {
    AppMethodBeat.i(231248);
    if (paramInt == 2)
    {
      if (ans(2) == 1)
      {
        AppMethodBeat.o(231248);
        return true;
      }
      AppMethodBeat.o(231248);
      return false;
    }
    a locala = (a)this.PCk.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(231248);
      return false;
    }
    boolean bool = locala.gTx();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(231248);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "delayDuration", "", "enable", "", "getType", "", "priority", "setEnable", "", "show", "valid", "app_release"})
  public static abstract interface a
  {
    public abstract boolean enable();
    
    public abstract boolean gTx();
    
    public abstract int gTy();
    
    public abstract long gTz();
    
    public abstract int getType();
    
    public abstract void setEnable(boolean paramBoolean);
    
    public abstract boolean valid();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "isEnable", "", "delayDuration", "", "enable", "getType", "", "setEnable", "", "show", "valid", "app_release"})
  static abstract class c
    implements g.a
  {
    private g PCp;
    private boolean ded;
    
    public c(g paramg)
    {
      this.PCp = paramg;
      this.ded = true;
    }
    
    public final boolean enable()
    {
      return this.ded;
    }
    
    public final boolean gTx()
    {
      if (this.PCp.ans(getType()) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() status: %s, canShow: %s, getType: %d", new Object[] { g.a(this.PCp, getType()), Boolean.valueOf(bool1), Integer.valueOf(getType()) });
        if (bool1) {
          break;
        }
        return false;
      }
      Iterator localIterator = ((Iterable)g.a(this.PCp)).iterator();
      boolean bool2 = bool1;
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        g.a locala = (g.a)g.b(this.PCp).get(Integer.valueOf(i));
        if ((locala != null) && (gTy() < locala.gTy()))
        {
          if (this.PCp.ans(i) == 1)
          {
            bool1 = true;
            label165:
            Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() actionType: %d, actionCanShow: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if ((!bool2) || (bool1)) {
              break label213;
            }
          }
          label213:
          for (bool1 = true;; bool1 = false)
          {
            bool2 = bool1;
            if (bool1) {
              break;
            }
            return false;
            bool1 = false;
            break label165;
          }
        }
      }
      return bool2;
    }
    
    public long gTz()
    {
      return 1000L;
    }
    
    public int getType()
    {
      return 0;
    }
    
    public final void setEnable(boolean paramBoolean)
    {
      this.ded = paramBoolean;
    }
    
    public final boolean valid()
    {
      Integer localInteger = g.a(this.PCp, getType());
      label35:
      int i;
      Object localObject;
      if (localInteger != null)
      {
        bool = true;
        Iterator localIterator = ((Iterable)g.a(this.PCp)).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          i = ((Number)localIterator.next()).intValue();
          localObject = (g.a)g.b(this.PCp).get(Integer.valueOf(i));
        } while ((localObject == null) || (gTy() >= ((g.a)localObject).gTy()));
        localObject = g.a(this.PCp, i);
        if ((!bool) || (localObject == null)) {
          break label149;
        }
      }
      label149:
      for (boolean bool = true;; bool = false)
      {
        Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() actionType: %s, status: %s", new Object[] { Integer.valueOf(i), localObject });
        break label35;
        bool = false;
        break;
      }
      Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() currentType: %d, currentStatus: %s, valid: %b", new Object[] { Integer.valueOf(getType()), localInteger, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class d
    extends g.c
  {
    public d(g paramg)
    {
      super();
      AppMethodBeat.i(231238);
      AppMethodBeat.o(231238);
    }
    
    public final int gTy()
    {
      return 4;
    }
    
    public final int getType()
    {
      return 2;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class e
    extends g.c
  {
    public e(g paramg)
    {
      super();
      AppMethodBeat.i(231239);
      AppMethodBeat.o(231239);
    }
    
    public final int gTy()
    {
      return 2;
    }
    
    public final long gTz()
    {
      return 2000L;
    }
    
    public final int getType()
    {
      return 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchHotImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class f
    extends g.c
  {
    public f(g paramg)
    {
      super();
      AppMethodBeat.i(231240);
      AppMethodBeat.o(231240);
    }
    
    public final int gTy()
    {
      return 3;
    }
    
    public final int getType()
    {
      return 3;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchNormalImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class g
    extends g.c
  {
    public g(g paramg)
    {
      super();
      AppMethodBeat.i(231241);
      AppMethodBeat.o(231241);
    }
    
    public final int gTy()
    {
      return 1;
    }
    
    public final long gTz()
    {
      return 2000L;
    }
    
    public final int getType()
    {
      return 4;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class h
    extends q
    implements m<g.a, g.a, x>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(g paramg, int paramInt, Runnable paramRunnable) {}
    
    public final void run()
    {
      AppMethodBeat.i(231243);
      g.b(this.PCq, paramInt);
      paramRunnable.run();
      AppMethodBeat.o(231243);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class j
    extends q
    implements m<g.a, g.a, x>
  {
    j(g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.g
 * JD-Core Version:    0.7.0.1
 */