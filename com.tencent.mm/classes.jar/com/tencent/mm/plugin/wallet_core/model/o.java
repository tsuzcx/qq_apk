package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class o
{
  public String hxt;
  public boolean kOD;
  public int retCode;
  public int uiu;
  
  public static o a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(46781);
    o localo = new o();
    localo.kOD = paramBoolean;
    localo.retCode = paramInt1;
    localo.uiu = paramInt2;
    localo.hxt = paramString;
    AppMethodBeat.o(46781);
    return localo;
  }
  
  public static o gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46782);
    o localo = a(false, paramInt1, paramInt2, "");
    AppMethodBeat.o(46782);
    return localo;
  }
  
  public final void y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(46783);
    if (this.kOD)
    {
      if (!bo.isNullOrNil(this.hxt))
      {
        if (paramBoolean)
        {
          Toast.makeText(paramContext, this.hxt, 1).show();
          AppMethodBeat.o(46783);
          return;
        }
        h.b(paramContext, this.hxt, "", false);
        AppMethodBeat.o(46783);
      }
    }
    else {
      h.b(paramContext, paramContext.getString(2131305218), "", false);
    }
    AppMethodBeat.o(46783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o
 * JD-Core Version:    0.7.0.1
 */