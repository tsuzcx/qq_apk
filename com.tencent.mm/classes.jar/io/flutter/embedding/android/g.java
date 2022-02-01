package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.a;
import io.flutter.embedding.engine.b.c;

@SuppressLint({"ViewConstructor"})
@TargetApi(19)
public final class g
  extends View
  implements c
{
  private Image SMR;
  private Image SMS;
  private a SMT;
  private a SMU;
  private int SMV;
  private boolean SMW;
  private ImageReader hiC;
  private Bitmap zUW;
  
  public g(Context paramContext, int paramInt1, int paramInt2, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(215101);
    this.SMV = 0;
    this.SMW = false;
    this.hiC = mR(paramInt1, paramInt2);
    this.SMU = parama;
    setAlpha(0.0F);
    AppMethodBeat.o(215101);
  }
  
  @TargetApi(19)
  private static ImageReader mR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215102);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3, 768L);
      AppMethodBeat.o(215102);
      return localImageReader;
    }
    ImageReader localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3);
    AppMethodBeat.o(215102);
    return localImageReader;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(215104);
    if (this.SMW)
    {
      AppMethodBeat.o(215104);
      return;
    }
    switch (1.SMX[this.SMU.ordinal()])
    {
    }
    for (;;)
    {
      setAlpha(1.0F);
      this.SMT = parama;
      this.SMW = true;
      AppMethodBeat.o(215104);
      return;
      parama.p(this.hiC.getSurface());
    }
  }
  
  public final a getAttachedRenderer()
  {
    return this.SMT;
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(215103);
    Surface localSurface = this.hiC.getSurface();
    AppMethodBeat.o(215103);
    return localSurface;
  }
  
  public final void hwu()
  {
    AppMethodBeat.i(215105);
    if (!this.SMW)
    {
      AppMethodBeat.o(215105);
      return;
    }
    setAlpha(0.0F);
    hwv();
    this.SMV = 0;
    this.zUW = null;
    if (this.SMR != null)
    {
      this.SMR.close();
      this.SMR = null;
    }
    if (this.SMS != null)
    {
      this.SMS.close();
      this.SMS = null;
    }
    invalidate();
    this.SMW = false;
    AppMethodBeat.o(215105);
  }
  
  @TargetApi(19)
  public final boolean hwv()
  {
    AppMethodBeat.i(215106);
    if (!this.SMW)
    {
      AppMethodBeat.o(215106);
      return false;
    }
    if (this.SMV < this.hiC.getMaxImages())
    {
      this.SMR = this.hiC.acquireLatestImage();
      if (this.SMR != null) {
        this.SMV += 1;
      }
    }
    invalidate();
    if (this.SMR != null)
    {
      AppMethodBeat.o(215106);
      return true;
    }
    AppMethodBeat.o(215106);
    return false;
  }
  
  public final void mS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215107);
    if (this.SMT == null)
    {
      AppMethodBeat.o(215107);
      return;
    }
    if ((paramInt1 == this.hiC.getWidth()) && (paramInt2 == this.hiC.getHeight()))
    {
      AppMethodBeat.o(215107);
      return;
    }
    if (this.SMR != null)
    {
      this.SMR.close();
      this.SMR = null;
    }
    if (this.SMS != null)
    {
      this.SMS.close();
      this.SMS = null;
    }
    this.hiC.close();
    this.hiC = mR(paramInt1, paramInt2);
    this.SMV = 0;
    AppMethodBeat.o(215107);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(215108);
    super.onDraw(paramCanvas);
    if (this.SMR != null)
    {
      if (this.SMS != null)
      {
        this.SMS.close();
        this.SMV -= 1;
      }
      this.SMS = this.SMR;
      this.SMR = null;
      if (Build.VERSION.SDK_INT < 29) {
        break label106;
      }
      this.zUW = Bitmap.wrapHardwareBuffer(this.SMS.getHardwareBuffer(), ColorSpace.get(ColorSpace.Named.SRGB));
    }
    for (;;)
    {
      if (this.zUW != null) {
        paramCanvas.drawBitmap(this.zUW, 0.0F, 0.0F, null);
      }
      AppMethodBeat.o(215108);
      return;
      label106:
      Object localObject = this.SMS.getPlanes();
      if (localObject.length == 1)
      {
        localObject = localObject[0];
        int i = ((Image.Plane)localObject).getRowStride() / ((Image.Plane)localObject).getPixelStride();
        int j = this.SMS.getHeight();
        if ((this.zUW == null) || (this.zUW.getWidth() != i) || (this.zUW.getHeight() != j)) {
          this.zUW = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        }
        this.zUW.copyPixelsFromBuffer(((Image.Plane)localObject).getBuffer());
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(215109);
    if ((paramInt1 == this.hiC.getWidth()) && (paramInt2 == this.hiC.getHeight()))
    {
      AppMethodBeat.o(215109);
      return;
    }
    if ((this.SMU == a.SMY) && (this.SMW))
    {
      mS(paramInt1, paramInt2);
      this.SMT.p(this.hiC.getSurface());
    }
    AppMethodBeat.o(215109);
  }
  
  public final void pause() {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(215047);
      SMY = new a("background", 0);
      SMZ = new a("overlay", 1);
      SNa = new a[] { SMY, SMZ };
      AppMethodBeat.o(215047);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.g
 * JD-Core Version:    0.7.0.1
 */