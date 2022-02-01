package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class ae
{
  private static String AYl = "";
  
  public static void ayI(String paramString)
  {
    AppMethodBeat.i(68547);
    ac.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    AYl = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static String ayJ(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String eon()
  {
    return AYl;
  }
  
  public static void parseUrl(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!bs.isNullOrNil(paramString)) {
      ayI(paramString);
    }
    AppMethodBeat.o(68548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ae
 * JD-Core Version:    0.7.0.1
 */