package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import java.io.IOException;

public final class h
{
  public j xrl;
  
  public h(String paramString)
  {
    AppMethodBeat.i(122662);
    this.xrl = new j(paramString, 10);
    AppMethodBeat.o(122662);
  }
  
  public static String eN(String paramString, int paramInt)
  {
    AppMethodBeat.i(122664);
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = g.ajR().ajA().get(9, null);; paramString = paramString + "_" + paramInt)
    {
      AppMethodBeat.o(122664);
      return paramString;
    }
  }
  
  public final i eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(122663);
    paramString = j.readFromFile(this.xrl.xru + eN(paramString, paramInt));
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(122663);
      return null;
    }
    try
    {
      paramString = (i)new i().parseFrom(paramString);
      AppMethodBeat.o(122663);
      return paramString;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
      AppMethodBeat.o(122663);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.h
 * JD-Core Version:    0.7.0.1
 */