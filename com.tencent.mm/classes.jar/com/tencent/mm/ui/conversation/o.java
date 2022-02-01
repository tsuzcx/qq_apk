package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class o
{
  j XAI;
  boolean XEb;
  private MMHandler XEc;
  private Runnable XEd;
  int XEe;
  ListView Xzq;
  e iYA;
  
  public o()
  {
    AppMethodBeat.i(38706);
    this.XEb = false;
    this.XEe = -1;
    this.iYA = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(285407);
        paramAnonymousAbsListView = d.XzX;
        d.a(o.this.Xzq, o.this.XAI, true, true);
        AppMethodBeat.o(285407);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(38703);
        if (paramAnonymousInt == 0)
        {
          if (o.this.Xzq == null)
          {
            AppMethodBeat.o(38703);
            return;
          }
          o.a(o.this, -1);
          AppMethodBeat.o(38703);
          return;
        }
        o.this.hWJ();
        AppMethodBeat.o(38703);
      }
    });
    AppMethodBeat.o(38706);
  }
  
  final void hWJ()
  {
    AppMethodBeat.i(38707);
    if (!this.XEb)
    {
      Log.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.XEb = true;
    }
    if ((this.XEc != null) && (this.XEd != null)) {
      this.XEc.removeCallbacks(this.XEd);
    }
    if (this.XEc != null)
    {
      this.XEc.quit();
      this.XEc = null;
    }
    AppMethodBeat.o(38707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.o
 * JD-Core Version:    0.7.0.1
 */