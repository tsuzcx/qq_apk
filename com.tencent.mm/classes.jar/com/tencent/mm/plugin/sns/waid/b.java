package com.tencent.mm.plugin.sns.waid;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class b
{
  public static String aCC(String paramString)
  {
    AppMethodBeat.i(220178);
    if (TextUtils.isEmpty(paramString))
    {
      ae.d("ad.waid.WaidHelper", "getAppWaid, pkg is empty");
      AppMethodBeat.o(220178);
      return "";
    }
    if (!eiT())
    {
      ae.w("ad.waid.WaidHelper", "getAppWaid, isInnerExptWaidEnable==false");
      AppMethodBeat.o(220178);
      return "";
    }
    paramString = aCD(paramString);
    AppMethodBeat.o(220178);
    return paramString;
  }
  
  public static String aCD(String paramString)
  {
    try
    {
      AppMethodBeat.i(220179);
      try
      {
        long l = System.currentTimeMillis();
        String str = kf(paramString, eiP());
        ae.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + paramString + ", appWaid=" + str + ", timeCost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(220179);
        paramString = str;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          ae.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + paramString.toString());
          paramString = "";
          AppMethodBeat.o(220179);
        }
      }
      return paramString;
    }
    finally {}
  }
  
  private static String aCE(String paramString)
  {
    AppMethodBeat.i(220181);
    paramString = bu.nullAsNil(paramString).replace(" ", "_");
    AppMethodBeat.o(220181);
    return paramString;
  }
  
  private static String eiP()
  {
    int i = 1;
    AppMethodBeat.i(220180);
    try
    {
      String str = "appWaid_" + aCE(Build.BRAND) + "_" + aCE(Build.MODEL);
      Object localObject4 = ay.aRW("ad_id_kv_pref").getString(str, "");
      Object localObject3 = com.tencent.mm.plugin.normsg.a.b.wJt.dyj();
      ae.i("ad.waid.WaidHelper", "getRawWaid, key=" + str + ", wxWaid=" + (String)localObject3 + ", localWaid=" + (String)localObject4);
      Object localObject1 = localObject4;
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          kg(str, (String)localObject3);
          localObject1 = eiQ();
          j = eiR();
          ae.w("ad.waid.WaidHelper", "device changed, update localWaid, key=" + str + ", kvCount=" + j);
          if (j <= 1) {
            break label406;
          }
          if (eiV()) {
            break label330;
          }
          ae.e("ad.waid.WaidReporter", "reportDeviceChange isWxEnvInitDone==false");
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
            boolean bool = eiU();
            ae.i("ad.waid.WaidHelper", "waid Changed, key=" + str + ", localWaid=" + (String)localObject1 + ", wxWaid=" + (String)localObject3 + ", isNeedUpdate=" + bool);
            if (bool)
            {
              kg(str, (String)localObject3);
              localObject1 = localObject3;
            }
            j = eiR();
            if (!bool) {
              break label412;
            }
            label306:
            if (eiV()) {
              break label417;
            }
            ae.e("ad.waid.WaidReporter", "reportWaidChange isWxEnvInitDone==false");
            localObject4 = localObject1;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(220180);
          return localObject4;
          try
          {
            label330:
            localObject1 = c.aCF((String)localObject1);
            ae.i("ad.waid.WaidReporter", "reportDeviceChange data=".concat(String.valueOf(localObject1)));
            com.tencent.mm.plugin.report.service.g.yxI.f(18666, new Object[] { Integer.valueOf(2004), localObject1 });
            localObject1 = localObject3;
          }
          catch (Throwable localThrowable1)
          {
            ae.e("ad.waid.WaidReporter", "reportDeviceChange exp=" + Log.getStackTraceString(localThrowable1));
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
          localObject3 = c.aCF(((JSONObject)localObject3).toString());
          ae.i("ad.waid.WaidReporter", "reportWaidChange data=".concat(String.valueOf(localObject3)));
          com.tencent.mm.plugin.report.service.g.yxI.f(18666, new Object[] { Integer.valueOf(2003), localObject3 });
          localObject4 = localObject2;
        }
        catch (Throwable localThrowable3)
        {
          ae.e("ad.waid.WaidReporter", "reportWaidChange exp=" + Log.getStackTraceString(localThrowable3));
          localObject4 = localObject2;
        }
      }
      return "";
    }
    catch (Throwable localThrowable2)
    {
      ae.e("ad.waid.WaidHelper", "getRawWaid exp=" + Log.getStackTraceString(localThrowable2));
      AppMethodBeat.o(220180);
    }
  }
  
  private static String eiQ()
  {
    AppMethodBeat.i(220184);
    localObject = new JSONObject();
    try
    {
      ay localay = ay.aRW("ad_id_kv_pref");
      String[] arrayOfString = localay.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          ((JSONObject)localObject).put(str, localay.getString(str, ""));
          i += 1;
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ae.e("ad.waid.WaidHelper", "dumpKV exp=" + localThrowable.toString());
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(220184);
    }
  }
  
  private static int eiR()
  {
    AppMethodBeat.i(220185);
    try
    {
      String[] arrayOfString = ay.aRW("ad_id_kv_pref").allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(220185);
        return 0;
      }
      int i = arrayOfString.length;
      AppMethodBeat.o(220185);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ae.e("ad.waid.WaidHelper", "getKVCount exp=" + localThrowable.toString());
      AppMethodBeat.o(220185);
    }
    return 0;
  }
  
  public static boolean eiS()
  {
    AppMethodBeat.i(220186);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxj, 0) > 0)
      {
        AppMethodBeat.o(220186);
        return true;
      }
      AppMethodBeat.o(220186);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(220186);
    }
    return false;
  }
  
  private static boolean eiT()
  {
    AppMethodBeat.i(220187);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxi, 1) > 0)
      {
        AppMethodBeat.o(220187);
        return true;
      }
      AppMethodBeat.o(220187);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("ad.waid.WaidHelper", "isInnerExptWaidEnable, exp=" + localThrowable.toString());
      AppMethodBeat.o(220187);
    }
    return false;
  }
  
  private static boolean eiU()
  {
    AppMethodBeat.i(220188);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxk, 0) > 0)
      {
        AppMethodBeat.o(220188);
        return true;
      }
      AppMethodBeat.o(220188);
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + localThrowable.toString());
      AppMethodBeat.o(220188);
    }
    return false;
  }
  
  public static boolean eiV()
  {
    AppMethodBeat.i(220189);
    if ((com.tencent.mm.kernel.g.ajS().gED) && (com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(220189);
      return true;
    }
    AppMethodBeat.o(220189);
    return false;
  }
  
  private static String kf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220182);
    paramString1 = bu.nullAsNil(paramString1).trim();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(220182);
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
        AppMethodBeat.o(220182);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      ae.e("ad.waid.WaidHelper", "getAppWaid, exp=" + paramString1.toString());
      AppMethodBeat.o(220182);
    }
    return "";
  }
  
  private static void kg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220183);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(220183);
      return;
    }
    paramString2 = bu.nullAsNil(paramString2);
    ay localay = ay.aRW("ad_id_kv_pref");
    int i = eiR();
    if (i >= 10)
    {
      localay.clear().commit();
      ae.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(i)));
    }
    localay.edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(220183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */