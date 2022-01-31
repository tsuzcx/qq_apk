package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

class NetStatRuler
  extends View
{
  public NetStatRuler(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatRuler(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatRuler(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(126969);
    super.onDraw(paramCanvas);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setDither(true);
    localTextPaint.setTextSize(getContext().getResources().getDimensionPixelSize(2131427870));
    Rect localRect = new Rect();
    getDrawingRect(localRect);
    float f1 = localRect.height();
    float f2 = localRect.left + getPaddingLeft();
    float f3 = localRect.top;
    float f4 = f1 / 3.0F;
    float f5 = localRect.top;
    float f6 = 2.0F * f1 / 3.0F;
    float f7 = localRect.top;
    localTextPaint.setColor(-7829368);
    paramCanvas.drawText(bo.nV(NetStatUnit.max * 2 / 3), f2, f3 + f4, localTextPaint);
    paramCanvas.drawText(bo.nV(NetStatUnit.max / 3), f2, f5 + f6, localTextPaint);
    paramCanvas.drawText(bo.nV(0L), f2, f7 + f1, localTextPaint);
    AppMethodBeat.o(126969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatRuler
 * JD-Core Version:    0.7.0.1
 */