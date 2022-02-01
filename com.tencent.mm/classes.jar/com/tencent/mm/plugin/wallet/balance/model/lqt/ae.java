package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class ae
{
  private static String CPZ = "";
  
  public static void aFj(String paramString)
  {
    AppMethodBeat.i(68547);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    CPZ = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static String aFk(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String eFT()
  {
    return CPZ;
  }
  
  public static void parseUrl(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!bu.isNullOrNil(paramString)) {
      aFj(paramString);
    }
    AppMethodBeat.o(68548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ae
 * JD-Core Version:    0.7.0.1
 */