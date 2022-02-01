package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
{
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(249260);
    if (aw.aAj(paramInt))
    {
      bh.a(bh.jBC(), paramInt, 0);
      w.a(w.jjL(), paramInt, 0);
      az.nZ(paramInt, 0);
      aj.nX(paramInt, 0);
      if (parama != null)
      {
        parama.fnW();
        AppMethodBeat.o(249260);
      }
    }
    else
    {
      bh.a(bh.jBC(), paramInt, 2);
      w.a(w.jjL(), paramInt, 2);
      az.nZ(paramInt, 2);
      aj.nX(paramInt, 2);
      if (parama != null) {
        parama.fnV();
      }
    }
    AppMethodBeat.o(249260);
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(249255);
    bh.aAi(paramInt);
    w.aAi(paramInt);
    az.aAi(paramInt);
    aj.aAi(paramInt);
    AppMethodBeat.o(249255);
  }
  
  public static boolean aAk(int paramInt)
  {
    AppMethodBeat.i(249264);
    if ((bh.aAk(paramInt)) || (w.aAk(paramInt)) || (az.aAk(paramInt)) || (aj.aAk(paramInt)))
    {
      AppMethodBeat.o(249264);
      return true;
    }
    AppMethodBeat.o(249264);
    return false;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(249254);
    bh.mN(paramContext);
    w.mN(paramContext);
    az.init();
    aj.mV(paramContext);
    AppMethodBeat.o(249254);
  }
  
  public static void nX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249258);
    bh.a(bh.jBC(), paramInt1, paramInt2);
    w.a(w.jjL(), paramInt1, paramInt2);
    az.nZ(paramInt1, paramInt2);
    aj.nX(paramInt1, paramInt2);
    AppMethodBeat.o(249258);
  }
  
  public static abstract interface a
  {
    public abstract void fnV();
    
    public abstract void fnW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ag
 * JD-Core Version:    0.7.0.1
 */