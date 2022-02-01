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
  private MMActivity fLP;
  private String mTitle;
  private String wSC;
  private int yEp;
  private int yEq;
  private TextView zZO;
  String zZP;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.wSC = "";
    this.mTitle = "";
    this.yEp = -1;
    this.yEq = 8;
    this.zZO = null;
    this.zZP = "";
    this.fLP = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    AppMethodBeat.o(98476);
  }
  
  public final void eby()
  {
    AppMethodBeat.i(98477);
    if ((this.zZO != null) && (this.zZP != null) && (!this.zZP.equals("")) && (this.fLP != null))
    {
      String str = this.fLP.getString(2131763415, new Object[] { this.zZP });
      this.zZO.setText(str);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.zZO = ((TextView)paramView.findViewById(2131296948));
    ((TextView)paramView.findViewById(2131296626)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131305745);
    if (paramView != null)
    {
      paramView.setVisibility(this.yEq);
      paramView.setText(this.wSC);
      if (this.yEp != -1) {
        paramView.setBackgroundDrawable(a.l(this.fLP, this.yEp));
      }
    }
    eby();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mTitle = this.fLP.getString(2131763416);
    localLayoutInflater.inflate(2131494806, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */