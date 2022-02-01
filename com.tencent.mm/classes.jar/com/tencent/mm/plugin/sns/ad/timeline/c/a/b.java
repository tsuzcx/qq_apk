package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

public final class b
  implements com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a
{
  SnsInfo DqO;
  TextView Dzu;
  com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a Dzv;
  WeakReference<Activity> mActivityRef;
  RecyclerView mRecyclerView;
  
  public b(Activity paramActivity, TextView paramTextView, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202269);
    if (paramActivity != null)
    {
      this.mActivityRef = new WeakReference(paramActivity);
      this.Dzv = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a(paramActivity);
    }
    this.Dzu = paramTextView;
    this.mRecyclerView = paramRecyclerView;
    AppMethodBeat.o(202269);
  }
  
  private void d(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202271);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? The input sns info or listener is null!!");
      AppMethodBeat.o(202271);
      return;
    }
    if (this.Dzv == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? I think the activity is null, which is input in constructor!!!!");
      AppMethodBeat.o(202271);
      return;
    }
    Object localObject1 = r.v(paramSnsInfo);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("0".equals(localObject1)))
    {
      Log.w("SnsAd.TopicCardDynamic", "the sns id is empty!! Are you sure?");
      AppMethodBeat.o(202271);
      return;
    }
    Object localObject2 = getActivity();
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "the context is null! Is activity destroyed?");
      AppMethodBeat.o(202271);
      return;
    }
    localObject2 = RequestListenerManager.aF((Activity)localObject2);
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fu le you!!! the activity is not life cycle owner!");
      AppMethodBeat.o(202271);
      return;
    }
    ((RequestListenerManager)localObject2).a((String)localObject1, this);
    localObject1 = com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI();
    if (localObject1 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fule you!!! the request manager is null. Isn't the RequestManager singleton?");
      AppMethodBeat.o(202271);
      return;
    }
    this.DqO = paramSnsInfo;
    ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.a)localObject1).a(paramSnsInfo, paramBoolean, this.Dzv);
    AppMethodBeat.o(202271);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(202273);
    if (this.mActivityRef == null)
    {
      AppMethodBeat.o(202273);
      return null;
    }
    Activity localActivity = (Activity)this.mActivityRef.get();
    AppMethodBeat.o(202273);
    return localActivity;
  }
  
  public final void A(String paramString, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(202272);
    Object localObject1;
    try
    {
      localObject1 = r.v(this.DqO);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramString)))
      {
        Log.w("SnsAd.TopicCardDynamic", "en ?? the sns is not same as the one when request used!");
        AppMethodBeat.o(202272);
        return;
      }
      if (!(paramObject instanceof com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a))
      {
        Log.w("SnsAd.TopicCardDynamic", "Crazy!!! the result data is not TopicCardResponseModel!");
        AppMethodBeat.o(202272);
        return;
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAd.TopicCardDynamic", "the on result failed!");
      AppMethodBeat.o(202272);
      return;
    }
    paramString = this.DqO;
    if ((paramString == null) || (paramString.getAdXml() == null))
    {
      AppMethodBeat.o(202272);
      return;
    }
    paramString = paramString.getAdXml().adFinderTopicInfo;
    if (paramString == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Yep !!! topicInfo is null, please check!!!");
      AppMethodBeat.o(202272);
      return;
    }
    paramObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a)paramObject;
    if (paramString == null) {}
    for (;;)
    {
      if (paramString == null)
      {
        Log.w("SnsAd.TopicCardDynamic", "Yep !!! after converting, the topic info is null!!! Don't update!");
        AppMethodBeat.o(202272);
        return;
        localObject1 = paramString.DrS;
        if ((!c.isEmpty((Collection)localObject1)) && (!c.isEmpty(paramObject.DxV)) && (((List)localObject1).size() == paramObject.DxV.size())) {
          break label552;
        }
        Log.w("SnsAd.TopicCardResponseModel", "the targetResInfoList size is not same as res infos size");
      }
      for (;;)
      {
        if (i == 0) {
          break label569;
        }
        if (!TextUtils.isEmpty(paramObject.DrQ)) {
          paramString.DrQ = paramObject.DrQ;
        }
        for (;;)
        {
          if ((i >= paramObject.DxV.size()) || (i >= ((List)localObject1).size())) {
            break label564;
          }
          Object localObject2 = (e)((List)localObject1).get(i);
          Object localObject3 = (a.b)paramObject.DxV.get(i);
          if ((localObject2 != null) && (localObject3 != null))
          {
            if (((a.b)localObject3).uNR != null) {
              ((e)localObject2).uNR = ((a.b)localObject3).uNR;
            }
            if (((a.b)localObject3).nickname != null) {
              ((e)localObject2).nickname = ((a.b)localObject3).nickname;
            }
            if (((a.b)localObject3).tag != null) {
              ((e)localObject2).tag = ((a.b)localObject3).tag;
            }
            if (((a.b)localObject3).desc != null) {
              ((e)localObject2).desc = ((a.b)localObject3).desc;
            }
            if (((a.b)localObject3).DrT != null) {
              ((e)localObject2).DrT = ((a.b)localObject3).DrT;
            }
            if (((a.b)localObject3).DrV != null) {
              ((e)localObject2).DrV = ((a.b)localObject3).DrV;
            }
            if (((a.b)localObject3).DxW != null)
            {
              localObject3 = ((a.b)localObject3).DxW;
              localObject2 = ((e)localObject2).ebR;
              if ((localObject3 != null) && (localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).wQO)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).dWJ)))
              {
                ((cnb)localObject2).Id = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).wQO;
                ((cnb)localObject2).Url = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url;
                ((cnb)localObject2).Msz = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).dWJ;
                break label557;
                if (paramString.DrQ != null) {
                  m.f(this.Dzu, paramString.DrQ);
                }
                if (this.mRecyclerView != null)
                {
                  paramString = this.mRecyclerView.getAdapter();
                  if (paramString != null) {
                    paramString.atj.notifyChanged();
                  }
                }
                AppMethodBeat.o(202272);
                return;
                break;
                label552:
                i = 0;
                continue;
              }
            }
          }
          label557:
          i += 1;
        }
        label564:
        i = 1;
      }
      label569:
      paramString = null;
    }
  }
  
  public final void c(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202270);
    try
    {
      d(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(202270);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      Log.e("SnsAd.TopicCardDynamic", "doDynamicRequest failed!!!");
      AppMethodBeat.o(202270);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.b
 * JD-Core Version:    0.7.0.1
 */