package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dl
{
  private dn a;
  private Context b;
  private int c = 20000;
  private int d = 0;
  private Runnable e = new dl.1(this);
  
  public dl(Context paramContext)
  {
    this.b = paramContext;
    HashMap localHashMap = new HashMap(2);
    boolean bool = a.g(this.b);
    e.a(paramContext);
    localHashMap.put("A33", e.g(paramContext));
    if (bool)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", a.h(this.b));
      if (!a.b) {
        break label164;
      }
    }
    label164:
    for (paramContext = "Y";; paramContext = "N")
    {
      localHashMap.put("A85", paramContext);
      this.a = e.a(this.b, "rqd_heartbeat", true, 0L, 0L, localHashMap, false);
      return;
      localHashMap.put("A66", "B");
      break;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int c()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (!e.m(this.b)) {}
    do
    {
      return;
      dx localdx = dq.d().f();
      if (localdx != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        localdx.a(new dp.a(this.b, localArrayList));
      }
      a(c() + 1);
    } while (c() % 10 != 0);
    b.a().a(108, this.e, 600000L, this.c);
    a(0);
  }
  
  public final void b()
  {
    String str = a.b(this.b, "HEART_DENGTA", "");
    if (e.g().equals(str))
    {
      cy.a("heartbeat has been uploaded today!", new Object[0]);
      return;
    }
    b.a().a(108, this.e, 0L, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dl
 * JD-Core Version:    0.7.0.1
 */