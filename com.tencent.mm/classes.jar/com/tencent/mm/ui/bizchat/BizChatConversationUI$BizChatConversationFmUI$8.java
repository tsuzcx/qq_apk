package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.p;

final class BizChatConversationUI$BizChatConversationFmUI$8
  implements bf.a
{
  BizChatConversationUI$BizChatConversationFmUI$8(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI, long paramLong) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(30064);
    boolean bool = BizChatConversationUI.BizChatConversationFmUI.o(this.ztv);
    AppMethodBeat.o(30064);
    return bool;
  }
  
  public final void JT()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(30065);
    if (BizChatConversationUI.BizChatConversationFmUI.p(this.ztv) != null)
    {
      z.afk().gG(this.fkR);
      z.afl().gG(this.fkR);
      Object localObject = z.afl();
      String str = BizChatConversationUI.BizChatConversationFmUI.a(this.ztv);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select count(*) from BizChatConversation");
      localStringBuilder.append(" where brandUserName = '").append(str).append("' ");
      str = localStringBuilder.toString();
      localObject = ((b)localObject).db.a(str, null, 2);
      if (localObject != null)
      {
        i = j;
        if (((Cursor)localObject).moveToFirst()) {
          i = ((Cursor)localObject).getInt(0);
        }
        ((Cursor)localObject).close();
      }
      if (i <= 0)
      {
        aw.aaz();
        c.YF().arF(BizChatConversationUI.BizChatConversationFmUI.a(this.ztv));
      }
      BizChatConversationUI.BizChatConversationFmUI.p(this.ztv).dismiss();
    }
    AppMethodBeat.o(30065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.8
 * JD-Core Version:    0.7.0.1
 */