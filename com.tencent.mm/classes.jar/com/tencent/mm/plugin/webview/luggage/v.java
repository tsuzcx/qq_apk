package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.j;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

public class v
  extends i
{
  com.tencent.mm.plugin.webview.modeltools.a PRx;
  
  public v(final Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(78469);
    O(com.tencent.mm.plugin.webview.luggage.d.a.class);
    this.crt.B(bt.ewB());
    this.PRx = new com.tencent.mm.plugin.webview.modeltools.a();
    this.cry.Oq().a(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78468);
        boolean bool = v.this.PRx.c(paramActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(78468);
        return bool;
      }
    });
    AppMethodBeat.o(78469);
  }
  
  private void gVb()
  {
    AppMethodBeat.i(78471);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.cry.On().size() <= 1)
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
  
  public final void Oi()
  {
    AppMethodBeat.i(78472);
    ((g)Od()).gUs();
    gVb();
    AppMethodBeat.o(78472);
  }
  
  public final void Oj()
  {
    AppMethodBeat.i(78473);
    gVb();
    AppMethodBeat.o(78473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(78470);
    super.onResume();
    gVb();
    AppMethodBeat.o(78470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.v
 * JD-Core Version:    0.7.0.1
 */