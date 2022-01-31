package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

public abstract class b
{
  protected final String aRC = "weixin/android";
  
  public static Map<String, String> Lh(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  public abstract void a(b.b paramb, b.c paramc);
  
  public final void a(b.b paramb, b.c paramc, ah paramah)
  {
    e.post(new b.1(this, paramb, paramc, paramah), getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */