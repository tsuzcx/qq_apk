package com.tencent.mm.pluginsdk.location;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
  implements b
{
  private View contentView;
  private float dTj;
  private float latitude;
  private int textColor;
  private WeImageView uzl;
  private TextView uzm;
  private TextView uzn;
  private View uzo;
  private MMProcessBar uzp;
  private TextView uzq;
  private View uzr;
  private d uzs;
  private int uzt;
  private int uzu;
  private int uzv;
  private int uzw;
  private int uzx;
  private b.a uzy;
  private com.tencent.mm.modelgeo.b.a uzz;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.uzs = d.bca();
    this.latitude = -85.0F;
    this.dTj = -1000.0F;
    this.uzz = new com.tencent.mm.modelgeo.b.a()
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
        o.a(2015, paramAnonymousFloat1, paramAnonymousFloat2, 0);
        if ((LocationView.c(LocationView.this) == -85.0F) || (LocationView.d(LocationView.this) == -1000.0F))
        {
          LocationView.a(LocationView.this, paramAnonymousFloat2);
          LocationView.b(LocationView.this, paramAnonymousFloat1);
        }
        AppMethodBeat.o(169200);
        return false;
      }
    };
    this.contentView = View.inflate(getContext(), 2131495308, this);
    this.uzl = ((WeImageView)findViewById(2131303730));
    this.uzm = ((TextView)findViewById(2131303745));
    this.uzn = ((TextView)findViewById(2131303746));
    this.uzo = findViewById(2131303739);
    this.uzp = ((MMProcessBar)findViewById(2131303757));
    this.uzq = ((TextView)findViewById(2131303758));
    this.uzr = findViewById(2131303743);
    setBackgroundResource(2131231898);
    paramContext = new LocationView.1(this);
    this.contentView.setOnClickListener(paramContext);
    setTextColor(getContext().getResources().getColor(2131099792));
    setIconColor(getContext().getResources().getColor(2131099792));
    setDefaultStateIconColor(getContext().getResources().getColor(2131100904));
    setDefaultStateTextColor(getContext().getResources().getColor(2131100904));
    setDefaultLoadingPBarColor(getContext().getResources().getColor(2131099792));
    setDefaultLoadingTipColor(getContext().getResources().getColor(2131099749));
    AppMethodBeat.o(169201);
  }
  
  public final void dix()
  {
    AppMethodBeat.i(223716);
    this.uzr.setVisibility(8);
    this.uzo.setVisibility(0);
    AppMethodBeat.o(223716);
  }
  
  public final void diy()
  {
    AppMethodBeat.i(169208);
    this.uzr.setVisibility(0);
    this.uzo.setVisibility(8);
    this.uzn.setVisibility(8);
    setLocationName(getContext().getString(2131762453));
    this.uzl.setIconColor(this.uzu);
    this.uzm.setTextColor(this.uzv);
    setLocationIcon(2131690826);
    AppMethodBeat.o(169208);
  }
  
  public final void diz()
  {
    AppMethodBeat.i(223720);
    this.uzp.setBackground$255f295(this.uzw);
    this.uzq.setTextColor(this.uzx);
    AppMethodBeat.o(223720);
  }
  
  public final void gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223718);
    this.uzr.setVisibility(0);
    this.uzo.setVisibility(8);
    this.uzn.setVisibility(8);
    if (!Util.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(this.textColor);
      setLocationIcon(2131690589);
      setLocationIconColor(this.uzt);
      AppMethodBeat.o(223718);
      return;
      setLocationName(paramString1);
    }
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.latitude, this.dTj);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.uzs.a(this.uzz, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.uzs.c(this.uzz);
    AppMethodBeat.o(169203);
  }
  
  public void setDefaultLoadingPBarColor(int paramInt)
  {
    this.uzw = paramInt;
  }
  
  public void setDefaultLoadingTipColor(int paramInt)
  {
    this.uzx = paramInt;
  }
  
  public void setDefaultStateIconColor(int paramInt)
  {
    this.uzu = paramInt;
  }
  
  public void setDefaultStateTextColor(int paramInt)
  {
    this.uzv = paramInt;
  }
  
  public void setIconColor(int paramInt)
  {
    this.uzt = paramInt;
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.uzl.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.uzl.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.uzm.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.uzm.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setLocationTipColor(int paramInt)
  {
    AppMethodBeat.i(223719);
    this.uzn.setTextColor(paramInt);
    AppMethodBeat.o(223719);
  }
  
  public void setOnClickLocationListener(b.a parama)
  {
    this.uzy = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(223717);
    this.uzr.setVisibility(0);
    this.uzo.setVisibility(8);
    this.uzn.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(this.textColor);
    setLocationIcon(2131690589);
    setLocationIconColor(this.uzt);
    AppMethodBeat.o(223717);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */