package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "childActions", "detectResult", "", "parentActions", "canShow", "type", "cancelChildAction", "", "getStatus", "(I)Ljava/lang/Boolean;", "defaultStatus", "postAction", "action", "Ljava/lang/Runnable;", "removeStatus", "reset", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "app_release"})
public final class c
{
  public static final c.b JUr;
  private HashMap<Integer, a> JUn;
  private HashMap<Integer, Integer> JUo;
  private HashMap<Integer, Integer> JUp;
  private final HashMap<Integer, Boolean> JUq;
  
  static
  {
    AppMethodBeat.i(194888);
    JUr = new c.b((byte)0);
    AppMethodBeat.o(194888);
  }
  
  public c()
  {
    AppMethodBeat.i(194887);
    this.JUn = new HashMap();
    this.JUo = new HashMap();
    this.JUp = new HashMap();
    this.JUq = new HashMap();
    ((Map)this.JUn).put(Integer.valueOf(1), new e(this));
    if (e.fGS())
    {
      ((Map)this.JUn).put(Integer.valueOf(2), new d(this));
      ((Map)this.JUo).put(Integer.valueOf(1), Integer.valueOf(2));
      ((Map)this.JUp).put(Integer.valueOf(2), Integer.valueOf(1));
    }
    AppMethodBeat.o(194887);
  }
  
