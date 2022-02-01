package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFiveFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFiveFragment$RecyclerAdapter;", "isFirst", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "ItemHolder", "RecyclerAdapter", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoFiveFragment
  extends BaseFragment
{
  private DemoFiveFragment.b OxY;
  private boolean isFirst = true;
  private RecyclerView mkw;
  
  public final void aNi()
  {
    AppMethodBeat.i(278500);
    if (this.isFirst)
    {
      this.isFirst = false;
      gNo().autoRefresh();
    }
    AppMethodBeat.o(278500);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(278511);
    super.cPy();
    DemoFiveFragment.b localb2 = this.OxY;
    DemoFiveFragment.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("adapter");
      localb1 = null;
    }
    localb1.bZE.notifyChanged();
    AppMethodBeat.o(278511);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvH;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278493);
    s.u(paramView, "view");
    Object localObject = paramView.findViewById(b.c.recyclerView);
    s.s(localObject, "view.findViewById(R.id.recyclerView)");
    this.mkw = ((RecyclerView)localObject);
    paramView = paramView.findViewById(b.c.refreshLayout);
    s.s(paramView, "view.findViewById(R.id.refreshLayout)");
    b((WxRefreshLayout)paramView);
    this.OxY = new DemoFiveFragment.b(this);
    paramView = this.mkw;
    if (paramView == null)
    {
      s.bIx("recyclerView");
      paramView = null;
    }
    for (;;)
    {
      DemoFiveFragment.b localb = this.OxY;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("adapter");
        localObject = null;
      }
      paramView.setAdapter((RecyclerView.a)localObject);
      gNo().setOnSimpleAction((b)new c(this));
      AppMethodBeat.o(278493);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFiveFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b
  {
    c(DemoFiveFragment paramDemoFiveFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278568);
      d.a(1000L, (a)new a(this.Oya));
      AppMethodBeat.o(278568);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278559);
      d.a(1000L, (a)new b(this.Oya));
      AppMethodBeat.o(278559);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(DemoFiveFragment paramDemoFiveFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(DemoFiveFragment paramDemoFiveFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoFiveFragment
 * JD-Core Version:    0.7.0.1
 */