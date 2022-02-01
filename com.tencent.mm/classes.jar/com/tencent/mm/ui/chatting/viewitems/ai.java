package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.g.a.xu.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.b;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.c;
import com.tencent.mm.msgsubscription.storage.a.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.o;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import d.g.b.y.f;
import d.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ai
  extends c
{
  private static int KAn;
  private static int KAo;
  private com.tencent.mm.ui.base.p BmD;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private com.tencent.mm.av.a.a.c JnE;
  private View.OnClickListener KAa;
  private View.OnClickListener KAb;
  private View.OnClickListener KAc;
  private com.tencent.mm.ui.l KAd;
  private View.OnClickListener KAe;
  private IBrandSubscribeMsgService.c KAf;
  private String KAg;
  private int KAh;
  private com.tencent.mm.msgsubscription.storage.a KAi;
  private com.tencent.mm.msgsubscription.storage.a KAj;
  private String KAk;
  private boolean KAl;
  private com.tencent.mm.ui.widget.a.e KAm;
  private com.tencent.mm.sdk.b.c<nx> KjR;
  private View.OnClickListener Kva;
  private View.OnClickListener KzZ;
  private com.tencent.mm.ui.base.p fSP;
  private String mAppId;
  private View.OnClickListener qri;
  
  static
  {
    AppMethodBeat.i(37267);
    KAn = ak.getContext().getResources().getColor(2131100212);
    KAo = ak.getContext().getResources().getColor(2131100212);
    AppMethodBeat.o(37267);
  }
  
  public ai()
  {
    AppMethodBeat.i(37240);
    this.KAf = new IBrandSubscribeMsgService.c(true, false);
    this.KAk = "";
    this.KAl = false;
    this.KAm = null;
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    ((com.tencent.mm.av.a.a.c.a)localObject).hhW = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).igv = 2131231342;
    this.JnE = ((com.tencent.mm.av.a.a.c.a)localObject).aJu();
    localObject = com.tencent.mm.msgsubscription.storage.f.iEK;
    this.KAi = com.tencent.mm.msgsubscription.storage.f.II("name_biz");
    localObject = com.tencent.mm.msgsubscription.storage.f.iEK;
    this.KAj = com.tencent.mm.msgsubscription.storage.f.II("name_wxa");
    this.KAa = new a((byte)0);
    this.KAe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = bx.M(paramAnonymousView.dCi.field_content, "msg");
        localObject1 = bu.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), localObject1, Integer.valueOf(66666) });
        localObject1 = bu.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bu.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = bu.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!bu.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.t((Intent)localObject1, ai.b(ai.this).getTalkerUserName());
            com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37198);
          return;
          String str = bu.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
          int i = bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
          int j = bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
          localObject2 = bu.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.dlj = (paramAnonymousView.dCi.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + (String)localObject2);
          localAppBrandStatObject.scene = ai.Vb((String)localObject2);
          ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ai.b(ai.this).Kkd.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        }
      }
    };
    this.Kva = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = (bk)paramAnonymousView.getTag();
        Object localObject2 = bx.M(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dCi.field_content, "msg");
        if ((localObject2 != null) && (((Map)localObject2).size() != 0))
        {
          bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
          if (!ai.cb((Map)localObject2)) {}
        }
        for (boolean bool = bu.getBoolean((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false);; bool = false)
        {
          ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click, blockProfile: %b", new Object[] { ((bk)localObject1).userName, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject2 = ai.this;
            paramAnonymousView.getContext();
            ai.a((ai)localObject2, ((bk)localObject1).userName);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37215);
          return;
        }
      }
    };
    this.KjR = new com.tencent.mm.sdk.b.c() {};
    this.KAd = new com.tencent.mm.ui.l()
    {
      public final void fAs() {}
      
      public final void fAt() {}
      
      public final void fAu() {}
      
      public final void fAv() {}
      
      public final void fAw() {}
      
      public final void fAx()
      {
        AppMethodBeat.i(187850);
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        com.tencent.mm.sdk.b.a.IvT.d(ai.c(ai.this));
        if (ai.b(ai.this) != null) {
          ((com.tencent.mm.ui.chatting.d.b.j)ai.b(ai.this).bh(com.tencent.mm.ui.chatting.d.b.j.class)).b(this);
        }
        AppMethodBeat.o(187850);
      }
      
      public final void fAy() {}
    };
    this.KAb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187851);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        bk localbk = (bk)paramAnonymousView.getTag();
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbk.userName });
        vq localvq = new vq();
        localvq.dKT.userName = localbk.userName;
        localvq.dKT.dKV = localbk.pageUrl;
        Map localMap = bx.M(localbk.dCi.field_content, "msg");
        localObject = "";
        paramAnonymousView = (View)localObject;
        if (localMap != null)
        {
          paramAnonymousView = (View)localObject;
          if (localMap.size() > 0)
          {
            localvq.dKT.dKW = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = bu.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localvq.dKT.dLa = true;
        localvq.dKT.scene = ai.Vb(paramAnonymousView);
        localvq.dKT.dlj = (localbk.dCi.field_msgSvrId + ":" + localbk.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + paramAnonymousView);
        com.tencent.mm.sdk.b.a.IvT.l(localvq);
        ai.mv(ai.d(ai.this), ai.a(ai.this));
        com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), localbk.userName, Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187851);
      }
    };
    this.qri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = (bk)paramAnonymousView.getTag();
        Object localObject2 = bx.M(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dCi.field_content, "msg");
        if (localObject2 == null)
        {
          ae.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
        }
        int i = bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String str1;
        String str2;
        int j;
        if (i == 1)
        {
          str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
          str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
          i = bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          j = bu.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = bu.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).dlj = (((bk)localObject1).dCi.field_msgSvrId + ":" + ((bk)localObject1).userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(((bk)localObject1).userName))
          {
            ((AppBrandStatObject)localObject2).scene = ai.Vb(paramAnonymousView);
            ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ai.b(ai.this).Kkd.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
            ai.mv(ai.d(ai.this), ai.a(ai.this));
            com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), ((bk)localObject1).userName, Integer.valueOf(0) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
          ((AppBrandStatObject)localObject2).scene = 1043;
          paramAnonymousView = com.tencent.mm.al.g.eX(((bk)localObject1).userName);
          com.tencent.mm.plugin.appbrand.service.p localp = (com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class);
          Activity localActivity = ai.b(ai.this).Kkd.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localp.a(localActivity, str1, null, j, i, str2, (AppBrandStatObject)localObject2, paramAnonymousView);
            break;
          }
          if (i == 2)
          {
            localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
            long l = bu.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
            ai.d(paramAnonymousView.getContext(), (String)localObject1, l);
            ae.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
          }
        }
      }
    };
    this.KAc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        int i = paramAnonymousView.opType;
        localObject1 = paramAnonymousView.KDX;
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "jumpNativePage opType: %d, opInfo: %s", new Object[] { Integer.valueOf(paramAnonymousView.opType), paramAnonymousView.KDX });
        Object localObject3;
        Object localObject2;
        if (i == 3)
        {
          paramAnonymousView = ai.b(ai.this).Kkd.getContext();
          ae.i("SnsAdUtil", "type = 0content = ".concat(String.valueOf(localObject1)));
          localObject3 = com.tencent.mm.plugin.sns.data.k.azg((String)localObject1);
          localObject1 = ((com.tencent.mm.plugin.sns.data.s)localObject3).pageId;
          localObject2 = ((com.tencent.mm.plugin.sns.data.s)localObject3).dGD;
          localObject3 = ((com.tencent.mm.plugin.sns.data.s)localObject3).kwE;
          if (paramAnonymousView != null) {
            if (!bu.V(new String[] { localObject1, localObject2, localObject3 })) {
              break label192;
            }
          }
          ae.e("SnsAdUtil", "context or pageId or uxInfo or adInfoXml is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37232);
          return;
          label192:
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_landing_pages_pageid", bu.aSC((String)localObject1));
          ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
          ((Intent)localObject2).putExtra("sns_landig_pages_from_source", 21);
          ((Intent)localObject2).putExtra("sns_landing_pages_ad_info", (String)localObject3);
          com.tencent.mm.br.d.b(paramAnonymousView, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject2);
        }
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private static void V(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    ae.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.g.yxI.f(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bu.aRi()) });
    AppMethodBeat.o(37253);
  }
  
  private void a(View paramView, com.tencent.mm.storage.bv parambv, Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(187858);
    if (parambv == null)
    {
      AppMethodBeat.o(187858);
      return;
    }
    if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramString))
    {
      AppMethodBeat.o(187858);
      return;
    }
    if (!"notifymessage".equals(parambv.field_talker))
    {
      AppMethodBeat.o(187858);
      return;
    }
    parambv = (bk)paramView.getTag();
    paramMap = bu.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string"));
    parambv.opType = paramInt;
    parambv.KDX = paramMap;
    paramView.setTag(parambv);
    paramView.setOnClickListener(this.KAc);
    AppMethodBeat.o(187858);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.e.a parama, String paramString1, com.tencent.mm.storage.bv parambv, String paramString2)
  {
    AppMethodBeat.i(37246);
    if (paramImageView == null)
    {
      AppMethodBeat.o(37246);
      return;
    }
    if (x.AZ(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(37246);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramString1))
    {
      com.tencent.mm.av.q.aJb().a(paramString2, paramImageView, this.JnE);
      paramImageView.setTag(new bk(parambv, paramString1));
      paramImageView.setOnClickListener(this.Kva);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(w.zP(paramString1) + parama.Kkd.getContext().getString(2131756087));
      AppMethodBeat.o(37246);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
    if (parama.fJC()) {}
    for (parambv = parama.getTalkerUserName();; parambv = null)
    {
      paramImageView.setTag(new bk(paramString1, parambv));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(bp parambp, com.tencent.mm.storage.bv parambv, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    LinearLayout localLinearLayout = parambp.KEC;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      final String str1;
      final String str2;
      for (parambp = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambp = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str1 = (String)paramMap.get(parambp + ".word");
        str2 = (String)paramMap.get(parambp + ".hint_word");
        if (!bu.isNullOrNil(str1)) {
          break label194;
        }
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label1074;
        }
        if (i != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
        AppMethodBeat.o(37251);
        return;
      }
      localLinearLayout.removeViews(i, j - i);
      AppMethodBeat.o(37251);
      return;
      label194:
      Object localObject1;
      label213:
      Object localObject2;
      final int k;
      label378:
      final int m;
      if (i < j)
      {
        localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
        localObject1 = (a)((LinearLayout)localObject1).getTag();
        localObject2 = (String)paramMap.get(parambp + ".icon");
        k = al.gE(c(paramMap, parambp + ".color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
        ((a)localObject1).gqi.setTextColor(k);
        if (bu.getInt((String)paramMap.get(parambp + ".is_rich_text"), 0) != 0) {
          break label874;
        }
        ((a)localObject1).gqi.setSingleLine(true);
        ((a)localObject1).gqi.setEllipsize(TextUtils.TruncateAt.END);
        ((a)localObject1).gqi.setText(str1);
        ((a)localObject1).jdb.setText(str2);
        ((a)localObject1).jdb.setTextColor(this.JWz.Kkd.getContext().getResources().getColor(2131099734));
        if (!bu.isNullOrNil((String)localObject2)) {
          break label973;
        }
        ((a)localObject1).ka.setVisibility(8);
        ((a)localObject1).gqi.setPadding(0, 0, 0, 0);
        label445:
        localObject2 = (String)paramMap.get(parambp + ".url");
        str1 = bu.nullAsNil((String)paramMap.get(".msg.fromusername"));
        m = bu.getInt((String)paramMap.get(parambp + ".op_type"), 0);
        str2 = (String)paramMap.get(parambp + ".weapp_username");
        bk localbk = new bk(parambv, str1, (String)localObject2);
        ((a)localObject1).Jvg.setTag(localbk);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty(str2))) {
          break label1021;
        }
        localObject2 = (String)paramMap.get(parambp + ".weapp_path");
        m = bu.getInt((String)paramMap.get(parambp + ".weapp_version"), 0);
        final int n = bu.getInt((String)paramMap.get(parambp + ".weapp_state"), 0);
        parambp = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187847);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = (bk)paramAnonymousView.getTag();
            ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            localObject = new AppBrandStatObject();
            ((AppBrandStatObject)localObject).dlj = (paramAnonymousView.dCi.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kxv);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramAnonymousView.userName))
            {
              ((AppBrandStatObject)localObject).scene = ai.Vb(this.Kxv);
              ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ai.b(ai.this).Kkd.getContext(), str2, null, n, m, this.KAH, (AppBrandStatObject)localObject);
              ai.mv(ai.d(ai.this), ai.a(ai.this));
              com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), str1, Integer.valueOf(k) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(187847);
              return;
            }
            ((AppBrandStatObject)localObject).scene = 1043;
            paramAnonymousView = com.tencent.mm.al.g.eX(paramAnonymousView.userName);
            com.tencent.mm.plugin.appbrand.service.p localp = (com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class);
            Activity localActivity = ai.b(ai.this).Kkd.getContext();
            String str1 = str2;
            int i = n;
            int j = m;
            String str2 = this.KAH;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localp.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
              break;
            }
          }
        };
        ((a)localObject1).Jvg.setOnClickListener(parambp);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.JWz.Kkd.getContext()).inflate(2131493393, null, false);
        localObject2 = new a();
        ((a)localObject2).gqi = ((TextView)((LinearLayout)localObject1).findViewById(2131302757));
        ((a)localObject2).ka = ((ImageView)((LinearLayout)localObject1).findViewById(2131302756));
        ((a)localObject2).Jvg = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131302754));
        ((a)localObject2).jdb = ((TextView)((LinearLayout)localObject1).findViewById(2131302755));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label213;
        label874:
        k = bu.getInt((String)paramMap.get(parambp + ".display_line_number"), 1);
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
        ((a)localObject1).gqi.setSingleLine(false);
        ((a)localObject1).gqi.setText(str1);
        ((a)localObject1).gqi.setMaxLines(k);
        com.tencent.mm.pluginsdk.ui.span.k.a(((a)localObject1).gqi, false, null);
        break label378;
        label973:
        ((a)localObject1).ka.setVisibility(0);
        l(((a)localObject1).ka, (String)localObject2);
        ((a)localObject1).gqi.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 28), 0);
        break label445;
        label1021:
        if (m == 2) {
          ((a)localObject1).Jvg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187848);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              if (k == 1)
              {
                localObject = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                long l = bu.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                ai.d(paramAnonymousView.getContext(), (String)localObject, l);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(795L, 2L, 1L, false);
                ae.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject, Long.valueOf(l) });
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187848);
                return;
                if (k == 2) {
                  com.tencent.mm.br.d.f(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
                }
              }
            }
          });
        } else {
          ((a)localObject1).Jvg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187849);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (!bu.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), str1, Integer.valueOf(k) });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(187849);
            }
          });
        }
      }
    }
    label1074:
    AppMethodBeat.o(37251);
  }
  
  private void a(bp parambp, String paramString1, String paramString2, Map<String, String> paramMap, com.tencent.mm.storage.bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    parambp.KEl.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JWz.Kkd.getContext(), paramString2, parambp.KEl.getTextSize()));
    com.tencent.mm.av.q.aJb().a(paramString1, parambp.KEk, this.JnE);
    parambp.KEk.setTag(null);
    parambp.KEk.setOnClickListener(null);
    parambp.KEj.setTag(null);
    parambp.KEj.setOnClickListener(null);
    parambp.KEj.setVisibility(0);
    paramString1 = bu.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bu.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bu.isNullOrNil(paramString1)) || (!bu.isNullOrNil(paramString2)))
    {
      paramString1 = bu.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambp.KEj.setTag(new bk(parambv, paramString1));
      parambp.KEj.setOnClickListener(this.KAe);
    }
    for (;;)
    {
      paramString1 = bu.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bu.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambp.KEn.getParent()).setVisibility(0);
      com.tencent.mm.av.q.aJb().a(paramString1, parambp.KEn, this.JnE);
      AppMethodBeat.o(37247);
      return;
      parambp.KEj.setOnClickListener(null);
    }
    ((View)parambp.KEn.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(bp parambp, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37250);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    Object localObject1;
    label37:
    Object localObject2;
    Object localObject3;
    label223:
    int k;
    if (j < 100)
    {
      if (j == 0)
      {
        localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
        localObject2 = (String)paramMap.get((String)localObject1 + ".value.word");
        localObject3 = (String)paramMap.get((String)localObject1 + ".key.word");
        if ((!bu.isNullOrNil((String)localObject2)) || (!bu.isNullOrNil((String)localObject3))) {
          break label353;
        }
        ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      j = i;
      if (i > 8) {
        j = 8;
      }
      localObject2 = parambp.KEz;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)parambp.KEz.getParent()).findViewById(2131298909);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((LinearLayout)localObject2).getChildCount() > localArrayList.size())
      {
        if (localArrayList.size() != 0) {
          break label813;
        }
        ((LinearLayout)localObject2).removeAllViews();
      }
      k = ((LinearLayout)localObject2).getChildCount();
      i = 0;
      label232:
      if (i >= localArrayList.size()) {
        break label978;
      }
      localObject3 = (bm)localArrayList.get(i);
      if (i >= k) {
        break label843;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject2).getChildAt(i);
      label273:
      localObject1 = (bn)((LinearLayout)localObject1).getTag();
      if (!((bm)localObject3).KEd) {
        break label927;
      }
      ((bn)localObject1).KEe.setVisibility(8);
    }
    for (;;)
    {
      ((bn)localObject1).KEf.setTextColor(al.gE(((bm)localObject3).KEc));
      ((bn)localObject1).KEf.setText(((bm)localObject3).KEa);
      i += 1;
      break label232;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label353:
      Object localObject4 = new bm();
      ((bm)localObject4).KEa = ((String)localObject2);
      ((bm)localObject4).KDZ = bu.nullAsNil((String)localObject3);
      label517:
      boolean bool;
      if (!al.isDarkMode())
      {
        ((bm)localObject4).KEb = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", KAn));
        ((bm)localObject4).KEc = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
        if (bu.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label804;
        }
        bool = true;
        label557:
        ((bm)localObject4).KEd = bool;
        k = (aYf(((bm)localObject4).KDZ) + 1) / 2;
        if (k <= i) {
          break label810;
        }
        i = k;
      }
      label804:
      label810:
      for (;;)
      {
        localArrayList.add(localObject4);
        j += 1;
        break;
        ((bm)localObject4).KEb = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", KAn)));
        ((bm)localObject4).KEc = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711))));
        ((bm)localObject4).KEc = al.gE(((bm)localObject4).KEc);
        break label517;
        bool = false;
        break label557;
      }
      label813:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label223;
      label843:
      localObject1 = (LinearLayout)LayoutInflater.from(this.JWz.Kkd.getContext()).inflate(2131493394, null, false);
      localObject4 = new bn();
      ((bn)localObject4).KEe = ((TextView)((LinearLayout)localObject1).findViewById(2131301424));
      ((bn)localObject4).KEf = ((TextView)((LinearLayout)localObject1).findViewById(2131301431));
      ((LinearLayout)localObject1).setTag(localObject4);
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label273;
      label927:
      ((bn)localObject1).KEe.setVisibility(0);
      ((bn)localObject1).KEe.setEms(j);
      ((bn)localObject1).KEe.setTextColor(al.gE(((bm)localObject3).KEb));
      ((bn)localObject1).KEe.setText(((bm)localObject3).KDZ);
    }
    label978:
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      parambp.KEy.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(37250);
      return;
    }
    if (bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      parambp.KEy.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(37250);
      return;
      parambp.KEy.setVisibility(0);
    }
  }
  
  private void a(final Map<String, String> paramMap, final com.tencent.mm.storage.bv parambv, final bp parambp, final IBrandSubscribeMsgService.c paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(187861);
    boolean bool1;
    if (!paramc.iEF)
    {
      bool1 = true;
      boolean bool2 = paramc.iEG;
      ae.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), this.KAg, this.KAk, Boolean.valueOf(bool2) });
      localObject = parambp.KEP;
      if (!this.KAl) {
        break label214;
      }
      i = 0;
      label91:
      ((LinearLayout)localObject).setVisibility(i);
      if ((!bool1) && ((!paramBoolean) || (bool2))) {
        break label229;
      }
      parambp.KEm.setVisibility(0);
      localObject = parambp.KEQ;
      localResources = this.JWz.Kkd.getMMResources();
      if (!paramBoolean) {
        break label221;
      }
    }
    label214:
    label221:
    for (int i = 2131761768;; i = 2131761761)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      parambp.KEP.setTag(2131302745, parambv);
      if (this.KAl) {
        parambp.KEP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37218);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ai.a(ai.this, parambv, paramMap, paramBoolean, paramc, parambp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37218);
          }
        });
      }
      AppMethodBeat.o(187861);
      return;
      bool1 = false;
      break;
      i = 8;
      break label91;
    }
    label229:
    parambp.KEm.setVisibility(8);
    Object localObject = parambp.KEQ;
    Resources localResources = this.JWz.Kkd.getMMResources();
    if (paramBoolean) {}
    for (i = 2131761766;; i = 2131761736)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      break;
    }
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final com.tencent.mm.storage.bv parambv, final Map<String, String> paramMap, final String paramString, final bp parambp, final boolean paramBoolean3)
  {
    AppMethodBeat.i(187862);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.JWz.Kkd.getContext(), 1, true);
    Object localObject = this.JWz.Kkd.getContext().getResources();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = String.format(((Resources)localObject).getString(2131761763), new Object[] { this.KAk });; localObject = ((Resources)localObject).getString(2131761762))
      {
        locale.p((CharSequence)localObject, 3);
        locale.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(187839);
            if (paramBoolean1)
            {
              paramAnonymousl.a(1, ai.b(ai.this).Kkd.getMMResources().getColor(2131100035), ai.b(ai.this).Kkd.getMMResources().getString(2131761764));
              AppMethodBeat.o(187839);
              return;
            }
            int j = ai.b(ai.this).Kkd.getMMResources().getColor(2131100800);
            Resources localResources = ai.b(ai.this).Kkd.getMMResources();
            if (paramBoolean2) {}
            for (int i = 2131761743;; i = 2131761744)
            {
              paramAnonymousl.a(0, j, localResources.getString(i));
              AppMethodBeat.o(187839);
              return;
            }
          }
        };
        locale.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(187840);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(187840);
              return;
              if (paramBoolean2)
              {
                ai.a(ai.this, paramMap, true, paramBoolean3, parambp, paramString);
                AppMethodBeat.o(187840);
                return;
              }
              ai.a(ai.this, true, parambp, paramString, parambv);
              AppMethodBeat.o(187840);
              return;
              if (paramBoolean2)
              {
                ai.a(ai.this, paramMap, false, paramBoolean3, parambp, paramString);
                AppMethodBeat.o(187840);
                return;
              }
              ai.a(ai.this, false, parambp, paramString, parambv);
            }
          }
        };
        locale.cPF();
        AppMethodBeat.o(187862);
        return;
      }
    }
    if (paramBoolean2) {}
    for (localObject = String.format(((Resources)localObject).getString(2131761741), new Object[] { this.KAk });; localObject = ((Resources)localObject).getString(2131761742))
    {
      locale.p((CharSequence)localObject, 3);
      break;
    }
  }
  
  private void aYd(final String paramString)
  {
    AppMethodBeat.i(187860);
    String str1 = this.JWz.Kkd.getContext().getString(2131761735);
    String str2 = this.JWz.Kkd.getContext().getString(2131761734);
    h.a(this.JWz.Kkd.getContext(), str2, str1, this.JWz.Kkd.getContext().getString(2131761773), this.JWz.Kkd.getContext().getString(2131755691), true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(187829);
        paramAnonymousDialogInterface = new Intent(ai.b(ai.this).Kkd.getContext(), BizSubscribeMsgManagerUI.class);
        paramAnonymousDialogInterface.putExtra("key_biz_username", paramString);
        paramAnonymousDialogInterface.putExtra("key_biz_nickname", w.zP(paramString));
        if (this.KAq)
        {
          paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
          if (!this.KAq) {
            break label150;
          }
        }
        label150:
        for (paramAnonymousInt = 100;; paramAnonymousInt = 101)
        {
          com.tencent.mm.br.d.a((MMFragmentActivity)ai.b(ai.this).Kkd.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramAnonymousDialogInterface, paramAnonymousInt, new MMFragmentActivity.b()
          {
            public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(187828);
              if ((paramAnonymous2Int1 == 100) && (paramAnonymous2Intent != null))
              {
                paramAnonymous2Intent = (SubscribeMsgSettingData)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                if (paramAnonymous2Intent != null)
                {
                  ai.i(ai.this);
                  com.tencent.mm.msgsubscription.util.c localc = com.tencent.mm.msgsubscription.util.c.iGY;
                  com.tencent.mm.msgsubscription.util.c.a(ai.3.this.fOj, paramAnonymous2Intent, new d.g.a.b() {});
                }
                AppMethodBeat.o(187828);
                return;
              }
              if ((paramAnonymous2Int1 == 101) && (paramAnonymous2Intent != null))
              {
                boolean bool = paramAnonymous2Intent.getBooleanExtra("key_need_update", false);
                ae.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", new Object[] { Boolean.valueOf(bool) });
                if (!bool)
                {
                  AppMethodBeat.o(187828);
                  return;
                }
                paramAnonymous2Intent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                if (paramAnonymous2Intent != null)
                {
                  ai.i(ai.this);
                  new com.tencent.mm.msgsubscription.storage.e(com.tencent.mm.al.b.b.hVA).a(ai.3.this.fOj, paramAnonymous2Intent.iEE, paramAnonymous2Intent.iED, false, new e.b()
                  {
                    public final void a(String paramAnonymous3String, SubscribeMsgRequestResult paramAnonymous3SubscribeMsgRequestResult)
                    {
                      AppMethodBeat.i(187826);
                      ae.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                      ai.j(ai.this);
                      if (ai.b(ai.this) != null) {
                        ai.b(ai.this).bPl();
                      }
                      AppMethodBeat.o(187826);
                    }
                    
                    public final void i(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String)
                    {
                      AppMethodBeat.i(187827);
                      ae.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String });
                      ai.j(ai.this);
                      t.makeText(ai.b(ai.this).Kkd.getContext(), ai.b(ai.this).Kkd.getContext().getString(2131761772), 1).show();
                      AppMethodBeat.o(187827);
                    }
                  });
                }
              }
              AppMethodBeat.o(187828);
            }
          });
          AppMethodBeat.o(187829);
          return;
          paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
          paramAnonymousDialogInterface.putExtra("key_need_update", false);
          paramAnonymousDialogInterface.putExtra("key_need_load_from_remote", true);
          break;
        }
      }
    }, null).setCanceledOnTouchOutside(false);
    AppMethodBeat.o(187860);
  }
  
  private static int aYe(String paramString)
  {
    AppMethodBeat.i(37248);
    String str = paramString;
    if (paramString == null) {
      str = "-1";
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      i = bu.m(Integer.valueOf(i), -1);
      AppMethodBeat.o(37248);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.ChattingItemDyeingTemplate", paramString.getMessage());
        int i = -1;
      }
    }
  }
  
  private static int aYf(String paramString)
  {
    AppMethodBeat.i(37255);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37255);
      return 0;
    }
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    AppMethodBeat.o(37255);
    return i;
  }
  
  private static int c(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(37254);
    if ((paramMap == null) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(37254);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bu.nullAsNil((String)paramMap.get(paramString)));
      paramInt = i;
    }
    catch (Exception paramMap)
    {
      label44:
      break label44;
    }
    AppMethodBeat.o(37254);
    return paramInt;
  }
  
  private static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(37252);
    if ((bu.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(37252);
      return;
    }
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    bc.aCg();
    ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azR();
    ((com.tencent.mm.av.a.a.c.a)localObject).igk = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).hgL = true;
    localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aJu();
    com.tencent.mm.av.q.aJb().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
    AppMethodBeat.o(37252);
  }
  
  private static boolean on(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int v(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187859);
    int i = aYe((String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
    AppMethodBeat.o(187859);
    return i;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37241);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493426);
      paramLayoutInflater = new bi();
      paramLayoutInflater.iFD = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramLayoutInflater.hcH = ((View)localObject).findViewById(2131298147);
      paramLayoutInflater.yUp = ((TextView)((View)localObject).findViewById(2131298185));
      paramLayoutInflater.KuH = ((ChattingAvatarImageView)((View)localObject).findViewById(2131298056));
      paramLayoutInflater.fVV = ((TextView)((View)localObject).findViewById(2131298178));
      paramLayoutInflater.olp = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramLayoutInflater.KDF.oiV = ((View)localObject).findViewById(2131298119);
      paramLayoutInflater.KDF.KDI = ((View)localObject).findViewById(2131300702);
      paramLayoutInflater.KDF.gqi = ((TextView)paramLayoutInflater.KDF.oiV.findViewById(2131305902));
      paramLayoutInflater.KDF.KDM = ((LinearLayout)paramLayoutInflater.KDF.oiV.findViewById(2131299136));
      paramLayoutInflater.KDF.KDL = ((TextView)paramLayoutInflater.olp.findViewById(2131299035));
      paramLayoutInflater.KDF.KDN = paramLayoutInflater.olp.findViewById(2131304592);
      paramLayoutInflater.KDF.KDJ = ((View)localObject).findViewById(2131302486);
      paramLayoutInflater.KDF.KDK = ((View)localObject).findViewById(2131302487);
      paramLayoutInflater.KDG.KEh = ((View)localObject).findViewById(2131298118);
      paramLayoutInflater.KDG.KEi = ((ImageView)((View)localObject).findViewById(2131302769));
      paramLayoutInflater.KDG.KEj = ((View)localObject).findViewById(2131302767);
      paramLayoutInflater.KDG.KEl = ((TextView)((View)localObject).findViewById(2131302785));
      paramLayoutInflater.KDG.KEk = ((ImageView)((View)localObject).findViewById(2131302743));
      paramLayoutInflater.KDG.KEm = ((View)localObject).findViewById(2131302746);
      paramLayoutInflater.KDG.KEn = ((ImageView)((View)localObject).findViewById(2131302773));
      paramLayoutInflater.KDG.KEo = ((View)localObject).findViewById(2131302771);
      paramLayoutInflater.KDG.KEp = ((View)localObject).findViewById(2131302772);
      paramLayoutInflater.KDG.KEq = ((TextView)((View)localObject).findViewById(2131302778));
      paramLayoutInflater.KDG.KEr = ((TextView)((View)localObject).findViewById(2131302766));
      paramLayoutInflater.KDG.KEs = ((View)localObject).findViewById(2131302768);
      paramLayoutInflater.KDG.KEt = ((LinearLayout)((View)localObject).findViewById(2131302779));
      paramLayoutInflater.KDG.KEu = ((TextView)((View)localObject).findViewById(2131302781));
      paramLayoutInflater.KDG.KEw = ((TextView)((View)localObject).findViewById(2131302782));
      paramLayoutInflater.KDG.KEv = ((TextView)((View)localObject).findViewById(2131302783));
      paramLayoutInflater.KDG.KEx = ((TextView)((View)localObject).findViewById(2131302784));
      paramLayoutInflater.KDG.KEy = ((View)localObject).findViewById(2131302780);
      paramLayoutInflater.KDG.KEz = ((LinearLayout)((View)localObject).findViewById(2131302770));
      paramLayoutInflater.KDG.KED = ((View)localObject).findViewById(2131302760);
      paramLayoutInflater.KDG.KEA = ((View)localObject).findViewById(2131297440);
      paramLayoutInflater.KDG.KEB = ((LinearLayout)((View)localObject).findViewById(2131302758));
      paramLayoutInflater.KDG.KEC = ((LinearLayout)((View)localObject).findViewById(2131299239));
      paramLayoutInflater.KDG.KEE = ((LinearLayout)((View)localObject).findViewById(2131302748));
      paramLayoutInflater.KDG.KEH = ((TextView)((View)localObject).findViewById(2131302750));
      paramLayoutInflater.KDG.KEJ = ((ImageView)((View)localObject).findViewById(2131302749));
      paramLayoutInflater.KDG.KEG = ((View)localObject).findViewById(2131302759);
      paramLayoutInflater.KDG.KEF = ((LinearLayout)((View)localObject).findViewById(2131302751));
      paramLayoutInflater.KDG.KEI = ((TextView)((View)localObject).findViewById(2131302753));
      paramLayoutInflater.KDG.KEK = ((ImageView)((View)localObject).findViewById(2131302752));
      paramLayoutInflater.KDG.KEL = ((ImageView)((View)localObject).findViewById(2131302742));
      paramLayoutInflater.KvK = ((ImageView)((View)localObject).findViewById(2131298117));
      paramLayoutInflater.KDG.KEM = ((View)localObject).findViewById(2131302774);
      paramLayoutInflater.KDG.KEN = ((ImageView)((View)localObject).findViewById(2131302775));
      paramLayoutInflater.KDG.KEO = ((TextView)((View)localObject).findViewById(2131302776));
      paramLayoutInflater.KDG.KEP = ((LinearLayout)((View)localObject).findViewById(2131302744));
      paramLayoutInflater.KDG.KEQ = ((TextView)((View)localObject).findViewById(2131302745));
      paramLayoutInflater.KDH.Kum = ((LinearLayout)((View)localObject).findViewById(2131302763));
      paramLayoutInflater.KDH.Kun = ((CdnImageView)((View)localObject).findViewById(2131302762));
      paramLayoutInflater.KDH.Kuo = ((TextView)((View)localObject).findViewById(2131302764));
      paramLayoutInflater.KDH.Kup = ((TextView)((View)localObject).findViewById(2131302761));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final com.tencent.mm.storage.bv parambv, final String paramString)
  {
    AppMethodBeat.i(37242);
    this.JWz = parama1;
    KAn = parama1.Kkd.getContext().getResources().getColor(2131100212);
    KAo = parama1.Kkd.getContext().getResources().getColor(2131100212);
    bi localbi = (bi)parama;
    final Map localMap = bx.M(parambv.field_content, "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ae.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localbi.olp.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    localbi.olp.setVisibility(0);
    final int j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.KAg = bu.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.KAh = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.IvT.d(this.KjR);
    ((com.tencent.mm.ui.chatting.d.b.j)parama1.bh(com.tencent.mm.ui.chatting.d.b.j.class)).b(this.KAd);
    Object localObject1;
    if (j != 0)
    {
      localbi.KDF.oiV.setVisibility(8);
      localObject1 = localbi.KDG;
      if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bp)localObject1, bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambv, false);
        if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2844;
        }
        ((bp)localObject1).KEj.setBackgroundResource(2131233299);
        label326:
        if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6676;
        }
      }
    }
    label518:
    label1162:
    label1682:
    label2963:
    label3347:
    label6676:
    for (int i = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      final int k = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      ((bp)localObject1).KEq.setVisibility(8);
      if ((i == 0) && (k == 0))
      {
        ((bp)localObject1).KEq.setVisibility(0);
        this.KAk = bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = c(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        ((bp)localObject1).KEq.setTextColor(al.gE(k));
        ((bp)localObject1).KEq.setText(this.KAk);
      }
      parama = bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = c(localMap, ".msg.appmsg.mmreader.template_header.first_color", KAo);
      label540:
      boolean bool1;
      label682:
      label698:
      Object localObject2;
      label840:
      Object localObject3;
      if (bu.isNullOrNil(parama))
      {
        ((bp)localObject1).KEr.setVisibility(8);
        if ((i == 0) || (!bu.isNullOrNil(parama))) {
          break label2963;
        }
        ((bp)localObject1).KEs.setVisibility(8);
        parama = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
        if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(parama)) {
          break label3267;
        }
        bool1 = on(v(localMap));
        if ("notifymessage".equals(parambv.field_talker))
        {
          parama1 = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
          ((com.tencent.mm.ui.chatting.d.b.j)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.j.class)).a(this.KAd);
          com.tencent.mm.sdk.b.a.IvT.c(this.KjR);
          if (!bool1) {
            break label3113;
          }
          parama = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(parama1);
          if (parama == null) {
            break label2975;
          }
          this.mAppId = parama.field_appId;
          parama = ((bp)localObject1).KEP;
          if (!this.KAl) {
            break label3001;
          }
          i = 0;
          parama.setVisibility(i);
          ((bp)localObject1).KEm.setVisibility(8);
          ((bp)localObject1).KEQ.setText(this.JWz.Kkd.getMMResources().getString(2131761766));
          this.KAf.iEF = true;
          this.KAf.iEG = true;
          parama = com.tencent.mm.msgsubscription.storage.a.iEd;
          paramString = this.KAg;
          parama = ((bp)localObject1).KEP.hashCode();
          d.g.b.p.h(paramString, "templateId");
          d.g.b.p.h(parama, "viewKey");
          localObject2 = (HashMap)com.tencent.mm.msgsubscription.storage.a.aON().get(paramString);
          if (localObject2 != null) {
            ((HashMap)localObject2).remove(parama);
          }
          if (localObject2 == null) {
            break label3008;
          }
          parama = Integer.valueOf(((HashMap)localObject2).size());
          ae.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString, parama });
          parama = com.tencent.mm.msgsubscription.storage.a.iEd;
          paramString = this.KAg;
          localObject2 = ((bp)localObject1).KEP.hashCode();
          localObject3 = new IBrandSubscribeMsgService.b()
          {
            public final void c(String paramAnonymousString, IBrandSubscribeMsgService.c paramAnonymousc)
            {
              AppMethodBeat.i(187835);
              if (paramAnonymousString.equals(ai.a(ai.this)))
              {
                ae.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", new Object[] { parama1, paramAnonymousString, Boolean.valueOf(paramAnonymousc.iEF), Boolean.valueOf(paramAnonymousc.iEG) });
                ai.a(ai.this, new IBrandSubscribeMsgService.c(paramAnonymousc.iEF, paramAnonymousc.iEG));
                ai.a(ai.this, localMap, parambv, this.KAw, ai.f(ai.this), true);
                if ((!ai.e(ai.this)) && (ai.g(ai.this) != null) && (ai.g(ai.this).isShowing())) {
                  ai.g(ai.this).cPF();
                }
              }
              AppMethodBeat.o(187835);
            }
            
            public final void onError()
            {
              AppMethodBeat.i(187836);
              ae.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
              AppMethodBeat.o(187836);
            }
          };
          d.g.b.p.h(paramString, "templateId");
          d.g.b.p.h(localObject2, "viewKey");
          d.g.b.p.h(localObject3, "callback");
          parama = (HashMap)com.tencent.mm.msgsubscription.storage.a.aON().get(paramString);
          if (parama != null) {
            break label6673;
          }
          parama = new HashMap();
        }
      }
      for (;;)
      {
        ((Map)parama).put(localObject2, localObject3);
        ((Map)com.tencent.mm.msgsubscription.storage.a.aON()).put(paramString, parama);
        ae.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString, Integer.valueOf(parama.size()) });
        parama = this.KAj;
        paramString = this.KAg;
        d.g.b.p.h(parama1, "bizUsername");
        d.g.b.p.h(paramString, "templateId");
        localObject2 = parama.iEb;
        d.g.b.p.h(parama1, "bizUsername");
        d.g.b.p.h(paramString, "templateId");
        localObject3 = ((com.tencent.mm.msgsubscription.storage.e)localObject2).iEH.bm(parama1, paramString);
        localObject2 = new y.f();
        ((y.f)localObject2).NiY = localObject3;
        Object localObject4 = parama.iEb;
        d.g.b.p.h(parama1, "bizUsername");
        boolean bool2 = ((com.tencent.mm.msgsubscription.storage.e)localObject4).iEH.Fe(parama1);
        if (localObject3 != null)
        {
          ae.v("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject3).iDl) });
          if (((SubscribeMsgTmpItem)localObject3).iDl == 1)
          {
            bool1 = true;
            com.tencent.mm.msgsubscription.storage.a.a(paramString, new IBrandSubscribeMsgService.c(bool1, bool2));
            localObject3 = (SubscribeMsgTmpItem)((y.f)localObject2).NiY;
            localObject2 = (SubscribeMsgTmpItem)((y.f)localObject2).NiY;
            if (localObject2 == null) {
              break label3019;
            }
            i = ((SubscribeMsgTmpItem)localObject2).iDl;
            label1210:
            parama.a((SubscribeMsgTmpItem)localObject3, new com.tencent.mm.msgsubscription.storage.a.b(parama1, paramString, i));
            label1228:
            ((bp)localObject1).KEo.setVisibility(0);
            ((bp)localObject1).KEo.setTag(2131302771, parambv);
            this.KzZ = new View.OnClickListener()
            {
              public final void onClick(final View paramAnonymousView)
              {
                AppMethodBeat.i(187854);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                localObject = (com.tencent.mm.storage.bv)paramAnonymousView.getTag(2131302771);
                if (localObject == null)
                {
                  ae.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(187854);
                  return;
                }
                final Map localMap = bx.M(((ei)localObject).field_content, "msg");
                if ((localMap == null) || (localMap.size() == 0))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(187854);
                  return;
                }
                final String str = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
                final int i = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                final int j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                ai.a(ai.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousView.getContext(), 1, false));
                ai.g(ai.this).LfS = new n.d()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(187852);
                    paramAnonymous2l.clear();
                    if (!ai.e(ai.this)) {
                      ai.a(ai.this, this.hHv, localMap, paramAnonymous2l, ai.f(ai.this));
                    }
                    paramAnonymous2l.add(0, 2, 0, paramAnonymousView.getResources().getString(2131761750));
                    AppMethodBeat.o(187852);
                  }
                };
                ai.g(ai.this).LfT = new n.e()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(187853);
                    ae.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(paramAnonymous2Int) });
                    switch (paramAnonymous2MenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(187853);
                      return;
                      ai.a(ai.this, paramAnonymousView.getContext(), this.hHv, str, i, j);
                      AppMethodBeat.o(187853);
                      return;
                      boolean bool = ai.cb(localMap);
                      ai.a(ai.this, this.hHv, localMap, bool, ai.f(ai.this), ai.28.this.KAw);
                    }
                  }
                };
                ai.g(ai.this).cPF();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187854);
              }
            };
            ((bp)localObject1).KEo.setOnClickListener(this.KzZ);
            label1276:
            ((bp)localObject1).KEi.setVisibility(8);
            parama = bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
            ((bp)localObject1).KEr.setText(parama);
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bu.isNullOrNil(parama1)) {
              break label3347;
            }
            i = al.gE(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
            j = al.gE(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
            k = al.gE(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
            int m = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
            ((bp)localObject1).KEu.setTextColor(i);
            ((bp)localObject1).KEw.setTextColor(j);
            ((bp)localObject1).KEx.setTextColor(k);
            ((bp)localObject1).KEx.getPaint().setFlags(16);
            ((bp)localObject1).KEu.setText(parama);
            if ((m <= 0) || (m >= parama1.length())) {
              break label3290;
            }
            ((bp)localObject1).KEv.setVisibility(0);
            ((bp)localObject1).KEv.setText(parama1.substring(0, m));
            ((bp)localObject1).KEv.setTextColor(j);
            ((bp)localObject1).KEv.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fV(this.JWz.Kkd.getContext()));
            ((bp)localObject1).KEw.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fV(this.JWz.Kkd.getContext()));
            ((bp)localObject1).KEw.setText(parama1.substring(m));
            label1655:
            if (bu.isNullOrNil(paramString)) {
              break label3334;
            }
            ((bp)localObject1).KEx.setText(paramString);
            ((bp)localObject1).KEx.setVisibility(0);
            ((bp)localObject1).KEt.setVisibility(0);
            label1691:
            i = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i != 2) {
              break label3513;
            }
            ae.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
            ((bp)localObject1).KEz.setVisibility(8);
            parama1 = (ViewGroup)((bp)localObject1).KEz.getParent();
            parama = parama1.findViewById(2131298909);
            if (parama != null) {
              break label6670;
            }
            parama = LayoutInflater.from(parama1.getContext()).inflate(2131495249, null);
            paramString = new bh();
            paramString.ka = ((ImageView)parama.findViewById(2131296996));
            paramString.KDE = ((TextView)parama.findViewById(2131302863));
            paramString.gqi = ((TextView)parama.findViewById(2131305902));
            parama.setTag(paramString);
            parama1.addView(parama);
          }
        }
        for (;;)
        {
          parama.setVisibility(0);
          paramString = (bh)parama.getTag();
          parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
          localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
          parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
          localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
          j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
          paramString.gqi.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.gqi.getContext(), parama));
          localObject3 = paramString.KDE;
          localObject4 = paramString.gqi.getContext();
          if (bu.isNullOrNil((String)localObject2)) {
            parama = "";
          }
          for (;;)
          {
            ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, parama));
            label2011:
            Object localObject5;
            if (j == 2)
            {
              paramString.ka.setImageDrawable(ak.getContext().getResources().getDrawable(2131230943));
              if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
                break label3524;
              }
              ((bp)localObject1).KEM.setVisibility(8);
              ((bp)localObject1).KEB.setVisibility(8);
              ((bp)localObject1).KED.setVisibility(8);
              ((bp)localObject1).KEC.setVisibility(0);
              ((bp)localObject1).KEA.setVisibility(0);
              a((bp)localObject1, parambv, localMap);
              label2089:
              paramString = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
              parama = null;
              if (!bu.isNullOrNil(paramString))
              {
                bc.aCg();
                parama = com.tencent.mm.model.c.azF().BH(paramString).adF();
              }
              localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
              localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
              parama1 = (String)localMap.get(".msg.appmsg.template_id");
              localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((!on(v(localMap))) || (i != 3)) {
                break label5085;
              }
              ((bp)localObject1).KEh.setTag(new bk(parambv, paramString));
              a(((bp)localObject1).KEh, parambv, localMap, paramString, i);
              label2262:
              ((bp)localObject1).KEh.setOnLongClickListener(c(this.JWz));
              ((bp)localObject1).KEh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
              if (com.tencent.mm.n.g.acM().acB())
              {
                localbi.KvK.setVisibility(0);
                c(this.JWz, localbi.KvK, new t.o(parama1, parambv, parama));
              }
              parama = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
              if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(parama)) || (!"notifymessage".equals(parambv.field_talker))) {
                break label5366;
              }
              ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
              ((bp)localObject1).KEp.setTag(null);
              ((bp)localObject1).KEp.setVisibility(8);
            }
            for (;;)
            {
              localbi.KDG.KEh.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
              {
                a((bp)localObject1, bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambv, true);
                break;
              }
              ((View)((bp)localObject1).KEn.getParent()).setVisibility(8);
              if ("notifymessage".equals(parambv.field_talker))
              {
                parama1 = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(parama1))
                {
                  paramString = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(parama1);
                  if (paramString == null)
                  {
                    parama = null;
                    label2596:
                    a(((bp)localObject1).KEk, this.JWz, parama1, parambv, parama);
                    if (paramString != null) {
                      break label2719;
                    }
                    parama = parama1;
                  }
                }
                for (;;)
                {
                  ((bp)localObject1).KEl.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JWz.Kkd.getContext(), parama, ((bp)localObject1).KEl.getTextSize()));
                  if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(parama1)) {
                    break label2768;
                  }
                  ((bp)localObject1).KEj.setTag(new bk(parambv, parama1));
                  ((bp)localObject1).KEj.setOnClickListener(this.Kva);
                  ((bp)localObject1).KEj.setVisibility(0);
                  break;
                  parama = paramString.field_brandIconURL;
                  break label2596;
                  label2719:
                  parama = paramString.field_nickname;
                  continue;
                  a(((bp)localObject1).KEk, this.JWz, parama1, parambv, null);
                  parama = ((com.tencent.mm.ui.chatting.d.b.f)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aXB(parama1);
                }
                label2768:
                paramString = ((bp)localObject1).KEj;
                if (this.JWz.fJC()) {}
                for (parama = this.JWz.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bk(parama1, parama));
                  ((bp)localObject1).KEj.setOnClickListener(e(this.JWz));
                  break;
                }
              }
              ((bp)localObject1).KEj.setVisibility(8);
              break;
              label2844:
              i = ((bp)localObject1).KEj.getPaddingLeft();
              ((bp)localObject1).KEj.setBackgroundResource(2131232867);
              ((bp)localObject1).KEj.setPadding(i, 0, 0, 0);
              break label326;
              ((bp)localObject1).KEr.setTextColor(al.gE(k));
              ((bp)localObject1).KEr.setText(parama);
              ((bp)localObject1).KEr.setVisibility(0);
              if (j == 2)
              {
                ((bp)localObject1).KEr.setPadding(0, this.JWz.Kkd.getMMResources().getDimensionPixelOffset(2131165480), 0, 0);
                break label518;
              }
              ((bp)localObject1).KEr.setPadding(0, 0, 0, 0);
              break label518;
              ((bp)localObject1).KEs.setVisibility(0);
              break label540;
              label2975:
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(parama1, new o.a()
              {
                public final void b(WxaAttributes paramAnonymousWxaAttributes)
                {
                  AppMethodBeat.i(187834);
                  if (paramAnonymousWxaAttributes != null)
                  {
                    ae.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ai.d(ai.this) });
                    ai.b(ai.this, paramAnonymousWxaAttributes.field_appId);
                  }
                  AppMethodBeat.o(187834);
                }
              });
              break label682;
              label3001:
              i = 8;
              break label698;
              label3008:
              parama = null;
              break label840;
              bool1 = false;
              break label1162;
              label3019:
              i = -1;
              break label1210;
              ae.i("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from local");
              localObject3 = parama.iEb;
              parama = (e.b)new a.d(parama, paramString, (y.f)localObject2);
              d.g.b.p.h(parama1, "username");
              ae.i("Mp.SubscribeMsgDataLoader", "alvinluo loadSubscribeMsgListByUsername username: %s", new Object[] { parama1 });
              paramString = com.tencent.mm.msgsubscription.storage.g.iEM;
              com.tencent.mm.msgsubscription.storage.g.a(((com.tencent.mm.msgsubscription.storage.e)localObject3).iEH, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.f(parama1, ((com.tencent.mm.msgsubscription.storage.e)localObject3).iEH, parama));
              break label1228;
              label3113:
              this.KAf.iEG = false;
              parama = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(parama1);
              if (parama != null)
              {
                this.mAppId = parama.field_appId;
                if ((parama.field_appOpt & 0x1) > 0)
                {
                  i = 1;
                  label3161:
                  parama = this.KAf;
                  if (i != 0) {
                    break label3204;
                  }
                  bool1 = true;
                  label3174:
                  parama.iEF = bool1;
                }
              }
              for (;;)
              {
                a(localMap, parambv, (bp)localObject1, this.KAf, false);
                break;
                i = 0;
                break label3161;
                bool1 = false;
                break label3174;
                ae.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama1 });
                this.KAf.iEF = true;
                ((o)com.tencent.mm.kernel.g.ab(o.class)).a(parama1, new o.a()
                {
                  public final void b(WxaAttributes paramAnonymousWxaAttributes)
                  {
                    boolean bool = true;
                    AppMethodBeat.i(187838);
                    if (paramAnonymousWxaAttributes == null)
                    {
                      AppMethodBeat.o(187838);
                      return;
                    }
                    ai.b(ai.this, paramAnonymousWxaAttributes.field_appId);
                    int i;
                    if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0)
                    {
                      i = 1;
                      paramAnonymousWxaAttributes = ai.f(ai.this);
                      if (i != 0) {
                        break label79;
                      }
                    }
                    for (;;)
                    {
                      paramAnonymousWxaAttributes.iEF = bool;
                      ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(187837);
                          ai.a(ai.this, ai.10.this.fMB, ai.10.this.hHv, ai.10.this.KAw, ai.f(ai.this), false);
                          AppMethodBeat.o(187837);
                        }
                      });
                      AppMethodBeat.o(187838);
                      return;
                      i = 0;
                      break;
                      label79:
                      bool = false;
                    }
                  }
                });
              }
              label3267:
              ((bp)localObject1).KEP.setVisibility(8);
              ((bp)localObject1).KEm.setVisibility(8);
              break label1276;
              label3290:
              ((bp)localObject1).KEv.setTypeface(Typeface.DEFAULT);
              ((bp)localObject1).KEv.setVisibility(8);
              ((bp)localObject1).KEw.setTypeface(Typeface.DEFAULT);
              ((bp)localObject1).KEw.setText(parama1);
              break label1655;
              ((bp)localObject1).KEx.setVisibility(8);
              break label1682;
              ((bp)localObject1).KEt.setVisibility(8);
              break label1691;
              parama = null;
              if (x.wb((String)localObject2))
              {
                bc.aCg();
                localObject5 = com.tencent.mm.model.c.azF().BH((String)localObject2);
                if (localObject5 != null)
                {
                  if (((an)localObject5).adG() != null) {
                    break label3453;
                  }
                  parama = ((an)localObject5).adF();
                }
              }
              for (;;)
              {
                if (!bu.isNullOrNil(parama)) {
                  break label6667;
                }
                ae.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
                parama = parama1;
                if (parama1 != null) {
                  break;
                }
                parama = ak.getContext().getString(2131757293);
                break;
                label3453:
                parama = ((an)localObject5).adG();
                continue;
                bc.aCg();
                parama = com.tencent.mm.model.c.azF().BH((String)localObject2);
                if (parama.adG() == null) {
                  parama = parama.adF();
                } else {
                  parama = parama.adG();
                }
              }
              com.tencent.mm.pluginsdk.ui.a.b.c(paramString.ka, (String)localObject2);
              break label2011;
              label3513:
              a((bp)localObject1, localMap);
              break label2011;
              label3524:
              ((bp)localObject1).KEC.setVisibility(8);
              parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
              parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
              if (!bu.isNullOrNil(parama1))
              {
                j = al.gE(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
                ((bp)localObject1).KEH.setTextColor(j);
                ((bp)localObject1).KEH.setText(parama1);
                if (bu.isNullOrNil(parama))
                {
                  ((bp)localObject1).KEJ.setVisibility(8);
                  ((bp)localObject1).KEH.setPadding(0, 0, 0, 0);
                  label3649:
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                  parama1 = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  localObject3 = new bk(parambv, parama1, (String)localObject2);
                  ((bp)localObject1).KEE.setTag(localObject3);
                  ((bp)localObject1).KEM.setTag(localObject3);
                  if ((!on(v(localMap))) || (j != 3)) {
                    break label4395;
                  }
                  a(((bp)localObject1).KEE, parambv, localMap, parama1, j);
                  label3782:
                  ((bp)localObject1).KEE.setVisibility(0);
                  label3791:
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                  parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                  if (bu.isNullOrNil(paramString)) {
                    break label4747;
                  }
                  j = al.gE(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.JWz.Kkd.getContext().getResources().getColor(2131100711)));
                  ((bp)localObject1).KEI.setTextColor(j);
                  ((bp)localObject1).KEI.setText(paramString);
                  if (!bu.isNullOrNil(parama1)) {
                    break label4561;
                  }
                  ((bp)localObject1).KEK.setVisibility(8);
                  ((bp)localObject1).KEI.setPadding(0, 0, 0, 0);
                  label3909:
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                  paramString = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                  ((bp)localObject1).KEF.setTag(new bk(parambv, paramString, (String)localObject3));
                  if ((!on(v(localMap))) || (j != 3)) {
                    break label4608;
                  }
                  a(((bp)localObject1).KEF, parambv, localMap, paramString, j);
                  label4031:
                  ((bp)localObject1).KEF.setVisibility(0);
                  label4040:
                  ((bp)localObject1).KEL.setVisibility(8);
                  if ((((bp)localObject1).KEE.getVisibility() != 8) || (((bp)localObject1).KEF.getVisibility() != 8)) {
                    break label4760;
                  }
                  ((bp)localObject1).KEB.setVisibility(8);
                  ((bp)localObject1).KEA.setVisibility(8);
                  ((bp)localObject1).KED.setVisibility(8);
                  if ((((bp)localObject1).KEE.getVisibility() != 0) || (((bp)localObject1).KEF.getVisibility() != 0)) {
                    break label5041;
                  }
                  ((bp)localObject1).KEG.setVisibility(0);
                  label4137:
                  parama = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  if ((an.zd(parama)) || (((bp)localObject1).KEE.getVisibility() == 8) || (((bp)localObject1).KEF.getVisibility() != 8) || (j != 1) || (!an.zd(paramString))) {
                    break label5072;
                  }
                  localObject2 = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(paramString);
                  if (localObject2 != null) {
                    break label5054;
                  }
                  parama = null;
                  label4260:
                  if (localObject2 != null) {
                    break label5063;
                  }
                }
              }
              label4395:
              label5041:
              label5054:
              label5063:
              for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
              {
                com.tencent.mm.av.q.aJb().a(parama, ((bp)localObject1).KEN, this.JnE);
                ((bp)localObject1).KEO.setText(parama1);
                if (localObject2 == null) {
                  ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramString, new o.a()
                  {
                    public final void b(WxaAttributes paramAnonymousWxaAttributes)
                    {
                      AppMethodBeat.i(187846);
                      if (paramAnonymousWxaAttributes == null)
                      {
                        AppMethodBeat.o(187846);
                        return;
                      }
                      ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(187845);
                          com.tencent.mm.av.q.aJb().a(this.pKf, ai.20.this.KAw.KEN, ai.m(ai.this));
                          if (TextUtils.isEmpty(this.ngT)) {}
                          for (String str = ai.20.this.KAE;; str = this.ngT)
                          {
                            ai.20.this.KAw.KEO.setText(str);
                            AppMethodBeat.o(187845);
                            return;
                          }
                        }
                      });
                      AppMethodBeat.o(187846);
                    }
                  });
                }
                ((bp)localObject1).KEM.setVisibility(0);
                ((bp)localObject1).KEB.setVisibility(8);
                break;
                ((bp)localObject1).KEJ.setVisibility(0);
                l(((bp)localObject1).KEJ, parama);
                ((bp)localObject1).KEH.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 16), 0);
                break label3649;
                if ((j == 1) && (!TextUtils.isEmpty(paramString)))
                {
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                  j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                  k = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                  parama1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(169890);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                      paramAnonymousView = (bk)paramAnonymousView.getTag();
                      ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                      localObject = new AppBrandStatObject();
                      ((AppBrandStatObject)localObject).dlj = (paramAnonymousView.dCi.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kxv);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramAnonymousView.userName))
                      {
                        ((AppBrandStatObject)localObject).scene = ai.Vb(this.Kxv);
                        ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ai.b(ai.this).Kkd.getContext(), paramString, null, k, j, this.KAH, (AppBrandStatObject)localObject);
                        ai.mv(ai.d(ai.this), ai.a(ai.this));
                        com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), parama1, Integer.valueOf(1) });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169890);
                        return;
                      }
                      ((AppBrandStatObject)localObject).scene = 1043;
                      paramAnonymousView = com.tencent.mm.al.g.eX(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.p localp = (com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class);
                      Activity localActivity = ai.b(ai.this).Kkd.getContext();
                      String str1 = paramString;
                      int i = k;
                      int j = j;
                      String str2 = this.KAH;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localp.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                        break;
                      }
                    }
                  };
                  ((bp)localObject1).KEE.setOnClickListener(parama1);
                  ((bp)localObject1).KEM.setOnClickListener(parama1);
                  break label3782;
                }
                ((bp)localObject1).KEE.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37224);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    if (!bu.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      paramAnonymousView.putExtra("geta8key_username", parama1);
                      c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                      com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), parama1, Integer.valueOf(1) });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37224);
                  }
                });
                ((bp)localObject1).KEM.setOnClickListener(null);
                break label3782;
                ((bp)localObject1).KEE.setVisibility(8);
                break label3791;
                label4561:
                ((bp)localObject1).KEK.setVisibility(0);
                l(((bp)localObject1).KEK, parama1);
                ((bp)localObject1).KEI.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 16), 0);
                break label3909;
                if ((j == 1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                  j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                  k = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                  localObject4 = bu.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                  ((bp)localObject1).KEF.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37225);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                      paramAnonymousView = (bk)paramAnonymousView.getTag();
                      ae.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.KAE });
                      localObject = new AppBrandStatObject();
                      ((AppBrandStatObject)localObject).dlj = (paramAnonymousView.dCi.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kxv);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramAnonymousView.userName))
                      {
                        ((AppBrandStatObject)localObject).scene = ai.Vb(this.Kxv);
                        ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ai.b(ai.this).Kkd.getContext(), this.KAE, null, k, j, this.KAH, (AppBrandStatObject)localObject);
                        ai.mv(ai.d(ai.this), ai.a(ai.this));
                        com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), paramString, Integer.valueOf(2) });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37225);
                        return;
                      }
                      ((AppBrandStatObject)localObject).scene = 1043;
                      paramAnonymousView = com.tencent.mm.al.g.eX(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.p localp = (com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class);
                      Activity localActivity = ai.b(ai.this).Kkd.getContext();
                      String str1 = this.KAE;
                      int i = k;
                      int j = j;
                      String str2 = this.KAH;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localp.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                        break;
                      }
                    }
                  });
                  break label4031;
                }
                ((bp)localObject1).KEF.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37226);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    if (!bu.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                      com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ai.a(ai.this), paramString, Integer.valueOf(2) });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37226);
                  }
                });
                break label4031;
                ((bp)localObject1).KEF.setVisibility(8);
                break label4040;
                ((bp)localObject1).KED.setVisibility(0);
                j = this.JWz.Kkd.getMMResources().getDimensionPixelOffset(2131165480);
                if ((((bp)localObject1).KEE.getVisibility() == 0) && (((bp)localObject1).KEF.getVisibility() == 0))
                {
                  ((bp)localObject1).KEE.setGravity(17);
                  ((bp)localObject1).KEF.setGravity(17);
                  ((bp)localObject1).KEE.setPadding(j, 0, j, 0);
                  ((bp)localObject1).KEF.setPadding(j, 0, j, 0);
                }
                for (;;)
                {
                  ((bp)localObject1).KEB.setVisibility(0);
                  ((bp)localObject1).KEA.setVisibility(0);
                  break;
                  if (((bp)localObject1).KEE.getVisibility() == 0)
                  {
                    if (bu.isNullOrNil(parama))
                    {
                      ((bp)localObject1).KEE.setGravity(19);
                      ((bp)localObject1).KEE.setPadding(j, 0, 0, 0);
                      ((bp)localObject1).KEL.setVisibility(0);
                    }
                    else
                    {
                      ((bp)localObject1).KEE.setGravity(17);
                      ((bp)localObject1).KEE.setPadding(j, 0, j, 0);
                    }
                  }
                  else if (bu.isNullOrNil(parama1))
                  {
                    ((bp)localObject1).KEF.setGravity(19);
                    ((bp)localObject1).KEF.setPadding(this.JWz.Kkd.getMMResources().getDimensionPixelOffset(2131165480), 0, 0, 0);
                    ((bp)localObject1).KEL.setVisibility(0);
                  }
                  else
                  {
                    ((bp)localObject1).KEF.setGravity(17);
                    ((bp)localObject1).KEF.setPadding(j, 0, j, 0);
                  }
                }
                ((bp)localObject1).KEG.setVisibility(8);
                break label4137;
                parama = ((WxaAttributes)localObject2).field_brandIconURL;
                break label4260;
              }
              label4760:
              label5072:
              ((bp)localObject1).KEM.setVisibility(8);
              break label2089;
              label5085:
              if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject5)))
              {
                paramString = new bk(parambv, paramString, (String)localObject4);
                paramString.position = paramInt;
                ((bp)localObject1).KEh.setTag(paramString);
                ((bp)localObject1).KEh.setOnClickListener(this.qri);
                break label2262;
              }
              if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramString)))
              {
                localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                localObject5 = ((bp)localObject1).KEh;
                paramString = new bk(parambv, false, paramInt, paramString, false, this.JWz.fGT(), paramString, parama, (String)localObject3);
                paramString.dPb = ((String)localObject2);
                paramString.pageUrl = ((String)localObject4);
                ((View)localObject5).setTag(paramString);
                ((bp)localObject1).KEh.setOnClickListener(this.KAb);
                break label2262;
              }
              if (i == 2)
              {
                paramString = new bk(parambv, paramString, (String)localObject4);
                paramString.position = paramInt;
                ((bp)localObject1).KEh.setTag(paramString);
                ((bp)localObject1).KEh.setOnClickListener(this.qri);
                break label2262;
              }
              ((bp)localObject1).KEh.setTag(new bk(parambv, false, paramInt, (String)localObject4, false, this.JWz.fGT(), paramString, parama, (String)localObject3).aYk((String)localObject2));
              ((bp)localObject1).KEh.setOnClickListener(h(this.JWz));
              break label2262;
              label5366:
              if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label5448;
                }
                ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              }
              label5448:
              do
              {
                ((bp)localObject1).KEo.setTag(null);
                ((bp)localObject1).KEp.setTag(null);
                ((bp)localObject1).KEo.setVisibility(8);
                ((bp)localObject1).KEp.setVisibility(8);
                break;
                paramInt = 0;
                break label5389;
                if (((bp)localObject1).KEj.getVisibility() == 0)
                {
                  ((bp)localObject1).KEo.setTag(parambv);
                  ((bp)localObject1).KEo.setOnClickListener(this.KAa);
                  ((bp)localObject1).KEo.setVisibility(0);
                  ((bp)localObject1).KEp.setVisibility(8);
                  break;
                }
              } while (((bp)localObject1).KEs.getVisibility() != 0);
              ((bp)localObject1).KEp.setTag(parambv);
              ((bp)localObject1).KEp.setOnClickListener(this.KAa);
              ((bp)localObject1).KEp.setVisibility(0);
              ((bp)localObject1).KEo.setVisibility(8);
            }
            localbi.KDG.KEh.setVisibility(8);
            parama1 = bu.nullAsNil((String)localMap.get(".msg.fromusername"));
            i = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
            ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
            if (i == 1)
            {
              parama = bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
              paramString = bu.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
              a(localbi, com.tencent.mm.pluginsdk.ui.span.k.b(this.JWz.getContext(), paramString, localbi.yUp.getTextSize()));
              localbi.KuH.setTag(null);
              localbi.KuH.setOnClickListener(null);
              com.tencent.mm.av.q.aJb().a(parama, localbi.KuH, this.JnE);
              ae.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambv.Wa() });
              if ((!"notifymessage".equals(parambv.Wa())) && (i != 1)) {
                break label6374;
              }
              localbi.KDF.KDI.setVisibility(0);
              localbi.KDF.gqi.setTextSize(0, com.tencent.mm.cb.a.ax(localbi.KDF.gqi.getContext(), 2131165517));
              label5811:
              localbi.KDF.oiV.setVisibility(0);
              paramString = b.cc(localMap);
              localbi.KDF.gqi.setText(paramString.title);
              aj.a(localbi.KDF.KDM, localMap);
              parama = null;
              if (!bu.isNullOrNil(parama1))
              {
                bc.aCg();
                parama = com.tencent.mm.model.c.azF().BH(parama1).adF();
              }
              if (bu.isNullOrNil(paramString.url)) {
                break label6420;
              }
              i = 1;
              j = bu.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
              localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label6426;
              }
              parama1 = new bk(parambv, parama1, paramString.url);
              parama1.position = paramInt;
              localbi.KDF.oiV.setTag(parama1);
              localbi.KDF.oiV.setOnClickListener(this.qri);
              i = 1;
              label5999:
              localbi.KDF.oiV.setOnLongClickListener(c(this.JWz));
              localbi.KDF.oiV.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
              if (i != 0) {
                break label6545;
              }
              localbi.KDF.KDN.setVisibility(8);
              localbi.KDF.KDL.setVisibility(8);
              label6078:
              if (com.tencent.mm.n.g.acM().acB())
              {
                localbi.KvK.setVisibility(0);
                c(this.JWz, localbi.KvK, new t.o(paramString.hDH, parambv, parama));
              }
              parama = localbi.KDF;
              if (bu.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
                break label6572;
              }
              paramInt = 1;
              if (paramInt != 0) {
                break label6577;
              }
              ae.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              parama.KDJ.setTag(null);
              parama.KDK.setTag(null);
              parama.KDJ.setVisibility(8);
              parama.KDK.setVisibility(8);
            }
            for (;;)
            {
              localbi.KDF.oiV.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              a(localbi, this.JWz, parambv, parama1);
              a(localbi.KuH, this.JWz, parama1, parambv, null);
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(parama1))
              {
                localbi.KDF.KDI.setTag(new bk(parambv, parama1));
                localbi.KDF.KDI.setOnClickListener(this.Kva);
                break;
              }
              paramString = localbi.KDF.KDI;
              if (this.JWz.fJC()) {}
              for (parama = this.JWz.getTalkerUserName();; parama = null)
              {
                paramString.setTag(new bk(parama1, parama));
                localbi.KDF.KDI.setOnClickListener(e(this.JWz));
                break;
              }
              label6374:
              localbi.KDF.KDI.setVisibility(8);
              localbi.KDF.gqi.setTextSize(0, com.tencent.mm.cb.a.ax(localbi.KDF.gqi.getContext(), 2131165184));
              break label5811;
              label6420:
              i = 0;
              break label5900;
              label6426:
              if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy(paramString.url)) {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramString.url, -1, 2, new Object[0]);
              }
              localbi.KDF.oiV.setTag(new bk(parambv, false, paramInt, paramString.url, false, this.JWz.fGT(), parama1, parama, paramString.title).aYk(paramString.dPb));
              localbi.KDF.oiV.setOnClickListener(h(this.JWz));
              break label5999;
              localbi.KDF.KDN.setVisibility(0);
              localbi.KDF.KDL.setVisibility(0);
              break label6078;
              label6572:
              paramInt = 0;
              break label6152;
              label6577:
              if (parama.KDI.getVisibility() == 0)
              {
                parama.KDJ.setTag(parambv);
                parama.KDJ.setOnClickListener(this.KAa);
                parama.KDJ.setVisibility(0);
                parama.KDK.setVisibility(8);
              }
              else
              {
                parama.KDK.setTag(parambv);
                parama.KDK.setOnClickListener(this.KAa);
                parama.KDK.setVisibility(0);
                parama.KDJ.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bv parambv, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.yUp == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    parambv = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aXB(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parambv, parama.yUp.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(37244);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37244);
      return false;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(187857);
    parambv = (bk)paramView.getTag();
    if (parambv == null)
    {
      AppMethodBeat.o(187857);
      return false;
    }
    int i = parambv.position;
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
    }
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
      paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
    }
    AppMethodBeat.o(187857);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  protected final boolean fLC()
  {
    return this.KAh == 0;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(37238);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      if (!(paramView.getTag() instanceof com.tencent.mm.storage.bv))
      {
        ae.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      localObject = (com.tencent.mm.storage.bv)paramView.getTag();
      if (localObject == null)
      {
        ae.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = bx.M(((ei)localObject).field_content, "msg");
      if ((localMap == null) || (localMap.size() == 0))
      {
        ae.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      bu.nullAsNil((String)localMap.get(".msg.fromusername"));
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
      locale.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(37233);
          paramAnonymousl.add(0, 1, 0, paramView.getResources().getString(2131761750));
          AppMethodBeat.o(37233);
        }
      };
      locale.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(37237);
          ae.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()), Integer.valueOf(paramAnonymousInt) });
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37237);
            return;
            bc.ajj().a(1198, new com.tencent.mm.ak.f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, final String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(37235);
                bc.ajj().b(1198, this);
                ae.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, Boolean.FALSE });
                if (ai.h(ai.this) != null)
                {
                  ai.h(ai.this).dismiss();
                  ai.a(ai.this, null);
                }
                if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
                {
                  t.makeText(ai.a.2.this.val$v.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                if (ai.a.2.this.hHv != ai.a.2.this.val$v.getTag())
                {
                  ae.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(ai.a.2.this.hHv.field_msgId) });
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = ((com.tencent.mm.modelappbrand.s)paramAnonymous2n).aEe();
                if (paramAnonymous2String == null)
                {
                  t.makeText(ai.a.2.this.val$v.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = paramAnonymous2String.Inl;
                paramAnonymous2n = bu.nullAsNil((String)ai.a.2.this.fMB.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zd(paramAnonymous2n))
                {
                  ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramAnonymous2n, new o.a()
                  {
                    public final void b(WxaAttributes paramAnonymous3WxaAttributes)
                    {
                      AppMethodBeat.i(37234);
                      if (paramAnonymous3WxaAttributes == null)
                      {
                        t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      Object localObject = paramAnonymous3WxaAttributes.field_appId;
                      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous2String)))
                      {
                        ae.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous2String });
                        t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      try
                      {
                        int i = bu.getInt((String)ai.a.2.this.fMB.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                        int j = bu.getInt((String)ai.a.2.this.fMB.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                        paramAnonymous3WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8"), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
                        ae.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, localObject, paramAnonymous3WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous3WxaAttributes);
                        c.t((Intent)localObject, ai.b(ai.this).getTalkerUserName());
                        com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37234);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous3WxaAttributes)
                      {
                        ae.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                      }
                    }
                  });
                  AppMethodBeat.o(37235);
                  return;
                }
                ae.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { paramAnonymous2n });
                try
                {
                  paramAnonymous2n = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { paramAnonymous2n, URLEncoder.encode(ai.a(ai.this), "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8") });
                  ae.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, ai.a(ai.this), paramAnonymous2n });
                  paramAnonymous2String = new Intent();
                  paramAnonymous2String.putExtra("rawUrl", paramAnonymous2n);
                  c.t(paramAnonymous2String, ai.b(ai.this).getTalkerUserName());
                  com.tencent.mm.br.d.b(ai.b(ai.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2String);
                  AppMethodBeat.o(37235);
                  return;
                }
                catch (UnsupportedEncodingException paramAnonymous2String)
                {
                  ae.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                  t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                  AppMethodBeat.o(37235);
                }
              }
            });
            paramAnonymousMenuItem = new com.tencent.mm.modelappbrand.s(this.hHv.field_content);
            ai localai = ai.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            ai.a(localai, h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(37236);
                bc.ajj().a(paramAnonymousMenuItem);
                AppMethodBeat.o(37236);
              }
            }));
            bc.ajj().a(paramAnonymousMenuItem, 0);
          }
        }
      };
      locale.cPF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
    }
  }
  
  public static final class b
  {
    public String dPb;
    public String hDH;
    public String hGc;
    public String hGd;
    public String hGe;
    public String hGf;
    public String hGg;
    public long time;
    public String title;
    public int type;
    public String url;
    
    public static b cc(Map<String, String> paramMap)
    {
      AppMethodBeat.i(37239);
      b localb = new b();
      localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
      localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
      localb.dPb = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
      localb.hGc = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
      localb.hGd = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
      localb.time = bu.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
      localb.hGe = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
      localb.hGf = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
      localb.hGg = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
      localb.type = bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
      localb.hDH = ((String)paramMap.get(".msg.appmsg.template_id"));
      AppMethodBeat.o(37239);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai
 * JD-Core Version:    0.7.0.1
 */