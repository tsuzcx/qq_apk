package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;

public final class bn
{
  private LinearLayout AGZ;
  public TextView AHa;
  public View AHb;
  private TextView AHc;
  ImageView AHd;
  private ImageView AHe;
  private View AHf;
  private View AHg;
  public com.tencent.mm.plugin.sns.storage.b AHh;
  public com.tencent.mm.plugin.sns.storage.a AHi;
  private View view;
  private String vlG;
  
  public bn(View paramView)
  {
    AppMethodBeat.i(99719);
    this.view = paramView;
    this.vlG = ad.iR(ak.getContext());
    ae.i("MicroMsg.TimeLineAdView", "adView init lan " + this.vlG);
    this.AHa = ((TextView)this.view.findViewById(2131296432));
    this.AHc = ((TextView)this.view.findViewById(2131296435));
    this.AHd = ((ImageView)this.view.findViewById(2131308470));
    this.AHe = ((ImageView)this.view.findViewById(2131308126));
    this.AHb = this.view.findViewById(2131308177);
    this.AHf = this.view.findViewById(2131296433);
    this.AHg = this.view.findViewById(2131296434);
    this.AGZ = ((LinearLayout)this.view.findViewById(2131296431));
    paramView = " " + this.view.getResources().getString(2131763766) + " ";
    this.AHa.setText(paramView);
    AppMethodBeat.o(99719);
  }
  
  public final void H(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.AHb.setTag(paramObject1);
    this.AHa.setTag(paramObject2);
    if (this.AHf != null) {
      this.AHf.setTag(paramObject2);
    }
    if (this.AGZ != null) {
      this.AGZ.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.AHb.setOnClickListener(paramOnClickListener1);
    this.AHa.setOnClickListener(paramOnClickListener2);
    if (this.AHf != null) {
      this.AHf.setOnClickListener(paramOnClickListener2);
    }
    if (this.AGZ != null) {
      this.AGZ.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final void b(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(99722);
    this.AHi = parama;
    this.AHh = paramb;
    Object localObject1 = "";
    if (paramb != null)
    {
      if ("zh_CN".equals(this.vlG)) {
        localObject1 = paramb.zMW;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject2 = paramb.zMU;
        }
      }
      Context localContext = this.AHc.getContext();
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131763772);
      }
      this.AHc.setText((CharSequence)localObject1);
      this.AHe.setTag("");
      if (this.AHe.getVisibility() == 0) {
        this.AHe.setVisibility(4);
      }
      if ((parama == null) || (!parama.dZr())) {
        break label358;
      }
      if (!al.isDarkMode()) {
        break label335;
      }
      this.AHd.setImageResource(2131689524);
      this.AHe.setImageResource(2131235014);
      label160:
      if ((paramb != null) && (!paramb.dZB()) && (!paramb.dZA()) && (!paramb.dZC())) {
        c.e(parama.zMn.duJ, this.AHe);
      }
      label199:
      if (!bu.isNullOrNil(paramb.zMV)) {
        h.c("adId", paramb.zMV, false, 41, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (bu.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null) {
              bn.this.AHd.setImageDrawable(paramAnonymousString);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void dVu() {}
          
          public final void dVv() {}
        });
      }
      if ((parama == null) || (bu.isNullOrNil(parama.zLY))) {
        break label390;
      }
      this.AHg.setVisibility(0);
      label251:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.vlG)) {
          break label402;
        }
        paramb = paramb.zNf;
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramb)) {
        this.AHa.setText(paramb);
      }
      AppMethodBeat.o(99722);
      return;
      if (("zh_TW".equals(this.vlG)) || ("zh_HK".equals(this.vlG)))
      {
        localObject1 = paramb.zMY;
        break;
      }
      localObject1 = paramb.zMX;
      break;
      label335:
      this.AHd.setImageResource(2131689523);
      this.AHe.setImageResource(2131235015);
      break label160;
      label358:
      if (al.isDarkMode())
      {
        this.AHd.setImageResource(2131689525);
        break label199;
      }
      this.AHd.setImageResource(2131689526);
      break label199;
      label390:
      this.AHg.setVisibility(8);
      break label251;
      label402:
      if (("zh_TW".equals(this.vlG)) || ("zh_HK".equals(this.vlG))) {
        paramb = paramb.zNh;
      } else {
        paramb = paramb.zNg;
      }
    }
  }
  
  public final String eht()
  {
    if (this.AHi == null) {
      return "";
    }
    if (this.AHi.dGD == null) {
      return "";
    }
    return this.AHi.dGD;
  }
  
  public final int[] ehu()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.AGZ != null)
    {
      this.AHf.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.AHf.getMeasuredWidth() + com.tencent.mm.cb.a.fromDPToPix(this.AHf.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.AHf != null)
      {
        this.AHf.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.AHf.getMeasuredWidth() + com.tencent.mm.cb.a.fromDPToPix(this.AHf.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.AHh != null) && (this.AHh.zMT == 1))
    {
      this.AHb.setVisibility(8);
      locala = d.aDJ().aTG("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = bu.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.AHh != null) && (this.AHh.dZv()) && (i.aBm(this.AHh.dCX))) {
        this.AHb.setVisibility(paramInt);
      }
      this.AHa.setVisibility(paramInt);
      if (this.AHf != null) {
        this.AHf.setVisibility(paramInt);
      }
      if (this.AGZ != null) {
        this.AGZ.setVisibility(paramInt);
      }
      if ((this.AHi != null) && (!bu.isNullOrNil(this.AHi.zLY)))
      {
        this.AHg.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.AHb.setVisibility(paramInt);
        break;
      }
      this.AHg.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */