package com.unionpay.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static Object i(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(207320);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONArray != null)
    {
      localObject1 = localObject2;
      if (paramInt < paramJSONArray.length())
      {
        localObject1 = localObject2;
        if (paramInt < 0) {}
      }
    }
    try
    {
      localObject1 = paramJSONArray.get(paramInt);
      AppMethodBeat.o(207320);
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static String v(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(207302);
    String str2 = "";
    String str1 = str2;
    if (x(paramJSONObject, paramString)) {}
    try
    {
      str1 = paramJSONObject.getString(paramString);
      AppMethodBeat.o(207302);
      return str1;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        j.b("uppay", i.class.toString() + " get " + paramString + " failed!!");
        str1 = str2;
      }
    }
  }
  
  public static JSONArray w(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(207310);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (x(paramJSONObject, paramString)) {}
    try
    {
      localObject1 = paramJSONObject.getJSONArray(paramString);
      AppMethodBeat.o(207310);
      return localObject1;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        j.b("uppay", i.class.toString() + " get " + paramString + " failed!!");
        localObject1 = localObject2;
      }
    }
  }
  
  private static boolean x(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(207322);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      bool1 = bool2;
      if (paramJSONObject.has(paramString)) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(207322);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.utils.i
 * JD-Core Version:    0.7.0.1
 */