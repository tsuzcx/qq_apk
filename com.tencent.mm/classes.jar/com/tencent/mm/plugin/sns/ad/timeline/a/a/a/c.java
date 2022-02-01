package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.plugin.sns.ad.d.l;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import java.util.Map;

public final class c
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(final View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    AppMethodBeat.i(228442);
    Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick button is clicked");
    if ((paramView == null) || (paramSnsInfo == null) || (paramAdClickActionInfo == null))
    {
      AppMethodBeat.o(228442);
      return false;
    }
    paramView = paramView.getContext();
    if (paramView == null)
    {
      AppMethodBeat.o(228442);
      return false;
    }
    String str = t.w(paramSnsInfo);
    k.a((SnsAdClick)paramd.y("snsAdClick", null), 44);
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().a(paramInt, paramSnsInfo);
      label78:
      paramInt = l.aeJ(paramAdClickActionInfo.scene);
      paramSnsInfo = l.an(paramSnsInfo.getUxinfo(), str, paramInt);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gF(paramSnsInfo, paramAdClickActionInfo.finderUsername);
      paramd = new ArrayMap();
      paramd.put("is_from_ad", Boolean.TRUE);
      paramd.put("key_extra_info", paramSnsInfo);
      b.a(paramAdClickActionInfo.finderUsername, paramAdClickActionInfo.finderLiveId, paramAdClickActionInfo.Jyd, paramAdClickActionInfo.Jye, str, new b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(245992);
          if (paramAnonymousInt2 != 0)
          {
            Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick is called, onResult ".concat(String.valueOf(paramAnonymousInt2)));
            paramAnonymousString = paramView;
            try
            {
              w.cS(paramAnonymousString, "进入直播间失败");
              AppMethodBeat.o(245992);
              return;
            }
            catch (Throwable paramAnonymousString) {}
          }
          AppMethodBeat.o(245992);
        }
      });
      AppMethodBeat.o(228442);
      return true;
    }
    catch (Throwable paramd)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */