package com.google.android.gms.internal;

public abstract class dq<M extends dq<M>>
  extends dw
{
  protected ds Tg;
  
  public void a(do paramdo)
  {
    if (this.Tg == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.Tg.size())
      {
        this.Tg.bV(i).a(paramdo);
        i += 1;
      }
    }
  }
  
  protected final boolean a(dn paramdn, int paramInt)
  {
    int i = paramdn.getPosition();
    if (!paramdn.bK(paramInt)) {
      return false;
    }
    int j = dz.bZ(paramInt);
    dy localdy = new dy(paramInt, paramdn.ab(i, paramdn.getPosition() - i));
    paramdn = null;
    if (this.Tg == null) {
      this.Tg = new ds();
    }
    for (;;)
    {
      Object localObject = paramdn;
      if (paramdn == null)
      {
        localObject = new dt();
        this.Tg.a(j, (dt)localObject);
      }
      ((dt)localObject).a(localdy);
      return true;
      paramdn = this.Tg.bU(j);
    }
  }
  
  protected int jW()
  {
    if (this.Tg != null)
    {
      int j = 0;
      for (int i = 0;; i = k + i)
      {
        k = i;
        if (j >= this.Tg.size()) {
          break;
        }
        k = this.Tg.bV(j).jW();
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