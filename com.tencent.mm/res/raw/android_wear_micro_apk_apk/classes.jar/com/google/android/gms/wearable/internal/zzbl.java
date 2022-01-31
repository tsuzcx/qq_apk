package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzbl
  extends zza
{
  public static final Parcelable.Creator<zzbl> CREATOR = new ac();
  public final List<zzcc> Tv;
  public final int statusCode;
  
  public zzbl(int paramInt, List<zzcc> paramList)
  {
    this.statusCode = paramInt;
    this.Tv = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ac.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */