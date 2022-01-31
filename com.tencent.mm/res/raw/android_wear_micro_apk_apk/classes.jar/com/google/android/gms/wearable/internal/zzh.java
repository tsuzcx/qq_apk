package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzh
  extends zza
{
  public static final Parcelable.Creator<zzh> CREATOR = new cf();
  private byte UB;
  private final byte UC;
  private final String mValue;
  
  public zzh(byte paramByte1, byte paramByte2, String paramString)
  {
    this.UB = paramByte1;
    this.UC = paramByte2;
    this.mValue = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zzh)paramObject;
      if (this.UB != paramObject.UB) {
        return false;
      }
      if (this.UC != paramObject.UC) {
        return false;
      }
    } while (this.mValue.equals(paramObject.mValue));
    return false;
  }
  
  public final String getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    return ((this.UB + 31) * 31 + this.UC) * 31 + this.mValue.hashCode();
  }
  
  public final byte kN()
  {
    return this.UB;
  }
  
  public final byte kO()
  {
    return this.UC;
  }
  
  public String toString()
  {
    int i = this.UB;
    int j = this.UC;
    String str = this.mValue;
    return String.valueOf(str).length() + 73 + "AmsEntityUpdateParcelable{, mEntityId=" + i + ", mAttributeId=" + j + ", mValue='" + str + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cf.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzh
 * JD-Core Version:    0.7.0.1
 */