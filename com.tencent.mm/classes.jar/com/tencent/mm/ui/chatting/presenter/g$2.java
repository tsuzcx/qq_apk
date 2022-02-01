package com.tencent.mm.ui.chatting.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;

final class g$2
  implements c.e
{
  g$2(g paramg) {}
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(36568);
    paramView = this.aeIZ.mContext;
    String str = this.aeIZ.lMU;
    long l = paramb.msgId;
    if (str == null)
    {
      Log.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
      AppMethodBeat.o(36568);
      return;
    }
    bh.bCz();
    paramb = c.bzD().sl(l);
    if (paramb == null) {
      Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msg is null");
    }
    if (paramb == null) {}
    for (l = -1L;; l = paramb.field_msgId)
    {
      Log.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
      if (!au.bwE(str)) {
        break;
      }
      bh.bCz();
      if (c.bzK().Ju(str) != null) {
        break label270;
      }
      Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
      k.d(paramView, paramView.getString(R.l.gTg), paramView.getString(R.l.tip_title), null);
      AppMethodBeat.o(36568);
      return;
    }
    bh.bCz();
    paramb = c.bzA().JE(str);
    if ((paramb == null) || (!d.rs(paramb.field_type)))
    {
      if (paramb == null) {
        Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
      }
      for (;;)
      {
        k.d(paramView, paramView.getString(R.l.gTg), paramView.getString(R.l.tip_title), null);
        AppMethodBeat.o(36568);
        return;
        Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
      }
    }
    label270:
    paramb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
    paramb.setClass(paramView, ChattingUI.class);
    paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramb.aYi(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)paramb.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36568);
  }
  
  public final void b(View paramView, int paramInt, c.b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.g.2
 * JD-Core Version:    0.7.0.1
 */