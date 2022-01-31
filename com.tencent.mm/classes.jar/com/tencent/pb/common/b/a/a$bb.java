package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$bb
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public int wGk = 0;
  public a.av[] wHz = a.av.cOf();
  public String wIO = "";
  public long wJA = 0L;
  public int wJx = 0;
  public String wJy = "";
  public String[] wJz = g.EMPTY_STRING_ARRAY;
  
  public a$bb()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    if (this.wGk != 0) {
      paramb.aM(4, this.wGk);
    }
    if (this.wJx != 0) {
      paramb.aL(5, this.wJx);
    }
    if (!this.wIO.equals("")) {
      paramb.d(6, this.wIO);
    }
    int i;
    Object localObject;
    if ((this.wHz != null) && (this.wHz.length > 0))
    {
      i = 0;
      while (i < this.wHz.length)
      {
        localObject = this.wHz[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.wJy.equals("")) {
      paramb.d(8, this.wJy);
    }
    if ((this.wJz != null) && (this.wJz.length > 0))
    {
      i = j;
      while (i < this.wJz.length)
      {
        localObject = this.wJz[i];
        if (localObject != null) {
          paramb.d(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.wJA != 0L) {
      paramb.h(10, this.wJA);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.pRI != 0) {
      j = i + b.aN(2, this.pRI);
    }
    i = j;
    if (this.pRJ != 0L) {
      i = j + b.k(3, this.pRJ);
    }
    j = i;
    if (this.wGk != 0) {
      j = i + b.aO(4, this.wGk);
    }
    int k = j;
    if (this.wJx != 0) {
      k = j + b.aN(5, this.wJx);
    }
    i = k;
    if (!this.wIO.equals("")) {
      i = k + b.e(6, this.wIO);
    }
    j = i;
    Object localObject;
    if (this.wHz != null)
    {
      j = i;
      if (this.wHz.length > 0)
      {
        j = 0;
        while (j < this.wHz.length)
        {
          localObject = this.wHz[j];
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
    if (!this.wJy.equals("")) {
      i = j + b.e(8, this.wJy);
    }
    j = i;
    if (this.wJz != null)
    {
      j = i;
      if (this.wJz.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.wJz.length; m = n)
        {
          localObject = this.wJz[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.aI((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.wJA != 0L) {
      i = j + b.j(10, this.wJA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.bb
 * JD-Core Version:    0.7.0.1
 */