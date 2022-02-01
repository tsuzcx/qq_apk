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
  private TextView COs;
  private int COt;
  private String COu;
  private int COv;
  private View mView;
  public boolean oB;
  private MMSwitchBtn rck;
  
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
    this.COt = -1;
    this.COu = "";
    this.COv = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142512);
  }
  
  public void Vv(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.COv = paramInt;
    if (this.COs != null) {
      this.COs.setVisibility(this.COv);
    }
    AppMethodBeat.o(142517);
  }
  
  public void fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.COt = paramInt;
    this.COu = paramString;
    if (this.COs != null)
    {
      if (paramInt > 0) {
        this.COs.setBackgroundResource(this.COt);
      }
      if (!TextUtils.isEmpty(this.COu)) {
        this.COs.setText(this.COu);
      }
    }
    AppMethodBeat.o(142516);
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
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    acw(8);
    this.rck = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.rck.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.rck.setCheck(this.oB);
    if (!isEnabled())
    {
      this.rck.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100249));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100249));
    }
    this.COs = ((TextView)paramView.findViewById(2131305883));
    fn(this.COu, this.COt);
    Vv(this.COv);
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
    this.oB = paramBoolean;
  }
  
  public final void xE(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.rck != null)
    {
      this.oB = paramBoolean;
      this.rck.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */