package com.tencent.mm.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

final class MultiTalkRoomPopupNav$2
  implements View.OnClickListener
{
  MultiTalkRoomPopupNav$2(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29770);
    ab.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
    if (this.oUa != null)
    {
      if (((a)g.E(a.class)).bSB())
      {
        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
        com.tencent.mm.ui.base.h.b(this.zdP.getContext(), ah.getContext().getString(2131301684), null, true);
        AppMethodBeat.o(29770);
        return;
      }
      paramView = ((a)g.E(a.class)).Ul(MultiTalkRoomPopupNav.b(this.zdP));
      if (paramView.size() != 1) {
        break label245;
      }
      MultiTalkRoomPopupNav.atq(this.oUa);
      com.tencent.mm.plugin.report.service.h.qsU.e(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(this.zdP), Integer.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomKey) });
    }
    for (;;)
    {
      MultiTalkRoomPopupNav.e(this.zdP).close();
      MultiTalkRoomPopupNav.f(this.zdP).setVisibility(0);
      MultiTalkRoomPopupNav.g(this.zdP).setVisibility(0);
      MultiTalkRoomPopupNav.h(this.zdP).setVisibility(8);
      AppMethodBeat.o(29770);
      return;
      label245:
      int i;
      if (paramView.size() >= 9)
      {
        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramView.size());
        com.tencent.mm.ui.base.h.b(this.zdP.getContext(), ah.getContext().getString(2131301688, new Object[] { Integer.valueOf(9) }), null, true);
        paramView = com.tencent.mm.plugin.report.service.h.qsU;
        if (MultiTalkRoomPopupNav.d(this.zdP) == MultiTalkRoomPopupNav.b.zdR) {}
        for (i = 1;; i = 0)
        {
          paramView.e(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(this.zdP), Integer.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomKey) });
          AppMethodBeat.o(29770);
          return;
        }
      }
      if (((a)g.E(a.class)).bSA())
      {
        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
        com.tencent.mm.ui.base.h.b(this.zdP.getContext(), ah.getContext().getString(2131301682), null, true);
        paramView = com.tencent.mm.plugin.report.service.h.qsU;
        if (MultiTalkRoomPopupNav.d(this.zdP) == MultiTalkRoomPopupNav.b.zdR) {}
        for (i = 1;; i = 0)
        {
          paramView.e(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(this.zdP), Integer.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.zdP).field_roomKey) });
          AppMethodBeat.o(29770);
          return;
        }
      }
      MultiTalkRoomPopupNav.a(this.zdP, this.oUa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.2
 * JD-Core Version:    0.7.0.1
 */