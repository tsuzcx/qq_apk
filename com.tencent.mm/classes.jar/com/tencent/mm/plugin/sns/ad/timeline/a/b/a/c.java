package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.a;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements b
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(204932);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the input param is invalid!!!!");
      AppMethodBeat.o(204932);
      return false;
    }
    Object localObject = paramSnsInfo.getAdXml().adAvatarFinderTopicInfo;
    if (localObject == null)
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the avatarFinderTopicInfo is null return false!!!!");
      AppMethodBeat.o(204932);
      return false;
    }
    paramd = ((a)localObject).Jxv;
    localObject = ((a)localObject).Jxw;
    boolean bool = com.tencent.mm.plugin.sns.ad.b.c.a(paramView.getContext(), paramd, (String)localObject, paramSnsInfo, 6);
    AppMethodBeat.o(204932);
    return bool;
  }
  
  public final void b(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(204933);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.y("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        k.a(paramSnsInfo, 46);
        t.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(204933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */