package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf
  extends zza
{
  public static final Parcelable.Creator<zzaf> CREATOR = new f();
  final int Hc;
  IBinder Jd;
  private ConnectionResult Je;
  private boolean Jf;
  private boolean Jg;
  
  zzaf(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Hc = paramInt;
    this.Jd = paramIBinder;
    this.Je = paramConnectionResult;
    this.Jf = paramBoolean1;
    this.Jg = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaf)) {
        return false;
      }
      paramObject = (zzaf)paramObject;
    } while ((this.Je.equals(paramObject.Je)) && (al.f(this.Jd).equals(al.f(paramObject.Jd))));
    return false;
  }
  
  public final ak gV()
  {
    return al.f(this.Jd);
  }
  
  public final ConnectionResult gW()
  {
    return this.Je;
  }
  
  public final boolean gX()
  {
    return this.Jf;
  }
  
  public final boolean gY()
  {
    return this.Jg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzaf
 * JD-Core Version:    0.7.0.1
 */