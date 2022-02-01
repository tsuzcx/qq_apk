package com.tencent.mm.pluginsdk.location;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
{
  private WeImageView BNQ;
  private TextView BNR;
  private a BNS;
  private TextView Lws;
  private View Lwt;
  private View Lwu;
  private View contentView;
  private float dpb;
  private float dqQ;
  private b.a qny;
  private d uce;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.uce = d.axT();
    this.dpb = -85.0F;
    this.dqQ = -1000.0F;
    this.qny = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(169200);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(169200);
          return true;
        }
        ad.d("MicroMsg.LocationView", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
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
    this.contentView = View.inflate(getContext(), 2131494597, this);
    this.BNQ = ((WeImageView)findViewById(2131301524));
    this.BNR = ((TextView)findViewById(2131301536));
    this.Lws = ((TextView)findViewById(2131307778));
    this.Lwt = findViewById(2131307776);
    this.Lwu = findViewById(2131307777);
    setBackgroundResource(2131231818);
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169199);
        if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.o(LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
            {
              LocationView.a(LocationView.this);
              AppMethodBeat.o(169199);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.b((Activity)LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
            AppMethodBeat.o(169199);
          }
        }
        else
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
          ad.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            AppMethodBeat.o(169199);
            return;
          }
        }
        LocationView.b(LocationView.this);
        AppMethodBeat.o(169199);
      }
    };
    this.contentView.setOnClickListener(paramContext);
    AppMethodBeat.o(169201);
  }
  
  public final void fZE()
  {
    AppMethodBeat.i(203570);
    this.Lwu.setVisibility(8);
    this.Lwt.setVisibility(0);
    AppMethodBeat.o(203570);
  }
  
  public final void fZF()
  {
    AppMethodBeat.i(169208);
    this.Lwu.setVisibility(0);
    this.Lwt.setVisibility(8);
    this.Lws.setVisibility(8);
    setLocationName(getContext().getString(2131766708));
    this.BNQ.setIconColor(getContext().getResources().getColor(2131099677));
    this.BNR.setTextColor(getContext().getResources().getColor(2131099664));
    setLocationIcon(2131690589);
    setLocationIconColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(169208);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.dpb, this.dqQ);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void mX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203572);
    this.Lwu.setVisibility(0);
    this.Lwt.setVisibility(8);
    this.Lws.setVisibility(8);
    if (!bt.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(getContext().getResources().getColor(2131099777));
      setLocationIcon(2131690422);
      setLocationIconColor(getContext().getResources().getColor(2131099777));
      AppMethodBeat.o(203572);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.uce.a(this.qny, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.uce.c(this.qny);
    AppMethodBeat.o(169203);
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.BNQ.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.BNQ.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.BNR.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.BNR.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setOnClickLocationListener(a parama)
  {
    this.BNS = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(203571);
    this.Lwu.setVisibility(0);
    this.Lwt.setVisibility(8);
    this.Lws.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(getContext().getResources().getColor(2131099777));
    setLocationIcon(2131690422);
    setLocationIconColor(getContext().getResources().getColor(2131099777));
    AppMethodBeat.o(203571);
  }
  
  public static abstract interface a
  {
    public abstract void crt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */