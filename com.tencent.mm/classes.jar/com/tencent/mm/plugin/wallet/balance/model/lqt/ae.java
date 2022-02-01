package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class ae
{
  private static String zFY = "";
  
  public static void atq(String paramString)
  {
    AppMethodBeat.i(68547);
    ad.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    zFY = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static String atr(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String dYR()
  {
    return zFY;
  }
  
  public static void parseUrl(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!bt.isNullOrNil(paramString)) {
      atq(paramString);
    }
    AppMethodBeat.o(68548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ae
 * JD-Core Version:    0.7.0.1
 */