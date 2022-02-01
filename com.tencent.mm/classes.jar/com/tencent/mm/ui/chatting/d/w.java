package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.1;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.d.a.a(fFo=t.class)
public class w
  extends a
  implements n.b, t
{
  private a JJp;
  private HashSet<String> JJq;
  private volatile bu JJr;
  private k JJs;
  private Handler mMainHandler;
  
  public w()
  {
    AppMethodBeat.i(35341);
    this.JJq = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (ai)w.this.cWM.bh(ai.class);
          boolean bool;
          if ((paramAnonymousMessage.fEO()) || (paramAnonymousMessage.fEN()))
          {
            bool = true;
            w.this.cWM.JOT.setIsBottomShowAll(false);
            w.this.cWM.JOT.setBottomViewVisible(true);
            if (!bool) {
              break label148;
            }
            w.this.cWM.JOT.xB(true);
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), w.this.cWM.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label148:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            w.this.cWM.JOT.be(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          w.this.cWM.JOT.setIsBottomShowAll(true);
          w.this.cWM.JOT.setBottomViewVisible(true);
          w.b(w.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((z)w.this.cWM.bh(z.class)).fEn();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { w.this.cWM.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          w.this.cWM.JOT.setIsBottomShowAll(false);
          w.this.cWM.JOT.setBottomViewVisible(true);
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          w.this.cWM.JOT.be(paramAnonymousMessage);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { w.this.cWM.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          w.this.cWM.JOR.fAZ();
        }
        AppMethodBeat.o(35339);
      }
    };
    AppMethodBeat.o(35341);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(35348);
    paramn = (b.a)paramObject;
    paramObject = paramn.username;
    boolean bool = paramn.vJZ;
    if (!paramObject.equals(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(paramn.id), Boolean.valueOf(paramn.vJZ) });
    if ((paramInt == 4) && (!bool))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramn = ((l)g.ab(l.class)).dlF().apH(this.cWM.getTalkerUserName());
      long l1 = paramn.field_lastPushSeq;
      long l2 = paramn.field_lastLocalSeq;
      com.tencent.mm.at.b.aHW().a(this.cWM.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35345);
    super.fCC();
    ((l)g.ab(l.class)).dlF().b(this);
    com.tencent.mm.at.b.aHW().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean fDP()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((l)g.ab(l.class)).dlF().apF(this.cWM.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void fDQ()
  {
    AppMethodBeat.i(35347);
    if (this.JJr == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.cWM.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).dlF().e(this.cWM.getTalkerUserName(), this.JJr.field_createTime, false);
    Object localObject = bt.aRp(this.JJr.field_content);
    int i;
    label229:
    com.tencent.mm.hellhoundlib.b.a locala;
    label355:
    long l2;
    if (localc == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.JJr.field_createTime) });
      if (localc != null) {
        break label554;
      }
      if (this.JJs == null) {
        this.JJs = ((k)this.cWM.bh(k.class));
      }
      i = ((z)this.cWM.bh(z.class)).fEl();
      if (this.JJs.getCount() < i) {
        break label514;
      }
      localObject = this.JJs.ada(this.JJs.getCount() - 1);
      if (localObject != null) {
        break label427;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.cWM;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((k)this.cWM.bh(k.class)).adb(i);
      ((z)this.cWM.bh(z.class)).fEm();
      l2 = System.currentTimeMillis();
      if (localc != null) {
        break label666;
      }
    }
    label512:
    label514:
    label666:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label427:
      l2 = ((l)g.ab(l.class)).dlK().i(this.cWM.getTalkerUserName(), ((ei)localObject).field_createTime, i);
      i = this.JJs.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label512;
        }
        localObject = this.JJs.ada(i);
        if ((localObject != null) && (((ei)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label229;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.cWM.JOR.fAY().a(d.a.JVh, true, (Bundle)localObject);
      break label229;
      label554:
      localObject = this.cWM;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.cWM.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", w.a(w.this).field_msgId);
          w.this.cWM.JOT.bf(localBundle);
          AppMethodBeat.o(35337);
        }
      }, 166L);
      break label355;
    }
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35342);
    super.fws();
    if (!this.cWM.fFv())
    {
      AppMethodBeat.o(35342);
      return;
    }
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        w.a(w.this, ((l)g.ab(l.class)).dlK().apX(w.this.cWM.getTalkerUserName()));
        if (w.a(w.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), w.this.cWM.getTalkerUserName(), Long.valueOf(w.a(w.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35343);
    super.fwt();
    if (!this.cWM.fFv())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((l)g.ab(l.class)).dlF().a(this, g.ajF().IdO.getLooper());
    this.JJp = new a(this.cWM.getTalkerUserName(), (byte)0);
    h.LTJ.aR(this.JJp);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.cWM.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35344);
    super.fwx();
    if (!this.cWM.fFv())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.JJp.cancel();
    ((l)g.ab(l.class)).dlF().b(this);
    if (!this.JJq.contains(this.cWM.getTalkerUserName()))
    {
      com.tencent.mm.sdk.g.b.c(new a.1(com.tencent.mm.at.a.aHV(), this.cWM.getTalkerUserName()), "checkDirtyBlock");
      this.JJq.add(this.cWM.getTalkerUserName());
    }
    com.tencent.mm.at.b.aHW().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    String talker;
    
    private a(String paramString)
    {
      this.talker = paramString;
    }
    
    public final String getKey()
    {
      return "CheckGetChatroomTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(35340);
      long l1 = System.currentTimeMillis();
      Object localObject2;
      long l2;
      long l3;
      int i;
      try
      {
        com.tencent.mm.model.ba.aBQ();
        Object localObject1 = com.tencent.mm.model.c.azv().aTz(this.talker);
        localObject2 = ((l)g.ab(l.class)).dlK();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            w.b(w.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((com.tencent.mm.g.c.ba)localObject1).field_lastSeq;
        l3 = ((com.tencent.mm.g.c.ba)localObject1).field_conversationTime;
        if (w.this.fDP())
        {
          localObject1 = ((l)g.ab(l.class)).dlF().apH(w.this.cWM.getTalkerUserName());
          l2 = ((com.tencent.mm.storage.ad)localObject1).field_lastLocalSeq;
          l3 = ((com.tencent.mm.storage.ad)localObject1).field_lastPushSeq;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label291;
            }
            w.b(w.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label291:
            w.b(w.this).sendEmptyMessage(2);
          }
        }
        if (!localat.lQ(67108864)) {
          break label406;
        }
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      w.b(w.this).sendEmptyMessage(2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localat.lO(67108864);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(localat, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).hQ(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((ei)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((ei)localObject3).field_msgId <= 0L) {
        if (localat.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).apZ(this.talker);
          l4 = cf.aCK() - 259200000L;
          localObject3 = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aX(this.talker, l4);
          if (((ei)localObject2).field_msgId == 0L)
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((l)g.ab(l.class)).azS().apK(this.talker);
            long l5 = ((l)g.ab(l.class)).azS().apJ(this.talker);
            ((bu)localObject2).qA(l4);
            ((bu)localObject2).qC(l5);
          }
          String str = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject2).field_createTime / 1000L);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((ei)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((ei)localObject2).field_createTime), localObject3, str });
          localObject3 = new iu();
          ((iu)localObject3).dvt.username = w.this.cWM.getTalkerUserName();
          ((iu)localObject3).dvt.dvw = ((ei)localObject2).field_msgSeq;
          ((iu)localObject3).dvt.dvx = ((ei)localObject2).field_createTime;
          ((iu)localObject3).dvt.dvu = l2;
          ((iu)localObject3).dvt.dvv = l3;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          w.b(w.this).sendEmptyMessage(8);
          if ((localbu != null) && (localbu.field_msgSeq != l2)) {
            w.b(w.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            w.b(w.this).sendEmptyMessage(4);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        w.b(w.this).sendEmptyMessage(2);
        break;
        i = 1;
        continue;
        label929:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.w
 * JD-Core Version:    0.7.0.1
 */