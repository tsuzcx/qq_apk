package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;

public final class ImagePreference
  extends Preference
{
  private ImageView pAE;
  private e zrl;
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107192);
    this.pAE = null;
    this.zrl = new e();
    setLayoutResource(2130970234);
    setWidgetLayoutResource(2130970254);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ImagePreference);
    paramInt = paramContext.getResourceId(0, 0);
    if (paramInt > 0)
    {
      paramAttributeSet = this.zrl;
      paramAttributeSet.resId = paramInt;
      paramAttributeSet.bitmap = null;
      this.zrl.m(this.pAE);
    }
    paramContext.recycle();
    AppMethodBeat.o(107192);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107194);
    super.onBindView(paramView);
    this.pAE = ((ImageView)paramView.findViewById(2131822243));
    this.zrl.m(this.pAE);
    AppMethodBeat.o(107194);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107193);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131821888);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970234, localViewGroup);
    AppMethodBeat.o(107193);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ImagePreference
 * JD-Core Version:    0.7.0.1
 */