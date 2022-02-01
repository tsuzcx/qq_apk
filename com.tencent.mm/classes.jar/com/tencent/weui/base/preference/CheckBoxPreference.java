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
  private TextView COs;
  private int COt;
  private String COu;
  private int COv;
  private View mView;
  boolean oB;
  private MMSwitchBtn rck;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159986);
    this.oB = false;
    this.COt = -1;
    this.COu = "";
    this.COv = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159986);
  }
  
  public final boolean isChecked()
  {
    if (this.rck != null) {
      return this.rck.KRP;
    }
    return this.oB;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(159988);
    super.onBindView(paramView);
    this.rck = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.rck.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159985);
        CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(159985);
      }
    });
    this.rck.setCheck(this.oB);
    if (!isEnabled())
    {
      this.rck.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100022));
    }
    this.COs = ((TextView)paramView.findViewById(2131305883));
    paramView = this.COu;
    int i = this.COt;
    this.COt = i;
    this.COu = paramView;
    if (this.COs != null)
    {
      if (i > 0) {
        this.COs.setBackgroundResource(this.COt);
      }
      if (!TextUtils.isEmpty(this.COu)) {
        this.COs.setText(this.COu);
      }
    }
    this.COv = this.COv;
    if (this.COs != null) {
      this.COs.setVisibility(this.COv);
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