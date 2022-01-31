package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.Surface;
import android.view.View;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$k
  implements Runnable
{
  WeakReference<Bitmap> ofk = new WeakReference(null);
  
  private a$k(a parama) {}
  
  public final void run()
  {
    View localView1 = null;
    boolean bool6 = true;
    boolean bool5 = true;
    int i;
    int j;
    boolean bool2;
    label70:
    boolean bool3;
    label83:
    boolean bool4;
    label96:
    Bitmap localBitmap;
    try
    {
      if ((a.m(this.oIA) != null) && (a.m(this.oIA).isValid())) {
        break label637;
      }
      i = this.oIA.hashCode();
      j = hashCode();
      if (a.m(this.oIA) != null) {
        break label792;
      }
      bool1 = true;
      if (a.n(this.oIA) != null) {
        break label797;
      }
      bool2 = true;
      if (this.ofk.get() != null) {
        break label803;
      }
      bool3 = true;
      if (a.o(this.oIA) != null) {
        break label809;
      }
      bool4 = true;
      y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if (a.o(this.oIA) == null)
      {
        localBitmap = (Bitmap)this.ofk.get();
        if (a.n(this.oIA) != null) {
          localView1 = (View)a.n(this.oIA).get();
        }
        if ((localView1 == null) || (localBitmap == null) || (localBitmap.isRecycled()))
        {
          if (localView1 != null) {
            break label815;
          }
          bool1 = true;
          label225:
          if (localBitmap != null) {
            break label820;
          }
          bool2 = bool5;
          label234:
          y.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return;
        }
        localView1.post(new a.k.1(this, localView1, localBitmap));
        return;
      }
    }
    catch (Exception localException1)
    {
      y.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
      return;
    }
    if ((a.p(this.oIA) != null) && (a.p(this.oIA).getWidth() == a.o(this.oIA).getWidth()))
    {
      i = a.p(this.oIA).getHeight();
      j = a.o(this.oIA).getHeight();
      if (i == j) {
        break label390;
      }
    }
    try
    {
      a.a(this.oIA, Bitmap.createBitmap(a.o(this.oIA).getWidth(), a.o(this.oIA).getHeight(), Bitmap.Config.ARGB_8888));
      label390:
      if ((a.p(this.oIA) == null) || (this.ofk.get() == null) || (((Bitmap)this.ofk.get()).isRecycled()))
      {
        if (a.p(this.oIA) != null) {
          break label826;
        }
        bool1 = true;
        label438:
        if (this.ofk.get() != null) {
          break label831;
        }
        bool2 = bool6;
        label452:
        y.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
        a.a(this.oIA, null);
      }
      long l = System.nanoTime();
      SightVideoJNI.handleThumb((Bitmap)this.ofk.get(), a.p(this.oIA), a.o(this.oIA));
      y.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
      localBitmap = a.p(this.oIA);
      if (a.n(this.oIA) == null) {
        break label837;
      }
    }
    View localView2 = (View)a.n(this.oIA).get();
    label608:
    if ((localView2 != null) && (localBitmap != null))
    {
      localView2.post(new a.k.2(this, localView2, localBitmap));
      return;
      label637:
      i = this.oIA.hashCode();
      j = hashCode();
      if (this.ofk.get() != null) {
        break label843;
      }
    }
    label792:
    label797:
    label803:
    label809:
    label815:
    label820:
    label826:
    label831:
    label837:
    label843:
    for (boolean bool1 = true;; bool1 = false)
    {
      y.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (a.n(this.oIA) != null)
      {
        localView2 = (View)a.n(this.oIA).get();
        if (localView2 != null) {
          localView2.post(new a.k.3(this, localView2));
        }
      }
      if (this.ofk.get() == null)
      {
        SightVideoJNI.drawSurfaceColor(a.m(this.oIA), 0);
        return;
      }
      SightVideoJNI.drawSurfaceThumb(a.m(this.oIA), (Bitmap)this.ofk.get(), a.o(this.oIA));
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label70;
      bool3 = false;
      break label83;
      bool4 = false;
      break label96;
      bool1 = false;
      break label225;
      bool2 = false;
      break label234;
      bool1 = false;
      break label438;
      bool2 = false;
      break label452;
      localView2 = null;
      break label608;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k
 * JD-Core Version:    0.7.0.1
 */