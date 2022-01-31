package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class GestureGalleryUI$4
  implements q.a
{
  GestureGalleryUI$4(GestureGalleryUI paramGestureGalleryUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(153672);
    if (paramBoolean)
    {
      if (n.raP != null)
      {
        n.raP.gf(this.val$filePath, paramString);
        n.raP.cnP();
      }
      h.bO(this.sYB, this.sYB.getResources().getString(2131297076));
    }
    AppMethodBeat.o(153672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */