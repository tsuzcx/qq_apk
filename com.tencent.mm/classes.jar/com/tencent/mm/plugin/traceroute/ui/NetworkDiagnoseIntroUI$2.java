package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class NetworkDiagnoseIntroUI$2
  implements View.OnClickListener
{
  NetworkDiagnoseIntroUI$2(NetworkDiagnoseIntroUI paramNetworkDiagnoseIntroUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("title", this.pJk.getString(R.l.privacy_tip));
    paramView.putExtra("rawUrl", this.pJk.getString(R.l.url_agreement));
    paramView.putExtra("showShare", false);
    a.eUR.j(paramView, this.pJk.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.2
 * JD-Core Version:    0.7.0.1
 */