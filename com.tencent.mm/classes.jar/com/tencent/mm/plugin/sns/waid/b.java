package com.tencent.mm.plugin.sns.waid;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
{
  public static String bcD(String paramString)
  {
    AppMethodBeat.i(267841);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.Log.d("ad.waid.WaidHelper", "getAppWaid, pkg is empty");
      AppMethodBeat.o(267841);
      return "";
    }
    if (!fZP())
    {
      com.tencent.mm.sdk.platformtools.Log.w("ad.waid.WaidHelper", "getAppWaid, isInnerExptWaidEnable==false");
      AppMethodBeat.o(267841);
      return "";
    }
    paramString = bcE(paramString);
    AppMethodBeat.o(267841);
    return paramString;
  }
  
  public static String bcE(String paramString)
  {
    try
    {
      AppMethodBeat.i(267843);
      try
      {
        long l = System.currentTimeMillis();
        String str = lp(paramString, fZL());
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + paramString + ", appWaid=" + str + ", timeCost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(267843);
        paramString = str;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + paramString.toString());
          paramString = "";
          AppMethodBeat.o(267843);
        }
      }
      return paramString;
    }
    finally {}
  }
  
  private static String bcF(String paramString)
  {
    AppMethodBeat.i(267845);
    paramString = Util.nullAsNil(paramString).replace(" ", "_");
    AppMethodBeat.o(267845);
    return paramString;
  }
  
  private static String fZL()
  {
    int i = 1;
    AppMethodBeat.i(267844);
    try
    {
      String str = "appWaid_" + bcF(Build.BRAND) + "_" + bcF(Build.MODEL);
      Object localObject4 = MultiProcessMMKV.getMMKV("ad_id_kv_pref").getString(str, "");
      Object localObject3 = d.GxJ.fjs();
      com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "getRawWaid, key=" + str + ", wxWaid=" + (String)localObject3 + ", localWaid=" + (String)localObject4);
      Object localObject1 = localObject4;
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          lq(str, (String)localObject3);
          localObject1 = fZM();
          j = fZN();
          com.tencent.mm.sdk.platformtools.Log.w("ad.waid.WaidHelper", "device changed, update localWaid, key=" + str + ", kvCount=" + j);
          if (j <= 1) {
            break label406;
          }
          if (fZR()) {
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
            boolean bool = fZQ();
            com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidHelper", "waid Changed, key=" + str + ", localWaid=" + (String)localObject1 + ", wxWaid=" + (String)localObject3 + ", isNeedUpdate=" + bool);
            if (bool)
            {
              lq(str, (String)localObject3);
              localObject1 = localObject3;
            }
            j = fZN();
            if (!bool) {
              break label412;
            }
            label306:
            if (fZR()) {
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
          AppMethodBeat.o(267844);
          return localObject4;
          try
          {
            label330:
            localObject1 = c.bcG((String)localObject1);
            com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportDeviceChange data=".concat(String.valueOf(localObject1)));
            com.tencent.mm.plugin.report.service.h.IzE.a(18666, new Object[] { Integer.valueOf(2004), localObject1 });
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
          localObject3 = c.bcG(((JSONObject)localObject3).toString());
          com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportWaidChange data=".concat(String.valueOf(localObject3)));
          com.tencent.mm.plugin.report.service.h.IzE.a(18666, new Object[] { Integer.valueOf(2003), localObject3 });
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
      AppMethodBeat.o(267844);
    }
  }
  
  private static String fZM()
  {
    AppMethodBeat.i(267848);
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
      AppMethodBeat.o(267848);
    }
  }
  
  private static int fZN()
  {
    AppMethodBeat.i(267849);
    try
    {
      String[] arrayOfString = MultiProcessMMKV.getMMKV("ad_id_kv_pref").allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(267849);
        return 0;
      }
      int i = arrayOfString.length;
      AppMethodBeat.o(267849);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "getKVCount exp=" + localThrowable.toString());
      AppMethodBeat.o(267849);
    }
    return 0;
  }
  
  public static boolean fZO()
  {
    AppMethodBeat.i(267850);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuY, 0) > 0)
      {
        AppMethodBeat.o(267850);
        return true;
      }
      AppMethodBeat.o(267850);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(267850);
    }
    return false;
  }
  
  private static boolean fZP()
  {
    AppMethodBeat.i(267851);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuX, 1) > 0)
      {
        AppMethodBeat.o(267851);
        return true;
      }
      AppMethodBeat.o(267851);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isInnerExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(267851);
    }
    return false;
  }
  
  private static boolean fZQ()
  {
    AppMethodBeat.i(267852);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuZ, 0) > 0)
      {
        AppMethodBeat.o(267852);
        return true;
      }
      AppMethodBeat.o(267852);
      return false;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + localThrowable.toString());
      AppMethodBeat.o(267852);
    }
    return false;
  }
  
  public static boolean fZR()
  {
    AppMethodBeat.i(267853);
    if ((com.tencent.mm.kernel.h.aHH().kdm) && (com.tencent.mm.kernel.h.aHE().aGM()))
    {
      AppMethodBeat.o(267853);
      return true;
    }
    AppMethodBeat.o(267853);
    return false;
  }
  
  private static String lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267846);
    paramString1 = Util.nullAsNil(paramString1).trim();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(267846);
      return "";
    }
    paramString1 = paramString1.toLowerCase();
    paramString1 = paramString1 + "_" + paramString2;
    try
    {
      paramString1 = g.getMessageDigest(paramString1.getBytes("UTF-8"));
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = "waid".concat(String.valueOf(paramString1));
        AppMethodBeat.o(267846);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "getAppWaid, exp=" + paramString1.toString());
      AppMethodBeat.o(267846);
    }
    return "";
  }
  
  private static void lq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267847);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(267847);
      return;
    }
    paramString2 = Util.nullAsNil(paramString2);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
    int i = fZN();
    if (i >= 10)
    {
      localMultiProcessMMKV.clear().commit();
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(i)));
    }
    localMultiProcessMMKV.edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(267847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */