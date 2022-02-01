package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class n
{
  ListView IAD;
  i IBS;
  boolean IGj;
  private ao IGk;
  private Runnable IGl;
  int IGm;
  com.tencent.mm.pluginsdk.ui.d ftW;
  
  public n()
  {
    AppMethodBeat.i(38706);
    this.IGj = false;
    this.IGm = -1;
    this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196908);
        paramAnonymousAbsListView = d.IBj;
        d.a(n.this.IAD, n.this.IBS, true, true);
        AppMethodBeat.o(196908);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.cj.d.feq().fW(MainUI.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (n.this.IAD == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          n.a(n.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        n.this.fsH();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void fsH()
  {
    AppMethodBeat.i(38707);
    if (!this.IGj)
    {
      ac.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.IGj = true;
    }
    if ((this.IGk != null) && (this.IGl != null)) {
      this.IGk.removeCallbacks(this.IGl);
    }
    if (this.IGk != null)
    {
      this.IGk.quit();
      this.IGk = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */