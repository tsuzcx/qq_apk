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
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.c;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"})
public final class TextColorSelector
  extends View
{
  private final int ChM;
  private float ChN;
  private int[] ChO;
  private int ChP;
  private float ChQ;
  private float ChR;
  private float ChS;
  private float ChT;
  private b<? super Integer, x> ChU;
  private final String TAG;
  private int bxP;
  private Paint paint;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237971);
    this.TAG = "TextColorSelector";
    this.ChM = -1;
    this.paint = new Paint(1);
    this.ChO = new int[0];
    this.ChP = -1;
    this.bxP = -1;
    this.ChQ = getResources().getDimension(2131166215);
    this.ChR = getResources().getDimension(2131166216);
    this.ChS = getResources().getDimension(2131166217);
    this.ChT = getResources().getDimension(2131166218);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(237971);
  }
  
  private final int ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237970);
    if (j.a((c)new f(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.ChR) / this.ChN);
      if ((i >= 0) && (i < this.ChO.length))
      {
        AppMethodBeat.o(237970);
        return i;
      }
    }
    AppMethodBeat.o(237970);
    return -1;
  }
  
  public final b<Integer, x> getColorSelectedCallback()
  {
    return this.ChU;
  }
  
  public final float getRadiusNormalInner()
  {
    return this.ChQ;
  }
  
  public final float getRadiusNormalOuter()
  {
    return this.ChR;
  }
  
  public final float getRadiusSelectInner()
  {
    return this.ChS;
  }
  
  public final float getRadiusSelectOuter()
  {
    return this.ChT;
  }
  
  public final int getSelected()
  {
    return this.bxP;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237968);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.ChN = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.ChR * 2.0F) / (this.ChO.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.ChO.length;
    if (i < j)
    {
      float f2 = this.ChN * i + this.ChR + getPaddingLeft();
      this.paint.setColor(this.ChM);
      if (i == this.bxP)
      {
        paramCanvas.drawCircle(f2, f1, this.ChT, this.paint);
        label130:
        this.paint.setColor(this.ChO[i]);
        if (i != this.bxP) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.ChS, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.ChR, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.ChQ, this.paint);
      }
    }
    AppMethodBeat.o(237968);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237969);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237969);
      return true;
      this.ChP = ah(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.ChP = -1;
      continue;
      int i = ah(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.ChP))
      {
        this.bxP = i;
        paramMotionEvent = this.ChU;
        if (paramMotionEvent != null) {
          paramMotionEvent.invoke(Integer.valueOf(this.bxP));
        }
      }
      this.ChP = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237967);
    p.h(paramArrayOfInt, "colorArray");
    this.ChO = paramArrayOfInt;
    AppMethodBeat.o(237967);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, x> paramb)
  {
    this.ChU = paramb;
  }
  
  public final void setRadiusNormalInner(float paramFloat)
  {
    this.ChQ = paramFloat;
  }
  
  public final void setRadiusNormalOuter(float paramFloat)
  {
    this.ChR = paramFloat;
  }
  
  public final void setRadiusSelectInner(float paramFloat)
  {
    this.ChS = paramFloat;
  }
  
  public final void setRadiusSelectOuter(float paramFloat)
  {
    this.ChT = paramFloat;
  }
  
  public final void setSelected(int paramInt)
  {
    this.bxP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */