package com.google.android.gms.internal;

public final class dk
  extends dq<dk>
{
  private static volatile dk[] SE;
  public dl SF = null;
  public String name = "";
  
  public dk()
  {
    this.Tg = null;
    this.Tq = -1;
  }
  
  public static dk[] jX()
  {
    if (SE == null) {}
    synchronized (du.Tp)
    {
      if (SE == null) {
        SE = new dk[0];
      }
      return SE;
    }
  }
  
  public final void a(do paramdo)
  {
    paramdo.b(1, this.name);
    if (this.SF != null) {
      paramdo.a(2, this.SF);
    }
    super.a(paramdo);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof dk)) {
        return false;
      }
      paramObject = (dk)paramObject;
      if (this.name == null)
      {
        if (paramObject.name != null) {
          return false;
        }
      }
      else if (!this.name.equals(paramObject.name)) {
        return false;
      }
      if (this.SF == null)
      {
        if (paramObject.SF != null) {
          return false;
        }
      }
      else if (!this.SF.equals(paramObject.SF)) {
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
    int i;
    int j;
    if (this.name == null)
    {
      i = 0;
      if (this.SF != null) {
        break label89;
      }
      j = 0;
      label33:
      k = m;
      if (this.Tg != null) {
        if (!this.Tg.isEmpty()) {
          break label100;
        }
      }
    }
    label89:
    label100:
    for (int k = m;; k = this.Tg.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.name.hashCode();
      break;
      j = this.SF.hashCode();
      break label33;
    }
  }
  
  protected final int jW()
  {
    int j = super.jW() + do.c(1, this.name);
    int i = j;
    if (this.SF != null) {
      i = j + do.c(2, this.SF);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dk
 * JD-Core Version:    0.7.0.1
 */