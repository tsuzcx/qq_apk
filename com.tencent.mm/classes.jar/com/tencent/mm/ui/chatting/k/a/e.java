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
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a.1;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.k.d;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public class e
  extends a
{
  private volatile long Hwp = 0L;
  private int aeKa = 0;
  private volatile long aeKk = 0L;
  private volatile long aeKl = 0L;
  
  public e(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.e parame)
  {
    super(parama, parame);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(36674);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(36674);
    return i;
  }
  
  protected final g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36672);
    Object localObject = null;
    bh.bCz();
    int j = com.tencent.mm.model.c.bzD().aLW(iNh().getTalkerUserName());
    switch (2.aeJk[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.aeKa = j;
      AppMethodBeat.o(36672);
      return parama;
      parama = new com.tencent.mm.ui.chatting.k.c(iNh().getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.k.c(iNh().getTalkerUserName(), jxa() + 48, j);
      continue;
      i = j - this.aeKa;
      parama = iNh().getTalkerUserName();
      k = jxa();
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.k.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(36672);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label627;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
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
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
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
        label426:
        bh.bCz();
        i = com.tencent.mm.model.c.bzD().I(parama, this.aeKk, this.aeKl);
        Log.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label748;
        }
        Log.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.aeKk), Integer.valueOf(0) });
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
      break label426;
      bh.bCz();
      i = com.tencent.mm.model.c.bzD().I(parama, this.aeKk, l);
      continue;
      label627:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        Log.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.k.c(iNh().getTalkerUserName(), jxa(), j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.k.c(iNh().getTalkerUserName(), k, j);
      break;
      label748:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    AppMethodBeat.i(36673);
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
    switch (2.aeJk[locala.ordinal()])
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
          Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.aeKk), Long.valueOf(this.aeKl), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = iNh().getTalkerUserName();
          long l = ((n)h.ax(n.class)).bAd().aLt(paramd);
          bh.bCz();
          i = com.tencent.mm.model.c.bzD().I(paramd, 0L, l);
          Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
          if (m - i > k) {
            break;
          }
          bool = true;
          label314:
          paramMMChattingListView.setIsTopShowAll(bool);
          paramMMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(36673);
        return;
        paramMMChattingListView.LB(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        q.a(paramMMChattingListView.getListView(), j - n + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((m)iNh().cm(m.class)).aBX(n);
          j = i;
          continue;
          paramMMChattingListView.LC(false);
          q.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - jxd() - paramMMChattingListView.getBottomHeight(), false, false);
          j = i;
          continue;
          iNh().Mf(false);
          paramd = iNh();
          paramd.aezP.getListView().postDelayed(new a.1(paramd), 100L);
          j = i;
        }
      }
    }
    if (localBundle == null)
    {
      j = -1;
      label512:
      if (j == -1) {
        break label585;
      }
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.lNX - j));
      paramd.selection = i;
    }
    label585:
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36670);
          Object localObject = (m)e.this.iNh().cm(m.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            boolean bool1 = localBundle.getBoolean("IS_HIGHLIGHT_ITEM", false);
            boolean bool2 = localBundle.getBoolean("IS_IDLE_VISBLE", false);
            int i = localBundle.getInt("SELECTION_TOP_OFFSET", 0);
            boolean bool3 = localBundle.getBoolean("IS_SMOOTH_SCROLL", false);
            e.this.iNh().aezR = i;
            e.this.b(i, bool2, i, bool3);
            if ((bool1) && (i >= 0)) {
              e.this.a(paramMMChattingListView, i, bool2, i, bool3);
            }
            AppMethodBeat.o(36670);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((m)localObject).aBW(i);
            localObject = e.this.iNh();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.d.a)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(36670);
        }
      });
      j = i;
      break;
      j = localBundle.getInt("MSG_POSITION", -1);
      break label512;
      bool = false;
      break label314;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.e
 * JD-Core Version:    0.7.0.1
 */