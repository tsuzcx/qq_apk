package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ai
{
  private static String Vbl = "";
  
  public static void bfU(String paramString)
  {
    AppMethodBeat.i(68547);
    Log.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", new Object[] { paramString });
    Vbl = paramString;
    AppMethodBeat.o(68547);
  }
  
  public static void bfV(String paramString)
  {
    AppMethodBeat.i(68548);
    paramString = Uri.parse(paramString).getQueryParameter("trace_info");
    if (!Util.isNullOrNil(paramString)) {
      bfU(paramString);
    }
    AppMethodBeat.o(68548);
  }
  
  public static String bfW(String paramString)
  {
    AppMethodBeat.i(68549);
    paramString = Uri.parse(paramString).getQueryParameter("operate_id");
    AppMethodBeat.o(68549);
    return paramString;
  }
  
  public static String ieD()
  {
    return Vbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ai
 * JD-Core Version:    0.7.0.1
 */