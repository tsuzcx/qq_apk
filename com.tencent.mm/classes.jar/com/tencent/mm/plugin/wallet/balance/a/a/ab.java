package com.tencent.mm.plugin.wallet.balance.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class ab
{
  private static String tNy = "";
  
  public static void aeP(String paramString)
  {
    AppMethodBeat.i(45328);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    tNy = paramString;
    AppMethodBeat.o(45328);
  }
  
  public static String aeQ(String paramString)
  {
    AppMethodBeat.i(45330);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(45330);
    return paramString;
  }
  
  public static String cQT()
  {
    return tNy;
  }
  
  public static void parseUrl(String paramString)
  {
    AppMethodBeat.i(45329);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!bo.isNullOrNil(paramString)) {
      aeP(paramString);
    }
    AppMethodBeat.o(45329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.ab
 * JD-Core Version:    0.7.0.1
 */