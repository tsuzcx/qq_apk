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

public class ContactSocialInfoPreference
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
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uAC = 8;
    this.uAD = 8;
    this.uAE = 8;
    this.uAF = 8;
    this.uAG = 8;
    this.uAH = 8;
  }
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27047);
    this.uAC = 8;
    this.uAD = 8;
    this.uAE = 8;
    this.uAF = 8;
    this.uAG = 8;
    this.uAH = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27047);
  }
  
  private void cE()
  {
    AppMethodBeat.i(27055);
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
    AppMethodBeat.o(27055);
  }
  
  public final void Jl(int paramInt)
  {
    AppMethodBeat.i(27051);
    this.uAD = paramInt;
    cE();
    AppMethodBeat.o(27051);
  }
  
  public final void Jm(int paramInt)
  {
    AppMethodBeat.i(27052);
    this.uAE = paramInt;
    cE();
    AppMethodBeat.o(27052);
  }
  
  public final void Jn(int paramInt)
  {
    AppMethodBeat.i(27053);
    this.uAG = paramInt;
    cE();
    AppMethodBeat.o(27053);
  }
  
  public final void Jo(int paramInt)
  {
    AppMethodBeat.i(27054);
    this.uAH = paramInt;
    cE();
    AppMethodBeat.o(27054);
  }
  
  public final void Jp(int paramInt)
  {
    AppMethodBeat.i(27050);
    this.uAC = paramInt;
    cE();
    AppMethodBeat.o(27050);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27049);
    this.uAw = ((ImageView)paramView.findViewById(2131300953));
    this.uAx = ((ImageView)paramView.findViewById(2131300958));
    this.uAy = ((ImageView)paramView.findViewById(2131300949));
    this.uAz = ((ImageView)paramView.findViewById(2131300927));
    this.uAA = ((ImageView)paramView.findViewById(2131300937));
    this.uAB = ((ImageView)paramView.findViewById(2131300967));
    this.nBl = ((TextView)paramView.findViewById(2131305902));
    cE();
    super.onBindView(paramView);
    AppMethodBeat.o(27049);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27048);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494848, localViewGroup);
    AppMethodBeat.o(27048);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference
 * JD-Core Version:    0.7.0.1
 */