package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "actionTypeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "detectResult", "minPriorityActionType", "pendingRunTasks", "Lcom/tencent/threadpool/runnable/FutureEx;", "canShow", "", "type", "cancelAction", "", "cancelLowerPriorityAction", "checkOnOverTime", "disableAction", "forEachAction", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentAction", "targetAction", "getMinPriorityActionType", "getStatus", "(I)Ljava/lang/Integer;", "defaultStatus", "isAllValid", "isValid", "postAction", "action", "Ljava/lang/Runnable;", "removeStatus", "reset", "setHigherPriorityActionOverTime", "updateAllStatusIfNeedOnOverTime", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "SearchHotImageAction", "SearchNormalImageAction", "app_release"})
public final class g
{
  public static final g.b Kqf;
  public HashSet<Integer> Kqa;
  public HashMap<Integer, a> Kqb;
  public final HashMap<Integer, Integer> Kqc;
  private HashMap<Integer, d<?>> Kqd;
  private int Kqe;
  
  static
  {
    AppMethodBeat.i(188306);
    Kqf = new g.b((byte)0);
    AppMethodBeat.o(188306);
  }
  
  public g()
  {
    AppMethodBeat.i(188305);
    this.Kqa = new HashSet();
    this.Kqb = new HashMap();
    this.Kqc = new HashMap();
    this.Kqd = new HashMap();
    this.Kqa.add(Integer.valueOf(1));
    ((Map)this.Kqb).put(Integer.valueOf(1), new e(this));
    if (e.fKZ())
    {
      this.Kqa.add(Integer.valueOf(2));
      ((Map)this.Kqb).put(Integer.valueOf(2), new d(this));
    }
    if (e.fLa())
    {
      this.Kqa.add(Integer.valueOf(4));
      ((Map)this.Kqb).put(Integer.valueOf(4), new g(this));
    }
    if (e.fLb())
    {
      this.Kqa.add(Integer.valueOf(3));
      ((Map)this.Kqb).put(Integer.valueOf(3), new f(this));
    }
    this.Kqe = fLe();
    ae.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo init minPriorityActionType: %d", new Object[] { Integer.valueOf(this.Kqe) });
    AppMethodBeat.o(188305);
  }
  
  private final void a(int paramInt, m<? super a, ? super a, z> paramm)
  {
    AppMethodBeat.i(188304);
    a locala1 = (a)this.Kqb.get(Integer.valueOf(paramInt));
    if (locala1 == null)
    {
      AppMethodBeat.o(188304);
      return;
    }
    Iterator localIterator = ((Iterable)this.Kqa).iterator();
    while (localIterator.hasNext())
    {
      paramInt = ((Number)localIterator.next()).intValue();
      a locala2 = (a)this.Kqb.get(Integer.valueOf(paramInt));
      if (locala2 != null) {
        paramm.p(locala1, locala2);
      }
    }
    AppMethodBeat.o(188304);
  }
  
  private final void aeL(int paramInt)
  {
    AppMethodBeat.i(188303);
    a(paramInt, (m)new h(this));
    AppMethodBeat.o(188303);
  }
  
