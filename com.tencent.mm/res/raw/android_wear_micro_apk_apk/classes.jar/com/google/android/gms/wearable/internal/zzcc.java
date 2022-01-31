package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.t;

public class zzcc
  extends zza
  implements t
{
  public static final Parcelable.Creator<zzcc> CREATOR = new bb();
  private final String Gq;
  private final String Gt;
  private final int TN;
  private final boolean TO;
  
  public zzcc(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.Gq = paramString1;
    this.Gt = paramString2;
    this.TN = paramInt;
    this.TO = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzcc)) {
      return false;
    }
    return ((zzcc)paramObject).Gq.equals(this.Gq);
  }
  
  public final String getDisplayName()
  {
    return this.Gt;
  }
  
  public final int getHopCount()
  {
    return this.TN;
  }
  
  public final String getId()
  {
    return this.Gq;
  }
  
  public int hashCode()
  {
    return this.Gq.hashCode();
  }
  
  public final boolean kJ()
  {
    return this.TO;
  }
  
  public String toString()
  {
    String str1 = this.Gt;
    String str2 = this.Gq;
    int i = this.TN;
    boolean bool = this.TO;
    return String.valueOf(str1).length() + 45 + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bb.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcc
 * JD-Core Version:    0.7.0.1
 */