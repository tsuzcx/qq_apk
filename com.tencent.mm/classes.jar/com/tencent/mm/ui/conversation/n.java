package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class n
{
  ListView KOd;
  i KPs;
  boolean KTJ;
  private aq KTK;
  private Runnable KTL;
  int KTM;
  e fPf;
  
  public n()
  {
    AppMethodBeat.i(38706);
    this.KTJ = false;
    this.KTM = -1;
    this.fPf = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(188159);
        paramAnonymousAbsListView = d.KOJ;
        d.a(n.this.KOd, n.this.KPs, true, true);
        AppMethodBeat.o(188159);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.ci.d.fyy().gC(MainUI.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (n.this.KOd == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          n.a(n.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        n.this.fNM();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void fNM()
  {
    AppMethodBeat.i(38707);
    if (!this.KTJ)
    {
      ae.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.KTJ = true;
    }
    if ((this.KTK != null) && (this.KTL != null)) {
      this.KTK.removeCallbacks(this.KTL);
    }
    if (this.KTK != null)
    {
      this.KTK.quit();
      this.KTK = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */