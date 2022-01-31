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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.a;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.j.b.a;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.p.b;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.s.i;
import com.tencent.mm.ui.chatting.s.j;
import com.tencent.mm.ui.chatting.s.l;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.Serializable;
import java.util.List;

public final class d$d
  extends c
{
  private boolean muU;
  protected s.i zSR;
  protected s.l zSS;
  protected s.j zST;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32834);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969064);
      ((View)localObject).setTag(new d.c().z((View)localObject, true));
    }
    AppMethodBeat.o(32834);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32835);
    d.c localc = (d.c)parama;
    this.zzP = parama1;
    localc.reset();
    Object localObject3 = parambi.field_content;
    Object localObject1 = (com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject1).bf(parambi);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject1).bg(parambi);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject1).bh(parambi);
    int i;
    if (this.muU)
    {
      i = parambi.field_content.indexOf(':');
      if (i != -1) {
        localObject3 = parambi.field_content.substring(i + 1);
      }
    }
    label770:
    label1033:
    label7177:
    for (;;)
    {
      j.b localb;
      Object localObject4;
      int j;
      Object localObject2;
      label466:
      label492:
      com.tencent.mm.pluginsdk.model.app.f localf;
      label554:
      boolean bool;
      if (localObject3 != null)
      {
        localb = j.b.ab((String)localObject3, parambi.field_reserved);
        localObject4 = com.tencent.mm.af.o.nd((String)localObject3);
        localObject1 = new az(parambi, parama1.dJG(), paramInt, null, '\000');
        i = 0;
        j = 0;
        localObject2 = localObject1;
        if (localb != null)
        {
          localc.gpL.setText(localb.getTitle());
          localc.gpM.setText(localb.getDescription());
          localc.zRR.setMaxLines(1);
          localc.gpL.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690322));
          localc.gpM.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690168));
          localc.zSh.setBackgroundResource(2130838217);
          localc.zSh.setPadding(0, parama1.zJz.getContext().getResources().getDimensionPixelSize(2131427792), 0, 0);
          localc.zRM.setVisibility(0);
          localc.zSf.setVisibility(0);
          localc.gpM.setVisibility(0);
          localc.zRT.setVisibility(8);
          localc.zRW.setVisibility(8);
          localc.zRV.setVisibility(8);
          localc.zSj.setVisibility(8);
          localc.zSk.setVisibility(8);
          localc.zRO.setVisibility(8);
          localc.zRP.setVisibility(8);
          localc.zSt.setVisibility(8);
          localc.zSn.setVisibility(8);
          localc.zSh.setVisibility(0);
          localc.zSy.setVisibility(8);
          localc.zSG.setVisibility(8);
          d.c.ar(localc.zSg, localc.zSN);
          localObject2 = (com.tencent.mm.af.g)localb.R(com.tencent.mm.af.g.class);
          ChattingItemFooter localChattingItemFooter = localc.zRZ;
          if (localObject2 != null) {
            break label1657;
          }
          localObject2 = null;
          if (!localChattingItemFooter.m((List)localObject2, parambi.field_talker)) {
            break label1667;
          }
          localc.zSg.setBackgroundResource(2130838276);
          localf = com.tencent.mm.pluginsdk.model.app.g.em(localb.appId, localb.bDc);
          if (localf != null) {
            b(parama1, localb, parambi);
          }
          if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
            break label1681;
          }
          localObject2 = localb.appName;
          bool = true;
          com.tencent.mm.cb.a.fromDPToPix(parama1.zJz.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool = p.a.dkR().cll();
          }
          if ((!bool) || (localb.appId == null) || (localb.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.dF((String)localObject2))) {
            break label1721;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.b(parama1.zJz.getContext(), localf, (String)localObject2);
          if (localb.type != 19) {
            break label1691;
          }
          localc.mCZ.setText(parama1.zJz.getContext().getResources().getString(2131302038, new Object[] { localObject2 }));
          label695:
          localc.mCZ.setVisibility(0);
          localc.mCZ.setCompoundDrawables(null, null, null, null);
          localc.zRQ.setVisibility(0);
          localc.zRN.setVisibility(0);
          if ((localf == null) || (!localf.vY())) {
            break label1704;
          }
          a(parama1, localc.mCZ, parambi, localb, localf.field_packageName, parambi.field_msgSvrId);
          localc.zRN.setImageResource(2130838341);
          a(parama1, localc.zRN, localb.appId);
          label795:
          if ((localb.fgt == null) || (localb.fgt.fjt == 0)) {
            break label1890;
          }
          i = 1;
          label817:
          if (i != 0) {
            localc.zRQ.setVisibility(8);
          }
          bool = false;
          localc.zRM.setVisibility(0);
          if ((localb.fgt == null) || (localb.fgt.fjq != 1)) {
            break label1896;
          }
          i = 1;
          label867:
          if ((i != 0) || (!this.kFs)) {
            break label1908;
          }
          localChattingItemFooter = null;
          localObject2 = localChattingItemFooter;
          if (localb.type != 33)
          {
            localObject2 = localChattingItemFooter;
            if (localb.type != 36)
            {
              localObject2 = localChattingItemFooter;
              if (localb.type != 44)
              {
                localObject2 = localChattingItemFooter;
                if (localb.type != 48)
                {
                  localObject2 = localChattingItemFooter;
                  if (!d.b.aum(parambi.field_imgPath)) {
                    localObject2 = com.tencent.mm.at.o.ahC().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext()), false);
                  }
                }
              }
            }
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break label1902;
          }
          localc.zRM.setImageBitmap((Bitmap)localObject2);
          label1000:
          if (localb.type == 3) {
            localc.zSh.getViewTreeObserver().addOnPreDrawListener(new d.d.1(this, localc, parama1, (Bitmap)localObject2));
          }
          if ((localb.dGR != null) && (localb.dGR.length() != 0)) {
            break label1935;
          }
          localc.zRY.setVisibility(8);
          label1062:
          localc.zRX.setOnClickListener(null);
          localc.zSb.setVisibility(0);
          localc.zRS.setVisibility(8);
          localc.zSe.setVisibility(0);
          localc.zSc.setVisibility(8);
        }
      }
      label1324:
      label1499:
      label5855:
      switch (localb.type)
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
      case 41: 
      case 42: 
      case 43: 
      case 45: 
      case 46: 
      case 47: 
      default: 
        paramInt = 1;
        parama = (c.a)localObject1;
        i = j;
      case 3: 
      case 6: 
      case 4: 
      case 5: 
      case 36: 
      case 33: 
      case 48: 
      case 44: 
      case 7: 
      case 10: 
      case 13: 
      case 20: 
      case 0: 
        for (;;)
        {
          if (paramInt != 0)
          {
            if ((localb.title == null) || (localb.title.length() <= 0)) {
              break label7164;
            }
            localc.zRR.setVisibility(0);
            localc.zRR.setMaxLines(2);
            localc.zRR.setText(localb.title);
            localc.gpL.setVisibility(8);
            if (bool)
            {
              if ((localb.type != 33) && (localb.type != 36) && (localb.type != 44)) {
                break label7177;
              }
              paramString = com.tencent.mm.at.o.ahC().tj(parambi.HE());
              localc.zRM.setImageResource(2131230829);
              com.tencent.mm.modelappbrand.a.b.acD().a(localc.zRM, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(50, 50));
            }
          }
          if (parama1.dJG()) {
            break label7291;
          }
          if (!com.tencent.mm.pluginsdk.model.app.g.j(localf)) {
            break label7275;
          }
          localc.zSa.setVisibility(0);
          c(parama1, localc.zSa, az.a(localb, parambi));
          localObject2 = parama;
          if (i == 0)
          {
            localc.zSg.setTag(localObject2);
            localc.zSg.setOnClickListener(d(parama1));
          }
          if (this.kFs)
          {
            localc.zSg.setOnLongClickListener(c(parama1));
            localc.zSg.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          }
          AppMethodBeat.o(32835);
          return;
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
          localObject4 = null;
          localb = null;
          break;
          localObject2 = ((com.tencent.mm.af.g)localObject2).fgn;
          break label466;
          localc.zSg.setBackgroundResource(2130838264);
          break label492;
          localObject2 = localf.field_appName;
          break label554;
          localc.mCZ.setText((CharSequence)localObject2);
          break label695;
          a(parama1, localc.mCZ, localb.appId);
          break label770;
          if (localb.type == 24)
          {
            localc.mCZ.setText(ah.getContext().getString(2131299680));
            localc.zRQ.setVisibility(0);
            localc.mCZ.setVisibility(0);
            localc.zRN.setVisibility(8);
            break label795;
          }
          if ((localb.type == 19) || (((com.tencent.mm.af.o)localObject4).fjG == 19))
          {
            localc.mCZ.setText(ah.getContext().getString(2131298219));
            localc.zRQ.setVisibility(0);
            localc.mCZ.setVisibility(0);
            localc.zRN.setVisibility(8);
            break label795;
          }
          if (d.a(localb, localc)) {
            break label795;
          }
          localc.zRQ.setVisibility(8);
          localc.mCZ.setVisibility(8);
          localc.zRN.setVisibility(8);
          break label795;
          i = 0;
          break label817;
          i = 0;
          break label867;
          bool = true;
          break label1000;
          localc.zRM.setImageBitmap(BitmapFactory.decodeResource(parama1.zJz.getMMResources(), 2130839820));
          bool = false;
          break label1033;
          localc.zRY.setVisibility(0);
          b(parama1, localc.zRY, az.auv(localb.dGR));
          break label1062;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpL.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690709));
            localc.gpM.setVisibility(0);
            localc.gpM.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690709));
            localc.zRR.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(0);
            if (!parambi.field_msgId.equals(parama.zRD)) {
              break label2265;
            }
            localc.zRX.setImageResource(2130839751);
            localc.gpM.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label2279;
              }
              localc.zRM.setImageResource(2131230809);
            }
          }
          for (;;)
          {
            parama = new d.f();
            parama.cpO = parambi.field_msgId;
            parama.cBW = parambi.field_content;
            parama.imgPath = parambi.field_imgPath;
            localc.zRX.setTag(parama);
            localc.zRX.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHj());
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            localc.gpL.setVisibility(8);
            break label2017;
            localc.zRX.setImageResource(2130839753);
            break label2117;
            localc.zRM.setImageBitmap(parama);
          }
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpL.setMaxLines(2);
          }
          for (;;)
          {
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRX.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            localc.gpM.setText(bo.hk(localb.fgw));
            d.c.a(localc, (String)localObject3, localb.fgw);
            d.c.a(localc, Boolean.TRUE, parambi, localb.cmN, localb.title);
            if (!bool) {
              break label7307;
            }
            if (!bo.aqj(localb.fgx)) {
              break label2476;
            }
            localc.zRM.setImageResource(2130837807);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            localc.gpL.setVisibility(8);
          }
          localc.zRM.setImageResource(com.tencent.mm.pluginsdk.model.o.alm(localb.fgx));
          paramInt = 0;
          parama = (c.a)localObject1;
          i = j;
          continue;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRX.setVisibility(0);
            localc.zRX.setImageResource(2130840655);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            if (!bool) {
              break label7307;
            }
            paramString = new com.tencent.mm.at.a.a.c.a();
            paramString.eNY = 2131230829;
            paramString.eNL = true;
            paramString.cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).eNK = true;
            localObject2 = com.tencent.mm.at.o.ahG();
            if (!bo.isNullOrNil(localb.thumburl)) {
              break label2715;
            }
          }
          for (parama = localb.fgD;; parama = localb.thumburl)
          {
            ((com.tencent.mm.at.a.a)localObject2).a(parama, localc.zRM, paramString.ahY());
            localc.zRX.setVisibility(8);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            localc.gpL.setVisibility(8);
            break label2532;
          }
          parama = (com.tencent.mm.af.e)localb.R(com.tencent.mm.af.e.class);
          if ((parama != null) && (parama.fgj == 1) && (parama.fgh == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm()))
          {
            d.c.a(parama1, localc, localb, parambi, bool);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
          }
          else
          {
            localc.gpL.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.zRR.setMaxLines(2);
              localc.zRR.setVisibility(0);
              localc.zRR.setText(localb.getTitle());
              localc.gpM.setMaxLines(3);
              if (!d.h(localb)) {
                break label3042;
              }
              localc.zRX.setVisibility(0);
              localc.zRX.setImageResource(2130840655);
              localc.zRS.setVisibility(4);
              if (bool)
              {
                localObject2 = new com.tencent.mm.at.a.a.c.a();
                ((com.tencent.mm.at.a.a.c.a)localObject2).eNY = 2131230829;
                ((com.tencent.mm.at.a.a.c.a)localObject2).eNL = true;
                ((com.tencent.mm.at.a.a.c.a)localObject2).eNP = com.tencent.mm.plugin.i.c.bIC();
                ((com.tencent.mm.at.a.a.c.a)localObject2).cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).eNK = true;
                localObject3 = com.tencent.mm.at.o.ahG();
                if (!bo.isNullOrNil(localb.thumburl)) {
                  break label3055;
                }
              }
            }
            for (parama = localb.fgD;; parama = localb.thumburl)
            {
              ((com.tencent.mm.at.a.a)localObject3).a(parama, localc.zRM, ((com.tencent.mm.at.a.a.c.a)localObject2).ahY());
              if (localb == null) {
                break label7307;
              }
              d.a(paramString, parama1, parambi, localb);
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              break;
              localc.zRR.setVisibility(8);
              break label2857;
              localc.zRX.setVisibility(8);
              break label2894;
            }
            if (localc.zSg.getLayoutParams() != null)
            {
              localc.zSg.getLayoutParams().width = -2;
              localc.zSg.requestLayout();
            }
            paramString = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(localb.fiX);
            if (paramString != null)
            {
              parama = paramString.field_nickname;
              if (paramString == null) {
                break label3315;
              }
            }
            for (paramString = paramString.field_smallHeadURL;; paramString = localb.fjj)
            {
              localc.zSh.setVisibility(8);
              localc.zSt.setVisibility(0);
              localc.zSn.setVisibility(8);
              localc.zSy.setVisibility(8);
              localc.zSw.setText(localb.title);
              localc.zSr.setText(parama);
              d.a(localc.zSs, localb);
              com.tencent.mm.at.o.ahG().a(paramString, localc.zSq, s.d.zUx);
              parama = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, true);
              localc.zSu.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSu, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              break;
              parama = localb.cGO;
              break label3128;
            }
            paramString = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(localb.fiX);
            switch (localb.fiZ)
            {
            default: 
              paramInt = 1;
              parama = (c.a)localObject1;
              i = j;
              break;
            case 2: 
            case 3: 
              if (localc.zSg.getLayoutParams() != null)
              {
                localc.zSg.getLayoutParams().width = -2;
                localc.zSg.requestLayout();
              }
              if (paramString != null)
              {
                parama = paramString.field_nickname;
                if (paramString == null) {
                  break label3644;
                }
              }
              for (paramString = paramString.field_smallHeadURL;; paramString = localb.fjj)
              {
                localc.zSh.setVisibility(8);
                localc.zSt.setVisibility(0);
                localc.zSn.setVisibility(8);
                localc.zSy.setVisibility(8);
                localc.zSw.setText(localb.title);
                localc.zSr.setText(parama);
                d.a(localc.zSs, localb);
                com.tencent.mm.at.o.ahG().a(paramString, localc.zSq, s.d.zUx);
                parama = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, true);
                localc.zSu.setImageBitmap(null);
                localc.zSu.setVisibility(4);
                localc.zSv.setVisibility(0);
                com.tencent.mm.modelappbrand.a.b.acD().a(new d.d.2(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                parama = localb.cGO;
                break label3435;
              }
            case 1: 
              if (paramString != null)
              {
                parama = paramString.field_nickname;
                if (paramString == null) {
                  break label3796;
                }
              }
              for (paramString = paramString.field_smallHeadURL;; paramString = null)
              {
                localc.zSh.setVisibility(8);
                localc.zSt.setVisibility(8);
                localc.zSn.setVisibility(0);
                localc.zSp.setText(parama);
                localc.zSy.setVisibility(8);
                if (!bo.isNullOrNil(paramString)) {
                  break label3802;
                }
                parama = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, true);
                com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSo, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.acC(), com.tencent.mm.modelappbrand.a.f.fqU);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                parama = localb.title;
                break label3665;
              }
              com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSo, paramString, com.tencent.mm.modelappbrand.a.a.acC(), com.tencent.mm.modelappbrand.a.f.fqU);
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              break;
            case 0: 
              localc.zRQ.setVisibility(0);
              localc.zRN.setVisibility(0);
              localc.zRN.setBackground(null);
              localc.zRN.setImageResource(2131230915);
              d.a(localc.mCZ, localb);
              break label1324;
              parama = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
              paramString = localb.fjj;
              localObject2 = localb.cGO;
              localObject3 = localb.title;
              localObject4 = localb.description;
              if ((parama == null) || (bo.isNullOrNil(parama.ffv)) || (bo.isNullOrNil(parama.ffx)))
              {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                break label1324;
              }
              localc.zSE.setText((CharSequence)localObject2);
              localc.zSh.setVisibility(8);
              localc.zSt.setVisibility(8);
              localc.zSn.setVisibility(8);
              localc.zSF.setVisibility(0);
              localc.zSB.setVisibility(8);
              localc.zSF.setImageDrawable(com.tencent.mm.cb.a.k(parama1.zJz.getContext(), 2131231980));
              localc.zSy.setVisibility(0);
              localc.zSz.setText((CharSequence)localObject3);
              localc.zSA.setText((CharSequence)localObject4);
              com.tencent.mm.at.o.ahF().a(paramString, new d.d.3(this, localc));
              parama = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, true);
              localc.zSC.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.acD().a(new d.d.4(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a(240, 120, i.a.fpT));
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              continue;
              if (localb.cH(false))
              {
                parama = localb.q(parama1.zJz.getContext(), false);
                if (!bo.isNullOrNil(parama))
                {
                  localc.zSE.setText(parama);
                  localc.zSh.setVisibility(8);
                  localc.zSt.setVisibility(8);
                  localc.zSn.setVisibility(8);
                  localc.zSy.setVisibility(0);
                  localc.zSF.setVisibility(8);
                  localc.zSz.setText(localb.title);
                  localc.zSA.setText(localb.description);
                  if (j.a.fgp.ordinal() != localb.fje) {
                    break label4407;
                  }
                  localc.zSD.setImageResource(2131231747);
                }
                for (;;)
                {
                  parama = com.tencent.mm.at.o.ahC().tj(parambi.field_imgPath);
                  localc.zSC.setImageBitmap(null);
                  com.tencent.mm.modelappbrand.a.b.acD().a(new d.d.6(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a(240, 120, i.a.fpT));
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  paramInt = 1;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  if (j.a.fgq.ordinal() == localb.fje) {
                    com.tencent.mm.at.o.ahF().a(localb.fjj, new d.d.5(this, localc));
                  }
                }
              }
              paramInt = 1;
              parama = (c.a)localObject1;
              i = j;
              continue;
              localc.gpL.setVisibility(8);
              if ((localb.title != null) && (localb.title.trim().length() > 0))
              {
                localc.zRR.setMaxLines(2);
                localc.zRR.setVisibility(0);
                localc.zRR.setText(localb.getTitle());
              }
              for (;;)
              {
                localc.gpM.setMaxLines(3);
                localc.zRX.setVisibility(8);
                localc.zRS.setVisibility(4);
                if (!bool) {
                  break label7307;
                }
                parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4617;
                }
                localc.zRM.setImageResource(2131230829);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                localc.zRR.setVisibility(8);
              }
              localc.zRM.setImageBitmap(parama);
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              continue;
              localc.zRR.setVisibility(0);
              if (localb.fgX == 1) {
                localc.zRR.setText(2131302924);
              }
              for (;;)
              {
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.gpL.setVisibility(0);
                  localc.gpL.setText(localb.getTitle());
                }
                localc.gpM.setMaxLines(4);
                localc.zRS.setVisibility(4);
                localc.zRX.setVisibility(8);
                if (!bool) {
                  break label7307;
                }
                parama = com.tencent.mm.at.o.ahC().b(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                if ((parama == null) || (parama.isRecycled())) {
                  break label4853;
                }
                localc.zRM.setImageBitmap(parama);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                if (localb.fgX == 2) {
                  localc.zRR.setText(2131302926);
                } else if (localb.fgX == 3) {
                  localc.zRR.setText(2131302925);
                } else {
                  localc.zRR.setText(2131302927);
                }
              }
              localc.zRM.setImageResource(2131230829);
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              continue;
              localc.gpL.setVisibility(0);
              localc.gpL.setText(localb.getTitle());
              localc.zRR.setVisibility(0);
              localc.zRR.setText(2131298256);
              localc.gpM.setMaxLines(4);
              localc.zRS.setVisibility(4);
              localc.zRX.setVisibility(8);
              if (!bool) {
                break label7307;
              }
              parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.zRM.setImageBitmap(parama);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
              }
              else
              {
                localc.zRM.setImageResource(2131230829);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.gpL.setVisibility(0);
                  localc.gpL.setText(localb.getTitle());
                  localc.zRR.setVisibility(8);
                }
                localc.gpM.setMaxLines(4);
                localc.zRS.setVisibility(4);
                localc.zRX.setVisibility(8);
                if (!bool) {
                  break label7307;
                }
                parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                if ((parama != null) && (!parama.isRecycled()))
                {
                  localc.zRM.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                }
                else
                {
                  localc.zRM.setImageResource(2131230829);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  continue;
                  if ((localb.title != null) && (localb.title.length() > 0)) {
                    localc.gpL.setVisibility(0);
                  }
                  for (;;)
                  {
                    localc.gpM.setVisibility(0);
                    localc.zRR.setVisibility(8);
                    localc.zRX.setVisibility(8);
                    localc.zRS.setVisibility(4);
                    localc.gpM.setMaxLines(2);
                    if (!bool) {
                      break label7307;
                    }
                    parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label5329;
                    }
                    localc.zRM.setImageResource(2131230829);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                    localc.gpL.setVisibility(8);
                  }
                  localc.zRM.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                }
              }
              break;
            }
          }
        }
      case 15: 
        if ((localb.title != null) && (localb.title.length() > 0))
        {
          localc.gpL.setVisibility(0);
          localc.gpM.setVisibility(0);
          localc.zRR.setVisibility(8);
          localc.zRX.setVisibility(8);
          localc.zRS.setVisibility(4);
          localc.gpM.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label5563;
            }
            localc.zRM.setImageResource(2131230829);
          }
        }
        for (;;)
        {
          parama = new az(parambi, false, paramInt, "", false, localb.title, localb.cGN, localb.cGO, localb.title, localb.fhf, localb.url, false, false);
          localc.zSg.setTag(parama);
          localc.zSg.setOnClickListener(i(parama1));
          i = 1;
          paramInt = 0;
          break;
          localc.gpL.setVisibility(8);
          break label5378;
          localc.zRM.setImageBitmap(parama);
        }
      case 25: 
        label2017:
        label2279:
        label3055:
        label3315:
        if ((localb.title != null) && (localb.title.length() > 0))
        {
          localc.gpL.setVisibility(0);
          localc.gpM.setVisibility(0);
          localc.zRR.setVisibility(8);
          localc.zRX.setVisibility(8);
          localc.zRS.setVisibility(4);
          localc.gpM.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label5815;
            }
            localc.zRM.setImageResource(2131230829);
          }
        }
        for (;;)
        {
          label2532:
          label3435:
          parama = new az(parambi, paramInt, "", parama1.dHF(), localb.cGN, localb.cGO, localb.title, localb.fiL, localb.designerName, localb.designerRediretctUrl, localb.url);
          label3042:
          label5603:
          localc.zSg.setTag(parama);
          paramString = localc.zSg;
          if (this.zSR == null) {
            this.zSR = new s.i(parama1);
          }
          paramString.setOnClickListener(this.zSR);
          i = 1;
          paramInt = 0;
          break;
          localc.gpL.setVisibility(8);
          break label5603;
          localc.zRM.setImageBitmap(parama);
        }
      case 26: 
      case 27: 
        label1387:
        label1657:
        if ((localb.title != null) && (localb.title.length() > 0))
        {
          localc.gpL.setVisibility(0);
          localc.gpM.setVisibility(0);
          localc.zRR.setVisibility(8);
          localc.zRX.setVisibility(8);
          localc.zRS.setVisibility(4);
          localc.gpM.setMaxLines(2);
          if (bool)
          {
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if ((parama != null) && (!parama.isRecycled())) {
              break label6148;
            }
            localc.zRM.setImageResource(2131230829);
          }
          parama = new az();
          parama.cEE = parambi;
          parama.zvB = false;
          parama.position = paramInt;
          parama.zYF = false;
          parama.title = parama1.dHF();
          parama.cGN = localb.cGN;
          parama.cGO = localb.cGO;
          parama.zYG = localb.title;
          if (localb.type != 26) {
            break label6160;
          }
          parama.tid = localb.tid;
          parama.fiM = localb.fiM;
          parama.desc = localb.desc;
          parama.iconUrl = localb.iconUrl;
          parama.secondUrl = localb.secondUrl;
          parama.pageType = localb.pageType;
          paramString = localc.zSg;
          if (this.zSS == null) {
            this.zSS = new s.l(parama1);
          }
          paramString.setOnClickListener(this.zSS);
          paramInt = 1;
        }
        label1890:
        label1896:
        label1902:
        label1908:
        label4853:
        break;
      }
      label4617:
      label7307:
      for (;;)
      {
        label1681:
        label1691:
        label1704:
        label1721:
        label2117:
        label2265:
        label3802:
        localc.zSg.setTag(parama);
        label1935:
        label2476:
        label2894:
        label3665:
        label3796:
        j = 0;
        label2715:
        label2857:
        label3128:
        label3644:
        label5329:
        i = paramInt;
        label4407:
        label5563:
        label5949:
        paramInt = j;
        label5815:
        break;
        localc.gpL.setVisibility(8);
        break label5855;
        localc.zRM.setImageBitmap(parama);
        break label5949;
        label6160:
        if (localb.type == 27)
        {
          parama.tid = localb.tid;
          parama.fiM = localb.fiM;
          parama.desc = localb.desc;
          parama.iconUrl = localb.iconUrl;
          parama.secondUrl = localb.secondUrl;
          parama.pageType = localb.pageType;
          paramString = localc.zSg;
          if (this.zST == null) {
            this.zST = new s.j(parama1);
          }
          paramString.setOnClickListener(this.zST);
          paramInt = 1;
          continue;
          localc.gpL.setVisibility(0);
          localc.gpL.setText(localb.description);
          localc.gpM.setText(localb.fhK);
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.zRR.setVisibility(0);
            localc.zRR.setText(localb.title);
          }
          for (;;)
          {
            localc.gpM.setMaxLines(4);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(8);
            if (!bool) {
              break label7307;
            }
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if (parama == null) {
              break label6431;
            }
            localc.zRM.setImageBitmap(parama);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            localc.zRR.setVisibility(8);
          }
          label6431:
          localc.zRM.setImageResource(2131230829);
          paramInt = 0;
          parama = (c.a)localObject1;
          i = j;
          break;
          localc.gpL.setVisibility(8);
          localc.zRR.setVisibility(0);
          if ((localb.title != null) && (localb.title.trim().length() > 0)) {
            localc.zRR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localc.zRR.getContext(), localb.title, localc.zRR.getTextSize()));
          }
          for (;;)
          {
            localc.gpM.setMaxLines(3);
            localc.zRX.setVisibility(8);
            localc.zRS.setVisibility(4);
            if (bool)
            {
              localc.zRM.setVisibility(8);
              localc.zSf.setVisibility(8);
            }
            d.c.b(parama1, localc, localb, parambi, bool);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            localc.zRR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localc.zRR.getContext(), ah.getContext().getString(2131299857), localc.zRR.getTextSize()));
          }
          d.c.a(parama1, localc, localb, bool);
          paramInt = 0;
          parama = (c.a)localObject1;
          i = j;
          break;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            if (!bo.isNullOrNil(localb.fhT))
            {
              localc.gpL.setTextColor(bo.bS(localb.fhT, parama1.getContext().getResources().getColor(2131689763)));
              label6733:
              localc.gpM.setMaxLines(2);
              localc.gpM.setVisibility(0);
              if (bo.isNullOrNil(localb.fhU)) {
                break label7029;
              }
              localc.gpM.setTextColor(bo.bS(localb.fhU, parama1.getContext().getResources().getColor(2131690143)));
              localc.zRR.setVisibility(8);
              localc.zRS.setVisibility(4);
              localc.zRX.setVisibility(8);
              localc.zRQ.setVisibility(0);
              localc.mCZ.setVisibility(0);
              if (bo.isNullOrNil(localb.fhP)) {
                break label7053;
              }
              localc.mCZ.setText(localb.fhP);
            }
          }
          for (;;)
          {
            if (this.kFs)
            {
              parama = com.tencent.mm.at.o.ahC().e(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
              if ((parama != null) && (!parama.isRecycled()))
              {
                paramString = com.tencent.mm.sdk.platformtools.d.a(parama, false, parama.getWidth() / 2);
                localc.zRM.setImageBitmap(paramString);
              }
              if (!bo.isNullOrNil(localb.fhS))
              {
                com.tencent.mm.at.o.ahG().a(localb.fhS, new ImageView(parama1.getContext()), new com.tencent.mm.at.a.a.c.a().ahU().ahY(), new d.d.7(this, localc, parama1));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                localc.gpL.setTextColor(parama1.getContext().getResources().getColor(2131689763));
                break label6733;
                localc.gpL.setVisibility(8);
                break label6733;
                label7029:
                localc.gpM.setTextColor(parama1.getContext().getResources().getColor(2131690143));
                break label6791;
                localc.mCZ.setText(2131298217);
                continue;
              }
              localc.zSh.getViewTreeObserver().addOnPreDrawListener(new d.d.8(this, localc, parama1, parama));
              paramInt = 0;
              parama = (c.a)localObject1;
              i = j;
              break;
            }
          }
          localc.zRM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2130839820));
          paramInt = 0;
          parama = (c.a)localObject1;
          i = j;
          break;
          if (((com.tencent.mm.af.o)localObject4).fjG == 19)
          {
            d.c.a(parama1, localc, localb, bool);
            paramInt = 0;
            parama = (c.a)localObject1;
            i = j;
            break;
            label7164:
            localc.zRR.setVisibility(8);
            break label1387;
            localObject1 = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if (localObject1 != null)
            {
              paramString = (String)localObject1;
              if (!((Bitmap)localObject1).isRecycled()) {}
            }
            else
            {
              paramString = com.tencent.mm.at.o.ahC().e(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
            }
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              localc.zRM.setImageBitmap(paramString);
              break label1499;
            }
            localc.zRM.setImageResource(2130837807);
            break label1499;
            label7275:
            localc.zSa.setVisibility(8);
            localObject2 = parama;
            break label1542;
            label7291:
            localc.zSa.setVisibility(8);
            localObject2 = parama;
            break label1542;
          }
          paramInt = 0;
          parama = (c.a)localObject1;
          i = j;
          break;
        }
        label7053:
        paramInt = 0;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32836);
    int i = ((az)paramView.getTag()).position;
    int j = l.alu(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.k((com.tencent.mm.pluginsdk.model.app.f)localObject)) && (!com.tencent.mm.ui.chatting.j.aB(parambi)))
    {
      if (localb.type != 6) {
        break label589;
      }
      com.tencent.mm.pluginsdk.model.app.b localb1 = l.alv(localb.cmN);
      if (((localb1 == null) || (!d.b.e(parambi, localb1.field_fileFullPath))) && (!parambi.dyc())) {
        paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
      }
    }
    boolean bool1;
    if ((localb.fgw <= 0) || ((localb.fgw > 0) && (j >= 100))) {
      switch (localb.type)
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      label275:
      if ((bool1) && (!this.zzP.dJH())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131298228));
      }
      if ((com.tencent.mm.bq.d.ahR("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject).vY()))) {
        switch (localb.type)
        {
        }
      }
      for (;;)
      {
        localObject = new dr();
        ((dr)localObject).crt.cpO = parambi.field_msgId;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((dr)localObject).cru.cqS) || (d.b.a(this.zzP.zJz.getContext(), localb))) {
          paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
        }
        if (bh.o(parambi)) {
          paramContextMenu.clear();
        }
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        }
        AppMethodBeat.o(32836);
        return true;
        label589:
        paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
        break;
        bool1 = com.tencent.mm.aj.f.aeY();
        break label275;
        bool1 = com.tencent.mm.aj.f.aeS();
        break label275;
        boolean bool2 = com.tencent.mm.aj.f.aeW();
        bool1 = bool2;
        if (bo.aqj(localb.fgx)) {
          break label275;
        }
        paramContextMenu.add(i, 150, 0, this.zzP.zJz.getMMResources().getString(2131298239));
        bool1 = bool2;
        break label275;
        bool1 = com.tencent.mm.aj.f.aeP();
        break label275;
        bool1 = com.tencent.mm.aj.f.aeO();
        break label275;
        bool1 = com.tencent.mm.aj.f.aeU();
        break label275;
        bool1 = com.tencent.mm.aj.f.aeQ();
        break label275;
        if ((localb.fhL != 5) && (localb.fhL != 6) && (localb.fhL != 2)) {
          break label877;
        }
        if ((localb.fhL != 2) || (bh.o(parambi))) {
          paramContextMenu.clear();
        }
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        AppMethodBeat.o(32836);
        return false;
        paramContextMenu.clear();
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        AppMethodBeat.o(32836);
        return false;
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
      }
      label877:
      bool1 = false;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32837);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(32837);
      return false;
    case 100: 
      AppMethodBeat.o(32837);
      return false;
    case 111: 
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(32837);
      return false;
    }
    paramMenuItem = parambi.field_content;
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(32837);
      return false;
    }
    paramMenuItem = j.b.mY(paramMenuItem);
    if (paramMenuItem != null) {
      switch (paramMenuItem.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32837);
      return false;
      al.a(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
      continue;
      al.d(parambi, parama.zJz.getContext());
      continue;
      al.b(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
      continue;
      al.a(parambi, parama.zJz.getContext(), b(parama, parambi), parama.dJG());
      continue;
      al.n(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
      continue;
      al.c(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
      continue;
      al.c(parambi, parama.zJz.getContext());
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32838);
    com.tencent.mm.modelstat.a.a(parambi, a.a.fRr);
    Object localObject2 = parambi.field_content;
    Object localObject1 = Boolean.FALSE;
    if (localObject2 == null)
    {
      AppMethodBeat.o(32838);
      return false;
    }
    j.b localb = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    localObject2 = com.tencent.mm.af.o.nd((String)localObject2);
    if (localb == null)
    {
      AppMethodBeat.o(32838);
      return false;
    }
    if (((com.tencent.mm.af.o)localObject2).fjG != 0)
    {
      localObject1 = Boolean.TRUE;
      localb.type = ((com.tencent.mm.af.o)localObject2).fjG;
    }
    localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false);
    Object localObject3 = d(parama, parambi);
    if (localObject2 != null) {
      a(parama, localb, (String)localObject3, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parambi.field_msgSvrId, parama.getTalkerUserName());
    }
    int j;
    label604:
    Object localObject4;
    label1523:
    Object localObject5;
    switch (localb.type)
    {
    default: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 10: 
    case 20: 
    case 13: 
    case 19: 
    case 16: 
    case 33: 
    case 44: 
    case 48: 
      for (;;)
      {
        j = 1;
        for (;;)
        {
          if ((j == 0) || (localb.url == null) || (localb.url.equals(""))) {
            break label3971;
          }
          if (bo.isNullOrNil(localb.canvasPageXml)) {
            break label2757;
          }
          paramView = new Intent();
          paramView.putExtra("sns_landig_pages_from_source", 5);
          paramView.putExtra("msg_id", parambi.field_msgId);
          paramView.putExtra("sns_landing_pages_xml", localb.canvasPageXml);
          paramView.putExtra("sns_landing_pages_share_thumb_url", parambi.field_imgPath);
          paramView.addFlags(268435456);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          com.tencent.mm.plugin.report.service.h.qsU.e(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
          if ((com.tencent.mm.r.a.bO(parama.zJz.getContext())) || (com.tencent.mm.r.a.bM(parama.zJz.getContext())))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
            AppMethodBeat.o(32838);
            return true;
          }
          if (a(parama, localb, parambi))
          {
            AppMethodBeat.o(32838);
            return true;
          }
          localObject1 = com.tencent.mm.pluginsdk.model.app.p.H(localb.url, "message");
          localObject2 = com.tencent.mm.pluginsdk.model.app.p.H(localb.fgv, "message");
          localObject3 = getPackageInfo(parama.zJz.getContext(), localb.appId);
          if (localObject3 == null)
          {
            paramView = null;
            if (localObject3 != null) {
              break label604;
            }
          }
          for (i = 0;; i = ((PackageInfo)localObject3).versionCode)
          {
            a(parama, (String)localObject1, (String)localObject2, paramView, i, localb.appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
            AppMethodBeat.o(32838);
            return true;
            paramView = ((PackageInfo)localObject3).versionName;
            break;
          }
          if (!this.kFs)
          {
            com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
            AppMethodBeat.o(32838);
            return true;
          }
          paramView = new Intent();
          paramView.setClassName(parama.zJz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("app_msg_id", parambi.field_msgId);
          parama.startActivity(paramView);
          AppMethodBeat.o(32838);
          return true;
          if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).vY()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.f)localObject2)))
          {
            AppMethodBeat.o(32838);
            return true;
          }
          if ((localb.cmN == null) || (localb.cmN.length() == 0)) {
            ((com.tencent.mm.ui.chatting.c.b.b)parama.ay(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambi, new d.d.9(this, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parama, localb, (String)localObject3, parambi));
          }
          for (;;)
          {
            AppMethodBeat.o(32838);
            return true;
            if (!this.kFs)
            {
              com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
              AppMethodBeat.o(32838);
              return true;
            }
            paramView = new Intent();
            paramView.setClassName(parama.zJz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramView.putExtra("app_msg_id", parambi.field_msgId);
            parama.zJz.startActivityForResult(paramView, 210);
          }
          if (bo.isNullOrNil(localb.fgY))
          {
            AppMethodBeat.o(32838);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_Product_xml", localb.fgY);
          paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
          if (parambi.field_imgPath == null) {
            paramView.putExtra("key_ProductUI_chatting_msgId", parambi.field_msgId);
          }
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "scanner", ".ui.ProductUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          if (bo.isNullOrNil(localb.fhb))
          {
            AppMethodBeat.o(32838);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_TV_xml", localb.fhb);
          paramView.putExtra("key_TV_getProductInfoScene", 1);
          if (parambi.field_imgPath == null) {
            paramView.putExtra("key_TVInfoUI_chatting_msgId", parambi.field_msgId);
          }
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "shake", ".ui.TVInfoUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          if (bo.isNullOrNil(localb.fhe))
          {
            AppMethodBeat.o(32838);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_product_info", localb.fhe);
          paramView.putExtra("key_product_scene", 1);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "product", ".ui.MallProductUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          paramView = new Intent();
          paramView.putExtra("message_id", parambi.field_msgId);
          paramView.putExtra("record_xml", localb.fhc);
          paramView.putExtra("big_appmsg", (Serializable)localObject1);
          i = u.ah(b(parama, parambi), parama.getTalkerUserName());
          paramView.putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
          paramView.putExtra("preUsername", b(parama, parambi));
          paramView.putExtra("preChatName", parama.getTalkerUserName());
          paramView.putExtra("preChatTYPE", i);
          d.a.a(paramView, parama, parambi, this);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          if (bo.isNullOrNil(localb.cxK))
          {
            AppMethodBeat.o(32838);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_card_app_msg", localb.cxK);
          paramView.putExtra("key_from_scene", localb.fhL);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "card", ".ui.CardDetailUI", paramView);
          AppMethodBeat.o(32838);
          return true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { localb.fiX, localb.fiW, localb.fiY, localb.url, Integer.valueOf(localb.fjh), localb.fja });
          if ((44 == localb.type) && ((!localb.cH(false)) || (bo.isNullOrNil(localb.q(parama.zJz.getContext(), false)))))
          {
            j = 1;
          }
          else
          {
            localObject3 = parama.getTalkerUserName();
            localObject4 = b(parama, parambi);
            localObject1 = new Bundle();
            if ((parama.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
            {
              i = 10;
              ((Bundle)localObject1).putInt("stat_scene", i);
              ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
              ((Bundle)localObject1).putString("stat_chat_talker_username", (String)localObject3);
              ((Bundle)localObject1).putString("stat_send_msg_user", (String)localObject4);
              switch (localb.fiZ)
              {
              default: 
                i = 1;
              }
            }
            for (;;)
            {
              j = i;
              if (i != 0) {
                break;
              }
              AppMethodBeat.o(32838);
              return true;
              if (parama.dJG())
              {
                i = 2;
                break label1523;
              }
              if (com.tencent.mm.model.t.nU((String)localObject3))
              {
                i = 7;
                break label1523;
              }
              i = 1;
              break label1523;
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("key_username", localb.fiX);
              if (parama.dJG())
              {
                ((Intent)localObject2).putExtra("key_from_scene", 1);
                ((Intent)localObject2).putExtra("key_scene_note", (String)localObject3 + ":" + (String)localObject4);
              }
              for (;;)
              {
                localObject3 = new WxaExposedParams.a();
                ((WxaExposedParams.a)localObject3).appId = localb.fiY;
                ((WxaExposedParams.a)localObject3).from = 6;
                ((WxaExposedParams.a)localObject3).gXe = localb.fjh;
                ((WxaExposedParams.a)localObject3).gXf = localb.fjb;
                ((Intent)localObject2).putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject3).ayJ());
                ((Intent)localObject2).putExtra("_stat_obj", (Bundle)localObject1);
                com.tencent.mm.bq.d.b(parama.zJz.getContext(), "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject2);
                i = 0;
                break;
                ((Intent)localObject2).putExtra("key_from_scene", 2);
                ((Intent)localObject2).putExtra("key_scene_note", (String)localObject3);
              }
              if ((parama.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject3, 1073, localb, (Bundle)localObject1);
                i = 0;
              }
              else if (com.tencent.mm.model.t.nU((String)localObject3))
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject3, 1074, localb, (Bundle)localObject1);
                i = 0;
              }
              else
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject3, (String)localObject4, parama.dJG(), localb, (Bundle)localObject1);
                i = 0;
                continue;
                com.tencent.mm.modelappbrand.a.b((String)localObject3, (String)localObject4, parama.dJG(), localb, (Bundle)localObject1);
                i = 0;
              }
            }
            Object localObject6 = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
            if ((localObject6 == null) || (bo.isNullOrNil(((com.tencent.mm.af.a)localObject6).ffv)) || (bo.isNullOrNil(((com.tencent.mm.af.a)localObject6).ffx))) {
              break;
            }
            localObject1 = ((com.tencent.mm.af.a)localObject6).ffv;
            localObject2 = ((com.tencent.mm.af.a)localObject6).ffu;
            localObject3 = localb.description;
            localObject4 = ((com.tencent.mm.af.a)localObject6).ffw;
            localObject5 = localb.fiY;
            localObject6 = ((com.tencent.mm.af.a)localObject6).ffx;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6 });
            Object localObject7 = com.tencent.mm.plugin.report.service.h.qsU;
            if (com.tencent.mm.model.t.lA(parama.getTalkerUserName())) {}
            for (i = 2;; i = 1)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject7).e(17608, new Object[] { Integer.valueOf(i), localObject5, Integer.valueOf(1), Integer.valueOf(1) });
              if (bo.isNullOrNil((String)localObject1)) {
                break label2257;
              }
              localObject7 = new Bundle();
              ((Bundle)localObject7).putString("key_chatting_wording", (String)localObject3);
              ((Bundle)localObject7).putString("key_chatting_text", (String)localObject4);
              ((Bundle)localObject7).putString("key_chatting_appid", (String)localObject5);
              ((Bundle)localObject7).putLong("key_msg_id", parambi.field_msgId);
              ((Bundle)localObject7).putString("key_talker_username", parama.getTalkerUserName());
              ((Bundle)localObject7).putString("key_sender_username", b(parama, parambi));
              d.a(parama, (String)localObject1, (String)localObject2, (String)localObject6, (Bundle)localObject7);
              j = 0;
              break;
            }
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
            j = 0;
          }
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
      }
    case 36: 
      if ((bo.isNullOrNil(localb.fiY)) && (bo.isNullOrNil(localb.fiX)))
      {
        parambi = localb.url;
        if (parama.dJG()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramView = com.tencent.mm.pluginsdk.model.app.p.H(parambi, paramView);
          parambi = new Intent();
          parambi.putExtra("rawUrl", paramView);
          parambi.putExtra("webpageTitle", localb.title);
          parambi.putExtra("shortUrl", localb.url);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
          AppMethodBeat.o(32838);
          return true;
        }
      }
      paramView = parama.getTalkerUserName();
      localObject1 = b(parama, parambi);
      localObject2 = new Bundle();
      if (parama.dJG()) {
        i = 2;
      }
      for (;;)
      {
        ((Bundle)localObject2).putInt("stat_scene", i);
        ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
        ((Bundle)localObject2).putString("stat_chat_talker_username", paramView);
        ((Bundle)localObject2).putString("stat_send_msg_user", (String)localObject1);
        ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(parama.zJz.getContext(), parama.getTalkerUserName(), b(parama, parambi), parama.dJG(), localb);
        AppMethodBeat.o(32838);
        return true;
        if (com.tencent.mm.model.t.nU(paramView)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    case 24: 
      label2257:
      paramView = new me();
      paramView.cCl.context = parama.zJz.getContext();
      paramView.cCl.cpO = parambi.field_msgId;
      paramView.cCl.cBz = parama.dJG();
      paramView.cCl.cCm = localb.fhc;
      paramView.cCl.scene = 6;
      com.tencent.mm.sdk.b.a.ymk.l(paramView);
      AppMethodBeat.o(32838);
      return true;
    }
    paramView = new Intent();
    paramView.putExtra("key_from_user_name", b(parama, parambi));
    paramView.putExtra("key_biz_uin", localb.fhN);
    paramView.putExtra("key_order_id", localb.fhO);
    if ((parambi.field_talker != null) && (!parambi.field_talker.equals("")) && (com.tencent.mm.model.t.lA(parambi.field_talker))) {
      paramView.putExtra("key_chatroom_name", parambi.field_talker);
    }
    com.tencent.mm.bq.d.b(parama.zJz.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
    AppMethodBeat.o(32838);
    return true;
    label2757:
    localObject1 = (com.tencent.mm.plugin.websearch.api.ab)localb.R(com.tencent.mm.plugin.websearch.api.ab.class);
    if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJi)))
    {
      paramView = new cyl();
      paramView.uJi = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJi;
      paramView.uJj = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJj;
      paramView.uJk = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJk;
      paramView.uJl = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJl;
      paramView.uJm = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJm;
      paramView.uJq = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJq;
      paramView.lHq = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).lHq;
      paramView.lHr = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).lHr;
      paramView.rrm = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).rrm;
      paramView.uJn = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJn;
      paramView.uJo = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJo;
      paramView.uJp = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJp;
      paramView.source = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).source;
      paramView.puE = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).puE;
      paramView.uJr = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJr;
      paramView.uJt = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJt;
      paramView.uJu = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJu;
      paramView.uJv = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJv;
      paramView.uJs = ((com.tencent.mm.plugin.websearch.api.ab)localObject1).uJs;
      localObject1 = com.tencent.mm.plugin.topstory.a.g.a(paramView, 32, parama.zJz.getContext().getString(2131300237));
      com.tencent.mm.plugin.topstory.a.h.a(paramView, parambi);
      aa.a(parama.zJz.getContext(), (ckw)localObject1);
      AppMethodBeat.o(32838);
      return true;
    }
    localObject2 = localb.url;
    if (parama.dJG())
    {
      localObject1 = "groupmessage";
      localObject2 = com.tencent.mm.pluginsdk.model.app.p.H((String)localObject2, (String)localObject1);
      localObject1 = localb.url;
      localObject4 = getPackageInfo(parama.zJz.getContext(), localb.appId);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("rawUrl", (String)localObject2);
      ((Intent)localObject3).putExtra("webpageTitle", localb.title);
      if ((localb.appId != null) && (("wx751a1acca5688ba3".equals(localb.appId)) || ("wxfbc915ff7c30e335".equals(localb.appId)) || ("wx482a4001c37e2b74".equals(localb.appId))))
      {
        localObject5 = new Bundle();
        ((Bundle)localObject5).putString("jsapi_args_appid", localb.appId);
        ((Intent)localObject3).putExtra("jsapiargs", (Bundle)localObject5);
      }
      if (bo.isNullOrNil((String)localObject1)) {
        break label3815;
      }
      ((Intent)localObject3).putExtra("shortUrl", (String)localObject1);
      label3199:
      if (localObject4 != null) {
        break label3832;
      }
      localObject1 = null;
      label3207:
      ((Intent)localObject3).putExtra("version_name", (String)localObject1);
      if (localObject4 != null) {
        break label3842;
      }
      i = 0;
      label3226:
      ((Intent)localObject3).putExtra("version_code", i);
      if (!bo.isNullOrNil(localb.cGN))
      {
        ((Intent)localObject3).putExtra("srcUsername", localb.cGN);
        ((Intent)localObject3).putExtra("srcDisplayname", localb.cGO);
      }
      ((Intent)localObject3).putExtra("msg_id", parambi.field_msgId);
      ((Intent)localObject3).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject3).putExtra("KAppId", localb.appId);
      ((Intent)localObject3).putExtra("geta8key_username", parama.getTalkerUserName());
      ((Intent)localObject3).putExtra("pre_username", b(parama, parambi));
      ((Intent)localObject3).putExtra("from_scence", 2);
      ((Intent)localObject3).putExtra("expid_str", parambi.dHa);
      i = u.ah(b(parama, parambi), parama.getTalkerUserName());
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
        label3531:
        ((Intent)localObject3).putExtra("share_report_pre_msg_url", localb.url);
        ((Intent)localObject3).putExtra("share_report_pre_msg_title", localb.title);
        ((Intent)localObject3).putExtra("share_report_pre_msg_desc", localb.description);
        ((Intent)localObject3).putExtra("share_report_pre_msg_icon_url", localb.thumburl);
        ((Intent)localObject3).putExtra("share_report_pre_msg_appid", localb.appId);
        ((Intent)localObject3).putExtra("share_report_from_scene", i);
        if (i == 5) {
          ((Intent)localObject3).putExtra("share_report_biz_username", parama.getTalkerUserName());
        }
        localObject1 = (com.tencent.mm.af.e)localb.R(com.tencent.mm.af.e.class);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (int i = ((com.tencent.mm.af.e)localObject1).fgh;; i = -1)
    {
      ((Intent)localObject3).putExtra(e.l.yVt, i);
      ((Intent)localObject3).addFlags(536870912);
      j = parama.zJz.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((localObject1 == null) || (i != 5) || (((com.tencent.mm.af.e)localObject1).fgj != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm())) {
        break label3876;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("biz_video_scene", 1);
      ((Bundle)localObject1).putInt("biz_video_subscene", j);
      ((Bundle)localObject1).putInt("geta8key_scene", 1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.a(parama.zJz.getContext(), parambi.field_msgId, parambi.field_msgSvrId, 0, paramView.findViewById(2131822508), (Bundle)localObject1);
      AppMethodBeat.o(32838);
      return true;
      localObject1 = "singlemessage";
      break;
      label3815:
      ((Intent)localObject3).putExtra("shortUrl", localb.url);
      break label3199;
      label3832:
      localObject1 = ((PackageInfo)localObject4).versionName;
      break label3207;
      label3842:
      i = ((PackageInfo)localObject4).versionCode;
      break label3226;
      i = 2;
      break label3531;
      i = 3;
      break label3531;
      i = 5;
      break label3531;
    }
    label3876:
    if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.zJz.getContext(), (String)localObject2, i, false, 1, j, (Intent)localObject3)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
      AppMethodBeat.o(32838);
      return true;
    }
    com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
    AppMethodBeat.o(32838);
    return true;
    label3971:
    AppMethodBeat.o(32838);
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d
 * JD-Core Version:    0.7.0.1
 */