package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMTruncTextView
  extends TextView
{
  private boolean Qvi = false;
  private boolean Qvj = false;
  
  public MMTruncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMTruncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(143196);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(143196);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(143196);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143195);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(143195);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(143195);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143192);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.Qvi)
    {
      AppMethodBeat.o(143192);
      return;
    }
    CharSequence localCharSequence = getText();
    if (!(localCharSequence instanceof Spanned))
    {
      AppMethodBeat.o(143192);
      return;
    }
    this.Qvj = true;
    setText(TextUtils.ellipsize(localCharSequence, getPaint(), getWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
    this.Qvj = false;
    AppMethodBeat.o(143192);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143194);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(143194);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(143194);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(143197);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(143197);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(143197);
    }
    return true;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143193);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.Qvj) {}
    for (boolean bool = true;; bool = false)
    {
      this.Qvi = bool;
      AppMethodBeat.o(143193);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTruncTextView
 * JD-Core Version:    0.7.0.1
 */