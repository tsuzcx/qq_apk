package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.e;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static HashSet<String> Jzs;
  
  static
  {
    AppMethodBeat.i(218521);
    Jzs = new HashSet();
    AppMethodBeat.o(218521);
  }
  
  private static h.a a(aa paramaa)
  {
    AppMethodBeat.i(218516);
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l))
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramaa;
      if ((paramaa != null) && (!TextUtils.isEmpty(paramaa.username)))
      {
        h.a locala = new h.a();
        locala.Jzt = paramaa.username;
        locala.Jxz = paramaa.Jxz;
        AppMethodBeat.o(218516);
        return locala;
      }
    }
    AppMethodBeat.o(218516);
    return null;
  }
  
  public static void a(aa paramaa, ArrayList<h.a> paramArrayList)
  {
    AppMethodBeat.i(218515);
    Object localObject;
    try
    {
      if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.agz(paramaa.type))
      {
        localObject = paramaa.fKw();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((aa)((Iterator)localObject).next(), paramArrayList);
          }
        }
        localObject = null;
      }
    }
    catch (Throwable paramaa)
    {
      Log.e("AdWeAppPreloader", "parseComponentWeAppInfo exp=" + paramaa.toString());
      AppMethodBeat.o(218515);
      return;
    }
    for (;;)
    {
      if ((localObject != null) && (!paramArrayList.contains(localObject))) {
        paramArrayList.add(localObject);
      }
      Log.d("AdWeAppPreloader", "parseComponentWeAppInfo, type=" + paramaa.type + ", subType=" + paramaa.subType + ", size=" + paramArrayList.size());
      AppMethodBeat.o(218515);
      return;
      if ((paramaa instanceof ae)) {
        localObject = a(((ae)paramaa).Knc);
      } else if ((paramaa instanceof e)) {
        localObject = a(((e)paramaa).JBO);
      } else {
        localObject = a(paramaa);
      }
    }
  }
  
  private static void aYr(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(218518);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(218518);
          return;
        }
        if (Jzs.contains(paramString))
        {
          Log.w("AdWeAppPreloader", "doPreloadWeAppPkg, already preloaded, userName=".concat(String.valueOf(paramString)));
          AppMethodBeat.o(218518);
          continue;
        }
        Log.i("AdWeAppPreloader", "doPreloadWeAppPkg, userName=".concat(String.valueOf(paramString)));
      }
      finally {}
      Jzs.add(paramString);
      ((w)com.tencent.mm.kernel.h.ae(w.class)).bu(paramString, 5);
      com.tencent.mm.plugin.report.service.h.IzE.el(1612, 45);
      AppMethodBeat.o(218518);
    }
  }
  
  private static void b(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(218517);
    Log.i("AdWeAppPreloader", "startPreloadWeApp, preloadWeAppPkg=" + paramBoolean1 + ", hasWeGame=" + paramBoolean2 + ", hasWeApp=" + paramBoolean3 + ", weAppUserName=" + hs(paramList));
    if (paramBoolean3) {}
    try
    {
      l = System.currentTimeMillis();
      ((f)com.tencent.mm.kernel.h.ae(f.class)).b(z.qPa);
      Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniProgram, timeCost=" + (System.currentTimeMillis() - l));
      if (!paramBoolean2) {}
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        l = System.currentTimeMillis();
        ((f)com.tencent.mm.kernel.h.ae(f.class)).c(z.qPa);
        Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniGame, timeCost=" + (System.currentTimeMillis() - l));
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            l = System.currentTimeMillis();
            ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.j.class)).ba(paramList);
            Log.i("AdWeAppPreloader", "startPreloadWeApp->batchSyncWxaAttr, timeCost=" + (System.currentTimeMillis() - l));
            if (paramBoolean1) {
              try
              {
                l = System.currentTimeMillis();
                paramList = paramList.iterator();
                while (paramList.hasNext()) {
                  aYr((String)paramList.next());
                }
                AppMethodBeat.o(218517);
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
          AppMethodBeat.o(218517);
        }
      }
    }
  }
  
  public static boolean g(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(218512);
    if (paramSnsInfo == null)
    {
      Log.e("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsInfo==null");
      AppMethodBeat.o(218512);
      return false;
    }
    try
    {
      localArrayList = new ArrayList();
      localObject2 = paramSnsInfo.getAdInfo();
      localObject1 = paramSnsInfo.getAdXml();
      paramSnsInfo = t.Qu(paramSnsInfo.field_snsId);
      if ((localObject1 == null) || (!((ADXml)localObject1).preloadWeAppPkg)) {
        break label1012;
      }
      bool7 = true;
    }
    catch (Throwable paramSnsInfo)
    {
      for (;;)
      {
        ArrayList localArrayList;
        Object localObject2;
        Object localObject1;
        boolean bool5;
        boolean bool3;
        boolean bool6;
        boolean bool4;
        String str;
        int i;
        Log.e("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, exp=" + paramSnsInfo.toString());
        continue;
        boolean bool1 = bool6;
        boolean bool2 = bool5;
        continue;
        boolean bool7 = false;
        continue;
        bool2 = true;
        bool1 = bool3;
        continue;
        bool2 = true;
        continue;
        bool1 = true;
        bool2 = bool3;
        continue;
        bool1 = true;
        continue;
        bool1 = true;
        bool2 = bool3;
      }
    }
    bool5 = false;
    bool3 = false;
    bool6 = false;
    bool4 = false;
    bool2 = bool6;
    bool1 = bool5;
    if (localObject2 != null)
    {
      bool2 = bool6;
      bool1 = bool5;
      if (((ADInfo)localObject2).actionExtWeApp != null)
      {
        str = ((ADInfo)localObject2).actionExtWeApp.appUserName;
        i = ((ADInfo)localObject2).actionExtWeApp.Jxz;
        bool2 = bool6;
        bool1 = bool5;
        if (!TextUtils.isEmpty(str))
        {
          localArrayList.add(str);
          if (i != 2) {
            break label1018;
          }
          bool1 = true;
          bool2 = bool4;
          Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, adInfo.actionExtWeApp, userName=" + str + ", type=" + i);
        }
      }
    }
    bool4 = bool2;
    bool3 = bool1;
    if (localObject1 != null)
    {
      bool4 = bool2;
      bool3 = bool1;
      if (((ADXml)localObject1).adCardActionBtnInfo != null)
      {
        bool4 = bool2;
        bool3 = bool1;
        if (((ADXml)localObject1).adCardActionBtnInfo.clickActionInfo != null)
        {
          localObject2 = ((ADXml)localObject1).adCardActionBtnInfo.clickActionInfo.uMJ;
          i = ((ADXml)localObject1).adCardActionBtnInfo.clickActionInfo.Jxz;
          bool4 = bool2;
          bool3 = bool1;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            bool4 = bool2;
            bool3 = bool1;
            if (!localArrayList.contains(localObject2))
            {
              localArrayList.add(localObject2);
              if (i != 2) {
                break label1026;
              }
              bool1 = true;
              Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, actionBtnWeApp, userName=" + (String)localObject2 + ", type=" + i);
              bool3 = bool1;
              bool4 = bool2;
            }
          }
        }
      }
    }
    bool1 = bool4;
    bool2 = bool3;
    if (localObject1 != null)
    {
      bool1 = bool4;
      bool2 = bool3;
      if (((ADXml)localObject1).weAppInfo != null)
      {
        localObject2 = ((ADXml)localObject1).weAppInfo.appUserName;
        i = ((ADXml)localObject1).weAppInfo.Jxz;
        bool1 = bool4;
        bool2 = bool3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          bool1 = bool4;
          bool2 = bool3;
          if (!localArrayList.contains(localObject2))
          {
            localArrayList.add(localObject2);
            if (i != 2) {
              break label1031;
            }
            bool2 = true;
            bool1 = bool4;
            Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, headWeApp, userName=" + (String)localObject2 + ", type=" + i);
          }
        }
      }
    }
    bool3 = bool1;
    bool4 = bool2;
    if (localObject1 != null)
    {
      bool3 = bool1;
      bool4 = bool2;
      if (((ADXml)localObject1).adSliderFullCardInfo != null)
      {
        bool3 = bool1;
        bool4 = bool2;
        if (((ADXml)localObject1).adSliderFullCardInfo.Jym != null)
        {
          localObject1 = ((ADXml)localObject1).adSliderFullCardInfo.Jym;
          bool3 = bool1;
          bool4 = bool2;
          if (!d.isEmpty((Collection)localObject1))
          {
            localObject1 = ((List)localObject1).iterator();
            bool3 = bool1;
            bool4 = bool2;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.sns.ad.adxml.i)((Iterator)localObject1).next();
              bool6 = bool1;
              bool5 = bool2;
              if (localObject2 == null) {
                break label1003;
              }
              bool4 = bool1;
              bool3 = bool2;
              if (((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).clickActionInfo != null)
              {
                str = ((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).clickActionInfo.uMJ;
                i = ((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).clickActionInfo.Jxz;
                bool4 = bool1;
                bool3 = bool2;
                if (!TextUtils.isEmpty(str))
                {
                  bool4 = bool1;
                  bool3 = bool2;
                  if (!localArrayList.contains(str))
                  {
                    localArrayList.add(str);
                    if (i != 2) {
                      break label1039;
                    }
                    bool2 = true;
                    Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, adSliderFullCardWeApp, weAppUserName = " + str + ", weAppType = " + i);
                    bool3 = bool2;
                    bool4 = bool1;
                  }
                }
              }
              bool6 = bool4;
              bool5 = bool3;
              if (((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).JyD == null) {
                break label1003;
              }
              bool6 = bool4;
              bool5 = bool3;
              if (((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).JyD.JyK == null) {
                break label1003;
              }
              str = ((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).JyD.JyK.uMJ;
              i = ((com.tencent.mm.plugin.sns.ad.adxml.i)localObject2).JyD.JyK.Jxz;
              bool6 = bool4;
              bool5 = bool3;
              if (TextUtils.isEmpty(str)) {
                break label1003;
              }
              bool6 = bool4;
              bool5 = bool3;
              if (localArrayList.contains(str)) {
                break label1003;
              }
              localArrayList.add(str);
              if (i != 2) {
                break label1044;
              }
              bool2 = true;
              bool1 = bool4;
              Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, adSliderFullCardBtnWeApp, btnWeAppUserName = " + str + ", btnWeAppType = " + i);
              break label1009;
            }
          }
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsId=" + paramSnsInfo + ", preloadWeAppPkg=" + bool7 + ", hasWeApp=" + bool3 + ", hasWeGame=" + bool4);
      b(localArrayList, bool7, bool4, bool3);
      AppMethodBeat.o(218512);
      return true;
    }
    Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForTimeLine, snsId=" + paramSnsInfo + ", preloadWeAppPkg=" + bool7 + ", no weAppUserName");
    AppMethodBeat.o(218512);
    return false;
  }
  
  public static boolean h(ArrayList<h.a> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(218514);
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
        h.a locala = (h.a)paramArrayList.next();
        if ((TextUtils.isEmpty(locala.Jzt)) || (localArrayList.contains(locala.Jzt))) {
          break label214;
        }
        localArrayList.add(locala.Jzt);
        if (locala.Jxz == 2) {
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
        AppMethodBeat.o(218514);
        return true;
        Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + paramBoolean + ", no weAppUserName");
      }
      AppMethodBeat.o(218514);
      return false;
    }
  }
  
  private static String hs(List<String> paramList)
  {
    AppMethodBeat.i(218519);
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
      AppMethodBeat.o(218519);
      return paramList;
    }
    AppMethodBeat.o(218519);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.h
 * JD-Core Version:    0.7.0.1
 */