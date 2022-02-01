package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
  private boolean OXp;
  private TextView OXq;
  private a OXr;
  private View.OnClickListener hEZ;
  private View mView;
  private boolean oD;
  private MMSwitchBtn sLW;
  
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
    this.oD = false;
    this.OXp = false;
    this.HIJ = -1;
    this.HIK = "";
    this.HIL = 8;
    setLayoutResource(2131495538);
    AppMethodBeat.o(142512);
  }
  
  private void gLA()
  {
    AppMethodBeat.i(205292);
    if ((this.mView != null) && (this.hEZ != null)) {
      this.mView.setOnClickListener(this.hEZ);
    }
    AppMethodBeat.o(205292);
  }
  
  private void gLB()
  {
    AppMethodBeat.i(205293);
    if ((isEnabled()) && (!this.OXp))
    {
      AppMethodBeat.o(205293);
      return;
    }
    if ((this.sLW != null) && (this.mView != null))
    {
      this.sLW.setEnabled(false);
      if (!isEnabled())
      {
        ((TextView)this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(2131100283));
        ((TextView)this.mView.findViewById(16908304)).setTextColor(this.mView.getResources().getColor(2131100283));
      }
    }
    AppMethodBeat.o(205293);
  }
  
  public final void a(a parama)
  {
    this.OXr = parama;
  }
  
  public void aez(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.HIL = paramInt;
    if (this.HMo != null) {
      this.HMo.setVisibility(this.HIL);
    }
    AppMethodBeat.o(142517);
  }
  
  public void fZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.HIJ = paramInt;
    this.HIK = paramString;
    if (this.HMo != null)
    {
      if (paramInt > 0) {
        this.HMo.setBackgroundResource(this.HIJ);
      }
      if (!TextUtils.isEmpty(this.HIK)) {
        this.HMo.setText(this.HIK);
      }
    }
    AppMethodBeat.o(142516);
  }
  
  public final TextView gLy()
  {
    return this.OXq;
  }
  
  public final void gLz()
  {
    AppMethodBeat.i(205291);
    this.OXp = true;
    gLB();
    AppMethodBeat.o(205291);
  }
  
  public boolean isChecked()
  {
    if (this.sLW != null) {
      return this.sLW.QDw;
    }
    return this.oD;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    alO(8);
    this.OXq = ((TextView)paramView.findViewById(16908304));
    this.sLW = ((MMSwitchBtn)paramView.findViewById(2131298639));
    this.sLW.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.sLW.setCheck(this.oD);
    this.HMo = ((TextView)paramView.findViewById(2131309166));
    fZ(this.HIK, this.HIJ);
    aez(this.HIL);
    gLB();
    if (this.OXr != null) {
      this.OXr.dCy();
    }
    AppMethodBeat.o(142514);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142513);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495627, localViewGroup);
    this.mView = paramViewGroup;
    gLA();
    paramViewGroup = this.mView;
    AppMethodBeat.o(142513);
    return paramViewGroup;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.oD = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(205290);
    this.hEZ = paramOnClickListener;
    gLA();
    AppMethodBeat.o(205290);
  }
  
  public void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.sLW != null)
    {
      this.oD = paramBoolean;
      this.sLW.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
  
  public static abstract interface a
  {
    public abstract void dCy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */