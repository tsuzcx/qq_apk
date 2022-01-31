package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class d
  extends a
{
  private volatile long vAd = 0L;
  private volatile long vAe = 0L;
  private volatile long vAf = 0L;
  private int vzT = 0;
  
  public d(com.tencent.mm.ui.chatting.c.a parama, com.tencent.mm.ui.chatting.e.e parame)
  {
    super(parama, parame);
  }
  
  private int cGY()
  {
    return ((q)this.byx.ac(q.class)).cEP();
  }
  
  protected final com.tencent.mm.ui.chatting.k.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    Object localObject = null;
    au.Hx();
    int j = com.tencent.mm.model.c.Fy().HP(this.byx.getTalkerUserName());
    switch (2.vzn[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.vzT = j;
      return parama;
      parama = new com.tencent.mm.ui.chatting.k.c(this.byx.getTalkerUserName(), 48, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.k.c(this.byx.getTalkerUserName(), this.vzN + 48, j);
      continue;
      i = j - this.vzT;
      parama = this.byx.getTalkerUserName();
      k = this.vzN;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.k.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        y.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label609;
      }
      y.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        y.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new com.tencent.mm.ui.chatting.k.d(this.byx.getTalkerUserName(), this.vAd, this.vAe);
      }
      else
      {
        parama = this.byx.getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        au.Hx();
        paramBundle = com.tencent.mm.model.c.Fy().fd(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        y.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new com.tencent.mm.ui.chatting.k.d(this.byx.getTalkerUserName(), this.vAd, this.vAe);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.vAd) || (l > this.vAe))
    {
      this.vAd = l;
      this.vAf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HV(parama);
      if (bool)
      {
        this.vAe = this.vAf;
        label408:
        au.Hx();
        i = com.tencent.mm.model.c.Fy().r(parama, this.vAd, this.vAe);
        y.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label730;
        }
        y.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.vAd), Integer.valueOf(0) });
        au.Hx();
        this.vAd = com.tencent.mm.model.c.Fy().e(parama, this.vAd, 48);
        au.Hx();
        i = com.tencent.mm.model.c.Fy().r(parama, this.vAd, l);
      }
    }
    for (;;)
    {
      paramd.nul = i;
      parama = new com.tencent.mm.ui.chatting.k.d(this.byx.getTalkerUserName(), this.vAd, this.vAe);
      break;
      au.Hx();
      this.vAe = com.tencent.mm.model.c.Fy().f(parama, l, 48);
      break label408;
      au.Hx();
      i = com.tencent.mm.model.c.Fy().r(parama, this.vAd, l);
      continue;
      label609:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        y.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.k.c(this.byx.getTalkerUserName(), this.vzN, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      y.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.k.c(this.byx.getTalkerUserName(), k, j);
      break;
      label730:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.vyj;
    Object localObject = paramd.vym;
    int j = paramd.vyk.size();
    int k = paramd.dsw;
    int i = paramd.nul;
    Bundle localBundle = paramd.vyi;
    bi localbi = (bi)((SparseArray)localObject).get(0);
    localObject = (bi)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localbi != null) {
      this.vAd = localbi.field_createTime;
    }
    if (localObject != null) {
      this.vAe = ((cs)localObject).field_createTime;
    }
    switch (2.vzn[locala.ordinal()])
    {
    case 3: 
    default: 
      y.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.vAd), Long.valueOf(this.vAe), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      paramd = this.byx.getTalkerUserName();
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb().Hp(paramd);
      au.Hx();
      i = com.tencent.mm.model.c.Fy().r(paramd, 0L, l);
      y.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
      if (k - i > j) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      return;
      paramMMChattingListView.na(false);
      int m = paramMMChattingListView.getCurCount();
      int n = paramMMChattingListView.getPreCount();
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), m - n + 1, cGY() + paramMMChattingListView.getTopHeight(), false);
      m = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (m <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GY(m);
      break;
      paramMMChattingListView.nb(false);
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - cGY(), false);
      break;
      this.byx.cCW();
      break;
      i = localBundle.getInt("MSG_POSITION");
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.dsw - i));
      paramd.nul = i;
      paramMMChattingListView.getListView().post(new d.1(this, localBundle, i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.d
 * JD-Core Version:    0.7.0.1
 */