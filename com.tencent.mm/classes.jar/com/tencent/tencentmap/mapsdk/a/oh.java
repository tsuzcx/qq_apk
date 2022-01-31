package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.List;

public final class oh
  extends pi
  implements pg
{
  private ma a = null;
  private ah.o b = null;
  
  public oh(View paramView)
  {
    this.a = ((ma)paramView);
    if ((this.a != null) && (this.a.a(lp.class) == null)) {
      this.a.a(lp.class, this);
    }
  }
  
  final qk a(ql paramql, og paramog)
  {
    if (this.a == null) {}
    lp locallp;
    do
    {
      return null;
      locallp = new lp(this.a);
      locallp.a(paramql);
      locallp.c();
    } while (!this.a.a(locallp));
    this.a.getMap().a();
    paramql = new qk(paramql, paramog, locallp.u());
    locallp.a(paramql);
    return paramql;
  }
  
  public final void a()
  {
    if (this.a != null)
    {
      this.a.b(lp.class);
      this.a = null;
    }
  }
  
  final void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramString, true);
    this.a.getMap().a();
  }
  
  final void a(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lp)) {
      return;
    }
    paramString = (lp)paramString;
    paramString.d(paramFloat);
    paramString.c();
    this.a.getMap().a();
  }
  
  final void a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.b(paramInt);
    paramString.c();
    this.a.getMap().a();
  }
  
  final void a(String paramString, pr parampr)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lp)) {
      return;
    }
    paramString = (lp)paramString;
    paramString.a(parampr);
    paramString.c();
    this.a.getMap().a();
  }
  
  final void a(String paramString, List<qc> paramList)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lp)) {
      return;
    }
    paramString = (lp)paramString;
    try
    {
      paramString.a(paramList);
      label59:
      paramString.c();
      this.a.getMap().a();
      return;
    }
    catch (IndexOutOfBoundsException paramList)
    {
      break label59;
    }
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.a_(paramBoolean);
    paramString.c();
    this.a.getMap().a();
  }
  
  public final boolean a(ln paramln, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
    paramln = (lp)paramln;
    paramBoolean = paramln.f().j();
    if ((this.b != null) && (paramBoolean))
    {
      paramGeoPoint = lq.a(paramGeoPoint);
      this.b.a(paramln.f(), paramGeoPoint);
      return true;
    }
    return false;
  }
  
  final List<kj> b(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if ((paramString == null) || (!(paramString instanceof lp))) {
        return null;
      }
      paramString = (lp)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString.g());
      return ???;
    }
  }
  
  final void b()
  {
    if (this.a != null) {
      this.a.c(lp.class);
    }
  }
  
  final void b(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lp)) {
      return;
    }
    paramString = (lp)paramString;
    paramString.c(paramFloat);
    paramString.c();
    this.a.getMap().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oh
 * JD-Core Version:    0.7.0.1
 */