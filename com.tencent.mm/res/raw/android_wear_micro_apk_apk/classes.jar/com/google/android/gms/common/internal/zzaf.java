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
  final int IR;
  IBinder KS;
  private ConnectionResult KT;
  private boolean KU;
  private boolean KV;
  
  zzaf(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.IR = paramInt;
    this.KS = paramIBinder;
    this.KT = paramConnectionResult;
    this.KU = paramBoolean1;
    this.KV = paramBoolean2;
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
    } while ((this.KT.equals(paramObject.KT)) && (al.f(this.KS).equals(al.f(paramObject.KS))));
    return false;
  }
  
  public final ak hf()
  {
    return al.f(this.KS);
  }
  
  public final ConnectionResult hg()
  {
    return this.KT;
  }
  
  public final boolean hh()
  {
    return this.KU;
  }
  
  public final boolean hi()
  {
    return this.KV;
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