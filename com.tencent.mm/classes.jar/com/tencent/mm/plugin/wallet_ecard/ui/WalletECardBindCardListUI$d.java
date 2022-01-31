package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletECardBindCardListUI$d
  implements WalletECardBindCardListUI.b
{
  TextView iJG;
  TextView ksU;
  CdnImageView uzH;
  
  public WalletECardBindCardListUI$d(WalletECardBindCardListUI paramWalletECardBindCardListUI, View paramView)
  {
    AppMethodBeat.i(48123);
    this.uzH = ((CdnImageView)paramView.findViewById(2131823468));
    this.iJG = ((TextView)paramView.findViewById(2131823469));
    this.ksU = ((TextView)paramView.findViewById(2131823470));
    AppMethodBeat.o(48123);
  }
  
  public final void a(View paramView, hg paramhg)
  {
    AppMethodBeat.i(48124);
    if (paramhg != null)
    {
      this.uzH.setRoundCorner(true);
      this.uzH.setUrl(paramhg.wtW);
      this.iJG.setText(String.format("%s %s(%s)", new Object[] { paramhg.nLq, paramhg.kwK, paramhg.wtU }));
      if (!bo.isNullOrNil(paramhg.wtY)) {
        this.ksU.setText(String.format("%s，%s", new Object[] { paramhg.ubQ, paramhg.wtY }));
      }
      while (paramhg.wtX)
      {
        ab.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramhg.nLq });
        paramView.setEnabled(false);
        this.iJG.setTextColor(this.uzF.getResources().getColor(2131689747));
        this.ksU.setTextColor(this.uzF.getResources().getColor(2131689747));
        AppMethodBeat.o(48124);
        return;
        this.ksU.setText(String.format("%s", new Object[] { paramhg.ubQ }));
      }
      paramView.setEnabled(true);
      this.iJG.setTextColor(this.uzF.getResources().getColor(2131689763));
      this.ksU.setTextColor(this.uzF.getResources().getColor(2131690318));
    }
    AppMethodBeat.o(48124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.d
 * JD-Core Version:    0.7.0.1
 */