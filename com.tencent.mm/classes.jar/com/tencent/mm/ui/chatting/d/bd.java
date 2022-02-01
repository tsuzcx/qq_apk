package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.k;

@com.tencent.mm.ui.chatting.d.a.a(hRc=aq.class)
@Deprecated
public final class bd
  extends a
  implements bw.a, aq
{
  public static int WOB = 350;
  
  public final void a(az paramaz, bw parambw)
  {
    AppMethodBeat.i(35617);
    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramaz.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.fgR.dgo)
    {
      Log.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    if ((this.fgR.hRi()) && (this.fgR.NKq.field_username.equals(paramaz.field_username)))
    {
      parambw = (k)this.fgR.bC(k.class);
      int i = paramaz.field_msgCount;
      int j = parambw.dpe();
      paramaz = new Object[4];
      paramaz[0] = Integer.valueOf(i);
      paramaz[1] = Integer.valueOf(j);
      AppMethodBeat.o(35617);
      throw null;
    }
    AppMethodBeat.o(35617);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35620);
    AppMethodBeat.o(35620);
    throw null;
  }
  
  public final void hGY() {}
  
  public final void hGZ()
  {
    AppMethodBeat.i(35621);
    EventCenter localEventCenter = EventCenter.instance;
    AppMethodBeat.o(35621);
    throw null;
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35619);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      for (;;)
      {
        try
        {
          paramAbsListView = this.fgR.getChildAt(this.fgR.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.fgR.hRi()) {
              break label857;
            }
            paramAbsListView = ((k)this.fgR.bC(k.class)).avt(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.fgR.WQx.hNk();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.fgR.hRi()) || (this.fgR.getChildAt(this.fgR.getListView().getChildCount() - 1) == null)) {
            break label857;
          }
          localObject = (k)this.fgR.bC(k.class);
          if (this.fgR.getLastVisiblePosition() != this.fgR.getListView().getAdapter().getCount() - 1) {
            break label857;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label873;
          }
          paramAbsListView = ((k)this.fgR.bC(k.class)).avt(((k)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label876;
            }
            localObject = ((n)h.ae(n.class)).eSe().aM(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((et)localObject).field_msgId == 0L) || (((et)localObject).field_msgId != paramAbsListView.field_msgId) || ((((et)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Integer.valueOf(((et)localObject).field_flag) });
            AppMethodBeat.o(35619);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          Log.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(35619);
          return;
        }
        paramInt += 1;
      }
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.fgR.WQx.setIsBottomShowAll(false);
        this.fgR.WQx.hNi();
        this.fgR.WQx.hNl();
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        bh.aHJ().postToWorker(new bd.1(this, paramAbsListView));
        AppMethodBeat.o(35619);
        return;
      }
      AppMethodBeat.o(35619);
      return;
    }
    for (;;)
    {
      label694:
      int i;
      if ((paramAbsListView.field_flag & 0x2) != 0)
      {
        i = 1;
        label705:
        if ((i & paramInt) != 0)
        {
          bh.beI();
          localObject = c.bbO().aOH(paramAbsListView.field_talker);
          if ((localObject != null) && (((et)localObject).field_msgId != 0L) && (((et)localObject).field_createTime > paramAbsListView.field_createTime)) {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((et)localObject).field_flag), Integer.valueOf(((et)localObject).field_isSend), Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_msgSvrId), Long.valueOf(((et)localObject).field_msgSeq), Long.valueOf(((et)localObject).field_createTime), Integer.valueOf(((ca)localObject).getType()), ((et)localObject).field_talker });
          }
        }
        label857:
        AppMethodBeat.o(35619);
        return;
      }
      label873:
      label876:
      do
      {
        paramInt = 0;
        break label694;
        i = 0;
        break label705;
        break;
      } while (paramAbsListView == null);
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd
 * JD-Core Version:    0.7.0.1
 */