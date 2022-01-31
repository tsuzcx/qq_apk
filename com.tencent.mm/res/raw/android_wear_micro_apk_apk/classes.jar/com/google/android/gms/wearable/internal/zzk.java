package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzk
  extends zza
{
  public static final Parcelable.Creator<zzk> CREATOR = new ch();
  private final String Gt;
  private final String UD;
  private final String UE;
  private final String UF;
  private final String UG;
  private final String UH;
  private final byte UI;
  private final byte UJ;
  private final byte UK;
  private final byte UL;
  private final String UM;
  private int de;
  
  public zzk(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, String paramString7)
  {
    this.de = paramInt;
    this.UD = paramString1;
    this.UE = paramString2;
    this.UF = paramString3;
    this.UG = paramString4;
    this.UH = paramString5;
    this.Gt = paramString6;
    this.UI = paramByte1;
    this.UJ = paramByte2;
    this.UK = paramByte3;
    this.UL = paramByte4;
    this.UM = paramString7;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zzk)paramObject;
      if (this.de != paramObject.de) {
        return false;
      }
      if (this.UI != paramObject.UI) {
        return false;
      }
      if (this.UJ != paramObject.UJ) {
        return false;
      }
      if (this.UK != paramObject.UK) {
        return false;
      }
      if (this.UL != paramObject.UL) {
        return false;
      }
      if (!this.UD.equals(paramObject.UD)) {
        return false;
      }
      if (this.UE != null)
      {
        if (this.UE.equals(paramObject.UE)) {}
      }
      else {
        while (paramObject.UE != null) {
          return false;
        }
      }
      if (!this.UF.equals(paramObject.UF)) {
        return false;
      }
      if (!this.UG.equals(paramObject.UG)) {
        return false;
      }
      if (!this.UH.equals(paramObject.UH)) {
        return false;
      }
      if (this.Gt != null)
      {
        if (this.Gt.equals(paramObject.Gt)) {}
      }
      else {
        while (paramObject.Gt != null) {
          return false;
        }
      }
      if (this.UM != null) {
        return this.UM.equals(paramObject.UM);
      }
    } while (paramObject.UM == null);
    return false;
  }
  
  public final String getDisplayName()
  {
    if (this.Gt == null) {
      return this.UD;
    }
    return this.Gt;
  }
  
  public final int getId()
  {
    return this.de;
  }
  
  public final String getPackageName()
  {
    return this.UM;
  }
  
  public final String getTitle()
  {
    return this.UG;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = this.de;
    int n = this.UD.hashCode();
    int i;
    int i1;
    int i2;
    int i3;
    if (this.UE != null)
    {
      i = this.UE.hashCode();
      i1 = this.UF.hashCode();
      i2 = this.UG.hashCode();
      i3 = this.UH.hashCode();
      if (this.Gt == null) {
        break label187;
      }
    }
    label187:
    for (int j = this.Gt.hashCode();; j = 0)
    {
      int i4 = this.UI;
      int i5 = this.UJ;
      int i6 = this.UK;
      int i7 = this.UL;
      if (this.UM != null) {
        k = this.UM.hashCode();
      }
      return (((((j + ((((i + ((m + 31) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String kP()
  {
    return this.UD;
  }
  
  public final String kQ()
  {
    return this.UE;
  }
  
  public final String kR()
  {
    return this.UF;
  }
  
  public final String kS()
  {
    return this.UH;
  }
  
  public final byte kT()
  {
    return this.UI;
  }
  
  public final byte kU()
  {
    return this.UJ;
  }
  
  public final byte kV()
  {
    return this.UK;
  }
  
  public final byte kW()
  {
    return this.UL;
  }
  
  public final String toString()
  {
    int i = this.de;
    String str1 = this.UD;
    String str2 = this.UE;
    String str3 = this.UF;
    String str4 = this.UG;
    String str5 = this.UH;
    String str6 = this.Gt;
    int j = this.UI;
    int k = this.UJ;
    int m = this.UK;
    int n = this.UL;
    String str7 = this.UM;
    return String.valueOf(str1).length() + 211 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + "AncsNotificationParcelable{, id=" + i + ", appId='" + str1 + "', dateTime='" + str2 + "', notificationText='" + str3 + "', title='" + str4 + "', subtitle='" + str5 + "', displayName='" + str6 + "', eventId=" + j + ", eventFlags=" + k + ", categoryId=" + m + ", categoryCount=" + n + ", packageName='" + str7 + "'}";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ch.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzk
 * JD-Core Version:    0.7.0.1
 */