package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static HashSet<String> DsI;
  
  static
  {
    AppMethodBeat.i(201915);
    DsI = new HashSet();
    AppMethodBeat.o(201915);
  }
  
  private static e.a a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z paramz)
  {
    AppMethodBeat.i(201911);
    if ((paramz instanceof k))
    {
      paramz = (k)paramz;
      if ((paramz != null) && (!TextUtils.isEmpty(paramz.username)))
      {
        e.a locala = new e.a();
        locala.DsJ = paramz.username;
        locala.weAppType = paramz.weAppType;
        AppMethodBeat.o(201911);
        return locala;
      }
    }
    AppMethodBeat.o(201911);
    return null;
  }
  
  public static void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z paramz, ArrayList<e.a> paramArrayList)
  {
    AppMethodBeat.i(201910);
    Object localObject;
    try
    {
      if (i.Zi(paramz.type))
      {
        localObject = paramz.eXg();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)((Iterator)localObject).next(), paramArrayList);
          }
        }
        localObject = null;
      }
    }
    catch (Throwable paramz)
    {
      Log.e("AdWeAppPreloader", "parseComponentWeAppInfo exp=" + paramz.toString());
      AppMethodBeat.o(201910);
      return;
    }
    for (;;)
    {
      if ((localObject != null) && (!paramArrayList.contains(localObject))) {
        paramArrayList.add(localObject);
      }
      Log.d("AdWeAppPreloader", "parseComponentWeAppInfo, type=" + paramz.type + ", subType=" + paramz.subType + ", size=" + paramArrayList.size());
      AppMethodBeat.o(201910);
      return;
      if ((paramz instanceof ad)) {
        localObject = a(((ad)paramz).DZH);
      } else if ((paramz instanceof d)) {
        localObject = a(((d)paramz).DtV);
      } else {
        localObject = a(paramz);
      }
    }
  }
  
  private static void aNG(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201913);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(201913);
          return;
        }
        if (DsI.contains(paramString))
        {
          Log.w("AdWeAppPreloader", "doPreloadWeAppPkg, already preloaded, userName=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(201913);
          continue;
        }
        Log.i("AdWeAppPreloader", "doPreloadWeAppPkg, userName=".concat(String.valueOf(paramString)));
      }
      finally {}
      DsI.add(paramString);
      ((w)g.af(w.class)).bb(paramString, 5);
      AppMethodBeat.o(201913);
    }
  }
  
  private static void b(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(201912);
    Log.i("AdWeAppPreloader", "startPreloadWeApp, preloadWeAppPkg=" + paramBoolean1 + ", hasWeGame=" + paramBoolean2 + ", hasWeApp=" + paramBoolean3 + ", weAppUserName=" + gM(paramList));
    if (paramBoolean3) {}
    try
    {
      l = System.currentTimeMillis();
      ((f)g.af(f.class)).b(com.tencent.mm.plugin.appbrand.service.z.nMI);
      Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniProgram, timeCost=" + (System.currentTimeMillis() - l));
      if (!paramBoolean2) {}
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        l = System.currentTimeMillis();
        ((f)g.af(f.class)).c(com.tencent.mm.plugin.appbrand.service.z.nMI);
        Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniGame, timeCost=" + (System.currentTimeMillis() - l));
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            l = System.currentTimeMillis();
            ((j)g.af(j.class)).bc(paramList);
            Log.i("AdWeAppPreloader", "startPreloadWeApp->batchSyncWxaAttr, timeCost=" + (System.currentTimeMillis() - l));
            if (paramBoolean1) {
              try
              {
                l = System.currentTimeMillis();
                paramList = paramList.iterator();
                while (paramList.hasNext()) {
                  aNG((String)paramList.next());
                }
                AppMethodBeat.o(201912);
              }
              catch (Throwable paramList)
              {
                Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadWeAppPkg, exp=" + paramList.toString());
              }
            }
            return;
            localThrowable1 = localThrowable1;
            Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniProgram, exp=" + localThrowable1.toString());
            continue;
            localThrowable2 = localThrowable2;
            Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniGame, exp=" + localThrowable2.toString());
          }
        }
        catch (Throwable localThrowable3)
        {
          long l;
          for (;;)
          {
            Log.e("AdWeAppPreloader", "startPreloadWeApp->batchSyncWxaAttr, exp=" + localThrowable3.toString());
          }
          Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadWeAppPkg, timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(201912);
        }
      }
    }
  }
  
  public static boolean f(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(201908);
    if (paramSnsInfo == null)
    {
      Log.e("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsInfo==null");
      AppMethodBeat.o(201908);
      return false;
    }
    try
    {
      localArrayList = new ArrayList();
      localObject = paramSnsInfo.getAdInfo();
      localADXml = paramSnsInfo.getAdXml();
      paramSnsInfo = r.Jb(paramSnsInfo.field_snsId);
      if ((localADXml == null) || (!localADXml.preloadWeAppPkg)) {
        break label496;
      }
      bool5 = true;
      if ((localObject == null) || (((ADInfo)localObject).actionExtWeApp == null)) {
        break label600;
      }
      String str = ((ADInfo)localObject).actionExtWeApp.appUserName;
      i = ((ADInfo)localObject).actionExtWeApp.weAppType;
      if (TextUtils.isEmpty(str)) {
        break label600;
      }
      localArrayList.add(str);
      if (i != 2) {
        break label502;
      }
      bool3 = false;
      bool4 = true;
      label130:
      Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, adInfo.actionExtWeApp, userName=" + str + ", type=" + i);
    }
    catch (Throwable paramSnsInfo)
    {
      for (;;)
      {
        ArrayList localArrayList;
        Object localObject;
        ADXml localADXml;
        boolean bool5;
        int i;
        boolean bool2;
        boolean bool1;
        label255:
        Log.e("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, exp=" + paramSnsInfo.toString());
        continue;
        boolean bool3 = false;
        boolean bool4 = false;
      }
    }
    bool2 = bool3;
    bool1 = bool4;
    if (localADXml != null)
    {
      bool2 = bool3;
      bool1 = bool4;
      if (localADXml.adCardActionBtnInfo != null)
      {
        localObject = localADXml.adCardActionBtnInfo.weappUserName;
        i = localADXml.adCardActionBtnInfo.weAppType;
        bool2 = bool3;
        bool1 = bool4;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool2 = bool3;
          bool1 = bool4;
          if (!localArrayList.contains(localObject))
          {
            localArrayList.add(localObject);
            if (i != 2) {
              break label511;
            }
            bool1 = true;
            bool2 = bool3;
            Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, actionBtnWeApp, userName=" + (String)localObject + ", type=" + i);
          }
        }
      }
    }
    bool4 = bool2;
    bool3 = bool1;
    if (localADXml != null)
    {
      bool4 = bool2;
      bool3 = bool1;
      if (localADXml.weAppInfo != null)
      {
        localObject = localADXml.weAppInfo.appUserName;
        i = localADXml.weAppInfo.weAppType;
        bool4 = bool2;
        bool3 = bool1;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool4 = bool2;
          bool3 = bool1;
          if (!localArrayList.contains(localObject))
          {
            localArrayList.add(localObject);
            if (i != 2) {
              break label519;
            }
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, headWeApp, userName=" + (String)localObject + ", type=" + i);
      bool3 = bool1;
      bool4 = bool2;
      if (localArrayList.isEmpty()) {
        break label524;
      }
      Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsId=" + paramSnsInfo + ", preloadWeAppPkg=" + bool5 + ", hasWeApp=" + bool4 + ", hasWeGame=" + bool3);
      b(localArrayList, bool5, bool3, bool4);
      AppMethodBeat.o(201908);
      return true;
      label496:
      bool5 = false;
      break;
      label502:
      bool3 = true;
      bool4 = false;
      break label130;
      label511:
      bool2 = true;
      bool1 = bool4;
      break label255;
      label519:
      bool2 = true;
    }
    label524:
    Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsId=" + paramSnsInfo + ", preloadWeAppPkg=" + bool5 + ", no weAppUserName");
    AppMethodBeat.o(201908);
    return false;
  }
  
  public static boolean g(ArrayList<e.a> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(201909);
    ArrayList localArrayList;
    boolean bool1;
    boolean bool2;
    if (!paramArrayList.isEmpty())
    {
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      bool1 = false;
      bool2 = false;
      while (paramArrayList.hasNext())
      {
        e.a locala = (e.a)paramArrayList.next();
        if ((TextUtils.isEmpty(locala.DsJ)) || (localArrayList.contains(locala.DsJ))) {
          break label214;
        }
        localArrayList.add(locala.DsJ);
        if (locala.weAppType == 2) {
          bool2 = true;
        } else {
          bool1 = true;
        }
      }
    }
    label214:
    for (;;)
    {
      break;
      if (!localArrayList.isEmpty())
      {
        Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + paramBoolean + ", hasWeApp=" + bool1 + ", hasWeGame=" + bool2);
        b(localArrayList, paramBoolean, bool2, bool1);
      }
      for (;;)
      {
        AppMethodBeat.o(201909);
        return true;
        Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + paramBoolean + ", no weAppUserName");
      }
      AppMethodBeat.o(201909);
      return false;
    }
  }
  
  private static String gM(List<String> paramList)
  {
    AppMethodBeat.i(201914);
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i != paramList.size() - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      localStringBuilder.append(']');
      paramList = localStringBuilder.toString();
      AppMethodBeat.o(201914);
      return paramList;
    }
    AppMethodBeat.o(201914);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.e
 * JD-Core Version:    0.7.0.1
 */