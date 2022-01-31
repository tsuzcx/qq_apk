package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class BizChatConversationUI$BizChatConversationFmUI$10
  implements Runnable
{
  BizChatConversationUI$BizChatConversationFmUI$10(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(30067);
    ab.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Cursor localCursor = z.afl().si(BizChatConversationUI.BizChatConversationFmUI.a(this.ztv));
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        Object localObject = new a();
        ((a)localObject).convertFrom(localCursor);
        localCursor.moveToNext();
        localObject = z.afk().aG(((a)localObject).field_bizChatId);
        if (((c)localObject).afy()) {
          if (((c)localObject).isGroup()) {
            localLinkedList2.add(((c)localObject).field_bizChatServId);
          } else {
            localLinkedList1.add(((c)localObject).field_bizChatServId);
          }
        }
      }
    }
    localCursor.close();
    if (localLinkedList2.size() > 0) {
      z.afq().a(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(this.ztv));
    }
    BizChatConversationUI.BizChatConversationFmUI.a(this.ztv, localLinkedList1);
    if (localLinkedList1.size() > 0) {
      z.afq().b(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(this.ztv));
    }
    AppMethodBeat.o(30067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.10
 * JD-Core Version:    0.7.0.1
 */