package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.List;

public final class ov
  extends oz
  implements pg
{
  private ma a = null;
  
  public ov(View paramView)
  {
    this.a = ((ma)paramView);
    if (this.a == null) {}
    while (this.a.a(lj.class) != null) {
      return;
    }
    this.a.a(lj.class, this);
  }
  
  final pv a(pw parampw, ou paramou)
  {
    if (this.a == null) {}
    lj locallj;
    do
    {
      return null;
      locallj = new lj(this.a);
      locallj.a(parampw);
      locallj.c();
    } while (!this.a.a(locallj));
    this.a.getMap().a();
    parampw = new pv(parampw, paramou, locallj.u());
    locallj.a(parampw);
    return parampw;
  }
  
  public final void a()
  {
    if (this.a != null)
    {
      this.a.b(lj.class);
      this.a = null;
    }
  }
  
  final void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.b(paramString, false);
      if ((paramString == null) || (!(paramString instanceof lj))) {
        return;
      }
    }
    paramString.d();
    this.a.getMap().a();
  }
  
  final void a(String paramString, double paramDouble)
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
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).a(paramDouble);
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
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).d(paramFloat);
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
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).c(paramInt);
    this.a.getMap().a();
  }
  
  final void a(String paramString, qc paramqc)
  {
    if (this.a == null) {}
    while (paramqc == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).a(lq.a(paramqc));
    this.a.getMap().a();
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
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).a_(paramBoolean);
    this.a.getMap().a();
  }
  
  public final boolean a(ln paramln, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
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
      if ((paramString == null) || (!(paramString instanceof lj))) {
        return null;
      }
      paramString = (lj)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      return ???;
    }
  }
  
  final void b()
  {
    if (this.a != null) {
      this.a.c(lj.class);
    }
  }
  
  final void b(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    ln localln = this.a.a(paramString);
    if (localln != null) {
      localln.c(paramFloat);
    }
    this.a.a(paramString, paramFloat);
    this.a.getMap().a();
  }
  
  final void b(String paramString, int paramInt)
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
    if (!(paramString instanceof lj)) {
      return;
    }
    ((lj)paramString).b(paramInt);
    this.a.getMap().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ov
 * JD-Core Version:    0.7.0.1
 */