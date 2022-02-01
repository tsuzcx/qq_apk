package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.sns.ad.adxml.e;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.d.r;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  private d PYG;
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml, d paramd)
  {
    AppMethodBeat.i(311383);
    Log.i("SnsAd.FinderLiveClick.AdFinderLiveClick", "AdFinderLiveRoomClick doClick, source=".concat(String.valueOf(paramInt)));
    e locale = paramADXml.adFinderLiveInfo;
    if ((paramView == null) || (paramSnsInfo == null))
    {
      Log.e("SnsAd.FinderLiveClick.AdFinderLiveClick", "info null");
      AppMethodBeat.o(311383);
      return false;
    }
    Context localContext = paramView.getContext();
    if (localContext == null)
    {
      Log.e("SnsAd.FinderLiveClick.AdFinderLiveClick", "context null");
      AppMethodBeat.o(311383);
      return false;
    }
    int i;
    if (locale != null)
    {
      if (!Util.isNullOrNil(new String[] { locale.finderUsername, locale.finderLiveId, locale.PLR, locale.PLS })) {}
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label198;
      }
      Log.i("SnsAd.FinderLiveClick.AdFinderLiveClick", "click material, ready to jump FinderRoomPreview");
      if (paramd != null)
      {
        paramd.put("isFinderRoomPreview", Boolean.TRUE);
        this.PYG = paramd;
      }
      paramView = paramADXml.adFinderLivePreviewInfo;
      if (paramView == null) {
        break label190;
      }
      r.bN(localContext, r.a(paramView, paramSnsInfo));
    }
    for (;;)
    {
      AppMethodBeat.o(311383);
      return true;
      i = 0;
      break;
      label190:
      r.jL(localContext);
    }
    label198:
    paramADXml = t.x(paramSnsInfo);
    try
    {
      com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.hbB().c(paramInt, paramSnsInfo);
      paramd = n.aw(paramSnsInfo.getUxinfo(), paramADXml, 3);
      c.hm(paramd, locale.finderUsername);
      Log.i("SnsAd.FinderLiveClick.AdFinderLiveClick", "doClick, setSnsAdData, snsAdInfo=" + paramd + ", finderUsername=" + locale.finderUsername);
      paramView = paramView.getTag();
      paramInt = paramSnsInfo.localid;
      if ((paramView instanceof bf))
      {
        paramInt = ((bf)paramView).position;
        com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.report21053OnClickOnSnsAd(paramSnsInfo.field_snsId, Util.safeParseLong(locale.finderLiveId), locale.finderUsername, paramInt);
        paramView = new ArrayMap();
        paramView.put("is_from_ad", Boolean.TRUE);
        paramView.put("key_extra_info", paramd);
        com.tencent.mm.plugin.sns.ad.b.b.a(locale.finderUsername, locale.finderLiveId, locale.PLR, locale.PLS, paramView, paramADXml, new b.1(this, localContext));
        AppMethodBeat.o(311383);
        return true;
      }
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public final int fKt()
  {
    AppMethodBeat.i(311386);
    if ((this.PYG != null) && (((Boolean)this.PYG.K("isFinderRoomPreview", Boolean.FALSE)).booleanValue()))
    {
      AppMethodBeat.o(311386);
      return 48;
    }
    AppMethodBeat.o(311386);
    return 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */