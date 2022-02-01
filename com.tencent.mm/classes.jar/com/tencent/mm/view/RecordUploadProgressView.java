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
import com.tencent.mm.plugin.selectcontact.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RecordUploadProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backColor", "", "getBackColor", "()I", "setBackColor", "(I)V", "foreColor", "getForeColor", "setForeColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "progress", "getProgress", "setProgress", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "ui-selectcontact_release"})
public final class RecordUploadProgressView
  extends View
{
  private int AZF;
  private int AZG;
  public Paint paint;
  private int progress;
  
  public RecordUploadProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187219);
    this.paint = new Paint();
    paramContext = this.paint;
    if (paramContext == null) {
      p.bGy("paint");
    }
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext = this.paint;
    if (paramContext == null) {
      p.bGy("paint");
    }
    paramContext.setStrokeWidth(getResources().getDimension(a.c.select_record_0_25_A));
    paramContext = this.paint;
    if (paramContext == null) {
      p.bGy("paint");
    }
    paramContext.setAntiAlias(true);
    this.AZF = getResources().getColor(a.b.BW_0_Alpha_0_1);
    this.AZG = getResources().getColor(a.b.Brand_100);
    AppMethodBeat.o(187219);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(187217);
    super.draw(paramCanvas);
    int i = getWidth() / 2;
    Object localObject = this.paint;
    if (localObject == null) {
      p.bGy("paint");
    }
    float f1 = ((Paint)localObject).getStrokeWidth();
    int j = (int)(i - f1 / 2.0F);
    localObject = this.paint;
    if (localObject == null) {
      p.bGy("paint");
    }
    ((Paint)localObject).setColor(this.AZF);
    localObject = this.paint;
    if (localObject == null) {
      p.bGy("paint");
    }
    ((Paint)localObject).setAntiAlias(true);
    localObject = this.paint;
    if (localObject == null) {
      p.bGy("paint");
    }
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (paramCanvas != null)
    {
      f1 = i;
      float f2 = i;
      float f3 = j;
      localObject = this.paint;
      if (localObject == null) {
        p.bGy("paint");
      }
      paramCanvas.drawCircle(f1, f2, f3, (Paint)localObject);
    }
    localObject = this.paint;
    if (localObject == null) {
      p.bGy("paint");
    }
    ((Paint)localObject).setColor(this.AZG);
    localObject = new RectF(i - j, i - j, i + j, i + j);
    f1 = this.progress * 360 / 100.0F;
    if (paramCanvas != null)
    {
      Paint localPaint = this.paint;
      if (localPaint == null) {
        p.bGy("paint");
      }
      paramCanvas.drawArc((RectF)localObject, -90.0F, f1, false, localPaint);
      AppMethodBeat.o(187217);
      return;
    }
    AppMethodBeat.o(187217);
  }
  
  public final int getBackColor()
  {
    return this.AZF;
  }
  
  public final int getForeColor()
  {
    return this.AZG;
  }
  
  public final Paint getPaint()
  {
    AppMethodBeat.i(187190);
    Paint localPaint = this.paint;
    if (localPaint == null) {
      p.bGy("paint");
    }
    AppMethodBeat.o(187190);
    return localPaint;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final void setBackColor(int paramInt)
  {
    this.AZF = paramInt;
  }
  
  public final void setForeColor(int paramInt)
  {
    this.AZG = paramInt;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(187193);
    p.k(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(187193);
  }
  
  public final void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.RecordUploadProgressView
 * JD-Core Version:    0.7.0.1
 */