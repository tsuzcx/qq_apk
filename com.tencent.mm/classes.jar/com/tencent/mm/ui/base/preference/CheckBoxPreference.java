package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class CheckBoxPreference
  extends Preference
{
  private MMSwitchBtn lAy;
  private TextView qqn;
  private int qqo = -1;
  private String qqp = "";
  private int qqq = 8;
  public boolean rHo = false;
  
  public CheckBoxPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference_summary_checkbox);
  }
  
  public void AL(int paramInt)
  {
    this.qqq = paramInt;
    if (this.qqn != null) {
      this.qqn.setVisibility(this.qqq);
    }
  }
  
  public void cF(String paramString, int paramInt)
  {
    this.qqo = paramInt;
    this.qqp = paramString;
    if (this.qqn != null)
    {
      if (paramInt > 0) {
        this.qqn.setBackgroundResource(this.qqo);
      }
      if (!TextUtils.isEmpty(this.qqp)) {
        this.qqn.setText(this.qqp);
      }
    }
  }
  
  public final boolean isChecked()
  {
    if (this.lAy != null) {
      return this.lAy.wjS;
    }
    return this.rHo;
  }
  
  public final void nd(boolean paramBoolean)
  {
    if (this.lAy != null)
    {
      this.rHo = paramBoolean;
      this.lAy.setCheck(paramBoolean);
    }
  }
  
  public void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.lAy = ((MMSwitchBtn)paramView.findViewById(a.g.checkbox));
    this.lAy.setSwitchListener(new CheckBoxPreference.1(this));
    this.lAy.setCheck(this.rHo);
    if (!isEnabled())
    {
      this.lAy.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.d.black_text_color_disabled));
    }
    this.qqn = ((TextView)paramView.findViewById(a.g.tipicon));
    cF(this.qqp, this.qqo);
    AL(this.qqq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */