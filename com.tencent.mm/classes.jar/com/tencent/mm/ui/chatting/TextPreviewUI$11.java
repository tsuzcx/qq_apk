package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.textview.a;

final class TextPreviewUI$11
  implements View.OnClickListener
{
  TextPreviewUI$11(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    if ((TextPreviewUI.c(this.vnn) != null) && (!TextPreviewUI.c(this.vnn).cbz))
    {
      TextPreviewUI.c(this.vnn).cKJ();
      TextPreviewUI.c(this.vnn).cKI();
      return;
    }
    this.vnn.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.11
 * JD-Core Version:    0.7.0.1
 */