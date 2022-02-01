package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private MMActivity imP;
  private String mTitle;
  private String uCA;
  private int wey;
  private int wez;
  private TextView xvE;
  String xvF;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.uCA = "";
    this.mTitle = "";
    this.wey = -1;
    this.wez = 8;
    this.xvE = null;
    this.xvF = "";
    this.imP = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    AppMethodBeat.o(98476);
  }
  
  public final void dAK()
  {
    AppMethodBeat.i(98477);
    if ((this.xvE != null) && (this.xvF != null) && (!this.xvF.equals("")) && (this.imP != null))
    {
      String str = this.imP.getString(2131763415, new Object[] { this.xvF });
      this.xvE.setText(str);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.xvE = ((TextView)paramView.findViewById(2131296948));
    ((TextView)paramView.findViewById(2131296626)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131305745);
    if (paramView != null)
    {
      paramView.setVisibility(this.wez);
      paramView.setText(this.uCA);
      if (this.wey != -1) {
        paramView.setBackgroundDrawable(a.l(this.imP, this.wey));
      }
    }
    dAK();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mTitle = this.imP.getString(2131763416);
    localLayoutInflater.inflate(2131494806, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */