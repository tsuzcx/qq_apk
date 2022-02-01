package com.tencent.mm.ui.chatting.o.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.o.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f
  extends a
{
  private volatile long BLt;
  private volatile long XaB;
  private volatile long XaC;
  private boolean XaF;
  private Runnable XaG;
  private String talker;
  
  public f(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.XaB = 0L;
    this.XaC = 0L;
    this.BLt = 0L;
    this.talker = hmp().getTalkerUserName();
    Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int hTB()
  {
    AppMethodBeat.i(36680);
    int i = ((aa)hmp().bC(aa.class)).hPV();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.WZK[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.XaB), Long.valueOf(this.XaC), Long.valueOf(this.BLt), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.o.d(hmp().getTalkerUserName(), this.XaB, this.XaC);
        AppMethodBeat.o(36678);
        return parama;
        if (paramBundle == null)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          this.XaF = paramBundle.getBoolean("IS_LOAD_ALL", false);
          bh.beI();
          paramBundle = c.bbO().Oq(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.XaB) || (l > this.XaC))
      {
        this.XaB = l;
        this.BLt = ((n)h.ae(n.class)).eSe().aPa(this.talker);
        if (this.XaF)
        {
          this.XaC = this.BLt;
          label311:
          bh.beI();
          i = c.bbO().D(this.talker, this.XaB, this.XaC);
          Log.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label799;
          }
          Log.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.XaB), Integer.valueOf(0) });
          bh.beI();
          this.XaB = c.bbO().j(this.talker, this.XaB, 48);
          bh.beI();
          i = c.bbO().D(this.talker, this.XaB, l);
        }
      }
      break;
    }
    for (;;)
    {
      paramd.selection = i;
      i = 0;
      j = 0;
      break;
      bh.beI();
      this.XaC = c.bbO().k(this.talker, l, 48);
      break label311;
      bh.beI();
      i = c.bbO().D(this.talker, this.XaB, l);
      continue;
      bh.beI();
      l = c.bbO().j(this.talker, this.XaB, 48);
      bh.beI();
      j = Math.max(0, c.bbO().D(this.talker, l, this.XaB) - 1);
      this.XaB = l;
      i = 0;
      break;
      bh.beI();
      l = c.bbO().k(this.talker, this.XaC, 48);
      bh.beI();
      i = Math.max(0, c.bbO().D(this.talker, this.XaC, l) - 1);
      this.XaC = l;
      j = 0;
      break;
      paramBundle = ((n)h.ae(n.class)).eSe().aOH(this.talker);
      this.BLt = paramBundle.field_createTime;
      bh.beI();
      i = Math.max(0, c.bbO().D(this.talker, this.XaC, this.BLt) - 1);
      if ((this.XaF) || (i <= 480)) {}
      for (this.XaC = this.BLt;; this.XaC = this.BLt)
      {
        do
        {
          j = 0;
          break;
        } while ((paramBundle.field_isSend != 1) || (this.BLt == paramBundle.field_createTime));
        this.BLt = paramBundle.field_createTime;
        bh.beI();
        this.XaB = c.bbO().j(this.talker, this.XaB, 48);
      }
      label799:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.WYy;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.WZK[localObject.ordinal()])
    {
    default: 
      if (hmp().getLastVisiblePosition() == paramd.WYA - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((n)h.ae(n.class)).eSe().aOZ(this.talker);
      Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.XaB) });
      if (this.XaB <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.XaC < this.BLt) {
          break label426;
        }
      }
      break;
    }
    label426:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMMChattingListView.setIsBottomShowAll(bool1);
      AppMethodBeat.o(36679);
      return;
      paramMMChattingListView.FP(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      r.a(paramMMChattingListView.getListView(), i - j + 1, hTB() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((k)hmp().bC(k.class)).avv(i);
      break;
      paramMMChattingListView.FQ(false);
      r.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - hTB() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = hmp().WQv.getBooleanExtra("need_hight_item", false).booleanValue();
      awC(i);
      if (!bool1) {
        break;
      }
      hmp().WQv.getLongExtra("msg_local_id", -1L);
      Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      MMHandlerThread.removeRunnable(this.XaG);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - f.this.hmp().getFirstVisiblePosition());
          f.this.awC(i);
          paramMMChattingListView.setHighLightChild(i);
          bh.beI();
          c.aHp().set(ar.a.Vkz, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.XaG = ((Runnable)localObject);
      MMHandlerThread.postToMainThreadDelayed((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a.f
 * JD-Core Version:    0.7.0.1
 */