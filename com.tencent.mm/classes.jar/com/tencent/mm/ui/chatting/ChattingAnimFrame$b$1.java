package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChattingAnimFrame$b$1
  implements View.OnLayoutChangeListener
{
  ChattingAnimFrame$b$1(ChattingAnimFrame.b paramb) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(30506);
    this.zxR.resolve();
    AppMethodBeat.o(30506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.b.1
 * JD-Core Version:    0.7.0.1
 */