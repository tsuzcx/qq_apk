package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.t;
import java.util.List;
import java.util.Set;

public class zzo
  extends zza
{
  public static final Parcelable.Creator<zzo> CREATOR = new ck();
  private final Object Lk = new Object();
  private final List<zzcc> WC;
  private Set<t> WD;
  private final String mName;
  
  public zzo(String paramString, List<zzcc> paramList)
  {
    this.mName = paramString;
    this.WC = paramList;
    this.WD = null;
    d.D(this.mName);
    d.D(this.WC);
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
      paramObject = (zzo)paramObject;
      if (this.mName != null)
      {
        if (this.mName.equals(paramObject.mName)) {}
      }
      else {
        while (paramObject.mName != null) {
          return false;
        }
      }
      if (this.WC == null) {
        break;
      }
    } while (this.WC.equals(paramObject.WC));
    for (;;)
    {
      return false;
      if (paramObject.WC == null) {
        break;
      }
    }
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.mName != null) {}
    for (int i = this.mName.hashCode();; i = 0)
    {
      if (this.WC != null) {
        j = this.WC.hashCode();
      }
      return (i + 31) * 31 + j;
    }
  }
  
  public final List<zzcc> lg()
  {
    return this.WC;
  }
  
  public String toString()
  {
    String str1 = this.mName;
    String str2 = String.valueOf(this.WC);
    return String.valueOf(str1).length() + 18 + String.valueOf(str2).length() + "CapabilityInfo{" + str1 + ", " + str2 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ck.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzo
 * JD-Core Version:    0.7.0.1
 */