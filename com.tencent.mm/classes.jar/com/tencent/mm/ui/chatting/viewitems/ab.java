package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.g.b.a.gr.a;
import com.tencent.mm.g.b.a.gr.b;
import com.tencent.mm.g.b.a.gr.c;
import com.tencent.mm.g.b.a.gr.d;
import com.tencent.mm.g.b.a.gr.e;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import java.util.Locale;

public final class ab
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493448);
        ((View)localObject).setTag(new ab.d().G((View)localObject, true));
      }
      AppMethodBeat.o(37109);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, String paramString)
    {
      AppMethodBeat.i(37110);
      this.Gob = parama1;
      final ab.d locald = (ab.d)parama;
      parama = (com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class);
      parama.bA(parambl);
      parama.bB(parambl);
      parama.bC(parambl);
      parama = parambl.field_content;
      bi localbi;
      Object localObject;
      if (parama != null)
      {
        parama = k.b.ar(parama, parambl.field_reserved);
        localbi = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        if (parama != null)
        {
          locald.GIS.setVisibility(8);
          locald.GIR.setVisibility(8);
          locald.GJp.setVisibility(8);
          parama.ao(com.tencent.mm.ai.h.class);
          locald.naN.setBackground(ao.aC(parama1.GzJ.getContext(), 2130968737));
          localObject = com.tencent.mm.pluginsdk.model.app.h.fv(parama.appId, parama.aAS);
          if (localObject != null) {
            b(parama1, parama, parambl);
          }
          if ((parama.eOT != null) && (parama.eOT.length() != 0)) {
            break label896;
          }
          locald.GIU.setVisibility(8);
          label201:
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(parama.gJE);
          locald.GIX.setVisibility(0);
          locald.GIO.setVisibility(8);
          locald.GJa.setVisibility(0);
          locald.GIY.setVisibility(8);
          if (localWxaAttributes == null) {
            break label925;
          }
          paramString = localWxaAttributes.field_nickname;
          label270:
          locald.GJn.setText(paramString);
          if (localWxaAttributes == null) {
            break label934;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label292:
          o.ayJ().a(paramString, locald.GJm, ab.d.frV);
          locald.GJp.setVisibility(0);
          locald.GMB.setVisibility(8);
          locald.GMB.setText(parama.description);
          locald.GJt.setText(parama.title);
          switch (parama.gJQ)
          {
          default: 
            locald.GJo.setText(2131755401);
            label387:
            o.ayJ().a(paramString, locald.GJm, ab.d.frV);
            if (!parama1.eZb()) {
              if (com.tencent.mm.pluginsdk.model.app.h.k((com.tencent.mm.pluginsdk.model.app.g)localObject))
              {
                locald.GIW.setVisibility(0);
                c(parama1, locald.GIW, bi.a(parama, parambl));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        parambl = o.ayF().b(parambl.field_imgPath, false, true);
        locald.GJq.setImageBitmap(null);
        locald.GJq.setVisibility(4);
        locald.GJs.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
        {
          public final String AL()
          {
            AppMethodBeat.i(37107);
            String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
            AppMethodBeat.o(37107);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(37106);
            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
            {
              locald.GJq.setImageBitmap(paramAnonymousBitmap);
              locald.GJq.setVisibility(0);
              locald.GJs.setVisibility(4);
              AppMethodBeat.o(37106);
              return;
            }
            locald.GJq.setVisibility(4);
            locald.GJs.setVisibility(0);
            AppMethodBeat.o(37106);
          }
          
          public final void auj() {}
          
          public final void nV() {}
        }, "file://".concat(String.valueOf(parambl)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
        locald.GMJ.setVisibility(8);
        locald.GMJ.setTag(bt.by(parama.gJK, ""));
        locald.GMK.setVisibility(8);
        parambl = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
        if ((parambl != null) && (parambl.gFp))
        {
          paramString = parama.gJK;
          localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).uY(paramString);
          ab.a(parama1, locald, parambl, (com.tencent.mm.ai.a.c)localObject);
          ab.a(parama1, locald, parambl, parama, (com.tencent.mm.ai.a.c)localObject);
          int i = parambl.gFw;
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (((com.tencent.mm.ai.a.c)localObject).field_updatePeroid != 0) {
              paramInt = ((com.tencent.mm.ai.a.c)localObject).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ab.e.cF(parama1), parama.gJF, paramString, paramInt, new m.a()
            {
              public final void a(String paramAnonymousString, dfn paramAnonymousdfn)
              {
                AppMethodBeat.i(37108);
                ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdfn.content });
                if (locald.GMJ == null)
                {
                  ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                String str = (String)locald.GMJ.getTag();
                if (bt.isNullOrNil(str))
                {
                  ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                if (str.equals(paramAnonymousString))
                {
                  locald.GMJ.setVisibility(0);
                  locald.GMJ.setText(paramAnonymousdfn.content);
                  locald.GMJ.setTextColor(bt.cB(paramAnonymousdfn.EkA, locald.GMJ.getCurrentTextColor()));
                  if (paramAnonymousdfn.state == 1)
                  {
                    paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).uY(paramAnonymousString);
                    if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                    {
                      if (bt.isNullOrNil(parambl.gFv))
                      {
                        locald.GMK.setVisibility(8);
                        AppMethodBeat.o(37108);
                        return;
                      }
                      locald.GMK.setVisibility(0);
                      locald.GMK.setText(parambl.gFv);
                    }
                  }
                }
                AppMethodBeat.o(37108);
              }
            });
          }
        }
        ((q)com.tencent.mm.kernel.g.ab(q.class)).Ew(parama.gJE);
        locald.naN.setTag(localbi);
        locald.naN.setOnClickListener(d(parama1));
        paramString = y.arz().E(ab.e.cF(parama1), true);
        parambl = (ab.c)paramString.get("listener", null);
        parama = parambl;
        if (parambl == null)
        {
          parama = new ab.c();
          paramString.m("listener", parama);
        }
        parama.n(parama1);
        if (this.nMt)
        {
          locald.naN.setOnLongClickListener(c(parama1));
          locald.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        }
        AppMethodBeat.o(37110);
        return;
        ad.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramString });
        parama = null;
        break;
        label896:
        locald.GIU.setVisibility(0);
        b(parama1, locald.GIU, bi.aLk(parama.eOT));
        break label201;
        label925:
        paramString = parama.dxA;
        break label270;
        label934:
        paramString = parama.gJS;
        break label292;
        locald.GJo.setText(2131755657);
        break label387;
        locald.GJo.setText(2131755656);
        break label387;
        locald.GIW.setVisibility(8);
        continue;
        locald.GIW.setVisibility(8);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37111);
      int i = ((bi)paramView.getTag()).position;
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false))) && (!j.aS(parambl)))
      {
        if (localb.type != 6) {
          break label264;
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.aAV(localb.dbA);
        if (((localObject == null) || (!e.b.e(parambl, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambl.eMl())) {
          paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
        }
      }
      for (;;)
      {
        localObject = new dx();
        ((dx)localObject).dgp.msgId = parambl.field_msgId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((dx)localObject).dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
          paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(37111);
        return true;
        label264:
        paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37112);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37112);
        return false;
      }
      e.b.a(parama, parambl, b(parama, parambl));
      AppMethodBeat.o(37112);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37113);
      com.tencent.mm.modelstat.a.a(parambl, a.a.htZ);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      if (parambl.field_content == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      paramView = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      if (paramView == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.j(paramView.appId, false, false);
      if (localObject1 != null) {
        a(parama, paramView, d(parama, parambl), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambl.field_msgSvrId, parama.getTalkerUserName());
      }
      ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.gJE, paramView.gJD, paramView.gJF, paramView.url, Integer.valueOf(paramView.gJQ), paramView.gJH });
      localObject1 = new uj();
      ((uj)localObject1).dzH.appId = paramView.gJF;
      ((uj)localObject1).dzH.userName = paramView.gJE;
      ((uj)localObject1).dzH.dzJ = paramView.gJD;
      ((uj)localObject1).dzH.dzK = paramView.gJQ;
      ((uj)localObject1).dzH.dzM = paramView.gJH;
      ((uj)localObject1).dzH.aAS = paramView.gJR;
      Object localObject2 = ((uj)localObject1).dzH;
      boolean bool;
      StringBuilder localStringBuilder;
      if (paramView.gJQ != 0)
      {
        bool = true;
        ((uj.a)localObject2).dzN = bool;
        ((uj)localObject1).dzH.dzP.cff = parama.getTalkerUserName();
        ((uj)localObject1).dzH.dzP.cfh = paramView.gJK;
        localObject2 = paramView.gJJ;
        if (!parama.eZb()) {
          break label423;
        }
        ((uj)localObject1).dzH.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(b(parama, parambl));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
      for (((uj)localObject1).dzH.dbt = localStringBuilder.toString();; ((uj)localObject1).dzH.dbt = parambl.toString())
      {
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        ab.a(parama, paramView);
        AppMethodBeat.o(37113);
        return true;
        bool = false;
        break;
        label423:
        ((uj)localObject1).dzH.scene = 1007;
        parambl = new StringBuilder(b(parama, parambl));
        parambl.append(":");
        parambl.append((String)localObject2);
      }
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493492);
        ((View)localObject).setTag(new ab.d().G((View)localObject, false));
      }
      AppMethodBeat.o(37117);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37122);
      if (parambl.cxB())
      {
        com.tencent.mm.pluginsdk.model.app.m.aB(parambl);
        com.tencent.mm.model.bi.lW(parambl.field_msgId);
        parama.wc(true);
        AppMethodBeat.o(37122);
        return;
      }
      AppMethodBeat.o(37122);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, final String paramString)
    {
      AppMethodBeat.i(37118);
      final ab.d locald = (ab.d)parama;
      this.Gob = parama1;
      parama = (com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class);
      parama.bC(parambl);
      paramString = parambl.field_content;
      parama.bA(parambl);
      if (paramString != null) {}
      for (parama = k.b.ar(paramString, parambl.field_reserved);; parama = null)
      {
        bi localbi = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        Object localObject;
        if (parama != null)
        {
          locald.GIS.setVisibility(8);
          locald.GIR.setVisibility(8);
          locald.GIO.setVisibility(8);
          locald.GJp.setVisibility(8);
          localObject = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(parama.gJE);
          if (localObject == null) {
            break label791;
          }
          paramString = ((WxaAttributes)localObject).field_nickname;
          if (localObject == null) {
            break label800;
          }
          localObject = ((WxaAttributes)localObject).field_smallHeadURL;
          label170:
          locald.GJp.setVisibility(0);
          locald.GMB.setVisibility(8);
          locald.GJt.setText(parama.title);
          locald.GMB.setText(parama.description);
          locald.GJn.setText(paramString);
          switch (parama.gJQ)
          {
          default: 
            locald.GJo.setText(2131755401);
            label258:
            o.ayJ().a((String)localObject, locald.GJm, ab.d.frV);
            if (faG())
            {
              paramString = (i)parama1.be(i.class);
              if ((parambl.field_status == 2) && (a(paramString, parambl.field_msgId)))
              {
                if (locald.GJi != null) {
                  locald.GJi.setVisibility(0);
                }
                label330:
                if (locald.uPp != null) {
                  locald.uPp.setVisibility(8);
                }
              }
            }
            break;
          }
        }
        for (;;)
        {
          paramString = o.ayF().b(parambl.field_imgPath, false, true);
          locald.GJq.setImageBitmap(null);
          locald.GJq.setVisibility(4);
          locald.GJs.setVisibility(0);
          com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
          {
            public final String AL()
            {
              AppMethodBeat.i(37115);
              String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
              AppMethodBeat.o(37115);
              return str;
            }
            
            public final void E(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(37114);
              if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
              {
                locald.GJq.setImageBitmap(paramAnonymousBitmap);
                locald.GJq.setVisibility(0);
                locald.GJs.setVisibility(4);
                AppMethodBeat.o(37114);
                return;
              }
              locald.GJq.setVisibility(4);
              locald.GJs.setVisibility(0);
              AppMethodBeat.o(37114);
            }
            
            public final void auj() {}
            
            public final void nV() {}
          }, "file://".concat(String.valueOf(paramString)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
          locald.GMJ.setVisibility(8);
          locald.GMJ.setTag(bt.by(parama.gJK, ""));
          locald.GMK.setVisibility(8);
          paramString = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
          if ((paramString != null) && (paramString.gFp))
          {
            localObject = parama.gJK;
            com.tencent.mm.ai.a.c localc = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).uY((String)localObject);
            ab.a(parama1, locald, paramString, localc);
            ab.a(parama1, locald, paramString, parama, localc);
            int j = paramString.gFw;
            int i = j;
            if (localc != null)
            {
              i = j;
              if (localc.field_updatePeroid != 0) {
                i = localc.field_updatePeroid;
              }
            }
            if (i > 0) {
              ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ab.e.cF(parama1), parama.gJF, (String)localObject, i, new m.a()
              {
                public final void a(String paramAnonymousString, dfn paramAnonymousdfn)
                {
                  AppMethodBeat.i(37116);
                  ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdfn.content });
                  if (locald.GMJ == null)
                  {
                    ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                    AppMethodBeat.o(37116);
                    return;
                  }
                  String str = (String)locald.GMJ.getTag();
                  if (bt.isNullOrNil(str))
                  {
                    ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                    AppMethodBeat.o(37116);
                    return;
                  }
                  if (str.equals(paramAnonymousString))
                  {
                    locald.GMJ.setVisibility(0);
                    locald.GMJ.setText(paramAnonymousdfn.content);
                    locald.GMJ.setTextColor(bt.cB(paramAnonymousdfn.EkA, locald.GMJ.getCurrentTextColor()));
                    if (paramAnonymousdfn.state == 1)
                    {
                      paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).uY(paramAnonymousString);
                      if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                      {
                        if (bt.isNullOrNil(paramString.gFv))
                        {
                          locald.GMK.setVisibility(8);
                          AppMethodBeat.o(37116);
                          return;
                        }
                        locald.GMK.setVisibility(0);
                        locald.GMK.setText(paramString.gFv);
                      }
                    }
                  }
                  AppMethodBeat.o(37116);
                }
              });
            }
          }
          ((q)com.tencent.mm.kernel.g.ab(q.class)).Ew(parama.gJE);
          locald.naN.setTag(localbi);
          locald.naN.setOnClickListener(d(parama1));
          localObject = y.arz().E(ab.e.cF(parama1), true);
          paramString = (ab.c)((y.b)localObject).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ab.c();
            ((y.b)localObject).m("listener", parama);
          }
          parama.n(parama1);
          if (this.nMt)
          {
            locald.naN.setOnLongClickListener(c(parama1));
            locald.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          }
          a(paramInt, locald, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
          AppMethodBeat.o(37118);
          return;
          label791:
          paramString = parama.dxA;
          break;
          label800:
          localObject = parama.gJS;
          break label170;
          locald.GJo.setText(2131755657);
          break label258;
          locald.GJo.setText(2131755656);
          break label258;
          if (locald.GJi == null) {
            break label330;
          }
          locald.GJi.setVisibility(8);
          break label330;
          if (locald.uPp != null)
          {
            locald.uPp.setVisibility(0);
            if (parambl.field_status >= 2) {
              locald.uPp.setVisibility(8);
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37119);
      int i = ((bi)paramView.getTag()).position;
      if (parambl.field_content == null)
      {
        AppMethodBeat.o(37119);
        return true;
      }
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(37119);
        return true;
      }
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false))) && (!j.aS(parambl))) {
        paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
      if (((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      dx localdx = new dx();
      localdx.dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l(localdx);
      if ((localdx.dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      }
      AppMethodBeat.o(37119);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37120);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37120);
        return false;
      case 111: 
        e.b.a(parama, parambl, b(parama, parambl));
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = parambl.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = k.b.rx(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37120);
        return false;
        parama = new je();
        parama.dnm.dnn = paramMenuItem.dnn;
        parama.dnm.ded = parambl.field_msgId;
        parama.dnm.dno = parambl.field_talker;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37121);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      paramView.getTag();
      paramView = parambl.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      paramView = k.b.rx(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.j(paramView.appId, true, false);
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
        a(parama, paramView, u.aqG(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambl.field_msgSvrId, parama.getTalkerUserName());
      }
      localObject1 = new uj();
      ((uj)localObject1).dzH.appId = paramView.gJF;
      ((uj)localObject1).dzH.userName = paramView.gJE;
      ((uj)localObject1).dzH.dzJ = paramView.gJD;
      ((uj)localObject1).dzH.dzK = paramView.gJQ;
      ((uj)localObject1).dzH.dzM = paramView.gJH;
      ((uj)localObject1).dzH.aAS = paramView.gJR;
      Object localObject2 = ((uj)localObject1).dzH;
      boolean bool;
      StringBuilder localStringBuilder;
      if (paramView.gJQ != 0)
      {
        bool = true;
        ((uj.a)localObject2).dzN = bool;
        localObject2 = paramView.gJJ;
        if (!parama.eZb()) {
          break label359;
        }
        ((uj)localObject1).dzH.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(b(parama, parambl));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
      for (((uj)localObject1).dzH.dbt = localStringBuilder.toString();; ((uj)localObject1).dzH.dbt = parambl.toString())
      {
        ((uj)localObject1).dzH.dzP.cff = parama.getTalkerUserName();
        ((uj)localObject1).dzH.dzP.cfh = paramView.gJK;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        ab.a(parama, paramView);
        AppMethodBeat.o(37121);
        return true;
        bool = false;
        break;
        label359:
        ((uj)localObject1).dzH.scene = 1007;
        parambl = new StringBuilder(b(parama, parambl));
        parambl.append(":");
        parambl.append((String)localObject2);
      }
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int GMA;
    public static final int GMz;
    static com.tencent.mm.aw.a.a.c frV;
    protected ImageView GIO;
    protected ImageView GIR;
    protected ImageView GIS;
    protected TextView GIU;
    protected ChattingItemFooter GIV;
    protected ImageView GIW;
    protected LinearLayout GIX;
    protected ViewGroup GIY;
    protected TextView GIZ;
    protected LinearLayout GJa;
    ImageView GJi;
    protected ImageView GJm;
    protected TextView GJn;
    protected TextView GJo;
    protected LinearLayout GJp;
    protected ImageView GJq;
    protected ImageView GJs;
    protected TextView GJt;
    protected TextView GMB;
    protected TextView GMJ;
    protected TextView GMK;
    
    static
    {
      AppMethodBeat.i(37128);
      GMz = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 240);
      GMA = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 192);
      com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
      locala.hkf = 2131689599;
      locala.de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20)).hjS = true;
      frV = locala.azc();
      AppMethodBeat.o(37128);
    }
    
    public final d G(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37127);
      super.fK(paramView);
      this.GIO = ((ImageView)paramView.findViewById(2131298045));
      this.GIR = ((ImageView)this.rLd.findViewById(2131298078));
      this.GIS = ((ImageView)this.rLd.findViewById(2131298177));
      this.GIU = ((TextView)paramView.findViewById(2131298023));
      this.GIW = ((ImageView)paramView.findViewById(2131298039));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.GIV = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.GIX = ((LinearLayout)paramView.findViewById(2131296863));
      this.GIY = ((ViewGroup)paramView.findViewById(2131301542));
      this.GIZ = ((TextView)paramView.findViewById(2131301539));
      this.GJa = ((LinearLayout)paramView.findViewById(2131298053));
      this.naN = paramView.findViewById(2131298069);
      if (!paramBoolean)
      {
        this.GJi = ((ImageView)this.rLd.findViewById(2131298176));
        this.uPp = ((ProgressBar)this.rLd.findViewById(2131306220));
      }
      this.GJp = ((LinearLayout)paramView.findViewById(2131298005));
      this.GJq = ((ImageView)paramView.findViewById(2131298006));
      this.GJs = ((ImageView)paramView.findViewById(2131299519));
      this.GJt = ((TextView)paramView.findViewById(2131298016));
      this.GMB = ((TextView)paramView.findViewById(2131298007));
      this.GMJ = ((TextView)paramView.findViewById(2131298022));
      this.GJm = ((ImageView)paramView.findViewById(2131298018));
      this.GJn = ((TextView)paramView.findViewById(2131298020));
      this.GJo = ((TextView)paramView.findViewById(2131298019));
      this.GMK = ((TextView)paramView.findViewById(2131298021));
      AppMethodBeat.o(37127);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab
 * JD-Core Version:    0.7.0.1
 */