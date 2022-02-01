package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzban
  extends zza
{
  public static final Parcelable.Creator<zzban> CREATOR = new cw();
  final int IR;
  final boolean Sv;
  final List<Scope> Sw;
  
  zzban(int paramInt, boolean paramBoolean, List<Scope> paramList)
  {
    this.IR = paramInt;
    this.Sv = paramBoolean;
    this.Sw = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cw.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzban
 * JD-Core Version:    0.7.0.1
 */