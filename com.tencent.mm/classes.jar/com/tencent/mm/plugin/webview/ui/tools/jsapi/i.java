package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public Map<String, Object> pJb;
  public String type;
  public String vrN;
  public JSONObject vrO;
  Map<String, Object> vrP;
  public String vrQ;
  
  public i()
  {
    AppMethodBeat.i(9818);
    this.vrP = new HashMap();
    AppMethodBeat.o(9818);
  }
  
  public static Bundle aQ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(9819);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(9819);
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
    AppMethodBeat.o(9819);
    return localBundle;
  }
  
  public static Map<String, Object> az(Bundle paramBundle)
  {
    AppMethodBeat.i(9820);
    if (paramBundle == null)
    {
      AppMethodBeat.o(9820);
      return null;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(9820);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    AppMethodBeat.o(9820);
    return localHashMap;
  }
  
  public final Map<String, Object> dgQ()
  {
    return this.vrP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */