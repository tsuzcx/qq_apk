package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.p;

final class BizChatConversationUI$a$8
  implements bd.a
{
  BizChatConversationUI$a$8(BizChatConversationUI.a parama, long paramLong) {}
  
  public final void xA()
  {
    int i = 0;
    int j = 0;
    if (BizChatConversationUI.a.p(this.veW) != null)
    {
      z.MA().bL(this.dUI);
      z.MB().bL(this.dUI);
      Object localObject = z.MB();
      String str = BizChatConversationUI.a.a(this.veW);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select count(*) from BizChatConversation");
      localStringBuilder.append(" where brandUserName = '").append(str).append("' ");
      str = localStringBuilder.toString();
      localObject = ((b)localObject).dXw.a(str, null, 2);
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
        au.Hx();
        c.FB().abu(BizChatConversationUI.a.a(this.veW));
      }
      BizChatConversationUI.a.p(this.veW).dismiss();
    }
  }
  
  public final boolean xz()
  {
    return BizChatConversationUI.a.o(this.veW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.8
 * JD-Core Version:    0.7.0.1
 */