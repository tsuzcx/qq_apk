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
  private int DcV;
  private String DcW;
  private int DcX;
  private TextView Dga;
  private View mView;
  boolean oB;
  private MMSwitchBtn rkq;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.oB = false;
    this.DcV = -1;
    this.DcW = "";
    this.DcX = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159986);
  }
  
  public final boolean isChecked()
  {
    if (this.rkq != null) {
      return this.rkq.Lon;
    }
    return this.oB;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.rkq = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.rkq.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.rkq.setCheck(this.oB);
    if (!isEnabled())
    {
      this.rkq.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100022));
    }
    this.Dga = ((TextView)paramView.findViewById(2131305883));
    paramView = this.DcW;
    int i = this.DcV;
    this.DcV = i;
    this.DcW = paramView;
    if (this.Dga != null)
    {
      if (i > 0) {
        this.Dga.setBackgroundResource(this.DcV);
      }
      if (!TextUtils.isEmpty(this.DcW)) {
        this.Dga.setText(this.DcW);
      }
    }
    this.DcX = this.DcX;
    if (this.Dga != null) {
      this.Dga.setVisibility(this.DcX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */