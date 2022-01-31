package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ba$a
  extends gr
{
  private av d;
  private String e;
  
  public ba$a(ba paramba, av paramav, String paramString)
  {
    this.d = paramav;
    this.e = paramString;
  }
  
  private void a()
  {
    Object localObject = this.d.b;
    localObject = cb.a(((aq)localObject).c(), ((aq)localObject).d, ((aq)localObject).c, ((aq)localObject).g);
    if (localObject != null) {
      b((ArrayList)((an)localObject).a, (ArrayList)((an)localObject).b);
    }
  }
  
  private void a(ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    paramArrayList1 = ba.a(this.a, this.e, paramArrayList1, paramArrayList2);
    if (paramArrayList1 != null)
    {
      ba.a(this.a).put(this.d, paramArrayList1);
      paramArrayList2 = ba.a(this.a, paramArrayList1);
      this.d.c.a(paramArrayList2);
      this.d.b.a(paramArrayList2);
      bc.c(this.e + " async refresh serviceinfos:" + paramArrayList1);
    }
  }
  
  private void b(ArrayList<bg> paramArrayList1, ArrayList<bg> paramArrayList2)
  {
    paramArrayList1 = ba.b(this.a, this.e, paramArrayList1, paramArrayList2);
    if (paramArrayList1 != null)
    {
      ba.a(this.a).put(this.d, paramArrayList1);
      paramArrayList2 = ba.a(this.a, paramArrayList1);
      this.d.c.a(paramArrayList2);
      this.d.b.a(paramArrayList2);
      bc.c(this.e + " async refresh serviceinfos:" + paramArrayList1);
    }
  }
  
  public void a(int paramInt)
  {
    bc.a(this.e + " callback_findObjectById_exception " + paramInt);
  }
  
  public void a(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    if (paramInt == 0)
    {
      a(paramArrayList1, paramArrayList2);
      cb.a(this.e, this.d.b.b());
      bc.c(this.e + " callback_findObjectById4All finish");
      return;
    }
    a();
    bc.b(this.e + "async findObjectById4All error , return " + paramInt);
  }
  
  public void a(ArrayList<fq> paramArrayList)
  {
    bc.a(this.e + "callback_findObjectById is not used");
  }
  
  public void b(int paramInt)
  {
    bc.a(this.e + " callback_findObjectById4All_exception " + paramInt);
  }
  
  public void b(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    if (paramInt == 0)
    {
      a(paramArrayList1, paramArrayList2);
      cb.a(this.e, this.d.b.b());
      bc.c(this.e + " callback_findObjectByIdInSameGroup finish");
      return;
    }
    a();
    bc.b(this.e + "async findObjectByIdInSameGroup error , return " + paramInt);
  }
  
  public void c(int paramInt)
  {
    bc.a(this.e + " callback_findObjectByIdInSameGroup_exception " + paramInt);
  }
  
  public void c(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    if (paramInt == 0)
    {
      a(paramArrayList1, paramArrayList2);
      cb.a(this.e, this.d.b.b());
      bc.c(this.e + " callback_findObjectByIdInSameStation finish");
      return;
    }
    a();
    bc.b(this.e + "async findObjectByIdInSameStation error , return " + paramInt);
  }
  
  public void d(int paramInt)
  {
    bc.a(this.e + " callback_findObjectByIdInSameStation_exception " + paramInt);
  }
  
  public void d(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    if (paramInt == 0)
    {
      a(paramArrayList1, paramArrayList2);
      cb.a(this.e, this.d.b.b());
      bc.c(this.e + " callback_findObjectByIdInSameSet finish");
      return;
    }
    a();
    bc.b(this.e + " async findObjectByIdInSameSet error , return " + paramInt);
  }
  
  public void e(int paramInt)
  {
    bc.a(this.e + " callback_findObjectByIdInSameSet_exception " + paramInt);
  }
  
  public void e(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2) {}
  
  public void f(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ba.a
 * JD-Core Version:    0.7.0.1
 */