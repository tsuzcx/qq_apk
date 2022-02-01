package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMAutoSizeTextView
  extends TextView
{
  private float IYA;
  private float adPH;
  private float adPI;
  private Paint cjv;
  
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
  
  private void iM(String paramString, int paramInt)
  {
    AppMethodBeat.i(141853);
    Log.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      AppMethodBeat.o(141853);
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    jmf();
    float f1 = this.IYA;
    this.cjv.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.adPH)
      {
        f2 = f1;
        if (this.cjv.measureText(paramString) > paramInt)
        {
          f1 -= 1.0F;
          if (f1 > this.adPH) {
            break label177;
          }
          f2 = this.adPH;
        }
      }
      Log.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(this.IYA), Float.valueOf(this.cjv.measureText(paramString)), Integer.valueOf(paramInt) });
      setTextSize(0, f2);
      AppMethodBeat.o(141853);
      return;
      label177:
      this.cjv.setTextSize(f1);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(141852);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    this.adPH = a.fromDPToPix(getContext(), 8);
    this.adPI = a.fromDPToPix(getContext(), 22);
    this.cjv = new Paint();
    this.cjv.set(getPaint());
    jmf();
    AppMethodBeat.o(141852);
  }
  
  private void jmf()
  {
    AppMethodBeat.i(141854);
    this.IYA = getTextSize();
    if (this.IYA <= this.adPH) {
      this.IYA = this.adPI;
    }
    AppMethodBeat.o(141854);
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", paramCanvas, "", new Object[0]);
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141857);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(141860);
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(141860);
    }
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141856);
    Log.w("MicroMsg.MMAutoSizeTextView", "on size changed");
    if (paramInt1 != paramInt3) {
      iM(getText().toString(), paramInt1);
    }
    AppMethodBeat.o(141856);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141855);
    Log.w("MicroMsg.MMAutoSizeTextView", "on text changed");
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    iM(paramCharSequence.toString(), getWidth());
    AppMethodBeat.o(141855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSizeTextView
 * JD-Core Version:    0.7.0.1
 */