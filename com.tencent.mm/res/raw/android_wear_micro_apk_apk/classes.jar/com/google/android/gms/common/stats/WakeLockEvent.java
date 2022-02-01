package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();
  final int IR;
  private final long MA;
  private int MB;
  private final String MC;
  private final String MD;
  private final String ME;
  private final int MF;
  private final List<String> MG;
  private final String MH;
  private final long MI;
  private int MJ;
  private final String MK;
  private final float ML;
  private long MM;
  private final long gY;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this.IR = paramInt1;
    this.MA = paramLong1;
    this.MB = paramInt2;
    this.MC = paramString1;
    this.MD = paramString3;
    this.ME = paramString5;
    this.MF = paramInt3;
    this.MM = -1L;
    this.MG = paramList;
    this.MH = paramString2;
    this.MI = paramLong2;
    this.MJ = paramInt4;
    this.MK = paramString4;
    this.ML = paramFloat;
    this.gY = paramLong3;
  }
  
  public final int getEventType()
  {
    return this.MB;
  }
  
  public final long getTimeMillis()
  {
    return this.MA;
  }
  
  public final long hO()
  {
    return this.MM;
  }
  
  public final String hP()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(this.MC);
    String str7 = String.valueOf("\t");
    int i = this.MF;
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76:
    String str11;
    String str3;
    label94:
    String str12;
    float f;
    String str13;
    if (this.MG == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = this.MJ;
      str10 = String.valueOf("\t");
      if (this.MD != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (this.MK != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = this.ML;
      str13 = String.valueOf("\t");
      if (this.ME != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = this.ME)
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", this.MG);
      break;
      str2 = this.MD;
      break label76;
      str3 = this.MK;
      break label94;
    }
  }
  
  public final String hQ()
  {
    return this.MC;
  }
  
  public final String hR()
  {
    return this.MD;
  }
  
  public final String hS()
  {
    return this.ME;
  }
  
  public final int hT()
  {
    return this.MF;
  }
  
  public final List<String> hU()
  {
    return this.MG;
  }
  
  public final String hV()
  {
    return this.MH;
  }
  
  public final long hW()
  {
    return this.MI;
  }
  
  public final int hX()
  {
    return this.MJ;
  }
  
  public final String hY()
  {
    return this.MK;
  }
  
  public final float hZ()
  {
    return this.ML;
  }
  
  public final long ia()
  {
    return this.gY;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * JD-Core Version:    0.7.0.1
 */