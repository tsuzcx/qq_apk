package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMLoadScrollView
  extends ScrollView
{
  private a IZY;
  
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
    AppMethodBeat.i(143362);
    if ((paramBoolean2) && (paramInt2 > 0) && (this.IZY != null)) {
      this.IZY.cek();
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143362);
  }
  
  public void setOnTopOrBottomListerner(a parama)
  {
    this.IZY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cek();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMLoadScrollView
 * JD-Core Version:    0.7.0.1
 */