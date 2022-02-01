package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacn
  extends zza
{
  public static final Parcelable.Creator<zzacn> CREATOR = new bu();
  final int IR;
  private final zzacp Rr;
  
  zzacn(int paramInt, zzacp paramzzacp)
  {
    this.IR = paramInt;
    this.Rr = paramzzacp;
  }
  
  private zzacn(zzacp paramzzacp)
  {
    this.IR = 1;
    this.Rr = paramzzacp;
  }
  
  public static zzacn a(bx<?, ?> parambx)
  {
    if ((parambx instanceof zzacp)) {
      return new zzacn((zzacp)parambx);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  final zzacp jr()
  {
    return this.Rr;
  }
  
  public final bx<?, ?> js()
  {
    if (this.Rr != null) {
      return this.Rr;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bu.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacn
 * JD-Core Version:    0.7.0.1
 */