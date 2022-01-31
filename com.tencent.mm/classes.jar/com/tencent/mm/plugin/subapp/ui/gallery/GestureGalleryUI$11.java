package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class GestureGalleryUI$11
  implements MMGestureGallery.c
{
  GestureGalleryUI$11(GestureGalleryUI paramGestureGalleryUI, int paramInt) {}
  
  public final void bxv()
  {
    AppMethodBeat.i(25386);
    Object localObject;
    if (1 == this.sYC)
    {
      localObject = v.aae().z("basescanui@datacenter", true);
      ((v.b)localObject).i("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.a(this.sYB).getXDown()));
      ((v.b)localObject).i("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.a(this.sYB).getYDown()));
      GestureGalleryUI.b(this.sYB);
      AppMethodBeat.o(25386);
      return;
    }
    if (2 == this.sYC)
    {
      localObject = this.sYB.getContext().getResources().getStringArray(2131755051);
      h.a(this.sYB, null, (String[])localObject, "", false, new GestureGalleryUI.11.1(this));
    }
    AppMethodBeat.o(25386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.11
 * JD-Core Version:    0.7.0.1
 */