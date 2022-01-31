package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.d.d.c;

final class FTSSOSHomeWebViewUI$17
  implements View.OnTouchListener
{
  FTSSOSHomeWebViewUI$17(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI, AbsoluteLayout paramAbsoluteLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = FTSSOSHomeWebViewUI.a(this.ruD);
    d.c localc = paramView.ujd;
    if (localc != null) {
      localc.sendMessage(Message.obtain(paramView.ujd, 15, paramMotionEvent));
    }
    return this.qWO.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.17
 * JD-Core Version:    0.7.0.1
 */