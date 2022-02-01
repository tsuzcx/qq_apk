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
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView
  extends View
{
  private Rect KUH;
  private boolean cAX;
  private Rect cPO;
  private final Path gyB;
  private final Paint gyD;
  private final Paint gyG;
  private final Paint gyH;
  private Rect mA;
  private final f xHR;
  private final f xHS;
  private final f xHT;
  private final f xHV;
  private final f xHW;
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.xHR = g.O((a)new b(this));
    this.xHS = g.O((a)new a(this));
    this.xHT = g.O((a)new e(this));
    this.xHV = g.O((a)new c(this));
    this.xHW = g.O((a)new d(this));
    this.gyB = new Path();
    this.gyD = new Paint();
    this.gyG = new Paint();
    this.gyH = new Paint();
    this.cPO = new Rect();
    this.mA = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.xHR = g.O((a)new b(this));
    this.xHS = g.O((a)new a(this));
    this.xHT = g.O((a)new e(this));
    this.xHV = g.O((a)new c(this));
    this.xHW = g.O((a)new d(this));
    this.gyB = new Path();
    this.gyD = new Paint();
    this.gyG = new Paint();
    this.gyH = new Paint();
    this.cPO = new Rect();
    this.mA = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.xHS.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.xHR.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.xHV.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.xHW.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.xHT.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164377);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.KUH;
    if (localRect1 == null) {
      p.bcb("currentRect");
    }
    if (!localRect1.equals(this.mA))
    {
      localRect1 = this.mA;
      Rect localRect2 = this.KUH;
      if (localRect2 == null) {
        p.bcb("currentRect");
      }
      localRect1.set(localRect2);
      localRect1 = this.cPO;
      localRect2 = this.KUH;
      if (localRect2 == null) {
        p.bcb("currentRect");
      }
      int i = localRect2.left;
      int j = (int)getBOX_PADDING();
      localRect2 = this.KUH;
      if (localRect2 == null) {
        p.bcb("currentRect");
      }
      int k = localRect2.top;
      int m = (int)getBOX_PADDING();
      localRect2 = this.KUH;
      if (localRect2 == null) {
        p.bcb("currentRect");
      }
      int n = localRect2.right;
      int i1 = (int)getBOX_PADDING();
      localRect2 = this.KUH;
      if (localRect2 == null) {
        p.bcb("currentRect");
      }
      localRect1.set(i + j, k + m, n - i1, localRect2.bottom - (int)getBOX_PADDING());
      this.gyB.reset();
      i = 1;
      while (i <= 2)
      {
        this.gyB.moveTo(this.cPO.left + this.cPO.width() / 3 * i, this.cPO.top);
        this.gyB.lineTo(this.cPO.left + this.cPO.width() / 3 * i, this.cPO.bottom);
        this.gyB.moveTo(this.cPO.left, this.cPO.top + this.cPO.height() / 3 * i);
        this.gyB.lineTo(this.cPO.right, this.cPO.top + this.cPO.height() / 3 * i);
        i += 1;
      }
    }
    paramCanvas.drawPath(this.gyB, this.gyG);
    paramCanvas.drawRect(this.cPO, this.gyD);
    float f1 = this.cPO.left;
    float f2 = getCORNER_WIDTH();
    float f3 = this.cPO.top;
    float f4 = getCORNER_WIDTH() / 2.0F;
    float f5 = this.cPO.left;
    paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.cPO.top - getCORNER_WIDTH() / 2.0F, this.gyH);
    f1 = this.cPO.right;
    f2 = getCORNER_LENGTH();
    f3 = getCORNER_WIDTH() / 2.0F;
    f4 = this.cPO.top;
    f5 = getCORNER_WIDTH() / 2.0F;
    float f6 = this.cPO.right;
    paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.cPO.top - getCORNER_WIDTH() / 2.0F, this.gyH);
    f1 = this.cPO.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cPO.top;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cPO.left;
    f6 = getCORNER_WIDTH() / 2.0F;
    float f7 = this.cPO.top;
    paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.gyH);
    f1 = this.cPO.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cPO.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cPO.left;
    f7 = getCORNER_WIDTH() / 2.0F;
    float f8 = this.cPO.bottom;
    paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.gyH);
    f1 = this.cPO.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cPO.top;
    f4 = this.cPO.right;
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cPO.top;
    paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.gyH);
    f1 = this.cPO.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cPO.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cPO.right;
    f7 = getCORNER_WIDTH() / 2.0F;
    f8 = this.cPO.bottom;
    paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.gyH);
    f1 = this.cPO.left;
    f2 = getCORNER_WIDTH();
    f3 = this.cPO.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cPO.left;
    f6 = getCORNER_LENGTH();
    f7 = this.cPO.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.gyH);
    f1 = this.cPO.right;
    f2 = getCORNER_LENGTH();
    f3 = this.cPO.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cPO.right;
    f6 = getCORNER_WIDTH();
    f7 = this.cPO.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.gyH);
    AppMethodBeat.o(164377);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.cAX)
    {
      this.cAX = true;
      this.gyD.setColor(-1);
      this.gyD.setStrokeWidth(getBOX_LINE_WIDTH());
      this.gyD.setStyle(Paint.Style.STROKE);
      this.gyD.setAntiAlias(true);
      this.gyG.set(this.gyD);
      this.gyG.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.gyH.set(this.gyD);
      this.gyH.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    p.h(paramRect, "rect");
    this.KUH = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BorderView
 * JD-Core Version:    0.7.0.1
 */