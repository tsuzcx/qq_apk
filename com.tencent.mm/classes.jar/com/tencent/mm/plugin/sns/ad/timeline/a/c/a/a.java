package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml)
  {
    AppMethodBeat.i(202116);
    Object localObject = paramADXml.adFinderTopicInfo;
    if ((localObject == null) || (paramView == null))
    {
      Log.w("SnsAd.FinderTopicMaterialClick", "the finder topic info is null!!");
      AppMethodBeat.o(202116);
      return false;
    }
    paramADXml = ((d)localObject).finderEncryptedTopicId;
    localObject = ((d)localObject).finderTopicName;
    boolean bool = c.a(paramView.getContext(), paramADXml, (String)localObject, paramSnsInfo);
    AppMethodBeat.o(202116);
    return bool;
  }
  
  public final int eXH()
  {
    return 46;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */