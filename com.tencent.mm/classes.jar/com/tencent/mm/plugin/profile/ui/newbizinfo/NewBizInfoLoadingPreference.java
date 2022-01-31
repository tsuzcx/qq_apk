package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference
  extends Preference
{
  private MMActivity bER;
  private View eML;
  private TextView gaI;
  private boolean jAt = false;
  private ProgressBar mZJ;
  boolean mZK = false;
  d mZz;
  int state = 1;
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  final void initView()
  {
    if (!this.jAt) {
      return;
    }
    if (this.state == 1)
    {
      this.eML.setVisibility(0);
      this.mZJ.setVisibility(0);
      this.gaI.setVisibility(8);
      return;
    }
    if (this.state == 2)
    {
      this.eML.setVisibility(0);
      SpannableString localSpannableString = j.a(this.bER, this.mZz.field_banReason, (int)this.gaI.getTextSize(), 1);
      this.gaI.setText(localSpannableString);
      this.gaI.setMovementMethod(LinkMovementMethod.getInstance());
      this.gaI.setVisibility(0);
      this.mZJ.setVisibility(8);
      return;
    }
    if (this.state == 3)
    {
      this.eML.setVisibility(0);
      this.gaI.setText(this.bER.getString(R.l.contact_info_time_expired));
      this.gaI.setVisibility(0);
      this.mZJ.setVisibility(8);
      return;
    }
    this.eML.setVisibility(8);
  }
  
  public final void onBindView(View paramView)
  {
    this.eML = paramView.findViewById(R.h.new_bizinfo_container);
    this.gaI = ((TextView)paramView.findViewById(R.h.new_bizinfo_desc_tv));
    this.mZJ = ((ProgressBar)paramView.findViewById(R.h.new_bizinfo_loading));
    this.jAt = true;
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference
 * JD-Core Version:    0.7.0.1
 */