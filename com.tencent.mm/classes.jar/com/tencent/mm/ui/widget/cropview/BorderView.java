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
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView
  extends View
{
  private final f HVt;
  private final f HVu;
  private final f HVv;
  private final f HVx;
  private final f HVy;
  private Rect YkP;
  private Rect bvn;
  private Rect eYz;
  private boolean isInit;
  private final Path jZO;
  private final Paint jZQ;
  private final Paint jZT;
  private final Paint jZU;
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.HVt = g.ar((a)new b(this));
    this.HVu = g.ar((a)new a(this));
    this.HVv = g.ar((a)new e(this));
    this.HVx = g.ar((a)new c(this));
    this.HVy = g.ar((a)new d(this));
    this.jZO = new Path();
    this.jZQ = new Paint();
    this.jZT = new Paint();
    this.jZU = new Paint();
    this.eYz = new Rect();
    this.bvn = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.HVt = g.ar((a)new b(this));
    this.HVu = g.ar((a)new a(this));
    this.HVv = g.ar((a)new e(this));
    this.HVx = g.ar((a)new c(this));
    this.HVy = g.ar((a)new d(this));
    this.jZO = new Path();
    this.jZQ = new Paint();
    this.jZT = new Paint();
    this.jZU = new Paint();
    this.eYz = new Rect();
    this.bvn = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.HVu.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.HVt.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.HVx.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.HVy.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.HVv.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164377);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.YkP;
    if (localRect1 == null) {
      p.bGy("currentRect");
    }
    if (!localRect1.equals(this.bvn))
    {
      localRect1 = this.bvn;
      Rect localRect2 = this.YkP;
      if (localRect2 == null) {
        p.bGy("currentRect");
      }
      localRect1.set(localRect2);
      localRect1 = this.eYz;
      localRect2 = this.YkP;
      if (localRect2 == null) {
        p.bGy("currentRect");
      }
      int i = localRect2.left;
      int j = (int)getBOX_PADDING();
      localRect2 = this.YkP;
      if (localRect2 == null) {
        p.bGy("currentRect");
      }
      int k = localRect2.top;
      int m = (int)getBOX_PADDING();
      localRect2 = this.YkP;
      if (localRect2 == null) {
        p.bGy("currentRect");
      }
      int n = localRect2.right;
      int i1 = (int)getBOX_PADDING();
      localRect2 = this.YkP;
      if (localRect2 == null) {
        p.bGy("currentRect");
      }
      localRect1.set(i + j, k + m, n - i1, localRect2.bottom - (int)getBOX_PADDING());
      this.jZO.reset();
      i = 1;
      while (i <= 2)
      {
        this.jZO.moveTo(this.eYz.left + this.eYz.width() / 3 * i, this.eYz.top);
        this.jZO.lineTo(this.eYz.left + this.eYz.width() / 3 * i, this.eYz.bottom);
        this.jZO.moveTo(this.eYz.left, this.eYz.top + this.eYz.height() / 3 * i);
        this.jZO.lineTo(this.eYz.right, this.eYz.top + this.eYz.height() / 3 * i);
        i += 1;
      }
    }
    paramCanvas.drawPath(this.jZO, this.jZT);
    paramCanvas.drawRect(this.eYz, this.jZQ);
    float f1 = this.eYz.left;
    float f2 = getCORNER_WIDTH();
    float f3 = this.eYz.top;
    float f4 = getCORNER_WIDTH() / 2.0F;
    float f5 = this.eYz.left;
    paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.eYz.top - getCORNER_WIDTH() / 2.0F, this.jZU);
    f1 = this.eYz.right;
    f2 = getCORNER_LENGTH();
    f3 = getCORNER_WIDTH() / 2.0F;
    f4 = this.eYz.top;
    f5 = getCORNER_WIDTH() / 2.0F;
    float f6 = this.eYz.right;
    paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.eYz.top - getCORNER_WIDTH() / 2.0F, this.jZU);
    f1 = this.eYz.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.eYz.top;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.eYz.left;
    f6 = getCORNER_WIDTH() / 2.0F;
    float f7 = this.eYz.top;
    paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.jZU);
    f1 = this.eYz.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.eYz.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.eYz.left;
    f7 = getCORNER_WIDTH() / 2.0F;
    float f8 = this.eYz.bottom;
    paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.jZU);
    f1 = this.eYz.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.eYz.top;
    f4 = this.eYz.right;
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.eYz.top;
    paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.jZU);
    f1 = this.eYz.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.eYz.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.eYz.right;
    f7 = getCORNER_WIDTH() / 2.0F;
    f8 = this.eYz.bottom;
    paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.jZU);
    f1 = this.eYz.left;
    f2 = getCORNER_WIDTH();
    f3 = this.eYz.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.eYz.left;
    f6 = getCORNER_LENGTH();
    f7 = this.eYz.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.jZU);
    f1 = this.eYz.right;
    f2 = getCORNER_LENGTH();
    f3 = this.eYz.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.eYz.right;
    f6 = getCORNER_WIDTH();
    f7 = this.eYz.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.jZU);
    AppMethodBeat.o(164377);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isInit)
    {
      this.isInit = true;
      this.jZQ.setColor(-1);
      this.jZQ.setStrokeWidth(getBOX_LINE_WIDTH());
      this.jZQ.setStyle(Paint.Style.STROKE);
      this.jZQ.setAntiAlias(true);
      this.jZT.set(this.jZQ);
      this.jZT.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.jZU.set(this.jZQ);
      this.jZU.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    p.k(paramRect, "rect");
    this.YkP = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Float>
  {
    e(BorderView paramBorderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BorderView
 * JD-Core Version:    0.7.0.1
 */