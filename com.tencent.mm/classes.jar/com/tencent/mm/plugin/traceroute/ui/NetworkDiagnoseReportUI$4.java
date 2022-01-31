package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;

final class NetworkDiagnoseReportUI$4
  implements View.OnClickListener
{
  NetworkDiagnoseReportUI$4(NetworkDiagnoseReportUI paramNetworkDiagnoseReportUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(NetworkDiagnoseReportUI.access$100()))
    {
      paramView = new File(NetworkDiagnoseReportUI.access$100());
      if (paramView.exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.fromFile(paramView), "text/plain");
        localIntent.addFlags(268435456);
        this.pJs.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.4
 * JD-Core Version:    0.7.0.1
 */