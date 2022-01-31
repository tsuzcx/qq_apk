package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class k$a
  extends JSONObject
{
  public k$a(Object paramObject)
  {
    AppMethodBeat.i(8202);
    if ((paramObject instanceof String))
    {
      put("type", 1);
      put("val", paramObject);
      AppMethodBeat.o(8202);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      put("type", 2);
      put("val", paramObject);
      AppMethodBeat.o(8202);
      return;
    }
    if ((paramObject instanceof Long))
    {
      put("type", 3);
      put("val", paramObject);
      AppMethodBeat.o(8202);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      put("type", 4);
      put("val", paramObject);
      AppMethodBeat.o(8202);
      return;
    }
    ab.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", new Object[] { paramObject.getClass() });
    put("type", 0);
    put("val", paramObject);
    AppMethodBeat.o(8202);
  }
  
  static void a(Bundle paramBundle, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(8203);
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("type");
        ab.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", new Object[] { paramString, Integer.valueOf(i) });
        switch (i)
        {
        case 1: 
          ab.w("MicroMsg.WebViewBagIntentLogic", "not support type");
          AppMethodBeat.o(8203);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        ab.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", new Object[] { paramBundle });
        AppMethodBeat.o(8203);
        return;
      }
      paramBundle.putString(paramString, paramJSONObject.getString("val"));
      AppMethodBeat.o(8203);
      return;
      paramBundle.putInt(paramString, paramJSONObject.getInt("val"));
      AppMethodBeat.o(8203);
      return;
      paramBundle.putLong(paramString, paramJSONObject.getLong("val"));
      AppMethodBeat.o(8203);
      return;
      paramBundle.putBoolean(paramString, paramJSONObject.getBoolean("val"));
      AppMethodBeat.o(8203);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.k.a
 * JD-Core Version:    0.7.0.1
 */