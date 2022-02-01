package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SelectPreference
  extends Preference
{
  private WeImageView Buo;
  private boolean enable;
  public boolean isSelected;
  private View mView;
  
  public SelectPreference(Context paramContext)
  {
    super(paramContext);
    this.enable = true;
  }
  
  public SelectPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.enable = true;
  }
  
  public SelectPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142670);
    this.enable = true;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142670);
  }
  
  public final boolean getSelected()
  {
    return this.isSelected;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142672);
    super.onBindView(paramView);
    auO(8);
    this.Buo = ((WeImageView)paramView.findViewById(a.g.state_icon));
    paramView = this.Buo;
    if (this.isSelected) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(142672);
      return;
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142671);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_select, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(142671);
    return paramViewGroup;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SelectPreference
 * JD-Core Version:    0.7.0.1
 */