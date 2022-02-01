package com.tencent.mm.ui.chatting.component;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.ax;
import com.tencent.mm.ui.chatting.component.api.m;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ax.class)
@Deprecated
public final class bk
  extends a
  implements by.a, ax
{
  public static int aexc = 350;
  
  public final void a(bb parambb, by paramby)
  {
    AppMethodBeat.i(35617);
    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { parambb.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.hlc.ffv)
    {
      Log.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    if ((this.hlc.juG()) && (this.hlc.Uxa.field_username.equals(parambb.field_username)))
    {
      paramby = (m)this.hlc.cm(m.class);
      int i = parambb.field_msgCount;
      int j = paramby.dWF();
      parambb = new Object[4];
      parambb[0] = Integer.valueOf(i);
      parambb[1] = Integer.valueOf(j);
      AppMethodBeat.o(35617);
      throw null;
    }
    AppMethodBeat.o(35617);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35620);
    AppMethodBeat.o(35620);
    throw null;
  }
  
  public final void jjj() {}
  
  public final void jjk()
  {
    AppMethodBeat.i(35621);
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
          paramAbsListView = this.hlc.getChildAt(this.hlc.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.hlc.juG()) {
              break label862;
            }
            paramAbsListView = ((m)this.hlc.cm(m.class)).aBV(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.getCreateTime()), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.hlc.aezQ.jpO();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.hlc.juG()) || (this.hlc.getChildAt(this.hlc.getListView().getChildCount() - 1) == null)) {
            break label862;
          }
          localObject = (m)this.hlc.cm(m.class);
          if (this.hlc.getLastVisiblePosition() != this.hlc.getListView().getAdapter().getCount() - 1) {
            break label862;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label878;
          }
          paramAbsListView = ((m)this.hlc.cm(m.class)).aBV(((m)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label881;
            }
            localObject = ((n)h.ax(n.class)).gaZ().aV(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((localObject == null) || (((fi)localObject).field_msgId == 0L) || (((fi)localObject).field_msgId != paramAbsListView.field_msgId) || ((((fi)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Integer.valueOf(((fi)localObject).field_flag) });
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
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.getCreateTime()), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.hlc.aezQ.setIsBottomShowAll(false);
        this.hlc.aezQ.jpM();
        this.hlc.aezQ.jpP();
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        bh.baH().postToWorker(new bk.1(this, paramAbsListView));
        AppMethodBeat.o(35619);
        return;
      }
      AppMethodBeat.o(35619);
      return;
    }
    for (;;)
    {
      label699:
      int i;
      if ((paramAbsListView.field_flag & 0x2) != 0)
      {
        i = 1;
        label710:
        if ((i & paramInt) != 0)
        {
          bh.bCz();
          localObject = c.bzD().aLG(paramAbsListView.field_talker);
          if ((localObject != null) && (((fi)localObject).field_msgId != 0L) && (((cc)localObject).getCreateTime() > paramAbsListView.getCreateTime())) {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((fi)localObject).field_flag), Integer.valueOf(((fi)localObject).field_isSend), Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((fi)localObject).field_msgSvrId), Long.valueOf(((fi)localObject).field_msgSeq), Long.valueOf(((cc)localObject).getCreateTime()), Integer.valueOf(((cc)localObject).getType()), ((fi)localObject).field_talker });
          }
        }
        label862:
        AppMethodBeat.o(35619);
        return;
      }
      label878:
      label881:
      do
      {
        paramInt = 0;
        break label699;
        i = 0;
        break label710;
        break;
      } while (paramAbsListView == null);
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bk
 * JD-Core Version:    0.7.0.1
 */