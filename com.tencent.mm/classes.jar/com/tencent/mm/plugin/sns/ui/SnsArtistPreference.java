package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference
  extends Preference
{
  private MMActivity bER;
  private String mTitle = "";
  private String nSg = "";
  private int nSh = -1;
  private int nSi = 8;
  private TextView oVq = null;
  String oVr = "";
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.bER = ((MMActivity)paramContext);
  }
  
  public SnsArtistPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    setLayoutResource(i.g.mm_preference);
    setWidgetLayoutResource(i.g.mm_preference_submenu);
  }
  
  public final void bIs()
  {
    if ((this.oVq != null) && (this.oVr != null) && (!this.oVr.equals("")) && (this.bER != null))
    {
      String str = this.bER.getString(i.j.settings_sns_bg_from_artist, new Object[] { this.oVr });
      this.oVq.setText(str);
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.oVq = ((TextView)paramView.findViewById(i.f.artist_name));
    ((TextView)paramView.findViewById(i.f.album_title)).setText(this.mTitle);
    paramView = (TextView)paramView.findViewById(i.f.text_tv_one);
    if (paramView != null)
    {
      paramView.setVisibility(this.nSi);
      paramView.setText(this.nSg);
      if (this.nSh != -1) {
        paramView.setBackgroundDrawable(a.g(this.bER, this.nSh));
      }
    }
    bIs();
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(i.f.content);
    localViewGroup.removeAllViews();
    this.mTitle = this.bER.getString(i.j.settings_sns_bg_select_bg);
    localLayoutInflater.inflate(i.g.mm_preference_artist, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsArtistPreference
 * JD-Core Version:    0.7.0.1
 */