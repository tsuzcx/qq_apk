package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class f
  extends s.a.a<f>
{
  public int ZIA;
  public int ZIB;
  public int ZIC;
  public int ZID;
  public int ZIu;
  public int ZIx;
  public int ZIy;
  public int ZIz;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1);
    this.ZIx = paramInt2;
    this.ZIu = paramInt3;
    this.ZIy = paramInt4;
    this.ZIz = paramInt5;
    this.ZIA = paramInt6;
    this.ZIB = paramInt7;
    this.ZIC = paramInt8;
    this.ZID = paramInt9;
  }
  
  private int a(f paramf)
  {
    int i = c.nU(this.ZIx, paramf.ZIx);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return i;
                j = c.nV(this.ZIu, paramf.ZIu);
                i = j;
              } while (j != 0);
              j = c.nU(this.ZIy, paramf.ZIy);
              i = j;
            } while (j != 0);
            j = c.nV(this.ZIz, paramf.ZIz);
            i = j;
          } while (j != 0);
          j = c.nU(this.ZIA, paramf.ZIA);
          i = j;
        } while (j != 0);
        j = c.nV(this.ZIB, paramf.ZIB);
        i = j;
      } while (j != 0);
      j = c.nV(this.ZIC, paramf.ZIC);
      i = j;
    } while (j != 0);
    return c.nV(this.ZID, paramf.ZID);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {}
    while (a((f)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.ZIx), Integer.valueOf(this.ZIu), Integer.valueOf(this.ZIy), Integer.valueOf(this.ZIz), Integer.valueOf(this.ZIA), Integer.valueOf(this.ZIB), Integer.valueOf(this.ZIC), Integer.valueOf(this.ZID) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.f
 * JD-Core Version:    0.7.0.1
 */