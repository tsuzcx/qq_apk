package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public class CheckPreference
  extends Preference
{
  private int VpO;
  private String VpP;
  private int VpQ;
  private TextView Vtv;
  private CheckBox adXS;
  public int adXT;
  public boolean duj;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142518);
    this.duj = false;
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    this.adXT = -1;
    setLayoutResource(a.h.mm_preference_summary_check);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.adXS = ((CheckBox)paramView.findViewById(a.g.checkbox));
    this.adXS.setChecked(this.duj);
    this.Vtv = ((TextView)paramView.findViewById(a.g.tipicon));
    paramView = this.VpP;
    int i = this.VpO;
    this.VpO = i;
    this.VpP = paramView;
    if (this.Vtv != null)
    {
      if (i > 0) {
        this.Vtv.setBackgroundResource(this.VpO);
      }
      if (!TextUtils.isEmpty(this.VpP)) {
        this.Vtv.setText(this.VpP);
      }
    }
    this.VpQ = this.VpQ;
    if (this.Vtv != null) {
      this.Vtv.setVisibility(this.VpQ);
    }
    paramView = (LinearLayout.LayoutParams)this.adXS.getLayoutParams();
    if (-1 != this.adXT) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.adXT, paramView.bottomMargin);
    }
    AppMethodBeat.o(142520);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142519);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(142519);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */