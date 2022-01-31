package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import java.util.ArrayList;

final class WalletOfflineCoinPurseUI$20
  implements AdapterView.OnItemClickListener
{
  WalletOfflineCoinPurseUI$20(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, int paramInt) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(43526);
    this.pny.dismissDialog(this.pnP);
    WalletOfflineCoinPurseUI.Bb(paramInt);
    if (this.pnP == 1)
    {
      paramAdapterView = (String)WalletOfflineCoinPurseUI.F(this.pny).get(paramInt);
      if ((!TextUtils.isEmpty(paramAdapterView)) && (!paramAdapterView.equals(WalletOfflineCoinPurseUI.G(this.pny))))
      {
        WalletOfflineCoinPurseUI.a(this.pny, paramAdapterView);
        a.Wr(WalletOfflineCoinPurseUI.G(this.pny));
        k.bYF();
        k.bYH().pjW = WalletOfflineCoinPurseUI.G(this.pny);
        this.pny.bZg();
        WalletOfflineCoinPurseUI.C(this.pny);
        WalletOfflineCoinPurseUI.D(this.pny);
      }
    }
    AppMethodBeat.o(43526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.20
 * JD-Core Version:    0.7.0.1
 */