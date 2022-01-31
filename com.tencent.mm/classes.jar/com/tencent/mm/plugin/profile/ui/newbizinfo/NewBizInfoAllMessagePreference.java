package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference
  extends Preference
{
  private MMActivity bER;
  private TextView eXr;
  private TextView lxm;
  private LinearLayout mZD;
  d mZz;
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
  }
  
  public NewBizInfoAllMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    this.mZD = ((LinearLayout)paramView.findViewById(R.h.new_bizinfo_message_container));
    this.eXr = ((TextView)paramView.findViewById(R.h.new_bizinfo_message_title));
    this.lxm = ((TextView)paramView.findViewById(R.h.new_bizinfo_message_count));
    if ((this.mZz != null) && (this.mZz.bsX()))
    {
      this.mZD.setVisibility(0);
      this.eXr.setText(this.bER.getString(R.l.contact_info_biz_all_message_title));
      this.lxm.setText(this.mZz.field_allArticleWording);
      return;
    }
    this.mZD.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference
 * JD-Core Version:    0.7.0.1
 */