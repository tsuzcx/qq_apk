package com.tencent.mm.ui.chatting.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ld;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelgetchatroommsg.a.1;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.y;
import com.tencent.mm.ui.chatting.f.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=y.class)
public class ac
  extends a
  implements MStorageEx.IOnStorageChange, y
{
  private a aesC;
  private HashSet<String> aesD;
  private volatile cc aesE;
  private m aesF;
  private Handler mMainHandler;
  
  public ac()
  {
    AppMethodBeat.i(35341);
    this.aesD = new HashSet();
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35339);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (au)ac.this.hlc.cm(au.class);
          boolean bool;
          if ((paramAnonymousMessage.jtA()) || (paramAnonymousMessage.jtz()))
          {
            bool = true;
            ac.this.hlc.aezQ.setIsBottomShowAll(false);
            ac.this.hlc.aezQ.jpM();
            if (!bool) {
              break label146;
            }
            ac.this.hlc.aezQ.jpP();
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), ac.this.hlc.getTalkerUserName() });
            AppMethodBeat.o(35339);
            return;
            bool = false;
            break;
            label146:
            paramAnonymousMessage = new Bundle();
            paramAnonymousMessage.putBoolean("load_bottom", true);
            ac.this.hlc.aezQ.bV(paramAnonymousMessage);
          }
        }
        if (paramAnonymousMessage.what == 2)
        {
          ac.this.hlc.aezQ.setIsBottomShowAll(true);
          ac.this.hlc.aezQ.jpM();
          ac.b(ac.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35338);
              ((ae)ac.this.hlc.cm(ae.class)).jsX();
              AppMethodBeat.o(35338);
            }
          }, 300L);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { ac.this.hlc.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 4)
        {
          ac.this.hlc.aezQ.setIsBottomShowAll(false);
          ac.this.hlc.aezQ.jpM();
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putBoolean("load_bottom", true);
          ac.this.hlc.aezQ.bV(paramAnonymousMessage);
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { ac.this.hlc.getTalkerUserName() });
          AppMethodBeat.o(35339);
          return;
        }
        if (paramAnonymousMessage.what == 8)
        {
          Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
          ac.this.hlc.aezO.joW();
        }
        AppMethodBeat.o(35339);
      }
    };
    AppMethodBeat.o(35341);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35342);
    super.jjf();
    if (!this.hlc.juG())
    {
      AppMethodBeat.o(35342);
      return;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35336);
        long l = System.currentTimeMillis();
        ac.a(ac.this, ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(ac.this.hlc.getTalkerUserName()));
        if (ac.a(ac.this) == null)
        {
          AppMethodBeat.o(35336);
          return;
        }
        Log.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ac.this.hlc.getTalkerUserName(), Long.valueOf(ac.a(ac.this).getCreateTime()) });
        AppMethodBeat.o(35336);
      }
    });
    AppMethodBeat.o(35342);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35343);
    super.jjg();
    if (!this.hlc.juG())
    {
      AppMethodBeat.o(35343);
      return;
    }
    long l = System.currentTimeMillis();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().add(this, com.tencent.mm.kernel.h.baH().getLooper());
    this.aesC = new a(this.hlc.getTalkerUserName(), (byte)0);
    com.tencent.threadpool.h.ahAA.bm(this.aesC);
    Log.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.hlc.getTalkerUserName() });
    AppMethodBeat.o(35343);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35344);
    super.jjk();
    if (!this.hlc.juG())
    {
      AppMethodBeat.o(35344);
      return;
    }
    this.aesC.cancel();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().remove(this);
    if (!this.aesD.contains(this.hlc.getTalkerUserName()))
    {
      ThreadPool.post(new a.1(com.tencent.mm.modelgetchatroommsg.a.bJq(), this.hlc.getTalkerUserName()), "checkDirtyBlock");
      this.aesD.add(this.hlc.getTalkerUserName());
    }
    com.tencent.mm.modelgetchatroommsg.b.bJr().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35344);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35345);
    super.jqF();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().remove(this);
    com.tencent.mm.modelgetchatroommsg.b.bJr().cancel();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(35345);
  }
  
  public final boolean jss()
  {
    AppMethodBeat.i(35346);
    boolean bool = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().aLo(this.hlc.getTalkerUserName());
    AppMethodBeat.o(35346);
    return bool;
  }
  
  public final void jst()
  {
    AppMethodBeat.i(35347);
    if (this.aesE == null)
    {
      Log.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.hlc.getTalkerUserName() });
      AppMethodBeat.o(35347);
      return;
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.h.a.a.c localc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().d(this.hlc.getTalkerUserName(), this.aesE.getCreateTime(), false);
    Object localObject = Util.secPrint(this.aesE.field_content);
    int i;
    label232:
    com.tencent.mm.hellhoundlib.b.a locala;
    label359:
    long l2;
    if (localc == null)
    {
      bool = true;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool), Long.valueOf(this.aesE.getCreateTime()) });
      if (localc != null) {
        break label559;
      }
      if (this.aesF == null) {
        this.aesF = ((m)this.hlc.cm(m.class));
      }
      i = ((ae)this.hlc.cm(ae.class)).jsV();
      if (this.aesF.getCount() < i) {
        break label519;
      }
      localObject = this.aesF.aBV(this.aesF.getCount() - 1);
      if (localObject != null) {
        break label432;
      }
      Log.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      i = 0;
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      localObject = this.hlc;
      locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((m)this.hlc.cm(m.class)).aBW(i);
      ((ae)this.hlc.cm(ae.class)).jsW();
      l2 = System.currentTimeMillis();
      if (localc != null) {
        break label671;
      }
    }
    label517:
    label519:
    label671:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
      AppMethodBeat.o(35347);
      return;
      bool = false;
      break;
      label432:
      l2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().l(this.hlc.getTalkerUserName(), ((cc)localObject).getCreateTime(), i);
      i = this.aesF.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label517;
        }
        localObject = this.aesF.aBV(i);
        if ((localObject != null) && (((cc)localObject).getCreateTime() == l2)) {
          break;
        }
        i -= 1;
      }
      break label232;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.hlc.aezO.joV().a(d.a.aeHU, true, (Bundle)localObject);
      break label232;
      label559:
      localObject = this.hlc;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/GetChatroomComponent", "goBackToHistory", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.hlc.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35337);
          Bundle localBundle = new Bundle();
          localBundle.putLong("MSG_ID", ac.a(ac.this).field_msgId);
          ac.this.hlc.aezQ.bW(localBundle);
          AppMethodBeat.o(35337);
        }
      }, 166L);
      break label359;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35348);
    paramMStorageEx = (b.a)paramObject;
    paramObject = paramMStorageEx.username;
    boolean bool = paramMStorageEx.KRh;
    if (!paramObject.equals(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(35348);
      return;
    }
    Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(paramMStorageEx.id), Boolean.valueOf(paramMStorageEx.KRh) });
    if ((paramInt == 4) && (!bool))
    {
      Log.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramMStorageEx = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().aLq(this.hlc.getTalkerUserName());
      long l1 = paramMStorageEx.field_lastPushSeq;
      long l2 = paramMStorageEx.field_lastLocalSeq;
      com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.hlc.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(35348);
  }
  
  final class a
    extends com.tencent.threadpool.i.b
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
        bh.bCz();
        Object localObject1 = com.tencent.mm.model.c.bzG().bxM(this.talker);
        localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ();
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (localObject1 == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.e("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] null == conv?%s talker:%s", new Object[] { Boolean.valueOf(bool), this.talker });
            ac.b(ac.this).sendEmptyMessage(2);
            return;
          }
        }
        l2 = ((bd)localObject1).field_lastSeq;
        l3 = ((bd)localObject1).field_conversationTime;
        if (ac.this.jss())
        {
          localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().aLq(ac.this.hlc.getTalkerUserName());
          l2 = ((al)localObject1).field_lastLocalSeq;
          l3 = ((al)localObject1).field_lastPushSeq;
          Log.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + l3 + " lastLocalSeq:" + l2);
          if (l2 != l3)
          {
            i = 1;
            if (i == 0) {
              break label291;
            }
            ac.b(ac.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            return;
            i = 0;
            break;
            label291:
            ac.b(ac.this).sendEmptyMessage(2);
          }
        }
        if (!localbb.rx(67108864)) {
          break label406;
        }
      }
      finally
      {
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35340);
      }
      Log.w("MicroMsg.GetChatroomComponent", "has check! %s", new Object[] { this.talker });
      ac.b(ac.this).sendEmptyMessage(2);
      Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(35340);
      return;
      label406:
      localbb.rv(67108864);
      bh.bCz();
      com.tencent.mm.model.c.bzG().c(localbb, this.talker);
      long l4 = System.currentTimeMillis();
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).kf(this.talker, " and msgSeq != 0 and flag & 2 != 0");
      Log.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", new Object[] { Long.valueOf(((fi)localObject3).field_msgSeq), Long.valueOf(System.currentTimeMillis() - l4), " and msgSeq != 0 and flag & 2 != 0" });
      if (((fi)localObject3).field_msgId <= 0L) {
        if (localbb.field_UnDeliverCount <= 0) {
          break label931;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).aLI(this.talker);
          l4 = cn.bDu() - 259200000L;
          localObject3 = f.formatTime("yyyy-MM-dd HH:mm:ss", l4 / 1000L);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject2).bj(this.talker, l4);
          if ((localObject2 == null) || (((fi)localObject2).field_msgId == 0L))
          {
            Log.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
            l4 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aLt(this.talker);
            long l5 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aLs(this.talker);
            ((cc)localObject2).setCreateTime(l4);
            ((cc)localObject2).gZ(l5);
          }
          String str = f.formatTime("yyyy-MM-dd HH:mm:ss", ((cc)localObject2).getCreateTime() / 1000L);
          Log.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", new Object[] { this.talker, Long.valueOf(l2), Long.valueOf(((fi)localObject2).field_msgSeq), Long.valueOf(l3), Long.valueOf(((cc)localObject2).getCreateTime()), localObject3, str });
          localObject3 = new ld();
          ((ld)localObject3).hMP.username = ac.this.hlc.getTalkerUserName();
          ((ld)localObject3).hMP.hMS = ((fi)localObject2).field_msgSeq;
          ((ld)localObject3).hMP.hMT = ((cc)localObject2).getCreateTime();
          ((ld)localObject3).hMP.hMQ = l2;
          ((ld)localObject3).hMP.hMR = l3;
          ((ld)localObject3).publish();
          ac.b(ac.this).sendEmptyMessage(8);
          if ((localcc != null) && (localcc.field_msgSeq != l2)) {
            ac.b(ac.this).sendEmptyMessage(1);
          }
          for (;;)
          {
            Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", new Object[] { this.talker });
            break;
            ac.b(ac.this).sendEmptyMessage(4);
          }
        }
        Log.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", new Object[] { this.talker });
        ac.b(ac.this).sendEmptyMessage(2);
        break;
        i = 1;
        continue;
        label931:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ac
 * JD-Core Version:    0.7.0.1
 */