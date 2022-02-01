package com.tencent.mm.plugin.sns.ad.timeline.a.d.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.d.a
{
  public final boolean a(View paramView, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(202122);
    if (paramd == null)
    {
      Log.w("SnsAd.FinderTopicCardAction", "the ");
      AppMethodBeat.o(202122);
      return false;
    }
    String str = paramd.finderEncryptedTopicId;
    paramd = paramd.finderTopicName;
    boolean bool = c.a(paramView.getContext(), str, paramd, paramSnsInfo);
    AppMethodBeat.o(202122);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */