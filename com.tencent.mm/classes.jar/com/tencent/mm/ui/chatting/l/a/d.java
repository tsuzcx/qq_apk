package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class d
  extends a
{
  private volatile long zQA = 0L;
  private volatile long zQB = 0L;
  private volatile long zQC = 0L;
  private int zQq = 0;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.e parame)
  {
    super(parama, parame);
  }
  
  private int dLl()
  {
    AppMethodBeat.i(32733);
    int i = ((r)this.caz.ay(r.class)).dIG();
    AppMethodBeat.o(32733);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.l.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(32731);
    Object localObject = null;
    aw.aaz();
    int j = com.tencent.mm.model.c.YC().TA(this.caz.getTalkerUserName());
    switch (d.2.zPK[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.zQq = j;
      AppMethodBeat.o(32731);
      return parama;
      parama = new com.tencent.mm.ui.chatting.l.c(this.caz.getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.l.c(this.caz.getTalkerUserName(), this.zQk + 48, j);
      continue;
      i = j - this.zQq;
      parama = this.caz.getTalkerUserName();
      k = this.zQk;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.l.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(32731);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label625;
      }
      ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new com.tencent.mm.ui.chatting.l.d(this.caz.getTalkerUserName(), this.zQA, this.zQB);
      }
      else
      {
        parama = this.caz.getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        aw.aaz();
        paramBundle = com.tencent.mm.model.c.YC().kB(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new com.tencent.mm.ui.chatting.l.d(this.caz.getTalkerUserName(), this.zQA, this.zQB);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.zQA) || (l > this.zQB))
    {
      this.zQA = l;
      this.zQC = ((j)g.E(j.class)).bPQ().TE(parama);
      if (bool)
      {
        this.zQB = this.zQC;
        label424:
        aw.aaz();
        i = com.tencent.mm.model.c.YC().z(parama, this.zQA, this.zQB);
        ab.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label746;
        }
        ab.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.zQA), Integer.valueOf(0) });
        aw.aaz();
        this.zQA = com.tencent.mm.model.c.YC().g(parama, this.zQA, 48);
        aw.aaz();
        i = com.tencent.mm.model.c.YC().z(parama, this.zQA, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new com.tencent.mm.ui.chatting.l.d(this.caz.getTalkerUserName(), this.zQA, this.zQB);
      break;
      aw.aaz();
      this.zQB = com.tencent.mm.model.c.YC().h(parama, l, 48);
      break label424;
      aw.aaz();
      i = com.tencent.mm.model.c.YC().z(parama, this.zQA, l);
      continue;
      label625:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        ab.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.l.c(this.caz.getTalkerUserName(), this.zQk, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.l.c(this.caz.getTalkerUserName(), k, j);
      break;
      label746:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    AppMethodBeat.i(32732);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.zOE;
    Object localObject = paramd.zOH;
    int j = paramd.zOF.size();
    int k = paramd.eke;
    int i = paramd.selection;
    Bundle localBundle = paramd.zOD;
    bi localbi = (bi)((SparseArray)localObject).get(0);
    localObject = (bi)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localbi != null) {
      this.zQA = localbi.field_createTime;
    }
    if (localObject != null) {
      this.zQB = ((dd)localObject).field_createTime;
    }
    switch (d.2.zPK[locala.ordinal()])
    {
    case 3: 
    default: 
      if (locala != d.a.zOz)
      {
        ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.zQA), Long.valueOf(this.zQB), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
        paramd = this.caz.getTalkerUserName();
        long l = ((j)g.E(j.class)).Zc().Tb(paramd);
        aw.aaz();
        i = com.tencent.mm.model.c.YC().z(paramd, 0L, l);
        ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
        if (k - i > j) {
          break label504;
        }
      }
      break;
    }
    label504:
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      AppMethodBeat.o(32732);
      return;
      paramMMChattingListView.qD(false);
      int m = paramMMChattingListView.getCurCount();
      int n = paramMMChattingListView.getPreCount();
      k.a(paramMMChattingListView.getListView(), m - n + 1, dLl() + paramMMChattingListView.getTopHeight(), false);
      m = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (m <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).PB(m);
      break;
      paramMMChattingListView.qE(false);
      k.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - dLl(), false);
      break;
      this.caz.qT(false);
      break;
      i = localBundle.getInt("MSG_POSITION");
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.eke - i));
      paramd.selection = i;
      paramMMChattingListView.getListView().post(new d.1(this, localBundle, i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.d
 * JD-Core Version:    0.7.0.1
 */