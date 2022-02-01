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
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.plugin.multitask.ui.uic.c.a;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerBitmap", "Landroid/graphics/Bitmap;", "cornorRadius", "paint", "Landroid/graphics/Paint;", "pathPaint", "rect", "Landroid/graphics/RectF;", "createCornerBitmap", "width", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "setMode", "mode", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTaskCoordinatorLayout
  extends CoordinatorLayout
{
  public static final MultiTaskCoordinatorLayout.a LGJ;
  private static final int LGN = 0;
  private static final int LGO;
  private static int mMode;
  private static final int nhE;
  private Paint LGK;
  private int LGL;
  private Bitmap LGM;
  private final RectF ekW;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(304532);
    LGJ = new MultiTaskCoordinatorLayout.a((byte)0);
    nhE = -1;
    LGO = 1;
    mMode = nhE;
    AppMethodBeat.o(304532);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304509);
    this.paint = new Paint(1);
    this.LGK = new Paint(1);
    this.ekW = new RectF();
    this.LGL = bd.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(304509);
  }
  
  public MultiTaskCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304514);
    this.paint = new Paint(1);
    this.LGK = new Paint(1);
    this.ekW = new RectF();
    this.LGL = bd.fromDPToPix(getContext(), 8);
    this.paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(304514);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(304559);
    s.u(paramCanvas, "canvas");
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0))
    {
      AppMethodBeat.o(304559);
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
    if (this.LGM == null)
    {
      j = paramCanvas.getWidth();
      int k = paramCanvas.getHeight();
      localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
      localCanvas = new Canvas(localBitmap);
      localPath = new Path();
      this.ekW.set(0.0F, this.LGL * 2.0F, j, k);
      localPath.addRect(this.ekW, Path.Direction.CCW);
      if (mMode != LGN) {
        break label307;
      }
      localObject = new Path();
      c.a locala = c.LHl;
      k = c.glv();
      f1 = (j - k) / 2.0F;
      this.ekW.set(f1, 0.0F, k + f1, this.LGL * 4.0F);
      ((Path)localObject).addRoundRect(this.ekW, this.LGL, this.LGL, Path.Direction.CCW);
      localPath.op((Path)localObject, Path.Op.UNION);
    }
    for (;;)
    {
      localPath.setFillType(Path.FillType.WINDING);
      localCanvas.drawPath(localPath, this.LGK);
      s.s(localBitmap, "bitmap");
      this.LGM = localBitmap;
      localBitmap = this.LGM;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(304559);
      return;
      label307:
      if (mMode == LGO)
      {
        localObject = c.LHl;
        float f2 = c.glo() + 0.0F;
        localObject = c.LHl;
        f1 = c.glt() + 0.0F;
        localObject = new Path();
        this.ekW.set(j - f2 - f1, 0.0F, j - f2, this.LGL * 4.0F);
        ((Path)localObject).addRoundRect(this.ekW, this.LGL, this.LGL, Path.Direction.CCW);
        localPath.op((Path)localObject, Path.Op.UNION);
        localObject = c.LHl;
        f2 = c.glo() + 0.0F;
        this.ekW.set(f2, 0.0F, f1 + f2, this.LGL * 4.0F);
        localObject = new Path();
        ((Path)localObject).addRoundRect(this.ekW, this.LGL, this.LGL, Path.Direction.CW);
        localPath.op((Path)localObject, Path.Op.UNION);
      }
    }
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304538);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.LGM = null;
    AppMethodBeat.o(304538);
  }
  
  public final void setMode(int paramInt)
  {
    AppMethodBeat.i(304543);
    if (mMode == paramInt)
    {
      AppMethodBeat.o(304543);
      return;
    }
    mMode = paramInt;
    if (this.LGM != null)
    {
      this.LGM = null;
      postInvalidate();
    }
    AppMethodBeat.o(304543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */