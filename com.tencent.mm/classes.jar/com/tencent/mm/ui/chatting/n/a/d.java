package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;
import java.util.List;

public final class d
  extends a
{
  private boolean Ktp = false;
  private boolean Ktq = false;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
  }
  
  private int fLw()
  {
    AppMethodBeat.i(36669);
    int i = ((y)fif().bh(y.class)).fIn();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final e a(com.tencent.mm.ui.chatting.h.d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.n.b(fif().getTalkerUserName(), parama, paramBundle, this.Ktj, this.KsT, this.KsU, this.Kti, paramd, bool);
      AppMethodBeat.o(36667);
      return parama;
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.h.d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36666);
    Bundle localBundle1;
    Bundle localBundle2;
    if (parama == com.tencent.mm.ui.chatting.h.d.a.Krx)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.Ktp)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
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
        if (this.Ktq)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != com.tencent.mm.ui.chatting.h.d.a.Krz);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.Ktp = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Ktq = bool1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bv> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.KrE.size();
    int k = paramd.fVS;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.KrG;
    com.tencent.mm.ui.chatting.h.d.a locala = paramd.KrD;
    bv localbv1 = (bv)localSparseArray.get(0);
    bv localbv2 = (bv)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.KrD != com.tencent.mm.ui.chatting.h.d.a.Krx) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { fif().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.KsJ[paramd.KrD.ordinal()])
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
          if (localbv1 != null) {
            l1 = localbv1.field_createTime;
          }
          long l2 = 0L;
          if (localbv2 != null) {
            l2 = localbv2.field_createTime;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { fif().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.ajU().aw(new a(paramMMChattingListView, fif().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.xJ(false);
          fif().xY(true);
          continue;
          if ((paramd.KrC != null) && (paramd.KrC.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.xJ(false);
            fif().xY(true);
            this.Ktp = false;
          }
          this.Ktq = false;
        }
        if ((paramd.KrC != null) && (paramd.KrC.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          fif().xY(true);
          ((z)fif().bh(z.class)).fIr();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.xJ(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - fLw() - paramMMChattingListView.getBottomHeight();
          fif().jV(i, n);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.KrC != null) && (paramd.KrC.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label613;
          }
          aeN(paramd.selection);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.KrC == null);
      paramMMChattingListView.b(false, null);
      l1 = paramd.KrC.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label647:
      if (i >= 0)
      {
        bv localbv3 = (bv)localSparseArray.get(i);
        if ((localbv3 == null) || (localbv3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((k)fif().bh(k.class)).adJ(paramd.selection);
      aeN(paramd.selection);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label647;
      paramMMChattingListView.xI(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      fif().jV(i + 1, fLw() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((k)fif().bh(k.class)).adK(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long Ktr;
    private long Kts;
    WeakReference<MMChattingListView> Ktt;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.Ktt = new WeakReference(paramMMChattingListView);
      this.Ktr = paramLong2;
      this.Kts = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((l)g.ab(l.class)).doE();
      int k = ((l)g.ab(l.class)).doJ().D(this.username, 0L, this.Kts - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).z(this.username, 0L, this.Kts - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((l)g.ab(l.class)).doJ().D(this.username, this.Ktr + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).z(this.username, this.Ktr + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aqM(this.username);
              if (((com.tencent.mm.storage.ae)localObject).field_lastLocalSeq != ((com.tencent.mm.storage.ae)localObject).field_lastPushSeq) {
                break label292;
              }
            }
          }
          for (final boolean bool2 = true;; bool2 = false)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
            this.view.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36663);
                MMChattingListView localMMChattingListView = (MMChattingListView)d.a.this.Ktt.get();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.d
 * JD-Core Version:    0.7.0.1
 */