  private final int fLe()
  {
    AppMethodBeat.i(188301);
    Object localObject1 = (Integer)j.d((Iterable)this.Kqa);
    Object localObject2;
    if (localObject1 != null)
    {
      ((Integer)localObject1).intValue();
      localObject2 = (a)this.Kqb.get(localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(188301);
        return 0;
      }
    }
    else
    {
      AppMethodBeat.o(188301);
      return 0;
    }
    int i = ((a)localObject2).fLg();
    int k = ((Integer)localObject1).intValue();
    localObject1 = ((Iterable)this.Kqa).iterator();
    int j = 0;
    for (;;)
    {
      int m;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        m = j + 1;
        if (j < 0) {
          j.gkd();
        }
        int n = ((Number)localObject2).intValue();
        if (j == 0) {
          break label199;
        }
        localObject2 = (a)this.Kqb.get(Integer.valueOf(n));
        if (localObject2 == null) {
          break label199;
        }
        if (((a)localObject2).fLg() >= i) {
          break label196;
        }
        i = ((a)localObject2).fLg();
        k = n;
      }
      label196:
      for (;;)
      {
        j = m;
        break;
        AppMethodBeat.o(188301);
        return k;
      }
      label199:
      j = m;
    }
  }
  
  public final int aeI(int paramInt)
  {
    AppMethodBeat.i(188295);
    Integer localInteger = (Integer)this.Kqc.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      localInteger.intValue();
      paramInt = localInteger.intValue();
      AppMethodBeat.o(188295);
      return paramInt;
    }
    AppMethodBeat.o(188295);
    return 2;
  }
  
  public final void aeJ(int paramInt)
  {
    AppMethodBeat.i(188298);
    d locald = (d)this.Kqd.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      ae.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d", new Object[] { Integer.valueOf(paramInt) });
      locald.cancel(false);
      AppMethodBeat.o(188298);
      return;
    }
    AppMethodBeat.o(188298);
  }
  
  public final void aeK(int paramInt)
  {
    AppMethodBeat.i(188302);
    this.Kqc.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(188302);
  }
  
  public final Integer amN(int paramInt)
  {
    AppMethodBeat.i(224199);
    Integer localInteger = (Integer)this.Kqc.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(224199);
    return localInteger;
  }
  
  public final void e(final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(188297);
    p.h(paramRunnable, "action");
    a locala = (a)this.Kqb.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(188297);
      return;
    }
    if (locala.enable())
    {
      localObject = amN(paramInt);
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 4)
      {
        if (!locala.valid()) {
          break;
        }
        ae.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid and run action type: %d", new Object[] { Integer.valueOf(paramInt) });
        aeL(paramInt);
        paramRunnable.run();
        AppMethodBeat.o(188297);
        return;
      }
    }
    ae.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction action not enable or overTimeLimit: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(188297);
    return;
    ae.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", new Object[] { Integer.valueOf(paramInt), paramRunnable, Long.valueOf(locala.fLh()) });
    aeJ(paramInt);
    Object localObject = (Map)this.Kqd;
    paramRunnable = h.MqF.q((Runnable)new j(this, paramInt, paramRunnable), locala.fLh());
    p.g(paramRunnable, "ThreadPool.INSTANCE.uiDe…ntAction.delayDuration())");
    ((Map)localObject).put(Integer.valueOf(paramInt), paramRunnable);
    AppMethodBeat.o(188297);
  }
  
  public final boolean fLd()
  {
    AppMethodBeat.i(188300);
    boolean bool = isValid(this.Kqe);
    AppMethodBeat.o(188300);
    return bool;
  }
  
  public final boolean isValid(int paramInt)
  {
    AppMethodBeat.i(188299);
    a locala = (a)this.Kqb.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(188299);
      return false;
    }
    if ((locala.enable()) && (locala.valid()))
    {
      AppMethodBeat.o(188299);
      return true;
    }
    AppMethodBeat.o(188299);
    return false;
  }
  
  public final void jY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188294);
    if ((a)this.Kqb.get(Integer.valueOf(paramInt1)) == null)
    {
      AppMethodBeat.o(188294);
      return;
    }
    ae.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Integer localInteger = amN(paramInt1);
    if (localInteger == null) {}
    while (localInteger.intValue() != 4)
    {
      ((Map)this.Kqc).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(188294);
      return;
    }
    ae.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d over time limit", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(188294);
  }
  
  public final boolean lc(int paramInt)
  {
    AppMethodBeat.i(188296);
    if (paramInt == 2)
    {
      if (aeI(2) == 1)
      {
        AppMethodBeat.o(188296);
        return true;
      }
      AppMethodBeat.o(188296);
      return false;
    }
    a locala = (a)this.Kqb.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(188296);
      return false;
    }
    boolean bool = locala.fLf();
    ae.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(188296);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "delayDuration", "", "enable", "", "getType", "", "priority", "setEnable", "", "show", "valid", "app_release"})
  public static abstract interface a
  {
    public abstract boolean enable();
    
    public abstract boolean fLf();
    
    public abstract int fLg();
    
    public abstract long fLh();
    
    public abstract int getType();
    
    public abstract void setEnable(boolean paramBoolean);
    
    public abstract boolean valid();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "isEnable", "", "delayDuration", "", "enable", "getType", "", "setEnable", "", "show", "valid", "app_release"})
  static abstract class c
    implements g.a
  {
    private g Kqg;
    private boolean cNF;
    
    public c(g paramg)
    {
      this.Kqg = paramg;
      this.cNF = true;
    }
    
    public final boolean enable()
    {
      return this.cNF;
    }
    
    public final boolean fLf()
    {
      if (this.Kqg.aeI(getType()) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() status: %s, canShow: %s, getType: %d", new Object[] { g.a(this.Kqg, getType()), Boolean.valueOf(bool1), Integer.valueOf(getType()) });
        if (bool1) {
          break;
        }
        return false;
      }
      Iterator localIterator = ((Iterable)g.a(this.Kqg)).iterator();
      boolean bool2 = bool1;
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        g.a locala = (g.a)g.b(this.Kqg).get(Integer.valueOf(i));
        if ((locala != null) && (fLg() < locala.fLg()))
        {
          if (this.Kqg.aeI(i) == 1)
          {
            bool1 = true;
            label165:
            ae.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() actionType: %d, actionCanShow: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
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
    
    public long fLh()
    {
      return 1000L;
    }
    
    public int getType()
    {
      return 0;
    }
    
    public final void setEnable(boolean paramBoolean)
    {
      this.cNF = paramBoolean;
    }
    
    public final boolean valid()
    {
      Integer localInteger = g.a(this.Kqg, getType());
      label35:
      int i;
      Object localObject;
      if (localInteger != null)
      {
        bool = true;
        Iterator localIterator = ((Iterable)g.a(this.Kqg)).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          i = ((Number)localIterator.next()).intValue();
          localObject = (g.a)g.b(this.Kqg).get(Integer.valueOf(i));
        } while ((localObject == null) || (fLg() >= ((g.a)localObject).fLg()));
        localObject = g.a(this.Kqg, i);
        if ((!bool) || (localObject == null)) {
          break label149;
        }
      }
      label149:
      for (boolean bool = true;; bool = false)
      {
        ae.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() actionType: %s, status: %s", new Object[] { Integer.valueOf(i), localObject });
        break label35;
        bool = false;
        break;
      }
      ae.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() currentType: %d, currentStatus: %s, valid: %b", new Object[] { Integer.valueOf(getType()), localInteger, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class d
    extends g.c
  {
    public d(g paramg)
    {
      super();
      AppMethodBeat.i(188287);
      AppMethodBeat.o(188287);
    }
    
    public final int fLg()
    {
      return 4;
    }
    
    public final int getType()
    {
      return 2;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class e
    extends g.c
  {
    public e(g paramg)
    {
      super();
      AppMethodBeat.i(188288);
      AppMethodBeat.o(188288);
    }
    
    public final int fLg()
    {
      return 2;
    }
    
    public final long fLh()
    {
      return 2000L;
    }
    
    public final int getType()
    {
      return 1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchHotImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class f
    extends g.c
  {
    public f(g paramg)
    {
      super();
      AppMethodBeat.i(188289);
      AppMethodBeat.o(188289);
    }
    
    public final int fLg()
    {
      return 3;
    }
    
    public final int getType()
    {
      return 3;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchNormalImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class g
    extends g.c
  {
    public g(g paramg)
    {
      super();
      AppMethodBeat.i(188290);
      AppMethodBeat.o(188290);
    }
    
    public final int fLg()
    {
      return 1;
    }
    
    public final long fLh()
    {
      return 2000L;
    }
    
    public final int getType()
    {
      return 4;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class h
    extends q
    implements m<g.a, g.a, z>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class i
    extends q
    implements m<g.a, g.a, z>
  {
    i(g paramg, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(g paramg, int paramInt, Runnable paramRunnable) {}
    
    public final void run()
    {
      AppMethodBeat.i(188293);
      g.b(this.Kqh, paramInt);
      paramRunnable.run();
      AppMethodBeat.o(188293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.g
 * JD-Core Version:    0.7.0.1
 */