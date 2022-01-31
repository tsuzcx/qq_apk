package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.d;
import java.util.Arrays;

public abstract class g
{
  protected final DataHolder Ia;
  protected int Iu;
  private int Iv;
  
  public g(DataHolder paramDataHolder, int paramInt)
  {
    this.Ia = ((DataHolder)d.u(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < this.Ia.Ik)) {}
    for (boolean bool = true;; bool = false)
    {
      d.v(bool);
      this.Iu = paramInt;
      this.Iv = this.Ia.be(this.Iu);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      bool1 = bool2;
      if (b.b(Integer.valueOf(paramObject.Iu), Integer.valueOf(this.Iu)))
      {
        bool1 = bool2;
        if (b.b(Integer.valueOf(paramObject.Iv), Integer.valueOf(this.Iv)))
        {
          bool1 = bool2;
          if (paramObject.Ia == this.Ia) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected final byte[] getByteArray(String paramString)
  {
    return this.Ia.d(paramString, this.Iu, this.Iv);
  }
  
  protected final int getInteger(String paramString)
  {
    return this.Ia.b(paramString, this.Iu, this.Iv);
  }
  
  protected final String getString(String paramString)
  {
    return this.Ia.c(paramString, this.Iu, this.Iv);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.Iu), Integer.valueOf(this.Iv), this.Ia });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.7.0.1
 */