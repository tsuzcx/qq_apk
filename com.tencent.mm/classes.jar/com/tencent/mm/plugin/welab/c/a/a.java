package com.tencent.mm.plugin.welab.c.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mm.h.c.co;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  extends co
{
  public static c.a buS;
  private static final List<String> rEz = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
  private Map<String, Field> rEy = new HashMap();
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[45];
    locala.columns = new String[46];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "LabsAppId";
    locala.ujN.put("LabsAppId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "LabsAppId";
    locala.columns[1] = "expId";
    locala.ujN.put("expId", "TEXT default '' ");
    localStringBuilder.append(" expId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "Type";
    locala.ujN.put("Type", "INTEGER default '0' ");
    localStringBuilder.append(" Type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "BizType";
    locala.ujN.put("BizType", "INTEGER default '0' ");
    localStringBuilder.append(" BizType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "Switch";
    locala.ujN.put("Switch", "INTEGER default '0' ");
    localStringBuilder.append(" Switch INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "AllVer";
    locala.ujN.put("AllVer", "INTEGER default '0' ");
    localStringBuilder.append(" AllVer INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "DetailURL";
    locala.ujN.put("DetailURL", "TEXT");
    localStringBuilder.append(" DetailURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "WeAppUser";
    locala.ujN.put("WeAppUser", "TEXT");
    localStringBuilder.append(" WeAppUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "WeAppPath";
    locala.ujN.put("WeAppPath", "TEXT");
    localStringBuilder.append(" WeAppPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "Pos";
    locala.ujN.put("Pos", "INTEGER default '0' ");
    localStringBuilder.append(" Pos INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "TitleKey_android";
    locala.ujN.put("TitleKey_android", "TEXT");
    localStringBuilder.append(" TitleKey_android TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "Title_cn";
    locala.ujN.put("Title_cn", "TEXT");
    localStringBuilder.append(" Title_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "Title_hk";
    locala.ujN.put("Title_hk", "TEXT");
    localStringBuilder.append(" Title_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "Title_tw";
    locala.ujN.put("Title_tw", "TEXT");
    localStringBuilder.append(" Title_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "Title_en";
    locala.ujN.put("Title_en", "TEXT");
    localStringBuilder.append(" Title_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "Desc_cn";
    locala.ujN.put("Desc_cn", "TEXT");
    localStringBuilder.append(" Desc_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "Desc_hk";
    locala.ujN.put("Desc_hk", "TEXT");
    localStringBuilder.append(" Desc_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "Desc_tw";
    locala.ujN.put("Desc_tw", "TEXT");
    localStringBuilder.append(" Desc_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "Desc_en";
    locala.ujN.put("Desc_en", "TEXT");
    localStringBuilder.append(" Desc_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "Introduce_cn";
    locala.ujN.put("Introduce_cn", "TEXT");
    localStringBuilder.append(" Introduce_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "Introduce_hk";
    locala.ujN.put("Introduce_hk", "TEXT");
    localStringBuilder.append(" Introduce_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "Introduce_tw";
    locala.ujN.put("Introduce_tw", "TEXT");
    localStringBuilder.append(" Introduce_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "Introduce_en";
    locala.ujN.put("Introduce_en", "TEXT");
    localStringBuilder.append(" Introduce_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "starttime";
    locala.ujN.put("starttime", "LONG");
    localStringBuilder.append(" starttime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "endtime";
    locala.ujN.put("endtime", "LONG");
    localStringBuilder.append(" endtime LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "sequence";
    locala.ujN.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[26] = "prioritylevel";
    locala.ujN.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "ThumbUrl_cn";
    locala.ujN.put("ThumbUrl_cn", "TEXT");
    localStringBuilder.append(" ThumbUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "ThumbUrl_hk";
    locala.ujN.put("ThumbUrl_hk", "TEXT");
    localStringBuilder.append(" ThumbUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "ThumbUrl_tw";
    locala.ujN.put("ThumbUrl_tw", "TEXT");
    localStringBuilder.append(" ThumbUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "ThumbUrl_en";
    locala.ujN.put("ThumbUrl_en", "TEXT");
    localStringBuilder.append(" ThumbUrl_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "ImgUrl_android_cn";
    locala.ujN.put("ImgUrl_android_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_android_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "ImgUrl_android_hk";
    locala.ujN.put("ImgUrl_android_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_android_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "ImgUrl_android_tw";
    locala.ujN.put("ImgUrl_android_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_android_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "ImgUrl_android_en";
    locala.ujN.put("ImgUrl_android_en", "TEXT");
    localStringBuilder.append(" ImgUrl_android_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "RedPoint";
    locala.ujN.put("RedPoint", "INTEGER");
    localStringBuilder.append(" RedPoint INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "WeAppDebugMode";
    locala.ujN.put("WeAppDebugMode", "INTEGER");
    localStringBuilder.append(" WeAppDebugMode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "idkey";
    locala.ujN.put("idkey", "INTEGER");
    localStringBuilder.append(" idkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "idkeyValue";
    locala.ujN.put("idkeyValue", "INTEGER");
    localStringBuilder.append(" idkeyValue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "Icon";
    locala.ujN.put("Icon", "TEXT");
    localStringBuilder.append(" Icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "ImgUrl_cn";
    locala.ujN.put("ImgUrl_cn", "TEXT");
    localStringBuilder.append(" ImgUrl_cn TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "ImgUrl_hk";
    locala.ujN.put("ImgUrl_hk", "TEXT");
    localStringBuilder.append(" ImgUrl_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "ImgUrl_tw";
    locala.ujN.put("ImgUrl_tw", "TEXT");
    localStringBuilder.append(" ImgUrl_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "ImgUrl_en";
    locala.ujN.put("ImgUrl_en", "TEXT");
    localStringBuilder.append(" ImgUrl_en TEXT");
    locala.columns[45] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  private String Un(String paramString)
  {
    Iterator localIterator = rEz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = wS(paramString + str);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return "";
  }
  
  private String fG(String paramString1, String paramString2)
  {
    paramString2 = wS(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      return paramString2;
    }
    return Un(paramString1);
  }
  
  private String wS(String paramString)
  {
    Object localObject = (Field)this.rEy.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        Field localField = a.class.getField(paramString);
        localObject = localField;
        return "";
      }
      catch (NoSuchFieldException paramString)
      {
        for (;;)
        {
          try
          {
            this.rEy.put(paramString, localObject);
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
            return paramString;
          }
          catch (IllegalAccessException paramString)
          {
            y.w("LabAppInfo", bk.j(paramString));
          }
        }
        paramString = paramString;
        y.w("LabAppInfo", bk.j(paramString));
      }
    }
  }
  
  public final String Um(String paramString)
  {
    String str1 = wS(paramString + "Key_android");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = ae.getPackageName();
      int i = ae.getResources().getIdentifier(str1, "string", str2);
      str1 = ae.getResources().getString(i);
      if (!TextUtils.isEmpty(str1)) {
        return str1;
      }
    }
    str1 = x.fB(ae.getContext());
    if (x.cqG()) {
      return fG(paramString, "_cn");
    }
    if ("zh_HK".equals(str1)) {
      return fG(paramString, "_hk");
    }
    if ("zh_TW".equals(str1)) {
      return fG(paramString, "_tw");
    }
    return fG(paramString, "_en");
  }
  
  public final boolean caB()
  {
    return (isValid()) && (System.currentTimeMillis() / 1000L >= this.field_endtime);
  }
  
  public final boolean chm()
  {
    return (isRunning()) && ((this.field_Switch == 2) || (this.field_Switch == 1));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a)) {
      return ((a)paramObject).field_LabsAppId.equals(this.field_LabsAppId);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.field_LabsAppId.hashCode();
  }
  
  public final boolean isRunning()
  {
    return (isValid()) && (System.currentTimeMillis() / 1000L > this.field_starttime) && (System.currentTimeMillis() / 1000L < this.field_endtime);
  }
  
  public final boolean isValid()
  {
    return (!TextUtils.isEmpty(this.field_LabsAppId)) && (!this.field_LabsAppId.equals("labs1de6f3"));
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public String toString()
  {
    return "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.a.a
 * JD-Core Version:    0.7.0.1
 */