package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceFooterCategory
  extends Preference
{
  public PreferenceFooterCategory(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(186487);
    setLayoutResource(2131494866);
    AppMethodBeat.o(186487);
  }
  
  public PreferenceFooterCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142656);
    setLayoutResource(2131494866);
    AppMethodBeat.o(142656);
  }
  
  public PreferenceFooterCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142657);
    setLayoutResource(2131494866);
    AppMethodBeat.o(142657);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142658);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null)
    {
      AppMethodBeat.o(142658);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0))
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(142658);
      return;
    }
    paramView.setVisibility(0);
    paramView.setText(getTitle());
    AppMethodBeat.o(142658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceFooterCategory
 * JD-Core Version:    0.7.0.1
 */