package com.tencent.mm.ui.chatting.gallery;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;

final class ImageGalleryUI$14
  implements ViewPager.OnPageChangeListener
{
  private boolean zMK = false;
  
  ImageGalleryUI$14(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(153873);
    ab.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2)
    {
      this.zMK = true;
      ImageGalleryUI.J(this.zME);
      ImageGalleryUI.K(this.zME);
      ImageGalleryUI.L(this.zME);
    }
    if (paramInt == 0)
    {
      if (this.zMK) {
        this.zME.dKB();
      }
      this.zMK = false;
    }
    if (ImageGalleryUI.j(this.zME) != null)
    {
      Object localObject = ImageGalleryUI.j(this.zME);
      if (((c)localObject).zJP != null)
      {
        localObject = ((c)localObject).zJP;
        ((e)localObject).mScrollState = paramInt;
        if (((e)localObject).zLb != null) {
          ((e)localObject).zLb.onPageScrollStateChanged(paramInt);
        }
      }
    }
    AppMethodBeat.o(153873);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(153872);
    if (ImageGalleryUI.j(this.zME) == null)
    {
      AppMethodBeat.o(153872);
      return;
    }
    if (ImageGalleryUI.G(this.zME) != paramInt)
    {
      if (ImageGalleryUI.f(this.zME) == 1) {
        ImageGalleryUI.g(this.zME);
      }
      ImageGalleryUI.I(this.zME);
      ImageGalleryUI.i(this.zME);
    }
    if (ImageGalleryUI.j(this.zME).Gm(paramInt) == null) {
      ab.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramInt) });
    }
    ImageGalleryUI.u(this.zME);
    ImageGalleryUI.f(this.zME, paramInt);
    Object localObject1;
    Object localObject2;
    long l;
    if (ImageGalleryUI.j(this.zME) != null)
    {
      localObject1 = ImageGalleryUI.j(this.zME);
      ((c)localObject1).zJQ.Dm();
      ((c)localObject1).zJR.Dm();
      localObject1 = ImageGalleryUI.j(this.zME).Pz(paramInt);
      if ((c.c((bi)localObject1)) || (c.br((bi)localObject1)))
      {
        localObject2 = ImageGalleryUI.a(this.zME, ImageGalleryUI.j(this.zME), this.zME.nga);
        if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
        {
          if (!(localObject2 instanceof MultiTouchImageView)) {
            break label413;
          }
          ((MultiTouchImageView)localObject2).dDJ();
        }
        ((b)com.tencent.mm.kernel.g.E(b.class)).T((bi)localObject1);
      }
      if (localObject1 != null) {
        this.zME.oN(((dd)localObject1).field_msgId);
      }
      if (ImageGalleryUI.j(this.zME) == null) {
        break label510;
      }
      localObject2 = ImageGalleryUI.j(this.zME).f((bi)localObject1, false);
      ImageGalleryUI.j(this.zME);
      if (!c.b((bi)localObject1, (com.tencent.mm.at.e)localObject2)) {
        break label441;
      }
      localObject1 = com.tencent.mm.at.f.a((com.tencent.mm.at.e)localObject2);
      int i = ((com.tencent.mm.at.e)localObject1).fsd;
      int j = ((com.tencent.mm.at.e)localObject1).offset;
      if (i == 0) {
        break label435;
      }
      l = j * 100L / i - 1L;
      label343:
      i = Math.max(1, (int)l);
      ab.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      this.zME.Qk(i);
    }
    label521:
    for (;;)
    {
      if (ImageGalleryUI.j(this.zME) != null) {
        ImageGalleryUI.j(this.zME).onPageSelected(paramInt);
      }
      AppMethodBeat.o(153872);
      return;
      label413:
      if (!(localObject2 instanceof WxImageView)) {
        break;
      }
      ((WxImageView)localObject2).dDJ();
      break;
      label435:
      l = 0L;
      break label343;
      label441:
      if ((localObject1 != null) && (!((bi)localObject1).byj()) && (ImageGalleryUI.j(this.zME).bt((bi)localObject1)))
      {
        this.zME.hX(false);
      }
      else
      {
        this.zME.hX(true);
        for (;;)
        {
          if (localObject1 != null) {
            break label521;
          }
          ab.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramInt)));
          break;
          label510:
          ab.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
        }
        this.zME.bG((bi)localObject1);
        ImageGalleryUI.k(this.zME);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.14
 * JD-Core Version:    0.7.0.1
 */