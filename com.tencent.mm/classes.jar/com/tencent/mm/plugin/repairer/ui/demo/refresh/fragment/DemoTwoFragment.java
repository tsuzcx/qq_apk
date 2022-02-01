package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import com.tencent.mm.view.refreshLayout.d.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoTwoFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoTwoFragment
  extends BaseFragment
{
  public final void aNi() {}
  
  public final int getLayoutId()
  {
    return b.d.OvN;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278544);
    s.u(paramView, "view");
    paramView = paramView.findViewById(b.c.refreshLayout);
    s.s(paramView, "view.findViewById(R.id.refreshLayout)");
    b((WxRefreshLayout)paramView);
    gNo().setOnSimpleAction((b)new a(this));
    AppMethodBeat.o(278544);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoTwoFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b
  {
    a(DemoTwoFragment paramDemoTwoFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278548);
      d.a(1000L, (a)new a(this.Oyj));
      AppMethodBeat.o(278548);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278542);
      d.a(1000L, (a)new b(this.Oyj));
      AppMethodBeat.o(278542);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(DemoTwoFragment paramDemoTwoFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(DemoTwoFragment paramDemoTwoFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoTwoFragment
 * JD-Core Version:    0.7.0.1
 */