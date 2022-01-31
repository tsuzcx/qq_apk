package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bk;

final class TalkRoomUI$15
  implements View.OnTouchListener
{
  TalkRoomUI$15(TalkRoomUI paramTalkRoomUI, TalkRoomUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.pCn;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramView.fSy = paramMotionEvent.getX();
      paramView.fSz = paramMotionEvent.getY();
      paramView.pCo = bk.UZ();
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      float f1 = Math.abs(paramMotionEvent.getX() - paramView.fSy);
      float f2 = paramView.fSz - paramMotionEvent.getY();
      if ((f2 >= 100.0F) && (f2 / f1 > 2.0F) && (f2 / (float)bk.cp(paramView.pCo) > 0.6F))
      {
        paramView.bMS();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.15
 * JD-Core Version:    0.7.0.1
 */