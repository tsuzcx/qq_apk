package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.g.b.a;
import com.tencent.mm.ui.chatting.g.d;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.c;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.m.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  public d IgC;
  int IgD;
  int IgE;
  long IgF;
  long IgG;
  int IgH = 3;
  long Igp;
  long Igq;
  protected com.tencent.mm.ui.chatting.d.a cLy;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    this.cLy = parama;
    this.IgC = paramd;
  }
  
  protected abstract e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.cLy.getTalkerUserName());
    if (bs.isNullOrNil(this.cLy.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    g.MH(13);
    ((i)this.cLy.bf(i.class)).flW();
    this.IgC.a(parama, paramBoolean, new d.c()
    {
      public final e b(d.d<bo> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.IeX = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<bo> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.this.IgD = paramAnonymousd.fAw;
        a.this.IgE = paramAnonymousd.Ifa;
        if (paramAnonymousd.IeZ.size() > 0)
        {
          bo localbo = (bo)paramAnonymousd.IeZ.get(0);
          if (localbo != null)
          {
            a.this.Igp = localbo.field_createTime;
            a.this.IgG = localbo.field_msgSeq;
          }
          paramAnonymousd = (bo)paramAnonymousd.IeZ.get(paramAnonymousd.IeZ.size() - 1);
          if (paramAnonymousd != null)
          {
            a.this.Igq = paramAnonymousd.field_createTime;
            a.this.IgF = paramAnonymousd.field_msgSeq;
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bo> paramd)
  {
    g.MI(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((i)this.cLy.bf(i.class)).flX();
    if (paramd.IeY == d.a.IeS) {
      this.cLy.HZF.dry();
    }
  }
  
  protected final void abK(final int paramInt)
  {
    this.IgH = 3;
    this.cLy.aaK(paramInt);
    this.cLy.getListView().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36656);
        if ((a.this.fqq().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.fqq().getLastVisiblePosition()))
        {
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.IgH);
          a.this.fqq().jF(paramInt, 0);
          a locala = a.this;
          locala.IgH -= 1;
          if (a.this.IgH >= 0)
          {
            a.this.fqq().getListView().postDelayed(this, 20L);
            AppMethodBeat.o(36656);
          }
        }
        else
        {
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
        }
        AppMethodBeat.o(36656);
      }
    }, 200L);
  }
  
  public final com.tencent.mm.ui.chatting.d.a fqq()
  {
    return this.cLy;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.a
 * JD-Core Version:    0.7.0.1
 */