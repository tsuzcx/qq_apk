package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzcs
  extends zza
{
  public static final Parcelable.Creator<zzcs> CREATOR = new bk();
  public final long TQ;
  public final List<zzcg> TU;
  public final int statusCode;
  
  public zzcs(int paramInt, long paramLong, List<zzcg> paramList)
  {
    this.statusCode = paramInt;
    this.TQ = paramLong;
    this.TU = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bk.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcs
 * JD-Core Version:    0.7.0.1
 */