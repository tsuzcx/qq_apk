package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SnsAdStreamVideoView$2
  implements ap.a
{
  SnsAdStreamVideoView$2(SnsAdStreamVideoView paramSnsAdStreamVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(145784);
    this.smO.setIsShowBasicControls(false);
    AppMethodBeat.o(145784);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView.2
 * JD-Core Version:    0.7.0.1
 */