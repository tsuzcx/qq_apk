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
  private TextView Arb;
  String Arc;
  private MMActivity fNT;
  private String mTitle;
  private String xit;
  private int yUu;
  private int yUv;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.xit = "";
    this.mTitle = "";
    this.yUu = -1;
    this.yUv = 8;
    this.Arb = null;
    this.Arc = "";
    this.fNT = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    AppMethodBeat.o(98476);
  }
  
  public final void eff()
  {
    AppMethodBeat.i(98477);
    if ((this.Arb != null) && (this.Arc != null) && (!this.Arc.equals("")) && (this.fNT != null))
    {
      String str = this.fNT.getString(2131763415, new Object[] { this.Arc });
      this.Arb.setText(str);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.Arb = ((TextView)paramView.findViewById(2131296948));
    ((TextView)paramView.findViewById(2131296626)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131305745);
    if (paramView != null)
    {
      paramView.setVisibility(this.yUv);
      paramView.setText(this.xit);
      if (this.yUu != -1) {
        paramView.setBackgroundDrawable(a.l(this.fNT, this.yUu));
      }
    }
    eff();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mTitle = this.fNT.getString(2131763416);
    localLayoutInflater.inflate(2131494806, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */