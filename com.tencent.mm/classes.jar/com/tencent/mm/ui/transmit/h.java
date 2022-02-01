package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.s;

public final class h
{
  boolean XZc;
  a XZd;
  Context context;
  Runnable oJs;
  boolean qWp;
  boolean qWq;
  boolean qWr;
  int qWs;
  String text;
  s tipDialog;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.XZc = false;
    this.oJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (h.this.tipDialog != null) {
          h.this.tipDialog.dismiss();
        }
        h.this.cjT();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean pG()
  {
    return this.qWp & this.qWq;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(272893);
    this.qWp = true;
    this.qWr = paramBoolean1;
    this.text = paramString;
    this.qWs = paramInt;
    this.XZc = paramBoolean2;
    if (pG())
    {
      cjT();
      AppMethodBeat.o(272893);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.eSl), true, null);
      MMHandlerThread.postToMainThreadDelayed(this.oJs, 5000L);
    }
    AppMethodBeat.o(272893);
  }
  
  public final void cjT()
  {
    AppMethodBeat.i(39489);
    if (this.XZd != null) {
      this.XZd.e(this.qWr, this.text, this.XZc);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void hZj()
  {
    AppMethodBeat.i(272891);
    this.qWq = true;
    if (pG())
    {
      MMHandlerThread.removeRunnable(this.oJs);
      cjT();
    }
    AppMethodBeat.o(272891);
  }
  
  static abstract interface a
  {
    public abstract void e(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.h
 * JD-Core Version:    0.7.0.1
 */