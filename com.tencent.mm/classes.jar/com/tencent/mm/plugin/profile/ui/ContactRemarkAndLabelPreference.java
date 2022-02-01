package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView lHk;
  private Context mContext;
  private String rtC;
  private TextView xgS;
  private TextView xgT;
  private boolean xgU;
  private String xgV;
  private String xgW;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xgU = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.xgU = false;
    this.mContext = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.lHk = ((TextView)paramView.findViewById(2131305902));
    this.xgS = ((TextView)paramView.findViewById(2131303978));
    this.xgT = ((TextView)paramView.findViewById(2131301282));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.lHk != null) && (!bu.isNullOrNil(this.rtC)))
    {
      this.lHk.setVisibility(0);
      this.lHk.setText(this.rtC);
      localLayoutParams = (RelativeLayout.LayoutParams)this.lHk.getLayoutParams();
      localLayoutParams.width = a.ax(this.mContext, 2131165370);
      this.lHk.setLayoutParams(localLayoutParams);
    }
    if (this.xgS != null) {
      if (!this.xgU)
      {
        this.xgS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bu.isNullOrNil(this.xgV))
        {
          this.xgS.setVisibility(0);
          this.xgS.setText(k.b(this.mContext, bu.nullAsNil(this.xgV), this.xgS.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.xgT != null)
      {
        j = i;
        if (!bu.isNullOrNil(this.xgW))
        {
          j = i | 0x2;
          this.xgT.setVisibility(0);
          this.xgT.setText(this.xgW);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.xgS.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.xgT.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.xgS.setVisibility(0);
      this.xgS.setCompoundDrawablesWithIntrinsicBounds(2131689872, 0, 0, 0);
      i = 1;
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27045);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494843, localViewGroup);
    AppMethodBeat.o(27045);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */