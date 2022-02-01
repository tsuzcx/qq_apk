package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$m
  extends e
{
  public int IkT = 0;
  public byte[] IkU = g.bIZ;
  public a.bc[] IkV = a.bc.flB();
  public a.ar[] IkW = a.ar.flw();
  public int IkX = 0;
  public int IkY = 0;
  public String groupId = "";
  public int hyp = 0;
  public int nPB = -1;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$m()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(2, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(3, this.zkU);
    }
    if (this.nPB != -1) {
      paramb.by(4, this.nPB);
    }
    if (this.IkT != 0) {
      paramb.by(5, this.IkT);
    }
    if (!Arrays.equals(this.IkU, g.bIZ)) {
      paramb.b(6, this.IkU);
    }
    int i;
    Object localObject;
    if ((this.IkV != null) && (this.IkV.length > 0))
    {
      i = 0;
      while (i < this.IkV.length)
      {
        localObject = this.IkV[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.IkW != null) && (this.IkW.length > 0))
    {
      i = j;
      while (i < this.IkW.length)
      {
        localObject = this.IkW[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.IkX != 0) {
      paramb.by(9, this.IkX);
    }
    if (this.IkY != 0) {
      paramb.by(10, this.IkY);
    }
    if (this.hyp != 0) {
      paramb.by(11, this.hyp);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int m = 0;
    int j = super.yg();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.zkT != 0) {
      j = i + b.bA(2, this.zkT);
    }
    i = j;
    if (this.zkU != 0L) {
      i = j + b.q(3, this.zkU);
    }
    j = i;
    if (this.nPB != -1) {
      j = i + b.bA(4, this.nPB);
    }
    int k = j;
    if (this.IkT != 0) {
      k = j + b.bA(5, this.IkT);
    }
    i = k;
    if (!Arrays.equals(this.IkU, g.bIZ)) {
      i = k + b.c(6, this.IkU);
    }
    j = i;
    Object localObject;
    if (this.IkV != null)
    {
      j = i;
      if (this.IkV.length > 0)
      {
        j = 0;
        while (j < this.IkV.length)
        {
          localObject = this.IkV[j];
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
    if (this.IkW != null)
    {
      i = j;
      if (this.IkW.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.IkW.length) {
            break;
          }
          localObject = this.IkW[k];
          i = j;
          if (localObject != null) {
            i = j + b.b(8, (e)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    j = i;
    if (this.IkX != 0) {
      j = i + b.bA(9, this.IkX);
    }
    i = j;
    if (this.IkY != 0) {
      i = j + b.bA(10, this.IkY);
    }
    j = i;
    if (this.hyp != 0) {
      j = i + b.bA(11, this.hyp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */