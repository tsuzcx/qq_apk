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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  private int VpO;
  private String VpP;
  private int VpQ;
  private TextView Vtv;
  public boolean duj;
  private View mView;
  private MMSwitchBtn zNX;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.duj = false;
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(159986);
  }
  
  public final void Hy(boolean paramBoolean)
  {
    AppMethodBeat.i(210682);
    if (this.zNX != null)
    {
      this.duj = paramBoolean;
      this.zNX.setCheck(paramBoolean);
    }
    AppMethodBeat.o(210682);
  }
  
  public final void arW(int paramInt)
  {
    AppMethodBeat.i(210684);
    this.VpQ = paramInt;
    if (this.Vtv != null) {
      this.Vtv.setVisibility(this.VpQ);
    }
    AppMethodBeat.o(210684);
  }
  
  public final boolean isChecked()
  {
    if (this.zNX != null) {
      return this.zNX.afTT;
    }
    return this.duj;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.zNX = ((MMSwitchBtn)paramView.findViewById(a.f.checkbox));
    this.zNX.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.zNX.setCheck(this.duj);
    if (!isEnabled())
    {
      this.zNX.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.c.black_text_color_disabled));
    }
    this.Vtv = ((TextView)paramView.findViewById(a.f.tipicon));
    paramView = this.VpP;
    int i = this.VpO;
    this.VpO = i;
    this.VpP = paramView;
    if (this.Vtv != null)
    {
      if (i > 0) {
        this.Vtv.setBackgroundResource(this.VpO);
      }
      if (!TextUtils.isEmpty(this.VpP)) {
        this.Vtv.setText(this.VpP);
      }
    }
    arW(this.VpQ);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */