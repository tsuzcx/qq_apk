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
import d.k.c;
import d.k.f;
import d.k.j;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"})
public final class TextColorSelector
  extends View
{
  private final String TAG;
  private int bxN;
  private Paint paint;
  private final int ygP;
  private float ygQ;
  private int[] ygR;
  private int ygS;
  private float ygT;
  private float ygU;
  private float ygV;
  private float ygW;
  private b<? super Integer, z> ygX;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207130);
    this.TAG = "TextColorSelector";
    this.ygP = -1;
    this.paint = new Paint(1);
    this.ygR = new int[0];
    this.ygS = -1;
    this.bxN = -1;
    this.ygT = getResources().getDimension(2131166174);
    this.ygU = getResources().getDimension(2131166175);
    this.ygV = getResources().getDimension(2131166176);
    this.ygW = getResources().getDimension(2131166177);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(207130);
  }
  
  private final int ac(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207129);
    if (j.a((c)new f(0, getMeasuredHeight()), paramFloat2))
    {
      int i = Math.round((paramFloat1 - getPaddingLeft() - this.ygU) / this.ygQ);
      if ((i >= 0) && (i < this.ygR.length))
      {
        AppMethodBeat.o(207129);
        return i;
      }
    }
    AppMethodBeat.o(207129);
    return -1;
  }
  
  public final b<Integer, z> getColorSelectedCallback()
  {
    return this.ygX;
  }
  
  public final float getRadiusNormalInner()
  {
    return this.ygT;
  }
  
  public final float getRadiusNormalOuter()
  {
    return this.ygU;
  }
  
  public final float getRadiusSelectInner()
  {
    return this.ygV;
  }
  
  public final float getRadiusSelectOuter()
  {
    return this.ygW;
  }
  
  public final int getSelected()
  {
    return this.bxN;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(207127);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.ygQ = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.ygU * 2.0F) / (this.ygR.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.ygR.length;
    if (i < j)
    {
      float f2 = this.ygQ * i + this.ygU + getPaddingLeft();
      this.paint.setColor(this.ygP);
      if (i == this.bxN)
      {
        paramCanvas.drawCircle(f2, f1, this.ygW, this.paint);
        label130:
        this.paint.setColor(this.ygR[i]);
        if (i != this.bxN) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.ygV, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.ygU, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.ygT, this.paint);
      }
    }
    AppMethodBeat.o(207127);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207128);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207128);
      return true;
      this.ygS = ac(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.ygS = -1;
      continue;
      int i = ac(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.ygS))
      {
        this.bxN = i;
        paramMotionEvent = this.ygX;
        if (paramMotionEvent != null) {
          paramMotionEvent.invoke(Integer.valueOf(this.bxN));
        }
      }
      this.ygS = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(207126);
    p.h(paramArrayOfInt, "colorArray");
    this.ygR = paramArrayOfInt;
    AppMethodBeat.o(207126);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, z> paramb)
  {
    this.ygX = paramb;
  }
  
  public final void setRadiusNormalInner(float paramFloat)
  {
    this.ygT = paramFloat;
  }
  
  public final void setRadiusNormalOuter(float paramFloat)
  {
    this.ygU = paramFloat;
  }
  
  public final void setRadiusSelectInner(float paramFloat)
  {
    this.ygV = paramFloat;
  }
  
  public final void setRadiusSelectOuter(float paramFloat)
  {
    this.ygW = paramFloat;
  }
  
  public final void setSelected(int paramInt)
  {
    this.bxN = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */