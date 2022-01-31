package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class GestureGalleryUI$8
  implements q.a
{
  GestureGalleryUI$8(GestureGalleryUI paramGestureGalleryUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      if (n.omB != null)
      {
        n.omB.eE(this.val$filePath, paramString);
        n.omB.bCp();
      }
      h.bC(this.pwN, this.pwN.getResources().getString(R.l.app_shared));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */