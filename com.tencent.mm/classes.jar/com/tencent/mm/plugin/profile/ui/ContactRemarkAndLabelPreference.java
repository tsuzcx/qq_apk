package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView lfN;
  private Context mContext;
  private String qBH;
  private TextView vJS;
  private TextView vJT;
  private boolean vJU;
  private String vJV;
  private String vJW;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.vJU = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.vJU = false;
    this.mContext = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.lfN = ((TextView)paramView.findViewById(2131305902));
    this.vJS = ((TextView)paramView.findViewById(2131303978));
    this.vJT = ((TextView)paramView.findViewById(2131301282));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.lfN != null) && (!bs.isNullOrNil(this.qBH)))
    {
      this.lfN.setVisibility(0);
      this.lfN.setText(this.qBH);
      localLayoutParams = (RelativeLayout.LayoutParams)this.lfN.getLayoutParams();
      localLayoutParams.width = a.au(this.mContext, 2131165370);
      this.lfN.setLayoutParams(localLayoutParams);
    }
    if (this.vJS != null) {
      if (!this.vJU)
      {
        this.vJS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bs.isNullOrNil(this.vJV))
        {
          this.vJS.setVisibility(0);
          this.vJS.setText(k.b(this.mContext, bs.nullAsNil(this.vJV), this.vJS.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.vJT != null)
      {
        j = i;
        if (!bs.isNullOrNil(this.vJW))
        {
          j = i | 0x2;
          this.vJT.setVisibility(0);
          this.vJT.setText(this.vJW);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.vJS.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.vJT.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.vJS.setVisibility(0);
      this.vJS.setCompoundDrawablesWithIntrinsicBounds(2131689872, 0, 0, 0);
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