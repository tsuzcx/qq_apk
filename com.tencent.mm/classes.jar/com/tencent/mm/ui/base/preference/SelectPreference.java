package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SelectPreference
  extends Preference
{
  private WeImageView HaZ;
  private String desc;
  private TextView descTv;
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
  
  public final void bAn(String paramString)
  {
    AppMethodBeat.i(251496);
    this.desc = paramString;
    if (this.descTv != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.descTv.setVisibility(8);
        this.descTv.setText("");
        AppMethodBeat.o(251496);
        return;
      }
      this.descTv.setVisibility(0);
      this.descTv.setText(paramString);
    }
    AppMethodBeat.o(251496);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142672);
    super.onBindView(paramView);
    aBq(8);
    this.HaZ = ((WeImageView)paramView.findViewById(a.g.state_icon));
    WeImageView localWeImageView = this.HaZ;
    if (this.isSelected) {}
    for (int i = 0;; i = 8)
    {
      localWeImageView.setVisibility(i);
      this.descTv = ((TextView)paramView.findViewById(a.g.desc));
      bAn(this.desc);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SelectPreference
 * JD-Core Version:    0.7.0.1
 */