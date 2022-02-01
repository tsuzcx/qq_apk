package com.tencent.mm.plugin.welab.d.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  extends dw
{
  private static final List<String> EQq;
  public static c.a info;
  private Map<String, Field> EQp;
  
  static
  {
    AppMethodBeat.i(146269);
    c.a locala = new c.a();
    locala.IBL = new Field[46];
    locala.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "LabsAppId";
    locala.IBN.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "LabsAppId";
    locala.columns[1] = "expId";
    locala.IBN.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "Type";
    locala.IBN.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "BizType";
    locala.IBN.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "Switch";
    locala.IBN.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "AllVer";
    locala.IBN.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "DetailURL";
    locala.IBN.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "WeAppUser";
    locala.IBN.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "WeAppPath";
    locala.IBN.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "Pos";
    locala.IBN.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "TitleKey_android";
    locala.IBN.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "Title_cn";
    locala.IBN.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "Title_hk";
    locala.IBN.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "Title_tw";
    locala.IBN.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "Title_en";
    locala.IBN.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "Desc_cn";
    locala.IBN.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "Desc_hk";
    locala.IBN.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "Desc_tw";
    locala.IBN.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "Desc_en";
    locala.IBN.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "Introduce_cn";
    locala.IBN.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "Introduce_hk";
    locala.IBN.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "Introduce_tw";
    locala.IBN.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "Introduce_en";
    locala.IBN.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "starttime";
    locala.IBN.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "endtime";
    locala.IBN.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "sequence";
    locala.IBN.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[26] = "prioritylevel";
    locala.IBN.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "ThumbUrl_cn";
    locala.IBN.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "ThumbUrl_hk";
    locala.IBN.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "ThumbUrl_tw";
    locala.IBN.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "ThumbUrl_en";
    locala.IBN.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "ImgUrl_android_cn";
    locala.IBN.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "ImgUrl_android_hk";
    locala.IBN.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "ImgUrl_android_tw";
    locala.IBN.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "ImgUrl_android_en";
    locala.IBN.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "RedPoint";
    locala.IBN.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "WeAppDebugMode";
    locala.IBN.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "idkey";
    locala.IBN.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "idkeyValue";
    locala.IBN.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "Icon";
    locala.IBN.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "ImgUrl_cn";
    locala.IBN.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "ImgUrl_hk";
    locala.IBN.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "ImgUrl_tw";
    locala.IBN.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "ImgUrl_en";
    locala.IBN.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[45] = "bItemFromXExpt";
    locala.IBN.put("bItemFromXExpt", "INTEGER");
    localStringBuilder.append(" bItemFromXExpt INTEGER");
    locala.columns[46] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    EQq = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
    AppMethodBeat.o(146269);
  }
  
  public a()
  {
    AppMethodBeat.i(146255);
    this.EQp = new HashMap();
    AppMethodBeat.o(146255);
  }
  
  private String VU(String paramString)
  {
    AppMethodBeat.i(146265);
    Object localObject = (Field)this.EQp.get(paramString);
    if (localObject == null) {
      try
      {
        Field localField = a.class.getField(paramString);
        localObject = localField;
        for (;;) {}
      }
      catch (NoSuchFieldException paramString)
      {
        for (;;)
        {
          try
          {
            this.EQp.put(paramString, localObject);
            if (localObject == null) {
              continue;
            }
          }
          catch (NoSuchFieldException paramString)
          {
            continue;
          }
          try
          {
            paramString = (String)((Field)localObject).get(this);
            AppMethodBeat.o(146265);
            return paramString;
          }
          catch (IllegalAccessException paramString)
          {
            ae.w("LabAppInfo", bu.o(paramString));
          }
          paramString = paramString;
          ae.w("LabAppInfo", bu.o(paramString));
        }
        AppMethodBeat.o(146265);
        return "";
      }
    }
  }
  
  private String aLs(String paramString)
  {
    AppMethodBeat.i(146264);
    Iterator localIterator = EQq.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = VU(paramString + str);
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(146264);
        return str;
      }
    }
    AppMethodBeat.o(146264);
    return "";
  }
  
  private String lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146263);
    paramString2 = VU(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(146263);
      return paramString2;
    }
    paramString1 = aLs(paramString1);
    AppMethodBeat.o(146263);
    return paramString1;
  }
  
  public final String aLr(String paramString)
  {
    AppMethodBeat.i(146262);
    String str1 = VU(paramString + "Key_android");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = ak.getPackageName();
      int i = ak.getResources().getIdentifier(str1, "string", str2);
      str1 = ak.getResources().getString(i);
      if (!TextUtils.isEmpty(str1))
      {
        AppMethodBeat.o(146262);
        return str1;
      }
    }
    str1 = ad.iR(ak.getContext());
    if (ad.foj())
    {
      paramString = lp(paramString, "_cn");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_HK".equals(str1))
    {
      paramString = lp(paramString, "_hk");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_TW".equals(str1))
    {
      paramString = lp(paramString, "_tw");
      AppMethodBeat.o(146262);
      return paramString;
    }
    paramString = lp(paramString, "_en");
    AppMethodBeat.o(146262);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(146257);
    if (paramObject == this)
    {
      AppMethodBeat.o(146257);
      return true;
    }
    if ((paramObject instanceof a))
    {
      boolean bool = ((a)paramObject).field_LabsAppId.equals(this.field_LabsAppId);
      AppMethodBeat.o(146257);
      return bool;
    }
    AppMethodBeat.o(146257);
    return false;
  }
  
  public final boolean faj()
  {
    AppMethodBeat.i(146267);
    if ((isRunning()) && ((this.field_Switch == 2) || (this.field_Switch == 1)))
    {
      AppMethodBeat.o(146267);
      return true;
    }
    AppMethodBeat.o(146267);
    return false;
  }
  
  public final boolean fak()
  {
    return this.field_bItemFromXExpt == 1;
  }
  
  public final boolean fal()
  {
    return this.field_status == 1;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(146256);
    int i = this.field_LabsAppId.hashCode();
    AppMethodBeat.o(146256);
    return i;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(146260);
    if ((isValid()) && (System.currentTimeMillis() / 1000L >= this.field_endtime))
    {
      AppMethodBeat.o(146260);
      return true;
    }
    AppMethodBeat.o(146260);
    return false;
  }
  
  public final boolean isOffline()
  {
    AppMethodBeat.i(146266);
    if ((isExpired()) || (this.field_Switch == 3))
    {
      AppMethodBeat.o(146266);
      return true;
    }
    AppMethodBeat.o(146266);
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(146259);
    if ((isValid()) && (System.currentTimeMillis() / 1000L >= this.field_starttime) && (System.currentTimeMillis() / 1000L < this.field_endtime))
    {
      AppMethodBeat.o(146259);
      return true;
    }
    AppMethodBeat.o(146259);
    return false;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(146258);
    if ((!TextUtils.isEmpty(this.field_LabsAppId)) && (!this.field_LabsAppId.equals("labs1de6f3")))
    {
      AppMethodBeat.o(146258);
      return true;
    }
    AppMethodBeat.o(146258);
    return false;
  }
  
  public final void reportIdkey()
  {
    AppMethodBeat.i(146268);
    if ((this.field_idkey > 0) && (this.field_idkeyValue >= 0)) {
      g.yxI.idkeyStat(this.field_idkey, this.field_idkeyValue, 1L, false);
    }
    AppMethodBeat.o(146268);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146261);
    String str = "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + ", exptId " + this.field_expId + "]";
    AppMethodBeat.o(146261);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a.a
 * JD-Core Version:    0.7.0.1
 */