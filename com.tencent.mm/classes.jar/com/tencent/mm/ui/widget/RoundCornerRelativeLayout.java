package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "path", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "onLayout", "changed", "", "left", "top", "right", "bottom", "resetPath", "setRadius", "radius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "CornerRadius", "libmmui_release"})
public final class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private a QEU;
  private Path lR;
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204891);
    this.lR = new Path();
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(204891);
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204892);
    this.lR = new Path();
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(204892);
  }
  
  private final void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(204885);
    float f = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RoundedCornerFrameLayout, paramInt, 0).getDimension(0, 0.0F);
    this.QEU = new a(f, f, f, f);
    setWillNotDraw(false);
    AppMethodBeat.o(204885);
  }
  
  private final void gZg()
  {
    AppMethodBeat.i(204890);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      Object localObject = this.QEU;
      if (localObject != null)
      {
        this.lR.reset();
        RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        Path localPath = this.lR;
        float f1 = ((a)localObject).QEV;
        float f2 = ((a)localObject).QEV;
        float f3 = ((a)localObject).QEW;
        float f4 = ((a)localObject).QEW;
        float f5 = ((a)localObject).QEY;
        float f6 = ((a)localObject).QEY;
        float f7 = ((a)localObject).QEX;
        float f8 = ((a)localObject).QEX;
        localObject = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (Path.Direction)localObject);
        this.lR.close();
        AppMethodBeat.o(204890);
        return;
      }
    }
    AppMethodBeat.o(204890);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204889);
    p.h(paramCanvas, "canvas");
    if (this.lR.isEmpty()) {
      gZg();
    }
    int i = paramCanvas.save();
    paramCanvas.clipPath(this.lR);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(204889);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204888);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    gZg();
    AppMethodBeat.o(204888);
  }
  
  public final void s(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(204887);
    a locala = this.QEU;
    if (locala == null) {
      p.hyc();
    }
    locala.QEV = paramFloat1;
    locala = this.QEU;
    if (locala == null) {
      p.hyc();
    }
    locala.QEW = paramFloat2;
    locala = this.QEU;
    if (locala == null) {
      p.hyc();
    }
    locala.QEX = paramFloat3;
    locala = this.QEU;
    if (locala == null) {
      p.hyc();
    }
    locala.QEY = paramFloat4;
    gZg();
    postInvalidate();
    AppMethodBeat.o(204887);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(204886);
    s(paramFloat, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(204886);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "libmmui_release"})
  static final class a
  {
    float QEV;
    float QEW;
    float QEX;
    float QEY;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.QEV = paramFloat1;
      this.QEW = paramFloat2;
      this.QEX = paramFloat3;
      this.QEY = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */