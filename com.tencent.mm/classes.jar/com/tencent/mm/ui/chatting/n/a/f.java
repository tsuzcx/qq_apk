package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class f
  extends a
{
  private boolean KtC;
  private Runnable KtD;
  private volatile long Kty;
  private volatile long Ktz;
  private volatile long tIv;
  private String talker;
  
  public f(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.ui.chatting.h.d paramd)
  {
    super(parama, paramd);
    AppMethodBeat.i(36677);
    this.Kty = 0L;
    this.Ktz = 0L;
    this.tIv = 0L;
    this.talker = fif().getTalkerUserName();
    ae.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
    AppMethodBeat.o(36677);
  }
  
  private int fLw()
  {
    AppMethodBeat.i(36680);
    int i = ((y)fif().bh(y.class)).fIn();
    AppMethodBeat.o(36680);
    return i;
  }
  
  protected final e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    AppMethodBeat.i(36678);
    int i;
    int j;
    long l;
    switch (2.KsJ[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        ae.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.Kty), Long.valueOf(this.Ktz), Long.valueOf(this.tIv), Integer.valueOf(j), Integer.valueOf(i) });
        parama = new com.tencent.mm.ui.chatting.n.d(fif().getTalkerUserName(), this.Kty, this.Ktz);
        AppMethodBeat.o(36678);
        return parama;
        if (paramBundle == null)
        {
          ae.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          this.KtC = paramBundle.getBoolean("IS_LOAD_ALL", false);
          bc.aCg();
          paramBundle = c.azI().ys(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          ae.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.Kty) || (l > this.Ktz))
      {
        this.Kty = l;
        this.tIv = ((l)g.ab(l.class)).doJ().arv(this.talker);
        if (this.KtC)
        {
          this.Ktz = this.tIv;
          label311:
          bc.aCg();
          i = c.azI().D(this.talker, this.Kty, this.Ktz);
          ae.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label799;
          }
          ae.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.Kty), Integer.valueOf(0) });
          bc.aCg();
          this.Kty = c.azI().i(this.talker, this.Kty, 48);
          bc.aCg();
          i = c.azI().D(this.talker, this.Kty, l);
        }
      }
      break;
    }
    for (;;)
    {
      paramd.selection = i;
      i = 0;
      j = 0;
      break;
      bc.aCg();
      this.Ktz = c.azI().j(this.talker, l, 48);
      break label311;
      bc.aCg();
      i = c.azI().D(this.talker, this.Kty, l);
      continue;
      bc.aCg();
      l = c.azI().i(this.talker, this.Kty, 48);
      bc.aCg();
      j = Math.max(0, c.azI().D(this.talker, l, this.Kty) - 1);
      this.Kty = l;
      i = 0;
      break;
      bc.aCg();
      l = c.azI().j(this.talker, this.Ktz, 48);
      bc.aCg();
      i = Math.max(0, c.azI().D(this.talker, this.Ktz, l) - 1);
      this.Ktz = l;
      j = 0;
      break;
      paramBundle = ((l)g.ab(l.class)).doJ().arc(this.talker);
      this.tIv = paramBundle.field_createTime;
      bc.aCg();
      i = Math.max(0, c.azI().D(this.talker, this.Ktz, this.tIv) - 1);
      if ((this.KtC) || (i <= 480)) {}
      for (this.Ktz = this.tIv;; this.Ktz = this.tIv)
      {
        do
        {
          j = 0;
          break;
        } while ((paramBundle.field_isSend != 1) || (this.tIv == paramBundle.field_createTime));
        this.tIv = paramBundle.field_createTime;
        bc.aCg();
        this.Kty = c.azI().i(this.talker, this.Kty, 48);
      }
      label799:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<bv> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(36679);
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.KrD;
    final int i = paramd.selection;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.KsJ[localObject.ordinal()])
    {
    default: 
      if (fif().getLastVisiblePosition() == paramd.KrF - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((l)g.ab(l.class)).doJ().aru(this.talker);
      ae.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.Kty) });
      if (this.Kty <= l)
      {
        bool1 = true;
        label167:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.Ktz < this.tIv) {
          break label426;
        }
      }
      break;
    }
    label426:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMMChattingListView.setIsBottomShowAll(bool1);
      AppMethodBeat.o(36679);
      return;
      paramMMChattingListView.xI(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), i - j + 1, fLw() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((k)fif().bh(k.class)).adK(i);
      break;
      paramMMChattingListView.xJ(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fLw() - paramMMChattingListView.getBottomHeight(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = fif().Kkd.getBooleanExtra("need_hight_item", false).booleanValue();
      aeN(i);
      if (!bool1) {
        break;
      }
      fif().Kkd.getLongExtra("msg_local_id", -1L);
      ae.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      ar.ay(this.KtD);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36675);
          int i = Math.max(0, i - f.this.fif().getFirstVisiblePosition());
          f.this.aeN(i);
          paramMMChattingListView.setHighLightChild(i);
          bc.aCg();
          c.ajA().set(am.a.IOx, Boolean.FALSE);
          AppMethodBeat.o(36675);
        }
      };
      this.KtD = ((Runnable)localObject);
      ar.o((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.f
 * JD-Core Version:    0.7.0.1
 */