package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class e
  extends a
{
  private volatile long IgU;
  private volatile long IgV;
  private boolean IgY;
  private Runnable IgZ;
  private volatile long sBd;
  private String talker;
  
  public e(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.g.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.IgU = 0L;
    this.IgV = 0L;
    this.sBd = 0L;
    this.talker = fqq().getTalkerUserName();
    ac.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int fqr()
  {
    AppMethodBeat.i(36680);
    int i = ((w)fqq().bf(w.class)).fnN();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.m.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.Igf[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        ac.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.IgU), Long.valueOf(this.IgV), Long.valueOf(this.sBd), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.m.d(fqq().getTalkerUserName(), this.IgU, this.IgV);
        AppMethodBeat.o(36678);
        return parama;
        if (paramBundle == null)
        {
          ac.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          this.IgY = paramBundle.getBoolean("IS_LOAD_ALL", false);
          az.ayM();
          paramBundle = c.awD().vP(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          ac.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.IgU) || (l > this.IgV))
      {
        this.IgU = l;
        this.sBd = ((k)g.ab(k.class)).dcr().alC(this.talker);
        if (this.IgY)
        {
          this.IgV = this.sBd;
          label311:
          az.ayM();
          i = c.awD().C(this.talker, this.IgU, this.IgV);
          ac.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label817;
          }
          ac.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.IgU), Integer.valueOf(0) });
          az.ayM();
          this.IgU = c.awD().g(this.talker, this.IgU, 48);
          az.ayM();
          i = c.awD().C(this.talker, this.IgU, l);
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
      az.ayM();
      this.IgV = c.awD().h(this.talker, l, 48);
      break label311;
      az.ayM();
      i = c.awD().C(this.talker, this.IgU, l);
      continue;
      az.ayM();
      l = c.awD().g(this.talker, this.IgU, 48);
      az.ayM();
      j = Math.max(0, c.awD().C(this.talker, l, this.IgU) - 1);
      this.IgU = l;
      i = 0;
      break;
      az.ayM();
      l = c.awD().h(this.talker, this.IgV, 48);
      az.ayM();
      i = Math.max(0, c.awD().C(this.talker, this.IgV, l) - 1);
      this.IgV = l;
      j = 0;
      break;
      this.sBd = ((k)g.ab(k.class)).dcr().alC(this.talker);
      az.ayM();
      i = Math.max(0, c.awD().C(this.talker, this.IgV, this.sBd) - 1);
      if ((this.IgY) || (i <= 480)) {}
      for (this.IgV = this.sBd;; this.IgV = this.sBd)
      {
        do
        {
          j = 0;
          break;
          paramBundle = ((k)g.ab(k.class)).dcr().alk(this.talker);
        } while ((paramBundle.field_isSend != 1) || (this.sBd == paramBundle.field_createTime));
        this.sBd = paramBundle.field_createTime;
        az.ayM();
        this.IgU = c.awD().g(this.talker, this.IgU, 48);
      }
      label817:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<bo> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.IeY;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.Igf[localObject.ordinal()])
    {
    default: 
      if (fqq().getLastVisiblePosition() == paramd.Ifa - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((k)g.ab(k.class)).dcr().alB(this.talker);
      ac.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.IgU) });
      if (this.IgU <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.IgV < this.sBd) {
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
      paramMMChattingListView.wP(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), i - j + 1, fqr() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((i)fqq().bf(i.class)).aaR(i);
      break;
      paramMMChattingListView.wQ(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fqr() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = fqq().HZF.getBooleanExtra("need_hight_item", false).booleanValue();
      abK(i);
      if (!bool1) {
        break;
      }
      fqq().HZF.getLongExtra("msg_local_id", -1L);
      ac.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      ap.aB(this.IgZ);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - e.this.fqq().getFirstVisiblePosition());
          e.this.abK(i);
          paramMMChattingListView.setHighLightChild(i);
          az.ayM();
          c.agA().set(ah.a.GHI, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.IgZ = ((Runnable)localObject);
      ap.n((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.e
 * JD-Core Version:    0.7.0.1
 */