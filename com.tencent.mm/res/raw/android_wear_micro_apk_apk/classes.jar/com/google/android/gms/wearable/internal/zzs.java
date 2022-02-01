package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.c;

public final class zzs
  extends zza
{
  public static final Parcelable.Creator<zzs> CREATOR = new co();
  final zzu VE;
  final int WI;
  final int WJ;
  final int type;
  
  public zzs(zzu paramzzu, int paramInt1, int paramInt2, int paramInt3)
  {
    this.VE = paramzzu;
    this.type = paramInt1;
    this.WI = paramInt2;
    this.WJ = paramInt3;
  }
  
  public final void a(c paramc)
  {
    switch (this.type)
    {
    default: 
      int i = this.type;
      Log.w("ChannelEventParcelable", 25 + "Unknown type: " + i);
    case 1: 
    case 2: 
    case 3: 
      return;
    }
    paramc.a(this.VE, this.WI, this.WJ);
  }
  
  public final String toString()
  {
    String str2 = String.valueOf(this.VE);
    int i = this.type;
    String str1;
    String str3;
    switch (i)
    {
    default: 
      str1 = Integer.toString(i);
      str3 = String.valueOf(str1);
      i = this.WI;
      switch (i)
      {
      default: 
        str1 = Integer.toString(i);
      }
      break;
    }
    for (;;)
    {
      str1 = String.valueOf(str1);
      i = this.WJ;
      return String.valueOf(str2).length() + 81 + String.valueOf(str3).length() + String.valueOf(str1).length() + "ChannelEventParcelable[, channel=" + str2 + ", type=" + str3 + ", closeReason=" + str1 + ", appErrorCode=" + i + "]";
      str1 = "CHANNEL_OPENED";
      break;
      str1 = "CHANNEL_CLOSED";
      break;
      str1 = "OUTPUT_CLOSED";
      break;
      str1 = "INPUT_CLOSED";
      break;
      str1 = "CLOSE_REASON_DISCONNECTED";
      continue;
      str1 = "CLOSE_REASON_REMOTE_CLOSE";
      continue;
      str1 = "CLOSE_REASON_LOCAL_CLOSE";
      continue;
      str1 = "CLOSE_REASON_NORMAL";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    co.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzs
 * JD-Core Version:    0.7.0.1
 */