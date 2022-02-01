package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class n
{
  ListView Qbd;
  i Qct;
  boolean QgR;
  private MMHandler QgS;
  private Runnable QgT;
  int QgU;
  e gup;
  
  public n()
  {
    AppMethodBeat.i(38706);
    this.QgR = false;
    this.QgU = -1;
    this.gup = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(234253);
        paramAnonymousAbsListView = d.QbK;
        d.a(n.this.Qbd, n.this.Qct, true, true);
        AppMethodBeat.o(234253);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.ci.d.gGm().gV(MainUI.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (n.this.Qbd == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          n.a(n.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        n.this.gWg();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void gWg()
  {
    AppMethodBeat.i(38707);
    if (!this.QgR)
    {
      Log.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.QgR = true;
    }
    if ((this.QgS != null) && (this.QgT != null)) {
      this.QgS.removeCallbacks(this.QgT);
    }
    if (this.QgS != null)
    {
      this.QgS.quit();
      this.QgS = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */