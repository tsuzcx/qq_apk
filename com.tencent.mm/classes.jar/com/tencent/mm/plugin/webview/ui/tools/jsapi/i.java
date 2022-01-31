package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public Map<String, Object> ndL;
  public String rAL;
  public JSONObject rAM;
  Map<String, Object> rAN = new HashMap();
  public String rAO;
  public String type;
  
  public static Map<String, Object> af(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return null;
      localObject = paramBundle.keySet();
    } while (localObject == null);
    HashMap localHashMap = new HashMap();
    Object localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    return localHashMap;
  }
  
  public static Bundle aq(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((localObject instanceof String[])) {
        localBundle.putStringArray(str, (String[])localObject);
      } else if ((localObject instanceof Bundle)) {
        localBundle.putBundle(str, (Bundle)localObject);
      } else {
        localBundle.putString(str, String.valueOf(localObject));
      }
    }
    return localBundle;
  }
  
  public final Map<String, Object> cgB()
  {
    return this.rAN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */