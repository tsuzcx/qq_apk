package com.tencent.mm.plugin.sns.waid;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class b
{
  public static String aBl(String paramString)
  {
    AppMethodBeat.i(198629);
    if (efl())
    {
      paramString = aHq(paramString);
      AppMethodBeat.o(198629);
      return paramString;
    }
    ad.w("ad.waid.WaidHelper", "getAppWaid isExptWaidEnable=false");
    AppMethodBeat.o(198629);
    return "";
  }
  
  private static String aBm(String paramString)
  {
    AppMethodBeat.i(198631);
    paramString = bt.nullAsNil(paramString).replace(" ", "_");
    AppMethodBeat.o(198631);
    return paramString;
  }
  
  public static String aHq(String paramString)
  {
    try
    {
      AppMethodBeat.i(221355);
      try
      {
        long l = System.currentTimeMillis();
        String str = jY(paramString, efi());
        ad.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + paramString + ", appWaid=" + str + ", timeCost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(221355);
        paramString = str;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          ad.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + paramString.toString());
          paramString = "";
          AppMethodBeat.o(221355);
        }
      }
      return paramString;
    }
    finally {}
  }
  
  private static String efi()
  {
    int i = 1;
    AppMethodBeat.i(198630);
    try
    {
      String str3 = "appWaid_" + aBm(Build.BRAND) + "_" + aBm(Build.MODEL);
      Object localObject2 = ax.aQz("ad_id_kv_pref").getString(str3, "");
      String str2 = com.tencent.mm.plugin.normsg.a.b.wtJ.duT();
      ad.i("ad.waid.WaidHelper", "getRawWaid, key=" + str3 + ", wxWaid=" + str2 + ", localWaid=" + (String)localObject2);
      Object localObject1 = localObject2;
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str2))
        {
          jZ(str3, str2);
          localObject1 = efj();
          j = efk();
          ad.w("ad.waid.WaidHelper", "device changed, update localWaid, key=" + str3 + ", kvCount=" + j);
          if (j <= 1) {
            break label401;
          }
          if (efn()) {
            break label330;
          }
          ad.e("ad.waid.WaidReporter", "reportDeviceChange isWxEnvInitDone==false");
          localObject1 = str2;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str2))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(str2))
          {
            boolean bool = efm();
            ad.i("ad.waid.WaidHelper", "waid Changed, key=" + str3 + ", localWaid=" + (String)localObject1 + ", wxWaid=" + str2 + ", isNeedUpdate=" + bool);
            if (bool)
            {
              jZ(str3, str2);
              localObject1 = str2;
            }
            j = efk();
            if (!bool) {
              break label407;
            }
            label306:
            if (efn()) {
              break label412;
            }
            ad.e("ad.waid.WaidReporter", "reportWaidChange isWxEnvInitDone==false");
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(198630);
          return localObject2;
          try
          {
            label330:
            ad.i("ad.waid.WaidReporter", "reportDeviceChange data=".concat(String.valueOf(localObject1)));
            com.tencent.mm.plugin.report.service.g.yhR.f(18666, new Object[] { Integer.valueOf(1004), localObject1 });
            localObject1 = str2;
          }
          catch (Throwable localThrowable1)
          {
            ad.e("ad.waid.WaidReporter", "reportDeviceChange exp=" + Log.getStackTraceString(localThrowable1));
          }
        }
        label401:
        String str1 = str2;
        break;
        label407:
        i = 0;
        break label306;
        try
        {
          label412:
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("localWaid", str1);
          ((JSONObject)localObject2).put("wxWaid", str2);
          ((JSONObject)localObject2).put("exptValue", i);
          ((JSONObject)localObject2).put("kvCount", j);
          str2 = ((JSONObject)localObject2).toString();
          ad.i("ad.waid.WaidReporter", "reportWaidChange data=".concat(String.valueOf(str2)));
          com.tencent.mm.plugin.report.service.g.yhR.f(18666, new Object[] { Integer.valueOf(1003), str2 });
          localObject2 = str1;
        }
        catch (Throwable localThrowable3)
        {
          ad.e("ad.waid.WaidReporter", "reportWaidChange exp=" + Log.getStackTraceString(localThrowable3));
          localObject2 = str1;
        }
      }
      return "";
    }
    catch (Throwable localThrowable2)
    {
      ad.e("ad.waid.WaidHelper", "getRawWaid exp=" + Log.getStackTraceString(localThrowable2));
      AppMethodBeat.o(198630);
    }
  }
  
  private static String efj()
  {
    AppMethodBeat.i(198634);
    localObject = new JSONObject();
    try
    {
      ax localax = ax.aQz("ad_id_kv_pref");
      String[] arrayOfString = localax.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          ((JSONObject)localObject).put(str, localax.getString(str, ""));
          i += 1;
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ad.e("ad.waid.WaidHelper", "dumpKV exp=" + localThrowable.toString());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(198634);
    }
  }
  
  private static int efk()
  {
    AppMethodBeat.i(198635);
    try
    {
      String[] arrayOfString = ax.aQz("ad_id_kv_pref").allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(198635);
        return 0;
      }
      int i = arrayOfString.length;
      AppMethodBeat.o(198635);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ad.e("ad.waid.WaidHelper", "getKVCount exp=" + localThrowable.toString());
      AppMethodBeat.o(198635);
    }
    return 0;
  }
  
  public static boolean efl()
  {
    AppMethodBeat.i(198636);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqA, 0);
      ad.i("ad.waid.WaidHelper", "isExptWaidEnable, value=".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(198636);
        return true;
      }
      AppMethodBeat.o(198636);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(198636);
    }
    return false;
  }
  
  private static boolean efm()
  {
    AppMethodBeat.i(198637);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqB, 0);
      ad.i("ad.waid.WaidHelper", "isExptWaidNeedUpdate, value=".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(198637);
        return true;
      }
      AppMethodBeat.o(198637);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + localThrowable.toString());
      AppMethodBeat.o(198637);
    }
    return false;
  }
  
  public static boolean efn()
  {
    AppMethodBeat.i(198638);
    if ((com.tencent.mm.kernel.g.ajD().gBW) && (com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(198638);
      return true;
    }
    AppMethodBeat.o(198638);
    return false;
  }
  
  private static String jY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198632);
    paramString1 = bt.nullAsNil(paramString1).trim();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(198632);
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
        AppMethodBeat.o(198632);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      ad.e("ad.waid.WaidHelper", "getAppWaid, exp=" + paramString1.toString());
      AppMethodBeat.o(198632);
    }
    return "";
  }
  
  private static void jZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198633);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(198633);
      return;
    }
    paramString2 = bt.nullAsNil(paramString2);
    ax localax = ax.aQz("ad_id_kv_pref");
    int i = efk();
    if (i >= 10)
    {
      localax.clear().commit();
      ad.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(i)));
    }
    localax.edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(198633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */