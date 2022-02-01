package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.k.f;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class h
  extends a
{
  private volatile long Hwp;
  private int aeKa;
  private volatile long aeKk;
  private volatile long aeKl;
  private String talker;
  
  public h(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(254097);
    this.aeKa = 0;
    this.aeKk = 0L;
    this.aeKl = 0L;
    this.Hwp = 0L;
    this.talker = iNh().aezO.getStringExtra("key_notify_message_real_username");
    Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[ChattingSingleNotifyMsgPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(254097);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(254104);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(254104);
    return i;
  }
  
  protected final g a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(254110);
    bh.bCz();
    int j = com.tencent.mm.model.c.getNotifyMessageRecordStorage().Hp(this.talker);
    switch (2.aeJk[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    int i;
    boolean bool;
    for (;;)
    {
      this.aeKa = j;
      AppMethodBeat.o(254110);
      return parama;
      parama = new f(this.talker, 16, j);
      continue;
      parama = new f(this.talker, jxa() + 48, j);
      continue;
      i = this.aeKa;
      parama = this.talker;
      int k = jxa();
      parama = new f(parama, Math.max(j - i, 0) + k, j);
      continue;
      if (paramBundle == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "null == sourceArgs!");
        AppMethodBeat.o(254110);
        return null;
      }
      parama = localObject;
      if (paramBundle.getInt("SCENE", 0) == 1)
      {
        Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[handlePositionForSearch]");
        if (paramBundle == null)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[handleEnter] sourceArgs is null!");
          parama = new f(this.talker, this.aeKk, this.aeKl);
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
          bh.bCz();
          parama = com.tencent.mm.model.c.bzD().sl(l);
          if ((parama != null) && (parama.field_msgId == l)) {
            break;
          }
          Log.w("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          parama = new f(this.talker, this.aeKk, this.aeKl);
        }
      }
    }
    long l = parama.getCreateTime();
    if ((l < this.aeKk) || (l > this.aeKl))
    {
      this.aeKk = l;
      bh.bCz();
      this.Hwp = com.tencent.mm.model.c.getNotifyMessageRecordStorage().Hq(this.talker);
      if (bool)
      {
        this.aeKl = this.Hwp;
        label392:
        bh.bCz();
        i = com.tencent.mm.model.c.getNotifyMessageRecordStorage().k(this.talker, this.aeKk, this.aeKl);
        Log.v("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 48) {
          break label601;
        }
        Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.aeKk), Integer.valueOf(0) });
        bh.bCz();
        this.aeKk = com.tencent.mm.model.c.getNotifyMessageRecordStorage().v(this.talker, this.aeKk);
        bh.bCz();
        i = com.tencent.mm.model.c.getNotifyMessageRecordStorage().k(this.talker, this.aeKk, l);
      }
    }
    for (;;)
    {
      paramd.selection = i;
      parama = new f(this.talker, this.aeKk, this.aeKl);
      break;
      bh.bCz();
      this.aeKl = com.tencent.mm.model.c.getNotifyMessageRecordStorage().w(this.talker, l);
      break label392;
      bh.bCz();
      i = com.tencent.mm.model.c.getNotifyMessageRecordStorage().k(this.talker, this.aeKk, l);
      continue;
      label601:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    AppMethodBeat.i(254117);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.aeHY;
    Object localObject = paramd.aeIb;
    int k = paramd.aeHZ.size();
    int m = paramd.lNX;
    final int i = paramd.selection;
    final Bundle localBundle = paramd.aeHX;
    cc localcc = (cc)((SparseArray)localObject).get(0);
    localObject = (cc)((SparseArray)localObject).get(((SparseArray)localObject).size() - 1);
    if (localcc != null) {
      this.aeKk = localcc.getCreateTime();
    }
    if (localObject != null) {
      this.aeKl = ((cc)localObject).getCreateTime();
    }
    int j = i;
    boolean bool;
    switch (2.aeJk[locala.ordinal()])
    {
    default: 
      j = i;
    case 3: 
    case 2: 
    case 5: 
    case 1: 
      for (;;)
      {
        if (locala != d.a.aeHT)
        {
          Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", new Object[] { locala, Long.valueOf(this.aeKk), Long.valueOf(this.aeKl), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          bh.bCz();
          i = com.tencent.mm.model.c.getNotifyMessageRecordStorage().k(this.talker, 0L, 0L);
          Log.i("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { this.talker, Long.valueOf(0L), Integer.valueOf(i) });
          if (m - i > k) {
            break;
          }
          bool = true;
          label289:
          paramMMChattingListView.setIsTopShowAll(bool);
          paramMMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(254117);
        return;
        paramMMChattingListView.LB(false);
        j = paramMMChattingListView.getCurCount();
        int n = paramMMChattingListView.getPreCount();
        q.a(paramMMChattingListView.getListView(), j - n + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
        n = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
        j = i;
        if (n > 0)
        {
          ((m)iNh().cm(m.class)).aBX(n);
          j = i;
          continue;
          paramMMChattingListView.LC(false);
          q.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - jxd() - paramMMChattingListView.getBottomHeight(), false, false);
          j = i;
          continue;
          iNh().Mf(false);
          j = i;
        }
      }
    }
    if (localBundle == null)
    {
      j = -1;
      label458:
      if (j == -1) {
        break label532;
      }
      i = Math.max(0, paramMMChattingListView.getCurCount() - (paramd.lNX - j));
      paramd.selection = i;
    }
    label532:
    for (;;)
    {
      paramMMChattingListView.getListView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254089);
          Object localObject = (m)h.this.iNh().cm(m.class);
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 1))
          {
            boolean bool1 = localBundle.getBoolean("IS_IDLE_VISBLE", false);
            int i = localBundle.getInt("SELECTION_TOP_OFFSET", 0);
            boolean bool2 = localBundle.getBoolean("IS_SMOOTH_SCROLL", false);
            h.this.iNh().aezR = i;
            h.this.b(i, bool1, i, bool2);
            if ((i >= 0) && (h.this.iNh().aezO.getBooleanExtra("need_hight_item", false).booleanValue()))
            {
              h.this.iNh().aezO.getLongExtra("msg_local_id", -1L);
              h.this.a(paramMMChattingListView, i, false, i, false);
            }
            AppMethodBeat.o(254089);
            return;
          }
          if ((localBundle != null) && (localBundle.getInt("SCENE", 0) == 2))
          {
            ((m)localObject).aBW(i);
            localObject = h.this.iNh();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((com.tencent.mm.ui.chatting.d.a)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/source/presenter/ChattingSingleNotifyMsgPresenter$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(254089);
        }
      });
      j = i;
      break;
      j = localBundle.getInt("MSG_POSITION", -1);
      break label458;
      bool = false;
      break label289;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.h
 * JD-Core Version:    0.7.0.1
 */