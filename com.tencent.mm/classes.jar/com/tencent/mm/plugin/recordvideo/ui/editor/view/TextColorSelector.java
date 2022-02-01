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
import com.tencent.mm.plugin.t.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"})
public final class TextColorSelector
  extends View
{
  private final int IeC;
  private float IeD;
  private int[] IeE;
  private int IeF;
  private float IeG;
  private float IeH;
  private float IeI;
  private float IeJ;
  private b<? super Integer, x> IeK;
  private final String TAG;
  private int bhr;
  private Paint paint;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(225950);
    this.TAG = "TextColorSelector";
    this.IeC = -1;
    this.paint = new Paint(1);
    this.IeE = new int[0];
    this.IeF = -1;
    this.bhr = -1;
    this.IeG = getResources().getDimension(a.a.editor_color_dot_inner_radius);
    this.IeH = getResources().getDimension(a.a.editor_color_dot_outer_radius);
    this.IeI = getResources().getDimension(a.a.editor_color_dot_select_inner_radius);
    this.IeJ = getResources().getDimension(a.a.editor_color_dot_select_outer_radius);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(225950);
  }
  
  private final int aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225945);
    int i = getMeasuredHeight();
    int j = (int)paramFloat2;
    if (j < 0) {}
    do
    {
      do
      {
        AppMethodBeat.o(225945);
        return -1;
      } while (i < j);
      i = Math.round((paramFloat1 - getPaddingLeft() - this.IeH) / this.IeD);
    } while ((i < 0) || (i >= this.IeE.length));
    AppMethodBeat.o(225945);
    return i;
  }
  
  public final b<Integer, x> getColorSelectedCallback()
  {
    return this.IeK;
  }
  
  public final float getRadiusNormalInner()
  {
    return this.IeG;
  }
  
  public final float getRadiusNormalOuter()
  {
    return this.IeH;
  }
  
  public final float getRadiusSelectInner()
  {
    return this.IeI;
  }
  
  public final float getRadiusSelectOuter()
  {
    return this.IeJ;
  }
  
  public final int getSelected()
  {
    return this.bhr;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225939);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.IeD = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.IeH * 2.0F) / (this.IeE.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int j = this.IeE.length;
    if (i < j)
    {
      float f2 = this.IeD * i + this.IeH + getPaddingLeft();
      this.paint.setColor(this.IeC);
      if (i == this.bhr)
      {
        paramCanvas.drawCircle(f2, f1, this.IeJ, this.paint);
        label130:
        this.paint.setColor(this.IeE[i]);
        if (i != this.bhr) {
          break label193;
        }
        paramCanvas.drawCircle(f2, f1, this.IeI, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(f2, f1, this.IeH, this.paint);
        break label130;
        label193:
        paramCanvas.drawCircle(f2, f1, this.IeG, this.paint);
      }
    }
    AppMethodBeat.o(225939);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225942);
    p.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225942);
      return true;
      this.IeF = aj(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.IeF = -1;
      continue;
      int i = aj(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.IeF))
      {
        this.bhr = i;
        paramMotionEvent = this.IeK;
        if (paramMotionEvent != null) {
          paramMotionEvent.invoke(Integer.valueOf(this.bhr));
        }
      }
      this.IeF = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225932);
    p.k(paramArrayOfInt, "colorArray");
    this.IeE = paramArrayOfInt;
    AppMethodBeat.o(225932);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, x> paramb)
  {
    this.IeK = paramb;
  }
  
  public final void setRadiusNormalInner(float paramFloat)
  {
    this.IeG = paramFloat;
  }
  
  public final void setRadiusNormalOuter(float paramFloat)
  {
    this.IeH = paramFloat;
  }
  
  public final void setRadiusSelectInner(float paramFloat)
  {
    this.IeI = paramFloat;
  }
  
  public final void setRadiusSelectOuter(float paramFloat)
  {
    this.IeJ = paramFloat;
  }
  
  public final void setSelected(int paramInt)
  {
    this.bhr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */