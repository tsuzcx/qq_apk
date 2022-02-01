package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerStartActivityUI
  extends BaseRepairerUI
{
  private static final void a(RepairerStartActivityUI paramRepairerStartActivityUI, View paramView)
  {
    AppMethodBeat.i(277947);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerStartActivityUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerStartActivityUI, "this$0");
    paramView = ((MMEditText)paramRepairerStartActivityUI.findViewById(b.c.OtD)).getText().toString();
    try
    {
      paramView = new Intent().setClassName((Context)paramRepairerStartActivityUI, paramView);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(paramRepairerStartActivityUI, paramView.aYi(), "com/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI", "onCreate$lambda-0", "(Lcom/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramRepairerStartActivityUI.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramRepairerStartActivityUI, "com/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI", "onCreate$lambda-0", "(Lcom/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      label146:
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerStartActivityUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277947);
      return;
    }
    catch (Exception paramRepairerStartActivityUI)
    {
      break label146;
    }
  }
  
  public final int getLayoutId()
  {
    return b.d.Owc;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277969);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.c.ok_btn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerStartActivityUI..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(277969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerStartActivityUI
 * JD-Core Version:    0.7.0.1
 */