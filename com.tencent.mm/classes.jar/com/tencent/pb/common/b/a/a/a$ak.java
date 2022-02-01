package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$ak
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public a.ay ZeS = null;
  public a.ax ZfE = null;
  public a.ba[] ZfK = a.ba.ikV();
  public a.ba[] Zgp = a.ba.ikV();
  public a.q[] Zgq = a.q.ikN();
  public a.bb[] Zgr = a.bb.ikW();
  public int Zgs = 0;
  public int[] Zgt = g.bZR;
  public String groupId = "";
  
  public a$ak()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int m = 0;
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
    Object localObject;
    if (this.Zgq != null)
    {
      j = i;
      if (this.Zgq.length > 0)
      {
        j = 0;
        while (j < this.Zgq.length)
        {
          localObject = this.Zgq[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(4, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ZfE != null) {
      i = j + b.b(5, this.ZfE);
    }
    j = i;
    if (this.Zgs != 0) {
      j = i + b.bM(6, this.Zgs);
    }
    i = j;
    if (this.Zgt != null)
    {
      i = j;
      if (this.Zgt.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.Zgt.length)
        {
          k += b.gM(this.Zgt[i]);
          i += 1;
        }
        i = j + k + this.Zgt.length * 1;
      }
    }
    j = i;
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
            k = i + b.b(200, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.Zgr != null)
    {
      k = j;
      if (this.Zgr.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Zgr.length)
        {
          localObject = this.Zgr[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(201, (e)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (this.ZeS != null) {
      i = k + b.b(202, this.ZeS);
    }
    k = i;
    if (this.ZfK != null)
    {
      k = i;
      if (this.ZfK.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.ZfK.length) {
            break;
          }
          localObject = this.ZfK[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(203, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
    int i;
    Object localObject;
    if ((this.Zgq != null) && (this.Zgq.length > 0))
    {
      i = 0;
      while (i < this.Zgq.length)
      {
        localObject = this.Zgq[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZfE != null) {
      paramb.a(5, this.ZfE);
    }
    if (this.Zgs != 0) {
      paramb.bJ(6, this.Zgs);
    }
    if ((this.Zgt != null) && (this.Zgt.length > 0))
    {
      i = 0;
      while (i < this.Zgt.length)
      {
        paramb.bJ(7, this.Zgt[i]);
        i += 1;
      }
    }
    if ((this.Zgp != null) && (this.Zgp.length > 0))
    {
      i = 0;
      while (i < this.Zgp.length)
      {
        localObject = this.Zgp[i];
        if (localObject != null) {
          paramb.a(200, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zgr != null) && (this.Zgr.length > 0))
    {
      i = 0;
      while (i < this.Zgr.length)
      {
        localObject = this.Zgr[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZeS != null) {
      paramb.a(202, this.ZeS);
    }
    if ((this.ZfK != null) && (this.ZfK.length > 0))
    {
      i = j;
      while (i < this.ZfK.length)
      {
        localObject = this.ZfK[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ak
 * JD-Core Version:    0.7.0.1
 */