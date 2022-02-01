package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.chatting.g.d;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.m.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;
import java.util.List;

public final class c
  extends a
{
  private boolean GGP = false;
  private boolean GGQ = false;
  
  public c(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    super(parama, paramd);
  }
  
  private int faB()
  {
    AppMethodBeat.i(36669);
    int i = ((w)faA().be(w.class)).eYb();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.m.b(faA().getTalkerUserName(), parama, paramBundle, this.GGJ, this.GGt, this.GGu, this.GGI, paramd, bool);
      AppMethodBeat.o(36667);
      return parama;
    }
  }
  
  public final void a(d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36666);
    Bundle localBundle1;
    Bundle localBundle2;
    if (parama == d.a.GEW)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.GGP)
      {
        ad.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
        localBundle1.putBoolean("has_position_tongue", true);
        localBundle2 = localBundle1;
      }
    }
    do
    {
      for (;;)
      {
        super.a(parama, paramBoolean, localBundle2);
        AppMethodBeat.o(36666);
        return;
        localBundle2 = localBundle1;
        if (this.GGQ)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != d.a.GEY);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.GGP = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.GGQ = bool1;
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bl> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.GFd.size();
    int k = paramd.fwP;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.GFf;
    d.a locala = paramd.GFc;
    bl localbl1 = (bl)localSparseArray.get(0);
    bl localbl2 = (bl)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.GFc != d.a.GEW) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      ad.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { faA().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.GGj[paramd.GFc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      label613:
      do
      {
        for (;;)
        {
          paramMMChattingListView.setIsTopShowAll(true);
          paramMMChattingListView.setIsBottomShowAll(true);
          l1 = 0L;
          if (localbl1 != null) {
            l1 = localbl1.field_createTime;
          }
          long l2 = 0L;
          if (localbl2 != null) {
            l2 = localbl2.field_createTime;
          }
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { faA().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.afE().ax(new a(paramMMChattingListView, faA().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.vM(false);
          faA().wc(true);
          continue;
          if ((paramd.GFb != null) && (paramd.GFb.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.vM(false);
            faA().wc(true);
            this.GGP = false;
          }
          this.GGQ = false;
        }
        if ((paramd.GFb != null) && (paramd.GFb.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          faA().wc(true);
          ((x)faA().be(x.class)).eYe();
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.vM(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - faB() - paramMMChattingListView.getBottomHeight();
          faA().jt(i, n);
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.GFb != null) && (paramd.GFb.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label613;
          }
          Zy(paramd.selection);
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.GFb == null);
      paramMMChattingListView.a(false, null);
      l1 = paramd.GFb.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label647:
      if (i >= 0)
      {
        bl localbl3 = (bl)localSparseArray.get(i);
        if ((localbl3 == null) || (localbl3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((i)faA().be(i.class)).YF(paramd.selection);
      Zy(paramd.selection);
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label647;
      paramMMChattingListView.vL(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      faA().jt(i + 1, faB() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((i)faA().be(i.class)).YG(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long GGR;
    private long GGS;
    WeakReference<MMChattingListView> GGT;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.GGT = new WeakReference(paramMMChattingListView);
      this.GGR = paramLong2;
      this.GGS = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((k)g.ab(k.class)).cOD();
      int k = ((k)g.ab(k.class)).cOI().E(this.username, 0L, this.GGS - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).A(this.username, 0L, this.GGS - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((k)g.ab(k.class)).cOI().E(this.username, this.GGR + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).A(this.username, this.GGR + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).agb(this.username);
              if (((y)localObject).field_lastLocalSeq != ((y)localObject).field_lastPushSeq) {
                break label292;
              }
            }
          }
          for (final boolean bool2 = true;; bool2 = false)
          {
            ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
            this.view.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36663);
                MMChattingListView localMMChattingListView = (MMChattingListView)c.a.this.GGT.get();
                if (localMMChattingListView != null)
                {
                  localMMChattingListView.getListView().setTranscriptMode(1);
                  localMMChattingListView.setIsTopShowAll(bool3);
                  localMMChattingListView.setIsBottomShowAll(bool2);
                }
                AppMethodBeat.o(36663);
              }
            }, 60L);
            AppMethodBeat.o(36665);
            return;
            bool3 = false;
            break;
            bool1 = false;
            break label155;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.c
 * JD-Core Version:    0.7.0.1
 */