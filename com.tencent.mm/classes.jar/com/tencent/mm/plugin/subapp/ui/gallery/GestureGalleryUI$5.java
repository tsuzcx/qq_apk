package com.tencent.mm.plugin.subapp.ui.gallery;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class GestureGalleryUI$5
  implements p.a
{
  GestureGalleryUI$5(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232078);
    Toast.makeText(this.FLO, this.FLO.getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    s.refreshMediaScanner(paramString2, this.FLO);
    AppMethodBeat.o(232078);
  }
  
  public final void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232079);
    Toast.makeText(this.FLO, this.FLO.getString(2131767075), 1).show();
    AppMethodBeat.o(232079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */