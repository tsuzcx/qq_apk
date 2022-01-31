package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class TalkRoomUI$13
  implements View.OnTouchListener
{
  TalkRoomUI$13(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return false;
        TalkRoomUI.b(this.pCk, TalkRoomUI.a(this.pCk, paramMotionEvent));
      } while (!TalkRoomUI.k(this.pCk));
      TalkRoomUI.l(this.pCk).setImageResource(R.g.talk_room_mic_btn_pressed);
      au.b(ae.getContext(), R.l.talkroom_press, new au.a()
      {
        public final void ug()
        {
          y.i("MicroMsg.TalkRoomUI", "play press sound end");
        }
      });
      TalkRoomUI.a(this.pCk, 1);
      TalkRoomUI.d(this.pCk);
      y.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
      TalkRoomUI.a(this.pCk, bk.UZ());
      b.bMu().RJ();
      TalkRoomUI.m(this.pCk);
      return false;
    } while ((!TalkRoomUI.k(this.pCk)) || (TalkRoomUI.a(this.pCk, paramMotionEvent)) || (!TalkRoomUI.k(this.pCk)));
    TalkRoomUI.b(this.pCk, false);
    if (TalkRoomUI.b(this.pCk) == 5)
    {
      y.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
      TalkRoomUI.n(this.pCk).stopTimer();
      TalkRoomUI.o(this.pCk).stopTimer();
    }
    TalkRoomUI.l(this.pCk).setImageResource(R.g.talk_room_mic_btn_normal);
    TalkRoomUI.a(this.pCk, 0);
    TalkRoomUI.d(this.pCk);
    TalkRoomUI.p(this.pCk).stopTimer();
    b.bMu().RK();
    au.b(ae.getContext(), R.l.talkroom_up, new TalkRoomUI.13.2(this));
    TalkRoomUI.m(this.pCk);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.13
 * JD-Core Version:    0.7.0.1
 */