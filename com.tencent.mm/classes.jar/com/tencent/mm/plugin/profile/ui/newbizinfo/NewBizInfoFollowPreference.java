package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  private MMActivity bER;
  private boolean jAt = false;
  a mVH;
  private TextView mZE;
  private TextView mZF;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public final void onBindView(View paramView)
  {
    this.jAt = true;
    this.mZE = ((TextView)paramView.findViewById(R.h.contact_info_go_chatting));
    this.mZF = ((TextView)paramView.findViewById(R.h.contact_info_cancel_follow));
    if (this.jAt)
    {
      this.mZE.setOnClickListener(new NewBizInfoFollowPreference.1(this));
      this.mZF.setOnClickListener(new NewBizInfoFollowPreference.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference
 * JD-Core Version:    0.7.0.1
 */