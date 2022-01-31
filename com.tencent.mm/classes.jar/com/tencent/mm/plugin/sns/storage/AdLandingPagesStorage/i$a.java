package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

final class i$a
{
  int oKD;
  int oKE;
  int oKF;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (paramObject.oKD == this.oKD)
      {
        bool1 = bool2;
        if (paramObject.oKE == this.oKE)
        {
          bool1 = bool2;
          if (paramObject.oKF == this.oKF) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.oKD + this.oKE + this.oKF;
  }
  
  public final String toString()
  {
    return "[nodeType=" + this.oKD + ",compType=" + this.oKE + ",subCompType=" + this.oKF + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a
 * JD-Core Version:    0.7.0.1
 */