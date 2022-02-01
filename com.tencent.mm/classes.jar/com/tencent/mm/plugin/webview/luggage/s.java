package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.g;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

public class s
  extends com.tencent.luggage.d.f
{
  private com.tencent.mm.plugin.webview.modeltools.a AUE;
  
  public s(final Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(78469);
    this.cad = com.tencent.mm.plugin.webview.luggage.d.a.class;
    this.cag.J(bp.bQW());
    this.AUE = new com.tencent.mm.plugin.webview.modeltools.a();
    this.cal.Bd().a(new e.b()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78468);
        boolean bool = com.tencent.mm.plugin.webview.modeltools.a.c(paramActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(78468);
        return bool;
      }
    });
    AppMethodBeat.o(78469);
  }
  
  private void elu()
  {
    AppMethodBeat.i(78471);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.cal.Ba().size() <= 1)
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
  
  public final void AY()
  {
    AppMethodBeat.i(78472);
    ((f)AT()).ekP();
    elu();
    AppMethodBeat.o(78472);
  }
  
  public final void AZ()
  {
    AppMethodBeat.i(78473);
    elu();
    AppMethodBeat.o(78473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(78470);
    super.onResume();
    elu();
    AppMethodBeat.o(78470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */