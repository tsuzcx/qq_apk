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
  private String Bgn;
  private int CZk;
  private int CZl;
  private TextView EAa;
  String EAb;
  private MMActivity gte;
  private String mTitle;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.Bgn = "";
    this.mTitle = "";
    this.CZk = -1;
    this.CZl = 8;
    this.EAa = null;
    this.EAb = "";
    this.gte = ((MMActivity)paramContext);
    setLayoutResource(2131495538);
    AppMethodBeat.o(98476);
  }
  
  public final void fhz()
  {
    AppMethodBeat.i(98477);
    if ((this.EAa != null) && (this.EAb != null) && (!this.EAb.equals("")) && (this.gte != null))
    {
      String str = this.gte.getString(2131765597, new Object[] { this.EAb });
      this.EAa.setText(str);
      this.EAa.setVisibility(0);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.EAa = ((TextView)paramView.findViewById(2131297055));
    ((TextView)paramView.findViewById(2131296703)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(2131309014);
    if (paramView != null)
    {
      paramView.setVisibility(this.CZl);
      paramView.setText(this.Bgn);
      if (this.CZk != -1) {
        paramView.setBackgroundDrawable(a.l(this.gte, this.CZk));
      }
    }
    fhz();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    this.mTitle = this.gte.getString(2131765598);
    localLayoutInflater.inflate(2131495540, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */