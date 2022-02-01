package com.tencent.mm.plugin.sns.ad.timeline.c.c;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.e;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

public final class b
  implements com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a
{
  TextView JKR;
  com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a JKS;
  SnsInfo Jws;
  WeakReference<Activity> mActivityRef;
  RecyclerView mRecyclerView;
  
  public b(Activity paramActivity, TextView paramTextView, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(264330);
    if (paramActivity != null)
    {
      this.mActivityRef = new WeakReference(paramActivity);
      this.JKS = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a(paramActivity);
    }
    this.JKR = paramTextView;
    this.mRecyclerView = paramRecyclerView;
    AppMethodBeat.o(264330);
  }
  
  private void d(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(264332);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? The input sns info or listener is null!!");
      AppMethodBeat.o(264332);
      return;
    }
    if (this.JKS == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? I think the activity is null, which is input in constructor!!!!");
      AppMethodBeat.o(264332);
      return;
    }
    Object localObject1 = t.w(paramSnsInfo);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("0".equals(localObject1)))
    {
      Log.w("SnsAd.TopicCardDynamic", "the sns id is empty!! Are you sure?");
      AppMethodBeat.o(264332);
      return;
    }
    Object localObject2 = getActivity();
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "the context is null! Is activity destroyed?");
      AppMethodBeat.o(264332);
      return;
    }
    localObject2 = RequestListenerManager.aL((Activity)localObject2);
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fu le you!!! the activity is not life cycle owner!");
      AppMethodBeat.o(264332);
      return;
    }
    ((RequestListenerManager)localObject2).a((String)localObject1, this);
    localObject1 = com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk();
    if (localObject1 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fule you!!! the request manager is null. Isn't the RequestManager singleton?");
      AppMethodBeat.o(264332);
      return;
    }
    this.Jws = paramSnsInfo;
    ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.a)localObject1).a(paramSnsInfo, paramBoolean, this.JKS);
    AppMethodBeat.o(264332);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(264334);
    if (this.mActivityRef == null)
    {
      AppMethodBeat.o(264334);
      return null;
    }
    Activity localActivity = (Activity)this.mActivityRef.get();
    AppMethodBeat.o(264334);
    return localActivity;
  }
  
  public final void c(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(264331);
    try
    {
      d(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(264331);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      Log.e("SnsAd.TopicCardDynamic", "doDynamicRequest failed!!!");
      AppMethodBeat.o(264331);
    }
  }
  
  public final void z(String paramString, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(264333);
    Object localObject1;
    try
    {
      localObject1 = t.w(this.Jws);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramString)))
      {
        Log.w("SnsAd.TopicCardDynamic", "en ?? the sns is not same as the one when request used!");
        AppMethodBeat.o(264333);
        return;
      }
      if (!(paramObject instanceof com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a))
      {
        Log.w("SnsAd.TopicCardDynamic", "Crazy!!! the result data is not TopicCardResponseModel!");
        AppMethodBeat.o(264333);
        return;
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAd.TopicCardDynamic", "the on result failed!");
      AppMethodBeat.o(264333);
      return;
    }
    paramString = this.Jws;
    if ((paramString == null) || (paramString.getAdXml() == null))
    {
      AppMethodBeat.o(264333);
      return;
    }
    paramString = paramString.getAdXml().adFinderTopicInfo;
    if (paramString == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Yep !!! topicInfo is null, please check!!!");
      AppMethodBeat.o(264333);
      return;
    }
    paramObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a)paramObject;
    if (paramString == null) {}
    for (;;)
    {
      if (paramString == null)
      {
        Log.w("SnsAd.TopicCardDynamic", "Yep !!! after converting, the topic info is null!!! Don't update!");
        AppMethodBeat.o(264333);
        return;
        localObject1 = paramString.Jym;
        if ((!com.tencent.mm.plugin.sns.ad.i.d.isEmpty((Collection)localObject1)) && (!com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramObject.JHO)) && (((List)localObject1).size() == paramObject.JHO.size())) {
          break label552;
        }
        Log.w("SnsAd.TopicCardResponseModel", "the targetResInfoList size is not same as res infos size");
      }
      for (;;)
      {
        if (i == 0) {
          break label569;
        }
        if (!TextUtils.isEmpty(paramObject.Jyk)) {
          paramString.Jyk = paramObject.Jyk;
        }
        for (;;)
        {
          if ((i >= paramObject.JHO.size()) || (i >= ((List)localObject1).size())) {
            break label564;
          }
          Object localObject2 = (e)((List)localObject1).get(i);
          Object localObject3 = (a.b)paramObject.JHO.get(i);
          if ((localObject2 != null) && (localObject3 != null))
          {
            if (((a.b)localObject3).avatar != null) {
              ((e)localObject2).avatar = ((a.b)localObject3).avatar;
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
            if (((a.b)localObject3).Jyn != null) {
              ((e)localObject2).Jyn = ((a.b)localObject3).Jyn;
            }
            if (((a.b)localObject3).Jyp != null) {
              ((e)localObject2).Jyp = ((a.b)localObject3).Jyp;
            }
            if (((a.b)localObject3).JHQ != null)
            {
              localObject3 = ((a.b)localObject3).JHQ;
              localObject2 = ((e)localObject2).fVT;
              if ((localObject3 != null) && (localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).JHP)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).fQv)))
              {
                ((cvt)localObject2).Id = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).JHP;
                ((cvt)localObject2).Url = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url;
                ((cvt)localObject2).TDF = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).fQv;
                break label557;
                if (paramString.Jyk != null) {
                  l.f(this.JKR, paramString.Jyk);
                }
                if (this.mRecyclerView != null)
                {
                  paramString = this.mRecyclerView.getAdapter();
                  if (paramString != null) {
                    paramString.alc.notifyChanged();
                  }
                }
                AppMethodBeat.o(264333);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.b
 * JD-Core Version:    0.7.0.1
 */