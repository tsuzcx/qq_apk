package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.c.b.a;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml)
  {
    AppMethodBeat.i(202118);
    paramADXml = paramADXml.adFinderLiveInfo;
    if ((paramView == null) || (paramADXml == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(202118);
      return false;
    }
    final Context localContext = paramView.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(202118);
      return false;
    }
    Log.d("SnsAd.FinderLiveClick", "the material of find live is clicked!");
    String str1 = r.v(paramSnsInfo);
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(paramInt, paramSnsInfo);
      String str2 = h.jU(paramSnsInfo.getUxinfo(), str1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(str2, paramADXml.finderUsername);
      paramView = paramView.getTag();
      paramInt = paramSnsInfo.localid;
      if ((paramView instanceof bc))
      {
        paramInt = ((bc)paramView).position;
        com.tencent.mm.plugin.expt.hellhound.a.b.c.a.report21053OnClickOnSnsAd(paramSnsInfo.field_snsId, Util.safeParseLong(paramADXml.finderLiveId), paramADXml.finderUsername, paramInt);
        paramView = new ArrayMap();
        paramView.put("is_from_ad", Boolean.TRUE);
        paramView.put("key_extra_info", str2);
        com.tencent.mm.plugin.sns.ad.c.b.a(paramADXml.finderUsername, paramADXml.finderLiveId, paramADXml.finderLiveFeedExportId, paramADXml.finderLiveFeedNonceId, str1, new b.a()
        {
          public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
          {
            AppMethodBeat.i(202117);
            if (paramAnonymousInt != 0)
            {
              Log.w("SnsAd.FinderLiveClick", "the FinderLiveClick is called, onResult ".concat(String.valueOf(paramAnonymousInt)));
              paramAnonymousString = localContext;
              try
              {
                u.cH(paramAnonymousString, "进入直播间失败");
                AppMethodBeat.o(202117);
                return;
              }
              catch (Throwable paramAnonymousString) {}
            }
            AppMethodBeat.o(202117);
          }
        });
        AppMethodBeat.o(202118);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final int eXH()
  {
    return 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */