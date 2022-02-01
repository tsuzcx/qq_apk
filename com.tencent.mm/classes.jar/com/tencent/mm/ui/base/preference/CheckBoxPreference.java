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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  private int OAB;
  private String OAC;
  private int OAD;
  private TextView OEk;
  private TextView WqA;
  private CheckBoxPreference.a WqB;
  private boolean Wqz;
  private boolean bBh;
  private View.OnClickListener kte;
  private View mView;
  private MMSwitchBtn wrR;
  
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
    this.bBh = false;
    this.Wqz = false;
    this.OAB = -1;
    this.OAC = "";
    this.OAD = 8;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142512);
  }
  
  private void hKC()
  {
    AppMethodBeat.i(195363);
    if ((this.mView != null) && (this.kte != null)) {
      this.mView.setOnClickListener(this.kte);
    }
    AppMethodBeat.o(195363);
  }
  
  private void hKD()
  {
    AppMethodBeat.i(195369);
    if ((isEnabled()) && (!this.Wqz))
    {
      AppMethodBeat.o(195369);
      return;
    }
    if ((this.wrR != null) && (this.mView != null))
    {
      this.wrR.setEnabled(false);
      if (!isEnabled())
      {
        ((TextView)this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(a.d.disable_text_color));
        ((TextView)this.mView.findViewById(16908304)).setTextColor(this.mView.getResources().getColor(a.d.disable_text_color));
      }
    }
    AppMethodBeat.o(195369);
  }
  
  public void BT(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.wrR != null)
    {
      this.bBh = paramBoolean;
      this.wrR.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
  
  public final void a(CheckBoxPreference.a parama)
  {
    this.WqB = parama;
  }
  
  public void amm(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.OAD = paramInt;
    if (this.OEk != null) {
      this.OEk.setVisibility(this.OAD);
    }
    AppMethodBeat.o(142517);
  }
  
  public void gI(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.OAB = paramInt;
    this.OAC = paramString;
    if (this.OEk != null)
    {
      if (paramInt > 0) {
        this.OEk.setBackgroundResource(this.OAB);
      }
      if (!TextUtils.isEmpty(this.OAC)) {
        this.OEk.setText(this.OAC);
      }
    }
    AppMethodBeat.o(142516);
  }
  
  protected int getLayoutId()
  {
    return a.h.mm_preference_summary_checkbox;
  }
  
  public final TextView hKA()
  {
    return this.WqA;
  }
  
  public final void hKB()
  {
    AppMethodBeat.i(195359);
    this.Wqz = true;
    hKD();
    AppMethodBeat.o(195359);
  }
  
  public boolean isChecked()
  {
    if (this.wrR != null) {
      return this.wrR.YbZ;
    }
    return this.bBh;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    auO(8);
    this.WqA = ((TextView)paramView.findViewById(16908304));
    this.wrR = ((MMSwitchBtn)paramView.findViewById(a.g.checkbox));
    this.wrR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.ej(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.wrR.setCheck(this.bBh);
    this.OEk = ((TextView)paramView.findViewById(a.g.tipicon));
    gI(this.OAC, this.OAB);
    amm(this.OAD);
    hKD();
    if (this.WqB != null) {
      this.WqB.edU();
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
    hKC();
    paramViewGroup = this.mView;
    AppMethodBeat.o(142513);
    return paramViewGroup;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.bBh = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195357);
    this.kte = paramOnClickListener;
    hKC();
    AppMethodBeat.o(195357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */