package com.tencent.mm.plugin.traceroute.ui;

import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.MMProgressBar.a;

final class NetworkDiagnoseUI$3
  implements MMProgressBar.a
{
  NetworkDiagnoseUI$3(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void zG(int paramInt)
  {
    if (paramInt < 5)
    {
      NetworkDiagnoseUI.f(this.pJy).setText(this.pJy.getString(R.l.connecting_server));
      return;
    }
    if ((paramInt >= 5) && (paramInt < 95))
    {
      NetworkDiagnoseUI.f(this.pJy).setText(this.pJy.getString(R.l.getting_route_path));
      return;
    }
    NetworkDiagnoseUI.f(this.pJy).setText(this.pJy.getString(R.l.uploading_report));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.3
 * JD-Core Version:    0.7.0.1
 */