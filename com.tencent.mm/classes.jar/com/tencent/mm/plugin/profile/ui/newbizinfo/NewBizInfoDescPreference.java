package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoDescPreference
  extends Preference
{
  private MMActivity bER;
  private LinearLayout dtF;
  private TextView gaI;
  private boolean jAt;
  d mZz;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    this.jAt = false;
  }
  
  public final void onBindView(View paramView)
  {
    this.dtF = ((LinearLayout)paramView.findViewById(R.h.bizinfo_desc_layout));
    this.gaI = ((TextView)paramView.findViewById(R.h.bizinfo_desc));
    this.jAt = true;
    if (!this.jAt)
    {
      y.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.jAt) });
      return;
    }
    if (this.mZz == null)
    {
      this.dtF.setVisibility(4);
      return;
    }
    paramView = new StringBuilder();
    if ((this.mZz.field_originalArticleCount > 0) && (this.mZz.field_friendSubscribeCount > 0))
    {
      paramView.append(String.format(this.bER.getResources().getString(R.l.contact_info_biz_original_article), new Object[] { Integer.valueOf(this.mZz.field_originalArticleCount) }));
      paramView.append("  ");
      paramView.append(String.format(this.bER.getResources().getString(R.l.contact_info_biz_friend_subscribe), new Object[] { Integer.valueOf(this.mZz.field_friendSubscribeCount) }));
      paramView = paramView.toString();
    }
    while (!bk.bl(paramView))
    {
      this.dtF.setVisibility(0);
      this.gaI.setText(paramView);
      return;
      if (this.mZz.field_originalArticleCount > 0)
      {
        paramView.append(String.format(this.bER.getResources().getString(R.l.contact_info_biz_original_article), new Object[] { Integer.valueOf(this.mZz.field_originalArticleCount) }));
        paramView = paramView.toString();
      }
      else if (this.mZz.field_friendSubscribeCount > 0)
      {
        paramView.append(String.format(this.bER.getResources().getString(R.l.contact_info_biz_friend_subscribe), new Object[] { Integer.valueOf(this.mZz.field_friendSubscribeCount) }));
        paramView = paramView.toString();
      }
      else
      {
        paramView = "";
      }
    }
    this.dtF.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */