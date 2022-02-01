package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class d
  extends a
{
  private int IgK = 0;
  private volatile long IgU = 0L;
  private volatile long IgV = 0L;
  private volatile long sBd = 0L;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.g.e parame)
  {
    super(parama, parame);
  }
  
  private int fqr()
  {
    AppMethodBeat.i(36674);
    int i = ((w)fqq().bf(w.class)).fnN();
    AppMethodBeat.o(36674);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.m.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36672);
    Object localObject = null;
    az.ayM();
    int j = com.tencent.mm.model.c.awD().aly(fqq().getTalkerUserName());
    switch (2.Igf[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.IgK = j;
      AppMethodBeat.o(36672);
      return parama;
      parama = new com.tencent.mm.ui.chatting.m.c(fqq().getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.m.c(fqq().getTalkerUserName(), this.IgE + 48, j);
      continue;
      i = j - this.IgK;
      parama = fqq().getTalkerUserName();
      k = this.IgE;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.m.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        ac.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(36672);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label623;
      }
      ac.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        ac.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new com.tencent.mm.ui.chatting.m.d(fqq().getTalkerUserName(), this.IgU, this.IgV);
      }
      else
      {
        parama = fqq().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        az.ayM();
        paramBundle = com.tencent.mm.model.c.awD().vP(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        ac.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new com.tencent.mm.ui.chatting.m.d(fqq().getTalkerUserName(), this.IgU, this.IgV);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.IgU) || (l > this.IgV))
    {
      this.IgU = l;
      this.sBd = ((k)g.ab(k.class)).dcr().alC(parama);
      if (bool)
      {
        this.IgV = this.sBd;
        label422:
        az.ayM();
        i = com.tencent.mm.model.c.awD().C(parama, this.IgU, this.IgV);
        ac.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label744;
        }
        ac.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.IgU), Integer.valueOf(0) });
        az.ayM();
        this.IgU = com.tencent.mm.model.c.awD().g(parama, this.IgU, 48);
        az.ayM();
        i = com.tencent.mm.model.c.awD().C(parama, this.IgU, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new com.tencent.mm.ui.chatting.m.d(fqq().getTalkerUserName(), this.IgU, this.IgV);
      break;
      az.ayM();
      this.IgV = com.tencent.mm.model.c.awD().h(parama, l, 48);
      break label422;
      az.ayM();
      i = com.tencent.mm.model.c.awD().C(parama, this.IgU, l);
      continue;
      label623:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        ac.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.m.c(fqq().getTalkerUserName(), this.IgE, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      ac.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.m.c(fqq().getTalkerUserName(), k, j);
      break;
      label744:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bo> paramd)
  {
    AppMethodBeat.i(36673);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.IeY;
    Object localObject = paramd.Ifb;
    int k = paramd.IeZ.size();
    int m = paramd.fAw;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.IeX;
    bo localbo = (bo)((SparseArray)localObject).get(0);
    localObject = (bo)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localbo != null) {
      this.IgU = localbo.field_createTime;
    }
    if (localObject != null) {
      this.IgV = ((dy)localObject).field_createTime;
    }
    int j = i;
    boolean bool;
    switch (2.Igf[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.IeT)
        {
          ac.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.IgU), Long.valueOf(this.IgV), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          paramd = fqq().getTalkerUserName();
          long l = ((k)g.ab(k.class)).axd().akY(paramd);
          az.ayM();
          i = com.tencent.mm.model.c.awD().C(paramd, 0L, l);
          ac.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
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
        paramMMChattingListView.wP(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        n.a(paramMMChattingListView.getListView(), j - n + 1, fqr() + paramMMChattingListView.getTopHeight(), false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((i)fqq().bf(i.class)).aaR(n);
          j = i;
          continue;
          paramMMChattingListView.wQ(false);
          n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fqr() - paramMMChattingListView.getBottomHeight(), false);
          j = i;
          continue;
          fqq().xg(false);
          j = i;
        }
      }
    }
    j = localBundle.getInt("MSG_POSITION", -1);
    if (j != -1)
    {
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.fAw - j));
      paramd.selection = i;
    }
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36670);
          Object localObject = (i)d.this.fqq().bf(i.class);
          if (localBundle.getInt("SCENE", 0) == 1)
          {
            d.this.abK(i);
            AppMethodBeat.o(36670);
            return;
          }
          if (localBundle.getInt("SCENE", 0) == 2)
          {
            ((i)localObject).aaQ(i);
            localObject = d.this.fqq();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lR(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(36670);
        }
      });
      j = i;
      break;
      bool = false;
      break label314;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.d
 * JD-Core Version:    0.7.0.1
 */