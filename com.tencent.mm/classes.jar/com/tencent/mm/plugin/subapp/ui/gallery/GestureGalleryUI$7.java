package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.ui.base.h;

final class GestureGalleryUI$7
  implements y.a
{
  GestureGalleryUI$7(GestureGalleryUI paramGestureGalleryUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(193367);
    if (paramBoolean)
    {
      if (o.zbR != null)
      {
        o.zbR.jd(this.val$filePath, paramString);
        o.zbR.dSE();
      }
      h.cl(this.BjD, this.BjD.getResources().getString(2131755894));
    }
    AppMethodBeat.o(193367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */