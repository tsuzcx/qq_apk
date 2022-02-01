package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.util.IXWebLogClient;

final class ab$a$1
  implements IXWebLogClient
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133674);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(133674);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133672);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(133672);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133671);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(133671);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133675);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(133675);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133673);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(133673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.ab.a.1
 * JD-Core Version:    0.7.0.1
 */