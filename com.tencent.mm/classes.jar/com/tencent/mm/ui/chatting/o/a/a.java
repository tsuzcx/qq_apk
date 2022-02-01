package com.tencent.mm.ui.chatting.o.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.c;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  private long WZV;
  private long WZW;
  public d Xaj;
  private int Xak;
  private int Xal;
  private long Xam;
  private long Xan;
  int Xao = 3;
  protected com.tencent.mm.ui.chatting.e.a fgR;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, d paramd)
  {
    this.fgR = parama;
    this.Xaj = paramd;
  }
  
  protected abstract com.tencent.mm.ui.chatting.o.g a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.fgR.getTalkerUserName());
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    com.tencent.mm.plugin.report.service.g.ada(13);
    ((k)this.fgR.bC(k.class)).hNJ();
    this.Xaj.a(parama, paramBoolean, new d.c()
    {
      public final com.tencent.mm.ui.chatting.o.g b(d.d<ca> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.WYx = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<ca> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.a(a.this, paramAnonymousd.jlf);
        a.b(a.this, paramAnonymousd.WYA);
        if (paramAnonymousd.WYz.size() > 0)
        {
          ca localca = (ca)paramAnonymousd.WYz.get(0);
          if (localca != null)
          {
            a.a(a.this, localca.field_createTime);
            a.b(a.this, localca.field_msgSeq);
          }
          paramAnonymousd = (ca)paramAnonymousd.WYz.get(paramAnonymousd.WYz.size() - 1);
          if (paramAnonymousd != null)
          {
            a.c(a.this, paramAnonymousd.field_createTime);
            a.d(a.this, paramAnonymousd.field_msgSeq);
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    com.tencent.mm.plugin.report.service.g.adb(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((k)this.fgR.bC(k.class)).hNK();
    if (paramd.WYy == d.a.WYs) {
      this.fgR.WQv.fsh();
    }
  }
  
  protected final void awC(final int paramInt)
  {
    this.Xao = 3;
    if (!this.fgR.WQz) {
      this.fgR.avn(paramInt);
    }
    for (;;)
    {
      this.fgR.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36656);
          if ((a.this.hmp().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.hmp().getLastVisiblePosition()))
          {
            Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.Xao);
            if (!a.this.fgR.WQz) {
              a.this.hmp().my(paramInt, 0);
            }
            for (;;)
            {
              a locala = a.this;
              locala.Xao -= 1;
              if (a.this.Xao < 0) {
                break;
              }
              a.this.hmp().getListView().postDelayed(this, 20L);
              AppMethodBeat.o(36656);
              return;
              a.this.hmp().my(paramInt, com.tencent.mm.ci.a.fromDPToPix(a.this.fgR.WQv.getContext(), 80));
            }
          }
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
          AppMethodBeat.o(36656);
        }
      }, 200L);
      return;
      com.tencent.mm.ui.chatting.e.a locala = this.fgR;
      locala.my(paramInt, com.tencent.mm.ci.a.fromDPToPix(locala.WQv.getContext(), 80));
    }
  }
  
  public final long hTA()
  {
    return this.WZV;
  }
  
  public final long hTx()
  {
    return this.Xam;
  }
  
  public final int hTy()
  {
    return this.Xal;
  }
  
  public final long hTz()
  {
    return this.WZW;
  }
  
  public final com.tencent.mm.ui.chatting.e.a hmp()
  {
    return this.fgR;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a.a
 * JD-Core Version:    0.7.0.1
 */