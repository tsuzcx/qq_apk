package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

final class NetworkDiagnoseReportUI$3
  implements View.OnClickListener
{
  NetworkDiagnoseReportUI$3(NetworkDiagnoseReportUI paramNetworkDiagnoseReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26018);
    paramView = new Intent("android.intent.action.SEND");
    paramView.addFlags(268435456);
    paramView.putExtra("android.intent.extra.EMAIL", new String[] { "WeChat_Log@qq.com" });
    paramView.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(this.tnG));
    paramView.putExtra("android.intent.extra.STREAM", k.d(this.tnG.getContext(), new File(NetworkDiagnoseReportUI.access$100())));
    paramView.setType("text/plain");
    this.tnG.startActivity(paramView);
    AppMethodBeat.o(26018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.3
 * JD-Core Version:    0.7.0.1
 */