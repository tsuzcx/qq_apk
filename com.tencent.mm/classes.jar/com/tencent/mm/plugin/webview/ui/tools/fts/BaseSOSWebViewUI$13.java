package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class BaseSOSWebViewUI$13
  implements View.OnTouchListener
{
  BaseSOSWebViewUI$13(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8343);
    this.vjG.dfA().getEditText().clearFocus();
    this.vjG.hideVKB();
    AppMethodBeat.o(8343);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.13
 * JD-Core Version:    0.7.0.1
 */