package com.tencent.mm.plugin.welab.d.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  extends cv
{
  public static c.a info;
  private static final List<String> vvi;
  private Map<String, Field> vvh;
  
  static
  {
    AppMethodBeat.i(80598);
    c.a locala = new c.a();
    locala.yrK = new Field[46];
    locala.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "LabsAppId";
    locala.yrM.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "LabsAppId";
    locala.columns[1] = "expId";
    locala.yrM.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "Type";
    locala.yrM.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "BizType";
    locala.yrM.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "Switch";
    locala.yrM.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "AllVer";
    locala.yrM.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "DetailURL";
    locala.yrM.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "WeAppUser";
    locala.yrM.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "WeAppPath";
    locala.yrM.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "Pos";
    locala.yrM.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "TitleKey_android";
    locala.yrM.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "Title_cn";
    locala.yrM.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "Title_hk";
    locala.yrM.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "Title_tw";
    locala.yrM.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "Title_en";
    locala.yrM.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "Desc_cn";
    locala.yrM.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "Desc_hk";
    locala.yrM.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "Desc_tw";
    locala.yrM.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "Desc_en";
    locala.yrM.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "Introduce_cn";
    locala.yrM.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "Introduce_hk";
    locala.yrM.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "Introduce_tw";
    locala.yrM.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "Introduce_en";
    locala.yrM.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "starttime";
    locala.yrM.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "endtime";
    locala.yrM.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "sequence";
    locala.yrM.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[26] = "prioritylevel";
    locala.yrM.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "ThumbUrl_cn";
    locala.yrM.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "ThumbUrl_hk";
    locala.yrM.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "ThumbUrl_tw";
    locala.yrM.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "ThumbUrl_en";
    locala.yrM.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "ImgUrl_android_cn";
    locala.yrM.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "ImgUrl_android_hk";
    locala.yrM.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "ImgUrl_android_tw";
    locala.yrM.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "ImgUrl_android_en";
    locala.yrM.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "RedPoint";
    locala.yrM.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "WeAppDebugMode";
    locala.yrM.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "idkey";
    locala.yrM.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "idkeyValue";
    locala.yrM.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "Icon";
    locala.yrM.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "ImgUrl_cn";
    locala.yrM.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "ImgUrl_hk";
    locala.yrM.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "ImgUrl_tw";
    locala.yrM.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "ImgUrl_en";
    locala.yrM.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[45] = "bItemFromXExpt";
    locala.yrM.put("bItemFromXExpt", "INTEGER");
    localStringBuilder.append(" bItemFromXExpt INTEGER");
    locala.columns[46] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    vvi = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
    AppMethodBeat.o(80598);
  }
  
  public a()
  {
    AppMethodBeat.i(80584);
    this.vvh = new HashMap();
    AppMethodBeat.o(80584);
  }
  
  private String Fy(String paramString)
  {
    AppMethodBeat.i(80594);
    Object localObject = (Field)this.vvh.get(paramString);
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
            this.vvh.put(paramString, localObject);
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
            AppMethodBeat.o(80594);
            return paramString;
          }
          catch (IllegalAccessException paramString)
          {
            ab.w("LabAppInfo", bo.l(paramString));
          }
          paramString = paramString;
          ab.w("LabAppInfo", bo.l(paramString));
        }
        AppMethodBeat.o(80594);
        return "";
      }
    }
  }
  
  private String ajB(String paramString)
  {
    AppMethodBeat.i(80593);
    Iterator localIterator = vvi.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = Fy(paramString + str);
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(80593);
        return str;
      }
    }
    AppMethodBeat.o(80593);
    return "";
  }
  
  private String hG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80592);
    paramString2 = Fy(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(80592);
      return paramString2;
    }
    paramString1 = ajB(paramString1);
    AppMethodBeat.o(80592);
    return paramString1;
  }
  
  public final String ajA(String paramString)
  {
    AppMethodBeat.i(80591);
    String str1 = Fy(paramString + "Key_android");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = ah.getPackageName();
      int i = ah.getResources().getIdentifier(str1, "string", str2);
      str1 = ah.getResources().getString(i);
      if (!TextUtils.isEmpty(str1))
      {
        AppMethodBeat.o(80591);
        return str1;
      }
    }
    str1 = aa.gP(ah.getContext());
    if (aa.dsD())
    {
      paramString = hG(paramString, "_cn");
      AppMethodBeat.o(80591);
      return paramString;
    }
    if ("zh_HK".equals(str1))
    {
      paramString = hG(paramString, "_hk");
      AppMethodBeat.o(80591);
      return paramString;
    }
    if ("zh_TW".equals(str1))
    {
      paramString = hG(paramString, "_tw");
      AppMethodBeat.o(80591);
      return paramString;
    }
    paramString = hG(paramString, "_en");
    AppMethodBeat.o(80591);
    return paramString;
  }
  
  public final boolean dhu()
  {
    AppMethodBeat.i(80595);
    if ((isExpired()) || (this.field_Switch == 3))
    {
      AppMethodBeat.o(80595);
      return true;
    }
    AppMethodBeat.o(80595);
    return false;
  }
  
  public final boolean dhv()
  {
    AppMethodBeat.i(80596);
    if ((isRunning()) && ((this.field_Switch == 2) || (this.field_Switch == 1)))
    {
      AppMethodBeat.o(80596);
      return true;
    }
    AppMethodBeat.o(80596);
    return false;
  }
  
  public final void dhw()
  {
    AppMethodBeat.i(80597);
    if ((this.field_idkey > 0) && (this.field_idkeyValue >= 0)) {
      h.qsU.idkeyStat(this.field_idkey, this.field_idkeyValue, 1L, false);
    }
    AppMethodBeat.o(80597);
  }
  
  public final boolean dhx()
  {
    return this.field_bItemFromXExpt == 1;
  }
  
  public final boolean dhy()
  {
    return this.field_status == 1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(80586);
    if (paramObject == this)
    {
      AppMethodBeat.o(80586);
      return true;
    }
    if ((paramObject instanceof a))
    {
      boolean bool = ((a)paramObject).field_LabsAppId.equals(this.field_LabsAppId);
      AppMethodBeat.o(80586);
      return bool;
    }
    AppMethodBeat.o(80586);
    return false;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(80585);
    int i = this.field_LabsAppId.hashCode();
    AppMethodBeat.o(80585);
    return i;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(80589);
    if ((isValid()) && (System.currentTimeMillis() / 1000L >= this.field_endtime))
    {
      AppMethodBeat.o(80589);
      return true;
    }
    AppMethodBeat.o(80589);
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(80588);
    if ((isValid()) && (System.currentTimeMillis() / 1000L >= this.field_starttime) && (System.currentTimeMillis() / 1000L < this.field_endtime))
    {
      AppMethodBeat.o(80588);
      return true;
    }
    AppMethodBeat.o(80588);
    return false;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(80587);
    if ((!TextUtils.isEmpty(this.field_LabsAppId)) && (!this.field_LabsAppId.equals("labs1de6f3")))
    {
      AppMethodBeat.o(80587);
      return true;
    }
    AppMethodBeat.o(80587);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(80590);
    String str = "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + ", exptId " + this.field_expId + "]";
    AppMethodBeat.o(80590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a.a
 * JD-Core Version:    0.7.0.1
 */