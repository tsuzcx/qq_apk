package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzk
  extends zza
{
  public static final Parcelable.Creator<zzk> CREATOR = new ch();
  private final String Ii;
  private final byte WA;
  private final String WB;
  private final String Ws;
  private final String Wt;
  private final String Wu;
  private final String Wv;
  private final String Ww;
  private final byte Wx;
  private final byte Wy;
  private final byte Wz;
  private int eS;
  
  public zzk(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, String paramString7)
  {
    this.eS = paramInt;
    this.Ws = paramString1;
    this.Wt = paramString2;
    this.Wu = paramString3;
    this.Wv = paramString4;
    this.Ww = paramString5;
    this.Ii = paramString6;
    this.Wx = paramByte1;
    this.Wy = paramByte2;
    this.Wz = paramByte3;
    this.WA = paramByte4;
    this.WB = paramString7;
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
      if (this.eS != paramObject.eS) {
        return false;
      }
      if (this.Wx != paramObject.Wx) {
        return false;
      }
      if (this.Wy != paramObject.Wy) {
        return false;
      }
      if (this.Wz != paramObject.Wz) {
        return false;
      }
      if (this.WA != paramObject.WA) {
        return false;
      }
      if (!this.Ws.equals(paramObject.Ws)) {
        return false;
      }
      if (this.Wt != null)
      {
        if (this.Wt.equals(paramObject.Wt)) {}
      }
      else {
        while (paramObject.Wt != null) {
          return false;
        }
      }
      if (!this.Wu.equals(paramObject.Wu)) {
        return false;
      }
      if (!this.Wv.equals(paramObject.Wv)) {
        return false;
      }
      if (!this.Ww.equals(paramObject.Ww)) {
        return false;
      }
      if (this.Ii != null)
      {
        if (this.Ii.equals(paramObject.Ii)) {}
      }
      else {
        while (paramObject.Ii != null) {
          return false;
        }
      }
      if (this.WB != null) {
        return this.WB.equals(paramObject.WB);
      }
    } while (paramObject.WB == null);
    return false;
  }
  
  public final String getDisplayName()
  {
    if (this.Ii == null) {
      return this.Ws;
    }
    return this.Ii;
  }
  
  public final int getId()
  {
    return this.eS;
  }
  
  public final String getPackageName()
  {
    return this.WB;
  }
  
  public final String getTitle()
  {
    return this.Wv;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = this.eS;
    int n = this.Ws.hashCode();
    int i;
    int i1;
    int i2;
    int i3;
    if (this.Wt != null)
    {
      i = this.Wt.hashCode();
      i1 = this.Wu.hashCode();
      i2 = this.Wv.hashCode();
      i3 = this.Ww.hashCode();
      if (this.Ii == null) {
        break label187;
      }
    }
    label187:
    for (int j = this.Ii.hashCode();; j = 0)
    {
      int i4 = this.Wx;
      int i5 = this.Wy;
      int i6 = this.Wz;
      int i7 = this.WA;
      if (this.WB != null) {
        k = this.WB.hashCode();
      }
      return (((((j + ((((i + ((m + 31) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String kY()
  {
    return this.Ws;
  }
  
  public final String kZ()
  {
    return this.Wt;
  }
  
  public final String la()
  {
    return this.Wu;
  }
  
  public final String lb()
  {
    return this.Ww;
  }
  
  public final byte lc()
  {
    return this.Wx;
  }
  
  public final byte ld()
  {
    return this.Wy;
  }
  
  public final byte le()
  {
    return this.Wz;
  }
  
  public final byte lf()
  {
    return this.WA;
  }
  
  public final String toString()
  {
    int i = this.eS;
    String str1 = this.Ws;
    String str2 = this.Wt;
    String str3 = this.Wu;
    String str4 = this.Wv;
    String str5 = this.Ww;
    String str6 = this.Ii;
    int j = this.Wx;
    int k = this.Wy;
    int m = this.Wz;
    int n = this.WA;
    String str7 = this.WB;
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