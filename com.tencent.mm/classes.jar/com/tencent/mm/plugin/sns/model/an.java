package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

public final class an
{
  private static final Map<String, String> ott = new HashMap();
  
  public static String eJ(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      localObject1 = "";
    }
    boolean bool;
    do
    {
      return localObject1;
      bool = Looper.getMainLooper().equals(Looper.myLooper());
      if ((!bool) || (!ott.containsKey(paramString1 + paramString2))) {
        break;
      }
      localObject2 = (String)ott.get(paramString1 + paramString2);
      localObject1 = localObject2;
    } while (!bk.bl((String)localObject2));
    Object localObject1 = g.o(paramString2.getBytes());
    Object localObject2 = new StringBuffer(paramString1);
    if (((String)localObject1).length() > 0)
    {
      ((StringBuffer)localObject2).append(((String)localObject1).charAt(0));
      ((StringBuffer)localObject2).append("/");
    }
    if (((String)localObject1).length() >= 2)
    {
      ((StringBuffer)localObject2).append(((String)localObject1).charAt(1));
      ((StringBuffer)localObject2).append("/");
    }
    if (bool) {
      ott.put(paramString1 + paramString2, ((StringBuffer)localObject2).toString());
    }
    return ((StringBuffer)localObject2).toString();
  }
  
  public static void release()
  {
    try
    {
      ott.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */