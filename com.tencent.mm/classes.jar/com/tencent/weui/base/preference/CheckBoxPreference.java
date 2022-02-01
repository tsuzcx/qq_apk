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
  private int HIJ;
  private String HIK;
  private int HIL;
  private TextView HMo;
  private View mView;
  boolean oD;
  private MMSwitchBtn sLW;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.oD = false;
    this.HIJ = -1;
    this.HIK = "";
    this.HIL = 8;
    setLayoutResource(2131495538);
    AppMethodBeat.o(159986);
  }
  
  public final void aez(int paramInt)
  {
    AppMethodBeat.i(198548);
    this.HIL = paramInt;
    if (this.HMo != null) {
      this.HMo.setVisibility(this.HIL);
    }
    AppMethodBeat.o(198548);
  }
  
  public final boolean isChecked()
  {
    if (this.sLW != null) {
      return this.sLW.QDw;
    }
    return this.oD;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.sLW = ((MMSwitchBtn)paramView.findViewById(2131298639));
    this.sLW.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.sLW.setCheck(this.oD);
    if (!isEnabled())
    {
      this.sLW.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100048));
    }
    this.HMo = ((TextView)paramView.findViewById(2131309166));
    paramView = this.HIK;
    int i = this.HIJ;
    this.HIJ = i;
    this.HIK = paramView;
    if (this.HMo != null)
    {
      if (i > 0) {
        this.HMo.setBackgroundResource(this.HIJ);
      }
      if (!TextUtils.isEmpty(this.HIK)) {
        this.HMo.setText(this.HIK);
      }
    }
    aez(this.HIL);
    AppMethodBeat.o(159988);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159987);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131495627, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(159987);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.oD = paramBoolean;
  }
  
  public final void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(198547);
    if (this.sLW != null)
    {
      this.oD = paramBoolean;
      this.sLW.setCheck(paramBoolean);
    }
    AppMethodBeat.o(198547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */