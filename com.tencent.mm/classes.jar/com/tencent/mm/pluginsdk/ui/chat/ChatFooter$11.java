package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

final class ChatFooter$11
  implements AppPanel.b
{
  ChatFooter$11(ChatFooter paramChatFooter) {}
  
  public final void cna()
  {
    boolean bool = a.a(ChatFooter.b(this.sgd), "android.permission.RECORD_AUDIO", 80, "", "");
    y.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), ChatFooter.b(this.sgd) });
    if (!bool) {}
    do
    {
      return;
      int i = au.Dk().KG();
      if ((i == 4) || (i == 6))
      {
        ChatFooter.B(this.sgd);
        return;
      }
    } while ((ChatFooter.l(this.sgd) != null) && (ChatFooter.l(this.sgd).isShowing()));
    ChatFooter.a(this.sgd, h.h(this.sgd.getContext(), R.l.voip_net_unavailable, R.l.app_tip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.11
 * JD-Core Version:    0.7.0.1
 */