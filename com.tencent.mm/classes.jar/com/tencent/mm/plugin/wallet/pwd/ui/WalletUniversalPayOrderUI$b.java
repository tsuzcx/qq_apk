package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class WalletUniversalPayOrderUI$b
{
  public CdnImageView HLU;
  public TextView HLV;
  public ImageView HLW;
  public View lJI;
  
  public WalletUniversalPayOrderUI$b(View paramView)
  {
    AppMethodBeat.i(69835);
    this.lJI = paramView;
    this.HLU = ((CdnImageView)paramView.findViewById(2131310357));
    this.HLV = ((TextView)paramView.findViewById(2131310358));
    this.HLW = ((ImageView)paramView.findViewById(2131310356));
    AppMethodBeat.o(69835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.b
 * JD-Core Version:    0.7.0.1
 */