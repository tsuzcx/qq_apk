package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
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
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f
  extends a
{
  private volatile long PFN;
  private volatile long PFO;
  private boolean PFR;
  private Runnable PFS;
  private String talker;
  private volatile long wZu;
  
  public f(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.PFN = 0L;
    this.PFO = 0L;
    this.wZu = 0L;
    this.talker = grq().getTalkerUserName();
    Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int gTR()
  {
    AppMethodBeat.i(36680);
    int i = ((aa)grq().bh(aa.class)).gQy();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.n.f a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.PEY[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.PFN), Long.valueOf(this.PFO), Long.valueOf(this.wZu), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.n.d(grq().getTalkerUserName(), this.PFN, this.PFO);
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
          this.PFR = paramBundle.getBoolean("IS_LOAD_ALL", false);
          bg.aVF();
          paramBundle = c.aSQ().Hb(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.PFN) || (l > this.PFO))
      {
        this.PFN = l;
        this.wZu = ((l)g.af(l.class)).eiy().aEQ(this.talker);
        if (this.PFR)
        {
          this.PFO = this.wZu;
          label311:
          bg.aVF();
          i = c.aSQ().E(this.talker, this.PFN, this.PFO);
          Log.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label799;
          }
          Log.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.PFN), Integer.valueOf(0) });
          bg.aVF();
          this.PFN = c.aSQ().i(this.talker, this.PFN, 48);
          bg.aVF();
          i = c.aSQ().E(this.talker, this.PFN, l);
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
      bg.aVF();
      this.PFO = c.aSQ().j(this.talker, l, 48);
      break label311;
      bg.aVF();
      i = c.aSQ().E(this.talker, this.PFN, l);
      continue;
      bg.aVF();
      l = c.aSQ().i(this.talker, this.PFN, 48);
      bg.aVF();
      j = Math.max(0, c.aSQ().E(this.talker, l, this.PFN) - 1);
      this.PFN = l;
      i = 0;
      break;
      bg.aVF();
      l = c.aSQ().j(this.talker, this.PFO, 48);
      bg.aVF();
      i = Math.max(0, c.aSQ().E(this.talker, this.PFO, l) - 1);
      this.PFO = l;
      j = 0;
      break;
      paramBundle = ((l)g.af(l.class)).eiy().aEx(this.talker);
      this.wZu = paramBundle.field_createTime;
      bg.aVF();
      i = Math.max(0, c.aSQ().E(this.talker, this.PFO, this.wZu) - 1);
      if ((this.PFR) || (i <= 480)) {}
      for (this.PFO = this.wZu;; this.PFO = this.wZu)
      {
        do
        {
          j = 0;
          break;
        } while ((paramBundle.field_isSend != 1) || (this.wZu == paramBundle.field_createTime));
        this.wZu = paramBundle.field_createTime;
        bg.aVF();
        this.PFN = c.aSQ().i(this.talker, this.PFN, 48);
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
    Object localObject = paramd.PDL;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.PEY[localObject.ordinal()])
    {
    default: 
      if (grq().getLastVisiblePosition() == paramd.PDN - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((l)g.af(l.class)).eiy().aEP(this.talker);
      Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.PFN) });
      if (this.PFN <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.PFO < this.wZu) {
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
      paramMMChattingListView.Bx(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      p.a(paramMMChattingListView.getListView(), i - j + 1, gTR() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((k)grq().bh(k.class)).amv(i);
      break;
      paramMMChattingListView.By(false);
      p.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - gTR() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = grq().Pwc.getBooleanExtra("need_hight_item", false).booleanValue();
      any(i);
      if (!bool1) {
        break;
      }
      grq().Pwc.getLongExtra("msg_local_id", -1L);
      Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      MMHandlerThread.removeRunnable(this.PFS);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - f.this.grq().getFirstVisiblePosition());
          f.this.any(i);
          paramMMChattingListView.setHighLightChild(i);
          bg.aVF();
          c.azQ().set(ar.a.NWz, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.PFS = ((Runnable)localObject);
      MMHandlerThread.postToMainThreadDelayed((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.f
 * JD-Core Version:    0.7.0.1
 */