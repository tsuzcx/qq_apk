package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public final class c
{
  public static void a(WaidProvider.a parama, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(306348);
    if (!b.hti())
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportPkg isWxEnvInitDone==false");
      AppMethodBeat.o(306348);
      return;
    }
    if ((parama != null) && (parama.RYW != null) && (parama.RYW.length > 1)) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (i < parama.RYW.length)
        {
          localStringBuilder.append(parama.RYW[i]);
          if (i == parama.RYW.length - 1) {
            break label235;
          }
          localStringBuilder.append("|");
          break label235;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rawCallPkg", parama.RYV);
        localJSONObject.put("callPkgType", parama.RYX);
        localJSONObject.put("pkgsFromUid", localStringBuilder.toString());
        localJSONObject.put("queryPkg", paramString);
        parama = bbu(localJSONObject.toString());
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportPkg data=".concat(String.valueOf(parama)));
        h.OAn.b(18666, new Object[] { Integer.valueOf(2002), parama });
        AppMethodBeat.o(306348);
        return;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportPkg exp=" + android.util.Log.getStackTraceString(parama));
      }
      AppMethodBeat.o(306348);
      return;
      label235:
      i += 1;
    }
  }
  
  static String bbu(String paramString)
  {
    AppMethodBeat.i(306355);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(306355);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(306355);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.c
 * JD-Core Version:    0.7.0.1
 */