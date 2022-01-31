package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.map.lib.f;
import org.json.JSONArray;

public class mb
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 0;
  public static int d = 1;
  private s e;
  private o f;
  private f g;
  private boolean h;
  
  public mb(Context paramContext, f paramf, String paramString)
  {
    if (paramString == null) {}
    for (this.e = w.a(paramContext);; this.e = u.a(paramContext, paramString))
    {
      this.g = paramf;
      c();
      this.h = false;
      a(this.h);
      return;
    }
  }
  
  private void c()
  {
    int i = this.e.b("AIEnabled");
    int j = this.e.b("AIType");
    try
    {
      JSONArray localJSONArray = new JSONArray(this.e.a("AIBuildingList"));
      if ((i != -1) && (j != -1) && (localJSONArray != null)) {
        this.f = new o(i, j, localJSONArray);
      }
      if ((this.g != null) && (j == d)) {
        this.g.a(b());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.b(Log.getStackTraceString(localException));
        Object localObject = null;
      }
    }
  }
  
  private boolean d()
  {
    return (this.f != null) && (this.f.a() == b);
  }
  
  public int a()
  {
    if ((this.f != null) && (this.f.a() == b)) {
      return d;
    }
    return c;
  }
  
  public void a(o paramo)
  {
    this.f = paramo;
    if (this.f == null)
    {
      this.e.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
      return;
    }
    this.e.a("AIEnabled", this.f.a());
    this.e.a("AIType", this.f.b());
    if (this.f.c() != null) {
      this.e.a("AIBuildingList", this.f.c().toString());
    }
    if ((this.g != null) && (a() == d)) {
      this.g.a(b());
    }
    a(this.h);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.g == null) {
      return;
    }
    if (!d())
    {
      this.g.d(false);
      return;
    }
    this.g.d(paramBoolean);
  }
  
  public String[] b()
  {
    if (this.f != null) {
      return this.f.d();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mb
 * JD-Core Version:    0.7.0.1
 */