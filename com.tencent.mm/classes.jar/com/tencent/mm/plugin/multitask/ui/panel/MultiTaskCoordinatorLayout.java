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
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.a;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "Landroid/support/design/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerBitmap", "Landroid/graphics/Bitmap;", "cornorRadius", "paint", "Landroid/graphics/Paint;", "pathPaint", "rect", "Landroid/graphics/RectF;", "createCornerBitmap", "width", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "setMode", "mode", "Companion", "ui-multitask_release"})
public final class MultiTaskCoordinatorLayout
  extends CoordinatorLayout
{
  private static final int Afe = 0;
  private static final int Aff = 1;
  public static final MultiTaskCoordinatorLayout.a Afg;
  private static final int MODE_DEFAULT = -1;
  private static int mMode;
  private Paint Afb;
  private int Afc;
  private Bitmap Afd;
  private final RectF cuN;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(236594);
    Afg = new MultiTaskCoordinatorLayout.a((byte)0);
    MODE_DEFAULT = -1;
    Aff = 1;
    mMode = MODE_DEFAULT;
    AppMethodBeat.o(236594);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236592);
    this.paint = new Paint(1);
    this.Afb = new Paint(1);
    this.cuN = new RectF();
    this.Afc = at.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(236592);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236593);
    this.paint = new Paint(1);
    this.Afb = new Paint(1);
    this.cuN = new RectF();
    this.Afc = at.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(236593);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236591);
    p.h(paramCanvas, "canvas");
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0))
    {
      AppMethodBeat.o(236591);
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
    if (this.Afd == null)
    {
      j = paramCanvas.getWidth();
      int k = paramCanvas.getHeight();
      localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
      localCanvas = new Canvas(localBitmap);
      localPath = new Path();
      this.cuN.set(0.0F, this.Afc * 2.0F, j, k);
      localPath.addRect(this.cuN, Path.Direction.CCW);
      if (mMode != Afe) {
        break label307;
      }
      localObject = new Path();
      MultiTaskUIC.a locala = MultiTaskUIC.Ago;
      k = MultiTaskUIC.esk();
      f1 = (j - k) / 2.0F;
      this.cuN.set(f1, 0.0F, k + f1, this.Afc * 4.0F);
      ((Path)localObject).addRoundRect(this.cuN, this.Afc, this.Afc, Path.Direction.CCW);
      localPath.op((Path)localObject, Path.Op.UNION);
    }
    for (;;)
    {
      localPath.setFillType(Path.FillType.WINDING);
      localCanvas.drawPath(localPath, this.Afb);
      p.g(localBitmap, "bitmap");
      this.Afd = localBitmap;
      localBitmap = this.Afd;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(236591);
      return;
      label307:
      if (mMode == Aff)
      {
        localObject = MultiTaskUIC.Ago;
        float f2 = MultiTaskUIC.esd() + 0.0F;
        localObject = MultiTaskUIC.Ago;
        f1 = MultiTaskUIC.esi() + 0.0F;
        localObject = new Path();
        this.cuN.set(j - f2 - f1, 0.0F, j - f2, this.Afc * 4.0F);
        ((Path)localObject).addRoundRect(this.cuN, this.Afc, this.Afc, Path.Direction.CCW);
        localPath.op((Path)localObject, Path.Op.UNION);
        localObject = MultiTaskUIC.Ago;
        f2 = MultiTaskUIC.esd() + 0.0F;
        this.cuN.set(f2, 0.0F, f1 + f2, this.Afc * 4.0F);
        localObject = new Path();
        ((Path)localObject).addRoundRect(this.cuN, this.Afc, this.Afc, Path.Direction.CW);
        localPath.op((Path)localObject, Path.Op.UNION);
      }
    }
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236589);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.Afd = null;
    AppMethodBeat.o(236589);
  }
  
  public final void setMode(int paramInt)
  {
    AppMethodBeat.i(236590);
    if (mMode == paramInt)
    {
      AppMethodBeat.o(236590);
      return;
    }
    mMode = paramInt;
    if (this.Afd != null)
    {
      this.Afd = null;
      postInvalidate();
    }
    AppMethodBeat.o(236590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */