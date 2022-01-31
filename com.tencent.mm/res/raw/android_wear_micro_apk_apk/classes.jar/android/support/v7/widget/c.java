package android.support.v7.widget;

final class c
{
  int al;
  int re;
  Object rf;
  int rg;
  
  c(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.al = paramInt1;
    this.re = paramInt2;
    this.rg = paramInt3;
    this.rf = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (c)paramObject;
          if (this.al != paramObject.al) {
            return false;
          }
        } while ((this.al == 3) && (Math.abs(this.rg - this.re) == 1) && (this.rg == paramObject.re) && (this.re == paramObject.rg));
        if (this.rg != paramObject.rg) {
          return false;
        }
        if (this.re != paramObject.re) {
          return false;
        }
        if (this.rf == null) {
          break;
        }
      } while (this.rf.equals(paramObject.rf));
      return false;
    } while (paramObject.rf == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.al * 31 + this.re) * 31 + this.rg;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (this.al)
    {
    default: 
      str = "??";
    }
    for (;;)
    {
      return str + ",s:" + this.re + "c:" + this.rg + ",p:" + this.rf + "]";
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.c
 * JD-Core Version:    0.7.0.1
 */