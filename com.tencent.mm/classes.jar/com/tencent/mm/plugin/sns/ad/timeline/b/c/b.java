package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

public final class b
  implements com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a
{
  SnsInfo PJQ;
  TextView QcA;
  com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a QcB;
  WeakReference<Activity> mActivityRef;
  RecyclerView mRecyclerView;
  
  public b(Activity paramActivity, TextView paramTextView, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(311214);
    if (paramActivity != null)
    {
      this.mActivityRef = new WeakReference(paramActivity);
      this.QcB = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a(paramActivity);
    }
    this.QcA = paramTextView;
    this.mRecyclerView = paramRecyclerView;
    AppMethodBeat.o(311214);
  }
  
  private void d(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311231);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? The input sns info or listener is null!!");
      AppMethodBeat.o(311231);
      return;
    }
    if (this.QcB == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Are you OK??? I think the activity is null, which is input in constructor!!!!");
      AppMethodBeat.o(311231);
      return;
    }
    Object localObject1 = t.x(paramSnsInfo);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("0".equals(localObject1)))
    {
      Log.w("SnsAd.TopicCardDynamic", "the sns id is empty!! Are you sure?");
      AppMethodBeat.o(311231);
      return;
    }
    Object localObject2 = getActivity();
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "the context is null! Is activity destroyed?");
      AppMethodBeat.o(311231);
      return;
    }
    localObject2 = RequestListenerManager.bn((Activity)localObject2);
    if (localObject2 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fu le you!!! the activity is not life cycle owner!");
      AppMethodBeat.o(311231);
      return;
    }
    ((RequestListenerManager)localObject2).a((String)localObject1, this);
    localObject1 = com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.hbB();
    if (localObject1 == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "OK, i fule you!!! the request manager is null. Isn't the RequestManager singleton?");
      AppMethodBeat.o(311231);
      return;
    }
    this.PJQ = paramSnsInfo;
    ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.a)localObject1).a(paramSnsInfo, paramBoolean, this.QcB);
    AppMethodBeat.o(311231);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(311248);
    if (this.mActivityRef == null)
    {
      AppMethodBeat.o(311248);
      return null;
    }
    Activity localActivity = (Activity)this.mActivityRef.get();
    AppMethodBeat.o(311248);
    return localActivity;
  }
  
  public final void L(String paramString, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(311291);
    Object localObject1;
    try
    {
      localObject1 = t.x(this.PJQ);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramString)))
      {
        Log.w("SnsAd.TopicCardDynamic", "en ?? the sns is not same as the one when request used!");
        AppMethodBeat.o(311291);
        return;
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a)) {}
    }
    finally
    {
      Log.e("SnsAd.TopicCardDynamic", "the on result failed!");
      AppMethodBeat.o(311291);
      return;
    }
    paramString = this.PJQ;
    if ((paramString == null) || (paramString.getAdXml() == null))
    {
      AppMethodBeat.o(311291);
      return;
    }
    paramString = paramString.getAdXml().adFinderTopicInfo;
    if (paramString == null)
    {
      Log.w("SnsAd.TopicCardDynamic", "Yep !!! topicInfo is null, please check!!!");
      AppMethodBeat.o(311291);
      return;
    }
    paramObject = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a)paramObject;
    if (paramString == null) {}
    for (;;)
    {
      if (paramString == null)
      {
        Log.w("SnsAd.TopicCardDynamic", "Yep !!! after converting, the topic info is null!!! Don't update!");
        AppMethodBeat.o(311291);
        return;
        localObject1 = paramString.PMG;
        if ((!d.isEmpty((Collection)localObject1)) && (!d.isEmpty(paramObject.PYP)) && (((List)localObject1).size() == paramObject.PYP.size())) {
          break label552;
        }
        Log.w("SnsAd.TopicCardResponseModel", "the targetResInfoList size is not same as res infos size");
      }
      for (;;)
      {
        if (i == 0) {
          break label569;
        }
        if (!TextUtils.isEmpty(paramObject.PME)) {
          paramString.PME = paramObject.PME;
        }
        for (;;)
        {
          if ((i >= paramObject.PYP.size()) || (i >= ((List)localObject1).size())) {
            break label564;
          }
          Object localObject2 = (g)((List)localObject1).get(i);
          Object localObject3 = (a.b)paramObject.PYP.get(i);
          if ((localObject2 != null) && (localObject3 != null))
          {
            if (((a.b)localObject3).avatar != null) {
              ((g)localObject2).avatar = ((a.b)localObject3).avatar;
            }
            if (((a.b)localObject3).nickname != null) {
              ((g)localObject2).nickname = ((a.b)localObject3).nickname;
            }
            if (((a.b)localObject3).tag != null) {
              ((g)localObject2).tag = ((a.b)localObject3).tag;
            }
            if (((a.b)localObject3).desc != null) {
              ((g)localObject2).desc = ((a.b)localObject3).desc;
            }
            if (((a.b)localObject3).PMH != null) {
              ((g)localObject2).PMH = ((a.b)localObject3).PMH;
            }
            if (((a.b)localObject3).PMJ != null) {
              ((g)localObject2).PMJ = ((a.b)localObject3).PMJ;
            }
            if (((a.b)localObject3).PYQ != null)
            {
              localObject3 = ((a.b)localObject3).PYQ;
              localObject2 = ((g)localObject2).ibT;
              if ((localObject3 != null) && (localObject2 != null) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).oOZ)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).hWq)))
              {
                ((dmz)localObject2).Id = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).oOZ;
                ((dmz)localObject2).Url = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).url;
                ((dmz)localObject2).aaTl = ((com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a.a)localObject3).hWq;
                break label557;
                if (paramString.PME != null) {
                  l.e(this.QcA, paramString.PME);
                }
                if (this.mRecyclerView != null)
                {
                  paramString = this.mRecyclerView.getAdapter();
                  if (paramString != null) {
                    paramString.bZE.notifyChanged();
                  }
                }
                AppMethodBeat.o(311291);
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
    AppMethodBeat.i(311258);
    try
    {
      d(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(311258);
      return;
    }
    finally
    {
      Log.e("SnsAd.TopicCardDynamic", "doDynamicRequest failed!!!");
      AppMethodBeat.o(311258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.b
 * JD-Core Version:    0.7.0.1
 */