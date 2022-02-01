package com.tencent.mm.ui.chatting.gallery.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "actionTypeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "detectResult", "minPriorityActionType", "pendingRunTasks", "Lcom/tencent/threadpool/runnable/FutureEx;", "canShow", "", "type", "cancelAction", "", "cancelLowerPriorityAction", "checkOnOverTime", "disableAction", "forEachAction", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentAction", "targetAction", "getMinPriorityActionType", "getStatus", "(I)Ljava/lang/Integer;", "defaultStatus", "hasDetect", "hasResult", "isAllValid", "isValid", "postAction", "action", "Ljava/lang/Runnable;", "removeStatus", "reset", "setHigherPriorityActionOverTime", "updateAllStatusIfNeedOnOverTime", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "SearchHotImageAction", "SearchNormalImageAction", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.b aeGI;
  public HashSet<Integer> aeGJ;
  public HashMap<Integer, a> aeGK;
  public final HashMap<Integer, Integer> aeGL;
  private HashMap<Integer, com.tencent.threadpool.i.d<?>> aeGM;
  private int aeGN;
  
  static
  {
    AppMethodBeat.i(254845);
    aeGI = new f.b((byte)0);
    AppMethodBeat.o(254845);
  }
  
  public f()
  {
    AppMethodBeat.i(254815);
    this.aeGJ = new HashSet();
    this.aeGK = new HashMap();
    this.aeGL = new HashMap();
    this.aeGM = new HashMap();
    this.aeGJ.add(Integer.valueOf(1));
    ((Map)this.aeGK).put(Integer.valueOf(1), new e(this));
    if (d.jwA())
    {
      this.aeGJ.add(Integer.valueOf(2));
      ((Map)this.aeGK).put(Integer.valueOf(2), new d(this));
    }
    if (d.jwB())
    {
      this.aeGJ.add(Integer.valueOf(4));
      ((Map)this.aeGK).put(Integer.valueOf(4), new g(this));
    }
    if (d.jwC())
    {
      this.aeGJ.add(Integer.valueOf(3));
      ((Map)this.aeGK).put(Integer.valueOf(3), new f(this));
    }
    this.aeGN = jwF();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo init minPriorityActionType: %d", new Object[] { Integer.valueOf(this.aeGN) });
    AppMethodBeat.o(254815);
  }
  
  private final void a(int paramInt, m<? super a, ? super a, ah> paramm)
  {
    AppMethodBeat.i(254824);
    a locala1 = (a)this.aeGK.get(Integer.valueOf(paramInt));
    if (locala1 == null)
    {
      AppMethodBeat.o(254824);
      return;
    }
    Iterator localIterator = ((Iterable)this.aeGJ).iterator();
    while (localIterator.hasNext())
    {
      paramInt = ((Number)localIterator.next()).intValue();
      a locala2 = (a)this.aeGK.get(Integer.valueOf(paramInt));
      if (locala2 != null) {
        paramm.invoke(locala1, locala2);
      }
    }
    AppMethodBeat.o(254824);
  }
  
  private static final void a(f paramf, final int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(254828);
    s.u(paramf, "this$0");
    s.u(paramRunnable, "$action");
    paramf.a(paramInt, (m)new i(paramf, paramInt));
    paramRunnable.run();
    AppMethodBeat.o(254828);
  }
  
  private final int jwF()
  {
    AppMethodBeat.i(254818);
    Object localObject1 = (Integer)p.f((Iterable)this.aeGJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(254818);
      return 0;
    }
    ((Integer)localObject1).intValue();
    Object localObject2 = (a)this.aeGK.get(localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(254818);
      return 0;
    }
    int i = ((a)localObject2).hkG();
    int k = ((Integer)localObject1).intValue();
    localObject1 = ((Iterable)this.aeGJ).iterator();
    int j = 0;
    for (;;)
    {
      int m;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        m = j + 1;
        if (j < 0) {
          p.kkW();
        }
        int n = ((Number)localObject2).intValue();
        if (j == 0) {
          break label199;
        }
        localObject2 = (a)this.aeGK.get(Integer.valueOf(n));
        if (localObject2 == null) {
          break label199;
        }
        if (((a)localObject2).hkG() >= i) {
          break label196;
        }
        i = ((a)localObject2).hkG();
        k = n;
      }
      label196:
      for (;;)
      {
        j = m;
        break;
        AppMethodBeat.o(254818);
        return k;
      }
      label199:
      j = m;
    }
  }
  
  public final int aDe(int paramInt)
  {
    AppMethodBeat.i(254863);
    Integer localInteger = (Integer)this.aeGL.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(254863);
      return 2;
    }
    localInteger.intValue();
    paramInt = localInteger.intValue();
    AppMethodBeat.o(254863);
    return paramInt;
  }
  
  public final Integer aDf(int paramInt)
  {
    AppMethodBeat.i(254873);
    Integer localInteger = (Integer)this.aeGL.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(254873);
    return localInteger;
  }
  
  public final boolean aDg(int paramInt)
  {
    AppMethodBeat.i(254878);
    paramInt = aDe(paramInt);
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 7))
    {
      AppMethodBeat.o(254878);
      return true;
    }
    AppMethodBeat.o(254878);
    return false;
  }
  
  public final void aDh(int paramInt)
  {
    AppMethodBeat.i(254892);
    com.tencent.threadpool.i.d locald = (com.tencent.threadpool.i.d)this.aeGM.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d", new Object[] { Integer.valueOf(paramInt) });
      locald.cancel(false);
    }
    AppMethodBeat.o(254892);
  }
  
  public final void aDi(int paramInt)
  {
    AppMethodBeat.i(254903);
    this.aeGL.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(254903);
  }
  
  public final void e(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(254888);
    s.u(paramRunnable, "action");
    a locala = (a)this.aeGK.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(254888);
      return;
    }
    if (locala.ceR())
    {
      localObject = aDf(paramInt);
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 4)
      {
        if (!locala.boj()) {
          break;
        }
        Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid and run action type: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramInt, (m)new h(this));
        paramRunnable.run();
        AppMethodBeat.o(254888);
        return;
      }
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction action not enable or overTimeLimit: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(254888);
    return;
    Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", new Object[] { Integer.valueOf(paramInt), paramRunnable, Long.valueOf(locala.jwG()) });
    aDh(paramInt);
    Object localObject = (Map)this.aeGM;
    paramRunnable = h.ahAA.o(new f..ExternalSyntheticLambda0(this, paramInt, paramRunnable), locala.jwG());
    s.s(paramRunnable, "INSTANCE.uiDelay({\n     …ntAction.delayDuration())");
    ((Map)localObject).put(Integer.valueOf(paramInt), paramRunnable);
    AppMethodBeat.o(254888);
  }
  
  public final boolean jwE()
  {
    AppMethodBeat.i(254899);
    boolean bool = uB(this.aeGN);
    AppMethodBeat.o(254899);
    return bool;
  }
  
  public final void ou(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254860);
    if ((a)this.aeGK.get(Integer.valueOf(paramInt1)) == null)
    {
      AppMethodBeat.o(254860);
      return;
    }
    Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Integer localInteger = aDf(paramInt1);
    if (localInteger == null) {}
    while (localInteger.intValue() != 4)
    {
      ((Map)this.aeGL).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(254860);
      return;
    }
    Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d over time limit, status: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(254860);
      return;
      ((Map)this.aeGL).put(Integer.valueOf(paramInt1), Integer.valueOf(7));
    }
  }
  
  public final boolean qt(int paramInt)
  {
    AppMethodBeat.i(254882);
    if (paramInt == 2)
    {
      if (aDe(2) == 1)
      {
        AppMethodBeat.o(254882);
        return true;
      }
      AppMethodBeat.o(254882);
      return false;
    }
    a locala = (a)this.aeGK.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(254882);
      return false;
    }
    boolean bool = locala.cMz();
    Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(254882);
    return bool;
  }
  
  public final boolean uB(int paramInt)
  {
    AppMethodBeat.i(254896);
    a locala = (a)this.aeGK.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(254896);
      return false;
    }
    if ((locala.ceR()) && (locala.boj()))
    {
      AppMethodBeat.o(254896);
      return true;
    }
    AppMethodBeat.o(254896);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "delayDuration", "", "enable", "", "getType", "", "priority", "setEnable", "", "show", "valid", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean boj();
    
    public abstract boolean cMz();
    
    public abstract boolean ceR();
    
    public abstract int getType();
    
    public abstract int hkG();
    
    public abstract long jwG();
    
    public abstract void setEnable(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "isEnable", "", "delayDuration", "", "enable", "getType", "", "setEnable", "", "show", "valid", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract class c
    implements f.a
  {
    private f aeGO;
    private boolean egk;
    
    public c(f paramf)
    {
      this.aeGO = paramf;
      this.egk = true;
    }
    
    public final boolean boj()
    {
      Integer localInteger = f.a(this.aeGO, getType());
      label35:
      int i;
      Object localObject;
      if (localInteger != null)
      {
        bool = true;
        Iterator localIterator = ((Iterable)f.a(this.aeGO)).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          i = ((Number)localIterator.next()).intValue();
          localObject = (f.a)f.b(this.aeGO).get(Integer.valueOf(i));
        } while ((localObject == null) || (hkG() >= ((f.a)localObject).hkG()));
        localObject = f.a(this.aeGO, i);
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
    
    public final boolean cMz()
    {
      if (this.aeGO.aDe(getType()) == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() status: %s, canShow: %s, getType: %d", new Object[] { f.a(this.aeGO, getType()), Boolean.valueOf(bool1), Integer.valueOf(getType()) });
        if (bool1) {
          break;
        }
        return false;
      }
      Iterator localIterator = ((Iterable)f.a(this.aeGO)).iterator();
      boolean bool2 = bool1;
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        f.a locala = (f.a)f.b(this.aeGO).get(Integer.valueOf(i));
        if ((locala != null) && (hkG() < locala.hkG()))
        {
          if (this.aeGO.aDe(i) == 1)
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
    
    public final boolean ceR()
    {
      return this.egk;
    }
    
    public int getType()
    {
      return 0;
    }
    
    public long jwG()
    {
      return 1000L;
    }
    
    public final void setEnable(boolean paramBoolean)
    {
      this.egk = paramBoolean;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    extends f.c
  {
    public d(f paramf)
    {
      super();
      AppMethodBeat.i(254822);
      AppMethodBeat.o(254822);
    }
    
    public final int getType()
    {
      return 2;
    }
    
    public final int hkG()
    {
      return 4;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    extends f.c
  {
    public e(f paramf)
    {
      super();
      AppMethodBeat.i(254837);
      AppMethodBeat.o(254837);
    }
    
    public final int getType()
    {
      return 1;
    }
    
    public final int hkG()
    {
      return 2;
    }
    
    public final long jwG()
    {
      return 2000L;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchHotImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "priority", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class f
    extends f.c
  {
    public f(f paramf)
    {
      super();
      AppMethodBeat.i(254812);
      AppMethodBeat.o(254812);
    }
    
    public final int getType()
    {
      return 3;
    }
    
    public final int hkG()
    {
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchNormalImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", "priority", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class g
    extends f.c
  {
    public g(f paramf)
    {
      super();
      AppMethodBeat.i(254813);
      AppMethodBeat.o(254813);
    }
    
    public final int getType()
    {
      return 4;
    }
    
    public final int hkG()
    {
      return 1;
    }
    
    public final long jwG()
    {
      return 2000L;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<f.a, f.a, ah>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "action", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements m<f.a, f.a, ah>
  {
    i(f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.f
 * JD-Core Version:    0.7.0.1
 */