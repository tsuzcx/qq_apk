package com.tencent.mm.sdk.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

public final class b
{
  public static String TY(String paramString)
  {
    AppMethodBeat.i(65357);
    paramString = com.tencent.mm.compatible.util.e.esr + String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(65357);
    return paramString;
  }
  
  public static void a(String paramString, Context paramContext)
  {
    AppMethodBeat.i(65356);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65356);
      return;
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.avH(paramString)));
    ab.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(65356);
  }
  
  public static String dpF()
  {
    AppMethodBeat.i(65358);
    String str = com.tencent.mm.compatible.util.e.esr;
    str = str.substring(str.indexOf("tencent/MicroMsg"));
    AppMethodBeat.o(65358);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */