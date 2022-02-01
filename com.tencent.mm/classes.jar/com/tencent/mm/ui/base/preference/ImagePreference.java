package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public final class ImagePreference
  extends Preference
{
  private e HEL;
  private ImageView vLg;
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142569);
    this.vLg = null;
    this.HEL = new e();
    setLayoutResource(2131494861);
    setWidgetLayoutResource(2131494884);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ImagePreference);
    paramInt = paramContext.getResourceId(0, 0);
    if (paramInt > 0)
    {
      paramAttributeSet = this.HEL;
      paramAttributeSet.resId = paramInt;
      paramAttributeSet.bitmap = null;
      this.HEL.m(this.vLg);
    }
    paramContext.recycle();
    AppMethodBeat.o(142569);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142571);
    super.onBindView(paramView);
    this.vLg = ((ImageView)paramView.findViewById(2131300943));
    this.HEL.m(this.vLg);
    AppMethodBeat.o(142571);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142570);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298764);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494861, localViewGroup);
    AppMethodBeat.o(142570);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ImagePreference
 * JD-Core Version:    0.7.0.1
 */