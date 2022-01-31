package com.google.android.gms.internal;

public final class dk
  extends dq<dk>
{
  private static volatile dk[] QP;
  public dl QQ = null;
  public String name = "";
  
  public dk()
  {
    this.Rr = null;
    this.RB = -1;
  }
  
  public static dk[] jO()
  {
    if (QP == null) {}
    synchronized (du.RA)
    {
      if (QP == null) {
        QP = new dk[0];
      }
      return QP;
    }
  }
  
  public final void a(do paramdo)
  {
    paramdo.b(1, this.name);
    if (this.QQ != null) {
      paramdo.a(2, this.QQ);
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
      if (this.QQ == null)
      {
        if (paramObject.QQ != null) {
          return false;
        }
      }
      else if (!this.QQ.equals(paramObject.QQ)) {
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
    int i;
    int j;
    if (this.name == null)
    {
      i = 0;
      if (this.QQ != null) {
        break label89;
      }
      j = 0;
      label33:
      k = m;
      if (this.Rr != null) {
        if (!this.Rr.isEmpty()) {
          break label100;
        }
      }
    }
    label89:
    label100:
    for (int k = m;; k = this.Rr.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.name.hashCode();
      break;
      j = this.QQ.hashCode();
      break label33;
    }
  }
  
  protected final int jN()
  {
    int j = super.jN() + do.c(1, this.name);
    int i = j;
    if (this.QQ != null) {
      i = j + do.b(2, this.QQ);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dk
 * JD-Core Version:    0.7.0.1
 */