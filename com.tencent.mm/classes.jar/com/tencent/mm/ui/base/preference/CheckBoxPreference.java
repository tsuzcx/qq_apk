package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
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
  public boolean lG;
  private View mView;
  private MMSwitchBtn sLH;
  private TextView zVJ;
  private int zVK;
  private String zVL;
  private int zVM;
  
  public CheckBoxPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142512);
    this.lG = false;
    this.zVK = -1;
    this.zVL = "";
    this.zVM = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142512);
  }
  
  public void Ru(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.zVM = paramInt;
    if (this.zVJ != null) {
      this.zVJ.setVisibility(this.zVM);
    }
    AppMethodBeat.o(142517);
  }
  
  public void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.zVK = paramInt;
    this.zVL = paramString;
    if (this.zVJ != null)
    {
      if (paramInt > 0) {
        this.zVJ.setBackgroundResource(this.zVK);
      }
      if (!TextUtils.isEmpty(this.zVL)) {
        this.zVJ.setText(this.zVL);
      }
    }
    AppMethodBeat.o(142516);
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
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    Yb(8);
    this.sLH = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.sLH.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.sLH.setCheck(this.lG);
    if (!isEnabled())
    {
      this.sLH.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100249));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100249));
    }
    this.zVJ = ((TextView)paramView.findViewById(2131305883));
    eM(this.zVL, this.zVK);
    Ru(this.zVM);
    AppMethodBeat.o(142514);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142513);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494889, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(142513);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.lG = paramBoolean;
  }
  
  public final void vP(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.sLH != null)
    {
      this.lG = paramBoolean;
      this.sLH.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */