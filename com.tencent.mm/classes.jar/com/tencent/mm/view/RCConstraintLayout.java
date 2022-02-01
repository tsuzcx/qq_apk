package com.tencent.mm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RCConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radius", "Lcom/tencent/mm/view/RCConstraintLayout$CornerRadius;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", "defStyle", "innerSetRadius", "r", "", "setRadius", "cornerRadius", "CornerRadius", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RCConstraintLayout
  extends ConstraintLayout
{
  private a agIG;
  private final Path path;
  
  public RCConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235013);
    this.agIG = new a(0.0F, 0.0F);
    this.path = new Path();
    if (paramAttributeSet != null) {
      b(paramAttributeSet, 0);
    }
    AppMethodBeat.o(235013);
  }
  
  public RCConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235018);
    this.agIG = new a(0.0F, 0.0F);
    this.path = new Path();
    if (paramAttributeSet != null) {
      b(paramAttributeSet, paramInt);
    }
    AppMethodBeat.o(235018);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(235019);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.RCConstraintLayout, paramInt, 0);
      s.s(paramAttributeSet, "context.obtainStyledAttr…raintLayout, defStyle, 0)");
      if (paramAttributeSet.hasValue(a.m.RCConstraintLayout_rcRadius))
      {
        ew((int)paramAttributeSet.getDimension(a.m.RCConstraintLayout_rcRadius, a.fromDPToPix(getContext(), 4) * 1.0F));
        Log.i("RCConstraintLayout", s.X("initAttribute radius:", this.agIG));
      }
      paramAttributeSet.recycle();
    }
    AppMethodBeat.o(235019);
  }
  
  private final void ew(float paramFloat)
  {
    this.agIG.BbO = paramFloat;
    this.agIG.BbP = paramFloat;
    this.agIG.BbQ = paramFloat;
    this.agIG.BbR = paramFloat;
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235032);
    s.u(paramCanvas, "canvas");
    if ((this.agIG.BbO > 0.0F) || (this.agIG.BbP > 0.0F) || (this.agIG.BbQ > 0.0F) || (this.agIG.BbR > 0.0F))
    {
      this.path.reset();
      RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.path;
      float f1 = this.agIG.BbO;
      float f2 = this.agIG.BbO;
      float f3 = this.agIG.BbP;
      float f4 = this.agIG.BbP;
      float f5 = this.agIG.BbR;
      float f6 = this.agIG.BbR;
      float f7 = this.agIG.BbQ;
      float f8 = this.agIG.BbQ;
      Path.Direction localDirection = Path.Direction.CCW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
      this.path.close();
      paramCanvas.clipPath(this.path);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(235032);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(235023);
    ew(paramFloat);
    requestLayout();
    AppMethodBeat.o(235023);
  }
  
  public final void setRadius(a parama)
  {
    AppMethodBeat.i(235025);
    s.u(parama, "cornerRadius");
    this.agIG = parama;
    requestLayout();
    AppMethodBeat.o(235025);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RCConstraintLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(234625);
      if (this == paramObject)
      {
        AppMethodBeat.o(234625);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(234625);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Float.valueOf(this.BbO), Float.valueOf(paramObject.BbO)))
      {
        AppMethodBeat.o(234625);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbP), Float.valueOf(paramObject.BbP)))
      {
        AppMethodBeat.o(234625);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbQ), Float.valueOf(paramObject.BbQ)))
      {
        AppMethodBeat.o(234625);
        return false;
      }
      if (!s.p(Float.valueOf(this.BbR), Float.valueOf(paramObject.BbR)))
      {
        AppMethodBeat.o(234625);
        return false;
      }
      AppMethodBeat.o(234625);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(234619);
      int i = Float.floatToIntBits(this.BbO);
      int j = Float.floatToIntBits(this.BbP);
      int k = Float.floatToIntBits(this.BbQ);
      int m = Float.floatToIntBits(this.BbR);
      AppMethodBeat.o(234619);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(234615);
      String str = "topLeft:" + this.BbO + ", topRight:" + this.BbP + ", bottomLeft:" + this.BbQ + ", bottomRight:" + this.BbR;
      AppMethodBeat.o(234615);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RCConstraintLayout
 * JD-Core Version:    0.7.0.1
 */