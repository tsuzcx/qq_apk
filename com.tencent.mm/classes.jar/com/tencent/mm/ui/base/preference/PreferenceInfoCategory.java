package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;

public class PreferenceInfoCategory
  extends Preference
{
  public int uHe = 0;
  public View.OnClickListener vdT = null;
  public View.OnClickListener vdU = null;
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceInfoCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference_info_center);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(16908310);
    if (localTextView == null) {
      return;
    }
    if ((getTitle() == null) || (getTitle().length() <= 0)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (ImageView)paramView.findViewById(a.g.add_my_qrcode);
      paramView.setOnClickListener(this.vdT);
      if (this.uHe <= 0) {
        break;
      }
      paramView.setImageResource(this.uHe);
      paramView.setVisibility(0);
      return;
      localTextView.setVisibility(0);
      localTextView.setText(getTitle());
      localTextView.setOnClickListener(this.vdU);
    }
    paramView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceInfoCategory
 * JD-Core Version:    0.7.0.1
 */