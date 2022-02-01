package com.tencent.mm.ui.chatting.m.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  public d GGG;
  int GGH;
  int GGI;
  long GGJ;
  long GGK;
  int GGL = 3;
  long GGt;
  long GGu;
  protected com.tencent.mm.ui.chatting.d.a cOd;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    this.cOd = parama;
    this.GGG = paramd;
  }
  
  protected final void Zy(final int paramInt)
  {
    this.GGL = 3;
    this.cOd.Yz(paramInt);
    this.cOd.getListView().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36656);
        if ((a.this.faA().getFirstVisiblePosition() > paramInt) || (paramInt > a.this.faA().getLastVisiblePosition()))
        {
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.GGL);
          a.this.faA().jt(paramInt, 0);
          a locala = a.this;
          locala.GGL -= 1;
          if (a.this.GGL >= 0)
          {
            a.this.faA().getListView().postDelayed(this, 20L);
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
  
  protected abstract e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(final d.a parama, boolean paramBoolean, final Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.cOd.getTalkerUserName());
    if (bt.isNullOrNil(this.cOd.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    g.KI(13);
    ((i)this.cOd.be(i.class)).eWk();
    this.GGG.a(parama, paramBoolean, new d.c()
    {
      public final e b(d.d<bl> paramAnonymousd)
      {
        AppMethodBeat.i(36654);
        paramAnonymousd.GFb = paramBundle;
        paramAnonymousd = a.this.a(parama, paramBundle, paramAnonymousd);
        AppMethodBeat.o(36654);
        return paramAnonymousd;
      }
      
      public final void c(d.d<bl> paramAnonymousd)
      {
        AppMethodBeat.i(36655);
        a.this.GGH = paramAnonymousd.fwP;
        a.this.GGI = paramAnonymousd.GFe;
        if (paramAnonymousd.GFd.size() > 0)
        {
          bl localbl = (bl)paramAnonymousd.GFd.get(0);
          if (localbl != null)
          {
            a.this.GGt = localbl.field_createTime;
            a.this.GGK = localbl.field_msgSeq;
          }
          paramAnonymousd = (bl)paramAnonymousd.GFd.get(paramAnonymousd.GFd.size() - 1);
          if (paramAnonymousd != null)
          {
            a.this.GGu = paramAnonymousd.field_createTime;
            a.this.GGJ = paramAnonymousd.field_msgSeq;
          }
        }
        AppMethodBeat.o(36655);
      }
    });
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bl> paramd)
  {
    g.KJ(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((i)this.cOd.be(i.class)).eWl();
    if (paramd.GFc == d.a.GEW) {
      this.cOd.GzJ.ddQ();
    }
  }
  
  public final com.tencent.mm.ui.chatting.d.a faA()
  {
    return this.cOd;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.a
 * JD-Core Version:    0.7.0.1
 */