package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSBaseWebViewUI$1
  implements View.OnTouchListener
{
  FTSBaseWebViewUI$1(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80581);
    this.CDb.hideVKB();
    this.CDb.eFd();
    AppMethodBeat.o(80581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */