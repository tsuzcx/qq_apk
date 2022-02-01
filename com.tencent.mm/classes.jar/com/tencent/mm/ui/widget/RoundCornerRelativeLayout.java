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
import com.tencent.mm.ah.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "path", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "onLayout", "changed", "", "left", "top", "right", "bottom", "resetPath", "setRadius", "radius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "CornerRadius", "libmmui_release"})
public final class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private a Ydv;
  private Path aBZ;
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(224652);
    this.aBZ = new Path();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(224652);
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(224656);
    this.aBZ = new Path();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(224656);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(224625);
    float f = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundedCornerFrameLayout, paramInt, 0).getDimension(a.m.RoundedCornerFrameLayout_cornerRadius, 0.0F);
    this.Ydv = new a(f, f, f, f);
    setWillNotDraw(false);
    AppMethodBeat.o(224625);
  }
  
  private final void hZW()
  {
    AppMethodBeat.i(224649);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      Object localObject = this.Ydv;
      if (localObject != null)
      {
        this.aBZ.reset();
        RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        Path localPath = this.aBZ;
        float f1 = ((a)localObject).xET;
        float f2 = ((a)localObject).xET;
        float f3 = ((a)localObject).xEU;
        float f4 = ((a)localObject).xEU;
        float f5 = ((a)localObject).xEW;
        float f6 = ((a)localObject).xEW;
        float f7 = ((a)localObject).xEV;
        float f8 = ((a)localObject).xEV;
        localObject = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (Path.Direction)localObject);
        this.aBZ.close();
        AppMethodBeat.o(224649);
        return;
      }
    }
    AppMethodBeat.o(224649);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(224637);
    p.k(paramCanvas, "canvas");
    if (this.aBZ.isEmpty()) {
      hZW();
    }
    int i = paramCanvas.save();
    paramCanvas.clipPath(this.aBZ);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(224637);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(224634);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    hZW();
    AppMethodBeat.o(224634);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(224627);
    v(paramFloat, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(224627);
  }
  
  public final void v(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(224633);
    a locala = this.Ydv;
    if (locala == null) {
      p.iCn();
    }
    locala.xET = paramFloat1;
    locala = this.Ydv;
    if (locala == null) {
      p.iCn();
    }
    locala.xEU = paramFloat2;
    locala = this.Ydv;
    if (locala == null) {
      p.iCn();
    }
    locala.xEV = paramFloat3;
    locala = this.Ydv;
    if (locala == null) {
      p.iCn();
    }
    locala.xEW = paramFloat4;
    hZW();
    postInvalidate();
    AppMethodBeat.o(224633);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "libmmui_release"})
  static final class a
  {
    float xET;
    float xEU;
    float xEV;
    float xEW;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.xET = paramFloat1;
      this.xEU = paramFloat2;
      this.xEV = paramFloat3;
      this.xEW = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */