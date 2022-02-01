package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import java.io.IOException;

public final class g
{
  public i Njw;
  
  public g(String paramString)
  {
    AppMethodBeat.i(122662);
    this.Njw = new i(paramString, 10);
    AppMethodBeat.o(122662);
  }
  
  public static String gz(String paramString, int paramInt)
  {
    AppMethodBeat.i(122664);
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = com.tencent.mm.kernel.h.baE().ban().d(9, null);; paramString = paramString + "_" + paramInt)
    {
      AppMethodBeat.o(122664);
      return paramString;
    }
  }
  
  public final h gy(String paramString, int paramInt)
  {
    AppMethodBeat.i(122663);
    paramString = i.readFromFile(this.Njw.NjE + gz(paramString, paramInt));
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(122663);
      return null;
    }
    try
    {
      paramString = (h)new h().parseFrom(paramString);
      AppMethodBeat.o(122663);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
      AppMethodBeat.o(122663);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.g
 * JD-Core Version:    0.7.0.1
 */