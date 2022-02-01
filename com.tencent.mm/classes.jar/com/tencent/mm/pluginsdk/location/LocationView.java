package com.tencent.mm.pluginsdk.location;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
  implements b
{
  private TextView QSy;
  private View contentView;
  private int iconColor;
  private float latitude;
  private float longitude;
  private int textColor;
  private WeImageView yUO;
  private TextView yUP;
  private View yUQ;
  private MMProcessBar yUR;
  private TextView yUS;
  private View yUT;
  private d yUU;
  private int yUV;
  private int yUW;
  private int yUX;
  private int yUY;
  private b.a yUZ;
  private com.tencent.mm.modelgeo.b.a yVa;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.yUU = d.blq();
    this.latitude = -85.0F;
    this.longitude = -1000.0F;
    this.yVa = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(169200);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(169200);
          return true;
        }
        Log.d("MicroMsg.LocationView", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        n.a(2015, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if ((LocationView.c(LocationView.this) == -85.0F) || (LocationView.d(LocationView.this) == -1000.0F))
        {
          LocationView.a(LocationView.this, paramAnonymousFloat2);
          LocationView.b(LocationView.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(169200);
        return false;
      }
    };
    this.contentView = View.inflate(getContext(), c.f.location_geo_view, this);
    this.yUO = ((WeImageView)findViewById(c.e.location_icon));
    this.yUP = ((TextView)findViewById(c.e.location_poi_name));
    this.QSy = ((TextView)findViewById(c.e.location_poi_tip_tv));
    this.yUQ = findViewById(c.e.location_loading_view);
    this.yUR = ((MMProcessBar)findViewById(c.e.location_verifying_icon));
    this.yUS = ((TextView)findViewById(c.e.location_verifying_tip));
    this.yUT = findViewById(c.e.location_normal_view);
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
  
  public final void NM(int paramInt)
  {
    AppMethodBeat.i(200476);
    this.yUR.mO(paramInt, this.yUX);
    this.yUS.setTextColor(this.yUY);
    AppMethodBeat.o(200476);
  }
  
  public final void dFc()
  {
    AppMethodBeat.i(200457);
    this.yUT.setVisibility(8);
    this.yUQ.setVisibility(0);
    AppMethodBeat.o(200457);
  }
  
  public final void dFd()
  {
    AppMethodBeat.i(169208);
    this.yUT.setVisibility(0);
    this.yUQ.setVisibility(8);
    this.QSy.setVisibility(8);
    setLocationName(getContext().getString(c.h.location_default_tip1));
    this.yUO.setIconColor(this.yUV);
    this.yUP.setTextColor(this.yUW);
    setLocationIcon(c.g.icons_outlined_location);
    AppMethodBeat.o(169208);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.latitude, this.longitude);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void hd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200462);
    this.yUT.setVisibility(0);
    this.yUQ.setVisibility(8);
    this.QSy.setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(c.g.icons_filled_location);
      setLocationIconColor(this.iconColor);
      AppMethodBeat.o(200462);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.yUU.a(this.yVa, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.yUU.b(this.yVa);
    AppMethodBeat.o(169203);
  }
  
  public void setDefaultLoadingPBarColor(int paramInt)
  {
    this.yUX = paramInt;
  }
  
  public void setDefaultLoadingTipColor(int paramInt)
  {
    this.yUY = paramInt;
  }
  
  public void setDefaultStateIconColor(int paramInt)
  {
    this.yUV = paramInt;
  }
  
  public void setDefaultStateTextColor(int paramInt)
  {
    this.yUW = paramInt;
  }
  
  public void setIconColor(int paramInt)
  {
    this.iconColor = paramInt;
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.yUO.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.yUO.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.yUP.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.yUP.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setLocationTipColor(int paramInt)
  {
    AppMethodBeat.i(200471);
    this.QSy.setTextColor(paramInt);
    AppMethodBeat.o(200471);
  }
  
  public void setOnClickLocationListener(b.a parama)
  {
    this.yUZ = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(200459);
    this.yUT.setVisibility(0);
    this.yUQ.setVisibility(8);
    this.QSy.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(c.g.icons_filled_location);
    setLocationIconColor(this.iconColor);
    AppMethodBeat.o(200459);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */