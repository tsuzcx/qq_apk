package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class RemittanceNewBaseUI$35
  implements Runnable
{
  RemittanceNewBaseUI$35(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(268514);
    Object localObject = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.x(this.IuE).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = (RemittanceNewBaseUI.y(this.IuE).getRight() + a.fromDPToPix(this.IuE.getContext(), 8));
    ((RelativeLayout.LayoutParams)localObject).height = a.fromDPToPix(this.IuE.getContext(), 36);
    RemittanceNewBaseUI.x(this.IuE).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)RemittanceNewBaseUI.z(this.IuE).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = a.fromDPToPix(this.IuE.getContext(), 16);
    RemittanceNewBaseUI.z(this.IuE).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)RemittanceNewBaseUI.A(this.IuE).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = a.fromDPToPix(this.IuE.getContext(), 0);
    RemittanceNewBaseUI.A(this.IuE).setLayoutParams((ViewGroup.LayoutParams)localObject);
    RemittanceNewBaseUI.C(this.IuE).setMaxWidth(RemittanceNewBaseUI.B(this.IuE).getWidth() - a.fromDPToPix(this.IuE.getContext(), 20) - a.fromDPToPix(this.IuE.getContext(), 8) - a.fromDPToPix(this.IuE.getContext(), 12) - a.fromDPToPix(this.IuE.getContext(), 16));
    AppMethodBeat.o(268514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.35
 * JD-Core Version:    0.7.0.1
 */