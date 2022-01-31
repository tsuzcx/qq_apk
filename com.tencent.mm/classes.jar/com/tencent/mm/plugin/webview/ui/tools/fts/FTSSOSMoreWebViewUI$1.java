package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

final class FTSSOSMoreWebViewUI$1
  implements View.OnTouchListener
{
  FTSSOSMoreWebViewUI$1(FTSSOSMoreWebViewUI paramFTSSOSMoreWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8523);
    this.vlj.dfA().naN.clearFocus();
    this.vlj.hideVKB();
    AppMethodBeat.o(8523);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */