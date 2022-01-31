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

public class CheckBoxPreference
  extends Preference
{
  private MMSwitchBtn iDy;
  private View mView;
  private TextView ubi;
  private int ubj;
  private String ubk;
  private int ubl;
  boolean vxW;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113249);
    this.vxW = false;
    this.ubj = -1;
    this.ubk = "";
    this.ubl = 8;
    setLayoutResource(2130970179);
    AppMethodBeat.o(113249);
  }
  
  public final boolean isChecked()
  {
    if (this.iDy != null) {
      return this.iDy.ADA;
    }
    return this.vxW;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(113251);
    super.onBindView(paramView);
    this.iDy = ((MMSwitchBtn)paramView.findViewById(2131820950));
    this.iDy.setSwitchListener(new CheckBoxPreference.1(this));
    this.iDy.setCheck(this.vxW);
    if (!isEnabled())
    {
      this.iDy.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131689767));
    }
    this.ubi = ((TextView)paramView.findViewById(2131826257));
    paramView = this.ubk;
    int i = this.ubj;
    this.ubj = i;
    this.ubk = paramView;
    if (this.ubi != null)
    {
      if (i > 0) {
        this.ubi.setBackgroundResource(this.ubj);
      }
      if (!TextUtils.isEmpty(this.ubk)) {
        this.ubi.setText(this.ubk);
      }
    }
    this.ubl = this.ubl;
    if (this.ubi != null) {
      this.ubi.setVisibility(this.ubl);
    }
    AppMethodBeat.o(113251);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113250);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2130970259, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(113250);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */