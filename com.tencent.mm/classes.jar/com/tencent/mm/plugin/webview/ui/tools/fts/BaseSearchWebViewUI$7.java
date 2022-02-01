package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseSearchWebViewUI$7
  implements View.OnTouchListener
{
  BaseSearchWebViewUI$7(BaseSearchWebViewUI paramBaseSearchWebViewUI, boolean paramBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208169);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSearchWebViewUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = this.leR;
    a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSearchWebViewUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(208169);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */