package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.p;

public class HelperHeaderPreference
  extends Preference
{
  private HelperHeaderPreference.a siu = new HelperHeaderPreference.a();
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void al(String paramString1, String paramString2, String paramString3)
  {
    this.siu.bVI = paramString1;
    this.siu.dtK = paramString2;
    this.siu.frh = paramString3;
    super.callChangeListener(null);
  }
  
  public final void onBindView(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(a.e.avatar_iv);
    TextView localTextView1 = (TextView)paramView.findViewById(a.e.status_tv);
    TextView localTextView2 = (TextView)paramView.findViewById(a.e.nickname_tv);
    TextView localTextView3 = (TextView)paramView.findViewById(a.e.hint_tv);
    if (localImageView != null) {
      a.b.a(localImageView, this.siu.bVI);
    }
    if (localTextView1 != null) {
      switch (this.siu.status)
      {
      }
    }
    for (;;)
    {
      if (localTextView2 != null) {
        localTextView2.setText(this.siu.dtK);
      }
      if (localTextView3 != null) {
        localTextView3.setText(this.siu.frh);
      }
      super.onBindView(paramView);
      return;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(p.hf(this.mContext));
      localTextView1.setText(a.h.settings_plugins_installed);
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(a.d.status_enable, 0, 0, 0);
      continue;
      localTextView1.setVisibility(0);
      localTextView1.setTextColor(p.hg(this.mContext));
      localTextView1.setText(a.h.settings_plugins_uninstalled);
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(a.d.status_disable, 0, 0, 0);
      continue;
      localTextView1.setVisibility(8);
    }
  }
  
  public final void ov(int paramInt)
  {
    this.siu.status = paramInt;
    super.callChangeListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */