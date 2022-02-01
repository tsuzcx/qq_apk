package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public class e
  extends a
{
  private int Kto = 0;
  private volatile long Kty = 0L;
  private volatile long Ktz = 0L;
  private volatile long tIv = 0L;
  
  public e(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.e parame)
  {
    super(parama, parame);
  }
  
  private int fLw()
  {
    AppMethodBeat.i(36674);
    int i = ((y)fif().bh(y.class)).fIn();
    AppMethodBeat.o(36674);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.n.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36672);
    Object localObject = null;
    bc.aCg();
    int j = com.tencent.mm.model.c.azI().arr(fif().getTalkerUserName());
    switch (2.KsJ[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.Kto = j;
      AppMethodBeat.o(36672);
      return parama;
      parama = new com.tencent.mm.ui.chatting.n.c(fif().getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.n.c(fif().getTalkerUserName(), this.Kti + 48, j);
      continue;
      i = j - this.Kto;
      parama = fif().getTalkerUserName();
      k = this.Kti;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.n.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        ae.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(36672);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label623;
      }
      ae.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        ae.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new d(fif().getTalkerUserName(), this.Kty, this.Ktz);
      }
      else
      {
        parama = fif().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        bc.aCg();
        paramBundle = com.tencent.mm.model.c.azI().ys(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        ae.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new d(fif().getTalkerUserName(), this.Kty, this.Ktz);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.Kty) || (l > this.Ktz))
    {
      this.Kty = l;
      this.tIv = ((l)g.ab(l.class)).doJ().arv(parama);
      if (bool)
      {
        this.Ktz = this.tIv;
        label422:
        bc.aCg();
        i = com.tencent.mm.model.c.azI().D(parama, this.Kty, this.Ktz);
        ae.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label744;
        }
        ae.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.Kty), Integer.valueOf(0) });
        bc.aCg();
        this.Kty = com.tencent.mm.model.c.azI().i(parama, this.Kty, 48);
        bc.aCg();
        i = com.tencent.mm.model.c.azI().D(parama, this.Kty, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new d(fif().getTalkerUserName(), this.Kty, this.Ktz);
      break;
      bc.aCg();
      this.Ktz = com.tencent.mm.model.c.azI().j(parama, l, 48);
      break label422;
      bc.aCg();
      i = com.tencent.mm.model.c.azI().D(parama, this.Kty, l);
      continue;
      label623:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        ae.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.n.c(fif().getTalkerUserName(), this.Kti, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      ae.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.n.c(fif().getTalkerUserName(), k, j);
      break;
      label744:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bv> paramd)
  {
    AppMethodBeat.i(36673);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.KrD;
    Object localObject = paramd.KrG;
    int k = paramd.KrE.size();
    int m = paramd.fVS;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.KrC;
    bv localbv = (bv)((SparseArray)localObject).get(0);
    localObject = (bv)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localbv != null) {
      this.Kty = localbv.field_createTime;
    }
    if (localObject != null) {
      this.Ktz = ((ei)localObject).field_createTime;
    }
    int j = i;
    boolean bool;
    switch (2.KsJ[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.Kry)
        {
          ae.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.Kty), Long.valueOf(this.Ktz), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = fif().getTalkerUserName();
          long l = ((l)g.ab(l.class)).aAi().aqP(paramd);
          bc.aCg();
          i = com.tencent.mm.model.c.azI().D(paramd, 0L, l);
          ae.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
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
        paramMMChattingListView.xI(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        n.a(paramMMChattingListView.getListView(), j - n + 1, fLw() + paramMMChattingListView.getTopHeight(), false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((k)fif().bh(k.class)).adK(n);
          j = i;
          continue;
          paramMMChattingListView.xJ(false);
          n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fLw() - paramMMChattingListView.getBottomHeight(), false);
          j = i;
          continue;
          fif().xY(false);
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
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.fVS - j));
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
          Object localObject = (k)e.this.fif().bh(k.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            e.this.fif().Kkg = i;
            e.this.aeN(i);
            AppMethodBeat.o(36670);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((k)localObject).adJ(i);
            localObject = e.this.fif();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.e.a)localObject).ca(((Integer)locala.mt(0)).intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.e
 * JD-Core Version:    0.7.0.1
 */