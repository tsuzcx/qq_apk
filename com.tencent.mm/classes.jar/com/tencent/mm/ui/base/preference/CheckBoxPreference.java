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
  private TextView Bod;
  private int Boe;
  private String Bof;
  private int Bog;
  public boolean mF;
  private View mView;
  private MMSwitchBtn tTm;
  
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
    this.mF = false;
    this.Boe = -1;
    this.Bof = "";
    this.Bog = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142512);
  }
  
  public void TD(int paramInt)
  {
    AppMethodBeat.i(142517);
    this.Bog = paramInt;
    if (this.Bod != null) {
      this.Bod.setVisibility(this.Bog);
    }
    AppMethodBeat.o(142517);
  }
  
  public void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(142516);
    this.Boe = paramInt;
    this.Bof = paramString;
    if (this.Bod != null)
    {
      if (paramInt > 0) {
        this.Bod.setBackgroundResource(this.Boe);
      }
      if (!TextUtils.isEmpty(this.Bof)) {
        this.Bod.setText(this.Bof);
      }
    }
    AppMethodBeat.o(142516);
  }
  
  public final boolean isChecked()
  {
    if (this.tTm != null) {
      return this.tTm.JaE;
    }
    return this.mF;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142514);
    super.onBindView(paramView);
    aam(8);
    this.tTm = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.tTm.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142511);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(142511);
      }
    });
    this.tTm.setCheck(this.mF);
    if (!isEnabled())
    {
      this.tTm.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100249));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100249));
    }
    this.Bod = ((TextView)paramView.findViewById(2131305883));
    eU(this.Bof, this.Boe);
    TD(this.Bog);
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
    this.mF = paramBoolean;
  }
  
  public final void wT(boolean paramBoolean)
  {
    AppMethodBeat.i(142515);
    if (this.tTm != null)
    {
      this.mF = paramBoolean;
      this.tTm.setCheck(paramBoolean);
    }
    AppMethodBeat.o(142515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */