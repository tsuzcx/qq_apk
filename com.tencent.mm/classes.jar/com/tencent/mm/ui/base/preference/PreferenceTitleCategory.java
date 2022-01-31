package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.h;

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
    if (getLayoutResource() != a.h.mm_preference_info_normaltext) {
      setLayoutResource(a.h.mm_preference_info_bigtext);
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null) {
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    paramView.setText(getTitle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceTitleCategory
 * JD-Core Version:    0.7.0.1
 */