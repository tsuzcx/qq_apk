package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBusiResultUI$6
  implements View.OnClickListener
{
  RemittanceBusiResultUI$6(RemittanceBusiResultUI paramRemittanceBusiResultUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(44874);
    if (RemittanceBusiResultUI.h(this.qnm))
    {
      this.qnp.setVisibility(8);
      RemittanceBusiResultUI.i(this.qnm).setVisibility(0);
      RemittanceBusiResultUI.a(this.qnm, RemittanceBusiResultUI.j(this.qnm));
    }
    for (;;)
    {
      paramView = this.qnm;
      if (!RemittanceBusiResultUI.h(this.qnm)) {
        bool = true;
      }
      RemittanceBusiResultUI.a(paramView, bool);
      AppMethodBeat.o(44874);
      return;
      this.qnp.setVisibility(0);
      RemittanceBusiResultUI.i(this.qnm).setVisibility(8);
      RemittanceBusiResultUI.a(this.qnm, this.qnp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.6
 * JD-Core Version:    0.7.0.1
 */