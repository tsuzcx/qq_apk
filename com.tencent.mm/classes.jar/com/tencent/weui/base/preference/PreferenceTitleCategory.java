package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.g;

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
    AppMethodBeat.i(159995);
    if (getLayoutResource() != a.g.mm_preference_info_normaltext) {
      setLayoutResource(a.g.mm_preference_info_bigtext);
    }
    AppMethodBeat.o(159995);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159996);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null)
    {
      AppMethodBeat.o(159996);
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0))
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(159996);
      return;
    }
    paramView.setVisibility(0);
    paramView.setText(getTitle());
    AppMethodBeat.o(159996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.PreferenceTitleCategory
 * JD-Core Version:    0.7.0.1
 */