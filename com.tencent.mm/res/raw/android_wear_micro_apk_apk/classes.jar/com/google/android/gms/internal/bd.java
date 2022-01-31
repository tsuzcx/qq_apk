package com.google.android.gms.internal;

public final class bd<L>
{
  private final L JL;
  private final String Pc;
  
  bd(L paramL, String paramString)
  {
    this.JL = paramL;
    this.Pc = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bd)) {
        return false;
      }
      paramObject = (bd)paramObject;
    } while ((this.JL == paramObject.JL) && (this.Pc.equals(paramObject.Pc)));
    return false;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this.JL) * 31 + this.Pc.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bd
 * JD-Core Version:    0.7.0.1
 */