package com.tencent.mm.pluginsdk.ui.chat;

import android.support.v4.view.t;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChattingScrollLayout$1
  implements Runnable
{
  ChattingScrollLayout$1(ChattingScrollLayout paramChattingScrollLayout, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(153740);
    ab.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: in runnable");
    ChattingScrollLayout.a(this.vYH);
    int j = ChattingScrollLayout.b(this.vYH);
    int k = ChattingScrollLayout.c(this.vYH);
    int i;
    OverScroller localOverScroller;
    int m;
    if (this.vYF == 0)
    {
      i = 350;
      localOverScroller = ChattingScrollLayout.d(this.vYH);
      m = ChattingScrollLayout.c(this.vYH);
      if (!this.vYG) {
        break label105;
      }
    }
    for (;;)
    {
      localOverScroller.startScroll(0, m, 0, j - k, i);
      t.R(this.vYH);
      AppMethodBeat.o(153740);
      return;
      i = 175;
      break;
      label105:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout.1
 * JD-Core Version:    0.7.0.1
 */