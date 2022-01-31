package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.xweb.c.a.a;
import com.tencent.xweb.c.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  static boolean xgi = false;
  static String xgj = "";
  static Map<String, String> xgk;
  static Map<String, String> xgl;
  static Map<String, String> xgm;
  static Map<String, String> xgn;
  static Map<String, String> xgo;
  
  private static void a(Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5)
  {
    xgk = paramMap1;
    xgl = paramMap2;
    xgj = paramString;
    xgm = paramMap3;
    xgn = paramMap4;
    xgo = paramMap5;
  }
  
  public static void a(a.a[] paramArrayOfa, String paramString)
  {
    
    if (paramString == null) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    HashMap localHashMap5 = new HashMap();
    if ((paramArrayOfa == null) || (paramArrayOfa.length == 0))
    {
      b(localHashMap1, localHashMap2, paramString, localHashMap3, localHashMap4, localHashMap5);
      return;
    }
    XWalkEnvironment.getAvailableVersion();
    int i = Build.VERSION.SDK_INT;
    new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL);
    i = 0;
    while (i < paramArrayOfa.length)
    {
      if ((paramArrayOfa[i] != null) && (paramArrayOfa[i].xiX.cSF()) && (paramArrayOfa[i].xja != null) && (!paramArrayOfa[i].xja.isEmpty()) && (paramArrayOfa[i].xiZ != null))
      {
        String[] arrayOfString = paramArrayOfa[i].xja.split(",");
        int j;
        String str;
        if (paramArrayOfa[i].xiY.equals("setwebtype"))
        {
          j = 0;
          while (j < arrayOfString.length)
          {
            str = arrayOfString[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap1.containsKey(str))) {
              localHashMap1.put(str, paramArrayOfa[i].xiZ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[i].xiY.equals("setjscore"))
        {
          j = 0;
          while (j < arrayOfString.length)
          {
            str = arrayOfString[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap2.containsKey(str))) {
              localHashMap2.put(str, paramArrayOfa[i].xiZ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[i].xiY.equals("setfullscreenvideo"))
        {
          j = 0;
          while (j < arrayOfString.length)
          {
            str = arrayOfString[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap3.containsKey(str))) {
              localHashMap3.put(str, paramArrayOfa[i].xiZ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[i].xiY.equals("setTraceSampleRatioInTenThousand"))
        {
          j = 0;
          while (j < arrayOfString.length)
          {
            str = arrayOfString[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap4.containsKey(str))) {
              localHashMap4.put(str, paramArrayOfa[i].xiZ);
            }
            j += 1;
          }
        }
        if (paramArrayOfa[i].xiY.equals("setEnabledTraceCategory"))
        {
          j = 0;
          while (j < arrayOfString.length)
          {
            str = arrayOfString[j].trim();
            if ((str != null) && (!str.isEmpty()) && (!localHashMap5.containsKey(str))) {
              localHashMap5.put(str, paramArrayOfa[i].xiZ);
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    b(localHashMap1, localHashMap2, paramString, localHashMap3, localHashMap4, localHashMap5);
  }
  
  private static String aD(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(":");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  public static WebView.d agL(String paramString)
  {
    
    if ((xgk == null) || (paramString == null)) {
      return WebView.d.xhn;
    }
    return agQ((String)xgk.get(paramString));
  }
  
  public static g.a agM(String paramString)
  {
    
    if ((xgl == null) || (paramString == null)) {
      return g.a.xgw;
    }
    return agR((String)xgl.get(paramString));
  }
  
  public static WebView.a agN(String paramString)
  {
    
    if ((xgm == null) || (paramString == null)) {
      return WebView.a.xhl;
    }
    return agS((String)xgm.get(paramString));
  }
  
  public static int agO(String paramString)
  {
    
    if ((xgn == null) || (paramString == null)) {
      return 0;
    }
    paramString = (String)xgn.get(paramString);
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString))) {
      return 0;
    }
    return Integer.parseInt(paramString);
  }
  
  public static String agP(String paramString)
  {
    
    if ((xgo == null) || (paramString == null)) {
      return "";
    }
    return (String)xgo.get(paramString);
  }
  
  private static WebView.d agQ(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return WebView.d.xhn;
    }
    WebView.d locald = WebView.d.xhn;
    try
    {
      paramString = WebView.d.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return locald;
  }
  
  private static g.a agR(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return g.a.xgw;
    }
    g.a locala = g.a.xgw;
    try
    {
      paramString = g.a.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return locala;
  }
  
  private static WebView.a agS(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return WebView.a.xhl;
    }
    WebView.a locala = WebView.a.xhl;
    try
    {
      paramString = WebView.a.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return locala;
  }
  
  private static Map<String, String> agT(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.isEmpty())) {}
    for (;;)
    {
      return localHashMap;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
        {
          arrayOfString = arrayOfString.split(":");
          if ((arrayOfString.length == 2) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
        i += 1;
      }
    }
  }
  
  private static void b(Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5)
  {
    a(paramMap1, paramMap2, paramString, paramMap3, paramMap4, paramMap5);
    paramMap1 = aD(xgk);
    paramMap2 = aD(xgl);
    paramString = aD(xgm);
    paramMap3 = aD(xgn);
    paramMap4 = aD(xgo);
    XWalkEnvironment.addXWalkInitializeLog("CommandCfg", "save cmds to : webtype = " + paramMap1 + "jstype = " + paramMap2 + "configver = " + xgj + "strFullscreenVideoCmds = " + paramString + "strTraceSampleRatioCmds = " + paramMap3 + "strEnabledTraceCategoryCmds = " + paramMap4);
    paramMap5 = cSd().edit();
    paramMap5.putString("setwebtype", paramMap1);
    paramMap5.putString("setjscore", paramMap2);
    paramMap5.putString("cStrTAGConfigVer", xgj);
    paramMap5.putString("setfullscreenvideo", paramString);
    paramMap5.putString("setTraceSampleRatioInTenThousand", paramMap3);
    paramMap5.putString("setEnabledTraceCategory", paramMap4);
    paramMap5.commit();
  }
  
  private static SharedPreferences cSd()
  {
    return XWalkEnvironment.getApplicationContext().getSharedPreferences("XWEB.CMDCFG", 0);
  }
  
  public static String getAbstractInfo()
  {
    
    if (((xgk == null) || (xgk.size() == 0)) && ((xgl == null) || (xgl.size() == 0)) && ((xgm == null) || (xgm.size() == 0))) {
      return "";
    }
    return "configver : " + xgj + "\n webtype : " + aD(xgk) + "\n jscore type :" + aD(xgl) + "\n fullscreenVideo :" + aD(xgm) + "\n traceSampleRatio :" + aD(xgn) + "\n enabledTraceCategory:" + aD(xgo);
  }
  
  private static void init()
  {
    if (xgi) {
      return;
    }
    xgi = true;
    Object localObject = cSd();
    String str1 = ((SharedPreferences)localObject).getString("setwebtype", WebView.d.xhn.toString());
    String str2 = ((SharedPreferences)localObject).getString("setjscore", g.a.xgw.toString());
    String str3 = ((SharedPreferences)localObject).getString("cStrTAGConfigVer", "");
    String str4 = ((SharedPreferences)localObject).getString("setfullscreenvideo", WebView.a.xhl.toString());
    String str5 = ((SharedPreferences)localObject).getString("setTraceSampleRatioInTenThousand", "0");
    localObject = ((SharedPreferences)localObject).getString("setEnabledTraceCategory", "");
    a(agT(str1), agT(str2), str3, agT(str4), agT(str5), agT((String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */