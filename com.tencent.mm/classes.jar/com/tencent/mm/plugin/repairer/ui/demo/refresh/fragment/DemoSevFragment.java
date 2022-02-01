package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoSevFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter;", "isFirst", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoSevFragment
  extends BaseFragment
{
  private com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b OxW;
  private boolean isFirst = true;
  private RecyclerView mkw;
  
  public final void aNi()
  {
    AppMethodBeat.i(278510);
    if (this.isFirst)
    {
      this.isFirst = false;
      gNo().autoRefresh();
    }
    AppMethodBeat.o(278510);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(278516);
    super.cPy();
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b localb2 = this.OxW;
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("adapter");
      localb1 = null;
    }
    localb1.bZE.notifyChanged();
    AppMethodBeat.o(278516);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvK;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278499);
    s.u(paramView, "view");
    Object localObject = paramView.findViewById(b.c.recyclerView);
    s.s(localObject, "view.findViewById(R.id.recyclerView)");
    this.mkw = ((RecyclerView)localObject);
    paramView = paramView.findViewById(b.c.refreshLayout);
    s.s(paramView, "view.findViewById(R.id.refreshLayout)");
    b((WxRefreshLayout)paramView);
    paramView = this.lMl;
    localObject = getContext();
    s.checkNotNull(localObject);
    s.s(localObject, "context!!");
    this.OxW = new com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b(paramView, (Context)localObject);
    paramView = this.mkw;
    if (paramView == null)
    {
      s.bIx("recyclerView");
      paramView = null;
      getContext();
      paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramView = this.mkw;
      if (paramView != null) {
        break label192;
      }
      s.bIx("recyclerView");
      paramView = null;
    }
    label192:
    for (;;)
    {
      com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b localb = this.OxW;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("adapter");
        localObject = null;
      }
      paramView.setAdapter((RecyclerView.a)localObject);
      gNo().setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new a(this));
      AppMethodBeat.o(278499);
      return;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoSevFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    a(DemoSevFragment paramDemoSevFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278545);
      d.a(1000L, (a)new a(this.Oye));
      AppMethodBeat.o(278545);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278535);
      d.a(1000L, (a)new b(this.Oye));
      AppMethodBeat.o(278535);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(DemoSevFragment paramDemoSevFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(DemoSevFragment paramDemoSevFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoSevFragment
 * JD-Core Version:    0.7.0.1
 */