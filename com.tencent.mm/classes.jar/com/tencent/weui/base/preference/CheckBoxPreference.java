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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  private int OAB;
  private String OAC;
  private int OAD;
  private TextView OEk;
  boolean bBh;
  private View mView;
  private MMSwitchBtn wrR;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.bBh = false;
    this.OAB = -1;
    this.OAC = "";
    this.OAD = 8;
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(159986);
  }
  
  public final void BT(boolean paramBoolean)
  {
    AppMethodBeat.i(249529);
    if (this.wrR != null)
    {
      this.bBh = paramBoolean;
      this.wrR.setCheck(paramBoolean);
    }
    AppMethodBeat.o(249529);
  }
  
  public final void amm(int paramInt)
  {
    AppMethodBeat.i(249530);
    this.OAD = paramInt;
    if (this.OEk != null) {
      this.OEk.setVisibility(this.OAD);
    }
    AppMethodBeat.o(249530);
  }
  
  public final boolean isChecked()
  {
    if (this.wrR != null) {
      return this.wrR.YbZ;
    }
    return this.bBh;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.wrR = ((MMSwitchBtn)paramView.findViewById(a.f.checkbox));
    this.wrR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.wrR.setCheck(this.bBh);
    if (!isEnabled())
    {
      this.wrR.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.c.black_text_color_disabled));
    }
    this.OEk = ((TextView)paramView.findViewById(a.f.tipicon));
    paramView = this.OAC;
    int i = this.OAB;
    this.OAB = i;
    this.OAC = paramView;
    if (this.OEk != null)
    {
      if (i > 0) {
        this.OEk.setBackgroundResource(this.OAB);
      }
      if (!TextUtils.isEmpty(this.OAC)) {
        this.OEk.setText(this.OAC);
      }
    }
    amm(this.OAD);
    AppMethodBeat.o(159988);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159987);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), a.g.mm_preference_summary_checkbox, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(159987);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.bBh = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */