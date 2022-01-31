package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactLinkPreference
  extends KeyValuePreference
{
  public VcardContactLinkPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public VcardContactLinkPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VcardContactLinkPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(16908304)).setTextColor(a.i(this.mContext, R.e.conatct_info_weibo_link_color));
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    return super.onCreateView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactLinkPreference
 * JD-Core Version:    0.7.0.1
 */