package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.m;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.ui.base.h;

final class GestureGalleryUI$5
  implements y.a
{
  GestureGalleryUI$5(GestureGalleryUI paramGestureGalleryUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(29069);
    if (paramBoolean)
    {
      if (o.wzF != null)
      {
        o.wzF.iv(this.val$filePath, paramString);
        o.wzF.drS();
      }
      h.cf(this.yEJ, this.yEJ.getResources().getString(2131755894));
    }
    AppMethodBeat.o(29069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */