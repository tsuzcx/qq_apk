package com.tencent.mm.plugin.remittance.ui;

import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class RemittanceBusiUI$37
  implements Runnable
{
  RemittanceBusiUI$37(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(206336);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)RemittanceBusiUI.aa(this.IrV).getLayoutParams();
    localLayoutParams.width = (RemittanceBusiUI.ab(this.IrV).getRight() + a.fromDPToPix(this.IrV.getContext(), 8));
    localLayoutParams.height = a.fromDPToPix(this.IrV.getContext(), 36);
    RemittanceBusiUI.aa(this.IrV).setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)RemittanceBusiUI.ac(this.IrV).getLayoutParams();
    localLayoutParams.addRule(3, a.f.remittance_busi_warning_layout);
    localLayoutParams.topMargin = a.fromDPToPix(this.IrV.getContext(), 16);
    RemittanceBusiUI.ac(this.IrV).setLayoutParams(localLayoutParams);
    RemittanceBusiUI.ad(this.IrV);
    RemittanceBusiUI.af(this.IrV).setMaxWidth(RemittanceBusiUI.ae(this.IrV).getWidth() - a.fromDPToPix(this.IrV.getContext(), 20) - a.fromDPToPix(this.IrV.getContext(), 8) - a.fromDPToPix(this.IrV.getContext(), 12) - a.fromDPToPix(this.IrV.getContext(), 16));
    AppMethodBeat.o(206336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.37
 * JD-Core Version:    0.7.0.1
 */