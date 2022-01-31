package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ay;
import java.util.LinkedList;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25347);
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
    {
      ab.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
      paramView = (com.tencent.mm.pluginsdk.ui.preference.b)paramView.getTag();
      if ((paramView == null) || (bo.isNullOrNil(paramView.username)))
      {
        ab.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
        AppMethodBeat.o(25347);
        return;
      }
      ad localad = com.tencent.mm.pluginsdk.ui.preference.b.a(d.alh().ase(paramView.username));
      a locala = new a(b.a(this.sXN), new b.2.1(this, paramView, localad));
      ab.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(paramView.qQk));
      locala.amg(localad.dra);
      locala.b(paramView.username, localLinkedList, true);
    }
    AppMethodBeat.o(25347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.2
 * JD-Core Version:    0.7.0.1
 */