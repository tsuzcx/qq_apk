package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class BaseSOSWebViewUI$12
  implements View.OnTouchListener
{
  BaseSOSWebViewUI$12(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.rtA.cfr().getEditText().clearFocus();
    this.rtA.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.12
 * JD-Core Version:    0.7.0.1
 */