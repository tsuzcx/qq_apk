package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public class MMAutoSizeTextView
  extends TextView
{
  private float JEH;
  private float JEI;
  private float uHq;
  private Paint yn;
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141851);
    init();
    AppMethodBeat.o(141851);
  }
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141850);
    init();
    AppMethodBeat.o(141850);
  }
  
  private void fCE()
  {
    AppMethodBeat.i(141854);
    this.uHq = getTextSize();
    if (this.uHq <= this.JEH) {
      this.uHq = this.JEI;
    }
    AppMethodBeat.o(141854);
  }
  
  private void gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(141853);
    ae.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      AppMethodBeat.o(141853);
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    fCE();
    float f1 = this.uHq;
    this.yn.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.JEH)
      {
        f2 = f1;
        if (this.yn.measureText(paramString) > paramInt)
        {
          f1 -= 1.0F;
          if (f1 > this.JEH) {
            break label177;
          }
          f2 = this.JEH;
        }
      }
      ae.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(this.uHq), Float.valueOf(this.yn.measureText(paramString)), Integer.valueOf(paramInt) });
      setTextSize(0, f2);
      AppMethodBeat.o(141853);
      return;
      label177:
      this.yn.setTextSize(f1);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(141852);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    this.JEH = a.fromDPToPix(getContext(), 8);
    this.JEI = a.fromDPToPix(getContext(), 22);
    this.yn = new Paint();
    this.yn.set(getPaint());
    fCE();
    AppMethodBeat.o(141852);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(141859);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(141859);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141859);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141858);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(141858);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ae.printErrStackTrace("MicroMsg.MMAutoSizeTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(141858);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141857);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(141857);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141857);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(141860);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(141860);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(141860);
    }
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141856);
    ae.w("MicroMsg.MMAutoSizeTextView", "on size changed");
    if (paramInt1 != paramInt3) {
      gD(getText().toString(), paramInt1);
    }
    AppMethodBeat.o(141856);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141855);
    ae.w("MicroMsg.MMAutoSizeTextView", "on text changed");
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    gD(paramCharSequence.toString(), getWidth());
    AppMethodBeat.o(141855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSizeTextView
 * JD-Core Version:    0.7.0.1
 */