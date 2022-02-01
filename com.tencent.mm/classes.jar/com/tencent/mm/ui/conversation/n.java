package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class n
{
  i HaU;
  ListView Hal;
  boolean HfQ;
  private ap HfR;
  private Runnable HfS;
  int HfT;
  com.tencent.mm.pluginsdk.ui.d fqs;
  
  public n()
  {
    AppMethodBeat.i(38706);
    this.HfQ = false;
    this.HfT = -1;
    this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(191794);
        paramAnonymousAbsListView = d.HaQ;
        d.a(n.this.Hal, n.this.HaU, true, true);
        AppMethodBeat.o(191794);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.ck.d.eOM().fS(MainUI.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (n.this.Hal == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          n.a(n.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        n.this.fcM();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void fcM()
  {
    AppMethodBeat.i(38707);
    if (!this.HfQ)
    {
      ad.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.HfQ = true;
    }
    if ((this.HfR != null) && (this.HfS != null)) {
      this.HfR.removeCallbacks(this.HfS);
    }
    if (this.HfR != null)
    {
      this.HfR.quit();
      this.HfR = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */