package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.l;

public final class i
  implements j
{
  private int GT;
  private l Tf;
  
  public i(j paramj)
  {
    this.GT = paramj.getType();
    this.Tf = ((l)paramj.ku().freeze());
  }
  
  public final int getType()
  {
    return this.GT;
  }
  
  public final l ku()
  {
    return this.Tf;
  }
  
  public final String toString()
  {
    String str1;
    if (this.GT == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(this.Tf);
      return String.valueOf(str1).length() + 35 + String.valueOf(str2).length() + "DataEventEntity{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (this.GT == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.i
 * JD-Core Version:    0.7.0.1
 */