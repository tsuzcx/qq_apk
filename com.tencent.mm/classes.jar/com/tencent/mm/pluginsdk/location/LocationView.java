package com.tencent.mm.pluginsdk.location;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
  implements b
{
  private WeImageView DOg;
  private TextView DOh;
  private View DOi;
  private MMProcessBar DOj;
  private TextView DOk;
  private View DOl;
  private int DOm;
  private int DOn;
  private int DOo;
  private int DOp;
  private b.a DOq;
  private TextView XOx;
  private View contentView;
  private int iconColor;
  private float latitude;
  private float longitude;
  private int textColor;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.contentView = View.inflate(getContext(), c.f.location_geo_view, this);
    this.DOg = ((WeImageView)findViewById(c.e.location_icon));
    this.DOh = ((TextView)findViewById(c.e.location_poi_name));
    this.XOx = ((TextView)findViewById(c.e.location_poi_tip_tv));
    this.DOi = findViewById(c.e.location_loading_view);
    this.DOj = ((MMProcessBar)findViewById(c.e.location_verifying_icon));
    this.DOk = ((TextView)findViewById(c.e.location_verifying_tip));
    this.DOl = findViewById(c.e.location_normal_view);
    setBackgroundResource(c.d.comm_list_item_selector);
    paramContext = new LocationView.1(this);
    this.contentView.setOnClickListener(paramContext);
    setTextColor(getContext().getResources().getColor(c.b.Orange));
    setIconColor(getContext().getResources().getColor(c.b.Orange));
    setDefaultStateIconColor(getContext().getResources().getColor(c.b.normal_text_color));
    setDefaultStateTextColor(getContext().getResources().getColor(c.b.normal_text_color));
    setDefaultLoadingPBarColor(getContext().getResources().getColor(c.b.Orange));
    setDefaultLoadingTipColor(getContext().getResources().getColor(c.b.FG_2));
    AppMethodBeat.o(169201);
  }
  
  public final void Px(int paramInt)
  {
    AppMethodBeat.i(244688);
    this.DOj.oH(paramInt, this.DOo);
    this.DOk.setTextColor(this.DOp);
    AppMethodBeat.o(244688);
  }
  
  public final void dUm()
  {
    AppMethodBeat.i(169208);
    this.DOl.setVisibility(0);
    this.DOi.setVisibility(8);
    this.XOx.setVisibility(8);
    setLocationName(getContext().getString(c.h.location_default_tip1));
    this.DOg.setIconColor(this.DOm);
    this.DOh.setTextColor(this.DOn);
    setLocationIcon(c.g.icons_outlined_location);
    AppMethodBeat.o(169208);
  }
  
  public final void dUn()
  {
    AppMethodBeat.i(244637);
    this.DOl.setVisibility(8);
    this.DOi.setVisibility(0);
    AppMethodBeat.o(244637);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.latitude, this.longitude);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void hT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244640);
    this.DOl.setVisibility(0);
    this.DOi.setVisibility(8);
    this.XOx.setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(c.g.icons_filled_location);
      setLocationIconColor(this.iconColor);
      AppMethodBeat.o(244640);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    AppMethodBeat.o(169203);
  }
  
  public void setDefaultLoadingPBarColor(int paramInt)
  {
    this.DOo = paramInt;
  }
  
  public void setDefaultLoadingTipColor(int paramInt)
  {
    this.DOp = paramInt;
  }
  
  public void setDefaultStateIconColor(int paramInt)
  {
    this.DOm = paramInt;
  }
  
  public void setDefaultStateTextColor(int paramInt)
  {
    this.DOn = paramInt;
  }
  
  public void setIconColor(int paramInt)
  {
    this.iconColor = paramInt;
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.DOg.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.DOg.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.DOh.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.DOh.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setLocationTipColor(int paramInt)
  {
    AppMethodBeat.i(244671);
    this.XOx.setTextColor(paramInt);
    AppMethodBeat.o(244671);
  }
  
  public void setOnClickLocationListener(b.a parama)
  {
    this.DOq = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(244638);
    this.DOl.setVisibility(0);
    this.DOi.setVisibility(8);
    this.XOx.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(c.g.icons_filled_location);
    setLocationIconColor(this.iconColor);
    AppMethodBeat.o(244638);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */