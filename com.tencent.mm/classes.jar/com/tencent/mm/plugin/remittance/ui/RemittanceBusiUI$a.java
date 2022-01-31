package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class RemittanceBusiUI$a
{
  private View jIo;
  private float marginTop;
  private float qoO;
  private float qoP;
  private TenpaySecureEditText qoQ;
  private TextView qoR;
  private RelativeLayout qoS;
  
  RemittanceBusiUI$a(RemittanceBusiUI paramRemittanceBusiUI, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(44930);
    this.qoO = paramInt1;
    this.qoP = paramInt2;
    this.marginTop = paramFloat;
    AppMethodBeat.o(44930);
  }
  
  final void update()
  {
    AppMethodBeat.i(44931);
    RemittanceBusiUI.a(this.qoF).setTextSize(1, this.qoP);
    RemittanceBusiUI.b(this.qoF).setTextSize(1, this.qoO);
    if (this.qoR == null) {
      this.qoR = ((TextView)RemittanceBusiUI.c(this.qoF).findViewById(2131820696));
    }
    if (this.qoR != null) {
      this.qoR.setTextSize(this.qoO);
    }
    if (this.qoQ == null) {
      this.qoQ = ((TenpaySecureEditText)RemittanceBusiUI.c(this.qoF).findViewById(2131820689));
    }
    if (this.qoQ != null) {
      this.qoQ.setTextSize(this.qoP);
    }
    if (this.jIo == null) {
      this.jIo = this.qoQ.findViewById(2131829383);
    }
    if (this.jIo != null) {
      this.jIo.setMinimumHeight(BackwardSupportUtil.b.b(this.qoF, RemittanceBusiUI.d(this.qoF).qoP));
    }
    if (this.qoS == null) {
      this.qoS = ((RelativeLayout)this.qoF.findViewById(2131827221));
    }
    if (this.qoS != null) {
      ((LinearLayout.LayoutParams)this.qoS.getLayoutParams()).topMargin = BackwardSupportUtil.b.b(this.qoF, this.marginTop);
    }
    AppMethodBeat.o(44931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.a
 * JD-Core Version:    0.7.0.1
 */