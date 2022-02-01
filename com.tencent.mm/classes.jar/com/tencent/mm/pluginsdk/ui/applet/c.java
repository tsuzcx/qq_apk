package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.pluginsdk.i;

public final class c
  implements i
{
  public final w a(Context paramContext, String paramString, int paramInt, v paramv, a parama)
  {
    AppMethodBeat.i(193443);
    paramContext = new b(paramContext, paramString, paramInt, paramv, parama);
    AppMethodBeat.o(193443);
    return paramContext;
  }
  
  public final w a(Context paramContext, String paramString, v paramv)
  {
    AppMethodBeat.i(31339);
    paramContext = new b(paramContext, paramString, 0, paramv);
    AppMethodBeat.o(31339);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */