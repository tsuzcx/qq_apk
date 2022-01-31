package com.tencent.mm.plugin.sight.decode.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.view.Surface;
import android.view.View;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class b$k
  implements Runnable
{
  WeakReference<Bitmap> ofk = new WeakReference(null);
  
  private b$k(b paramb) {}
  
  public final void run()
  {
    final View localView1 = null;
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
    final Bitmap localBitmap;
    try
    {
      if ((b.m(this.oeY) != null) && (b.m(this.oeY).isValid())) {
        break label637;
      }
      i = this.oeY.hashCode();
      j = hashCode();
      if (b.m(this.oeY) != null) {
        break label792;
      }
      bool1 = true;
      if (b.n(this.oeY) != null) {
        break label797;
      }
      bool2 = true;
      if (this.ofk.get() != null) {
        break label803;
      }
      bool3 = true;
      if (b.o(this.oeY) != null) {
        break label809;
      }
      bool4 = true;
      y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if (b.o(this.oeY) == null)
      {
        localBitmap = (Bitmap)this.ofk.get();
        if (b.n(this.oeY) != null) {
          localView1 = (View)b.n(this.oeY).get();
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
        localView1.post(new Runnable()
        {
          public final void run()
          {
            localView1.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          }
        });
        return;
      }
    }
    catch (Exception localException1)
    {
      y.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
      return;
    }
    if ((b.p(this.oeY) != null) && (b.p(this.oeY).getWidth() == b.o(this.oeY).getWidth()))
    {
      i = b.p(this.oeY).getHeight();
      j = b.o(this.oeY).getHeight();
      if (i == j) {
        break label390;
      }
    }
    try
    {
      b.a(this.oeY, Bitmap.createBitmap(b.o(this.oeY).getWidth(), b.o(this.oeY).getHeight(), Bitmap.Config.ARGB_8888));
      label390:
      if ((b.p(this.oeY) == null) || (this.ofk.get() == null) || (((Bitmap)this.ofk.get()).isRecycled()))
      {
        if (b.p(this.oeY) != null) {
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
        b.a(this.oeY, null);
      }
      long l = System.nanoTime();
      SightVideoJNI.handleThumb((Bitmap)this.ofk.get(), b.p(this.oeY), b.o(this.oeY));
      y.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
      localBitmap = b.p(this.oeY);
      if (b.n(this.oeY) == null) {
        break label837;
      }
    }
    View localView2 = (View)b.n(this.oeY).get();
    label608:
    if ((localView2 != null) && (localBitmap != null))
    {
      localView2.post(new b.k.2(this, localView2, localBitmap));
      return;
      label637:
      i = this.oeY.hashCode();
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
      if (b.n(this.oeY) != null)
      {
        localView2 = (View)b.n(this.oeY).get();
        if (localView2 != null) {
          localView2.post(new b.k.3(this, localView2));
        }
      }
      if (this.ofk.get() == null)
      {
        SightVideoJNI.drawSurfaceColor(b.m(this.oeY), 0);
        return;
      }
      SightVideoJNI.drawSurfaceThumb(b.m(this.oeY), (Bitmap)this.ofk.get(), b.o(this.oeY));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.k
 * JD-Core Version:    0.7.0.1
 */