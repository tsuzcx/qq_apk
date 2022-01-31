package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatConversationUI$a$1
  implements MessageQueue.IdleHandler
{
  BizChatConversationUI$a$1(BizChatConversationUI.a parama) {}
  
  public final boolean queueIdle()
  {
    Object localObject = z.My().kQ(BizChatConversationUI.a.a(this.veW));
    BizChatConversationUI.a.a(this.veW, ((d)localObject).LG());
    int m = this.veW.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
    int i = -1;
    if (BizChatConversationUI.a.b(this.veW) != null) {
      i = BizChatConversationUI.a.b(this.veW).getCount();
    }
    localObject = z.MH().kD(BizChatConversationUI.a.c(this.veW));
    int j;
    int k;
    label107:
    int n;
    long l1;
    if (localObject != null)
    {
      j = ((com.tencent.mm.ai.b)localObject).field_qyUin;
      if (localObject == null) {
        break label331;
      }
      k = ((com.tencent.mm.ai.b)localObject).field_userUin;
      n = z.MH().kF(BizChatConversationUI.a.a(this.veW));
      if (localObject == null) {
        break label336;
      }
      l1 = ((com.tencent.mm.ai.b)localObject).field_wwCorpId;
      label134:
      if (localObject == null) {
        break label342;
      }
    }
    label331:
    label336:
    label342:
    for (long l2 = ((com.tencent.mm.ai.b)localObject).field_wwUserVid;; l2 = 0L)
    {
      h.nFQ.f(12648, new Object[] { BizChatConversationUI.a.c(this.veW), BizChatConversationUI.a.a(this.veW), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
      y.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.a.c(this.veW), BizChatConversationUI.a.a(this.veW), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
      return false;
      j = 0;
      break;
      k = 0;
      break label107;
      l1 = 0L;
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.1
 * JD-Core Version:    0.7.0.1
 */