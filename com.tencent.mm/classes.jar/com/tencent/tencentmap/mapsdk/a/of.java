package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.List;

public class of
  extends ph
{
  private ma a = null;
  
  public of(View paramView)
  {
    this.a = ((ma)paramView);
  }
  
  private ArrayList<GeoPoint> a(List<qc> paramList)
  {
    if (paramList == null) {}
    int j;
    do
    {
      return null;
      j = paramList.size();
    } while (j <= 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Object localObject = (qc)paramList.get(i);
      if (localObject != null)
      {
        localObject = lq.a((qc)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  qi a(qj paramqj, oe paramoe)
  {
    if (this.a == null) {}
    lo locallo;
    do
    {
      return null;
      locallo = new lo(this.a, paramqj);
      locallo.a(paramqj);
      locallo.c();
    } while (!this.a.a(locallo));
    this.a.getMap().a();
    return new qi(paramqj, paramoe, locallo.u());
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.b(lo.class);
      this.a = null;
    }
  }
  
  void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramString, true);
    this.a.getMap().a();
  }
  
  void a(String paramString, float paramFloat)
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
    paramString.d(paramFloat);
    this.a.getMap().a();
  }
  
  void a(String paramString, int paramInt)
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
    paramString.c(paramInt);
    this.a.getMap().a();
  }
  
  void a(String paramString, List<qc> paramList)
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
    if (!(paramString instanceof lo)) {
      return;
    }
    paramString = (lo)paramString;
    paramString.a(a(paramList));
    paramString.c();
    this.a.getMap().a();
  }
  
  void a(String paramString, boolean paramBoolean)
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
    this.a.getMap().a();
  }
  
  List<kj> b(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if ((paramString == null) || (!(paramString instanceof lo))) {
        return null;
      }
      paramString = (lo)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      return ???;
    }
  }
  
  void b()
  {
    if (this.a != null) {
      this.a.c(lo.class);
    }
  }
  
  void b(String paramString, float paramFloat)
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
    paramString.c(paramFloat);
    this.a.getMap().a();
  }
  
  void b(String paramString, int paramInt)
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
    this.a.getMap().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.of
 * JD-Core Version:    0.7.0.1
 */