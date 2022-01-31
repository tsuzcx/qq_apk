package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class GestureGalleryUI$4
  implements MMGestureGallery.c
{
  GestureGalleryUI$4(GestureGalleryUI paramGestureGalleryUI, int paramInt) {}
  
  public final void aRg()
  {
    if (1 == this.pwO)
    {
      localObject = u.Hc().v("basescanui@datacenter", true);
      ((u.b)localObject).h("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.a(this.pwN).getXDown()));
      ((u.b)localObject).h("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.a(this.pwN).getYDown()));
      GestureGalleryUI.b(this.pwN);
    }
    while (2 != this.pwO) {
      return;
    }
    Object localObject = this.pwN.mController.uMN.getResources().getStringArray(R.c.shake_tran_img_alert);
    h.a(this.pwN, null, (String[])localObject, "", false, new GestureGalleryUI.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */