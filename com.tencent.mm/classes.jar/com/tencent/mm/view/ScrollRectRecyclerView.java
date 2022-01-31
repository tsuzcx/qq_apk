package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrollRectRecyclerView
  extends RecyclerView
{
  private int AQG;
  public int scrollX;
  public int scrollY;
  
  public ScrollRectRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollRectRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62895);
    this.AQG = getResources().getDimensionPixelSize(2131428385);
    AppMethodBeat.o(62895);
  }
  
  public final void al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62896);
    super.al(paramInt1, paramInt2);
    this.scrollX += paramInt1;
    this.scrollY += paramInt2;
    AppMethodBeat.o(62896);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62897);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.AQG, 1073741824));
    AppMethodBeat.o(62897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.ScrollRectRecyclerView
 * JD-Core Version:    0.7.0.1
 */