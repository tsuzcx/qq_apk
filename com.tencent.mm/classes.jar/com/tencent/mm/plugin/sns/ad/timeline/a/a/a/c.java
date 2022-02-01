package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.d.r;
import com.tencent.mm.plugin.sns.ad.j.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public c(AdClickActionInfo paramAdClickActionInfo)
  {
    this.PYe = paramAdClickActionInfo;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    int j = 0;
    AppMethodBeat.i(311411);
    Log.i("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "AdFinderLiveRoomClick doClick, source=".concat(String.valueOf(paramInt)));
    if ((paramView == null) || (paramAdClickActionInfo == null) || (paramSnsInfo == null))
    {
      Log.e("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "info null");
      AppMethodBeat.o(311411);
      return false;
    }
    paramView = paramView.getContext();
    if (paramView == null)
    {
      Log.e("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "context null");
      AppMethodBeat.o(311411);
      return false;
    }
    int i = j;
    if (paramAdClickActionInfo != null)
    {
      i = j;
      if (Util.isNullOrNil(new String[] { paramAdClickActionInfo.finderUsername, paramAdClickActionInfo.finderLiveId, paramAdClickActionInfo.PLR, paramAdClickActionInfo.PLS })) {
        i = 1;
      }
    }
    if (i != 0)
    {
      Log.i("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "click actionBtn, ready to jump FinderRoomPreview， previewNode=" + paramAdClickActionInfo.PLT);
      k.a((SnsAdClick)paramd.K("snsAdClick", null), 48);
      if (paramAdClickActionInfo.PLT) {
        r.bN(paramView, r.a(paramAdClickActionInfo, paramSnsInfo));
      }
      for (;;)
      {
        AppMethodBeat.o(311411);
        return true;
        r.jL(paramView);
      }
    }
    String str = t.x(paramSnsInfo);
    k.a((SnsAdClick)paramd.K("snsAdClick", null), 44);
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.hbB().c(paramInt, paramSnsInfo);
      label238:
      paramInt = n.ajs(paramAdClickActionInfo.scene);
      paramSnsInfo = n.aw(paramSnsInfo.getUxinfo(), str, paramInt);
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.hm(paramSnsInfo, paramAdClickActionInfo.finderUsername);
      Log.i("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "doClick, setSnsAdData, snsAdInfo=" + paramSnsInfo + ", finderUsername=" + paramAdClickActionInfo.finderUsername);
      paramd = new ArrayMap();
      paramd.put("is_from_ad", Boolean.TRUE);
      paramd.put("key_extra_info", paramSnsInfo);
      b.a(paramAdClickActionInfo.finderUsername, paramAdClickActionInfo.finderLiveId, paramAdClickActionInfo.PLR, paramAdClickActionInfo.PLS, paramd, str, new c.1(this, paramView));
      AppMethodBeat.o(311411);
      return true;
    }
    finally
    {
      break label238;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */