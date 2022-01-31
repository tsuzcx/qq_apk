package com.tencent.mm.pluginsdk.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class a
{
  public static Bundle VI(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_scene", 1);
    paramString = paramString.split("&");
    if ((paramString == null) || (paramString.length == 0))
    {
      y.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
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
    localBundle.putString("_wxapi_payreq_appid", b("appid", localHashMap));
    localBundle.putString("_wxapi_payreq_partnerid", b("partnerid", localHashMap));
    localBundle.putString("_wxapi_payreq_prepayid", b("prepayid", localHashMap));
    localBundle.putString("_wxapi_payreq_noncestr", b("noncestr", localHashMap));
    localBundle.putString("_wxapi_payreq_timestamp", b("timestamp", localHashMap));
    localBundle.putString("_wxapi_payreq_packagevalue", b("package", localHashMap));
    localBundle.putString("_wxapi_payreq_sign", b("sign", localHashMap));
    localBundle.putString("_wxapi_payreq_sign_type", b("signtype", localHashMap));
    localBundle.putString("_wxapi_payreq_extdata", b("extdata", localHashMap));
    localBundle.putString("_wxapi_payoptions_callback_classname", "");
    localBundle.putInt("_wxapi_payoptions_callback_flags", -1);
    return localBundle;
  }
  
  private static String b(String paramString, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get(paramString);
    paramHashMap = str;
    if (TextUtils.isEmpty(str))
    {
      y.e("MicroMsg.MallManager", "getWapPayKey key: " + paramString + " value is empty");
      paramHashMap = "";
    }
    return paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */