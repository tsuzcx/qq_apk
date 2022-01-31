package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a.1;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.p;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.f.d.a;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.c.a.a(dJy=p.class)
public class r
  extends a
  implements n.b, p
{
  private Handler mMainHandler;
  private r.a zGd;
  private HashSet<String> zGe;
  private volatile bi zGf;
  private com.tencent.mm.ui.chatting.c.b.h zGg;
  
  public r()
  {
    AppMethodBeat.i(31445);
    this.zGe = new HashSet();
    this.mMainHandler = new r.3(this, Looper.getMainLooper());
    AppMethodBeat.o(31445);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(31452);
    paramn = (b.a)paramObject;
    paramObject = paramn.username;
    boolean bool = paramn.oDK;
    if (!paramObject.equals(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31452);
      return;
    }
    ab.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(paramn.id), Boolean.valueOf(paramn.oDK) });
    if ((paramInt == 4) && (!bool))
    {
      ab.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(paramObject)));
      this.mMainHandler.sendEmptyMessage(8);
    }
    if ((!bool) && ((paramInt == 2) || (paramInt == 4)))
    {
      paramn = ((j)g.E(j.class)).bPL().SY(this.caz.getTalkerUserName());
      long l1 = paramn.field_lastPushSeq;
      long l2 = paramn.field_lastLocalSeq;
      com.tencent.mm.aq.b.agX().a(this.caz.getTalkerUserName(), l2 + 1L, l1, 0, null);
    }
    AppMethodBeat.o(31452);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31446);
    super.dBY();
    if (!this.caz.dJG())
    {
      AppMethodBeat.o(31446);
      return;
    }
    g.RO().ac(new r.1(this));
    AppMethodBeat.o(31446);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31447);
    super.dBZ();
    if (!this.caz.dJG())
    {
      AppMethodBeat.o(31447);
      return;
    }
    long l = System.currentTimeMillis();
    ((j)g.E(j.class)).bPL().a(this, g.RO().oNc.getLooper());
    this.zGd = new r.a(this, this.caz.getTalkerUserName(), (byte)0);
    d.g(this.zGd, "[GetChatroomComponent]");
    ab.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), this.caz.getTalkerUserName() });
    AppMethodBeat.o(31447);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31448);
    super.dCd();
    if (!this.caz.dJG())
    {
      AppMethodBeat.o(31448);
      return;
    }
    d.ysm.remove(this.zGd);
    ((j)g.E(j.class)).bPL().b(this);
    if (!this.zGe.contains(this.caz.getTalkerUserName()))
    {
      d.post(new a.1(com.tencent.mm.aq.a.agW(), this.caz.getTalkerUserName()), "checkDirtyBlock");
      this.zGe.add(this.caz.getTalkerUserName());
    }
    AppMethodBeat.o(31448);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31449);
    super.dHq();
    ((j)g.E(j.class)).bPL().b(this);
    AppMethodBeat.o(31449);
  }
  
  public final boolean dIr()
  {
    AppMethodBeat.i(31450);
    boolean bool = ((j)g.E(j.class)).bPL().SW(this.caz.getTalkerUserName());
    AppMethodBeat.o(31450);
    return bool;
  }
  
  public final void dIs()
  {
    boolean bool2 = false;
    AppMethodBeat.i(31451);
    if (this.zGf == null)
    {
      ab.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", new Object[] { this.caz.getTalkerUserName() });
      AppMethodBeat.o(31451);
      return;
    }
    long l1 = System.currentTimeMillis();
    c localc = ((j)g.E(j.class)).bPL().f(this.caz.getTalkerUserName(), this.zGf.field_createTime, false);
    Object localObject = bo.aqg(this.zGf.field_content);
    boolean bool1;
    int i;
    if (localc == null)
    {
      bool1 = true;
      ab.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s", new Object[] { localObject, Boolean.valueOf(bool1), Long.valueOf(this.zGf.field_createTime) });
      if (localc != null) {
        break label485;
      }
      if (this.zGg == null) {
        this.zGg = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class));
      }
      i = ((s)this.caz.ay(s.class)).dIH();
      if (this.zGg.getCount() < i) {
        break label445;
      }
      localObject = this.zGg.Pz(this.zGg.getCount() - 1);
      if (localObject != null) {
        break label358;
      }
      ab.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
      label236:
      i = 0;
      ab.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", new Object[] { Integer.valueOf(i) });
      this.caz.bJ(i);
      ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).PA(i);
    }
    for (;;)
    {
      ((s)this.caz.ay(s.class)).dII();
      long l2 = System.currentTimeMillis();
      bool1 = bool2;
      if (localc == null) {
        bool1 = true;
      }
      ab.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] cost:%s null == seqBlock?:%s", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool1) });
      AppMethodBeat.o(31451);
      return;
      bool1 = false;
      break;
      label358:
      l2 = ((j)g.E(j.class)).bPQ().g(this.caz.getTalkerUserName(), ((dd)localObject).field_createTime, i);
      i = this.zGg.getCount() - 1;
      for (;;)
      {
        if (i < 0) {
          break label443;
        }
        localObject = this.zGg.Pz(i);
        if ((localObject != null) && (((dd)localObject).field_createTime == l2)) {
          break;
        }
        i -= 1;
      }
      label443:
      break label236;
      label445:
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MSG_POSITION_UNREAD_COUNT", i);
      this.caz.zJz.dGc().a(d.a.zOA, true, (Bundle)localObject);
      break label236;
      label485:
      this.caz.bJ(0);
      this.caz.getListView().postDelayed(new r.2(this), 166L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r
 * JD-Core Version:    0.7.0.1
 */