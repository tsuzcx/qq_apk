package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.al;

public class MMAutoAdjustTextView
  extends TextView
{
  private Paint oU;
  private float scale;
  private float textSize;
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113111);
    c(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMAutoAdjustTextView));
    init();
    AppMethodBeat.o(113111);
  }
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113112);
    c(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMAutoAdjustTextView));
    init();
    AppMethodBeat.o(113112);
  }
  
  private void RD(int paramInt)
  {
    AppMethodBeat.i(113115);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(113115);
      return;
    }
    for (;;)
    {
      measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
      if (getMeasuredWidth() <= paramInt) {
        break;
      }
      this.textSize -= al.getDensity(getContext());
      setTextSize(0, this.textSize * this.scale);
    }
    AppMethodBeat.o(113115);
  }
  
  private static void c(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(113114);
    if (paramTypedArray != null) {
      paramTypedArray.recycle();
    }
    AppMethodBeat.o(113114);
  }
  
  private void init()
  {
    AppMethodBeat.i(113113);
    this.textSize = getTextSize();
    this.scale = al.dr(getContext());
    this.oU = new Paint();
    this.oU.set(getPaint());
    AppMethodBeat.o(113113);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(113117);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      getText().toString();
      RD(paramInt1);
    }
    AppMethodBeat.o(113117);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(113116);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence.toString();
    RD(getWidth());
    AppMethodBeat.o(113116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView
 * JD-Core Version:    0.7.0.1
 */