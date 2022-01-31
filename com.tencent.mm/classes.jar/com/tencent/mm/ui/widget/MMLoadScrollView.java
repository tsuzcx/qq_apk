package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMLoadScrollView
  extends ScrollView
{
  private MMLoadScrollView.a ACW;
  
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
    AppMethodBeat.i(107884);
    if ((paramBoolean2) && (paramInt2 > 0) && (this.ACW != null)) {
      this.ACW.bnl();
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(107884);
  }
  
  public void setOnTopOrBottomListerner(MMLoadScrollView.a parama)
  {
    this.ACW = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMLoadScrollView
 * JD-Core Version:    0.7.0.1
 */