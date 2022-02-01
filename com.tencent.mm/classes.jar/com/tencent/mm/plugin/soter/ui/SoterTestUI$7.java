package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.soter.core.c.i;

final class SoterTestUI$7
  implements View.OnClickListener
{
  SoterTestUI$7(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(130911);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = com.tencent.soter.core.a.bDc("sample_auth_key_name");
    if (paramView == null)
    {
      SoterTestUI.a(this.Lxm).setText("not passed: no certificate");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(130911);
      return;
    }
    SoterTestUI.a(this.Lxm).setText("model available: " + paramView.toString());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(130911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.7
 * JD-Core Version:    0.7.0.1
 */