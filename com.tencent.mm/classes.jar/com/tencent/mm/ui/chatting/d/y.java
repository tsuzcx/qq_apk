package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.a.1;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.d.a.a(gRF=v.class)
public class y
  extends a
  implements MStorageEx.IOnStorageChange, v
{
  private a Pqc;
  private HashSet<String> Pqd;
  private volatile ca Pqe;
  private k Pqf;
  private Handler mMainHandler;
  
  public y()
  {
    AppMethodBeat.i(35341);
    this.Pqd = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (am)y.this.dom.bh(am.class);
          boolean bool;
          if ((paramAnonymousMessage.gRb()) || (paramAnonymousMessage.gRa()))
          {
            bool = true;
            y.this.dom.Pwe.setIsBottomShowAll(false);
            y.this.dom.Pwe.setBottomViewVisible(true);
            if (!bool) {
              break label148;
            }
            y.this.dom.Pwe.By(true);
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), y.this.dom.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label148:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            y.this.dom.Pwe.bs(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          y.this.dom.Pwe.setIsBottomShowAll(true);
          y.this.dom.Pwe.setBottomViewVisible(true);
          y.b(y.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((ab)y.this.dom.bh(ab.class)).gQC();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { y.this.dom.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          y.this.dom.Pwe.setIsBottomShowAll(false);
          y.this.dom.Pwe.setBottomViewVisible(true);
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          y.this.dom.Pwe.bs(paramAnonymousMessage);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { y.this.dom.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          y.this.dom.Pwc.gNj();
        }
        AppMethodBeat.o(35339);
      }
    };
    AppMethodBeat.o(35341);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35342);
    super.gIk();
    if (!this.dom.gRM())
    {
      AppMethodBeat.o(35342);
      return;
    }
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        y.a(y.this, ((l)g.af(l.class)).eiy().aEx(y.this.dom.getTalkerUserName()));
        if (y.a(y.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        Log.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), y.this.dom.getTalkerUserName(), Long.valueOf(y.a(y.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35343);
    super.gIl();
    if (!this.dom.gRM())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((l)g.af(l.class)).eit().add(this, g.aAk().getLooper());
    this.Pqc = new a(this.dom.getTalkerUserName(), (byte)0);
    h.RTc.aX(this.Pqc);
    Log.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.dom.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35344);
    super.gIn();
    if (!this.dom.gRM())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.Pqc.cancel();
    ((l)g.af(l.class)).eit().remove(this);
    if (!this.Pqd.contains(this.dom.getTalkerUserName()))
    {
      ThreadPool.post(new a.1(com.tencent.mm.as.a.bcg(), this.dom.getTalkerUserName()), "checkDirtyBlock");
      this.Pqd.add(this.dom.getTalkerUserName());
    }
    com.tencent.mm.as.b.bch().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35345);
    super.gOK();
    ((l)g.af(l.class)).eit().remove(this);
    com.tencent.mm.as.b.bch().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean gQb()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((l)g.af(l.class)).eit().aEf(this.dom.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void gQc()
  {
    AppMethodBeat.i(35347);
    if (this.Pqe == null)
    {
      Log.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.dom.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.k.a.a.c localc = ((l)g.af(l.class)).eit().e(this.dom.getTalkerUserName(), this.Pqe.field_createTime, false);
    Object localObject = Util.secPrint(this.Pqe.field_content);
    int i;
    label231:
    com.tencent.mm.hellhoundlib.b.a locala;
    label358:
    long l2;
    if (localc == null)
    {
      bool = true;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.Pqe.field_createTime) });
      if (localc != null) {
        break label558;
      }
      if (this.Pqf == null) {
        this.Pqf = ((k)this.dom.bh(k.class));
      }
      i = ((ab)this.dom.bh(ab.class)).gQA();
      if (this.Pqf.getCount() < i) {
        break label518;
      }
      localObject = this.Pqf.amt(this.Pqf.getCount() - 1);
      if (localObject != null) {
        break label431;
      }
      Log.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.dom;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((k)this.dom.bh(k.class)).amu(i);
      ((ab)this.dom.bh(ab.class)).gQB();
      l2 = System.currentTimeMillis();
      if (localc != null) {
        break label670;
      }
    }
    label516:
    label518:
    label670:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label431:
      l2 = ((l)g.af(l.class)).eiy().i(this.dom.getTalkerUserName(), ((eo)localObject).field_createTime, i);
      i = this.Pqf.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label516;
        }
        localObject = this.Pqf.amt(i);
        if ((localObject != null) && (((eo)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label231;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.dom.Pwc.gNi().a(d.a.PDH, true, (Bundle)localObject);
      break label231;
      label558:
      localObject = this.dom;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.dom.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", y.a(y.this).field_msgId);
          y.this.dom.Pwe.bt(localBundle);
          AppMethodBeat.o(35337);
        }
      }, 166L);
      break label358;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35348);
    paramMStorageEx = (b.a)paramObject;
    paramObject = paramMStorageEx.username;
    boolean bool = paramMStorageEx.zqi;
    if (!paramObject.equals(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(paramMStorageEx.id), Boolean.valueOf(paramMStorageEx.zqi) });
    if ((paramInt == 4) && (!bool))
    {
      Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramMStorageEx = ((l)g.af(l.class)).eit().aEh(this.dom.getTalkerUserName());
      long l1 = paramMStorageEx.field_lastPushSeq;
      long l2 = paramMStorageEx.field_lastLocalSeq;
      com.tencent.mm.as.b.bch().a(this.dom.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  final class a
    extends com.tencent.f.i.b
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
        bg.aVF();
        Object localObject1 = com.tencent.mm.model.c.aST().bjY(this.talker);
        localObject2 = ((l)g.af(l.class)).eiy();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            y.b(y.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((bb)localObject1).field_lastSeq;
        l3 = ((bb)localObject1).field_conversationTime;
        if (y.this.gQb())
        {
          localObject1 = ((l)g.af(l.class)).eit().aEh(y.this.dom.getTalkerUserName());
          l2 = ((aj)localObject1).field_lastLocalSeq;
          l3 = ((aj)localObject1).field_lastPushSeq;
          Log.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label291;
            }
            y.b(y.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label291:
            y.b(y.this).sendEmptyMessage(2);
          }
        }
        if (!localaz.oV(67108864)) {
          break label406;
        }
      }
      finally
      {
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      Log.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      y.b(y.this).sendEmptyMessage(2);
      Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localaz.oT(67108864);
      bg.aVF();
      com.tencent.mm.model.c.aST().a(localaz, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).iG(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      Log.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((eo)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((eo)localObject3).field_msgId <= 0L) {
        if (localaz.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aEz(this.talker);
          l4 = cl.aWy() - 259200000L;
          localObject3 = f.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aZ(this.talker, l4);
          if (((eo)localObject2).field_msgId == 0L)
          {
            Log.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((l)g.af(l.class)).aTq().aEk(this.talker);
            long l5 = ((l)g.af(l.class)).aTq().aEj(this.talker);
            ((ca)localObject2).setCreateTime(l4);
            ((ca)localObject2).yH(l5);
          }
          String str = f.formatTime("yyyy-MM-dd HH:mm:ss", ((eo)localObject2).field_createTime / 1000L);
          Log.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((eo)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((eo)localObject2).field_createTime), localObject3, str });
          localObject3 = new jk();
          ((jk)localObject3).dOf.username = y.this.dom.getTalkerUserName();
          ((jk)localObject3).dOf.dOi = ((eo)localObject2).field_msgSeq;
          ((jk)localObject3).dOf.dOj = ((eo)localObject2).field_createTime;
          ((jk)localObject3).dOf.dOg = l2;
          ((jk)localObject3).dOf.dOh = l3;
          EventCenter.instance.publish((IEvent)localObject3);
          y.b(y.this).sendEmptyMessage(8);
          if ((localca != null) && (localca.field_msgSeq != l2)) {
            y.b(y.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            y.b(y.this).sendEmptyMessage(4);
          }
        }
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        y.b(y.this).sendEmptyMessage(2);
        break;
        i = 1;
        continue;
        label929:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.y
 * JD-Core Version:    0.7.0.1
 */