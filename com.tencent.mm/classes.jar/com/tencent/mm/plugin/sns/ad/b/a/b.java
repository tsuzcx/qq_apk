package com.tencent.mm.plugin.sns.ad.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements Runnable
{
  private final c zng;
  private final String zni;
  
  b(c paramc, String paramString)
  {
    this.zng = paramc;
    this.zni = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(218989);
    ae.d("SnsAd.H5PrefetchTask", "AdH5PrefetchTask is running, the task key is " + this.zni);
    if (TextUtils.isEmpty(this.zni))
    {
      ae.w("SnsAd.H5PrefetchTask", "AdH5PrefetchTask: the task key is empty");
      AppMethodBeat.o(218989);
      return;
    }
    Object localObject1 = this.zng;
    Object localObject2 = this.zni;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (c.b)((c)localObject1).znj.remove(localObject2);
    }
    while (localObject1 != null)
    {
      localObject2 = this.zng;
      Object localObject3;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((c.b)localObject1).glT)))
      {
        localObject3 = new c.a();
        ((c.a)localObject3).glT = ((c.b)localObject1).glT;
        ((c.a)localObject3).znl = System.currentTimeMillis();
        ((c)localObject2).znk.put(((c.a)localObject3).glT, localObject3);
        ae.i("SnsAd.H5Prefetch", "the prefetch info is recorded");
      }
      if (localObject1 != null)
      {
        int i = ((c.b)localObject1).type;
        if (i == 0)
        {
          i = ((c.b)localObject1).doj;
          Object localObject4 = ((c.b)localObject1).znm;
          if (localObject4 == null)
          {
            ae.w("SnsAd.H5PrefetchTask", "doPrefetch: the snsInfo is null");
            AppMethodBeat.o(218989);
            return;
            localObject1 = null;
          }
          else
          {
            localObject3 = new LinkedList();
            localObject2 = ((p)localObject4).ecw();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = ((p)localObject4).ecv();
            }
            Object localObject5 = ((p)localObject4).Rv(i);
            localObject2 = localObject1;
            if (localObject5 != null) {
              localObject2 = r.jo((String)localObject1, ((com.tencent.mm.plugin.sns.storage.a)localObject5).dGD);
            }
            localObject1 = a.ayS((String)localObject2);
            ae.d("SnsAd.H5PrefetchTask", "doTextAdLink: the url is ".concat(String.valueOf(localObject1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((List)localObject3).add(localObject1);
            }
            localObject1 = ((p)localObject4).dVj();
            if (localObject1 == null)
            {
              localObject1 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((List)localObject3).add(localObject1);
              }
              localObject5 = ((p)localObject4).dVj();
              localObject2 = "";
              localObject1 = localObject2;
              if (localObject5 != null)
              {
                localObject1 = localObject2;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject5).zNT != null)
                {
                  localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject5).zNT.kzz;
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
              a.fN((List)localObject3);
              AppMethodBeat.o(218989);
              return;
              localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).zsZ;
              if (localObject1 == null)
              {
                localObject1 = "";
                break;
              }
              if (((b.c)localObject1).zOk != 0)
              {
                localObject1 = "";
                break;
              }
              localObject2 = ((b.c)localObject1).zOl;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = "";
                break;
              }
              localObject5 = ((p)localObject4).Rv(i);
              localObject1 = localObject2;
              if (localObject5 != null) {
                localObject1 = r.jo((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject5).dGD);
              }
              localObject1 = a.ayS((String)localObject1);
              ae.d("SnsAd.H5PrefetchTask", "doActionBtnUrl: the url is ".concat(String.valueOf(localObject1)));
              break;
              label488:
              localObject4 = ((p)localObject4).dVi();
              localObject1 = localObject2;
              if (localObject4 != null) {
                localObject1 = r.jo((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject4).dGD);
              }
              localObject1 = a.ayS((String)localObject1);
              ae.d("SnsAd.H5PrefetchTask", "doWebViewOnePlusOne: the url is ".concat(String.valueOf(localObject1)));
            }
          }
        }
        else if (i == 1)
        {
          if ((localObject1 == null) || (com.tencent.mm.plugin.sns.ad.f.c.w(((c.b)localObject1).cni)))
          {
            ae.w("SnsAd.H5PrefetchTask", "doPrefetchNativeLanding: the task is null or urls is empty");
            AppMethodBeat.o(218989);
            return;
          }
          a.fN(Arrays.asList(((c.b)localObject1).cni));
        }
      }
    }
    AppMethodBeat.o(218989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a.b
 * JD-Core Version:    0.7.0.1
 */