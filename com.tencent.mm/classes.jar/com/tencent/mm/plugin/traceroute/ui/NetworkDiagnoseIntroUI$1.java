package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.s;

final class NetworkDiagnoseIntroUI$1
  implements View.OnClickListener
{
  NetworkDiagnoseIntroUI$1(NetworkDiagnoseIntroUI paramNetworkDiagnoseIntroUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(this.pJk);
      return;
    }
    if (au.Dk().KG() == 0)
    {
      Toast.makeText(this.pJk, this.pJk.getString(R.l.fmt_iap_err), 0).show();
      return;
    }
    paramView = new Intent(this.pJk, NetworkDiagnoseUI.class);
    this.pJk.startActivity(paramView);
    this.pJk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.1
 * JD-Core Version:    0.7.0.1
 */