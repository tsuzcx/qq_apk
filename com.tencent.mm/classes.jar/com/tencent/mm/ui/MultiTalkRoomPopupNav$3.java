package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.bf.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class MultiTalkRoomPopupNav$3
  implements View.OnClickListener
{
  MultiTalkRoomPopupNav$3(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav, String paramString) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
    int i;
    if (MultiTalkRoomPopupNav.d(this.uPC) == MultiTalkRoomPopupNav.b.uPE)
    {
      y.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
      boolean bool = ((a)g.r(a.class)).IB(this.mul);
      ((a)g.r(a.class)).IC(this.mul);
      paramView = h.nFQ;
      if (bool)
      {
        i = 0;
        paramView.f(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(this.uPC), Integer.valueOf(MultiTalkRoomPopupNav.c(this.uPC).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.uPC).field_roomKey) });
      }
    }
    for (;;)
    {
      MultiTalkRoomPopupNav.a.a(MultiTalkRoomPopupNav.e(this.uPC));
      MultiTalkRoomPopupNav.f(this.uPC).setVisibility(0);
      MultiTalkRoomPopupNav.g(this.uPC).setVisibility(0);
      MultiTalkRoomPopupNav.h(this.uPC).setVisibility(8);
      return;
      i = 1;
      break;
      h.nFQ.f(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(this.uPC), Integer.valueOf(MultiTalkRoomPopupNav.c(this.uPC).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.uPC).field_roomKey) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.3
 * JD-Core Version:    0.7.0.1
 */