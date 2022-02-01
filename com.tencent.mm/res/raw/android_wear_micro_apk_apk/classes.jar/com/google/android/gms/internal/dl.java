package com.google.android.gms.internal;

public final class dl
  extends dq<dl>
{
  private static volatile dl[] SG;
  public dm SH = null;
  public int type = 1;
  
  public dl()
  {
    this.Tg = null;
    this.Tq = -1;
  }
  
  public static dl[] jY()
  {
    if (SG == null) {}
    synchronized (du.Tp)
    {
      if (SG == null) {
        SG = new dl[0];
      }
      return SG;
    }
  }
  
  public final void a(do paramdo)
  {
    paramdo.ac(1, this.type);
    if (this.SH != null) {
      paramdo.a(2, this.SH);
    }
    super.a(paramdo);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof dl)) {
        return false;
      }
      paramObject = (dl)paramObject;
      if (this.type != paramObject.type) {
        return false;
      }
      if (this.SH == null)
      {
        if (paramObject.SH != null) {
          return false;
        }
      }
      else if (!this.SH.equals(paramObject.SH)) {
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
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.type;
    int i;
    if (this.SH == null)
    {
      i = 0;
      j = k;
      if (this.Tg != null) {
        if (!this.Tg.isEmpty()) {
          break label84;
        }
      }
    }
    label84:
    for (int j = k;; j = this.Tg.hashCode())
    {
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
      i = this.SH.hashCode();
      break;
    }
  }
  
  protected final int jW()
  {
    int j = super.jW() + do.ad(1, this.type);
    int i = j;
    if (this.SH != null) {
      i = j + do.c(2, this.SH);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.7.0.1
 */