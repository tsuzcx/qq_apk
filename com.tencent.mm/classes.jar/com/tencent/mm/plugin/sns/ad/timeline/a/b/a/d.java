package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.q;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class d
  implements b
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(216391);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(216391);
      return false;
    }
    paramView = paramSnsInfo.getAdXml();
    if (paramView.weAppInfo == null)
    {
      AppMethodBeat.o(216391);
      return false;
    }
    boolean bool = c.a(paramView.weAppInfo.appUserName, paramView.weAppInfo.fve, paramView.weAppInfo.appVersion, paramSnsInfo, paramInt);
    AppMethodBeat.o(216391);
    return bool;
  }
  
  public final void b(SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(216393);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.y("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        k.a(paramSnsInfo, 31);
        t.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(216393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */