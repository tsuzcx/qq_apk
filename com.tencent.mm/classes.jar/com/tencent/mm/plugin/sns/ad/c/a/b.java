package com.tencent.mm.plugin.sns.ad.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.l;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.adxml.n;
import com.tencent.mm.plugin.sns.ad.adxml.o;
import com.tencent.mm.plugin.sns.ad.j.d;
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
  private final c PNC;
  private final String PNE;
  
  b(c paramc, String paramString)
  {
    this.PNC = paramc;
    this.PNE = paramString;
  }
  
  private static String a(int paramInt, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309921);
    if (paramAdClickActionInfo == null)
    {
      AppMethodBeat.o(309921);
      return "";
    }
    if (paramAdClickActionInfo.PLm != 0)
    {
      AppMethodBeat.o(309921);
      return "";
    }
    String str = paramAdClickActionInfo.PLn;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(309921);
      return "";
    }
    paramSnsInfo = paramSnsInfo.getAdInfo(paramInt);
    paramAdClickActionInfo = str;
    if (paramSnsInfo != null) {
      paramAdClickActionInfo = t.lY(str, paramSnsInfo.uxInfo);
    }
    paramAdClickActionInfo = a.aWi(paramAdClickActionInfo);
    Log.d("SnsAd.H5PrefetchTask", "doClickBtnUrl: the url is ".concat(String.valueOf(paramAdClickActionInfo)));
    AppMethodBeat.o(309921);
    return paramAdClickActionInfo;
  }
  
  private static List<String> a(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309931);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramSnsInfo.getAdXml();
    if ((localObject1 != null) && (((ADXml)localObject1).adSliderFullCardInfo != null) && (((ADXml)localObject1).adSliderFullCardInfo.PMG != null))
    {
      localObject1 = ((ADXml)localObject1).adSliderFullCardInfo.PMG;
      if (d.isEmpty((Collection)localObject1))
      {
        AppMethodBeat.o(309931);
        return localLinkedList;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (l)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (((l)localObject2).clickActionInfo != null)
          {
            String str = a(paramInt, ((l)localObject2).clickActionInfo, paramSnsInfo);
            if ((!TextUtils.isEmpty(str)) && (!localLinkedList.contains(str))) {
              localLinkedList.add(str);
            }
          }
          if ((((l)localObject2).PMY != null) && (((l)localObject2).PMY.PNj != null))
          {
            localObject2 = a(paramInt, ((l)localObject2).PMY.PNj, paramSnsInfo);
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!localLinkedList.contains(localObject2))) {
              localLinkedList.add(localObject2);
            }
          }
        }
      }
    }
    AppMethodBeat.o(309931);
    return localLinkedList;
  }
  
  private static List<String> b(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309936);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramSnsInfo.getAdInfo(paramInt);
    if ((localObject1 != null) && (!d.isEmpty(((ADInfo)localObject1).adClickActionInfoList)))
    {
      localObject1 = ((ADInfo)localObject1).adClickActionInfoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AdClickActionInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = a(paramInt, (AdClickActionInfo)localObject2, paramSnsInfo);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!localLinkedList.contains(localObject2))) {
            localLinkedList.add(localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(309936);
    return localLinkedList;
  }
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(309945);
    Log.d("SnsAd.H5PrefetchTask", "AdH5PrefetchTask is running, the task key is " + this.PNE);
    if (TextUtils.isEmpty(this.PNE))
    {
      Log.w("SnsAd.H5PrefetchTask", "AdH5PrefetchTask: the task key is empty");
      AppMethodBeat.o(309945);
      return;
    }
    Object localObject1 = this.PNC;
    Object localObject2 = this.PNE;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (c.b)((c)localObject1).PNF.remove(localObject2);
    }
    int i;
    SnsInfo localSnsInfo;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.PNC;
        Object localObject4;
        if ((localObject1 != null) && (!TextUtils.isEmpty(((c.b)localObject1).mhl)))
        {
          localObject4 = new c.a();
          ((c.a)localObject4).mhl = ((c.b)localObject1).mhl;
          ((c.a)localObject4).PNH = System.currentTimeMillis();
          ((c)localObject2).PNG.put(((c.a)localObject4).mhl, localObject4);
          Log.i("SnsAd.H5Prefetch", "the prefetch info is recorded");
        }
        if (localObject1 != null)
        {
          i = ((c.b)localObject1).type;
          if (i == 0)
          {
            i = ((c.b)localObject1).source;
            localSnsInfo = ((c.b)localObject1).PNI;
            if (localSnsInfo == null)
            {
              Log.w("SnsAd.H5PrefetchTask", "doPrefetch: the snsInfo is null");
              AppMethodBeat.o(309945);
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
              localObject2 = t.lY((String)localObject1, localADInfo.uxInfo);
            }
            localObject1 = a.aWi((String)localObject2);
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
                    localObject2 = ((ADXml)localObject3).adFloatWebViewInfo.rDm;
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label528;
                    }
                    localObject1 = "";
                  }
                }
                label400:
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((List)localObject4).add(localObject1);
                }
                localObject1 = a(i, localSnsInfo);
                if (!d.isEmpty((Collection)localObject1)) {
                  ((List)localObject4).addAll((Collection)localObject1);
                }
                localObject1 = b(i, localSnsInfo);
                if (!d.isEmpty((Collection)localObject1)) {
                  ((List)localObject4).addAll((Collection)localObject1);
                }
                a.kt((List)localObject4);
                AppMethodBeat.o(309945);
              }
            }
            else
            {
              if (((ADXml)localObject1).adCardActionBtnInfo == null) {
                break label624;
              }
            }
          }
        }
      }
    }
    label528:
    label624:
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
      localObject3 = localSnsInfo.getAdInfo();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = t.lY((String)localObject2, ((ADInfo)localObject3).uxInfo);
      }
      localObject1 = a.aWi((String)localObject1);
      Log.d("SnsAd.H5PrefetchTask", "doWebViewOnePlusOne: the url is ".concat(String.valueOf(localObject1)));
      break label400;
      if (i == 1)
      {
        if ((localObject1 == null) || (d.y(((c.b)localObject1).eqg)))
        {
          Log.w("SnsAd.H5PrefetchTask", "doPrefetchNativeLanding: the task is null or urls is empty");
          AppMethodBeat.o(309945);
          return;
        }
        a.kt(Arrays.asList(((c.b)localObject1).eqg));
      }
      AppMethodBeat.o(309945);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.b
 * JD-Core Version:    0.7.0.1
 */