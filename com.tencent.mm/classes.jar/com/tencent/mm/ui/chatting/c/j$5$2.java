package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.am.1;
import com.tencent.mm.ui.chatting.am.2;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.k;
import java.util.List;

final class j$5$2
  implements n.d
{
  j$5$2(j.5 param5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31312);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(31312);
      return;
    case 0: 
      j.a(this.zEX.zET, true);
      k.a(this.zEX.zET.caz.zJz.getContext(), j.c(this.zEX.zET), j.d(this.zEX.zET), j.e(this.zEX.zET).field_username, this.zEX.zET);
      AppMethodBeat.o(31312);
      return;
    case 1: 
      j.a(this.zEX.zET, false);
      k.a(this.zEX.zET.caz.zJz.getContext(), j.c(this.zEX.zET), j.d(this.zEX.zET), j.e(this.zEX.zET).field_username, this.zEX.zET);
      AppMethodBeat.o(31312);
      return;
    }
    paramMenuItem = this.zEX.zET.caz.zJz.getContext();
    ad localad = j.e(this.zEX.zET);
    List localList = j.c(this.zEX.zET);
    boolean bool = j.d(this.zEX.zET);
    if (localList.size() != 0)
    {
      if (!com.tencent.mm.ui.chatting.j.eZ(localList)) {
        break label314;
      }
      ab.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      h.a(paramMenuItem, paramMenuItem.getString(2131298862), "", new am.1(), null);
    }
    for (;;)
    {
      this.zEX.zET.dHU();
      break;
      label314:
      if (!com.tencent.mm.ui.chatting.j.a(true, localList, null))
      {
        ab.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
        h.d(paramMenuItem, paramMenuItem.getString(2131300748), "", paramMenuItem.getString(2131302650), paramMenuItem.getString(2131296888), new am.2(paramMenuItem, localad, localList, bool), null);
      }
      else
      {
        am.a(paramMenuItem, localad, localList, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.5.2
 * JD-Core Version:    0.7.0.1
 */