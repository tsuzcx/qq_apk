package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.if;
import com.tencent.mm.h.a.lp;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.h;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.k;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.tools.ShowImageUI;

public final class d$e
  extends c
  implements t.m
{
  protected t.h vCd;
  protected t.k vCe;
  protected t.i vCf;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private static void a(d.c paramc, com.tencent.mm.ui.chatting.b.b.g paramg, bi parambi)
  {
    if ((parambi.field_status == 2) && (a(paramg, parambi.field_msgId))) {
      if (paramc.vBN != null) {
        paramc.vBN.setVisibility(0);
      }
    }
    while (paramc.vBN == null) {
      return;
    }
    paramc.vBN.setVisibility(8);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg);
      ((View)localObject).setTag(new d.c().r((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    com.tencent.mm.ui.base.h.a(parama.vtz.getContext(), parama.vtz.getMMResources().getString(R.l.chatting_resend_content), "", parama.vtz.getMMResources().getString(R.l.app_resend), parama.vtz.getMMResources().getString(R.l.app_cancel), new d.e.6(this, parambi), new d.e.7(this));
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    d.c localc = (d.c)parama;
    this.vko = parama1;
    ((com.tencent.mm.ui.chatting.b.b.i)parama1.ac(com.tencent.mm.ui.chatting.b.b.i.class)).aW(parambi);
    localc.reset();
    String str = parambi.field_content;
    ((com.tencent.mm.ui.chatting.b.b.i)parama1.ac(com.tencent.mm.ui.chatting.b.b.i.class)).aU(parambi);
    g.a locala;
    Object localObject2;
    if (str != null)
    {
      locala = g.a.M(str, parambi.field_reserved);
      localObject2 = com.tencent.mm.ae.k.gv(str);
    }
    for (;;)
    {
      paramString = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      int j = 0;
      int k = 0;
      Object localObject1 = paramString;
      Object localObject3;
      boolean bool;
      label600:
      label614:
      label744:
      int i;
      if (locala != null)
      {
        localObject3 = com.tencent.mm.pluginsdk.model.app.g.dh(locala.appId, locala.cau);
        localc.eXO.setText(locala.title);
        localc.eXP.setText(locala.description);
        localc.vBs.setMaxLines(1);
        localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.normal_text_color));
        localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.hint_text_color));
        localc.vBI.setBackgroundResource(R.g.chat_to_content_bg_mask);
        localc.vBI.setPadding(0, parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
        localc.vBn.setVisibility(0);
        localc.vBG.setVisibility(0);
        localc.eXP.setVisibility(0);
        localc.vBK.setVisibility(8);
        localc.vBL.setVisibility(8);
        localc.vBx.setVisibility(8);
        localc.vBw.setVisibility(8);
        localc.vBt.setVisibility(8);
        localc.vBq.setVisibility(8);
        localc.vBp.setVisibility(8);
        localc.vBV.setVisibility(8);
        localc.vBO.setVisibility(8);
        localc.vBI.setVisibility(0);
        d.c.Y(localc.vBH, localc.vBZ);
        if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName.trim().length() > 0)) {
          break label1206;
        }
        localObject1 = locala.appName;
        bool = true;
        com.tencent.mm.cb.a.fromDPToPix(parama1.vtz.getContext(), 12);
        if ((locala.type == 20) || ("wxaf060266bfa9a35c".equals(locala.appId))) {
          bool = o.a.ckl().bzS();
        }
        if ((!bool) || (locala.appId == null) || (locala.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.ct((String)localObject1))) {
          break label1233;
        }
        localc.kiv.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.vtz.getContext(), (com.tencent.mm.pluginsdk.model.app.f)localObject3, (String)localObject1));
        localc.vBr.setVisibility(0);
        localc.kiv.setVisibility(0);
        localc.kiv.setCompoundDrawables(null, null, null, null);
        localc.vBo.setVisibility(0);
        if ((localObject3 == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject3).ZH())) {
          break label1216;
        }
        a(parama1, localc.kiv, parambi, locala, ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName, parambi.field_msgSvrId);
        a(parama1, localc.vBo, locala.appId);
        bool = false;
        localc.vBn.setVisibility(0);
        if (!this.khG) {
          break label1408;
        }
        localObject3 = null;
        localObject1 = localObject3;
        if (locala.type != 33)
        {
          localObject1 = localObject3;
          if (locala.type != 36) {
            localObject1 = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
          }
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label1402;
        }
        localc.vBn.setImageBitmap((Bitmap)localObject1);
        label711:
        if (locala.type == 3) {
          localc.vBI.getViewTreeObserver().addOnPreDrawListener(new d.e.1(this, localc, parama1, (Bitmap)localObject1));
        }
        localc.vBy.setOnClickListener(null);
        switch (locala.type)
        {
        case 1: 
        case 2: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 14: 
        case 17: 
        case 18: 
        case 21: 
        case 22: 
        case 23: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 35: 
        case 37: 
        case 38: 
        case 39: 
        default: 
          i = 1;
          parama = paramString;
          j = k;
        }
      }
      for (;;)
      {
        label946:
        if (i != 0) {
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.vBs.setVisibility(0);
            localc.vBs.setMaxLines(2);
            localc.vBs.setText(locala.title);
            label1001:
            localc.eXO.setVisibility(8);
            if (!bool) {
              break label6841;
            }
            if ((locala.type != 33) && (locala.type != 36)) {
              break label6736;
            }
            paramString = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBn, "file://" + paramString, null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(50, 50));
            localObject1 = parama;
          }
        }
        for (;;)
        {
          if (j == 0)
          {
            localc.vBH.setTag(localObject1);
            localc.vBH.setOnClickListener(d(parama1));
          }
          if (this.khG)
          {
            localc.vBH.setOnLongClickListener(c(parama1));
            localc.vBH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          }
          a(paramInt, localc, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
          return;
          label1206:
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName;
          break;
          label1216:
          a(parama1, localc.kiv, locala.appId);
          break label600;
          label1233:
          if (locala.type == 24)
          {
            localc.kiv.setText(ae.getContext().getString(R.l.favorite));
            localc.vBr.setVisibility(0);
            localc.kiv.setVisibility(0);
            localc.vBo.setVisibility(8);
            break label614;
          }
          if ((locala.type == 19) || (((com.tencent.mm.ae.k)localObject2).dTA == 19))
          {
            localc.kiv.setText(ae.getContext().getString(R.l.chatting_item_record));
            localc.vBr.setVisibility(0);
            localc.kiv.setVisibility(0);
            localc.vBo.setVisibility(8);
            break label614;
          }
          if (d.a(locala, localc)) {
            break label614;
          }
          localc.vBr.setVisibility(8);
          localc.kiv.setVisibility(8);
          localc.vBo.setVisibility(8);
          break label614;
          label1402:
          bool = true;
          break label711;
          label1408:
          localc.vBn.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_app));
          bool = false;
          break label744;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white));
            label1487:
            localc.eXP.setVisibility(0);
            localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white));
            localc.vBs.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            localc.vBy.setVisibility(0);
            if (!parambi.field_msgId.equals(parama.vBb)) {
              break label1760;
            }
            localc.vBy.setImageResource(R.g.music_pauseicon);
            label1596:
            parama = new d.f();
            parama.bIt = parambi.field_msgId;
            parama.bUr = parambi.field_content;
            parama.imgPath = parambi.field_imgPath;
            localc.vBy.setTag(parama);
            localc.vBy.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDv());
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label1774;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_music);
            }
          }
          for (;;)
          {
            if (!cHc()) {
              break label1786;
            }
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.eXO.setVisibility(8);
            break label1487;
            label1760:
            localc.vBy.setImageResource(R.g.music_playicon);
            break label1596;
            label1774:
            localc.vBn.setImageBitmap(parama);
          }
          label1786:
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXO.setMaxLines(2);
          }
          for (;;)
          {
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            localc.eXP.setText(bk.cm(locala.dQv));
            localc.vBy.setVisibility(8);
            d.c.a(localc, str, locala.dQv);
            d.c.a(localc, Boolean.valueOf(false), parambi, locala.bFE, locala.title);
            if (!bool) {
              break label6847;
            }
            if (!bk.aaf(locala.dQw)) {
              break label2022;
            }
            localc.vBn.setImageResource(R.g.appshareimage_icon);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.eXO.setVisibility(8);
          }
          label2022:
          localc.vBn.setImageResource(com.tencent.mm.pluginsdk.model.o.VP(locala.dQw));
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            label2079:
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.eXP.setMaxLines(2);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(0);
            localc.vBy.setImageResource(R.g.video_download_btn);
            if (!bool) {
              break label6847;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2219;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_video);
          }
          for (;;)
          {
            localc.vBy.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.eXO.setVisibility(8);
            break label2079;
            label2219:
            localc.vBn.setImageBitmap(parama);
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(locala.dSY);
          if (localObject1 != null)
          {
            parama = ((WxaAttributes)localObject1).field_nickname;
            label2263:
            if (localObject1 == null) {
              break label2540;
            }
            localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;
            label2275:
            localc.vBI.setVisibility(8);
            localc.vBV.setVisibility(0);
            localc.vBO.setVisibility(8);
            localc.vBR.setVisibility(8);
            localc.vBY.setText(locala.title);
            localc.vBR.setText(locala.description);
            localc.vBT.setText(parama);
            switch (locala.dTf)
            {
            default: 
              localc.vBU.setText(R.l.app_brand_entrance);
            }
          }
          for (;;)
          {
            com.tencent.mm.as.o.ON().a((String)localObject1, localc.vBS, p.d.vDo);
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
            localc.vBW.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBW, "file://" + parama, null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(240, 192));
            if (!cHc()) {
              break label2578;
            }
            a(localc, (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi);
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            parama = locala.bYH;
            break label2263;
            label2540:
            localObject1 = locala.dTh;
            break label2275;
            localc.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
            continue;
            localc.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
          }
          label2578:
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localc.eXO.setVisibility(8);
          label2826:
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.vBs.setMaxLines(2);
            localc.vBs.setVisibility(0);
            localc.vBs.setText(locala.title);
            label2687:
            localc.eXP.setMaxLines(3);
            localc.vBt.setVisibility(4);
            if (!d.h(locala)) {
              break label2909;
            }
            localc.vBy.setImageResource(R.g.video_download_btn);
            localc.vBy.setVisibility(0);
            label2733:
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
              if (parama != null) {
                break label2931;
              }
              localObject1 = new com.tencent.mm.as.a.a.c.a();
              ((com.tencent.mm.as.a.a.c.a)localObject1).eru = R.k.app_attach_file_icon_webpage;
              ((com.tencent.mm.as.a.a.c.a)localObject1).bn(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50)).erd = true;
              localObject2 = com.tencent.mm.as.o.ON();
              if (!bk.bl(locala.thumburl)) {
                break label2922;
              }
              parama = locala.dQC;
              ((com.tencent.mm.as.a.a)localObject2).a(parama, localc.vBn, ((com.tencent.mm.as.a.a.c.a)localObject1).OV());
            }
          }
          for (;;)
          {
            if (!cHc()) {
              break label2964;
            }
            a(localc, (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi);
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.vBs.setVisibility(8);
            break label2687;
            label2909:
            localc.vBy.setVisibility(8);
            break label2733;
            label2922:
            parama = locala.thumburl;
            break label2826;
            label2931:
            if (parama.isRecycled()) {
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            } else {
              localc.vBn.setImageBitmap(parama);
            }
          }
          label2964:
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(locala.dSY);
          switch (locala.dTa)
          {
          default: 
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label6860;
            }
            if (!cHc()) {
              break label3571;
            }
            a(localc, (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi);
            if (localc.nhQ == null) {
              break label6860;
            }
            localc.nhQ.setVisibility(8);
            parama = paramString;
            j = k;
            break;
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              label3134:
              if (localObject1 == null) {
                break label3368;
              }
              localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;
              label3146:
              localc.vBI.setVisibility(8);
              localc.vBV.setVisibility(0);
              localc.vBO.setVisibility(8);
              localc.vBR.setVisibility(8);
              localc.vBY.setText(locala.title);
              localc.vBR.setText(locala.description);
              localc.vBT.setText(parama);
              switch (locala.dTf)
              {
              default: 
                localc.vBU.setText(R.l.app_brand_entrance);
              }
            }
            for (;;)
            {
              com.tencent.mm.as.o.ON().a((String)localObject1, localc.vBS, p.d.vDo);
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
              localc.vBW.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.JD().a(new d.e.2(this, localc), "file://" + parama, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(240, 192));
              i = 0;
              break;
              parama = locala.bYH;
              break label3134;
              label3368:
              localObject1 = locala.dTh;
              break label3146;
              localc.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
              continue;
              localc.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
            }
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              label3417:
              if (localObject1 == null) {
                break label3539;
              }
            }
            label3539:
            for (localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;; localObject1 = null)
            {
              localc.vBI.setVisibility(8);
              localc.vBV.setVisibility(8);
              localc.vBO.setVisibility(0);
              localc.vBQ.setText(parama);
              if (!bk.bl((String)localObject1)) {
                break label3545;
              }
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
              com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBP, "file://" + parama, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
              i = 0;
              break;
              parama = locala.title;
              break label3417;
            }
            label3545:
            com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBP, (String)localObject1, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
            i = 0;
          }
          label3571:
          if (localc.nhQ == null) {
            break label6860;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6860;
          }
          localc.nhQ.setVisibility(8);
          parama = paramString;
          j = k;
          break label946;
          localc.eXO.setVisibility(8);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.vBs.setMaxLines(2);
            localc.vBs.setVisibility(0);
            localc.vBs.setText(locala.title);
            label3677:
            localc.eXP.setMaxLines(3);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(8);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label3802;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            }
          }
          for (;;)
          {
            if (!cHc()) {
              break label3814;
            }
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.vBs.setVisibility(8);
            break label3677;
            label3802:
            localc.vBn.setImageBitmap(parama);
          }
          label3814:
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localc.vBs.setVisibility(0);
          if (locala.dQY == 1) {
            localc.vBs.setText(R.l.scan_product_appmsg_top_title_book);
          }
          for (;;)
          {
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localc.eXO.setVisibility(0);
              localc.eXO.setText(locala.title);
            }
            localc.eXP.setMaxLines(4);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(8);
            if (!bool) {
              break label6847;
            }
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama == null) || (parama.isRecycled())) {
              break label4082;
            }
            localc.vBn.setImageBitmap(parama);
            i = 0;
            parama = paramString;
            j = k;
            break;
            if (locala.dQY == 2) {
              localc.vBs.setText(R.l.scan_product_appmsg_top_title_movie);
            } else if (locala.dQY == 3) {
              localc.vBs.setText(R.l.scan_product_appmsg_top_title_cd);
            } else {
              localc.vBs.setText(R.l.scan_product_appmsg_top_title_product);
            }
          }
          label4082:
          localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localc.eXO.setVisibility(0);
          localc.eXO.setText(locala.title);
          localc.vBs.setVisibility(0);
          localc.vBs.setText(R.l.chatting_mall_product_msg_title);
          localc.eXP.setMaxLines(4);
          localc.vBt.setVisibility(4);
          localc.vBy.setVisibility(8);
          if (!bool) {
            break label6847;
          }
          parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
          if ((parama != null) && (!parama.isRecycled()))
          {
            localc.vBn.setImageBitmap(parama);
            i = 0;
            parama = paramString;
            j = k;
            break label946;
          }
          localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXO.setText(locala.title);
            localc.vBs.setVisibility(8);
          }
          localc.eXP.setMaxLines(4);
          localc.vBt.setVisibility(4);
          localc.vBy.setVisibility(8);
          if (!bool) {
            break label6847;
          }
          parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
          if ((parama != null) && (!parama.isRecycled()))
          {
            localc.vBn.setImageBitmap(parama);
            i = 0;
            parama = paramString;
            j = k;
            break label946;
          }
          localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0)) {
            localc.eXO.setVisibility(0);
          }
          for (;;)
          {
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBt.setVisibility(8);
            localc.vBy.setVisibility(4);
            localc.eXP.setMaxLines(2);
            if (!bool) {
              break label6847;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
            if ((parama != null) && (!parama.isRecycled())) {
              break label4573;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.eXO.setVisibility(8);
          }
          label4573:
          localc.vBn.setImageBitmap(parama);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            label4623:
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBy.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
              if ((parama != null) && (!parama.isRecycled())) {
                break label4810;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            }
          }
          for (;;)
          {
            parama = new aw(parambi, false, paramInt, "", false, parama1.cDP(), locala.bYG, locala.bYH, locala.title, locala.dRg, locala.url, false, false);
            localc.vBH.setTag(parama);
            localc.vBH.setOnClickListener(h(parama1));
            j = 1;
            i = 0;
            break;
            localc.eXO.setVisibility(8);
            break label4623;
            label4810:
            localc.vBn.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            label4850:
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBy.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
              if ((parama != null) && (!parama.isRecycled())) {
                break label5065;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            }
          }
          for (;;)
          {
            parama = new aw(parambi, paramInt, "", parama1.cDP(), locala.bYG, locala.bYH, locala.title, locala.dSM, locala.designerName, locala.designerRediretctUrl, locala.url);
            localc.vBH.setTag(parama);
            paramString = localc.vBH;
            if (this.vCd == null) {
              this.vCd = new t.h(parama1);
            }
            paramString.setOnClickListener(this.vCd);
            j = 1;
            i = 0;
            break;
            localc.eXO.setVisibility(8);
            break label4850;
            label5065:
            localc.vBn.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            label5105:
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBy.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            if (bool)
            {
              if (!bk.bl(parambi.field_imgPath)) {
                break label5386;
              }
              com.tencent.mm.as.o.ON().a(locala.thumburl, localc.vBn);
            }
            label5184:
            parama = new aw();
            parama.bWO = parambi;
            parama.vgB = false;
            parama.position = paramInt;
            parama.vHj = false;
            parama.title = parama1.cDP();
            parama.bYG = locala.bYG;
            parama.bYH = locala.bYH;
            parama.vHk = locala.title;
            if (locala.type != 26) {
              break label5446;
            }
            parama.tid = locala.tid;
            parama.dSN = locala.dSN;
            parama.desc = locala.desc;
            parama.iconUrl = locala.iconUrl;
            parama.secondUrl = locala.secondUrl;
            parama.pageType = locala.pageType;
            paramString = localc.vBH;
            if (this.vCe == null) {
              this.vCe = new t.k(parama1);
            }
            paramString.setOnClickListener(this.vCe);
            i = 1;
          }
          for (;;)
          {
            localc.vBH.setTag(parama);
            k = 0;
            j = i;
            i = k;
            break;
            localc.eXO.setVisibility(8);
            break label5105;
            label5386:
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama == null) || (parama.isRecycled()))
            {
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
              break label5184;
            }
            localc.vBn.setImageBitmap(parama);
            break label5184;
            label5446:
            if (locala.type == 27)
            {
              parama.tid = locala.tid;
              parama.dSN = locala.dSN;
              parama.desc = locala.desc;
              parama.iconUrl = locala.iconUrl;
              parama.secondUrl = locala.secondUrl;
              parama.pageType = locala.pageType;
              paramString = localc.vBH;
              if (this.vCf == null) {
                this.vCf = new t.i(parama1);
              }
              paramString.setOnClickListener(this.vCf);
              i = 1;
            }
            else
            {
              y.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
              i = 0;
            }
          }
          localc.eXO.setVisibility(0);
          localc.eXO.setText(locala.description);
          localc.eXP.setText(locala.dRL);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.vBs.setVisibility(0);
            localc.vBs.setText(locala.title);
          }
          for (;;)
          {
            localc.eXP.setMaxLines(4);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(8);
            if (!bool) {
              break label6847;
            }
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if (parama == null) {
              break label5737;
            }
            localc.vBn.setImageBitmap(parama);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.vBs.setVisibility(8);
          }
          label5737:
          localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localc.eXO.setVisibility(8);
          localc.vBs.setVisibility(0);
          if ((locala.title != null) && (locala.title.length() > 0)) {
            localc.vBs.setText(j.b(localc.vBs.getContext(), locala.title, (int)localc.vBs.getTextSize()));
          }
          for (;;)
          {
            localc.eXP.setMaxLines(3);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(8);
            if (bool) {
              localc.vBn.setVisibility(8);
            }
            d.c.a(parama1, localc, locala, parambi, bool);
            if (!cHc()) {
              break label5981;
            }
            a(localc, (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi);
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break;
            localc.vBs.setText(j.b(localc.vBs.getContext(), ae.getContext().getString(R.l.favorite_wenote), (int)localc.vBs.getTextSize()));
          }
          label5981:
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          d.c.a(parama1, localc, locala, bool);
          if (cHc())
          {
            a(localc, (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi);
            if (localc.nhQ == null) {
              break label6847;
            }
            localc.nhQ.setVisibility(8);
            i = 0;
            parama = paramString;
            j = k;
            break label946;
          }
          if (localc.nhQ == null) {
            break label6847;
          }
          localc.nhQ.setVisibility(0);
          if (parambi.field_status < 2) {
            break label6847;
          }
          localc.nhQ.setVisibility(8);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            if (!bk.bl(locala.dRU)) {
              if (!bk.bl(locala.dRU))
              {
                localc.eXO.setTextColor(bk.bq(locala.dRU, parama1.vtz.getContext().getResources().getColor(R.e.black)));
                label6225:
                localc.eXP.setMaxLines(2);
                localc.eXP.setVisibility(0);
                if (bk.bl(locala.dRV)) {
                  break label6579;
                }
                localc.eXP.setTextColor(bk.bq(locala.dRV, parama1.vtz.getContext().getResources().getColor(R.e.grey_background_text_color)));
                label6286:
                localc.vBs.setVisibility(8);
                localc.vBt.setVisibility(4);
                localc.vBy.setVisibility(8);
                localc.vBr.setVisibility(0);
                localc.kiv.setVisibility(0);
                if (bk.bl(locala.dRQ)) {
                  break label6606;
                }
                localc.kiv.setText(locala.dRQ);
              }
            }
          }
          for (;;)
          {
            if (this.khG)
            {
              parama = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localObject1 = com.tencent.mm.sdk.platformtools.c.a(parama, false, parama.getWidth() / 2);
                localc.vBn.setImageBitmap((Bitmap)localObject1);
              }
              if (!bk.bl(locala.dRT))
              {
                parama = com.tencent.mm.as.o.ON();
                localObject1 = locala.dRT;
                localObject2 = new ImageView(parama1.vtz.getContext());
                localObject3 = new com.tencent.mm.as.a.a.c.a();
                ((com.tencent.mm.as.a.a.c.a)localObject3).erf = true;
                parama.a((String)localObject1, (ImageView)localObject2, ((com.tencent.mm.as.a.a.c.a)localObject3).OV(), new d.e.3(this, localc, parama1));
                i = 0;
                parama = paramString;
                j = k;
                break;
                localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black));
                break label6225;
                localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black));
                break label6225;
                localc.eXO.setVisibility(8);
                break label6225;
                label6579:
                localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.grey_background_text_color));
                break label6286;
                label6606:
                localc.kiv.setText(R.l.chatting_item_coupon_card);
                continue;
              }
              localc.vBI.getViewTreeObserver().addOnPreDrawListener(new d.e.4(this, localc, parama1, parama));
              i = 0;
              parama = paramString;
              j = k;
              break;
            }
          }
          localc.vBn.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_app));
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          if (((com.tencent.mm.ae.k)localObject2).dTA != 19) {
            break label6847;
          }
          d.c.a(parama1, localc, locala, bool);
          i = 0;
          parama = paramString;
          j = k;
          break label946;
          localc.vBs.setVisibility(8);
          break label1001;
          label6736:
          localObject1 = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
          if (localObject1 != null)
          {
            paramString = (String)localObject1;
            if (!((Bitmap)localObject1).isRecycled()) {}
          }
          else
          {
            paramString = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
          }
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            localc.vBn.setImageBitmap(paramString);
            localObject1 = parama;
          }
          else
          {
            localc.vBn.setImageResource(R.g.appshareimage_icon);
            label6841:
            localObject1 = parama;
          }
        }
        label6847:
        i = 0;
        parama = paramString;
        j = k;
        continue;
        label6860:
        parama = paramString;
        j = k;
      }
      localObject2 = null;
      locala = null;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (parambi.field_content == null) {
      return true;
    }
    g.a locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    if (locala == null) {
      return true;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.h((com.tencent.mm.pluginsdk.model.app.f)localObject)) && (!com.tencent.mm.ui.chatting.k.at(parambi))) {
      paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
    if (((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
    }
    boolean bool;
    switch (locala.type)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((bool) && (!this.vko.cFF())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
      }
      if ((com.tencent.mm.br.d.SP("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject).ZH()))) {
        switch (locala.type)
        {
        }
      }
      for (;;)
      {
        localObject = new do();
        ((do)localObject).bJZ.bIt = parambi.field_msgId;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        if ((((do)localObject).bKa.bJy) || (d.b.a(this.vko.vtz.getContext(), locala))) {
          paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
        bool = com.tencent.mm.ai.f.Mp();
        break;
        bool = com.tencent.mm.ai.f.Ml();
        break;
        bool = com.tencent.mm.ai.f.Mo();
        break;
        bool = com.tencent.mm.ai.f.Mi();
        break;
        bool = com.tencent.mm.ai.f.Mh();
        break;
        bool = com.tencent.mm.ai.f.Mn();
        break;
        bool = com.tencent.mm.ai.f.Mj();
        break;
        if ((locala.dRM != 5) && (locala.dRM != 6) && (locala.dRM != 2)) {
          break label740;
        }
        if (locala.dRM != 2) {
          paramContextMenu.clear();
        }
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
        paramContextMenu.clear();
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      label740:
      bool = false;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              Object localObject = parambi.field_content;
              paramMenuItem = null;
              if (localObject != null) {
                paramMenuItem = g.a.gp((String)localObject);
              }
              if ((paramMenuItem != null) && (19 == paramMenuItem.type))
              {
                localObject = new nd();
                ((nd)localObject).bWJ.type = 3;
                ((nd)localObject).bWJ.bIt = parambi.field_msgId;
                com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
              }
              bd.bC(parambi.field_msgId);
              if (paramMenuItem != null)
              {
                localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramMenuItem.appId, false);
                if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).ZH())) {
                  a(parama, paramMenuItem, parambi, (com.tencent.mm.pluginsdk.model.app.f)localObject);
                }
              }
            } while (paramMenuItem.type != 3);
            d.f(parambi, parama.getTalkerUserName());
            return false;
            d.b.a(parama, parambi, b(parama, parambi));
            return false;
            paramMenuItem = parambi.field_content;
          } while (paramMenuItem == null);
          paramMenuItem = g.a.gp(paramMenuItem);
        } while (paramMenuItem == null);
        switch (paramMenuItem.type)
        {
        case 7: 
        default: 
          return false;
        case 1: 
          ao.l(bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend), parama.vtz.getContext());
          return false;
        case 3: 
          ao.a(parambi, bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend), parama.vtz.getContext());
          return false;
        case 8: 
          ao.d(parambi, parama.vtz.getContext());
          return false;
        case 6: 
          ao.b(parambi, bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend), parama.vtz.getContext());
          return false;
        case 2: 
          ao.a(parambi, parama.vtz.getContext(), b(parama, parambi), parama.cFE());
          return false;
        case 5: 
          ao.c(parambi, bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend), parama.vtz.getContext());
          return false;
        }
        ao.c(parambi, parama.vtz.getContext());
        return false;
        paramMenuItem = parambi.field_content;
      } while (paramMenuItem == null);
      paramMenuItem = g.a.gp(paramMenuItem);
    } while (paramMenuItem == null);
    switch (paramMenuItem.type)
    {
    default: 
      return false;
    }
    parama = new if();
    parama.bQq.bQr = paramMenuItem.bQr;
    parama.bQq.bHR = parambi.field_msgId;
    parama.bQq.bQs = parambi.field_talker;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return ((paramBoolean) && (paramInt == 49)) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView.getTag();
    paramView = parambi.field_content;
    if (paramView == null) {
      return false;
    }
    Object localObject1 = g.a.gp(paramView);
    if (localObject1 == null) {
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, true);
    if ((paramView != null) && (!bk.bl(paramView.field_appId)) && (paramView.ZH())) {
      a(parama, (g.a)localObject1, q.Gj(), paramView, parambi.field_msgSvrId);
    }
    int i;
    Object localObject3;
    Object localObject4;
    switch (((g.a)localObject1).type)
    {
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 35: 
    default: 
      if ((((g.a)localObject1).url == null) || (((g.a)localObject1).url.equals(""))) {
        break label4188;
      }
      if (!bk.bl(((g.a)localObject1).canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", parambi.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", ((g.a)localObject1).canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", parambi.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        return true;
      }
      break;
    case 6: 
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
        return true;
      }
      if (bk.aaf(((g.a)localObject1).dQw))
      {
        long l = parambi.field_msgId;
        localObject1 = ((g.a)localObject1).bFE;
        paramView = ap.avh().VQ((String)localObject1);
        if ((paramView == null) || (!paramView.aXY())) {
          i = 0;
        }
        while (i != 0)
        {
          return true;
          au.Hx();
          localObject2 = com.tencent.mm.model.c.Fy().fd(l);
          if (((bi)localObject2).cvx())
          {
            y.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject1, Long.valueOf(l), Long.valueOf(((cs)localObject2).field_msgSvrId), ((cs)localObject2).field_imgPath });
            paramView = new Intent();
            paramView.setClassName(this.vko.vtz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramView.putExtra("clean_view_type", 1);
            this.vko.startActivity(paramView);
            i = 1;
          }
          else
          {
            localObject1 = new Intent(this.vko.vtz.getContext(), ShowImageUI.class);
            ((Intent)localObject1).putExtra("key_image_path", paramView.field_fileFullPath);
            ((Intent)localObject1).putExtra("key_message_id", l);
            ((Intent)localObject1).putExtra("key_favorite", true);
            this.vko.startActivity((Intent)localObject1);
            i = 1;
          }
        }
      }
      paramView = new Intent();
      paramView.setClassName(parama.vtz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
      paramView.putExtra("app_msg_id", parambi.field_msgId);
      parama.startActivity(paramView);
      return true;
    case 3: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(13043, new Object[] { Integer.valueOf(2), ((g.a)localObject1).description, ((g.a)localObject1).appId });
    case 4: 
      if (a(parama, (g.a)localObject1, parambi)) {
        return true;
      }
      localObject2 = p.u(((g.a)localObject1).url, "message");
      localObject3 = p.u(((g.a)localObject1).dQu, "message");
      localObject4 = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
      if (localObject4 == null)
      {
        paramView = null;
        if (localObject4 != null) {
          break label793;
        }
      }
      for (i = 0;; i = ((PackageInfo)localObject4).versionCode)
      {
        a(parama, (String)localObject2, (String)localObject3, paramView, i, ((g.a)localObject1).appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
        return true;
        paramView = ((PackageInfo)localObject4).versionName;
        break;
      }
    case 5: 
      if (!bk.bl(((g.a)localObject1).canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", parambi.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", ((g.a)localObject1).canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", parambi.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        return true;
      }
      paramView = (ab)((g.a)localObject1).A(ab.class);
      if ((paramView != null) && (!bk.bl(paramView.qTY)))
      {
        localObject1 = new ckw();
        ((ckw)localObject1).qTY = paramView.qTY;
        ((ckw)localObject1).qTZ = paramView.qTZ;
        ((ckw)localObject1).qUa = paramView.qUa;
        ((ckw)localObject1).qUb = paramView.qUb;
        ((ckw)localObject1).qUc = paramView.qUc;
        ((ckw)localObject1).qUg = paramView.qUg;
        ((ckw)localObject1).jxR = paramView.jxR;
        ((ckw)localObject1).jxS = paramView.jxS;
        ((ckw)localObject1).oBT = paramView.oBT;
        ((ckw)localObject1).qUd = paramView.qUd;
        ((ckw)localObject1).qUe = paramView.qUe;
        ((ckw)localObject1).qUf = paramView.qUf;
        ((ckw)localObject1).aWf = paramView.aWf;
        ((ckw)localObject1).mSy = paramView.mSy;
        ((ckw)localObject1).qUh = paramView.qUh;
        ((ckw)localObject1).qUj = paramView.qUj;
        ((ckw)localObject1).qUk = paramView.qUk;
        paramView = com.tencent.mm.plugin.topstory.a.g.a((ckw)localObject1, 32, parama.vtz.getContext().getString(R.l.fts_recommend_search_keyword));
        aa.a(parama.vtz.getContext(), paramView);
        com.tencent.mm.plugin.topstory.a.h.a((ckw)localObject1, parambi);
        return true;
      }
      if ((((g.a)localObject1).url != null) && (!((g.a)localObject1).url.equals("")))
      {
        localObject2 = ((g.a)localObject1).url;
        if (parama.cFE())
        {
          paramView = "groupmessage";
          localObject2 = p.u((String)localObject2, paramView);
          paramView = ((g.a)localObject1).dQu;
          localObject3 = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject4).putExtra("webpageTitle", ((g.a)localObject1).title);
          Bundle localBundle = new Bundle();
          localBundle.putString("key_snsad_statextstr", ((g.a)localObject1).bYN);
          if ((((g.a)localObject1).appId != null) && (("wx751a1acca5688ba3".equals(((g.a)localObject1).appId)) || ("wxfbc915ff7c30e335".equals(((g.a)localObject1).appId)) || ("wx482a4001c37e2b74".equals(((g.a)localObject1).appId)))) {
            localBundle.putString("jsapi_args_appid", ((g.a)localObject1).appId);
          }
          ((Intent)localObject4).putExtra("jsapiargs", localBundle);
          if (bk.bl(paramView)) {
            break label1803;
          }
          ((Intent)localObject4).putExtra("shortUrl", paramView);
          if (localObject3 != null) {
            break label1820;
          }
          paramView = null;
          ((Intent)localObject4).putExtra("version_name", paramView);
          if (localObject3 != null) {
            break label1829;
          }
          i = 0;
          ((Intent)localObject4).putExtra("version_code", i);
          if (!bk.bl(((g.a)localObject1).bYG))
          {
            ((Intent)localObject4).putExtra("srcUsername", ((g.a)localObject1).bYG);
            ((Intent)localObject4).putExtra("srcDisplayname", ((g.a)localObject1).bYH);
          }
          ((Intent)localObject4).putExtra("msg_id", parambi.field_msgId);
          ((Intent)localObject4).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
          ((Intent)localObject4).putExtra("KAppId", ((g.a)localObject1).appId);
          ((Intent)localObject4).putExtra("geta8key_username", parama.getTalkerUserName());
          ((Intent)localObject4).putExtra("pre_username", b(parama, parambi));
          ((Intent)localObject4).putExtra("from_scence", 2);
          i = com.tencent.mm.model.t.R(b(parama, parambi), parama.getTalkerUserName());
          ((Intent)localObject4).putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
          ((Intent)localObject4).putExtra("preUsername", b(parama, parambi));
          ((Intent)localObject4).putExtra("preChatName", parama.getTalkerUserName());
          ((Intent)localObject4).putExtra("preChatTYPE", i);
          ((Intent)localObject4).putExtra("preMsgIndex", 0);
          switch (i)
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            i = 0;
          }
        }
        for (;;)
        {
          ((Intent)localObject4).putExtra("share_report_pre_msg_url", ((g.a)localObject1).url);
          ((Intent)localObject4).putExtra("share_report_pre_msg_title", ((g.a)localObject1).title);
          ((Intent)localObject4).putExtra("share_report_pre_msg_desc", ((g.a)localObject1).description);
          ((Intent)localObject4).putExtra("share_report_pre_msg_icon_url", ((g.a)localObject1).thumburl);
          ((Intent)localObject4).putExtra("share_report_pre_msg_appid", ((g.a)localObject1).appId);
          ((Intent)localObject4).putExtra("share_report_from_scene", i);
          if (i == 5) {
            ((Intent)localObject4).putExtra("share_report_biz_username", parama.getTalkerUserName());
          }
          if ((!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.ayw()) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayv()) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.a(parama.vtz.getContext(), (String)localObject2, (Intent)localObject4, 0))) {
            break label1857;
          }
          y.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          return true;
          paramView = "singlemessage";
          break;
          ((Intent)localObject4).putExtra("shortUrl", ((g.a)localObject1).url);
          break label1340;
          paramView = ((PackageInfo)localObject3).versionName;
          break label1347;
          i = ((PackageInfo)localObject3).versionCode;
          break label1365;
          i = 2;
          continue;
          i = 3;
          continue;
          i = 5;
        }
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
      }
      return true;
    case 33: 
      y.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((g.a)localObject1).dSY, ((g.a)localObject1).dSX, ((g.a)localObject1).dSZ, ((g.a)localObject1).url, Integer.valueOf(((g.a)localObject1).dTf), ((g.a)localObject1).dTb });
      localObject2 = parama.getTalkerUserName();
      localObject3 = b(parama, parambi);
      localObject4 = new Bundle();
      if ((parama.vtz instanceof AppBrandServiceChattingUI.a))
      {
        i = 10;
        ((Bundle)localObject4).putInt("stat_scene", i);
        ((Bundle)localObject4).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
        ((Bundle)localObject4).putString("stat_chat_talker_username", (String)localObject2);
        ((Bundle)localObject4).putString("stat_send_msg_user", (String)localObject3);
        switch (((g.a)localObject1).dTa)
        {
        default: 
          i = 1;
        }
      }
      while (i == 0)
      {
        return true;
        if (parama.cFE())
        {
          i = 2;
          break label1979;
        }
        if (com.tencent.mm.model.s.hl((String)localObject2))
        {
          i = 7;
          break label1979;
        }
        i = 1;
        break label1979;
        paramView = new Intent();
        paramView.putExtra("key_username", ((g.a)localObject1).dSY);
        if (parama.cFE())
        {
          paramView.putExtra("key_from_scene", 1);
          paramView.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + (String)localObject3);
        }
        for (;;)
        {
          paramView.putExtra("_stat_obj", (Bundle)localObject4);
          localObject2 = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject2).appId = ((g.a)localObject1).dSZ;
          ((WxaExposedParams.a)localObject2).from = 6;
          ((WxaExposedParams.a)localObject2).fEM = ((g.a)localObject1).dTf;
          ((WxaExposedParams.a)localObject2).fEN = ((g.a)localObject1).dTc;
          paramView.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject2).aes());
          com.tencent.mm.br.d.b(parama.vtz.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramView);
          i = 0;
          break;
          paramView.putExtra("key_from_scene", 2);
          paramView.putExtra("key_scene_note", (String)localObject2);
        }
        if ((parama.vtz instanceof AppBrandServiceChattingUI.a))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1073, (g.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
        else if (com.tencent.mm.model.s.hl((String)localObject2))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1074, (g.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, (String)localObject3, parama.cFE(), (g.a)localObject1, (Bundle)localObject4);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject2, (String)localObject3, parama.cFE(), (g.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
      }
    case 36: 
      if ((bk.bl(((g.a)localObject1).dSZ)) && (bk.bl(((g.a)localObject1).dSY)))
      {
        parambi = ((g.a)localObject1).url;
        if (parama.cFE()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramView = p.u(parambi, paramView);
          parambi = new Intent();
          parambi.putExtra("rawUrl", paramView);
          parambi.putExtra("webpageTitle", ((g.a)localObject1).title);
          parambi.putExtra("shortUrl", ((g.a)localObject1).url);
          com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
          return true;
        }
      }
      paramView = parama.getTalkerUserName();
      localObject2 = b(parama, parambi);
      localObject3 = new Bundle();
      if (parama.cFE()) {
        i = 2;
      }
      for (;;)
      {
        ((Bundle)localObject3).putInt("stat_scene", i);
        ((Bundle)localObject3).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
        ((Bundle)localObject3).putString("stat_chat_talker_username", paramView);
        ((Bundle)localObject3).putString("stat_send_msg_user", (String)localObject2);
        ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(parama.vtz.getContext(), parama.getTalkerUserName(), b(parama, parambi), parama.cFE(), (g.a)localObject1);
        return true;
        if (com.tencent.mm.model.s.hl(paramView)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    case 7: 
      if ((paramView != null) && (paramView.ZH()) && (a(parama, paramView))) {
        return true;
      }
      ((com.tencent.mm.ui.chatting.b.b.a)parama.ac(com.tencent.mm.ui.chatting.b.b.a.class)).a(parambi, new d.e.5(this, paramView, parama, (g.a)localObject1, parambi));
      return true;
    case 10: 
      if (bk.bl(((g.a)localObject1).dQZ)) {
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_Product_xml", ((g.a)localObject1).dQZ);
      paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
      if (parambi.field_imgPath == null) {
        paramView.putExtra("key_ProductUI_chatting_msgId", parambi.field_msgId);
      }
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "scanner", ".ui.ProductUI", paramView);
      return true;
    case 20: 
      if (bk.bl(((g.a)localObject1).dRc)) {
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_TV_xml", ((g.a)localObject1).dRc);
      paramView.putExtra("key_TV_getProductInfoScene", 1);
      if (parambi.field_imgPath == null) {
        paramView.putExtra("key_TVInfoUI_chatting_msgId", parambi.field_msgId);
      }
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "shake", ".ui.TVInfoUI", paramView);
      return true;
    case 13: 
      if (bk.bl(((g.a)localObject1).dRf)) {
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_product_info", ((g.a)localObject1).dRf);
      paramView.putExtra("key_product_scene", 1);
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "product", ".ui.MallProductUI", paramView);
      return true;
    case 16: 
      if (bk.bl(((g.a)localObject1).bQr)) {
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((g.a)localObject1).bQr);
      paramView.putExtra("key_from_scene", ((g.a)localObject1).dRM);
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "card", ".ui.CardDetailUI", paramView);
      return true;
    case 19: 
      paramView = new Intent();
      paramView.putExtra("message_id", parambi.field_msgId);
      paramView.putExtra("record_xml", ((g.a)localObject1).dRd);
      d.a.a(paramView, parama, parambi, this);
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
      return true;
    case 24: 
      paramView = new lp();
      paramView.bUG.context = parama.vtz.getContext();
      paramView.bUG.bIt = parambi.field_msgId;
      paramView.bUG.bTT = parama.cFE();
      paramView.bUG.bUH = ((g.a)localObject1).dRd;
      paramView.bUG.scene = 6;
      com.tencent.mm.sdk.b.a.udP.m(paramView);
      return true;
    case 34: 
      label793:
      label1340:
      label1347:
      label1365:
      paramView = new Intent();
      label1803:
      label1820:
      label1829:
      label1857:
      paramView.putExtra("key_biz_uin", ((g.a)localObject1).dRO);
      label1979:
      paramView.putExtra("key_order_id", ((g.a)localObject1).dRP);
      if ((parambi.field_talker != null) && (!parambi.field_talker.equals("")) && (com.tencent.mm.model.s.fn(parambi.field_talker))) {
        paramView.putExtra("key_chatroom_name", parambi.field_talker);
      }
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
      return true;
    }
    paramView = (ab)((g.a)localObject1).A(ab.class);
    if ((paramView != null) && (!bk.bl(paramView.qTY)))
    {
      localObject1 = new ckw();
      ((ckw)localObject1).qTY = paramView.qTY;
      ((ckw)localObject1).qTZ = paramView.qTZ;
      ((ckw)localObject1).qUa = paramView.qUa;
      ((ckw)localObject1).qUb = paramView.qUb;
      ((ckw)localObject1).qUc = paramView.qUc;
      ((ckw)localObject1).qUg = paramView.qUg;
      ((ckw)localObject1).jxR = paramView.jxR;
      ((ckw)localObject1).jxS = paramView.jxS;
      ((ckw)localObject1).oBT = paramView.oBT;
      ((ckw)localObject1).qUd = paramView.qUd;
      ((ckw)localObject1).qUe = paramView.qUe;
      ((ckw)localObject1).qUf = paramView.qUf;
      ((ckw)localObject1).aWf = paramView.aWf;
      ((ckw)localObject1).mSy = paramView.mSy;
      ((ckw)localObject1).qUh = paramView.qUh;
      ((ckw)localObject1).qUj = paramView.qUj;
      ((ckw)localObject1).qUk = paramView.qUk;
      paramView = com.tencent.mm.plugin.topstory.a.g.a((ckw)localObject1, 32, parama.vtz.getContext().getString(R.l.fts_recommend_search_keyword));
      aa.a(parama.vtz.getContext(), paramView);
      com.tencent.mm.plugin.topstory.a.h.a((ckw)localObject1, parambi);
      return true;
    }
    Object localObject2 = ((g.a)localObject1).url;
    if (parama.cFE())
    {
      paramView = "groupmessage";
      localObject4 = p.u((String)localObject2, paramView);
      paramView = ((g.a)localObject1).url;
      localObject2 = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject3).putExtra("webpageTitle", ((g.a)localObject1).title);
      if ((((g.a)localObject1).appId != null) && (("wx751a1acca5688ba3".equals(((g.a)localObject1).appId)) || ("wxfbc915ff7c30e335".equals(((g.a)localObject1).appId)) || ("wx482a4001c37e2b74".equals(((g.a)localObject1).appId))))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("jsapi_args_appid", ((g.a)localObject1).appId);
        ((Intent)localObject3).putExtra("jsapiargs", (Bundle)localObject4);
      }
      if (bk.bl(paramView)) {
        break label4134;
      }
      ((Intent)localObject3).putExtra("shortUrl", paramView);
      label3677:
      if (localObject2 != null) {
        break label4151;
      }
      paramView = null;
      label3684:
      ((Intent)localObject3).putExtra("version_name", paramView);
      if (localObject2 != null) {
        break label4160;
      }
      i = 0;
      label3702:
      ((Intent)localObject3).putExtra("version_code", i);
      if (!bk.bl(((g.a)localObject1).bYG))
      {
        ((Intent)localObject3).putExtra("srcUsername", ((g.a)localObject1).bYG);
        ((Intent)localObject3).putExtra("srcDisplayname", ((g.a)localObject1).bYH);
      }
      ((Intent)localObject3).putExtra("msg_id", parambi.field_msgId);
      ((Intent)localObject3).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject3).putExtra("KAppId", ((g.a)localObject1).appId);
      ((Intent)localObject3).putExtra("geta8key_username", parama.getTalkerUserName());
      ((Intent)localObject3).putExtra("pre_username", b(parama, parambi));
      ((Intent)localObject3).putExtra("from_scence", 2);
      ((Intent)localObject3).putExtra("expid_str", parambi.cQO);
      i = com.tencent.mm.model.t.R(b(parama, parambi), parama.getTalkerUserName());
      ((Intent)localObject3).putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject3).putExtra("preUsername", b(parama, parambi));
      ((Intent)localObject3).putExtra("preChatName", parama.getTalkerUserName());
      ((Intent)localObject3).putExtra("preChatTYPE", i);
      ((Intent)localObject3).putExtra("preMsgIndex", 0);
      switch (i)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((Intent)localObject3).putExtra("share_report_pre_msg_url", ((g.a)localObject1).url);
      ((Intent)localObject3).putExtra("share_report_pre_msg_title", ((g.a)localObject1).title);
      ((Intent)localObject3).putExtra("share_report_pre_msg_desc", ((g.a)localObject1).description);
      ((Intent)localObject3).putExtra("share_report_pre_msg_icon_url", ((g.a)localObject1).thumburl);
      ((Intent)localObject3).putExtra("share_report_pre_msg_appid", ((g.a)localObject1).appId);
      ((Intent)localObject3).putExtra("share_report_from_scene", i);
      if (i == 5) {
        ((Intent)localObject3).putExtra("share_report_biz_username", parama.getTalkerUserName());
      }
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
      return true;
      paramView = "singlemessage";
      break;
      label4134:
      ((Intent)localObject3).putExtra("shortUrl", ((g.a)localObject1).url);
      break label3677;
      label4151:
      paramView = ((PackageInfo)localObject2).versionName;
      break label3684;
      label4160:
      i = ((PackageInfo)localObject2).versionCode;
      break label3702;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
    label4188:
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e
 * JD-Core Version:    0.7.0.1
 */