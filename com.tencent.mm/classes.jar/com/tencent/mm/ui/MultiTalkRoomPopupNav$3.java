package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class MultiTalkRoomPopupNav$3
  implements View.OnClickListener
{
  MultiTalkRoomPopupNav$3(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29771);
    ab.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
    int i;
    if (MultiTalkRoomPopupNav.d(this.zdP) == MultiTalkRoomPopupNav.b.zdR)
    {
      ab.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
      boolean bool = ((a)g.E(a.class)).Uq(this.oUa);
      ((a)g.E(a.class)).Ur(this.oUa);
      paramView = h.qsU;
      if (bool)
      {
        i = 0;
        paramView.e(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(this.zdP), Integer.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomKey) });
      }
    }
    for (;;)
    {
      MultiTalkRoomPopupNav.e(this.zdP).close();
      MultiTalkRoomPopupNav.f(this.zdP).setVisibility(0);
      MultiTalkRoomPopupNav.g(this.zdP).setVisibility(0);
      MultiTalkRoomPopupNav.h(this.zdP).setVisibility(8);
      AppMethodBeat.o(29771);
      return;
      i = 1;
      break;
      h.qsU.e(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(this.zdP), Integer.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomKey) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.3
 * JD-Core Version:    0.7.0.1
 */