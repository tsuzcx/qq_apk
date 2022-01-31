package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.n;

final class NetworkDiagnoseIntroUI$2
  implements View.OnClickListener
{
  NetworkDiagnoseIntroUI$2(NetworkDiagnoseIntroUI paramNetworkDiagnoseIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26012);
    paramView = new Intent();
    paramView.putExtra("title", this.tny.getString(2131302170));
    paramView.putExtra("rawUrl", this.tny.getString(2131304454));
    paramView.putExtra("showShare", false);
    a.gmO.i(paramView, this.tny.getContext());
    AppMethodBeat.o(26012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.2
 * JD-Core Version:    0.7.0.1
 */