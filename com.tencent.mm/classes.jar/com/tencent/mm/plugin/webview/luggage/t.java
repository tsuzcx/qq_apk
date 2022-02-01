package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.j;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

public class t
  extends i
{
  com.tencent.mm.plugin.webview.modeltools.a DQm;
  
  public t(final Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(78469);
    this.chq = com.tencent.mm.plugin.webview.luggage.d.a.class;
    this.cht.A(bs.ccP());
    this.DQm = new com.tencent.mm.plugin.webview.modeltools.a();
    this.chy.Cg().a(new e.c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78468);
        boolean bool = t.this.DQm.c(paramActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(78468);
        return bool;
      }
    });
    AppMethodBeat.o(78469);
  }
  
  private void ePI()
  {
    AppMethodBeat.i(78471);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.chy.Cd().size() <= 1)
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
  
  public final void Cb()
  {
    AppMethodBeat.i(78472);
    ((g)BW()).ePa();
    ePI();
    AppMethodBeat.o(78472);
  }
  
  public final void Cc()
  {
    AppMethodBeat.i(78473);
    ePI();
    AppMethodBeat.o(78473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(78470);
    super.onResume();
    ePI();
    AppMethodBeat.o(78470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */