package com.google.android.gms.internal;

import java.util.Arrays;

public final class dm
  extends dq<dm>
{
  public byte[] QT = dz.RO;
  public String QU = "";
  public double QV = 0.0D;
  public float QW = 0.0F;
  public long QX = 0L;
  public int QY = 0;
  public int QZ = 0;
  public boolean Ra = false;
  public dk[] Rb = dk.jO();
  public dl[] Rc = dl.jP();
  public String[] Rd = dz.RM;
  public long[] Re = dz.RI;
  public float[] Rf = dz.RJ;
  public long Rg = 0L;
  
  public dm()
  {
    this.Rr = null;
    this.RB = -1;
  }
  
  public final void a(do paramdo)
  {
    int i = 1;
    int j = 0;
    Object localObject;
    if (!Arrays.equals(this.QT, dz.RO))
    {
      localObject = this.QT;
      paramdo.ac(1, 2);
      paramdo.bx(localObject.length);
      paramdo.d((byte[])localObject);
    }
    if ((this.QU != null) && (!this.QU.equals(""))) {
      paramdo.b(2, this.QU);
    }
    if (Double.doubleToLongBits(this.QV) != Double.doubleToLongBits(0.0D))
    {
      double d = this.QV;
      paramdo.ac(3, 1);
      paramdo.e(Double.doubleToLongBits(d));
    }
    if (Float.floatToIntBits(this.QW) != Float.floatToIntBits(0.0F)) {
      paramdo.b(4, this.QW);
    }
    if (this.QX != 0L) {
      paramdo.a(5, this.QX);
    }
    if (this.QY != 0) {
      paramdo.aa(6, this.QY);
    }
    if (this.QZ != 0)
    {
      int k = this.QZ;
      paramdo.ac(7, 0);
      paramdo.bx(do.bz(k));
    }
    if (this.Ra)
    {
      boolean bool = this.Ra;
      paramdo.ac(8, 0);
      if (!bool) {
        break label283;
      }
    }
    for (;;)
    {
      paramdo.bv(i);
      if ((this.Rb == null) || (this.Rb.length <= 0)) {
        break;
      }
      i = 0;
      while (i < this.Rb.length)
      {
        localObject = this.Rb[i];
        if (localObject != null) {
          paramdo.a(9, (dw)localObject);
        }
        i += 1;
      }
      label283:
      i = 0;
    }
    if ((this.Rc != null) && (this.Rc.length > 0))
    {
      i = 0;
      while (i < this.Rc.length)
      {
        localObject = this.Rc[i];
        if (localObject != null) {
          paramdo.a(10, (dw)localObject);
        }
        i += 1;
      }
    }
    if ((this.Rd != null) && (this.Rd.length > 0))
    {
      i = 0;
      while (i < this.Rd.length)
      {
        localObject = this.Rd[i];
        if (localObject != null) {
          paramdo.b(11, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.Re != null) && (this.Re.length > 0))
    {
      i = 0;
      while (i < this.Re.length)
      {
        paramdo.a(12, this.Re[i]);
        i += 1;
      }
    }
    if (this.Rg != 0L) {
      paramdo.a(13, this.Rg);
    }
    if ((this.Rf != null) && (this.Rf.length > 0))
    {
      i = j;
      while (i < this.Rf.length)
      {
        paramdo.b(14, this.Rf[i]);
        i += 1;
      }
    }
    super.a(paramdo);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof dm)) {
        return false;
      }
      paramObject = (dm)paramObject;
      if (!Arrays.equals(this.QT, paramObject.QT)) {
        return false;
      }
      if (this.QU == null)
      {
        if (paramObject.QU != null) {
          return false;
        }
      }
      else if (!this.QU.equals(paramObject.QU)) {
        return false;
      }
      if (Double.doubleToLongBits(this.QV) != Double.doubleToLongBits(paramObject.QV)) {
        return false;
      }
      if (Float.floatToIntBits(this.QW) != Float.floatToIntBits(paramObject.QW)) {
        return false;
      }
      if (this.QX != paramObject.QX) {
        return false;
      }
      if (this.QY != paramObject.QY) {
        return false;
      }
      if (this.QZ != paramObject.QZ) {
        return false;
      }
      if (this.Ra != paramObject.Ra) {
        return false;
      }
      if (!du.equals(this.Rb, paramObject.Rb)) {
        return false;
      }
      if (!du.equals(this.Rc, paramObject.Rc)) {
        return false;
      }
      if (!du.equals(this.Rd, paramObject.Rd)) {
        return false;
      }
      if (!du.equals(this.Re, paramObject.Re)) {
        return false;
      }
      if (!du.equals(this.Rf, paramObject.Rf)) {
        return false;
      }
      if (this.Rg != paramObject.Rg) {
        return false;
      }
      if ((this.Rr != null) && (!this.Rr.isEmpty())) {
        break;
      }
    } while ((paramObject.Rr == null) || (paramObject.Rr.isEmpty()));
    return false;
    return this.Rr.equals(paramObject.Rr);
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = Arrays.hashCode(this.QT);
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int j;
    label100:
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    if (this.QU == null)
    {
      i = 0;
      long l = Double.doubleToLongBits(this.QV);
      i2 = (int)(l ^ l >>> 32);
      i3 = Float.floatToIntBits(this.QW);
      i4 = (int)(this.QX ^ this.QX >>> 32);
      i5 = this.QY;
      i6 = this.QZ;
      if (!this.Ra) {
        break label288;
      }
      j = 1231;
      i7 = du.hashCode(this.Rb);
      i8 = du.hashCode(this.Rc);
      i9 = du.hashCode(this.Rd);
      i10 = du.hashCode(this.Re);
      i11 = du.hashCode(this.Rf);
      i12 = (int)(this.Rg ^ this.Rg >>> 32);
      k = m;
      if (this.Rr != null) {
        if (!this.Rr.isEmpty()) {
          break label295;
        }
      }
    }
    label288:
    label295:
    for (int k = m;; k = this.Rr.hashCode())
    {
      return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
      i = this.QU.hashCode();
      break;
      j = 1237;
      break label100;
    }
  }
  
  protected final int jN()
  {
    int j = super.jN();
    int i = j;
    Object localObject;
    if (!Arrays.equals(this.QT, dz.RO))
    {
      localObject = this.QT;
      i = do.bw(1);
      k = do.by(localObject.length);
      i = j + (localObject.length + k + i);
    }
    j = i;
    if (this.QU != null)
    {
      j = i;
      if (!this.QU.equals("")) {
        j = i + do.c(2, this.QU);
      }
    }
    i = j;
    if (Double.doubleToLongBits(this.QV) != Double.doubleToLongBits(0.0D)) {
      i = j + (do.bw(3) + 8);
    }
    j = i;
    if (Float.floatToIntBits(this.QW) != Float.floatToIntBits(0.0F)) {
      j = i + (do.bw(4) + 4);
    }
    int k = j;
    if (this.QX != 0L) {
      k = j + do.b(5, this.QX);
    }
    i = k;
    if (this.QY != 0) {
      i = k + do.ab(6, this.QY);
    }
    j = i;
    if (this.QZ != 0)
    {
      j = this.QZ;
      k = do.bw(7);
      j = i + (do.by(do.bz(j)) + k);
    }
    i = j;
    if (this.Ra) {
      i = j + (do.bw(8) + 1);
    }
    j = i;
    if (this.Rb != null)
    {
      j = i;
      if (this.Rb.length > 0)
      {
        j = 0;
        while (j < this.Rb.length)
        {
          localObject = this.Rb[j];
          k = i;
          if (localObject != null) {
            k = i + do.b(9, (dw)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Rc != null)
    {
      i = j;
      if (this.Rc.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Rc.length)
        {
          localObject = this.Rc[j];
          k = i;
          if (localObject != null) {
            k = i + do.b(10, (dw)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Rd != null)
    {
      j = i;
      if (this.Rd.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.Rd.length; m = n)
        {
          localObject = this.Rd[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + do.r((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.Re != null)
    {
      i = j;
      if (this.Re.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.Re.length)
        {
          k += do.c(this.Re[i]);
          i += 1;
        }
        i = j + k + this.Re.length * 1;
      }
    }
    j = i;
    if (this.Rg != 0L) {
      j = i + do.b(13, this.Rg);
    }
    i = j;
    if (this.Rf != null)
    {
      i = j;
      if (this.Rf.length > 0) {
        i = j + this.Rf.length * 4 + this.Rf.length * 1;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dm
 * JD-Core Version:    0.7.0.1
 */