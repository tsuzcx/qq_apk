package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.m;

public final class k
  implements m
{
  private final String Gq;
  private final String Ta;
  
  public k(m paramm)
  {
    this.Gq = paramm.getId();
    this.Ta = paramm.kw();
  }
  
  public final String getId()
  {
    return this.Gq;
  }
  
  public final String kw()
  {
    return this.Ta;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.Gq == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.Ta);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.Gq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.k
 * JD-Core Version:    0.7.0.1
 */