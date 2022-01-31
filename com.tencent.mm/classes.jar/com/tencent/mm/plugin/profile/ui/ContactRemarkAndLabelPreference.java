package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView haW;
  private String jRT;
  private Context mContext;
  private TextView mWu;
  private TextView mWv;
  private boolean mWw = false;
  private String mWx;
  private String mWy;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    setLayoutResource(R.i.mm_preference);
  }
  
  public final void onBindView(View paramView)
  {
    this.haW = ((TextView)paramView.findViewById(R.h.title));
    this.mWu = ((TextView)paramView.findViewById(R.h.remark));
    this.mWv = ((TextView)paramView.findViewById(R.h.label));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.haW != null) && (!bk.bl(this.jRT)))
    {
      this.haW.setVisibility(0);
      this.haW.setText(this.jRT);
      localLayoutParams = (RelativeLayout.LayoutParams)this.haW.getLayoutParams();
      localLayoutParams.width = a.aa(this.mContext, R.f.FixedTitleWidth);
      this.haW.setLayoutParams(localLayoutParams);
    }
    if (this.mWu != null) {
      if (!this.mWw)
      {
        this.mWu.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bk.bl(this.mWx))
        {
          this.mWu.setVisibility(0);
          this.mWu.setText(j.a(this.mContext, bk.pm(this.mWx), this.mWu.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.mWv != null)
      {
        j = i;
        if (!bk.bl(this.mWy))
        {
          j = i | 0x2;
          this.mWv.setVisibility(0);
          this.mWv.setText(this.mWy);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.mWu.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.mWv.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      return;
      this.mWu.setVisibility(0);
      this.mWu.setCompoundDrawablesWithIntrinsicBounds(R.k.card_photoicon, 0, 0, 0);
      i = 1;
      break;
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_remark_and_label_info, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */