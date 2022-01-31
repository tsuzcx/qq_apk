package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class e
  extends a
{
  private String talker;
  private volatile long zQA;
  private volatile long zQB;
  private volatile long zQC;
  private boolean zQF;
  private Runnable zQG;
  
  public e(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(32736);
    this.zQA = 0L;
    this.zQB = 0L;
    this.zQC = 0L;
    this.talker = this.caz.getTalkerUserName();
    ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(32736);
  }
  
  private int dLl()
  {
    AppMethodBeat.i(32739);
    int i = ((r)this.caz.ay(r.class)).dIG();
    AppMethodBeat.o(32739);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.l.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(32737);
    int i;
    int j;
    long l;
    switch (e.2.zPK[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.zQA), Long.valueOf(this.zQB), Long.valueOf(this.zQC), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.l.d(this.caz.getTalkerUserName(), this.zQA, this.zQB);
        AppMethodBeat.o(32737);
        return parama;
        if (paramBundle == null)
        {
          ab.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          this.zQF = paramBundle.getBoolean("IS_LOAD_ALL", false);
          aw.aaz();
          paramBundle = c.YC().kB(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          ab.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.zQA) || (l > this.zQB))
      {
        this.zQA = l;
        this.zQC = ((j)g.E(j.class)).bPQ().TE(this.talker);
        if (this.zQF)
        {
          this.zQB = this.zQC;
          label312:
          aw.aaz();
          i = c.YC().z(this.talker, this.zQA, this.zQB);
          ab.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label818;
          }
          ab.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.zQA), Integer.valueOf(0) });
          aw.aaz();
          this.zQA = c.YC().g(this.talker, this.zQA, 48);
          aw.aaz();
          i = c.YC().z(this.talker, this.zQA, l);
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
      aw.aaz();
      this.zQB = c.YC().h(this.talker, l, 48);
      break label312;
      aw.aaz();
      i = c.YC().z(this.talker, this.zQA, l);
      continue;
      aw.aaz();
      l = c.YC().g(this.talker, this.zQA, 48);
      aw.aaz();
      j = Math.max(0, c.YC().z(this.talker, l, this.zQA) - 1);
      this.zQA = l;
      i = 0;
      break;
      aw.aaz();
      l = c.YC().h(this.talker, this.zQB, 48);
      aw.aaz();
      i = Math.max(0, c.YC().z(this.talker, this.zQB, l) - 1);
      this.zQB = l;
      j = 0;
      break;
      this.zQC = ((j)g.E(j.class)).bPQ().TE(this.talker);
      aw.aaz();
      i = Math.max(0, c.YC().z(this.talker, this.zQB, this.zQC) - 1);
      if ((this.zQF) || (i <= 480)) {}
      for (this.zQB = this.zQC;; this.zQB = this.zQC)
      {
        do
        {
          j = 0;
          break;
          paramBundle = ((j)g.E(j.class)).bPQ().Tm(this.talker);
        } while ((paramBundle.field_isSend != 1) || (this.zQC == paramBundle.field_createTime));
        this.zQC = paramBundle.field_createTime;
        aw.aaz();
        this.zQA = c.YC().g(this.talker, this.zQA, 48);
      }
      label818:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(32738);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.zOE;
    int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (e.2.zPK[localObject.ordinal()])
    {
    default: 
      if (this.caz.getLastVisiblePosition() == paramd.zOG - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((j)g.E(j.class)).bPQ().TD(this.talker);
      ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.zQA) });
      if (this.zQA <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.zQB < this.zQC) {
          break label422;
        }
      }
      break;
    }
    label422:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMMChattingListView.setIsBottomShowAll(bool1);
      AppMethodBeat.o(32738);
      return;
      paramMMChattingListView.qD(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      k.a(paramMMChattingListView.getListView(), i - j + 1, dLl() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).PB(i);
      break;
      paramMMChattingListView.qE(false);
      k.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - dLl(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = this.caz.zJz.getBooleanExtra("need_hight_item", false).booleanValue();
      Qp(i);
      if (!bool1) {
        break;
      }
      this.caz.zJz.getLongExtra("msg_local_id", -1L);
      ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      al.ae(this.zQG);
      localObject = new e.1(this, i, paramMMChattingListView);
      this.zQG = ((Runnable)localObject);
      al.p((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.e
 * JD-Core Version:    0.7.0.1
 */