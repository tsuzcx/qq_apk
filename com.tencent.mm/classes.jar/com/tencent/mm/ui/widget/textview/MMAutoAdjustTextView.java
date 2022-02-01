package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.ao;

public class MMAutoAdjustTextView
  extends TextView
{
  private float scale;
  private float textSize;
  private Paint wv;
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159842);
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMAutoAdjustTextView));
    init();
    AppMethodBeat.o(159842);
  }
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159843);
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMAutoAdjustTextView));
    init();
    AppMethodBeat.o(159843);
  }
  
  private void ado(int paramInt)
  {
    AppMethodBeat.i(159846);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(159846);
      return;
    }
    for (;;)
    {
      measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
      if (getMeasuredWidth() <= paramInt) {
        break;
      }
      this.textSize -= ao.getDensity(getContext());
      setTextSize(0, this.textSize * this.scale);
    }
    AppMethodBeat.o(159846);
  }
  
  private static void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159845);
    if (paramTypedArray != null) {
      paramTypedArray.recycle();
    }
    AppMethodBeat.o(159845);
  }
  
  private void init()
  {
    AppMethodBeat.i(159844);
    this.textSize = getTextSize();
    this.scale = ao.eb(getContext());
    this.wv = new Paint();
    this.wv.set(getPaint());
    AppMethodBeat.o(159844);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159848);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      getText().toString();
      ado(paramInt1);
    }
    AppMethodBeat.o(159848);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159847);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence.toString();
    ado(getWidth());
    AppMethodBeat.o(159847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView
 * JD-Core Version:    0.7.0.1
 */