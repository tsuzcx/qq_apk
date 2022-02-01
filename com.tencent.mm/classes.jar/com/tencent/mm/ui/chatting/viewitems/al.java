package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.me;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.uj;
import com.tencent.mm.autogen.mmdata.rpt.uj.a;
import com.tencent.mm.autogen.mmdata.rpt.uj.b;
import com.tencent.mm.autogen.mmdata.rpt.uj.c;
import com.tencent.mm.autogen.mmdata.rpt.uj.d;
import com.tencent.mm.autogen.mmdata.rpt.uj.e;
import com.tencent.mm.message.c.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.frj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.l;
import com.tencent.mm.ui.chatting.v.n;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class al
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.gfV);
        ((View)localObject).setTag(new al.d().ac((View)localObject, true));
      }
      AppMethodBeat.o(37109);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
    {
      AppMethodBeat.i(37110);
      this.aeiK = parama1;
      final al.d locald = (al.d)parama;
      Object localObject1 = (com.tencent.mm.ui.chatting.component.api.o)parama1.cm(com.tencent.mm.ui.chatting.component.api.o.class);
      ((com.tencent.mm.ui.chatting.component.api.o)localObject1).cN(paramcc);
      ((com.tencent.mm.ui.chatting.component.api.o)localObject1).cO(paramcc);
      ((com.tencent.mm.ui.chatting.component.api.o)localObject1).cP(paramcc);
      com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
      parama = paramcc.field_content;
      Object localObject2;
      label206:
      WxaAttributes localWxaAttributes;
      if (parama != null)
      {
        parama = k.b.aP(parama, paramcc.field_reserved);
        localObject1 = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        if (parama != null)
        {
          locald.aeNq.setVisibility(8);
          locald.aeNp.setVisibility(8);
          locald.aeNN.setVisibility(8);
          parama.aK(com.tencent.mm.message.h.class);
          locald.clickArea.setBackgroundResource(R.g.chatto_bg_app);
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
          if (localObject2 != null) {
            b(parama1, parama, paramcc);
          }
          if ((parama.kLg != null) && (parama.kLg.length() != 0)) {
            break label896;
          }
          locald.aeNs.setVisibility(8);
          localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(parama.nTD);
          locald.aeNv.setVisibility(0);
          locald.aeNm.setVisibility(8);
          locald.aeNy.setVisibility(0);
          locald.aeNw.setVisibility(8);
          if (localWxaAttributes == null) {
            break label925;
          }
          paramString = localWxaAttributes.field_nickname;
          label275:
          locald.aeNL.setText(paramString);
          if (localWxaAttributes == null) {
            break label934;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label297:
          r.bKe().a(paramString, locald.aeNK, al.d.lCf);
          locald.aeNN.setVisibility(0);
          locald.aeRT.setVisibility(8);
          locald.aeRT.setText(parama.description);
          locald.aeNR.setText(parama.title);
          switch (parama.nTW)
          {
          default: 
            locald.aeNM.setText(R.l.app_brand_entrance);
            label395:
            r.bKe().a(paramString, locald.aeNK, al.d.lCf);
            if (!parama1.juG()) {
              if (com.tencent.mm.pluginsdk.model.app.h.k((g)localObject2))
              {
                locald.aeNu.setVisibility(0);
                c(parama1, locald.aeNu, bz.a(parama, paramcc));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramcc = r.bKa().d(paramcc.field_imgPath, false, true);
        locald.aeNO.setImageBitmap(null);
        locald.aeNO.setVisibility(4);
        locald.aeNQ.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
        {
          public final void bFg() {}
          
          public final void bFh() {}
          
          public final String key()
          {
            AppMethodBeat.i(37107);
            String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
            AppMethodBeat.o(37107);
            return str;
          }
          
          public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(37106);
            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
            {
              locald.aeNO.setImageBitmap(paramAnonymousBitmap);
              locald.aeNO.setVisibility(0);
              locald.aeNQ.setVisibility(4);
              AppMethodBeat.o(37106);
              return;
            }
            locald.aeNO.setVisibility(4);
            locald.aeNQ.setVisibility(0);
            AppMethodBeat.o(37106);
          }
        }, "file://".concat(String.valueOf(paramcc)), null, ((k)com.tencent.mm.kernel.h.ax(k.class)).eE(240, 192));
        locald.aeSb.setVisibility(8);
        locald.aeSb.setTag(Util.nullAs(parama.nTJ, ""));
        locald.aeSc.setVisibility(8);
        paramcc = (com.tencent.mm.message.a)parama.aK(com.tencent.mm.message.a.class);
        if ((paramcc != null) && (paramcc.nON))
        {
          paramString = parama.nTJ;
          localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).KL(paramString);
          al.a(parama1, locald, paramcc, (d)localObject2);
          al.a(parama1, locald, paramcc, parama, (d)localObject2);
          int i = paramcc.nOU;
          paramInt = i;
          if (localObject2 != null)
          {
            paramInt = i;
            if (((d)localObject2).field_updatePeroid != 0) {
              paramInt = ((d)localObject2).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).a(al.e.el(parama1), parama.nTE, paramString, paramInt, new m.a()
            {
              public final void a(String paramAnonymousString, frj paramAnonymousfrj)
              {
                AppMethodBeat.i(37108);
                Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousfrj.content });
                if (locald.aeSb == null)
                {
                  Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                String str = (String)locald.aeSb.getTag();
                if (Util.isNullOrNil(str))
                {
                  Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                if (str.equals(paramAnonymousString))
                {
                  locald.aeSb.setVisibility(0);
                  locald.aeSb.setText(paramAnonymousfrj.content);
                  locald.aeSb.setTextColor(Util.convertStringToRGB(paramAnonymousfrj.abBq, locald.aeSb.getCurrentTextColor()));
                  if (paramAnonymousfrj.state == 1)
                  {
                    paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).KL(paramAnonymousString);
                    if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                    {
                      if (Util.isNullOrNil(paramcc.nOT))
                      {
                        locald.aeSc.setVisibility(8);
                        AppMethodBeat.o(37108);
                        return;
                      }
                      locald.aeSc.setVisibility(0);
                      locald.aeSc.setText(paramcc.nOT);
                    }
                  }
                }
                AppMethodBeat.o(37108);
              }
            });
          }
        }
        com.tencent.mm.modelappbrand.b.a(parama.nTD, localWxaAttributes, parama);
        locald.clickArea.setTag(localObject1);
        locald.clickArea.setOnClickListener(d(parama1));
        paramString = ad.bCb().M(al.e.el(parama1), true);
        paramcc = (al.c)paramString.get("listener", null);
        parama = paramcc;
        if (paramcc == null)
        {
          parama = new al.c();
          paramString.q("listener", parama);
        }
        parama.n(parama1);
        if (this.wQm)
        {
          locald.clickArea.setOnLongClickListener(c(parama1));
          locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
        }
        AppMethodBeat.o(37110);
        return;
        Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString });
        parama = null;
        break;
        label896:
        locald.aeNs.setVisibility(0);
        b(parama1, locald.aeNs, bz.bBE(parama.kLg));
        break label206;
        label925:
        paramString = parama.iab;
        break label275;
        label934:
        paramString = parama.nTY;
        break label297;
        locald.aeNM.setText(R.l.app_brand_share_wxa_testing_tag);
        break label395;
        locald.aeNM.setText(R.l.app_brand_share_wxa_preview_tag);
        break label395;
        locald.aeNu.setVisibility(8);
        continue;
        locald.aeNu.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37112);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37112);
        return false;
      }
      e.b.a(parama, paramcc, a(parama, paramcc));
      AppMethodBeat.o(37112);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255175);
      int i = ((bz)paramView.getTag()).position;
      paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false))) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)))
      {
        if (paramContextMenuInfo.type != 6) {
          break label262;
        }
        localObject = n.bpU(paramContextMenuInfo.hzM);
        if (((localObject == null) || (!e.b.j(paramcc, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramcc.isClean())) {
          params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      for (;;)
      {
        localObject = new ex();
        ((ex)localObject).hFc.msgId = paramcc.field_msgId;
        ((ex)localObject).publish();
        if ((((ex)localObject).hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
          params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if (!this.aeiK.juH()) {
          params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(255175);
        return true;
        label262:
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37113);
      com.tencent.mm.modelstat.a.a(paramcc, a.a.oUW);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      if (paramcc.field_content == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      k.b localb = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.s(localb.appId, false, false);
      if (localObject1 != null) {
        a(parama, localb, d(parama, paramcc), (g)localObject1, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { localb.nTD, localb.nTC, localb.nTE, localb.url, Integer.valueOf(localb.nTW), localb.nTG });
      localObject1 = new zp();
      ((zp)localObject1).icM.appId = localb.nTE;
      ((zp)localObject1).icM.userName = localb.nTD;
      ((zp)localObject1).icM.icO = localb.nTC;
      ((zp)localObject1).icM.icP = localb.nTW;
      ((zp)localObject1).icM.icS = localb.nTG;
      ((zp)localObject1).icM.appVersion = localb.nTX;
      Object localObject2 = ((zp)localObject1).icM;
      boolean bool;
      StringBuilder localStringBuilder;
      if (localb.nTW != 0)
      {
        bool = true;
        ((zp.a)localObject2).icT = bool;
        ((zp)localObject1).icM.icV.eoT = parama.getTalkerUserName();
        ((zp)localObject1).icM.icV.eoU = localb.nTJ;
        localObject2 = localb.nTI;
        if (!parama.juG()) {
          break label453;
        }
        ((zp)localObject1).icM.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(a(parama, paramcc));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
      for (((zp)localObject1).icM.hzx = localStringBuilder.toString();; ((zp)localObject1).icM.hzx = localStringBuilder.toString())
      {
        al.c((zp)localObject1, localb);
        ((zp)localObject1).publish();
        al.a(parama, localb);
        com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
        AppMethodBeat.o(37113);
        return true;
        bool = false;
        break;
        label453:
        ((zp)localObject1).icM.scene = 1007;
        localStringBuilder = new StringBuilder(a(parama, paramcc));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject2);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements v.n
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.ggV);
        ((View)localObject).setTag(new al.d().ac((View)localObject, false));
      }
      AppMethodBeat.o(37117);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(37118);
      final al.d locald = (al.d)parama;
      this.aeiK = parama1;
      paramString = (com.tencent.mm.ui.chatting.component.api.o)parama1.cm(com.tencent.mm.ui.chatting.component.api.o.class);
      paramString.cP(paramcc);
      com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
      Object localObject1 = paramcc.field_content;
      paramString.cN(paramcc);
      if (localObject1 != null) {}
      label279:
      label798:
      label808:
      for (paramString = k.b.aP((String)localObject1, paramcc.field_reserved);; paramString = null)
      {
        bz localbz = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        WxaAttributes localWxaAttributes;
        Object localObject2;
        if (paramString != null)
        {
          locald.aeNq.setVisibility(8);
          locald.aeNp.setVisibility(8);
          locald.aeNm.setVisibility(8);
          locald.aeNN.setVisibility(8);
          localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString.nTD);
          if (localWxaAttributes == null) {
            break label798;
          }
          localObject1 = localWxaAttributes.field_nickname;
          if (localWxaAttributes == null) {
            break label808;
          }
          localObject2 = localWxaAttributes.field_smallHeadURL;
          label186:
          locald.aeNN.setVisibility(0);
          locald.aeRT.setVisibility(8);
          locald.aeNR.setText(paramString.title);
          locald.aeRT.setText(paramString.description);
          locald.aeNL.setText((CharSequence)localObject1);
          switch (paramString.nTW)
          {
          default: 
            locald.aeNM.setText(R.l.app_brand_entrance);
            r.bKe().a((String)localObject2, locald.aeNK, al.d.lCf);
            if (jxj())
            {
              localObject1 = (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class);
              if ((paramcc.field_status == 2) && (b((com.tencent.mm.ui.chatting.component.api.m)localObject1, paramcc.field_msgId))) {
                if (locald.aeNG != null) {
                  locald.aeNG.setVisibility(0);
                }
              }
            }
            break;
          }
        }
        label351:
        label885:
        for (;;)
        {
          boolean bool = false;
          for (localObject1 = this;; localObject1 = this)
          {
            ((b)localObject1).b(parama, bool);
            parama = r.bKa().d(paramcc.field_imgPath, false, true);
            locald.aeNO.setImageBitmap(null);
            locald.aeNO.setVisibility(4);
            locald.aeNQ.setVisibility(0);
            com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
            {
              public final void bFg() {}
              
              public final void bFh() {}
              
              public final String key()
              {
                AppMethodBeat.i(37115);
                String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                AppMethodBeat.o(37115);
                return str;
              }
              
              public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(37114);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  locald.aeNO.setImageBitmap(paramAnonymousBitmap);
                  locald.aeNO.setVisibility(0);
                  locald.aeNQ.setVisibility(4);
                  AppMethodBeat.o(37114);
                  return;
                }
                locald.aeNO.setVisibility(4);
                locald.aeNQ.setVisibility(0);
                AppMethodBeat.o(37114);
              }
            }, "file://".concat(String.valueOf(parama)), null, ((k)com.tencent.mm.kernel.h.ax(k.class)).eE(240, 192));
            locald.aeSb.setVisibility(8);
            locald.aeSb.setTag(Util.nullAs(paramString.nTJ, ""));
            locald.aeSc.setVisibility(8);
            parama = (com.tencent.mm.message.a)paramString.aK(com.tencent.mm.message.a.class);
            if ((parama != null) && (parama.nON))
            {
              localObject1 = paramString.nTJ;
              localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).KL((String)localObject1);
              al.a(parama1, locald, parama, (d)localObject2);
              al.a(parama1, locald, parama, paramString, (d)localObject2);
              int j = parama.nOU;
              int i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((d)localObject2).field_updatePeroid != 0) {
                  i = ((d)localObject2).field_updatePeroid;
                }
              }
              if (i > 0) {
                ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).a(al.e.el(parama1), paramString.nTE, (String)localObject1, i, new m.a()
                {
                  public final void a(String paramAnonymousString, frj paramAnonymousfrj)
                  {
                    AppMethodBeat.i(37116);
                    Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousfrj.content });
                    if (locald.aeSb == null)
                    {
                      Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    String str = (String)locald.aeSb.getTag();
                    if (Util.isNullOrNil(str))
                    {
                      Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    if (str.equals(paramAnonymousString))
                    {
                      locald.aeSb.setVisibility(0);
                      locald.aeSb.setText(paramAnonymousfrj.content);
                      locald.aeSb.setTextColor(Util.convertStringToRGB(paramAnonymousfrj.abBq, locald.aeSb.getCurrentTextColor()));
                      if (paramAnonymousfrj.state == 1)
                      {
                        paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).KL(paramAnonymousString);
                        if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                        {
                          if (Util.isNullOrNil(parama.nOT))
                          {
                            locald.aeSc.setVisibility(8);
                            AppMethodBeat.o(37116);
                            return;
                          }
                          locald.aeSc.setVisibility(0);
                          locald.aeSc.setText(parama.nOT);
                        }
                      }
                    }
                    AppMethodBeat.o(37116);
                  }
                });
              }
            }
            com.tencent.mm.modelappbrand.b.a(paramString.nTD, localWxaAttributes, paramString);
            locald.clickArea.setTag(localbz);
            locald.clickArea.setOnClickListener(d(parama1));
            localObject1 = ad.bCb().M(al.e.el(parama1), true);
            paramString = (al.c)((ad.b)localObject1).get("listener", null);
            parama = paramString;
            if (paramString == null)
            {
              parama = new al.c();
              ((ad.b)localObject1).q("listener", parama);
            }
            parama.n(parama1);
            if (this.wQm)
            {
              locald.clickArea.setOnLongClickListener(c(parama1));
              locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
            }
            a(paramInt, locald, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
            AppMethodBeat.o(37118);
            return;
            localObject1 = paramString.iab;
            break;
            localObject2 = paramString.nTY;
            break label186;
            locald.aeNM.setText(R.l.app_brand_share_wxa_testing_tag);
            break label279;
            locald.aeNM.setText(R.l.app_brand_share_wxa_preview_tag);
            break label279;
            if (locald.aeNG == null) {
              break label351;
            }
            locald.aeNG.setVisibility(8);
            break label351;
            if (paramcc.field_status >= 2) {
              break label885;
            }
            bool = true;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37120);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37120);
        return false;
      case 111: 
        e.b.a(parama, paramcc, a(parama, paramcc));
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = paramcc.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = k.b.Hf(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37120);
        return false;
        parama = new me();
        parama.hOi.hOj = paramMenuItem.hOj;
        parama.hOi.hCz = paramcc.field_msgId;
        parama.hOi.hOk = paramcc.field_talker;
        parama.publish();
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255155);
      int i = ((bz)paramView.getTag()).position;
      if (paramcc.field_content == null)
      {
        AppMethodBeat.o(255155);
        return true;
      }
      paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      if (paramContextMenuInfo == null)
      {
        AppMethodBeat.o(255155);
        return true;
      }
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false))) && (!com.tencent.mm.ui.chatting.m.bR(paramcc))) {
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      ex localex = new ex();
      localex.hFc.msgId = paramcc.field_msgId;
      localex.publish();
      if ((localex.hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255155);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255166);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
        AppMethodBeat.o(255166);
        return;
      }
      AppMethodBeat.o(255166);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37121);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      paramView.getTag();
      Object localObject1 = paramcc.field_content;
      if (localObject1 == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      localObject1 = k.b.Hf((String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
      if ((localObject2 != null) && (!Util.isNullOrNil(((g)localObject2).field_appId))) {
        a(parama, (k.b)localObject1, z.bAM(), (g)localObject2, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      localObject2 = new zp();
      ((zp)localObject2).icM.appId = ((k.b)localObject1).nTE;
      ((zp)localObject2).icM.userName = ((k.b)localObject1).nTD;
      ((zp)localObject2).icM.icO = ((k.b)localObject1).nTC;
      ((zp)localObject2).icM.icP = ((k.b)localObject1).nTW;
      ((zp)localObject2).icM.icS = ((k.b)localObject1).nTG;
      ((zp)localObject2).icM.appVersion = ((k.b)localObject1).nTX;
      Object localObject3 = ((zp)localObject2).icM;
      boolean bool;
      StringBuilder localStringBuilder;
      if (((k.b)localObject1).nTW != 0)
      {
        bool = true;
        ((zp.a)localObject3).icT = bool;
        localObject3 = ((k.b)localObject1).nTI;
        if (!parama.juG()) {
          break label386;
        }
        ((zp)localObject2).icM.scene = 1008;
        localStringBuilder = new StringBuilder(parama.getTalkerUserName());
        localStringBuilder.append(":");
        localStringBuilder.append(a(parama, paramcc));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject3);
      }
      for (((zp)localObject2).icM.hzx = localStringBuilder.toString();; ((zp)localObject2).icM.hzx = localStringBuilder.toString())
      {
        ((zp)localObject2).icM.icV.eoT = parama.getTalkerUserName();
        ((zp)localObject2).icM.icV.eoU = ((k.b)localObject1).nTJ;
        al.c((zp)localObject2, (k.b)localObject1);
        ((zp)localObject2).publish();
        al.a(parama, (k.b)localObject1);
        com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
        AppMethodBeat.o(37121);
        return true;
        bool = false;
        break;
        label386:
        ((zp)localObject2).icM.scene = 1007;
        localStringBuilder = new StringBuilder(a(parama, paramcc));
        localStringBuilder.append(":");
        localStringBuilder.append((String)localObject3);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
  
  static final class c
    implements com.tencent.mm.ui.o
  {
    private WeakReference<com.tencent.mm.ui.chatting.d.a> vKQ;
    
    public final void jjf() {}
    
    public final void jjg() {}
    
    public final void jjh() {}
    
    public final void jji()
    {
      AppMethodBeat.i(37124);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).bEM();
      AppMethodBeat.o(37124);
    }
    
    public final void jjj()
    {
      AppMethodBeat.i(37125);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).bEN();
      AppMethodBeat.o(37125);
    }
    
    public final void jjk()
    {
      AppMethodBeat.i(37126);
      Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.vKQ == null)
      {
        AppMethodBeat.o(37126);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.vKQ.get();
      if (locala != null)
      {
        ad.bCb().Jn(al.e.el(locala));
        ((l)locala.cm(l.class)).b(this);
        ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.m.class)).KM(al.e.el(locala));
      }
      AppMethodBeat.o(37126);
    }
    
    public final void jjl() {}
    
    final void n(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37123);
      this.vKQ = new WeakReference(parama);
      ((l)parama.cm(l.class)).a(this);
      AppMethodBeat.o(37123);
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int aeRR;
    public static final int aeRS;
    static com.tencent.mm.modelimage.loader.a.c lCf;
    ImageView aeNG;
    protected ImageView aeNK;
    protected TextView aeNL;
    protected TextView aeNM;
    protected LinearLayout aeNN;
    protected ImageView aeNO;
    protected ImageView aeNQ;
    protected TextView aeNR;
    protected ImageView aeNm;
    protected ImageView aeNp;
    protected ImageView aeNq;
    protected TextView aeNs;
    protected ChattingItemFooter aeNt;
    protected ImageView aeNu;
    protected LinearLayout aeNv;
    protected ViewGroup aeNw;
    protected TextView aeNx;
    protected LinearLayout aeNy;
    protected TextView aeRT;
    protected TextView aeSb;
    protected TextView aeSc;
    
    static
    {
      AppMethodBeat.i(37128);
      aeRR = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 240);
      aeRS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 192);
      com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
      locala.oKB = R.k.app_brand_app_default_icon_for_tail;
      locala.eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20)).oKn = true;
      lCf = locala.bKx();
      AppMethodBeat.o(37128);
    }
    
    public final d ac(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37127);
      super.create(paramView);
      this.aeNm = ((ImageView)paramView.findViewById(R.h.fxa));
      this.aeNp = ((ImageView)this.convertView.findViewById(R.h.fxD));
      this.aeNq = ((ImageView)this.convertView.findViewById(R.h.fAl));
      this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
      this.aeNu = ((ImageView)paramView.findViewById(R.h.fwU));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.maskView = paramView.findViewById(R.h.fzn);
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.aeNt = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
      this.aeNv = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
      this.aeNw = ((ViewGroup)paramView.findViewById(R.h.fNj));
      this.aeNx = ((TextView)paramView.findViewById(R.h.fNg));
      this.aeNy = ((LinearLayout)paramView.findViewById(R.h.fxi));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      if (!paramBoolean)
      {
        this.aeNG = ((ImageView)this.convertView.findViewById(R.h.chatting_status_tick));
        this.uploadingPB = ((ProgressBar)this.convertView.findViewById(R.h.gbo));
      }
      this.aeNN = ((LinearLayout)paramView.findViewById(R.h.fwl));
      this.aeNO = ((ImageView)paramView.findViewById(R.h.fwm));
      this.aeNQ = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
      this.aeNR = ((TextView)paramView.findViewById(R.h.fww));
      this.aeRT = ((TextView)paramView.findViewById(R.h.fwn));
      this.aeSb = ((TextView)paramView.findViewById(R.h.fwC));
      this.aeNK = ((ImageView)paramView.findViewById(R.h.fwy));
      this.aeNL = ((TextView)paramView.findViewById(R.h.fwA));
      this.aeNM = ((TextView)paramView.findViewById(R.h.fwz));
      this.aeSc = ((TextView)paramView.findViewById(R.h.fwB));
      AppMethodBeat.o(37127);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return this.aeNy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al
 * JD-Core Version:    0.7.0.1
 */