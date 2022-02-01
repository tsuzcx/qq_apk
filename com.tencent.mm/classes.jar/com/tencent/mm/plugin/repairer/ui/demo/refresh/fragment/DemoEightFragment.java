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
import com.tencent.mm.view.refreshLayout.a.a.a;
import com.tencent.mm.view.refreshLayout.d.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoEightFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/RecyclerAdapter;", "isFirst", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoEightFragment
  extends BaseFragment
{
  private com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b OxW;
  private boolean isFirst = true;
  private RecyclerView mkw;
  
  public final void aNi()
  {
    AppMethodBeat.i(278523);
    if (this.isFirst)
    {
      this.isFirst = false;
      gNo().autoRefresh();
    }
    AppMethodBeat.o(278523);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(278528);
    super.cPy();
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b localb2 = this.OxW;
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("adapter");
      localb1 = null;
    }
    localb1.bZE.notifyChanged();
    AppMethodBeat.o(278528);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvG;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278517);
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
        break label376;
      }
      s.bIx("recyclerView");
      paramView = null;
    }
    label376:
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
      paramView = new a.a();
      paramView.Jcx = true;
      paramView.agPN = true;
      paramView.agPI = true;
      localObject = new com.tencent.mm.view.refreshLayout.a.a();
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPE = paramView.agPE;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).reboundDuration = paramView.reboundDuration;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agJq = paramView.agJq;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPF = paramView.agPF;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPG = paramView.agPG;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPH = paramView.agPH;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPI = paramView.agPI;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPJ = paramView.agPJ;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPK = paramView.agPK;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPL = paramView.agPL;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPM = paramView.agPM;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPN = paramView.agPN;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPO = paramView.agPO;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPP = paramView.agPP;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPQ = paramView.agPQ;
      ((com.tencent.mm.view.refreshLayout.a.a)localObject).agPR = paramView.agPR;
      gNo().setCommonConfig((com.tencent.mm.view.refreshLayout.a.a)localObject);
      gNo().setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new a(this));
      gNo().setOnMultiAction((c)new b());
      AppMethodBeat.o(278517);
      return;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoEightFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    a(DemoEightFragment paramDemoEightFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278462);
      d.a(1000L, (kotlin.g.a.a)new a(this.OxX));
      AppMethodBeat.o(278462);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278455);
      d.a(1000L, (kotlin.g.a.a)new b(this.OxX));
      AppMethodBeat.o(278455);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(DemoEightFragment paramDemoEightFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(DemoEightFragment paramDemoEightFragment)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoEightFragment$initView$2", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshMultiAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c
  {
    public final void onLoadMore() {}
    
    public final void onRefresh() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoEightFragment
 * JD-Core Version:    0.7.0.1
 */