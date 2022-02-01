package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomScrollView
  extends ScrollView
{
  private a adOi;
  
  public CustomScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159150);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.adOi != null) {
      this.adOi.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(159150);
  }
  
  public void setOnScrollChangeListener(a parama)
  {
    this.adOi = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScrollChange(ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */