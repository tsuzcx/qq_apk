package android.support.v7.widget;

final class c
{
  int bU;
  int sU;
  Object sV;
  int sW;
  
  c(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.bU = paramInt1;
    this.sU = paramInt2;
    this.sW = paramInt3;
    this.sV = paramObject;
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
          if (this.bU != paramObject.bU) {
            return false;
          }
        } while ((this.bU == 3) && (Math.abs(this.sW - this.sU) == 1) && (this.sW == paramObject.sU) && (this.sU == paramObject.sW));
        if (this.sW != paramObject.sW) {
          return false;
        }
        if (this.sU != paramObject.sU) {
          return false;
        }
        if (this.sV == null) {
          break;
        }
      } while (this.sV.equals(paramObject.sV));
      return false;
    } while (paramObject.sV == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.bU * 31 + this.sU) * 31 + this.sW;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (this.bU)
    {
    default: 
      str = "??";
    }
    for (;;)
    {
      return str + ",s:" + this.sU + "c:" + this.sW + ",p:" + this.sV + "]";
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