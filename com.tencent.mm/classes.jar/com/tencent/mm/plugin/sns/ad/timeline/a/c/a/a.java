package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.b.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml, d paramd)
  {
    AppMethodBeat.i(311366);
    paramd = paramADXml.adFinderTopicInfo;
    if ((paramd == null) || (paramView == null))
    {
      Log.w("SnsAd.FinderTopicMaterialClick", "the finder topic info is null!!");
      AppMethodBeat.o(311366);
      return false;
    }
    paramADXml = paramd.PLk;
    paramd = paramd.PLl;
    boolean bool = c.a(paramView.getContext(), paramADXml, paramd, paramSnsInfo);
    AppMethodBeat.o(311366);
    return bool;
  }
  
  public final int fKt()
  {
    return 46;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */