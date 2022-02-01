package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f
  extends a
{
  private volatile long JXh;
  private volatile long JXi;
  private boolean JXl;
  private Runnable JXm;
  private String talker;
  private volatile long txE;
  
  public f(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.JXh = 0L;
    this.JXi = 0L;
    this.txE = 0L;
    this.talker = fep().getTalkerUserName();
    ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int fHe()
  {
    AppMethodBeat.i(36680);
    int i = ((y)fep().bh(y.class)).fEk();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.JWs[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.JXh), Long.valueOf(this.JXi), Long.valueOf(this.txE), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.n.d(fep().getTalkerUserName(), this.JXh, this.JXi);
        AppMethodBeat.o(36678);
        return parama;
        if (paramBundle == null)
        {
          ad.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          this.JXl = paramBundle.getBoolean("IS_LOAD_ALL", false);
          ba.aBQ();
          paramBundle = c.azs().xY(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          ad.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.JXh) || (l > this.JXi))
      {
        this.JXh = l;
        this.txE = ((l)g.ab(l.class)).dlK().aqq(this.talker);
        if (this.JXl)
        {
          this.JXi = this.txE;
          label311:
          ba.aBQ();
          i = c.azs().D(this.talker, this.JXh, this.JXi);
          ad.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label799;
          }
          ad.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.JXh), Integer.valueOf(0) });
          ba.aBQ();
          this.JXh = c.azs().i(this.talker, this.JXh, 48);
          ba.aBQ();
          i = c.azs().D(this.talker, this.JXh, l);
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
      ba.aBQ();
      this.JXi = c.azs().j(this.talker, l, 48);
      break label311;
      ba.aBQ();
      i = c.azs().D(this.talker, this.JXh, l);
      continue;
      ba.aBQ();
      l = c.azs().i(this.talker, this.JXh, 48);
      ba.aBQ();
      j = Math.max(0, c.azs().D(this.talker, l, this.JXh) - 1);
      this.JXh = l;
      i = 0;
      break;
      ba.aBQ();
      l = c.azs().j(this.talker, this.JXi, 48);
      ba.aBQ();
      i = Math.max(0, c.azs().D(this.talker, this.JXi, l) - 1);
      this.JXi = l;
      j = 0;
      break;
      paramBundle = ((l)g.ab(l.class)).dlK().apX(this.talker);
      this.txE = paramBundle.field_createTime;
      ba.aBQ();
      i = Math.max(0, c.azs().D(this.talker, this.JXi, this.txE) - 1);
      if ((this.JXl) || (i <= 480)) {}
      for (this.JXi = this.txE;; this.JXi = this.txE)
      {
        do
        {
          j = 0;
          break;
        } while ((paramBundle.field_isSend != 1) || (this.txE == paramBundle.field_createTime));
        this.txE = paramBundle.field_createTime;
        ba.aBQ();
        this.JXh = c.azs().i(this.talker, this.JXh, 48);
      }
      label799:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<bu> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.JVl;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.JWs[localObject.ordinal()])
    {
    default: 
      if (fep().getLastVisiblePosition() == paramd.JVn - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((l)g.ab(l.class)).dlK().aqp(this.talker);
      ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.JXh) });
      if (this.JXh <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.JXi < this.txE) {
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
      paramMMChattingListView.xA(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), i - j + 1, fHe() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((k)fep().bh(k.class)).adc(i);
      break;
      paramMMChattingListView.xB(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fHe() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = fep().JOR.getBooleanExtra("need_hight_item", false).booleanValue();
      aee(i);
      if (!bool1) {
        break;
      }
      fep().JOR.getLongExtra("msg_local_id", -1L);
      ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      aq.aA(this.JXm);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - f.this.fep().getFirstVisiblePosition());
          f.this.aee(i);
          paramMMChattingListView.setHighLightChild(i);
          ba.aBQ();
          c.ajl().set(al.a.Iua, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.JXm = ((Runnable)localObject);
      aq.o((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.f
 * JD-Core Version:    0.7.0.1
 */