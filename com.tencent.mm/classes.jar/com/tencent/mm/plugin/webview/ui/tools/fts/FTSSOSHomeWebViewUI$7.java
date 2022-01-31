package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$7
  implements AdapterView.OnItemClickListener
{
  FTSSOSHomeWebViewUI$7(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(153290);
    paramAdapterView = FTSSOSHomeWebViewUI.v(this.vkS).KM(paramInt);
    this.vkS.dfA().o(paramAdapterView.content, null);
    if (paramAdapterView.type == 2)
    {
      FTSSOSHomeWebViewUI.a(this.vkS, paramAdapterView, 1);
      FTSSOSHomeWebViewUI.e(this.vkS, 1);
    }
    this.vkS.aMm();
    AppMethodBeat.o(153290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */