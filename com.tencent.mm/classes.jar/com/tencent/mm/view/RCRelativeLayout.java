package com.tencent.mm.view;

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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RCRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radius", "Lcom/tencent/mm/view/RCRelativeLayout$CornerRadius;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", "defStyle", "innerSetRadius", "r", "", "setRadius", "cornerRadius", "CornerRadius", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RCRelativeLayout
  extends RelativeLayout
{
  private a agIH;
  private final Path path;
  
  public RCRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234683);
    this.agIH = new a(0.0F, 0.0F);
    this.path = new Path();
    if (paramAttributeSet != null) {
      b(paramAttributeSet, 0);
    }
    AppMethodBeat.o(234683);
  }
  
  public RCRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234687);
    this.agIH = new a(0.0F, 0.0F);
    this.path = new Path();
    if (paramAttributeSet != null) {
      b(paramAttributeSet, paramInt);
    }
    AppMethodBeat.o(234687);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(234692);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.RCConstraintLayout, paramInt, 0);
      s.s(paramAttributeSet, "context.obtainStyledAttr…raintLayout, defStyle, 0)");
      if (paramAttributeSet.hasValue(a.m.RCConstraintLayout_rcRadius))
      {
        ew((int)paramAttributeSet.getDimension(a.m.RCConstraintLayout_rcRadius, a.fromDPToPix(getContext(), 4) * 1.0F));
        Log.i("RCRelativeLayout", s.X("initAttribute radius:", this.agIH));
      }
      paramAttributeSet.recycle();
    }
    AppMethodBeat.o(234692);
  }
  
  private final void ew(float paramFloat)
  {
    this.agIH.BbO = paramFloat;
    this.agIH.BbP = paramFloat;
    this.agIH.BbQ = paramFloat;
    this.agIH.BbR = paramFloat;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(234707);
    s.u(paramCanvas, "canvas");
    if ((this.agIH.BbO > 0.0F) || (this.agIH.BbP > 0.0F) || (this.agIH.BbQ > 0.0F) || (this.agIH.BbR > 0.0F))
    {
      this.path.reset();
      RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.path;
      float f1 = this.agIH.BbO;
      float f2 = this.agIH.BbO;
      float f3 = this.agIH.BbP;
      float f4 = this.agIH.BbP;
      float f5 = this.agIH.BbR;
      float f6 = this.agIH.BbR;
      float f7 = this.agIH.BbQ;
      float f8 = this.agIH.BbQ;
      Path.Direction localDirection = Path.Direction.CCW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
      this.path.close();
      paramCanvas.clipPath(this.path);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(234707);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(234701);
    ew(paramFloat);
    requestLayout();
    AppMethodBeat.o(234701);
  }
  
  public final void setRadius(a parama)
  {
    AppMethodBeat.i(234703);
    s.u(parama, "cornerRadius");
    this.agIH = parama;
    requestLayout();
    AppMethodBeat.o(234703);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RCRelativeLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    float BbO;
    float BbP;
    float BbQ;
    float BbR;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.BbO = paramFloat1;
      this.BbP = 0.0F;
      this.BbQ = paramFloat2;
      this.BbR = 0.0F;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(234724);
      if (this == paramObject)
      {
        AppMethodBeat.o(234724);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(234724);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Float.valueOf(this.BbO), Float.valueOf(paramObject.BbO)))
      {
        AppMethodBeat.o(234724);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbP), Float.valueOf(paramObject.BbP)))
      {
        AppMethodBeat.o(234724);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbQ), Float.valueOf(paramObject.BbQ)))
      {
        AppMethodBeat.o(234724);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbR), Float.valueOf(paramObject.BbR)))
      {
        AppMethodBeat.o(234724);
        return false;
      }
      AppMethodBeat.o(234724);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(234722);
      int i = Float.floatToIntBits(this.BbO);
      int j = Float.floatToIntBits(this.BbP);
      int k = Float.floatToIntBits(this.BbQ);
      int m = Float.floatToIntBits(this.BbR);
      AppMethodBeat.o(234722);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(234719);
      String str = "topLeft:" + this.BbO + ", topRight:" + this.BbP + ", bottomLeft:" + this.BbQ + ", bottomRight:" + this.BbR;
      AppMethodBeat.o(234719);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RCRelativeLayout
 * JD-Core Version:    0.7.0.1
 */