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
  private final String Gq;
  private final String Ta;
  
  public DataItemAssetParcelable(m paramm)
  {
    this.Gq = ((String)d.u(paramm.getId()));
    this.Ta = ((String)d.u(paramm.kw()));
  }
  
  DataItemAssetParcelable(String paramString1, String paramString2)
  {
    this.Gq = paramString1;
    this.Ta = paramString2;
  }
  
  public final String getId()
  {
    return this.Gq;
  }
  
  public final String kw()
  {
    return this.Ta;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */