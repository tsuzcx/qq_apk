package com.tencent.mm.pluginsdk.f;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a
{
  public static Bundle bpj(String paramString)
  {
    AppMethodBeat.i(30935);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_scene", 1);
    paramString = paramString.split("&");
    if ((paramString == null) || (paramString.length == 0))
    {
      Log.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
      AppMethodBeat.o(30935);
      return localBundle;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("=");
        if ((localObject != null) && (localObject.length == 2)) {
          localHashMap.put(localObject[0], localObject[1]);
        }
      }
      i += 1;
    }
    localBundle.putString("_wxapi_payreq_appid", f("appid", localHashMap));
    localBundle.putString("_wxapi_payreq_partnerid", f("partnerid", localHashMap));
    localBundle.putString("_wxapi_payreq_prepayid", f("prepayid", localHashMap));
    localBundle.putString("_wxapi_payreq_noncestr", f("noncestr", localHashMap));
    localBundle.putString("_wxapi_payreq_timestamp", f("timestamp", localHashMap));
    localBundle.putString("_wxapi_payreq_packagevalue", f("package", localHashMap));
    localBundle.putString("_wxapi_payreq_sign", f("sign", localHashMap));
    localBundle.putString("_wxapi_payreq_sign_type", f("signtype", localHashMap));
    localBundle.putString("_wxapi_payreq_extdata", f("extdata", localHashMap));
    localBundle.putString("_wxapi_payoptions_callback_classname", "");
    localBundle.putInt("_wxapi_payoptions_callback_flags", -1);
    AppMethodBeat.o(30935);
    return localBundle;
  }
  
  private static String f(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(30936);
    paramHashMap = (String)paramHashMap.get(paramString);
    if (TextUtils.isEmpty(paramHashMap))
    {
      Log.e("MicroMsg.MallManager", "getWapPayKey key: " + paramString + " value is empty");
      AppMethodBeat.o(30936);
      return "";
    }
    AppMethodBeat.o(30936);
    return paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.a
 * JD-Core Version:    0.7.0.1
 */