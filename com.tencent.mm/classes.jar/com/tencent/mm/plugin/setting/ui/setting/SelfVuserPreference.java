package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference
  extends Preference
{
  Drawable drawable;
  private String nSG;
  String text;
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(a.f.image_iv);
    if (localImageView != null)
    {
      localImageView.setImageDrawable(this.drawable);
      y.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
      if (!bk.bl(this.nSG)) {
        localImageView.setContentDescription(this.nSG);
      }
    }
    paramView = (TextView)paramView.findViewById(a.f.text_tv);
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setText(this.text);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.g.mm_preference_self_vuser, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfVuserPreference
 * JD-Core Version:    0.7.0.1
 */