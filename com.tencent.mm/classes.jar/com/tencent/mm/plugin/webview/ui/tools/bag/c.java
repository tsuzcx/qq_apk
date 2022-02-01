package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static final HashSet<String> Qim;
  
  static
  {
    AppMethodBeat.i(80438);
    HashSet localHashSet = new HashSet();
    Qim = localHashSet;
    localHashSet.add("title");
    Qim.add("webpageTitle");
    Qim.add("srcUsername");
    Qim.add("srcDisplayname");
    Qim.add("mode");
    Qim.add("KTemplateId");
    Qim.add("KPublisherId");
    AppMethodBeat.o(80438);
  }
  
  public static void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(80437);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(80437);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator == null)
    {
      AppMethodBeat.o(80437);
      return;
    }
    Bundle localBundle = new Bundle();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        a.b(localBundle, str, paramJSONObject.getJSONObject(str));
      }
      catch (JSONException localJSONException) {}
    }
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(80437);
  }
  
  public static JSONObject bc(Bundle paramBundle)
  {
    AppMethodBeat.i(80436);
    localJSONObject = new JSONObject();
    if (paramBundle == null)
    {
      AppMethodBeat.o(80436);
      return localJSONObject;
    }
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, new a(paramBundle.get(str)));
      }
      return localJSONObject;
    }
    catch (JSONException paramBundle)
    {
      Log.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", new Object[] { paramBundle });
      AppMethodBeat.o(80436);
    }
  }
  
  static final class a
    extends JSONObject
  {
    public a(Object paramObject)
    {
      AppMethodBeat.i(80434);
      if ((paramObject instanceof String))
      {
        put("type", 1);
        put("val", paramObject);
        AppMethodBeat.o(80434);
        return;
      }
      if ((paramObject instanceof Integer))
      {
        put("type", 2);
        put("val", paramObject);
        AppMethodBeat.o(80434);
        return;
      }
      if ((paramObject instanceof Long))
      {
        put("type", 3);
        put("val", paramObject);
        AppMethodBeat.o(80434);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        put("type", 4);
        put("val", paramObject);
        AppMethodBeat.o(80434);
        return;
      }
      Log.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", new Object[] { paramObject.getClass() });
      put("type", 0);
      put("val", paramObject);
      AppMethodBeat.o(80434);
    }
    
    static void b(Bundle paramBundle, String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(80435);
      for (;;)
      {
        try
        {
          int i = paramJSONObject.getInt("type");
          Log.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", new Object[] { paramString, Integer.valueOf(i) });
          switch (i)
          {
          case 1: 
            Log.w("MicroMsg.WebViewBagIntentLogic", "not support type");
            AppMethodBeat.o(80435);
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          Log.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", new Object[] { paramBundle });
          AppMethodBeat.o(80435);
          return;
        }
        paramBundle.putString(paramString, paramJSONObject.getString("val"));
        AppMethodBeat.o(80435);
        return;
        paramBundle.putInt(paramString, paramJSONObject.getInt("val"));
        AppMethodBeat.o(80435);
        return;
        paramBundle.putLong(paramString, paramJSONObject.getLong("val"));
        AppMethodBeat.o(80435);
        return;
        paramBundle.putBoolean(paramString, paramJSONObject.getBoolean("val"));
        AppMethodBeat.o(80435);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.c
 * JD-Core Version:    0.7.0.1
 */