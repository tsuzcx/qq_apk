package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthorizeItemListView
  extends ListView
{
  public int ajO;
  
  public AuthorizeItemListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AuthorizeItemListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131596);
    if (this.ajO <= 5)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
      AppMethodBeat.o(131596);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(131596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.AuthorizeItemListView
 * JD-Core Version:    0.7.0.1
 */