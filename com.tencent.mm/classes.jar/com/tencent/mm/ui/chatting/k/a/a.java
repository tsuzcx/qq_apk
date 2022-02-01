package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.c;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public abstract class a
  implements b.a
{
  private long aeJA;
  public d aeJO;
  private int aeJP;
  private int aeJQ;
  private long aeJR;
  private long aeJS;
  int aeJT = 3;
  private Runnable aeJU;
  private long aeJz;
  protected com.tencent.mm.ui.chatting.d.a hlc;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    this.hlc = parama;
    this.aeJO = paramd;
  }
  
  protected abstract com.tencent.mm.ui.chatting.k.g a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    org.xwalk.core.Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.hlc.getTalkerUserName());
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      org.xwalk.core.Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    com.tencent.mm.plugin.report.service.g.ahw(13);
    ((m)this.hlc.cm(m.class)).jqq();
    this.aeJO.a(parama, paramBoolean, new d.c()
    {
      public final com.tencent.mm.ui.chatting.k.g b(d.d<cc> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.aeHX = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<cc> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.a(a.this, paramAnonymousd.lNX);
        a.b(a.this, paramAnonymousd.aeIa);
        if (paramAnonymousd.aeHZ.size() > 0)
        {
          cc localcc = (cc)paramAnonymousd.aeHZ.get(0);
          if (localcc != null)
          {
            a.a(a.this, localcc.getCreateTime());
            a.b(a.this, localcc.field_msgSeq);
          }
          paramAnonymousd = (cc)paramAnonymousd.aeHZ.get(paramAnonymousd.aeHZ.size() - 1);
          if (paramAnonymousd != null)
          {
            a.c(a.this, paramAnonymousd.getCreateTime());
            a.d(a.this, paramAnonymousd.field_msgSeq);
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  protected final void a(final MMChattingListView paramMMChattingListView, final int paramInt1, final boolean paramBoolean1, final int paramInt2, final boolean paramBoolean2)
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(paramInt1) });
    MMHandlerThread.removeRunnable(this.aeJU);
    paramMMChattingListView = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254112);
        int i = Math.max(0, paramInt1 - a.this.iNh().getFirstVisiblePosition());
        a.this.b(paramInt1, paramBoolean1, paramInt2, paramBoolean2);
        paramMMChattingListView.setHighLightChildNew(i);
        bh.bCz();
        c.ban().set(at.a.acLT, Boolean.FALSE);
        AppMethodBeat.o(254112);
      }
    };
    this.aeJU = paramMMChattingListView;
    MMHandlerThread.postToMainThreadDelayed(paramMMChattingListView, 300L);
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    com.tencent.mm.plugin.report.service.g.ahx(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((m)this.hlc.cm(m.class)).jqr();
    if (paramd.aeHY == d.a.aeHS) {
      this.hlc.aezO.gDP();
    }
  }
  
  protected final void b(final int paramInt1, final boolean paramBoolean1, final int paramInt2, final boolean paramBoolean2)
  {
    this.aeJT = 3;
    if (!this.hlc.aezS) {
      this.hlc.b(paramInt1, paramBoolean2, paramBoolean1, paramInt2);
    }
    for (;;)
    {
      this.hlc.getListView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36656);
          if ((a.this.iNh().getFirstVisiblePosition() > paramInt1) || (paramInt1 > a.this.iNh().getLastVisiblePosition()))
          {
            org.xwalk.core.Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt1 + " reTryCount:" + a.this.aeJT);
            if (!a.this.hlc.aezS) {
              a.this.iNh().h(paramInt1, paramInt2, paramBoolean2, paramBoolean1);
            }
            for (;;)
            {
              a locala = a.this;
              locala.aeJT -= 1;
              if (a.this.aeJT < 0) {
                break;
              }
              a.this.iNh().getListView().postDelayed(this, 20L);
              AppMethodBeat.o(36656);
              return;
              a.this.iNh().h(paramInt1, com.tencent.mm.cd.a.fromDPToPix(a.this.hlc.aezO.getContext(), 120), paramBoolean2, paramBoolean1);
            }
          }
          org.xwalk.core.Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt1);
          AppMethodBeat.o(36656);
        }
      }, 200L);
      return;
      com.tencent.mm.ui.chatting.d.a locala = this.hlc;
      locala.h(paramInt1, com.tencent.mm.cd.a.fromDPToPix(locala.aezO.getContext(), 120), paramBoolean2, paramBoolean1);
    }
  }
  
  public final com.tencent.mm.ui.chatting.d.a iNh()
  {
    return this.hlc;
  }
  
  public final long jwZ()
  {
    return this.aeJR;
  }
  
  public final int jxa()
  {
    return this.aeJQ;
  }
  
  public final long jxb()
  {
    return this.aeJA;
  }
  
  public final long jxc()
  {
    return this.aeJz;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a
 * JD-Core Version:    0.7.0.1
 */