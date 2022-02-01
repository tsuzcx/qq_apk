package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class f
{
  boolean Llv;
  a Llw;
  Context context;
  Runnable kIz;
  boolean mHS;
  boolean mHT;
  boolean mHU;
  int mHV;
  String text;
  p tipDialog;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(39488);
    this.Llv = false;
    this.kIz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39487);
        if (f.this.tipDialog != null) {
          f.this.tipDialog.dismiss();
        }
        f.this.bAp();
        AppMethodBeat.o(39487);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(39488);
  }
  
  private boolean rP()
  {
    return this.mHS & this.mHT;
  }
  
  public final void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(188235);
    this.mHS = true;
    this.mHU = paramBoolean1;
    this.text = paramString;
    this.mHV = paramInt;
    this.Llv = paramBoolean2;
    if (rP())
    {
      bAp();
      AppMethodBeat.o(188235);
      return;
    }
    if (paramBoolean1)
    {
      this.tipDialog = h.b(this.context, this.context.getString(2131763073), true, null);
      ar.o(this.kIz, 5000L);
    }
    AppMethodBeat.o(188235);
  }
  
  public final void bAp()
  {
    AppMethodBeat.i(39489);
    if (this.Llw != null) {
      this.Llw.e(this.mHU, this.text, this.Llv);
    }
    AppMethodBeat.o(39489);
  }
  
  public final void fPC()
  {
    AppMethodBeat.i(188234);
    this.mHT = true;
    if (rP())
    {
      ar.ay(this.kIz);
      bAp();
    }
    AppMethodBeat.o(188234);
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