package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class p
{
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("local", "true");
    localHashMap.put("style", "1");
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("path", paramString1);
      localJSONObject.put("ext", paramString2);
      localJSONObject.put("token", paramString3);
      paramString1 = localJSONObject.toString();
      return d.startMiniQBToLoadUrl(paramContext, paramString1, localHashMap, paramValueCallback);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.QbReaderLogic", paramString1, "openReadFile", new Object[0]);
        paramString1 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */