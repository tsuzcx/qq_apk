package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private ImageView MWb;
  private ImageView MWc;
  private ImageView MWd;
  private ImageView MWe;
  private ImageView MWf;
  private ImageView MWg;
  private int MWh;
  private int MWi;
  private int MWj;
  private int MWk;
  private int MWl;
  private int MWm;
  private TextView wCq;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.MWh = 8;
    this.MWi = 8;
    this.MWj = 8;
    this.MWk = 8;
    this.MWl = 8;
    this.MWm = 8;
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27018);
    this.MWh = 8;
    this.MWi = 8;
    this.MWj = 8;
    this.MWk = 8;
    this.MWl = 8;
    this.MWm = 8;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27018);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27020);
    this.MWb = ((ImageView)paramView.findViewById(R.h.fKk));
    this.MWc = ((ImageView)paramView.findViewById(R.h.fKo));
    this.MWd = ((ImageView)paramView.findViewById(R.h.fKj));
    this.MWe = ((ImageView)paramView.findViewById(R.h.fJZ));
    this.MWf = ((ImageView)paramView.findViewById(R.h.fKf));
    this.MWg = ((ImageView)paramView.findViewById(R.h.fKr));
    this.wCq = ((TextView)paramView.findViewById(R.h.title));
    if (this.MWb != null) {
      this.MWb.setVisibility(this.MWh);
    }
    if (this.MWc != null) {
      this.MWc.setVisibility(this.MWi);
    }
    if (this.MWd != null) {
      this.MWd.setVisibility(this.MWj);
    }
    if (this.MWe != null) {
      this.MWe.setVisibility(this.MWk);
    }
    if (this.MWf != null) {
      this.MWf.setVisibility(this.MWl);
    }
    if (this.wCq != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.wCq.getLayoutParams();
      localLayoutParams.width = a.br(this.mContext, R.f.FixedTitleWidth);
      this.wCq.setLayoutParams(localLayoutParams);
    }
    if (this.MWg != null) {
      this.MWg.setVisibility(this.MWm);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27020);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27019);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.glV, localViewGroup);
    AppMethodBeat.o(27019);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */