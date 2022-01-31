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

public class CheckBoxPreference
  extends Preference
{
  private MMSwitchBtn iDy;
  private View mView;
  private TextView ubi;
  private int ubj;
  private String ubk;
  private int ubl;
  public boolean vxW;
  
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
    AppMethodBeat.i(107135);
    this.vxW = false;
    this.ubj = -1;
    this.ubk = "";
    this.ubl = 8;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107135);
  }
  
  public void Iu(int paramInt)
  {
    AppMethodBeat.i(107140);
    this.ubl = paramInt;
    if (this.ubi != null) {
      this.ubi.setVisibility(this.ubl);
    }
    AppMethodBeat.o(107140);
  }
  
  public void dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(107139);
    this.ubj = paramInt;
    this.ubk = paramString;
    if (this.ubi != null)
    {
      if (paramInt > 0) {
        this.ubi.setBackgroundResource(this.ubj);
      }
      if (!TextUtils.isEmpty(this.ubk)) {
        this.ubi.setText(this.ubk);
      }
    }
    AppMethodBeat.o(107139);
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
    AppMethodBeat.i(107137);
    super.onBindView(paramView);
    OW(8);
    this.iDy = ((MMSwitchBtn)paramView.findViewById(2131820950));
    this.iDy.setSwitchListener(new CheckBoxPreference.1(this));
    this.iDy.setCheck(this.vxW);
    if (!isEnabled())
    {
      this.iDy.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131689963));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131689963));
    }
    this.ubi = ((TextView)paramView.findViewById(2131826257));
    dE(this.ubk, this.ubj);
    Iu(this.ubl);
    AppMethodBeat.o(107137);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107136);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970259, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(107136);
    return paramViewGroup;
  }
  
  public final void qH(boolean paramBoolean)
  {
    AppMethodBeat.i(107138);
    if (this.iDy != null)
    {
      this.vxW = paramBoolean;
      this.iDy.setCheck(paramBoolean);
    }
    AppMethodBeat.o(107138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */