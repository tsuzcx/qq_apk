package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceTitleCategory
  extends PreferenceCategory
{
  public PreferenceTitleCategory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142664);
    if (getLayoutResource() != 2131495603) {
      setLayoutResource(2131495600);
    }
    AppMethodBeat.o(142664);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142665);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null)
    {
      AppMethodBeat.o(142665);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0))
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(142665);
      return;
    }
    paramView.setVisibility(0);
    paramView.setText(getTitle());
    AppMethodBeat.o(142665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceTitleCategory
 * JD-Core Version:    0.7.0.1
 */