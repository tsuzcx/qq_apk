package com.tencent.mm.ui.chatting.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.mm.ap.a.1;
import com.tencent.mm.h.a.hh;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.e.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.b.a.a(cFA=o.class)
public class r
  extends a
  implements m.b, o
{
  private Handler mMainHandler = new r.3(this, Looper.getMainLooper());
  private com.tencent.mm.ui.chatting.b.b.g vqA;
  private a vqx;
  private HashSet<String> vqy = new HashSet();
  private volatile bi vqz;
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    paramm = (b.a)paramObject;
    paramObject = paramm.username;
    boolean bool = paramm.mdo;
    if (!paramObject.equals(this.byx.getTalkerUserName())) {}
    do
    {
      return;
      y.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.byx.getTalkerUserName(), Integer.valueOf(paramm.id), Boolean.valueOf(paramm.mdo) });
      if ((paramInt == 4) && (!bool))
      {
        y.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:" + paramObject);
        this.mMainHandler.sendEmptyMessage(8);
      }
    } while ((bool) || ((paramInt != 2) && (paramInt != 4)));
    paramm = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hm(this.byx.getTalkerUserName());
    long l1 = paramm.field_lastPushSeq;
    long l2 = paramm.field_lastLocalSeq;
    com.tencent.mm.ap.b.Oi().a(this.byx.getTalkerUserName(), l2 + 1L, l1, 0, null);
  }
  
  public final boolean cEB()
  {
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hk(this.byx.getTalkerUserName());
  }
  
  public final void cEC()
  {
    boolean bool2 = false;
    if (this.vqz == null)
    {
      y.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.byx.getTalkerUserName() });
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.k.a.a.c localc = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().f(this.byx.getTalkerUserName(), this.vqz.field_createTime, false);
    Object localObject = bk.aac(this.vqz.field_content);
    boolean bool1;
    int i;
    if (localc == null)
    {
      bool1 = true;
      y.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool1), Long.valueOf(this.vqz.field_createTime) });
      if (localc != null) {
        break label458;
      }
      if (this.vqA == null) {
        this.vqA = ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class));
      }
      i = ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).cEQ();
      if (this.vqA.getCount() < i) {
        break label418;
      }
      localObject = this.vqA.GW(this.vqA.getCount() - 1);
      if (localObject != null) {
        break label331;
      }
      y.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      label219:
      i = 0;
      y.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      this.byx.bE(i);
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GX(i);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).cER();
      long l2 = System.currentTimeMillis();
      bool1 = bool2;
      if (localc == null) {
        bool1 = true;
      }
      y.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool1) });
      return;
      bool1 = false;
      break;
      label331:
      l2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().e(this.byx.getTalkerUserName(), ((cs)localObject).field_createTime, i);
      i = this.vqA.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label416;
        }
        localObject = this.vqA.GW(i);
        if ((localObject != null) && (((cs)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      label416:
      break label219;
      label418:
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.byx.vtz.cCp().a(d.a.vyf, true, (Bundle)localObject);
      break label219;
      label458:
      this.byx.bE(0);
      this.byx.getListView().postDelayed(new r.2(this), 166L);
    }
  }
  
  public final void cyM()
  {
    super.cyM();
    if (!this.byx.cFE()) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new r.1(this));
  }
  
  public final void cyN()
  {
    super.cyN();
    if (!this.byx.cFE()) {
      return;
    }
    long l = System.currentTimeMillis();
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().a(this, com.tencent.mm.kernel.g.DS().mnU.getLooper());
    this.vqx = new a(this.byx.getTalkerUserName(), (byte)0);
    com.tencent.mm.sdk.f.e.a(this.vqx, "[GetChatroomComponent]");
    y.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.byx.getTalkerUserName() });
  }
  
  public final void cyR()
  {
    super.cyR();
    if (!this.byx.cFE()) {}
    do
    {
      return;
      com.tencent.mm.sdk.f.e.remove(this.vqx);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().b(this);
    } while (this.vqy.contains(this.byx.getTalkerUserName()));
    com.tencent.mm.sdk.f.e.post(new a.1(com.tencent.mm.ap.a.Oh(), this.byx.getTalkerUserName()), "checkDirtyBlock");
    this.vqy.add(this.byx.getTalkerUserName());
  }
  
  private final class a
    implements Runnable
  {
    String talker;
    
    private a(String paramString)
    {
      this.talker = paramString;
    }
    
    public final void run()
    {
      long l1 = System.currentTimeMillis();
      Object localObject2;
      long l2;
      long l3;
      int i;
      try
      {
        au.Hx();
        Object localObject1 = com.tencent.mm.model.c.FB().abv(this.talker);
        localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            y.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            r.b(r.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((as)localObject1).field_lastSeq;
        l3 = ((as)localObject1).field_conversationTime;
        if (r.this.cEB())
        {
          localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hm(r.this.byx.getTalkerUserName());
          l2 = ((w)localObject1).field_lastLocalSeq;
          l3 = ((w)localObject1).field_lastPushSeq;
          y.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label276;
            }
            r.b(r.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label276:
            r.b(r.this).sendEmptyMessage(2);
          }
        }
        if (!localak.gV(67108864)) {
          break label381;
        }
      }
      finally
      {
        y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      }
      y.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      r.b(r.this).sendEmptyMessage(2);
      y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      return;
      label381:
      localak.gT(67108864);
      au.Hx();
      com.tencent.mm.model.c.FB().a(localak, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).dP(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      y.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((cs)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((cs)localObject3).field_msgId <= 0L) {
        if (localak.field_UnDeliverCount <= 0) {
          break label904;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).HB(this.talker);
          l4 = bz.Is() - 259200000L;
          localObject3 = h.g("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).ad(this.talker, l4);
          if (((cs)localObject2).field_msgId == 0L)
          {
            y.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((j)com.tencent.mm.kernel.g.r(j.class)).Gb().Hp(this.talker);
            long l5 = ((j)com.tencent.mm.kernel.g.r(j.class)).Gb().Ho(this.talker);
            ((bi)localObject2).bg(l4);
            ((bi)localObject2).bi(l5);
          }
          String str = h.g("yyyy-MM-dd HH:mm:ss", ((cs)localObject2).field_createTime / 1000L);
          y.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((cs)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((cs)localObject2).field_createTime), localObject3, str });
          localObject3 = new hh();
          ((hh)localObject3).bPe.username = r.this.byx.getTalkerUserName();
          ((hh)localObject3).bPe.bPh = ((cs)localObject2).field_msgSeq;
          ((hh)localObject3).bPe.bPi = ((cs)localObject2).field_createTime;
          ((hh)localObject3).bPe.bPf = l2;
          ((hh)localObject3).bPe.bPg = l3;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          r.b(r.this).sendEmptyMessage(8);
          if ((localbi != null) && (localbi.field_msgSeq != l2)) {
            r.b(r.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            r.b(r.this).sendEmptyMessage(4);
          }
        }
        y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        r.b(r.this).sendEmptyMessage(2);
        break;
        i = 1;
        continue;
        label904:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.r
 * JD-Core Version:    0.7.0.1
 */