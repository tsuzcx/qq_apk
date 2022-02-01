package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.sdk.platformtools.Util;

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
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(73898);
    super.onDraw(paramCanvas);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setDither(true);
    localTextPaint.setTextSize(getContext().getResources().getDimensionPixelSize(b.d.TinierTextSize));
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
    paramCanvas.drawText(Util.getSizeMB(NetStatUnit.max * 2L / 3L), f2, f3 + f4, localTextPaint);
    paramCanvas.drawText(Util.getSizeMB(NetStatUnit.max / 3L), f2, f5 + f6, localTextPaint);
    paramCanvas.drawText(Util.getSizeMB(0L), f2, f7 + f1, localTextPaint);
    AppMethodBeat.o(73898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatRuler
 * JD-Core Version:    0.7.0.1
 */