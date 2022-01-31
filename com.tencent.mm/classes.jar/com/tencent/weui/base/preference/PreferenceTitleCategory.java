package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceTitleCategory
  extends PreferenceCategory
{
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113258);
    if (getLayoutResource() != 2130970239) {
      setLayoutResource(2130970237);
    }
    AppMethodBeat.o(113258);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(113259);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null)
    {
      AppMethodBeat.o(113259);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0))
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(113259);
      return;
    }
    paramView.setVisibility(0);
    paramView.setText(getTitle());
    AppMethodBeat.o(113259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.weui.base.preference.PreferenceTitleCategory
 * JD-Core Version:    0.7.0.1
 */