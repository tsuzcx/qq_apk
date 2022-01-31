package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uf$1
{
  ArrayList<ue> a = null;
  ArrayList<ue> b = null;
  ArrayList<ue> c = null;
  ui d;
  private tn e;
  private tj f;
  private int g = 0;
  private List<tw> h;
  private PaintFlagsDrawFilter i;
  
  public uf$1(tn paramtn)
  {
    this.e = paramtn;
    this.f = paramtn.c();
    this.d = new ui(paramtn);
    this.h = new ArrayList();
  }
  
  public static int a(ue.a parama)
  {
    switch (uq.a[parama.ordinal()])
    {
    default: 
      return -1;
    case 1: 
      return tp.g();
    case 2: 
      return tp.b();
    }
    return tp.d();
  }
  
  private ArrayList<ue> a(int paramInt)
  {
    return a(this.f.b(), paramInt, this.f.getWidth(), this.f.getHeight(), this.e.f().d());
  }
  
  private static void a(ArrayList<ue> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ue)localIterator.next()).c();
    }
    paramArrayList.clear();
  }
  
  private static void a(ArrayList<ue> paramArrayList1, ArrayList<ue> paramArrayList2, ArrayList<ue> paramArrayList3)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {
      return;
    }
    int j = 0;
    label14:
    ue localue;
    int k;
    label51:
    Object localObject;
    if (j < paramArrayList1.size())
    {
      localue = (ue)paramArrayList1.get(j);
      if (localue != null)
      {
        if ((paramArrayList2 == null) || (paramArrayList2.size() <= 0)) {
          break label192;
        }
        k = 0;
        if (k >= paramArrayList2.size()) {
          break label192;
        }
        localObject = (ue)paramArrayList2.get(k);
        if (!((ue)localObject).equals(localue)) {
          break label128;
        }
        localObject = ((ue)localObject).b();
        paramArrayList2.remove(k);
      }
    }
    for (;;)
    {
      if (((localObject == null) || (localue.a((List)localObject))) && (paramArrayList3 != null)) {
        paramArrayList3.add(localue);
      }
      j += 1;
      break label14;
      label128:
      k += 1;
      break label51;
      if (paramArrayList2 == null) {
        break;
      }
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList3 = (ue)paramArrayList1.next();
        if ((paramArrayList3 != null) && (paramArrayList3.b() != null)) {
          try
          {
            paramArrayList3.c();
          }
          catch (Exception paramArrayList3) {}
        }
      }
      paramArrayList2.clear();
      return;
      label192:
      localObject = null;
    }
  }
  
  private static void a(List<ue> paramList, tw paramtw)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ue)paramList.next()).a(paramtw);
      }
    }
  }
  
  private boolean a(Canvas paramCanvas, ArrayList<ue> paramArrayList)
  {
    double d1 = this.f.d().b();
    Object localObject = this.f.a();
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool3;
    int j;
    if (paramArrayList != null)
    {
      bool2 = bool3;
      if (paramArrayList.size() > 0)
      {
        int m = ((ue)paramArrayList.get(0)).a();
        int k = this.f.d().a();
        j = k;
        if (this.e.f().e()) {
          j = k - 1;
        }
        d1 *= Math.pow(2.0D, j - m);
        if (d1 != 1.0D)
        {
          Matrix localMatrix = new Matrix();
          paramCanvas.save();
          localMatrix.reset();
          localMatrix.postScale((float)d1, (float)d1, ((PointF)localObject).x, ((PointF)localObject).y);
          paramCanvas.concat(localMatrix);
        }
        j = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (j < paramArrayList.size())
        {
          localObject = (ue)paramArrayList.get(j);
          if (localObject != null)
          {
            bool2 = ((ue)localObject).a(paramCanvas);
            if (!bool2)
            {
              bool1 = false;
              j += 1;
            }
          }
        }
        else
        {
          return bool2;
        }
      }
      catch (Throwable paramArrayList)
      {
        bool2 = bool1;
        if (d1 != 1.0D)
        {
          paramCanvas.restore();
          bool2 = bool1;
        }
      }
    }
  }
  
  private static void b(List<ue> paramList, tw paramtw)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ue)paramList.next()).b(paramtw);
      }
    }
  }
  
  PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PointF localPointF = new PointF();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 >= Math.pow(2.0D, paramInt8)) || (paramInt2 >= Math.pow(2.0D, paramInt8))) {
      paramPointF = null;
    }
    do
    {
      return paramPointF;
      localPointF.x = ((paramInt1 - paramInt3) * paramInt7 + paramPointF.x);
      localPointF.y = ((paramInt2 - paramInt4) * paramInt7 + paramPointF.y);
      if ((localPointF.x + paramInt7 <= 0.0F) || (localPointF.x >= paramInt5) || (localPointF.y + paramInt7 <= 0.0F)) {
        break;
      }
      paramPointF = localPointF;
    } while (localPointF.y < paramInt6);
    return null;
  }
  
  public tw a(si paramsi)
  {
    paramsi = new tw(this.e, paramsi);
    this.h.add(paramsi);
    a(this.b, paramsi);
    a(null, paramsi);
    a(this.c, paramsi);
    this.e.a(false, false);
    return paramsi;
  }
  
  public ArrayList<ue> a(sw paramsw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    if (this.e.f().e()) {
      j = 1;
    }
    double d1 = su.c(j + paramInt1);
    ue.a locala = this.e.f().c();
    new StringBuilder("mapSource:").append(locala);
    int i1 = (int)((paramsw.b() + 20037508.34D) / (paramInt4 * d1));
    double d2 = i1 * paramInt4;
    int i2 = (int)((20037508.34D - paramsw.a()) / (paramInt4 * d1));
    Object localObject1 = new sw(d2 * d1 - 20037508.34D, 20037508.34D - i2 * paramInt4 * d1);
    Object localObject2 = this.f.a();
    PointF localPointF = new PointF();
    localPointF.x = ((float)((((sw)localObject1).b() - paramsw.b()) / d1 + ((PointF)localObject2).x));
    localPointF.y = ((float)(((PointF)localObject2).y - (((sw)localObject1).a() - paramsw.a()) / d1));
    localObject1 = new ue(this.e, i1, i2, paramInt1, a(locala), locala, this.h);
    ((ue)localObject1).a(localPointF);
    paramsw = new ArrayList();
    paramsw.add(localObject1);
    int m = 1;
    for (;;)
    {
      j = 0;
      int n = i1 - m;
      int i3;
      while (n <= i1 + m)
      {
        i3 = i2 + m;
        localObject1 = a(n, i3, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        k = j;
        if (localObject1 != null)
        {
          k = j;
          if (j == 0) {
            k = 1;
          }
          localObject2 = new ue(this.e, n, i3, paramInt1, a(locala), locala, this.h);
          ((ue)localObject2).a((PointF)localObject1);
          paramsw.add(localObject2);
        }
        i3 = i2 - m;
        localObject1 = a(n, i3, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        j = k;
        if (localObject1 != null)
        {
          j = k;
          if (k == 0) {
            j = 1;
          }
          localObject2 = new ue(this.e, n, i3, paramInt1, a(locala), locala, this.h);
          ((ue)localObject2).a((PointF)localObject1);
          paramsw.add(localObject2);
        }
        n += 1;
      }
      n = i2 + m - 1;
      int k = j;
      while (n > i2 - m)
      {
        i3 = i1 + m;
        localObject1 = a(i3, n, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        j = k;
        if (localObject1 != null)
        {
          j = k;
          if (k == 0) {
            j = 1;
          }
          localObject2 = new ue(this.e, i3, n, paramInt1, a(locala), locala, this.h);
          ((ue)localObject2).a((PointF)localObject1);
          paramsw.add(localObject2);
        }
        i3 = i1 - m;
        localObject1 = a(i3, n, i1, i2, localPointF, paramInt2, paramInt3, paramInt4, paramInt1);
        k = j;
        if (localObject1 != null)
        {
          k = j;
          if (j == 0) {
            k = 1;
          }
          localObject2 = new ue(this.e, i3, n, paramInt1, a(locala), locala, this.h);
          ((ue)localObject2).a((PointF)localObject1);
          paramsw.add(localObject2);
        }
        n -= 1;
      }
      if (k == 0) {
        break;
      }
      m += 1;
    }
    return paramsw;
  }
  
  public void a()
  {
    a(null);
    a(this.b);
    a(this.c);
    this.d.a();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean1)
    {
      localObject = ue.a.a;
      if (this.e.l() != 2) {
        break label366;
      }
      localObject = ue.a.c;
      if (this.e.f().c() != localObject)
      {
        this.e.f().a((ue.a)localObject);
        if (this.b != null) {
          this.b.clear();
        }
        if (this.c != null) {
          this.c.clear();
        }
      }
    }
    label106:
    int j;
    if (this.e.f().e())
    {
      this.e.f().a(512);
      j = this.f.d().a();
      if (!this.e.f().e()) {
        break label444;
      }
      j -= 1;
    }
    label426:
    label444:
    for (;;)
    {
      int k;
      if ((this.b != null) && (this.b.size() > 0))
      {
        k = ((ue)this.b.get(0)).a();
        localObject = this.b;
      }
      for (;;)
      {
        int m = k - j;
        ArrayList localArrayList;
        if ((m != 0) || (paramBoolean2))
        {
          if ((this.c == null) || (this.c.size() <= 0)) {
            break label426;
          }
          k = ((ue)this.c.get(0)).a();
          localArrayList = this.c;
        }
        for (;;)
        {
          if ((j == k) && (k != -1)) {
            this.b = localArrayList;
          }
          if (Math.abs(m) == 1) {
            this.c = ((ArrayList)localObject);
          }
          localObject = new ArrayList();
          if ((this.c != null) && (this.c.size() > 0))
          {
            localArrayList = a(((ue)this.c.get(0)).a());
            a(localArrayList, this.c, null);
            this.c = localArrayList;
          }
          localArrayList = a(j);
          a(localArrayList, this.b, (ArrayList)localObject);
          this.b = localArrayList;
          this.d.a((ArrayList)localObject);
          this.e.c().invalidate();
          return;
          label366:
          if ((tp.h()) && (this.f.d().a() > 7) && (!b()))
          {
            localObject = ue.a.b;
            break;
          }
          localObject = ue.a.a;
          break;
          this.e.f().a(256);
          break label106;
          localArrayList = null;
          k = -1;
        }
        localObject = null;
        k = -1;
      }
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool1 = false;
    a(paramCanvas, null);
    a(paramCanvas, this.c);
    if (this.i == null) {
      this.i = new PaintFlagsDrawFilter(0, 2);
    }
    paramCanvas.setDrawFilter(this.i);
    boolean bool2 = a(paramCanvas, this.b);
    paramCanvas.setDrawFilter(null);
    if (bool2)
    {
      if (this.c != null) {
        this.c.clear();
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(tw paramtw)
  {
    boolean bool = this.h.remove(paramtw);
    if (bool)
    {
      b(this.b, paramtw);
      b(null, paramtw);
      b(this.c, paramtw);
    }
    this.e.a(false, false);
    return bool;
  }
  
  public boolean b()
  {
    sw[] arrayOfsw1 = this.e.b().b();
    tm.a();
    sw[] arrayOfsw2 = tm.c("china");
    int k = arrayOfsw1.length;
    int j = 0;
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2 = bool1;
      if (j < k)
      {
        bool1 |= tm.a(arrayOfsw1[j], arrayOfsw2);
        if (bool1) {
          bool2 = true;
        }
      }
      else
      {
        return bool2;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uf.1
 * JD-Core Version:    0.7.0.1
 */