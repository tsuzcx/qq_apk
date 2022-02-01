package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.a.1;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.chatting.g.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.c.a.a(foJ=r.class)
public class u
  extends a
  implements n.b, r
{
  private a HUR;
  private HashSet<String> HUS;
  private volatile bo HUT;
  private com.tencent.mm.ui.chatting.c.b.i HUU;
  private Handler mMainHandler;
  
  public u()
  {
    AppMethodBeat.i(35341);
    this.HUS = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (com.tencent.mm.ui.chatting.c.b.ae)u.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
          boolean bool;
          if ((paramAnonymousMessage.fok()) || (paramAnonymousMessage.foj()))
          {
            bool = true;
            u.this.cLy.HZH.setIsBottomShowAll(false);
            u.this.cLy.HZH.setBottomViewVisible(true);
            if (!bool) {
              break label148;
            }
            u.this.cLy.HZH.wQ(true);
          }
          for (;;)
          {
            ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), u.this.cLy.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label148:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            u.this.cLy.HZH.aZ(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          u.this.cLy.HZH.setIsBottomShowAll(true);
          u.this.cLy.HZH.setBottomViewVisible(true);
          u.b(u.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((x)u.this.cLy.bf(x.class)).fnQ();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { u.this.cLy.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          u.this.cLy.HZH.setIsBottomShowAll(false);
          u.this.cLy.HZH.setBottomViewVisible(true);
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          u.this.cLy.HZH.aZ(paramAnonymousMessage);
          ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { u.this.cLy.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          u.this.cLy.HZF.fkK();
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
    boolean bool = paramn.uGW;
    if (!paramObject.equals(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    ac.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(paramn.id), Boolean.valueOf(paramn.uGW) });
    if ((paramInt == 4) && (!bool))
    {
      ac.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramn = ((k)g.ab(k.class)).dcm().akV(this.cLy.getTalkerUserName());
      long l1 = paramn.field_lastPushSeq;
      long l2 = paramn.field_lastLocalSeq;
      com.tencent.mm.as.b.aER().a(this.cLy.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35342);
    super.fgg();
    if (!this.cLy.foQ())
    {
      AppMethodBeat.o(35342);
      return;
    }
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        u.a(u.this, ((k)g.ab(k.class)).dcr().alk(u.this.cLy.getTalkerUserName()));
        if (u.a(u.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        ac.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), u.this.cLy.getTalkerUserName(), Long.valueOf(u.a(u.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35343);
    super.fgh();
    if (!this.cLy.foQ())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((k)g.ab(k.class)).dcm().a(this, g.agU().GrZ.getLooper());
    this.HUR = new a(this.cLy.getTalkerUserName(), (byte)0);
    com.tencent.e.h.JZN.aS(this.HUR);
    ac.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.cLy.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35344);
    super.fgl();
    if (!this.cLy.foQ())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.HUR.cancel();
    ((k)g.ab(k.class)).dcm().b(this);
    if (!this.HUS.contains(this.cLy.getTalkerUserName()))
    {
      com.tencent.mm.sdk.g.b.c(new a.1(com.tencent.mm.as.a.aEQ(), this.cLy.getTalkerUserName()), "checkDirtyBlock");
      this.HUS.add(this.cLy.getTalkerUserName());
    }
    com.tencent.mm.as.b.aER().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35345);
    super.fmj();
    ((k)g.ab(k.class)).dcm().b(this);
    com.tencent.mm.as.b.aER().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean fnr()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((k)g.ab(k.class)).dcm().akT(this.cLy.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void fns()
  {
    AppMethodBeat.i(35347);
    if (this.HUT == null)
    {
      ac.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.cLy.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).dcm().f(this.cLy.getTalkerUserName(), this.HUT.field_createTime, false);
    Object localObject = bs.aLJ(this.HUT.field_content);
    int i;
    label235:
    com.tencent.mm.hellhoundlib.b.a locala;
    label362:
    long l2;
    if (localc == null)
    {
      bool = true;
      ac.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.HUT.field_createTime) });
      if (localc != null) {
        break label563;
      }
      if (this.HUU == null) {
        this.HUU = ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class));
      }
      i = ((x)this.cLy.bf(x.class)).fnO();
      if (this.HUU.getCount() < i) {
        break label523;
      }
      localObject = this.HUU.aaP(this.HUU.getCount() - 1);
      if (localObject != null) {
        break label436;
      }
      ac.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      ac.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.cLy;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).aaQ(i);
      ((x)this.cLy.bf(x.class)).fnP();
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
      ac.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label436:
      l2 = ((k)g.ab(k.class)).dcr().g(this.cLy.getTalkerUserName(), ((dy)localObject).field_createTime, i);
      i = this.HUU.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label521;
        }
        localObject = this.HUU.aaP(i);
        if ((localObject != null) && (((dy)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label235;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.cLy.HZF.fkJ().a(d.a.IeU, true, (Bundle)localObject);
      break label235;
      label563:
      localObject = this.cLy;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.cLy.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", u.a(u.this).field_msgId);
          u.this.cLy.HZH.ba(localBundle);
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
        com.tencent.mm.model.az.ayM();
        Object localObject1 = com.tencent.mm.model.c.awG().aNI(this.talker);
        localObject2 = ((k)g.ab(k.class)).dcr();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            ac.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            u.b(u.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((com.tencent.mm.g.c.az)localObject1).field_lastSeq;
        l3 = ((com.tencent.mm.g.c.az)localObject1).field_conversationTime;
        if (u.this.fnr())
        {
          localObject1 = ((k)g.ab(k.class)).dcm().akV(u.this.cLy.getTalkerUserName());
          l2 = ((z)localObject1).field_lastLocalSeq;
          l3 = ((z)localObject1).field_lastPushSeq;
          ac.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
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
        if (!localap.lr(67108864)) {
          break label406;
        }
      }
      finally
      {
        ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      ac.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      u.b(u.this).sendEmptyMessage(2);
      ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localap.lp(67108864);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(localap, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).hG(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      ac.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((dy)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((dy)localObject3).field_msgId <= 0L) {
        if (localap.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).all(this.talker);
          l4 = ce.azH() - 259200000L;
          localObject3 = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject2).aW(this.talker, l4);
          if (((dy)localObject2).field_msgId == 0L)
          {
            ac.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((k)g.ab(k.class)).axd().akY(this.talker);
            long l5 = ((k)g.ab(k.class)).axd().akX(this.talker);
            ((bo)localObject2).oA(l4);
            ((bo)localObject2).oC(l5);
          }
          String str = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dy)localObject2).field_createTime / 1000L);
          ac.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((dy)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((dy)localObject2).field_createTime), localObject3, str });
          localObject3 = new im();
          ((im)localObject3).djG.username = u.this.cLy.getTalkerUserName();
          ((im)localObject3).djG.djJ = ((dy)localObject2).field_msgSeq;
          ((im)localObject3).djG.djK = ((dy)localObject2).field_createTime;
          ((im)localObject3).djG.djH = l2;
          ((im)localObject3).djG.djI = l3;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
          u.b(u.this).sendEmptyMessage(8);
          if ((localbo != null) && (localbo.field_msgSeq != l2)) {
            u.b(u.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            u.b(u.this).sendEmptyMessage(4);
          }
        }
        ac.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.u
 * JD-Core Version:    0.7.0.1
 */