package com.google.android.gms.internal;

public abstract class dq<M extends dq<M>>
  extends dw
{
  protected ds Rr;
  
  public void a(do paramdo)
  {
    if (this.Rr == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.Rr.size())
      {
        this.Rr.bB(i).a(paramdo);
        i += 1;
      }
    }
  }
  
  protected final boolean a(dn paramdn, int paramInt)
  {
    int i = paramdn.getPosition();
    if (!paramdn.bq(paramInt)) {
      return false;
    }
    int j = dz.bE(paramInt);
    dy localdy = new dy(paramInt, paramdn.Z(i, paramdn.getPosition() - i));
    paramdn = null;
    if (this.Rr == null) {
      this.Rr = new ds();
    }
    for (;;)
    {
      Object localObject = paramdn;
      if (paramdn == null)
      {
        localObject = new dt();
        this.Rr.a(j, (dt)localObject);
      }
      ((dt)localObject).a(localdy);
      return true;
      paramdn = this.Rr.bA(j);
    }
  }
  
  protected int jN()
  {
    if (this.Rr != null)
    {
      int j = 0;
      for (int i = 0;; i = k + i)
      {
        k = i;
        if (j >= this.Rr.size()) {
          break;
        }
        k = this.Rr.bB(j).jN();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dq
 * JD-Core Version:    0.7.0.1
 */