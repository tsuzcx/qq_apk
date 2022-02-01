package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.sns.ad.a.f;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class b
  implements com.tencent.mm.plugin.sns.ad.timeline.a.b.b
{
  public final void a(SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202108);
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
        com.tencent.mm.audio.mix.i.b.printErrStackTrace("HABBYGE-MALI.AdFinderProfileAvatarAction", paramSnsInfo, "reportAd crash: %s", new Object[] { paramSnsInfo.getMessage() });
        continue;
      }
      if (paramd != null)
      {
        paramSnsInfo = (SnsAdClick)paramd.z("ext_sns_ad_click", null);
        if (paramSnsInfo != null)
        {
          j.a(paramSnsInfo, 41);
          r.a(paramSnsInfo);
        }
      }
      AppMethodBeat.o(202108);
      return;
      localObject1 = ((ADXml)localObject1).adHeadFinderProfile.finderUsername;
      localObject2 = r.Jb(paramSnsInfo.field_snsId);
      c.gr(h.jU(paramSnsInfo.getUxinfo(), (String)localObject2), (String)localObject1);
    }
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202107);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(202107);
      return false;
    }
    if (paramSnsInfo.getAdXml().adHeadFinderProfile == null)
    {
      AppMethodBeat.o(202107);
      return false;
    }
    boolean bool = h.a(paramView.getContext(), paramSnsInfo, paramInt);
    AppMethodBeat.o(202107);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */