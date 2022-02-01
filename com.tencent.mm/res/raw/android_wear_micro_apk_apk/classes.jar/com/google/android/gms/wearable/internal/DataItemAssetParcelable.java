package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.m;

@KeepName
public class DataItemAssetParcelable
  extends zza
  implements ReflectedParcelable, m
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new l();
  private final String If;
  private final String UP;
  
  public DataItemAssetParcelable(m paramm)
  {
    this.If = ((String)d.D(paramm.getId()));
    this.UP = ((String)d.D(paramm.kF()));
  }
  
  DataItemAssetParcelable(String paramString1, String paramString2)
  {
    this.If = paramString1;
    this.UP = paramString2;
  }
  
  public final String getId()
  {
    return this.If;
  }
  
  public final String kF()
  {
    return this.UP;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */