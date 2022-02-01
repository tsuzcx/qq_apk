package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.q;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class d
  implements b
{
  public final void a(SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(202112);
    if (paramd != null)
    {
      paramSnsInfo = (SnsAdClick)paramd.z("ext_sns_ad_click", null);
      if (paramSnsInfo != null)
      {
        j.a(paramSnsInfo, 31);
        r.a(paramSnsInfo);
      }
    }
    AppMethodBeat.o(202112);
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(202111);
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(202111);
      return false;
    }
    paramView = paramSnsInfo.getAdXml();
    if (paramView.weAppInfo == null)
    {
      AppMethodBeat.o(202111);
      return false;
    }
    boolean bool = c.a(paramView.weAppInfo.appUserName, paramView.weAppInfo.dCx, paramView.weAppInfo.appVersion, paramSnsInfo, paramInt);
    AppMethodBeat.o(202111);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */