package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class i
{
  public k pIH;
  
  public i(String paramString)
  {
    AppMethodBeat.i(67928);
    this.pIH = new k(paramString, 10);
    AppMethodBeat.o(67928);
  }
  
  public static String db(String paramString, int paramInt)
  {
    AppMethodBeat.i(67930);
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = g.RL().Ru().get(9, null);; paramString = paramString + "_" + paramInt)
    {
      AppMethodBeat.o(67930);
      return paramString;
    }
  }
  
  public final j da(String paramString, int paramInt)
  {
    AppMethodBeat.i(67929);
    paramString = k.readFromFile(this.pIH.pIR + db(paramString, paramInt));
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(67929);
      return null;
    }
    try
    {
      paramString = (j)new j().parseFrom(paramString);
      AppMethodBeat.o(67929);
      return paramString;
    }
    catch (IOException paramString)
    {
      ab.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
      AppMethodBeat.o(67929);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.i
 * JD-Core Version:    0.7.0.1
 */