package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class cb
{
  private static cb a;
  private Map<String, String> b;
  
  static
  {
    AppMethodBeat.i(147340);
    a = new cb();
    AppMethodBeat.o(147340);
  }
  
  private cb()
  {
    AppMethodBeat.i(147335);
    this.b = new cc(this, 8, 1.0F, true);
    a(da.b("HalleyOperInfo_" + ac.c(), "", true), false);
    AppMethodBeat.o(147335);
  }
  
  public static cb a()
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
    AppMethodBeat.i(147339);
    if ((dd.a(paramString)) || ("unknown".equals(paramString)))
    {
      AppMethodBeat.o(147339);
      return "";
    }
    synchronized (this.b)
    {
      paramString = (String)this.b.get(paramString);
      if (!dd.a(paramString))
      {
        AppMethodBeat.o(147339);
        return paramString;
      }
      AppMethodBeat.o(147339);
      return "";
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147337);
    if ((dd.a(paramString1)) || ("unknown".equals(paramString1)) || (dd.a(paramString2)) || ("unknown".equals(paramString2)))
    {
      AppMethodBeat.o(147337);
      return;
    }
    synchronized (this.b)
    {
      if (!paramString2.equals((String)this.b.get(paramString1)))
      {
        this.b.put(paramString1, paramString2);
        paramString1 = b();
        da.a("HalleyOperInfo_" + ac.c(), paramString1, true);
      }
      AppMethodBeat.o(147337);
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(147336);
    label157:
    for (;;)
    {
      try
      {
        if (!dd.a(paramString)) {}
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
                break label157;
              }
              Object localObject1 = localObject2[0];
              localObject2 = localObject2[1];
              this.b.put(localObject1, localObject2);
              break label157;
            }
          }
          if (paramBoolean) {
            da.a("HalleyOperInfo_" + ac.c(), paramString, true);
          }
          AppMethodBeat.o(147336);
          return;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(147336);
        return;
      }
    }
  }
  
  public final String b()
  {
    AppMethodBeat.i(147338);
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
      ??? = localStringBuilder.toString();
      AppMethodBeat.o(147338);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cb
 * JD-Core Version:    0.7.0.1
 */