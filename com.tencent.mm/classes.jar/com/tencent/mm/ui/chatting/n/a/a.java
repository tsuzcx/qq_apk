package com.tencent.mm.ui.chatting.n.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.c;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.n.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  int PFA = 3;
  long PFi;
  long PFj;
  public d PFv;
  int PFw;
  int PFx;
  long PFy;
  long PFz;
  protected com.tencent.mm.ui.chatting.e.a dom;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    this.dom = parama;
    this.PFv = paramd;
  }
  
  protected abstract f a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.dom.getTalkerUserName());
    if (Util.isNullOrNil(this.dom.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    g.Wl(13);
    ((k)this.dom.bh(k.class)).gOx();
    this.PFv.a(parama, paramBoolean, new d.c()
    {
      public final f b(d.d<ca> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.PDK = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<ca> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.this.PFw = paramAnonymousd.gAZ;
        a.this.PFx = paramAnonymousd.PDN;
        if (paramAnonymousd.PDM.size() > 0)
        {
          ca localca = (ca)paramAnonymousd.PDM.get(0);
          if (localca != null)
          {
            a.this.PFi = localca.field_createTime;
            a.this.PFz = localca.field_msgSeq;
          }
          paramAnonymousd = (ca)paramAnonymousd.PDM.get(paramAnonymousd.PDM.size() - 1);
          if (paramAnonymousd != null)
          {
            a.this.PFj = paramAnonymousd.field_createTime;
            a.this.PFy = paramAnonymousd.field_msgSeq;
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    g.Wm(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((k)this.dom.bh(k.class)).gOy();
    if (paramd.PDL == d.a.PDF) {
      this.dom.Pwc.eGg();
    }
  }
  
  protected final void any(final int paramInt)
  {
    this.PFA = 3;
    if (!this.dom.Pwg) {
      this.dom.amm(paramInt);
    }
    for (;;)
    {
      this.dom.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36656);
          if ((a.this.grq().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.grq().getLastVisiblePosition()))
          {
            Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.PFA);
            if (!a.this.dom.Pwg) {
              a.this.grq().lf(paramInt, 0);
            }
            for (;;)
            {
              a locala = a.this;
              locala.PFA -= 1;
              if (a.this.PFA < 0) {
                break;
              }
              a.this.grq().getListView().postDelayed(this, 20L);
              AppMethodBeat.o(36656);
              return;
              a.this.grq().lf(paramInt, com.tencent.mm.cb.a.fromDPToPix(a.this.dom.Pwc.getContext(), 80));
            }
          }
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
          AppMethodBeat.o(36656);
        }
      }, 200L);
      return;
      com.tencent.mm.ui.chatting.e.a locala = this.dom;
      locala.lf(paramInt, com.tencent.mm.cb.a.fromDPToPix(locala.Pwc.getContext(), 80));
    }
  }
  
  public final com.tencent.mm.ui.chatting.e.a grq()
  {
    return this.dom;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.a
 * JD-Core Version:    0.7.0.1
 */