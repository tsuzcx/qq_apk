package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

final class NetworkDiagnoseReportUI$4
  implements View.OnClickListener
{
  NetworkDiagnoseReportUI$4(NetworkDiagnoseReportUI paramNetworkDiagnoseReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26019);
    if (!bo.isNullOrNil(NetworkDiagnoseReportUI.access$100()))
    {
      paramView = new File(NetworkDiagnoseReportUI.access$100());
      if (paramView.exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        k.a(this.tnG.getContext(), localIntent, paramView, "text/plain");
        localIntent.addFlags(268435456);
        this.tnG.startActivity(localIntent);
      }
    }
    AppMethodBeat.o(26019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.4
 * JD-Core Version:    0.7.0.1
 */