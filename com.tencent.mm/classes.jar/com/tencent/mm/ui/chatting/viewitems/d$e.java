package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.a;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.p.b;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.i;
import com.tencent.mm.ui.chatting.s.j;
import com.tencent.mm.ui.chatting.s.l;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.tools.ShowImageUI;

public final class d$e
  extends c
  implements s.n
{
  protected s.i zSR;
  protected s.l zSS;
  protected s.j zST;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private static void a(d.c paramc, com.tencent.mm.ui.chatting.c.b.h paramh, bi parambi)
  {
    AppMethodBeat.i(32854);
    if ((parambi.field_status == 2) && (a(paramh, parambi.field_msgId)))
    {
      if (paramc.zSm != null)
      {
        paramc.zSm.setVisibility(0);
        AppMethodBeat.o(32854);
      }
    }
    else if (paramc.zSm != null) {
      paramc.zSm.setVisibility(8);
    }
    AppMethodBeat.o(32854);
  }
  
  private s.i j(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(153936);
    if (this.zSR == null) {
      this.zSR = new s.i(parama);
    }
    parama = this.zSR;
    AppMethodBeat.o(153936);
    return parama;
  }
  
  private s.l k(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(153937);
    if (this.zSS == null) {
      this.zSS = new s.l(parama);
    }
    parama = this.zSS;
    AppMethodBeat.o(153937);
    return parama;
  }
  
  private s.j l(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(153938);
    if (this.zST == null) {
      this.zST = new s.j(parama);
    }
    parama = this.zST;
    AppMethodBeat.o(153938);
    return parama;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32852);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969103);
      ((View)localObject).setTag(new d.c().z((View)localObject, false));
    }
    AppMethodBeat.o(32852);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32858);
    com.tencent.mm.ui.base.h.d(parama.zJz.getContext(), parama.zJz.getMMResources().getString(2131298294), "", parama.zJz.getMMResources().getString(2131297060), parama.zJz.getMMResources().getString(2131296888), new d.e.2(this, parambi, parama), new d.e.3(this));
    AppMethodBeat.o(32858);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32853);
    final d.c localc = (d.c)parama;
    this.zzP = parama1;
    ((com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class)).bh(parambi);
    localc.reset();
    String str = parambi.getContent();
    ((com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class)).bf(parambi);
    j.b localb;
    Object localObject3;
    if (str != null)
    {
      localb = j.b.ab(str, parambi.HF());
      localObject3 = com.tencent.mm.af.o.nd(str);
    }
    for (;;)
    {
      Object localObject1 = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      int j = 0;
      int k = 0;
      Object localObject2 = localObject1;
      Object localObject4;
      boolean bool;
      label568:
      label837:
      int i;
      if (localb != null)
      {
        localObject4 = com.tencent.mm.pluginsdk.model.app.g.em(localb.appId, localb.bDc);
        localc.gpL.setText(localb.title);
        localc.gpM.setText(localb.description);
        localc.zRR.setMaxLines(1);
        localc.gpL.setTextColor(parama1.getContext().getResources().getColor(2131690322));
        localc.gpM.setTextColor(parama1.getContext().getResources().getColor(2131690168));
        localc.zSh.setBackgroundResource(2130838250);
        localc.zSh.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131427792), 0, 0);
        localc.zRM.setVisibility(0);
        localc.zSf.setVisibility(0);
        localc.gpM.setVisibility(0);
        localc.zSj.setVisibility(8);
        localc.zSk.setVisibility(8);
        localc.zRW.setVisibility(8);
        localc.zRV.setVisibility(8);
        localc.zRS.setVisibility(8);
        localc.zRP.setVisibility(8);
        localc.zRO.setVisibility(8);
        localc.zSt.setVisibility(8);
        localc.zSn.setVisibility(8);
        localc.zSh.setVisibility(0);
        localc.zSy.setVisibility(8);
        localc.zSG.setVisibility(8);
        d.c.ar(localc.zSg, localc.zSN);
        if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject4).field_appName.trim().length() > 0)) {
          break label1336;
        }
        localObject2 = localb.appName;
        bool = true;
        com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 12);
        if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
          bool = p.a.dkR().cll();
        }
        if ((!bool) || (localb.appId == null) || (localb.appId.length() <= 0) || (!dF((String)localObject2))) {
          break label1376;
        }
        localObject2 = com.tencent.mm.pluginsdk.model.app.g.b(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.f)localObject4, (String)localObject2);
        if (localb.type != 19) {
          break label1346;
        }
        localc.mCZ.setText(parama1.getContext().getResources().getString(2131302038, new Object[] { localObject2 }));
        localc.zRQ.setVisibility(0);
        localc.mCZ.setVisibility(0);
        localc.mCZ.setCompoundDrawables(null, null, null, null);
        localc.zRN.setVisibility(0);
        if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject4).vY())) {
          break label1359;
        }
        a(parama1, localc.mCZ, parambi, localb, ((com.tencent.mm.pluginsdk.model.app.f)localObject4).field_packageName, parambi.HA());
        label643:
        localc.zRN.setImageResource(2130838341);
        a(parama1, localc.zRN, localb.appId);
        label668:
        bool = false;
        localc.zRM.setVisibility(0);
        if (!this.kFs) {
          break label1551;
        }
        localObject4 = null;
        localObject2 = localObject4;
        if (localb.type != 33)
        {
          localObject2 = localObject4;
          if (localb.type != 36)
          {
            localObject2 = localObject4;
            if (localb.type != 44)
            {
              localObject2 = localObject4;
              if (localb.type != 48)
              {
                localObject2 = localObject4;
                if (!d.b.aum(parambi.HE())) {
                  localObject2 = com.tencent.mm.at.o.ahC().e(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                }
              }
            }
          }
        }
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label1545;
        }
        localc.zRM.setImageBitmap((Bitmap)localObject2);
        label804:
        if (localb.type == 3) {
          localc.zSh.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            private boolean zSU = false;
            
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(32839);
              if (this.zSU)
              {
                localc.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
                AppMethodBeat.o(32839);
                return true;
              }
              localc.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
              this.zSU = true;
              int i = com.tencent.mm.cb.a.fromDPToPix(parama1.zJz.getContext(), 24);
              Bitmap localBitmap = this.val$bitmap;
              Object localObject;
              if (localBitmap != null)
              {
                localObject = localBitmap;
                if (!localBitmap.isRecycled()) {}
              }
              else
              {
                localObject = com.tencent.mm.sdk.platformtools.d.au(parama1.zJz.getContext().getResources().getColor(2131689870), i, i);
              }
              int j = ((Bitmap)localObject).getHeight();
              if (i > j) {
                i = j;
              }
              for (;;)
              {
                localObject = com.tencent.mm.sdk.platformtools.d.g(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                j = localc.zSh.getHeight();
                int k = localc.zSh.getWidth();
                i = j;
                if (j == 0) {
                  i = com.tencent.mm.cb.a.ao(parama1.zJz.getContext(), 2131428225);
                }
                j = k;
                if (k == 0) {
                  j = com.tencent.mm.cb.a.ao(parama1.zJz.getContext(), 2131428226);
                }
                localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, 2130838250, j, i));
                localc.zSh.setBackgroundDrawable((Drawable)localObject);
                AppMethodBeat.o(32839);
                return true;
              }
            }
          });
        }
        localc.zRX.setOnClickListener(null);
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
          label1060:
          i = 1;
          parama = (c.a)localObject1;
          j = k;
        }
      }
      for (;;)
      {
        label1070:
        if (i != 0) {
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.zRR.setVisibility(0);
            localc.zRR.setMaxLines(2);
            localc.zRR.setText(localb.title);
            label1125:
            localc.gpL.setVisibility(8);
            if (!bool) {
              break label7540;
            }
            if ((localb.type != 33) && (localb.type != 36) && (localb.type != 44)) {
              break label7442;
            }
            paramString = com.tencent.mm.at.o.ahC().tj(parambi.HE());
            localc.zRM.setImageResource(2131230829);
            com.tencent.mm.modelappbrand.a.b.acD().a(localc.zRM, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(50, 50));
            localObject2 = parama;
          }
        }
        for (;;)
        {
          if (j == 0)
          {
            localc.zSg.setTag(localObject2);
            localc.zSg.setOnClickListener(d(parama1));
          }
          if (this.kFs)
          {
            localc.zSg.setOnLongClickListener(c(parama1));
            localc.zSg.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          }
          a(paramInt, localc, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
          AppMethodBeat.o(32853);
          return;
          label1336:
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.f)localObject4).field_appName;
          break;
          label1346:
          localc.mCZ.setText((CharSequence)localObject2);
          break label568;
          label1359:
          a(parama1, localc.mCZ, localb.appId);
          break label643;
          label1376:
          if (localb.type == 24)
          {
            localc.mCZ.setText(ah.getContext().getString(2131299680));
            localc.zRQ.setVisibility(0);
            localc.mCZ.setVisibility(0);
            localc.zRN.setVisibility(8);
            break label668;
          }
          if ((localb.type == 19) || (((com.tencent.mm.af.o)localObject3).fjG == 19))
          {
            localc.mCZ.setText(ah.getContext().getString(2131298219));
            localc.zRQ.setVisibility(0);
            localc.mCZ.setVisibility(0);
            localc.zRN.setVisibility(8);
            break label668;
          }
          if (d.a(localb, localc)) {
            break label668;
          }
          localc.zRQ.setVisibility(8);
          localc.mCZ.setVisibility(8);
          localc.zRN.setVisibility(8);
          break label668;
          label1545:
          bool = true;
          break label804;
          label1551:
          localc.zRM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2130839820));
          bool = false;
          break label837;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpL.setTextColor(parama1.getContext().getResources().getColor(2131690709));
            label1624:
            localc.gpM.setVisibility(0);
            localc.gpM.setTextColor(parama1.getContext().getResources().getColor(2131690709));
            localc.zRR.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            localc.zRX.setVisibility(0);
            if (!parambi.Hz().equals(parama.zRD)) {
              break label1891;
            }
            localc.zRX.setImageResource(2130839751);
            label1730:
            parama = new d.f();
            parama.cpO = parambi.Hz();
            parama.cBW = parambi.getContent();
            parama.imgPath = parambi.HE();
            localc.zRX.setTag(parama);
            localc.zRX.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHj());
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label1905;
              }
              localc.zRM.setImageResource(2131230809);
            }
          }
          for (;;)
          {
            if (!dLr()) {
              break label1917;
            }
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.gpL.setVisibility(8);
            break label1624;
            label1891:
            localc.zRX.setImageResource(2130839753);
            break label1730;
            label1905:
            localc.zRM.setImageBitmap(parama);
          }
          label1917:
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpL.setMaxLines(2);
          }
          for (;;)
          {
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            localc.gpM.setText(bo.hk(localb.fgw));
            localc.zRX.setVisibility(8);
            d.c.a(localc, str, localb.fgw);
            d.c.a(localc, Boolean.FALSE, parambi, localb.cmN, localb.title);
            if (!bool) {
              break label7546;
            }
            if (!d.b.aul(localb.fgx)) {
              break label2152;
            }
            localc.zRM.setImageResource(2130837807);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.gpL.setVisibility(8);
          }
          label2152:
          localc.zRM.setImageResource(com.tencent.mm.pluginsdk.model.o.alm(localb.fgx));
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            label2209:
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.gpM.setMaxLines(2);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(0);
            localc.zRX.setImageResource(2130840655);
            if (!bool) {
              break label7546;
            }
            paramString = new com.tencent.mm.at.a.a.c.a();
            paramString.lH(2131230829).ahV().cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).ahT();
            localObject2 = com.tencent.mm.at.o.ahG();
            if (!bo.isNullOrNil(localb.thumburl)) {
              break label2388;
            }
          }
          label2388:
          for (parama = localb.fgD;; parama = localb.thumburl)
          {
            ((com.tencent.mm.at.a.a)localObject2).a(parama, localc.zRM, paramString.ahY());
            localc.zRX.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.gpL.setVisibility(8);
            break label2209;
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
            label2461:
            if (paramString == null) {
              break label2688;
            }
          }
          label2688:
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
            parama = com.tencent.mm.at.o.ahC().tj(parambi.HE());
            localc.zSu.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSu, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
            if (!dLr()) {
              break label2698;
            }
            a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            parama = localb.cGO;
            break label2461;
          }
          label2698:
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          parama = (com.tencent.mm.af.e)localb.R(com.tencent.mm.af.e.class);
          if ((parama != null) && (parama.fgj == 1) && (parama.fgh == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm()))
          {
            d.c.a(parama1, localc, localb, parambi, bool);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1070;
          }
          localc.gpL.setVisibility(8);
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.zRR.setMaxLines(2);
            localc.zRR.setVisibility(0);
            localc.zRR.setText(localb.title);
            label2881:
            localc.gpM.setMaxLines(3);
            localc.zRS.setVisibility(4);
            if (!d.h(localb)) {
              break label3101;
            }
            localc.zRX.setImageResource(2130840655);
            localc.zRX.setVisibility(0);
            label2927:
            if (bool)
            {
              localObject2 = new com.tencent.mm.at.a.a.c.a();
              ((com.tencent.mm.at.a.a.c.a)localObject2).lH(2131230829).ahV().tz(com.tencent.mm.plugin.i.c.bIC()).cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).ahT();
              localObject3 = com.tencent.mm.at.o.ahG();
              if (!bo.isNullOrNil(localb.thumburl)) {
                break label3114;
              }
              parama = localb.fgD;
              ((com.tencent.mm.at.a.a)localObject3).a(parama, localc.zRM, ((com.tencent.mm.at.a.a.c.a)localObject2).ahY());
            }
            label3003:
            if (!dLr()) {
              break label3123;
            }
            a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
            if (localc.pNd != null) {
              localc.pNd.setVisibility(8);
            }
          }
          for (;;)
          {
            if (localb == null) {
              break label7546;
            }
            d.a(paramString, parama1, parambi, localb);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.zRR.setVisibility(8);
            break label2881;
            label3101:
            localc.zRX.setVisibility(8);
            break label2927;
            label3114:
            parama = localb.thumburl;
            break label3003;
            label3123:
            if (localc.pNd != null)
            {
              localc.pNd.setVisibility(0);
              if (parambi.getStatus() >= 2) {
                localc.pNd.setVisibility(8);
              }
            }
          }
          paramString = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(localb.fiX);
          switch (localb.fiZ)
          {
          }
          for (;;)
          {
            i = 1;
            for (;;)
            {
              if (i != 0) {
                break label7559;
              }
              if (!dLr()) {
                break label3732;
              }
              a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
              if (localc.pNd == null) {
                break label7559;
              }
              localc.pNd.setVisibility(8);
              parama = (c.a)localObject1;
              j = k;
              break;
              if (localc.zSg.getLayoutParams() != null)
              {
                localc.zSg.getLayoutParams().width = -2;
                localc.zSg.requestLayout();
              }
              if (paramString != null)
              {
                parama = paramString.field_nickname;
                label3322:
                if (paramString == null) {
                  break label3505;
                }
              }
              label3505:
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
                parama = com.tencent.mm.at.o.ahC().tj(parambi.HE());
                localc.zSu.setImageBitmap(null);
                com.tencent.mm.modelappbrand.a.b.acD().a(new d.e.4(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
                i = 0;
                break;
                parama = localb.cGO;
                break label3322;
              }
              if (paramString != null)
              {
                parama = paramString.field_nickname;
                label3526:
                if (paramString == null) {
                  break label3649;
                }
              }
              label3649:
              for (paramString = paramString.field_smallHeadURL;; paramString = null)
              {
                localc.zSh.setVisibility(8);
                localc.zSt.setVisibility(8);
                localc.zSn.setVisibility(0);
                localc.zSp.setText(parama);
                localc.zSy.setVisibility(8);
                if (!bo.isNullOrNil(paramString)) {
                  break label3655;
                }
                parama = com.tencent.mm.at.o.ahC().tj(parambi.HE());
                com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSo, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.acC(), com.tencent.mm.modelappbrand.a.f.fqU);
                i = 0;
                break;
                parama = localb.title;
                break label3526;
              }
              label3655:
              com.tencent.mm.modelappbrand.a.b.acD().a(localc.zSo, paramString, com.tencent.mm.modelappbrand.a.a.acC(), com.tencent.mm.modelappbrand.a.f.fqU);
              i = 0;
            }
            localc.zRQ.setVisibility(0);
            localc.zRN.setVisibility(0);
            localc.zRN.setBackground(null);
            localc.zRN.setImageResource(2131230915);
            d.a(localc.mCZ, localb);
          }
          label3732:
          if (localc.pNd == null) {
            break label7559;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7559;
          }
          localc.pNd.setVisibility(8);
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          parama = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
          paramString = localb.fjj;
          localObject2 = localb.cGO;
          localObject3 = localb.title;
          localObject4 = localb.description;
          if (parama == null)
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
            break label1060;
          }
          if (((bo.isNullOrNil(parama.ffv)) || (bo.isNullOrNil(parama.ffx))) && (bo.isNullOrNil(parama.ffu)))
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
            break label1060;
          }
          localc.zSE.setText((CharSequence)localObject2);
          localc.zSh.setVisibility(8);
          localc.zSt.setVisibility(8);
          localc.zSn.setVisibility(8);
          localc.zSF.setVisibility(0);
          localc.zSB.setVisibility(8);
          localc.zSF.setImageDrawable(com.tencent.mm.cb.a.k(parama1.getContext(), 2131231980));
          localc.zSy.setVisibility(0);
          localc.zSz.setText((CharSequence)localObject3);
          localc.zSA.setText((CharSequence)localObject4);
          com.tencent.mm.at.o.ahF().a(paramString, new d.e.5(this, localc));
          parama = com.tencent.mm.at.o.ahC().tj(parambi.HE());
          localc.zSC.setImageBitmap(null);
          com.tencent.mm.modelappbrand.a.b.acD().a(new d.e.6(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a(240, 120, i.a.fpT));
          if (dLr())
          {
            a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1070;
          }
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if (localb.cH(false))
          {
            parama = localb.q(parama1.getContext(), false);
            if (!bo.isNullOrNil(parama))
            {
              localc.zSE.setText(parama);
              localc.zSh.setVisibility(8);
              localc.zSt.setVisibility(8);
              localc.zSn.setVisibility(8);
              localc.zSF.setVisibility(8);
              localc.zSy.setVisibility(0);
              localc.zSz.setText(localb.title);
              localc.zSA.setText(localb.description);
              if (j.a.fgp.ordinal() != localb.fje) {
                break label4407;
              }
              localc.zSD.setImageResource(2131231747);
            }
            for (;;)
            {
              parama = com.tencent.mm.at.o.ahC().tj(parambi.HE());
              localc.zSC.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.acD().a(new d.e.8(this, localc), "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a(240, 120, i.a.fpT));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              i = 1;
              parama = (c.a)localObject1;
              j = k;
              break;
              label4407:
              if (j.a.fgq.ordinal() == localb.fje) {
                com.tencent.mm.at.o.ahF().a(localb.fjj, new d.e.7(this, localc));
              }
            }
          }
          i = 1;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          localc.gpL.setVisibility(8);
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.zRR.setMaxLines(2);
            localc.zRR.setVisibility(0);
            localc.zRR.setText(localb.title);
            label4518:
            localc.gpM.setMaxLines(3);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(8);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
              if ((parama != null) && (!parama.isRecycled())) {
                break label4640;
              }
              localc.zRM.setImageResource(2131230829);
            }
          }
          for (;;)
          {
            if (!dLr()) {
              break label4652;
            }
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.zRR.setVisibility(8);
            break label4518;
            label4640:
            localc.zRM.setImageBitmap(parama);
          }
          label4652:
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          localc.zRR.setVisibility(0);
          if (localb.fgX == 1) {
            localc.zRR.setText(2131302924);
          }
          for (;;)
          {
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.gpL.setVisibility(0);
              localc.gpL.setText(localb.title);
            }
            localc.gpM.setMaxLines(4);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(8);
            if (!bool) {
              break label7546;
            }
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if ((parama == null) || (parama.isRecycled())) {
              break label4917;
            }
            localc.zRM.setImageBitmap(parama);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            if (localb.fgX == 2) {
              localc.zRR.setText(2131302926);
            } else if (localb.fgX == 3) {
              localc.zRR.setText(2131302925);
            } else {
              localc.zRR.setText(2131302927);
            }
          }
          label4917:
          localc.zRM.setImageResource(2131230829);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          localc.gpL.setVisibility(0);
          localc.gpL.setText(localb.title);
          localc.zRR.setVisibility(0);
          localc.zRR.setText(2131298256);
          localc.gpM.setMaxLines(4);
          localc.zRS.setVisibility(4);
          localc.zRX.setVisibility(8);
          if (!bool) {
            break label7546;
          }
          parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
          if ((parama != null) && (!parama.isRecycled()))
          {
            localc.zRM.setImageBitmap(parama);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1070;
          }
          localc.zRM.setImageResource(2131230829);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            localc.gpL.setText(localb.title);
            localc.zRR.setVisibility(8);
          }
          localc.gpM.setMaxLines(4);
          localc.zRS.setVisibility(4);
          localc.zRX.setVisibility(8);
          if (!bool) {
            break label7546;
          }
          parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
          if ((parama != null) && (!parama.isRecycled()))
          {
            localc.zRM.setImageBitmap(parama);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1070;
          }
          localc.zRM.setImageResource(2131230829);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0)) {
            localc.gpL.setVisibility(0);
          }
          for (;;)
          {
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRS.setVisibility(8);
            localc.zRX.setVisibility(4);
            localc.gpM.setMaxLines(2);
            if (!bool) {
              break label7546;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
            if ((parama != null) && (!parama.isRecycled())) {
              break label5399;
            }
            localc.zRM.setImageResource(2131230829);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.gpL.setVisibility(8);
          }
          label5399:
          localc.zRM.setImageBitmap(parama);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            label5449:
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRX.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled())) {
                break label5633;
              }
              localc.zRM.setImageResource(2131230829);
            }
          }
          for (;;)
          {
            parama = new az(parambi, false, paramInt, "", false, parama1.dHF(), localb.cGN, localb.cGO, localb.title, localb.fhf, localb.url, false, false);
            localc.zSg.setTag(parama);
            localc.zSg.setOnClickListener(i(parama1));
            j = 1;
            i = 0;
            break;
            localc.gpL.setVisibility(8);
            break label5449;
            label5633:
            localc.zRM.setImageBitmap(parama);
          }
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            label5673:
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRX.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled())) {
                break label5863;
              }
              localc.zRM.setImageResource(2131230829);
            }
          }
          for (;;)
          {
            parama = new az(parambi, paramInt, "", parama1.dHF(), localb.cGN, localb.cGO, localb.title, localb.fiL, localb.designerName, localb.designerRediretctUrl, localb.url);
            localc.zSg.setTag(parama);
            localc.zSg.setOnClickListener(j(parama1));
            j = 1;
            i = 0;
            break;
            localc.gpL.setVisibility(8);
            break label5673;
            label5863:
            localc.zRM.setImageBitmap(parama);
          }
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            label5903:
            localc.gpM.setVisibility(0);
            localc.zRR.setVisibility(8);
            localc.zRX.setVisibility(8);
            localc.zRS.setVisibility(4);
            localc.gpM.setMaxLines(2);
            if (bool)
            {
              if (!bo.isNullOrNil(parambi.HE())) {
                break label6162;
              }
              com.tencent.mm.at.o.ahG().a(localb.thumburl, localc.zRM);
            }
            label5982:
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
              break label6219;
            }
            parama.tid = localb.tid;
            parama.fiM = localb.fiM;
            parama.desc = localb.desc;
            parama.iconUrl = localb.iconUrl;
            parama.secondUrl = localb.secondUrl;
            parama.pageType = localb.pageType;
            localc.zSg.setOnClickListener(k(parama1));
            i = 1;
          }
          for (;;)
          {
            localc.zSg.setTag(parama);
            k = 0;
            j = i;
            i = k;
            break;
            localc.gpL.setVisibility(8);
            break label5903;
            label6162:
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if ((parama == null) || (parama.isRecycled()))
            {
              localc.zRM.setImageResource(2131230829);
              break label5982;
            }
            localc.zRM.setImageBitmap(parama);
            break label5982;
            label6219:
            if (localb.type == 27)
            {
              parama.tid = localb.tid;
              parama.fiM = localb.fiM;
              parama.desc = localb.desc;
              parama.iconUrl = localb.iconUrl;
              parama.secondUrl = localb.secondUrl;
              parama.pageType = localb.pageType;
              localc.zSg.setOnClickListener(l(parama1));
              i = 1;
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
              i = 0;
            }
          }
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
              break label7546;
            }
            parama = com.tencent.mm.at.o.ahC().b(parambi.HE(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
            if (parama == null) {
              break label6485;
            }
            localc.zRM.setImageBitmap(parama);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.zRR.setVisibility(8);
          }
          label6485:
          localc.zRM.setImageResource(2131230829);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          localc.gpL.setVisibility(8);
          localc.zRR.setVisibility(0);
          if ((localb.title != null) && (localb.title.length() > 0)) {
            localc.zRR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localc.zRR.getContext(), localb.title, (int)localc.zRR.getTextSize()));
          }
          for (;;)
          {
            localc.gpM.setMaxLines(3);
            localc.zRS.setVisibility(4);
            localc.zRX.setVisibility(8);
            if (bool) {
              localc.zRM.setVisibility(8);
            }
            d.c.b(parama1, localc, localb, parambi, bool);
            if (!dLr()) {
              break label6729;
            }
            a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break;
            localc.zRR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localc.zRR.getContext(), ah.getContext().getString(2131299857), (int)localc.zRR.getTextSize()));
          }
          label6729:
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          d.c.a(parama1, localc, localb, bool);
          if (dLr())
          {
            a(localc, (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi);
            if (localc.pNd == null) {
              break label7546;
            }
            localc.pNd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1070;
          }
          if (localc.pNd == null) {
            break label7546;
          }
          localc.pNd.setVisibility(0);
          if (parambi.getStatus() < 2) {
            break label7546;
          }
          localc.pNd.setVisibility(8);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if ((localb.title != null) && (localb.title.length() > 0))
          {
            localc.gpL.setVisibility(0);
            if (!bo.isNullOrNil(localb.fhT)) {
              if (!bo.isNullOrNil(localb.fhT))
              {
                localc.gpL.setTextColor(bo.bS(localb.fhT, parama1.getContext().getResources().getColor(2131689763)));
                label6970:
                localc.gpM.setMaxLines(2);
                localc.gpM.setVisibility(0);
                if (bo.isNullOrNil(localb.fhU)) {
                  break label7291;
                }
                localc.gpM.setTextColor(bo.bS(localb.fhU, parama1.getContext().getResources().getColor(2131690143)));
                label7028:
                localc.zRR.setVisibility(8);
                localc.zRS.setVisibility(4);
                localc.zRX.setVisibility(8);
                localc.zRQ.setVisibility(0);
                localc.mCZ.setVisibility(0);
                if (bo.isNullOrNil(localb.fhP)) {
                  break label7315;
                }
                localc.mCZ.setText(localb.fhP);
              }
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
                com.tencent.mm.at.o.ahG().a(localb.fhS, new ImageView(parama1.getContext()), new com.tencent.mm.at.a.a.c.a().ahU().ahY(), new d.e.9(this, localc, parama1));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.gpL.setTextColor(parama1.getContext().getResources().getColor(2131689763));
                break label6970;
                localc.gpL.setTextColor(parama1.getContext().getResources().getColor(2131689763));
                break label6970;
                localc.gpL.setVisibility(8);
                break label6970;
                label7291:
                localc.gpM.setTextColor(parama1.getContext().getResources().getColor(2131690143));
                break label7028;
                label7315:
                localc.mCZ.setText(2131298217);
                continue;
              }
              localc.zSh.getViewTreeObserver().addOnPreDrawListener(new d.e.10(this, localc, parama1, parama));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
          }
          localc.zRM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2130839820));
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          if (((com.tencent.mm.af.o)localObject3).fjG != 19) {
            break label7546;
          }
          d.c.a(parama1, localc, localb, bool);
          i = 0;
          parama = (c.a)localObject1;
          j = k;
          break label1070;
          localc.zRR.setVisibility(8);
          break label1125;
          label7442:
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
            localObject2 = parama;
          }
          else
          {
            localc.zRM.setImageResource(2130837807);
            label7540:
            localObject2 = parama;
          }
        }
        label7546:
        i = 0;
        parama = (c.a)localObject1;
        j = k;
        continue;
        label7559:
        parama = (c.a)localObject1;
        j = k;
      }
      localObject3 = null;
      localb = null;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32855);
    int i = ((az)paramView.getTag()).position;
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(32855);
      return true;
    }
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(32855);
      return true;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.k((com.tencent.mm.pluginsdk.model.app.f)localObject)) && (!com.tencent.mm.ui.chatting.j.aB(parambi))) {
      paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker)) && (!ad.na(this.zzP.getTalkerUserName()))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
    }
    boolean bool1;
    switch (localb.type)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
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
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        }
        AppMethodBeat.o(32855);
        return true;
        bool1 = com.tencent.mm.aj.f.aeY();
        break;
        bool1 = com.tencent.mm.aj.f.aeS();
        break;
        boolean bool2 = com.tencent.mm.aj.f.aeW();
        bool1 = bool2;
        if (bo.aqj(localb.fgx)) {
          break;
        }
        paramContextMenu.add(i, 150, 0, this.zzP.zJz.getMMResources().getString(2131298239));
        bool1 = bool2;
        break;
        bool1 = com.tencent.mm.aj.f.aeP();
        break;
        bool1 = com.tencent.mm.aj.f.aeO();
        break;
        bool1 = com.tencent.mm.aj.f.aeU();
        break;
        bool1 = com.tencent.mm.aj.f.aeQ();
        break;
        if ((localb.fhL != 5) && (localb.fhL != 6) && (localb.fhL != 2)) {
          break label838;
        }
        if (localb.fhL != 2) {
          paramContextMenu.clear();
        }
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        AppMethodBeat.o(32855);
        return false;
        paramContextMenu.clear();
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        AppMethodBeat.o(32855);
        return false;
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
      }
      label838:
      bool1 = false;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32856);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(32856);
      return false;
      AppMethodBeat.o(32856);
      return false;
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(32856);
      return false;
      paramMenuItem = parambi.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(32856);
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
        AppMethodBeat.o(32856);
        return false;
        com.tencent.mm.ui.chatting.al.a(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
        continue;
        com.tencent.mm.ui.chatting.al.d(parambi, parama.zJz.getContext());
        continue;
        com.tencent.mm.ui.chatting.al.b(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
        continue;
        com.tencent.mm.ui.chatting.al.a(parambi, parama.zJz.getContext(), b(parama, parambi), parama.dJG());
        continue;
        com.tencent.mm.ui.chatting.al.n(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
        continue;
        com.tencent.mm.ui.chatting.al.c(parambi, bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend), parama.zJz.getContext());
        continue;
        com.tencent.mm.ui.chatting.al.c(parambi, parama.zJz.getContext());
      }
      paramMenuItem = parambi.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(32856);
        return false;
      }
      paramMenuItem = j.b.mY(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new ij();
          parama.cxJ.cxK = paramMenuItem.cxK;
          parama.cxJ.cpg = parambi.field_msgId;
          parama.cxJ.cxL = parambi.field_talker;
          com.tencent.mm.sdk.b.a.ymk.l(parama);
        }
      }
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32857);
    paramView.getTag();
    Object localObject1 = parambi.field_content;
    if (localObject1 == null)
    {
      AppMethodBeat.o(32857);
      return false;
    }
    Object localObject2 = j.b.mY((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(32857);
      return false;
    }
    localObject1 = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject2).appId, true);
    if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appId))) {
      a(parama, (j.b)localObject2, r.Zn(), (com.tencent.mm.pluginsdk.model.app.f)localObject1, parambi.field_msgSvrId, parama.getTalkerUserName());
    }
    int j;
    switch (((j.b)localObject2).type)
    {
    default: 
      j = 1;
    }
    while ((j != 0) && (((j.b)localObject2).url != null) && (!((j.b)localObject2).url.equals("")))
    {
      int i;
      Object localObject3;
      Object localObject4;
      if (!bo.isNullOrNil(((j.b)localObject2).canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", parambi.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", ((j.b)localObject2).canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", parambi.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        AppMethodBeat.o(32857);
        return true;
        aw.aaz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
          AppMethodBeat.o(32857);
          return true;
        }
        if (bo.aqj(((j.b)localObject2).fgx))
        {
          long l = parambi.field_msgId;
          localObject1 = ((j.b)localObject2).cmN;
          paramView = com.tencent.mm.pluginsdk.model.app.al.aUJ().alo((String)localObject1);
          if ((paramView == null) || (!paramView.bEL())) {
            i = 0;
          }
          while (i != 0)
          {
            AppMethodBeat.o(32857);
            return true;
            aw.aaz();
            localObject2 = com.tencent.mm.model.c.YC().kB(l);
            if (((bi)localObject2).dyc())
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject1, Long.valueOf(l), Long.valueOf(((dd)localObject2).field_msgSvrId), ((dd)localObject2).field_imgPath });
              paramView = new Intent();
              paramView.setClassName(this.zzP.zJz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              this.zzP.startActivity(paramView);
              i = 1;
            }
            else
            {
              localObject1 = new Intent(this.zzP.zJz.getContext(), ShowImageUI.class);
              ((Intent)localObject1).putExtra("key_image_path", paramView.field_fileFullPath);
              ((Intent)localObject1).putExtra("key_message_id", l);
              ((Intent)localObject1).putExtra("key_favorite", true);
              this.zzP.startActivity((Intent)localObject1);
              i = 1;
            }
          }
        }
        paramView = new Intent();
        paramView.setClassName(parama.zJz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("app_msg_id", parambi.field_msgId);
        parama.startActivity(paramView);
        AppMethodBeat.o(32857);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.e(13043, new Object[] { Integer.valueOf(2), ((j.b)localObject2).description, ((j.b)localObject2).appId });
        if (a(parama, (j.b)localObject2, parambi))
        {
          AppMethodBeat.o(32857);
          return true;
        }
        localObject1 = com.tencent.mm.pluginsdk.model.app.p.H(((j.b)localObject2).url, "message");
        localObject3 = com.tencent.mm.pluginsdk.model.app.p.H(((j.b)localObject2).fgv, "message");
        localObject4 = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject2).appId);
        if (localObject4 == null)
        {
          paramView = null;
          if (localObject4 != null) {
            break label849;
          }
        }
        label849:
        for (i = 0;; i = ((PackageInfo)localObject4).versionCode)
        {
          a(parama, (String)localObject1, (String)localObject3, paramView, i, ((j.b)localObject2).appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
          AppMethodBeat.o(32857);
          return true;
          paramView = ((PackageInfo)localObject4).versionName;
          break;
        }
        if (!bo.isNullOrNil(((j.b)localObject2).canvasPageXml))
        {
          paramView = new Intent();
          paramView.putExtra("sns_landig_pages_from_source", 5);
          paramView.putExtra("msg_id", parambi.field_msgId);
          paramView.putExtra("sns_landing_pages_xml", ((j.b)localObject2).canvasPageXml);
          paramView.putExtra("sns_landing_pages_share_thumb_url", parambi.field_imgPath);
          paramView.addFlags(268435456);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
          AppMethodBeat.o(32857);
          return true;
        }
        localObject1 = (com.tencent.mm.plugin.websearch.api.ab)((j.b)localObject2).R(com.tencent.mm.plugin.websearch.api.ab.class);
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
          aa.a(parama.zJz.getContext(), (ckw)localObject1);
          com.tencent.mm.plugin.topstory.a.h.a(paramView, parambi);
          AppMethodBeat.o(32857);
          return true;
        }
        Object localObject5;
        Object localObject6;
        if ((((j.b)localObject2).url != null) && (!((j.b)localObject2).url.equals("")))
        {
          localObject3 = ((j.b)localObject2).url;
          if (parama.dJG())
          {
            localObject1 = "groupmessage";
            localObject3 = com.tencent.mm.pluginsdk.model.app.p.H((String)localObject3, (String)localObject1);
            localObject1 = ((j.b)localObject2).fgv;
            localObject5 = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject2).appId);
            localObject4 = new Intent();
            ((Intent)localObject4).putExtra("rawUrl", (String)localObject3);
            ((Intent)localObject4).putExtra("webpageTitle", ((j.b)localObject2).title);
            localObject6 = new Bundle();
            ((Bundle)localObject6).putString("key_snsad_statextstr", ((j.b)localObject2).cGU);
            if ((((j.b)localObject2).appId != null) && (("wx751a1acca5688ba3".equals(((j.b)localObject2).appId)) || ("wxfbc915ff7c30e335".equals(((j.b)localObject2).appId)) || ("wx482a4001c37e2b74".equals(((j.b)localObject2).appId)))) {
              ((Bundle)localObject6).putString("jsapi_args_appid", ((j.b)localObject2).appId);
            }
            ((Intent)localObject4).putExtra("jsapiargs", (Bundle)localObject6);
            if (bo.isNullOrNil((String)localObject1)) {
              break label2026;
            }
            ((Intent)localObject4).putExtra("shortUrl", (String)localObject1);
            label1433:
            if (localObject5 != null) {
              break label2043;
            }
            localObject1 = null;
            label1441:
            ((Intent)localObject4).putExtra("version_name", (String)localObject1);
            if (localObject5 != null) {
              break label2053;
            }
            i = 0;
            label1460:
            ((Intent)localObject4).putExtra("version_code", i);
            if (!bo.isNullOrNil(((j.b)localObject2).cGN))
            {
              ((Intent)localObject4).putExtra("srcUsername", ((j.b)localObject2).cGN);
              ((Intent)localObject4).putExtra("srcDisplayname", ((j.b)localObject2).cGO);
            }
            ((Intent)localObject4).putExtra("msg_id", parambi.field_msgId);
            ((Intent)localObject4).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
            ((Intent)localObject4).putExtra("KAppId", ((j.b)localObject2).appId);
            ((Intent)localObject4).putExtra("geta8key_username", parama.getTalkerUserName());
            ((Intent)localObject4).putExtra("pre_username", b(parama, parambi));
            ((Intent)localObject4).putExtra("from_scence", 2);
            i = u.ah(b(parama, parambi), parama.getTalkerUserName());
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
              label1751:
              ((Intent)localObject4).putExtra("share_report_pre_msg_url", ((j.b)localObject2).url);
              ((Intent)localObject4).putExtra("share_report_pre_msg_title", ((j.b)localObject2).title);
              ((Intent)localObject4).putExtra("share_report_pre_msg_desc", ((j.b)localObject2).description);
              ((Intent)localObject4).putExtra("share_report_pre_msg_icon_url", ((j.b)localObject2).thumburl);
              ((Intent)localObject4).putExtra("share_report_pre_msg_appid", ((j.b)localObject2).appId);
              ((Intent)localObject4).putExtra("share_report_from_scene", i);
              if (i == 5) {
                ((Intent)localObject4).putExtra("share_report_biz_username", parama.getTalkerUserName());
              }
              localObject1 = (com.tencent.mm.af.e)((j.b)localObject2).R(com.tencent.mm.af.e.class);
              if (localObject1 == null) {
                break;
              }
            }
          }
          for (i = ((com.tencent.mm.af.e)localObject1).fgh;; i = -1)
          {
            ((Intent)localObject4).putExtra(e.l.yVt, i);
            j = parama.zJz.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
            if ((localObject1 == null) || (i != 5) || (((com.tencent.mm.af.e)localObject1).fgj != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm())) {
              break label2087;
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("biz_video_scene", 1);
            ((Bundle)localObject1).putInt("biz_video_subscene", j);
            ((Bundle)localObject1).putInt("geta8key_scene", 1);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.a(parama.zJz.getContext(), parambi.field_msgId, parambi.field_msgSvrId, 0, paramView.findViewById(2131822508), (Bundle)localObject1);
            AppMethodBeat.o(32857);
            return true;
            localObject1 = "singlemessage";
            break;
            label2026:
            ((Intent)localObject4).putExtra("shortUrl", ((j.b)localObject2).url);
            break label1433;
            label2043:
            localObject1 = ((PackageInfo)localObject5).versionName;
            break label1441;
            label2053:
            i = ((PackageInfo)localObject5).versionCode;
            break label1460;
            i = 2;
            break label1751;
            i = 3;
            break label1751;
            i = 5;
            break label1751;
          }
          label2087:
          if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.zJz.getContext(), (String)localObject3, i, false, 1, j, (Intent)localObject4)))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
            AppMethodBeat.o(32857);
            return true;
          }
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
        }
        AppMethodBeat.o(32857);
        return true;
        Object localObject7 = (com.tencent.mm.af.a)((j.b)localObject2).R(com.tencent.mm.af.a.class);
        if ((localObject7 != null) && (!bo.isNullOrNil(((com.tencent.mm.af.a)localObject7).ffv)) && (!bo.isNullOrNil(((com.tencent.mm.af.a)localObject7).ffx)))
        {
          paramView = ((com.tencent.mm.af.a)localObject7).ffv;
          localObject1 = ((com.tencent.mm.af.a)localObject7).ffu;
          localObject6 = ((com.tencent.mm.af.a)localObject7).cHH;
          localObject3 = ((j.b)localObject2).description;
          localObject4 = ((com.tencent.mm.af.a)localObject7).ffw;
          localObject5 = ((j.b)localObject2).fiY;
          localObject7 = ((com.tencent.mm.af.a)localObject7).ffx;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { paramView, localObject1, localObject3, localObject4, localObject5, localObject7 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
          if (com.tencent.mm.model.t.lA(parama.getTalkerUserName())) {}
          for (i = 2;; i = 1)
          {
            localh.e(17608, new Object[] { Integer.valueOf(i), localObject5, Integer.valueOf(1), Integer.valueOf(1) });
            if ((bo.isNullOrNil(paramView)) && ((bo.isNullOrNil((String)localObject1)) || (!com.tencent.mm.a.e.cN((String)localObject1)) || (!bo.nullAsNil(com.tencent.mm.a.g.getMD5((String)localObject1)).equals(localObject6)))) {
              break label2510;
            }
            localObject6 = new Bundle();
            ((Bundle)localObject6).putString("key_chatting_wording", (String)localObject3);
            ((Bundle)localObject6).putString("key_chatting_text", (String)localObject4);
            ((Bundle)localObject6).putString("key_chatting_appid", (String)localObject5);
            ((Bundle)localObject6).putLong("key_msg_id", parambi.field_msgId);
            ((Bundle)localObject6).putString("key_talker_username", parama.getTalkerUserName());
            ((Bundle)localObject6).putString("key_sender_username", b(parama, parambi));
            d.a(parama, paramView, (String)localObject1, (String)localObject7, (Bundle)localObject6);
            j = 0;
            break;
          }
          label2510:
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
          j = 0;
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
          com.tencent.mm.ui.base.t.makeText(parama.zJz.getContext(), parama.zJz.getMMResources().getString(2131297069), 0).show();
          AppMethodBeat.o(32857);
          return true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((j.b)localObject2).fiX, ((j.b)localObject2).fiW, ((j.b)localObject2).fiY, ((j.b)localObject2).url, Integer.valueOf(((j.b)localObject2).fjh), ((j.b)localObject2).fja });
          if ((44 == ((j.b)localObject2).type) && ((!((j.b)localObject2).cH(false)) || (bo.isNullOrNil(((j.b)localObject2).q(parama.zJz.getContext(), false)))))
          {
            j = 1;
          }
          else
          {
            localObject1 = parama.getTalkerUserName();
            localObject3 = b(parama, parambi);
            localObject4 = new Bundle();
            if ((parama.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
            {
              i = 10;
              label2715:
              ((Bundle)localObject4).putInt("stat_scene", i);
              ((Bundle)localObject4).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
              ((Bundle)localObject4).putString("stat_chat_talker_username", (String)localObject1);
              ((Bundle)localObject4).putString("stat_send_msg_user", (String)localObject3);
              switch (((j.b)localObject2).fiZ)
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
              AppMethodBeat.o(32857);
              return true;
              if (parama.dJG())
              {
                i = 2;
                break label2715;
              }
              if (com.tencent.mm.model.t.nU((String)localObject1))
              {
                i = 7;
                break label2715;
              }
              i = 1;
              break label2715;
              paramView = new Intent();
              paramView.putExtra("key_username", ((j.b)localObject2).fiX);
              if (parama.dJG())
              {
                paramView.putExtra("key_from_scene", 1);
                paramView.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + (String)localObject3);
              }
              for (;;)
              {
                paramView.putExtra("_stat_obj", (Bundle)localObject4);
                localObject1 = new WxaExposedParams.a();
                ((WxaExposedParams.a)localObject1).appId = ((j.b)localObject2).fiY;
                ((WxaExposedParams.a)localObject1).from = 6;
                ((WxaExposedParams.a)localObject1).gXe = ((j.b)localObject2).fjh;
                ((WxaExposedParams.a)localObject1).gXf = ((j.b)localObject2).fjb;
                paramView.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject1).ayJ());
                com.tencent.mm.bq.d.b(parama.zJz.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramView);
                i = 0;
                break;
                paramView.putExtra("key_from_scene", 2);
                paramView.putExtra("key_scene_note", (String)localObject1);
              }
              if ((parama.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject1, 1073, (j.b)localObject2, (Bundle)localObject4);
                i = 0;
              }
              else if (com.tencent.mm.model.t.nU((String)localObject1))
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject1, 1074, (j.b)localObject2, (Bundle)localObject4);
                i = 0;
              }
              else
              {
                com.tencent.mm.modelappbrand.a.a((String)localObject1, (String)localObject3, parama.dJG(), (j.b)localObject2, (Bundle)localObject4);
                i = 0;
                continue;
                com.tencent.mm.modelappbrand.a.b((String)localObject1, (String)localObject3, parama.dJG(), (j.b)localObject2, (Bundle)localObject4);
                i = 0;
              }
            }
            if ((bo.isNullOrNil(((j.b)localObject2).fiY)) && (bo.isNullOrNil(((j.b)localObject2).fiX)))
            {
              parambi = ((j.b)localObject2).url;
              if (parama.dJG()) {}
              for (paramView = "groupmessage";; paramView = "singlemessage")
              {
                paramView = com.tencent.mm.pluginsdk.model.app.p.H(parambi, paramView);
                parambi = new Intent();
                parambi.putExtra("rawUrl", paramView);
                parambi.putExtra("webpageTitle", ((j.b)localObject2).title);
                parambi.putExtra("shortUrl", ((j.b)localObject2).url);
                com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
                AppMethodBeat.o(32857);
                return true;
              }
            }
            paramView = parama.getTalkerUserName();
            localObject1 = b(parama, parambi);
            localObject3 = new Bundle();
            if (parama.dJG()) {
              i = 2;
            }
            for (;;)
            {
              ((Bundle)localObject3).putInt("stat_scene", i);
              ((Bundle)localObject3).putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
              ((Bundle)localObject3).putString("stat_chat_talker_username", paramView);
              ((Bundle)localObject3).putString("stat_send_msg_user", (String)localObject1);
              ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(parama.zJz.getContext(), parama.getTalkerUserName(), b(parama, parambi), parama.dJG(), (j.b)localObject2);
              AppMethodBeat.o(32857);
              return true;
              if (com.tencent.mm.model.t.nU(paramView)) {
                i = 7;
              } else {
                i = 1;
              }
            }
            if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).vY()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.f)localObject1)))
            {
              AppMethodBeat.o(32857);
              return true;
            }
            ((com.tencent.mm.ui.chatting.c.b.b)parama.ay(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambi, new d.e.11(this, (com.tencent.mm.pluginsdk.model.app.f)localObject1, parama, (j.b)localObject2, parambi));
            AppMethodBeat.o(32857);
            return true;
            if (bo.isNullOrNil(((j.b)localObject2).fgY))
            {
              AppMethodBeat.o(32857);
              return false;
            }
            paramView = new Intent();
            paramView.setFlags(65536);
            paramView.putExtra("key_Product_xml", ((j.b)localObject2).fgY);
            paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
            if (parambi.field_imgPath == null) {
              paramView.putExtra("key_ProductUI_chatting_msgId", parambi.field_msgId);
            }
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "scanner", ".ui.ProductUI", paramView);
            AppMethodBeat.o(32857);
            return true;
            if (bo.isNullOrNil(((j.b)localObject2).fhb))
            {
              AppMethodBeat.o(32857);
              return false;
            }
            paramView = new Intent();
            paramView.setFlags(65536);
            paramView.putExtra("key_TV_xml", ((j.b)localObject2).fhb);
            paramView.putExtra("key_TV_getProductInfoScene", 1);
            if (parambi.field_imgPath == null) {
              paramView.putExtra("key_TVInfoUI_chatting_msgId", parambi.field_msgId);
            }
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "shake", ".ui.TVInfoUI", paramView);
            AppMethodBeat.o(32857);
            return true;
            if (bo.isNullOrNil(((j.b)localObject2).fhe))
            {
              AppMethodBeat.o(32857);
              return false;
            }
            paramView = new Intent();
            paramView.setFlags(65536);
            paramView.putExtra("key_product_info", ((j.b)localObject2).fhe);
            paramView.putExtra("key_product_scene", 1);
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "product", ".ui.MallProductUI", paramView);
            AppMethodBeat.o(32857);
            return true;
            if (bo.isNullOrNil(((j.b)localObject2).cxK))
            {
              AppMethodBeat.o(32857);
              return false;
            }
            paramView = new Intent();
            paramView.setFlags(65536);
            paramView.putExtra("key_card_app_msg", ((j.b)localObject2).cxK);
            paramView.putExtra("key_from_scene", ((j.b)localObject2).fhL);
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "card", ".ui.CardDetailUI", paramView);
            AppMethodBeat.o(32857);
            return true;
            paramView = new Intent();
            paramView.putExtra("message_id", parambi.field_msgId);
            paramView.putExtra("record_xml", ((j.b)localObject2).fhc);
            i = u.ah(b(parama, parambi), parama.getTalkerUserName());
            paramView.putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
            paramView.putExtra("preUsername", b(parama, parambi));
            paramView.putExtra("preChatName", parama.getTalkerUserName());
            paramView.putExtra("preChatTYPE", i);
            d.a.a(paramView, parama, parambi, this);
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
            AppMethodBeat.o(32857);
            return true;
            paramView = new me();
            paramView.cCl.context = parama.zJz.getContext();
            paramView.cCl.cpO = parambi.field_msgId;
            paramView.cCl.cBz = parama.dJG();
            paramView.cCl.cCm = ((j.b)localObject2).fhc;
            paramView.cCl.scene = 6;
            com.tencent.mm.sdk.b.a.ymk.l(paramView);
            AppMethodBeat.o(32857);
            return true;
            paramView = new Intent();
            paramView.putExtra("key_biz_uin", ((j.b)localObject2).fhN);
            paramView.putExtra("key_order_id", ((j.b)localObject2).fhO);
            if ((parambi.field_talker != null) && (!parambi.field_talker.equals("")) && (com.tencent.mm.model.t.lA(parambi.field_talker))) {
              paramView.putExtra("key_chatroom_name", parambi.field_talker);
            }
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
            AppMethodBeat.o(32857);
            return true;
          }
        }
      }
      else
      {
        paramView = (com.tencent.mm.plugin.websearch.api.ab)((j.b)localObject2).R(com.tencent.mm.plugin.websearch.api.ab.class);
        if ((paramView != null) && (!bo.isNullOrNil(paramView.uJi)))
        {
          localObject1 = new cyl();
          ((cyl)localObject1).uJi = paramView.uJi;
          ((cyl)localObject1).uJj = paramView.uJj;
          ((cyl)localObject1).uJk = paramView.uJk;
          ((cyl)localObject1).uJl = paramView.uJl;
          ((cyl)localObject1).uJm = paramView.uJm;
          ((cyl)localObject1).uJq = paramView.uJq;
          ((cyl)localObject1).lHq = paramView.lHq;
          ((cyl)localObject1).lHr = paramView.lHr;
          ((cyl)localObject1).rrm = paramView.rrm;
          ((cyl)localObject1).uJn = paramView.uJn;
          ((cyl)localObject1).uJo = paramView.uJo;
          ((cyl)localObject1).uJp = paramView.uJp;
          ((cyl)localObject1).source = paramView.source;
          ((cyl)localObject1).puE = paramView.puE;
          ((cyl)localObject1).uJr = paramView.uJr;
          ((cyl)localObject1).uJt = paramView.uJt;
          ((cyl)localObject1).uJu = paramView.uJu;
          ((cyl)localObject1).uJv = paramView.uJv;
          ((cyl)localObject1).uJs = paramView.uJs;
          paramView = com.tencent.mm.plugin.topstory.a.g.a((cyl)localObject1, 32, parama.zJz.getContext().getString(2131300237));
          aa.a(parama.zJz.getContext(), paramView);
          com.tencent.mm.plugin.topstory.a.h.a((cyl)localObject1, parambi);
          AppMethodBeat.o(32857);
          return true;
        }
        localObject1 = ((j.b)localObject2).url;
        if (parama.dJG())
        {
          paramView = "groupmessage";
          localObject4 = com.tencent.mm.pluginsdk.model.app.p.H((String)localObject1, paramView);
          paramView = ((j.b)localObject2).url;
          localObject1 = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject2).appId);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("rawUrl", (String)localObject4);
          ((Intent)localObject3).putExtra("webpageTitle", ((j.b)localObject2).title);
          if ((((j.b)localObject2).appId != null) && (("wx751a1acca5688ba3".equals(((j.b)localObject2).appId)) || ("wxfbc915ff7c30e335".equals(((j.b)localObject2).appId)) || ("wx482a4001c37e2b74".equals(((j.b)localObject2).appId))))
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("jsapi_args_appid", ((j.b)localObject2).appId);
            ((Intent)localObject3).putExtra("jsapiargs", (Bundle)localObject4);
          }
          if (bo.isNullOrNil(paramView)) {
            break label5088;
          }
          ((Intent)localObject3).putExtra("shortUrl", paramView);
          label4627:
          if (localObject1 != null) {
            break label5105;
          }
          paramView = null;
          label4634:
          ((Intent)localObject3).putExtra("version_name", paramView);
          if (localObject1 != null) {
            break label5114;
          }
          i = 0;
          label4652:
          ((Intent)localObject3).putExtra("version_code", i);
          if (!bo.isNullOrNil(((j.b)localObject2).cGN))
          {
            ((Intent)localObject3).putExtra("srcUsername", ((j.b)localObject2).cGN);
            ((Intent)localObject3).putExtra("srcDisplayname", ((j.b)localObject2).cGO);
          }
          ((Intent)localObject3).putExtra("msg_id", parambi.field_msgId);
          ((Intent)localObject3).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
          ((Intent)localObject3).putExtra("KAppId", ((j.b)localObject2).appId);
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
          }
        }
        for (;;)
        {
          ((Intent)localObject3).putExtra("share_report_pre_msg_url", ((j.b)localObject2).url);
          ((Intent)localObject3).putExtra("share_report_pre_msg_title", ((j.b)localObject2).title);
          ((Intent)localObject3).putExtra("share_report_pre_msg_desc", ((j.b)localObject2).description);
          ((Intent)localObject3).putExtra("share_report_pre_msg_icon_url", ((j.b)localObject2).thumburl);
          ((Intent)localObject3).putExtra("share_report_pre_msg_appid", ((j.b)localObject2).appId);
          ((Intent)localObject3).putExtra("share_report_from_scene", i);
          if (i == 5) {
            ((Intent)localObject3).putExtra("share_report_biz_username", parama.getTalkerUserName());
          }
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
          AppMethodBeat.o(32857);
          return true;
          paramView = "singlemessage";
          break;
          label5088:
          ((Intent)localObject3).putExtra("shortUrl", ((j.b)localObject2).url);
          break label4627;
          label5105:
          paramView = ((PackageInfo)localObject1).versionName;
          break label4634;
          label5114:
          i = ((PackageInfo)localObject1).versionCode;
          break label4652;
          i = 2;
          continue;
          i = 3;
          continue;
          i = 5;
        }
      }
    }
    AppMethodBeat.o(32857);
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e
 * JD-Core Version:    0.7.0.1
 */