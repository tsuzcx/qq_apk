package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private MMActivity cmc;
  private String mTitle;
  private String pAS;
  private int qGe;
  private int qGf;
  private TextView rNL;
  String rNM;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(38733);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(38733);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38734);
    this.pAS = "";
    this.mTitle = "";
    this.qGe = -1;
    this.qGf = 8;
    this.rNL = null;
    this.rNM = "";
    this.cmc = ((MMActivity)paramContext);
    setLayoutResource(2130970179);
    AppMethodBeat.o(38734);
  }
  
  public final void cuM()
  {
    AppMethodBeat.i(38735);
    if ((this.rNL != null) && (this.rNM != null) && (!this.rNM.equals("")) && (this.cmc != null))
    {
      String str = this.cmc.getString(2131303433, new Object[] { this.rNM });
      this.rNL.setText(str);
    }
    AppMethodBeat.o(38735);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(38737);
    super.onBindView(paramView);
    this.rNL = ((TextView)paramView.findViewById(2131826193));
    ((TextView)paramView.findViewById(2131826192)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131822409);
    if (paramView != null)
    {
      paramView.setVisibility(this.qGf);
      paramView.setText(this.pAS);
      if (this.qGe != -1) {
        paramView.setBackgroundDrawable(a.k(this.cmc, this.qGe));
      }
    }
    cuM();
    AppMethodBeat.o(38737);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38736);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    this.mTitle = this.cmc.getString(2131303434);
    localLayoutInflater.inflate(2130970181, localViewGroup);
    AppMethodBeat.o(38736);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */