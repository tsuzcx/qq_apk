package com.tencent.mm.pluginsdk.ui.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView.b;

final class RTChattingEmojiView$1
  implements EmojiStatusView.b
{
  RTChattingEmojiView$1(RTChattingEmojiView paramRTChattingEmojiView) {}
  
  public final void jj(int paramInt)
  {
    AppMethodBeat.i(62489);
    if (paramInt == 0)
    {
      RTChattingEmojiView localRTChattingEmojiView = this.wao;
      if (RTChattingEmojiView.a(this.wao)) {}
      for (paramInt = 0;; paramInt = 1)
      {
        RTChattingEmojiView.a(localRTChattingEmojiView, paramInt);
        AppMethodBeat.o(62489);
        return;
      }
    }
    if (paramInt == -1)
    {
      RTChattingEmojiView.a(this.wao, 3);
      AppMethodBeat.o(62489);
      return;
    }
    RTChattingEmojiView.a(this.wao, 2);
    AppMethodBeat.o(62489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView.1
 * JD-Core Version:    0.7.0.1
 */