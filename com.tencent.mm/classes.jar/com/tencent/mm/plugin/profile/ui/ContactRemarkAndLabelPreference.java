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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView lCL;
  private Context mContext;
  private String rlx;
  private TextView wRb;
  private TextView wRc;
  private boolean wRd;
  private String wRe;
  private String wRf;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.wRd = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.wRd = false;
    this.mContext = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.lCL = ((TextView)paramView.findViewById(2131305902));
    this.wRb = ((TextView)paramView.findViewById(2131303978));
    this.wRc = ((TextView)paramView.findViewById(2131301282));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.lCL != null) && (!bt.isNullOrNil(this.rlx)))
    {
      this.lCL.setVisibility(0);
      this.lCL.setText(this.rlx);
      localLayoutParams = (RelativeLayout.LayoutParams)this.lCL.getLayoutParams();
      localLayoutParams.width = a.ax(this.mContext, 2131165370);
      this.lCL.setLayoutParams(localLayoutParams);
    }
    if (this.wRb != null) {
      if (!this.wRd)
      {
        this.wRb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bt.isNullOrNil(this.wRe))
        {
          this.wRb.setVisibility(0);
          this.wRb.setText(k.b(this.mContext, bt.nullAsNil(this.wRe), this.wRb.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.wRc != null)
      {
        j = i;
        if (!bt.isNullOrNil(this.wRf))
        {
          j = i | 0x2;
          this.wRc.setVisibility(0);
          this.wRc.setText(this.wRf);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.wRb.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.wRc.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.wRb.setVisibility(0);
      this.wRb.setCompoundDrawablesWithIntrinsicBounds(2131689872, 0, 0, 0);
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