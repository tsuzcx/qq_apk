package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
{
  private static String HuS = "";
  
  public static void aUH(String paramString)
  {
    AppMethodBeat.i(68547);
    Log.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    HuS = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static String aUI(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String fNb()
  {
    return HuS;
  }
  
  public static void parseUrl(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!Util.isNullOrNil(paramString)) {
      aUH(paramString);
    }
    AppMethodBeat.o(68548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ag
 * JD-Core Version:    0.7.0.1
 */