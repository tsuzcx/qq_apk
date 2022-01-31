package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BigIconSummaryPreference
  extends IconSummaryPreference
{
  public BigIconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BigIconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107130);
    paramViewGroup = super.onCreateView(paramViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(2131427786));
    AppMethodBeat.o(107130);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.BigIconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */