package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class dk
{
  private int a = 12;
  private int b = 60;
  private int c = 12;
  private int d = 60;
  private int e = 20;
  private boolean f = false;
  private boolean g = true;
  private Set<String> h = null;
  private Map<String, Float> i = null;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public final int a()
  {
    try
    {
      int m = this.a;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (paramMap != null) {}
    for (;;)
    {
      String str;
      try
      {
        str = (String)paramMap.get("realNumUp");
        int m;
        if (str != null)
        {
          m = Integer.valueOf(str).intValue();
          if ((m > 0) && (m <= 50)) {
            this.a = m;
          }
        }
        str = (String)paramMap.get("realDelayUp");
        if (str != null)
        {
          m = Integer.valueOf(str).intValue();
          if ((m >= 10) && (m <= 600)) {
            this.b = m;
          }
        }
        str = (String)paramMap.get("comNumDB");
        if (str != null)
        {
          m = Integer.valueOf(str).intValue();
          if ((m > 0) && (m <= 50)) {
            this.c = m;
          }
        }
        str = (String)paramMap.get("comDelayDB");
        if (str != null)
        {
          m = Integer.valueOf(str).intValue();
          if ((m >= 30) && (m <= 600)) {
            this.d = m;
          }
        }
        str = (String)paramMap.get("comNumUp");
        if (str != null)
        {
          m = Integer.valueOf(str).intValue();
          if ((m > 0) && (m <= 100)) {
            this.e = m;
          }
        }
        str = (String)paramMap.get("heartOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            continue;
          }
          this.g = true;
        }
        str = (String)paramMap.get("tidyEF");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label449;
          }
          this.k = true;
        }
        str = (String)paramMap.get("lauEveSim");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label469;
          }
          this.l = true;
        }
        str = (String)paramMap.get("comPollUp");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label489;
          }
          this.f = true;
        }
        str = (String)paramMap.get("accessTestOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label509;
          }
          cy.b = true;
        }
        str = (String)paramMap.get("upAc");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label528;
          }
          this.j = true;
        }
        paramMap.get("appendXMeths");
      }
      catch (Exception paramMap)
      {
        cy.a(paramMap);
        continue;
      }
      finally {}
      return;
      label528:
      if (str.toLowerCase().equals("n"))
      {
        this.g = false;
        continue;
        label449:
        if (str.toLowerCase().equals("n"))
        {
          this.k = false;
          continue;
          label469:
          if (str.toLowerCase().equals("n"))
          {
            this.l = false;
            continue;
            label489:
            if (str.toLowerCase().equals("n"))
            {
              this.f = false;
              continue;
              label509:
              if (str.toLowerCase().equals("n"))
              {
                cy.b = false;
                continue;
                if (str.toLowerCase().equals("n")) {
                  this.j = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    try
    {
      this.h = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.h != null)
      {
        bool1 = bool2;
        if (this.h.size() > 0) {
          bool1 = this.h.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int m = this.b;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(Set<String> paramSet)
  {
    try
    {
      if (this.i == null) {
        this.i = new HashMap();
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String[] arrayOfString = ((String)paramSet.next()).split(",");
        int m = arrayOfString.length;
        if (m == 3) {
          try
          {
            float f1 = Float.valueOf(arrayOfString[1]).floatValue() / Float.valueOf(arrayOfString[2]).floatValue();
            this.i.put(arrayOfString[0].toLowerCase(), Float.valueOf(f1));
          }
          catch (Exception localException) {}
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.i != null)
        {
          Object localObject = this.i.get(paramString);
          if (localObject != null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        int m = (int)(((Float)this.i.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int n = new Random().nextInt(1000);
        if (n + 1 > m) {
          bool = false;
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public final int c()
  {
    try
    {
      int m = this.c;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int m = this.d;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int m = this.e;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  public final boolean g()
  {
    return this.f;
  }
  
  public final boolean h()
  {
    return this.k;
  }
  
  public final boolean i()
  {
    return this.l;
  }
  
  public final boolean j()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dk
 * JD-Core Version:    0.7.0.1
 */