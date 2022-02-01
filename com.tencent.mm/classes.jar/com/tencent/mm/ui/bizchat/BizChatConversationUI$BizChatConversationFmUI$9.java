package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class BizChatConversationUI$BizChatConversationFmUI$9
  implements Runnable
{
  BizChatConversationUI$BizChatConversationFmUI$9(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(232780);
    Log.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Cursor localCursor = ag.bak().NB(BizChatConversationUI.BizChatConversationFmUI.a(this.PaS));
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        Object localObject = new a();
        ((a)localObject).convertFrom(localCursor);
        localCursor.moveToNext();
        localObject = ag.baj().bs(((a)localObject).field_bizChatId);
        if (((c)localObject).bay()) {
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
      ag.baq().b(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(this.PaS));
    }
    BizChatConversationUI.BizChatConversationFmUI.a(this.PaS, localLinkedList1);
    if (localLinkedList1.size() > 0) {
      ag.baq().c(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(this.PaS));
    }
    AppMethodBeat.o(232780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */