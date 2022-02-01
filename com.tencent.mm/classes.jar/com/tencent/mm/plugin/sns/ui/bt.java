package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.sns.ad.d.g;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.b;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class bt
{
  private String Ejr;
  private int JCO;
  private com.tencent.mm.plugin.sns.ad.f.l JHg;
  private c.b JHi;
  private LinearLayout LeP;
  public TextView LeQ;
  public View LeR;
  private TextView LeS;
  ImageView LeT;
  private ImageView LeU;
  private View LeV;
  private View LeW;
  public ADXml LeX;
  public ADInfo LeY;
  private ViewStub LeZ;
  private RoundedCornerFrameLayout Lfa;
  private com.tencent.mm.plugin.sns.ad.timeline.b.i Lfb;
  private View view;
  
  public bt(View paramView, com.tencent.mm.plugin.sns.ad.f.l paraml, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(267400);
    this.view = paramView;
    this.Ejr = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    this.JCO = paramInt;
    this.JHi = paramb;
    this.JHg = paraml;
    Log.i("MicroMsg.TimeLineAdView", "adView init lan " + this.Ejr);
    this.LeQ = ((TextView)this.view.findViewById(i.f.ad_info_tv));
    this.LeS = ((TextView)this.view.findViewById(i.f.ad_link_tv));
    this.LeT = ((ImageView)this.view.findViewById(i.f.ad_link_pre_icon));
    this.LeU = ((ImageView)this.view.findViewById(i.f.ad_link_after_icon));
    this.LeR = this.view.findViewById(i.f.ad_link_container);
    this.LeV = this.view.findViewById(i.f.ad_info_tv_arrow);
    this.LeW = this.view.findViewById(i.f.ad_lbs_icon_tv);
    this.LeP = ((LinearLayout)this.view.findViewById(i.f.ad_info_ll));
    this.LeZ = ((ViewStub)this.view.findViewById(i.f.sns_ad_tag_btn_stub));
    paramView = " " + this.view.getResources().getString(i.j.sns_ad_tip) + " ";
    this.LeQ.setText(paramView);
    AppMethodBeat.o(267400);
  }
  
  public final void G(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.LeR.setTag(paramObject1);
    this.LeQ.setTag(paramObject2);
    if (this.LeV != null) {
      this.LeV.setTag(paramObject2);
    }
    if (this.LeP != null) {
      this.LeP.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(SnsInfo paramSnsInfo, ADXml paramADXml, ADInfo paramADInfo)
  {
    AppMethodBeat.i(267401);
    this.LeY = paramADInfo;
    this.LeX = paramADXml;
    Object localObject1 = "";
    Context localContext;
    if (paramADXml != null)
    {
      if ("zh_CN".equals(this.Ejr)) {
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
      localContext = this.LeS.getContext();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(i.j.sns_ad_view_more);
      }
      this.LeS.setText((CharSequence)localObject1);
      this.LeU.setTag("");
      if (this.LeU.getVisibility() == 0) {
        this.LeU.setVisibility(4);
      }
      if ((paramADInfo == null) || (!paramADInfo.isWeapp())) {
        break label457;
      }
      if (!ar.isDarkMode()) {
        break label434;
      }
      this.LeT.setImageResource(i.i.album_ad_link_tag_weapp_dark);
      this.LeU.setImageResource(i.e.ad_weapp_auth_dark_icon);
      label171:
      if ((paramADXml != null) && (!paramADXml.isFullCardAd()) && (!paramADXml.isCardAd()) && (!paramADXml.isSphereCardAd())) {
        g.f(paramADInfo.actionExtWeApp.appUserName, this.LeU);
      }
      label210:
      if (!Util.isNullOrNil(paramADXml.adActionLinkIcon)) {
        h.a("adId", paramADXml.adActionLinkIcon, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (Util.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null) {
              bt.this.LeT.setImageDrawable(paramAnonymousString);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void fJU() {}
          
          public final void fJV() {}
        });
      }
      if ((paramADInfo == null) || (Util.isNullOrNil(paramADInfo.adActionPOIName))) {
        break label529;
      }
      this.LeW.setVisibility(0);
      label260:
      if (paramADXml != null)
      {
        if (!"zh_CN".equals(this.Ejr)) {
          break label541;
        }
        paramADInfo = paramADXml.expandOutsideTitle_cn;
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramADInfo)) {
        this.LeQ.setText(paramADInfo);
      }
      if ((paramADXml == null) || (paramADXml.adTagBtnInfo == null) || (this.LeZ == null)) {
        break label583;
      }
      if (this.Lfa == null)
      {
        this.Lfa = ((RoundedCornerFrameLayout)this.LeZ.inflate());
        this.Lfb = new com.tencent.mm.plugin.sns.ad.timeline.b.i(localContext, this.JCO, this.JHg, this.Lfa, this.JHi);
      }
      this.Lfa.setVisibility(0);
      this.Lfb.a(paramADXml.adTagBtnInfo, paramSnsInfo);
      AppMethodBeat.o(267401);
      return;
      if (("zh_TW".equals(this.Ejr)) || ("zh_HK".equals(this.Ejr)))
      {
        localObject1 = paramADXml.adActionLinkTitle_tw;
        break;
      }
      localObject1 = paramADXml.adActionLinkTitle_en;
      break;
      label434:
      this.LeT.setImageResource(i.i.album_ad_link_tag_weapp);
      this.LeU.setImageResource(i.e.ad_weapp_auth_icon);
      break label171;
      label457:
      if (com.tencent.mm.plugin.sns.ad.d.l.a(paramADXml, paramADInfo))
      {
        if (ar.isDarkMode())
        {
          this.LeT.setImageResource(i.i.album_ad_finder_link_dark_icon);
          break label210;
        }
        this.LeT.setImageResource(i.i.album_ad_finder_link_icon);
        break label210;
      }
      if (ar.isDarkMode())
      {
        this.LeT.setImageResource(i.i.album_advertise_link_dark_icon);
        break label210;
      }
      this.LeT.setImageResource(i.i.album_advertise_link_icon);
      break label210;
      label529:
      this.LeW.setVisibility(8);
      break label260;
      label541:
      if (("zh_TW".equals(this.Ejr)) || ("zh_HK".equals(this.Ejr))) {
        paramADInfo = paramADXml.expandOutsideTitle_tw;
      } else {
        paramADInfo = paramADXml.expandOutsideTitle_en;
      }
    }
    label583:
    if (this.Lfa != null) {
      this.Lfa.setVisibility(8);
    }
    AppMethodBeat.o(267401);
  }
  
  public final void b(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.LeR.setOnClickListener(paramOnClickListener1);
    this.LeQ.setOnClickListener(paramOnClickListener2);
    if (this.LeV != null) {
      this.LeV.setOnClickListener(paramOnClickListener2);
    }
    if (this.LeP != null) {
      this.LeP.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final String dug()
  {
    if (this.LeY == null) {
      return "";
    }
    if (this.LeY.uxInfo == null) {
      return "";
    }
    return this.LeY.uxInfo;
  }
  
  public final int[] fYf()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.LeP != null)
    {
      this.LeV.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.LeV.getMeasuredWidth() + com.tencent.mm.ci.a.fromDPToPix(this.LeV.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.LeV != null)
      {
        this.LeV.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.LeV.getMeasuredWidth() + com.tencent.mm.ci.a.fromDPToPix(this.LeV.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.LeX != null) && (this.LeX.adActionLinkHidden == 1))
    {
      this.LeR.setVisibility(8);
      locala = d.bgC().buS("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = Util.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.LeX != null) && (this.LeX.isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(this.LeX.xml))) {
        this.LeR.setVisibility(paramInt);
      }
      this.LeQ.setVisibility(paramInt);
      if (this.LeV != null) {
        this.LeV.setVisibility(paramInt);
      }
      if (this.LeP != null) {
        this.LeP.setVisibility(paramInt);
      }
      if ((this.LeY != null) && (!Util.isNullOrNil(this.LeY.adActionPOIName)))
      {
        this.LeW.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.LeR.setVisibility(paramInt);
        break;
      }
      this.LeW.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bt
 * JD-Core Version:    0.7.0.1
 */