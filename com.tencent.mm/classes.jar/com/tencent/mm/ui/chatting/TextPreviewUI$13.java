package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class TextPreviewUI$13
  implements View.OnClickListener
{
  TextPreviewUI$13(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31057);
    paramView = new Intent(this.zCJ, WebViewUI.class);
    paramView.putExtra("rawUrl", bh.r(TextPreviewUI.b(this.zCJ)));
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("needRedirect", false);
    this.zCJ.startActivity(paramView);
    AppMethodBeat.o(31057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */