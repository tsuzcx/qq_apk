package com.tencent.mm.plugin.setting.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference
  extends Preference
{
  private int height = -1;
  public ImageView hic;
  private TextView nXT;
  private View nXU;
  public String nXV;
  public View.OnClickListener nXW;
  public boolean nXX = false;
  private boolean nXY = false;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.hic == null) {
      this.hic = ((ImageView)paramView.findViewById(a.f.image_headimg));
    }
    if (this.nXT == null) {
      this.nXT = ((TextView)paramView.findViewById(a.f.no_header_icon_tip));
    }
    if (this.nXU == null) {
      this.nXU = paramView.findViewById(a.f.mask_header_icon);
    }
    if (this.nXW != null) {
      this.nXU.setOnClickListener(this.nXW);
    }
    if (this.nXV != null)
    {
      a.b.a(this.hic, this.nXV);
      this.nXV = null;
    }
    if (!this.nXX)
    {
      this.nXU.setVisibility(8);
      this.nXT.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(a.f.mm_preference_ll_id);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      return;
      this.nXT.setVisibility(8);
      this.nXU.setVisibility(0);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    if (this.nXY) {
      View.inflate(this.mContext, a.g.more_tab_personal_info, localViewGroup);
    }
    for (;;)
    {
      this.hic = ((ImageView)paramViewGroup.findViewById(a.f.image_headimg));
      this.nXT = ((TextView)paramViewGroup.findViewById(a.f.no_header_icon_tip));
      this.nXU = paramViewGroup.findViewById(a.f.mask_header_icon);
      return paramViewGroup;
      View.inflate(this.mContext, a.g.mm_preference_content_headimg_new, localViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */