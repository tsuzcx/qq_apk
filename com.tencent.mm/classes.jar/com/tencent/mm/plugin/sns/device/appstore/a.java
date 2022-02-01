package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
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
  private final WeakReference<? extends Context> avO;
  private final List<c> wBB;
  
  private a(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187280);
    this.avO = new WeakReference(paramContext);
    this.wBB = ay(paramMap);
    AppMethodBeat.o(187280);
  }
  
  private static boolean Mc(int paramInt)
  {
    return paramInt <= 1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(187288);
    b(paramString1, paramString2, paramString3, paramInt, paramString4, az(paramMap));
    AppMethodBeat.o(187288);
  }
  
  public static boolean aC(Intent paramIntent)
  {
    AppMethodBeat.i(187285);
    if (paramIntent != null) {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("brand_state", false);
        AppMethodBeat.o(187285);
        return bool;
      }
      catch (Throwable paramIntent)
      {
        ad.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      }
    }
    AppMethodBeat.o(187285);
    return false;
  }
  
  public static boolean aD(Intent paramIntent)
  {
    AppMethodBeat.i(187286);
    if (paramIntent != null) {
      try
      {
        if (!TextUtils.isEmpty(paramIntent.getAction()))
        {
          paramIntent = paramIntent.getData();
          if (paramIntent != null)
          {
            AppMethodBeat.o(187286);
            return true;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        ad.w("MICROMSG.AdAppMarketHelper", "isAppMarketIntentValid has something error");
      }
    }
    AppMethodBeat.o(187286);
    return false;
  }
  
  private static List<c> ay(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187281);
    ArrayList localArrayList = new ArrayList();
    if ((!paramMap.containsKey(".adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema")) && (paramMap.containsKey(".RecXml.adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema"))) {}
    String str2;
    c localc;
    String str4;
    String str3;
    for (String str1 = ".RecXml.adxml.adCanvasInfo.adMarketJump.";; str1 = ".adxml.adCanvasInfo.adMarketJump.")
    {
      str2 = eq(str1 + "marketTag", 0);
      int j = 0;
      for (;;)
      {
        if ((!paramMap.containsKey(str2 + ".marketSchema")) || (j >= 20)) {
          break label457;
        }
        localc = new c();
        localc.wBI = ((String)paramMap.get(str2 + ".brand"));
        localc.wBE = ((String)paramMap.get(str2 + ".appPackage"));
        localc.wBF = ((String)paramMap.get(str2 + ".marketName"));
        localc.wBH = d(paramMap, str2, "marketPackage");
        localc.wBG = d(paramMap, str2, "marketSchema");
        str4 = Build.BRAND;
        str2 = Build.MANUFACTURER;
        str3 = localc.wBI;
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
        str2 = eq(str1 + "marketTag", j);
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
    AppMethodBeat.o(187281);
    return localArrayList;
  }
  
  private static String az(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(187289);
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
        AppMethodBeat.o(187289);
      }
      catch (Throwable paramMap) {}
    } else {
      return "";
    }
    paramMap = localJSONObject.toString();
    AppMethodBeat.o(187289);
    return paramMap;
  }
  
  public static a b(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187278);
    try
    {
      paramContext = new a(paramContext, paramMap);
      AppMethodBeat.o(187278);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ad.e("MICROMSG.AdAppMarketHelper", "create aAdAppMarketHelper failed!");
      AppMethodBeat.o(187278);
    }
    return null;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(187287);
    try
    {
      h.vKh.f(19790, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt), paramString4, paramString5 });
      ad.i("MICROMSG.AdAppMarketHelper", "report19790 snsId=" + paramString1 + ", uxInfo=" + paramString2 + ", adExtInfo =" + paramString3 + ", actType =" + paramInt + ", actValue = " + paramString4 + ", extInfo = " + paramString5);
      AppMethodBeat.o(187287);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("MICROMSG.AdAppMarketHelper", "report19790 exp:" + paramString1.toString());
      AppMethodBeat.o(187287);
    }
  }
  
  private static List<String> d(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(187283);
    ArrayList localArrayList = new ArrayList();
    for (String str = eq(paramString1 + "." + paramString2, 0); (paramMap.containsKey(str)) && (i < 10); str = eq(paramString1 + "." + paramString2, i))
    {
      str = (String)paramMap.get(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(187283);
    return localArrayList;
  }
  
  private static void d(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(187284);
    if (paramIntent != null) {}
    try
    {
      paramIntent.putExtra("brand_state", paramBoolean);
      AppMethodBeat.o(187284);
      return;
    }
    catch (Throwable paramIntent)
    {
      ad.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
      AppMethodBeat.o(187284);
    }
  }
  
  private static String eq(String paramString, int paramInt)
  {
    AppMethodBeat.i(187282);
    if (paramInt == 0)
    {
      AppMethodBeat.o(187282);
      return paramString;
    }
    paramString = paramString + paramInt;
    AppMethodBeat.o(187282);
    return paramString;
  }
  
  public final Intent dsg()
  {
    AppMethodBeat.i(187279);
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      c localc;
      PackageManager localPackageManager;
      Iterator localIterator2;
      try
      {
        localObject2 = (Context)this.avO.get();
        if (localObject2 == null)
        {
          ad.w("MICROMSG.AdAppMarketHelper", "the context is null, activity is finished?");
          AppMethodBeat.o(187279);
          return null;
        }
        localObject3 = this.wBB;
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
        localIterator2 = localc.dsi().iterator();
        if (localIterator2.hasNext())
        {
          Intent localIntent = ((b)localIterator2.next()).dsh();
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
        AppMethodBeat.o(187279);
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
        d((Intent)localObject1, Mc(localc.mPriority));
        AppMethodBeat.o(187279);
        return localObject1;
        label245:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = (c)((List)localObject3).get(0);
          if (localObject1 != null)
          {
            localObject2 = new Intent();
            localObject3 = ((c)localObject1).wBE;
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Intent)localObject2).putExtra("target_app_id", (String)localObject3);
              }
              d((Intent)localObject2, Mc(((c)localObject1).mPriority));
              AppMethodBeat.o(187279);
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
        AppMethodBeat.o(187279);
        return null;
        label336:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.a
 * JD-Core Version:    0.7.0.1
 */