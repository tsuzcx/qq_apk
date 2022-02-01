package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ThreadTag", "getThreadTag", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerLiveMainDBDemoUI
  extends BaseRepairerUI
{
  final String TAG = "MicroMsg.RepairerLiveMainDBDemoUI";
  private final String tRX = "DemoThread";
  
  private static final void a(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI, View paramView)
  {
    AppMethodBeat.i(278345);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerLiveMainDBDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerLiveMainDBDemoUI, "this$0");
    d.e(paramRepairerLiveMainDBDemoUI.tRX, (kotlin.g.a.a)b.Oxi);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveMainDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278345);
  }
  
  private static final boolean a(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278340);
    s.u(paramRepairerLiveMainDBDemoUI, "this$0");
    paramRepairerLiveMainDBDemoUI.finish();
    AppMethodBeat.o(278340);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovy;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278374);
    super.onCreate(paramBundle);
    setMMTitle("LiveDBDemo");
    setBackBtn(new RepairerLiveMainDBDemoUI..ExternalSyntheticLambda0(this));
    d.e(this.tRX, (kotlin.g.a.a)new a(this));
    paramBundle = findViewById(b.c.Ouc);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerLiveMainDBDemoUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(278374);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278384);
    d.e(this.tRX, (kotlin.g.a.a)c.Oxj);
    super.onDestroy();
    AppMethodBeat.o(278384);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(RepairerLiveMainDBDemoUI paramRepairerLiveMainDBDemoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b Oxi;
    
    static
    {
      AppMethodBeat.i(278299);
      Oxi = new b();
      AppMethodBeat.o(278299);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final c Oxj;
    
    static
    {
      AppMethodBeat.i(278295);
      Oxj = new c();
      AppMethodBeat.o(278295);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerLiveMainDBDemoUI
 * JD-Core Version:    0.7.0.1
 */