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
  private boolean Awl = false;
  private boolean Awm = false;
  
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
    AppMethodBeat.i(107739);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(107739);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(107739);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107738);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(107738);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(107738);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107735);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.Awl)
    {
      AppMethodBeat.o(107735);
      return;
    }
    CharSequence localCharSequence = getText();
    if (!(localCharSequence instanceof Spanned))
    {
      AppMethodBeat.o(107735);
      return;
    }
    this.Awm = true;
    setText(TextUtils.ellipsize(localCharSequence, getPaint(), getWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
    this.Awm = false;
    AppMethodBeat.o(107735);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107737);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(107737);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(107737);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(107740);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(107740);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(107740);
    }
    return true;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107736);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.Awm) {}
    for (boolean bool = true;; bool = false)
    {
      this.Awl = bool;
      AppMethodBeat.o(107736);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTruncTextView
 * JD-Core Version:    0.7.0.1
 */