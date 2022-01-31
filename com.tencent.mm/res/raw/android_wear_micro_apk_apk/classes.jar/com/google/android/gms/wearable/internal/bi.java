package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.d;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.c;

final class bi
  implements c
{
  private final String TS;
  private final c TT;
  
  bi(String paramString, c paramc)
  {
    this.TS = ((String)d.u(paramString));
    this.TT = ((c)d.u(paramc));
  }
  
  public final void a(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.TT.a(paramChannel, paramInt1, paramInt2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bi)) {
        return false;
      }
      paramObject = (bi)paramObject;
    } while ((this.TT.equals(paramObject.TT)) && (this.TS.equals(paramObject.TS)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.TS.hashCode() * 31 + this.TT.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bi
 * JD-Core Version:    0.7.0.1
 */