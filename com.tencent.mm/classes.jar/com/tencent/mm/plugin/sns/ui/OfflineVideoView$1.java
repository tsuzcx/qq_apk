package com.tencent.mm.plugin.sns.ui;

import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineVideoView$1
  implements Runnable
{
  OfflineVideoView$1(OfflineVideoView paramOfflineVideoView, String paramString) {}
  
  public final void run()
  {
    if (OfflineVideoView.a(this.oRp) != null)
    {
      y.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
      OfflineVideoView.a(this.oRp).setImageBitmap(BackwardSupportUtil.b.e(this.oRo, 1.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.1
 * JD-Core Version:    0.7.0.1
 */