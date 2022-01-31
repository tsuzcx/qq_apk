package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;

public final class ImagePreference
  extends Preference
{
  private ImageView mXR = null;
  private e vcL = new e();
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference_image);
    setWidgetLayoutResource(a.h.mm_preference_submenu);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ImagePreference);
    paramInt = paramContext.getResourceId(a.m.ImagePreference_img, 0);
    if (paramInt > 0)
    {
      paramAttributeSet = this.vcL;
      paramAttributeSet.kCB = paramInt;
      paramAttributeSet.bitmap = null;
      this.vcL.h(this.mXR);
    }
    paramContext.recycle();
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mXR = ((ImageView)paramView.findViewById(a.g.image_iv));
    this.vcL.h(this.mXR);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content_ll);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_image, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ImagePreference
 * JD-Core Version:    0.7.0.1
 */