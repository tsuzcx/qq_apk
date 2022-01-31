package com.tencent.mm.view.popview;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;

final class EmojiPopView$1
  implements EmojiStatusView.b
{
  EmojiPopView$1(EmojiPopView paramEmojiPopView) {}
  
  public final void jj(int paramInt)
  {
    AppMethodBeat.i(63063);
    if (paramInt == 1)
    {
      EmojiPopView.a(this.AUD).setVisibility(8);
      EmojiPopView.b(this.AUD).setVisibility(0);
      AppMethodBeat.o(63063);
      return;
    }
    EmojiPopView.b(this.AUD).setVisibility(4);
    EmojiPopView.a(this.AUD).setVisibility(0);
    AppMethodBeat.o(63063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView.1
 * JD-Core Version:    0.7.0.1
 */