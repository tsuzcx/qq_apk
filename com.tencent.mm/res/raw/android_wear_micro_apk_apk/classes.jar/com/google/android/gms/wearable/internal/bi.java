package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.d;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.c;

final class bi
  implements c
{
  private final String VH;
  private final c VI;
  
  bi(String paramString, c paramc)
  {
    this.VH = ((String)d.D(paramString));
    this.VI = ((c)d.D(paramc));
  }
  
  public final void a(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.VI.a(paramChannel, paramInt1, paramInt2);
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
    } while ((this.VI.equals(paramObject.VI)) && (this.VH.equals(paramObject.VH)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.VH.hashCode() * 31 + this.VI.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bi
 * JD-Core Version:    0.7.0.1
 */