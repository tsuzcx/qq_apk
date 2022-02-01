package com.google.android.gms.internal;

public final class bd<L>
{
  private final L LA;
  private final String QR;
  
  bd(L paramL, String paramString)
  {
    this.LA = paramL;
    this.QR = paramString;
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
    } while ((this.LA == paramObject.LA) && (this.QR.equals(paramObject.QR)));
    return false;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this.LA) * 31 + this.QR.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bd
 * JD-Core Version:    0.7.0.1
 */