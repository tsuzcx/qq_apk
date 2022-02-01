package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.g.b.a.no.a;
import com.tencent.mm.g.b.a.no.b;
import com.tencent.mm.g.b.a.no.c;
import com.tencent.mm.g.b.a.no.d;
import com.tencent.mm.g.b.a.no.e;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.protocal.protobuf.elo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.t.n;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class aj
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37109);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493549);
        ((View)localObject).setTag(new aj.d().S((View)localObject, true));
      }
      AppMethodBeat.o(37109);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37110);
      this.PhN = parama1;
      final aj.d locald = (aj.d)parama;
      parama = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      parama.bX(paramca);
      parama.bY(paramca);
      parama.bZ(paramca);
      parama = paramca.field_content;
      bq localbq;
      Object localObject;
      if (parama != null)
      {
        parama = k.b.aD(parama, paramca.field_reserved);
        localbq = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
        if (parama != null)
        {
          locald.PHX.setVisibility(8);
          locald.PHW.setVisibility(8);
          locald.PIu.setVisibility(8);
          parama.as(com.tencent.mm.ag.h.class);
          locald.clickArea.setBackgroundResource(2131231798);
          localObject = com.tencent.mm.pluginsdk.model.app.h.gE(parama.appId, parama.appVersion);
          if (localObject != null) {
            b(parama1, parama, paramca);
          }
          if ((parama.fQR != null) && (parama.fQR.length() != 0)) {
            break label887;
          }
          locald.PHZ.setVisibility(8);
          label191:
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(parama.izi);
          locald.PIc.setVisibility(0);
          locald.PHT.setVisibility(8);
          locald.PIf.setVisibility(0);
          locald.PId.setVisibility(8);
          if (localWxaAttributes == null) {
            break label916;
          }
          paramString = localWxaAttributes.field_nickname;
          label260:
          locald.PIs.setText(paramString);
          if (localWxaAttributes == null) {
            break label925;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label282:
          com.tencent.mm.av.q.bcV().a(paramString, locald.PIr, aj.d.gvY);
          locald.PIu.setVisibility(0);
          locald.PLT.setVisibility(8);
          locald.PLT.setText(parama.description);
          locald.PIy.setText(parama.title);
          switch (parama.izz)
          {
          default: 
            locald.PIt.setText(2131755440);
            label378:
            com.tencent.mm.av.q.bcV().a(paramString, locald.PIr, aj.d.gvY);
            if (!parama1.gRM()) {
              if (com.tencent.mm.pluginsdk.model.app.h.k((com.tencent.mm.pluginsdk.model.app.g)localObject))
              {
                locald.PIb.setVisibility(0);
                c(parama1, locald.PIb, bq.a(parama, paramca));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramca = com.tencent.mm.av.q.bcR().d(paramca.field_imgPath, false, true);
        locald.PIv.setImageBitmap(null);
        locald.PIv.setVisibility(4);
        locald.PIx.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
        {
          public final void I(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(37106);
            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
            {
              locald.PIv.setImageBitmap(paramAnonymousBitmap);
              locald.PIv.setVisibility(0);
              locald.PIx.setVisibility(4);
              AppMethodBeat.o(37106);
              return;
            }
            locald.PIv.setVisibility(4);
            locald.PIx.setVisibility(0);
            AppMethodBeat.o(37106);
          }
          
          public final String Lb()
          {
            AppMethodBeat.i(37107);
            String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
            AppMethodBeat.o(37107);
            return str;
          }
          
          public final void aYg() {}
          
          public final void oD() {}
        }, "file://".concat(String.valueOf(paramca)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
        locald.PMb.setVisibility(8);
        locald.PMb.setTag(Util.nullAs(parama.izo, ""));
        locald.PMc.setVisibility(8);
        paramca = (com.tencent.mm.ag.a)parama.as(com.tencent.mm.ag.a.class);
        if ((paramca != null) && (paramca.iuT))
        {
          paramString = parama.izo;
          localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq(paramString);
          aj.a(parama1, locald, paramca, (com.tencent.mm.ag.a.c)localObject);
          aj.a(parama1, locald, paramca, parama, (com.tencent.mm.ag.a.c)localObject);
          int i = paramca.iva;
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (((com.tencent.mm.ag.a.c)localObject).field_updatePeroid != 0) {
              paramInt = ((com.tencent.mm.ag.a.c)localObject).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).a(aj.e.cO(parama1), parama.izj, paramString, paramInt, new m.a()
            {
              public final void a(String paramAnonymousString, elo paramAnonymouselo)
              {
                AppMethodBeat.i(37108);
                Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymouselo.content });
                if (locald.PMb == null)
                {
                  Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                String str = (String)locald.PMb.getTag();
                if (Util.isNullOrNil(str))
                {
                  Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                if (str.equals(paramAnonymousString))
                {
                  locald.PMb.setVisibility(0);
                  locald.PMb.setText(paramAnonymouselo.content);
                  locald.PMb.setTextColor(Util.convertStringToRGB(paramAnonymouselo.MXr, locald.PMb.getCurrentTextColor()));
                  if (paramAnonymouselo.state == 1)
                  {
                    paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq(paramAnonymousString);
                    if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                    {
                      if (Util.isNullOrNil(paramca.iuZ))
                      {
                        locald.PMc.setVisibility(8);
                        AppMethodBeat.o(37108);
                        return;
                      }
                      locald.PMc.setVisibility(0);
                      locald.PMc.setText(paramca.iuZ);
                    }
                  }
                }
                AppMethodBeat.o(37108);
              }
            });
          }
        }
        ((w)com.tencent.mm.kernel.g.af(w.class)).VA(parama.izi);
        locald.clickArea.setTag(localbq);
        locald.clickArea.setOnClickListener(d(parama1));
        paramString = ad.aVe().G(aj.e.cO(parama1), true);
        paramca = (aj.c)paramString.get("listener", null);
        parama = paramca;
        if (paramca == null)
        {
          parama = new aj.c();
          paramString.l("listener", parama);
        }
        parama.n(parama1);
        if (this.qoo)
        {
          locald.clickArea.setOnLongClickListener(c(parama1));
          locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        }
        AppMethodBeat.o(37110);
        return;
        Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
        parama = null;
        break;
        label887:
        locald.PHZ.setVisibility(0);
        b(parama1, locald.PHZ, bq.bnn(parama.fQR));
        break label191;
        label916:
        paramString = parama.eah;
        break label260;
        label925:
        paramString = parama.izB;
        break label282;
        locald.PIt.setText(2131755704);
        break label378;
        locald.PIt.setText(2131755703);
        break label378;
        locald.PIb.setVisibility(8);
        continue;
        locald.PIb.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37112);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37112);
        return false;
      }
      e.b.a(parama, paramca, a(parama, paramca));
      AppMethodBeat.o(37112);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233814);
      int i = ((bq)paramView.getTag()).position;
      k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bm(paramca)))
      {
        if (localb.type != 6) {
          break label264;
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.bdJ(localb.dCK);
        if (((localObject == null) || (!e.b.h(paramca, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramca.gDB())) {
          paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        }
      }
      for (;;)
      {
        localObject = new ef();
        ((ef)localObject).dHy.msgId = paramca.field_msgId;
        EventCenter.instance.publish((IEvent)localObject);
        if ((((ef)localObject).dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
          paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
        }
        if (!this.PhN.gRN()) {
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
        }
        AppMethodBeat.o(233814);
        return true;
        label264:
        paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37113);
      com.tencent.mm.modelstat.a.a(paramca, a.a.jma);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      if (paramca.field_content == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      paramView = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      if (paramView == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, false, false);
      if (localObject1 != null) {
        a(parama, paramView, d(parama, paramca), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.izi, paramView.izh, paramView.izj, paramView.url, Integer.valueOf(paramView.izz), paramView.izl });
      localObject1 = new wq();
      ((wq)localObject1).ecI.appId = paramView.izj;
      ((wq)localObject1).ecI.userName = paramView.izi;
      ((wq)localObject1).ecI.ecK = paramView.izh;
      ((wq)localObject1).ecI.ecL = paramView.izz;
      ((wq)localObject1).ecI.ecO = paramView.izl;
      ((wq)localObject1).ecI.appVersion = paramView.izA;
      Object localObject2 = ((wq)localObject1).ecI;
      boolean bool;
      StringBuilder localStringBuilder;
      if (paramView.izz != 0)
      {
        bool = true;
        ((wq.a)localObject2).ecP = bool;
        ((wq)localObject1).ecI.ecR.cyq = parama.getTalkerUserName();
        ((wq)localObject1).ecI.ecR.cyr = paramView.izo;
        localObject2 = paramView.izn;
        if (!parama.gRM()) {
          break label429;
        }
        ((wq)localObject1).ecI.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(a(parama, paramca));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
      for (((wq)localObject1).ecI.dCw = localStringBuilder.toString();; ((wq)localObject1).ecI.dCw = paramca.toString())
      {
        aj.c((wq)localObject1, paramView);
        EventCenter.instance.publish((IEvent)localObject1);
        aj.a(parama, paramView);
        AppMethodBeat.o(37113);
        return true;
        bool = false;
        break;
        label429:
        ((wq)localObject1).ecI.scene = 1007;
        paramca = new StringBuilder(a(parama, paramca));
        paramca.append(":");
        paramca.append((String)localObject2);
      }
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37117);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493600);
        ((View)localObject).setTag(new aj.d().S((View)localObject, false));
      }
      AppMethodBeat.o(37117);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37118);
      final aj.d locald = (aj.d)parama;
      this.PhN = parama1;
      paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      paramString.bZ(paramca);
      Object localObject1 = paramca.field_content;
      paramString.bX(paramca);
      if (localObject1 != null) {}
      label270:
      label795:
      label805:
      for (paramString = k.b.aD((String)localObject1, paramca.field_reserved);; paramString = null)
      {
        bq localbq = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
        Object localObject2;
        if (paramString != null)
        {
          locald.PHX.setVisibility(8);
          locald.PHW.setVisibility(8);
          locald.PHT.setVisibility(8);
          locald.PIu.setVisibility(8);
          localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString.izi);
          if (localObject2 == null) {
            break label795;
          }
          localObject1 = ((WxaAttributes)localObject2).field_nickname;
          if (localObject2 == null) {
            break label805;
          }
          localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
          label176:
          locald.PIu.setVisibility(0);
          locald.PLT.setVisibility(8);
          locald.PIy.setText(paramString.title);
          locald.PLT.setText(paramString.description);
          locald.PIs.setText((CharSequence)localObject1);
          switch (paramString.izz)
          {
          default: 
            locald.PIt.setText(2131755440);
            com.tencent.mm.av.q.bcV().a((String)localObject2, locald.PIr, aj.d.gvY);
            if (gTW())
            {
              localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
              if ((paramca.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, paramca.field_msgId))) {
                if (locald.PIn != null) {
                  locald.PIn.setVisibility(0);
                }
              }
            }
            break;
          }
        }
        label342:
        label882:
        for (;;)
        {
          boolean bool = false;
          for (localObject1 = this;; localObject1 = this)
          {
            ((b)localObject1).b(parama, bool);
            parama = com.tencent.mm.av.q.bcR().d(paramca.field_imgPath, false, true);
            locald.PIv.setImageBitmap(null);
            locald.PIv.setVisibility(4);
            locald.PIx.setVisibility(0);
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
            {
              public final void I(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(37114);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  locald.PIv.setImageBitmap(paramAnonymousBitmap);
                  locald.PIv.setVisibility(0);
                  locald.PIx.setVisibility(4);
                  AppMethodBeat.o(37114);
                  return;
                }
                locald.PIv.setVisibility(4);
                locald.PIx.setVisibility(0);
                AppMethodBeat.o(37114);
              }
              
              public final String Lb()
              {
                AppMethodBeat.i(37115);
                String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                AppMethodBeat.o(37115);
                return str;
              }
              
              public final void aYg() {}
              
              public final void oD() {}
            }, "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
            locald.PMb.setVisibility(8);
            locald.PMb.setTag(Util.nullAs(paramString.izo, ""));
            locald.PMc.setVisibility(8);
            parama = (com.tencent.mm.ag.a)paramString.as(com.tencent.mm.ag.a.class);
            if ((parama != null) && (parama.iuT))
            {
              localObject1 = paramString.izo;
              localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq((String)localObject1);
              aj.a(parama1, locald, parama, (com.tencent.mm.ag.a.c)localObject2);
              aj.a(parama1, locald, parama, paramString, (com.tencent.mm.ag.a.c)localObject2);
              int j = parama.iva;
              int i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((com.tencent.mm.ag.a.c)localObject2).field_updatePeroid != 0) {
                  i = ((com.tencent.mm.ag.a.c)localObject2).field_updatePeroid;
                }
              }
              if (i > 0) {
                ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).a(aj.e.cO(parama1), paramString.izj, (String)localObject1, i, new m.a()
                {
                  public final void a(String paramAnonymousString, elo paramAnonymouselo)
                  {
                    AppMethodBeat.i(37116);
                    Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymouselo.content });
                    if (locald.PMb == null)
                    {
                      Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    String str = (String)locald.PMb.getTag();
                    if (Util.isNullOrNil(str))
                    {
                      Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    if (str.equals(paramAnonymousString))
                    {
                      locald.PMb.setVisibility(0);
                      locald.PMb.setText(paramAnonymouselo.content);
                      locald.PMb.setTextColor(Util.convertStringToRGB(paramAnonymouselo.MXr, locald.PMb.getCurrentTextColor()));
                      if (paramAnonymouselo.state == 1)
                      {
                        paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq(paramAnonymousString);
                        if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                        {
                          if (Util.isNullOrNil(parama.iuZ))
                          {
                            locald.PMc.setVisibility(8);
                            AppMethodBeat.o(37116);
                            return;
                          }
                          locald.PMc.setVisibility(0);
                          locald.PMc.setText(parama.iuZ);
                        }
                      }
                    }
                    AppMethodBeat.o(37116);
                  }
                });
              }
            }
            ((w)com.tencent.mm.kernel.g.af(w.class)).VA(paramString.izi);
            locald.clickArea.setTag(localbq);
            locald.clickArea.setOnClickListener(d(parama1));
            localObject1 = ad.aVe().G(aj.e.cO(parama1), true);
            paramString = (aj.c)((ad.b)localObject1).get("listener", null);
            parama = paramString;
            if (paramString == null)
            {
              parama = new aj.c();
              ((ad.b)localObject1).l("listener", parama);
            }
            parama.n(parama1);
            if (this.qoo)
            {
              locald.clickArea.setOnLongClickListener(c(parama1));
              locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            a(paramInt, locald, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
            AppMethodBeat.o(37118);
            return;
            localObject1 = paramString.eah;
            break;
            localObject2 = paramString.izB;
            break label176;
            locald.PIt.setText(2131755704);
            break label270;
            locald.PIt.setText(2131755703);
            break label270;
            if (locald.PIn == null) {
              break label342;
            }
            locald.PIn.setVisibility(8);
            break label342;
            if (paramca.field_status >= 2) {
              break label882;
            }
            bool = true;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37120);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37120);
        return false;
      case 111: 
        e.b.a(parama, paramca, a(parama, paramca));
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = paramca.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = k.b.HD(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37120);
        return false;
        parama = new kj();
        parama.dPt.dPu = paramMenuItem.dPu;
        parama.dPt.dFm = paramca.field_msgId;
        parama.dPt.dPv = paramca.field_talker;
        EventCenter.instance.publish(parama);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233815);
      int i = ((bq)paramView.getTag()).position;
      if (paramca.field_content == null)
      {
        AppMethodBeat.o(233815);
        return true;
      }
      k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(233815);
        return true;
      }
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bm(paramca))) {
        paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      ef localef = new ef();
      localef.dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localef);
      if ((localef.dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      }
      AppMethodBeat.o(233815);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233816);
      if (paramca.dOQ())
      {
        com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
        bp.Ad(paramca.field_msgId);
        parama.BN(true);
        AppMethodBeat.o(233816);
        return;
      }
      AppMethodBeat.o(233816);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37121);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      paramView.getTag();
      paramView = paramca.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      paramView = k.b.HD(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
        a(parama, paramView, z.aTY(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      localObject1 = new wq();
      ((wq)localObject1).ecI.appId = paramView.izj;
      ((wq)localObject1).ecI.userName = paramView.izi;
      ((wq)localObject1).ecI.ecK = paramView.izh;
      ((wq)localObject1).ecI.ecL = paramView.izz;
      ((wq)localObject1).ecI.ecO = paramView.izl;
      ((wq)localObject1).ecI.appVersion = paramView.izA;
      Object localObject2 = ((wq)localObject1).ecI;
      boolean bool;
      StringBuilder localStringBuilder;
      if (paramView.izz != 0)
      {
        bool = true;
        ((wq.a)localObject2).ecP = bool;
        localObject2 = paramView.izn;
        if (!parama.gRM()) {
          break label365;
        }
        ((wq)localObject1).ecI.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(a(parama, paramca));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
      for (((wq)localObject1).ecI.dCw = localStringBuilder.toString();; ((wq)localObject1).ecI.dCw = paramca.toString())
      {
        ((wq)localObject1).ecI.ecR.cyq = parama.getTalkerUserName();
        ((wq)localObject1).ecI.ecR.cyr = paramView.izo;
        aj.c((wq)localObject1, paramView);
        EventCenter.instance.publish((IEvent)localObject1);
        aj.a(parama, paramView);
        AppMethodBeat.o(37121);
        return true;
        bool = false;
        break;
        label365:
        ((wq)localObject1).ecI.scene = 1007;
        paramca = new StringBuilder(a(parama, paramca));
        paramca.append(":");
        paramca.append((String)localObject2);
      }
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  static final class c
    implements com.tencent.mm.ui.m
  {
    private WeakReference<com.tencent.mm.ui.chatting.e.a> pvS;
    
    public final void cFx()
    {
      AppMethodBeat.i(37124);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).aXM();
      AppMethodBeat.o(37124);
    }
    
    public final void cFy()
    {
      AppMethodBeat.i(37125);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).aXN();
      AppMethodBeat.o(37125);
    }
    
    public final void gIk() {}
    
    public final void gIl() {}
    
    public final void gIm() {}
    
    public final void gIn()
    {
      AppMethodBeat.i(37126);
      Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.pvS == null)
      {
        AppMethodBeat.o(37126);
        return;
      }
      com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)this.pvS.get();
      if (locala != null)
      {
        ad.aVe().JW(aj.e.cO(locala));
        ((j)locala.bh(j.class)).b(this);
        ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lr(aj.e.cO(locala));
      }
      AppMethodBeat.o(37126);
    }
    
    public final void gIo() {}
    
    final void n(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37123);
      this.pvS = new WeakReference(parama);
      ((j)parama.bh(j.class)).a(this);
      AppMethodBeat.o(37123);
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int PLR;
    public static final int PLS;
    static com.tencent.mm.av.a.a.c gvY;
    protected ImageView PHT;
    protected ImageView PHW;
    protected ImageView PHX;
    protected TextView PHZ;
    protected ChattingItemFooter PIa;
    protected ImageView PIb;
    protected LinearLayout PIc;
    protected ViewGroup PId;
    protected TextView PIe;
    protected LinearLayout PIf;
    ImageView PIn;
    protected ImageView PIr;
    protected TextView PIs;
    protected TextView PIt;
    protected LinearLayout PIu;
    protected ImageView PIv;
    protected ImageView PIx;
    protected TextView PIy;
    protected TextView PLT;
    protected TextView PMb;
    protected TextView PMc;
    
    static
    {
      AppMethodBeat.i(37128);
      PLR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 240);
      PLS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 192);
      com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
      locala.jbq = 2131689602;
      locala.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20)).jbd = true;
      gvY = locala.bdv();
      AppMethodBeat.o(37128);
    }
    
    public final d S(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37127);
      super.create(paramView);
      this.PHT = ((ImageView)paramView.findViewById(2131298386));
      this.PHW = ((ImageView)this.convertView.findViewById(2131298421));
      this.PHX = ((ImageView)this.convertView.findViewById(2131298557));
      this.PHZ = ((TextView)paramView.findViewById(2131298364));
      this.PIb = ((ImageView)paramView.findViewById(2131298380));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.PIa = ((ChattingItemFooter)paramView.findViewById(2131301661));
      this.PIc = ((LinearLayout)paramView.findViewById(2131296956));
      this.PId = ((ViewGroup)paramView.findViewById(2131303752));
      this.PIe = ((TextView)paramView.findViewById(2131303749));
      this.PIf = ((LinearLayout)paramView.findViewById(2131298394));
      this.clickArea = paramView.findViewById(2131298411);
      if (!paramBoolean)
      {
        this.PIn = ((ImageView)this.convertView.findViewById(2131298556));
        this.uploadingPB = ((ProgressBar)this.convertView.findViewById(2131309619));
      }
      this.PIu = ((LinearLayout)paramView.findViewById(2131298346));
      this.PIv = ((ImageView)paramView.findViewById(2131298347));
      this.PIx = ((ImageView)paramView.findViewById(2131300157));
      this.PIy = ((TextView)paramView.findViewById(2131298357));
      this.PLT = ((TextView)paramView.findViewById(2131298348));
      this.PMb = ((TextView)paramView.findViewById(2131298363));
      this.PIr = ((ImageView)paramView.findViewById(2131298359));
      this.PIs = ((TextView)paramView.findViewById(2131298361));
      this.PIt = ((TextView)paramView.findViewById(2131298360));
      this.PMc = ((TextView)paramView.findViewById(2131298362));
      AppMethodBeat.o(37127);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return this.PIf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj
 * JD-Core Version:    0.7.0.1
 */