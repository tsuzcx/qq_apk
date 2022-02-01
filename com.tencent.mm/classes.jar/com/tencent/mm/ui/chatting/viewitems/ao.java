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
import android.os.Bundle;
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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.a.yw.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.c;
import com.tencent.mm.msgsubscription.b.a.a;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.report.live.s.az;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.t.b;
import com.tencent.mm.ui.chatting.t.o;
import com.tencent.mm.ui.chatting.t.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.widget.a.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.x;

public final class ao
  extends c
{
  private static final String PHp;
  private static final String PMD;
  private static final String PME;
  private static int PMV;
  private static int PMW;
  private com.tencent.mm.ui.base.q Fxt;
  private com.tencent.mm.av.a.a.c Oxy;
  private View.OnClickListener PHr;
  private View.OnClickListener PMF;
  private View.OnClickListener PMG;
  private View.OnClickListener PMH;
  private View.OnClickListener PMI;
  private com.tencent.mm.ui.m PMJ;
  private View.OnClickListener PMK;
  private ISubscribeMsgService.c PML;
  private String PMM;
  private int PMN;
  private com.tencent.mm.msgsubscription.b.a PMO;
  private String PMP;
  private int PMQ;
  private com.tencent.mm.msgsubscription.c.a.b PMR;
  private boolean PMS;
  private e PMT;
  private boolean PMU;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private IListener<op> PvR;
  private com.tencent.mm.ui.base.q gxX;
  private com.tencent.mm.msgsubscription.b.a jzW;
  private String mAppId;
  private View.OnClickListener rID;
  
  static
  {
    AppMethodBeat.i(37267);
    PHp = "https://" + WeChatHosts.domainString(2131761726) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    PMD = "https://" + WeChatHosts.domainString(2131761726) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    PME = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect";
    PMV = MMApplicationContext.getContext().getResources().getColor(2131100245);
    PMW = MMApplicationContext.getContext().getResources().getColor(2131100245);
    AppMethodBeat.o(37267);
  }
  
  public ao()
  {
    AppMethodBeat.i(37240);
    this.PML = new ISubscribeMsgService.c(true, false);
    this.PMP = "";
    this.PMQ = -1;
    this.PMR = new com.tencent.mm.msgsubscription.c.a.b();
    this.PMS = false;
    this.PMT = null;
    this.PMU = false;
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    ((com.tencent.mm.av.a.a.c.a)localObject).iaT = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).jbq = 2131231405;
    this.Oxy = ((com.tencent.mm.av.a.a.c.a)localObject).bdv();
    localObject = com.tencent.mm.msgsubscription.api.b.jza;
    this.jzW = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
    localObject = com.tencent.mm.msgsubscription.api.b.jza;
    this.PMO = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
    this.PMG = new a((byte)0);
    this.PMK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = (bq)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = XmlParser.parseXml(paramAnonymousView.dTX.field_content, "msg", null);
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), localObject1, Integer.valueOf(66666) });
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (Util.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.r((Intent)localObject1, ao.b(ao.this).getTalkerUserName());
            com.tencent.mm.br.c.b(ao.b(ao.this).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37198);
          return;
          String str = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
          int i = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
          int j = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
          localObject2 = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.dCw = (paramAnonymousView.dTX.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + (String)localObject2);
          localAppBrandStatObject.scene = ao.aeQ((String)localObject2);
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(ao.b(ao.this).Pwc.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        }
      }
    };
    this.PHr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = (bq)paramAnonymousView.getTag();
        Object localObject2 = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dTX.field_content, "msg", null);
        if ((localObject2 != null) && (((Map)localObject2).size() != 0))
        {
          Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
          if (!ao.a(ao.this, (Map)localObject2)) {}
        }
        for (boolean bool = Util.getBoolean((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false);; bool = false)
        {
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click, blockProfile: %b", new Object[] { ((bq)localObject1).userName, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject2 = ao.this;
            paramAnonymousView.getContext();
            ao.a((ao)localObject2, ((bq)localObject1).userName);
            ao.a(ao.this, 10, ao.b(ao.this).getTalkerUserName(), ((bq)localObject1).userName);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37215);
          return;
        }
      }
    };
    this.PvR = new IListener() {};
    this.PMJ = new com.tencent.mm.ui.m()
    {
      public final void cFx() {}
      
      public final void cFy() {}
      
      public final void gIk() {}
      
      public final void gIl() {}
      
      public final void gIm() {}
      
      public final void gIn()
      {
        AppMethodBeat.i(233863);
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        EventCenter.instance.removeListener(ao.c(ao.this));
        if (ao.b(ao.this) != null) {
          ((j)ao.b(ao.this).bh(j.class)).b(this);
        }
        AppMethodBeat.o(233863);
      }
      
      public final void gIo() {}
    };
    this.PMH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233864);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        bq localbq = (bq)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbq.userName });
        wq localwq = new wq();
        localwq.ecI.userName = localbq.userName;
        localwq.ecI.ecK = localbq.pageUrl;
        Map localMap = XmlParser.parseXml(localbq.dTX.field_content, "msg", null);
        localObject = "";
        paramAnonymousView = (View)localObject;
        if (localMap != null)
        {
          paramAnonymousView = (View)localObject;
          if (localMap.size() > 0)
          {
            localwq.ecI.ecL = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localwq.ecI.ecP = true;
        localwq.ecI.scene = ao.aeQ(paramAnonymousView);
        localwq.ecI.dCw = (localbq.dTX.field_msgSvrId + ":" + localbq.userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + paramAnonymousView);
        EventCenter.instance.publish(localwq);
        ao.nj(ao.d(ao.this), ao.a(ao.this));
        com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), localbq.userName, Integer.valueOf(0) });
        ao.a(ao.this, 2, ao.b(ao.this).getTalkerUserName(), localbq.userName);
        ao.a(ao.this, 8, localbq.userName, 1, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233864);
      }
    };
    this.rID = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = (bq)paramAnonymousView.getTag();
        Object localObject2 = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dTX.field_content, "msg", null);
        if (localObject2 == null)
        {
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
        }
        int i = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String str1;
        String str2;
        int j;
        int k;
        if (i == 1)
        {
          str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
          str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
          j = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          k = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).dCw = (((bq)localObject1).dTX.field_msgSvrId + ":" + ((bq)localObject1).userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(((bq)localObject1).userName))
          {
            ((AppBrandStatObject)localObject2).scene = ao.aeQ(paramAnonymousView);
            ((r)com.tencent.mm.kernel.g.af(r.class)).a(ao.b(ao.this).Pwc.getContext(), str1, null, k, j, str2, (AppBrandStatObject)localObject2);
            ao.nj(ao.d(ao.this), ao.a(ao.this));
            com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), ((bq)localObject1).userName, Integer.valueOf(0) });
            ao.a(ao.this, 2, ao.b(ao.this).getTalkerUserName(), ((bq)localObject1).userName);
            label428:
            paramAnonymousView = ao.this;
            localObject1 = ((bq)localObject1).userName;
            if (i != 1) {
              break label632;
            }
          }
        }
        label632:
        for (i = 1;; i = 2)
        {
          ao.a(paramAnonymousView, 8, (String)localObject1, i, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
          ((AppBrandStatObject)localObject2).scene = 1043;
          paramAnonymousView = com.tencent.mm.al.g.fJ(((bq)localObject1).userName);
          r localr = (r)com.tencent.mm.kernel.g.af(r.class);
          Activity localActivity = ao.b(ao.this).Pwc.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localr.a(localActivity, str1, null, k, j, str2, (AppBrandStatObject)localObject2, paramAnonymousView);
            break;
          }
          if (i != 2) {
            break label428;
          }
          str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
          long l = Util.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
          ao.g(paramAnonymousView.getContext(), str1, l);
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str1, Long.valueOf(l) });
          break label428;
        }
      }
    };
    this.PMI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = (bq)paramAnonymousView.getTag();
        int i = ((bq)localObject1).opType;
        Object localObject2 = ((bq)localObject1).PQK;
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "jumpNativePage opType: %d, opInfo: %s", new Object[] { Integer.valueOf(((bq)localObject1).opType), ((bq)localObject1).PQK });
        Object localObject4;
        Object localObject3;
        int j;
        if (i == 3)
        {
          paramAnonymousView = ao.b(ao.this).Pwc.getContext();
          Log.i("SnsAdUtil", "type = 0content = " + (String)localObject2);
          localObject4 = com.tencent.mm.plugin.sns.data.k.aOc((String)localObject2);
          localObject2 = ((com.tencent.mm.plugin.sns.data.s)localObject4).pageId;
          localObject3 = ((com.tencent.mm.plugin.sns.data.s)localObject4).uxInfo;
          localObject4 = ((com.tencent.mm.plugin.sns.data.s)localObject4).lAP;
          if (paramAnonymousView != null)
          {
            if (!Util.isNullOrNil(new String[] { localObject2, localObject3, localObject4 })) {}
          }
          else
          {
            Log.e("SnsAdUtil", "context or pageId or uxInfo or adInfoXml is null");
            paramAnonymousView = ((bq)localObject1).CAJ;
            if (paramAnonymousView != null)
            {
              j = paramAnonymousView.getInt("click_area_type");
              if (j != 1) {
                break label489;
              }
              localObject2 = ao.this;
              if (((bq)localObject1).dTX == null) {
                break label482;
              }
              paramAnonymousView = ((bq)localObject1).dTX.field_talker;
              label239:
              ao.a((ao)localObject2, 2, paramAnonymousView, ((bq)localObject1).userName);
            }
            label251:
            paramAnonymousView = ao.this;
            localObject1 = ((bq)localObject1).userName;
            if (i != 1) {
              break label539;
            }
          }
        }
        label539:
        for (i = 1;; i = 2)
        {
          for (;;)
          {
            ao.a(paramAnonymousView, 8, (String)localObject1, i, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37232);
            return;
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("sns_landing_pages_pageid", Util.safeParseLong((String)localObject2));
            ((Intent)localObject3).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            ((Intent)localObject3).putExtra("sns_landig_pages_from_source", 21);
            ((Intent)localObject3).putExtra("sns_landing_pages_ad_info", (String)localObject4);
            com.tencent.mm.br.c.b(paramAnonymousView, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject3);
            break;
            if (i != 4) {
              break;
            }
            try
            {
              paramAnonymousView = new com.tencent.mm.ab.i(((bq)localObject1).PQK);
              long l1 = com.tencent.mm.ac.d.Ga(paramAnonymousView.optString("feed_id"));
              long l2 = com.tencent.mm.ac.d.Ga(paramAnonymousView.optString("live_id"));
              paramAnonymousView = paramAnonymousView.optString("nonce_id");
              ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), l1, Long.valueOf(l2), "", paramAnonymousView, "", "", "");
              ao.a(l1, l2, ((bq)localObject1).userName, ((bq)localObject1).position);
            }
            catch (Throwable paramAnonymousView)
            {
              Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", paramAnonymousView, "OP_ITEM_TYPE_FINDER_LIVE exception", new Object[0]);
            }
          }
          break;
          label482:
          paramAnonymousView = "";
          break label239;
          label489:
          if (j != 2) {
            break label251;
          }
          localObject2 = ao.this;
          if (((bq)localObject1).dTX != null) {}
          for (paramAnonymousView = ((bq)localObject1).dTX.field_talker;; paramAnonymousView = "")
          {
            ao.a((ao)localObject2, 3, paramAnonymousView, ((bq)localObject1).userName);
            break;
          }
        }
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private void R(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(233879);
    String str1;
    if (paramBoolean)
    {
      str1 = this.PhN.Pwc.getContext().getString(2131763704);
      if (!paramBoolean) {
        break label140;
      }
    }
    label140:
    for (String str2 = this.PhN.Pwc.getContext().getString(2131763703);; str2 = this.PhN.Pwc.getContext().getString(2131763740))
    {
      com.tencent.mm.ui.base.h.a(this.PhN.Pwc.getContext(), str2, str1, this.PhN.Pwc.getContext().getString(2131763743), this.PhN.Pwc.getContext().getString(2131755761), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233839);
          paramAnonymousDialogInterface = new Intent(ao.b(ao.this).Pwc.getContext(), BizSubscribeMsgManagerUI.class);
          paramAnonymousDialogInterface.putExtra("key_biz_username", paramString);
          paramAnonymousDialogInterface.putExtra("key_biz_nickname", aa.getDisplayName(paramString));
          if (paramBoolean)
          {
            paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
            if (!paramBoolean) {
              break label158;
            }
          }
          label158:
          for (paramAnonymousInt = 100;; paramAnonymousInt = 101)
          {
            com.tencent.mm.br.c.a((MMFragmentActivity)ao.b(ao.this).Pwc.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramAnonymousDialogInterface, paramAnonymousInt, new MMFragmentActivity.b()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(233838);
                Object localObject;
                if ((paramAnonymous2Int1 == 100) && (paramAnonymous2Intent != null))
                {
                  paramAnonymous2Intent = (SubscribeMsgSettingData)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                  if (paramAnonymous2Intent != null)
                  {
                    ao.k(ao.this);
                    localObject = com.tencent.mm.msgsubscription.util.c.jDh;
                    com.tencent.mm.msgsubscription.util.c.a(ao.11.this.gtu, paramAnonymous2Intent, new kotlin.g.a.b() {});
                  }
                  AppMethodBeat.o(233838);
                  return;
                }
                if ((paramAnonymous2Int1 == 101) && (paramAnonymous2Intent != null))
                {
                  boolean bool = paramAnonymous2Intent.getBooleanExtra("key_need_update", false);
                  Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", new Object[] { Boolean.valueOf(bool) });
                  if (!bool)
                  {
                    AppMethodBeat.o(233838);
                    return;
                  }
                  paramAnonymous2Intent = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                  localObject = com.tencent.mm.msgsubscription.api.b.jza;
                  localObject = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
                  if ((paramAnonymous2Intent != null) && (localObject != null))
                  {
                    ao.k(ao.this);
                    com.tencent.mm.msgsubscription.api.c localc = new com.tencent.mm.msgsubscription.api.c();
                    localc.setUsername(Util.nullAs(ao.11.this.gtu, ""));
                    localc.jyV.addAll(paramAnonymous2Intent.jyV);
                    localc.jzb = paramAnonymous2Intent.jyW;
                    localc.jze = new com.tencent.mm.msgsubscription.api.a()
                    {
                      public final void a(String paramAnonymous3String, SubscribeMsgRequestResult paramAnonymous3SubscribeMsgRequestResult)
                      {
                        AppMethodBeat.i(233836);
                        Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                        ao.l(ao.this);
                        if (ao.b(ao.this) != null) {
                          ao.b(ao.this).cmy();
                        }
                        AppMethodBeat.o(233836);
                      }
                      
                      public final void i(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(233837);
                        Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String });
                        ao.l(ao.this);
                        u.makeText(ao.b(ao.this).Pwc.getContext(), ao.b(ao.this).Pwc.getContext().getString(2131763742), 1).show();
                        AppMethodBeat.o(233837);
                      }
                    };
                    ((ISubscribeMsgService)localObject).a(localc);
                  }
                }
                AppMethodBeat.o(233838);
              }
            });
            AppMethodBeat.o(233839);
            return;
            paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
            paramAnonymousDialogInterface.putExtra("key_need_update", false);
            paramAnonymousDialogInterface.putExtra("key_need_load_from_remote", true);
            paramAnonymousDialogInterface.putExtra("key_enter_scene", 2);
            break;
          }
        }
      }, null).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(233879);
      return;
      str1 = this.PhN.Pwc.getContext().getString(2131763741);
      break;
    }
  }
  
  private void X(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(233873);
    if (!rL(this.PMQ))
    {
      AppMethodBeat.o(233873);
      return;
    }
    if (!ab.Jx(paramString1))
    {
      AppMethodBeat.o(233873);
      return;
    }
    if (!com.tencent.mm.al.g.Nb(paramString2))
    {
      AppMethodBeat.o(233873);
      return;
    }
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.PMR);
    AppMethodBeat.o(233873);
  }
  
  private static void Y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    Log.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.CyF.a(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(37253);
  }
  
  private static void a(int paramInt, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(233884);
    if (paramInt == 4) {
      try
      {
        l = com.tencent.mm.ac.d.Ga(new com.tencent.mm.ab.i(Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string"))).optString("live_id"));
        if (com.tencent.mm.plugin.expt.hellhound.a.aow(com.tencent.mm.plugin.expt.hellhound.core.b.zs(l)))
        {
          AppMethodBeat.o(233884);
          return;
        }
      }
      catch (Exception paramMap)
      {
        long l;
        for (;;)
        {
          Log.e("MicroMsg.ChattingItemDyeingTemplate", "opExtraInfo, liveId, crash: %s", new Object[] { paramMap.getMessage() });
          l = 0L;
        }
        paramMap = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.az.vsV, paramString, l, "");
      }
    }
    AppMethodBeat.o(233884);
  }
  
  private void a(View paramView, ca paramca, Map<String, String> paramMap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233874);
    if (paramca == null)
    {
      AppMethodBeat.o(233874);
      return;
    }
    if (!"notifymessage".equals(paramca.field_talker))
    {
      AppMethodBeat.o(233874);
      return;
    }
    paramca = (bq)paramView.getTag();
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string"));
    paramca.opType = paramInt1;
    paramca.PQK = paramMap;
    paramMap = new Bundle();
    paramMap.putInt("click_area_type", paramInt2);
    paramca.CAJ = paramMap;
    paramView.setTag(paramca);
    paramView.setOnClickListener(this.PMI);
    AppMethodBeat.o(233874);
  }
  
  private void a(ImageView paramImageView, final com.tencent.mm.ui.chatting.e.a parama, final String paramString1, ca paramca, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233872);
    if (paramImageView == null)
    {
      AppMethodBeat.o(233872);
      return;
    }
    if (ab.JE(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(233872);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(paramString1))
    {
      com.tencent.mm.av.q.bcV().a(paramString2, paramImageView, this.Oxy);
      paramImageView.setTag(new bq(paramca, paramString1));
      paramImageView.setOnClickListener(this.PHr);
    }
    for (;;)
    {
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(aa.getDisplayName(paramString1) + parama.Pwc.getContext().getString(2131756221));
      AppMethodBeat.o(233872);
      return;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
      if (parama.gRM()) {}
      for (paramca = parama.getTalkerUserName();; paramca = null)
      {
        paramImageView.setTag(new bq(paramString1, paramca));
        if (!Util.getBoolean((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
          break label214;
        }
        paramImageView.setOnClickListener(null);
        break;
      }
      label214:
      paramImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233826);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = ao.this.e(parama);
          if (localObject != null) {
            ((t.b)localObject).onClick(paramAnonymousView);
          }
          ao.a(ao.this, 10, parama.getTalkerUserName(), paramString1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233826);
        }
      });
    }
  }
  
  private void a(bp parambp, Map<String, String> paramMap, ca paramca)
  {
    AppMethodBeat.i(233875);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
      parambp.PQy.setTag(null);
      parambp.PQz.setTag(null);
      parambp.PQy.setVisibility(8);
      parambp.PQz.setVisibility(8);
      AppMethodBeat.o(233875);
      return;
    }
    if (parambp.PQx.getVisibility() == 0)
    {
      parambp.PQy.setTag(paramca);
      parambp.PQy.setOnClickListener(this.PMG);
      parambp.PQy.setVisibility(0);
      parambp.PQz.setVisibility(8);
      AppMethodBeat.o(233875);
      return;
    }
    parambp.PQz.setTag(paramca);
    parambp.PQz.setOnClickListener(this.PMG);
    parambp.PQz.setVisibility(0);
    parambp.PQy.setVisibility(8);
    AppMethodBeat.o(233875);
  }
  
  private void a(final bv parambv)
  {
    AppMethodBeat.i(233870);
    this.PMF = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(233867);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = (ca)paramAnonymousView.getTag(2131305340);
        if (localObject == null)
        {
          Log.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233867);
          return;
        }
        final Map localMap = XmlParser.parseXml(((eo)localObject).field_content, "msg", null);
        if ((localMap == null) || (localMap.size() == 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233867);
          return;
        }
        final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
        final boolean bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str);
        ao.a(ao.this, new e(paramAnonymousView.getContext(), 1, false));
        ao.g(ao.this).HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(233865);
            paramAnonymous2m.clear();
            if (!ao.e(ao.this)) {
              ao.a(ao.this, this.iBF, localMap, paramAnonymous2m, ao.f(ao.this));
            }
            if (bool) {}
            for (String str = paramAnonymousView.getResources().getString(2131763721);; str = paramAnonymousView.getResources().getString(2131763719))
            {
              paramAnonymous2m.add(0, 2, 0, str);
              AppMethodBeat.o(233865);
              return;
            }
          }
        };
        ao.g(ao.this).HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(233866);
            int i = paramAnonymous2MenuItem.getItemId();
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected. msgId: %s, v: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymous2Int), Long.valueOf(this.iBF.field_msgId), paramAnonymousView });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              if (ao.h(ao.this))
              {
                if (i != 2) {
                  break label221;
                }
                paramAnonymous2Int = 1;
              }
              break;
            }
            for (;;)
            {
              ao.a(ao.this, 9, str, 0, paramAnonymous2Int);
              AppMethodBeat.o(233866);
              return;
              ao.a(ao.this, paramAnonymousView, this.iBF, localMap, str);
              break;
              boolean bool = ao.a(ao.this, localMap);
              ao.a(ao.this, this.iBF, localMap, bool, bool, ao.f(ao.this), ao.36.this.PMZ);
              break;
              label221:
              if (i == 1) {
                paramAnonymous2Int = 2;
              } else if (i == 0) {
                paramAnonymous2Int = 3;
              } else {
                paramAnonymous2Int = 0;
              }
            }
          }
        };
        ao.g(ao.this).dGm();
        ao.a(ao.this, 4, ((eo)localObject).field_talker, str);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233867);
      }
    };
    parambv.PRb.setOnClickListener(this.PMF);
    AppMethodBeat.o(233870);
  }
  
  private void a(bv parambv, int paramInt)
  {
    AppMethodBeat.i(233883);
    if (this.PMU)
    {
      parambv.PRe.setVisibility(paramInt);
      AppMethodBeat.o(233883);
      return;
    }
    parambv.PQZ.setVisibility(paramInt);
    AppMethodBeat.o(233883);
  }
  
  private void a(bv parambv, ca paramca, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    LinearLayout localLinearLayout = parambv.PRq;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      final String str1;
      final String str2;
      for (parambv = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambv = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str1 = (String)paramMap.get(parambv + ".word");
        str2 = (String)paramMap.get(parambv + ".hint_word");
        if (!Util.isNullOrNil(str1)) {
          break label194;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label1128;
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
      if (i < j)
      {
        localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
        label213:
        if (!h(paramMap, i)) {
          break label354;
        }
        ((LinearLayout)localObject1).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.PhN.Pwc.getContext()).inflate(2131493487, null, false);
        Object localObject2 = new a();
        ((a)localObject2).hbb = ((TextView)((LinearLayout)localObject1).findViewById(2131305326));
        ((a)localObject2).kc = ((ImageView)((LinearLayout)localObject1).findViewById(2131305325));
        ((a)localObject2).OFA = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131305323));
        ((a)localObject2).kbe = ((TextView)((LinearLayout)localObject1).findViewById(2131305324));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label213;
        label354:
        ((LinearLayout)localObject1).setVisibility(0);
        localObject1 = (a)((LinearLayout)localObject1).getTag();
        localObject2 = (String)paramMap.get(parambv + ".icon");
        final int k = com.tencent.mm.ui.ao.hT(c(paramMap, parambv + ".color", this.PhN.Pwc.getContext().getResources().getColor(2131100904)));
        ((a)localObject1).hbb.setTextColor(k);
        if (Util.getInt((String)paramMap.get(parambv + ".is_rich_text"), 0) == 0)
        {
          ((a)localObject1).hbb.setSingleLine(true);
          ((a)localObject1).hbb.setEllipsize(TextUtils.TruncateAt.END);
          ((a)localObject1).hbb.setText(str1);
          label525:
          ((a)localObject1).kbe.setText(str2);
          ((a)localObject1).kbe.setTextColor(this.PhN.Pwc.getContext().getResources().getColor(2131099748));
          if (!Util.isNullOrNil((String)localObject2)) {
            break label864;
          }
          ((a)localObject1).kc.setVisibility(8);
          ((a)localObject1).hbb.setPadding(0, 0, 0, 0);
        }
        final int m;
        for (;;)
        {
          localObject2 = (String)paramMap.get(parambv + ".url");
          str1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
          m = Util.getInt((String)paramMap.get(parambv + ".op_type"), 0);
          str2 = (String)paramMap.get(parambv + ".weapp_username");
          bq localbq = new bq(paramca, str1, (String)localObject2);
          ((a)localObject1).OFA.setTag(localbq);
          k = i + 1;
          if ((m != 3) && (m != 4)) {
            break label912;
          }
          a(((a)localObject1).OFA, paramca, paramMap, m, 2);
          break;
          k = Util.getInt((String)paramMap.get(parambv + ".display_line_number"), 1);
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
          ((a)localObject1).hbb.setSingleLine(false);
          ((a)localObject1).hbb.setText(str1);
          ((a)localObject1).hbb.setMaxLines(k);
          l.a(((a)localObject1).hbb, false, null);
          break label525;
          label864:
          ((a)localObject1).kc.setVisibility(0);
          o(((a)localObject1).kc, (String)localObject2);
          ((a)localObject1).hbb.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.PhN.Pwc.getContext(), 28), 0);
        }
        label912:
        if ((m == 1) && (!TextUtils.isEmpty(str2)))
        {
          localObject2 = (String)paramMap.get(parambv + ".weapp_path");
          m = Util.getInt((String)paramMap.get(parambv + ".weapp_version"), 0);
          final int n = Util.getInt((String)paramMap.get(parambv + ".weapp_state"), 0);
          parambv = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(233860);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              paramAnonymousView = (bq)paramAnonymousView.getTag();
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
              localObject = new AppBrandStatObject();
              ((AppBrandStatObject)localObject).dCw = (paramAnonymousView.dTX.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + this.PJL);
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(paramAnonymousView.userName))
              {
                ((AppBrandStatObject)localObject).scene = ao.aeQ(this.PJL);
                ((r)com.tencent.mm.kernel.g.af(r.class)).a(ao.b(ao.this).Pwc.getContext(), str2, null, n, m, this.PNr, (AppBrandStatObject)localObject);
                ao.nj(ao.d(ao.this), ao.a(ao.this));
                com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), str1, Integer.valueOf(k) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233860);
                return;
              }
              ((AppBrandStatObject)localObject).scene = 1043;
              paramAnonymousView = com.tencent.mm.al.g.fJ(paramAnonymousView.userName);
              r localr = (r)com.tencent.mm.kernel.g.af(r.class);
              Activity localActivity = ao.b(ao.this).Pwc.getContext();
              String str1 = str2;
              int i = n;
              int j = m;
              String str2 = this.PNr;
              if (paramAnonymousView == null) {}
              for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
              {
                localr.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                break;
              }
            }
          };
          ((a)localObject1).OFA.setOnClickListener(parambv);
        }
        else if (m == 2)
        {
          ((a)localObject1).OFA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(233861);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              if (k == 1)
              {
                localObject = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                long l = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                ao.g(paramAnonymousView.getContext(), (String)localObject, l);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 2L, 1L, false);
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject, Long.valueOf(l) });
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233861);
                return;
                if (k == 2) {
                  com.tencent.mm.br.c.f(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
                }
              }
            }
          });
        }
        else
        {
          ((a)localObject1).OFA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(233862);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (!Util.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                c.r(paramAnonymousView, ao.b(ao.this).getTalkerUserName());
                com.tencent.mm.br.c.b(ao.b(ao.this).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), str1, Integer.valueOf(k) });
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(233862);
            }
          });
        }
      }
    }
    label1128:
    AppMethodBeat.o(37251);
  }
  
  private void a(bv parambv, String paramString1, String paramString2, Map<String, String> paramMap, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    parambv.PQY.setText(l.b(this.PhN.Pwc.getContext(), paramString2, parambv.PQY.getTextSize()));
    com.tencent.mm.av.q.bcV().a(paramString1, parambv.PQX, this.Oxy);
    parambv.PQX.setTag(null);
    parambv.PQX.setOnClickListener(null);
    parambv.PQW.setTag(null);
    parambv.PQW.setOnClickListener(null);
    parambv.PQW.setVisibility(0);
    paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambv.PQW.setTag(new bq(paramca, paramString1));
      parambv.PQW.setOnClickListener(this.PMK);
    }
    for (;;)
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (Util.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambv.PRa.getParent()).setVisibility(0);
      com.tencent.mm.av.q.bcV().a(paramString1, parambv.PRa, this.Oxy);
      AppMethodBeat.o(37247);
      return;
      parambv.PQW.setOnClickListener(null);
    }
    ((View)parambv.PRa.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(bv parambv, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37250);
    Object localObject2 = new ArrayList();
    int i = 0;
    int j = 0;
    label37:
    Object localObject3;
    Object localObject4;
    label223:
    int k;
    label241:
    bs localbs;
    if (j < 100)
    {
      if (j == 0)
      {
        localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
        localObject3 = (String)paramMap.get((String)localObject1 + ".value.word");
        localObject4 = (String)paramMap.get((String)localObject1 + ".key.word");
        if ((!Util.isNullOrNil((String)localObject3)) || (!Util.isNullOrNil((String)localObject4))) {
          break label403;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      j = i;
      if (i > 8) {
        j = 8;
      }
      localObject3 = parambv.PRn;
      ((LinearLayout)localObject3).setVisibility(0);
      localObject1 = ((ViewGroup)parambv.PRn.getParent()).findViewById(2131299393);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((LinearLayout)localObject3).getChildCount() > ((List)localObject2).size())
      {
        if (((List)localObject2).size() != 0) {
          break label863;
        }
        ((LinearLayout)localObject3).removeAllViews();
      }
      localObject4 = new StringBuilder();
      k = ((LinearLayout)localObject3).getChildCount();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label1028;
      }
      localbs = (bs)((List)localObject2).get(i);
      if (i >= k) {
        break label893;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject3).getChildAt(i);
      label282:
      localObject1 = (bt)((LinearLayout)localObject1).getTag();
      if (!localbs.PQQ) {
        break label977;
      }
      ((bt)localObject1).PQR.setVisibility(8);
    }
    for (;;)
    {
      ((bt)localObject1).PQS.setTextColor(com.tencent.mm.ui.ao.hT(localbs.PQP));
      ((bt)localObject1).PQS.setText(localbs.PQN);
      ((StringBuilder)localObject4).append(Util.nullAs(localbs.PQM, "")).append(":").append(Util.nullAs(localbs.PQN, "")).append("\n");
      i += 1;
      break label241;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label403:
      localbs = new bs();
      localbs.PQN = ((String)localObject3);
      localbs.PQM = Util.nullAsNil((String)localObject4);
      label567:
      boolean bool;
      if (!com.tencent.mm.ui.ao.isDarkMode())
      {
        localbs.PQO = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", PMV));
        localbs.PQP = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.PhN.Pwc.getContext().getResources().getColor(2131100904)));
        if (Util.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label854;
        }
        bool = true;
        label607:
        localbs.PQQ = bool;
        k = (bnj(localbs.PQM) + 1) / 2;
        if (k <= i) {
          break label860;
        }
        i = k;
      }
      label854:
      label860:
      for (;;)
      {
        ((List)localObject2).add(localbs);
        j += 1;
        break;
        localbs.PQO = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", PMV)));
        localbs.PQP = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.PhN.Pwc.getContext().getResources().getColor(2131100904))));
        localbs.PQP = com.tencent.mm.ui.ao.hT(localbs.PQP);
        break label567;
        bool = false;
        break label607;
      }
      label863:
      i = ((LinearLayout)localObject3).getChildCount();
      ((LinearLayout)localObject3).removeViews(((List)localObject2).size(), i - ((List)localObject2).size());
      break label223;
      label893:
      localObject1 = (LinearLayout)LayoutInflater.from(this.PhN.Pwc.getContext()).inflate(2131493488, null, false);
      bt localbt = new bt();
      localbt.PQR = ((TextView)((LinearLayout)localObject1).findViewById(2131303200));
      localbt.PQS = ((TextView)((LinearLayout)localObject1).findViewById(2131303207));
      ((LinearLayout)localObject1).setTag(localbt);
      ((LinearLayout)localObject3).addView((View)localObject1);
      break label282;
      label977:
      ((bt)localObject1).PQR.setVisibility(0);
      ((bt)localObject1).PQR.setEms(j);
      ((bt)localObject1).PQR.setTextColor(com.tencent.mm.ui.ao.hT(localbs.PQO));
      ((bt)localObject1).PQR.setText(localbs.PQM);
    }
    label1028:
    Object localObject1 = this.PMR;
    localObject2 = ((StringBuilder)localObject4).toString();
    p.h(localObject2, "<set-?>");
    ((com.tencent.mm.msgsubscription.c.a.b)localObject1).dWG = ((String)localObject2);
    if (((LinearLayout)localObject3).getChildCount() == 0)
    {
      parambv.PRm.setVisibility(8);
      ((LinearLayout)localObject3).setVisibility(8);
      AppMethodBeat.o(37250);
      return;
    }
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      parambv.PRm.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject3).setVisibility(0);
      AppMethodBeat.o(37250);
      return;
      parambv.PRm.setVisibility(0);
    }
  }
  
  private void a(final Map<String, String> paramMap, final ca paramca, final bv parambv, final ISubscribeMsgService.c paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(233880);
    boolean bool1;
    if (!paramc.jyX)
    {
      bool1 = true;
      boolean bool2 = paramc.jyY;
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), this.PMM, this.PMP, Boolean.valueOf(bool2) });
      localObject = parambv.PRD;
      if (!this.PMS) {
        break label212;
      }
      i = 0;
      label91:
      ((LinearLayout)localObject).setVisibility(i);
      if ((!bool1) && ((!paramBoolean) || (bool2))) {
        break label227;
      }
      a(parambv, 0);
      localObject = parambv.PRE;
      localResources = this.PhN.Pwc.getMMResources();
      if (!paramBoolean) {
        break label219;
      }
    }
    label212:
    label219:
    for (int i = 2131763738;; i = 2131763731)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      parambv.PRD.setTag(2131305314, paramca);
      if (this.PMS) {
        parambv.PRD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(169890);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ao.a(ao.this, paramca, paramMap, true, paramBoolean, paramc, parambv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169890);
          }
        });
      }
      AppMethodBeat.o(233880);
      return;
      bool1 = false;
      break;
      i = 8;
      break label91;
    }
    label227:
    a(parambv, 8);
    Object localObject = parambv.PRE;
    Resources localResources = this.PhN.Pwc.getMMResources();
    if (paramBoolean) {}
    for (i = 2131763736;; i = 2131763705)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      break;
    }
  }
  
  private void a(final Map<String, String> paramMap, final ca paramca, final String paramString, final bv parambv, final boolean paramBoolean)
  {
    AppMethodBeat.i(233878);
    e locale = new e(this.PhN.Pwc.getContext(), 1, true);
    if (paramBoolean) {
      locale.o(String.format(this.PhN.Pwc.getMMResources().getString(2131763737), new Object[] { this.PMP }), 17);
    }
    for (;;)
    {
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(233832);
          if (paramBoolean)
          {
            paramAnonymousm.a(0, ao.b(ao.this).Pwc.getMMResources().getColor(2131100996), ao.b(ao.this).Pwc.getMMResources().getString(2131763712));
            AppMethodBeat.o(233832);
            return;
          }
          paramAnonymousm.a(1, ao.b(ao.this).Pwc.getMMResources().getColor(2131100063), ao.b(ao.this).Pwc.getMMResources().getString(2131763734));
          AppMethodBeat.o(233832);
        }
      };
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(233833);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(233833);
            return;
            ao.a(ao.this, 8, paramca.field_talker, paramString);
            ao.a(ao.this, paramMap, true, this.PNc, parambv, paramString, false);
            AppMethodBeat.o(233833);
            return;
            ao.a(ao.this, 9, paramca.field_talker, paramString);
            ao.a(ao.this, paramMap, false, this.PNc, parambv, paramString, false);
          }
        }
      };
      locale.dGm();
      AppMethodBeat.o(233878);
      return;
      locale.o(String.format(this.PhN.Pwc.getMMResources().getString(2131763739), new Object[] { this.PMP }), 17);
    }
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final ca paramca, final Map<String, String> paramMap, final String paramString, final bv parambv, final boolean paramBoolean3)
  {
    AppMethodBeat.i(233881);
    e locale = new e(this.PhN.Pwc.getContext(), 1, true);
    Object localObject = this.PhN.Pwc.getContext().getResources();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = String.format(((Resources)localObject).getString(2131763733), new Object[] { this.PMP });; localObject = ((Resources)localObject).getString(2131763732))
      {
        locale.o((CharSequence)localObject, 17);
        locale.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
          {
            AppMethodBeat.i(233849);
            if (paramBoolean1)
            {
              paramAnonymousm.a(1, ao.b(ao.this).Pwc.getMMResources().getColor(2131100063), ao.b(ao.this).Pwc.getMMResources().getString(2131763734));
              AppMethodBeat.o(233849);
              return;
            }
            int j = ao.b(ao.this).Pwc.getMMResources().getColor(2131100996);
            Resources localResources = ao.b(ao.this).Pwc.getMMResources();
            if (paramBoolean2) {}
            for (int i = 2131763712;; i = 2131763713)
            {
              paramAnonymousm.a(0, j, localResources.getString(i));
              AppMethodBeat.o(233849);
              return;
            }
          }
        };
        locale.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(233850);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(233850);
              return;
              ao.a(ao.this, 8, paramca.field_talker, paramString);
              if (paramBoolean2)
              {
                ao.a(ao.this, paramMap, true, paramBoolean3, parambv, paramString, true);
                AppMethodBeat.o(233850);
                return;
              }
              ao.a(ao.this, true, parambv, paramString, paramca);
              AppMethodBeat.o(233850);
              return;
              ao.a(ao.this, 9, paramca.field_talker, paramString);
              if (paramBoolean2)
              {
                ao.a(ao.this, paramMap, false, paramBoolean3, parambv, paramString, true);
                AppMethodBeat.o(233850);
                return;
              }
              ao.a(ao.this, false, parambv, paramString, paramca);
            }
          }
        };
        locale.dGm();
        AppMethodBeat.o(233881);
        return;
      }
    }
    if (paramBoolean2) {}
    for (localObject = String.format(((Resources)localObject).getString(2131763710), new Object[] { this.PMP });; localObject = ((Resources)localObject).getString(2131763711))
    {
      locale.o((CharSequence)localObject, 17);
      break;
    }
  }
  
  private static int bni(String paramString)
  {
    AppMethodBeat.i(37248);
    String str = paramString;
    if (paramString == null) {
      str = "-1";
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      i = Util.nullAsInt(Integer.valueOf(i), -1);
      AppMethodBeat.o(37248);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChattingItemDyeingTemplate", paramString.getMessage());
        int i = -1;
      }
    }
  }
  
  private static int bnj(String paramString)
  {
    AppMethodBeat.i(37255);
    if (Util.isNullOrNil(paramString))
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
    if ((paramMap == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(37254);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(Util.nullAsNil((String)paramMap.get(paramString)));
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
  
  private static boolean ch(Map<String, String> paramMap)
  {
    AppMethodBeat.i(233876);
    boolean bool = rL(x(paramMap));
    AppMethodBeat.o(233876);
    return bool;
  }
  
  private static boolean h(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(233882);
    Object localObject2 = new StringBuilder(".msg.appmsg.mmreader.template_detail.opitems.opitem");
    Object localObject1;
    int i;
    if (paramInt == 0)
    {
      localObject1 = "";
      localObject2 = localObject1 + ".device_list.device";
      i = 0;
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder().append((String)localObject2);
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject1 = localObject1;
        if (paramMap.containsKey(localObject1)) {
          break label117;
        }
        AppMethodBeat.o(233882);
        return false;
        localObject1 = Integer.valueOf(paramInt);
        break;
      }
      label117:
      if (Util.getInt((String)paramMap.get((String)localObject1 + ".device_type"), 0) == 2)
      {
        i = Util.getInt((String)paramMap.get((String)localObject1 + ".device_op_type"), 0);
        int j = Util.getInt((String)paramMap.get((String)localObject1 + ".device_client_version"), 0);
        Log.v("MicroMsg.ChattingItemDyeingTemplate", "checkButtonShouldHide opItemIndex: %s, deviceOpType: %s, deviceClientVersion: %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
        if ((i == 1) && (com.tencent.mm.protocal.d.KyO >= j))
        {
          AppMethodBeat.o(233882);
          return true;
        }
        AppMethodBeat.o(233882);
        return false;
      }
      i += 1;
      if (i > 10)
      {
        AppMethodBeat.o(233882);
        return false;
      }
    }
  }
  
  private static void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(37252);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(37252);
      return;
    }
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    bg.aVF();
    ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.aSZ();
    ((com.tencent.mm.av.a.a.c.a)localObject).jbf = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).hZF = true;
    localObject = ((com.tencent.mm.av.a.a.c.a)localObject).bdv();
    com.tencent.mm.av.q.bcV().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
    AppMethodBeat.o(37252);
  }
  
  private static boolean rL(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int x(Map<String, String> paramMap)
  {
    AppMethodBeat.i(233877);
    int i = bni((String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
    AppMethodBeat.o(233877);
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
      localObject = new an(paramLayoutInflater, 2131493521);
      paramLayoutInflater = new bo();
      paramLayoutInflater.checkBox = ((CheckBox)((View)localObject).findViewById(2131298410));
      paramLayoutInflater.maskView = ((View)localObject).findViewById(2131298508);
      paramLayoutInflater.userTV = ((TextView)((View)localObject).findViewById(2131298566));
      paramLayoutInflater.avatarIV = ((ChattingAvatarImageView)((View)localObject).findViewById(2131298397));
      paramLayoutInflater.timeTV = ((TextView)((View)localObject).findViewById(2131298558));
      paramLayoutInflater.pxI = ((LinearLayout)((View)localObject).findViewById(2131298418));
      paramLayoutInflater.PQu.puO = ((View)localObject).findViewById(2131298469);
      paramLayoutInflater.PQu.PQx = ((View)localObject).findViewById(2131302274);
      paramLayoutInflater.PQu.hbb = ((TextView)paramLayoutInflater.PQu.puO.findViewById(2131309195));
      paramLayoutInflater.PQu.PQA = ((LinearLayout)paramLayoutInflater.PQu.puO.findViewById(2131299663));
      paramLayoutInflater.PQu.uCh = ((TextView)paramLayoutInflater.pxI.findViewById(2131299538));
      paramLayoutInflater.PQu.PQB = paramLayoutInflater.pxI.findViewById(2131307639);
      paramLayoutInflater.PQu.PQy = ((View)localObject).findViewById(2131304911);
      paramLayoutInflater.PQu.PQz = ((View)localObject).findViewById(2131304912);
      paramLayoutInflater.PQv.PQU = ((View)localObject).findViewById(2131298468);
      paramLayoutInflater.PQv.PQV = ((ImageView)((View)localObject).findViewById(2131305338));
      paramLayoutInflater.PQv.PQW = ((View)localObject).findViewById(2131305336);
      paramLayoutInflater.PQv.PQY = ((TextView)((View)localObject).findViewById(2131305354));
      paramLayoutInflater.PQv.PQX = ((ImageView)((View)localObject).findViewById(2131305311));
      paramLayoutInflater.PQv.PQZ = ((View)localObject).findViewById(2131305315);
      paramLayoutInflater.PQv.PRa = ((ImageView)((View)localObject).findViewById(2131305342));
      paramLayoutInflater.PQv.PRb = ((View)localObject).findViewById(2131305340);
      paramLayoutInflater.PQv.PRc = ((View)localObject).findViewById(2131305341);
      paramLayoutInflater.PQv.PRd = ((TextView)((View)localObject).findViewById(2131305347));
      paramLayoutInflater.PQv.PRe = ((TextView)((View)localObject).findViewById(2131305312));
      paramLayoutInflater.PQv.PRf = ((TextView)((View)localObject).findViewById(2131305335));
      paramLayoutInflater.PQv.PRg = ((View)localObject).findViewById(2131305337);
      paramLayoutInflater.PQv.PRh = ((LinearLayout)((View)localObject).findViewById(2131305348));
      paramLayoutInflater.PQv.PRi = ((TextView)((View)localObject).findViewById(2131305350));
      paramLayoutInflater.PQv.PRk = ((TextView)((View)localObject).findViewById(2131305351));
      paramLayoutInflater.PQv.PRj = ((TextView)((View)localObject).findViewById(2131305352));
      paramLayoutInflater.PQv.PRl = ((TextView)((View)localObject).findViewById(2131305353));
      paramLayoutInflater.PQv.PRm = ((View)localObject).findViewById(2131305349);
      paramLayoutInflater.PQv.PRn = ((LinearLayout)((View)localObject).findViewById(2131305339));
      paramLayoutInflater.PQv.PRr = ((View)localObject).findViewById(2131305329);
      paramLayoutInflater.PQv.PRo = ((View)localObject).findViewById(2131297669);
      paramLayoutInflater.PQv.PRp = ((LinearLayout)((View)localObject).findViewById(2131305327));
      paramLayoutInflater.PQv.PRq = ((LinearLayout)((View)localObject).findViewById(2131299811));
      paramLayoutInflater.PQv.PRs = ((LinearLayout)((View)localObject).findViewById(2131305317));
      paramLayoutInflater.PQv.PRv = ((TextView)((View)localObject).findViewById(2131305319));
      paramLayoutInflater.PQv.PRx = ((ImageView)((View)localObject).findViewById(2131305318));
      paramLayoutInflater.PQv.PRu = ((View)localObject).findViewById(2131305328);
      paramLayoutInflater.PQv.PRt = ((LinearLayout)((View)localObject).findViewById(2131305320));
      paramLayoutInflater.PQv.PRw = ((TextView)((View)localObject).findViewById(2131305322));
      paramLayoutInflater.PQv.PRy = ((ImageView)((View)localObject).findViewById(2131305321));
      paramLayoutInflater.PQv.PRz = ((ImageView)((View)localObject).findViewById(2131305310));
      paramLayoutInflater.PIb = ((ImageView)((View)localObject).findViewById(2131298467));
      paramLayoutInflater.PQv.PRA = ((View)localObject).findViewById(2131305343);
      paramLayoutInflater.PQv.PRB = ((ImageView)((View)localObject).findViewById(2131305344));
      paramLayoutInflater.PQv.PRC = ((TextView)((View)localObject).findViewById(2131305345));
      paramLayoutInflater.PQv.PRD = ((LinearLayout)((View)localObject).findViewById(2131305313));
      paramLayoutInflater.PQv.PRE = ((TextView)((View)localObject).findViewById(2131305314));
      paramLayoutInflater.PQw.PGC = ((LinearLayout)((View)localObject).findViewById(2131305332));
      paramLayoutInflater.PQw.PGD = ((CdnImageView)((View)localObject).findViewById(2131305331));
      paramLayoutInflater.PQw.PGE = ((TextView)((View)localObject).findViewById(2131305333));
      paramLayoutInflater.PQw.PGF = ((TextView)((View)localObject).findViewById(2131305330));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37242);
    this.PhN = parama1;
    PMV = parama1.getContext().getResources().getColor(2131100245);
    PMW = parama1.getContext().getResources().getColor(2131100245);
    this.PMU = ((o)parama1.bh(o.class)).gPH();
    bo localbo = (bo)parama;
    final Map localMap = XmlParser.parseXml(paramca.getContent(), "msg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localbo.pxI.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    localbo.pxI.setVisibility(0);
    int j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.PMM = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.PMQ = x(localMap);
    this.PMN = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    EventCenter.instance.removeListener(this.PvR);
    ((j)parama1.bh(j.class)).b(this.PMJ);
    Object localObject1;
    if (j != 0)
    {
      localbo.PQu.puO.setVisibility(8);
      localObject1 = localbo.PQv;
      if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bv)localObject1, Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, paramca, false);
        if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2664;
        }
        ((bv)localObject1).PQW.setBackgroundResource(2131233974);
        label349:
        if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6909;
        }
      }
    }
    label541:
    label563:
    label954:
    label1358:
    label1367:
    label1765:
    label2408:
    label2555:
    label6909:
    for (final int i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      final int k = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      ((bv)localObject1).PRd.setVisibility(8);
      if ((i == 0) && (k == 0))
      {
        ((bv)localObject1).PRd.setVisibility(0);
        this.PMP = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = c(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        ((bv)localObject1).PRd.setTextColor(com.tencent.mm.ui.ao.hT(k));
        ((bv)localObject1).PRd.setText(this.PMP);
      }
      parama = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = c(localMap, ".msg.appmsg.mmreader.template_header.first_color", PMW);
      boolean bool;
      if (Util.isNullOrNil(parama))
      {
        ((bv)localObject1).PRf.setVisibility(8);
        if ((i == 0) || (!Util.isNullOrNil(parama))) {
          break label2780;
        }
        ((bv)localObject1).PRg.setVisibility(8);
        parama = this.PMR;
        parama.username = "";
        parama.type = 0;
        parama.ixM = "";
        parama.jyz = 0;
        parama.jAu = "";
        parama.dWG = "";
        parama.jumpType = 0;
        parama.jAv = "";
        parama = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
        if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(parama)) {
          break label2979;
        }
        bool = ch(localMap);
        if ("notifymessage".equals(paramca.ajO()))
        {
          parama = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
          this.PMR.setUsername(parama);
          this.PMR.setType(2);
          ((j)this.PhN.bh(j.class)).a(this.PMJ);
          EventCenter.instance.addListener(this.PvR);
          if (!bool) {
            break label2825;
          }
          parama1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(parama);
          if (parama1 == null) {
            break label2792;
          }
          this.mAppId = parama1.field_appId;
          parama1 = ((bv)localObject1).PRD;
          if (!this.PMS) {
            break label2818;
          }
          i = 0;
          parama1.setVisibility(i);
          a((bv)localObject1, 8);
          ((bv)localObject1).PRE.setText(this.PhN.getResources().getString(2131763736));
          this.PML.fY(true);
          this.PML.fZ(true);
          parama1 = com.tencent.mm.msgsubscription.b.a.jzz;
          a.a.bH(this.PMM, ((bv)localObject1).PRD.hashCode());
          parama1 = com.tencent.mm.msgsubscription.b.a.jzz;
          a.a.a(this.PMM, ((bv)localObject1).PRD.hashCode(), new ISubscribeMsgService.b()
          {
            public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
            {
              AppMethodBeat.i(233845);
              if (paramAnonymousString.equals(ao.a(ao.this)))
              {
                Log.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", new Object[] { parama, paramAnonymousString, Boolean.valueOf(paramAnonymousc.jyX), Boolean.valueOf(paramAnonymousc.jyY) });
                ao.a(ao.this, new ISubscribeMsgService.c(paramAnonymousc.jyX, paramAnonymousc.jyY));
                ao.a(ao.this, localMap, paramca, this.PMZ, ao.f(ao.this), true);
                if ((!ao.e(ao.this)) && (ao.g(ao.this) != null) && (ao.g(ao.this).isShowing())) {
                  ao.g(ao.this).dGm();
                }
              }
              AppMethodBeat.o(233845);
            }
            
            public final void onError()
            {
              AppMethodBeat.i(233846);
              Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
              AppMethodBeat.o(233846);
            }
          });
          this.PMO.bG(parama, this.PMM);
        }
        ((bv)localObject1).PRb.setVisibility(0);
        ((bv)localObject1).PRb.setTag(2131305340, paramca);
        a((bv)localObject1);
        ((bv)localObject1).PQV.setVisibility(8);
        parama = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
        ((bv)localObject1).PRf.setText(parama);
        parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
        paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
        if (Util.isNullOrNil(parama1)) {
          break label3553;
        }
        i = com.tencent.mm.ui.ao.hT(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.PhN.getContext().getResources().getColor(2131100904)));
        j = com.tencent.mm.ui.ao.hT(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.PhN.getContext().getResources().getColor(2131100904)));
        k = com.tencent.mm.ui.ao.hT(c(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.PhN.getContext().getResources().getColor(2131100904)));
        int m = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
        ((bv)localObject1).PRi.setTextColor(i);
        ((bv)localObject1).PRk.setTextColor(j);
        ((bv)localObject1).PRl.setTextColor(k);
        ((bv)localObject1).PRl.getPaint().setFlags(16);
        ((bv)localObject1).PRi.setText(parama);
        if ((m <= 0) || (m >= parama1.length())) {
          break label3378;
        }
        ((bv)localObject1).PRj.setVisibility(0);
        ((bv)localObject1).PRj.setText(parama1.substring(0, m));
        ((bv)localObject1).PRj.setTextColor(j);
        ((bv)localObject1).PRj.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
        ((bv)localObject1).PRk.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
        ((bv)localObject1).PRk.setTextSize(1, 40.0F);
        ((bv)localObject1).PRj.setTextSize(1, 40.0F);
        ((bv)localObject1).PRk.setIncludeFontPadding(true);
        ((bv)localObject1).PRk.setText(parama1.substring(m));
        if (Util.isNullOrNil(paramString)) {
          break label3540;
        }
        ((bv)localObject1).PRl.setText(paramString);
        ((bv)localObject1).PRl.setVisibility(0);
        ((bv)localObject1).PRh.setVisibility(0);
        j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        if (j != 2) {
          break label3725;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
        ((bv)localObject1).PRn.setVisibility(8);
        parama1 = (ViewGroup)((bv)localObject1).PRn.getParent();
        parama = parama1.findViewById(2131299393);
        if (parama != null) {
          break label6906;
        }
        parama = LayoutInflater.from(parama1.getContext()).inflate(2131496095, null);
        paramString = new bn();
        paramString.kc = ((ImageView)parama.findViewById(2131297119));
        paramString.uuB = ((TextView)parama.findViewById(2131305436));
        paramString.hbb = ((TextView)parama.findViewById(2131309195));
        parama.setTag(paramString);
        parama1.addView(parama);
      }
      for (;;)
      {
        parama.setVisibility(0);
        paramString = (bn)parama.getTag();
        parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
        Object localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
        localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
        i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
        paramString.hbb.setText(l.c(paramString.hbb.getContext(), parama));
        Object localObject3 = paramString.uuB;
        Object localObject4 = paramString.hbb.getContext();
        if (Util.isNullOrNil((String)localObject2)) {
          parama = "";
        }
        for (;;)
        {
          ((TextView)localObject3).setText(l.c((Context)localObject4, parama));
          Object localObject5;
          if (i == 2)
          {
            paramString.kc.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(2131230966));
            if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
              break label3736;
            }
            ((bv)localObject1).PRA.setVisibility(8);
            ((bv)localObject1).PRp.setVisibility(8);
            ((bv)localObject1).PRr.setVisibility(8);
            ((bv)localObject1).PRq.setVisibility(0);
            ((bv)localObject1).PRo.setVisibility(0);
            a((bv)localObject1, paramca, localMap);
            paramString = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
            parama1 = null;
            if (!Util.isNullOrNil(paramString))
            {
              bg.aVF();
              parama1 = com.tencent.mm.model.c.aSN().Kn(paramString).arI();
            }
            parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
            localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
            localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
            localObject2 = (String)localMap.get(".msg.appmsg.template_id");
            localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            i = 0;
            if ((j != 3) && (j != 4)) {
              break label5294;
            }
            ((bv)localObject1).PQU.setTag(new bq(paramca, paramString));
            a(((bv)localObject1).PQU, paramca, localMap, j, 1);
            a(j, localMap, paramString);
            parama = "";
            paramInt = 3;
            ((bv)localObject1).PQU.setOnLongClickListener(c(this.PhN));
            ((bv)localObject1).PQU.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            if (com.tencent.mm.n.h.aqK().aqz())
            {
              localbo.PIb.setVisibility(0);
              c(this.PhN, localbo.PIb, new t.o((String)localObject2, paramca, parama1));
            }
            parama1 = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
            bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(parama1);
            if ((!this.PMU) || (((bv)localObject1).PRb.getTag(2131305340) == null)) {
              break label5618;
            }
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app single talker chat");
            ((bv)localObject1).PRc.setTag(2131305340, paramca);
            ((bv)localObject1).PRc.setOnClickListener(this.PMF);
            ((bv)localObject1).PRc.setVisibility(0);
            ((bv)localObject1).PRb.setVisibility(8);
            parama1 = ((bv)localObject1).PRg;
            parama1.setPadding(parama1.getPaddingLeft(), parama1.getPaddingTop(), parama1.getPaddingRight(), 0);
          }
          for (;;)
          {
            this.PMR.jumpType = paramInt;
            parama1 = this.PMR;
            p.h(parama, "<set-?>");
            parama1.jAv = parama;
            X(1, paramca.ajO(), paramString);
            localbo.PQv.PQU.setVisibility(0);
            AppMethodBeat.o(37242);
            return;
            if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
            {
              a((bv)localObject1, Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, paramca, true);
              break;
            }
            ((View)((bv)localObject1).PRa.getParent()).setVisibility(8);
            if (("notifymessage".equals(paramca.ajO())) && (!this.PMU))
            {
              parama1 = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(parama1))
              {
                paramString = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(parama1);
                if (paramString == null)
                {
                  parama = null;
                  a(((bv)localObject1).PQX, this.PhN, parama1, paramca, parama, localMap);
                  if (paramString != null) {
                    break label2504;
                  }
                  parama = parama1;
                  ((bv)localObject1).PQY.setText(l.b(this.PhN.getContext(), parama, ((bv)localObject1).PQY.getTextSize()));
                  if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(parama1)) {
                    break label2555;
                  }
                  ((bv)localObject1).PQW.setTag(new bq(paramca, parama1));
                  ((bv)localObject1).PQW.setOnClickListener(this.PHr);
                }
              }
              for (;;)
              {
                ((bv)localObject1).PQW.setVisibility(0);
                break;
                parama = paramString.field_brandIconURL;
                break label2382;
                parama = paramString.field_nickname;
                break label2408;
                a(((bv)localObject1).PQX, this.PhN, parama1, paramca, null, localMap);
                parama = ((com.tencent.mm.ui.chatting.d.b.f)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(parama1);
                break label2408;
                paramString = ((bv)localObject1).PQW;
                if (this.PhN.gRM()) {}
                for (parama = this.PhN.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bq(parama1, parama));
                  if (!Util.getBoolean((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
                    break label2631;
                  }
                  ((bv)localObject1).PQW.setOnClickListener(null);
                  break;
                }
                ((bv)localObject1).PQW.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(233829);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                    localObject = ao.this.e(ao.b(ao.this));
                    if (localObject != null) {
                      ((t.b)localObject).onClick(paramAnonymousView);
                    }
                    ao.a(ao.this, 10, ao.b(ao.this).getTalkerUserName(), parama1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233829);
                  }
                });
              }
            }
            ((bv)localObject1).PQW.setVisibility(8);
            break;
            i = ((bv)localObject1).PQW.getPaddingLeft();
            ((bv)localObject1).PQW.setBackgroundResource(2131233327);
            ((bv)localObject1).PQW.setPadding(i, 0, 0, 0);
            break label349;
            ((bv)localObject1).PRf.setTextColor(com.tencent.mm.ui.ao.hT(k));
            ((bv)localObject1).PRf.setText(parama);
            ((bv)localObject1).PRf.setVisibility(0);
            if (j == 2)
            {
              ((bv)localObject1).PRf.setPadding(0, this.PhN.getResources().getDimensionPixelOffset(2131165498), 0, 0);
              break label541;
            }
            ((bv)localObject1).PRf.setPadding(0, 0, 0, 0);
            break label541;
            ((bv)localObject1).PRg.setVisibility(0);
            break label563;
            ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(parama, new q.a()
            {
              public final void b(WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(233844);
                if (paramAnonymousWxaAttributes != null)
                {
                  Log.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ao.d(ao.this) });
                  ao.b(ao.this, paramAnonymousWxaAttributes.field_appId);
                }
                AppMethodBeat.o(233844);
              }
            });
            break label768;
            i = 8;
            break label784;
            this.PML.fZ(false);
            parama1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(parama);
            if (parama1 != null)
            {
              this.mAppId = parama1.field_appId;
              if ((parama1.field_appOpt & 0x1) > 0)
              {
                i = 1;
                parama = this.PML;
                if (i != 0) {
                  break label2916;
                }
                bool = true;
                parama.fY(bool);
              }
            }
            for (;;)
            {
              a(localMap, paramca, (bv)localObject1, this.PML, false);
              break;
              i = 0;
              break label2873;
              bool = false;
              break label2886;
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama });
              this.PML.fY(true);
              ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(parama, new q.a()
              {
                public final void b(WxaAttributes paramAnonymousWxaAttributes)
                {
                  boolean bool = true;
                  AppMethodBeat.i(233848);
                  if (paramAnonymousWxaAttributes == null)
                  {
                    AppMethodBeat.o(233848);
                    return;
                  }
                  ao.b(ao.this, paramAnonymousWxaAttributes.field_appId);
                  int i;
                  if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0)
                  {
                    i = 1;
                    paramAnonymousWxaAttributes = ao.f(ao.this);
                    if (i != 0) {
                      break label79;
                    }
                  }
                  for (;;)
                  {
                    paramAnonymousWxaAttributes.jyX = bool;
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(233847);
                        ao.a(ao.this, ao.18.this.grN, ao.18.this.iBF, ao.18.this.PMZ, ao.f(ao.this), false);
                        AppMethodBeat.o(233847);
                      }
                    });
                    AppMethodBeat.o(233848);
                    return;
                    i = 0;
                    break;
                    label79:
                    bool = false;
                  }
                }
              });
            }
            if (com.tencent.mm.al.g.Nb(parama))
            {
              j = 1;
              if (!"notifymessage".equals(paramca.ajO())) {
                j = 0;
              }
              for (i = 1;; i = 0)
              {
                if ((j == 0) || (i == 0))
                {
                  ((bv)localObject1).PRD.setVisibility(8);
                  a((bv)localObject1, 8);
                }
                if ((j == 0) || (i == 0)) {
                  break;
                }
                ((bv)localObject1).PRb.setVisibility(0);
                ((bv)localObject1).PRb.setTag(2131305340, paramca);
                a((bv)localObject1);
                break;
                if (rL(this.PMQ)) {
                  break label3094;
                }
              }
              parama = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
              this.PMR.setUsername(Util.nullAs(parama, ""));
              this.PMR.setType(1);
              parama1 = this.PMR;
              paramString = Util.nullAs(this.PMM, "");
              p.h(paramString, "<set-?>");
              parama1.ixM = paramString;
              this.PMR.jyz = this.PMQ;
              parama1 = this.PMR;
              paramString = Util.nullAs(this.PMP, "");
              p.h(paramString, "<set-?>");
              parama1.jAu = paramString;
              parama1 = ((bv)localObject1).PRD;
              if (this.PMS) {}
              for (i = 0;; i = 8)
              {
                parama1.setVisibility(i);
                a((bv)localObject1, 8);
                ((bv)localObject1).PRE.setText(this.PhN.getResources().getString(2131763736));
                parama1 = com.tencent.mm.msgsubscription.b.a.jzz;
                a.a.bH(this.PMM, ((bv)localObject1).PRD.hashCode());
                parama1 = com.tencent.mm.msgsubscription.b.a.jzz;
                a.a.a(this.PMM, ((bv)localObject1).PRD.hashCode(), new ISubscribeMsgService.b()
                {
                  public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
                  {
                    AppMethodBeat.i(233830);
                    if (paramAnonymousString.equals(ao.a(ao.this)))
                    {
                      Log.d("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onUpdated templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousc.jyX), Boolean.valueOf(paramAnonymousc.jyY) });
                      ao.a(ao.this, new ISubscribeMsgService.c(paramAnonymousc.jyX, paramAnonymousc.jyY));
                      ao.a(ao.this, localMap, paramca, this.PMZ, paramAnonymousc);
                      if ((!ao.e(ao.this)) && (ao.g(ao.this) != null) && (ao.g(ao.this).isShowing())) {
                        ao.g(ao.this).dGm();
                      }
                    }
                    AppMethodBeat.o(233830);
                  }
                  
                  public final void onError()
                  {
                    AppMethodBeat.i(37208);
                    Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
                    AppMethodBeat.o(37208);
                  }
                });
                this.jzW.bG(parama, this.PMM);
                i = 1;
                break;
              }
            }
            ((bv)localObject1).PRD.setVisibility(8);
            a((bv)localObject1, 8);
            break label954;
            ((bv)localObject1).PRj.setTypeface(Typeface.DEFAULT);
            ((bv)localObject1).PRj.setVisibility(8);
            if ((parama1.contains("￥")) || (parama1.contains("¥")) || (parama1.contains("$")) || (parama1.contains("＄")))
            {
              ((bv)localObject1).PRk.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
              ((bv)localObject1).PRk.setTextSize(1, 40.0F);
              ((bv)localObject1).PRk.setIncludeFontPadding(true);
            }
            for (;;)
            {
              ((bv)localObject1).PRk.setText(parama1);
              break;
              ((bv)localObject1).PRk.setTypeface(Typeface.DEFAULT);
              com.tencent.mm.ui.ao.a(((bv)localObject1).PRk.getPaint(), 0.8F);
              ((bv)localObject1).PRk.setTextSize(1, 32.0F);
              ((bv)localObject1).PRk.setIncludeFontPadding(false);
            }
            ((bv)localObject1).PRl.setVisibility(8);
            break label1358;
            ((bv)localObject1).PRh.setVisibility(8);
            break label1367;
            parama = null;
            if (ab.Eq((String)localObject2))
            {
              bg.aVF();
              localObject5 = com.tencent.mm.model.c.aSN().Kn((String)localObject2);
              if (localObject5 != null)
              {
                if (!Util.isNullOrNil(((as)localObject5).ajy())) {
                  break label3665;
                }
                parama = ((as)localObject5).getNickname();
              }
            }
            for (;;)
            {
              if (!Util.isNullOrNil(parama)) {
                break label6903;
              }
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
              parama = parama1;
              if (!Util.isNullOrNil(parama1)) {
                break;
              }
              parama = MMApplicationContext.getContext().getString(2131757507);
              break;
              parama = ((as)localObject5).ajy();
              continue;
              bg.aVF();
              parama = com.tencent.mm.model.c.aSN().Kn((String)localObject2);
              if (parama.arJ() == null) {
                parama = parama.arI();
              } else {
                parama = parama.arJ();
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramString.kc, (String)localObject2);
            break label1687;
            a((bv)localObject1, localMap);
            break label1687;
            ((bv)localObject1).PRq.setVisibility(8);
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
            bool = h(localMap, 0);
            if ((!Util.isNullOrNil(parama1)) && (!bool))
            {
              i = com.tencent.mm.ui.ao.hT(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.PhN.getContext().getResources().getColor(2131100904)));
              ((bv)localObject1).PRv.setTextColor(i);
              ((bv)localObject1).PRv.setText(parama1);
              if (Util.isNullOrNil(parama))
              {
                ((bv)localObject1).PRx.setVisibility(8);
                ((bv)localObject1).PRv.setPadding(0, 0, 0, 0);
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                parama1 = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                localObject3 = new bq(paramca, parama1, (String)localObject2);
                ((bv)localObject1).PRs.setTag(localObject3);
                ((bv)localObject1).PRA.setTag(localObject3);
                if ((i != 3) && (i != 4)) {
                  break label4613;
                }
                a(((bv)localObject1).PRs, paramca, localMap, i, 2);
                ((bv)localObject1).PRs.setVisibility(0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                bool = h(localMap, 1);
                if ((Util.isNullOrNil(paramString)) || (bool)) {
                  break label4962;
                }
                i = com.tencent.mm.ui.ao.hT(c(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.PhN.getContext().getResources().getColor(2131100904)));
                ((bv)localObject1).PRw.setTextColor(i);
                ((bv)localObject1).PRw.setText(paramString);
                if (!Util.isNullOrNil(parama1)) {
                  break label4779;
                }
                ((bv)localObject1).PRy.setVisibility(8);
                ((bv)localObject1).PRw.setPadding(0, 0, 0, 0);
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                paramString = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                ((bv)localObject1).PRt.setTag(new bq(paramca, paramString, (String)localObject3));
                if ((i != 3) && (i != 4)) {
                  break label4823;
                }
                a(((bv)localObject1).PRt, paramca, localMap, i, 2);
                ((bv)localObject1).PRt.setVisibility(0);
                ((bv)localObject1).PRz.setVisibility(8);
                if ((((bv)localObject1).PRs.getVisibility() != 8) || (((bv)localObject1).PRt.getVisibility() != 8)) {
                  break label4975;
                }
                ((bv)localObject1).PRp.setVisibility(8);
                ((bv)localObject1).PRo.setVisibility(8);
                ((bv)localObject1).PRr.setVisibility(8);
                if ((((bv)localObject1).PRs.getVisibility() != 0) || (((bv)localObject1).PRt.getVisibility() != 0)) {
                  break label5250;
                }
                ((bv)localObject1).PRu.setVisibility(0);
                parama = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if ((as.HF(parama)) || (((bv)localObject1).PRs.getVisibility() == 8) || (((bv)localObject1).PRt.getVisibility() != 8) || (i != 1) || (!as.HF(paramString))) {
                  break label5281;
                }
                localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString);
                if (localObject2 != null) {
                  break label5263;
                }
                parama = null;
                if (localObject2 != null) {
                  break label5272;
                }
              }
            }
            for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
            {
              com.tencent.mm.av.q.bcV().a(parama, ((bv)localObject1).PRB, this.Oxy);
              ((bv)localObject1).PRC.setText(parama1);
              if (localObject2 == null) {
                ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(paramString, new q.a()
                {
                  public final void b(WxaAttributes paramAnonymousWxaAttributes)
                  {
                    AppMethodBeat.i(233859);
                    if (paramAnonymousWxaAttributes == null)
                    {
                      AppMethodBeat.o(233859);
                      return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(233858);
                        com.tencent.mm.av.q.bcV().a(this.raI, ao.28.this.PMZ.PRB, ao.o(ao.this));
                        if (TextUtils.isEmpty(this.kqs)) {}
                        for (String str = ao.28.this.PNo;; str = this.kqs)
                        {
                          ao.28.this.PMZ.PRC.setText(str);
                          AppMethodBeat.o(233858);
                          return;
                        }
                      }
                    });
                    AppMethodBeat.o(233859);
                  }
                });
              }
              ((bv)localObject1).PRA.setVisibility(0);
              ((bv)localObject1).PRp.setVisibility(8);
              break;
              ((bv)localObject1).PRx.setVisibility(0);
              o(((bv)localObject1).PRx, parama);
              ((bv)localObject1).PRv.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.PhN.getContext(), 16), 0);
              break label3871;
              if ((i == 1) && (!TextUtils.isEmpty(paramString)))
              {
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                k = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                parama1 = new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(169893);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                    paramAnonymousView = (bq)paramAnonymousView.getTag();
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                    localObject = new AppBrandStatObject();
                    ((AppBrandStatObject)localObject).dCw = (paramAnonymousView.dTX.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + this.PJL);
                    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(paramAnonymousView.userName))
                    {
                      ((AppBrandStatObject)localObject).scene = ao.aeQ(this.PJL);
                      ((r)com.tencent.mm.kernel.g.af(r.class)).a(ao.b(ao.this).Pwc.getContext(), paramString, null, k, i, this.PNr, (AppBrandStatObject)localObject);
                      ao.nj(ao.d(ao.this), ao.a(ao.this));
                      com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), parama1, Integer.valueOf(1) });
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(169893);
                      return;
                    }
                    ((AppBrandStatObject)localObject).scene = 1043;
                    paramAnonymousView = com.tencent.mm.al.g.fJ(paramAnonymousView.userName);
                    r localr = (r)com.tencent.mm.kernel.g.af(r.class);
                    Activity localActivity = ao.b(ao.this).Pwc.getContext();
                    String str1 = paramString;
                    int i = k;
                    int j = i;
                    String str2 = this.PNr;
                    if (paramAnonymousView == null) {}
                    for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                    {
                      localr.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                      break;
                    }
                  }
                };
                ((bv)localObject1).PRs.setOnClickListener(parama1);
                ((bv)localObject1).PRA.setOnClickListener(parama1);
                break label3999;
              }
              ((bv)localObject1).PRs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(233855);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if (!Util.isNullOrNil(this.val$url))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("rawUrl", this.val$url);
                    paramAnonymousView.putExtra("geta8key_username", parama1);
                    c.r(paramAnonymousView, ao.b(ao.this).getTalkerUserName());
                    com.tencent.mm.br.c.b(ao.b(ao.this).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), parama1, Integer.valueOf(1) });
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(233855);
                }
              });
              ((bv)localObject1).PRA.setOnClickListener(null);
              break label3999;
              ((bv)localObject1).PRs.setVisibility(8);
              break label4008;
              ((bv)localObject1).PRy.setVisibility(0);
              o(((bv)localObject1).PRy, parama1);
              ((bv)localObject1).PRw.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.PhN.getContext(), 16), 0);
              break label4136;
              if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                k = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                localObject4 = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                ((bv)localObject1).PRt.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(233856);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                    paramAnonymousView = (bq)paramAnonymousView.getTag();
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.PNo });
                    localObject = new AppBrandStatObject();
                    ((AppBrandStatObject)localObject).dCw = (paramAnonymousView.dTX.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ao.b(ao.this).getTalkerUserName() + ":" + this.PJL);
                    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(paramAnonymousView.userName))
                    {
                      ((AppBrandStatObject)localObject).scene = ao.aeQ(this.PJL);
                      ((r)com.tencent.mm.kernel.g.af(r.class)).a(ao.b(ao.this).Pwc.getContext(), this.PNo, null, k, i, this.PNr, (AppBrandStatObject)localObject);
                      ao.nj(ao.d(ao.this), ao.a(ao.this));
                      com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), paramString, Integer.valueOf(2) });
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(233856);
                      return;
                    }
                    ((AppBrandStatObject)localObject).scene = 1043;
                    paramAnonymousView = com.tencent.mm.al.g.fJ(paramAnonymousView.userName);
                    r localr = (r)com.tencent.mm.kernel.g.af(r.class);
                    Activity localActivity = ao.b(ao.this).Pwc.getContext();
                    String str1 = this.PNo;
                    int i = k;
                    int j = i;
                    String str2 = this.PNr;
                    if (paramAnonymousView == null) {}
                    for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                    {
                      localr.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                      break;
                    }
                  }
                });
                break label4252;
              }
              ((bv)localObject1).PRt.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(233857);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  if (!Util.isNullOrNil(this.val$url))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("rawUrl", this.val$url);
                    c.r(paramAnonymousView, ao.b(ao.this).getTalkerUserName());
                    com.tencent.mm.br.c.b(ao.b(ao.this).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11608, new Object[] { ao.a(ao.this), paramString, Integer.valueOf(2) });
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(233857);
                }
              });
              break label4252;
              ((bv)localObject1).PRt.setVisibility(8);
              break label4261;
              ((bv)localObject1).PRr.setVisibility(0);
              i = this.PhN.getResources().getDimensionPixelOffset(2131165498);
              if ((((bv)localObject1).PRs.getVisibility() == 0) && (((bv)localObject1).PRt.getVisibility() == 0))
              {
                ((bv)localObject1).PRs.setGravity(17);
                ((bv)localObject1).PRt.setGravity(17);
                ((bv)localObject1).PRs.setPadding(i, 0, i, 0);
                ((bv)localObject1).PRt.setPadding(i, 0, i, 0);
              }
              for (;;)
              {
                ((bv)localObject1).PRp.setVisibility(0);
                ((bv)localObject1).PRo.setVisibility(0);
                break;
                if (((bv)localObject1).PRs.getVisibility() == 0)
                {
                  if (Util.isNullOrNil(parama))
                  {
                    ((bv)localObject1).PRs.setGravity(19);
                    ((bv)localObject1).PRs.setPadding(i, 0, 0, 0);
                    ((bv)localObject1).PRz.setVisibility(0);
                  }
                  else
                  {
                    ((bv)localObject1).PRs.setGravity(17);
                    ((bv)localObject1).PRs.setPadding(i, 0, i, 0);
                  }
                }
                else if (Util.isNullOrNil(parama1))
                {
                  ((bv)localObject1).PRt.setGravity(19);
                  ((bv)localObject1).PRt.setPadding(this.PhN.getResources().getDimensionPixelOffset(2131165498), 0, 0, 0);
                  ((bv)localObject1).PRz.setVisibility(0);
                }
                else
                {
                  ((bv)localObject1).PRt.setGravity(17);
                  ((bv)localObject1).PRt.setPadding(i, 0, i, 0);
                }
              }
              ((bv)localObject1).PRu.setVisibility(8);
              break label4358;
              parama = ((WxaAttributes)localObject2).field_brandIconURL;
              break label4481;
            }
            ((bv)localObject1).PRA.setVisibility(8);
            break label1765;
            if ((j == 1) && (!TextUtils.isEmpty((CharSequence)localObject4)))
            {
              parama = new bq(paramca, paramString, (String)localObject5);
              parama.position = paramInt;
              ((bv)localObject1).PQU.setTag(parama);
              ((bv)localObject1).PQU.setOnClickListener(this.rID);
              parama = Util.nullAs((String)localObject4, "");
              paramInt = 2;
              break label1949;
            }
            if ((j == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(paramString)))
            {
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
              localObject5 = ((bv)localObject1).PQU;
              parama = new bq(paramca, false, paramInt, paramString, false, this.PhN.gOZ(), paramString, parama1, parama).bno((String)localObject3);
              parama.pageUrl = ((String)localObject4);
              ((View)localObject5).setTag(parama);
              ((bv)localObject1).PQU.setOnClickListener(this.PMH);
              parama = Util.nullAs(paramString, "");
              paramInt = 2;
              break label1949;
            }
            if (j == 2)
            {
              parama = new bq(paramca, paramString, (String)localObject5);
              parama.position = paramInt;
              ((bv)localObject1).PQU.setTag(parama);
              ((bv)localObject1).PQU.setOnClickListener(this.rID);
              parama = "";
              paramInt = i;
              break label1949;
            }
            ((bv)localObject1).PQU.setTag(new bq(paramca, false, paramInt, (String)localObject5, false, this.PhN.gOZ(), paramString, parama1, parama).bno((String)localObject3));
            ((bv)localObject1).PQU.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(233828);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                localObject = ao.this.h(ao.b(ao.this));
                if (localObject != null) {
                  ((t.p)localObject).onClick(paramAnonymousView);
                }
                ao.a(ao.this, 2, paramca.field_talker, paramString);
                ao.a(ao.this, 8, paramString, 2, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233828);
              }
            });
            if (!Util.isNullOrNil((String)localObject5))
            {
              parama = Util.nullAs((String)localObject5, "");
              paramInt = 1;
              break label1949;
            }
            parama = "";
            paramInt = 0;
            break label1949;
            if ((bool) && ("notifymessage".equals(paramca.ajO())))
            {
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
              ((bv)localObject1).PRc.setTag(null);
              ((bv)localObject1).PRc.setVisibility(8);
            }
            else if ((ab.Jx(paramca.ajO())) && (com.tencent.mm.al.g.Nb(parama1)) && (ch(localMap)))
            {
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by biz subscribe msg");
              ((bv)localObject1).PRc.setTag(null);
              ((bv)localObject1).PRc.setVisibility(8);
            }
            else
            {
              if (Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
              {
                i = 1;
                if (i != 0) {
                  break label5810;
                }
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              }
              do
              {
                ((bv)localObject1).PRb.setTag(null);
                ((bv)localObject1).PRc.setTag(null);
                ((bv)localObject1).PRb.setVisibility(8);
                ((bv)localObject1).PRc.setVisibility(8);
                break;
                i = 0;
                break label5749;
                if (((bv)localObject1).PQW.getVisibility() == 0)
                {
                  ((bv)localObject1).PRb.setTag(paramca);
                  ((bv)localObject1).PRb.setOnClickListener(this.PMG);
                  ((bv)localObject1).PRb.setVisibility(0);
                  ((bv)localObject1).PRc.setVisibility(8);
                  break;
                }
              } while (((bv)localObject1).PRg.getVisibility() != 0);
              ((bv)localObject1).PRc.setTag(paramca);
              ((bv)localObject1).PRc.setOnClickListener(this.PMG);
              ((bv)localObject1).PRc.setVisibility(0);
              ((bv)localObject1).PRb.setVisibility(8);
            }
          }
          localbo.PQv.PQU.setVisibility(8);
          parama1 = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
          i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
          if (i == 1)
          {
            parama = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            paramString = Util.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
            a(localbo, l.b(this.PhN.getContext(), paramString, localbo.userTV.getTextSize()));
            localbo.avatarIV.setTag(null);
            localbo.avatarIV.setOnClickListener(null);
            com.tencent.mm.av.q.bcV().a(parama, localbo.avatarIV, this.Oxy);
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { paramca.ajO() });
            if ((!"notifymessage".equals(paramca.ajO())) && (i != 1)) {
              break label6675;
            }
            localbo.PQu.PQx.setVisibility(0);
            localbo.PQu.hbb.setTextSize(0, com.tencent.mm.cb.a.aG(localbo.PQu.hbb.getContext(), 2131165535));
            localbo.PQu.puO.setVisibility(0);
            paramString = b.ci(localMap);
            localbo.PQu.hbb.setText(paramString.title);
            ap.a(localbo.PQu.PQA, localMap);
            parama = null;
            if (!Util.isNullOrNil(parama1))
            {
              bg.aVF();
              parama = com.tencent.mm.model.c.aSN().Kn(parama1).arI();
            }
            if (Util.isNullOrNil(paramString.url)) {
              break label6721;
            }
            i = 1;
            j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
            localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              break label6727;
            }
            parama1 = new bq(paramca, parama1, paramString.url);
            parama1.position = paramInt;
            localbo.PQu.puO.setTag(parama1);
            localbo.PQu.puO.setOnClickListener(this.rID);
            i = 1;
            localbo.PQu.puO.setOnLongClickListener(c(this.PhN));
            localbo.PQu.puO.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            if (i != 0) {
              break label6876;
            }
            localbo.PQu.PQB.setVisibility(8);
            localbo.PQu.uCh.setVisibility(8);
          }
          for (;;)
          {
            if (com.tencent.mm.n.h.aqK().aqz())
            {
              localbo.PIb.setVisibility(0);
              c(this.PhN, localbo.PIb, new t.o(paramString.ixM, paramca, parama));
            }
            a(localbo.PQu, localMap, paramca);
            localbo.PQu.puO.setVisibility(0);
            AppMethodBeat.o(37242);
            return;
            a(localbo, this.PhN, paramca, parama1);
            a(localbo.avatarIV, this.PhN, parama1, paramca, null, localMap);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(parama1))
            {
              localbo.PQu.PQx.setTag(new bq(paramca, parama1));
              localbo.PQu.PQx.setOnClickListener(this.PHr);
              break;
            }
            paramString = localbo.PQu.PQx;
            if (this.PhN.gRM()) {}
            for (parama = this.PhN.getTalkerUserName();; parama = null)
            {
              paramString.setTag(new bq(parama1, parama));
              localbo.PQu.PQx.setOnClickListener(e(this.PhN));
              break;
            }
            localbo.PQu.PQx.setVisibility(8);
            localbo.PQu.hbb.setTextSize(0, com.tencent.mm.cb.a.aG(localbo.PQu.hbb.getContext(), 2131165186));
            break label6173;
            i = 0;
            break label6262;
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(paramString.url)) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramString.url, -1, 2, new Object[0]);
            }
            localbo.PQu.puO.setTag(new bq(paramca, false, paramInt, paramString.url, false, this.PhN.gOZ(), parama1, parama, paramString.title).bno(paramString.egX));
            if (this.PMU)
            {
              localbo.PQu.puO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(233827);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                  localObject = ao.this.h(ao.b(ao.this));
                  if (localObject != null) {
                    ((t.p)localObject).onClick(paramAnonymousView);
                  }
                  ao.a(ao.this, 8, parama1, 2, 0);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(233827);
                }
              });
              break label6361;
            }
            localbo.PQu.puO.setOnClickListener(h(this.PhN));
            break label6361;
            localbo.PQu.PQB.setVisibility(0);
            localbo.PQu.uCh.setVisibility(0);
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(paramString);
    a(parama, l.b(parama1.Pwc.getContext(), paramca, parama.userTV.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
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
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233871);
    paramca = (bq)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(233871);
      return false;
    }
    int i = paramca.position;
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
    }
    AppMethodBeat.o(233871);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
  
  protected final boolean gTX()
  {
    return this.PMN == 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(37238);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (!(paramView.getTag() instanceof ca))
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      localObject = (ca)paramView.getTag();
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = XmlParser.parseXml(((eo)localObject).field_content, "msg", null);
      if ((localMap == null) || (localMap.size() == 0))
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
      e locale = new e(paramView.getContext(), 1, false);
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(37233);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str)) {}
          for (String str = paramView.getResources().getString(2131763721);; str = paramView.getResources().getString(2131763719))
          {
            paramAnonymousm.add(0, 2, 0, str);
            AppMethodBeat.o(37233);
            return;
          }
        }
      };
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(37237);
          Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()), Integer.valueOf(paramAnonymousInt) });
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37237);
            return;
            ao.a(ao.this, paramView, this.iBF, localMap, str);
          }
        }
      };
      locale.dGm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
    }
  }
  
  public static final class b
  {
    public String egX;
    public String iAm;
    public String iAn;
    public String iAo;
    public String iAp;
    public String iAq;
    public String ixM;
    public long time;
    public String title;
    public int type;
    public String url;
    
    public static b ci(Map<String, String> paramMap)
    {
      AppMethodBeat.i(37239);
      b localb = new b();
      localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
      localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
      localb.egX = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
      localb.iAm = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
      localb.iAn = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
      localb.time = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
      localb.iAo = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
      localb.iAp = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
      localb.iAq = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
      localb.type = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
      localb.ixM = ((String)paramMap.get(".msg.appmsg.template_id"));
      AppMethodBeat.o(37239);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */