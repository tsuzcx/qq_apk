package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;

final class SelectConversationUI$26
  implements q.a
{
  SelectConversationUI$26(SelectConversationUI paramSelectConversationUI, Intent paramIntent) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whw.XM();
    boolean bool = this.val$intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
    if (bool)
    {
      if (paramBoolean)
      {
        paramInt = 1;
        y.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramInt) });
        h.nFQ.f(13943, new Object[] { Integer.valueOf(paramInt) });
      }
    }
    else
    {
      if (!paramBoolean) {
        break label116;
      }
      this.val$intent.putExtra("custom_send_text", paramString);
      SelectConversationUI.a(this.whw, this.val$intent);
      this.whw.finish();
    }
    label116:
    while (!bool)
    {
      return;
      paramInt = 0;
      break;
    }
    paramString = this.val$intent.getStringExtra("Select_Contact");
    au.Hx();
    c.FB().abu(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.26
 * JD-Core Version:    0.7.0.1
 */