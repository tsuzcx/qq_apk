package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  boolean lG;
  private View mView;
  private MMSwitchBtn sLH;
  private TextView zVJ;
  private int zVK;
  private String zVL;
  private int zVM;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.lG = false;
    this.zVK = -1;
    this.zVL = "";
    this.zVM = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159986);
  }
  
  public final boolean isChecked()
  {
    if (this.sLH != null) {
      return this.sLH.HAh;
    }
    return this.lG;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.sLH = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.sLH.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.sLH.setCheck(this.lG);
    if (!isEnabled())
    {
      this.sLH.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100022));
    }
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
    AppMethodBeat.o(159988);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159987);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131494889, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(159987);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */