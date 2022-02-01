package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.d;
import java.util.Arrays;

public abstract class g
{
  protected final DataHolder JP;
  protected int Kj;
  private int Kk;
  
  public g(DataHolder paramDataHolder, int paramInt)
  {
    this.JP = ((DataHolder)d.D(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < this.JP.JZ)) {}
    for (boolean bool = true;; bool = false)
    {
      d.y(bool);
      this.Kj = paramInt;
      this.Kk = this.JP.by(this.Kj);
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
      if (b.c(Integer.valueOf(paramObject.Kj), Integer.valueOf(this.Kj)))
      {
        bool1 = bool2;
        if (b.c(Integer.valueOf(paramObject.Kk), Integer.valueOf(this.Kk)))
        {
          bool1 = bool2;
          if (paramObject.JP == this.JP) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected final byte[] getByteArray(String paramString)
  {
    return this.JP.d(paramString, this.Kj, this.Kk);
  }
  
  protected final int getInteger(String paramString)
  {
    return this.JP.b(paramString, this.Kj, this.Kk);
  }
  
  protected final String getString(String paramString)
  {
    return this.JP.c(paramString, this.Kj, this.Kk);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.Kj), Integer.valueOf(this.Kk), this.JP });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.7.0.1
 */