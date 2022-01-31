package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  private static final HashSet<String> rsr;
  
  static
  {
    HashSet localHashSet = new HashSet();
    rsr = localHashSet;
    localHashSet.add("title");
    rsr.add("webpageTitle");
    rsr.add("srcUsername");
    rsr.add("srcDisplayname");
    rsr.add("mode");
    rsr.add("KTemplateId");
    rsr.add("KPublisherId");
  }
  
  public static JSONObject W(Bundle paramBundle)
  {
    localJSONObject = new JSONObject();
    if (paramBundle == null) {
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
      y.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", new Object[] { paramBundle });
    }
  }
  
  public static void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    Iterator localIterator;
    do
    {
      return;
      localIterator = paramJSONObject.keys();
    } while (localIterator == null);
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
  }
  
  public static Bundle af(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    Bundle localBundle = new Bundle();
    if (paramIntent == null) {
      return localBundle;
    }
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (rsr.contains(str))
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
          y.w("MicroMsg.WebViewBagIntentLogic", "put not support type; key:%s", new Object[] { str });
        }
      }
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.k
 * JD-Core Version:    0.7.0.1
 */