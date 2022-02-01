package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference
  extends CheckBoxPreference
{
  private int HIJ;
  private String HIK;
  private int HIL;
  private TextView HMo;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.HIJ = -1;
    this.HIK = "";
    this.HIL = 8;
    setLayoutResource(2131495629);
    AppMethodBeat.o(69843);
  }
  
  public final void aez(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.HIL = paramInt;
    if (this.HMo != null) {
      this.HMo.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void fZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.HIJ = paramInt;
    this.HIK = paramString;
    if (this.HMo != null)
    {
      if (this.HIJ > 0) {
        this.HMo.setBackgroundResource(this.HIJ);
      }
      if (!TextUtils.isEmpty(this.HIK)) {
        this.HMo.setText(this.HIK);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.HMo = ((TextView)paramView.findViewById(2131309166));
    fZ(this.HIK, this.HIJ);
    aez(this.HIL);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */