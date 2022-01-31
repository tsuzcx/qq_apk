package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ay;
import java.util.LinkedList;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
    {
      y.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
      paramView = (com.tencent.mm.pluginsdk.ui.preference.b)paramView.getTag();
      if ((paramView == null) || (bk.bl(paramView.username))) {
        y.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
      }
    }
    else
    {
      return;
    }
    ad localad = com.tencent.mm.pluginsdk.ui.preference.b.a(d.RX().abU(paramView.username));
    a locala = new a(b.a(this.pwh), new b.2.1(this, paramView, localad));
    y.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(paramView.ocd));
    locala.WA(localad.cCQ);
    locala.b(paramView.username, localLinkedList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.2
 * JD-Core Version:    0.7.0.1
 */