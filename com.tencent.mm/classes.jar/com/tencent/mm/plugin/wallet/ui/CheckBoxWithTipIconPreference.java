package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference
  extends CheckBoxPreference
{
  private TextView qqn;
  private int qqo = -1;
  private String qqp = "";
  private int qqq = 8;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference_summary_icontip_checkbox);
  }
  
  public final void AL(int paramInt)
  {
    this.qqq = paramInt;
    if (this.qqn != null) {
      this.qqn.setVisibility(paramInt);
    }
  }
  
  public final void cF(String paramString, int paramInt)
  {
    this.qqo = paramInt;
    this.qqp = paramString;
    if (this.qqn != null)
    {
      if (this.qqo > 0) {
        this.qqn.setBackgroundResource(this.qqo);
      }
      if (!TextUtils.isEmpty(this.qqp)) {
        this.qqn.setText(this.qqp);
      }
    }
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.qqn = ((TextView)paramView.findViewById(a.f.tipicon));
    cF(this.qqp, this.qqo);
    AL(this.qqq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */