package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.a.c;
import com.tencent.mm.plugin.multitask.ui.a.c.a;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerBitmap", "Landroid/graphics/Bitmap;", "cornorRadius", "paint", "Landroid/graphics/Paint;", "pathPaint", "rect", "Landroid/graphics/RectF;", "createCornerBitmap", "width", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "setMode", "mode", "Companion", "ui-multitask_release"})
public final class MultiTaskCoordinatorLayout
  extends CoordinatorLayout
{
  private static final int FLH = 0;
  private static final int FLI = 1;
  public static final MultiTaskCoordinatorLayout.a FLJ;
  private static final int kEu = -1;
  private static int mMode;
  private Paint FLE;
  private int FLF;
  private Bitmap FLG;
  private final RectF ctb;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(196864);
    FLJ = new MultiTaskCoordinatorLayout.a((byte)0);
    kEu = -1;
    FLI = 1;
    mMode = kEu;
    AppMethodBeat.o(196864);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196861);
    this.paint = new Paint(1);
    this.FLE = new Paint(1);
    this.ctb = new RectF();
    this.FLF = aw.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(196861);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196863);
    this.paint = new Paint(1);
    this.FLE = new Paint(1);
    this.ctb = new RectF();
    this.FLF = aw.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(196863);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196859);
    p.k(paramCanvas, "canvas");
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0))
    {
      AppMethodBeat.o(196859);
      return;
    }
    int i = paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), null, 31);
    super.draw(paramCanvas);
    int j;
    Bitmap localBitmap;
    Canvas localCanvas;
    Path localPath;
    Object localObject;
    float f1;
    if (this.FLG == null)
    {
      j = paramCanvas.getWidth();
      int k = paramCanvas.getHeight();
      localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
      localCanvas = new Canvas(localBitmap);
      localPath = new Path();
      this.ctb.set(0.0F, this.FLF * 2.0F, j, k);
      localPath.addRect(this.ctb, Path.Direction.CCW);
      if (mMode != FLH) {
        break label307;
      }
      localObject = new Path();
      c.a locala = c.FNc;
      k = c.fcs();
      f1 = (j - k) / 2.0F;
      this.ctb.set(f1, 0.0F, k + f1, this.FLF * 4.0F);
      ((Path)localObject).addRoundRect(this.ctb, this.FLF, this.FLF, Path.Direction.CCW);
      localPath.op((Path)localObject, Path.Op.UNION);
    }
    for (;;)
    {
      localPath.setFillType(Path.FillType.WINDING);
      localCanvas.drawPath(localPath, this.FLE);
      p.j(localBitmap, "bitmap");
      this.FLG = localBitmap;
      localBitmap = this.FLG;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(196859);
      return;
      label307:
      if (mMode == FLI)
      {
        localObject = c.FNc;
        float f2 = c.fcl() + 0.0F;
        localObject = c.FNc;
        f1 = c.fcq() + 0.0F;
        localObject = new Path();
        this.ctb.set(j - f2 - f1, 0.0F, j - f2, this.FLF * 4.0F);
        ((Path)localObject).addRoundRect(this.ctb, this.FLF, this.FLF, Path.Direction.CCW);
        localPath.op((Path)localObject, Path.Op.UNION);
        localObject = c.FNc;
        f2 = c.fcl() + 0.0F;
        this.ctb.set(f2, 0.0F, f1 + f2, this.FLF * 4.0F);
        localObject = new Path();
        ((Path)localObject).addRoundRect(this.ctb, this.FLF, this.FLF, Path.Direction.CW);
        localPath.op((Path)localObject, Path.Op.UNION);
      }
    }
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196846);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.FLG = null;
    AppMethodBeat.o(196846);
  }
  
  public final void setMode(int paramInt)
  {
    AppMethodBeat.i(196847);
    if (mMode == paramInt)
    {
      AppMethodBeat.o(196847);
      return;
    }
    mMode = paramInt;
    if (this.FLG != null)
    {
      this.FLG = null;
      postInvalidate();
    }
    AppMethodBeat.o(196847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */