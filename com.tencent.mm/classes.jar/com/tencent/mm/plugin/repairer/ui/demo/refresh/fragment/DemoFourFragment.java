package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFourFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/adapter/ListAdapter;", "isFirst", "", "listView", "Landroid/widget/ListView;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "onItemClick", "parent", "Landroid/widget/AdapterView;", "position", "id", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoFourFragment
  extends BaseFragment
  implements AdapterView.OnItemClickListener
{
  private com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a Oyb;
  private boolean isFirst = true;
  private ListView qgc;
  
  public final void aNi()
  {
    AppMethodBeat.i(278492);
    if (this.isFirst)
    {
      this.isFirst = false;
      gNo().autoRefresh();
    }
    AppMethodBeat.o(278492);
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(278513);
    super.cPy();
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a locala2 = this.Oyb;
    com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("adapter");
      locala1 = null;
    }
    locala1.notifyDataSetChanged();
    AppMethodBeat.o(278513);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvI;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278485);
    s.u(paramView, "view");
    Object localObject = paramView.findViewById(b.c.refreshLayout);
    s.s(localObject, "view.findViewById(R.id.refreshLayout)");
    b((WxRefreshLayout)localObject);
    paramView = paramView.findViewById(b.c.Oun);
    s.s(paramView, "view.findViewById(R.id.listView)");
    this.qgc = ((ListView)paramView);
    paramView = this.qgc;
    if (paramView == null)
    {
      s.bIx("listView");
      paramView = null;
      paramView.setOnItemClickListener((AdapterView.OnItemClickListener)this);
      paramView = getContext();
      s.checkNotNull(paramView);
      s.s(paramView, "context!!");
      this.Oyb = new com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a(paramView, this.lMl);
      paramView = this.qgc;
      if (paramView != null) {
        break label179;
      }
      s.bIx("listView");
      paramView = null;
    }
    label179:
    for (;;)
    {
      com.tencent.mm.plugin.repairer.ui.demo.refresh.a.a locala = this.Oyb;
      localObject = locala;
      if (locala == null)
      {
        s.bIx("adapter");
        localObject = null;
      }
      paramView.setAdapter((ListAdapter)localObject);
      gNo().setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new a(this));
      AppMethodBeat.o(278485);
      return;
      break;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(278504);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFourFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    Toast.makeText(getContext(), (CharSequence)String.valueOf(paramInt), 0).show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFourFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(278504);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFourFragment$initView$1", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    a(DemoFourFragment paramDemoFourFragment) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(278538);
      d.a(1000L, (kotlin.g.a.a)new a(this.Oyc));
      AppMethodBeat.o(278538);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(278529);
      d.a(1000L, (kotlin.g.a.a)new b(this.Oyc));
      AppMethodBeat.o(278529);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(DemoFourFragment paramDemoFourFragment)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(DemoFourFragment paramDemoFourFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoFourFragment
 * JD-Core Version:    0.7.0.1
 */