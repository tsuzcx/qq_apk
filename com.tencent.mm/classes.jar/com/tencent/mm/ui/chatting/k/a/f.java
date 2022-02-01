package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f
  extends a
{
  private volatile long Hwp;
  private volatile long aeKk;
  private volatile long aeKl;
  private boolean aeKo;
  private String talker;
  
  public f(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.aeKk = 0L;
    this.aeKl = 0L;
    this.Hwp = 0L;
    this.talker = iNh().getTalkerUserName();
    Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(36680);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (1.aeJk[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.aeKk), Long.valueOf(this.aeKl), Long.valueOf(this.Hwp), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.k.d(iNh().getTalkerUserName(), this.aeKk, this.aeKl);
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
          this.aeKo = paramBundle.getBoolean("IS_LOAD_ALL", false);
          bh.bCz();
          paramBundle = c.bzD().sl(l);
          if ((paramBundle != null) && (paramBundle.field_msgId == l)) {
            break;
          }
          Log.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.getCreateTime();
      if ((l < this.aeKk) || (l > this.aeKl))
      {
        this.aeKk = l;
        this.Hwp = ((n)h.ax(n.class)).gaZ().Hq(this.talker);
        if (this.aeKo)
        {
          this.aeKl = this.Hwp;
          label315:
          bh.bCz();
          i = c.bzD().I(this.talker, this.aeKk, this.aeKl);
          Log.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label803;
          }
          Log.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.aeKk), Integer.valueOf(0) });
          bh.bCz();
          this.aeKk = c.bzD().l(this.talker, this.aeKk, 48);
          bh.bCz();
          i = c.bzD().I(this.talker, this.aeKk, l);
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
      bh.bCz();
      this.aeKl = c.bzD().m(this.talker, l, 48);
      break label315;
      bh.bCz();
      i = c.bzD().I(this.talker, this.aeKk, l);
      continue;
      bh.bCz();
      l = c.bzD().l(this.talker, this.aeKk, 48);
      bh.bCz();
      j = Math.max(0, c.bzD().I(this.talker, l, this.aeKk) - 1);
      this.aeKk = l;
      i = 0;
      break;
      bh.bCz();
      l = c.bzD().m(this.talker, this.aeKl, 48);
      bh.bCz();
      i = Math.max(0, c.bzD().I(this.talker, this.aeKl, l) - 1);
      this.aeKl = l;
      j = 0;
      break;
      paramBundle = ((n)h.ax(n.class)).gaZ().aLG(this.talker);
      this.Hwp = paramBundle.getCreateTime();
      bh.bCz();
      i = Math.max(0, c.bzD().I(this.talker, this.aeKl, this.Hwp) - 1);
      if ((this.aeKo) || (i <= 480)) {}
      for (this.aeKl = this.Hwp;; this.aeKl = this.Hwp)
      {
        do
        {
          j = 0;
          break;
        } while ((paramBundle.field_isSend != 1) || (this.Hwp == paramBundle.getCreateTime()));
        this.Hwp = paramBundle.getCreateTime();
        bh.bCz();
        this.aeKk = c.bzD().l(this.talker, this.aeKk, 48);
      }
      label803:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.aeHY;
    int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (1.aeJk[locala.ordinal()])
    {
    default: 
      if (iNh().getLastVisiblePosition() == paramd.aeIa - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((n)h.ax(n.class)).gaZ().aLZ(this.talker);
      Log.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.aeKk) });
      if (this.aeKk <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.aeKl < this.Hwp) {
          break label406;
        }
      }
      break;
    }
    label406:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMMChattingListView.setIsBottomShowAll(bool1);
      AppMethodBeat.o(36679);
      return;
      paramMMChattingListView.LB(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      q.a(paramMMChattingListView.getListView(), i - j + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((m)iNh().cm(m.class)).aBX(i);
      break;
      paramMMChattingListView.LC(false);
      q.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - jxd() - paramMMChattingListView.getBottomHeight(), false, false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = iNh().aezO.getBooleanExtra("need_hight_item", false).booleanValue();
      j = this.hlc.aezO.getIntExtra("SELECTION_TOP_OFFSET", 0);
      b(i, false, j, false);
      if (!bool1) {
        break;
      }
      iNh().aezO.getLongExtra("msg_local_id", -1L);
      a(paramMMChattingListView, i, false, j, false);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.f
 * JD-Core Version:    0.7.0.1
 */