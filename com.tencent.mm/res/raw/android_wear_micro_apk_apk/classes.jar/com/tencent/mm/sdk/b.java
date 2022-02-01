package com.tencent.mm.sdk;

final class b
{
  Object YJ;
  Runnable YK;
  int what;
  
  public b(a parama, int paramInt, Object paramObject, Runnable paramRunnable)
  {
    this.what = paramInt;
    this.YJ = paramObject;
    this.YK = paramRunnable;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.what == this.what)
      {
        bool1 = bool2;
        if (paramObject.YK == this.YK)
        {
          bool1 = bool2;
          if (paramObject.YJ == this.YJ) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (this.YJ != null) {}
    for (int i = this.YJ.hashCode();; i = 0)
    {
      if (this.YK != null) {
        j = this.YK.hashCode();
      }
      return i + j + this.what;
    }
  }
  
  public final String toString()
  {
    return "WrapMessage{token=" + this.YJ + ", what=" + this.what + ", callback=" + this.YK + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b
 * JD-Core Version:    0.7.0.1
 */