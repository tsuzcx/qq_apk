package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class CheckBoxPreference
  extends Preference
{
  private MMSwitchBtn lAy;
  private TextView qqn;
  private int qqo = -1;
  private String qqp = "";
  private int qqq = 8;
  boolean rHo = false;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference_summary_checkbox);
  }
  
  public final boolean isChecked()
  {
    if (this.lAy != null) {
      return this.lAy.wjS;
    }
    return this.rHo;
  }
  
  public void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.lAy = ((MMSwitchBtn)paramView.findViewById(a.f.checkbox));
    this.lAy.setSwitchListener(new CheckBoxPreference.1(this));
    this.lAy.setCheck(this.rHo);
    if (!isEnabled())
    {
      this.lAy.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.c.black_text_color_disabled));
    }
    this.qqn = ((TextView)paramView.findViewById(a.f.tipicon));
    paramView = this.qqp;
    int i = this.qqo;
    this.qqo = i;
    this.qqp = paramView;
    if (this.qqn != null)
    {
      if (i > 0) {
        this.qqn.setBackgroundResource(this.qqo);
      }
      if (!TextUtils.isEmpty(this.qqp)) {
        this.qqn.setText(this.qqp);
      }
    }
    this.qqq = this.qqq;
    if (this.qqn != null) {
      this.qqn.setVisibility(this.qqq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */