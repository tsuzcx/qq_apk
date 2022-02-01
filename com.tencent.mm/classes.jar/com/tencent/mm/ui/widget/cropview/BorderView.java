package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BorderView
  extends View
{
  private final j NSh;
  private final j NSi;
  private final j NSj;
  private final j NSl;
  private final j NSm;
  private Rect agcN;
  private Rect hbZ;
  private boolean isInit;
  private final Path mzS;
  private final Paint mzU;
  private final Paint mzX;
  private final Paint mzY;
  private Rect tmpRect;
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.NSh = k.cm((a)new b(this));
    this.NSi = k.cm((a)new a(this));
    this.NSj = k.cm((a)new e(this));
    this.NSl = k.cm((a)new c(this));
    this.NSm = k.cm((a)new d(this));
    this.mzS = new Path();
    this.mzU = new Paint();
    this.mzX = new Paint();
    this.mzY = new Paint();
    this.hbZ = new Rect();
    this.tmpRect = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.NSh = k.cm((a)new b(this));
    this.NSi = k.cm((a)new a(this));
    this.NSj = k.cm((a)new e(this));
    this.NSl = k.cm((a)new c(this));
    this.NSm = k.cm((a)new d(this));
    this.mzS = new Path();
    this.mzU = new Paint();
    this.mzX = new Paint();
    this.mzY = new Paint();
    this.hbZ = new Rect();
    this.tmpRect = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.NSi.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.NSh.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.NSl.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.NSm.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.NSj.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164377);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.agcN;
    Object localObject1 = localRect1;
    if (localRect1 == null)
    {
      s.bIx("currentRect");
      localObject1 = null;
    }
    int j;
    int k;
    if (!((Rect)localObject1).equals(this.tmpRect))
    {
      Rect localRect2 = this.tmpRect;
      localRect1 = this.agcN;
      localObject1 = localRect1;
      if (localRect1 == null)
      {
        s.bIx("currentRect");
        localObject1 = null;
      }
      localRect2.set((Rect)localObject1);
      localRect2 = this.hbZ;
      localRect1 = this.agcN;
      localObject1 = localRect1;
      if (localRect1 == null)
      {
        s.bIx("currentRect");
        localObject1 = null;
      }
      i = ((Rect)localObject1).left;
      j = (int)getBOX_PADDING();
      localRect1 = this.agcN;
      localObject1 = localRect1;
      if (localRect1 == null)
      {
        s.bIx("currentRect");
        localObject1 = null;
      }
      k = ((Rect)localObject1).top;
      int m = (int)getBOX_PADDING();
      localRect1 = this.agcN;
      localObject1 = localRect1;
      if (localRect1 == null)
      {
        s.bIx("currentRect");
        localObject1 = null;
      }
      int n = ((Rect)localObject1).right;
      int i1 = (int)getBOX_PADDING();
      localObject1 = this.agcN;
      if (localObject1 != null) {
        break label1182;
      }
      s.bIx("currentRect");
      localObject1 = localObject2;
      localRect2.set(j + i, m + k, n - i1, ((Rect)localObject1).bottom - (int)getBOX_PADDING());
      this.mzS.reset();
    }
    for (int i = 1;; i = j)
    {
      j = i + 1;
      this.mzS.moveTo(this.hbZ.left + this.hbZ.width() / 3 * i, this.hbZ.top);
      this.mzS.lineTo(this.hbZ.left + this.hbZ.width() / 3 * i, this.hbZ.bottom);
      this.mzS.moveTo(this.hbZ.left, this.hbZ.top + this.hbZ.height() / 3 * i);
      localObject1 = this.mzS;
      float f1 = this.hbZ.right;
      k = this.hbZ.top;
      ((Path)localObject1).lineTo(f1, i * (this.hbZ.height() / 3) + k);
      if (j > 2)
      {
        paramCanvas.drawPath(this.mzS, this.mzX);
        paramCanvas.drawRect(this.hbZ, this.mzU);
        f1 = this.hbZ.left;
        float f2 = getCORNER_WIDTH();
        float f3 = this.hbZ.top;
        float f4 = getCORNER_WIDTH() / 2.0F;
        float f5 = this.hbZ.left;
        paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.hbZ.top - getCORNER_WIDTH() / 2.0F, this.mzY);
        f1 = this.hbZ.right;
        f2 = getCORNER_LENGTH();
        f3 = getCORNER_WIDTH() / 2.0F;
        f4 = this.hbZ.top;
        f5 = getCORNER_WIDTH() / 2.0F;
        float f6 = this.hbZ.right;
        paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.hbZ.top - getCORNER_WIDTH() / 2.0F, this.mzY);
        f1 = this.hbZ.left;
        f2 = getCORNER_WIDTH() / 2.0F;
        f3 = this.hbZ.top;
        f4 = getCORNER_WIDTH() / 2.0F;
        f5 = this.hbZ.left;
        f6 = getCORNER_WIDTH() / 2.0F;
        float f7 = this.hbZ.top;
        paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.mzY);
        f1 = this.hbZ.left;
        f2 = getCORNER_WIDTH() / 2.0F;
        f3 = this.hbZ.bottom;
        f4 = getCORNER_LENGTH();
        f5 = getCORNER_WIDTH() / 2.0F;
        f6 = this.hbZ.left;
        f7 = getCORNER_WIDTH() / 2.0F;
        float f8 = this.hbZ.bottom;
        paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.mzY);
        f1 = this.hbZ.right;
        f2 = getCORNER_WIDTH() / 2.0F;
        f3 = this.hbZ.top;
        f4 = this.hbZ.right;
        f5 = getCORNER_WIDTH() / 2.0F;
        f6 = this.hbZ.top;
        paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.mzY);
        f1 = this.hbZ.right;
        f2 = getCORNER_WIDTH() / 2.0F;
        f3 = this.hbZ.bottom;
        f4 = getCORNER_LENGTH();
        f5 = getCORNER_WIDTH() / 2.0F;
        f6 = this.hbZ.right;
        f7 = getCORNER_WIDTH() / 2.0F;
        f8 = this.hbZ.bottom;
        paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.mzY);
        f1 = this.hbZ.left;
        f2 = getCORNER_WIDTH();
        f3 = this.hbZ.bottom;
        f4 = getCORNER_WIDTH() / 2.0F;
        f5 = this.hbZ.left;
        f6 = getCORNER_LENGTH();
        f7 = this.hbZ.bottom;
        paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.mzY);
        f1 = this.hbZ.right;
        f2 = getCORNER_LENGTH();
        f3 = this.hbZ.bottom;
        f4 = getCORNER_WIDTH() / 2.0F;
        f5 = this.hbZ.right;
        f6 = getCORNER_WIDTH();
        f7 = this.hbZ.bottom;
        paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.mzY);
        AppMethodBeat.o(164377);
        return;
        label1182:
        break;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isInit)
    {
      this.isInit = true;
      this.mzU.setColor(-1);
      this.mzU.setStrokeWidth(getBOX_LINE_WIDTH());
      this.mzU.setStyle(Paint.Style.STROKE);
      this.mzU.setAntiAlias(true);
      this.mzX.set(this.mzU);
      this.mzX.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.mzY.set(this.mzU);
      this.mzY.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    s.u(paramRect, "rect");
    this.agcN = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<Float>
  {
    e(BorderView paramBorderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BorderView
 * JD-Core Version:    0.7.0.1
 */