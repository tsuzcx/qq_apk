package com.tencent.mm.pluginsdk.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class a
{
  public static Bundle aAA(String paramString)
  {
    AppMethodBeat.i(30935);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_scene", 1);
    paramString = paramString.split("&");
    if ((paramString == null) || (paramString.length == 0))
    {
      ad.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
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
    localBundle.putString("_wxapi_payreq_appid", d("appid", localHashMap));
    localBundle.putString("_wxapi_payreq_partnerid", d("partnerid", localHashMap));
    localBundle.putString("_wxapi_payreq_prepayid", d("prepayid", localHashMap));
    localBundle.putString("_wxapi_payreq_noncestr", d("noncestr", localHashMap));
    localBundle.putString("_wxapi_payreq_timestamp", d("timestamp", localHashMap));
    localBundle.putString("_wxapi_payreq_packagevalue", d("package", localHashMap));
    localBundle.putString("_wxapi_payreq_sign", d("sign", localHashMap));
    localBundle.putString("_wxapi_payreq_sign_type", d("signtype", localHashMap));
    localBundle.putString("_wxapi_payreq_extdata", d("extdata", localHashMap));
    localBundle.putString("_wxapi_payoptions_callback_classname", "");
    localBundle.putInt("_wxapi_payoptions_callback_flags", -1);
    AppMethodBeat.o(30935);
    return localBundle;
  }
  
  private static String d(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(30936);
    paramHashMap = (String)paramHashMap.get(paramString);
    if (TextUtils.isEmpty(paramHashMap))
    {
      ad.e("MicroMsg.MallManager", "getWapPayKey key: " + paramString + " value is empty");
      AppMethodBeat.o(30936);
      return "";
    }
    AppMethodBeat.o(30936);
    return paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */