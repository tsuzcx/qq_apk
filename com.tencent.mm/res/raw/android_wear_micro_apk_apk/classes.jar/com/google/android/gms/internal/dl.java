package com.google.android.gms.internal;

public final class dl
  extends dq<dl>
{
  private static volatile dl[] QR;
  public dm QS = null;
  public int type = 1;
  
  public dl()
  {
    this.Rr = null;
    this.RB = -1;
  }
  
  public static dl[] jP()
  {
    if (QR == null) {}
    synchronized (du.RA)
    {
      if (QR == null) {
        QR = new dl[0];
      }
      return QR;
    }
  }
  
  public final void a(do paramdo)
  {
    paramdo.aa(1, this.type);
    if (this.QS != null) {
      paramdo.a(2, this.QS);
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
      if (this.QS == null)
      {
        if (paramObject.QS != null) {
          return false;
        }
      }
      else if (!this.QS.equals(paramObject.QS)) {
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
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.type;
    int i;
    if (this.QS == null)
    {
      i = 0;
      j = k;
      if (this.Rr != null) {
        if (!this.Rr.isEmpty()) {
          break label84;
        }
      }
    }
    label84:
    for (int j = k;; j = this.Rr.hashCode())
    {
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
      i = this.QS.hashCode();
      break;
    }
  }
  
  protected final int jN()
  {
    int j = super.jN() + do.ab(1, this.type);
    int i = j;
    if (this.QS != null) {
      i = j + do.b(2, this.QS);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.7.0.1
 */