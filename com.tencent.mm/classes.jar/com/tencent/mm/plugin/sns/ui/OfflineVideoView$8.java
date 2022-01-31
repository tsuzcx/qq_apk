package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineVideoView$8
  implements e.e
{
  OfflineVideoView$8(OfflineVideoView paramOfflineVideoView) {}
  
  public final void bSk()
  {
    AppMethodBeat.i(38367);
    ab.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(this.rJb.hashCode()) });
    try
    {
      this.rJb.a(true, 1.0F);
      AppMethodBeat.o(38367);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OfflineVideoView", "texture view update. error " + localException.toString());
      AppMethodBeat.o(38367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.8
 * JD-Core Version:    0.7.0.1
 */