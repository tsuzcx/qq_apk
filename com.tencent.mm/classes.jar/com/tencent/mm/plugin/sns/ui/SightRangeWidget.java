package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;

public class SightRangeWidget
  extends RangeWidget
{
  public SightRangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SightRangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    super.a(paramInt1, paramInt2, paramIntent, paramAtContactWidget);
    if (paramAtContactWidget != null)
    {
      if (getLabelRange() == 1)
      {
        paramAtContactWidget.setVisibility(4);
        paramAtContactWidget.bHk();
      }
    }
    else {
      return true;
    }
    paramAtContactWidget.setVisibility(0);
    return true;
  }
  
  protected int getLayoutResource()
  {
    return i.g.sight_range_layout;
  }
  
  protected int getMaxTagNameLen()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightRangeWidget
 * JD-Core Version:    0.7.0.1
 */