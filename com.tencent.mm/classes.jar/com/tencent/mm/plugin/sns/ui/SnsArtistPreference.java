package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private String MPk;
  private int MPl;
  private int MPm;
  String RnA;
  private TextView Rnz;
  private MMActivity lzt;
  private String mTitle;
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(98475);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(98475);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98476);
    this.MPk = "";
    this.mTitle = "";
    this.MPl = -1;
    this.MPm = 8;
    this.Rnz = null;
    this.RnA = "";
    this.lzt = ((MMActivity)paramContext);
    setLayoutResource(b.g.mm_preference);
    AppMethodBeat.o(98476);
  }
  
  public final void hnY()
  {
    AppMethodBeat.i(98477);
    if ((this.Rnz != null) && (this.RnA != null) && (!this.RnA.equals("")) && (this.lzt != null))
    {
      String str = this.lzt.getString(b.j.settings_sns_bg_from_artist, new Object[] { this.RnA });
      this.Rnz.setText(str);
      this.Rnz.setVisibility(0);
    }
    AppMethodBeat.o(98477);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(98479);
    super.onBindView(paramView);
    this.Rnz = ((TextView)paramView.findViewById(b.f.artist_name));
    ((TextView)paramView.findViewById(b.f.album_title)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(b.f.text_tv_one);
    if (paramView != null)
    {
      paramView.setVisibility(this.MPm);
      paramView.setText(this.MPk);
      if (this.MPl != -1) {
        paramView.setBackgroundDrawable(a.m(this.lzt, this.MPl));
      }
    }
    hnY();
    AppMethodBeat.o(98479);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(98478);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.f.content);
    localViewGroup.removeAllViews();
    this.mTitle = this.lzt.getString(b.j.settings_sns_bg_select_bg);
    localLayoutInflater.inflate(b.g.mm_preference_artist, localViewGroup);
    AppMethodBeat.o(98478);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */