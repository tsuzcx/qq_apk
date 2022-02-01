package com.google.android.gms.internal;

import java.util.Arrays;

final class dy
{
  final byte[] Tr;
  final int tag;
  
  dy(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.Tr = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof dy)) {
        return false;
      }
      paramObject = (dy)paramObject;
    } while ((this.tag == paramObject.tag) && (Arrays.equals(this.Tr, paramObject.Tr)));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.Tr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dy
 * JD-Core Version:    0.7.0.1
 */