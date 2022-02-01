package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class n
{
  ListView KrJ;
  i KsY;
  boolean Kxp;
  private ap Kxq;
  private Runnable Kxr;
  int Kxs;
  e fMX;
  
  public n()
  {
    AppMethodBeat.i(38706);
    this.Kxp = false;
    this.Kxs = -1;
    this.fMX = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(194757);
        paramAnonymousAbsListView = d.Ksp;
        d.a(n.this.KrJ, n.this.KsY, true, true);
        AppMethodBeat.o(194757);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.cj.d.fux().gt(MainUI.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (n.this.KrJ == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          n.a(n.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        n.this.fJv();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void fJv()
  {
    AppMethodBeat.i(38707);
    if (!this.Kxp)
    {
      ad.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.Kxp = true;
    }
    if ((this.Kxq != null) && (this.Kxr != null)) {
      this.Kxq.removeCallbacks(this.Kxr);
    }
    if (this.Kxq != null)
    {
      this.Kxq.quit();
      this.Kxq = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */