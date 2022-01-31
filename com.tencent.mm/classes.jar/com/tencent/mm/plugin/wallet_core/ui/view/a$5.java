package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements View.OnClickListener
{
  a$5(LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47857);
    this.uwi.setVisibility(0);
    this.uwj.setVisibility(8);
    this.uwk.setText("");
    this.uwh.setText("");
    AppMethodBeat.o(47857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.5
 * JD-Core Version:    0.7.0.1
 */