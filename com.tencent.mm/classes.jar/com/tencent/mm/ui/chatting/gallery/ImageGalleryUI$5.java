package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.List;

final class ImageGalleryUI$5
  implements n.d
{
  ImageGalleryUI$5(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return;
        paramMenuItem = ImageGalleryUI.f(this.vww).cFU();
        com.tencent.mm.modelvideo.s locals;
        if ((paramMenuItem != null) && (paramMenuItem.aRQ()))
        {
          locals = u.oe(paramMenuItem.field_imgPath);
          if ((locals.status != 199) && (locals.status != 199))
          {
            ImageGalleryUI.b(this.vww, u.d(paramMenuItem.field_msgId, 1));
            ImageGalleryUI.f(this.vww).Hp(this.vww.kJC.getCurrentItem());
            return;
          }
          ImageGalleryUI.f(this.vww).Hk(this.vww.kJC.getCurrentItem());
          return;
        }
        ImageGalleryUI.f(this.vww).Hk(this.vww.kJC.getCurrentItem());
        return;
        paramMenuItem = ImageGalleryUI.f(this.vww).cFU();
        if ((paramMenuItem != null) && (paramMenuItem.aRQ()))
        {
          locals = u.oe(paramMenuItem.field_imgPath);
          if ((locals.status != 199) && (locals.status != 199))
          {
            ImageGalleryUI.b(this.vww, u.d(paramMenuItem.field_msgId, 2));
            ImageGalleryUI.f(this.vww).Hp(this.vww.kJC.getCurrentItem());
            return;
          }
          paramMenuItem = new ArrayList();
          paramMenuItem.add(ImageGalleryUI.f(this.vww).cFU());
          c.e(this.vww.mController.uMN, paramMenuItem);
          return;
        }
        paramMenuItem = new ArrayList();
        paramMenuItem.add(ImageGalleryUI.f(this.vww).cFU());
        b.eBD.B((bi)paramMenuItem.get(0));
        c.e(this.vww.mController.uMN, paramMenuItem);
        return;
        ImageGalleryUI.f(this.vww).Hl(this.vww.kJC.getCurrentItem());
        return;
      } while (!d.SP("favorite"));
      ImageGalleryUI.f(this.vww).Hm(this.vww.kJC.getCurrentItem());
      return;
      y.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
      paramMenuItem = new cd();
      paramMenuItem.bIi.activity = this.vww;
      paramMenuItem.bIi.bGE = ImageGalleryUI.c(this.vww);
      paramMenuItem.bIi.bIj = ImageGalleryUI.x(this.vww);
      paramMenuItem.bIi.bIk = ImageGalleryUI.y(this.vww);
      paramMenuItem.bIi.scene = 37;
      paramMenuItem.bIi.bIo = this.vww.getIntent().getBundleExtra("_stat_obj");
      ImageGalleryUI.a(this.vww, paramMenuItem);
      ImageGalleryUI.b(this.vww, paramMenuItem);
      a.udP.m(paramMenuItem);
      return;
      ImageGalleryUI.z(this.vww);
      return;
    } while (!c.be(ImageGalleryUI.f(this.vww).cFU()));
    ImageGalleryUI.A(this.vww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */