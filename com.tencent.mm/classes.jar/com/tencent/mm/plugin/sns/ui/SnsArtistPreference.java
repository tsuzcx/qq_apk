package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private String GRG;
  private int GRH;
  private int GRI;
  private TextView KNO;
  String KNP;
  private MMActivity iXq;
  private String mTitle;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.GRG = "";
    this.mTitle = "";
    this.GRH = -1;
    this.GRI = 8;
    this.KNO = null;
    this.KNP = "";
    this.iXq = ((MMActivity)paramContext);
    setLayoutResource(i.g.mm_preference);
    AppMethodBeat.o(98476);
  }
  
  public final void fVK()
  {
    AppMethodBeat.i(98477);
    if ((this.KNO != null) && (this.KNP != null) && (!this.KNP.equals("")) && (this.iXq != null))
    {
      String str = this.iXq.getString(i.j.settings_sns_bg_from_artist, new Object[] { this.KNP });
      this.KNO.setText(str);
      this.KNO.setVisibility(0);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.KNO = ((TextView)paramView.findViewById(i.f.artist_name));
    ((TextView)paramView.findViewById(i.f.album_title)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(i.f.text_tv_one);
    if (paramView != null)
    {
      paramView.setVisibility(this.GRI);
      paramView.setText(this.GRG);
      if (this.GRH != -1) {
        paramView.setBackgroundDrawable(a.m(this.iXq, this.GRH));
      }
    }
    fVK();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(i.f.content);
    localViewGroup.removeAllViews();
    this.mTitle = this.iXq.getString(i.j.settings_sns_bg_select_bg);
    localLayoutInflater.inflate(i.g.mm_preference_artist, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */