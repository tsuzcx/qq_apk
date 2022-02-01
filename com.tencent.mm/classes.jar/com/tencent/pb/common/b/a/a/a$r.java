package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$r
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public a.ay ZeS = null;
  public int ZeV = 0;
  public a.bd ZeX = null;
  public int ZfB = 0;
  public a.bb[] ZfC = a.bb.ikW();
  public a.ba[] ZfD = a.ba.ikV();
  public a.ax ZfE = null;
  public int ZfF = 0;
  public int ZfG = 0;
  public int ZfH = 0;
  public byte[] ZfI = g.ccX;
  public byte[] ZfJ = g.ccX;
  public a.ba[] ZfK = a.ba.ikV();
  public int ZfL = 0;
  public String groupId = "";
  public int mbp = 0;
  public long msgId = 0L;
  
  public a$r()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int m = 0;
    int j = super.JG();
    int i = j;
    if (this.ZfB != 0) {
      i = j + b.bM(1, this.ZfB);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.g(2, this.groupId);
    }
    i = j;
    if (this.NOc != 0) {
      i = j + b.bM(3, this.NOc);
    }
    j = i;
    if (this.NOd != 0L) {
      j = i + b.p(4, this.NOd);
    }
    int k = j;
    if (this.ZeV != 0) {
      k = j + b.bN(5, this.ZeV);
    }
    i = k;
    if (this.ZeS != null) {
      i = k + b.b(6, this.ZeS);
    }
    j = i;
    Object localObject;
    if (this.ZfC != null)
    {
      j = i;
      if (this.ZfC.length > 0)
      {
        j = 0;
        while (j < this.ZfC.length)
        {
          localObject = this.ZfC[j];
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
    if (this.ZfD != null)
    {
      i = j;
      if (this.ZfD.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.ZfD.length)
        {
          localObject = this.ZfD[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(8, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.ZfE != null) {
      j = i + b.b(9, this.ZfE);
    }
    i = j;
    if (this.ZeX != null) {
      i = j + b.b(10, this.ZeX);
    }
    j = i;
    if (this.ZfF != 0) {
      j = i + b.bN(11, this.ZfF);
    }
    i = j;
    if (this.ZfG != 0) {
      i = j + b.bN(12, this.ZfG);
    }
    j = i;
    if (this.mbp != 0) {
      j = i + b.bN(13, this.mbp);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.q(101, this.msgId);
    }
    j = i;
    if (this.ZfH != 0) {
      j = i + b.bN(102, this.ZfH);
    }
    k = j;
    if (!Arrays.equals(this.ZfI, g.ccX)) {
      k = j + b.c(103, this.ZfI);
    }
    i = k;
    if (!Arrays.equals(this.ZfJ, g.ccX)) {
      i = k + b.c(200, this.ZfJ);
    }
    j = i;
    if (this.ZfK != null)
    {
      j = i;
      if (this.ZfK.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.ZfK.length) {
            break;
          }
          localObject = this.ZfK[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(201, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.ZfL != 0) {
      i = j + b.bM(202, this.ZfL);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.ZfB != 0) {
      paramb.bJ(1, this.ZfB);
    }
    if (!this.groupId.equals("")) {
      paramb.f(2, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(3, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(4, this.NOd);
    }
    if (this.ZeV != 0) {
      paramb.bK(5, this.ZeV);
    }
    if (this.ZeS != null) {
      paramb.a(6, this.ZeS);
    }
    int i;
    Object localObject;
    if ((this.ZfC != null) && (this.ZfC.length > 0))
    {
      i = 0;
      while (i < this.ZfC.length)
      {
        localObject = this.ZfC[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.ZfD != null) && (this.ZfD.length > 0))
    {
      i = 0;
      while (i < this.ZfD.length)
      {
        localObject = this.ZfD[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZfE != null) {
      paramb.a(9, this.ZfE);
    }
    if (this.ZeX != null) {
      paramb.a(10, this.ZeX);
    }
    if (this.ZfF != 0) {
      paramb.bK(11, this.ZfF);
    }
    if (this.ZfG != 0) {
      paramb.bK(12, this.ZfG);
    }
    if (this.mbp != 0) {
      paramb.bK(13, this.mbp);
    }
    if (this.msgId != 0L) {
      paramb.n(101, this.msgId);
    }
    if (this.ZfH != 0) {
      paramb.bK(102, this.ZfH);
    }
    if (!Arrays.equals(this.ZfI, g.ccX)) {
      paramb.b(103, this.ZfI);
    }
    if (!Arrays.equals(this.ZfJ, g.ccX)) {
      paramb.b(200, this.ZfJ);
    }
    if ((this.ZfK != null) && (this.ZfK.length > 0))
    {
      i = j;
      while (i < this.ZfK.length)
      {
        localObject = this.ZfK[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZfL != 0) {
      paramb.bJ(202, this.ZfL);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.r
 * JD-Core Version:    0.7.0.1
 */