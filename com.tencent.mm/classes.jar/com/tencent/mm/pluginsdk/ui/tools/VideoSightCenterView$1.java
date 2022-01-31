package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSightCenterView$1
  implements b.e
{
  VideoSightCenterView$1(VideoSightCenterView paramVideoSightCenterView) {}
  
  public final void d(b paramb, int paramInt)
  {
    if (-1 == paramInt)
    {
      y.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[] { Boolean.valueOf(VideoSightCenterView.a(this.snp)) });
      if ((this.snp.joM != null) && (!VideoSightCenterView.a(this.snp))) {
        this.snp.joM.onError(0, 0);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      y.i("MicroMsg.VideoSightCenterView", "normal stop");
      VideoSightCenterView.b(this.snp);
    } while (this.snp.joM == null);
    this.snp.joM.ug();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView.1
 * JD-Core Version:    0.7.0.1
 */