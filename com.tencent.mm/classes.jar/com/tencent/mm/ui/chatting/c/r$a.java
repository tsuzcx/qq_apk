package com.tencent.mm.ui.chatting.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;

final class r$a
  implements Runnable
{
  String talker;
  
  private r$a(r paramr, String paramString)
  {
    this.talker = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(31444);
    long l1 = System.currentTimeMillis();
    Object localObject2;
    long l2;
    long l3;
    int i;
    try
    {
      aw.aaz();
      Object localObject1 = com.tencent.mm.model.c.YF().arH(this.talker);
      localObject2 = ((j)g.E(j.class)).bPQ();
      if ((localObject1 == null) || (localObject2 == null))
      {
        if (localObject1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
          r.b(this.zGh).sendEmptyMessage(2);
          return;
        }
      }
      l2 = ((au)localObject1).field_lastSeq;
      l3 = ((au)localObject1).field_conversationTime;
      if (this.zGh.dIr())
      {
        localObject1 = ((j)g.E(j.class)).bPL().SY(this.zGh.caz.getTalkerUserName());
        l2 = ((w)localObject1).field_lastLocalSeq;
        l3 = ((w)localObject1).field_lastPushSeq;
        ab.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
        if (l2 != l3)
        {
          i = 1;
          if (i == 0) {
            break label294;
          }
          r.b(this.zGh).sendEmptyMessage(1);
        }
        for (;;)
        {
          return;
          i = 0;
          break;
          label294:
          r.b(this.zGh).sendEmptyMessage(2);
        }
      }
      if (!localak.ji(67108864)) {
        break label411;
      }
    }
    finally
    {
      ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(31444);
    }
    ab.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
    r.b(this.zGh).sendEmptyMessage(2);
    ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(31444);
    return;
    label411:
    localak.jg(67108864);
    aw.aaz();
    com.tencent.mm.model.c.YF().a(localak, this.talker);
    long l4 = System.currentTimeMillis();
    Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).fi(this.talker, " and msgSeq != 0 and flag & 2 != 0");
    ab.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((dd)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
    if (((dd)localObject3).field_msgId <= 0L) {
      if (localak.field_UnDeliverCount <= 0) {
        break label934;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).Tn(this.talker);
        l4 = cb.abp() - 259200000L;
        localObject3 = com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).av(this.talker, l4);
        if (((dd)localObject2).field_msgId == 0L)
        {
          ab.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
          l4 = ((j)g.E(j.class)).Zc().Tb(this.talker);
          long l5 = ((j)g.E(j.class)).Zc().Ta(this.talker);
          ((bi)localObject2).fQ(l4);
          ((bi)localObject2).fS(l5);
        }
        String str = com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dd)localObject2).field_createTime / 1000L);
        ab.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((dd)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((dd)localObject2).field_createTime), localObject3, str });
        localObject3 = new hl();
        ((hl)localObject3).cwx.username = this.zGh.caz.getTalkerUserName();
        ((hl)localObject3).cwx.cwA = ((dd)localObject2).field_msgSeq;
        ((hl)localObject3).cwx.cwB = ((dd)localObject2).field_createTime;
        ((hl)localObject3).cwx.cwy = l2;
        ((hl)localObject3).cwx.cwz = l3;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
        r.b(this.zGh).sendEmptyMessage(8);
        if ((localbi != null) && (localbi.field_msgSeq != l2)) {
          r.b(this.zGh).sendEmptyMessage(1);
        }
        for (;;)
        {
          ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
          break;
          r.b(this.zGh).sendEmptyMessage(4);
        }
      }
      ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
      r.b(this.zGh).sendEmptyMessage(2);
      break;
      i = 1;
      continue;
      label934:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r.a
 * JD-Core Version:    0.7.0.1
 */