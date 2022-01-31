package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class NewBizInfoMenuPreference
  extends Preference
{
  private MMActivity bER;
  ad dnp;
  private boolean jAt = false;
  private LinearLayout mZL;
  List<e> mZM;
  private int mZN = 0;
  d mZz;
  int state = 0;
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoMenuPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  final void initView()
  {
    if (!this.jAt) {}
    int i;
    do
    {
      return;
      if ((this.state == 1) || (this.state == 2) || (this.state != 3)) {
        break;
      }
      this.mZL.setVisibility(0);
      this.mZL.removeAllViews();
      i = 0;
    } while (i >= this.mZM.size());
    Object localObject2 = (e)this.mZM.get(i);
    Object localObject1 = View.inflate(this.bER, R.i.contact_info_biz_menu_item, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(R.h.new_bizinfo_menu_text);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(R.h.new_bizinfo_menu_icon);
    this.mZN = ((int)localTextView.getTextSize());
    int j = (int)localTextView.getTextSize() * 3 / 4;
    ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
    localLayoutParams.height = j;
    localLayoutParams.width = j;
    localImageView.setLayoutParams(localLayoutParams);
    switch (((e)localObject2).type)
    {
    }
    for (;;)
    {
      localTextView.setText(j.b(this.bER, ((e)localObject2).name));
      ((View)localObject1).setOnClickListener(new NewBizInfoMenuPreference.1(this, (e)localObject2));
      this.mZL.addView((View)localObject1);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -2;
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (i != this.mZM.size() - 1)
      {
        localObject1 = new ImageView(this.bER);
        ((ImageView)localObject1).setBackgroundColor(this.bER.getResources().getColor(R.e.line_color));
        this.mZL.addView((View)localObject1);
        localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.mZN;
        ((LinearLayout.LayoutParams)localObject2).width = a.fromDPToPix(this.bER, 1);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i += 1;
      break;
      localImageView.setVisibility(0);
      localImageView.setImageResource(R.g.biz_menu_show_sub_menu_icon);
      continue;
      localImageView.setVisibility(8);
      continue;
      localImageView.setVisibility(0);
      localImageView.setImageResource(R.g.biz_menu_show_miniprogram_icon);
    }
    this.mZL.setVisibility(8);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mZL = ((LinearLayout)paramView.findViewById(R.h.contact_info_biz_menu_container));
    this.jAt = true;
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference
 * JD-Core Version:    0.7.0.1
 */