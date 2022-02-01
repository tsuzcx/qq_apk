package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b
  implements Parcelable.Creator<WakeLockEvent>
{
  static void a(WakeLockEvent paramWakeLockEvent, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramWakeLockEvent.IR);
    c.a(paramParcel, 2, paramWakeLockEvent.getTimeMillis());
    c.a(paramParcel, 4, paramWakeLockEvent.hQ());
    c.c(paramParcel, 5, paramWakeLockEvent.hT());
    c.a(paramParcel, paramWakeLockEvent.hU());
    c.a(paramParcel, 8, paramWakeLockEvent.hW());
    c.a(paramParcel, 10, paramWakeLockEvent.hR());
    c.c(paramParcel, 11, paramWakeLockEvent.getEventType());
    c.a(paramParcel, 12, paramWakeLockEvent.hV());
    c.a(paramParcel, 13, paramWakeLockEvent.hY());
    c.c(paramParcel, 14, paramWakeLockEvent.hX());
    c.a(paramParcel, paramWakeLockEvent.hZ());
    c.a(paramParcel, 16, paramWakeLockEvent.ia());
    c.a(paramParcel, 17, paramWakeLockEvent.hS());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.b
 * JD-Core Version:    0.7.0.1
 */