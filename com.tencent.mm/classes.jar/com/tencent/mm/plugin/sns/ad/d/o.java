package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.bk;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.a;
import com.tencent.mm.plugin.sns.storage.ADXml.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ah;

public final class o
{
  private static List<String> POl;
  public static Map<String, Long> POm;
  private static bk POn;
  
  static
  {
    AppMethodBeat.i(310060);
    POl = Collections.synchronizedList(new ArrayList());
    POm = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(310060);
  }
  
  public static void a(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(309972);
    if (paramSnsInfo == null)
    {
      Log.e("FinderAdPreloadHelper", "reqFinderFeedsObjectId, snsInfo is null");
      AppMethodBeat.o(309972);
      return;
    }
    Object localObject1;
    try
    {
      localObject1 = paramSnsInfo.getAdInfo(paramInt);
      if ((localObject1 == null) || (!((ADInfo)localObject1).preloadFinderFeed)) {
        break label366;
      }
      paramSnsInfo = paramSnsInfo.getAdXml();
      if (paramSnsInfo != null)
      {
        if (paramSnsInfo.adFinderInfo != null) {
          aWp(paramSnsInfo.adFinderInfo.hAx);
        }
        if (paramSnsInfo.adActionLinkClickInfo != null) {
          aWp(paramSnsInfo.adActionLinkClickInfo.PMe);
        }
        if ((paramSnsInfo.adCardActionBtnInfo != null) && (paramSnsInfo.adCardActionBtnInfo.clickActionInfo != null)) {
          aWp(paramSnsInfo.adCardActionBtnInfo.clickActionInfo.PMe);
        }
        if ((paramSnsInfo.adTagBtnInfo != null) && (paramSnsInfo.adTagBtnInfo.clickActionInfo != null)) {
          aWp(paramSnsInfo.adTagBtnInfo.clickActionInfo.PMe);
        }
        Object localObject2 = paramSnsInfo.getAdSelectInfo();
        if (localObject2 != null)
        {
          if (((ADXml.h)localObject2).QHR != null) {
            aWp(((ADXml.h)localObject2).QHR.PMe);
          }
          if (((ADXml.h)localObject2).QHS != null) {
            aWp(((ADXml.h)localObject2).QHS.PMe);
          }
        }
        if (paramSnsInfo.adSliderFullCardInfo != null)
        {
          paramSnsInfo = paramSnsInfo.adSliderFullCardInfo.PMG;
          if (!com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramSnsInfo))
          {
            paramSnsInfo = paramSnsInfo.iterator();
            while (paramSnsInfo.hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.sns.ad.adxml.l)paramSnsInfo.next();
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo != null) {
                  aWp(((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo.PMe);
                }
                if ((((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY != null) && (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj != null)) {
                  aWp(((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj.PMe);
                }
              }
            }
          }
        }
      }
      if (localObject1 == null) {
        break label317;
      }
    }
    finally
    {
      Log.e("FinderAdPreloadHelper", paramSnsInfo.toString());
      AppMethodBeat.o(309972);
      return;
    }
    if (com.tencent.mm.plugin.sns.ad.j.d.isEmpty(((ADInfo)localObject1).adClickActionInfoList))
    {
      label317:
      AppMethodBeat.o(309972);
      return;
    }
    paramSnsInfo = ((ADInfo)localObject1).adClickActionInfoList.iterator();
    while (paramSnsInfo.hasNext())
    {
      localObject1 = (AdClickActionInfo)paramSnsInfo.next();
      if (localObject1 != null) {
        aWp(((AdClickActionInfo)localObject1).PMe);
      }
    }
    label366:
    AppMethodBeat.o(309972);
  }
  
  private static void a(SnsInfo paramSnsInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(310020);
    Object localObject = paramSnsInfo.getAdInfo(paramInt1);
    if ((localObject == null) || (!((ADInfo)localObject).preloadFinderLive))
    {
      AppMethodBeat.o(310020);
      return;
    }
    if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3, paramString4 }))
    {
      Log.i("FinderAdPreloadHelper", "doCacheFinderLivingRoom, username, liveId, feedExportId or feedNonceId is null");
      AppMethodBeat.o(310020);
      return;
    }
    localObject = t.x(paramSnsInfo);
    paramSnsInfo = n.aw(paramSnsInfo.getUxinfo(), (String)localObject, paramInt2);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("is_from_ad", Boolean.TRUE);
    localArrayMap.put("key_extra_info", paramSnsInfo);
    b.b(paramString1, paramString2, paramString3, paramString4, localArrayMap, (String)localObject, new o.5());
    AppMethodBeat.o(310020);
  }
  
  private static void a(SnsInfo paramSnsInfo, int paramInt, Context paramContext, AdClickActionInfo paramAdClickActionInfo)
  {
    AppMethodBeat.i(310010);
    a(paramSnsInfo, paramInt, n.ajs(paramAdClickActionInfo.scene), paramAdClickActionInfo.finderUsername, paramAdClickActionInfo.finderLiveId, paramAdClickActionInfo.PLR, paramAdClickActionInfo.PLS);
    AppMethodBeat.o(310010);
  }
  
  public static void a(String paramString, int paramInt, aa paramaa)
  {
    AppMethodBeat.i(309991);
    if (paramaa == null)
    {
      AppMethodBeat.o(309991);
      return;
    }
    long l1;
    try
    {
      l1 = System.currentTimeMillis();
      if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.als(paramaa.type))
      {
        Object localObject = paramaa.haE();
        if (localObject == null) {
          break label131;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramString, paramInt, (aa)((Iterator)localObject).next());
        }
      }
      if (!(paramaa instanceof ae)) {
        break label194;
      }
    }
    finally
    {
      Log.e("FinderAdPreloadHelper", "preloadComponentFinderFeedsInfo exp = " + paramString.toString());
      AppMethodBeat.o(309991);
      return;
    }
    b(paramString, paramInt, ((ae)paramaa).QLh);
    for (;;)
    {
      label131:
      long l2 = System.currentTimeMillis();
      Log.d("FinderAdPreloadHelper", "preloadComponentFinderFeedsInfo, type = " + paramaa.type + ", subType = " + paramaa.subType + ", costTime = " + (l2 - l1));
      AppMethodBeat.o(309991);
      return;
      label194:
      if ((paramaa instanceof f)) {
        b(paramString, paramInt, ((f)paramaa).PRW);
      } else {
        b(paramString, paramInt, paramaa);
      }
    }
  }
  
  public static void aWo(String paramString)
  {
    AppMethodBeat.i(309961);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(309961);
      return;
    }
    if (POl.contains(paramString))
    {
      AppMethodBeat.o(309961);
      return;
    }
    Log.i("FinderAdPreloadHelper", "reqFinderFeedsObjectIds start, exportId is ".concat(String.valueOf(paramString)));
    POl.add(paramString);
    if (POn == null)
    {
      bk localbk = ((ag)com.tencent.mm.kernel.h.ax(ag.class)).ePv();
      POn = localbk;
      localbk.a(new o.a());
    }
    ((ag)com.tencent.mm.kernel.h.ax(ag.class)).f(paramString, new kotlin.g.a.m() {});
    AppMethodBeat.o(309961);
  }
  
  private static void aWp(String paramString)
  {
    AppMethodBeat.i(309978);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(309978);
      return;
    }
    if (POl.contains(paramString))
    {
      AppMethodBeat.o(309978);
      return;
    }
    Log.i("FinderAdPreloadHelper", "onAddAppear req finderFeedsObjectIds start, exportId is ".concat(String.valueOf(paramString)));
    POl.add(paramString);
    ((ag)com.tencent.mm.kernel.h.ax(ag.class)).f(paramString, new o.3());
    AppMethodBeat.o(309978);
  }
  
  public static void b(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(310004);
    if (paramSnsInfo == null)
    {
      Log.e("FinderAdPreloadHelper", "doPreloadFinderInfo, snsInfo is null");
      AppMethodBeat.o(310004);
      return;
    }
    try
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309940);
          try
          {
            Context localContext = MMApplicationContext.getContext();
            o.a(localContext, o.this.getAdXml(), o.this, paramInt);
            o.a(localContext, o.this.getAdInfo(paramInt), o.this, paramInt);
            AppMethodBeat.o(309940);
            return;
          }
          finally
          {
            Log.e("FinderAdPreloadHelper", localObject.toString());
            AppMethodBeat.o(309940);
          }
        }
      });
      return;
    }
    finally
    {
      AppMethodBeat.o(310004);
    }
  }
  
  private static void b(String paramString, int paramInt, aa paramaa)
  {
    AppMethodBeat.i(309997);
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.info.d))
    {
      paramaa = (com.tencent.mm.plugin.sns.ad.landingpage.component.info.d)paramaa;
      if (!Util.isNullOrNil(paramaa.PMe)) {
        AdLandingPagesProxy.getInstance().preloadFinderFeeds(paramString, paramInt, paramaa.PMe);
      }
    }
    AppMethodBeat.o(309997);
  }
  
  public static bk gZS()
  {
    return POn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.o
 * JD-Core Version:    0.7.0.1
 */