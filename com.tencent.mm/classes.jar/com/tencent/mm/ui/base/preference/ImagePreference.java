package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;

public final class ImagePreference
  extends Preference
{
  private ImageView MXO;
  private e adYS;
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142569);
    this.MXO = null;
    this.adYS = new e();
    setLayoutResource(a.h.mm_preference_image);
    aBp(a.h.mm_preference_submenu);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ImagePreference);
    paramInt = paramContext.getResourceId(a.m.ImagePreference_img, 0);
    if (paramInt > 0)
    {
      paramAttributeSet = this.adYS;
      paramAttributeSet.resId = paramInt;
      paramAttributeSet.bitmap = null;
      this.adYS.z(this.MXO);
    }
    paramContext.recycle();
    AppMethodBeat.o(142569);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142571);
    super.onBindView(paramView);
    this.MXO = ((ImageView)paramView.findViewById(a.g.image_iv));
    this.adYS.z(this.MXO);
    AppMethodBeat.o(142571);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142570);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content_ll);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_image, localViewGroup);
    AppMethodBeat.o(142570);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ImagePreference
 * JD-Core Version:    0.7.0.1
 */