package com.tencent.mm.plugin.sns.ui.widget;

import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMOverScrollView.a;
import com.tencent.mm.ui.base.MMOverScrollView.b;
import com.tencent.mm.ui.base.MMOverScrollView.c;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller;", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "provider", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "(Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;)V", "TAG", "", "currentConsumer", "isOpen", "", "()Z", "isOpening", "isPullDown", "onOpenChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "open", "", "onScrollCallback", "Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;", "getOnScrollCallback", "()Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;", "setOnScrollCallback", "(Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;)V", "openScroller", "Lcom/tencent/mm/plugin/sns/ui/widget/OpenScroller;", "openState", "", "getOpenState", "()I", "setOpenState", "(I)V", "value", "openTarget", "getOpenTarget", "setOpenTarget", "getProvider", "()Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "pullDownOpen", "getPullDownOpen", "setPullDownOpen", "(Z)V", "pullDownScroller", "Lcom/tencent/mm/ui/base/MMOverScrollView$PullDownScroller;", "stateSettle", "getStateSettle", "checkState", "scrollEnd", "close", "smooth", "onFling", "velocityY", "", "onScroll", "distanceY", "onScrollEnd", "onScrolled", "dy", "onTouchEnd", "isFlinging", "touchMoved", "onTouchStart", "Companion", "OnScrollCallback", "OnScrollCallbackList", "SimpleOnScrollCallback", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements MMOverScrollView.a
{
  public static final h.a RXv;
  public boolean LWA;
  public int RVA;
  private final b<Boolean, ah> RVB;
  public final MMOverScrollView.b RVz;
  private final MMOverScrollView.c RXA;
  private MMOverScrollView.a RXB;
  public boolean RXw;
  public b RXx;
  public boolean RXy;
  public final a RXz;
  private final String TAG;
  int byB;
  
  static
  {
    AppMethodBeat.i(309209);
    RXv = new h.a((byte)0);
    AppMethodBeat.o(309209);
  }
  
  public h(MMOverScrollView.b paramb)
  {
    AppMethodBeat.i(309205);
    this.RVz = paramb;
    this.TAG = "MicroMsg.SnsOpenScroller";
    this.RVA = 800;
    this.RXz = new a(this.RVz);
    this.RXA = new MMOverScrollView.c(this.RVz);
    this.RXB = ((MMOverScrollView.a)this.RXz);
    this.RVB = ((b)new e(this));
    this.RXz.RVB = this.RVB;
    AppMethodBeat.o(309205);
  }
  
  public final void K(boolean paramBoolean)
  {
    AppMethodBeat.i(309217);
    this.RXy = false;
    if (paramBoolean)
    {
      this.RVz.aAY(0);
      checkState(false);
    }
    for (;;)
    {
      this.LWA = false;
      AppMethodBeat.o(309217);
      return;
      this.RVz.aAX(0);
      checkState(true);
    }
  }
  
  public final boolean aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(309230);
    paramBoolean1 = this.RXB.aZ(paramBoolean1, paramBoolean2);
    if (!paramBoolean1) {
      if ((this.byB != 1) && (this.byB != 0)) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        K(true);
      }
      this.LWA = false;
      if (paramBoolean1) {
        checkState(false);
      }
      b localb = this.RXx;
      if (localb != null) {
        localb.Ep(this.RXy);
      }
      AppMethodBeat.o(309230);
      return paramBoolean1;
    }
  }
  
  public final void amL(int paramInt)
  {
    AppMethodBeat.i(309234);
    b localb = this.RXx;
    if (localb != null) {
      localb.v(this.RXy, paramInt, this.RVz.getScrollY());
    }
    AppMethodBeat.o(309234);
  }
  
  public final void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(309241);
    Log.i(this.TAG, s.X("checkState: ", Boolean.valueOf(paramBoolean)));
    int i;
    label56:
    b localb;
    if (this.RVz.jmx().isFinished())
    {
      i = this.RVz.getScrollY();
      if (i >= 0) {
        break label145;
      }
      if (!paramBoolean) {
        break label140;
      }
      i = 1;
      if (this.byB != i)
      {
        if ((i != 0) || (this.byB == 3)) {
          break label159;
        }
        localb = this.RXx;
        if (localb != null) {
          localb.bO(3, false);
        }
      }
    }
    for (;;)
    {
      this.byB = i;
      localb = this.RXx;
      if (localb != null) {
        localb.bO(this.byB, false);
      }
      AppMethodBeat.o(309241);
      return;
      i = this.RVz.jmx().getFinalY();
      break;
      label140:
      i = 2;
      break label56;
      label145:
      if (paramBoolean)
      {
        i = 0;
        break label56;
      }
      i = 3;
      break label56;
      label159:
      if ((i == 1) && (this.byB != 2))
      {
        localb = this.RXx;
        if (localb != null) {
          localb.bO(2, false);
        }
      }
    }
  }
  
  public final boolean dt(float paramFloat)
  {
    AppMethodBeat.i(309221);
    b localb = this.RXx;
    if (localb != null) {
      localb.v(this.RXy, (int)paramFloat, this.RVz.getScrollY());
    }
    boolean bool = this.RXB.dt(paramFloat);
    AppMethodBeat.o(309221);
    return bool;
  }
  
  public final boolean du(float paramFloat)
  {
    AppMethodBeat.i(309225);
    boolean bool = this.RXB.du(paramFloat);
    this.LWA = false;
    AppMethodBeat.o(309225);
    return bool;
  }
  
  public final void fYb()
  {
    AppMethodBeat.i(309237);
    b localb = this.RXx;
    if (localb != null) {
      localb.Ez(this.RXy);
    }
    checkState(true);
    AppMethodBeat.o(309237);
  }
  
  public final boolean hsG()
  {
    AppMethodBeat.i(309228);
    Log.i(this.TAG, "onTouchStart: " + this.RXw + ", " + isOpen() + ", " + this.LWA + ", " + this.RXB);
    if (((this.RXw) || (isOpen())) && (this.RVz.dsp())) {
      this.RXy = false;
    }
    for (this.RXB = ((MMOverScrollView.a)this.RXz);; this.RXB = ((MMOverScrollView.a)this.RXA))
    {
      b localb = this.RXx;
      if (localb != null) {
        localb.hpY();
      }
      boolean bool = this.RXB.hsG();
      AppMethodBeat.o(309228);
      return bool;
      this.RXy = true;
    }
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(309214);
    if ((this.RVz.getScrollY() == -this.RVA) || (this.LWA))
    {
      AppMethodBeat.o(309214);
      return true;
    }
    AppMethodBeat.o(309214);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;", "", "onOpenStateChange", "", "state", "", "fromScroll", "", "onScrollEnd", "isPullDown", "onScrolled", "dy", "scrollY", "onTouchEnd", "onTouchStart", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void Ep(boolean paramBoolean);
    
    public abstract void Ez(boolean paramBoolean);
    
    public abstract void bO(int paramInt, boolean paramBoolean);
    
    public abstract void hpY();
    
    public abstract void v(boolean paramBoolean, int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallbackList;", "Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;", "()V", "list", "Ljava/util/LinkedList;", "add", "", "callback", "onOpenStateChange", "state", "", "fromScroll", "", "onScrollEnd", "isPullDown", "onScrolled", "dy", "scrollY", "onTouchEnd", "onTouchStart", "remove", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements h.b
  {
    private final LinkedList<h.b> lPK;
    
    public c()
    {
      AppMethodBeat.i(309180);
      this.lPK = new LinkedList();
      AppMethodBeat.o(309180);
    }
    
    public final void Ep(boolean paramBoolean)
    {
      AppMethodBeat.i(309195);
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext()) {
        ((h.b)localIterator.next()).Ep(paramBoolean);
      }
      AppMethodBeat.o(309195);
    }
    
    public final void Ez(boolean paramBoolean)
    {
      AppMethodBeat.i(309197);
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext()) {
        ((h.b)localIterator.next()).Ez(paramBoolean);
      }
      AppMethodBeat.o(309197);
    }
    
    public final void a(h.b paramb)
    {
      AppMethodBeat.i(309186);
      s.u(paramb, "callback");
      if (!this.lPK.contains(paramb)) {
        this.lPK.add(paramb);
      }
      AppMethodBeat.o(309186);
    }
    
    public final void bO(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(309201);
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext()) {
        ((h.b)localIterator.next()).bO(paramInt, paramBoolean);
      }
      AppMethodBeat.o(309201);
    }
    
    public final void hpY()
    {
      AppMethodBeat.i(309188);
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext()) {
        ((h.b)localIterator.next()).hpY();
      }
      AppMethodBeat.o(309188);
    }
    
    public final void v(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(309192);
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext()) {
        ((h.b)localIterator.next()).v(paramBoolean, paramInt1, paramInt2);
      }
      AppMethodBeat.o(309192);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$SimpleOnScrollCallback;", "Lcom/tencent/mm/plugin/sns/ui/widget/SnsOpenScroller$OnScrollCallback;", "()V", "onOpenStateChange", "", "state", "", "fromScroll", "", "onScrollEnd", "isPullDown", "onScrolled", "dy", "scrollY", "onTouchEnd", "onTouchStart", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class d
    implements h.b
  {
    public void Ep(boolean paramBoolean) {}
    
    public final void Ez(boolean paramBoolean) {}
    
    public void bO(int paramInt, boolean paramBoolean) {}
    
    public void hpY() {}
    
    public void v(boolean paramBoolean, int paramInt1, int paramInt2) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "open", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<Boolean, ah>
  {
    e(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */