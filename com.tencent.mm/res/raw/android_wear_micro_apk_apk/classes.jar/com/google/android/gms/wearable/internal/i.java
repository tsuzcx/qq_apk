package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.l;

public final class i
  implements j
{
  private int II;
  private l UU;
  
  public i(j paramj)
  {
    this.II = paramj.getType();
    this.UU = ((l)paramj.kD().freeze());
  }
  
  public final int getType()
  {
    return this.II;
  }
  
  public final l kD()
  {
    return this.UU;
  }
  
  public final String toString()
  {
    String str1;
    if (this.II == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(this.UU);
      return String.valueOf(str1).length() + 35 + String.valueOf(str2).length() + "DataEventEntity{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (this.II == 2) {
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