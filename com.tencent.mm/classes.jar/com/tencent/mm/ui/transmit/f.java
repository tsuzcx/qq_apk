package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class f
{
  boolean IXS;
  a IXT;
  Context context;
  Runnable kkk;
  boolean mcF;
  boolean mcG;
  boolean mcH;
  int mcI;
  String text;
  p tipDialog;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.IXS = false;
    this.kkk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (f.this.tipDialog != null) {
          f.this.tipDialog.dismiss();
        }
        f.this.bvo();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean qr()
  {
    return this.mcF & this.mcG;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(196978);
    this.mcF = true;
    this.mcH = paramBoolean1;
    this.text = paramString;
    this.mcI = paramInt;
    this.IXS = paramBoolean2;
    if (qr())
    {
      bvo();
      AppMethodBeat.o(196978);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = h.b(this.context, this.context.getString(2131763073), true, null);
      ap.n(this.kkk, 5000L);
    }
    AppMethodBeat.o(196978);
  }
  
  public final void bvo()
  {
    AppMethodBeat.i(39489);
    if (this.IXT != null) {
      this.IXT.e(this.mcH, this.text, this.IXS);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void fuw()
  {
    AppMethodBeat.i(196977);
    this.mcG = true;
    if (qr())
    {
      ap.aB(this.kkk);
      bvo();
    }
    AppMethodBeat.o(196977);
  }
  
  static abstract interface a
  {
    public abstract void e(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.f
 * JD-Core Version:    0.7.0.1
 */