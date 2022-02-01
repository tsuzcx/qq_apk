package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class TalkRoomUI$15
  implements View.OnTouchListener
{
  TalkRoomUI$15(TalkRoomUI paramTalkRoomUI, TalkRoomUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(29605);
    paramView = this.yKs;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramView.cEZ = paramMotionEvent.getX();
      paramView.cFa = paramMotionEvent.getY();
      paramView.yKt = bt.GC();
      AppMethodBeat.o(29605);
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      float f1 = Math.abs(paramMotionEvent.getX() - paramView.cEZ);
      float f2 = paramView.cFa - paramMotionEvent.getY();
      if ((f2 >= 100.0F) && (f2 / f1 > 2.0F) && (f2 / (float)bt.aS(paramView.yKt) > 0.6F))
      {
        paramView.dNo();
        AppMethodBeat.o(29605);
        return true;
      }
    }
    AppMethodBeat.o(29605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.15
 * JD-Core Version:    0.7.0.1
 */