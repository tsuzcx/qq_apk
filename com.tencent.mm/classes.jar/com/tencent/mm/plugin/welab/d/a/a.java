package com.tencent.mm.plugin.welab.d.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  extends dw
{
  private static final List<String> ExU;
  public static c.a info;
  private Map<String, Field> ExT;
  
  static
  {
    AppMethodBeat.i(146269);
    c.a locala = new c.a();
    locala.IhA = new Field[46];
    locala.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "LabsAppId";
    locala.IhC.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "LabsAppId";
    locala.columns[1] = "expId";
    locala.IhC.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "Type";
    locala.IhC.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "BizType";
    locala.IhC.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "Switch";
    locala.IhC.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "AllVer";
    locala.IhC.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "DetailURL";
    locala.IhC.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "WeAppUser";
    locala.IhC.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "WeAppPath";
    locala.IhC.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "Pos";
    locala.IhC.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "TitleKey_android";
    locala.IhC.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "Title_cn";
    locala.IhC.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "Title_hk";
    locala.IhC.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "Title_tw";
    locala.IhC.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "Title_en";
    locala.IhC.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "Desc_cn";
    locala.IhC.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "Desc_hk";
    locala.IhC.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "Desc_tw";
    locala.IhC.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "Desc_en";
    locala.IhC.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "Introduce_cn";
    locala.IhC.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "Introduce_hk";
    locala.IhC.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "Introduce_tw";
    locala.IhC.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "Introduce_en";
    locala.IhC.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "starttime";
    locala.IhC.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "endtime";
    locala.IhC.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "sequence";
    locala.IhC.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[26] = "prioritylevel";
    locala.IhC.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "ThumbUrl_cn";
    locala.IhC.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "ThumbUrl_hk";
    locala.IhC.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "ThumbUrl_tw";
    locala.IhC.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "ThumbUrl_en";
    locala.IhC.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "ImgUrl_android_cn";
    locala.IhC.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "ImgUrl_android_hk";
    locala.IhC.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "ImgUrl_android_tw";
    locala.IhC.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "ImgUrl_android_en";
    locala.IhC.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "RedPoint";
    locala.IhC.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "WeAppDebugMode";
    locala.IhC.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "idkey";
    locala.IhC.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "idkeyValue";
    locala.IhC.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "Icon";
    locala.IhC.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "ImgUrl_cn";
    locala.IhC.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "ImgUrl_hk";
    locala.IhC.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "ImgUrl_tw";
    locala.IhC.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "ImgUrl_en";
    locala.IhC.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[45] = "bItemFromXExpt";
    locala.IhC.put("bItemFromXExpt", "INTEGER");
    localStringBuilder.append(" bItemFromXExpt INTEGER");
    locala.columns[46] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    ExU = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
    AppMethodBeat.o(146269);
  }
  
  public a()
  {
    AppMethodBeat.i(146255);
    this.ExT = new HashMap();
    AppMethodBeat.o(146255);
  }
  
  private String Vj(String paramString)
  {
    AppMethodBeat.i(146265);
    Object localObject = (Field)this.ExT.get(paramString);
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
            this.ExT.put(paramString, localObject);
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
            ad.w("LabAppInfo", bt.n(paramString));
          }
          paramString = paramString;
          ad.w("LabAppInfo", bt.n(paramString));
        }
        AppMethodBeat.o(146265);
        return "";
      }
    }
  }
  
  private String aJW(String paramString)
  {
    AppMethodBeat.i(146264);
    Iterator localIterator = ExU.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = Vj(paramString + str);
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(146264);
        return str;
      }
    }
    AppMethodBeat.o(146264);
    return "";
  }
  
  private String li(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146263);
    paramString2 = Vj(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(146263);
      return paramString2;
    }
    paramString1 = aJW(paramString1);
    AppMethodBeat.o(146263);
    return paramString1;
  }
  
  public final String aJV(String paramString)
  {
    AppMethodBeat.i(146262);
    String str1 = Vj(paramString + "Key_android");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = aj.getPackageName();
      int i = aj.getResources().getIdentifier(str1, "string", str2);
      str1 = aj.getResources().getString(i);
      if (!TextUtils.isEmpty(str1))
      {
        AppMethodBeat.o(146262);
        return str1;
      }
    }
    str1 = ac.iM(aj.getContext());
    if (ac.fkp())
    {
      paramString = li(paramString, "_cn");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_HK".equals(str1))
    {
      paramString = li(paramString, "_hk");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_TW".equals(str1))
    {
      paramString = li(paramString, "_tw");
      AppMethodBeat.o(146262);
      return paramString;
    }
    paramString = li(paramString, "_en");
    AppMethodBeat.o(146262);
    return paramString;
  }
  
  public final boolean eWx()
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
  
  public final boolean eWy()
  {
    return this.field_bItemFromXExpt == 1;
  }
  
  public final boolean eWz()
  {
    return this.field_status == 1;
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
      g.yhR.idkeyStat(this.field_idkey, this.field_idkeyValue, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a.a
 * JD-Core Version:    0.7.0.1
 */