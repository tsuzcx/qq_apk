package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.k.a;
import d.k.d;
import d.k.h;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"})
public final class TextColorSelector
  extends View
{
  private final String TAG;
  private int bxN;
  private Paint paint;
  private final int xQW;
  private float xQX;
  private int[] xQY;
  private int xQZ;
  private float xRa;
  private float xRb;
  private float xRc;
  private float xRd;
  private b<? super Integer, z> xRe;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200872);
    this.TAG = "TextColorSelector";
    this.xQW = -1;
    this.paint = new Paint(1);
    this.xQY = new int[0];
    this.xQZ = -1;
    this.bxN = -1;
    this.xRa = getResources().getDimension(2131166174);
    this.xRb = getResources().getDimension(2131166175);
    this.xRc = getResources().getDimension(2131166176);
    this.xRd = getResources().getDimension(2131166177);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(200872);
  }
  
  private final int ac(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200871);
    if (h.a((a)new d(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.xRb) / this.xQX);
      if ((i >= 0) && (i < this.xQY.length))
      {
        AppMethodBeat.o(200871);
        return i;
      }
    }
    AppMethodBeat.o(200871);
    return -1;
  }
  
  public final b<Integer, z> getColorSelectedCallback()
  {
    return this.xRe;
  }
  
  public final float getRadiusNormalInner()
  {
    return this.xRa;
  }
  
  public final float getRadiusNormalOuter()
  {
    return this.xRb;
  }
  
  public final float getRadiusSelectInner()
  {
    return this.xRc;
  }
  
  public final float getRadiusSelectOuter()
  {
    return this.xRd;
  }
  
  public final int getSelected()
  {
    return this.bxN;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200869);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.xQX = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.xRb * 2.0F) / (this.xQY.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.xQY.length;
    if (i < j)
    {
      float f2 = this.xQX * i + this.xRb + getPaddingLeft();
      this.paint.setColor(this.xQW);
      if (i == this.bxN)
      {
        paramCanvas.drawCircle(f2, f1, this.xRd, this.paint);
        label130:
        this.paint.setColor(this.xQY[i]);
        if (i != this.bxN) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.xRc, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.xRb, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.xRa, this.paint);
      }
    }
    AppMethodBeat.o(200869);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200870);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200870);
      return true;
      this.xQZ = ac(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.xQZ = -1;
      continue;
      int i = ac(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.xQZ))
      {
        this.bxN = i;
        paramMotionEvent = this.xRe;
        if (paramMotionEvent != null) {
          paramMotionEvent.invoke(Integer.valueOf(this.bxN));
        }
      }
      this.xQZ = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200868);
    p.h(paramArrayOfInt, "colorArray");
    this.xQY = paramArrayOfInt;
    AppMethodBeat.o(200868);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, z> paramb)
  {
    this.xRe = paramb;
  }
  
  public final void setRadiusNormalInner(float paramFloat)
  {
    this.xRa = paramFloat;
  }
  
  public final void setRadiusNormalOuter(float paramFloat)
  {
    this.xRb = paramFloat;
  }
  
  public final void setRadiusSelectInner(float paramFloat)
  {
    this.xRc = paramFloat;
  }
  
  public final void setRadiusSelectOuter(float paramFloat)
  {
    this.xRd = paramFloat;
  }
  
  public final void setSelected(int paramInt)
  {
    this.bxN = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */