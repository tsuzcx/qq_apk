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
import com.tencent.mm.model.newabtest.d;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.interactionlabel.SnsAdInteractionLabelView;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class bu
{
  private String Kca;
  private com.tencent.mm.plugin.sns.ad.g.l PYh;
  private c.b PYj;
  private LinearLayout REZ;
  public TextView RFa;
  public View RFb;
  private TextView RFc;
  ImageView RFd;
  private ImageView RFe;
  private View RFf;
  private View RFg;
  public ADXml RFh;
  public ADInfo RFi;
  private ViewStub RFj;
  private RoundedCornerFrameLayout RFk;
  private com.tencent.mm.plugin.sns.ad.timeline.helper.l RFl;
  private ViewStub RFm;
  private SnsAdInteractionLabelView RFn;
  private View view;
  private int xOq;
  
  public bu(View paramView, com.tencent.mm.plugin.sns.ad.g.l paraml, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(308294);
    this.view = paramView;
    this.Kca = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    this.xOq = paramInt;
    this.PYj = paramb;
    this.PYh = paraml;
    Log.i("MicroMsg.TimeLineAdView", "adView init lan " + this.Kca);
    this.RFa = ((TextView)this.view.findViewById(b.f.ad_info_tv));
    this.RFc = ((TextView)this.view.findViewById(b.f.ad_link_tv));
    this.RFd = ((ImageView)this.view.findViewById(b.f.ad_link_pre_icon));
    this.RFe = ((ImageView)this.view.findViewById(b.f.ad_link_after_icon));
    this.RFb = this.view.findViewById(b.f.ad_link_container);
    this.RFf = this.view.findViewById(b.f.ad_info_tv_arrow);
    this.RFg = this.view.findViewById(b.f.ad_lbs_icon_tv);
    this.REZ = ((LinearLayout)this.view.findViewById(b.f.ad_info_ll));
    this.RFj = ((ViewStub)this.view.findViewById(b.f.sns_ad_tag_btn_stub));
    this.RFm = ((ViewStub)this.view.findViewById(b.f.sns_ad_interaction_label_layout_stub));
    paramView = " " + this.view.getResources().getString(b.j.sns_ad_tip) + " ";
    this.RFa.setText(paramView);
    AppMethodBeat.o(308294);
  }
  
  public final void R(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.RFb.setTag(paramObject1);
    this.RFa.setTag(paramObject2);
    if (this.RFf != null) {
      this.RFf.setTag(paramObject2);
    }
    if (this.REZ != null) {
      this.REZ.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(SnsInfo paramSnsInfo, ADXml paramADXml, ADInfo paramADInfo)
  {
    AppMethodBeat.i(308314);
    this.RFi = paramADInfo;
    this.RFh = paramADXml;
    Object localObject1 = "";
    if (paramADXml != null)
    {
      if ("zh_CN".equals(this.Kca)) {
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
      Context localContext = this.RFc.getContext();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(b.j.sns_ad_view_more);
      }
      this.RFc.setText((CharSequence)localObject1);
      this.RFe.setTag("");
      if (this.RFe.getVisibility() == 0) {
        this.RFe.setVisibility(4);
      }
      if ((paramADInfo == null) || (!paramADInfo.isWeapp())) {
        break label525;
      }
      if (!aw.isDarkMode()) {
        break label512;
      }
      this.RFd.setImageResource(b.i.album_ad_link_tag_weapp_dark);
      label161:
      if ((paramADXml != null) && (!paramADXml.isFullCardAd()) && (!paramADXml.isCardAd()) && (!paramADXml.isSphereCardAd())) {
        i.a(paramADInfo.actionExtWeApp.appUserName, this.RFe, paramADInfo);
      }
      label201:
      if (!Util.isNullOrNil(paramADXml.adActionLinkIcon)) {
        k.b("adId", paramADXml.adActionLinkIcon, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (Util.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null) {
              bu.this.RFd.setImageDrawable(paramAnonymousString);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void gZM() {}
          
          public final void gZN() {}
        });
      }
      if ((paramADInfo == null) || (Util.isNullOrNil(paramADInfo.adActionPOIName))) {
        break label636;
      }
      this.RFg.setVisibility(0);
      label251:
      if (paramADXml != null)
      {
        if (!"zh_CN".equals(this.Kca)) {
          break label648;
        }
        paramADInfo = paramADXml.expandOutsideTitle_cn;
        if (!Util.isNullOrNil(paramADInfo)) {
          this.RFa.setText(paramADInfo);
        }
      }
      label272:
      if ((paramADXml == null) || (paramADXml.adTagBtnInfo == null) || (!paramADXml.adTagBtnInfo.isValid()) || (this.RFj == null)) {
        break label690;
      }
      if (this.RFk == null)
      {
        this.RFk = ((RoundedCornerFrameLayout)this.RFj.inflate());
        this.RFl = new com.tencent.mm.plugin.sns.ad.timeline.helper.l(localContext, this.xOq, this.PYh, this.RFk, this.PYj);
      }
      this.RFk.setVisibility(0);
      this.RFl.a(paramADXml.adTagBtnInfo, paramSnsInfo);
    }
    for (;;)
    {
      if ((paramADXml == null) || (paramADXml.adInteractionLabelInfo == null) || (this.RFm == null) || (paramSnsInfo == null)) {
        break label709;
      }
      if (this.RFn == null) {
        this.RFn = ((SnsAdInteractionLabelView)this.RFm.inflate());
      }
      if (this.RFn == null) {
        break label725;
      }
      this.RFn.a(paramADXml.adInteractionLabelInfo, paramSnsInfo.field_snsId, this.xOq);
      this.RFn.setVisibility(0);
      AppMethodBeat.o(308314);
      return;
      if (("zh_TW".equals(this.Kca)) || ("zh_HK".equals(this.Kca)))
      {
        localObject1 = paramADXml.adActionLinkTitle_tw;
        break;
      }
      localObject1 = paramADXml.adActionLinkTitle_en;
      break;
      label512:
      this.RFd.setImageResource(b.i.album_ad_link_tag_weapp);
      break label161;
      label525:
      if (com.tencent.mm.plugin.sns.ad.d.n.a(paramADXml, paramADInfo))
      {
        if (aw.isDarkMode())
        {
          this.RFd.setImageResource(b.i.album_ad_finder_link_dark_icon);
          break label201;
        }
        this.RFd.setImageResource(b.i.album_ad_finder_link_icon);
        break label201;
      }
      if (com.tencent.mm.plugin.sns.ad.d.n.a(paramADXml))
      {
        if (aw.isDarkMode())
        {
          this.RFd.setImageResource(b.i.album_ad_finder_link_dark_icon);
          break label201;
        }
        this.RFd.setImageResource(b.i.album_ad_finder_link_icon);
        break label201;
      }
      if (aw.isDarkMode())
      {
        this.RFd.setImageResource(b.i.album_advertise_link_dark_icon);
        break label201;
      }
      this.RFd.setImageResource(b.i.album_advertise_link_icon);
      break label201;
      label636:
      this.RFg.setVisibility(8);
      break label251;
      label648:
      if (("zh_TW".equals(this.Kca)) || ("zh_HK".equals(this.Kca)))
      {
        paramADInfo = paramADXml.expandOutsideTitle_tw;
        break label272;
      }
      paramADInfo = paramADXml.expandOutsideTitle_en;
      break label272;
      label690:
      if (this.RFk != null) {
        this.RFk.setVisibility(8);
      }
    }
    label709:
    if (this.RFn != null) {
      this.RFn.setVisibility(8);
    }
    label725:
    AppMethodBeat.o(308314);
  }
  
  public final void b(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.RFb.setOnClickListener(paramOnClickListener1);
    this.RFa.setOnClickListener(paramOnClickListener2);
    if (this.RFf != null) {
      this.RFf.setOnClickListener(paramOnClickListener2);
    }
    if (this.REZ != null) {
      this.REZ.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final String edF()
  {
    if (this.RFi == null) {
      return "";
    }
    if (this.RFi.uxInfo == null) {
      return "";
    }
    return this.RFi.uxInfo;
  }
  
  public final int[] hqD()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.REZ != null)
    {
      this.RFf.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.RFf.getMeasuredWidth() + com.tencent.mm.cd.a.fromDPToPix(this.RFf.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.RFf != null)
      {
        this.RFf.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.RFf.getMeasuredWidth() + com.tencent.mm.cd.a.fromDPToPix(this.RFf.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.RFh != null) && (this.RFh.adActionLinkHidden == 1))
    {
      this.RFb.setVisibility(8);
      locala = d.bEu().buZ("Sns_CanvasAd_DetailLink_JumpWay");
      if ((locala == null) || (!locala.isValid())) {
        break label206;
      }
    }
    label206:
    for (int i = Util.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.RFh != null) && (this.RFh.isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(this.RFh.xml))) {
        this.RFb.setVisibility(paramInt);
      }
      this.RFa.setVisibility(paramInt);
      if (this.RFf != null) {
        this.RFf.setVisibility(paramInt);
      }
      if (this.REZ != null) {
        this.REZ.setVisibility(paramInt);
      }
      if ((this.RFi != null) && (!Util.isNullOrNil(this.RFi.adActionPOIName)))
      {
        this.RFg.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.RFb.setVisibility(paramInt);
        break;
      }
      this.RFg.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu
 * JD-Core Version:    0.7.0.1
 */