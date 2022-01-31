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
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.a.a;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.lp;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.pluginsdk.model.app.l;
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
import com.tencent.mm.ui.chatting.t.h;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.x;
import java.util.List;

public final class d$d
  extends c
{
  private boolean kay;
  protected t.h vCd;
  protected t.k vCe;
  protected t.i vCf;
  private com.tencent.mm.ui.chatting.c.a vko;
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg);
      ((View)localObject).setTag(new d.c().r((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    d.c localc = (d.c)parama;
    this.vko = parama1;
    localc.reset();
    Object localObject2 = parambi.field_content;
    Object localObject1 = (com.tencent.mm.ui.chatting.b.b.i)parama1.ac(com.tencent.mm.ui.chatting.b.b.i.class);
    ((com.tencent.mm.ui.chatting.b.b.i)localObject1).aU(parambi);
    ((com.tencent.mm.ui.chatting.b.b.i)localObject1).aV(parambi);
    ((com.tencent.mm.ui.chatting.b.b.i)localObject1).aW(parambi);
    int i;
    if (this.kay)
    {
      i = parambi.field_content.indexOf(':');
      if (i != -1) {
        localObject2 = parambi.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      g.a locala;
      Object localObject3;
      int j;
      label445:
      label471:
      com.tencent.mm.pluginsdk.model.app.f localf;
      label541:
      boolean bool;
      if (localObject2 != null)
      {
        locala = g.a.M((String)localObject2, parambi.field_reserved);
        localObject3 = com.tencent.mm.ae.k.gv((String)localObject2);
        paramString = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
        i = 0;
        j = 0;
        localObject1 = paramString;
        if (locala != null)
        {
          localc.eXO.setText(locala.getTitle());
          localc.eXP.setText(locala.getDescription());
          localc.vBs.setMaxLines(1);
          localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.normal_text_color));
          localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.hint_text_color));
          localc.vBI.setBackgroundResource(R.g.chat_from_content_bg_mask);
          localc.vBI.setPadding(0, parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          localc.vBn.setVisibility(0);
          localc.vBG.setVisibility(0);
          localc.eXP.setVisibility(0);
          localc.vBu.setVisibility(8);
          localc.vBx.setVisibility(8);
          localc.vBw.setVisibility(8);
          localc.vBK.setVisibility(8);
          localc.vBL.setVisibility(8);
          localc.vBp.setVisibility(8);
          localc.vBq.setVisibility(8);
          localc.vBV.setVisibility(8);
          localc.vBO.setVisibility(8);
          localc.vBI.setVisibility(0);
          d.c.Y(localc.vBH, localc.vBZ);
          localObject1 = (com.tencent.mm.ae.e)locala.A(com.tencent.mm.ae.e.class);
          ChattingItemFooter localChattingItemFooter = localc.vBA;
          if (localObject1 != null) {
            break label1515;
          }
          localObject1 = null;
          if (!localChattingItemFooter.l((List)localObject1, parambi.field_talker)) {
            break label1525;
          }
          localc.vBH.setBackgroundResource(R.g.chatfrom_bg_apptop);
          localf = com.tencent.mm.pluginsdk.model.app.g.dh(locala.appId, locala.cau);
          if ((localf != null) && (localf.ZH())) {
            b(parama1, locala, parambi);
          }
          if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
            break label1539;
          }
          localObject1 = locala.appName;
          bool = true;
          com.tencent.mm.cb.a.fromDPToPix(parama1.vtz.getContext(), 12);
          if ((locala.type == 20) || ("wxaf060266bfa9a35c".equals(locala.appId))) {
            bool = o.a.ckl().bzS();
          }
          if ((!bool) || (locala.appId == null) || (locala.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.ct((String)localObject1))) {
            break label1566;
          }
          localc.kiv.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.vtz.getContext(), localf, (String)localObject1));
          localc.kiv.setVisibility(0);
          localc.kiv.setCompoundDrawables(null, null, null, null);
          localc.vBr.setVisibility(0);
          localc.vBo.setVisibility(0);
          if ((localf == null) || (!localf.ZH())) {
            break label1549;
          }
          a(parama1, localc.kiv, parambi, locala, localf.field_packageName, parambi.field_msgSvrId);
          label720:
          a(parama1, localc.vBo, locala.appId);
          label734:
          if ((locala.dQs == null) || (locala.dQs.dTs == 0)) {
            break label1735;
          }
          i = 1;
          label756:
          if (i != 0) {
            localc.vBr.setVisibility(8);
          }
          bool = false;
          localc.vBn.setVisibility(0);
          if ((locala.dQs == null) || (locala.dQs.dTp != 1)) {
            break label1741;
          }
          i = 1;
          label806:
          if ((i != 0) || (!this.khG)) {
            break label1753;
          }
          localChattingItemFooter = null;
          localObject1 = localChattingItemFooter;
          if (locala.type != 33)
          {
            localObject1 = localChattingItemFooter;
            if (locala.type != 36) {
              localObject1 = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            }
          }
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            break label1747;
          }
          localc.vBn.setImageBitmap((Bitmap)localObject1);
          label896:
          if (locala.type == 3) {
            localc.vBI.getViewTreeObserver().addOnPreDrawListener(new d.d.1(this, localc, parama1, (Bitmap)localObject1));
          }
          label929:
          if ((locala.cQF != null) && (locala.cQF.length() != 0)) {
            break label1780;
          }
          localc.vBz.setVisibility(8);
          label958:
          localc.vBy.setOnClickListener(null);
          localc.vBC.setVisibility(0);
          localc.vBt.setVisibility(8);
          localc.vBF.setVisibility(0);
          localc.vBD.setVisibility(8);
        }
      }
      label1362:
      label1747:
      label1753:
      label5090:
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
        paramInt = 1;
        parama = paramString;
        i = j;
      case 3: 
      case 6: 
      case 4: 
      case 5: 
      case 36: 
      case 33: 
      case 7: 
      case 10: 
      case 13: 
      case 20: 
      case 0: 
        for (;;)
        {
          if (paramInt != 0)
          {
            if ((locala.title == null) || (locala.title.length() <= 0)) {
              break label6444;
            }
            localc.vBs.setVisibility(0);
            localc.vBs.setMaxLines(2);
            localc.vBs.setText(locala.title);
            localc.eXO.setVisibility(8);
            if (bool)
            {
              if ((locala.type != 33) && (locala.type != 36)) {
                break label6457;
              }
              paramString = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
              com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBn, "file://" + paramString, null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(50, 50));
            }
          }
          if (parama1.cFE()) {
            break label6578;
          }
          if (!com.tencent.mm.pluginsdk.model.app.g.g(localf)) {
            break label6562;
          }
          localc.vBB.setVisibility(0);
          c(parama1, localc.vBB, aw.a(locala, parambi));
          localObject1 = parama;
          if (i == 0)
          {
            localc.vBH.setTag(localObject1);
            localc.vBH.setOnClickListener(d(parama1));
          }
          if (this.khG)
          {
            localc.vBH.setOnLongClickListener(c(parama1));
            localc.vBH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          }
          return;
          y.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
          localObject3 = null;
          locala = null;
          break;
          localObject1 = ((com.tencent.mm.ae.e)localObject1).dQr;
          break label445;
          localc.vBH.setBackgroundResource(R.g.chatfrom_bg_app);
          break label471;
          localObject1 = localf.field_appName;
          break label541;
          a(parama1, localc.kiv, locala.appId);
          break label720;
          if (locala.type == 24)
          {
            localc.kiv.setText(ae.getContext().getString(R.l.favorite));
            localc.vBr.setVisibility(0);
            localc.kiv.setVisibility(0);
            localc.vBo.setVisibility(8);
            break label734;
          }
          if ((locala.type == 19) || (((com.tencent.mm.ae.k)localObject3).dTA == 19))
          {
            localc.kiv.setText(ae.getContext().getString(R.l.chatting_item_record));
            localc.vBr.setVisibility(0);
            localc.kiv.setVisibility(0);
            localc.vBo.setVisibility(8);
            break label734;
          }
          if (d.a(locala, localc)) {
            break label734;
          }
          localc.vBr.setVisibility(8);
          localc.kiv.setVisibility(8);
          localc.vBo.setVisibility(8);
          break label734;
          i = 0;
          break label756;
          i = 0;
          break label806;
          bool = true;
          break label896;
          localc.vBn.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_app));
          bool = false;
          break label929;
          localc.vBz.setVisibility(0);
          b(parama1, localc.vBz, aw.adO(locala.cQF));
          break label958;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white));
            localc.eXP.setVisibility(0);
            localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white));
            localc.vBs.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(0);
            if (!parambi.field_msgId.equals(parama.vBb)) {
              break label2110;
            }
            localc.vBy.setImageResource(R.g.music_pauseicon);
            localc.eXP.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label2124;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_music);
            }
          }
          for (;;)
          {
            parama = new d.f();
            parama.bIt = parambi.field_msgId;
            parama.bUr = parambi.field_content;
            parama.imgPath = parambi.field_imgPath;
            localc.vBy.setTag(parama);
            localc.vBy.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDv());
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.eXO.setVisibility(8);
            break label1862;
            localc.vBy.setImageResource(R.g.music_playicon);
            break label1962;
            localc.vBn.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXO.setMaxLines(2);
          }
          for (;;)
          {
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBy.setVisibility(8);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            localc.eXP.setText(bk.cm(locala.dQv));
            d.c.a(localc, (String)localObject2, locala.dQv);
            d.c.a(localc, Boolean.valueOf(true), parambi, locala.bFE, locala.title);
            if (!bool) {
              break label6594;
            }
            if (!bk.aaf(locala.dQw)) {
              break label2322;
            }
            localc.vBn.setImageResource(R.g.appshareimage_icon);
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.eXO.setVisibility(8);
          }
          localc.vBn.setImageResource(com.tencent.mm.pluginsdk.model.o.VP(locala.dQw));
          paramInt = 0;
          parama = paramString;
          i = j;
          continue;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            localc.eXP.setVisibility(0);
            localc.vBs.setVisibility(8);
            localc.vBy.setVisibility(0);
            localc.vBy.setImageResource(R.g.video_download_btn);
            localc.vBt.setVisibility(4);
            localc.eXP.setMaxLines(2);
            if (!bool) {
              break label6594;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2517;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_video);
          }
          for (;;)
          {
            localc.vBy.setVisibility(8);
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.eXO.setVisibility(8);
            break label2378;
            localc.vBn.setImageBitmap(parama);
          }
          localc.eXO.setVisibility(8);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.vBs.setMaxLines(2);
            localc.vBs.setVisibility(0);
            localc.vBs.setText(locala.getTitle());
            localc.eXP.setMaxLines(3);
            if (!d.h(locala)) {
              break label2776;
            }
            localc.vBy.setVisibility(0);
            localc.vBy.setImageResource(R.g.video_download_btn);
            localc.vBt.setVisibility(4);
            if (!bool) {
              break label6594;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2798;
            }
            localObject1 = new com.tencent.mm.as.a.a.c.a();
            ((com.tencent.mm.as.a.a.c.a)localObject1).eru = R.k.app_attach_file_icon_webpage;
            ((com.tencent.mm.as.a.a.c.a)localObject1).bn(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50)).erd = true;
            localObject2 = com.tencent.mm.as.o.ON();
            if (!bk.bl(locala.thumburl)) {
              break label2789;
            }
          }
          for (parama = locala.dQC;; parama = locala.thumburl)
          {
            ((com.tencent.mm.as.a.a)localObject2).a(parama, localc.vBn, ((com.tencent.mm.as.a.a.c.a)localObject1).OV());
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.vBs.setVisibility(8);
            break label2589;
            localc.vBy.setVisibility(8);
            break label2626;
          }
          localc.vBn.setImageBitmap(parama);
          paramInt = 0;
          parama = paramString;
          i = j;
          continue;
          localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(locala.dSY);
          if (localObject1 != null)
          {
            parama = ((WxaAttributes)localObject1).field_nickname;
            if (localObject1 == null) {
              break label3086;
            }
            localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;
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
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            parama = locala.bYH;
            break label2851;
            localObject1 = locala.dTh;
            break label2863;
            localc.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
            continue;
            localc.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(locala.dSY);
          switch (locala.dTa)
          {
          default: 
            paramInt = 1;
            parama = paramString;
            i = j;
            break;
          case 2: 
          case 3: 
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              if (localObject1 == null) {
                break label3456;
              }
              localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;
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
              localc.vBW.setVisibility(4);
              localc.vBX.setVisibility(0);
              com.tencent.mm.modelappbrand.a.b.JD().a(new d.d.2(this, localc), "file://" + parama, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(240, 192));
              paramInt = 0;
              parama = paramString;
              i = j;
              break;
              parama = locala.bYH;
              break label3199;
              localObject1 = locala.dTh;
              break label3211;
              localc.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
              continue;
              localc.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
            }
          case 1: 
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              if (localObject1 == null) {
                break label3633;
              }
            }
            for (localObject1 = ((WxaAttributes)localObject1).field_smallHeadURL;; localObject1 = null)
            {
              localc.vBI.setVisibility(8);
              localc.vBV.setVisibility(8);
              localc.vBO.setVisibility(0);
              localc.vBQ.setText(parama);
              if (!bk.bl((String)localObject1)) {
                break label3639;
              }
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, true);
              com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBP, "file://" + parama, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
              paramInt = 0;
              parama = paramString;
              i = j;
              break;
              parama = locala.title;
              break label3505;
            }
            com.tencent.mm.modelappbrand.a.b.JD().a(localc.vBP, (String)localObject1, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
            paramInt = 0;
            parama = paramString;
            i = j;
            continue;
            localc.eXO.setVisibility(8);
            if ((locala.title != null) && (locala.title.trim().length() > 0))
            {
              localc.vBs.setMaxLines(2);
              localc.vBs.setVisibility(0);
              localc.vBs.setText(locala.getTitle());
            }
            for (;;)
            {
              localc.eXP.setMaxLines(3);
              localc.vBy.setVisibility(8);
              localc.vBt.setVisibility(4);
              if (!bool) {
                break label6594;
              }
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label3834;
              }
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
              paramInt = 0;
              parama = paramString;
              i = j;
              break;
              localc.vBs.setVisibility(8);
            }
            localc.vBn.setImageBitmap(parama);
            paramInt = 0;
            parama = paramString;
            i = j;
            continue;
            localc.vBs.setVisibility(0);
            if (locala.dQY == 1) {
              localc.vBs.setText(R.l.scan_product_appmsg_top_title_book);
            }
            for (;;)
            {
              if ((locala.title != null) && (locala.title.length() > 0))
              {
                localc.eXO.setVisibility(0);
                localc.eXO.setText(locala.getTitle());
              }
              localc.eXP.setMaxLines(4);
              localc.vBt.setVisibility(4);
              localc.vBy.setVisibility(8);
              if (!bool) {
                break label6594;
              }
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
              if ((parama == null) || (parama.isRecycled())) {
                break label4073;
              }
              localc.vBn.setImageBitmap(parama);
              paramInt = 0;
              parama = paramString;
              i = j;
              break;
              if (locala.dQY == 2) {
                localc.vBs.setText(R.l.scan_product_appmsg_top_title_movie);
              } else if (locala.dQY == 3) {
                localc.vBs.setText(R.l.scan_product_appmsg_top_title_cd);
              } else {
                localc.vBs.setText(R.l.scan_product_appmsg_top_title_product);
              }
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
            paramInt = 0;
            parama = paramString;
            i = j;
            continue;
            localc.eXO.setVisibility(0);
            localc.eXO.setText(locala.getTitle());
            localc.vBs.setVisibility(0);
            localc.vBs.setText(R.l.chatting_mall_product_msg_title);
            localc.eXP.setMaxLines(4);
            localc.vBt.setVisibility(4);
            localc.vBy.setVisibility(8);
            if (!bool) {
              break label6594;
            }
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama != null) && (!parama.isRecycled()))
            {
              localc.vBn.setImageBitmap(parama);
              paramInt = 0;
              parama = paramString;
              i = j;
            }
            else
            {
              localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
              paramInt = 0;
              parama = paramString;
              i = j;
              continue;
              if ((locala.title != null) && (locala.title.length() > 0))
              {
                localc.eXO.setVisibility(0);
                localc.eXO.setText(locala.getTitle());
                localc.vBs.setVisibility(8);
              }
              localc.eXP.setMaxLines(4);
              localc.vBt.setVisibility(4);
              localc.vBy.setVisibility(8);
              if (!bool) {
                break label6594;
              }
              parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.vBn.setImageBitmap(parama);
                paramInt = 0;
                parama = paramString;
                i = j;
              }
              else
              {
                localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
                paramInt = 0;
                parama = paramString;
                i = j;
                continue;
                if ((locala.title != null) && (locala.title.length() > 0)) {
                  localc.eXO.setVisibility(0);
                }
                for (;;)
                {
                  localc.eXP.setVisibility(0);
                  localc.vBs.setVisibility(8);
                  localc.vBy.setVisibility(8);
                  localc.vBt.setVisibility(4);
                  localc.eXP.setMaxLines(2);
                  if (!bool) {
                    break label6594;
                  }
                  parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label4558;
                  }
                  localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
                  paramInt = 0;
                  parama = paramString;
                  i = j;
                  break;
                  localc.eXO.setVisibility(8);
                }
                localc.vBn.setImageBitmap(parama);
                paramInt = 0;
                parama = paramString;
                i = j;
              }
            }
            break;
          }
        }
      case 15: 
        if ((locala.title != null) && (locala.title.length() > 0))
        {
          localc.eXO.setVisibility(0);
          localc.eXP.setVisibility(0);
          localc.vBs.setVisibility(8);
          localc.vBy.setVisibility(8);
          localc.vBt.setVisibility(4);
          localc.eXP.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label4795;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          }
        }
        for (;;)
        {
          parama = new aw(parambi, false, paramInt, "", false, locala.title, locala.bYG, locala.bYH, locala.title, locala.dRg, locala.url, false, false);
          localc.vBH.setTag(parama);
          localc.vBH.setOnClickListener(h(parama1));
          i = 1;
          paramInt = 0;
          break;
          localc.eXO.setVisibility(8);
          break label4607;
          localc.vBn.setImageBitmap(parama);
        }
      case 25: 
        label1780:
        if ((locala.title != null) && (locala.title.length() > 0))
        {
          localc.eXO.setVisibility(0);
          localc.eXP.setVisibility(0);
          localc.vBs.setVisibility(8);
          localc.vBy.setVisibility(8);
          localc.vBt.setVisibility(4);
          localc.eXP.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label5050;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          }
        }
        for (;;)
        {
          label2789:
          label2798:
          parama = new aw(parambi, paramInt, "", parama1.cDP(), locala.bYG, locala.bYH, locala.title, locala.dSM, locala.designerName, locala.designerRediretctUrl, locala.url);
          label4073:
          localc.vBH.setTag(parama);
          label4835:
          paramString = localc.vBH;
          if (this.vCd == null) {
            this.vCd = new t.h(parama1);
          }
          paramString.setOnClickListener(this.vCd);
          i = 1;
          paramInt = 0;
          break;
          localc.eXO.setVisibility(8);
          break label4835;
          localc.vBn.setImageBitmap(parama);
        }
      case 26: 
      case 27: 
        label1251:
        label1405:
        label3199:
        label4607:
        if ((locala.title != null) && (locala.title.length() > 0))
        {
          localc.eXO.setVisibility(0);
          localc.eXP.setVisibility(0);
          localc.vBs.setVisibility(8);
          localc.vBy.setVisibility(8);
          localc.vBt.setVisibility(4);
          localc.eXP.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label5386;
            }
            localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          }
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
            break label5398;
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
          paramInt = 1;
        }
        label1515:
        label1525:
        label3834:
        break;
      }
      for (;;)
      {
        label1539:
        label1549:
        label1566:
        label1735:
        label1741:
        label2517:
        label2776:
        localc.vBH.setTag(parama);
        label1862:
        label2124:
        label4558:
        j = 0;
        label1962:
        label2110:
        label2378:
        i = paramInt;
        label2322:
        label2589:
        label2626:
        label5187:
        paramInt = j;
        label2851:
        label2863:
        label3505:
        label3639:
        label4795:
        break;
        label3086:
        label3633:
        label5050:
        localc.eXO.setVisibility(8);
        label3211:
        break label5090;
        label3456:
        label5386:
        localc.vBn.setImageBitmap(parama);
        break label5187;
        label5398:
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
          paramInt = 1;
          continue;
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
              break label6594;
            }
            parama = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.vtz.getContext()), false);
            if (parama == null) {
              break label5672;
            }
            localc.vBn.setImageBitmap(parama);
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.vBs.setVisibility(8);
          }
          label5672:
          localc.vBn.setImageResource(R.k.app_attach_file_icon_webpage);
          paramInt = 0;
          parama = paramString;
          i = j;
          break;
          localc.eXO.setVisibility(8);
          localc.vBs.setVisibility(0);
          if ((locala.title != null) && (locala.title.trim().length() > 0)) {
            localc.vBs.setText(j.a(localc.vBs.getContext(), locala.title, localc.vBs.getTextSize()));
          }
          for (;;)
          {
            localc.eXP.setMaxLines(3);
            localc.vBy.setVisibility(8);
            localc.vBt.setVisibility(4);
            if (bool)
            {
              localc.vBn.setVisibility(8);
              localc.vBG.setVisibility(8);
            }
            d.c.a(parama1, localc, locala, parambi, bool);
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            localc.vBs.setText(j.a(localc.vBs.getContext(), ae.getContext().getString(R.l.favorite_wenote), localc.vBs.getTextSize()));
          }
          d.c.a(parama1, localc, locala, bool);
          paramInt = 0;
          parama = paramString;
          i = j;
          break;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localc.eXO.setVisibility(0);
            if (!bk.bl(locala.dRU))
            {
              localc.eXO.setTextColor(bk.bq(locala.dRU, parama1.vtz.getContext().getResources().getColor(R.e.black)));
              label5977:
              localc.eXP.setMaxLines(2);
              localc.eXP.setVisibility(0);
              if (bk.bl(locala.dRV)) {
                break label6303;
              }
              localc.eXP.setTextColor(bk.bq(locala.dRV, parama1.vtz.getContext().getResources().getColor(R.e.grey_background_text_color)));
              label6038:
              localc.vBs.setVisibility(8);
              localc.vBt.setVisibility(4);
              localc.vBy.setVisibility(8);
              localc.vBr.setVisibility(0);
              localc.kiv.setVisibility(0);
              if (bk.bl(locala.dRQ)) {
                break label6330;
              }
              localc.kiv.setText(locala.dRQ);
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
                parama.a((String)localObject1, (ImageView)localObject2, ((com.tencent.mm.as.a.a.c.a)localObject3).OV(), new d.d.3(this, localc, parama1));
                paramInt = 0;
                parama = paramString;
                i = j;
                break;
                localc.eXO.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black));
                break label5977;
                localc.eXO.setVisibility(8);
                break label5977;
                label6303:
                localc.eXP.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.grey_background_text_color));
                break label6038;
                label6330:
                localc.kiv.setText(R.l.chatting_item_coupon_card);
                continue;
              }
              localc.vBI.getViewTreeObserver().addOnPreDrawListener(new d.d.4(this, localc, parama1, parama));
              paramInt = 0;
              parama = paramString;
              i = j;
              break;
            }
          }
          localc.vBn.setImageBitmap(BitmapFactory.decodeResource(parama1.vtz.getMMResources(), R.g.nosdcard_app));
          paramInt = 0;
          parama = paramString;
          i = j;
          break;
          if (((com.tencent.mm.ae.k)localObject3).dTA == 19)
          {
            d.c.a(parama1, localc, locala, bool);
            paramInt = 0;
            parama = paramString;
            i = j;
            break;
            label6444:
            localc.vBs.setVisibility(8);
            break label1251;
            label6457:
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
              break label1362;
            }
            localc.vBn.setImageResource(R.g.appshareimage_icon);
            break label1362;
            label6562:
            localc.vBB.setVisibility(8);
            localObject1 = parama;
            break label1405;
            label6578:
            localc.vBB.setVisibility(8);
            localObject1 = parama;
            break label1405;
          }
          label6594:
          paramInt = 0;
          parama = paramString;
          i = j;
          break;
        }
        paramInt = 0;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    int j = l.VW(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    g.a locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.h((com.tencent.mm.pluginsdk.model.app.f)localObject)) && (!com.tencent.mm.ui.chatting.k.at(parambi)))
    {
      if (locala.type != 6) {
        break label579;
      }
      com.tencent.mm.pluginsdk.model.app.b localb = l.VX(locala.bFE);
      if (((localb == null) || (!d.b.e(parambi, localb.field_fileFullPath))) && (!parambi.cvx())) {
        paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
      }
    }
    boolean bool;
    if ((locala.dQv <= 0) || ((locala.dQv > 0) && (j >= 100))) {
      switch (locala.type)
      {
      default: 
        bool = false;
      }
    }
    for (;;)
    {
      label271:
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
        if (bf.k(parambi)) {
          paramContextMenu.clear();
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
        label579:
        paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
        break;
        bool = com.tencent.mm.ai.f.Mp();
        break label271;
        bool = com.tencent.mm.ai.f.Ml();
        break label271;
        bool = com.tencent.mm.ai.f.Mo();
        break label271;
        bool = com.tencent.mm.ai.f.Mi();
        break label271;
        bool = com.tencent.mm.ai.f.Mh();
        break label271;
        bool = com.tencent.mm.ai.f.Mn();
        break label271;
        bool = com.tencent.mm.ai.f.Mj();
        break label271;
        if ((locala.dRM != 5) && (locala.dRM != 6) && (locala.dRM != 2)) {
          break label807;
        }
        if ((locala.dRM != 2) || (bf.k(parambi))) {
          paramContextMenu.clear();
        }
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
        paramContextMenu.clear();
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      label807:
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
            return false;
            localObject = parambi.field_content;
            paramMenuItem = null;
            if (localObject != null) {
              paramMenuItem = g.a.gp((String)localObject);
            }
          } while (paramMenuItem == null);
          l.ha(parambi.field_msgId);
          if (19 == paramMenuItem.type)
          {
            localObject = new nd();
            ((nd)localObject).bWJ.type = 3;
            ((nd)localObject).bWJ.bIt = parambi.field_msgId;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          }
          bd.bC(parambi.field_msgId);
          Object localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramMenuItem.appId, false);
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).ZH())) {
            a(parama, paramMenuItem, parambi, (com.tencent.mm.pluginsdk.model.app.f)localObject);
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
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return ((!paramBoolean) && (paramInt == 49)) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    com.tencent.mm.modelstat.a.a(parambi, a.a.eBA);
    Object localObject2 = parambi.field_content;
    paramView = Boolean.valueOf(false);
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = g.a.gp(bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
    localObject2 = com.tencent.mm.ae.k.gv((String)localObject2);
    if (localObject1 == null) {
      return false;
    }
    if (((com.tencent.mm.ae.k)localObject2).dTA != 0)
    {
      paramView = Boolean.valueOf(true);
      ((g.a)localObject1).type = ((com.tencent.mm.ae.k)localObject2).dTA;
    }
    localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, false);
    Object localObject3 = d(parama, parambi);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).ZH())) {
      a(parama, (g.a)localObject1, (String)localObject3, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parambi.field_msgSvrId);
    }
    Object localObject4;
    int i;
    switch (((g.a)localObject1).type)
    {
    default: 
      if ((((g.a)localObject1).url == null) || (((g.a)localObject1).url.equals(""))) {
        break label3094;
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
    case 3: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(13043, new Object[] { Integer.valueOf(2), ((g.a)localObject1).description, ((g.a)localObject1).appId });
    case 4: 
      if ((com.tencent.mm.r.a.bk(parama.vtz.getContext())) || (com.tencent.mm.r.a.bi(parama.vtz.getContext())))
      {
        y.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        return true;
      }
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
          break label544;
        }
      }
      for (i = 0;; i = ((PackageInfo)localObject4).versionCode)
      {
        a(parama, (String)localObject2, (String)localObject3, paramView, i, ((g.a)localObject1).appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
        return true;
        paramView = ((PackageInfo)localObject4).versionName;
        break;
      }
    case 6: 
      if (!this.khG)
      {
        com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
        return true;
      }
      paramView = new Intent();
      paramView.setClassName(parama.vtz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
      paramView.putExtra("app_msg_id", parambi.field_msgId);
      parama.startActivity(paramView);
      return true;
    case 7: 
      if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).ZH()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.f)localObject2))) {
        return true;
      }
      if ((((g.a)localObject1).bFE == null) || (((g.a)localObject1).bFE.length() == 0)) {
        ((com.tencent.mm.ui.chatting.b.b.a)parama.ac(com.tencent.mm.ui.chatting.b.b.a.class)).a(parambi, new d.d.5(this, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parama, (g.a)localObject1, (String)localObject3, parambi));
      }
      for (;;)
      {
        return true;
        if (!this.khG)
        {
          com.tencent.mm.ui.base.s.gM(parama.vtz.getContext());
          return true;
        }
        paramView = new Intent();
        paramView.setClassName(parama.vtz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("app_msg_id", parambi.field_msgId);
        parama.vtz.startActivityForResult(paramView, 210);
      }
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
    case 19: 
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("message_id", parambi.field_msgId);
      ((Intent)localObject2).putExtra("record_xml", ((g.a)localObject1).dRd);
      ((Intent)localObject2).putExtra("big_appmsg", paramView);
      d.a.a((Intent)localObject2, parama, parambi, this);
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject2);
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
    case 33: 
      y.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((g.a)localObject1).dSY, ((g.a)localObject1).dSX, ((g.a)localObject1).dSZ, ((g.a)localObject1).url, Integer.valueOf(((g.a)localObject1).dTf), ((g.a)localObject1).dTb });
      localObject3 = parama.getTalkerUserName();
      localObject4 = b(parama, parambi);
      paramView = new Bundle();
      if ((parama.vtz instanceof AppBrandServiceChattingUI.a))
      {
        i = 10;
        paramView.putInt("stat_scene", i);
        paramView.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
        paramView.putString("stat_chat_talker_username", (String)localObject3);
        paramView.putString("stat_send_msg_user", (String)localObject4);
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
          break label1257;
        }
        if (com.tencent.mm.model.s.hl((String)localObject3))
        {
          i = 7;
          break label1257;
        }
        i = 1;
        break label1257;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_username", ((g.a)localObject1).dSY);
        if (parama.cFE())
        {
          ((Intent)localObject2).putExtra("key_from_scene", 1);
          ((Intent)localObject2).putExtra("key_scene_note", (String)localObject3 + ":" + (String)localObject4);
        }
        for (;;)
        {
          localObject3 = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject3).appId = ((g.a)localObject1).dSZ;
          ((WxaExposedParams.a)localObject3).from = 6;
          ((WxaExposedParams.a)localObject3).fEM = ((g.a)localObject1).dTf;
          ((WxaExposedParams.a)localObject3).fEN = ((g.a)localObject1).dTc;
          ((Intent)localObject2).putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject3).aes());
          ((Intent)localObject2).putExtra("_stat_obj", paramView);
          com.tencent.mm.br.d.b(parama.vtz.getContext(), "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject2);
          i = 0;
          break;
          ((Intent)localObject2).putExtra("key_from_scene", 2);
          ((Intent)localObject2).putExtra("key_scene_note", (String)localObject3);
        }
        if ((parama.vtz instanceof AppBrandServiceChattingUI.a))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject3, 1073, (g.a)localObject1, paramView);
          i = 0;
        }
        else if (com.tencent.mm.model.s.hl((String)localObject3))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject3, 1074, (g.a)localObject1, paramView);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject3, (String)localObject4, parama.cFE(), (g.a)localObject1, paramView);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject3, (String)localObject4, parama.cFE(), (g.a)localObject1, paramView);
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
      label544:
      label1257:
      paramView = new Intent();
      paramView.putExtra("key_from_user_name", b(parama, parambi));
      paramView.putExtra("key_biz_uin", ((g.a)localObject1).dRO);
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
      com.tencent.mm.plugin.topstory.a.h.a((ckw)localObject1, parambi);
      aa.a(parama.vtz.getContext(), paramView);
      return true;
    }
    localObject2 = ((g.a)localObject1).url;
    if (parama.cFE())
    {
      paramView = "groupmessage";
      localObject2 = p.u((String)localObject2, paramView);
      paramView = ((g.a)localObject1).url;
      localObject3 = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject1).appId);
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("rawUrl", (String)localObject2);
      ((Intent)localObject4).putExtra("webpageTitle", ((g.a)localObject1).title);
      if ((((g.a)localObject1).appId != null) && (("wx751a1acca5688ba3".equals(((g.a)localObject1).appId)) || ("wxfbc915ff7c30e335".equals(((g.a)localObject1).appId)) || ("wx482a4001c37e2b74".equals(((g.a)localObject1).appId))))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("jsapi_args_appid", ((g.a)localObject1).appId);
        ((Intent)localObject4).putExtra("jsapiargs", localBundle);
      }
      if (bk.bl(paramView)) {
        break label3020;
      }
      ((Intent)localObject4).putExtra("shortUrl", paramView);
      label2533:
      if (localObject3 != null) {
        break label3037;
      }
      paramView = null;
      label2540:
      ((Intent)localObject4).putExtra("version_name", paramView);
      if (localObject3 != null) {
        break label3046;
      }
      i = 0;
      label2558:
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
      ((Intent)localObject4).putExtra("expid_str", parambi.cQO);
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
      ((Intent)localObject4).addFlags(536870912);
      if ((!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.ayw()) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayv()) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.a(parama.vtz.getContext(), (String)localObject2, (Intent)localObject4, 0))) {
        break label3074;
      }
      y.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
      return true;
      paramView = "singlemessage";
      break;
      label3020:
      ((Intent)localObject4).putExtra("shortUrl", ((g.a)localObject1).url);
      break label2533;
      label3037:
      paramView = ((PackageInfo)localObject3).versionName;
      break label2540;
      label3046:
      i = ((PackageInfo)localObject3).versionCode;
      break label2558;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
    label3074:
    com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
    return true;
    label3094:
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d
 * JD-Core Version:    0.7.0.1
 */