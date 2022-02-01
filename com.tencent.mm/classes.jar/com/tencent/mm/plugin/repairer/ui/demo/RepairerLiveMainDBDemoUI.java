package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.ui.report.MMSecDataActivity;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ThreadTag", "getThreadTag", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "ui-repairer_release"})
public final class RepairerLiveMainDBDemoUI
  extends MMSecDataActivity
{
  final String TAG = "MicroMsg.RepairerLiveMainDBDemoUI";
  final String qNn = "DemoThread";
  
  public final int getLayoutId()
  {
    return b.b.IwL;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227081);
    super.onCreate(paramBundle);
    setMMTitle("LiveDBDemo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    d.c(this.qNn, (kotlin.g.a.a)new b(this));
    paramBundle = findViewById(b.a.Iwj);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(227081);
      return;
    }
    AppMethodBeat.o(227081);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227083);
    d.c(this.qNn, (kotlin.g.a.a)RepairerLiveMainDBDemoUI.d.IxO);
    super.onDestroy();
    AppMethodBeat.o(227083);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(227273);
      this.IxM.finish();
      AppMethodBeat.o(227273);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226557);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.c(this.IxM.qNn, (kotlin.g.a.a)1.IxN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerLiveMainDBDemoUI
 * JD-Core Version:    0.7.0.1
 */