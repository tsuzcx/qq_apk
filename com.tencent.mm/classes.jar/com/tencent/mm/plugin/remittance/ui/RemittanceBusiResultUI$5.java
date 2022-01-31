package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    if (RemittanceBusiResultUI.b(this.nBx))
    {
      this.nBA.setVisibility(8);
      RemittanceBusiResultUI.c(this.nBx).setVisibility(0);
      RemittanceBusiResultUI.a(this.nBx, RemittanceBusiResultUI.d(this.nBx));
    }
    for (;;)
    {
      paramView = this.nBx;
      if (!RemittanceBusiResultUI.b(this.nBx)) {
        bool = true;
      }
      RemittanceBusiResultUI.a(paramView, bool);
      return;
      this.nBA.setVisibility(0);
      RemittanceBusiResultUI.c(this.nBx).setVisibility(8);
      RemittanceBusiResultUI.a(this.nBx, this.nBA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */