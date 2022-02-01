package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.c.b.a;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import java.util.Map;

public final class c
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(final View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, d paramd)
  {
    AppMethodBeat.i(202099);
    Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick button is clicked");
    if ((paramView == null) || (paramSnsInfo == null) || (paramAdCardActionBtnInfo == null))
    {
      AppMethodBeat.o(202099);
      return false;
    }
    paramView = paramView.getContext();
    if (paramView == null)
    {
      AppMethodBeat.o(202099);
      return false;
    }
    String str = r.v(paramSnsInfo);
    j.a((SnsAdClick)paramd.z("snsAdClick", null), 44);
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(paramInt, paramSnsInfo);
      label78:
      paramSnsInfo = h.jU(paramSnsInfo.getUxinfo(), str);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(paramSnsInfo, paramAdCardActionBtnInfo.finderUsername);
      paramd = new ArrayMap();
      paramd.put("is_from_ad", Boolean.TRUE);
      paramd.put("key_extra_info", paramSnsInfo);
      b.a(paramAdCardActionBtnInfo.finderUsername, paramAdCardActionBtnInfo.finderLiveId, paramAdCardActionBtnInfo.finderLiveFeedExportId, paramAdCardActionBtnInfo.finderLiveFeedNonceId, str, new b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(202098);
          if (paramAnonymousInt != 0)
          {
            Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick is called, onResult ".concat(String.valueOf(paramAnonymousInt)));
            paramAnonymousString = paramView;
            try
            {
              u.cH(paramAnonymousString, "进入直播间失败");
              AppMethodBeat.o(202098);
              return;
            }
            catch (Throwable paramAnonymousString) {}
          }
          AppMethodBeat.o(202098);
        }
      });
      AppMethodBeat.o(202099);
      return true;
    }
    catch (Throwable paramd)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */