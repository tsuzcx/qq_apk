package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class gn
{
  private static gn a = new gn();
  private Map<String, String> b = new go(this, 8, 1.0F, true);
  
  private gn()
  {
    a(hn.b("HalleyOperInfo_" + em.c(), "", true), false);
  }
  
  public static gn a()
  {
    return a;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "cm";
    }
    do
    {
      return str;
      if (paramInt == 3) {
        return "ct";
      }
    } while (paramInt != 2);
    return "uni";
  }
  
  public final String a(String paramString)
  {
    if ((hq.a(paramString)) || ("unknown".equals(paramString))) {
      return "";
    }
    synchronized (this.b)
    {
      paramString = (String)this.b.get(paramString);
      if (!hq.a(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((hq.a(paramString1)) || ("unknown".equals(paramString1)) || (hq.a(paramString2)) || ("unknown".equals(paramString2))) {
      return;
    }
    synchronized (this.b)
    {
      if (!paramString2.equals((String)this.b.get(paramString1)))
      {
        this.b.put(paramString1, paramString2);
        paramString1 = b();
        hn.a("HalleyOperInfo_" + em.c(), paramString1, true);
      }
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    label137:
    for (;;)
    {
      try
      {
        if (!hq.a(paramString)) {}
        synchronized (this.b)
        {
          this.b.clear();
          String[] arrayOfString = paramString.split("h;l");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            if (i < j)
            {
              Object localObject2 = arrayOfString[i].split("h,l");
              if (localObject2.length != 2) {
                break label137;
              }
              Object localObject1 = localObject2[0];
              localObject2 = localObject2[1];
              this.b.put(localObject1, localObject2);
              break label137;
            }
          }
          if (paramBoolean) {
            hn.a("HalleyOperInfo_" + em.c(), paramString, true);
          }
          return;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.b)
    {
      ArrayList localArrayList1 = new ArrayList(this.b.keySet());
      ArrayList localArrayList2 = new ArrayList(this.b.values());
      int i = 0;
      while (i < localArrayList1.size())
      {
        String str1 = (String)localArrayList1.get(i);
        String str2 = (String)localArrayList2.get(i);
        localStringBuilder.append(str1).append("h,l").append(str2).append("h;l");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gn
 * JD-Core Version:    0.7.0.1
 */