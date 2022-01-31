package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallOrderDetailInfoUI$7
  implements View.OnClickListener
{
  MallOrderDetailInfoUI$7(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43802);
    if ((MallOrderDetailInfoUI.f(this.pqU) != null) && (MallOrderDetailInfoUI.g(this.pqU) != null))
    {
      if (paramView.getId() == 2131825970)
      {
        MallOrderDetailInfoUI.f(this.pqU).setSelected(true);
        MallOrderDetailInfoUI.g(this.pqU).setSelected(false);
        MallOrderDetailInfoUI.a(this.pqU, 100);
        AppMethodBeat.o(43802);
        return;
      }
      MallOrderDetailInfoUI.f(this.pqU).setSelected(false);
      MallOrderDetailInfoUI.g(this.pqU).setSelected(true);
      MallOrderDetailInfoUI.a(this.pqU, -100);
    }
    AppMethodBeat.o(43802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.7
 * JD-Core Version:    0.7.0.1
 */