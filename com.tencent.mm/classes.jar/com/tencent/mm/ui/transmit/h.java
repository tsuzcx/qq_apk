package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.q;

public final class h
{
  boolean QAD;
  a QAE;
  Context context;
  Runnable lNe;
  boolean nUP;
  boolean nUQ;
  boolean nUR;
  int nUS;
  String text;
  q tipDialog;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.QAD = false;
    this.lNe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (h.this.tipDialog != null) {
          h.this.tipDialog.dismiss();
        }
        h.this.bXo();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean rS()
  {
    return this.nUP & this.nUQ;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(234538);
    this.nUP = true;
    this.nUR = paramBoolean1;
    this.text = paramString;
    this.nUS = paramInt;
    this.QAD = paramBoolean2;
    if (rS())
    {
      bXo();
      AppMethodBeat.o(234538);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131765232), true, null);
      MMHandlerThread.postToMainThreadDelayed(this.lNe, 5000L);
    }
    AppMethodBeat.o(234538);
  }
  
  public final void bXo()
  {
    AppMethodBeat.i(39489);
    if (this.QAE != null) {
      this.QAE.e(this.nUR, this.text, this.QAD);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void gYw()
  {
    AppMethodBeat.i(234537);
    this.nUQ = true;
    if (rS())
    {
      MMHandlerThread.removeRunnable(this.lNe);
      bXo();
    }
    AppMethodBeat.o(234537);
  }
  
  static abstract interface a
  {
    public abstract void e(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.h
 * JD-Core Version:    0.7.0.1
 */