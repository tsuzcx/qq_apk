package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.c;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  long KsT;
  long KsU;
  public d Ktg;
  int Kth;
  int Kti;
  long Ktj;
  long Ktk;
  int Ktl = 3;
  protected com.tencent.mm.ui.chatting.e.a cXJ;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    this.cXJ = parama;
    this.Ktg = paramd;
  }
  
  protected abstract e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.cXJ.getTalkerUserName());
    if (bu.isNullOrNil(this.cXJ.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    f.OP(13);
    ((k)this.cXJ.bh(k.class)).fGr();
    this.Ktg.a(parama, paramBoolean, new d.c()
    {
      public final e b(d.d<bv> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.KrC = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<bv> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.this.Kth = paramAnonymousd.fVS;
        a.this.Kti = paramAnonymousd.KrF;
        if (paramAnonymousd.KrE.size() > 0)
        {
          bv localbv = (bv)paramAnonymousd.KrE.get(0);
          if (localbv != null)
          {
            a.this.KsT = localbv.field_createTime;
            a.this.Ktk = localbv.field_msgSeq;
          }
          paramAnonymousd = (bv)paramAnonymousd.KrE.get(paramAnonymousd.KrE.size() - 1);
          if (paramAnonymousd != null)
          {
            a.this.KsU = paramAnonymousd.field_createTime;
            a.this.Ktj = paramAnonymousd.field_msgSeq;
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bv> paramd)
  {
    f.OQ(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((k)this.cXJ.bh(k.class)).fGs();
    if (paramd.KrD == d.a.Krx) {
      this.cXJ.Kkd.dFr();
    }
  }
  
  protected final void aeN(final int paramInt)
  {
    this.Ktl = 3;
    if (!this.cXJ.Kkh) {
      this.cXJ.adC(paramInt);
    }
    for (;;)
    {
      this.cXJ.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36656);
          if ((a.this.fif().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.fif().getLastVisiblePosition()))
          {
            Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.Ktl);
            if (!a.this.cXJ.Kkh) {
              a.this.fif().jV(paramInt, 0);
            }
            for (;;)
            {
              a locala = a.this;
              locala.Ktl -= 1;
              if (a.this.Ktl < 0) {
                break;
              }
              a.this.fif().getListView().postDelayed(this, 20L);
              AppMethodBeat.o(36656);
              return;
              a.this.fif().jV(paramInt, com.tencent.mm.cb.a.fromDPToPix(a.this.cXJ.Kkd.getContext(), 80));
            }
          }
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
          AppMethodBeat.o(36656);
        }
      }, 200L);
      return;
      com.tencent.mm.ui.chatting.e.a locala = this.cXJ;
      locala.jV(paramInt, com.tencent.mm.cb.a.fromDPToPix(locala.Kkd.getContext(), 80));
    }
  }
  
  public final com.tencent.mm.ui.chatting.e.a fif()
  {
    return this.cXJ;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.a
 * JD-Core Version:    0.7.0.1
 */