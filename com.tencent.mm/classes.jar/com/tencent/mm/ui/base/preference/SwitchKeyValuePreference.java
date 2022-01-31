package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.tools.p;

public class SwitchKeyValuePreference
  extends Preference
{
  public boolean bIU = true;
  private TextView mXQ;
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference);
  }
  
  public final void aZ()
  {
    if (this.mXQ == null) {
      return;
    }
    if (this.bIU)
    {
      this.mXQ.setTextColor(p.hf(this.mContext));
      return;
    }
    this.mXQ.setTextColor(p.hg(this.mContext));
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mXQ = ((TextView)paramView.findViewById(16908304));
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */