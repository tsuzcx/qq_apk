package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Scope
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new ae();
  final int IR;
  private final String Jz;
  
  Scope(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException(String.valueOf("scopeUri must not be null or empty"));
    }
    this.IR = paramInt;
    this.Jz = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return this.Jz.equals(((Scope)paramObject).Jz);
  }
  
  public final String gO()
  {
    return this.Jz;
  }
  
  public final int hashCode()
  {
    return this.Jz.hashCode();
  }
  
  public final String toString()
  {
    return this.Jz;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ae.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.7.0.1
 */