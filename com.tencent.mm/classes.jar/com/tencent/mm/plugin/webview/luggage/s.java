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
  private com.tencent.mm.plugin.webview.modeltools.a CmR;
  
  public s(final Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(78469);
    this.bXa = com.tencent.mm.plugin.webview.luggage.d.a.class;
    this.bXd.A(bp.bYl());
    this.CmR = new com.tencent.mm.plugin.webview.modeltools.a();
    this.bXi.AH().a(new e.b()
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
  
  private void eAQ()
  {
    AppMethodBeat.i(78471);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.bXi.AE().size() <= 1)
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
  
  public final void AC()
  {
    AppMethodBeat.i(78472);
    ((f)Ax()).eAl();
    eAQ();
    AppMethodBeat.o(78472);
  }
  
  public final void AD()
  {
    AppMethodBeat.i(78473);
    eAQ();
    AppMethodBeat.o(78473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(78470);
    super.onResume();
    eAQ();
    AppMethodBeat.o(78470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */