package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ah
{
  private static String OmF = "";
  
  public static void bgp(String paramString)
  {
    AppMethodBeat.i(68547);
    Log.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    OmF = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static void bgq(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!Util.isNullOrNil(paramString)) {
      bgp(paramString);
    }
    AppMethodBeat.o(68548);
  }
  
  public static String bgr(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String gFF()
  {
    return OmF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ah
 * JD-Core Version:    0.7.0.1
 */