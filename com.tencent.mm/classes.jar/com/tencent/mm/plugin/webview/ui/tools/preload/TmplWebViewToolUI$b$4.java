package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.webview.preload.c;
import com.tencent.mm.ui.base.h;

final class TmplWebViewToolUI$b$4
  implements View.OnLongClickListener
{
  TmplWebViewToolUI$b$4(TmplWebViewToolUI.b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(this.rBM.rBJ.toString());
    h.b(this.rBM.rBF, paramView.toString(), "", true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.b.4
 * JD-Core Version:    0.7.0.1
 */