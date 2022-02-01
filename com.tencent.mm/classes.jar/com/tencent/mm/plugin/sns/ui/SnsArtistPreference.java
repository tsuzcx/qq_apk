package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private MMActivity iMV;
  private String mTitle;
  private String vLt;
  private int xpM;
  private int xpN;
  private TextView yIu;
  String yIv;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.vLt = "";
    this.mTitle = "";
    this.xpM = -1;
    this.xpN = 8;
    this.yIu = null;
    this.yIv = "";
    this.iMV = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    AppMethodBeat.o(98476);
  }
  
  public final void dPh()
  {
    AppMethodBeat.i(98477);
    if ((this.yIu != null) && (this.yIv != null) && (!this.yIv.equals("")) && (this.iMV != null))
    {
      String str = this.iMV.getString(2131763415, new Object[] { this.yIv });
      this.yIu.setText(str);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.yIu = ((TextView)paramView.findViewById(2131296948));
    ((TextView)paramView.findViewById(2131296626)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131305745);
    if (paramView != null)
    {
      paramView.setVisibility(this.xpN);
      paramView.setText(this.vLt);
      if (this.xpM != -1) {
        paramView.setBackgroundDrawable(a.l(this.iMV, this.xpM));
      }
    }
    dPh();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mTitle = this.iMV.getString(2131763416);
    localLayoutInflater.inflate(2131494806, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */