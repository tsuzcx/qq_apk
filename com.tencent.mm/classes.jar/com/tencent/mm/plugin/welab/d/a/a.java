package com.tencent.mm.plugin.welab.d.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.eu;
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
  extends eu
{
  private static final List<String> XyN;
  public static IAutoDBItem.MAutoDBInfo info;
  private Map<String, Field> XyM;
  
  static
  {
    AppMethodBeat.i(146269);
    info = eu.aJm();
    XyN = Arrays.asList(new String[] { "_cn", "_hk", "_tw", "_en" });
    AppMethodBeat.o(146269);
  }
  
  public a()
  {
    AppMethodBeat.i(146255);
    this.XyM = new HashMap();
    AppMethodBeat.o(146255);
  }
  
  private String agT(String paramString)
  {
    AppMethodBeat.i(146265);
    Object localObject = (Field)this.XyM.get(paramString);
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
            this.XyM.put(paramString, localObject);
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
  
  private String bnw(String paramString)
  {
    AppMethodBeat.i(146264);
    Iterator localIterator = XyN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      str = agT(paramString + str);
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(146264);
        return str;
      }
    }
    AppMethodBeat.o(146264);
    return "";
  }
  
  private String oG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146263);
    paramString2 = agT(paramString1 + paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(146263);
      return paramString2;
    }
    paramString1 = bnw(paramString1);
    AppMethodBeat.o(146263);
    return paramString1;
  }
  
  public final boolean MX()
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
  
  public final String bnv(String paramString)
  {
    AppMethodBeat.i(146262);
    String str1 = agT(paramString + "Key_android");
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
      paramString = oG(paramString, "_cn");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_HK".equals(str1))
    {
      paramString = oG(paramString, "_hk");
      AppMethodBeat.o(146262);
      return paramString;
    }
    if ("zh_TW".equals(str1))
    {
      paramString = oG(paramString, "_tw");
      AppMethodBeat.o(146262);
      return paramString;
    }
    paramString = oG(paramString, "_en");
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
  
  public int hashCode()
  {
    AppMethodBeat.i(146256);
    int i = this.field_LabsAppId.hashCode();
    AppMethodBeat.o(146256);
    return i;
  }
  
  public final boolean iDJ()
  {
    return this.field_bItemFromXExpt == 1;
  }
  
  public final boolean iDK()
  {
    return this.field_status == 1;
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
      h.OAn.idkeyStat(this.field_idkey, this.field_idkeyValue, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a.a
 * JD-Core Version:    0.7.0.1
 */