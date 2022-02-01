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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView
  extends View
{
  private Rect HDd;
  private Rect cHB;
  private boolean csX;
  private final Path gak;
  private final Paint gam;
  private final Paint gaq;
  private final Paint gar;
  private Rect jL;
  private final f rFs;
  private final f rFt;
  private final f rFu;
  private final f rFw;
  private final f rFx;
  
  static
  {
    AppMethodBeat.i(164369);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(BorderView.class), "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH()F")), (d.l.k)w.a(new u(w.bk(BorderView.class), "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH()F")), (d.l.k)w.a(new u(w.bk(BorderView.class), "CORNER_WIDTH", "getCORNER_WIDTH()F")), (d.l.k)w.a(new u(w.bk(BorderView.class), "BOX_PADDING", "getBOX_PADDING()F")), (d.l.k)w.a(new u(w.bk(BorderView.class), "CORNER_LENGTH", "getCORNER_LENGTH()F")) };
    AppMethodBeat.o(164369);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.rFs = g.E((a)new b(this));
    this.rFt = g.E((a)new a(this));
    this.rFu = g.E((a)new e(this));
    this.rFw = g.E((a)new c(this));
    this.rFx = g.E((a)new d(this));
    this.gak = new Path();
    this.gam = new Paint();
    this.gaq = new Paint();
    this.gar = new Paint();
    this.cHB = new Rect();
    this.jL = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.rFs = g.E((a)new b(this));
    this.rFt = g.E((a)new a(this));
    this.rFu = g.E((a)new e(this));
    this.rFw = g.E((a)new c(this));
    this.rFx = g.E((a)new d(this));
    this.gak = new Path();
    this.gam = new Paint();
    this.gaq = new Paint();
    this.gar = new Paint();
    this.cHB = new Rect();
    this.jL = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.rFt.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.rFs.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.rFw.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.rFx.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.rFu.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164377);
    d.g.b.k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.HDd;
    if (localRect1 == null) {
      d.g.b.k.aPZ("currentRect");
    }
    if (!localRect1.equals(this.jL))
    {
      localRect1 = this.jL;
      Rect localRect2 = this.HDd;
      if (localRect2 == null) {
        d.g.b.k.aPZ("currentRect");
      }
      localRect1.set(localRect2);
      localRect1 = this.cHB;
      localRect2 = this.HDd;
      if (localRect2 == null) {
        d.g.b.k.aPZ("currentRect");
      }
      int i = localRect2.left;
      int j = (int)getBOX_PADDING();
      localRect2 = this.HDd;
      if (localRect2 == null) {
        d.g.b.k.aPZ("currentRect");
      }
      int k = localRect2.top;
      int m = (int)getBOX_PADDING();
      localRect2 = this.HDd;
      if (localRect2 == null) {
        d.g.b.k.aPZ("currentRect");
      }
      int n = localRect2.right;
      int i1 = (int)getBOX_PADDING();
      localRect2 = this.HDd;
      if (localRect2 == null) {
        d.g.b.k.aPZ("currentRect");
      }
      localRect1.set(i + j, k + m, n - i1, localRect2.bottom - (int)getBOX_PADDING());
      this.gak.reset();
      i = 1;
      while (i <= 2)
      {
        this.gak.moveTo(this.cHB.left + this.cHB.width() / 3 * i, this.cHB.top);
        this.gak.lineTo(this.cHB.left + this.cHB.width() / 3 * i, this.cHB.bottom);
        this.gak.moveTo(this.cHB.left, this.cHB.top + this.cHB.height() / 3 * i);
        this.gak.lineTo(this.cHB.right, this.cHB.top + this.cHB.height() / 3 * i);
        i += 1;
      }
    }
    paramCanvas.drawPath(this.gak, this.gaq);
    paramCanvas.drawRect(this.cHB, this.gam);
    float f1 = this.cHB.left;
    float f2 = getCORNER_WIDTH();
    float f3 = this.cHB.top;
    float f4 = getCORNER_WIDTH() / 2.0F;
    float f5 = this.cHB.left;
    paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.cHB.top - getCORNER_WIDTH() / 2.0F, this.gar);
    f1 = this.cHB.right;
    f2 = getCORNER_LENGTH();
    f3 = getCORNER_WIDTH() / 2.0F;
    f4 = this.cHB.top;
    f5 = getCORNER_WIDTH() / 2.0F;
    float f6 = this.cHB.right;
    paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.cHB.top - getCORNER_WIDTH() / 2.0F, this.gar);
    f1 = this.cHB.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cHB.top;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cHB.left;
    f6 = getCORNER_WIDTH() / 2.0F;
    float f7 = this.cHB.top;
    paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.gar);
    f1 = this.cHB.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cHB.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cHB.left;
    f7 = getCORNER_WIDTH() / 2.0F;
    float f8 = this.cHB.bottom;
    paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.gar);
    f1 = this.cHB.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cHB.top;
    f4 = this.cHB.right;
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cHB.top;
    paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.gar);
    f1 = this.cHB.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.cHB.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.cHB.right;
    f7 = getCORNER_WIDTH() / 2.0F;
    f8 = this.cHB.bottom;
    paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.gar);
    f1 = this.cHB.left;
    f2 = getCORNER_WIDTH();
    f3 = this.cHB.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cHB.left;
    f6 = getCORNER_LENGTH();
    f7 = this.cHB.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.gar);
    f1 = this.cHB.right;
    f2 = getCORNER_LENGTH();
    f3 = this.cHB.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.cHB.right;
    f6 = getCORNER_WIDTH();
    f7 = this.cHB.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.gar);
    AppMethodBeat.o(164377);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.csX)
    {
      this.csX = true;
      this.gam.setColor(-1);
      this.gam.setStrokeWidth(getBOX_LINE_WIDTH());
      this.gam.setStyle(Paint.Style.STROKE);
      this.gam.setAntiAlias(true);
      this.gaq.set(this.gam);
      this.gaq.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.gar.set(this.gam);
      this.gar.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    d.g.b.k.h(paramRect, "rect");
    this.HDd = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.BorderView
 * JD-Core Version:    0.7.0.1
 */