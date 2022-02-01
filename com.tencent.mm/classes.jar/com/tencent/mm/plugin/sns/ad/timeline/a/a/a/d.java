package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.b.c;
import com.tencent.mm.plugin.sns.ad.j.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  public d(AdClickActionInfo paramAdClickActionInfo)
  {
    this.PYe = paramAdClickActionInfo;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(311407);
    if ((paramSnsInfo == null) || (paramAdClickActionInfo == null) || (paramView == null))
    {
      Log.w("SnsAd.FinderTopicActionButton", "the input param is invalid!!!");
      AppMethodBeat.o(311407);
      return false;
    }
    String str = paramAdClickActionInfo.PLk;
    paramAdClickActionInfo = paramAdClickActionInfo.PLl;
    boolean bool = c.a(paramView.getContext(), str, paramAdClickActionInfo, paramSnsInfo);
    if ((bool) && (paramd != null)) {
      k.a((SnsAdClick)paramd.K("snsAdClick", null), 46);
    }
    AppMethodBeat.o(311407);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */