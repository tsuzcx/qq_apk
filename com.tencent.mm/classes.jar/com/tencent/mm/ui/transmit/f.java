package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class f
{
  boolean Hxv;
  a Hxw;
  Context context;
  Runnable jJK;
  boolean lAJ;
  boolean lAK;
  boolean lAL;
  int lAM;
  String text;
  p tipDialog;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.Hxv = false;
    this.jJK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (f.this.tipDialog != null) {
          f.this.tipDialog.dismiss();
        }
        f.this.bos();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean qh()
  {
    return this.lAJ & this.lAK;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(191863);
    this.lAJ = true;
    this.lAL = paramBoolean1;
    this.text = paramString;
    this.lAM = paramInt;
    this.Hxv = paramBoolean2;
    if (qh())
    {
      bos();
      AppMethodBeat.o(191863);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = h.b(this.context, this.context.getString(2131763073), true, null);
      aq.n(this.jJK, 5000L);
    }
    AppMethodBeat.o(191863);
  }
  
  public final void bos()
  {
    AppMethodBeat.i(39489);
    if (this.Hxw != null) {
      this.Hxw.e(this.lAL, this.text, this.Hxv);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void feB()
  {
    AppMethodBeat.i(191862);
    this.lAK = true;
    if (qh())
    {
      aq.az(this.jJK);
      bos();
    }
    AppMethodBeat.o(191862);
  }
  
  static abstract interface a
  {
    public abstract void e(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.f
 * JD-Core Version:    0.7.0.1
 */