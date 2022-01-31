package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$7
  implements AdapterView.OnItemClickListener
{
  FTSSOSHomeWebViewUI$7(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = FTSSOSHomeWebViewUI.z(this.ruD).CR(paramInt);
    this.ruD.cfr().n(paramAdapterView.content, null);
    if (paramAdapterView.type == 2)
    {
      FTSSOSHomeWebViewUI.a(this.ruD, paramAdapterView, 1);
      FTSSOSHomeWebViewUI.e(this.ruD, 1);
    }
    this.ruD.apb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */