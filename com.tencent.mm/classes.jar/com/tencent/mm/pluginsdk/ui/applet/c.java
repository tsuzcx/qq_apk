package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h;

public final class c
  implements h
{
  public final w a(Context paramContext, String paramString1, int paramInt, v paramv, String paramString2)
  {
    AppMethodBeat.i(31340);
    paramContext = new b(paramContext, paramString1, paramInt, paramv, paramString2);
    paramContext.BXE = 4;
    AppMethodBeat.o(31340);
    return paramContext;
  }
  
  public final w a(Context paramContext, String paramString1, int paramInt, v paramv, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(31341);
    paramContext = new b(paramContext, paramString1, paramInt, paramv, paramBoolean, paramString2);
    AppMethodBeat.o(31341);
    return paramContext;
  }
  
  public final w a(Context paramContext, String paramString, v paramv)
  {
    AppMethodBeat.i(31339);
    paramContext = new b(paramContext, paramString, paramv);
    AppMethodBeat.o(31339);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */