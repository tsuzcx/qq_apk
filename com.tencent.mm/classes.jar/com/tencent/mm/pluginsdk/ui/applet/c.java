package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g;

public final class c
  implements g
{
  public final o a(Context paramContext, String paramString1, int paramInt, n paramn, String paramString2)
  {
    AppMethodBeat.i(156067);
    paramContext = new b(paramContext, paramString1, paramInt, paramn, paramString2);
    paramContext.vSY = 4;
    AppMethodBeat.o(156067);
    return paramContext;
  }
  
  public final o a(Context paramContext, String paramString1, int paramInt, n paramn, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(27638);
    paramContext = new b(paramContext, paramString1, paramInt, paramn, paramBoolean, paramString2);
    AppMethodBeat.o(27638);
    return paramContext;
  }
  
  public final o a(Context paramContext, String paramString, n paramn)
  {
    AppMethodBeat.i(27636);
    paramContext = new b(paramContext, paramString, paramn);
    AppMethodBeat.o(27636);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */