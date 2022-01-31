package com.tencent.mm.z.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a
  extends b<JSONObject, Bundle, JSONObject>
  implements e
{
  public a(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private static void d(Map paramMap)
  {
    AppMethodBeat.i(115301);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        d((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(115301);
  }
  
  public final JSONObject a(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(115300);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.name);
    ((StringBuilder)localObject2).append(":");
    if (paramBoolean) {}
    for (Object localObject1 = "ok";; localObject1 = "fail")
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      if (!TextUtils.isEmpty(paramString))
      {
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(bo.nullAsNil(paramString));
      }
      paramString = new HashMap();
      paramString.put("errMsg", ((StringBuilder)localObject2).toString());
      if (paramBundle == null) {
        break;
      }
      localObject1 = paramBundle.keySet();
      if ((localObject1 == null) || (((Set)localObject1).isEmpty())) {
        break;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        paramString.put(localObject2, paramBundle.get((String)localObject2));
      }
    }
    d(paramString);
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(115300);
    return paramString;
  }
  
  public final JSONObject a(boolean paramBoolean, String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(115299);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(":");
    if (paramBoolean) {}
    for (String str = "ok";; str = "fail")
    {
      localStringBuilder.append(str);
      if (!TextUtils.isEmpty(paramString))
      {
        localStringBuilder.append(":");
        localStringBuilder.append(bo.nullAsNil(paramString));
      }
      paramString = new HashMap();
      paramString.put("errMsg", localStringBuilder.toString());
      if (paramMap != null) {
        paramString.putAll(paramMap);
      }
      d(paramString);
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(115299);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.b.a
 * JD-Core Version:    0.7.0.1
 */