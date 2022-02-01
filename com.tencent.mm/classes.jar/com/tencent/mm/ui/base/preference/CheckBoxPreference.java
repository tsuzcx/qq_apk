package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  private int VpO;
  private String VpP;
  private int VpQ;
  private TextView Vtv;
  private boolean adXL;
  public boolean adXM;
  public boolean adXN;
  private ImageView adXO;
  public TextView adXP;
  public CheckBoxPreference.a adXQ;
  private boolean duj;
  private View mView;
  private View.OnClickListener mWW;
  private MMSwitchBtn zNX;
  
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
    this.duj = false;
    this.adXL = false;
    this.adXM = false;
    this.adXN = true;
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142512);
  }
  
  private void jng()
  {
    AppMethodBeat.i(251506);
    if ((this.mView != null) && (this.mWW != null)) {
      this.mView.setOnClickListener(this.mWW);
    }
    AppMethodBeat.o(251506);
  }
  
  private void jnh()
  {
    AppMethodBeat.i(251507);
    if ((isEnabled()) && (!this.adXL))
    {
      if ((this.adXO != null) && (this.zNX != null))
      {
        if (!this.adXM) {
          break label90;
        }
        this.adXO.setVisibility(0);
        this.zNX.setVisibility(4);
      }
      for (;;)
      {
        ((TextView)this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(a.d.normal_text_color));
        AppMethodBeat.o(251507);
        return;
        label90:
        this.adXO.setVisibility(8);
        this.zNX.setVisibility(0);
      }
    }
    if ((this.zNX != null) && (this.mView != null) && (this.adXO != null))
    {
      ColorStateList localColorStateList = ((TextView)this.mView.findViewById(16908310)).getTextColors();
      setEnabled(false);
      ((TextView)this.mView.findViewById(16908310)).setTextColor(localColorStateList);
      if (this.adXM)
      {
        this.adXO.setVisibility(0);
        this.zNX.setVisibility(4);
      }
      while (!isEnabled())
      {
        if (!this.adXN) {
          break label287;
        }
        ((TextView)this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(a.d.disable_text_color));
        AppMethodBeat.o(251507);
        return;
        this.adXO.setVisibility(8);
        this.zNX.setVisibility(0);
      }
      ((TextView)this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(a.d.normal_text_color));
    }
    label287:
    AppMethodBeat.o(251507);
  }
  
  public void Hy(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.zNX != null)
    {
      this.duj = paramBoolean;
      this.zNX.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
  
  public void arW(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.VpQ = paramInt;
    if (this.Vtv != null) {
      this.Vtv.setVisibility(this.VpQ);
    }
    AppMethodBeat.o(142517);
  }
  
  protected int getLayoutId()
  {
    return a.h.mm_preference_summary_checkbox;
  }
  
  public void hF(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.VpO = paramInt;
    this.VpP = paramString;
    if (this.Vtv != null)
    {
      if (paramInt > 0) {
        this.Vtv.setBackgroundResource(this.VpO);
      }
      if (!TextUtils.isEmpty(this.VpP)) {
        this.Vtv.setText(this.VpP);
      }
    }
    AppMethodBeat.o(142516);
  }
  
  public boolean isChecked()
  {
    if (this.zNX != null) {
      return this.zNX.afTT;
    }
    return this.duj;
  }
  
  public final void jne()
  {
    AppMethodBeat.i(251513);
    this.adXL = true;
    jnh();
    AppMethodBeat.o(251513);
  }
  
  public final void jnf()
  {
    AppMethodBeat.i(251517);
    this.adXL = false;
    jnh();
    AppMethodBeat.o(251517);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    aBq(8);
    this.mView = paramView;
    this.adXP = ((TextView)paramView.findViewById(16908304));
    this.zNX = ((MMSwitchBtn)paramView.findViewById(a.g.checkbox));
    this.adXO = ((ImageView)paramView.findViewById(a.g.checkbox_mask));
    this.zNX.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.gH(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.zNX.setCheck(this.duj);
    this.Vtv = ((TextView)paramView.findViewById(a.g.tipicon));
    hF(this.VpP, this.VpO);
    arW(this.VpQ);
    jnh();
    if (this.adXQ != null) {
      this.adXQ.afterOnBind(paramView);
    }
    AppMethodBeat.o(142514);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142513);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, getLayoutId(), localViewGroup);
    this.mView = paramViewGroup;
    jng();
    paramViewGroup = this.mView;
    AppMethodBeat.o(142513);
    return paramViewGroup;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.duj = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251512);
    this.mWW = paramOnClickListener;
    jng();
    AppMethodBeat.o(251512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */