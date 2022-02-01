package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$bg
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int ZeV = 0;
  public a.ba[] Zgp = a.ba.ikV();
  public String ZhI = "";
  public int Ziq = 0;
  public String Zir = "";
  public String[] Zis = g.EMPTY_STRING_ARRAY;
  public long Zit = 0L;
  public String groupId = "";
  
  public a$bg()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    if (this.ZeV != 0) {
      j = i + b.bN(4, this.ZeV);
    }
    int k = j;
    if (this.Ziq != 0) {
      k = j + b.bM(5, this.Ziq);
    }
    i = k;
    if (!this.ZhI.equals("")) {
      i = k + b.g(6, this.ZhI);
    }
    j = i;
    Object localObject;
    if (this.Zgp != null)
    {
      j = i;
      if (this.Zgp.length > 0)
      {
        j = 0;
        while (j < this.Zgp.length)
        {
          localObject = this.Zgp[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!this.Zir.equals("")) {
      i = j + b.g(8, this.Zir);
    }
    j = i;
    if (this.Zis != null)
    {
      j = i;
      if (this.Zis.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.Zis.length; m = n)
        {
          localObject = this.Zis[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cv((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.Zit != 0L) {
      i = j + b.q(10, this.Zit);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if (this.ZeV != 0) {
      paramb.bK(4, this.ZeV);
    }
    if (this.Ziq != 0) {
      paramb.bJ(5, this.Ziq);
    }
    if (!this.ZhI.equals("")) {
      paramb.f(6, this.ZhI);
    }
    int i;
    Object localObject;
    if ((this.Zgp != null) && (this.Zgp.length > 0))
    {
      i = 0;
      while (i < this.Zgp.length)
      {
        localObject = this.Zgp[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.Zir.equals("")) {
      paramb.f(8, this.Zir);
    }
    if ((this.Zis != null) && (this.Zis.length > 0))
    {
      i = j;
      while (i < this.Zis.length)
      {
        localObject = this.Zis[i];
        if (localObject != null) {
          paramb.f(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.Zit != 0L) {
      paramb.n(10, this.Zit);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bg
 * JD-Core Version:    0.7.0.1
 */