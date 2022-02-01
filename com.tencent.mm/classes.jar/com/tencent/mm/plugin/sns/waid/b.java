package com.tencent.mm.plugin.sns.waid;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
{
  private static String aRA(String paramString)
  {
    AppMethodBeat.i(204040);
    paramString = Util.nullAsNil(paramString).replace(" ", "_");
    AppMethodBeat.o(204040);
    return paramString;
  }
  
  public static String aRy(String paramString)
  {
    AppMethodBeat.i(204037);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.Log.d("ad.waid.WaidHelper", "getAppWaid, pkg is empty");
      AppMethodBeat.o(204037);
      return "";
    }
    if (!flt())
    {
      com.tencent.mm.sdk.platformtools.Log.w("ad.waid.WaidHelper", "getAppWaid, isInnerExptWaidEnable==false");
      AppMethodBeat.o(204037);
      return "";
    }
    paramString = aRz(paramString);
    AppMethodBeat.o(204037);
    return paramString;
  }
  
  public static String aRz(String paramString)
  {
    try
    {
      AppMethodBeat.i(204038);
      try
      {
        long l = System.currentTimeMillis();
        String str = kT(paramString, flp());
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + paramString + ", appWaid=" + str + ", timeCost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(204038);
        paramString = str;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + paramString.toString());
          paramString = "";
          AppMethodBeat.o(204038);
        }
      }
      return paramString;
    }
    finally {}
  }
  
  private static String flp()
  {
    int i = 1;
    AppMethodBeat.i(204039);
    try
    {
      String str = "appWaid_" + aRA(Build.BRAND) + "_" + aRA(Build.MODEL);
      Object localObject4 = MultiProcessMMKV.getMMKV("ad_id_kv_pref").getString(str, "");
      Object localObject3 = d.AEF.exO();
      com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "getRawWaid, key=" + str + ", wxWaid=" + (String)localObject3 + ", localWaid=" + (String)localObject4);
      Object localObject1 = localObject4;
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          kU(str, (String)localObject3);
          localObject1 = flq();
          j = flr();
          com.tencent.mm.sdk.platformtools.Log.w("ad.waid.WaidHelper", "device changed, update localWaid, key=" + str + ", kvCount=" + j);
          if (j <= 1) {
            break label406;
          }
          if (flv()) {
            break label330;
          }
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportDeviceChange isWxEnvInitDone==false");
          localObject1 = localObject3;
        }
      }
      localObject4 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject4 = localObject1;
          if (!((String)localObject1).equals(localObject3))
          {
            boolean bool = flu();
            com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "waid Changed, key=" + str + ", localWaid=" + (String)localObject1 + ", wxWaid=" + (String)localObject3 + ", isNeedUpdate=" + bool);
            if (bool)
            {
              kU(str, (String)localObject3);
              localObject1 = localObject3;
            }
            j = flr();
            if (!bool) {
              break label412;
            }
            label306:
            if (flv()) {
              break label417;
            }
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportWaidChange isWxEnvInitDone==false");
            localObject4 = localObject1;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(204039);
          return localObject4;
          try
          {
            label330:
            localObject1 = c.aRB((String)localObject1);
            com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportDeviceChange data=".concat(String.valueOf(localObject1)));
            h.CyF.a(18666, new Object[] { Integer.valueOf(2004), localObject1 });
            localObject1 = localObject3;
          }
          catch (Throwable localThrowable1)
          {
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportDeviceChange exp=" + android.util.Log.getStackTraceString(localThrowable1));
          }
        }
        label406:
        Object localObject2 = localObject3;
        break;
        label412:
        i = 0;
        break label306;
        try
        {
          label417:
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("needUpdate", i);
          ((JSONObject)localObject3).put("kvCount", j);
          localObject3 = c.aRB(((JSONObject)localObject3).toString());
          com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportWaidChange data=".concat(String.valueOf(localObject3)));
          h.CyF.a(18666, new Object[] { Integer.valueOf(2003), localObject3 });
          localObject4 = localObject2;
        }
        catch (Throwable localThrowable3)
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportWaidChange exp=" + android.util.Log.getStackTraceString(localThrowable3));
          localObject4 = localObject2;
        }
      }
      return "";
    }
    catch (Throwable localThrowable2)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "getRawWaid exp=" + android.util.Log.getStackTraceString(localThrowable2));
      AppMethodBeat.o(204039);
    }
  }
  
  private static String flq()
  {
    AppMethodBeat.i(204043);
    localObject = new JSONObject();
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
      String[] arrayOfString = localMultiProcessMMKV.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          ((JSONObject)localObject).put(str, localMultiProcessMMKV.getString(str, ""));
          i += 1;
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "dumpKV exp=" + localThrowable.toString());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(204043);
    }
  }
  
  private static int flr()
  {
    AppMethodBeat.i(204044);
    try
    {
      String[] arrayOfString = MultiProcessMMKV.getMMKV("ad_id_kv_pref").allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(204044);
        return 0;
      }
      int i = arrayOfString.length;
      AppMethodBeat.o(204044);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "getKVCount exp=" + localThrowable.toString());
      AppMethodBeat.o(204044);
    }
    return 0;
  }
  
  public static boolean fls()
  {
    AppMethodBeat.i(204045);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOW, 0) > 0)
      {
        AppMethodBeat.o(204045);
        return true;
      }
      AppMethodBeat.o(204045);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(204045);
    }
    return false;
  }
  
  private static boolean flt()
  {
    AppMethodBeat.i(204046);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOV, 1) > 0)
      {
        AppMethodBeat.o(204046);
        return true;
      }
      AppMethodBeat.o(204046);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isInnerExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(204046);
    }
    return false;
  }
  
  private static boolean flu()
  {
    AppMethodBeat.i(204047);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOX, 0) > 0)
      {
        AppMethodBeat.o(204047);
        return true;
      }
      AppMethodBeat.o(204047);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + localThrowable.toString());
      AppMethodBeat.o(204047);
    }
    return false;
  }
  
  public static boolean flv()
  {
    AppMethodBeat.i(204048);
    if ((com.tencent.mm.kernel.g.aAi().hrr) && (com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(204048);
      return true;
    }
    AppMethodBeat.o(204048);
    return false;
  }
  
  private static String kT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204041);
    paramString1 = Util.nullAsNil(paramString1).trim();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(204041);
      return "";
    }
    paramString1 = paramString1.toLowerCase();
    paramString1 = paramString1 + "_" + paramString2;
    try
    {
      paramString1 = com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes("UTF-8"));
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = "waid".concat(String.valueOf(paramString1));
        AppMethodBeat.o(204041);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "getAppWaid, exp=" + paramString1.toString());
      AppMethodBeat.o(204041);
    }
    return "";
  }
  
  private static void kU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204042);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(204042);
      return;
    }
    paramString2 = Util.nullAsNil(paramString2);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
    int i = flr();
    if (i >= 10)
    {
      localMultiProcessMMKV.clear().commit();
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(i)));
    }
    localMultiProcessMMKV.edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(204042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */