package com.tencent.mm.plugin.sns.ui.widget;

import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMOverScrollView.a;
import com.tencent.mm.ui.base.MMOverScrollView.b;
import com.tencent.mm.ui.base.MMOverScrollView.b.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/OpenScroller;", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "provider", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "(Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;)V", "TAG", "", "onOpenChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "open", "", "getOnOpenChanged", "()Lkotlin/jvm/functions/Function1;", "setOnOpenChanged", "(Lkotlin/jvm/functions/Function1;)V", "openTarget", "", "getOpenTarget", "()I", "setOpenTarget", "(I)V", "getProvider", "()Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "onFling", "velocityY", "", "onScroll", "distanceY", "onScrolled", "dy", "onTouchEnd", "isFlinging", "touchMoved", "onTouchStart", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements MMOverScrollView.a
{
  public int RVA;
  b<? super Boolean, ah> RVB;
  private final MMOverScrollView.b RVz;
  private final String TAG;
  
  public a(MMOverScrollView.b paramb)
  {
    AppMethodBeat.i(309189);
    this.RVz = paramb;
    this.TAG = "MicroMsg.OpenScroller";
    this.RVA = 800;
    AppMethodBeat.o(309189);
  }
  
  public final boolean aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(309203);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(309203);
      return false;
    }
    if (paramBoolean1)
    {
      AppMethodBeat.o(309203);
      return true;
    }
    b localb;
    if (this.RVz.getScrollY() < -this.RVA / 2)
    {
      MMOverScrollView.b.a.a(this.RVz, -this.RVA - this.RVz.getScrollY());
      localb = this.RVB;
      if (localb != null) {
        localb.invoke(Boolean.TRUE);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(309203);
      return true;
      MMOverScrollView.b.a.a(this.RVz, -this.RVz.getScrollY());
      localb = this.RVB;
      if (localb != null) {
        localb.invoke(Boolean.FALSE);
      }
    }
  }
  
  public final void amL(int paramInt) {}
  
  public final boolean dt(float paramFloat)
  {
    AppMethodBeat.i(309194);
    int i = (int)(paramFloat / 2.0F);
    int j = this.RVz.getScrollY() + i;
    new StringBuilder("onScroll: ").append(j).append(", ").append(this.RVz.getScrollY()).append(", ").append(paramFloat);
    if ((j <= 0) && (j >= -this.RVA))
    {
      this.RVz.Yn(i);
      AppMethodBeat.o(309194);
      return true;
    }
    if (this.RVz.getScrollY() < 0)
    {
      if (j < -this.RVA) {
        this.RVz.aAX(-this.RVA);
      }
      for (;;)
      {
        AppMethodBeat.o(309194);
        return true;
        MMOverScrollView.b localb = this.RVz;
        localb.Yn(Math.min(i, -localb.getScrollY()));
      }
    }
    AppMethodBeat.o(309194);
    return false;
  }
  
  public final boolean du(float paramFloat)
  {
    AppMethodBeat.i(309199);
    this.RVz.jmx().fling(0, this.RVz.getScrollY(), 0, -(int)paramFloat, 0, 0, -this.RVA, 0);
    b localb;
    if (this.RVz.jmx().getFinalY() < -this.RVA / 2)
    {
      MMOverScrollView.b.a.a(this.RVz, -this.RVA - this.RVz.getScrollY());
      localb = this.RVB;
      if (localb != null) {
        localb.invoke(Boolean.TRUE);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(309199);
      return true;
      MMOverScrollView.b.a.a(this.RVz, -this.RVz.getScrollY());
      localb = this.RVB;
      if (localb != null) {
        localb.invoke(Boolean.FALSE);
      }
    }
  }
  
  public final void fYb()
  {
    AppMethodBeat.i(309208);
    s.u(this, "this");
    AppMethodBeat.o(309208);
  }
  
  public final boolean hsG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */