package com.google.android.gms.internal;

import java.util.Arrays;

public final class dm
  extends dq<dm>
{
  public byte[] SI = dz.TD;
  public String SJ = "";
  public double SK = 0.0D;
  public float SL = 0.0F;
  public long SM = 0L;
  public int SN = 0;
  public int SO = 0;
  public boolean SP = false;
  public dk[] SQ = dk.jX();
  public dl[] SR = dl.jY();
  public String[] SS = dz.TB;
  public long[] ST = dz.Tx;
  public float[] SU = dz.Ty;
  public long SV = 0L;
  
  public dm()
  {
    this.Tg = null;
    this.Tq = -1;
  }
  
  public final void a(do paramdo)
  {
    int i = 1;
    int j = 0;
    Object localObject;
    if (!Arrays.equals(this.SI, dz.TD))
    {
      localObject = this.SI;
      paramdo.ae(1, 2);
      paramdo.bR(localObject.length);
      paramdo.d((byte[])localObject);
    }
    if ((this.SJ != null) && (!this.SJ.equals(""))) {
      paramdo.b(2, this.SJ);
    }
    if (Double.doubleToLongBits(this.SK) != Double.doubleToLongBits(0.0D))
    {
      double d = this.SK;
      paramdo.ae(3, 1);
      paramdo.f(Double.doubleToLongBits(d));
    }
    if (Float.floatToIntBits(this.SL) != Float.floatToIntBits(0.0F)) {
      paramdo.c(4, this.SL);
    }
    if (this.SM != 0L) {
      paramdo.a(5, this.SM);
    }
    if (this.SN != 0) {
      paramdo.ac(6, this.SN);
    }
    if (this.SO != 0)
    {
      int k = this.SO;
      paramdo.ae(7, 0);
      paramdo.bR(do.bT(k));
    }
    if (this.SP)
    {
      boolean bool = this.SP;
      paramdo.ae(8, 0);
      if (!bool) {
        break label283;
      }
    }
    for (;;)
    {
      paramdo.bP(i);
      if ((this.SQ == null) || (this.SQ.length <= 0)) {
        break;
      }
      i = 0;
      while (i < this.SQ.length)
      {
        localObject = this.SQ[i];
        if (localObject != null) {
          paramdo.a(9, (dw)localObject);
        }
        i += 1;
      }
      label283:
      i = 0;
    }
    if ((this.SR != null) && (this.SR.length > 0))
    {
      i = 0;
      while (i < this.SR.length)
      {
        localObject = this.SR[i];
        if (localObject != null) {
          paramdo.a(10, (dw)localObject);
        }
        i += 1;
      }
    }
    if ((this.SS != null) && (this.SS.length > 0))
    {
      i = 0;
      while (i < this.SS.length)
      {
        localObject = this.SS[i];
        if (localObject != null) {
          paramdo.b(11, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.ST != null) && (this.ST.length > 0))
    {
      i = 0;
      while (i < this.ST.length)
      {
        paramdo.a(12, this.ST[i]);
        i += 1;
      }
    }
    if (this.SV != 0L) {
      paramdo.a(13, this.SV);
    }
    if ((this.SU != null) && (this.SU.length > 0))
    {
      i = j;
      while (i < this.SU.length)
      {
        paramdo.c(14, this.SU[i]);
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
      if (!Arrays.equals(this.SI, paramObject.SI)) {
        return false;
      }
      if (this.SJ == null)
      {
        if (paramObject.SJ != null) {
          return false;
        }
      }
      else if (!this.SJ.equals(paramObject.SJ)) {
        return false;
      }
      if (Double.doubleToLongBits(this.SK) != Double.doubleToLongBits(paramObject.SK)) {
        return false;
      }
      if (Float.floatToIntBits(this.SL) != Float.floatToIntBits(paramObject.SL)) {
        return false;
      }
      if (this.SM != paramObject.SM) {
        return false;
      }
      if (this.SN != paramObject.SN) {
        return false;
      }
      if (this.SO != paramObject.SO) {
        return false;
      }
      if (this.SP != paramObject.SP) {
        return false;
      }
      if (!du.equals(this.SQ, paramObject.SQ)) {
        return false;
      }
      if (!du.equals(this.SR, paramObject.SR)) {
        return false;
      }
      if (!du.equals(this.SS, paramObject.SS)) {
        return false;
      }
      if (!du.equals(this.ST, paramObject.ST)) {
        return false;
      }
      if (!du.equals(this.SU, paramObject.SU)) {
        return false;
      }
      if (this.SV != paramObject.SV) {
        return false;
      }
      if ((this.Tg != null) && (!this.Tg.isEmpty())) {
        break;
      }
    } while ((paramObject.Tg == null) || (paramObject.Tg.isEmpty()));
    return false;
    return this.Tg.equals(paramObject.Tg);
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = Arrays.hashCode(this.SI);
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
    if (this.SJ == null)
    {
      i = 0;
      long l = Double.doubleToLongBits(this.SK);
      i2 = (int)(l ^ l >>> 32);
      i3 = Float.floatToIntBits(this.SL);
      i4 = (int)(this.SM ^ this.SM >>> 32);
      i5 = this.SN;
      i6 = this.SO;
      if (!this.SP) {
        break label288;
      }
      j = 1231;
      i7 = du.hashCode(this.SQ);
      i8 = du.hashCode(this.SR);
      i9 = du.hashCode(this.SS);
      i10 = du.hashCode(this.ST);
      i11 = du.hashCode(this.SU);
      i12 = (int)(this.SV ^ this.SV >>> 32);
      k = m;
      if (this.Tg != null) {
        if (!this.Tg.isEmpty()) {
          break label295;
        }
      }
    }
    label288:
    label295:
    for (int k = m;; k = this.Tg.hashCode())
    {
      return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
      i = this.SJ.hashCode();
      break;
      j = 1237;
      break label100;
    }
  }
  
  protected final int jW()
  {
    int j = super.jW();
    int i = j;
    Object localObject;
    if (!Arrays.equals(this.SI, dz.TD))
    {
      localObject = this.SI;
      i = do.bQ(1);
      k = do.bS(localObject.length);
      i = j + (localObject.length + k + i);
    }
    j = i;
    if (this.SJ != null)
    {
      j = i;
      if (!this.SJ.equals("")) {
        j = i + do.c(2, this.SJ);
      }
    }
    i = j;
    if (Double.doubleToLongBits(this.SK) != Double.doubleToLongBits(0.0D)) {
      i = j + (do.bQ(3) + 8);
    }
    j = i;
    if (Float.floatToIntBits(this.SL) != Float.floatToIntBits(0.0F)) {
      j = i + (do.bQ(4) + 4);
    }
    int k = j;
    if (this.SM != 0L) {
      k = j + do.b(5, this.SM);
    }
    i = k;
    if (this.SN != 0) {
      i = k + do.ad(6, this.SN);
    }
    j = i;
    if (this.SO != 0)
    {
      j = this.SO;
      k = do.bQ(7);
      j = i + (do.bS(do.bT(j)) + k);
    }
    i = j;
    if (this.SP) {
      i = j + (do.bQ(8) + 1);
    }
    j = i;
    if (this.SQ != null)
    {
      j = i;
      if (this.SQ.length > 0)
      {
        j = 0;
        while (j < this.SQ.length)
        {
          localObject = this.SQ[j];
          k = i;
          if (localObject != null) {
            k = i + do.c(9, (dw)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.SR != null)
    {
      i = j;
      if (this.SR.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.SR.length)
        {
          localObject = this.SR[j];
          k = i;
          if (localObject != null) {
            k = i + do.c(10, (dw)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.SS != null)
    {
      j = i;
      if (this.SS.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.SS.length; m = n)
        {
          localObject = this.SS[j];
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
    if (this.ST != null)
    {
      i = j;
      if (this.ST.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.ST.length)
        {
          k += do.e(this.ST[i]);
          i += 1;
        }
        i = j + k + this.ST.length * 1;
      }
    }
    j = i;
    if (this.SV != 0L) {
      j = i + do.b(13, this.SV);
    }
    i = j;
    if (this.SU != null)
    {
      i = j;
      if (this.SU.length > 0) {
        i = j + this.SU.length * 4 + this.SU.length * 1;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dm
 * JD-Core Version:    0.7.0.1
 */