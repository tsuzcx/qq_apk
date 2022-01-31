package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.l;

public final class j
  extends g
  implements com.google.android.gms.wearable.j
{
  private final int Tj;
  
  public j(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Tj = paramInt2;
  }
  
  public final int getType()
  {
    return getInteger("event_type");
  }
  
  public final l ku()
  {
    return new p(this.Ia, this.Iu, this.Tj);
  }
  
  public final String toString()
  {
    String str1;
    if (getInteger("event_type") == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(ku());
      return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "DataEventRef{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getInteger("event_type") == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.j
 * JD-Core Version:    0.7.0.1
 */