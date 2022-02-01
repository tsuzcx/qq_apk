package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;
import java.util.List;

public final class d
  extends a
{
  private boolean aeKb = false;
  private boolean aeKc = false;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.d paramd)
  {
    super(parama, paramd);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(36669);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final g a(com.tencent.mm.ui.chatting.f.d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.k.b(iNh().getTalkerUserName(), parama, paramBundle, jwZ(), jxc(), jxb(), jxa(), paramd, bool);
      AppMethodBeat.o(36667);
      return parama;
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.f.d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36666);
    Bundle localBundle1;
    Bundle localBundle2;
    if (parama == com.tencent.mm.ui.chatting.f.d.a.aeHS)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.aeKb)
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
        if (this.aeKc)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != com.tencent.mm.ui.chatting.f.d.a.aeHU);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.aeKb = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aeKc = bool1;
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.aeHZ.size();
    int k = paramd.lNX;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.aeIb;
    com.tencent.mm.ui.chatting.f.d.a locala = paramd.aeHY;
    cc localcc1 = (cc)localSparseArray.get(0);
    cc localcc2 = (cc)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.aeHY != com.tencent.mm.ui.chatting.f.d.a.aeHS) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      Log.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { iNh().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.aeJk[paramd.aeHY.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      label616:
      do
      {
        for (;;)
        {
          paramMMChattingListView.setIsTopShowAll(true);
          paramMMChattingListView.setIsBottomShowAll(true);
          l1 = 0L;
          if (localcc1 != null) {
            l1 = localcc1.getCreateTime();
          }
          long l2 = 0L;
          if (localcc2 != null) {
            l2 = localcc2.getCreateTime();
          }
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { iNh().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          h.baH().postToWorker(new a(paramMMChattingListView, iNh().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.LC(false);
          iNh().Mf(true);
          continue;
          if ((paramd.aeHX != null) && (paramd.aeHX.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.LC(false);
            iNh().jpK();
            this.aeKb = false;
          }
          this.aeKc = false;
        }
        if ((paramd.aeHX != null) && (paramd.aeHX.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          iNh().jpK();
          ((ae)iNh().cm(ae.class)).jsX();
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.LC(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - jxd() - paramMMChattingListView.getBottomHeight();
          iNh().h(i, n, false, false);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.aeHX != null) && (paramd.aeHX.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label616;
          }
          b(paramd.selection, false, 0, false);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.aeHX == null);
      paramMMChattingListView.c(false, null);
      l1 = paramd.aeHX.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label650:
      if (i >= 0)
      {
        cc localcc3 = (cc)localSparseArray.get(i);
        if ((localcc3 == null) || (localcc3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((m)iNh().cm(m.class)).aBW(paramd.selection);
      b(paramd.selection, false, 0, false);
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label650;
      paramMMChattingListView.LB(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      iNh().h(i + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((m)iNh().cm(m.class)).aBX(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long aeKd;
    private long aeKe;
    WeakReference<MMChattingListView> aeKf;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.aeKf = new WeakReference(paramMMChattingListView);
      this.aeKd = paramLong2;
      this.aeKe = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((n)h.ax(n.class)).gaU();
      int k = ((n)h.ax(n.class)).gaZ().I(this.username, 0L, this.aeKe - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).E(this.username, 0L, this.aeKe - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((n)h.ax(n.class)).gaZ().I(this.username, this.aeKd + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).E(this.username, this.aeKd + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aLq(this.username);
              if (((al)localObject).field_lastLocalSeq != ((al)localObject).field_lastPushSeq) {
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
                MMChattingListView localMMChattingListView = (MMChattingListView)d.a.this.aeKf.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.d
 * JD-Core Version:    0.7.0.1
 */