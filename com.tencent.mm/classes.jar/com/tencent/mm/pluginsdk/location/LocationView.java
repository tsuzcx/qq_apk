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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
{
  private b.a FcA;
  private WeImageView Fcu;
  private TextView Fcv;
  private TextView Fcw;
  private View Fcx;
  private View Fcy;
  private a Fcz;
  private View contentView;
  private float dBu;
  private float dzE;
  private d wGe;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.wGe = d.aIh();
    this.dzE = -85.0F;
    this.dBu = -1000.0F;
    this.FcA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(169200);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(169200);
          return true;
        }
        ae.d("MicroMsg.LocationView", "get location %f %f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
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
    this.Fcu = ((WeImageView)findViewById(2131301524));
    this.Fcv = ((TextView)findViewById(2131301536));
    this.Fcw = ((TextView)findViewById(2131307857));
    this.Fcx = findViewById(2131307855);
    this.Fcy = findViewById(2131307856);
    setBackgroundResource(2131231818);
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169199);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.n(LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
              LocationView.a(LocationView.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(169199);
              return;
              com.tencent.mm.pluginsdk.permission.b.b((Activity)LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
          }
        }
        else
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
          ae.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169199);
            return;
          }
        }
        LocationView.b(LocationView.this);
        a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(169199);
      }
    };
    this.contentView.setOnClickListener(paramContext);
    AppMethodBeat.o(169201);
  }
  
  public final void fcR()
  {
    AppMethodBeat.i(218787);
    this.Fcy.setVisibility(8);
    this.Fcx.setVisibility(0);
    AppMethodBeat.o(218787);
  }
  
  public final void fcS()
  {
    AppMethodBeat.i(169208);
    this.Fcy.setVisibility(0);
    this.Fcx.setVisibility(8);
    this.Fcw.setVisibility(8);
    setLocationName(getContext().getString(2131766743));
    this.Fcu.setIconColor(getContext().getResources().getColor(2131099677));
    this.Fcv.setTextColor(getContext().getResources().getColor(2131099664));
    setLocationIcon(2131690589);
    setLocationIconColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(169208);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.dzE, this.dBu);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void lx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218789);
    this.Fcy.setVisibility(0);
    this.Fcx.setVisibility(8);
    this.Fcw.setVisibility(8);
    if (!bu.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(getContext().getResources().getColor(2131099777));
      setLocationIcon(2131690422);
      setLocationIconColor(getContext().getResources().getColor(2131099777));
      AppMethodBeat.o(218789);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.wGe.a(this.FcA, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.wGe.c(this.FcA);
    AppMethodBeat.o(169203);
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.Fcu.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.Fcu.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.Fcv.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.Fcv.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setOnClickLocationListener(a parama)
  {
    this.Fcz = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(218788);
    this.Fcy.setVisibility(0);
    this.Fcx.setVisibility(8);
    this.Fcw.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(getContext().getResources().getColor(2131099777));
    setLocationIcon(2131690422);
    setLocationIconColor(getContext().getResources().getColor(2131099777));
    AppMethodBeat.o(218788);
  }
  
  public static abstract interface a
  {
    public abstract void cNC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */