package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.a.1;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.d.a.a(fJv=t.class)
public class w
  extends a
  implements n.b, t
{
  private a Kel;
  private HashSet<String> Kem;
  private volatile bv Ken;
  private k Keo;
  private Handler mMainHandler;
  
  public w()
  {
    AppMethodBeat.i(35341);
    this.Kem = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (aj)w.this.cXJ.bh(aj.class);
          boolean bool;
          if ((paramAnonymousMessage.fIR()) || (paramAnonymousMessage.fIQ()))
          {
            bool = true;
            w.this.cXJ.Kkf.setIsBottomShowAll(false);
            w.this.cXJ.Kkf.setBottomViewVisible(true);
            if (!bool) {
              break label148;
            }
            w.this.cXJ.Kkf.xJ(true);
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), w.this.cXJ.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label148:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            w.this.cXJ.Kkf.bf(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          w.this.cXJ.Kkf.setIsBottomShowAll(true);
          w.this.cXJ.Kkf.setBottomViewVisible(true);
          w.b(w.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((z)w.this.cXJ.bh(z.class)).fIr();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { w.this.cXJ.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          w.this.cXJ.Kkf.setIsBottomShowAll(false);
          w.this.cXJ.Kkf.setBottomViewVisible(true);
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          w.this.cXJ.Kkf.bf(paramAnonymousMessage);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { w.this.cXJ.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          w.this.cXJ.Kkd.fFb();
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
    boolean bool = paramn.vWd;
    if (!paramObject.equals(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(paramn.id), Boolean.valueOf(paramn.vWd) });
    if ((paramInt == 4) && (!bool))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramn = ((l)g.ab(l.class)).doE().aqM(this.cXJ.getTalkerUserName());
      long l1 = paramn.field_lastPushSeq;
      long l2 = paramn.field_lastLocalSeq;
      com.tencent.mm.as.b.aIn().a(this.cXJ.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35342);
    super.fAs();
    if (!this.cXJ.fJC())
    {
      AppMethodBeat.o(35342);
      return;
    }
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        w.a(w.this, ((l)g.ab(l.class)).doJ().arc(w.this.cXJ.getTalkerUserName()));
        if (w.a(w.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), w.this.cXJ.getTalkerUserName(), Long.valueOf(w.a(w.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35343);
    super.fAt();
    if (!this.cXJ.fJC())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((l)g.ab(l.class)).doE().a(this, g.ajU().IxZ.getLooper());
    this.Kel = new a(this.cXJ.getTalkerUserName(), (byte)0);
    h.MqF.aO(this.Kel);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.cXJ.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35344);
    super.fAx();
    if (!this.cXJ.fJC())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.Kel.cancel();
    ((l)g.ab(l.class)).doE().b(this);
    if (!this.Kem.contains(this.cXJ.getTalkerUserName()))
    {
      com.tencent.mm.sdk.g.b.c(new a.1(com.tencent.mm.as.a.aIm(), this.cXJ.getTalkerUserName()), "checkDirtyBlock");
      this.Kem.add(this.cXJ.getTalkerUserName());
    }
    com.tencent.mm.as.b.aIn().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35345);
    super.fGE();
    ((l)g.ab(l.class)).doE().b(this);
    com.tencent.mm.as.b.aIn().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean fHS()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((l)g.ab(l.class)).doE().aqK(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void fHT()
  {
    AppMethodBeat.i(35347);
    if (this.Ken == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.cXJ.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).doE().e(this.cXJ.getTalkerUserName(), this.Ken.field_createTime, false);
    Object localObject = bu.aSM(this.Ken.field_content);
    int i;
    label235:
    com.tencent.mm.hellhoundlib.b.a locala;
    label362:
    long l2;
    if (localc == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.Ken.field_createTime) });
      if (localc != null) {
        break label563;
      }
      if (this.Keo == null) {
        this.Keo = ((k)this.cXJ.bh(k.class));
      }
      i = ((z)this.cXJ.bh(z.class)).fIp();
      if (this.Keo.getCount() < i) {
        break label523;
      }
      localObject = this.Keo.adI(this.Keo.getCount() - 1);
      if (localObject != null) {
        break label436;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.cXJ;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).ca(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((k)this.cXJ.bh(k.class)).adJ(i);
      ((z)this.cXJ.bh(z.class)).fIq();
      l2 = System.currentTimeMillis();
      if (localc != null) {
        break label675;
      }
    }
    label521:
    label523:
    label675:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label436:
      l2 = ((l)g.ab(l.class)).doJ().i(this.cXJ.getTalkerUserName(), ((ei)localObject).field_createTime, i);
      i = this.Keo.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label521;
        }
        localObject = this.Keo.adI(i);
        if ((localObject != null) && (((ei)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label235;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.cXJ.Kkd.fFa().a(d.a.Krz, true, (Bundle)localObject);
      break label235;
      label563:
      localObject = this.cXJ;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).ca(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.cXJ.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", w.a(w.this).field_msgId);
          w.this.cXJ.Kkf.bg(localBundle);
          AppMethodBeat.o(35337);
        }
      }, 166L);
      break label362;
    }
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
        bc.aCg();
        Object localObject1 = com.tencent.mm.model.c.azL().aVa(this.talker);
        localObject2 = ((l)g.ab(l.class)).doJ();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            w.b(w.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((ba)localObject1).field_lastSeq;
        l3 = ((ba)localObject1).field_conversationTime;
        if (w.this.fHS())
        {
          localObject1 = ((l)g.ab(l.class)).doE().aqM(w.this.cXJ.getTalkerUserName());
          l2 = ((com.tencent.mm.storage.ae)localObject1).field_lastLocalSeq;
          l3 = ((com.tencent.mm.storage.ae)localObject1).field_lastPushSeq;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
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
        if (!localau.lS(67108864)) {
          break label406;
        }
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      w.b(w.this).sendEmptyMessage(2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localau.lQ(67108864);
      bc.aCg();
      com.tencent.mm.model.c.azL().a(localau, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).hX(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((ei)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((ei)localObject3).field_msgId <= 0L) {
        if (localau.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).are(this.talker);
          l4 = ch.aDa() - 259200000L;
          localObject3 = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aY(this.talker, l4);
          if (((ei)localObject2).field_msgId == 0L)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((l)g.ab(l.class)).aAi().aqP(this.talker);
            long l5 = ((l)g.ab(l.class)).aAi().aqO(this.talker);
            ((bv)localObject2).qN(l4);
            ((bv)localObject2).qP(l5);
          }
          String str = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject2).field_createTime / 1000L);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((ei)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((ei)localObject2).field_createTime), localObject3, str });
          localObject3 = new iv();
          ((iv)localObject3).dwy.username = w.this.cXJ.getTalkerUserName();
          ((iv)localObject3).dwy.dwB = ((ei)localObject2).field_msgSeq;
          ((iv)localObject3).dwy.dwC = ((ei)localObject2).field_createTime;
          ((iv)localObject3).dwy.dwz = l2;
          ((iv)localObject3).dwy.dwA = l3;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          w.b(w.this).sendEmptyMessage(8);
          if ((localbv != null) && (localbv.field_msgSeq != l2)) {
            w.b(w.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            w.b(w.this).sendEmptyMessage(4);
          }
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
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