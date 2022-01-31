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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference
  extends Preference
{
  private TextView kvS;
  private ImageView pyN;
  private ImageView pyO;
  private ImageView pyP;
  private ImageView pyQ;
  private ImageView pyR;
  private ImageView pyS;
  private int pyT;
  private int pyU;
  private int pyV;
  private int pyW;
  private int pyX;
  private int pyY;
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.pyT = 8;
    this.pyU = 8;
    this.pyV = 8;
    this.pyW = 8;
    this.pyX = 8;
    this.pyY = 8;
  }
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23431);
    this.pyT = 8;
    this.pyU = 8;
    this.pyV = 8;
    this.pyW = 8;
    this.pyX = 8;
    this.pyY = 8;
    setLayoutResource(2130970179);
    AppMethodBeat.o(23431);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(23439);
    if (this.pyN != null) {
      this.pyN.setVisibility(this.pyT);
    }
    if (this.pyO != null) {
      this.pyO.setVisibility(this.pyU);
    }
    if (this.pyP != null) {
      this.pyP.setVisibility(this.pyV);
    }
    if (this.pyQ != null) {
      this.pyQ.setVisibility(this.pyW);
    }
    if (this.pyR != null) {
      this.pyR.setVisibility(this.pyX);
    }
    if (this.kvS != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.kvS.getLayoutParams();
      localLayoutParams.width = a.ao(this.mContext, 2131427664);
      this.kvS.setLayoutParams(localLayoutParams);
    }
    if (this.pyS != null) {
      this.pyS.setVisibility(this.pyY);
    }
    AppMethodBeat.o(23439);
  }
  
  public final void BA(int paramInt)
  {
    AppMethodBeat.i(23437);
    this.pyX = paramInt;
    bJ();
    AppMethodBeat.o(23437);
  }
  
  public final void BB(int paramInt)
  {
    AppMethodBeat.i(23438);
    this.pyY = paramInt;
    bJ();
    AppMethodBeat.o(23438);
  }
  
  public final void BC(int paramInt)
  {
    AppMethodBeat.i(23434);
    this.pyT = paramInt;
    bJ();
    AppMethodBeat.o(23434);
  }
  
  public final void By(int paramInt)
  {
    AppMethodBeat.i(23435);
    this.pyU = paramInt;
    bJ();
    AppMethodBeat.o(23435);
  }
  
  public final void Bz(int paramInt)
  {
    AppMethodBeat.i(23436);
    this.pyV = paramInt;
    bJ();
    AppMethodBeat.o(23436);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23433);
    this.pyN = ((ImageView)paramView.findViewById(2131826219));
    this.pyO = ((ImageView)paramView.findViewById(2131826220));
    this.pyP = ((ImageView)paramView.findViewById(2131826221));
    this.pyQ = ((ImageView)paramView.findViewById(2131826222));
    this.pyR = ((ImageView)paramView.findViewById(2131826223));
    this.pyS = ((ImageView)paramView.findViewById(2131826224));
    this.kvS = ((TextView)paramView.findViewById(2131820680));
    bJ();
    super.onBindView(paramView);
    AppMethodBeat.o(23433);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23432);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970221, localViewGroup);
    AppMethodBeat.o(23432);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference
 * JD-Core Version:    0.7.0.1
 */