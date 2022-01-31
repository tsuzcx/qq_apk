package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  private static final HashSet<String> viw;
  
  static
  {
    AppMethodBeat.i(8207);
    HashSet localHashSet = new HashSet();
    viw = localHashSet;
    localHashSet.add("title");
    viw.add("webpageTitle");
    viw.add("srcUsername");
    viw.add("srcDisplayname");
    viw.add("mode");
    viw.add("KTemplateId");
    viw.add("KPublisherId");
    AppMethodBeat.o(8207);
  }
  
  public static void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(8205);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(8205);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator == null)
    {
      AppMethodBeat.o(8205);
      return;
    }
    Bundle localBundle = new Bundle();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        k.a.a(localBundle, str, paramJSONObject.getJSONObject(str));
      }
      catch (JSONException localJSONException) {}
    }
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(8205);
  }
  
  public static Bundle aB(Intent paramIntent)
  {
    AppMethodBeat.i(8206);
    paramIntent = paramIntent.getExtras();
    Bundle localBundle = new Bundle();
    if (paramIntent == null)
    {
      AppMethodBeat.o(8206);
      return localBundle;
    }
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (viw.contains(str))
      {
        Object localObject = paramIntent.get(str);
        if ((localObject instanceof String)) {
          localBundle.putString(str, (String)localObject);
        } else if ((localObject instanceof Integer)) {
          localBundle.putInt(str, ((Integer)localObject).intValue());
        } else if ((localObject instanceof Long)) {
          localBundle.putLong(str, ((Long)localObject).longValue());
        } else if ((localObject instanceof Boolean)) {
          localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
        } else {
          ab.w("MicroMsg.WebViewBagIntentLogic", "put not support type; key:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(8206);
    return localBundle;
  }
  
  public static JSONObject an(Bundle paramBundle)
  {
    AppMethodBeat.i(8204);
    localJSONObject = new JSONObject();
    if (paramBundle == null)
    {
      AppMethodBeat.o(8204);
      return localJSONObject;
    }
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, new k.a(paramBundle.get(str)));
      }
      return localJSONObject;
    }
    catch (JSONException paramBundle)
    {
      ab.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", new Object[] { paramBundle });
      AppMethodBeat.o(8204);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.k
 * JD-Core Version:    0.7.0.1
 */