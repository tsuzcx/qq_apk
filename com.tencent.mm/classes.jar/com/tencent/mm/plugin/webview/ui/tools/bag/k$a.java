package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class k$a
  extends JSONObject
{
  public k$a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      put("type", 1);
      put("val", paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      put("type", 2);
      put("val", paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      put("type", 3);
      put("val", paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      put("type", 4);
      put("val", paramObject);
      return;
    }
    y.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", new Object[] { paramObject.getClass() });
    put("type", 0);
    put("val", paramObject);
  }
  
  static void a(Bundle paramBundle, String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("type");
        y.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", new Object[] { paramString, Integer.valueOf(i) });
        switch (i)
        {
        case 1: 
          y.w("MicroMsg.WebViewBagIntentLogic", "not support type");
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        y.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", new Object[] { paramBundle });
        return;
      }
      paramBundle.putString(paramString, paramJSONObject.getString("val"));
      return;
      paramBundle.putInt(paramString, paramJSONObject.getInt("val"));
      return;
      paramBundle.putLong(paramString, paramJSONObject.getLong("val"));
      return;
      paramBundle.putBoolean(paramString, paramJSONObject.getBoolean("val"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.k.a
 * JD-Core Version:    0.7.0.1
 */