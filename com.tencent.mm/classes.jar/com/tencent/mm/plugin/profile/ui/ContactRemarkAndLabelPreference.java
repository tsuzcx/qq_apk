package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ci.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView GYD;
  private TextView GYE;
  private boolean GYF;
  private String GYG;
  private String GYH;
  private Context mContext;
  private TextView pPT;
  private String wAb;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.GYF = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.GYF = false;
    this.mContext = paramContext;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.pPT = ((TextView)paramView.findViewById(R.h.title));
    this.GYD = ((TextView)paramView.findViewById(R.h.dSF));
    this.GYE = ((TextView)paramView.findViewById(R.h.label));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.pPT != null) && (!Util.isNullOrNil(this.wAb)))
    {
      this.pPT.setVisibility(0);
      this.pPT.setText(this.wAb);
      localLayoutParams = (RelativeLayout.LayoutParams)this.pPT.getLayoutParams();
      localLayoutParams.width = a.aY(this.mContext, R.f.FixedTitleWidth);
      this.pPT.setLayoutParams(localLayoutParams);
    }
    if (this.GYD != null) {
      if (!this.GYF)
      {
        this.GYD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!Util.isNullOrNil(this.GYG))
        {
          this.GYD.setVisibility(0);
          this.GYD.setText(l.b(this.mContext, Util.nullAsNil(this.GYG), this.GYD.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.GYE != null)
      {
        j = i;
        if (!Util.isNullOrNil(this.GYH))
        {
          j = i | 0x2;
          this.GYE.setVisibility(0);
          this.GYE.setText(this.GYH);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.GYD.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.GYE.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.GYD.setVisibility(0);
      this.GYD.setCompoundDrawablesWithIntrinsicBounds(R.k.card_photoicon, 0, 0, 0);
      i = 1;
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27045);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eiX, localViewGroup);
    AppMethodBeat.o(27045);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */