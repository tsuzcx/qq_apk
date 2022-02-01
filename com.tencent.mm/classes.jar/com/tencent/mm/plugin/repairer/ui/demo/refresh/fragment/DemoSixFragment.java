package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.t;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoSixFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoSixFragment$RecyclerAdapter;", "isFirst", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "ItemHolder", "RecyclerAdapter", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoSixFragment
  extends BaseFragment
{
  private DemoSixFragment.b Oyf;
  private boolean isFirst = true;
  private RecyclerView mkw;
  
  public final void aNi()
  {
    AppMethodBeat.i(278524);
    if (this.isFirst)
    {
      this.isFirst = false;
      gNo().autoRefresh();
    }
    AppMethodBeat.o(278524);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(278530);
    super.cPy();
    DemoSixFragment.b localb2 = this.Oyf;
    DemoSixFragment.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("adapter");
      localb1 = null;
    }
    localb1.bZE.notifyChanged();
    AppMethodBeat.o(278530);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvL;
  }
  
  public final void iS(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(278518);
    s.u(paramView, "view");
    Object localObject1 = paramView.findViewById(b.c.refreshLayout);
    s.s(localObject1, "view.findViewById(R.id.refreshLayout)");
    b((WxRefreshLayout)localObject1);
    paramView = paramView.findViewById(b.c.recyclerView);
    s.s(paramView, "view.findViewById(R.id.recyclerView)");
    this.mkw = ((RecyclerView)paramView);
    this.Oyf = new DemoSixFragment.b(this);
    paramView = this.mkw;
    if (paramView == null)
    {
      s.bIx("recyclerView");
      paramView = null;
      getContext();
      paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramView = this.mkw;
      if (paramView != null) {
        break label228;
      }
      s.bIx("recyclerView");
      paramView = null;
      label120:
      DemoSixFragment.b localb = this.Oyf;
      localObject1 = localb;
      if (localb == null)
      {
        s.bIx("adapter");
        localObject1 = null;
      }
      paramView.setAdapter((RecyclerView.a)localObject1);
      localObject1 = this.mkw;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("recyclerView");
        paramView = null;
      }
      paramView.setHasFixedSize(true);
      localObject1 = new t();
      paramView = this.mkw;
      if (paramView != null) {
        break label231;
      }
      s.bIx("recyclerView");
      paramView = localObject2;
    }
    label228:
    label231:
    for (;;)
    {
      ((t)localObject1).a(paramView);
      gNo().setOnSimpleAction((b)new c(this));
      AppMethodBeat.o(278518);
      return;
      break;
      break label120;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoSixFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b
  {
    c(DemoSixFragment paramDemoSixFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278515);
      d.a(1000L, (a)new a(this.Oyg));
      AppMethodBeat.o(278515);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278507);
      d.a(1000L, (a)new b(this.Oyg));
      AppMethodBeat.o(278507);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(DemoSixFragment paramDemoSixFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(DemoSixFragment paramDemoSixFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoSixFragment
 * JD-Core Version:    0.7.0.1
 */