package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.m;

public final class k
  implements m
{
  private final String If;
  private final String UP;
  
  public k(m paramm)
  {
    this.If = paramm.getId();
    this.UP = paramm.kF();
  }
  
  public final String getId()
  {
    return this.If;
  }
  
  public final String kF()
  {
    return this.UP;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.If == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.UP);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.If);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.k
 * JD-Core Version:    0.7.0.1
 */