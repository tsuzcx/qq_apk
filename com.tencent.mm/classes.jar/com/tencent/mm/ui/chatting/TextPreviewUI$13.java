package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class TextPreviewUI$13
  implements View.OnClickListener
{
  TextPreviewUI$13(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.vnn, WebViewUI.class);
    paramView.putExtra("rawUrl", bf.n(TextPreviewUI.d(this.vnn)));
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("needRedirect", false);
    this.vnn.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */