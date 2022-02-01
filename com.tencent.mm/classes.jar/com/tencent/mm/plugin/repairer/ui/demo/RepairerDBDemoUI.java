package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerDBDemoUI
  extends BaseRepairerUI
{
  private final String TAG = "MicroMsg.RepairerDBDemoUI";
  
  private static final void a(RepairerDBDemoUI paramRepairerDBDemoUI, View paramView)
  {
    AppMethodBeat.i(278248);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerDBDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerDBDemoUI, "this$0");
    paramView = new Intent().setClassName((Context)paramRepairerDBDemoUI, "com.tencent.mm.plugin.repairer.ui.demo.RepairerDBSelectDemoUI");
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramRepairerDBDemoUI, paramView.aYi(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramRepairerDBDemoUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramRepairerDBDemoUI, "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278248);
  }
  
  private static final boolean a(RepairerDBDemoUI paramRepairerDBDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278241);
    s.u(paramRepairerDBDemoUI, "this$0");
    paramRepairerDBDemoUI.finish();
    AppMethodBeat.o(278241);
    return true;
  }
  
  private static final void eV(View paramView)
  {
    AppMethodBeat.i(278252);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278252);
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovs;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278283);
    super.onCreate(paramBundle);
    setMMTitle("DB组件Demo");
    setBackBtn(new RepairerDBDemoUI..ExternalSyntheticLambda0(this));
    ((Button)findViewById(b.c.OtH)).setOnClickListener(new RepairerDBDemoUI..ExternalSyntheticLambda1(this));
    ((Button)findViewById(b.c.OtI)).setOnClickListener(RepairerDBDemoUI..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(278283);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerDBDemoUI
 * JD-Core Version:    0.7.0.1
 */