package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
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
  private final WeakReference<? extends Context> mContextRef;
  private final List<c> zdQ;
  
  private a(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197786);
    this.mContextRef = new WeakReference(paramContext);
    this.zdQ = aF(paramMap);
    AppMethodBeat.o(197786);
  }
  
  private static boolean PL(int paramInt)
  {
    return paramInt <= 1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197794);
    b(paramString1, paramString2, paramString3, paramInt, paramString4, aG(paramMap));
    AppMethodBeat.o(197794);
  }
  
  private static List<c> aF(Map<String, String> paramMap)
  {
    AppMethodBeat.i(197787);
    ArrayList localArrayList = new ArrayList();
    if ((!paramMap.containsKey(".adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema")) && (paramMap.containsKey(".RecXml.adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema"))) {}
    String str2;
    c localc;
    String str4;
    String str3;
    for (String str1 = ".RecXml.adxml.adCanvasInfo.adMarketJump.";; str1 = ".adxml.adCanvasInfo.adMarketJump.")
    {
      str2 = eQ(str1 + "marketTag", 0);
      int j = 0;
      for (;;)
      {
        if ((!paramMap.containsKey(str2 + ".marketSchema")) || (j >= 20)) {
          break label457;
        }
        localc = new c();
        localc.zdX = ((String)paramMap.get(str2 + ".brand"));
        localc.zdT = ((String)paramMap.get(str2 + ".appPackage"));
        localc.zdU = ((String)paramMap.get(str2 + ".marketName"));
        localc.zdW = d(paramMap, str2, "marketPackage");
        localc.zdV = d(paramMap, str2, "marketSchema");
        str4 = Build.BRAND;
        str2 = Build.MANUFACTURER;
        str3 = localc.zdX;
        localc.mPriority = 2;
        if ((!TextUtils.isEmpty(str3)) && (str4 != null))
        {
          str3 = str3.toLowerCase();
          str4 = str4.toLowerCase();
          if (!str3.equals(str4)) {
            break;
          }
          localc.mPriority = 0;
        }
        localArrayList.add(localc);
        j += 1;
        str2 = eQ(str1 + "marketTag", j);
      }
    }
    String str5;
    int i;
    if ((str3 != null) && (str2 != null))
    {
      str5 = str3.toLowerCase();
      str2 = str2.toLowerCase();
      if (str5.equals(str2)) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.mPriority = i;
      if ((localc.mPriority < 2) || (!str3.contains(str4))) {
        break;
      }
      localc.mPriority = 1;
      break;
      if (str5.contains(str2)) {
        i = 1;
      } else if (str2.contains(str5)) {
        i = 2;
      } else {
        i = 3;
      }
    }
    label457:
    Collections.sort(localArrayList, new c.a());
    AppMethodBeat.o(197787);
    return localArrayList;
  }
  
  private static String aG(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197795);
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
        AppMethodBeat.o(197795);
      }
      catch (Throwable paramMap) {}
    } else {
      return "";
    }
    paramMap = localJSONObject.toString();
    AppMethodBeat.o(197795);
    return paramMap;
  }
  
  public static boolean aJ(Intent paramIntent)
  {
    AppMethodBeat.i(197791);
    if (paramIntent != null) {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("brand_state", false);
        AppMethodBeat.o(197791);
        return bool;
      }
      catch (Throwable paramIntent)
      {
        ad.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      }
    }
    AppMethodBeat.o(197791);
    return false;
  }
  
  public static boolean aK(Intent paramIntent)
  {
    AppMethodBeat.i(197792);
    if (paramIntent != null) {
      try
      {
        if (!TextUtils.isEmpty(paramIntent.getAction()))
        {
          paramIntent = paramIntent.getData();
          if (paramIntent != null)
          {
            AppMethodBeat.o(197792);
            return true;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        ad.w("MICROMSG.AdAppMarketHelper", "isAppMarketIntentValid has something error");
      }
    }
    AppMethodBeat.o(197792);
    return false;
  }
  
  public static a b(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197784);
    try
    {
      paramContext = new a(paramContext, paramMap);
      AppMethodBeat.o(197784);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ad.e("MICROMSG.AdAppMarketHelper", "create aAdAppMarketHelper failed!");
      AppMethodBeat.o(197784);
    }
    return null;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(197793);
    try
    {
      g.yhR.f(19790, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt), paramString4, paramString5 });
      ad.i("MICROMSG.AdAppMarketHelper", "report19790 snsId=" + paramString1 + ", uxInfo=" + paramString2 + ", adExtInfo =" + paramString3 + ", actType =" + paramInt + ", actValue = " + paramString4 + ", extInfo = " + paramString5);
      AppMethodBeat.o(197793);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("MICROMSG.AdAppMarketHelper", "report19790 exp:" + paramString1.toString());
      AppMethodBeat.o(197793);
    }
  }
  
  private static List<String> d(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(197789);
    ArrayList localArrayList = new ArrayList();
    for (String str = eQ(paramString1 + "." + paramString2, 0); (paramMap.containsKey(str)) && (i < 10); str = eQ(paramString1 + "." + paramString2, i))
    {
      str = (String)paramMap.get(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(197789);
    return localArrayList;
  }
  
  private static void d(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(197790);
    if (paramIntent != null) {}
    try
    {
      paramIntent.putExtra("brand_state", paramBoolean);
      AppMethodBeat.o(197790);
      return;
    }
    catch (Throwable paramIntent)
    {
      ad.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      AppMethodBeat.o(197790);
    }
  }
  
  private static String eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(197788);
    if (paramInt == 0)
    {
      AppMethodBeat.o(197788);
      return paramString;
    }
    paramString = paramString + paramInt;
    AppMethodBeat.o(197788);
    return paramString;
  }
  
  public final Intent dSS()
  {
    AppMethodBeat.i(197785);
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      c localc;
      PackageManager localPackageManager;
      Iterator localIterator2;
      try
      {
        localObject2 = (Context)this.mContextRef.get();
        if (localObject2 == null)
        {
          ad.w("MICROMSG.AdAppMarketHelper", "the context is null, activity is finished?");
          AppMethodBeat.o(197785);
          return null;
        }
        localObject3 = this.zdQ;
        if (localObject3 == null) {
          break label328;
        }
        Iterator localIterator1 = ((List)localObject3).iterator();
        if (!localIterator1.hasNext()) {
          break label245;
        }
        localc = (c)localIterator1.next();
        if (localc == null) {
          continue;
        }
        if (localObject2 == null) {
          break label336;
        }
        localPackageManager = ((Context)localObject2).getPackageManager();
        ArrayList localArrayList = new ArrayList();
        localIterator2 = localc.dSU().iterator();
        if (localIterator2.hasNext())
        {
          Intent localIntent = ((b)localIterator2.next()).dST();
          if (localIntent == null) {
            continue;
          }
          localArrayList.add(localIntent);
          continue;
        }
        localIterator2 = localThrowable1.iterator();
      }
      catch (Throwable localThrowable1)
      {
        ad.d("MICROMSG.AdAppMarketHelper", "screen intent failed");
        AppMethodBeat.o(197785);
        return null;
      }
      Object localObject1;
      while (localIterator2.hasNext())
      {
        localObject1 = (Intent)localIterator2.next();
        if (((Intent)localObject1).resolveActivity(localPackageManager) != null) {
          ((Intent)localObject1).putExtra("market_priority", localc.mPriority);
        }
      }
      while (localObject1 != null)
      {
        d((Intent)localObject1, PL(localc.mPriority));
        AppMethodBeat.o(197785);
        return localObject1;
        label245:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = (c)((List)localObject3).get(0);
          if (localObject1 != null)
          {
            localObject2 = new Intent();
            localObject3 = ((c)localObject1).zdT;
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Intent)localObject2).putExtra("target_app_id", (String)localObject3);
              }
              d((Intent)localObject2, PL(((c)localObject1).mPriority));
              AppMethodBeat.o(197785);
              return localObject2;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                ad.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
              }
            }
          }
        }
        label328:
        AppMethodBeat.o(197785);
        return null;
        label336:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.a
 * JD-Core Version:    0.7.0.1
 */