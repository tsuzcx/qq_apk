package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProductScrollView
  extends ScrollView
{
  private a xdl;
  
  public ProductScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProductScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51848);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xdl != null) {
      this.xdl.chO();
    }
    AppMethodBeat.o(51848);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.xdl = parama;
  }
  
  public static abstract interface a
  {
    public abstract void chO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductScrollView
 * JD-Core Version:    0.7.0.1
 */