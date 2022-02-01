package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;

public class MMAutoSizeTextView
  extends TextView
{
  private float JjT;
  private float JjU;
  private float uvR;
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
  
  private void fyC()
  {
    AppMethodBeat.i(141854);
    this.uvR = getTextSize();
    if (this.uvR <= this.JjT) {
      this.uvR = this.JjU;
    }
    AppMethodBeat.o(141854);
  }
  
  private void gu(String paramString, int paramInt)
  {
    AppMethodBeat.i(141853);
    ad.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      AppMethodBeat.o(141853);
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    fyC();
    float f1 = this.uvR;
    this.yn.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.JjT)
      {
        f2 = f1;
        if (this.yn.measureText(paramString) > paramInt)
        {
          f1 -= 1.0F;
          if (f1 > this.JjT) {
            break label177;
          }
          f2 = this.JjT;
        }
      }
      ad.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(this.uvR), Float.valueOf(this.yn.measureText(paramString)), Integer.valueOf(paramInt) });
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
    this.JjT = a.fromDPToPix(getContext(), 8);
    this.JjU = a.fromDPToPix(getContext(), 22);
    this.yn = new Paint();
    this.yn.set(getPaint());
    fyC();
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
      ad.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
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
      ad.printErrStackTrace("MicroMsg.MMAutoSizeTextView", paramCanvas, "", new Object[0]);
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
      ad.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
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
    ad.w("MicroMsg.MMAutoSizeTextView", "on size changed");
    if (paramInt1 != paramInt3) {
      gu(getText().toString(), paramInt1);
    }
    AppMethodBeat.o(141856);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141855);
    ad.w("MicroMsg.MMAutoSizeTextView", "on text changed");
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    gu(paramCharSequence.toString(), getWidth());
    AppMethodBeat.o(141855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSizeTextView
 * JD-Core Version:    0.7.0.1
 */