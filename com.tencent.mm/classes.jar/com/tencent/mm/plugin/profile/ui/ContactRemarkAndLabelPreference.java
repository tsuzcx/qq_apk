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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView BeF;
  private TextView BeG;
  private boolean BeH;
  private String BeI;
  private String BeJ;
  private Context mContext;
  private TextView mPa;
  private String sUf;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.BeH = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.BeH = false;
    this.mContext = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.mPa = ((TextView)paramView.findViewById(2131309195));
    this.BeF = ((TextView)paramView.findViewById(2131306832));
    this.BeG = ((TextView)paramView.findViewById(2131302979));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mPa != null) && (!Util.isNullOrNil(this.sUf)))
    {
      this.mPa.setVisibility(0);
      this.mPa.setText(this.sUf);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mPa.getLayoutParams();
      localLayoutParams.width = a.aG(this.mContext, 2131165381);
      this.mPa.setLayoutParams(localLayoutParams);
    }
    if (this.BeF != null) {
      if (!this.BeH)
      {
        this.BeF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!Util.isNullOrNil(this.BeI))
        {
          this.BeF.setVisibility(0);
          this.BeF.setText(l.b(this.mContext, Util.nullAsNil(this.BeI), this.BeF.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.BeG != null)
      {
        j = i;
        if (!Util.isNullOrNil(this.BeJ))
        {
          j = i | 0x2;
          this.BeG.setVisibility(0);
          this.BeG.setText(this.BeJ);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.BeF.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.BeG.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.BeF.setVisibility(0);
      this.BeF.setCompoundDrawablesWithIntrinsicBounds(2131689887, 0, 0, 0);
      i = 1;
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27045);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495578, localViewGroup);
    AppMethodBeat.o(27045);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */