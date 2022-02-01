package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public class RadioCheckPreference
  extends Preference
{
  private int VpO;
  private String VpP;
  private int VpQ;
  private TextView Vtv;
  private CheckBox adXS;
  private int adXT;
  private boolean duj;
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142666);
    this.duj = false;
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    this.adXT = -1;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142666);
  }
  
  public final void Hy(boolean paramBoolean)
  {
    AppMethodBeat.i(142669);
    this.duj = paramBoolean;
    if (this.adXS != null) {
      this.adXS.setChecked(paramBoolean);
    }
    AppMethodBeat.o(142669);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142668);
    super.onBindView(paramView);
    aBq(8);
    this.adXS = ((CheckBox)paramView.findViewById(a.g.radiocheck));
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
    AppMethodBeat.o(142668);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142667);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_summary_radio_check, localViewGroup);
    AppMethodBeat.o(142667);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.RadioCheckPreference
 * JD-Core Version:    0.7.0.1
 */