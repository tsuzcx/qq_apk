package com.tencent.mm.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  boolean Jim;
  b.b Jin;
  String Jio;
  String mUrl;
  String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.Jim = false;
    this.Jin = null;
    this.Jio = "";
    this.Jin = paramb;
    setVisibility(8);
    refresh();
    AppMethodBeat.o(33849);
  }
  
  private void refresh()
  {
    AppMethodBeat.i(33850);
    setVisibility(8);
    h.LTJ.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221401);
        ba.aBQ().azQ();
        boolean bool = com.tencent.mm.model.b.b.a(a.this.Jin);
        h.LTJ.aP(new a.1.1(this, bool));
        AppMethodBeat.o(221401);
      }
    });
    AppMethodBeat.o(33850);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(33852);
    refresh();
    boolean bool = super.bAa();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493516;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(2131302449).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */