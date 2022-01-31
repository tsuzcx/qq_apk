package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class k$4
  implements SnsTimelineVideoView.b
{
  k$4(k paramk) {}
  
  public final void BP(String paramString)
  {
    AppMethodBeat.i(155775);
    ab.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramString, k.a(this.siU) });
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(k.a(this.siU))) && (this.siU.siT != null))
    {
      this.siU.siT.setVisibility(0);
      ab.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
    }
    AppMethodBeat.o(155775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k.4
 * JD-Core Version:    0.7.0.1
 */