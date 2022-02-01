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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
{
  private WeImageView Dga;
  private TextView Dgb;
  private TextView Dgc;
  private View Dgd;
  private View Dge;
  private a Dgf;
  private b.a Dgg;
  private View contentView;
  private float dmL;
  private float doB;
  private d vld;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.vld = d.aEL();
    this.dmL = -85.0F;
    this.doB = -1000.0F;
    this.Dgg = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(169200);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(169200);
          return true;
        }
        ac.d("MicroMsg.LocationView", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
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
    this.Dga = ((WeImageView)findViewById(2131301524));
    this.Dgb = ((TextView)findViewById(2131301536));
    this.Dgc = ((TextView)findViewById(2131307857));
    this.Dgd = findViewById(2131307855);
    this.Dge = findViewById(2131307856);
    setBackgroundResource(2131231818);
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169199);
        if (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.o(LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue())
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
          ac.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
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
  
  public final void eKp()
  {
    AppMethodBeat.i(192643);
    this.Dge.setVisibility(8);
    this.Dgd.setVisibility(0);
    AppMethodBeat.o(192643);
  }
  
  public final void eKq()
  {
    AppMethodBeat.i(169208);
    this.Dge.setVisibility(0);
    this.Dgd.setVisibility(8);
    this.Dgc.setVisibility(8);
    setLocationName(getContext().getString(2131766743));
    this.Dga.setIconColor(getContext().getResources().getColor(2131099677));
    this.Dgb.setTextColor(getContext().getResources().getColor(2131099664));
    setLocationIcon(2131690589);
    setLocationIconColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(169208);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.dmL, this.doB);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void kT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192645);
    this.Dge.setVisibility(0);
    this.Dgd.setVisibility(8);
    this.Dgc.setVisibility(8);
    if (!bs.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(getContext().getResources().getColor(2131099777));
      setLocationIcon(2131690422);
      setLocationIconColor(getContext().getResources().getColor(2131099777));
      AppMethodBeat.o(192645);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.vld.a(this.Dgg, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.vld.c(this.Dgg);
    AppMethodBeat.o(169203);
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.Dga.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.Dga.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.Dgb.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.Dgb.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setOnClickLocationListener(a parama)
  {
    this.Dgf = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(192644);
    this.Dge.setVisibility(0);
    this.Dgd.setVisibility(8);
    this.Dgc.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(getContext().getResources().getColor(2131099777));
    setLocationIcon(2131690422);
    setLocationIconColor(getContext().getResources().getColor(2131099777));
    AppMethodBeat.o(192644);
  }
  
  public static abstract interface a
  {
    public abstract void cCK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */