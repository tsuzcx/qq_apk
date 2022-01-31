package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.ap.1;
import com.tencent.mm.ui.chatting.ap.2;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.l;
import java.util.List;

final class j$5$2
  implements n.d
{
  j$5$2(j.5 param5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramMenuItem.getItemId() == 0) {
      j.a(this.vpv.vpr, true);
    }
    for (;;)
    {
      l.a(this.vpv.vpr.byx.vtz.getContext(), j.c(this.vpv.vpr), j.d(this.vpv.vpr), j.e(this.vpv.vpr).field_username, this.vpv.vpr);
      return;
      if (2 == paramMenuItem.getItemId())
      {
        paramMenuItem = this.vpv.vpr.byx.vtz.getContext();
        ad localad = j.e(this.vpv.vpr);
        List localList = j.c(this.vpv.vpr);
        boolean bool = j.d(this.vpv.vpr);
        if (localList.size() != 0)
        {
          if (!k.dQ(localList)) {
            break label201;
          }
          y.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
          h.a(paramMenuItem, paramMenuItem.getString(R.l.contain_undownload_msg_send), "", new ap.1(), null);
        }
        for (;;)
        {
          this.vpv.vpr.cEf();
          return;
          label201:
          if (!k.a(localList, null))
          {
            y.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
            h.a(paramMenuItem, paramMenuItem.getString(R.l.invalid_friend_msg_warning), "", paramMenuItem.getString(R.l.retransmit), paramMenuItem.getString(R.l.app_cancel), new ap.2(paramMenuItem, localad, localList, bool), null);
          }
          else
          {
            ap.a(paramMenuItem, localad, localList, bool);
          }
        }
      }
      j.a(this.vpv.vpr, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.5.2
 * JD-Core Version:    0.7.0.1
 */