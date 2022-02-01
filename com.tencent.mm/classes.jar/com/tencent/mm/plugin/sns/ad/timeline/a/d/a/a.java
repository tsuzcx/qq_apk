package com.tencent.mm.plugin.sns.ad.timeline.a.d.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.d;
import com.tencent.mm.plugin.sns.ad.b.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.d.a
{
  public final boolean a(View paramView, SnsInfo paramSnsInfo, d paramd)
  {
    AppMethodBeat.i(269637);
    if (paramd == null)
    {
      Log.w("SnsAd.FinderTopicCardAction", "the ");
      AppMethodBeat.o(269637);
      return false;
    }
    String str = paramd.Jxv;
    paramd = paramd.Jxw;
    boolean bool = c.a(paramView.getContext(), str, paramd, paramSnsInfo, 6);
    AppMethodBeat.o(269637);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */