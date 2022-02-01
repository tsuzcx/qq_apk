package com.tencent.mm.plugin.welab.d.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  extends ec
{
  private static final List<String> JGd;
  public static IAutoDBItem.MAutoDBInfo info;
  private Map<String, Field> JGc;
  
  static
  {
    AppMethodBeat.i(146269);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "LabsAppId";
    localMAutoDBInfo.colsMap.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "LabsAppId";
    localMAutoDBInfo.columns[1] = "expId";
    localMAutoDBInfo.colsMap.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "Type";
    localMAutoDBInfo.colsMap.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "BizType";
    localMAutoDBInfo.colsMap.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "Switch";
    localMAutoDBInfo.colsMap.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "AllVer";
    localMAutoDBInfo.colsMap.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "DetailURL";
    localMAutoDBInfo.colsMap.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "WeAppUser";
    localMAutoDBInfo.colsMap.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "WeAppPath";
    localMAutoDBInfo.colsMap.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "Pos";
    localMAutoDBInfo.colsMap.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "TitleKey_android";
    localMAutoDBInfo.colsMap.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "Title_cn";
    localMAutoDBInfo.colsMap.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "Title_hk";
    localMAutoDBInfo.colsMap.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "Title_tw";
    localMAutoDBInfo.colsMap.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "Title_en";
    localMAutoDBInfo.colsMap.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "Desc_cn";
    localMAutoDBInfo.colsMap.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "Desc_hk";
    localMAutoDBInfo.colsMap.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "Desc_tw";
    localMAutoDBInfo.colsMap.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "Desc_en";
    localMAutoDBInfo.colsMap.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "Introduce_cn";
    localMAutoDBInfo.colsMap.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "Introduce_hk";
    localMAutoDBInfo.colsMap.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "Introduce_tw";
    localMAutoDBInfo.colsMap.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "Introduce_en";
    localMAutoDBInfo.colsMap.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "starttime";
    localMAutoDBInfo.colsMap.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "endtime";
    localMAutoDBInfo.colsMap.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "sequence";
    localMAutoDBInfo.colsMap.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "prioritylevel";
    localMAutoDBInfo.colsMap.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "ThumbUrl_cn";
    localMAutoDBInfo.colsMap.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "ThumbUrl_hk";
    localMAutoDBInfo.colsMap.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "ThumbUrl_tw";
    localMAutoDBInfo.colsMap.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "ThumbUrl_en";
    localMAutoDBInfo.colsMap.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "ImgUrl_android_cn";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "ImgUrl_android_hk";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "ImgUrl_android_tw";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "ImgUrl_android_en";
    localMAutoDBInfo.colsMap.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "RedPoint";
    localMAutoDBInfo.colsMap.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "WeAppDebugMode";
    localMAutoDBInfo.colsMap.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "idkey";
    localMAutoDBInfo.colsMap.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "idkeyValue";
    localMAutoDBInfo.colsMap.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "Icon";
    localMAutoDBInfo.colsMap.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "ImgUrl_cn";
    localMAutoDBInfo.colsMap.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "ImgUrl_hk";
    localMAutoDBInfo.colsMap.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "ImgUrl_tw";
    localMAutoDBInfo.colsMap.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "ImgUrl_en";
    localMAutoDBInfo.colsMap.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "bItemFromXExpt";
    localMAutoDBInfo.colsMap.put("bItemFromXExpt", "INTEGER");
    localStringBuilder.append(" bItemFromXExpt INTEGER");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    JGd = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
    AppMethodBeat.o(146269);
  }
  
  public a()
  {
    AppMethodBeat.i(146255);
    this.JGc = new HashMap();
    AppMethodBeat.o(146255);
  }
  
  private String afQ(String paramString)
  {
    AppMethodBeat.i(146265);
    Object localObject = (Field)this.JGc.get(paramString);
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
            this.JGc.put(paramString, localObject);
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
            Log.w("LabAppInfo", Util.stackTraceToString(paramString));
          }
          paramString = paramString;
          Log.w("LabAppInfo", Util.stackTraceToString(paramString));
        }
        AppMethodBeat.o(146265);
        return "";
      }
    }
  }
  
  private String bbI(String paramString)
  {
    AppMethodBeat.i(146264);
    Iterator localIterator = JGd.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = afQ(paramString + str);
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(146264);
        return str;
      }
    }
    AppMethodBeat.o(146264);
    return "";
  }
  
  private String mo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146263);
    paramString2 = afQ(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(146263);
      return paramString2;
    }
    paramString1 = bbI(paramString1);
    AppMethodBeat.o(146263);
    return paramString1;
  }
  
  public final String bbH(String paramString)
  {
    AppMethodBeat.i(146262);
    String str1 = afQ(paramString + "Key_android");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = MMApplicationContext.getPackageName();
      int i = MMApplicationContext.getResources().getIdentifier(str1, "string", str2);
      str1 = MMApplicationContext.getResources().getString(i);
      if (!TextUtils.isEmpty(str1))
      {
        AppMethodBeat.o(146262);
        return str1;
      }
    }
    str1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      paramString = mo(paramString, "_cn");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_HK".equals(str1))
    {
      paramString = mo(paramString, "_hk");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_TW".equals(str1))
    {
      paramString = mo(paramString, "_tw");
      AppMethodBeat.o(146262);
      return paramString;
    }
    paramString = mo(paramString, "_en");
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
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean gjo()
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
  
  public final boolean gjp()
  {
    return this.field_bItemFromXExpt == 1;
  }
  
  public final boolean gjq()
  {
    return this.field_status == 1;
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
      h.CyF.idkeyStat(this.field_idkey, this.field_idkeyValue, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a.a
 * JD-Core Version:    0.7.0.1
 */