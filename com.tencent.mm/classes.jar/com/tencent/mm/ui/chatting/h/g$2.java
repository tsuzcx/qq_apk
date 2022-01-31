package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;

final class g$2
  implements c.e
{
  g$2(g paramg) {}
  
  public final void a(int paramInt, c.b paramb)
  {
    Context localContext = this.vzd.mContext;
    String str = this.vzd.drJ;
    long l = paramb.bIt;
    if (str == null)
    {
      y.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
      return;
    }
    au.Hx();
    l = c.Fy().fd(l).field_msgId;
    y.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
    if (s.fn(str))
    {
      au.Hx();
      if (c.FF().in(str) == null)
      {
        y.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
        h.a(localContext, localContext.getString(R.l.remind_not_found_room), localContext.getString(R.l.tip_title), null);
      }
    }
    else
    {
      au.Hx();
      paramb = c.Fw().abl(str);
      if ((paramb == null) || (!a.gR(paramb.field_type)))
      {
        if (paramb == null) {
          y.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
        }
        for (;;)
        {
          h.a(localContext, localContext.getString(R.l.remind_not_found_room), localContext.getString(R.l.tip_title), null);
          return;
          y.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
        }
      }
    }
    paramb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
    paramb.setClass(localContext, ChattingUI.class);
    localContext.startActivity(paramb);
  }
  
  public final void a(View paramView, int paramInt, c.b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.g.2
 * JD-Core Version:    0.7.0.1
 */