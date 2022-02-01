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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextColorSelector
  extends View
{
  private int[] OaP;
  private b<? super Integer, ah> OaT;
  private final int Obb;
  private float Obc;
  private int Obd;
  private float Obe;
  private float Obf;
  private float Obg;
  private float Obh;
  private final String TAG;
  private int dbk;
  private Paint paint;
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280009);
    this.TAG = "TextColorSelector";
    this.Obb = -1;
    this.paint = new Paint(1);
    this.OaP = new int[0];
    this.Obd = -1;
    this.dbk = -1;
    this.Obe = getResources().getDimension(a.a.editor_color_dot_inner_radius);
    this.Obf = getResources().getDimension(a.a.editor_color_dot_outer_radius);
    this.Obg = getResources().getDimension(a.a.editor_color_dot_select_inner_radius);
    this.Obh = getResources().getDimension(a.a.editor_color_dot_select_outer_radius);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(280009);
  }
  
  private final int aO(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    AppMethodBeat.i(280020);
    int k = getMeasuredHeight();
    int m = (int)paramFloat2;
    int i = j;
    if (m >= 0)
    {
      i = j;
      if (m <= k) {
        i = 1;
      }
    }
    if (i != 0)
    {
      i = Math.round((paramFloat1 - getPaddingLeft() - this.Obf) / this.Obc);
      if ((i >= 0) && (i < this.OaP.length))
      {
        AppMethodBeat.o(280020);
        return i;
      }
    }
    AppMethodBeat.o(280020);
    return -1;
  }
  
  public final b<Integer, ah> getColorSelectedCallback()
  {
    return this.OaT;
  }
  
  public final float getRadiusNormalInner()
  {
    return this.Obe;
  }
  
  public final float getRadiusNormalOuter()
  {
    return this.Obf;
  }
  
  public final float getRadiusSelectInner()
  {
    return this.Obg;
  }
  
  public final float getRadiusSelectOuter()
  {
    return this.Obh;
  }
  
  public final int getSelected()
  {
    return this.dbk;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280080);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.Obc = ((getWidth() - getPaddingLeft() - getPaddingRight() - this.Obf * 2.0F) / (this.OaP.length - 1));
    float f1 = getHeight() / 2.0F;
    int i = 0;
    int k = this.OaP.length - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      float f2 = this.Obc * i + this.Obf + getPaddingLeft();
      this.paint.setColor(this.Obb);
      if (i == this.dbk)
      {
        paramCanvas.drawCircle(f2, f1, this.Obh, this.paint);
        this.paint.setColor(this.OaP[i]);
        if (i != this.dbk) {
          break label203;
        }
        paramCanvas.drawCircle(f2, f1, this.Obg, this.paint);
      }
      for (;;)
      {
        if (j <= k) {
          break label220;
        }
        AppMethodBeat.o(280080);
        return;
        paramCanvas.drawCircle(f2, f1, this.Obf, this.paint);
        break;
        label203:
        paramCanvas.drawCircle(f2, f1, this.Obe, this.paint);
      }
      label220:
      i = j;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280093);
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(280093);
      return true;
      this.Obd = aO(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.Obd = -1;
      continue;
      int i = aO(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i >= 0) && (i == this.Obd))
      {
        this.dbk = i;
        paramMotionEvent = this.OaT;
        if (paramMotionEvent != null) {
          paramMotionEvent.invoke(Integer.valueOf(this.dbk));
        }
      }
      this.Obd = -1;
      postInvalidate();
    }
  }
  
  public final void setColorList(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280055);
    s.u(paramArrayOfInt, "colorArray");
    this.OaP = paramArrayOfInt;
    AppMethodBeat.o(280055);
  }
  
  public final void setColorSelectedCallback(b<? super Integer, ah> paramb)
  {
    this.OaT = paramb;
  }
  
  public final void setRadiusNormalInner(float paramFloat)
  {
    this.Obe = paramFloat;
  }
  
  public final void setRadiusNormalOuter(float paramFloat)
  {
    this.Obf = paramFloat;
  }
  
  public final void setRadiusSelectInner(float paramFloat)
  {
    this.Obg = paramFloat;
  }
  
  public final void setRadiusSelectOuter(float paramFloat)
  {
    this.Obh = paramFloat;
  }
  
  public final void setSelected(int paramInt)
  {
    this.dbk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector
 * JD-Core Version:    0.7.0.1
 */