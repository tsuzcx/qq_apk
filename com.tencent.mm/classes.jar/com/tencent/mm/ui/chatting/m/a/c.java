package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.z;
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
  private boolean IgL = false;
  private boolean IgM = false;
  
  public c(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    super(parama, paramd);
  }
  
  private int fqr()
  {
    AppMethodBeat.i(36669);
    int i = ((w)fqq().bf(w.class)).fnN();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.m.b(fqq().getTalkerUserName(), parama, paramBundle, this.IgF, this.Igp, this.Igq, this.IgE, paramd, bool);
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
    if (parama == d.a.IeS)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.IgL)
      {
        ac.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
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
        if (this.IgM)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != d.a.IeU);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.IgL = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.IgM = bool1;
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bo> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.IeZ.size();
    int k = paramd.fAw;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.Ifb;
    d.a locala = paramd.IeY;
    bo localbo1 = (bo)localSparseArray.get(0);
    bo localbo2 = (bo)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.IeY != d.a.IeS) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      ac.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { fqq().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.Igf[paramd.IeY.ordinal()])
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
          if (localbo1 != null) {
            l1 = localbo1.field_createTime;
          }
          long l2 = 0L;
          if (localbo2 != null) {
            l2 = localbo2.field_createTime;
          }
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { fqq().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.agU().az(new a(paramMMChattingListView, fqq().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.wQ(false);
          fqq().xg(true);
          continue;
          if ((paramd.IeX != null) && (paramd.IeX.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.wQ(false);
            fqq().xg(true);
            this.IgL = false;
          }
          this.IgM = false;
        }
        if ((paramd.IeX != null) && (paramd.IeX.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          fqq().xg(true);
          ((x)fqq().bf(x.class)).fnQ();
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.wQ(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - fqr() - paramMMChattingListView.getBottomHeight();
          fqq().jF(i, n);
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.IeX != null) && (paramd.IeX.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label613;
          }
          abK(paramd.selection);
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.IeX == null);
      paramMMChattingListView.a(false, null);
      l1 = paramd.IeX.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label647:
      if (i >= 0)
      {
        bo localbo3 = (bo)localSparseArray.get(i);
        if ((localbo3 == null) || (localbo3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((i)fqq().bf(i.class)).aaQ(paramd.selection);
      abK(paramd.selection);
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label647;
      paramMMChattingListView.wP(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      fqq().jF(i + 1, fqr() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((i)fqq().bf(i.class)).aaR(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long IgN;
    private long IgO;
    WeakReference<MMChattingListView> IgP;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.IgP = new WeakReference(paramMMChattingListView);
      this.IgN = paramLong2;
      this.IgO = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((k)g.ab(k.class)).dcm();
      int k = ((k)g.ab(k.class)).dcr().C(this.username, 0L, this.IgO - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).y(this.username, 0L, this.IgO - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((k)g.ab(k.class)).dcr().C(this.username, this.IgN + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).y(this.username, this.IgN + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).akV(this.username);
              if (((z)localObject).field_lastLocalSeq != ((z)localObject).field_lastPushSeq) {
                break label292;
              }
            }
          }
          for (final boolean bool2 = true;; bool2 = false)
          {
            ac.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
            this.view.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36663);
                MMChattingListView localMMChattingListView = (MMChattingListView)c.a.this.IgP.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.c
 * JD-Core Version:    0.7.0.1
 */