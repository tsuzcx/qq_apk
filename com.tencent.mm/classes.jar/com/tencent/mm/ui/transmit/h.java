package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class h
{
  boolean afPN;
  a afPO;
  Context context;
  Runnable rNg;
  String text;
  w tipDialog;
  boolean ubY;
  boolean ubZ;
  boolean uca;
  int ucb;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.afPN = false;
    this.rNg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (h.this.tipDialog != null) {
          h.this.tipDialog.dismiss();
        }
        h.this.cLf();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean checkReady()
  {
    return this.ubY & this.ubZ;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(250920);
    this.ubY = true;
    this.uca = paramBoolean1;
    this.text = paramString;
    this.ucb = paramInt;
    this.afPN = paramBoolean2;
    if (checkReady())
    {
      cLf();
      AppMethodBeat.o(250920);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = k.a(this.context, this.context.getString(R.l.gUV), true, null);
      MMHandlerThread.postToMainThreadDelayed(this.rNg, 5000L);
    }
    AppMethodBeat.o(250920);
  }
  
  public final void cLf()
  {
    AppMethodBeat.i(39489);
    if (this.afPO != null) {
      this.afPO.g(this.uca, this.text, this.afPN);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void jEb()
  {
    AppMethodBeat.i(250916);
    this.ubZ = true;
    if (checkReady())
    {
      MMHandlerThread.removeRunnable(this.rNg);
      cLf();
    }
    AppMethodBeat.o(250916);
  }
  
  static abstract interface a
  {
    public abstract void g(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.h
 * JD-Core Version:    0.7.0.1
 */