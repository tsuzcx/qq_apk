package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;

public final class RadarSpecialTableLayout
  extends TableLayout
{
  private boolean nmA;
  
  public RadarSpecialTableLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RadarSpecialTableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int i;
    if ((!this.nmA) && (paramInt2 < 0))
    {
      j = paramInt4 - paramInt2;
      i = 1;
    }
    for (;;)
    {
      this.nmA = false;
      if (i == 0)
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      layout(paramInt1, 0, paramInt3, j);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.nmA = true;
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialTableLayout
 * JD-Core Version:    0.7.0.1
 */