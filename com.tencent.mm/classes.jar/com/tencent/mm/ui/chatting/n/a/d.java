package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;
import java.util.List;

public final class d
  extends a
{
  private boolean PFE = false;
  private boolean PFF = false;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
  }
  
  private int gTR()
  {
    AppMethodBeat.i(36669);
    int i = ((aa)grq().bh(aa.class)).gQy();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final f a(com.tencent.mm.ui.chatting.h.d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.n.b(grq().getTalkerUserName(), parama, paramBundle, this.PFy, this.PFi, this.PFj, this.PFx, paramd, bool);
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
    if (parama == com.tencent.mm.ui.chatting.h.d.a.PDF)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.PFE)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
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
        if (this.PFF)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != com.tencent.mm.ui.chatting.h.d.a.PDH);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.PFE = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.PFF = bool1;
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.PDM.size();
    int k = paramd.gAZ;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.PDO;
    com.tencent.mm.ui.chatting.h.d.a locala = paramd.PDL;
    ca localca1 = (ca)localSparseArray.get(0);
    ca localca2 = (ca)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.PDL != com.tencent.mm.ui.chatting.h.d.a.PDF) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      Log.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { grq().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.PEY[paramd.PDL.ordinal()])
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
          if (localca1 != null) {
            l1 = localca1.field_createTime;
          }
          long l2 = 0L;
          if (localca2 != null) {
            l2 = localca2.field_createTime;
          }
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { grq().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.aAk().postToWorker(new a(paramMMChattingListView, grq().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.By(false);
          grq().BN(true);
          continue;
          if ((paramd.PDK != null) && (paramd.PDK.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.By(false);
            grq().BN(true);
            this.PFE = false;
          }
          this.PFF = false;
        }
        if ((paramd.PDK != null) && (paramd.PDK.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          grq().BN(true);
          ((ab)grq().bh(ab.class)).gQC();
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.By(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - gTR() - paramMMChattingListView.getBottomHeight();
          grq().lf(i, n);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.PDK != null) && (paramd.PDK.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label613;
          }
          any(paramd.selection);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.PDK == null);
      paramMMChattingListView.c(false, null);
      l1 = paramd.PDK.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label647:
      if (i >= 0)
      {
        ca localca3 = (ca)localSparseArray.get(i);
        if ((localca3 == null) || (localca3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((k)grq().bh(k.class)).amu(paramd.selection);
      any(paramd.selection);
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label647;
      paramMMChattingListView.Bx(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      grq().lf(i + 1, gTR() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((k)grq().bh(k.class)).amv(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long PFG;
    private long PFH;
    WeakReference<MMChattingListView> PFI;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.PFI = new WeakReference(paramMMChattingListView);
      this.PFG = paramLong2;
      this.PFH = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((l)g.af(l.class)).eit();
      int k = ((l)g.af(l.class)).eiy().E(this.username, 0L, this.PFH - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).A(this.username, 0L, this.PFH - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((l)g.af(l.class)).eiy().E(this.username, this.PFG + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).A(this.username, this.PFG + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aEh(this.username);
              if (((aj)localObject).field_lastLocalSeq != ((aj)localObject).field_lastPushSeq) {
                break label292;
              }
            }
          }
          for (final boolean bool2 = true;; bool2 = false)
          {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
            this.view.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36663);
                MMChattingListView localMMChattingListView = (MMChattingListView)d.a.this.PFI.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.d
 * JD-Core Version:    0.7.0.1
 */