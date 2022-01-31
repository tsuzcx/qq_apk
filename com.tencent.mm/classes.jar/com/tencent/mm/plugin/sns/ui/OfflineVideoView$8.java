package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineVideoView$8
  implements f.e
{
  OfflineVideoView$8(OfflineVideoView paramOfflineVideoView) {}
  
  public final void bkk()
  {
    y.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(this.oRp.hashCode()) });
    try
    {
      this.oRp.a(true, 1.0F);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.8
 * JD-Core Version:    0.7.0.1
 */