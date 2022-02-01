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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "path", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "onLayout", "changed", "", "left", "top", "right", "bottom", "resetPath", "setRadius", "radius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "CornerRadius", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private a afVm;
  private Path path;
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251607);
    this.path = new Path();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(251607);
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251611);
    this.path = new Path();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(251611);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(251617);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundedCornerFrameLayout, paramInt, 0);
    s.s(paramContext, "context.obtainStyledAttr…FrameLayout, defStyle, 0)");
    float f = paramContext.getDimension(a.m.RoundedCornerFrameLayout_cornerRadius, 0.0F);
    this.afVm = new a(f, f, f, f);
    setWillNotDraw(false);
    AppMethodBeat.o(251617);
  }
  
  private final void jFc()
  {
    AppMethodBeat.i(251624);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      Object localObject = this.afVm;
      if (localObject != null)
      {
        this.path.reset();
        RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        Path localPath = this.path;
        float f1 = ((a)localObject).BbO;
        float f2 = ((a)localObject).BbO;
        float f3 = ((a)localObject).BbP;
        float f4 = ((a)localObject).BbP;
        float f5 = ((a)localObject).BbR;
        float f6 = ((a)localObject).BbR;
        float f7 = ((a)localObject).BbQ;
        float f8 = ((a)localObject).BbQ;
        localObject = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (Path.Direction)localObject);
        this.path.close();
      }
    }
    AppMethodBeat.o(251624);
  }
  
  public final void A(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(251636);
    a locala = this.afVm;
    s.checkNotNull(locala);
    locala.BbO = paramFloat1;
    locala = this.afVm;
    s.checkNotNull(locala);
    locala.BbP = paramFloat2;
    locala = this.afVm;
    s.checkNotNull(locala);
    locala.BbQ = paramFloat3;
    locala = this.afVm;
    s.checkNotNull(locala);
    locala.BbR = paramFloat4;
    jFc();
    postInvalidate();
    AppMethodBeat.o(251636);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(251645);
    s.u(paramCanvas, "canvas");
    if (this.path.isEmpty()) {
      jFc();
    }
    int i = paramCanvas.save();
    paramCanvas.clipPath(this.path);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(251645);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251641);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    jFc();
    AppMethodBeat.o(251641);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(251631);
    A(paramFloat, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(251631);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    float BbO;
    float BbP;
    float BbQ;
    float BbR;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.BbO = paramFloat1;
      this.BbP = paramFloat2;
      this.BbQ = paramFloat3;
      this.BbR = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */