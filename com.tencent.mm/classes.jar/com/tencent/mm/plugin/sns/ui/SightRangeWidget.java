package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(98271);
    super.a(paramInt1, paramInt2, paramIntent, paramAtContactWidget);
    if (paramAtContactWidget != null)
    {
      if (getLabelRange() != 1) {
        break label46;
      }
      paramAtContactWidget.setVisibility(4);
      paramAtContactWidget.dyI();
    }
    for (;;)
    {
      AppMethodBeat.o(98271);
      return true;
      label46:
      paramAtContactWidget.setVisibility(0);
    }
  }
  
  protected int getLayoutResource()
  {
    return 2131495459;
  }
  
  protected int getMaxTagNameLen()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightRangeWidget
 * JD-Core Version:    0.7.0.1
 */