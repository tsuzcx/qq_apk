package com.tencent.mm.plugin.sns.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineVideoView$1
  implements Runnable
{
  OfflineVideoView$1(OfflineVideoView paramOfflineVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38360);
    if (OfflineVideoView.a(this.rJb) != null)
    {
      ab.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[] { Integer.valueOf(hashCode()) });
      OfflineVideoView.a(this.rJb).setImageBitmap(BackwardSupportUtil.b.k(this.rJa, 1.0F));
    }
    AppMethodBeat.o(38360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.1
 * JD-Core Version:    0.7.0.1
 */