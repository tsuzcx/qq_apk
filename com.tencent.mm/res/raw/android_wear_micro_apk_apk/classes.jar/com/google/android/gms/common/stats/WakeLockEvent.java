package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();
  final int Hc;
  private final long KL;
  private int KM;
  private final String KN;
  private final String KO;
  private final String KP;
  private final int KQ;
  private final List<String> KR;
  private final String KS;
  private final long KT;
  private int KU;
  private final String KV;
  private final float KW;
  private long KX;
  private final long fk;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this.Hc = paramInt1;
    this.KL = paramLong1;
    this.KM = paramInt2;
    this.KN = paramString1;
    this.KO = paramString3;
    this.KP = paramString5;
    this.KQ = paramInt3;
    this.KX = -1L;
    this.KR = paramList;
    this.KS = paramString2;
    this.KT = paramLong2;
    this.KU = paramInt4;
    this.KV = paramString4;
    this.KW = paramFloat;
    this.fk = paramLong3;
  }
  
  public final int getEventType()
  {
    return this.KM;
  }
  
  public final long getTimeMillis()
  {
    return this.KL;
  }
  
  public final long hE()
  {
    return this.KX;
  }
  
  public final String hF()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(this.KN);
    String str7 = String.valueOf("\t");
    int i = this.KQ;
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
    if (this.KR == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = this.KU;
      str10 = String.valueOf("\t");
      if (this.KO != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (this.KV != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = this.KW;
      str13 = String.valueOf("\t");
      if (this.KP != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = this.KP)
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", this.KR);
      break;
      str2 = this.KO;
      break label76;
      str3 = this.KV;
      break label94;
    }
  }
  
  public final String hG()
  {
    return this.KN;
  }
  
  public final String hH()
  {
    return this.KO;
  }
  
  public final String hI()
  {
    return this.KP;
  }
  
  public final int hJ()
  {
    return this.KQ;
  }
  
  public final List<String> hK()
  {
    return this.KR;
  }
  
  public final String hL()
  {
    return this.KS;
  }
  
  public final long hM()
  {
    return this.KT;
  }
  
  public final int hN()
  {
    return this.KU;
  }
  
  public final String hO()
  {
    return this.KV;
  }
  
  public final float hP()
  {
    return this.KW;
  }
  
  public final long hQ()
  {
    return this.fk;
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