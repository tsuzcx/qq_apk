package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import java.util.ArrayList;

final class WalletOfflineCoinPurseUI$20
  implements AdapterView.OnItemClickListener
{
  WalletOfflineCoinPurseUI$20(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, int paramInt) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mNj.dismissDialog(this.mNA);
    WalletOfflineCoinPurseUI.vD(paramInt);
    if (this.mNA == 1)
    {
      paramAdapterView = (String)WalletOfflineCoinPurseUI.G(this.mNj).get(paramInt);
      if ((!TextUtils.isEmpty(paramAdapterView)) && (!paramAdapterView.equals(WalletOfflineCoinPurseUI.H(this.mNj))))
      {
        WalletOfflineCoinPurseUI.a(this.mNj, paramAdapterView);
        a.Kp(WalletOfflineCoinPurseUI.H(this.mNj));
        k.bpX();
        k.bpZ().mJH = WalletOfflineCoinPurseUI.H(this.mNj);
        this.mNj.bqx();
        WalletOfflineCoinPurseUI.D(this.mNj);
        WalletOfflineCoinPurseUI.E(this.mNj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.20
 * JD-Core Version:    0.7.0.1
 */