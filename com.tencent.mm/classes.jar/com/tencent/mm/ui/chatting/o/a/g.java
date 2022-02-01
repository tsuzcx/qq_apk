package com.tencent.mm.ui.chatting.o.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.o.d;
import com.tencent.mm.ui.chatting.o.e.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class g
  extends a
{
  private volatile long BLt;
  private volatile long XaB;
  private volatile long XaC;
  private e.a XaJ;
  private int Xar;
  
  public g(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(271605);
    this.Xar = 0;
    this.XaB = 0L;
    this.XaC = 0L;
    this.BLt = 0L;
    this.XaJ = new e.a()
    {
      public final boolean c(ca paramAnonymousca1, ca paramAnonymousca2)
      {
        AppMethodBeat.i(292355);
        if ((g.this.hmp() != null) && (g.this.hmp().bC(o.class) != null))
        {
          boolean bool = ((o)g.this.hmp().bC(o.class)).a(paramAnonymousca1, paramAnonymousca2);
          AppMethodBeat.o(292355);
          return bool;
        }
        AppMethodBeat.o(292355);
        return false;
      }
    };
    AppMethodBeat.o(271605);
  }
  
  private int hTB()
  {
    AppMethodBeat.i(271610);
    int i = ((aa)hmp().bC(aa.class)).hPV();
    AppMethodBeat.o(271610);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.o.g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(271608);
    Object localObject = null;
    bh.beI();
    int j = com.tencent.mm.model.c.bbO().aOW(hmp().getTalkerUserName());
    switch (3.WZK[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    label108:
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.Xar = j;
      AppMethodBeat.o(271608);
      return parama;
      for (parama = new com.tencent.mm.ui.chatting.o.e(hmp().getTalkerUserName(), 16, j, parama, this.XaJ);; parama = new com.tencent.mm.ui.chatting.o.e(hmp().getTalkerUserName(), hTy() + 48, j, parama, this.XaJ)) {
        break;
      }
      i = j - this.Xar;
      paramBundle = hmp().getTalkerUserName();
      k = hTy();
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.o.e(paramBundle, i + k, j, parama, this.XaJ);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(271608);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label638;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new d(hmp().getTalkerUserName(), this.XaB, this.XaC);
      }
      else
      {
        parama = hmp().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        bh.beI();
        paramBundle = com.tencent.mm.model.c.bbO().Oq(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new d(hmp().getTalkerUserName(), this.XaB, this.XaC);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.XaB) || (l > this.XaC))
    {
      this.XaB = l;
      this.BLt = ((n)h.ae(n.class)).eSe().aPa(parama);
      if (bool)
      {
        this.XaC = this.BLt;
        label437:
        bh.beI();
        i = com.tencent.mm.model.c.bbO().D(parama, this.XaB, this.XaC);
        Log.v("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label773;
        }
        Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.XaB), Integer.valueOf(0) });
        bh.beI();
        this.XaB = com.tencent.mm.model.c.bbO().j(parama, this.XaB, 48);
        bh.beI();
        i = com.tencent.mm.model.c.bbO().D(parama, this.XaB, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new d(hmp().getTalkerUserName(), this.XaB, this.XaC);
      break;
      bh.beI();
      this.XaC = com.tencent.mm.model.c.bbO().k(parama, l, 48);
      break label437;
      bh.beI();
      i = com.tencent.mm.model.c.bbO().D(parama, this.XaB, l);
      continue;
      label638:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        Log.e("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.o.e(hmp().getTalkerUserName(), hTy(), j, d.a.WYu, this.XaJ);
        break label108;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.o.e(hmp().getTalkerUserName(), k, j, d.a.WYu, this.XaJ);
      break label108;
      label773:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(271609);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.WYy;
    Object localObject = paramd.WYB;
    int k = paramd.WYz.size();
    int m = paramd.jlf;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.WYx;
    ca localca = (ca)((SparseArray)localObject).get(0);
    localObject = (ca)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localca != null) {
      this.XaB = localca.field_createTime;
    }
    if (localObject != null) {
      this.XaC = ((et)localObject).field_createTime;
    }
    int j = i;
    boolean bool;
    switch (3.WZK[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.WYt)
        {
          Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.XaB), Long.valueOf(this.XaC), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = hmp().getTalkerUserName();
          long l = ((n)h.ae(n.class)).bco().aOu(paramd);
          bh.beI();
          i = com.tencent.mm.model.c.bbO().D(paramd, 0L, l);
          Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
          if (m - i > k) {
            break;
          }
          bool = true;
          label314:
          paramMMChattingListView.setIsTopShowAll(bool);
          paramMMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(271609);
        return;
        paramMMChattingListView.FP(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        r.a(paramMMChattingListView.getListView(), j - n + 1, hTB() + paramMMChattingListView.getTopHeight(), false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((k)hmp().bC(k.class)).avv(n);
          j = i;
          continue;
          paramMMChattingListView.FQ(false);
          r.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - hTB() - paramMMChattingListView.getBottomHeight(), false);
          j = i;
          continue;
          hmp().Gi(false);
          j = i;
        }
      }
    }
    if (localBundle == null)
    {
      j = -1;
      label481:
      if (j == -1) {
        break label553;
      }
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.jlf - j));
      paramd.selection = i;
    }
    label553:
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268102);
          Object localObject = (k)g.this.hmp().bC(k.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            g.this.hmp().WQy = i;
            g.this.awC(i);
            AppMethodBeat.o(268102);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((k)localObject).avu(i);
            localObject = g.this.hmp();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/chatting/source/presenter/ChattingServiceNotifyDataPresenter$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingServiceNotifyDataPresenter$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(268102);
        }
      });
      j = i;
      break;
      j = localBundle.getInt("MSG_POSITION", -1);
      break label481;
      bool = false;
      break label314;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a.g
 * JD-Core Version:    0.7.0.1
 */