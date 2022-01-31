package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbak
  extends zza
  implements w
{
  public static final Parcelable.Creator<zzbak> CREATOR = new cu();
  final int Hc;
  private int QE;
  private Intent QF;
  
  public zzbak()
  {
    this((byte)0);
  }
  
  private zzbak(byte paramByte)
  {
    this(2, 0, null);
  }
  
  zzbak(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.Hc = paramInt1;
    this.QE = paramInt2;
    this.QF = paramIntent;
  }
  
  public final Status gC()
  {
    if (this.QE == 0) {
      return Status.HL;
    }
    return Status.HP;
  }
  
  public final int jJ()
  {
    return this.QE;
  }
  
  public final Intent jK()
  {
    return this.QF;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cu.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzbak
 * JD-Core Version:    0.7.0.1
 */