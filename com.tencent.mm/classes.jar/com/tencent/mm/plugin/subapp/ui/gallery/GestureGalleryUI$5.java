package com.tencent.mm.plugin.subapp.ui.gallery;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.f.b;

final class GestureGalleryUI$5
  implements p.a
{
  GestureGalleryUI$5(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193364);
    Toast.makeText(this.BjD, this.BjD.getString(2131764683, new Object[] { b.aRB(paramString2) }), 1).show();
    q.k(paramString2, this.BjD);
    AppMethodBeat.o(193364);
  }
  
  public final void bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193365);
    Toast.makeText(this.BjD, this.BjD.getString(2131764682), 1).show();
    AppMethodBeat.o(193365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */