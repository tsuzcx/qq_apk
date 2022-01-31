package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private static final Pattern Lj = Pattern.compile("\\\\.");
  private static final Pattern Lk = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  public static String n(String paramString)
  {
    Matcher localMatcher;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localMatcher = Lk.matcher(paramString);
      localObject1 = null;
      while (localMatcher.find())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuffer();
        }
        switch (localMatcher.group().charAt(0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case '\b': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\b");
          localObject1 = localObject2;
          break;
        case '"': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\"");
          localObject1 = localObject2;
          break;
        case '\\': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\\");
          localObject1 = localObject2;
          break;
        case '/': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\/");
          localObject1 = localObject2;
          break;
        case '\f': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\f");
          localObject1 = localObject2;
          break;
        case '\n': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\n");
          localObject1 = localObject2;
          break;
        case '\r': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\r");
          localObject1 = localObject2;
          break;
        case '\t': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\t");
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {}
    }
    else
    {
      return paramString;
    }
    localMatcher.appendTail(localObject1);
    return localObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.i
 * JD-Core Version:    0.7.0.1
 */