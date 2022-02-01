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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bu;
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
  private boolean JWY = false;
  private boolean JWZ = false;
  
  public d(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
  }
  
  private int fHe()
  {
    AppMethodBeat.i(36669);
    int i = ((y)fep().bh(y.class)).fEk();
    AppMethodBeat.o(36669);
    return i;
  }
  
  protected final e a(com.tencent.mm.ui.chatting.h.d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36667);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = new com.tencent.mm.ui.chatting.n.b(fep().getTalkerUserName(), parama, paramBundle, this.JWS, this.JWC, this.JWD, this.JWR, paramd, bool);
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
    if (parama == com.tencent.mm.ui.chatting.h.d.a.JVf)
    {
      localBundle1 = paramBundle;
      if (paramBundle == null) {
        localBundle1 = new Bundle();
      }
      if (this.JWY)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
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
        if (this.JWZ)
        {
          localBundle1.putBoolean("has_position_search", true);
          localBundle2 = localBundle1;
        }
      }
      localBundle2 = paramBundle;
    } while (parama != com.tencent.mm.ui.chatting.h.d.a.JVh);
    if ((paramBundle != null) && (paramBundle.getInt("SCENE") == 2))
    {
      bool1 = true;
      label124:
      this.JWY = bool1;
      if ((paramBundle == null) || (paramBundle.getInt("SCENE") != 1)) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.JWZ = bool1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
      localBundle2 = paramBundle;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bu> paramd)
  {
    AppMethodBeat.i(36668);
    int j = paramd.JVm.size();
    int k = paramd.fTM;
    int m = paramd.selection;
    SparseArray localSparseArray = paramd.JVo;
    com.tencent.mm.ui.chatting.h.d.a locala = paramd.JVl;
    bu localbu1 = (bu)localSparseArray.get(0);
    bu localbu2 = (bu)localSparseArray.get(localSparseArray.size() - 1);
    super.a(paramMMChattingListView, paramd);
    if (paramd.JVl != com.tencent.mm.ui.chatting.h.d.a.JVf) {
      paramMMChattingListView.getListView().setTranscriptMode(0);
    }
    if ((localSparseArray.size() <= 6) && (k > 6)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", new Object[] { fep().getTalkerUserName() });
    }
    long l1;
    int i;
    int n;
    switch (1.JWs[paramd.JVl.ordinal()])
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
          if (localbu1 != null) {
            l1 = localbu1.field_createTime;
          }
          long l2 = 0L;
          if (localbu2 != null) {
            l2 = localbu2.field_createTime;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", new Object[] { fep().getTalkerUserName(), locala, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
          g.ajF().ay(new a(paramMMChattingListView, fep().getTalkerUserName(), l1, l2, (byte)0));
          AppMethodBeat.o(36668);
          return;
          paramMMChattingListView.xB(false);
          fep().xR(true);
          continue;
          if ((paramd.JVk != null) && (paramd.JVk.getBoolean("need_scroll_to_bottom", false)))
          {
            paramMMChattingListView.xB(false);
            fep().xR(true);
            this.JWY = false;
          }
          this.JWZ = false;
        }
        if ((paramd.JVk != null) && (paramd.JVk.getBoolean("load_bottom", false)))
        {
          paramMMChattingListView.getListView().setTranscriptMode(1);
          fep().xR(true);
          ((z)fep().bh(z.class)).fEn();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
        }
        for (;;)
        {
          paramMMChattingListView.xB(false);
          break;
          i = paramMMChattingListView.getPreCount() + 1;
          n = paramMMChattingListView.getListView().getHeight() - fHe() - paramMMChattingListView.getBottomHeight();
          fep().jR(i, n);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + i + " offset:" + n + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
        }
        if ((paramd.JVk != null) && (paramd.JVk.getInt("SCENE") == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label613;
          }
          aee(paramd.selection);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + paramd.selection);
          break;
        }
      } while (paramd.JVk == null);
      paramMMChattingListView.b(false, null);
      l1 = paramd.JVk.getLong("MSG_ID", 0L);
      i = localSparseArray.size() - 1;
      label647:
      if (i >= 0)
      {
        bu localbu3 = (bu)localSparseArray.get(i);
        if ((localbu3 == null) || (localbu3.field_msgId != l1)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i = Math.max(0, i);
      paramd.selection = i;
      ((k)fep().bh(k.class)).adb(paramd.selection);
      aee(paramd.selection);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + i + " msgId:" + l1);
      break;
      i -= 1;
      break label647;
      paramMMChattingListView.xA(false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      fep().jR(i + 1, fHe() + paramMMChattingListView.getTopHeight());
      n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + i + " curCount:" + paramMMChattingListView.getCurCount() + " preCount:" + paramMMChattingListView.getPreCount());
      if (n <= 0) {
        break;
      }
      ((k)fep().bh(k.class)).adc(n);
      break;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private long JXa;
    private long JXb;
    WeakReference<MMChattingListView> JXc;
    private String username;
    private View view;
    
    private a(MMChattingListView paramMMChattingListView, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(36664);
      this.view = paramMMChattingListView;
      this.username = paramString;
      this.JXc = new WeakReference(paramMMChattingListView);
      this.JXa = paramLong2;
      this.JXb = paramLong1;
      AppMethodBeat.o(36664);
    }
    
    public final void run()
    {
      AppMethodBeat.i(36665);
      Object localObject = ((l)g.ab(l.class)).dlF();
      int k = ((l)g.ab(l.class)).dlK().D(this.username, 0L, this.JXb - 1L);
      if (k <= 0) {}
      for (int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).z(this.username, 0L, this.JXb - 1L);; i = 0)
      {
        final boolean bool3;
        int m;
        if ((k <= 0) && (i <= 0))
        {
          bool3 = true;
          m = ((l)g.ab(l.class)).dlK().D(this.username, this.JXa + 1L, 9223372036854775807L);
          if (m > 0) {
            break label298;
          }
        }
        label155:
        label292:
        label298:
        for (int j = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).z(this.username, this.JXa + 1L, 9223372036854775807L);; j = 0)
        {
          boolean bool1;
          if ((m <= 0) && (j <= 0))
          {
            bool1 = true;
            bool2 = bool1;
            if (bool1)
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).apH(this.username);
              if (((com.tencent.mm.storage.ad)localObject).field_lastLocalSeq != ((com.tencent.mm.storage.ad)localObject).field_lastPushSeq) {
                break label292;
              }
            }
          }
          for (final boolean bool2 = true;; bool2 = false)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(j) });
            this.view.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36663);
                MMChattingListView localMMChattingListView = (MMChattingListView)d.a.this.JXc.get();
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