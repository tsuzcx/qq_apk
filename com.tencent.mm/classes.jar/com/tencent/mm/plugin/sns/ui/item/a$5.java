package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class a$5
  implements SnsTimelineVideoView.b
{
  a$5(a parama) {}
  
  public final void PR(String paramString)
  {
    AppMethodBeat.i(220083);
    ae.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramString + ", the timelineId is " + a.a(this.ANJ));
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(a.a(this.ANJ))))
    {
      a.b(this.ANJ);
      a.c(this.ANJ);
    }
    AppMethodBeat.o(220083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.5
 * JD-Core Version:    0.7.0.1
 */