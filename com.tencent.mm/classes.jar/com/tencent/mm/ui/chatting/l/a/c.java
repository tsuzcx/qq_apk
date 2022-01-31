package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.l.b;
import com.tencent.mm.ui.chatting.l.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class c
  extends a
{
  private boolean zQr = false;
  private boolean zQs = false;
  
  public c(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    super(parama, paramd);
  }
  
  private int dLl()
  {
    AppMethodBeat.i(32728);
    int i = ((r)this.caz.ay(r.class)).dIG();
    AppMethodBeat.o(32728);
    return i;
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(32726);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new b(this.caz.getTalkerUserName(), parama, paramBundle, this.zQl, this.zPU, this.zPV, this.zQk, paramd, bool);
      AppMethodBeat.o(32726);
      return parama;
    }
  }
  
  public final void a(d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(32725);
    Bundle localBundle1;
    Bundle localBundle2;
    if (parama == d.a.zOy)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.zQr)
      {
        ab.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
        localBundle1.putBoolean("has_position_tongue", true);
        localBundle2 = localBundle1;
      }
    }
    do
    {
      for (;;)
      {
        super.a(parama, paramBoolean, localBundle2);
        AppMethodBeat.o(32725);
        return;
        localBundle2 = localBundle1;
        if (this.zQs)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != d.a.zOA);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label126:
      this.zQr = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label175;
      }
    }
    label175:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zQs = bool1;
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label126;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    AppMethodBeat.i(32727);
    int j = paramd.zOF.size();
    int k = paramd.eke;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.zOH;
    d.a locala = paramd.zOE;
    bi localbi1 = (bi)localSparseArray.get(0);
    bi localbi2 = (bi)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.zOE != d.a.zOy) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      ab.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { this.caz.getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (c.1.zPK[paramd.zOE.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      label614:
      do
      {
        for (;;)
        {
          paramMMChattingListView.setIsTopShowAll(true);
          paramMMChattingListView.setIsBottomShowAll(true);
          l1 = 0L;
          if (localbi1 != null) {
            l1 = localbi1.field_createTime;
          }
          long l2 = 0L;
          if (localbi2 != null) {
            l2 = localbi2.field_createTime;
          }
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { this.caz.getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.RO().ac(new c.a(this, paramMMChattingListView, this.caz.getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(32727);
          return;
          paramMMChattingListView.qE(false);
          this.caz.qT(true);
          continue;
          if ((paramd.zOD != null) && (paramd.zOD.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.qE(false);
            this.caz.qT(true);
            this.zQr = false;
          }
          this.zQs = false;
        }
        if ((paramd.zOD != null) && (paramd.zOD.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          this.caz.qT(true);
          ((s)this.caz.ay(s.class)).dIJ();
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.qE(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - dLl() - paramMMChattingListView.getBottomHeight();
          this.caz.hF(i, n);
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.zOD != null) && (paramd.zOD.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label614;
          }
          Qp(paramd.selection);
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.zOD == null);
      paramMMChattingListView.a(false, null);
      l1 = paramd.zOD.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label648:
      if (i >= 0)
      {
        bi localbi3 = (bi)localSparseArray.get(i);
        if ((localbi3 == null) || (localbi3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((h)this.caz.ay(h.class)).PA(paramd.selection);
      Qp(paramd.selection);
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label648;
      paramMMChattingListView.qD(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      this.caz.hF(i + 1, dLl() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((h)this.caz.ay(h.class)).PB(n);
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.c
 * JD-Core Version:    0.7.0.1
 */