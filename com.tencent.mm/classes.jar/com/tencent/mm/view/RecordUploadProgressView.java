package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/RecordUploadProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backColor", "", "getBackColor", "()I", "setBackColor", "(I)V", "foreColor", "getForeColor", "setForeColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "progress", "getProgress", "setProgress", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "ui-selectcontact_release"})
public final class RecordUploadProgressView
  extends View
{
  public Paint paint;
  private int progress;
  private int sVo;
  private int sVp;
  
  public RecordUploadProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219080);
    this.paint = new Paint();
    paramContext = this.paint;
    if (paramContext == null) {
      p.bcb("paint");
    }
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext = this.paint;
    if (paramContext == null) {
      p.bcb("paint");
    }
    paramContext.setStrokeWidth(getResources().getDimension(2131167072));
    paramContext = this.paint;
    if (paramContext == null) {
      p.bcb("paint");
    }
    paramContext.setAntiAlias(true);
    this.sVo = getResources().getColor(2131099656);
    this.sVp = getResources().getColor(2131099700);
    AppMethodBeat.o(219080);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(219079);
    super.draw(paramCanvas);
    int i = getWidth() / 2;
    Object localObject = this.paint;
    if (localObject == null) {
      p.bcb("paint");
    }
    float f1 = ((Paint)localObject).getStrokeWidth();
    int j = (int)(i - f1 / 2.0F);
    localObject = this.paint;
    if (localObject == null) {
      p.bcb("paint");
    }
    ((Paint)localObject).setColor(this.sVo);
    localObject = this.paint;
    if (localObject == null) {
      p.bcb("paint");
    }
    ((Paint)localObject).setAntiAlias(true);
    localObject = this.paint;
    if (localObject == null) {
      p.bcb("paint");
    }
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (paramCanvas != null)
    {
      f1 = i;
      float f2 = i;
      float f3 = j;
      localObject = this.paint;
      if (localObject == null) {
        p.bcb("paint");
      }
      paramCanvas.drawCircle(f1, f2, f3, (Paint)localObject);
    }
    localObject = this.paint;
    if (localObject == null) {
      p.bcb("paint");
    }
    ((Paint)localObject).setColor(this.sVp);
    localObject = new RectF(i - j, i - j, i + j, i + j);
    f1 = this.progress * 360 / 100.0F;
    if (paramCanvas != null)
    {
      Paint localPaint = this.paint;
      if (localPaint == null) {
        p.bcb("paint");
      }
      paramCanvas.drawArc((RectF)localObject, -90.0F, f1, false, localPaint);
      AppMethodBeat.o(219079);
      return;
    }
    AppMethodBeat.o(219079);
  }
  
  public final int getBackColor()
  {
    return this.sVo;
  }
  
  public final int getForeColor()
  {
    return this.sVp;
  }
  
  public final Paint getPaint()
  {
    AppMethodBeat.i(219077);
    Paint localPaint = this.paint;
    if (localPaint == null) {
      p.bcb("paint");
    }
    AppMethodBeat.o(219077);
    return localPaint;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final void setBackColor(int paramInt)
  {
    this.sVo = paramInt;
  }
  
  public final void setForeColor(int paramInt)
  {
    this.sVp = paramInt;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(219078);
    p.h(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(219078);
  }
  
  public final void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.RecordUploadProgressView
 * JD-Core Version:    0.7.0.1
 */