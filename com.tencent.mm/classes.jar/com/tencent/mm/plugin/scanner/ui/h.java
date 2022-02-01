package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/ScanViewUtils;", "", "()V", "TAG", "", "decodeRoundBitmap", "Landroid/graphics/Bitmap;", "filePath", "fitBitmapBottom", "", "bitmap", "imageView", "Landroid/widget/ImageView;", "viewWidth", "", "viewHeight", "getRoundBitmap", "plugin-scan_release"})
public final class h
{
  public static final h yKm;
  
  static
  {
    AppMethodBeat.i(189642);
    yKm = new h();
    AppMethodBeat.o(189642);
  }
  
  public static boolean a(Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189640);
    p.h(paramImageView, "imageView");
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(null);
      AppMethodBeat.o(189640);
      return false;
    }
    paramImageView.setImageBitmap(paramBitmap);
    Matrix localMatrix1 = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix2 = paramImageView.getImageMatrix();
    float f1 = 1.0F * paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 - paramBitmap.getHeight() * f1;
    ae.d("MicroMsg.ScanViewUtils", "alvinluo fitBitmapBottom bitmap: %d, %d, scale: %f, translationY: %f, width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localMatrix2.postScale(f1, f1);
    localMatrix2.postTranslate(0.0F, f2);
    localMatrix1.set(localMatrix2);
    paramImageView.setImageMatrix(localMatrix1);
    AppMethodBeat.o(189640);
    return true;
  }
  
  public static Bitmap ad(Bitmap paramBitmap)
  {
    AppMethodBeat.i(189641);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        if (paramBitmap.getWidth() > paramBitmap.getHeight()) {}
        for (double d = Math.floor(paramBitmap.getWidth() / 2.0D + 0.5D);; d = Math.floor(paramBitmap.getHeight() / 2.0D + 0.5D))
        {
          paramBitmap = com.tencent.mm.sdk.platformtools.h.a(paramBitmap, false, (float)d);
          AppMethodBeat.o(189641);
          return paramBitmap;
        }
      }
      AppMethodBeat.o(189641);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      ae.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)paramBitmap, "alvinluo decodeRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(189641);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */