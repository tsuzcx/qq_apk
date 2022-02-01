package com.tencent.mm.plugin.sns.ad.timeline.a.d.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.b.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.d.a
{
  public final boolean a(View paramView, SnsInfo paramSnsInfo, f paramf)
  {
    AppMethodBeat.i(311309);
    if (paramf == null)
    {
      Log.w("SnsAd.FinderTopicCardAction", "the ");
      AppMethodBeat.o(311309);
      return false;
    }
    String str = paramf.PLk;
    paramf = paramf.PLl;
    boolean bool = c.a(paramView.getContext(), str, paramf, paramSnsInfo);
    AppMethodBeat.o(311309);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */