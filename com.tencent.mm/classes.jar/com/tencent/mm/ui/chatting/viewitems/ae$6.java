package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ae$6
  extends com.tencent.mm.plugin.messenger.a.a
{
  ae$6(ae paramae, com.tencent.mm.ui.chatting.d.a parama)
  {
    super(1);
  }
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(254951);
    if ((getTag() != null) && ((getTag() instanceof String)))
    {
      paramView = (String)getTag();
      Log.i("MicroMsg.ChattingItemAppMsgPat", "click %s", new Object[] { paramView });
      paramView = new Intent().putExtra("Contact_User", paramView);
      paramView.putExtra("Contact_ChatRoomId", this.XSz.getTalkerUserName());
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 21);
      paramView.putExtra("Contact_Scene", 14);
      c.b(this.XSz.aezO.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    }
    AppMethodBeat.o(254951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.6
 * JD-Core Version:    0.7.0.1
 */