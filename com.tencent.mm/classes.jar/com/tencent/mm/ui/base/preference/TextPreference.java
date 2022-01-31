package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ac.a.h;

public class TextPreference
  extends Preference
{
  protected int An;
  private Context context;
  protected TextView lh;
  protected CharSequence mText;
  
  public TextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference_info);
  }
  
  private void aZ()
  {
    if (this.lh == null) {
      return;
    }
    this.lh.setText(this.mText);
    this.lh.setGravity(this.An);
  }
  
  public final void O(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    this.An = 17;
    aZ();
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.lh = ((TextView)paramView.findViewById(16908310));
    aZ();
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    return super.onCreateView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.TextPreference
 * JD-Core Version:    0.7.0.1
 */