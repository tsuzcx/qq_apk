package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;

final class VideoSightView$1
  implements b.e
{
  VideoSightView$1(VideoSightView paramVideoSightView) {}
  
  public final void d(b paramb, int paramInt)
  {
    if (-1 == paramInt) {
      if (this.snt.joM != null) {
        this.snt.joM.onError(0, 0);
      }
    }
    while ((paramInt != 0) || (this.snt.joM == null)) {
      return;
    }
    this.snt.joM.ug();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView.1
 * JD-Core Version:    0.7.0.1
 */