package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TalkRoomPopupNav$1
  implements View.OnClickListener
{
  TalkRoomPopupNav$1(TalkRoomPopupNav paramTalkRoomPopupNav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30006);
    if (TalkRoomPopupNav.a(this.zpT) != null) {
      TalkRoomPopupNav.a(this.zpT).dEE();
    }
    AppMethodBeat.o(30006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav.1
 * JD-Core Version:    0.7.0.1
 */