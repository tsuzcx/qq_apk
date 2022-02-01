package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.j;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

public class w
  extends i
{
  com.tencent.mm.plugin.webview.modeltools.a WHU;
  
  public w(final Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(78469);
    X(com.tencent.mm.plugin.webview.luggage.d.a.class);
    this.ejl.aZ(bx.fEv());
    this.WHU = new com.tencent.mm.plugin.webview.modeltools.a();
    this.ejq.aoy().a(new e.c()
    {
      public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78468);
        boolean bool = w.this.WHU.d(paramActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(78468);
        return bool;
      }
    });
    AppMethodBeat.o(78469);
  }
  
  private void iuM()
  {
    AppMethodBeat.i(78471);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.ejq.aov().size() <= 1)
        {
          localSwipeBackLayout.setEnableGesture(true);
          AppMethodBeat.o(78471);
          return;
        }
        localSwipeBackLayout.setEnableGesture(false);
      }
    }
    AppMethodBeat.o(78471);
  }
  
  public final void aoq()
  {
    AppMethodBeat.i(78472);
    ((g)aol()).iua();
    iuM();
    AppMethodBeat.o(78472);
  }
  
  public final void aor()
  {
    AppMethodBeat.i(78473);
    iuM();
    AppMethodBeat.o(78473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(78470);
    super.onResume();
    iuM();
    AppMethodBeat.o(78470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.w
 * JD-Core Version:    0.7.0.1
 */