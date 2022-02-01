package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class TalkRoomUI$15
  implements View.OnTouchListener
{
  TalkRoomUI$15(TalkRoomUI paramTalkRoomUI, TalkRoomUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(29605);
    paramView = this.SOU;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramView.fif = paramMotionEvent.getX();
      paramView.fig = paramMotionEvent.getY();
      paramView.SOV = Util.currentTicks();
      AppMethodBeat.o(29605);
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      float f1 = Math.abs(paramMotionEvent.getX() - paramView.fif);
      float f2 = paramView.fig - paramMotionEvent.getY();
      if ((f2 >= 100.0F) && (f2 / f1 > 2.0F) && (f2 / (float)Util.ticksToNow(paramView.SOV) > 0.6F))
      {
        paramView.hCR();
        AppMethodBeat.o(29605);
        return true;
      }
    }
    AppMethodBeat.o(29605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.15
 * JD-Core Version:    0.7.0.1
 */