package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.p;

public class IconSwitchKeyValuePreference
  extends IconPreference
{
  private TextView mXQ;
  private int status = 0;
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aZ()
  {
    if (this.mXQ == null) {
      return;
    }
    int i = BackwardSupportUtil.b.b(this.mContext, 2.0F);
    this.mXQ.setTextColor(p.hg(this.mContext));
    if (this.status == 0)
    {
      this.mXQ.setCompoundDrawablesWithIntrinsicBounds(a.j.status_accountunkey, 0, 0, 0);
      this.mXQ.setCompoundDrawablePadding(i);
      return;
    }
    if (this.status == 1)
    {
      this.mXQ.setCompoundDrawablesWithIntrinsicBounds(a.j.status_accountkey, 0, 0, 0);
      this.mXQ.setCompoundDrawablePadding(i);
      return;
    }
    if (this.status == 2)
    {
      this.mXQ.setCompoundDrawablesWithIntrinsicBounds(a.j.status_accountkey_off, 0, 0, 0);
      this.mXQ.setCompoundDrawablePadding(i);
      return;
    }
    this.mXQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public final void GA(int paramInt)
  {
    this.status = paramInt;
    aZ();
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mXQ = ((TextView)paramView.findViewById(16908304));
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */