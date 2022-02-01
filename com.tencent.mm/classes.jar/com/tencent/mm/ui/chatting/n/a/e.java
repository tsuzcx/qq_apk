package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.d;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public class e
  extends a
{
  private int PFD = 0;
  private volatile long PFN = 0L;
  private volatile long PFO = 0L;
  private volatile long wZu = 0L;
  
  public e(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.e parame)
  {
    super(parama, parame);
  }
  
  private int gTR()
  {
    AppMethodBeat.i(36674);
    int i = ((aa)grq().bh(aa.class)).gQy();
    AppMethodBeat.o(36674);
    return i;
  }
  
  protected final f a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36672);
    Object localObject = null;
    bg.aVF();
    int j = com.tencent.mm.model.c.aSQ().aEM(grq().getTalkerUserName());
    switch (2.PEY[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.PFD = j;
      AppMethodBeat.o(36672);
      return parama;
      parama = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), this.PFx + 48, j);
      continue;
      i = j - this.PFD;
      parama = grq().getTalkerUserName();
      k = this.PFx;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.n.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(36672);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label623;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new d(grq().getTalkerUserName(), this.PFN, this.PFO);
      }
      else
      {
        parama = grq().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        bg.aVF();
        paramBundle = com.tencent.mm.model.c.aSQ().Hb(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        Log.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new d(grq().getTalkerUserName(), this.PFN, this.PFO);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.PFN) || (l > this.PFO))
    {
      this.PFN = l;
      this.wZu = ((l)g.af(l.class)).eiy().aEQ(parama);
      if (bool)
      {
        this.PFO = this.wZu;
        label422:
        bg.aVF();
        i = com.tencent.mm.model.c.aSQ().E(parama, this.PFN, this.PFO);
        Log.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label744;
        }
        Log.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.PFN), Integer.valueOf(0) });
        bg.aVF();
        this.PFN = com.tencent.mm.model.c.aSQ().i(parama, this.PFN, 48);
        bg.aVF();
        i = com.tencent.mm.model.c.aSQ().E(parama, this.PFN, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new d(grq().getTalkerUserName(), this.PFN, this.PFO);
      break;
      bg.aVF();
      this.PFO = com.tencent.mm.model.c.aSQ().j(parama, l, 48);
      break label422;
      bg.aVF();
      i = com.tencent.mm.model.c.aSQ().E(parama, this.PFN, l);
      continue;
      label623:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        Log.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), this.PFx, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.n.c(grq().getTalkerUserName(), k, j);
      break;
      label744:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(36673);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.PDL;
    Object localObject = paramd.PDO;
    int k = paramd.PDM.size();
    int m = paramd.gAZ;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.PDK;
    ca localca = (ca)((SparseArray)localObject).get(0);
    localObject = (ca)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localca != null) {
      this.PFN = localca.field_createTime;
    }
    if (localObject != null) {
      this.PFO = ((eo)localObject).field_createTime;
    }
    int j = i;
    boolean bool;
    switch (2.PEY[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.PDG)
        {
          Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.PFN), Long.valueOf(this.PFO), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = grq().getTalkerUserName();
          long l = ((l)g.af(l.class)).aTq().aEk(paramd);
          bg.aVF();
          i = com.tencent.mm.model.c.aSQ().E(paramd, 0L, l);
          Log.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
          if (m - i > k) {
            break;
          }
          bool = true;
          label314:
          paramMMChattingListView.setIsTopShowAll(bool);
          paramMMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(36673);
        return;
        paramMMChattingListView.Bx(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        p.a(paramMMChattingListView.getListView(), j - n + 1, gTR() + paramMMChattingListView.getTopHeight(), false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((k)grq().bh(k.class)).amv(n);
          j = i;
          continue;
          paramMMChattingListView.By(false);
          p.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - gTR() - paramMMChattingListView.getBottomHeight(), false);
          j = i;
          continue;
          grq().BN(false);
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
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.gAZ - j));
      paramd.selection = i;
    }
    label553:
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36670);
          Object localObject = (k)e.this.grq().bh(k.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            e.this.grq().Pwf = i;
            e.this.any(i);
            AppMethodBeat.o(36670);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((k)localObject).amu(i);
            localObject = e.this.grq();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.e.a)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(36670);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.e
 * JD-Core Version:    0.7.0.1
 */