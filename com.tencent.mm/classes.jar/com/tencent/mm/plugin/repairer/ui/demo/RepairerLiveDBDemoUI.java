package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ThreadTag", "getThreadTag", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "getAdapter", "()Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/livelist/MMLiveList;", "liveList$delegate", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerLiveDBDemoUI
  extends MMSecDataActivity
{
  final f BiY;
  private final f GkY;
  final String TAG;
  final String qNn;
  WxRecyclerView vnF;
  
  public RepairerLiveDBDemoUI()
  {
    AppMethodBeat.i(227470);
    this.TAG = "MicroMsg.RepairerLiveDBDemoUI";
    this.qNn = "DemoThread";
    this.GkY = g.ar((kotlin.g.a.a)new c(this));
    this.BiY = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(227470);
  }
  
  public final MMLiveList<d> fBg()
  {
    AppMethodBeat.i(227466);
    MMLiveList localMMLiveList = (MMLiveList)this.GkY.getValue();
    AppMethodBeat.o(227466);
    return localMMLiveList;
  }
  
  public final int getLayoutId()
  {
    return b.b.IwL;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227469);
    super.onCreate(paramBundle);
    setMMTitle("LiveDBDemo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    com.tencent.mm.ae.d.c(this.qNn, (kotlin.g.a.a)new e(this));
    paramBundle = findViewById(b.a.Iwj);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      AppMethodBeat.o(227469);
      return;
    }
    AppMethodBeat.o(227469);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.livelist.h<d>>
  {
    a(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MMLiveList<d>>
  {
    c(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(227416);
      this.IxJ.finish();
      AppMethodBeat.o(227416);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226976);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.ae.d.c(this.IxJ.qNn, (kotlin.g.a.a)1.IxL);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerLiveDBDemoUI
 * JD-Core Version:    0.7.0.1
 */