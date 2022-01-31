package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.ci.a.k;
import com.tencent.mm.ui.ap;

public class MMAutoAdjustTextView
  extends TextView
{
  private float dOB;
  private Paint nV;
  private float scale;
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMAutoAdjustTextView));
    init();
  }
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMAutoAdjustTextView));
    init();
  }
  
  private void IJ(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    for (;;)
    {
      measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
      if (getMeasuredWidth() <= paramInt) {
        break;
      }
      this.dOB -= ap.getDensity(getContext());
      setTextSize(0, this.dOB * this.scale);
    }
  }
  
  private static void b(TypedArray paramTypedArray)
  {
    if (paramTypedArray != null) {
      paramTypedArray.recycle();
    }
  }
  
  private void init()
  {
    this.dOB = getTextSize();
    this.scale = ap.cJ(getContext());
    this.nV = new Paint();
    this.nV.set(getPaint());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      getText().toString();
      IJ(paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence.toString();
    IJ(getWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView
 * JD-Core Version:    0.7.0.1
 */