package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$5
  implements View.OnClickListener
{
  a$5(LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71457);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.VVG.setVisibility(0);
    this.VVH.setVisibility(8);
    this.VVI.setText("");
    this.VVF.setText("");
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/AlertWithMMEditText$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.5
 * JD-Core Version:    0.7.0.1
 */