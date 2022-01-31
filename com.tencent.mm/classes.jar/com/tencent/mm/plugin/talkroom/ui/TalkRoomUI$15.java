package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class TalkRoomUI$15
  implements View.OnTouchListener
{
  TalkRoomUI$15(TalkRoomUI paramTalkRoomUI, TalkRoomUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25922);
    paramView = this.tdX;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramView.bTE = paramMotionEvent.getX();
      paramView.bTF = paramMotionEvent.getY();
      paramView.tdY = bo.yB();
      AppMethodBeat.o(25922);
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      float f1 = Math.abs(paramMotionEvent.getX() - paramView.bTE);
      float f2 = paramView.bTF - paramMotionEvent.getY();
      if ((f2 >= 100.0F) && (f2 / f1 > 2.0F) && (f2 / (float)bo.av(paramView.tdY) > 0.6F))
      {
        paramView.cHV();
        AppMethodBeat.o(25922);
        return true;
      }
    }
    AppMethodBeat.o(25922);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.15
 * JD-Core Version:    0.7.0.1
 */