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
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.b;
import com.tencent.mm.ui.ao;

public final class bq
{
  private LinearLayout EQQ;
  public TextView EQR;
  public View EQS;
  private TextView EQT;
  ImageView EQU;
  private ImageView EQV;
  private View EQW;
  private View EQX;
  public ADXml EQY;
  public ADInfo EQZ;
  private View view;
  private String yFy;
  
  public bq(View paramView)
  {
    AppMethodBeat.i(99719);
    this.view = paramView;
    this.yFy = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    Log.i("MicroMsg.TimeLineAdView", "adView init lan " + this.yFy);
    this.EQR = ((TextView)this.view.findViewById(2131296488));
    this.EQT = ((TextView)this.view.findViewById(2131296494));
    this.EQU = ((ImageView)this.view.findViewById(2131296493));
    this.EQV = ((ImageView)this.view.findViewById(2131296491));
    this.EQS = this.view.findViewById(2131296492);
    this.EQW = this.view.findViewById(2131296489);
    this.EQX = this.view.findViewById(2131296490);
    this.EQQ = ((LinearLayout)this.view.findViewById(2131296487));
    paramView = " " + this.view.getResources().getString(2131765987) + " ";
    this.EQR.setText(paramView);
    AppMethodBeat.o(99719);
  }
  
  public final void N(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.EQS.setTag(paramObject1);
    this.EQR.setTag(paramObject2);
    if (this.EQW != null) {
      this.EQW.setTag(paramObject2);
    }
    if (this.EQQ != null) {
      this.EQQ.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void b(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.EQS.setOnClickListener(paramOnClickListener1);
    this.EQR.setOnClickListener(paramOnClickListener2);
    if (this.EQW != null) {
      this.EQW.setOnClickListener(paramOnClickListener2);
    }
    if (this.EQQ != null) {
      this.EQQ.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final void b(ADXml paramADXml, ADInfo paramADInfo)
  {
    AppMethodBeat.i(99722);
    this.EQZ = paramADInfo;
    this.EQY = paramADXml;
    Object localObject1 = "";
    if (paramADXml != null)
    {
      if ("zh_CN".equals(this.yFy)) {
        localObject1 = paramADXml.adActionLinkTitle_cn;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramADXml != null)
      {
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = paramADXml.adActionLinkName;
        }
      }
      Context localContext = this.EQT.getContext();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131765994);
      }
      this.EQT.setText((CharSequence)localObject1);
      this.EQV.setTag("");
      if (this.EQV.getVisibility() == 0) {
        this.EQV.setVisibility(4);
      }
      if ((paramADInfo == null) || (!paramADInfo.isWeapp())) {
        break label358;
      }
      if (!ao.isDarkMode()) {
        break label335;
      }
      this.EQU.setImageResource(2131689527);
      this.EQV.setImageResource(2131230909);
      label160:
      if ((paramADXml != null) && (!paramADXml.isFullCardAd()) && (!paramADXml.isCardAd()) && (!paramADXml.isSphereCardAd())) {
        com.tencent.mm.plugin.sns.ad.e.d.f(paramADInfo.actionExtWeApp.appUserName, this.EQV);
      }
      label199:
      if (!Util.isNullOrNil(paramADXml.adActionLinkIcon)) {
        h.a("adId", paramADXml.adActionLinkIcon, false, 41, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (Util.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null) {
              bq.this.EQU.setImageDrawable(paramAnonymousString);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void eWN() {}
          
          public final void eWO() {}
        });
      }
      if ((paramADInfo == null) || (Util.isNullOrNil(paramADInfo.adActionPOIName))) {
        break label390;
      }
      this.EQX.setVisibility(0);
      label251:
      if (paramADXml != null)
      {
        if (!"zh_CN".equals(this.yFy)) {
          break label402;
        }
        paramADXml = paramADXml.expandOutsideTitle_cn;
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramADXml)) {
        this.EQR.setText(paramADXml);
      }
      AppMethodBeat.o(99722);
      return;
      if (("zh_TW".equals(this.yFy)) || ("zh_HK".equals(this.yFy)))
      {
        localObject1 = paramADXml.adActionLinkTitle_tw;
        break;
      }
      localObject1 = paramADXml.adActionLinkTitle_en;
      break;
      label335:
      this.EQU.setImageResource(2131689526);
      this.EQV.setImageResource(2131230910);
      break label160;
      label358:
      if (ao.isDarkMode())
      {
        this.EQU.setImageResource(2131689528);
        break label199;
      }
      this.EQU.setImageResource(2131689529);
      break label199;
      label390:
      this.EQX.setVisibility(8);
      break label251;
      label402:
      if (("zh_TW".equals(this.yFy)) || ("zh_HK".equals(this.yFy))) {
        paramADXml = paramADXml.expandOutsideTitle_tw;
      } else {
        paramADXml = paramADXml.expandOutsideTitle_en;
      }
    }
  }
  
  public final String fjV()
  {
    if (this.EQZ == null) {
      return "";
    }
    if (this.EQZ.uxInfo == null) {
      return "";
    }
    return this.EQZ.uxInfo;
  }
  
  public final int[] fjW()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.EQQ != null)
    {
      this.EQW.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.EQW.getMeasuredWidth() + com.tencent.mm.cb.a.fromDPToPix(this.EQW.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.EQW != null)
      {
        this.EQW.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.EQW.getMeasuredWidth() + com.tencent.mm.cb.a.fromDPToPix(this.EQW.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.EQY != null) && (this.EQY.adActionLinkHidden == 1))
    {
      this.EQS.setVisibility(8);
      locala = com.tencent.mm.model.c.d.aXv().biB("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = Util.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.EQY != null) && (this.EQY.isLandingPagesAd()) && (i.aQg(this.EQY.xml))) {
        this.EQS.setVisibility(paramInt);
      }
      this.EQR.setVisibility(paramInt);
      if (this.EQW != null) {
        this.EQW.setVisibility(paramInt);
      }
      if (this.EQQ != null) {
        this.EQQ.setVisibility(paramInt);
      }
      if ((this.EQZ != null) && (!Util.isNullOrNil(this.EQZ.adActionPOIName)))
      {
        this.EQX.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.EQS.setVisibility(paramInt);
        break;
      }
      this.EQX.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bq
 * JD-Core Version:    0.7.0.1
 */