package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.l.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import org.xwalk.core.Log;

public abstract class a
  implements b.a
{
  com.tencent.mm.ui.chatting.d.a caz;
  long zPU;
  long zPV;
  public d zQi;
  int zQj;
  int zQk;
  long zQl;
  long zQm;
  int zQn = 3;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, d paramd)
  {
    this.caz = parama;
    this.zQi = paramd;
  }
  
  protected final void Qp(final int paramInt)
  {
    this.zQn = 3;
    this.caz.Pu(paramInt);
    this.caz.getListView().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32715);
        if ((a.this.caz.getFirstVisiblePosition() > paramInt) || (paramInt > a.this.caz.getLastVisiblePosition()))
        {
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + paramInt + " reTryCount:" + a.this.zQn);
          a.this.caz.hF(paramInt, 0);
          a locala = a.this;
          locala.zQn -= 1;
          if (a.this.zQn >= 0)
          {
            a.this.caz.getListView().postDelayed(this, 20L);
            AppMethodBeat.o(32715);
          }
        }
        else
        {
          Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + paramInt);
        }
        AppMethodBeat.o(32715);
      }
    }, 200L);
  }
  
  protected abstract e a(d.a parama, Bundle paramBundle, d.d paramd);
  
  public void a(d.a parama, boolean paramBoolean, Bundle paramBundle)
  {
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + parama + " isBlock:" + paramBoolean + " username:" + this.caz.getTalkerUserName());
    if (bo.isNullOrNil(this.caz.getTalkerUserName()))
    {
      Log.w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
      return;
    }
    g.Cx(13);
    ((h)this.caz.ay(h.class)).dHd();
    this.zQi.a(parama, paramBoolean, new a.1(this, paramBundle, parama));
  }
  
  public void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    g.Cy(13);
    paramMMChattingListView.getBaseAdapter().notifyDataSetChanged();
    ((h)this.caz.ay(h.class)).dHe();
    if (paramd.zOE == d.a.zOy) {
      this.caz.zJz.cdy();
    }
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.a
 * JD-Core Version:    0.7.0.1
 */