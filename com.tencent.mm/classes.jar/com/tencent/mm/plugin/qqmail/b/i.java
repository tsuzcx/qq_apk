package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import java.io.IOException;

public final class i
{
  public k vTR;
  
  public i(String paramString)
  {
    AppMethodBeat.i(122662);
    this.vTR = new k(paramString, 10);
    AppMethodBeat.o(122662);
  }
  
  public static String em(String paramString, int paramInt)
  {
    AppMethodBeat.i(122664);
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = g.agR().agA().get(9, null);; paramString = paramString + "_" + paramInt)
    {
      AppMethodBeat.o(122664);
      return paramString;
    }
  }
  
  public final j el(String paramString, int paramInt)
  {
    AppMethodBeat.i(122663);
    paramString = k.readFromFile(this.vTR.vUb + em(paramString, paramInt));
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
      ac.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
      AppMethodBeat.o(122663);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.i
 * JD-Core Version:    0.7.0.1
 */