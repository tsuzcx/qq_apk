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
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference
  extends Preference
{
  private TextView oHF;
  private ImageView wQA;
  private ImageView wQB;
  private ImageView wQC;
  private ImageView wQD;
  private int wQE;
  private int wQF;
  private int wQG;
  private int wQH;
  private int wQI;
  private int wQJ;
  private ImageView wQy;
  private ImageView wQz;
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.wQE = 8;
    this.wQF = 8;
    this.wQG = 8;
    this.wQH = 8;
    this.wQI = 8;
    this.wQJ = 8;
  }
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27047);
    this.wQE = 8;
    this.wQF = 8;
    this.wQG = 8;
    this.wQH = 8;
    this.wQI = 8;
    this.wQJ = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27047);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(27055);
    if (this.wQy != null) {
      this.wQy.setVisibility(this.wQE);
    }
    if (this.wQz != null) {
      this.wQz.setVisibility(this.wQF);
    }
    if (this.wQA != null) {
      this.wQA.setVisibility(this.wQG);
    }
    if (this.wQB != null) {
      this.wQB.setVisibility(this.wQH);
    }
    if (this.wQC != null) {
      this.wQC.setVisibility(this.wQI);
    }
    if (this.oHF != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.oHF.getLayoutParams();
      localLayoutParams.width = a.ax(this.mContext, 2131165370);
      this.oHF.setLayoutParams(localLayoutParams);
    }
    if (this.wQD != null) {
      this.wQD.setVisibility(this.wQJ);
    }
    AppMethodBeat.o(27055);
  }
  
  public final void MM(int paramInt)
  {
    AppMethodBeat.i(27051);
    this.wQF = paramInt;
    updateView();
    AppMethodBeat.o(27051);
  }
  
  public final void MN(int paramInt)
  {
    AppMethodBeat.i(27052);
    this.wQG = paramInt;
    updateView();
    AppMethodBeat.o(27052);
  }
  
  public final void MO(int paramInt)
  {
    AppMethodBeat.i(27053);
    this.wQI = paramInt;
    updateView();
    AppMethodBeat.o(27053);
  }
  
  public final void MP(int paramInt)
  {
    AppMethodBeat.i(27054);
    this.wQJ = paramInt;
    updateView();
    AppMethodBeat.o(27054);
  }
  
  public final void MQ(int paramInt)
  {
    AppMethodBeat.i(27050);
    this.wQE = paramInt;
    updateView();
    AppMethodBeat.o(27050);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27049);
    this.wQy = ((ImageView)paramView.findViewById(2131300953));
    this.wQz = ((ImageView)paramView.findViewById(2131300958));
    this.wQA = ((ImageView)paramView.findViewById(2131300949));
    this.wQB = ((ImageView)paramView.findViewById(2131300927));
    this.wQC = ((ImageView)paramView.findViewById(2131300937));
    this.wQD = ((ImageView)paramView.findViewById(2131300967));
    this.oHF = ((TextView)paramView.findViewById(2131305902));
    updateView();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference
 * JD-Core Version:    0.7.0.1
 */