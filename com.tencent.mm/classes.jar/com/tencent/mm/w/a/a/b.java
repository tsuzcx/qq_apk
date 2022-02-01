package com.tencent.mm.w.a.a;

import com.tencent.mm.w.a;
import com.tencent.mm.w.c;
import com.tencent.mm.w.e;

public abstract class b
  extends a
{
  public final void a(c paramc)
  {
    String str = paramc.fTO;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new e();
        if (str.equals("androidStartNativeActivity"))
        {
          i = 0;
          continue;
          if (str.equals("androidStartNativeActivityForResult"))
          {
            i = 1;
            continue;
            if (str.equals("androidStartFlutterActivity"))
            {
              i = 2;
              continue;
              if (str.equals("androidFinishActivity"))
              {
                i = 3;
                continue;
                if (str.equals("onNavigationObserverPushRoute"))
                {
                  i = 4;
                  continue;
                  if (str.equals("onNavigationObserverPopRoute")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramc.qa("plugin");
    paramc.qa("entry");
    paramc.qa("arguments");
    k(paramc);
    return;
    paramc.qa("plugin");
    paramc.qa("entry");
    paramc.qa("arguments");
    paramc.qa("name");
    ((Integer)paramc.qa("requestCode")).intValue();
    l(paramc);
    return;
    c((String)paramc.qa("route"), paramc);
    return;
    qc((String)paramc.qa("route"));
    return;
    d((String)paramc.qa("route"), paramc);
    return;
    paramc.qa("route");
    m(paramc);
  }
  
  public final String acK()
  {
    return "Route";
  }
  
  public abstract void c(String paramString, c paramc);
  
  public abstract void d(String paramString, c paramc);
  
  public abstract void k(c paramc);
  
  public abstract void l(c paramc);
  
  public abstract void m(c paramc);
  
  public abstract void qc(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.a.a.b
 * JD-Core Version:    0.7.0.1
 */