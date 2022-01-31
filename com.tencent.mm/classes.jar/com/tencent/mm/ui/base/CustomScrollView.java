package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomScrollView
  extends ScrollView
{
  private CustomScrollView.a zhn;
  
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
    AppMethodBeat.i(112504);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.zhn != null) {
      this.zhn.a(this, paramInt2, paramInt4);
    }
    AppMethodBeat.o(112504);
  }
  
  public void setOnScrollChangeListener(CustomScrollView.a parama)
  {
    this.zhn = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */