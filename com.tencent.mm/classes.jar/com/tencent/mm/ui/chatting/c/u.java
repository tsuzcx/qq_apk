package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.1;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.chatting.g.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.c.a.a(eYT=r.class)
public class u
  extends a
  implements n.b, r
{
  private a Gva;
  private HashSet<String> Gvb;
  private volatile bl Gvc;
  private com.tencent.mm.ui.chatting.c.b.i Gvd;
  private Handler mMainHandler;
  
  public u()
  {
    AppMethodBeat.i(35341);
    this.Gvb = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (com.tencent.mm.ui.chatting.c.b.ae)u.this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class);
          boolean bool;
          if ((paramAnonymousMessage.eYy()) || (paramAnonymousMessage.eYx()))
          {
            bool = true;
            u.this.cOd.GzL.setIsBottomShowAll(false);
            u.this.cOd.GzL.setBottomViewVisible(true);
            if (!bool) {
              break label148;
            }
            u.this.cOd.GzL.vM(true);
          }
          for (;;)
          {
            ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), u.this.cOd.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label148:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            u.this.cOd.GzL.aV(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          u.this.cOd.GzL.setIsBottomShowAll(true);
          u.this.cOd.GzL.setBottomViewVisible(true);
          u.b(u.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((x)u.this.cOd.be(x.class)).eYe();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { u.this.cOd.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          u.this.cOd.GzL.setIsBottomShowAll(false);
          u.this.cOd.GzL.setBottomViewVisible(true);
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          u.this.cOd.GzL.aV(paramAnonymousMessage);
          ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { u.this.cOd.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          u.this.cOd.GzJ.eUY();
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
    boolean bool = paramn.tyy;
    if (!paramObject.equals(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    ad.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(paramn.id), Boolean.valueOf(paramn.tyy) });
    if ((paramInt == 4) && (!bool))
    {
      ad.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramn = ((k)g.ab(k.class)).cOD().agb(this.cOd.getTalkerUserName());
      long l1 = paramn.field_lastPushSeq;
      long l2 = paramn.field_lastLocalSeq;
      com.tencent.mm.at.b.axZ().a(this.cOd.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35342);
    super.eQA();
    if (!this.cOd.eZb())
    {
      AppMethodBeat.o(35342);
      return;
    }
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        u.a(u.this, ((k)g.ab(k.class)).cOI().agq(u.this.cOd.getTalkerUserName()));
        if (u.a(u.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        ad.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), u.this.cOd.getTalkerUserName(), Long.valueOf(u.a(u.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35343);
    super.eQB();
    if (!this.cOd.eZb())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((k)g.ab(k.class)).cOD().a(this, g.afE().EUN.getLooper());
    this.Gva = new a(this.cOd.getTalkerUserName(), (byte)0);
    com.tencent.e.h.Iye.aP(this.Gva);
    ad.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.cOd.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35344);
    super.eQF();
    if (!this.cOd.eZb())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.Gva.cancel();
    ((k)g.ab(k.class)).cOD().b(this);
    if (!this.Gvb.contains(this.cOd.getTalkerUserName()))
    {
      com.tencent.mm.sdk.g.b.c(new a.1(com.tencent.mm.at.a.axY(), this.cOd.getTalkerUserName()), "checkDirtyBlock");
      this.Gvb.add(this.cOd.getTalkerUserName());
    }
    com.tencent.mm.at.b.axZ().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35345);
    super.eWx();
    ((k)g.ab(k.class)).cOD().b(this);
    com.tencent.mm.at.b.axZ().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean eXF()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((k)g.ab(k.class)).cOD().afZ(this.cOd.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void eXG()
  {
    AppMethodBeat.i(35347);
    if (this.Gvc == null)
    {
      ad.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.cOd.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).cOD().f(this.cOd.getTalkerUserName(), this.Gvc.field_createTime, false);
    Object localObject = bt.aGs(this.Gvc.field_content);
    int i;
    label235:
    com.tencent.mm.hellhoundlib.b.a locala;
    label362:
    long l2;
    if (localc == null)
    {
      bool = true;
      ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.Gvc.field_createTime) });
      if (localc != null) {
        break label563;
      }
      if (this.Gvd == null) {
        this.Gvd = ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class));
      }
      i = ((x)this.cOd.be(x.class)).eYc();
      if (this.Gvd.getCount() < i) {
        break label523;
      }
      localObject = this.Gvd.YE(this.Gvd.getCount() - 1);
      if (localObject != null) {
        break label436;
      }
      ad.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.cOd;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).YF(i);
      ((x)this.cOd.be(x.class)).eYd();
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
      ad.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label436:
      l2 = ((k)g.ab(k.class)).cOI().g(this.cOd.getTalkerUserName(), ((du)localObject).field_createTime, i);
      i = this.Gvd.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label521;
        }
        localObject = this.Gvd.YE(i);
        if ((localObject != null) && (((du)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label235;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.cOd.GzJ.eUX().a(d.a.GEY, true, (Bundle)localObject);
      break label235;
      label563:
      localObject = this.cOd;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.cOd.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", u.a(u.this).field_msgId);
          u.this.cOd.GzL.aW(localBundle);
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
        az.arV();
        Object localObject1 = com.tencent.mm.model.c.apR().aIn(this.talker);
        localObject2 = ((k)g.ab(k.class)).cOI();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            u.b(u.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((ay)localObject1).field_lastSeq;
        l3 = ((ay)localObject1).field_conversationTime;
        if (u.this.eXF())
        {
          localObject1 = ((k)g.ab(k.class)).cOD().agb(u.this.cOd.getTalkerUserName());
          l2 = ((y)localObject1).field_lastLocalSeq;
          l3 = ((y)localObject1).field_lastPushSeq;
          ad.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label291;
            }
            u.b(u.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label291:
            u.b(u.this).sendEmptyMessage(2);
          }
        }
        if (!localam.lw(67108864)) {
          break label406;
        }
      }
      finally
      {
        ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      ad.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      u.b(u.this).sendEmptyMessage(2);
      ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localam.lu(67108864);
      az.arV();
      com.tencent.mm.model.c.apR().a(localam, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).hn(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      ad.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((du)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((du)localObject3).field_msgId <= 0L) {
        if (localam.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).agr(this.talker);
          l4 = ce.asQ() - 259200000L;
          localObject3 = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).aU(this.talker, l4);
          if (((du)localObject2).field_msgId == 0L)
          {
            ad.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((k)g.ab(k.class)).aqo().age(this.talker);
            long l5 = ((k)g.ab(k.class)).aqo().agd(this.talker);
            ((bl)localObject2).kY(l4);
            ((bl)localObject2).la(l5);
          }
          String str = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((du)localObject2).field_createTime / 1000L);
          ad.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((du)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((du)localObject2).field_createTime), localObject3, str });
          localObject3 = new if();
          ((if)localObject3).dlY.username = u.this.cOd.getTalkerUserName();
          ((if)localObject3).dlY.dmb = ((du)localObject2).field_msgSeq;
          ((if)localObject3).dlY.dmc = ((du)localObject2).field_createTime;
          ((if)localObject3).dlY.dlZ = l2;
          ((if)localObject3).dlY.dma = l3;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
          u.b(u.this).sendEmptyMessage(8);
          if ((localbl != null) && (localbl.field_msgSeq != l2)) {
            u.b(u.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            u.b(u.this).sendEmptyMessage(4);
          }
        }
        ad.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        u.b(u.this).sendEmptyMessage(2);
        break;
        i = 1;
        continue;
        label929:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.u
 * JD-Core Version:    0.7.0.1
 */