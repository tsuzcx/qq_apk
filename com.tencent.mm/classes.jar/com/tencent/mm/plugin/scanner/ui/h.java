package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/ui/ScanViewUtils;", "", "()V", "TAG", "", "decodeRoundBitmap", "Landroid/graphics/Bitmap;", "filePath", "fitBitmapBottom", "", "bitmap", "imageView", "Landroid/widget/ImageView;", "viewWidth", "", "viewHeight", "getRoundBitmap", "plugin-scan_release"})
public final class h
{
  public static final h yul;
  
  static
  {
    AppMethodBeat.i(186347);
    yul = new h();
    AppMethodBeat.o(186347);
  }
  
  public static boolean a(Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186345);
    p.h(paramImageView, "imageView");
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(null);
      AppMethodBeat.o(186345);
      return false;
    }
    paramImageView.setImageBitmap(paramBitmap);
    Matrix localMatrix1 = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix2 = paramImageView.getImageMatrix();
    float f1 = 1.0F * paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 - paramBitmap.getHeight() * f1;
    ad.d("MicroMsg.ScanViewUtils", "alvinluo fitBitmapBottom bitmap: %d, %d, scale: %f, translationY: %f, width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localMatrix2.postScale(f1, f1);
    localMatrix2.postTranslate(0.0F, f2);
    localMatrix1.set(localMatrix2);
    paramImageView.setImageMatrix(localMatrix1);
    AppMethodBeat.o(186345);
    return true;
  }
  
  public static Bitmap ac(Bitmap paramBitmap)
  {
    AppMethodBeat.i(186346);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        if (paramBitmap.getWidth() > paramBitmap.getHeight()) {}
        for (double d = Math.floor(paramBitmap.getWidth() / 2.0D + 0.5D);; d = Math.floor(paramBitmap.getHeight() / 2.0D + 0.5D))
        {
          paramBitmap = g.a(paramBitmap, false, (float)d);
          AppMethodBeat.o(186346);
          return paramBitmap;
        }
      }
      AppMethodBeat.o(186346);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      ad.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)paramBitmap, "alvinluo decodeRoundBitmap exception", new Object[0]);
      AppMethodBeat.o(186346);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */