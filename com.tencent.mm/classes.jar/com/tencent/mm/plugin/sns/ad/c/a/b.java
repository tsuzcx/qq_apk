package com.tencent.mm.plugin.sns.ad.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.ad.adxml.k;
import com.tencent.mm.plugin.sns.ad.adxml.l;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.n;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements Runnable
{
  private final c Jze;
  private final String Jzg;
  
  b(c paramc, String paramString)
  {
    this.Jze = paramc;
    this.Jzg = paramString;
  }
  
  private static String a(int paramInt, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(268791);
    if (paramAdClickActionInfo == null)
    {
      AppMethodBeat.o(268791);
      return "";
    }
    if (paramAdClickActionInfo.Jxx != 0)
    {
      AppMethodBeat.o(268791);
      return "";
    }
    String str = paramAdClickActionInfo.Jxy;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(268791);
      return "";
    }
    paramSnsInfo = paramSnsInfo.getAdInfo(paramInt);
    paramAdClickActionInfo = str;
    if (paramSnsInfo != null) {
      paramAdClickActionInfo = t.kw(str, paramSnsInfo.uxInfo);
    }
    paramAdClickActionInfo = a.aYn(paramAdClickActionInfo);
    Log.d("SnsAd.H5PrefetchTask", "doClickBtnUrl: the url is ".concat(String.valueOf(paramAdClickActionInfo)));
    AppMethodBeat.o(268791);
    return paramAdClickActionInfo;
  }
  
  private static void a(String paramString, List<String> paramList, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(268793);
    if ((!TextUtils.isEmpty(paramString)) && (!paramList.contains(paramString)))
    {
      ADInfo localADInfo = paramSnsInfo.getAdInfo();
      paramSnsInfo = paramString;
      if (localADInfo != null) {
        paramSnsInfo = t.kw(paramString, localADInfo.uxInfo);
      }
      paramString = a.aYn(paramSnsInfo);
      if (!TextUtils.isEmpty(paramString))
      {
        Log.d("SnsAd.H5PrefetchTask", "doSlideFullCardUrl: the url is ".concat(String.valueOf(paramString)));
        paramList.add(paramString);
      }
    }
    AppMethodBeat.o(268793);
  }
  
  private static List<String> f(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(268792);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramSnsInfo.getAdXml();
    if ((localObject != null) && (((ADXml)localObject).adSliderFullCardInfo != null) && (((ADXml)localObject).adSliderFullCardInfo.Jym != null))
    {
      localObject = ((ADXml)localObject).adSliderFullCardInfo.Jym;
      if (d.isEmpty((Collection)localObject))
      {
        AppMethodBeat.o(268792);
        return localLinkedList;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        if (locali != null)
        {
          if (locali.clickActionInfo != null) {
            a(locali.clickActionInfo.Jxy, localLinkedList, paramSnsInfo);
          }
          if ((locali.JyD != null) && (locali.JyD.JyK != null)) {
            a(locali.JyD.JyK.Jxy, localLinkedList, paramSnsInfo);
          }
        }
      }
    }
    AppMethodBeat.o(268792);
    return localLinkedList;
  }
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(268789);
    Log.d("SnsAd.H5PrefetchTask", "AdH5PrefetchTask is running, the task key is " + this.Jzg);
    if (TextUtils.isEmpty(this.Jzg))
    {
      Log.w("SnsAd.H5PrefetchTask", "AdH5PrefetchTask: the task key is empty");
      AppMethodBeat.o(268789);
      return;
    }
    Object localObject1 = this.Jze;
    Object localObject2 = this.Jzg;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (c.b)((c)localObject1).Jzh.remove(localObject2);
    }
    int i;
    SnsInfo localSnsInfo;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.Jze;
        Object localObject4;
        if ((localObject1 != null) && (!TextUtils.isEmpty(((c.b)localObject1).jHH)))
        {
          localObject4 = new c.a();
          ((c.a)localObject4).jHH = ((c.b)localObject1).jHH;
          ((c.a)localObject4).Jzj = System.currentTimeMillis();
          ((c)localObject2).Jzi.put(((c.a)localObject4).jHH, localObject4);
          Log.i("SnsAd.H5Prefetch", "the prefetch info is recorded");
        }
        if (localObject1 != null)
        {
          i = ((c.b)localObject1).type;
          if (i == 0)
          {
            i = ((c.b)localObject1).source;
            localSnsInfo = ((c.b)localObject1).Jzk;
            if (localSnsInfo == null)
            {
              Log.w("SnsAd.H5PrefetchTask", "doPrefetch: the snsInfo is null");
              AppMethodBeat.o(268789);
              return;
              localObject1 = null;
              continue;
            }
            localObject4 = new LinkedList();
            localObject2 = localSnsInfo.getAdInfoLink();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localSnsInfo.getAdLink();
            }
            ADInfo localADInfo = localSnsInfo.getAdInfo(i);
            localObject2 = localObject1;
            if (localADInfo != null) {
              localObject2 = t.kw((String)localObject1, localADInfo.uxInfo);
            }
            localObject1 = a.aYn((String)localObject2);
            Log.d("SnsAd.H5PrefetchTask", "doTextAdLink: the url is ".concat(String.valueOf(localObject1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((List)localObject4).add(localObject1);
            }
            localObject1 = localSnsInfo.getAdXml();
            if (localObject1 == null)
            {
              localObject1 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((List)localObject4).add(localObject1);
              }
              localObject2 = localSnsInfo.getAdXml();
              if (localObject2 == null)
              {
                localObject1 = "";
                label338:
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((List)localObject4).add(localObject1);
                }
                localObject3 = localSnsInfo.getAdXml();
                localObject2 = "";
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject1 = localObject2;
                  if (((ADXml)localObject3).adFloatWebViewInfo != null)
                  {
                    localObject2 = ((ADXml)localObject3).adFloatWebViewInfo.ozt;
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label504;
                    }
                    localObject1 = "";
                  }
                }
                label400:
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((List)localObject4).add(localObject1);
                }
                localObject1 = f(localSnsInfo);
                if (!d.isEmpty((Collection)localObject1)) {
                  ((List)localObject4).addAll((Collection)localObject1);
                }
                a.hr((List)localObject4);
                AppMethodBeat.o(268789);
              }
            }
            else
            {
              if (((ADXml)localObject1).adCardActionBtnInfo == null) {
                break label600;
              }
            }
          }
        }
      }
    }
    label600:
    for (localObject1 = ((ADXml)localObject1).adCardActionBtnInfo.clickActionInfo;; localObject1 = null)
    {
      localObject1 = a(i, (AdClickActionInfo)localObject1, localSnsInfo);
      break;
      localObject1 = localObject3;
      if (((ADXml)localObject2).adTagBtnInfo != null) {
        localObject1 = ((ADXml)localObject2).adTagBtnInfo.clickActionInfo;
      }
      localObject1 = a(i, (AdClickActionInfo)localObject1, localSnsInfo);
      break label338;
      label504:
      localObject3 = localSnsInfo.getAdInfo();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = t.kw((String)localObject2, ((ADInfo)localObject3).uxInfo);
      }
      localObject1 = a.aYn((String)localObject1);
      Log.d("SnsAd.H5PrefetchTask", "doWebViewOnePlusOne: the url is ".concat(String.valueOf(localObject1)));
      break label400;
      if (i == 1)
      {
        if ((localObject1 == null) || (d.w(((c.b)localObject1).cxM)))
        {
          Log.w("SnsAd.H5PrefetchTask", "doPrefetchNativeLanding: the task is null or urls is empty");
          AppMethodBeat.o(268789);
          return;
        }
        a.hr(Arrays.asList(((c.b)localObject1).cxM));
      }
      AppMethodBeat.o(268789);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.b
 * JD-Core Version:    0.7.0.1
 */