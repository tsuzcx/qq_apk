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
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.s;
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
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.o;
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
  private static int KdU;
  private static int KdV;
  private com.tencent.mm.ui.base.p AVf;
  private com.tencent.mm.aw.a.a.c ISW;
  private com.tencent.mm.ui.chatting.e.a JBI;
  private com.tencent.mm.sdk.b.c<nw> JOF;
  private View.OnClickListener JYH;
  private View.OnClickListener KdG;
  private View.OnClickListener KdH;
  private View.OnClickListener KdI;
  private View.OnClickListener KdJ;
  private com.tencent.mm.ui.l KdK;
  private View.OnClickListener KdL;
  private IBrandSubscribeMsgService.c KdM;
  private String KdN;
  private int KdO;
  private com.tencent.mm.msgsubscription.storage.a KdP;
  private com.tencent.mm.msgsubscription.storage.a KdQ;
  private String KdR;
  private boolean KdS;
  private com.tencent.mm.ui.widget.a.e KdT;
  private com.tencent.mm.ui.base.p fQJ;
  private String mAppId;
  private View.OnClickListener qkD;
  
  static
  {
    AppMethodBeat.i(37267);
    KdU = com.tencent.mm.sdk.platformtools.aj.getContext().getResources().getColor(2131100212);
    KdV = com.tencent.mm.sdk.platformtools.aj.getContext().getResources().getColor(2131100212);
    AppMethodBeat.o(37267);
  }
  
  public ai()
  {
    AppMethodBeat.i(37240);
    this.KdM = new IBrandSubscribeMsgService.c(true, false);
    this.KdR = "";
    this.KdS = false;
    this.KdT = null;
    Object localObject = new com.tencent.mm.aw.a.a.c.a();
    ((com.tencent.mm.aw.a.a.c.a)localObject).hfi = true;
    ((com.tencent.mm.aw.a.a.c.a)localObject).idD = 2131231342;
    this.ISW = ((com.tencent.mm.aw.a.a.c.a)localObject).aJc();
    localObject = com.tencent.mm.msgsubscription.storage.f.iBR;
    this.KdP = com.tencent.mm.msgsubscription.storage.f.Ig("name_biz");
    localObject = com.tencent.mm.msgsubscription.storage.f.iBR;
    this.KdQ = com.tencent.mm.msgsubscription.storage.f.Ig("name_wxa");
    this.KdH = new a((byte)0);
    this.KdL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = bw.M(paramAnonymousView.dBd.field_content, "msg");
        localObject1 = bt.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), localObject1, Integer.valueOf(66666) });
        localObject1 = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bt.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!bt.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.t((Intent)localObject1, ai.b(ai.this).getTalkerUserName());
            com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37198);
          return;
          String str = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
          int i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
          int j = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
          localObject2 = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.dkh = (paramAnonymousView.dBd.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + (String)localObject2);
          localAppBrandStatObject.scene = ai.Uq((String)localObject2);
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(ai.b(ai.this).JOR.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        }
      }
    };
    this.JYH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = (bk)paramAnonymousView.getTag();
        Object localObject2 = bw.M(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dBd.field_content, "msg");
        if ((localObject2 != null) && (((Map)localObject2).size() != 0))
        {
          bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
          if (!ai.bW((Map)localObject2)) {}
        }
        for (boolean bool = bt.getBoolean((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false);; bool = false)
        {
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click, blockProfile: %b", new Object[] { ((bk)localObject1).userName, Boolean.valueOf(bool) });
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
    this.JOF = new com.tencent.mm.sdk.b.c() {};
    this.KdK = new com.tencent.mm.ui.l()
    {
      public final void fws() {}
      
      public final void fwt() {}
      
      public final void fwu() {}
      
      public final void fwv() {}
      
      public final void fww() {}
      
      public final void fwx()
      {
        AppMethodBeat.i(194455);
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        com.tencent.mm.sdk.b.a.IbL.d(ai.c(ai.this));
        if (ai.b(ai.this) != null) {
          ((com.tencent.mm.ui.chatting.d.b.j)ai.b(ai.this).bh(com.tencent.mm.ui.chatting.d.b.j.class)).b(this);
        }
        AppMethodBeat.o(194455);
      }
      
      public final void fwy() {}
    };
    this.KdI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194456);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        bk localbk = (bk)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbk.userName });
        vm localvm = new vm();
        localvm.dJF.userName = localbk.userName;
        localvm.dJF.dJH = localbk.pageUrl;
        Map localMap = bw.M(localbk.dBd.field_content, "msg");
        localObject = "";
        paramAnonymousView = (View)localObject;
        if (localMap != null)
        {
          paramAnonymousView = (View)localObject;
          if (localMap.size() > 0)
          {
            localvm.dJF.dJI = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localvm.dJF.dJL = true;
        localvm.dJF.scene = ai.Uq(paramAnonymousView);
        localvm.dJF.dkh = (localbk.dBd.field_msgSvrId + ":" + localbk.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + paramAnonymousView);
        com.tencent.mm.sdk.b.a.IbL.l(localvm);
        ai.mo(ai.d(ai.this), ai.a(ai.this));
        com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), localbk.userName, Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194456);
      }
    };
    this.qkD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = (bk)paramAnonymousView.getTag();
        Object localObject2 = bw.M(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dBd.field_content, "msg");
        if (localObject2 == null)
        {
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
        }
        int i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String str1;
        String str2;
        int j;
        if (i == 1)
        {
          str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
          str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
          i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          j = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).dkh = (((bk)localObject1).dBd.field_msgSvrId + ":" + ((bk)localObject1).userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(((bk)localObject1).userName))
          {
            ((AppBrandStatObject)localObject2).scene = ai.Uq(paramAnonymousView);
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(ai.b(ai.this).JOR.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
            ai.mo(ai.d(ai.this), ai.a(ai.this));
            com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), ((bk)localObject1).userName, Integer.valueOf(0) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
          ((AppBrandStatObject)localObject2).scene = 1043;
          paramAnonymousView = com.tencent.mm.am.g.eS(((bk)localObject1).userName);
          o localo = (o)com.tencent.mm.kernel.g.ab(o.class);
          Activity localActivity = ai.b(ai.this).JOR.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localo.a(localActivity, str1, null, j, i, str2, (AppBrandStatObject)localObject2, paramAnonymousView);
            break;
          }
          if (i == 2)
          {
            localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
            long l = bt.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
            ai.c(paramAnonymousView.getContext(), (String)localObject1, l);
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
          }
        }
      }
    };
    this.KdJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        int i = paramAnonymousView.KhC;
        localObject1 = paramAnonymousView.KhD;
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "jumpNativePage nativePageType: %d, nativePageInfo: %s", new Object[] { Integer.valueOf(paramAnonymousView.KhC), paramAnonymousView.KhD });
        Object localObject3;
        Object localObject2;
        if (i == 1)
        {
          paramAnonymousView = ai.b(ai.this).JOR.getContext();
          ad.i("SnsAdUtil", "type = 0content = ".concat(String.valueOf(localObject1)));
          localObject3 = com.tencent.mm.plugin.sns.data.j.axP((String)localObject1);
          localObject1 = ((r)localObject3).ktn;
          localObject2 = ((r)localObject3).dFy;
          localObject3 = ((r)localObject3).kto;
          if (paramAnonymousView != null) {
            if (!bt.V(new String[] { localObject1, localObject2, localObject3 })) {
              break label192;
            }
          }
          ad.e("SnsAdUtil", "context or canvasId or uxInfo or adInfoXml is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37232);
          return;
          label192:
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_landing_pages_xml", "");
          ((Intent)localObject2).putExtra("sns_landing_pages_pageid", bt.aRf((String)localObject1));
          ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
          ((Intent)localObject2).putExtra("sns_landing_pages_ad_info", (String)localObject3);
          com.tencent.mm.bs.d.b(paramAnonymousView, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject2);
        }
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private static void V(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    ad.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.g.yhR.f(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bt.aQJ()) });
    AppMethodBeat.o(37253);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.e.a parama, String paramString1, com.tencent.mm.storage.bu parambu, String paramString2)
  {
    AppMethodBeat.i(37246);
    if (paramImageView == null)
    {
      AppMethodBeat.o(37246);
      return;
    }
    if (w.Ap(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(37246);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(paramString1))
    {
      com.tencent.mm.aw.q.aIJ().a(paramString2, paramImageView, this.ISW);
      paramImageView.setTag(new bk(parambu, paramString1));
      paramImageView.setOnClickListener(this.JYH);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(v.zf(paramString1) + parama.JOR.getContext().getString(2131756087));
      AppMethodBeat.o(37246);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
    if (parama.fFv()) {}
    for (parambu = parama.getTalkerUserName();; parambu = null)
    {
      paramImageView.setTag(new bk(paramString1, parambu));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(bp parambp, com.tencent.mm.storage.bu parambu, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    LinearLayout localLinearLayout = parambp.Kii;
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
        if (!bt.isNullOrNil(str1)) {
          break label194;
        }
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
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
        k = al.gD(c(paramMap, parambp + ".color", this.JBI.JOR.getContext().getResources().getColor(2131100711)));
        ((a)localObject1).gnM.setTextColor(k);
        if (bt.getInt((String)paramMap.get(parambp + ".is_rich_text"), 0) != 0) {
          break label874;
        }
        ((a)localObject1).gnM.setSingleLine(true);
        ((a)localObject1).gnM.setEllipsize(TextUtils.TruncateAt.END);
        ((a)localObject1).gnM.setText(str1);
        ((a)localObject1).jai.setText(str2);
        ((a)localObject1).jai.setTextColor(this.JBI.JOR.getContext().getResources().getColor(2131099734));
        if (!bt.isNullOrNil((String)localObject2)) {
          break label973;
        }
        ((a)localObject1).ka.setVisibility(8);
        ((a)localObject1).gnM.setPadding(0, 0, 0, 0);
        label445:
        localObject2 = (String)paramMap.get(parambp + ".url");
        str1 = bt.nullAsNil((String)paramMap.get(".msg.fromusername"));
        m = bt.getInt((String)paramMap.get(parambp + ".op_type"), 0);
        str2 = (String)paramMap.get(parambp + ".weapp_username");
        bk localbk = new bk(parambu, str1, (String)localObject2);
        ((a)localObject1).Jay.setTag(localbk);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty(str2))) {
          break label1021;
        }
        localObject2 = (String)paramMap.get(parambp + ".weapp_path");
        m = bt.getInt((String)paramMap.get(parambp + ".weapp_version"), 0);
        final int n = bt.getInt((String)paramMap.get(parambp + ".weapp_state"), 0);
        parambp = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194452);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = (bk)paramAnonymousView.getTag();
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            localObject = new AppBrandStatObject();
            ((AppBrandStatObject)localObject).dkh = (paramAnonymousView.dBd.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kbd);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(paramAnonymousView.userName))
            {
              ((AppBrandStatObject)localObject).scene = ai.Uq(this.Kbd);
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(ai.b(ai.this).JOR.getContext(), str2, null, n, m, this.Keo, (AppBrandStatObject)localObject);
              ai.mo(ai.d(ai.this), ai.a(ai.this));
              com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), str1, Integer.valueOf(k) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194452);
              return;
            }
            ((AppBrandStatObject)localObject).scene = 1043;
            paramAnonymousView = com.tencent.mm.am.g.eS(paramAnonymousView.userName);
            o localo = (o)com.tencent.mm.kernel.g.ab(o.class);
            Activity localActivity = ai.b(ai.this).JOR.getContext();
            String str1 = str2;
            int i = n;
            int j = m;
            String str2 = this.Keo;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localo.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
              break;
            }
          }
        };
        ((a)localObject1).Jay.setOnClickListener(parambp);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.JBI.JOR.getContext()).inflate(2131493393, null, false);
        localObject2 = new a();
        ((a)localObject2).gnM = ((TextView)((LinearLayout)localObject1).findViewById(2131302757));
        ((a)localObject2).ka = ((ImageView)((LinearLayout)localObject1).findViewById(2131302756));
        ((a)localObject2).Jay = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131302754));
        ((a)localObject2).jai = ((TextView)((LinearLayout)localObject1).findViewById(2131302755));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label213;
        label874:
        k = bt.getInt((String)paramMap.get(parambp + ".display_line_number"), 1);
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
        ((a)localObject1).gnM.setSingleLine(false);
        ((a)localObject1).gnM.setText(str1);
        ((a)localObject1).gnM.setMaxLines(k);
        com.tencent.mm.pluginsdk.ui.span.k.a(((a)localObject1).gnM, false, null);
        break label378;
        label973:
        ((a)localObject1).ka.setVisibility(0);
        l(((a)localObject1).ka, (String)localObject2);
        ((a)localObject1).gnM.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.JBI.JOR.getContext(), 28), 0);
        break label445;
        label1021:
        if (m == 2) {
          ((a)localObject1).Jay.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(194453);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              if (k == 1)
              {
                localObject = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                long l = bt.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                ai.c(paramAnonymousView.getContext(), (String)localObject, l);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(795L, 2L, 1L, false);
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject, Long.valueOf(l) });
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194453);
                return;
                if (k == 2) {
                  com.tencent.mm.bs.d.f(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
                }
              }
            }
          });
        } else {
          ((a)localObject1).Jay.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(194454);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (!bt.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), str1, Integer.valueOf(k) });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194454);
            }
          });
        }
      }
    }
    label1074:
    AppMethodBeat.o(37251);
  }
  
  private void a(bp parambp, String paramString1, String paramString2, Map<String, String> paramMap, com.tencent.mm.storage.bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    parambp.KhR.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JBI.JOR.getContext(), paramString2, parambp.KhR.getTextSize()));
    com.tencent.mm.aw.q.aIJ().a(paramString1, parambp.KhQ, this.ISW);
    parambp.KhQ.setTag(null);
    parambp.KhQ.setOnClickListener(null);
    parambp.KhP.setTag(null);
    parambp.KhP.setOnClickListener(null);
    parambp.KhP.setVisibility(0);
    paramString1 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bt.isNullOrNil(paramString1)) || (!bt.isNullOrNil(paramString2)))
    {
      paramString1 = bt.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambp.KhP.setTag(new bk(parambu, paramString1));
      parambp.KhP.setOnClickListener(this.KdL);
    }
    for (;;)
    {
      paramString1 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bt.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambp.KhT.getParent()).setVisibility(0);
      com.tencent.mm.aw.q.aIJ().a(paramString1, parambp.KhT, this.ISW);
      AppMethodBeat.o(37247);
      return;
      parambp.KhP.setOnClickListener(null);
    }
    ((View)parambp.KhT.getParent()).setVisibility(8);
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
        if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject3))) {
          break label353;
        }
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      j = i;
      if (i > 8) {
        j = 8;
      }
      localObject2 = parambp.Kif;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)parambp.Kif.getParent()).findViewById(2131298909);
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
      if (!((bm)localObject3).KhJ) {
        break label927;
      }
      ((bn)localObject1).KhK.setVisibility(8);
    }
    for (;;)
    {
      ((bn)localObject1).KhL.setTextColor(al.gD(((bm)localObject3).KhI));
      ((bn)localObject1).KhL.setText(((bm)localObject3).KhG);
      i += 1;
      break label232;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label353:
      Object localObject4 = new bm();
      ((bm)localObject4).KhG = ((String)localObject2);
      ((bm)localObject4).KhF = bt.nullAsNil((String)localObject3);
      label517:
      boolean bool;
      if (!al.isDarkMode())
      {
        ((bm)localObject4).KhH = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", KdU));
        ((bm)localObject4).KhI = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.JBI.JOR.getContext().getResources().getColor(2131100711)));
        if (bt.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label804;
        }
        bool = true;
        label557:
        ((bm)localObject4).KhJ = bool;
        k = (aWE(((bm)localObject4).KhF) + 1) / 2;
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
        ((bm)localObject4).KhH = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", KdU)));
        ((bm)localObject4).KhI = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.JBI.JOR.getContext().getResources().getColor(2131100711))));
        ((bm)localObject4).KhI = al.gD(((bm)localObject4).KhI);
        break label517;
        bool = false;
        break label557;
      }
      label813:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label223;
      label843:
      localObject1 = (LinearLayout)LayoutInflater.from(this.JBI.JOR.getContext()).inflate(2131493394, null, false);
      localObject4 = new bn();
      ((bn)localObject4).KhK = ((TextView)((LinearLayout)localObject1).findViewById(2131301424));
      ((bn)localObject4).KhL = ((TextView)((LinearLayout)localObject1).findViewById(2131301431));
      ((LinearLayout)localObject1).setTag(localObject4);
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label273;
      label927:
      ((bn)localObject1).KhK.setVisibility(0);
      ((bn)localObject1).KhK.setEms(j);
      ((bn)localObject1).KhK.setTextColor(al.gD(((bm)localObject3).KhH));
      ((bn)localObject1).KhK.setText(((bm)localObject3).KhF);
    }
    label978:
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      parambp.Kie.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(37250);
      return;
    }
    if (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      parambp.Kie.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(37250);
      return;
      parambp.Kie.setVisibility(0);
    }
  }
  
  private void a(final Map<String, String> paramMap, final com.tencent.mm.storage.bu parambu, final bp parambp, final IBrandSubscribeMsgService.c paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(194466);
    boolean bool1;
    if (!paramc.iBM)
    {
      bool1 = true;
      boolean bool2 = paramc.iBN;
      ad.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), this.KdN, this.KdR, Boolean.valueOf(bool2) });
      localObject = parambp.Kiv;
      if (!this.KdS) {
        break label214;
      }
      i = 0;
      label91:
      ((LinearLayout)localObject).setVisibility(i);
      if ((!bool1) && ((!paramBoolean) || (bool2))) {
        break label229;
      }
      parambp.KhS.setVisibility(0);
      localObject = parambp.Kiw;
      localResources = this.JBI.JOR.getMMResources();
      if (!paramBoolean) {
        break label221;
      }
    }
    label214:
    label221:
    for (int i = 2131761768;; i = 2131761761)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      parambp.Kiv.setTag(2131302745, parambu);
      if (this.KdS) {
        parambp.Kiv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37218);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ai.a(ai.this, parambu, paramMap, paramBoolean, paramc, parambp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37218);
          }
        });
      }
      AppMethodBeat.o(194466);
      return;
      bool1 = false;
      break;
      i = 8;
      break label91;
    }
    label229:
    parambp.KhS.setVisibility(8);
    Object localObject = parambp.Kiw;
    Resources localResources = this.JBI.JOR.getMMResources();
    if (paramBoolean) {}
    for (i = 2131761766;; i = 2131761736)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      break;
    }
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final com.tencent.mm.storage.bu parambu, final Map<String, String> paramMap, final String paramString, final bp parambp, final boolean paramBoolean3)
  {
    AppMethodBeat.i(194467);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.JBI.JOR.getContext(), 1, true);
    Object localObject = this.JBI.JOR.getContext().getResources();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = String.format(((Resources)localObject).getString(2131761763), new Object[] { this.KdR });; localObject = ((Resources)localObject).getString(2131761762))
      {
        locale.p((CharSequence)localObject, 3);
        locale.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(194444);
            if (paramBoolean1)
            {
              paramAnonymousl.a(1, ai.b(ai.this).JOR.getMMResources().getColor(2131100035), ai.b(ai.this).JOR.getMMResources().getString(2131761764));
              AppMethodBeat.o(194444);
              return;
            }
            int j = ai.b(ai.this).JOR.getMMResources().getColor(2131100800);
            Resources localResources = ai.b(ai.this).JOR.getMMResources();
            if (paramBoolean2) {}
            for (int i = 2131761743;; i = 2131761744)
            {
              paramAnonymousl.a(0, j, localResources.getString(i));
              AppMethodBeat.o(194444);
              return;
            }
          }
        };
        locale.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(194445);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(194445);
              return;
              if (paramBoolean2)
              {
                ai.a(ai.this, paramMap, true, paramBoolean3, parambp, paramString);
                AppMethodBeat.o(194445);
                return;
              }
              ai.a(ai.this, true, parambp, paramString, parambu);
              AppMethodBeat.o(194445);
              return;
              if (paramBoolean2)
              {
                ai.a(ai.this, paramMap, false, paramBoolean3, parambp, paramString);
                AppMethodBeat.o(194445);
                return;
              }
              ai.a(ai.this, false, parambp, paramString, parambu);
            }
          }
        };
        locale.cMW();
        AppMethodBeat.o(194467);
        return;
      }
    }
    if (paramBoolean2) {}
    for (localObject = String.format(((Resources)localObject).getString(2131761741), new Object[] { this.KdR });; localObject = ((Resources)localObject).getString(2131761742))
    {
      locale.p((CharSequence)localObject, 3);
      break;
    }
  }
  
  private void aWC(final String paramString)
  {
    AppMethodBeat.i(194465);
    String str1 = this.JBI.JOR.getContext().getString(2131761735);
    String str2 = this.JBI.JOR.getContext().getString(2131761734);
    h.a(this.JBI.JOR.getContext(), str2, str1, this.JBI.JOR.getContext().getString(2131761773), this.JBI.JOR.getContext().getString(2131755691), true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(194434);
        paramAnonymousDialogInterface = new Intent(ai.b(ai.this).JOR.getContext(), BizSubscribeMsgManagerUI.class);
        paramAnonymousDialogInterface.putExtra("key_biz_username", paramString);
        paramAnonymousDialogInterface.putExtra("key_biz_nickname", v.zf(paramString));
        if (this.KdX)
        {
          paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
          if (!this.KdX) {
            break label150;
          }
        }
        label150:
        for (paramAnonymousInt = 100;; paramAnonymousInt = 101)
        {
          com.tencent.mm.bs.d.a((MMFragmentActivity)ai.b(ai.this).JOR.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramAnonymousDialogInterface, paramAnonymousInt, new MMFragmentActivity.b()
          {
            public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(194433);
              if ((paramAnonymous2Int1 == 100) && (paramAnonymous2Intent != null))
              {
                paramAnonymous2Intent = (SubscribeMsgSettingData)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                if (paramAnonymous2Intent != null)
                {
                  ai.i(ai.this);
                  com.tencent.mm.msgsubscription.util.c localc = com.tencent.mm.msgsubscription.util.c.iEf;
                  com.tencent.mm.msgsubscription.util.c.a(ai.3.this.fNr, paramAnonymous2Intent, new d.g.a.b() {});
                }
                AppMethodBeat.o(194433);
                return;
              }
              if ((paramAnonymous2Int1 == 101) && (paramAnonymous2Intent != null))
              {
                boolean bool = paramAnonymous2Intent.getBooleanExtra("key_need_update", false);
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", new Object[] { Boolean.valueOf(bool) });
                if (!bool)
                {
                  AppMethodBeat.o(194433);
                  return;
                }
                paramAnonymous2Intent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                if (paramAnonymous2Intent != null)
                {
                  ai.i(ai.this);
                  new com.tencent.mm.msgsubscription.storage.e(com.tencent.mm.am.b.b.hSI).a(ai.3.this.fNr, paramAnonymous2Intent.iBL, paramAnonymous2Intent.iBK, false, new e.b()
                  {
                    public final void a(String paramAnonymous3String, SubscribeMsgRequestResult paramAnonymous3SubscribeMsgRequestResult)
                    {
                      AppMethodBeat.i(194431);
                      ad.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                      ai.j(ai.this);
                      if (ai.b(ai.this) != null) {
                        ai.b(ai.this).bOo();
                      }
                      AppMethodBeat.o(194431);
                    }
                    
                    public final void i(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String)
                    {
                      AppMethodBeat.i(194432);
                      ad.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String });
                      ai.j(ai.this);
                      t.makeText(ai.b(ai.this).JOR.getContext(), ai.b(ai.this).JOR.getContext().getString(2131761772), 1).show();
                      AppMethodBeat.o(194432);
                    }
                  });
                }
              }
              AppMethodBeat.o(194433);
            }
          });
          AppMethodBeat.o(194434);
          return;
          paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.am.b.a.class.getName());
          paramAnonymousDialogInterface.putExtra("key_need_update", false);
          paramAnonymousDialogInterface.putExtra("key_need_load_from_remote", true);
          break;
        }
      }
    }, null).setCanceledOnTouchOutside(false);
    AppMethodBeat.o(194465);
  }
  
  private static int aWD(String paramString)
  {
    AppMethodBeat.i(37248);
    String str = paramString;
    if (paramString == null) {
      str = "-1";
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      i = bt.m(Integer.valueOf(i), -1);
      AppMethodBeat.o(37248);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.ChattingItemDyeingTemplate", paramString.getMessage());
        int i = -1;
      }
    }
  }
  
  private static int aWE(String paramString)
  {
    AppMethodBeat.i(37255);
    if (bt.isNullOrNil(paramString))
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
  
  private static boolean bV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194463);
    boolean bool = ok(o(paramMap));
    AppMethodBeat.o(194463);
    return bool;
  }
  
  private static int c(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(37254);
    if ((paramMap == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(37254);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bt.nullAsNil((String)paramMap.get(paramString)));
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
    if ((bt.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(37252);
      return;
    }
    Object localObject = new com.tencent.mm.aw.a.a.c.a();
    ba.aBQ();
    ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.azB();
    ((com.tencent.mm.aw.a.a.c.a)localObject).idr = true;
    ((com.tencent.mm.aw.a.a.c.a)localObject).hdX = true;
    localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).aJc();
    com.tencent.mm.aw.q.aIJ().a(paramString, paramImageView, (com.tencent.mm.aw.a.a.c)localObject);
    AppMethodBeat.o(37252);
  }
  
  private static int o(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194464);
    int i = aWD((String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
    AppMethodBeat.o(194464);
    return i;
  }
  
  private static boolean ok(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
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
      paramLayoutInflater.iCK = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramLayoutInflater.gZU = ((View)localObject).findViewById(2131298147);
      paramLayoutInflater.yEk = ((TextView)((View)localObject).findViewById(2131298185));
      paramLayoutInflater.JYo = ((ChattingAvatarImageView)((View)localObject).findViewById(2131298056));
      paramLayoutInflater.fTP = ((TextView)((View)localObject).findViewById(2131298178));
      paramLayoutInflater.ofq = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramLayoutInflater.Khk.odh = ((View)localObject).findViewById(2131298119);
      paramLayoutInflater.Khk.Khn = ((View)localObject).findViewById(2131300702);
      paramLayoutInflater.Khk.gnM = ((TextView)paramLayoutInflater.Khk.odh.findViewById(2131305902));
      paramLayoutInflater.Khk.Khr = ((LinearLayout)paramLayoutInflater.Khk.odh.findViewById(2131299136));
      paramLayoutInflater.Khk.Khq = ((TextView)paramLayoutInflater.ofq.findViewById(2131299035));
      paramLayoutInflater.Khk.Khs = paramLayoutInflater.ofq.findViewById(2131304592);
      paramLayoutInflater.Khk.Kho = ((View)localObject).findViewById(2131302486);
      paramLayoutInflater.Khk.Khp = ((View)localObject).findViewById(2131302487);
      paramLayoutInflater.Khl.KhN = ((View)localObject).findViewById(2131298118);
      paramLayoutInflater.Khl.KhO = ((ImageView)((View)localObject).findViewById(2131302769));
      paramLayoutInflater.Khl.KhP = ((View)localObject).findViewById(2131302767);
      paramLayoutInflater.Khl.KhR = ((TextView)((View)localObject).findViewById(2131302785));
      paramLayoutInflater.Khl.KhQ = ((ImageView)((View)localObject).findViewById(2131302743));
      paramLayoutInflater.Khl.KhS = ((View)localObject).findViewById(2131302746);
      paramLayoutInflater.Khl.KhT = ((ImageView)((View)localObject).findViewById(2131302773));
      paramLayoutInflater.Khl.KhU = ((View)localObject).findViewById(2131302771);
      paramLayoutInflater.Khl.KhV = ((View)localObject).findViewById(2131302772);
      paramLayoutInflater.Khl.KhW = ((TextView)((View)localObject).findViewById(2131302778));
      paramLayoutInflater.Khl.KhX = ((TextView)((View)localObject).findViewById(2131302766));
      paramLayoutInflater.Khl.KhY = ((View)localObject).findViewById(2131302768);
      paramLayoutInflater.Khl.KhZ = ((LinearLayout)((View)localObject).findViewById(2131302779));
      paramLayoutInflater.Khl.Kia = ((TextView)((View)localObject).findViewById(2131302781));
      paramLayoutInflater.Khl.Kic = ((TextView)((View)localObject).findViewById(2131302782));
      paramLayoutInflater.Khl.Kib = ((TextView)((View)localObject).findViewById(2131302783));
      paramLayoutInflater.Khl.Kid = ((TextView)((View)localObject).findViewById(2131302784));
      paramLayoutInflater.Khl.Kie = ((View)localObject).findViewById(2131302780);
      paramLayoutInflater.Khl.Kif = ((LinearLayout)((View)localObject).findViewById(2131302770));
      paramLayoutInflater.Khl.Kij = ((View)localObject).findViewById(2131302760);
      paramLayoutInflater.Khl.Kig = ((View)localObject).findViewById(2131297440);
      paramLayoutInflater.Khl.Kih = ((LinearLayout)((View)localObject).findViewById(2131302758));
      paramLayoutInflater.Khl.Kii = ((LinearLayout)((View)localObject).findViewById(2131299239));
      paramLayoutInflater.Khl.Kik = ((LinearLayout)((View)localObject).findViewById(2131302748));
      paramLayoutInflater.Khl.Kin = ((TextView)((View)localObject).findViewById(2131302750));
      paramLayoutInflater.Khl.Kip = ((ImageView)((View)localObject).findViewById(2131302749));
      paramLayoutInflater.Khl.Kim = ((View)localObject).findViewById(2131302759);
      paramLayoutInflater.Khl.Kil = ((LinearLayout)((View)localObject).findViewById(2131302751));
      paramLayoutInflater.Khl.Kio = ((TextView)((View)localObject).findViewById(2131302753));
      paramLayoutInflater.Khl.Kiq = ((ImageView)((View)localObject).findViewById(2131302752));
      paramLayoutInflater.Khl.Kir = ((ImageView)((View)localObject).findViewById(2131302742));
      paramLayoutInflater.JZr = ((ImageView)((View)localObject).findViewById(2131298117));
      paramLayoutInflater.Khl.Kis = ((View)localObject).findViewById(2131302774);
      paramLayoutInflater.Khl.Kit = ((ImageView)((View)localObject).findViewById(2131302775));
      paramLayoutInflater.Khl.Kiu = ((TextView)((View)localObject).findViewById(2131302776));
      paramLayoutInflater.Khl.Kiv = ((LinearLayout)((View)localObject).findViewById(2131302744));
      paramLayoutInflater.Khl.Kiw = ((TextView)((View)localObject).findViewById(2131302745));
      paramLayoutInflater.Khm.JXT = ((LinearLayout)((View)localObject).findViewById(2131302763));
      paramLayoutInflater.Khm.JXU = ((CdnImageView)((View)localObject).findViewById(2131302762));
      paramLayoutInflater.Khm.JXV = ((TextView)((View)localObject).findViewById(2131302764));
      paramLayoutInflater.Khm.JXW = ((TextView)((View)localObject).findViewById(2131302761));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final com.tencent.mm.storage.bu parambu, final String paramString)
  {
    AppMethodBeat.i(37242);
    this.JBI = parama1;
    KdU = parama1.getContext().getResources().getColor(2131100212);
    KdV = parama1.getContext().getResources().getColor(2131100212);
    bi localbi = (bi)parama;
    final Map localMap = bw.M(parambu.getContent(), "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localbi.ofq.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    localbi.ofq.setVisibility(0);
    int j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.KdN = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.KdO = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.IbL.d(this.JOF);
    ((com.tencent.mm.ui.chatting.d.b.j)parama1.bh(com.tencent.mm.ui.chatting.d.b.j.class)).b(this.KdK);
    Object localObject1;
    if (j != 0)
    {
      localbi.Khk.odh.setVisibility(8);
      localObject1 = localbi.Khl;
      if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bp)localObject1, bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambu, false);
        if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2841;
        }
        ((bp)localObject1).KhP.setBackgroundResource(2131233299);
        label320:
        if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6802;
        }
      }
    }
    label512:
    label2062:
    label3983:
    label6543:
    label6802:
    for (final int i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      final int k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      ((bp)localObject1).KhW.setVisibility(8);
      if ((i == 0) && (k == 0))
      {
        ((bp)localObject1).KhW.setVisibility(0);
        this.KdR = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = c(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        ((bp)localObject1).KhW.setTextColor(al.gD(k));
        ((bp)localObject1).KhW.setText(this.KdR);
      }
      parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = c(localMap, ".msg.appmsg.mmreader.template_header.first_color", KdV);
      label534:
      boolean bool1;
      label673:
      label689:
      Object localObject2;
      label828:
      Object localObject3;
      if (bt.isNullOrNil(parama))
      {
        ((bp)localObject1).KhX.setVisibility(8);
        if ((i == 0) || (!bt.isNullOrNil(parama))) {
          break label2957;
        }
        ((bp)localObject1).KhY.setVisibility(8);
        parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
        if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(parama)) {
          break label3261;
        }
        bool1 = bV(localMap);
        if ("notifymessage".equals(parambu.VS()))
        {
          parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
          ((com.tencent.mm.ui.chatting.d.b.j)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.j.class)).a(this.KdK);
          com.tencent.mm.sdk.b.a.IbL.c(this.JOF);
          if (!bool1) {
            break label3107;
          }
          parama = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(parama1);
          if (parama == null) {
            break label2969;
          }
          this.mAppId = parama.field_appId;
          parama = ((bp)localObject1).Kiv;
          if (!this.KdS) {
            break label2995;
          }
          i = 0;
          parama.setVisibility(i);
          ((bp)localObject1).KhS.setVisibility(8);
          ((bp)localObject1).Kiw.setText(this.JBI.getResources().getString(2131761766));
          this.KdM.ff(true);
          this.KdM.fg(true);
          parama = com.tencent.mm.msgsubscription.storage.a.iBk;
          paramString = this.KdN;
          parama = ((bp)localObject1).Kiv.hashCode();
          d.g.b.p.h(paramString, "templateId");
          d.g.b.p.h(parama, "viewKey");
          localObject2 = (HashMap)com.tencent.mm.msgsubscription.storage.a.aOq().get(paramString);
          if (localObject2 != null) {
            ((HashMap)localObject2).remove(parama);
          }
          if (localObject2 == null) {
            break label3002;
          }
          parama = Integer.valueOf(((HashMap)localObject2).size());
          ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString, parama });
          parama = com.tencent.mm.msgsubscription.storage.a.iBk;
          paramString = this.KdN;
          localObject2 = ((bp)localObject1).Kiv.hashCode();
          localObject3 = new IBrandSubscribeMsgService.b()
          {
            public final void c(String paramAnonymousString, IBrandSubscribeMsgService.c paramAnonymousc)
            {
              AppMethodBeat.i(194440);
              if (paramAnonymousString.equals(ai.a(ai.this)))
              {
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", new Object[] { parama1, paramAnonymousString, Boolean.valueOf(paramAnonymousc.iBM), Boolean.valueOf(paramAnonymousc.iBN) });
                ai.a(ai.this, new IBrandSubscribeMsgService.c(paramAnonymousc.iBM, paramAnonymousc.iBN));
                ai.a(ai.this, localMap, parambu, this.Ked, ai.f(ai.this), true);
                if ((!ai.e(ai.this)) && (ai.g(ai.this) != null) && (ai.g(ai.this).isShowing())) {
                  ai.g(ai.this).cMW();
                }
              }
              AppMethodBeat.o(194440);
            }
            
            public final void onError()
            {
              AppMethodBeat.i(194441);
              ad.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
              AppMethodBeat.o(194441);
            }
          };
          d.g.b.p.h(paramString, "templateId");
          d.g.b.p.h(localObject2, "viewKey");
          d.g.b.p.h(localObject3, "callback");
          parama = (HashMap)com.tencent.mm.msgsubscription.storage.a.aOq().get(paramString);
          if (parama != null) {
            break label6799;
          }
          parama = new HashMap();
        }
      }
      for (;;)
      {
        ((Map)parama).put(localObject2, localObject3);
        ((Map)com.tencent.mm.msgsubscription.storage.a.aOq()).put(paramString, parama);
        ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString, Integer.valueOf(parama.size()) });
        parama = this.KdQ;
        paramString = this.KdN;
        d.g.b.p.h(parama1, "bizUsername");
        d.g.b.p.h(paramString, "templateId");
        localObject2 = parama.iBi;
        d.g.b.p.h(parama1, "bizUsername");
        d.g.b.p.h(paramString, "templateId");
        localObject3 = ((com.tencent.mm.msgsubscription.storage.e)localObject2).iBO.bm(parama1, paramString);
        localObject2 = new y.f();
        ((y.f)localObject2).MLV = localObject3;
        Object localObject4 = parama.iBi;
        d.g.b.p.h(parama1, "bizUsername");
        boolean bool2 = ((com.tencent.mm.msgsubscription.storage.e)localObject4).iBO.EC(parama1);
        if (localObject3 != null)
        {
          ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject3).aOp()) });
          if (((SubscribeMsgTmpItem)localObject3).aOp() == 1)
          {
            bool1 = true;
            label1150:
            com.tencent.mm.msgsubscription.storage.a.a(paramString, new IBrandSubscribeMsgService.c(bool1, bool2));
            localObject3 = (SubscribeMsgTmpItem)((y.f)localObject2).MLV;
            localObject2 = (SubscribeMsgTmpItem)((y.f)localObject2).MLV;
            if (localObject2 == null) {
              break label3013;
            }
            i = ((SubscribeMsgTmpItem)localObject2).aOp();
            label1198:
            parama.a((SubscribeMsgTmpItem)localObject3, new com.tencent.mm.msgsubscription.storage.a.b(parama1, paramString, i));
            label1216:
            ((bp)localObject1).KhU.setVisibility(0);
            ((bp)localObject1).KhU.setTag(2131302771, parambu);
            this.KdG = new View.OnClickListener()
            {
              public final void onClick(final View paramAnonymousView)
              {
                AppMethodBeat.i(194459);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                localObject = (com.tencent.mm.storage.bu)paramAnonymousView.getTag(2131302771);
                if (localObject == null)
                {
                  ad.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(194459);
                  return;
                }
                final Map localMap = bw.M(((ei)localObject).field_content, "msg");
                if ((localMap == null) || (localMap.size() == 0))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(194459);
                  return;
                }
                final String str = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                final int i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                final int j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                ai.a(ai.this, new com.tencent.mm.ui.widget.a.e(paramAnonymousView.getContext(), 1, false));
                ai.g(ai.this).KJy = new n.d()
                {
                  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                  {
                    AppMethodBeat.i(194457);
                    paramAnonymous2l.clear();
                    if (!ai.e(ai.this)) {
                      ai.a(ai.this, this.hED, localMap, paramAnonymous2l, ai.f(ai.this));
                    }
                    paramAnonymous2l.add(0, 2, 0, paramAnonymousView.getResources().getString(2131761750));
                    AppMethodBeat.o(194457);
                  }
                };
                ai.g(ai.this).KJz = new n.e()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(194458);
                    ad.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(paramAnonymous2Int) });
                    switch (paramAnonymous2MenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(194458);
                      return;
                      ai.a(ai.this, paramAnonymousView.getContext(), this.hED, str, i, j);
                      AppMethodBeat.o(194458);
                      return;
                      boolean bool = ai.bW(localMap);
                      ai.a(ai.this, this.hED, localMap, bool, ai.f(ai.this), ai.28.this.Ked);
                    }
                  }
                };
                ai.g(ai.this).cMW();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194459);
              }
            };
            ((bp)localObject1).KhU.setOnClickListener(this.KdG);
            label1264:
            ((bp)localObject1).KhO.setVisibility(8);
            parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
            ((bp)localObject1).KhX.setText(parama);
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bt.isNullOrNil(parama1)) {
              break label3341;
            }
            i = al.gD(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.JBI.getContext().getResources().getColor(2131100711)));
            j = al.gD(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.JBI.getContext().getResources().getColor(2131100711)));
            k = al.gD(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.JBI.getContext().getResources().getColor(2131100711)));
            int m = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
            ((bp)localObject1).Kia.setTextColor(i);
            ((bp)localObject1).Kic.setTextColor(j);
            ((bp)localObject1).Kid.setTextColor(k);
            ((bp)localObject1).Kid.getPaint().setFlags(16);
            ((bp)localObject1).Kia.setText(parama);
            if ((m <= 0) || (m >= parama1.length())) {
              break label3284;
            }
            ((bp)localObject1).Kib.setVisibility(0);
            ((bp)localObject1).Kib.setText(parama1.substring(0, m));
            ((bp)localObject1).Kib.setTextColor(j);
            ((bp)localObject1).Kib.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fP(this.JBI.getContext()));
            ((bp)localObject1).Kic.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fP(this.JBI.getContext()));
            ((bp)localObject1).Kic.setText(parama1.substring(m));
            label1628:
            if (bt.isNullOrNil(paramString)) {
              break label3328;
            }
            ((bp)localObject1).Kid.setText(paramString);
            ((bp)localObject1).Kid.setVisibility(0);
            label1655:
            ((bp)localObject1).KhZ.setVisibility(0);
            j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (j != 2) {
              break label3507;
            }
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
            ((bp)localObject1).Kif.setVisibility(8);
            parama1 = (ViewGroup)((bp)localObject1).Kif.getParent();
            parama = parama1.findViewById(2131298909);
            if (parama != null) {
              break label6796;
            }
            parama = LayoutInflater.from(parama1.getContext()).inflate(2131495249, null);
            paramString = new bh();
            paramString.ka = ((ImageView)parama.findViewById(2131296996));
            paramString.Khj = ((TextView)parama.findViewById(2131302863));
            paramString.gnM = ((TextView)parama.findViewById(2131305902));
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
          i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
          paramString.gnM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.gnM.getContext(), parama));
          localObject3 = paramString.Khj;
          localObject4 = paramString.gnM.getContext();
          if (bt.isNullOrNil((String)localObject2)) {
            parama = "";
          }
          for (;;)
          {
            ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, parama));
            label1984:
            Object localObject5;
            String str;
            if (i == 2)
            {
              paramString.ka.setImageDrawable(com.tencent.mm.sdk.platformtools.aj.getContext().getResources().getDrawable(2131230943));
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
                break label3518;
              }
              ((bp)localObject1).Kis.setVisibility(8);
              ((bp)localObject1).Kih.setVisibility(8);
              ((bp)localObject1).Kij.setVisibility(8);
              ((bp)localObject1).Kii.setVisibility(0);
              ((bp)localObject1).Kig.setVisibility(0);
              a((bp)localObject1, parambu, localMap);
              localObject3 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
              parama = null;
              if (!bt.isNullOrNil((String)localObject3))
              {
                ba.aBQ();
                parama = com.tencent.mm.model.c.azp().Bf((String)localObject3).adu();
              }
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
              paramString = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
              localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
              localObject2 = (String)localMap.get(".msg.appmsg.template_id");
              str = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if (ok(o(localMap)))
              {
                if (parambu != null) {
                  break label4988;
                }
                i = 0;
              }
            }
            for (;;)
            {
              if (i == 0)
              {
                if ((j != 1) || (TextUtils.isEmpty(str))) {
                  break label5275;
                }
                parama1 = new bk(parambu, (String)localObject3, paramString);
                parama1.position = paramInt;
                ((bp)localObject1).KhN.setTag(parama1);
                ((bp)localObject1).KhN.setOnClickListener(this.qkD);
              }
              label2261:
              ((bp)localObject1).KhN.setOnLongClickListener(c(this.JBI));
              ((bp)localObject1).KhN.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
              if (com.tencent.mm.n.g.acB().acq())
              {
                localbi.JZr.setVisibility(0);
                c(this.JBI, localbi.JZr, new s.o((String)localObject2, parambu, parama));
              }
              parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
              if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(parama)) || (!"notifymessage".equals(parambu.VS()))) {
                break label5489;
              }
              ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
              ((bp)localObject1).KhV.setTag(null);
              ((bp)localObject1).KhV.setVisibility(8);
              label2422:
              localbi.Khl.KhN.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
              {
                a((bp)localObject1, bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambu, true);
                break;
              }
              ((View)((bp)localObject1).KhT.getParent()).setVisibility(8);
              if ("notifymessage".equals(parambu.VS()))
              {
                parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(parama1))
                {
                  paramString = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(parama1);
                  if (paramString == null)
                  {
                    parama = null;
                    label2596:
                    a(((bp)localObject1).KhQ, this.JBI, parama1, parambu, parama);
                    if (paramString != null) {
                      break label2716;
                    }
                    parama = parama1;
                  }
                }
                for (;;)
                {
                  ((bp)localObject1).KhR.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JBI.getContext(), parama, ((bp)localObject1).KhR.getTextSize()));
                  if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(parama1)) {
                    break label2765;
                  }
                  ((bp)localObject1).KhP.setTag(new bk(parambu, parama1));
                  ((bp)localObject1).KhP.setOnClickListener(this.JYH);
                  ((bp)localObject1).KhP.setVisibility(0);
                  break;
                  parama = paramString.field_brandIconURL;
                  break label2596;
                  label2716:
                  parama = paramString.field_nickname;
                  continue;
                  a(((bp)localObject1).KhQ, this.JBI, parama1, parambu, null);
                  parama = ((com.tencent.mm.ui.chatting.d.b.f)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aWa(parama1);
                }
                label2765:
                paramString = ((bp)localObject1).KhP;
                if (this.JBI.fFv()) {}
                for (parama = this.JBI.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bk(parama1, parama));
                  ((bp)localObject1).KhP.setOnClickListener(e(this.JBI));
                  break;
                }
              }
              ((bp)localObject1).KhP.setVisibility(8);
              break;
              label2841:
              i = ((bp)localObject1).KhP.getPaddingLeft();
              ((bp)localObject1).KhP.setBackgroundResource(2131232867);
              ((bp)localObject1).KhP.setPadding(i, 0, 0, 0);
              break label320;
              ((bp)localObject1).KhX.setTextColor(al.gD(k));
              ((bp)localObject1).KhX.setText(parama);
              ((bp)localObject1).KhX.setVisibility(0);
              if (j == 2)
              {
                ((bp)localObject1).KhX.setPadding(0, this.JBI.getResources().getDimensionPixelOffset(2131165480), 0, 0);
                break label512;
              }
              ((bp)localObject1).KhX.setPadding(0, 0, 0, 0);
              break label512;
              ((bp)localObject1).KhY.setVisibility(0);
              break label534;
              label2969:
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama1, new n.a()
              {
                public final void b(WxaAttributes paramAnonymousWxaAttributes)
                {
                  AppMethodBeat.i(194439);
                  if (paramAnonymousWxaAttributes != null)
                  {
                    ad.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ai.d(ai.this) });
                    ai.b(ai.this, paramAnonymousWxaAttributes.field_appId);
                  }
                  AppMethodBeat.o(194439);
                }
              });
              break label673;
              label2995:
              i = 8;
              break label689;
              label3002:
              parama = null;
              break label828;
              bool1 = false;
              break label1150;
              label3013:
              i = -1;
              break label1198;
              ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from local");
              localObject3 = parama.iBi;
              parama = (e.b)new a.d(parama, paramString, (y.f)localObject2);
              d.g.b.p.h(parama1, "username");
              ad.i("Mp.SubscribeMsgDataLoader", "alvinluo loadSubscribeMsgListByUsername username: %s", new Object[] { parama1 });
              paramString = com.tencent.mm.msgsubscription.storage.g.iBT;
              com.tencent.mm.msgsubscription.storage.g.a(((com.tencent.mm.msgsubscription.storage.e)localObject3).iBO, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.f(parama1, ((com.tencent.mm.msgsubscription.storage.e)localObject3).iBO, parama));
              break label1216;
              label3107:
              this.KdM.fg(false);
              parama = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(parama1);
              if (parama != null)
              {
                this.mAppId = parama.field_appId;
                if ((parama.field_appOpt & 0x1) > 0)
                {
                  i = 1;
                  label3155:
                  parama = this.KdM;
                  if (i != 0) {
                    break label3198;
                  }
                  bool1 = true;
                  label3168:
                  parama.ff(bool1);
                }
              }
              for (;;)
              {
                a(localMap, parambu, (bp)localObject1, this.KdM, false);
                break;
                i = 0;
                break label3155;
                label3198:
                bool1 = false;
                break label3168;
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama1 });
                this.KdM.ff(true);
                ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama1, new n.a()
                {
                  public final void b(WxaAttributes paramAnonymousWxaAttributes)
                  {
                    boolean bool = true;
                    AppMethodBeat.i(194443);
                    if (paramAnonymousWxaAttributes == null)
                    {
                      AppMethodBeat.o(194443);
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
                      paramAnonymousWxaAttributes.iBM = bool;
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(194442);
                          ai.a(ai.this, ai.10.this.fKy, ai.10.this.hED, ai.10.this.Ked, ai.f(ai.this), false);
                          AppMethodBeat.o(194442);
                        }
                      });
                      AppMethodBeat.o(194443);
                      return;
                      i = 0;
                      break;
                      label79:
                      bool = false;
                    }
                  }
                });
              }
              label3261:
              ((bp)localObject1).Kiv.setVisibility(8);
              ((bp)localObject1).KhS.setVisibility(8);
              break label1264;
              label3284:
              ((bp)localObject1).Kib.setTypeface(Typeface.DEFAULT);
              ((bp)localObject1).Kib.setVisibility(8);
              ((bp)localObject1).Kic.setTypeface(Typeface.DEFAULT);
              ((bp)localObject1).Kic.setText(parama1);
              break label1628;
              ((bp)localObject1).Kid.setVisibility(8);
              break label1655;
              ((bp)localObject1).KhZ.setVisibility(8);
              break label1664;
              parama = null;
              if (w.vF((String)localObject2))
              {
                ba.aBQ();
                localObject5 = com.tencent.mm.model.c.azp().Bf((String)localObject2);
                if (localObject5 != null)
                {
                  if (((am)localObject5).adv() != null) {
                    break label3447;
                  }
                  parama = ((am)localObject5).adu();
                }
              }
              for (;;)
              {
                if (!bt.isNullOrNil(parama)) {
                  break label6793;
                }
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
                parama = parama1;
                if (parama1 != null) {
                  break;
                }
                parama = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131757293);
                break;
                label3447:
                parama = ((am)localObject5).adv();
                continue;
                ba.aBQ();
                parama = com.tencent.mm.model.c.azp().Bf((String)localObject2);
                if (parama.adv() == null) {
                  parama = parama.adu();
                } else {
                  parama = parama.adv();
                }
              }
              com.tencent.mm.pluginsdk.ui.a.b.c(paramString.ka, (String)localObject2);
              break label1984;
              label3507:
              a((bp)localObject1, localMap);
              break label1984;
              label3518:
              ((bp)localObject1).Kii.setVisibility(8);
              parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
              parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
              if (!bt.isNullOrNil(parama1))
              {
                i = al.gD(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.JBI.getContext().getResources().getColor(2131100711)));
                ((bp)localObject1).Kin.setTextColor(i);
                ((bp)localObject1).Kin.setText(parama1);
                if (bt.isNullOrNil(parama))
                {
                  ((bp)localObject1).Kip.setVisibility(8);
                  ((bp)localObject1).Kin.setPadding(0, 0, 0, 0);
                  label3640:
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                  parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  localObject3 = new bk(parambu, parama1, (String)localObject2);
                  ((bp)localObject1).Kik.setTag(localObject3);
                  ((bp)localObject1).Kis.setTag(localObject3);
                  if ((i != 1) || (TextUtils.isEmpty(paramString))) {
                    break label4545;
                  }
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                  i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                  k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                  parama1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(169890);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                      paramAnonymousView = (bk)paramAnonymousView.getTag();
                      ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                      localObject = new AppBrandStatObject();
                      ((AppBrandStatObject)localObject).dkh = (paramAnonymousView.dBd.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kbd);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(paramAnonymousView.userName))
                      {
                        ((AppBrandStatObject)localObject).scene = ai.Uq(this.Kbd);
                        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(ai.b(ai.this).JOR.getContext(), paramString, null, k, i, this.Keo, (AppBrandStatObject)localObject);
                        ai.mo(ai.d(ai.this), ai.a(ai.this));
                        com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), parama1, Integer.valueOf(1) });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169890);
                        return;
                      }
                      ((AppBrandStatObject)localObject).scene = 1043;
                      paramAnonymousView = com.tencent.mm.am.g.eS(paramAnonymousView.userName);
                      o localo = (o)com.tencent.mm.kernel.g.ab(o.class);
                      Activity localActivity = ai.b(ai.this).JOR.getContext();
                      String str1 = paramString;
                      int i = k;
                      int j = i;
                      String str2 = this.Keo;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localo.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                        break;
                      }
                    }
                  };
                  ((bp)localObject1).Kik.setOnClickListener(parama1);
                  ((bp)localObject1).Kis.setOnClickListener(parama1);
                  label3859:
                  ((bp)localObject1).Kik.setVisibility(0);
                  label3868:
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                  parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                  if (bt.isNullOrNil(paramString)) {
                    break label4656;
                  }
                  i = al.gD(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.JBI.getContext().getResources().getColor(2131100711)));
                  ((bp)localObject1).Kio.setTextColor(i);
                  ((bp)localObject1).Kio.setText(paramString);
                  if (!bt.isNullOrNil(parama1)) {
                    break label4589;
                  }
                  ((bp)localObject1).Kiq.setVisibility(8);
                  ((bp)localObject1).Kio.setPadding(0, 0, 0, 0);
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                  paramString = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                  ((bp)localObject1).Kil.setTag(new bk(parambu, paramString, (String)localObject3));
                  if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                    break label4633;
                  }
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                  i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                  k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                  localObject4 = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                  ((bp)localObject1).Kil.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37225);
                      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                      paramAnonymousView = (bk)paramAnonymousView.getTag();
                      ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.Kel });
                      localObject = new AppBrandStatObject();
                      ((AppBrandStatObject)localObject).dkh = (paramAnonymousView.dBd.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ai.b(ai.this).getTalkerUserName() + ":" + this.Kbd);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(paramAnonymousView.userName))
                      {
                        ((AppBrandStatObject)localObject).scene = ai.Uq(this.Kbd);
                        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(ai.b(ai.this).JOR.getContext(), this.Kel, null, k, i, this.Keo, (AppBrandStatObject)localObject);
                        ai.mo(ai.d(ai.this), ai.a(ai.this));
                        com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), paramString, Integer.valueOf(2) });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37225);
                        return;
                      }
                      ((AppBrandStatObject)localObject).scene = 1043;
                      paramAnonymousView = com.tencent.mm.am.g.eS(paramAnonymousView.userName);
                      o localo = (o)com.tencent.mm.kernel.g.ab(o.class);
                      Activity localActivity = ai.b(ai.this).JOR.getContext();
                      String str1 = this.Kel;
                      int i = k;
                      int j = i;
                      String str2 = this.Keo;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localo.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                        break;
                      }
                    }
                  });
                  label4184:
                  ((bp)localObject1).Kil.setVisibility(0);
                  label4193:
                  ((bp)localObject1).Kir.setVisibility(8);
                  if ((((bp)localObject1).Kik.getVisibility() != 8) || (((bp)localObject1).Kil.getVisibility() != 8)) {
                    break label4669;
                  }
                  ((bp)localObject1).Kih.setVisibility(8);
                  ((bp)localObject1).Kig.setVisibility(8);
                  ((bp)localObject1).Kij.setVisibility(8);
                  if ((((bp)localObject1).Kik.getVisibility() != 0) || (((bp)localObject1).Kil.getVisibility() != 0)) {
                    break label4944;
                  }
                  ((bp)localObject1).Kim.setVisibility(0);
                  label4290:
                  parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  if ((am.yt(parama)) || (((bp)localObject1).Kik.getVisibility() == 8) || (((bp)localObject1).Kil.getVisibility() != 8) || (i != 1) || (!am.yt(paramString))) {
                    break label4975;
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramString);
                  if (localObject2 != null) {
                    break label4957;
                  }
                  parama = null;
                  label4413:
                  if (localObject2 != null) {
                    break label4966;
                  }
                }
              }
              label4545:
              label4944:
              label4957:
              label4966:
              for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
              {
                com.tencent.mm.aw.q.aIJ().a(parama, ((bp)localObject1).Kit, this.ISW);
                ((bp)localObject1).Kiu.setText(parama1);
                if (localObject2 == null) {
                  ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramString, new n.a()
                  {
                    public final void b(WxaAttributes paramAnonymousWxaAttributes)
                    {
                      AppMethodBeat.i(194451);
                      if (paramAnonymousWxaAttributes == null)
                      {
                        AppMethodBeat.o(194451);
                        return;
                      }
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(194450);
                          com.tencent.mm.aw.q.aIJ().a(this.pDB, ai.20.this.Ked.Kit, ai.m(ai.this));
                          if (TextUtils.isEmpty(this.nbK)) {}
                          for (String str = ai.20.this.Kel;; str = this.nbK)
                          {
                            ai.20.this.Ked.Kiu.setText(str);
                            AppMethodBeat.o(194450);
                            return;
                          }
                        }
                      });
                      AppMethodBeat.o(194451);
                    }
                  });
                }
                ((bp)localObject1).Kis.setVisibility(0);
                ((bp)localObject1).Kih.setVisibility(8);
                break;
                ((bp)localObject1).Kip.setVisibility(0);
                l(((bp)localObject1).Kip, parama);
                ((bp)localObject1).Kin.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.JBI.getContext(), 16), 0);
                break label3640;
                ((bp)localObject1).Kik.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37224);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    if (!bt.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      paramAnonymousView.putExtra("geta8key_username", parama1);
                      c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                      com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), parama1, Integer.valueOf(1) });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37224);
                  }
                });
                ((bp)localObject1).Kis.setOnClickListener(null);
                break label3859;
                ((bp)localObject1).Kik.setVisibility(8);
                break label3868;
                label4589:
                ((bp)localObject1).Kiq.setVisibility(0);
                l(((bp)localObject1).Kiq, parama1);
                ((bp)localObject1).Kio.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.JBI.getContext(), 16), 0);
                break label3983;
                ((bp)localObject1).Kil.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37226);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    if (!bt.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      c.t(paramAnonymousView, ai.b(ai.this).getTalkerUserName());
                      com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ai.a(ai.this), paramString, Integer.valueOf(2) });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37226);
                  }
                });
                break label4184;
                ((bp)localObject1).Kil.setVisibility(8);
                break label4193;
                ((bp)localObject1).Kij.setVisibility(0);
                i = this.JBI.getResources().getDimensionPixelOffset(2131165480);
                if ((((bp)localObject1).Kik.getVisibility() == 0) && (((bp)localObject1).Kil.getVisibility() == 0))
                {
                  ((bp)localObject1).Kik.setGravity(17);
                  ((bp)localObject1).Kil.setGravity(17);
                  ((bp)localObject1).Kik.setPadding(i, 0, i, 0);
                  ((bp)localObject1).Kil.setPadding(i, 0, i, 0);
                }
                for (;;)
                {
                  ((bp)localObject1).Kih.setVisibility(0);
                  ((bp)localObject1).Kig.setVisibility(0);
                  break;
                  if (((bp)localObject1).Kik.getVisibility() == 0)
                  {
                    if (bt.isNullOrNil(parama))
                    {
                      ((bp)localObject1).Kik.setGravity(19);
                      ((bp)localObject1).Kik.setPadding(i, 0, 0, 0);
                      ((bp)localObject1).Kir.setVisibility(0);
                    }
                    else
                    {
                      ((bp)localObject1).Kik.setGravity(17);
                      ((bp)localObject1).Kik.setPadding(i, 0, i, 0);
                    }
                  }
                  else if (bt.isNullOrNil(parama1))
                  {
                    ((bp)localObject1).Kil.setGravity(19);
                    ((bp)localObject1).Kil.setPadding(this.JBI.getResources().getDimensionPixelOffset(2131165480), 0, 0, 0);
                    ((bp)localObject1).Kir.setVisibility(0);
                  }
                  else
                  {
                    ((bp)localObject1).Kil.setGravity(17);
                    ((bp)localObject1).Kil.setPadding(i, 0, i, 0);
                  }
                }
                ((bp)localObject1).Kim.setVisibility(8);
                break label4290;
                parama = ((WxaAttributes)localObject2).field_brandIconURL;
                break label4413;
              }
              label4633:
              label4656:
              label4669:
              label4975:
              ((bp)localObject1).Kis.setVisibility(8);
              break label2062;
              label4988:
              if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt((String)localObject3))
              {
                i = 0;
              }
              else if (!"notifymessage".equals(parambu.VS()))
              {
                i = 0;
              }
              else
              {
                i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.native_page_type"), 0);
                if (i > 0)
                {
                  parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.native_info");
                  bk localbk = new bk(parambu, (String)localObject3);
                  localbk.position = paramInt;
                  localbk.KhC = i;
                  localbk.KhD = parama1;
                  ((bp)localObject1).KhN.setTag(localbk);
                  ((bp)localObject1).KhN.setOnClickListener(this.KdJ);
                  i = 1;
                }
                else
                {
                  if ((j != 1) || (bt.isNullOrNil(str))) {
                    break label5191;
                  }
                  parama1 = new bk(parambu, (String)localObject3, paramString);
                  parama1.position = paramInt;
                  ((bp)localObject1).KhN.setTag(parama1);
                  ((bp)localObject1).KhN.setOnClickListener(this.qkD);
                  i = 1;
                }
              }
            }
            label5191:
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.h5_url");
            if (bt.isNullOrNil(parama1)) {
              parama1 = paramString;
            }
            for (;;)
            {
              ((bp)localObject1).KhN.setTag(new bk(parambu, false, paramInt, parama1, false, this.JBI.fCR(), (String)localObject3, parama, (String)localObject4).aWJ((String)localObject5));
              ((bp)localObject1).KhN.setOnClickListener(h(this.JBI));
              i = 1;
              break;
              label5275:
              if ((j == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt((String)localObject3)))
              {
                parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                paramString = ((bp)localObject1).KhN;
                localObject3 = new bk(parambu, false, paramInt, (String)localObject3, false, this.JBI.fCR(), (String)localObject3, parama, (String)localObject4).aWJ((String)localObject5);
                ((bk)localObject3).pageUrl = parama1;
                paramString.setTag(localObject3);
                ((bp)localObject1).KhN.setOnClickListener(this.KdI);
                break label2261;
              }
              if (j == 2)
              {
                parama1 = new bk(parambu, (String)localObject3, paramString);
                parama1.position = paramInt;
                ((bp)localObject1).KhN.setTag(parama1);
                ((bp)localObject1).KhN.setOnClickListener(this.qkD);
                break label2261;
              }
              ((bp)localObject1).KhN.setTag(new bk(parambu, false, paramInt, paramString, false, this.JBI.fCR(), (String)localObject3, parama, (String)localObject4).aWJ((String)localObject5));
              ((bp)localObject1).KhN.setOnClickListener(h(this.JBI));
              break label2261;
              label5489:
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label5571;
                }
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              }
              label5571:
              do
              {
                ((bp)localObject1).KhU.setTag(null);
                ((bp)localObject1).KhV.setTag(null);
                ((bp)localObject1).KhU.setVisibility(8);
                ((bp)localObject1).KhV.setVisibility(8);
                break;
                paramInt = 0;
                break label5512;
                if (((bp)localObject1).KhP.getVisibility() == 0)
                {
                  ((bp)localObject1).KhU.setTag(parambu);
                  ((bp)localObject1).KhU.setOnClickListener(this.KdH);
                  ((bp)localObject1).KhU.setVisibility(0);
                  ((bp)localObject1).KhV.setVisibility(8);
                  break;
                }
              } while (((bp)localObject1).KhY.getVisibility() != 0);
              ((bp)localObject1).KhV.setTag(parambu);
              ((bp)localObject1).KhV.setOnClickListener(this.KdH);
              ((bp)localObject1).KhV.setVisibility(0);
              ((bp)localObject1).KhU.setVisibility(8);
              break label2422;
              localbi.Khl.KhN.setVisibility(8);
              parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
              i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
              ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
              if (i == 1)
              {
                parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
                paramString = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
                a(localbi, com.tencent.mm.pluginsdk.ui.span.k.b(this.JBI.getContext(), paramString, localbi.yEk.getTextSize()));
                localbi.JYo.setTag(null);
                localbi.JYo.setOnClickListener(null);
                com.tencent.mm.aw.q.aIJ().a(parama, localbi.JYo, this.ISW);
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambu.VS() });
                if ((!"notifymessage".equals(parambu.VS())) && (i != 1)) {
                  break label6497;
                }
                localbi.Khk.Khn.setVisibility(0);
                localbi.Khk.gnM.setTextSize(0, com.tencent.mm.cc.a.ax(localbi.Khk.gnM.getContext(), 2131165517));
                label5934:
                localbi.Khk.odh.setVisibility(0);
                paramString = b.bX(localMap);
                localbi.Khk.gnM.setText(paramString.title);
                aj.a(localbi.Khk.Khr, localMap);
                parama = null;
                if (!bt.isNullOrNil(parama1))
                {
                  ba.aBQ();
                  parama = com.tencent.mm.model.c.azp().Bf(parama1).adu();
                }
                if (bt.isNullOrNil(paramString.url)) {
                  break label6543;
                }
                i = 1;
                j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
                localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
                if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                  break label6549;
                }
                parama1 = new bk(parambu, parama1, paramString.url);
                parama1.position = paramInt;
                localbi.Khk.odh.setTag(parama1);
                localbi.Khk.odh.setOnClickListener(this.qkD);
                i = 1;
                label6122:
                localbi.Khk.odh.setOnLongClickListener(c(this.JBI));
                localbi.Khk.odh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                if (i != 0) {
                  break label6668;
                }
                localbi.Khk.Khs.setVisibility(8);
                localbi.Khk.Khq.setVisibility(8);
                label6201:
                if (com.tencent.mm.n.g.acB().acq())
                {
                  localbi.JZr.setVisibility(0);
                  c(this.JBI, localbi.JZr, new s.o(paramString.hAT, parambu, parama));
                }
                parama = localbi.Khk;
                if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
                  break label6695;
                }
                paramInt = 1;
                if (paramInt != 0) {
                  break label6700;
                }
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                parama.Kho.setTag(null);
                parama.Khp.setTag(null);
                parama.Kho.setVisibility(8);
                parama.Khp.setVisibility(8);
              }
              for (;;)
              {
                localbi.Khk.odh.setVisibility(0);
                AppMethodBeat.o(37242);
                return;
                a(localbi, this.JBI, parambu, parama1);
                a(localbi.JYo, this.JBI, parama1, parambu, null);
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(parama1))
                {
                  localbi.Khk.Khn.setTag(new bk(parambu, parama1));
                  localbi.Khk.Khn.setOnClickListener(this.JYH);
                  break;
                }
                paramString = localbi.Khk.Khn;
                if (this.JBI.fFv()) {}
                for (parama = this.JBI.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bk(parama1, parama));
                  localbi.Khk.Khn.setOnClickListener(e(this.JBI));
                  break;
                }
                label6497:
                localbi.Khk.Khn.setVisibility(8);
                localbi.Khk.gnM.setTextSize(0, com.tencent.mm.cc.a.ax(localbi.Khk.gnM.getContext(), 2131165184));
                break label5934;
                i = 0;
                break label6023;
                label6549:
                if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM(paramString.url)) {
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramString.url, -1, 2, new Object[0]);
                }
                localbi.Khk.odh.setTag(new bk(parambu, false, paramInt, paramString.url, false, this.JBI.fCR(), parama1, parama, paramString.title).aWJ(paramString.dNL));
                localbi.Khk.odh.setOnClickListener(h(this.JBI));
                break label6122;
                localbi.Khk.Khs.setVisibility(0);
                localbi.Khk.Khq.setVisibility(0);
                break label6201;
                label6695:
                paramInt = 0;
                break label6275;
                label6700:
                if (parama.Khn.getVisibility() == 0)
                {
                  parama.Kho.setTag(parambu);
                  parama.Kho.setOnClickListener(this.KdH);
                  parama.Kho.setVisibility(0);
                  parama.Khp.setVisibility(8);
                }
                else
                {
                  parama.Khp.setTag(parambu);
                  parama.Khp.setOnClickListener(this.KdH);
                  parama.Khp.setVisibility(0);
                  parama.Kho.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bu parambu, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.yEk == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    parambu = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aWa(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parambu, parama.yEk.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(194462);
    parambu = (bk)paramView.getTag();
    if (parambu == null)
    {
      AppMethodBeat.o(194462);
      return false;
    }
    int i = parambu.position;
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
    }
    if ((i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
      paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
    }
    AppMethodBeat.o(194462);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  protected final boolean fHk()
  {
    return this.KdO == 0;
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      if (!(paramView.getTag() instanceof com.tencent.mm.storage.bu))
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      localObject = (com.tencent.mm.storage.bu)paramView.getTag();
      if (localObject == null)
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = bw.M(((ei)localObject).field_content, "msg");
      if ((localMap == null) || (localMap.size() == 0))
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      bt.nullAsNil((String)localMap.get(".msg.fromusername"));
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(37233);
          paramAnonymousl.add(0, 1, 0, paramView.getResources().getString(2131761750));
          AppMethodBeat.o(37233);
        }
      };
      locale.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(37237);
          ad.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()), Integer.valueOf(paramAnonymousInt) });
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37237);
            return;
            ba.aiU().a(1198, new com.tencent.mm.al.f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, final String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
              {
                AppMethodBeat.i(37235);
                ba.aiU().b(1198, this);
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, Boolean.FALSE });
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
                if (ai.a.2.this.hED != ai.a.2.this.val$v.getTag())
                {
                  ad.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(ai.a.2.this.hED.field_msgId) });
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = ((s)paramAnonymous2n).aDO();
                if (paramAnonymous2String == null)
                {
                  t.makeText(ai.a.2.this.val$v.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = paramAnonymous2String.HTe;
                paramAnonymous2n = bt.nullAsNil((String)ai.a.2.this.fKy.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).yt(paramAnonymous2n))
                {
                  ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramAnonymous2n, new n.a()
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
                        ad.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous2String });
                        t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      try
                      {
                        int i = bt.getInt((String)ai.a.2.this.fKy.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                        int j = bt.getInt((String)ai.a.2.this.fKy.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                        paramAnonymous3WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8"), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
                        ad.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, localObject, paramAnonymous3WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous3WxaAttributes);
                        c.t((Intent)localObject, ai.b(ai.this).getTalkerUserName());
                        com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37234);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous3WxaAttributes)
                      {
                        ad.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                      }
                    }
                  });
                  AppMethodBeat.o(37235);
                  return;
                }
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { paramAnonymous2n });
                try
                {
                  paramAnonymous2n = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { paramAnonymous2n, URLEncoder.encode(ai.a(ai.this), "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8") });
                  ad.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, ai.a(ai.this), paramAnonymous2n });
                  paramAnonymous2String = new Intent();
                  paramAnonymous2String.putExtra("rawUrl", paramAnonymous2n);
                  c.t(paramAnonymous2String, ai.b(ai.this).getTalkerUserName());
                  com.tencent.mm.bs.d.b(ai.b(ai.this).JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2String);
                  AppMethodBeat.o(37235);
                  return;
                }
                catch (UnsupportedEncodingException paramAnonymous2String)
                {
                  ad.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                  t.makeText(ai.a.2.this.val$v.getContext(), 2131761756, 0).show();
                  AppMethodBeat.o(37235);
                }
              }
            });
            paramAnonymousMenuItem = new s(this.hED.field_content);
            ai localai = ai.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            ai.a(localai, h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(37236);
                ba.aiU().a(paramAnonymousMenuItem);
                AppMethodBeat.o(37236);
              }
            }));
            ba.aiU().a(paramAnonymousMenuItem, 0);
          }
        }
      };
      locale.cMW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
    }
  }
  
  public static final class b
  {
    public String dNL;
    public String hAT;
    public String hDk;
    public String hDl;
    public String hDm;
    public String hDn;
    public String hDo;
    public long time;
    public String title;
    public int type;
    public String url;
    
    public static b bX(Map<String, String> paramMap)
    {
      AppMethodBeat.i(37239);
      b localb = new b();
      localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
      localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
      localb.dNL = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
      localb.hDk = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
      localb.hDl = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
      localb.time = bt.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
      localb.hDm = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
      localb.hDn = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
      localb.hDo = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
      localb.type = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
      localb.hAT = ((String)paramMap.get(".msg.appmsg.template_id"));
      AppMethodBeat.o(37239);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai
 * JD-Core Version:    0.7.0.1
 */