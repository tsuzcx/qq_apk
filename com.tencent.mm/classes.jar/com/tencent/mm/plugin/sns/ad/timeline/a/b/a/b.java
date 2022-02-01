package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.sns.ad.adxml.h;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.j.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements com.tencent.mm.plugin.sns.ad.timeline.a.b.b
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    int i = 1;
    AppMethodBeat.i(311336);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(311336);
      return false;
    }
    paramd = paramSnsInfo.getAdXml().adHeadFinderProfile;
    if (paramd == null)
    {
      AppMethodBeat.o(311336);
      return false;
    }
    try
    {
      paramView = paramView.getContext();
      if ((paramView != null) && (paramSnsInfo.getAdInfo(paramInt) != null))
      {
        localObject = paramSnsInfo.getAdXml();
        if ((localObject == null) || (((ADXml)localObject).headClickType != 4)) {
          break label112;
        }
        localObject = ((ADXml)localObject).adHeadFinderProfile;
        if (localObject == null) {
          break label112;
        }
      }
      while (i == 0)
      {
        AppMethodBeat.o(311336);
        return false;
        label112:
        i = 0;
      }
      Object localObject = paramSnsInfo.getAdInfo(paramInt);
      paramd = paramd.finderUsername;
      paramSnsInfo = t.uA(paramSnsInfo.field_snsId);
      boolean bool = n.a(paramView, paramd, ((ADInfo)localObject).uxInfo, paramSnsInfo, 1);
      AppMethodBeat.o(311336);
      return bool;
    }
    finally
    {
      Log.e("HABBYGE-MALI.AdFinderProfileAvatarAction", "doAction exp=" + paramView.toString());
      AppMethodBeat.o(311336);
    }
    return false;
  }
  
  public final void b(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(311349);
    if (paramSnsInfo != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramSnsInfo.getAdXml();
        localObject2 = ((ADXml)localObject1).adHeadFinderProfile;
        if (localObject2 != null) {
          continue;
        }
      }
      catch (Exception paramSnsInfo)
      {
        Object localObject1;
        Object localObject2;
        com.tencent.mm.audio.mix.h.b.printErrStackTrace("HABBYGE-MALI.AdFinderProfileAvatarAction", paramSnsInfo, "reportAd crash: %s", new Object[] { paramSnsInfo.getMessage() });
        continue;
      }
      if (paramd != null)
      {
        paramSnsInfo = (SnsAdClick)paramd.K("ext_sns_ad_click", null);
        if (paramSnsInfo != null)
        {
          k.a(paramSnsInfo, 41);
          t.a(paramSnsInfo);
        }
      }
      AppMethodBeat.o(311349);
      return;
      localObject1 = ((ADXml)localObject1).adHeadFinderProfile.finderUsername;
      localObject2 = t.uA(paramSnsInfo.field_snsId);
      c.hm(n.aw(paramSnsInfo.getUxinfo(), (String)localObject2, 1), (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */