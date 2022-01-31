package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class OnLayoutChangedLinearLayout
  extends DrawnCallBackLinearLayout
{
  public OnLayoutChangedLinearLayout.a vbj;
  
  public OnLayoutChangedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public OnLayoutChangedLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vbj != null) {
      this.vbj.cAa();
    }
  }
  
  public void setOnChattingLayoutChangedListener(OnLayoutChangedLinearLayout.a parama)
  {
    this.vbj = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.OnLayoutChangedLinearLayout
 * JD-Core Version:    0.7.0.1
 */