package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class f
{
  boolean KOX;
  a KOY;
  Context context;
  Runnable kFk;
  boolean mCN;
  boolean mCO;
  boolean mCP;
  int mCQ;
  String text;
  p tipDialog;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.KOX = false;
    this.kFk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (f.this.tipDialog != null) {
          f.this.tipDialog.dismiss();
        }
        f.this.bzu();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean rP()
  {
    return this.mCN & this.mCO;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(194833);
    this.mCN = true;
    this.mCP = paramBoolean1;
    this.text = paramString;
    this.mCQ = paramInt;
    this.KOX = paramBoolean2;
    if (rP())
    {
      bzu();
      AppMethodBeat.o(194833);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = h.b(this.context, this.context.getString(2131763073), true, null);
      aq.o(this.kFk, 5000L);
    }
    AppMethodBeat.o(194833);
  }
  
  public final void bzu()
  {
    AppMethodBeat.i(39489);
    if (this.KOY != null) {
      this.KOY.e(this.mCP, this.text, this.KOX);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void fLj()
  {
    AppMethodBeat.i(194832);
    this.mCO = true;
    if (rP())
    {
      aq.aA(this.kFk);
      bzu();
    }
    AppMethodBeat.o(194832);
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