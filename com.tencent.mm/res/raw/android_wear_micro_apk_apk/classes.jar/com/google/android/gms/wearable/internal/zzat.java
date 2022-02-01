package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzat
  extends zza
{
  public static final Parcelable.Creator<zzat> CREATOR = new r();
  public final List<zzo> Vb;
  public final int statusCode;
  
  public zzat(int paramInt, List<zzo> paramList)
  {
    this.statusCode = paramInt;
    this.Vb = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzat
 * JD-Core Version:    0.7.0.1
 */