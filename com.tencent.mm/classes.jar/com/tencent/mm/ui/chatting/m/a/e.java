package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class e
  extends a
{
  private volatile long GGY;
  private volatile long GGZ;
  private boolean GHc;
  private Runnable GHd;
  private volatile long rsj;
  private String talker;
  
  public e(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.g.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.GGY = 0L;
    this.GGZ = 0L;
    this.rsj = 0L;
    this.talker = faA().getTalkerUserName();
    ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int faB()
  {
    AppMethodBeat.i(36680);
    int i = ((w)faA().be(w.class)).eYb();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.m.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.GGj[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.GGY), Long.valueOf(this.GGZ), Long.valueOf(this.rsj), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.m.d(faA().getTalkerUserName(), this.GGY, this.GGZ);
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
          this.GHc = paramBundle.getBoolean("IS_LOAD_ALL", false);
          az.arV();
          paramBundle = c.apO().rm(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          ad.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.GGY) || (l > this.GGZ))
      {
        this.GGY = l;
        this.rsj = ((k)g.ab(k.class)).cOI().agI(this.talker);
        if (this.GHc)
        {
          this.GGZ = this.rsj;
          label311:
          az.arV();
          i = c.apO().E(this.talker, this.GGY, this.GGZ);
          ad.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label817;
          }
          ad.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.GGY), Integer.valueOf(0) });
          az.arV();
          this.GGY = c.apO().g(this.talker, this.GGY, 48);
          az.arV();
          i = c.apO().E(this.talker, this.GGY, l);
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
      az.arV();
      this.GGZ = c.apO().h(this.talker, l, 48);
      break label311;
      az.arV();
      i = c.apO().E(this.talker, this.GGY, l);
      continue;
      az.arV();
      l = c.apO().g(this.talker, this.GGY, 48);
      az.arV();
      j = Math.max(0, c.apO().E(this.talker, l, this.GGY) - 1);
      this.GGY = l;
      i = 0;
      break;
      az.arV();
      l = c.apO().h(this.talker, this.GGZ, 48);
      az.arV();
      i = Math.max(0, c.apO().E(this.talker, this.GGZ, l) - 1);
      this.GGZ = l;
      j = 0;
      break;
      this.rsj = ((k)g.ab(k.class)).cOI().agI(this.talker);
      az.arV();
      i = Math.max(0, c.apO().E(this.talker, this.GGZ, this.rsj) - 1);
      if ((this.GHc) || (i <= 480)) {}
      for (this.GGZ = this.rsj;; this.GGZ = this.rsj)
      {
        do
        {
          j = 0;
          break;
          paramBundle = ((k)g.ab(k.class)).cOI().agq(this.talker);
        } while ((paramBundle.field_isSend != 1) || (this.rsj == paramBundle.field_createTime));
        this.rsj = paramBundle.field_createTime;
        az.arV();
        this.GGY = c.apO().g(this.talker, this.GGY, 48);
      }
      label817:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<bl> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.GFc;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.GGj[localObject.ordinal()])
    {
    default: 
      if (faA().getLastVisiblePosition() == paramd.GFe - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((k)g.ab(k.class)).cOI().agH(this.talker);
      ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.GGY) });
      if (this.GGY <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.GGZ < this.rsj) {
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
      paramMMChattingListView.vL(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), i - j + 1, faB() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((i)faA().be(i.class)).YG(i);
      break;
      paramMMChattingListView.vM(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - faB() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = faA().GzJ.getBooleanExtra("need_hight_item", false).booleanValue();
      Zy(i);
      if (!bool1) {
        break;
      }
      faA().GzJ.getLongExtra("msg_local_id", -1L);
      ad.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      aq.az(this.GHd);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - e.this.faA().getFirstVisiblePosition());
          e.this.Zy(i);
          paramMMChattingListView.setHighLightChild(i);
          az.arV();
          c.afk().set(ae.a.FjT, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.GHd = ((Runnable)localObject);
      aq.n((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.e
 * JD-Core Version:    0.7.0.1
 */