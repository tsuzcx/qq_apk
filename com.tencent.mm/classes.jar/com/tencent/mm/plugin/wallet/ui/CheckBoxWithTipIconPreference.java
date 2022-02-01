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
  private int VpO;
  private String VpP;
  private int VpQ;
  private TextView Vtv;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    setLayoutResource(a.g.mm_preference_summary_icontip_checkbox);
    AppMethodBeat.o(69843);
  }
  
  public final void arW(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.VpQ = paramInt;
    if (this.Vtv != null) {
      this.Vtv.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void hF(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.VpO = paramInt;
    this.VpP = paramString;
    if (this.Vtv != null)
    {
      if (this.VpO > 0) {
        this.Vtv.setBackgroundResource(this.VpO);
      }
      if (!TextUtils.isEmpty(this.VpP)) {
        this.Vtv.setText(this.VpP);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.Vtv = ((TextView)paramView.findViewById(a.f.tipicon));
    hF(this.VpP, this.VpO);
    arW(this.VpQ);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */