package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.h;
import com.tencent.e.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "actionTypeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "detectResult", "minPriorityActionType", "pendingRunTasks", "Lcom/tencent/threadpool/runnable/FutureEx;", "canShow", "", "type", "cancelAction", "", "cancelLowerPriorityAction", "checkOnOverTime", "disableAction", "forEachAction", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentAction", "targetAction", "getMinPriorityActionType", "getStatus", "(I)Ljava/lang/Integer;", "defaultStatus", "hasDetect", "hasResult", "isAllValid", "isValid", "postAction", "action", "Ljava/lang/Runnable;", "removeStatus", "reset", "setHigherPriorityActionOverTime", "updateAllStatusIfNeedOnOverTime", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "SearchHotImageAction", "SearchNormalImageAction", "app_release"})
public final class f
{
  public static final f.b WXk;
  public HashSet<Integer> WXf;
  public HashMap<Integer, a> WXg;
  public final HashMap<Integer, Integer> WXh;
  private HashMap<Integer, com.tencent.e.i.d<?>> WXi;
  private int WXj;
  
  static
  {
    AppMethodBeat.i(270192);
    WXk = new f.b((byte)0);
    AppMethodBeat.o(270192);
  }
  
  public f()
  {
    AppMethodBeat.i(270190);
    this.WXf = new HashSet();
    this.WXg = new HashMap();
    this.WXh = new HashMap();
    this.WXi = new HashMap();
    this.WXf.add(Integer.valueOf(1));
    ((Map)this.WXg).put(Integer.valueOf(1), new e(this));
    if (d.hSX())
    {
      this.WXf.add(Integer.valueOf(2));
      ((Map)this.WXg).put(Integer.valueOf(2), new d(this));
    }
    if (d.hSY())
    {
      this.WXf.add(Integer.valueOf(4));
      ((Map)this.WXg).put(Integer.valueOf(4), new g(this));
    }
    if (d.hSZ())
    {
      this.WXf.add(Integer.valueOf(3));
      ((Map)this.WXg).put(Integer.valueOf(3), new f(this));
    }
    this.WXj = hTc();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo init minPriorityActionType: %d", new Object[] { Integer.valueOf(this.WXj) });
    AppMethodBeat.o(270190);
  }
  
  private final void a(int paramInt, m<? super a, ? super a, x> paramm)
  {
    AppMethodBeat.i(270188);
    a locala1 = (a)this.WXg.get(Integer.valueOf(paramInt));
    if (locala1 == null)
    {
      AppMethodBeat.o(270188);
      return;
    }
    Iterator localIterator = ((Iterable)this.WXf).iterator();
    while (localIterator.hasNext())
    {
      paramInt = ((Number)localIterator.next()).intValue();
      a locala2 = (a)this.WXg.get(Integer.valueOf(paramInt));
      if (locala2 != null) {
        paramm.invoke(locala1, locala2);
      }
    }
    AppMethodBeat.o(270188);
  }
  
  private final void awz(int paramInt)
  {
    AppMethodBeat.i(270186);
    a(paramInt, (m)new h(this));
    AppMethodBeat.o(270186);
  }
  
  private final int hTc()
  {
    AppMethodBeat.i(270183);
    Object localObject1 = (Integer)j.f((Iterable)this.WXf);
    Object localObject2;
    if (localObject1 != null)
    {
      ((Integer)localObject1).intValue();
      localObject2 = (a)this.WXg.get(localObject1);
      if (localObject2 == null)
      {
        AppMethodBeat.o(270183);
        return 0;
      }
    }
    else
    {
      AppMethodBeat.o(270183);
      return 0;
    }
    int i = ((a)localObject2).hTe();
    int k = ((Integer)localObject1).intValue();
    localObject1 = ((Iterable)this.WXf).iterator();
    int j = 0;
    for (;;)
    {
      int m;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        m = j + 1;
        if (j < 0) {
          j.iBO();
        }
        int n = ((Number)localObject2).intValue();
        if (j == 0) {
          break label199;
        }
        localObject2 = (a)this.WXg.get(Integer.valueOf(n));
        if (localObject2 == null) {
          break label199;
        }
        if (((a)localObject2).hTe() >= i) {
          break label196;
        }
        i = ((a)localObject2).hTe();
        k = n;
      }
      label196:
      for (;;)
      {
        j = m;
        break;
        AppMethodBeat.o(270183);
        return k;
      }
      label199:
      j = m;
    }
  }
  
  public final int awu(int paramInt)
  {
    AppMethodBeat.i(270172);
    Integer localInteger = (Integer)this.WXh.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      localInteger.intValue();
      paramInt = localInteger.intValue();
      AppMethodBeat.o(270172);
      return paramInt;
    }
    AppMethodBeat.o(270172);
    return 2;
  }
  
  public final Integer awv(int paramInt)
  {
    AppMethodBeat.i(270173);
    Integer localInteger = (Integer)this.WXh.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(270173);
    return localInteger;
  }
  
  public final boolean aww(int paramInt)
  {
    AppMethodBeat.i(270175);
    paramInt = awu(paramInt);
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 7))
    {
      AppMethodBeat.o(270175);
      return true;
    }
    AppMethodBeat.o(270175);
    return false;
  }
  
  public final void awx(int paramInt)
  {
    AppMethodBeat.i(270180);
    com.tencent.e.i.d locald = (com.tencent.e.i.d)this.WXi.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d", new Object[] { Integer.valueOf(paramInt) });
      locald.cancel(false);
      AppMethodBeat.o(270180);
      return;
    }
    AppMethodBeat.o(270180);
  }
  
  public final void awy(int paramInt)
  {
    AppMethodBeat.i(270184);
    this.WXh.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(270184);
  }
  
  public final void e(final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(270179);
    p.k(paramRunnable, "action");
    a locala = (a)this.WXg.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(270179);
      return;
    }
    if (locala.bFu())
    {
      localObject = awv(paramInt);
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 4)
      {
        if (!locala.fCF()) {
          break;
        }
        Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid and run action type: %d", new Object[] { Integer.valueOf(paramInt) });
        awz(paramInt);
        paramRunnable.run();
        AppMethodBeat.o(270179);
        return;
      }
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction action not enable or overTimeLimit: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(270179);
    return;
    Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", new Object[] { Integer.valueOf(paramInt), paramRunnable, Long.valueOf(locala.hTf()) });
    awx(paramInt);
    Object localObject = (Map)this.WXi;
    paramRunnable = h.ZvG.n((Runnable)new i(this, paramInt, paramRunnable), locala.hTf());
    p.j(paramRunnable, "ThreadPool.INSTANCE.uiDe…ntAction.delayDuration())");
    ((Map)localObject).put(Integer.valueOf(paramInt), paramRunnable);
    AppMethodBeat.o(270179);
  }
  
  public final boolean hTb()
  {
    AppMethodBeat.i(270182);
    boolean bool = uB(this.WXj);
    AppMethodBeat.o(270182);
    return bool;
  }
  
  public final void mA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270171);
    if ((a)this.WXg.get(Integer.valueOf(paramInt1)) == null)
    {
      AppMethodBeat.o(270171);
      return;
    }
    Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Integer localInteger = awv(paramInt1);
    if (localInteger == null) {}
    while (localInteger.intValue() != 4)
    {
      ((Map)this.WXh).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(270171);
      return;
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d over time limit, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 == 1) || (paramInt2 == 3)) {
      ((Map)this.WXh).put(Integer.valueOf(paramInt1), Integer.valueOf(7));
    }
    AppMethodBeat.o(270171);
  }
  
  public final boolean qt(int paramInt)
  {
    AppMethodBeat.i(270177);
    if (paramInt == 2)
    {
      if (awu(2) == 1)
      {
        AppMethodBeat.o(270177);
        return true;
      }
      AppMethodBeat.o(270177);
      return false;
    }
    a locala = (a)this.WXg.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(270177);
      return false;
    }
    boolean bool = locala.hTd();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(270177);
    return bool;
  }
  
  public final boolean uB(int paramInt)
  {
    AppMethodBeat.i(270181);
    a locala = (a)this.WXg.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(270181);
      return false;
    }
    if ((locala.bFu()) && (locala.fCF()))
    {
      AppMethodBeat.o(270181);
      return true;
    }
    AppMethodBeat.o(270181);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "delayDuration", "", "enable", "", "getType", "", "priority", "setEnable", "", "show", "valid", "app_release"})
  public static abstract interface a
  {
    public abstract boolean bFu();
    
    public abstract boolean fCF();
    
    public abstract int getType();
    
    public abstract boolean hTd();
    
    public abstract int hTe();
    
    public abstract long hTf();
    
    public abstract void setEnable(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "isEnable", "", "delayDuration", "", "enable", "getType", "", "setEnable", "", "show", "valid", "app_release"})
  static abstract class c
    implements f.a
  {
    private f WXl;
    private boolean dih;
    
    public c(f paramf)
    {
      this.WXl = paramf;
      this.dih = true;
    }
    
    public final boolean bFu()
    {
      return this.dih;
    }
    
    public final boolean fCF()
    {
      Integer localInteger = f.a(this.WXl, getType());
      label35:
      int i;
      Object localObject;
      if (localInteger != null)
      {
        bool = true;
        Iterator localIterator = ((Iterable)f.a(this.WXl)).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          i = ((Number)localIterator.next()).intValue();
          localObject = (f.a)f.b(this.WXl).get(Integer.valueOf(i));
        } while ((localObject == null) || (hTe() >= ((f.a)localObject).hTe()));
        localObject = f.a(this.WXl, i);
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
    
    public int getType()
    {
      return 0;
    }
    
    public final boolean hTd()
    {
      if (this.WXl.awu(getType()) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() status: %s, canShow: %s, getType: %d", new Object[] { f.a(this.WXl, getType()), Boolean.valueOf(bool1), Integer.valueOf(getType()) });
        if (bool1) {
          break;
        }
        return false;
      }
      Iterator localIterator = ((Iterable)f.a(this.WXl)).iterator();
      boolean bool2 = bool1;
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        f.a locala = (f.a)f.b(this.WXl).get(Integer.valueOf(i));
        if ((locala != null) && (hTe() < locala.hTe()))
        {
          if (this.WXl.awu(i) == 1)
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
    
    public long hTf()
    {
      return 1000L;
    }
    
    public final void setEnable(boolean paramBoolean)
    {
      this.dih = paramBoolean;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class d
    extends f.c
  {
    public d(f paramf)
    {
      super();
      AppMethodBeat.i(258272);
      AppMethodBeat.o(258272);
    }
    
    public final int getType()
    {
      return 2;
    }
    
    public final int hTe()
    {
      return 4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class e
    extends f.c
  {
    public e(f paramf)
    {
      super();
      AppMethodBeat.i(285664);
      AppMethodBeat.o(285664);
    }
    
    public final int getType()
    {
      return 1;
    }
    
    public final int hTe()
    {
      return 2;
    }
    
    public final long hTf()
    {
      return 2000L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchHotImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"})
  static final class f
    extends f.c
  {
    public f(f paramf)
    {
      super();
      AppMethodBeat.i(271696);
      AppMethodBeat.o(271696);
    }
    
    public final int getType()
    {
      return 3;
    }
    
    public final int hTe()
    {
      return 3;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchNormalImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"})
  static final class g
    extends f.c
  {
    public g(f paramf)
    {
      super();
      AppMethodBeat.i(282163);
      AppMethodBeat.o(282163);
    }
    
    public final int getType()
    {
      return 4;
    }
    
    public final int hTe()
    {
      return 1;
    }
    
    public final long hTf()
    {
      return 2000L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class h
    extends q
    implements m<f.a, f.a, x>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(f paramf, int paramInt, Runnable paramRunnable) {}
    
    public final void run()
    {
      AppMethodBeat.i(272784);
      f.b(this.WXm, paramInt);
      paramRunnable.run();
      AppMethodBeat.o(272784);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
  static final class j
    extends q
    implements m<f.a, f.a, x>
  {
    j(f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.f
 * JD-Core Version:    0.7.0.1
 */