package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
{
  private final List<c> QoA;
  private final WeakReference<? extends Context> mContextRef;
  
  private a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(306356);
    this.mContextRef = new WeakReference(paramContext);
    this.QoA = U(paramString, paramMap);
    AppMethodBeat.o(306356);
  }
  
  private a(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(306351);
    this.mContextRef = new WeakReference(paramContext);
    this.QoA = aV(paramMap);
    AppMethodBeat.o(306351);
  }
  
  private static List<c> U(String paramString, Map<String, String> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(306366);
    ArrayList localArrayList = new ArrayList();
    for (String str = gT(paramString + "marketTag", 0); (paramMap.containsKey(str + ".marketSchema")) && (i < 20); str = gT(paramString + "marketTag", i))
    {
      c localc = new c();
      localc.QoH = ((String)paramMap.get(str + ".brand"));
      localc.QoD = ((String)paramMap.get(str + ".appPackage"));
      localc.QoE = ((String)paramMap.get(str + ".marketName"));
      localc.QoG = d(paramMap, str, "marketPackage");
      localc.QoF = d(paramMap, str, "marketSchema");
      a(localc);
      localArrayList.add(localc);
      i += 1;
    }
    Collections.sort(localArrayList, new c.a());
    AppMethodBeat.o(306366);
    return localArrayList;
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(306384);
    String str2 = Build.BRAND;
    String str1 = Build.MANUFACTURER;
    String str3 = paramc.QoH;
    paramc.mPriority = 2;
    if ((!TextUtils.isEmpty(str3)) && (str2 != null))
    {
      str3 = str3.toLowerCase();
      str2 = str2.toLowerCase();
      if (str3.equals(str2))
      {
        paramc.mPriority = 0;
        AppMethodBeat.o(306384);
        return;
      }
      paramc.mPriority = lZ(str3, str1);
      if ((paramc.mPriority >= 2) && (str3.contains(str2))) {
        paramc.mPriority = 1;
      }
    }
    AppMethodBeat.o(306384);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(306412);
    try
    {
      h.OAn.b(19790, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt), paramString4, paramString5 });
      Log.i("MICROMSG.AdAppMarketHelper", "report19790 snsId=" + paramString1 + ", uxInfo=" + paramString2 + ", adExtInfo =" + paramString3 + ", actType =" + paramInt + ", actValue = " + paramString4 + ", extInfo = " + paramString5);
      AppMethodBeat.o(306412);
      return;
    }
    finally
    {
      Log.e("MICROMSG.AdAppMarketHelper", "report19790 exp:" + paramString1.toString());
      AppMethodBeat.o(306412);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(306416);
    a(paramString1, paramString2, paramString3, paramInt, paramString4, aW(paramMap));
    AppMethodBeat.o(306416);
  }
  
  private static List<c> aV(Map<String, String> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(306360);
    ArrayList localArrayList = new ArrayList();
    if ((!paramMap.containsKey(".adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema")) && (paramMap.containsKey(".RecXml.adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema"))) {}
    for (String str1 = ".RecXml.adxml.adCanvasInfo.adMarketJump.";; str1 = ".adxml.adCanvasInfo.adMarketJump.") {
      for (String str2 = gT(str1 + "marketTag", 0); (paramMap.containsKey(str2 + ".marketSchema")) && (i < 20); str2 = gT(str1 + "marketTag", i))
      {
        c localc = new c();
        localc.QoH = ((String)paramMap.get(str2 + ".brand"));
        localc.QoD = ((String)paramMap.get(str2 + ".appPackage"));
        localc.QoE = ((String)paramMap.get(str2 + ".marketName"));
        localc.QoG = d(paramMap, str2, "marketPackage");
        localc.QoF = d(paramMap, str2, "marketSchema");
        a(localc);
        localArrayList.add(localc);
        i += 1;
      }
    }
    Collections.sort(localArrayList, new c.a());
    AppMethodBeat.o(306360);
    return localArrayList;
  }
  
  private static String aW(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(306417);
    JSONObject localJSONObject;
    if (paramMap != null) {
      try
      {
        if (!paramMap.isEmpty())
        {
          localJSONObject = new JSONObject();
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, paramMap.get(str));
          }
        }
        AppMethodBeat.o(306417);
      }
      finally {}
    } else {
      return "";
    }
    paramMap = localJSONObject.toString();
    AppMethodBeat.o(306417);
    return paramMap;
  }
  
  private static boolean akw(int paramInt)
  {
    return paramInt <= 1;
  }
  
  public static a b(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(306345);
    try
    {
      paramContext = new a(paramContext, paramString, paramMap);
      AppMethodBeat.o(306345);
      return paramContext;
    }
    finally
    {
      Log.e("MICROMSG.AdAppMarketHelper", "create aAdAppMarketHelper failed!");
      AppMethodBeat.o(306345);
    }
    return null;
  }
  
  public static boolean bu(Intent paramIntent)
  {
    AppMethodBeat.i(306398);
    if (paramIntent != null) {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("brand_state", false);
        AppMethodBeat.o(306398);
        return bool;
      }
      finally
      {
        Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      }
    }
    AppMethodBeat.o(306398);
    return false;
  }
  
  public static boolean bv(Intent paramIntent)
  {
    AppMethodBeat.i(306403);
    if (paramIntent != null) {
      try
      {
        if (!TextUtils.isEmpty(paramIntent.getAction()))
        {
          paramIntent = paramIntent.getData();
          if (paramIntent != null)
          {
            AppMethodBeat.o(306403);
            return true;
          }
        }
      }
      finally
      {
        Log.w("MICROMSG.AdAppMarketHelper", "isAppMarketIntentValid has something error");
      }
    }
    AppMethodBeat.o(306403);
    return false;
  }
  
  public static a c(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(306342);
    try
    {
      paramContext = new a(paramContext, paramMap);
      AppMethodBeat.o(306342);
      return paramContext;
    }
    finally
    {
      Log.e("MICROMSG.AdAppMarketHelper", "create aAdAppMarketHelper failed!");
      AppMethodBeat.o(306342);
    }
    return null;
  }
  
  private static void c(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(306395);
    if (paramIntent != null) {}
    try
    {
      paramIntent.putExtra("brand_state", paramBoolean);
      AppMethodBeat.o(306395);
      return;
    }
    finally
    {
      Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      AppMethodBeat.o(306395);
    }
  }
  
  private static List<String> d(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(306375);
    ArrayList localArrayList = new ArrayList();
    for (String str = gT(paramString1 + "." + paramString2, 0); (paramMap.containsKey(str)) && (i < 10); str = gT(paramString1 + "." + paramString2, i))
    {
      str = (String)paramMap.get(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(306375);
    return localArrayList;
  }
  
  private static String gT(String paramString, int paramInt)
  {
    AppMethodBeat.i(306370);
    if (paramInt == 0)
    {
      AppMethodBeat.o(306370);
      return paramString;
    }
    paramString = paramString + paramInt;
    AppMethodBeat.o(306370);
    return paramString;
  }
  
  private static int lZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306387);
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.toLowerCase();
      if (paramString1.equals(paramString2))
      {
        AppMethodBeat.o(306387);
        return 0;
      }
      if (paramString1.contains(paramString2))
      {
        AppMethodBeat.o(306387);
        return 1;
      }
      if (paramString2.contains(paramString1))
      {
        AppMethodBeat.o(306387);
        return 2;
      }
    }
    AppMethodBeat.o(306387);
    return 3;
  }
  
  public final Intent heU()
  {
    AppMethodBeat.i(306420);
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      c localc;
      PackageManager localPackageManager;
      Object localObject6;
      try
      {
        localObject3 = (Context)this.mContextRef.get();
        if (localObject3 == null)
        {
          Log.w("MICROMSG.AdAppMarketHelper", "the context is null, activity is finished?");
          AppMethodBeat.o(306420);
          return null;
        }
        localObject4 = this.QoA;
        if (localObject4 == null) {
          break label338;
        }
        Iterator localIterator = ((List)localObject4).iterator();
        if (!localIterator.hasNext()) {
          break label254;
        }
        localc = (c)localIterator.next();
        if (localc == null) {
          continue;
        }
        if (localObject3 == null) {
          break label346;
        }
        localPackageManager = ((Context)localObject3).getPackageManager();
        ArrayList localArrayList = new ArrayList();
        localObject6 = localc.heW();
        if (localObject6 != null)
        {
          localObject6 = ((Collection)localObject6).iterator();
          if (((Iterator)localObject6).hasNext())
          {
            Intent localIntent = ((b)((Iterator)localObject6).next()).heV();
            if (localIntent == null) {
              continue;
            }
            localArrayList.add(localIntent);
            continue;
          }
        }
        localObject6 = localObject1.iterator();
      }
      finally
      {
        Log.d("MICROMSG.AdAppMarketHelper", "screen intent failed");
        AppMethodBeat.o(306420);
        return null;
      }
      Object localObject2;
      while (((Iterator)localObject6).hasNext())
      {
        localObject2 = (Intent)((Iterator)localObject6).next();
        if (((Intent)localObject2).resolveActivity(localPackageManager) != null) {
          ((Intent)localObject2).putExtra("market_priority", localc.mPriority);
        }
      }
      while (localObject2 != null)
      {
        c((Intent)localObject2, akw(localc.mPriority));
        AppMethodBeat.o(306420);
        return localObject2;
        label254:
        if (!((List)localObject4).isEmpty())
        {
          localObject2 = (c)((List)localObject4).get(0);
          if (localObject2 != null)
          {
            localObject3 = new Intent();
            localObject4 = ((c)localObject2).QoD;
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                ((Intent)localObject3).putExtra("target_app_id", (String)localObject4);
              }
              c((Intent)localObject3, akw(((c)localObject2).mPriority));
              AppMethodBeat.o(306420);
              return localObject3;
            }
            finally
            {
              for (;;)
              {
                Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
              }
            }
          }
        }
        label338:
        AppMethodBeat.o(306420);
        return null;
        label346:
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.a
 * JD-Core Version:    0.7.0.1
 */