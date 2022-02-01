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
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView MWG;
  private TextView MWH;
  private boolean MWI;
  private String MWJ;
  private String MWK;
  private Context mContext;
  private TextView sUt;
  private String zWm;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.MWI = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27044);
    this.MWI = false;
    this.mContext = paramContext;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27044);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27046);
    this.sUt = ((TextView)paramView.findViewById(R.h.title));
    this.MWG = ((TextView)paramView.findViewById(R.h.fUI));
    this.MWH = ((TextView)paramView.findViewById(R.h.label));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.sUt != null) && (!Util.isNullOrNil(this.zWm)))
    {
      this.sUt.setVisibility(0);
      this.sUt.setText(this.zWm);
      localLayoutParams = (RelativeLayout.LayoutParams)this.sUt.getLayoutParams();
      localLayoutParams.width = a.br(this.mContext, R.f.FixedTitleWidth);
      this.sUt.setLayoutParams(localLayoutParams);
    }
    if (this.MWG != null) {
      if (!this.MWI)
      {
        this.MWG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!Util.isNullOrNil(this.MWJ))
        {
          this.MWG.setVisibility(0);
          this.MWG.setText(p.b(this.mContext, Util.nullAsNil(this.MWJ), this.MWG.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.MWH != null)
      {
        j = i;
        if (!Util.isNullOrNil(this.MWK))
        {
          j = i | 0x2;
          this.MWH.setVisibility(0);
          this.MWH.setText(this.MWK);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.MWG.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.MWH.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27046);
      return;
      this.MWG.setVisibility(0);
      this.MWG.setCompoundDrawablesWithIntrinsicBounds(R.k.card_photoicon, 0, 0, 0);
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
    localLayoutInflater.inflate(R.i.glX, localViewGroup);
    AppMethodBeat.o(27045);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */