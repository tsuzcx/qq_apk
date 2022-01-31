package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomScrollView.a;

final class TextPreviewUI$2
  implements CustomScrollView.a
{
  TextPreviewUI$2(TextPreviewUI paramTextPreviewUI) {}
  
  public final void a(ScrollView paramScrollView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31044);
    TextPreviewUI.f(this.zCJ);
    int i;
    if (paramScrollView.getChildAt(0).getMeasuredHeight() == paramScrollView.getHeight() + paramScrollView.getScrollY())
    {
      i = 1;
      if (i != 0) {
        TextPreviewUI.a(this.zCJ, paramScrollView.getScrollY());
      }
      if ((paramScrollView.getScrollY() > 0) && ((paramScrollView.getScrollY() < TextPreviewUI.g(this.zCJ) - 10) || (TextPreviewUI.g(this.zCJ) <= 0))) {
        break label119;
      }
      TextPreviewUI.h(this.zCJ);
    }
    label119:
    while (!TextPreviewUI.i(this.zCJ))
    {
      TextPreviewUI.b(this.zCJ, paramInt1 - paramInt2);
      AppMethodBeat.o(31044);
      return;
      i = 0;
      break;
    }
    if (paramInt2 > paramInt1) {
      TextPreviewUI.h(this.zCJ);
    }
    for (;;)
    {
      TextPreviewUI.a(this.zCJ, false);
      break;
      if (paramInt2 < paramInt1) {
        TextPreviewUI.j(this.zCJ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */