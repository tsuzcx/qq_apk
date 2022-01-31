package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.f;
import java.io.File;

public class nd
{
  private ma a = null;
  private mz b = null;
  private ne c = new ne();
  private int d;
  
  public nd(ma paramma)
  {
    this.a = paramma;
    e();
  }
  
  public static void a(int paramInt, w paramw)
  {
    new Thread(new nd.1(paramw, paramInt)).start();
  }
  
  private boolean a(b[] paramArrayOfb)
  {
    if (this.a == null) {
      return true;
    }
    return my.a(this.a.getScreenFrontierPoint(), paramArrayOfb);
  }
  
  private void e()
  {
    v.c(r.b(this.a.getContext()) + "/tencentmapsdk/rastermap/unmainland");
    v.c(r.a(this.a.getContext()).e().getPath() + "/rastermap/taiwan");
  }
  
  private void f()
  {
    if ((this.a == null) || (this.a.getMap() == null) || (this.b == null)) {
      return;
    }
    f localf = this.a.getMap();
    a(this.b.u());
    localf.g(true);
    localf.h(true);
    this.b = null;
  }
  
  private void g()
  {
    if ((this.a == null) || (this.a.getMap() == null)) {
      return;
    }
    f localf = this.a.getMap();
    localf.g(false);
    localf.h(false);
    this.b = a(this.c);
  }
  
  public ma a()
  {
    return this.a;
  }
  
  public mz a(ne paramne)
  {
    if (this.a == null) {
      return null;
    }
    paramne = new mz(this, paramne);
    this.a.a(paramne);
    this.a.getMap().a();
    this.d = 0;
    return paramne;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.d += paramInt;
      return;
    }
    finally {}
  }
  
  public void a(qb paramqb)
  {
    this.c.a(paramqb);
  }
  
  public void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramString, true);
    this.a.getMap().a();
  }
  
  public void b()
  {
    a(this.d, w.a(this.a.getContext().getApplicationContext()));
    this.a = null;
    this.d = 0;
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.e();
    }
  }
  
  public void d()
  {
    if ((this.a == null) || (this.a.getMap() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.a.getMap().h() < 7)
          {
            f();
            return;
          }
          if (nb.d()) {
            break;
          }
        } while (this.b == null);
        f();
        return;
        if (!a(my.a().c("china"))) {
          break;
        }
      } while (this.b == null);
      f();
      return;
    } while (this.b != null);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nd
 * JD-Core Version:    0.7.0.1
 */