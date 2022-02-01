package com.tencent.shadow.a.a.b;

import android.util.Log;
import java.util.HashMap;

public class a
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    a.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void b(String paramString)
  {
    if (!a.containsKey(paramString)) {
      return;
    }
    long l = ((Long)a.get(paramString)).longValue();
    a.remove(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" elpase:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Log.e("ElapseStat", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */