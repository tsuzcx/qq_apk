package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.Surface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class b$k
  implements Runnable
{
  WeakReference<Bitmap> qTy;
  
  private b$k(b paramb)
  {
    AppMethodBeat.i(37433);
    this.qTy = new WeakReference(null);
    AppMethodBeat.o(37433);
  }
  
  public final void run()
  {
    View localView1 = null;
    boolean bool6 = true;
    boolean bool5 = true;
    AppMethodBeat.i(37434);
    boolean bool2;
    label75:
    label88:
    label101:
    Bitmap localBitmap;
    try
    {
      if ((b.m(this.ryy) != null) && (b.m(this.ryy).isValid())) {
        break label713;
      }
      i = this.ryy.hashCode();
      j = hashCode();
      boolean bool3;
      boolean bool4;
      if (b.m(this.ryy) == null)
      {
        bool1 = true;
        if (b.n(this.ryy) != null) {
          break label276;
        }
        bool2 = true;
        if (this.qTy.get() != null) {
          break label282;
        }
        bool3 = true;
        if (b.o(this.ryy) != null) {
          break label288;
        }
        bool4 = true;
        ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if (b.o(this.ryy) != null) {
          break label350;
        }
        localBitmap = (Bitmap)this.qTy.get();
        if (b.n(this.ryy) != null) {
          localView1 = (View)b.n(this.ryy).get();
        }
        if ((localView1 != null) && (localBitmap != null) && (!localBitmap.isRecycled())) {
          break label305;
        }
        if (localView1 != null) {
          break label294;
        }
        bool1 = true;
        label230:
        if (localBitmap != null) {
          break label299;
        }
      }
      label276:
      label282:
      label288:
      label294:
      label299:
      for (bool2 = bool5;; bool2 = false)
      {
        ab.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(37434);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label75;
        bool3 = false;
        break label88;
        bool4 = false;
        break label101;
        bool1 = false;
        break label230;
      }
      label305:
      localView1.post(new b.k.1(this, localView1, localBitmap));
      AppMethodBeat.o(37434);
      return;
    }
    catch (Exception localException1)
    {
      ab.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
      AppMethodBeat.o(37434);
      return;
    }
    label350:
    if ((b.p(this.ryy) != null) && (b.p(this.ryy).getWidth() == b.o(this.ryy).getWidth()))
    {
      i = b.p(this.ryy).getHeight();
      j = b.o(this.ryy).getHeight();
      if (i == j) {
        break label444;
      }
    }
    label444:
    label506:
    View localView2;
    try
    {
      b.a(this.ryy, Bitmap.createBitmap(b.o(this.ryy).getWidth(), b.o(this.ryy).getHeight(), Bitmap.Config.ARGB_8888));
      if ((b.p(this.ryy) == null) || (this.qTy.get() == null) || (((Bitmap)this.qTy.get()).isRecycled()))
      {
        if (b.p(this.ryy) != null) {
          break label878;
        }
        bool1 = true;
        if (this.qTy.get() != null) {
          break label883;
        }
        bool2 = bool6;
        ab.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(37434);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
        b.a(this.ryy, null);
      }
      long l = System.nanoTime();
      SightVideoJNI.handleThumb((Bitmap)this.qTy.get(), b.p(this.ryy), b.o(this.ryy));
      ab.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
      localBitmap = b.p(this.ryy);
      if (b.n(this.ryy) != null) {}
      for (localView2 = (View)b.n(this.ryy).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
      {
        AppMethodBeat.o(37434);
        return;
      }
      localView2.post(new b.k.2(this, localView2, localBitmap));
      AppMethodBeat.o(37434);
      return;
    }
    label713:
    int i = this.ryy.hashCode();
    int j = hashCode();
    if (this.qTy.get() == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (b.n(this.ryy) != null)
      {
        localView2 = (View)b.n(this.ryy).get();
        if (localView2 != null) {
          localView2.post(new b.k.3(this, localView2));
        }
      }
      if (this.qTy.get() == null)
      {
        SightVideoJNI.drawSurfaceColor(b.m(this.ryy), 0);
        AppMethodBeat.o(37434);
        return;
      }
      SightVideoJNI.drawSurfaceThumb(b.m(this.ryy), (Bitmap)this.qTy.get(), b.o(this.ryy));
      AppMethodBeat.o(37434);
      return;
      label878:
      bool1 = false;
      break;
      label883:
      bool2 = false;
      break label506;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.k
 * JD-Core Version:    0.7.0.1
 */