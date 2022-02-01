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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView
  extends View
{
  private final f BYE;
  private final f BYF;
  private final f BYG;
  private final f BYI;
  private final f BYJ;
  private Rect QLX;
  private Rect dgS;
  private final Path hnX;
  private final Paint hnZ;
  private final Paint hoc;
  private final Paint hod;
  private boolean isInit;
  private Rect mC;
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164378);
    this.BYE = g.ah((a)new b(this));
    this.BYF = g.ah((a)new a(this));
    this.BYG = g.ah((a)new e(this));
    this.BYI = g.ah((a)new c(this));
    this.BYJ = g.ah((a)new d(this));
    this.hnX = new Path();
    this.hnZ = new Paint();
    this.hoc = new Paint();
    this.hod = new Paint();
    this.dgS = new Rect();
    this.mC = new Rect();
    AppMethodBeat.o(164378);
  }
  
  public BorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164379);
    this.BYE = g.ah((a)new b(this));
    this.BYF = g.ah((a)new a(this));
    this.BYG = g.ah((a)new e(this));
    this.BYI = g.ah((a)new c(this));
    this.BYJ = g.ah((a)new d(this));
    this.hnX = new Path();
    this.hnZ = new Paint();
    this.hoc = new Paint();
    this.hod = new Paint();
    this.dgS = new Rect();
    this.mC = new Rect();
    AppMethodBeat.o(164379);
  }
  
  private final float getBOX_GIRD_WIDTH()
  {
    AppMethodBeat.i(164371);
    float f = ((Number)this.BYF.getValue()).floatValue();
    AppMethodBeat.o(164371);
    return f;
  }
  
  private final float getBOX_LINE_WIDTH()
  {
    AppMethodBeat.i(164370);
    float f = ((Number)this.BYE.getValue()).floatValue();
    AppMethodBeat.o(164370);
    return f;
  }
  
  private final float getBOX_PADDING()
  {
    AppMethodBeat.i(164373);
    float f = ((Number)this.BYI.getValue()).floatValue();
    AppMethodBeat.o(164373);
    return f;
  }
  
  private final float getCORNER_LENGTH()
  {
    AppMethodBeat.i(164374);
    float f = ((Number)this.BYJ.getValue()).floatValue();
    AppMethodBeat.o(164374);
    return f;
  }
  
  private final float getCORNER_WIDTH()
  {
    AppMethodBeat.i(164372);
    float f = ((Number)this.BYG.getValue()).floatValue();
    AppMethodBeat.o(164372);
    return f;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164377);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Rect localRect1 = this.QLX;
    if (localRect1 == null) {
      p.btv("currentRect");
    }
    if (!localRect1.equals(this.mC))
    {
      localRect1 = this.mC;
      Rect localRect2 = this.QLX;
      if (localRect2 == null) {
        p.btv("currentRect");
      }
      localRect1.set(localRect2);
      localRect1 = this.dgS;
      localRect2 = this.QLX;
      if (localRect2 == null) {
        p.btv("currentRect");
      }
      int i = localRect2.left;
      int j = (int)getBOX_PADDING();
      localRect2 = this.QLX;
      if (localRect2 == null) {
        p.btv("currentRect");
      }
      int k = localRect2.top;
      int m = (int)getBOX_PADDING();
      localRect2 = this.QLX;
      if (localRect2 == null) {
        p.btv("currentRect");
      }
      int n = localRect2.right;
      int i1 = (int)getBOX_PADDING();
      localRect2 = this.QLX;
      if (localRect2 == null) {
        p.btv("currentRect");
      }
      localRect1.set(i + j, k + m, n - i1, localRect2.bottom - (int)getBOX_PADDING());
      this.hnX.reset();
      i = 1;
      while (i <= 2)
      {
        this.hnX.moveTo(this.dgS.left + this.dgS.width() / 3 * i, this.dgS.top);
        this.hnX.lineTo(this.dgS.left + this.dgS.width() / 3 * i, this.dgS.bottom);
        this.hnX.moveTo(this.dgS.left, this.dgS.top + this.dgS.height() / 3 * i);
        this.hnX.lineTo(this.dgS.right, this.dgS.top + this.dgS.height() / 3 * i);
        i += 1;
      }
    }
    paramCanvas.drawPath(this.hnX, this.hoc);
    paramCanvas.drawRect(this.dgS, this.hnZ);
    float f1 = this.dgS.left;
    float f2 = getCORNER_WIDTH();
    float f3 = this.dgS.top;
    float f4 = getCORNER_WIDTH() / 2.0F;
    float f5 = this.dgS.left;
    paramCanvas.drawLine(f1 - f2, f3 - f4, getCORNER_LENGTH() + f5, this.dgS.top - getCORNER_WIDTH() / 2.0F, this.hod);
    f1 = this.dgS.right;
    f2 = getCORNER_LENGTH();
    f3 = getCORNER_WIDTH() / 2.0F;
    f4 = this.dgS.top;
    f5 = getCORNER_WIDTH() / 2.0F;
    float f6 = this.dgS.right;
    paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, getCORNER_WIDTH() + f6, this.dgS.top - getCORNER_WIDTH() / 2.0F, this.hod);
    f1 = this.dgS.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.dgS.top;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.dgS.left;
    f6 = getCORNER_WIDTH() / 2.0F;
    float f7 = this.dgS.top;
    paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, getCORNER_LENGTH() + f7, this.hod);
    f1 = this.dgS.left;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.dgS.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.dgS.left;
    f7 = getCORNER_WIDTH() / 2.0F;
    float f8 = this.dgS.bottom;
    paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, getCORNER_WIDTH() / 2.0F + f8, this.hod);
    f1 = this.dgS.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.dgS.top;
    f4 = this.dgS.right;
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.dgS.top;
    paramCanvas.drawLine(f2 + f1, f3, f5 + f4, getCORNER_LENGTH() + f6, this.hod);
    f1 = this.dgS.right;
    f2 = getCORNER_WIDTH() / 2.0F;
    f3 = this.dgS.bottom;
    f4 = getCORNER_LENGTH();
    f5 = getCORNER_WIDTH() / 2.0F;
    f6 = this.dgS.right;
    f7 = getCORNER_WIDTH() / 2.0F;
    f8 = this.dgS.bottom;
    paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, getCORNER_WIDTH() / 2.0F + f8, this.hod);
    f1 = this.dgS.left;
    f2 = getCORNER_WIDTH();
    f3 = this.dgS.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.dgS.left;
    f6 = getCORNER_LENGTH();
    f7 = this.dgS.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.hod);
    f1 = this.dgS.right;
    f2 = getCORNER_LENGTH();
    f3 = this.dgS.bottom;
    f4 = getCORNER_WIDTH() / 2.0F;
    f5 = this.dgS.right;
    f6 = getCORNER_WIDTH();
    f7 = this.dgS.bottom;
    paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, getCORNER_WIDTH() / 2.0F + f7, this.hod);
    AppMethodBeat.o(164377);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164375);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.isInit)
    {
      this.isInit = true;
      this.hnZ.setColor(-1);
      this.hnZ.setStrokeWidth(getBOX_LINE_WIDTH());
      this.hnZ.setStyle(Paint.Style.STROKE);
      this.hnZ.setAntiAlias(true);
      this.hoc.set(this.hnZ);
      this.hoc.setStrokeWidth(getBOX_GIRD_WIDTH());
      this.hod.set(this.hnZ);
      this.hod.setStrokeWidth(getCORNER_WIDTH());
    }
    AppMethodBeat.o(164375);
  }
  
  public final void setBorderRect(Rect paramRect)
  {
    AppMethodBeat.i(164376);
    p.h(paramRect, "rect");
    this.QLX = paramRect;
    AppMethodBeat.o(164376);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    a(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    b(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    c(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Float>
  {
    d(BorderView paramBorderView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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