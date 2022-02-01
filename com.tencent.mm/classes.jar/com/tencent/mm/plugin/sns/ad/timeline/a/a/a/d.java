package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    AppMethodBeat.i(202100);
    if ((paramSnsInfo == null) || (paramAdCardActionBtnInfo == null) || (paramView == null))
    {
      Log.w("SnsAd.FinderTopicActionButton", "the input param is invalid!!!");
      AppMethodBeat.o(202100);
      return false;
    }
    String str = paramAdCardActionBtnInfo.finderEncryptedTopicId;
    paramAdCardActionBtnInfo = paramAdCardActionBtnInfo.finderTopicName;
    boolean bool = c.a(paramView.getContext(), str, paramAdCardActionBtnInfo, paramSnsInfo);
    if ((bool) && (paramd != null)) {
      j.a((SnsAdClick)paramd.z("snsAdClick", null), 46);
    }
    AppMethodBeat.o(202100);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */