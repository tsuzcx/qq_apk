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
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private TextView nBl;
  private ImageView uAA;
  private ImageView uAB;
  private int uAC;
  private int uAD;
  private int uAE;
  private int uAF;
  private int uAG;
  private int uAH;
  private ImageView uAw;
  private ImageView uAx;
  private ImageView uAy;
  private ImageView uAz;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uAC = 8;
    this.uAD = 8;
    this.uAE = 8;
    this.uAF = 8;
    this.uAG = 8;
    this.uAH = 8;
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27018);
    this.uAC = 8;
    this.uAD = 8;
    this.uAE = 8;
    this.uAF = 8;
    this.uAG = 8;
    this.uAH = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27018);
  }
  
  private void cE()
  {
    AppMethodBeat.i(27025);
    if (this.uAw != null) {
      this.uAw.setVisibility(this.uAC);
    }
    if (this.uAx != null) {
      this.uAx.setVisibility(this.uAD);
    }
    if (this.uAy != null) {
      this.uAy.setVisibility(this.uAE);
    }
    if (this.uAz != null) {
      this.uAz.setVisibility(this.uAF);
    }
    if (this.uAA != null) {
      this.uAA.setVisibility(this.uAG);
    }
    if (this.nBl != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.nBl.getLayoutParams();
      localLayoutParams.width = a.ao(this.mContext, 2131165370);
      this.nBl.setLayoutParams(localLayoutParams);
    }
    if (this.uAB != null) {
      this.uAB.setVisibility(this.uAH);
    }
    AppMethodBeat.o(27025);
  }
  
  public final void Jl(int paramInt)
  {
    AppMethodBeat.i(27021);
    this.uAD = paramInt;
    cE();
    AppMethodBeat.o(27021);
  }
  
  public final void Jm(int paramInt)
  {
    AppMethodBeat.i(27022);
    this.uAE = paramInt;
    cE();
    AppMethodBeat.o(27022);
  }
  
  public final void Jn(int paramInt)
  {
    AppMethodBeat.i(27023);
    this.uAG = paramInt;
    cE();
    AppMethodBeat.o(27023);
  }
  
  public final void Jo(int paramInt)
  {
    AppMethodBeat.i(27024);
    this.uAH = paramInt;
    cE();
    AppMethodBeat.o(27024);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27020);
    this.uAw = ((ImageView)paramView.findViewById(2131300953));
    this.uAx = ((ImageView)paramView.findViewById(2131300958));
    this.uAy = ((ImageView)paramView.findViewById(2131300949));
    this.uAz = ((ImageView)paramView.findViewById(2131300927));
    this.uAA = ((ImageView)paramView.findViewById(2131300937));
    this.uAB = ((ImageView)paramView.findViewById(2131300967));
    this.nBl = ((TextView)paramView.findViewById(2131305902));
    cE();
    super.onBindView(paramView);
    AppMethodBeat.o(27020);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27019);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494836, localViewGroup);
    AppMethodBeat.o(27019);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */