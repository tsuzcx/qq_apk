package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import java.io.IOException;

public final class i
{
  public k uLa;
  
  public i(String paramString)
  {
    AppMethodBeat.i(122662);
    this.uLa = new k(paramString, 10);
    AppMethodBeat.o(122662);
  }
  
  public static String ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(122664);
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = g.afB().afk().get(9, null);; paramString = paramString + "_" + paramInt)
    {
      AppMethodBeat.o(122664);
      return paramString;
    }
  }
  
  public final j ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(122663);
    paramString = k.readFromFile(this.uLa.uLk + ef(paramString, paramInt));
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(122663);
      return null;
    }
    try
    {
      paramString = (j)new j().parseFrom(paramString);
      AppMethodBeat.o(122663);
      return paramString;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
      AppMethodBeat.o(122663);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.i
 * JD-Core Version:    0.7.0.1
 */