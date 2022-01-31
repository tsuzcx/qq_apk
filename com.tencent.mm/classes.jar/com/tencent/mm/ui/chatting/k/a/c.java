package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.r;
import com.tencent.mm.ui.chatting.e.d;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.k.b;
import com.tencent.mm.ui.chatting.k.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class c
  extends a
{
  private boolean vzU = false;
  private boolean vzV = false;
  
  public c(com.tencent.mm.ui.chatting.c.a parama, d paramd)
  {
    super(parama, paramd);
  }
  
  private int cGY()
  {
    return ((q)this.byx.ac(q.class)).cEP();
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false) {
      return new b(this.byx.getTalkerUserName(), parama, paramBundle, this.vzO, this.vzx, this.vzy, this.vzN, paramd, bool);
    }
  }
  
  public final void a(d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    Bundle localBundle1;
    Bundle localBundle2;
    if (parama == d.a.vyd)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.vzU)
      {
        y.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
        localBundle1.putBoolean("has_position_tongue", true);
        localBundle2 = localBundle1;
      }
    }
    do
    {
      for (;;)
      {
        super.a(parama, paramBoolean, localBundle2);
        return;
        localBundle2 = localBundle1;
        if (this.vzV)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != d.a.vyf);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label114:
      this.vzU = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label163;
      }
    }
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vzV = bool1;
      y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label114;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    int j = paramd.vyk.size();
    int k = paramd.dsw;
    int m = paramd.nul;
    SparseArray localSparseArray = paramd.vym;
    d.a locala = paramd.vyj;
    bi localbi1 = (bi)localSparseArray.get(0);
    bi localbi2 = (bi)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.vyj != d.a.vyd) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      y.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { this.byx.getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (c.1.vzn[paramd.vyj.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      label593:
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
          y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { this.byx.getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          com.tencent.mm.kernel.g.DS().O(new c.a(this, paramMMChattingListView, this.byx.getTalkerUserName(), l1, l2, (byte)0));
          return;
          paramMMChattingListView.nb(false);
          this.byx.cCW();
          continue;
          if ((paramd.vyi != null) && (paramd.vyi.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.nb(false);
            this.byx.cCW();
            this.vzU = false;
          }
          this.vzV = false;
        }
        if ((paramd.vyi != null) && (paramd.vyi.getBoolean("load_bottom", false)))
        {
          this.byx.cCW();
          ((r)this.byx.ac(r.class)).cES();
          y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.nb(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - cGY() - paramMMChattingListView.getBottomHeight();
          this.byx.fx(i, n);
          y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.vyi != null) && (paramd.vyi.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label593;
          }
          HH(paramd.nul);
          y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.nul);
          break;
        }
      } while (paramd.vyi == null);
      paramMMChattingListView.a(false, null);
      l1 = paramd.vyi.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label627:
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
      paramd.nul = i;
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GX(paramd.nul);
      HH(paramd.nul);
      y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label627;
      paramMMChattingListView.na(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      this.byx.fx(i + 1, cGY() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      y.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GY(n);
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.c
 * JD-Core Version:    0.7.0.1
 */