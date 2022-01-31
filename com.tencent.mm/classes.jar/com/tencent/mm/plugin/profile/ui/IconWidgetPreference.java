package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference
  extends Preference
{
  private ImageView mYc = null;
  private int mYd = -1;
  private Bitmap mYe = null;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
    setWidgetLayoutResource(0);
  }
  
  public final void C(Bitmap paramBitmap)
  {
    this.mYe = paramBitmap;
    if (this.mYc != null) {
      this.mYc.setImageBitmap(paramBitmap);
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mYc = ((ImageView)paramView.findViewById(R.h.pref_widget_right_icon));
    if (this.mYc != null)
    {
      this.mYc.setVisibility(8);
      if (this.mYd == -1) {
        break label63;
      }
      this.mYc.setImageResource(this.mYd);
      this.mYc.setVisibility(0);
    }
    label63:
    while (this.mYe == null) {
      return;
    }
    this.mYc.setImageBitmap(this.mYe);
    this.mYc.setVisibility(0);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.mm_preference_widget_icon, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */