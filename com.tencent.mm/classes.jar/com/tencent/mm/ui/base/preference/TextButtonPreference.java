package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.y;

public class TextButtonPreference
  extends Preference
{
  public TextButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getLayoutResource()
  {
    return a.h.mm_preference_button;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView != null)
    {
      paramView.setText(getTitle());
      paramView.setEnabled(isEnabled());
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    super.onCreateView(paramViewGroup);
    return y.gt(this.mContext).inflate(a.h.mm_preference_button, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextButtonPreference
 * JD-Core Version:    0.7.0.1
 */