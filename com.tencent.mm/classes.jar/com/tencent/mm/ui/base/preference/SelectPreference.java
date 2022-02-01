package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SelectPreference
  extends Preference
{
  private boolean enable;
  public boolean ira;
  private View mView;
  private WeImageView raM;
  
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
    setLayoutResource(2131494804);
    AppMethodBeat.o(142670);
  }
  
  public final boolean getSelected()
  {
    return this.ira;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142672);
    super.onBindView(paramView);
    Yb(8);
    this.raM = ((WeImageView)paramView.findViewById(2131305186));
    paramView = this.raM;
    if (this.ira) {}
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
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494882, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(142671);
    return paramViewGroup;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.ira = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SelectPreference
 * JD-Core Version:    0.7.0.1
 */