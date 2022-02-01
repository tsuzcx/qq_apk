package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.plugin.sns.ad.d.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml)
  {
    AppMethodBeat.i(208777);
    paramADXml = paramADXml.adFinderLiveInfo;
    if ((paramView == null) || (paramADXml == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(208777);
      return false;
    }
    final Context localContext = paramView.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(208777);
      return false;
    }
    String str1 = t.w(paramSnsInfo);
    Log.i("SnsAd.FinderLiveClick", "the material of find live is clicked, snsId=".concat(String.valueOf(str1)));
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().a(paramInt, paramSnsInfo);
      String str2 = l.an(paramSnsInfo.getUxinfo(), str1, 3);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gF(str2, paramADXml.finderUsername);
      paramView = paramView.getTag();
      paramInt = paramSnsInfo.localid;
      if ((paramView instanceof be))
      {
        paramInt = ((be)paramView).position;
        com.tencent.mm.plugin.expt.hellhound.a.b.c.a.report21053OnClickOnSnsAd(paramSnsInfo.field_snsId, Util.safeParseLong(paramADXml.finderLiveId), paramADXml.finderUsername, paramInt);
        paramView = new ArrayMap();
        paramView.put("is_from_ad", Boolean.TRUE);
        paramView.put("key_extra_info", str2);
        com.tencent.mm.plugin.sns.ad.b.b.a(paramADXml.finderUsername, paramADXml.finderLiveId, paramADXml.Jyd, paramADXml.Jye, str1, new b.a()
        {
          public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(209038);
            Log.i("SnsAd.FinderLiveClick", "the FinderLiveClick is called, snsId " + paramAnonymousString + ", errorCode=" + paramAnonymousInt2 + ", actType=" + paramAnonymousInt1);
            if (paramAnonymousInt2 != 0)
            {
              paramAnonymousString = localContext;
              try
              {
                w.cS(paramAnonymousString, "进入直播间失败");
                AppMethodBeat.o(209038);
                return;
              }
              catch (Throwable paramAnonymousString) {}
            }
            AppMethodBeat.o(209038);
          }
        });
        AppMethodBeat.o(208777);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final int eCp()
  {
    return 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */