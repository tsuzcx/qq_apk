package com.google.android.gms.internal;

public final class dj
  extends dq<dj>
{
  public dk[] QO = dk.jO();
  
  public dj()
  {
    this.Rr = null;
    this.RB = -1;
  }
  
  public final void a(do paramdo)
  {
    if ((this.QO != null) && (this.QO.length > 0))
    {
      int i = 0;
      while (i < this.QO.length)
      {
        dk localdk = this.QO[i];
        if (localdk != null) {
          paramdo.a(1, localdk);
        }
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
      if (!(paramObject instanceof dj)) {
        return false;
      }
      paramObject = (dj)paramObject;
      if (!du.equals(this.QO, paramObject.QO)) {
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
    int j = getClass().getName().hashCode();
    int k = du.hashCode(this.QO);
    if ((this.Rr == null) || (this.Rr.isEmpty())) {}
    for (int i = 0;; i = this.Rr.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  protected final int jN()
  {
    int i = super.jN();
    int k = i;
    if (this.QO != null)
    {
      k = i;
      if (this.QO.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.QO.length) {
            break;
          }
          dk localdk = this.QO[j];
          k = i;
          if (localdk != null) {
            k = i + do.b(1, localdk);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dj
 * JD-Core Version:    0.7.0.1
 */