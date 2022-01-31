package org.c.g;

import java.util.regex.Pattern;

public final class d
{
  private static final Pattern xvb = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");
  
  public static void hc(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.trim().equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      u(bool, paramString2);
      return;
    }
  }
  
  public static void l(Object paramObject, String paramString)
  {
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      u(bool, paramString);
      return;
    }
  }
  
  private static void u(boolean paramBoolean, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.trim().length() > 0) {}
    }
    else
    {
      str = "Received an invalid parameter";
    }
    if (!paramBoolean) {
      throw new IllegalArgumentException(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.c.g.d
 * JD-Core Version:    0.7.0.1
 */