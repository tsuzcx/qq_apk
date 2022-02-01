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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView
  extends LinearLayout
{
  private WeImageView EJW;
  private TextView EJX;
  private TextView EJY;
  private View EJZ;
  private View EKa;
  private a EKb;
  private b.a EKc;
  private View contentView;
  private float dAp;
  private float dyz;
  private d wqv;
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(169201);
    this.wqv = d.aHQ();
    this.dyz = -85.0F;
    this.dAp = -1000.0F;
    this.EKc = new b.a()
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
    this.EJW = ((WeImageView)findViewById(2131301524));
    this.EJX = ((TextView)findViewById(2131301536));
    this.EJY = ((TextView)findViewById(2131307857));
    this.EJZ = findViewById(2131307855);
    this.EKa = findViewById(2131307856);
    setBackgroundResource(2131231818);
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169199);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (com.tencent.mm.ax.b.FU((String)g.ajC().ajl().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.n(LocationView.this.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue()) {
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
          ad.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
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
  
  public final void eZd()
  {
    AppMethodBeat.i(195334);
    this.EKa.setVisibility(8);
    this.EJZ.setVisibility(0);
    AppMethodBeat.o(195334);
  }
  
  public final void eZe()
  {
    AppMethodBeat.i(169208);
    this.EKa.setVisibility(0);
    this.EJZ.setVisibility(8);
    this.EJY.setVisibility(8);
    setLocationName(getContext().getString(2131766743));
    this.EJW.setIconColor(getContext().getResources().getColor(2131099677));
    this.EJX.setTextColor(getContext().getResources().getColor(2131099664));
    setLocationIcon(2131690589);
    setLocationIconColor(getContext().getResources().getColor(2131100711));
    AppMethodBeat.o(169208);
  }
  
  public Location getLocation()
  {
    AppMethodBeat.i(169209);
    Location localLocation = new Location(this.dyz, this.dAp);
    AppMethodBeat.o(169209);
    return localLocation;
  }
  
  public final void lq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195336);
    this.EKa.setVisibility(0);
    this.EJZ.setVisibility(8);
    this.EJY.setVisibility(8);
    if (!bt.isNullOrNil(paramString2)) {
      setLocationName(paramString2);
    }
    for (;;)
    {
      setLocationNameColor(getContext().getResources().getColor(2131099777));
      setLocationIcon(2131690422);
      setLocationIconColor(getContext().getResources().getColor(2131099777));
      AppMethodBeat.o(195336);
      return;
      setLocationName(paramString1);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(169202);
    super.onAttachedToWindow();
    this.wqv.a(this.EKc, true);
    AppMethodBeat.o(169202);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(169203);
    super.onDetachedFromWindow();
    this.wqv.c(this.EKc);
    AppMethodBeat.o(169203);
  }
  
  public void setLocationIcon(int paramInt)
  {
    AppMethodBeat.i(169206);
    this.EJW.setImageResource(paramInt);
    AppMethodBeat.o(169206);
  }
  
  public void setLocationIconColor(int paramInt)
  {
    AppMethodBeat.i(169205);
    this.EJW.setIconColor(paramInt);
    AppMethodBeat.o(169205);
  }
  
  public void setLocationName(String paramString)
  {
    AppMethodBeat.i(169204);
    this.EJX.setText(paramString);
    AppMethodBeat.o(169204);
  }
  
  public void setLocationNameColor(int paramInt)
  {
    AppMethodBeat.i(169207);
    this.EJX.setTextColor(paramInt);
    AppMethodBeat.o(169207);
  }
  
  public void setOnClickLocationListener(a parama)
  {
    this.EKb = parama;
  }
  
  public void setSuggestView(String paramString)
  {
    AppMethodBeat.i(195335);
    this.EKa.setVisibility(0);
    this.EJZ.setVisibility(8);
    this.EJY.setVisibility(0);
    setLocationName(paramString);
    setLocationNameColor(getContext().getResources().getColor(2131099777));
    setLocationIcon(2131690422);
    setLocationIconColor(getContext().getResources().getColor(2131099777));
    AppMethodBeat.o(195335);
  }
  
  public static abstract interface a
  {
    public abstract void cKY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView
 * JD-Core Version:    0.7.0.1
 */