package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RadioCheckPreference
  extends Preference
{
  private CheckBox GdZ;
  private int Gea;
  private boolean lG;
  private TextView zVJ;
  private int zVK;
  private String zVL;
  private int zVM;
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142666);
    this.lG = false;
    this.zVK = -1;
    this.zVL = "";
    this.zVM = 8;
    this.Gea = -1;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142666);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142668);
    super.onBindView(paramView);
    Yb(8);
    this.GdZ = ((CheckBox)paramView.findViewById(2131303709));
    this.GdZ.setChecked(this.lG);
    this.zVJ = ((TextView)paramView.findViewById(2131305883));
    paramView = this.zVL;
    int i = this.zVK;
    this.zVK = i;
    this.zVL = paramView;
    if (this.zVJ != null)
    {
      if (i > 0) {
        this.zVJ.setBackgroundResource(this.zVK);
      }
      if (!TextUtils.isEmpty(this.zVL)) {
        this.zVJ.setText(this.zVL);
      }
    }
    this.zVM = this.zVM;
    if (this.zVJ != null) {
      this.zVJ.setVisibility(this.zVM);
    }
    paramView = (LinearLayout.LayoutParams)this.GdZ.getLayoutParams();
    if (-1 != this.Gea) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.Gea, paramView.bottomMargin);
    }
    AppMethodBeat.o(142668);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142667);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494892, localViewGroup);
    AppMethodBeat.o(142667);
    return paramViewGroup;
  }
  
  public final void vP(boolean paramBoolean)
  {
    AppMethodBeat.i(142669);
    this.lG = paramBoolean;
    if (this.GdZ != null) {
      this.GdZ.setChecked(paramBoolean);
    }
    AppMethodBeat.o(142669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.RadioCheckPreference
 * JD-Core Version:    0.7.0.1
 */