package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class d
  extends a
{
  private int GGO = 0;
  private volatile long GGY = 0L;
  private volatile long GGZ = 0L;
  private volatile long rsj = 0L;
  
  public d(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.g.e parame)
  {
    super(parama, parame);
  }
  
  private int faB()
  {
    AppMethodBeat.i(36674);
    int i = ((w)faA().be(w.class)).eYb();
    AppMethodBeat.o(36674);
    return i;
  }
  
  protected final com.tencent.mm.ui.chatting.m.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36672);
    Object localObject = null;
    az.arV();
    int j = com.tencent.mm.model.c.apO().agE(faA().getTalkerUserName());
    switch (2.GGj[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    int k;
    boolean bool;
    for (;;)
    {
      this.GGO = j;
      AppMethodBeat.o(36672);
      return parama;
      parama = new com.tencent.mm.ui.chatting.m.c(faA().getTalkerUserName(), 16, j);
      continue;
      parama = new com.tencent.mm.ui.chatting.m.c(faA().getTalkerUserName(), this.GGI + 48, j);
      continue;
      i = j - this.GGO;
      parama = faA().getTalkerUserName();
      k = this.GGI;
      if (i > 0) {}
      for (;;)
      {
        parama = new com.tencent.mm.ui.chatting.m.c(parama, i + k, j);
        break;
        i = 0;
      }
      if (paramBundle == null)
      {
        ad.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
        AppMethodBeat.o(36672);
        return null;
      }
      if (paramBundle.getInt("SCENE", 0) != 1) {
        break label623;
      }
      ad.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
      if (paramBundle == null)
      {
        ad.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
        parama = new com.tencent.mm.ui.chatting.m.d(faA().getTalkerUserName(), this.GGY, this.GGZ);
      }
      else
      {
        parama = faA().getTalkerUserName();
        l = paramBundle.getLong("MSG_ID");
        bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
        az.arV();
        paramBundle = com.tencent.mm.model.c.apO().rm(l);
        if (paramBundle.field_msgId == l) {
          break;
        }
        ad.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
        parama = new com.tencent.mm.ui.chatting.m.d(faA().getTalkerUserName(), this.GGY, this.GGZ);
      }
    }
    long l = paramBundle.field_createTime;
    if ((l < this.GGY) || (l > this.GGZ))
    {
      this.GGY = l;
      this.rsj = ((k)g.ab(k.class)).cOI().agI(parama);
      if (bool)
      {
        this.GGZ = this.rsj;
        label422:
        az.arV();
        i = com.tencent.mm.model.c.apO().E(parama, this.GGY, this.GGZ);
        ad.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label744;
        }
        ad.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.GGY), Integer.valueOf(0) });
        az.arV();
        this.GGY = com.tencent.mm.model.c.apO().g(parama, this.GGY, 48);
        az.arV();
        i = com.tencent.mm.model.c.apO().E(parama, this.GGY, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new com.tencent.mm.ui.chatting.m.d(faA().getTalkerUserName(), this.GGY, this.GGZ);
      break;
      az.arV();
      this.GGZ = com.tencent.mm.model.c.apO().h(parama, l, 48);
      break label422;
      az.arV();
      i = com.tencent.mm.model.c.apO().E(parama, this.GGY, l);
      continue;
      label623:
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) != 2) {
        break;
      }
      if (paramBundle == null)
      {
        ad.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
        parama = new com.tencent.mm.ui.chatting.m.c(faA().getTalkerUserName(), this.GGI, j);
        break;
      }
      i = paramBundle.getInt("MSG_POSITION");
      k = j - i;
      ad.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      parama = new com.tencent.mm.ui.chatting.m.c(faA().getTalkerUserName(), k, j);
      break;
      label744:
      i = 0;
    }
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bl> paramd)
  {
    AppMethodBeat.i(36673);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.GFc;
    Object localObject = paramd.GFf;
    int j = paramd.GFd.size();
    int k = paramd.fwP;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.GFb;
    bl localbl = (bl)((SparseArray)localObject).get(0);
    localObject = (bl)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localbl != null) {
      this.GGY = localbl.field_createTime;
    }
    if (localObject != null) {
      this.GGZ = ((du)localObject).field_createTime;
    }
    switch (2.GGj[locala.ordinal()])
    {
    case 3: 
    default: 
      if (locala != d.a.GEX)
      {
        ad.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.GGY), Long.valueOf(this.GGZ), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
        paramd = faA().getTalkerUserName();
        long l = ((k)g.ab(k.class)).aqo().age(paramd);
        az.arV();
        i = com.tencent.mm.model.c.apO().E(paramd, 0L, l);
        ad.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(i) });
        if (k - i > j) {
          break label508;
        }
      }
      break;
    }
    label508:
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      AppMethodBeat.o(36673);
      return;
      paramMMChattingListView.vL(false);
      int m = paramMMChattingListView.getCurCount();
      int n = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), m - n + 1, faB() + paramMMChattingListView.getTopHeight(), false);
      m = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (m <= 0) {
        break;
      }
      ((i)faA().be(i.class)).YG(m);
      break;
      paramMMChattingListView.vM(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - faB() - paramMMChattingListView.getBottomHeight(), false);
      break;
      faA().wc(false);
      break;
      i = localBundle.getInt("MSG_POSITION");
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.fwP - i));
      paramd.selection = i;
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36670);
          Object localObject = (i)d.this.faA().be(i.class);
          if (localBundle.getInt("SCENE", 0) == 1)
          {
            d.this.Zy(i);
            AppMethodBeat.o(36670);
            return;
          }
          if (localBundle.getInt("SCENE", 0) == 2)
          {
            ((i)localObject).YF(i);
            localObject = d.this.faA();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.d.a)localObject).ca(((Integer)locala.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingNormalDataPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(36670);
        }
      });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.d
 * JD-Core Version:    0.7.0.1
 */