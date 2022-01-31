package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMAutoSizeTextView
  extends TextView
{
  private float nEE;
  private Paint oU;
  private float ziL;
  private float ziM;
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106485);
    init();
    AppMethodBeat.o(106485);
  }
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106484);
    init();
    AppMethodBeat.o(106484);
  }
  
  private void dDM()
  {
    AppMethodBeat.i(106488);
    this.nEE = getTextSize();
    if (this.nEE <= this.ziL) {
      this.nEE = this.ziM;
    }
    AppMethodBeat.o(106488);
  }
  
  private void eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(106487);
    ab.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      AppMethodBeat.o(106487);
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    dDM();
    float f1 = this.nEE;
    this.oU.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.ziL)
      {
        f2 = f1;
        if (this.oU.measureText(paramString) > paramInt)
        {
          f1 -= 1.0F;
          if (f1 > this.ziL) {
            break label177;
          }
          f2 = this.ziL;
        }
      }
      ab.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(this.nEE), Float.valueOf(this.oU.measureText(paramString)), Integer.valueOf(paramInt) });
      setTextSize(0, f2);
      AppMethodBeat.o(106487);
      return;
      label177:
      this.oU.setTextSize(f1);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(106486);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    this.ziL = a.fromDPToPix(getContext(), 8);
    this.ziM = a.fromDPToPix(getContext(), 22);
    this.oU = new Paint();
    this.oU.set(getPaint());
    dDM();
    AppMethodBeat.o(106486);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(106493);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(106493);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(106493);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106492);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(106492);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(106492);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106491);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(106491);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(106491);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(106494);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(106494);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(106494);
    }
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106490);
    ab.w("MicroMsg.MMAutoSizeTextView", "on size changed");
    if (paramInt1 != paramInt3) {
      eL(getText().toString(), paramInt1);
    }
    AppMethodBeat.o(106490);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106489);
    ab.w("MicroMsg.MMAutoSizeTextView", "on text changed");
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    eL(paramCharSequence.toString(), getWidth());
    AppMethodBeat.o(106489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSizeTextView
 * JD-Core Version:    0.7.0.1
 */