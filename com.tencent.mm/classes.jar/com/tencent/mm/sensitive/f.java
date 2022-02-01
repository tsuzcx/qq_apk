package com.tencent.mm.sensitive;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/MethodPermissionChecker;", "", "()V", "method2Permission", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getUsingPermission", "methodName", "initJson2Map", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f actK;
  private static final HashMap<String, String> actL;
  
  static
  {
    AppMethodBeat.i(240909);
    actK = new f();
    actL = new HashMap();
    iTI();
    AppMethodBeat.o(240909);
  }
  
  public static String buo(String paramString)
  {
    AppMethodBeat.i(240907);
    s.u(paramString, "methodName");
    paramString = (String)actL.get(paramString);
    AppMethodBeat.o(240907);
    return paramString;
  }
  
  private static void iTI()
  {
    AppMethodBeat.i(240905);
    Object localObject = k.acud;
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = new JSONObject(k.cl((Context)localObject, "methodToPermissionMap.json"));
    Iterator localIterator = ((JSONObject)localObject).keys();
    s.s(localIterator, "json.keys()");
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray(str1);
      int k = localJSONArray.length();
      if (k > 0)
      {
        int j;
        for (int i = 0;; i = j)
        {
          j = i + 1;
          Map localMap = (Map)actL;
          String str2 = localJSONArray.get(i).toString();
          s.s(str1, "it");
          localMap.put(str2, str1);
          if (j >= k) {
            break;
          }
        }
      }
    }
    AppMethodBeat.o(240905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.f
 * JD-Core Version:    0.7.0.1
 */