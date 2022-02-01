package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.1;
import com.tencent.mm.f.a.ka;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.j.f;
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
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.d.a.a(hRc=v.class)
public class z
  extends a
  implements MStorageEx.IOnStorageChange, v
{
  private volatile ca WKA;
  private k WKB;
  private a WKy;
  private HashSet<String> WKz;
  private Handler mMainHandler;
  
  public z()
  {
    AppMethodBeat.i(35341);
    this.WKz = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (an)z.this.fgR.bC(an.class);
          boolean bool;
          if ((paramAnonymousMessage.hQy()) || (paramAnonymousMessage.hQx()))
          {
            bool = true;
            z.this.fgR.WQx.setIsBottomShowAll(false);
            z.this.fgR.WQx.hNi();
            if (!bool) {
              break label146;
            }
            z.this.fgR.WQx.hNl();
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), z.this.fgR.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label146:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            z.this.fgR.WQx.bp(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          z.this.fgR.WQx.setIsBottomShowAll(true);
          z.this.fgR.WQx.hNi();
          z.b(z.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((ab)z.this.fgR.bC(ab.class)).hPZ();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { z.this.fgR.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          z.this.fgR.WQx.setIsBottomShowAll(false);
          z.this.fgR.WQx.hNi();
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          z.this.fgR.WQx.bp(paramAnonymousMessage);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { z.this.fgR.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          z.this.fgR.WQv.hMt();
        }
        AppMethodBeat.o(35339);
      }
    };
    AppMethodBeat.o(35341);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35342);
    super.hGU();
    if (!this.fgR.hRi())
    {
      AppMethodBeat.o(35342);
      return;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        z.a(z.this, ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(z.this.fgR.getTalkerUserName()));
        if (z.a(z.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        Log.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), z.this.fgR.getTalkerUserName(), Long.valueOf(z.a(z.this).field_createTime) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35343);
    super.hGV();
    if (!this.fgR.hRi())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().add(this, com.tencent.mm.kernel.h.aHJ().getLooper());
    this.WKy = new a(this.fgR.getTalkerUserName(), (byte)0);
    com.tencent.e.h.ZvG.be(this.WKy);
    Log.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.fgR.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35344);
    super.hGZ();
    if (!this.fgR.hRi())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.WKy.cancel();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().remove(this);
    if (!this.WKz.contains(this.fgR.getTalkerUserName()))
    {
      ThreadPool.post(new a.1(com.tencent.mm.av.a.blv(), this.fgR.getTalkerUserName()), "checkDirtyBlock");
      this.WKz.add(this.fgR.getTalkerUserName());
    }
    com.tencent.mm.av.b.blw().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35345);
    super.hNZ();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().remove(this);
    com.tencent.mm.av.b.blw().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean hPw()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().aOp(this.fgR.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void hPx()
  {
    AppMethodBeat.i(35347);
    if (this.WKA == null)
    {
      Log.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.fgR.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.k.a.a.c localc = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().d(this.fgR.getTalkerUserName(), this.WKA.field_createTime, false);
    Object localObject = Util.secPrint(this.WKA.field_content);
    int i;
    label231:
    com.tencent.mm.hellhoundlib.b.a locala;
    label358:
    long l2;
    if (localc == null)
    {
      bool = true;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.WKA.field_createTime) });
      if (localc != null) {
        break label558;
      }
      if (this.WKB == null) {
        this.WKB = ((k)this.fgR.bC(k.class));
      }
      i = ((ab)this.fgR.bC(ab.class)).hPX();
      if (this.WKB.getCount() < i) {
        break label518;
      }
      localObject = this.WKB.avt(this.WKB.getCount() - 1);
      if (localObject != null) {
        break label431;
      }
      Log.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.fgR;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((k)this.fgR.bC(k.class)).avu(i);
      ((ab)this.fgR.bC(ab.class)).hPY();
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
      l2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().j(this.fgR.getTalkerUserName(), ((et)localObject).field_createTime, i);
      i = this.WKB.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label516;
        }
        localObject = this.WKB.avt(i);
        if ((localObject != null) && (((et)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      break label231;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.fgR.WQv.hMs().a(d.a.WYu, true, (Bundle)localObject);
      break label231;
      label558:
      localObject = this.fgR;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.fgR.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", z.a(z.this).field_msgId);
          z.this.fgR.WQx.bq(localBundle);
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
    boolean bool = paramMStorageEx.EVH;
    if (!paramObject.equals(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(paramMStorageEx.id), Boolean.valueOf(paramMStorageEx.EVH) });
    if ((paramInt == 4) && (!bool))
    {
      Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramMStorageEx = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().aOr(this.fgR.getTalkerUserName());
      long l1 = paramMStorageEx.field_lastPushSeq;
      long l2 = paramMStorageEx.field_lastLocalSeq;
      com.tencent.mm.av.b.blw().a(this.fgR.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
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
        bh.beI();
        Object localObject1 = com.tencent.mm.model.c.bbR().bwx(this.talker);
        localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            z.b(z.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((bb)localObject1).field_lastSeq;
        l3 = ((bb)localObject1).field_conversationTime;
        if (z.this.hPw())
        {
          localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().aOr(z.this.fgR.getTalkerUserName());
          l2 = ((aj)localObject1).field_lastLocalSeq;
          l3 = ((aj)localObject1).field_lastPushSeq;
          Log.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label291;
            }
            z.b(z.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label291:
            z.b(z.this).sendEmptyMessage(2);
          }
        }
        if (!localaz.rp(67108864)) {
          break label406;
        }
      }
      finally
      {
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      Log.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      z.b(z.this).sendEmptyMessage(2);
      Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localaz.rn(67108864);
      bh.beI();
      com.tencent.mm.model.c.bbR().a(localaz, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).iR(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      Log.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((et)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((et)localObject3).field_msgId <= 0L) {
        if (localaz.field_UnDeliverCount <= 0) {
          break label929;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aOJ(this.talker);
          l4 = cm.bfC() - 259200000L;
          localObject3 = f.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).ba(this.talker, l4);
          if (((et)localObject2).field_msgId == 0L)
          {
            Log.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aOu(this.talker);
            long l5 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aOt(this.talker);
            ((ca)localObject2).setCreateTime(l4);
            ((ca)localObject2).EI(l5);
          }
          String str = f.formatTime("yyyy-MM-dd HH:mm:ss", ((et)localObject2).field_createTime / 1000L);
          Log.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((et)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((et)localObject2).field_createTime), localObject3, str });
          localObject3 = new ka();
          ((ka)localObject3).fHq.username = z.this.fgR.getTalkerUserName();
          ((ka)localObject3).fHq.fHt = ((et)localObject2).field_msgSeq;
          ((ka)localObject3).fHq.fHu = ((et)localObject2).field_createTime;
          ((ka)localObject3).fHq.fHr = l2;
          ((ka)localObject3).fHq.fHs = l3;
          EventCenter.instance.publish((IEvent)localObject3);
          z.b(z.this).sendEmptyMessage(8);
          if ((localca != null) && (localca.field_msgSeq != l2)) {
            z.b(z.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            z.b(z.this).sendEmptyMessage(4);
          }
        }
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        z.b(z.this).sendEmptyMessage(2);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.z
 * JD-Core Version:    0.7.0.1
 */