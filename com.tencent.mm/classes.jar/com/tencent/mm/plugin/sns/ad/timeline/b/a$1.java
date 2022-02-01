package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class a$1
  implements SnsTimelineVideoView.b
{
  a$1(a parama) {}
  
  public final void PR(String paramString)
  {
    AppMethodBeat.i(219152);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(a.a(this.zrT))))
    {
      ae.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramString + ", the timelineId is " + a.a(this.zrT));
      a.b(this.zrT);
    }
    AppMethodBeat.o(219152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.1
 * JD-Core Version:    0.7.0.1
 */