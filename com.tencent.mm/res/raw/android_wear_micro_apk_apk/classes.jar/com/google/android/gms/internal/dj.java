package com.google.android.gms.internal;

public final class dj
  extends dq<dj>
{
  public dk[] SD = dk.jX();
  
  public dj()
  {
    this.Tg = null;
    this.Tq = -1;
  }
  
  public final void a(do paramdo)
  {
    if ((this.SD != null) && (this.SD.length > 0))
    {
      int i = 0;
      while (i < this.SD.length)
      {
        dk localdk = this.SD[i];
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
      if (!du.equals(this.SD, paramObject.SD)) {
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
    int j = getClass().getName().hashCode();
    int k = du.hashCode(this.SD);
    if ((this.Tg == null) || (this.Tg.isEmpty())) {}
    for (int i = 0;; i = this.Tg.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  protected final int jW()
  {
    int i = super.jW();
    int k = i;
    if (this.SD != null)
    {
      k = i;
      if (this.SD.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.SD.length) {
            break;
          }
          dk localdk = this.SD[j];
          k = i;
          if (localdk != null) {
            k = i + do.c(1, localdk);
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