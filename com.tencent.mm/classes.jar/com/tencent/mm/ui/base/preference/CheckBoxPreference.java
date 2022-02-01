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
  private int DcV;
  private String DcW;
  private int DcX;
  private TextView Dga;
  private View mView;
  private boolean oB;
  private MMSwitchBtn rkq;
  
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
    this.oB = false;
    this.DcV = -1;
    this.DcW = "";
    this.DcX = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142512);
  }
  
  public void VX(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.DcX = paramInt;
    if (this.Dga != null) {
      this.Dga.setVisibility(this.DcX);
    }
    AppMethodBeat.o(142517);
  }
  
  public void fw(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.DcV = paramInt;
    this.DcW = paramString;
    if (this.Dga != null)
    {
      if (paramInt > 0) {
        this.Dga.setBackgroundResource(this.DcV);
      }
      if (!TextUtils.isEmpty(this.DcW)) {
        this.Dga.setText(this.DcW);
      }
    }
    AppMethodBeat.o(142516);
  }
  
  public boolean isChecked()
  {
    if (this.rkq != null) {
      return this.rkq.Lon;
    }
    return this.oB;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    ade(8);
    this.rkq = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.rkq.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.rkq.setCheck(this.oB);
    if (!isEnabled())
    {
      this.rkq.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100249));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100249));
    }
    this.Dga = ((TextView)paramView.findViewById(2131305883));
    fw(this.DcW, this.DcV);
    VX(this.DcX);
    AppMethodBeat.o(142514);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
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
  
  public void setChecked(boolean paramBoolean)
  {
    this.oB = paramBoolean;
  }
  
  public void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.rkq != null)
    {
      this.oB = paramBoolean;
      this.rkq.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */