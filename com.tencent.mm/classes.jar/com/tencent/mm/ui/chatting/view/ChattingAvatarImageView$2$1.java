package com.tencent.mm.ui.chatting.view;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;

final class ChattingAvatarImageView$2$1
  implements Runnable
{
  ChattingAvatarImageView$2$1(ChattingAvatarImageView.2 param2, int[] paramArrayOfInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(221414);
    int[] arrayOfInt = new int[2];
    View localView = ChattingAvatarImageView.f(this.Ofr.JXA).getContentView();
    localView.getLocationOnScreen(arrayOfInt);
    localView = localView.findViewById(2131308443);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.leftMargin = (this.wFR[0] + this.Ofr.JXA.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
    localView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(221414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView.2.1
 * JD-Core Version:    0.7.0.1
 */