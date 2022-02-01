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
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView
  extends View
{
  private Rect Jdz;
  private Rect cEJ;
  private boolean cqf;
  private final Path geR;
  private final Paint geT;
  private final Paint geW;
  private final Paint geX;
  private Rect kK;
  private final f wyG;
  private final f wyH;
  private final f wyI;
  private final f wyK;
  private final f wyL;
  
  static
  {
    AppMethodBeat.i(164369);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(BorderView.class), "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH()F")), (d.l.k)w.a(new u(w.bn(BorderView.class), "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH()F")), (d.l.k)w.a(new u(w.bn(BorderView.class), "CORNER_WIDTH", "getCORNER_WIDTH()F")), (d.l.k)w.a(new u(w.bn(BorderView.class), "BOX_PADDING", "getBOX_PADDING()F")), (d.l.k)w.a(new u(w.bn(BorderView.class), "CORNER_LENGTH", "getCORNER_LENGTH()F")) };
    AppMethodBeat.o(164369);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.wyG = g.K((a)new b(this));
    this.wyH = g.K((a)new a(this));
    this.wyI = g.K((a)new e(this));
    this.wyK = g.K((a)new c(this));
    this.wyL = g.K((a)new d(this));
    this.geR = new Path();
    this.geT = new Paint();
    this.geW = new Paint();
    this.geX = new Paint();
    this.cEJ = new Rect();
    this.kK = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.wyG = g.K((a)new b(this));
    this.wyH = g.K((a)new a(this));
    this.wyI = g.K((a)new e(this));
    this.wyK = g.K((a)new c(this));
    this.wyL = g.K((a)new d(this));
    this.geR = new Path();
    this.geT = new Paint();
    this.geW = new Paint();
    this.geX = new Paint();
    this.cEJ = new Rect();
    this.kK = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.wyH.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.wyG.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.wyK.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.wyL.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.wyI.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164377);
    d.g.b.k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.Jdz;
    if (localRect1 == null) {
      d.g.b.k.aVY("currentRect");
    }
    if (!localRect1.equals(this.kK))
    {
      localRect1 = this.kK;
      Rect localRect2 = this.Jdz;
      if (localRect2 == null) {
        d.g.b.k.aVY("currentRect");
      }
      localRect1.set(localRect2);
      localRect1 = this.cEJ;
      localRect2 = this.Jdz;
      if (localRect2 == null) {
        d.g.b.k.aVY("currentRect");
      }
      int i = localRect2.left;
      int j = (int)getBOX_PADDING();
      localRect2 = this.Jdz;
      if (localRect2 == null) {
        d.g.b.k.aVY("currentRect");
      }
      int k = localRect2.top;
      int m = (int)getBOX_PADDING();
      localRect2 = this.Jdz;
      if (localRect2 == null) {
        d.g.b.k.aVY("currentRect");
      }
      int n = localRect2.right;
      int i1 = (int)getBOX_PADDING();
      localRect2 = this.Jdz;
      if (localRect2 == null) {
        d.g.b.k.aVY("currentRect");
      }
      localRect1.set(i + j, k + m, n - i1, localRect2.bottom - (int)getBOX_PADDING());
      this.geR.reset();
      i = 1;
      while (i <= 2)
      {
        this.geR.moveTo(this.cEJ.left + this.cEJ.width() / 3 * i, this.cEJ.top);
        this.geR.lineTo(this.cEJ.left + this.cEJ.width() / 3 * i, this.cEJ.bottom);
        this.geR.moveTo(this.cEJ.left, this.cEJ.top + this.cEJ.height() / 3 * i);
        this.geR.lineTo(this.cEJ.right, this.cEJ.top + this.cEJ.height() / 3 * i);
        i += 1;
      }
    }
    paramCanvas.drawPath(this.geR, this.geW);
    paramCanvas.drawRect(this.cEJ, this.geT);
    float f1 = this.cEJ.left;
    float f2 = getCORNER_WIDTH();
    float f3 = this.cEJ.top;
    float f4 = getCORNER_WIDTH() / 2.0F;
    float f5 = this.cEJ.left;
    paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.cEJ.top - getCORNER_WIDTH() / 2.0F, this.geX);
    f1 = this.cEJ.right;
    f2 = getCORNER_LENGTH();
    f3 = getCORNER_WIDTH() / 2.0F;
    f4 = this.cEJ.top;
    f5 = getCORNER_WIDTH() / 2.0F;
    float f6 = this.cEJ.right;
    paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.cEJ.top - getCORNER_WIDTH() / 2.0F, this.geX);
    f1 = this.cEJ.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cEJ.top;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cEJ.left;
    f6 = getCORNER_WIDTH() / 2.0F;
    float f7 = this.cEJ.top;
    paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.geX);
    f1 = this.cEJ.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cEJ.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cEJ.left;
    f7 = getCORNER_WIDTH() / 2.0F;
    float f8 = this.cEJ.bottom;
    paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.geX);
    f1 = this.cEJ.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cEJ.top;
    f4 = this.cEJ.right;
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cEJ.top;
    paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.geX);
    f1 = this.cEJ.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cEJ.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cEJ.right;
    f7 = getCORNER_WIDTH() / 2.0F;
    f8 = this.cEJ.bottom;
    paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.geX);
    f1 = this.cEJ.left;
    f2 = getCORNER_WIDTH();
    f3 = this.cEJ.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cEJ.left;
    f6 = getCORNER_LENGTH();
    f7 = this.cEJ.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.geX);
    f1 = this.cEJ.right;
    f2 = getCORNER_LENGTH();
    f3 = this.cEJ.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cEJ.right;
    f6 = getCORNER_WIDTH();
    f7 = this.cEJ.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.geX);
    AppMethodBeat.o(164377);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.cqf)
    {
      this.cqf = true;
      this.geT.setColor(-1);
      this.geT.setStrokeWidth(getBOX_LINE_WIDTH());
      this.geT.setStyle(Paint.Style.STROKE);
      this.geT.setAntiAlias(true);
      this.geW.set(this.geT);
      this.geW.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.geX.set(this.geT);
      this.geX.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    d.g.b.k.h(paramRect, "rect");
    this.Jdz = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Float>
  {
    e(BorderView paramBorderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BorderView
 * JD-Core Version:    0.7.0.1
 */