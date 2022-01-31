package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public final class WalletLqtPlanHomeUI$b
{
  public View iDS;
  public WalletTextView tRc;
  public ImageView tRd;
  public TextView tRe;
  public TextView tRf;
  public TextView tRg;
  public TextView tRh;
  public LinearLayout tRi;
  
  public WalletLqtPlanHomeUI$b(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, View paramView)
  {
    AppMethodBeat.i(45621);
    this.iDS = paramView;
    this.tRc = ((WalletTextView)paramView.findViewById(2131825503));
    this.tRd = ((ImageView)paramView.findViewById(2131825504));
    this.tRh = ((TextView)paramView.findViewById(2131825505));
    this.tRe = ((TextView)paramView.findViewById(2131825506));
    this.tRf = ((TextView)paramView.findViewById(2131825507));
    this.tRg = ((TextView)paramView.findViewById(2131825509));
    this.tRi = ((LinearLayout)paramView.findViewById(2131825508));
    int i = a.fromDPToPix(paramWalletLqtPlanHomeUI.getContext(), 50);
    bo.n(this.tRd, i, i, i, i);
    AppMethodBeat.o(45621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.b
 * JD-Core Version:    0.7.0.1
 */