package com.tencent.mm.plugin.sns.ad.d.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.n;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements Runnable
{
  private final c Dsw;
  private final String Dsy;
  
  b(c paramc, String paramString)
  {
    this.Dsw = paramc;
    this.Dsy = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(201879);
    Log.d("SnsAd.H5PrefetchTask", "AdH5PrefetchTask is running, the task key is " + this.Dsy);
    if (TextUtils.isEmpty(this.Dsy))
    {
      Log.w("SnsAd.H5PrefetchTask", "AdH5PrefetchTask: the task key is empty");
      AppMethodBeat.o(201879);
      return;
    }
    Object localObject1 = this.Dsw;
    Object localObject2 = this.Dsy;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (c.b)((c)localObject1).Dsz.remove(localObject2);
    }
    while (localObject1 != null)
    {
      localObject2 = this.Dsw;
      Object localObject3;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((c.b)localObject1).gWK)))
      {
        localObject3 = new c.a();
        ((c.a)localObject3).gWK = ((c.b)localObject1).gWK;
        ((c.a)localObject3).DsB = System.currentTimeMillis();
        ((c)localObject2).DsA.put(((c.a)localObject3).gWK, localObject3);
        Log.i("SnsAd.H5Prefetch", "the prefetch info is recorded");
      }
      if (localObject1 != null)
      {
        int i = ((c.b)localObject1).type;
        if (i == 0)
        {
          i = ((c.b)localObject1).source;
          Object localObject4 = ((c.b)localObject1).DsC;
          if (localObject4 == null)
          {
            Log.w("SnsAd.H5PrefetchTask", "doPrefetch: the snsInfo is null");
            AppMethodBeat.o(201879);
            return;
            localObject1 = null;
          }
          else
          {
            localObject3 = new LinkedList();
            localObject2 = ((SnsInfo)localObject4).getAdInfoLink();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = ((SnsInfo)localObject4).getAdLink();
            }
            Object localObject5 = ((SnsInfo)localObject4).getAdInfo(i);
            localObject2 = localObject1;
            if (localObject5 != null) {
              localObject2 = r.kb((String)localObject1, ((ADInfo)localObject5).uxInfo);
            }
            localObject1 = a.aNC((String)localObject2);
            Log.d("SnsAd.H5PrefetchTask", "doTextAdLink: the url is ".concat(String.valueOf(localObject1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((List)localObject3).add(localObject1);
            }
            localObject1 = ((SnsInfo)localObject4).getAdXml();
            if (localObject1 == null)
            {
              localObject1 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((List)localObject3).add(localObject1);
              }
              localObject5 = ((SnsInfo)localObject4).getAdXml();
              localObject2 = "";
              localObject1 = localObject2;
              if (localObject5 != null)
              {
                localObject1 = localObject2;
                if (((ADXml)localObject5).adFloatWebViewInfo != null)
                {
                  localObject2 = ((ADXml)localObject5).adFloatWebViewInfo.lDS;
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label488;
                  }
                  localObject1 = "";
                }
              }
            }
            for (;;)
            {
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((List)localObject3).add(localObject1);
              }
              a.gL((List)localObject3);
              AppMethodBeat.o(201879);
              return;
              localObject1 = ((ADXml)localObject1).adCardActionBtnInfo;
              if (localObject1 == null)
              {
                localObject1 = "";
                break;
              }
              if (((ADXml.AdCardActionBtnInfo)localObject1).clickActionType != 0)
              {
                localObject1 = "";
                break;
              }
              localObject2 = ((ADXml.AdCardActionBtnInfo)localObject1).clickActionLink;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = "";
                break;
              }
              localObject5 = ((SnsInfo)localObject4).getAdInfo(i);
              localObject1 = localObject2;
              if (localObject5 != null) {
                localObject1 = r.kb((String)localObject2, ((ADInfo)localObject5).uxInfo);
              }
              localObject1 = a.aNC((String)localObject1);
              Log.d("SnsAd.H5PrefetchTask", "doActionBtnUrl: the url is ".concat(String.valueOf(localObject1)));
              break;
              label488:
              localObject4 = ((SnsInfo)localObject4).getAdInfo();
              localObject1 = localObject2;
              if (localObject4 != null) {
                localObject1 = r.kb((String)localObject2, ((ADInfo)localObject4).uxInfo);
              }
              localObject1 = a.aNC((String)localObject1);
              Log.d("SnsAd.H5PrefetchTask", "doWebViewOnePlusOne: the url is ".concat(String.valueOf(localObject1)));
            }
          }
        }
        else if (i == 1)
        {
          if ((localObject1 == null) || (com.tencent.mm.plugin.sns.ad.i.c.w(((c.b)localObject1).cze)))
          {
            Log.w("SnsAd.H5PrefetchTask", "doPrefetchNativeLanding: the task is null or urls is empty");
            AppMethodBeat.o(201879);
            return;
          }
          a.gL(Arrays.asList(((c.b)localObject1).cze));
        }
      }
    }
    AppMethodBeat.o(201879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.b
 * JD-Core Version:    0.7.0.1
 */