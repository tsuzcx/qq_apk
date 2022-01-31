package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bo;

final class TalkRoomUI$13
  implements View.OnTouchListener
{
  TalkRoomUI$13(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25920);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25920);
      return false;
      TalkRoomUI.b(this.tdT, TalkRoomUI.a(this.tdT, paramMotionEvent));
      if (TalkRoomUI.k(this.tdT))
      {
        TalkRoomUI.l(this.tdT).setImageResource(2130840529);
        ay.a(ah.getContext(), 2131304257, new ay.a()
        {
          public final void Es()
          {
            AppMethodBeat.i(25918);
            ab.i("MicroMsg.TalkRoomUI", "play press sound end");
            AppMethodBeat.o(25918);
          }
        });
        TalkRoomUI.a(this.tdT, 1);
        TalkRoomUI.d(this.tdT);
        ab.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
        TalkRoomUI.a(this.tdT, bo.yB());
        b.cHs().akS();
        TalkRoomUI.m(this.tdT);
        continue;
        if ((TalkRoomUI.k(this.tdT)) && (!TalkRoomUI.a(this.tdT, paramMotionEvent)) && (TalkRoomUI.k(this.tdT)))
        {
          TalkRoomUI.b(this.tdT, false);
          if (TalkRoomUI.b(this.tdT) == 5)
          {
            ab.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
            TalkRoomUI.n(this.tdT).stopTimer();
            TalkRoomUI.o(this.tdT).stopTimer();
          }
          TalkRoomUI.l(this.tdT).setImageResource(2130840528);
          TalkRoomUI.a(this.tdT, 0);
          TalkRoomUI.d(this.tdT);
          TalkRoomUI.p(this.tdT).stopTimer();
          b.cHs().akT();
          ay.a(ah.getContext(), 2131304260, new TalkRoomUI.13.2(this));
          TalkRoomUI.m(this.tdT);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.13
 * JD-Core Version:    0.7.0.1
 */