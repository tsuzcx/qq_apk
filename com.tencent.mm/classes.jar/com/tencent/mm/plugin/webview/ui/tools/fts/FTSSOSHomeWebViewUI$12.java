package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

final class FTSSOSHomeWebViewUI$12
  implements View.OnTouchListener
{
  FTSSOSHomeWebViewUI$12(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153296);
    this.vkS.dfA().naN.clearFocus();
    this.vkS.hideVKB();
    AppMethodBeat.o(153296);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.12
 * JD-Core Version:    0.7.0.1
 */