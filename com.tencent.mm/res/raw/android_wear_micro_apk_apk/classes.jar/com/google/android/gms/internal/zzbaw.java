package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaf;

public class zzbaw
  extends zza
{
  public static final Parcelable.Creator<zzbaw> CREATOR = new dg();
  final int IR;
  private final ConnectionResult KT;
  private final zzaf SA;
  
  public zzbaw()
  {
    this(new ConnectionResult(8, null));
  }
  
  zzbaw(int paramInt, ConnectionResult paramConnectionResult, zzaf paramzzaf)
  {
    this.IR = paramInt;
    this.KT = paramConnectionResult;
    this.SA = paramzzaf;
  }
  
  private zzbaw(ConnectionResult paramConnectionResult)
  {
    this(1, paramConnectionResult, null);
  }
  
  public final ConnectionResult hg()
  {
    return this.KT;
  }
  
  public final zzaf jV()
  {
    return this.SA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dg.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzbaw
 * JD-Core Version:    0.7.0.1
 */