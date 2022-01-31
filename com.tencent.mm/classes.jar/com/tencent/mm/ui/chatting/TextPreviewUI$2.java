package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;

final class TextPreviewUI$2
  implements CustomScrollView.a
{
  TextPreviewUI$2(TextPreviewUI paramTextPreviewUI) {}
  
  public final void a(ScrollView paramScrollView, int paramInt1, int paramInt2)
  {
    TextPreviewUI.f(this.vnn);
    int i;
    if (paramScrollView.getChildAt(0).getMeasuredHeight() == paramScrollView.getHeight() + paramScrollView.getScrollY())
    {
      i = 1;
      if (i != 0) {
        TextPreviewUI.a(this.vnn, paramScrollView.getScrollY());
      }
      if ((paramScrollView.getScrollY() > 0) && ((paramScrollView.getScrollY() < TextPreviewUI.g(this.vnn) - 10) || (TextPreviewUI.g(this.vnn) <= 0))) {
        break label107;
      }
      TextPreviewUI.h(this.vnn);
    }
    label107:
    while (!TextPreviewUI.i(this.vnn))
    {
      TextPreviewUI.b(this.vnn, paramInt1 - paramInt2);
      return;
      i = 0;
      break;
    }
    if (paramInt2 > paramInt1) {
      TextPreviewUI.h(this.vnn);
    }
    for (;;)
    {
      TextPreviewUI.a(this.vnn, false);
      break;
      if (paramInt2 < paramInt1) {
        TextPreviewUI.j(this.vnn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */