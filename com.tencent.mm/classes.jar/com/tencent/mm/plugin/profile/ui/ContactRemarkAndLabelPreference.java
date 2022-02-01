package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView kEu;
  private Context mContext;
  private String pTa;
  private TextView uAZ;
  private TextView uBa;
  private boolean uBb;
  private String uBc;
  private String uBd;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uBb = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.uBb = false;
    this.mContext = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.kEu = ((TextView)paramView.findViewById(2131305902));
    this.uAZ = ((TextView)paramView.findViewById(2131303978));
    this.uBa = ((TextView)paramView.findViewById(2131301282));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.kEu != null) && (!bt.isNullOrNil(this.pTa)))
    {
      this.kEu.setVisibility(0);
      this.kEu.setText(this.pTa);
      localLayoutParams = (RelativeLayout.LayoutParams)this.kEu.getLayoutParams();
      localLayoutParams.width = a.ao(this.mContext, 2131165370);
      this.kEu.setLayoutParams(localLayoutParams);
    }
    if (this.uAZ != null) {
      if (!this.uBb)
      {
        this.uAZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bt.isNullOrNil(this.uBc))
        {
          this.uAZ.setVisibility(0);
          this.uAZ.setText(k.b(this.mContext, bt.nullAsNil(this.uBc), this.uAZ.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.uBa != null)
      {
        j = i;
        if (!bt.isNullOrNil(this.uBd))
        {
          j = i | 0x2;
          this.uBa.setVisibility(0);
          this.uBa.setText(this.uBd);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.uAZ.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.uBa.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.uAZ.setVisibility(0);
      this.uAZ.setCompoundDrawablesWithIntrinsicBounds(2131689872, 0, 0, 0);
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