package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSBaseWebViewUI$7
  implements View.OnClickListener
{
  FTSBaseWebViewUI$7(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210075);
    this.CDb.finish();
    AppMethodBeat.o(210075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */