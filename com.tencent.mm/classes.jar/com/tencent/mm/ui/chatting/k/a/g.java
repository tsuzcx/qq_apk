package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.k.d;
import com.tencent.mm.ui.chatting.k.e.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class g
  extends a
{
  private volatile long Hwp;
  private int aeKa;
  private volatile long aeKk;
  private volatile long aeKl;
  private e.a aeKp;
  
  public g(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(254096);
    this.aeKa = 0;
    this.aeKk = 0L;
    this.aeKl = 0L;
    this.Hwp = 0L;
    this.aeKp = new e.a()
    {
      public final boolean c(cc paramAnonymouscc1, cc paramAnonymouscc2)
      {
        AppMethodBeat.i(254113);
        if ((g.this.iNh() != null) && (g.this.iNh().cm(com.tencent.mm.ui.chatting.component.api.q.class) != null))
        {
          boolean bool = ((com.tencent.mm.ui.chatting.component.api.q)g.this.iNh().cm(com.tencent.mm.ui.chatting.component.api.q.class)).a(paramAnonymouscc1, paramAnonymouscc2);
          AppMethodBeat.o(254113);
          return bool;
        }
        AppMethodBeat.o(254113);
        return false;
      }
    };
    AppMethodBeat.o(254096);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(254102);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(254102);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.k.g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(254111);
    Object localObject = null;
    bh.bCz();
    int j = com.tencent.mm.model.c.bzD().aLW(iNh().getTalkerUserName());
    switch (3.aeJk[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    label108:
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.aeKa = j;
      AppMethodBeat.o(254111);
      return parama;
      for (parama = new com.tencent.mm.ui.chatting.k.e(iNh().getTalkerUserName(), 16, j, parama, this.aeKp);; parama = new com.tencent.mm.ui.chatting.k.e(iNh().getTalkerUserName(), jxa() + 48, j, parama, this.aeKp)) {
        break;
      }
      i = j - this.aeKa;
      paramBundle = iNh().getTalkerUserName();
      k = jxa();
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.k.e(paramBundle, i + k, j, parama, this.aeKp);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(254111);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label642;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new d(iNh().getTalkerUserName(), this.aeKk, this.aeKl);
      }
      else
      {
        parama = iNh().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        bh.bCz();
        paramBundle = com.tencent.mm.model.c.bzD().sl(l);
        if ((paramBundle != null) && (paramBundle.field_msgId == l)) {
          break;
        }
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new d(iNh().getTalkerUserName(), this.aeKk, this.aeKl);
      }
    }
    long l = paramBundle.getCreateTime();
    if ((l < this.aeKk) || (l > this.aeKl))
    {
      this.aeKk = l;
      this.Hwp = ((n)h.ax(n.class)).gaZ().Hq(parama);
      if (bool)
      {
        this.aeKl = this.Hwp;
        label441:
        bh.bCz();
        i = com.tencent.mm.model.c.bzD().I(parama, this.aeKk, this.aeKl);
        Log.v("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label777;
        }
        Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.aeKk), Integer.valueOf(0) });
        bh.bCz();
        this.aeKk = com.tencent.mm.model.c.bzD().l(parama, this.aeKk, 48);
        bh.bCz();
        i = com.tencent.mm.model.c.bzD().I(parama, this.aeKk, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new d(iNh().getTalkerUserName(), this.aeKk, this.aeKl);
      break;
      bh.bCz();
      this.aeKl = com.tencent.mm.model.c.bzD().m(parama, l, 48);
      break label441;
      bh.bCz();
      i = com.tencent.mm.model.c.bzD().I(parama, this.aeKk, l);
      continue;
      label642:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        Log.e("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.k.e(iNh().getTalkerUserName(), jxa(), j, d.a.aeHU, this.aeKp);
        break label108;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.k.e(iNh().getTalkerUserName(), k, j, d.a.aeHU, this.aeKp);
      break label108;
      label777:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    AppMethodBeat.i(254118);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.aeHY;
    Object localObject = paramd.aeIb;
    int k = paramd.aeHZ.size();
    int m = paramd.lNX;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.aeHX;
    cc localcc = (cc)((SparseArray)localObject).get(0);
    localObject = (cc)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localcc != null) {
      this.aeKk = localcc.getCreateTime();
    }
    if (localObject != null) {
      this.aeKl = ((cc)localObject).getCreateTime();
    }
    int j = i;
    boolean bool;
    switch (3.aeJk[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.aeHT)
        {
          Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.aeKk), Long.valueOf(this.aeKl), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = iNh().getTalkerUserName();
          long l = ((n)h.ax(n.class)).bAd().aLt(paramd);
          bh.bCz();
          i = com.tencent.mm.model.c.bzD().I(paramd, 0L, l);
          Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
          if (m - i > k) {
            break;
          }
          bool = true;
          label314:
          paramMMChattingListView.setIsTopShowAll(bool);
          paramMMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(254118);
        return;
        paramMMChattingListView.LB(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        com.tencent.mm.pluginsdk.ui.tools.q.a(paramMMChattingListView.getListView(), j - n + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((m)iNh().cm(m.class)).aBX(n);
          j = i;
          continue;
          paramMMChattingListView.LC(false);
          com.tencent.mm.pluginsdk.ui.tools.q.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - jxd() - paramMMChattingListView.getBottomHeight(), false, false);
          j = i;
          continue;
          iNh().Mf(false);
          j = i;
        }
      }
    }
    if (localBundle == null)
    {
      j = -1;
      label483:
      if (j == -1) {
        break label556;
      }
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.lNX - j));
      paramd.selection = i;
    }
    label556:
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254120);
          Object localObject = (m)g.this.iNh().cm(m.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            boolean bool1 = localBundle.getBoolean("IS_IDLE_VISBLE", false);
            int i = localBundle.getInt("SELECTION_TOP_OFFSET", 0);
            boolean bool2 = localBundle.getBoolean("IS_SMOOTH_SCROLL", false);
            g.this.iNh().aezR = i;
            g.this.b(i, bool1, i, bool2);
            if ((i >= 0) && (g.this.iNh().aezO.getBooleanExtra("need_hight_item", false).booleanValue()))
            {
              g.this.iNh().aezO.getLongExtra("msg_local_id", -1L);
              g.this.a(paramMMChattingListView, i, false, i, false);
            }
            AppMethodBeat.o(254120);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((m)localObject).aBW(i);
            localObject = g.this.iNh();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/chatting/source/presenter/ChattingServiceNotifyDataPresenter$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.d.a)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingServiceNotifyDataPresenter$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(254120);
        }
      });
      j = i;
      break;
      j = localBundle.getInt("MSG_POSITION", -1);
      break label483;
      bool = false;
      break label314;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.g
 * JD-Core Version:    0.7.0.1
 */