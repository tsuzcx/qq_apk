package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.j.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.mm.plugin.sns.ad.timeline.a.b.b
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(311327);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the input param is invalid!!!!");
      AppMethodBeat.o(311327);
      return false;
    }
    Object localObject = paramSnsInfo.getAdXml().adAvatarFinderTopicInfo;
    if (localObject == null)
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the avatarFinderTopicInfo is null return false!!!!");
      AppMethodBeat.o(311327);
      return false;
    }
    paramd = ((com.tencent.mm.plugin.sns.ad.adxml.b)localObject).PLk;
    localObject = ((com.tencent.mm.plugin.sns.ad.adxml.b)localObject).PLl;
    boolean bool = com.tencent.mm.plugin.sns.ad.b.c.a(paramView.getContext(), paramd, (String)localObject, paramSnsInfo);
    AppMethodBeat.o(311327);
    return bool;
  }
  
  public final void b(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(311338);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.K("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        k.a(paramSnsInfo, 46);
        t.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(311338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */