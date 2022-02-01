package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.d;
import com.tencent.mm.plugin.sns.ad.b.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml)
  {
    AppMethodBeat.i(262443);
    Object localObject = paramADXml.adFinderTopicInfo;
    if ((localObject == null) || (paramView == null))
    {
      Log.w("SnsAd.FinderTopicMaterialClick", "the finder topic info is null!!");
      AppMethodBeat.o(262443);
      return false;
    }
    paramADXml = ((d)localObject).Jxv;
    localObject = ((d)localObject).Jxw;
    boolean bool = c.a(paramView.getContext(), paramADXml, (String)localObject, paramSnsInfo, 6);
    AppMethodBeat.o(262443);
    return bool;
  }
  
  public final int eCp()
  {
    return 46;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */