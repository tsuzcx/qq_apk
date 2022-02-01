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
  private final String If;
  private final String Ii;
  private final int VC;
  private final boolean VD;
  
  public zzcc(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.If = paramString1;
    this.Ii = paramString2;
    this.VC = paramInt;
    this.VD = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzcc)) {
      return false;
    }
    return ((zzcc)paramObject).If.equals(this.If);
  }
  
  public final String getDisplayName()
  {
    return this.Ii;
  }
  
  public final int getHopCount()
  {
    return this.VC;
  }
  
  public final String getId()
  {
    return this.If;
  }
  
  public int hashCode()
  {
    return this.If.hashCode();
  }
  
  public final boolean kS()
  {
    return this.VD;
  }
  
  public String toString()
  {
    String str1 = this.Ii;
    String str2 = this.If;
    int i = this.VC;
    boolean bool = this.VD;
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