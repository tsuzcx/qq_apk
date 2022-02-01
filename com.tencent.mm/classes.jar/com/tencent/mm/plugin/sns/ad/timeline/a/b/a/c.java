package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements b
{
  public final void a(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202110);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.z("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        j.a(paramSnsInfo, 46);
        r.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(202110);
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202109);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the input param is invalid!!!!");
      AppMethodBeat.o(202109);
      return false;
    }
    Object localObject = paramSnsInfo.getAdXml().adAvatarFinderTopicInfo;
    if (localObject == null)
    {
      Log.w("SnsAd.FinderTopicAvatarAction", "the avatarFinderTopicInfo is null return false!!!!");
      AppMethodBeat.o(202109);
      return false;
    }
    paramd = ((a)localObject).finderEncryptedTopicId;
    localObject = ((a)localObject).finderTopicName;
    boolean bool = com.tencent.mm.plugin.sns.ad.c.c.a(paramView.getContext(), paramd, (String)localObject, paramSnsInfo);
    AppMethodBeat.o(202109);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */