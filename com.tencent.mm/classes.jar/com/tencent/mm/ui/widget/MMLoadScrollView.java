package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MMLoadScrollView
  extends ScrollView
{
  private MMLoadScrollView.a wjp;
  
  public MMLoadScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMLoadScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramInt2 > 0) && (this.wjp != null)) {
      this.wjp.aJC();
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void setOnTopOrBottomListerner(MMLoadScrollView.a parama)
  {
    this.wjp = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMLoadScrollView
 * JD-Core Version:    0.7.0.1
 */