  private final void aec(int paramInt)
  {
    AppMethodBeat.i(194886);
    Object localObject = (Integer)this.JUp.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      ((Integer)localObject).intValue();
      localObject = (a)this.JUn.get(localObject);
      if (localObject != null)
      {
        ((a)localObject).fGQ();
        AppMethodBeat.o(194886);
      }
    }
    else
    {
      AppMethodBeat.o(194886);
      return;
    }
    AppMethodBeat.o(194886);
  }
  
  public final boolean aea(int paramInt)
  {
    AppMethodBeat.i(194882);
    Boolean localBoolean = (Boolean)this.JUq.get(Integer.valueOf(paramInt));
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(194882);
      return bool;
    }
    AppMethodBeat.o(194882);
    return false;
  }
  
  public final void aeb(int paramInt)
  {
    AppMethodBeat.i(194885);
    this.JUq.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(194885);
  }
  
  public final void e(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(194884);
    p.h(paramRunnable, "action");
    a locala = (a)this.JUn.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(194884);
      return;
    }
    if (locala.valid())
    {
      ad.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid type: %d, action: %s", new Object[] { Integer.valueOf(paramInt), paramRunnable });
      aec(paramInt);
      paramRunnable.run();
      AppMethodBeat.o(194884);
      return;
    }
    ad.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", new Object[] { Integer.valueOf(paramInt), paramRunnable, Long.valueOf(1000L) });
    locala.aI(paramRunnable);
    h.LTJ.q((Runnable)new f(locala), 1000L);
    AppMethodBeat.o(194884);
  }
  
  public final boolean la(int paramInt)
  {
    AppMethodBeat.i(194883);
    if (paramInt == 2)
    {
      bool = aea(2);
      AppMethodBeat.o(194883);
      return bool;
    }
    a locala = (a)this.JUn.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(194883);
      return false;
    }
    boolean bool = locala.fGP();
    ad.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(194883);
    return bool;
  }
  
  public final void updateStatus(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194881);
    ((Map)this.JUq).put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(194881);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "cancelAction", "", "delay", "", "delayDuration", "", "getType", "", "runAction", "setAction", "action", "Ljava/lang/Runnable;", "show", "valid", "app_release"})
  static abstract interface a
  {
    public abstract void aI(Runnable paramRunnable);
    
    public abstract boolean fGP();
    
    public abstract void fGQ();
    
    public abstract void fGR();
    
    public abstract boolean valid();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "action", "Ljava/lang/Runnable;", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "cancelAction", "", "delay", "", "delayDuration", "", "getType", "", "runAction", "setAction", "show", "valid", "app_release"})
  static class c
    implements c.a
  {
    private c JUs;
    private Runnable aBK;
    
    public c(c paramc)
    {
      AppMethodBeat.i(194877);
      this.JUs = paramc;
      AppMethodBeat.o(194877);
    }
    
    public final void aI(Runnable paramRunnable)
    {
      AppMethodBeat.i(194874);
      p.h(paramRunnable, "action");
      this.aBK = paramRunnable;
      AppMethodBeat.o(194874);
    }
    
    public final boolean fGP()
    {
      AppMethodBeat.i(194873);
      Boolean localBoolean = c.a(this.JUs, getType());
      Integer localInteger;
      c.a locala;
      if (localBoolean != null)
      {
        localBoolean.booleanValue();
        localInteger = (Integer)c.a(this.JUs).get(Integer.valueOf(getType()));
        if (localInteger == null) {
          break label134;
        }
        localInteger.intValue();
        locala = (c.a)c.b(this.JUs).get(localInteger);
        if (locala == null) {
          break label151;
        }
        if (locala.fGP()) {
          break label146;
        }
      }
      label134:
      label146:
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.ImageScanButtonStatusManager", "Action.show() parentActionType: %d, parentAction: %s, currentStatus: %s, show: %b", new Object[] { localInteger, locala, localBoolean, Boolean.valueOf(bool) });
        AppMethodBeat.o(194873);
        return bool;
        AppMethodBeat.o(194873);
        return false;
        bool = localBoolean.booleanValue();
        AppMethodBeat.o(194873);
        return bool;
      }
      label151:
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(194873);
      return bool;
    }
    
    public final void fGQ()
    {
      AppMethodBeat.i(194875);
      this.aBK = null;
      Object localObject = (Integer)c.c(this.JUs).get(Integer.valueOf(getType()));
      ad.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d, childActionType: %s", new Object[] { Integer.valueOf(getType()), localObject });
      if (localObject != null)
      {
        ((Integer)localObject).intValue();
        localObject = (c.a)c.b(this.JUs).get(localObject);
        if (localObject != null)
        {
          ((c.a)localObject).fGQ();
          AppMethodBeat.o(194875);
        }
      }
      else
      {
        AppMethodBeat.o(194875);
        return;
      }
      AppMethodBeat.o(194875);
    }
    
    public final void fGR()
    {
      AppMethodBeat.i(194876);
      Runnable localRunnable = this.aBK;
      if (localRunnable != null)
      {
        localRunnable.run();
        AppMethodBeat.o(194876);
        return;
      }
      AppMethodBeat.o(194876);
    }
    
    public int getType()
    {
      return 0;
    }
    
    public final boolean valid()
    {
      AppMethodBeat.i(194872);
      Integer localInteger = (Integer)c.a(this.JUs).get(Integer.valueOf(getType()));
      Boolean localBoolean = c.a(this.JUs, getType());
      c.a locala;
      if (localInteger != null)
      {
        localInteger.intValue();
        locala = (c.a)c.b(this.JUs).get(localInteger);
        if (locala == null) {
          break label145;
        }
        if ((localBoolean == null) || (!locala.valid())) {
          break label140;
        }
      }
      label140:
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.ImageScanButtonStatusManager", "Action.valid() parentActionType: %d, parentAction: %s, currentStatus: %s, valid: %b", new Object[] { localInteger, locala, localBoolean, Boolean.valueOf(bool) });
        AppMethodBeat.o(194872);
        return bool;
        if (localBoolean != null)
        {
          AppMethodBeat.o(194872);
          return true;
        }
        AppMethodBeat.o(194872);
        return false;
      }
      label145:
      AppMethodBeat.o(194872);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "app_release"})
  static final class d
    extends c.c
  {
    public d(c paramc)
    {
      super();
      AppMethodBeat.i(194878);
      AppMethodBeat.o(194878);
    }
    
    public final int getType()
    {
      return 2;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", "app_release"})
  static final class e
    extends c.c
  {
    public e(c paramc)
    {
      super();
      AppMethodBeat.i(194879);
      AppMethodBeat.o(194879);
    }
    
    public final int getType()
    {
      return 1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(c.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(194880);
      this.JUt.fGR();
      AppMethodBeat.o(194880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */