package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference
  extends CheckBoxPreference
{
  private int OAB;
  private String OAC;
  private int OAD;
  private TextView OEk;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.OAB = -1;
    this.OAC = "";
    this.OAD = 8;
    setLayoutResource(a.g.mm_preference_summary_icontip_checkbox);
    AppMethodBeat.o(69843);
  }
  
  public final void amm(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.OAD = paramInt;
    if (this.OEk != null) {
      this.OEk.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void gI(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.OAB = paramInt;
    this.OAC = paramString;
    if (this.OEk != null)
    {
      if (this.OAB > 0) {
        this.OEk.setBackgroundResource(this.OAB);
      }
      if (!TextUtils.isEmpty(this.OAC)) {
        this.OEk.setText(this.OAC);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.OEk = ((TextView)paramView.findViewById(a.f.tipicon));
    gI(this.OAC, this.OAB);
    amm(this.OAD);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */