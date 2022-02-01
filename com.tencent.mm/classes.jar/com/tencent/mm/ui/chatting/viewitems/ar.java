package com.tencent.mm.ui.chatting.viewitems;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aad;
import com.tencent.mm.f.a.aad.a;
import com.tencent.mm.f.a.pm;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
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
import com.tencent.mm.plugin.finder.live.report.s.bn;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.fpz;
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
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.b;
import com.tencent.mm.ui.chatting.t.o;
import com.tencent.mm.ui.chatting.t.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout.ViewWrapperForAnim;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout.a;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.widget.a.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

public final class ar
  extends c
{
  private static final String XcI;
  private static int XiO;
  private static int XiP;
  private static final String Xiw;
  private static final String Xix;
  private com.tencent.mm.ui.base.s LRv;
  private com.tencent.mm.ay.a.a.c VQC;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private IListener<pm> WQk;
  private View.OnClickListener XcK;
  private View.OnClickListener XiA;
  private View.OnClickListener XiB;
  private n XiC;
  private View.OnClickListener XiD;
  private ISubscribeMsgService.c XiE;
  private String XiF;
  private int XiG;
  private com.tencent.mm.msgsubscription.b.a XiH;
  private String XiI;
  private int XiJ;
  private com.tencent.mm.msgsubscription.c.a.b XiK;
  private boolean XiL;
  private e XiM;
  private boolean XiN;
  private View.OnClickListener Xiy;
  private View.OnClickListener Xiz;
  private com.tencent.mm.ui.base.s jhZ;
  private String mAppId;
  private com.tencent.mm.msgsubscription.b.a mpC;
  private View.OnClickListener vol;
  
  static
  {
    AppMethodBeat.i(37267);
    XcI = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    Xiw = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    Xix = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect";
    XiO = MMApplicationContext.getContext().getResources().getColor(R.e.desc_text_color);
    XiP = MMApplicationContext.getContext().getResources().getColor(R.e.desc_text_color);
    AppMethodBeat.o(37267);
  }
  
  public ar()
  {
    AppMethodBeat.i(37240);
    this.XiE = new ISubscribeMsgService.c(true, false);
    this.XiI = "";
    this.XiJ = -1;
    this.XiK = new com.tencent.mm.msgsubscription.c.a.b();
    this.XiL = false;
    this.XiM = null;
    this.XiN = false;
    Object localObject = new com.tencent.mm.ay.a.a.c.a();
    ((com.tencent.mm.ay.a.a.c.a)localObject).kPz = true;
    ((com.tencent.mm.ay.a.a.c.a)localObject).lRP = R.g.brand_default_head;
    this.VQC = ((com.tencent.mm.ay.a.a.c.a)localObject).bmL();
    localObject = com.tencent.mm.msgsubscription.api.b.moG;
    this.mpC = com.tencent.mm.msgsubscription.api.b.YR("name_biz");
    localObject = com.tencent.mm.msgsubscription.api.b.moG;
    this.XiH = com.tencent.mm.msgsubscription.api.b.YR("name_wxa");
    this.Xiz = new a((byte)0);
    this.XiD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = (by)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = XmlParser.parseXml(paramAnonymousView.fNz.field_content, "msg", null);
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), localObject1, Integer.valueOf(66666) });
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (Util.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.q((Intent)localObject1, ar.b(ar.this).getTalkerUserName());
            com.tencent.mm.by.c.b(ar.b(ar.this).WQv.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
          localAppBrandStatObject.fvd = (paramAnonymousView.fNz.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + (String)localObject2);
          localAppBrandStatObject.scene = ar.amL((String)localObject2);
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ar.b(ar.this).WQv.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        }
      }
    };
    this.XcK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = (by)paramAnonymousView.getTag();
        Object localObject2 = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).fNz.field_content, "msg", null);
        if ((localObject2 != null) && (((Map)localObject2).size() != 0))
        {
          Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
          if (!ar.a(ar.this, (Map)localObject2)) {}
        }
        for (boolean bool = Util.getBoolean((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false);; bool = false)
        {
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click, blockProfile: %b", new Object[] { ((by)localObject1).userName, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject2 = ar.this;
            paramAnonymousView.getContext();
            ar.a((ar)localObject2, ((by)localObject1).userName);
            ar.a(ar.this, 10, ar.b(ar.this).getTalkerUserName(), ((by)localObject1).userName);
          }
          ar.a(ar.this, 4, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).fNz);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37215);
          return;
        }
      }
    };
    this.WQk = new IListener() {};
    this.XiC = new n()
    {
      public final void hGU() {}
      
      public final void hGV() {}
      
      public final void hGW() {}
      
      public final void hGX() {}
      
      public final void hGY() {}
      
      public final void hGZ()
      {
        AppMethodBeat.i(278303);
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        EventCenter.instance.removeListener(ar.c(ar.this));
        if (ar.b(ar.this) != null) {
          ((j)ar.b(ar.this).bC(j.class)).b(this);
        }
        AppMethodBeat.o(278303);
      }
      
      public final void hHa() {}
    };
    this.XiA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(286682);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        by localby = (by)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localby.userName });
        xw localxw = new xw();
        localxw.fWN.userName = localby.userName;
        localxw.fWN.fWP = localby.pageUrl;
        Map localMap = XmlParser.parseXml(localby.fNz.field_content, "msg", null);
        localObject = "";
        paramAnonymousView = (View)localObject;
        if (localMap != null)
        {
          paramAnonymousView = (View)localObject;
          if (localMap.size() > 0)
          {
            localxw.fWN.fWQ = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localxw.fWN.fWU = true;
        localxw.fWN.scene = ar.amL(paramAnonymousView);
        localxw.fWN.fvd = (localby.fNz.field_msgSvrId + ":" + localby.userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + paramAnonymousView);
        EventCenter.instance.publish(localxw);
        ar.od(ar.d(ar.this), ar.a(ar.this));
        com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), localby.userName, Integer.valueOf(0) });
        ar.a(ar.this, 2, ar.b(ar.this).getTalkerUserName(), localby.userName);
        ar.a(ar.this, 8, localby.userName, 1, 0);
        ar.a(ar.this, 4, localMap, "");
        ar.a(ar.this, 6, localby.fNz);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286682);
      }
    };
    this.vol = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = (by)paramAnonymousView.getTag();
        Map localMap = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject).fNz.field_content, "msg", null);
        if (localMap == null)
        {
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
        }
        int i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String str1;
        String str2;
        int j;
        int k;
        AppBrandStatObject localAppBrandStatObject;
        if (i == 1)
        {
          str1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
          str2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_path");
          j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          k = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.fvd = (((by)localObject).fNz.field_msgSvrId + ":" + ((by)localObject).userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(((by)localObject).userName))
          {
            localAppBrandStatObject.scene = ar.amL(paramAnonymousView);
            ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ar.b(ar.this).WQv.getContext(), str1, null, k, j, str2, localAppBrandStatObject);
            ar.od(ar.d(ar.this), ar.a(ar.this));
            com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), ((by)localObject).userName, Integer.valueOf(0) });
            ar.a(ar.this, 2, ar.b(ar.this).getTalkerUserName(), ((by)localObject).userName);
            label428:
            paramAnonymousView = ar.this;
            str1 = ((by)localObject).userName;
            if (i != 1) {
              break label660;
            }
          }
        }
        label660:
        for (i = 1;; i = 2)
        {
          ar.a(paramAnonymousView, 8, str1, i, 0);
          ar.a(ar.this, 4, localMap, "");
          ar.a(ar.this, 6, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).fNz);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
          localAppBrandStatObject.scene = 1043;
          paramAnonymousView = com.tencent.mm.ao.g.gu(((by)localObject).userName);
          r localr = (r)com.tencent.mm.kernel.h.ae(r.class);
          Activity localActivity = ar.b(ar.this).WQv.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localr.a(localActivity, str1, null, k, j, str2, localAppBrandStatObject, paramAnonymousView);
            break;
          }
          if (i != 2) {
            break label428;
          }
          str1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
          long l = Util.getLong((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
          ar.h(paramAnonymousView.getContext(), str1, l);
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str1, Long.valueOf(l) });
          break label428;
        }
      }
    };
    this.XiB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = (by)paramAnonymousView.getTag();
        int i = ((by)localObject1).opType;
        Object localObject2 = ((by)localObject1).XmQ;
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "jumpNativePage opType: %d, opInfo: %s", new Object[] { Integer.valueOf(((by)localObject1).opType), ((by)localObject1).XmQ });
        int j;
        if (i == 3)
        {
          paramAnonymousView = ar.b(ar.this).WQv.getContext();
          Log.i("SnsAdUtil", "type = 0content = " + (String)localObject2);
          Object localObject4 = com.tencent.mm.plugin.sns.data.m.aYU((String)localObject2);
          localObject2 = ((u)localObject4).pageId;
          Object localObject3 = ((u)localObject4).uxInfo;
          localObject4 = ((u)localObject4).owf;
          if (paramAnonymousView != null)
          {
            if (!Util.isNullOrNil(new String[] { localObject2, localObject3, localObject4 })) {}
          }
          else {
            Log.e("SnsAdUtil", "context or pageId or uxInfo or adInfoXml is null");
          }
          for (;;)
          {
            paramAnonymousView = ((by)localObject1).IGp;
            if (paramAnonymousView != null)
            {
              j = paramAnonymousView.getInt("click_area_type");
              if (j != 1) {
                break label693;
              }
              localObject2 = ar.this;
              if (((by)localObject1).fNz == null) {
                break;
              }
              paramAnonymousView = ((by)localObject1).fNz.field_talker;
              label239:
              ar.a((ar)localObject2, 2, paramAnonymousView, ((by)localObject1).userName);
              if (!Util.isNullOrNil(((by)localObject1).XmR)) {
                ar.k(4, ((by)localObject1).XmR, ((by)localObject1).finderUsername, ((by)localObject1).XmS, "");
              }
            }
            label283:
            paramAnonymousView = ar.this;
            localObject2 = ((by)localObject1).userName;
            if (i != 1) {
              break label806;
            }
            i = 1;
            label302:
            ar.a(paramAnonymousView, 8, (String)localObject2, i, 0);
            ar.a(ar.this, 7, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).fNz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37232);
            return;
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("sns_landing_pages_pageid", Util.safeParseLong((String)localObject2));
            ((Intent)localObject3).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            ((Intent)localObject3).putExtra("sns_landig_pages_from_source", 21);
            ((Intent)localObject3).putExtra("sns_landing_pages_ad_info", (String)localObject4);
            com.tencent.mm.by.c.b(paramAnonymousView, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject3);
          }
        }
        if (i == 4) {}
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramAnonymousView = new com.tencent.mm.ad.i(((by)localObject1).XmQ);
              long l1 = com.tencent.mm.ae.d.Nb(paramAnonymousView.optString("feed_id"));
              long l2 = com.tencent.mm.ae.d.Nb(paramAnonymousView.optString("live_id"));
              localObject2 = paramAnonymousView.optString("nonce_id");
              paramAnonymousView = paramAnonymousView.optString("force_push_info");
              if (TextUtils.isEmpty(paramAnonymousView)) {
                break label811;
              }
              paramAnonymousView = new com.tencent.mm.ad.i(paramAnonymousView).optString("forcePushId");
              ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveVisitorUI(null, ar.b(ar.this).WQv.getContext(), l1, Long.valueOf(l2), "", (String)localObject2, "", "", "", "", 0, "", 1, true);
              ar.a(l1, l2, ((by)localObject1).userName, ((by)localObject1).position, paramAnonymousView);
            }
            catch (Throwable paramAnonymousView)
            {
              Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", paramAnonymousView, "OP_ITEM_TYPE_FINDER_LIVE exception", new Object[0]);
            }
            break;
            if (i != 5) {
              break;
            }
            try
            {
              paramAnonymousView = new com.tencent.mm.ad.i(((by)localObject1).XmQ).optString("ticket_s");
              if (Util.isNullOrNil(paramAnonymousView)) {
                break;
              }
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("KEY_TICKET", paramAnonymousView);
              ((Intent)localObject2).putExtra("KEY_FROM_SCAN", true);
              ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderGameLiveAuthUI(ar.b(ar.this).WQv.getContext(), (Intent)localObject2);
            }
            catch (Throwable paramAnonymousView)
            {
              Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", paramAnonymousView, "OP_ITEM_TYPE_FINDER_GAME_LIVE exception", new Object[0]);
            }
          }
          break;
          paramAnonymousView = "";
          break label239;
          label693:
          if (j != 2) {
            break label283;
          }
          localObject2 = ar.this;
          if (((by)localObject1).fNz != null) {}
          for (paramAnonymousView = ((by)localObject1).fNz.field_talker;; paramAnonymousView = "")
          {
            ar.a((ar)localObject2, 3, paramAnonymousView, ((by)localObject1).userName);
            if (!Util.isNullOrNil(((by)localObject1).XmR)) {
              ar.k(5, ((by)localObject1).XmR, ((by)localObject1).finderUsername, null, String.valueOf(((by)localObject1).XmT));
            }
            if ((((by)localObject1).fNz == null) || (((by)localObject1).XmU != 1)) {
              break;
            }
            ar.q(((by)localObject1).fNz, ((by)localObject1).XmT);
            break;
          }
          label806:
          i = 2;
          break label302;
          label811:
          paramAnonymousView = "";
        }
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private void X(final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(268891);
    String str1;
    if (paramBoolean)
    {
      str1 = this.WBq.WQv.getContext().getString(R.l.eNQ);
      if (!paramBoolean) {
        break label140;
      }
    }
    label140:
    for (String str2 = this.WBq.WQv.getContext().getString(R.l.eNP);; str2 = this.WBq.WQv.getContext().getString(R.l.eOz))
    {
      com.tencent.mm.ui.base.h.a(this.WBq.WQv.getContext(), str2, str1, this.WBq.WQv.getContext().getString(R.l.eOC), this.WBq.WQv.getContext().getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(229191);
          paramAnonymousDialogInterface = new Intent(ar.b(ar.this).WQv.getContext(), BizSubscribeMsgManagerUI.class);
          paramAnonymousDialogInterface.putExtra("key_biz_username", paramString);
          paramAnonymousDialogInterface.putExtra("key_biz_nickname", aa.PJ(paramString));
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
            com.tencent.mm.by.c.a((MMFragmentActivity)ar.b(ar.this).WQv.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramAnonymousDialogInterface, paramAnonymousInt, new MMFragmentActivity.b()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(290594);
                Object localObject;
                if ((paramAnonymous2Int1 == 100) && (paramAnonymous2Intent != null))
                {
                  paramAnonymous2Intent = (SubscribeMsgSettingData)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                  if (paramAnonymous2Intent != null)
                  {
                    ar.k(ar.this);
                    localObject = com.tencent.mm.msgsubscription.util.d.mtA;
                    com.tencent.mm.msgsubscription.util.d.a(ar.19.this.iXG, paramAnonymous2Intent, new kotlin.g.a.b() {});
                  }
                  AppMethodBeat.o(290594);
                  return;
                }
                if ((paramAnonymous2Int1 == 101) && (paramAnonymous2Intent != null))
                {
                  boolean bool = paramAnonymous2Intent.getBooleanExtra("key_need_update", false);
                  Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", new Object[] { Boolean.valueOf(bool) });
                  if (!bool)
                  {
                    AppMethodBeat.o(290594);
                    return;
                  }
                  paramAnonymous2Intent = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)paramAnonymous2Intent.getParcelableExtra("key_biz_data");
                  localObject = com.tencent.mm.msgsubscription.api.b.moG;
                  localObject = com.tencent.mm.msgsubscription.api.b.YR("name_biz");
                  if ((paramAnonymous2Intent != null) && (localObject != null))
                  {
                    ar.k(ar.this);
                    com.tencent.mm.msgsubscription.api.c localc = new com.tencent.mm.msgsubscription.api.c();
                    localc.setUsername(Util.nullAs(ar.19.this.iXG, ""));
                    localc.moB.addAll(paramAnonymous2Intent.moB);
                    localc.moH = paramAnonymous2Intent.moC;
                    localc.moK = new com.tencent.mm.msgsubscription.api.a()
                    {
                      public final void a(String paramAnonymous3String, SubscribeMsgRequestResult paramAnonymous3SubscribeMsgRequestResult)
                      {
                        AppMethodBeat.i(223635);
                        Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                        ar.l(ar.this);
                        if (ar.b(ar.this) != null) {
                          ar.b(ar.this).cAe();
                        }
                        AppMethodBeat.o(223635);
                      }
                      
                      public final void i(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(223639);
                        Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String });
                        ar.l(ar.this);
                        w.makeText(ar.b(ar.this).WQv.getContext(), ar.b(ar.this).WQv.getContext().getString(R.l.eOB), 1).show();
                        AppMethodBeat.o(223639);
                      }
                    };
                    ((ISubscribeMsgService)localObject).a(localc);
                  }
                }
                AppMethodBeat.o(290594);
              }
            });
            AppMethodBeat.o(229191);
            return;
            paramAnonymousDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.ao.b.a.class.getName());
            paramAnonymousDialogInterface.putExtra("key_need_update", false);
            paramAnonymousDialogInterface.putExtra("key_need_load_from_remote", true);
            paramAnonymousDialogInterface.putExtra("key_enter_scene", 2);
            break;
          }
        }
      }, null).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(268891);
      return;
      str1 = this.WBq.WQv.getContext().getString(R.l.eOA);
      break;
    }
  }
  
  private static void a(int paramInt, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(268907);
    a(paramInt, paramMap, paramString, "");
    AppMethodBeat.o(268907);
  }
  
  private static void a(int paramInt, Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(268908);
    String str1 = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.transaction_id"), "");
    String str2 = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"), "");
    paramMap = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"), "");
    if (!Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      if (!Util.isNullOrNil(str1)) {
        j(paramInt, str1, str2, paramString2, paramString1);
      }
      AppMethodBeat.o(268908);
      return;
      paramString2 = paramMap;
    }
  }
  
  private void a(View paramView, com.tencent.mm.storage.ca paramca, Map<String, String> paramMap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268882);
    if (paramca == null)
    {
      AppMethodBeat.o(268882);
      return;
    }
    if (!"notifymessage".equals(paramca.field_talker))
    {
      AppMethodBeat.o(268882);
      return;
    }
    paramca = (by)paramView.getTag();
    Object localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string"));
    paramca.opType = paramInt1;
    paramca.XmQ = ((String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("click_area_type", paramInt2);
    paramca.IGp = ((Bundle)localObject);
    localObject = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.transaction_id"), "");
    if (!Util.isNullOrNil((String)localObject))
    {
      String str = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"), "");
      paramMap = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"), "");
      paramca.XmR = ((String)localObject);
      paramca.finderUsername = str;
      paramca.XmS = paramMap;
    }
    paramView.setTag(paramca);
    paramView.setOnClickListener(this.XiB);
    AppMethodBeat.o(268882);
  }
  
  private void a(ImageView paramImageView, final com.tencent.mm.ui.chatting.e.a parama, final String paramString1, final com.tencent.mm.storage.ca paramca, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(268878);
    if (paramImageView == null)
    {
      AppMethodBeat.o(268878);
      return;
    }
    if (ab.QX(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(268878);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(paramString1))
    {
      com.tencent.mm.ay.q.bml().a(paramString2, paramImageView, this.VQC);
      paramImageView.setTag(new by(paramca, paramString1));
      paramImageView.setOnClickListener(this.XcK);
    }
    for (;;)
    {
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(aa.PJ(paramString1) + parama.WQv.getContext().getString(R.l.avatar_desc));
      AppMethodBeat.o(268878);
      return;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
      if (parama.hRi()) {}
      for (paramString2 = parama.getTalkerUserName();; paramString2 = null)
      {
        paramImageView.setTag(new by(paramString1, paramString2));
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
          AppMethodBeat.i(291034);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = ar.this.e(parama);
          if (localObject != null) {
            ((t.b)localObject).onClick(paramAnonymousView);
          }
          ar.a(ar.this, 10, parama.getTalkerUserName(), paramString1);
          ar.a(ar.this, 4, paramca);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(291034);
        }
      });
    }
  }
  
  private void a(bv parambv, Map<String, String> paramMap)
  {
    AppMethodBeat.i(268884);
    String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
    a(parambv, l.b(this.WBq.WQv.getContext(), paramMap, parambv.userTV.getTextSize()));
    parambv.avatarIV.setTag(null);
    parambv.avatarIV.setOnClickListener(null);
    com.tencent.mm.ay.q.bml().a(str, parambv.avatarIV, this.VQC);
    AppMethodBeat.o(268884);
  }
  
  private void a(bv parambv, Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca, int paramInt)
  {
    AppMethodBeat.i(268879);
    Object localObject1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
    Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
    label152:
    Object localObject2;
    String str;
    label240:
    Object localObject3;
    if (i == 1)
    {
      a(parambv, paramMap);
      Log.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { paramca.field_talker });
      if ((!"notifymessage".equals(paramca.field_talker)) && (i != 1)) {
        break label655;
      }
      parambv.XmA.XmD.setVisibility(0);
      parambv.XmA.jMg.setTextSize(0, com.tencent.mm.ci.a.aY(parambv.XmA.jMg.getContext(), R.f.NormalTextSize));
      parambv.XmA.sEi.setVisibility(0);
      localObject2 = b.co(paramMap);
      parambv.XmA.jMg.setText(((b)localObject2).title);
      as.a(parambv.XmA.XmG, paramMap);
      str = null;
      if (!Util.isNullOrNil((String)localObject1))
      {
        bh.beI();
        str = com.tencent.mm.model.c.bbL().RG((String)localObject1).ayr();
      }
      if (Util.isNullOrNil(((b)localObject2).url)) {
        break label698;
      }
      i = 1;
      int j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
      localObject3 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
      if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject3))) {
        break label704;
      }
      localObject1 = new by(paramca, (String)localObject1, ((b)localObject2).url);
      ((by)localObject1).position = paramInt;
      parambv.XmA.sEi.setTag(localObject1);
      parambv.XmA.sEi.setOnClickListener(this.vol);
      i = 1;
      label339:
      if (!((com.tencent.mm.ui.chatting.d.b.o)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.o.class)).VI(paramca.field_msgId)) {
        parambv.XmA.sEi.setOnLongClickListener(c(this.WBq));
      }
      parambv.XmA.sEi.setOnTouchListener(((k)this.WBq.bC(k.class)).hNO());
      if (i != 0) {
        break label836;
      }
      parambv.XmA.XmH.setVisibility(8);
      parambv.XmA.zau.setVisibility(8);
    }
    for (;;)
    {
      if (com.tencent.mm.n.h.axd().awS())
      {
        parambv.Xdw.setVisibility(0);
        c(this.WBq, parambv.Xdw, new t.o(((b)localObject2).lnb, paramca, str));
      }
      a(parambv.XmA, paramMap, paramca);
      AppMethodBeat.o(268879);
      return;
      a(parambv, this.WBq, paramca, (String)localObject1);
      a(parambv.avatarIV, this.WBq, (String)localObject1, paramca, null, paramMap);
      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS((String)localObject1))
      {
        parambv.XmA.XmD.setTag(new by(paramca, (String)localObject1));
        parambv.XmA.XmD.setOnClickListener(this.XcK);
        break;
      }
      localObject2 = parambv.XmA.XmD;
      if (this.WBq.hRi()) {}
      for (str = this.WBq.getTalkerUserName();; str = null)
      {
        ((View)localObject2).setTag(new by((String)localObject1, str));
        parambv.XmA.XmD.setOnClickListener(e(this.WBq));
        break;
      }
      label655:
      parambv.XmA.XmD.setVisibility(8);
      parambv.XmA.jMg.setTextSize(0, com.tencent.mm.ci.a.aY(parambv.XmA.jMg.getContext(), R.f.ActionBarTextSize));
      break label152;
      label698:
      i = 0;
      break label240;
      label704:
      if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(((b)localObject2).url)) {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(((b)localObject2).url, -1, 2, new Object[0]);
      }
      localObject3 = parambv.XmA.sEi;
      by localby = new by(paramca, false, paramInt, ((b)localObject2).url, false, this.WBq.hOp(), (String)localObject1, str, ((b)localObject2).title);
      localby.gbn = ((b)localObject2).gbn;
      ((View)localObject3).setTag(localby);
      parambv.XmA.sEi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37213);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = ar.this.h(ar.b(ar.this));
          if (localObject != null) {
            ((t.p)localObject).onClick(paramAnonymousView);
          }
          if (ar.h(ar.this)) {
            ar.a(ar.this, 8, this.Qry, 2, 0);
          }
          ar.a(ar.this, 6, paramca);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37213);
        }
      });
      break label339;
      label836:
      parambv.XmA.XmH.setVisibility(0);
      parambv.XmA.zau.setVisibility(0);
    }
  }
  
  private void a(bv parambv, final Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268880);
    cd localcd = parambv.XmB;
    a(localcd, paramMap, paramca);
    a(localcd, paramMap, paramInt2);
    d(localcd, paramMap, paramca);
    a(localcd, paramMap);
    b(localcd, paramMap);
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
    final String str2;
    String str1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    String str3;
    String str4;
    Object localObject1;
    if (i == 2)
    {
      c(localcd, paramMap);
      a(localcd, paramca, paramMap);
      str2 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
      str1 = null;
      if (!Util.isNullOrNil(str2))
      {
        bh.beI();
        str1 = com.tencent.mm.model.c.bbL().RG(str2).ayr();
      }
      localObject3 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.title");
      localObject4 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.url");
      localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url");
      str3 = (String)paramMap.get(".msg.appmsg.template_id");
      str4 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
      paramInt2 = 0;
      localObject1 = "";
      if ((i != 3) && (i != 4) && (i != 5)) {
        break label460;
      }
      localObject1 = new by(paramca, str2);
      ((by)localObject1).position = paramInt1;
      localcd.Xnd.setTag(localObject1);
      a(localcd.Xnd, paramca, paramMap, i, 1);
      b(i, paramMap, str2);
      paramInt1 = 3;
      localObject1 = "";
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.d.b.o)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.o.class)).VI(paramca.field_msgId)) {
        localcd.Xnd.setOnLongClickListener(c(this.WBq));
      }
      localcd.Xnd.setOnTouchListener(((k)this.WBq.bC(k.class)).hNO());
      if (com.tencent.mm.n.h.axd().awS())
      {
        parambv.Xdw.setVisibility(0);
        c(this.WBq, parambv.Xdw, new t.o(str3, paramca, str1));
      }
      a(1, paramMap, "");
      b(localcd, paramMap, paramca);
      this.XiK.jumpType = paramInt1;
      this.XiK.YX((String)localObject1);
      ab(1, paramca.field_talker, str2);
      AppMethodBeat.o(268880);
      return;
      d(localcd, paramMap);
      break;
      label460:
      if ((i == 1) && (!TextUtils.isEmpty(str4)))
      {
        localObject1 = new by(paramca, str2, (String)localObject4);
        ((by)localObject1).position = paramInt1;
        localcd.Xnd.setTag(localObject1);
        localcd.Xnd.setOnClickListener(this.vol);
        paramInt1 = 2;
        localObject1 = Util.nullAs(str4, "");
      }
      else if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str2)))
      {
        localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
        localObject4 = localcd.Xnd;
        localObject3 = new by(paramca, false, paramInt1, str2, false, this.WBq.hOp(), str2, str1, (String)localObject3);
        ((by)localObject3).gbn = ((String)localObject2);
        ((by)localObject3).pageUrl = ((String)localObject1);
        ((View)localObject4).setTag(localObject3);
        localcd.Xnd.setOnClickListener(this.XiA);
        paramInt1 = 2;
        localObject1 = Util.nullAs(str2, "");
      }
      else if (i == 2)
      {
        localObject2 = new by(paramca, str2, (String)localObject4);
        ((by)localObject2).position = paramInt1;
        localcd.Xnd.setTag(localObject2);
        localcd.Xnd.setOnClickListener(this.vol);
        paramInt1 = paramInt2;
      }
      else
      {
        localObject1 = localcd.Xnd;
        localObject3 = new by(paramca, false, paramInt1, (String)localObject4, false, this.WBq.hOp(), str2, str1, (String)localObject3);
        ((by)localObject3).gbn = ((String)localObject2);
        ((View)localObject1).setTag(localObject3);
        localcd.Xnd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(169886);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            localObject = ar.this.h(ar.b(ar.this));
            if (localObject != null) {
              ((t.p)localObject).onClick(paramAnonymousView);
            }
            ar.a(ar.this, 2, paramca.field_talker, str2);
            ar.a(ar.this, 8, str2, 2, 0);
            ar.a(ar.this, 4, paramMap, "");
            ar.a(ar.this, 6, paramca);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(169886);
          }
        });
        if (!Util.isNullOrNil((String)localObject4))
        {
          paramInt1 = 1;
          localObject1 = Util.nullAs((String)localObject4, "");
        }
        else
        {
          paramInt1 = 0;
          localObject1 = "";
        }
      }
    }
  }
  
  private void a(bx parambx, Map<String, String> paramMap, com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268886);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
      parambx.XmE.setTag(null);
      parambx.XmF.setTag(null);
      parambx.XmE.setVisibility(8);
      parambx.XmF.setVisibility(8);
      AppMethodBeat.o(268886);
      return;
    }
    if (parambx.XmD.getVisibility() == 0)
    {
      parambx.XmE.setTag(paramca);
      parambx.XmE.setOnClickListener(this.Xiz);
      parambx.XmE.setVisibility(0);
      parambx.XmF.setVisibility(8);
      AppMethodBeat.o(268886);
      return;
    }
    parambx.XmF.setTag(paramca);
    parambx.XmF.setOnClickListener(this.Xiz);
    parambx.XmF.setVisibility(0);
    parambx.XmE.setVisibility(8);
    AppMethodBeat.o(268886);
  }
  
  private void a(final cd paramcd)
  {
    AppMethodBeat.i(268867);
    this.Xiy = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(276311);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = (com.tencent.mm.storage.ca)paramAnonymousView.getTag(R.h.dOp);
        if (localObject == null)
        {
          Log.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276311);
          return;
        }
        final Map localMap = XmlParser.parseXml(((et)localObject).field_content, "msg", null);
        if ((localMap == null) || (localMap.size() == 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276311);
          return;
        }
        final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
        final boolean bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str);
        ar.a(ar.this, new e(paramAnonymousView.getContext(), 1, false));
        ar.g(ar.this).ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(289464);
            paramAnonymous2o.clear();
            if (!ar.e(ar.this)) {
              ar.a(ar.this, this.lrk, localMap, paramAnonymous2o, ar.f(ar.this));
            }
            if (bool) {}
            for (String str = paramAnonymousView.getResources().getString(R.l.eOe);; str = paramAnonymousView.getResources().getString(R.l.eOc))
            {
              paramAnonymous2o.add(0, 2, 0, str);
              AppMethodBeat.o(289464);
              return;
            }
          }
        };
        ar.g(ar.this).ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(274027);
            int i = paramAnonymous2MenuItem.getItemId();
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected. msgId: %s, v: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymous2Int), Long.valueOf(this.lrk.field_msgId), paramAnonymousView });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              if (ar.h(ar.this))
              {
                if (i != 2) {
                  break label327;
                }
                paramAnonymous2Int = 1;
              }
              break;
            }
            for (;;)
            {
              ar.a(ar.this, 9, str, 0, paramAnonymous2Int);
              AppMethodBeat.o(274027);
              return;
              ar.a(ar.this, paramAnonymousView, this.lrk, localMap, str);
              break;
              boolean bool = ar.a(ar.this, localMap);
              ar.a(ar.this, this.lrk, localMap, bool, bool, ar.f(ar.this), ar.45.this.Xja);
              break;
              if (!ar.a(ar.this, localMap)) {
                break;
              }
              if (!ar.f(ar.this).moE)
              {
                ar.b(ar.this, str);
                break;
              }
              bool = ar.f(ar.this).mnH;
              ar.a(ar.this, bool, str, localMap, ar.f(ar.this));
              break;
              label327:
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
        ar.g(ar.this).eik();
        ar.a(ar.this, 4, ((et)localObject).field_talker, str);
        ar.a(ar.this, 5, (com.tencent.mm.storage.ca)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276311);
      }
    };
    paramcd.Xnl.setOnClickListener(this.Xiy);
    AppMethodBeat.o(268867);
  }
  
  private void a(cd paramcd, int paramInt)
  {
    AppMethodBeat.i(268911);
    if (this.XiN)
    {
      paramcd.Xno.setVisibility(paramInt);
      AppMethodBeat.o(268911);
      return;
    }
    paramcd.Xnj.setVisibility(paramInt);
    AppMethodBeat.o(268911);
  }
  
  private void a(final cd paramcd, final com.tencent.mm.storage.ca paramca, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0)
    {
      paramcd.XnK.setVisibility(8);
      paramcd.Xnz.setVisibility(8);
      paramcd.XnB.setVisibility(8);
      paramcd.XnA.setVisibility(0);
      paramcd.Xny.setVisibility(0);
      b(paramcd, paramca, paramMap);
      AppMethodBeat.o(37251);
      return;
    }
    paramcd.XnA.setVisibility(8);
    Object localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
    final String str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
    boolean bool = h(paramMap, 0);
    final int i;
    final String str3;
    final String str2;
    Object localObject2;
    if ((!Util.isNullOrNil((String)localObject1)) && (!bool))
    {
      i = com.tencent.mm.ui.ar.iV(c(paramMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
      paramcd.XnF.setTextColor(i);
      paramcd.XnF.setText((CharSequence)localObject1);
      if (Util.isNullOrNil(str1))
      {
        paramcd.XnH.setVisibility(8);
        paramcd.XnF.setPadding(0, 0, 0, 0);
        str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
        localObject1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
        str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
        localObject2 = new by(paramca, (String)localObject1, str3);
        paramcd.XnC.setTag(localObject2);
        paramcd.XnK.setTag(localObject2);
        if ((i != 3) && (i != 4) && (i != 5)) {
          break label934;
        }
        a(paramcd.XnC, paramca, paramMap, i, 2);
        label342:
        paramcd.XnC.setVisibility(0);
        label350:
        str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
        localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
        bool = h(paramMap, 1);
        if ((Util.isNullOrNil(str2)) || (bool)) {
          break label1272;
        }
        i = com.tencent.mm.ui.ar.iV(c(paramMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
        paramcd.XnG.setTextColor(i);
        paramcd.XnG.setText(str2);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1096;
        }
        paramcd.XnI.setVisibility(8);
        paramcd.XnG.setPadding(0, 0, 0, 0);
        label475:
        localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
        str2 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
        str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
        paramcd.XnD.setTag(new by(paramca, str2, (String)localObject2));
        if ((i != 3) && (i != 4) && (i != 5)) {
          break label1141;
        }
        a(paramcd.XnD, paramca, paramMap, i, 2);
        label588:
        paramcd.XnD.setVisibility(0);
        label596:
        paramcd.XnJ.setVisibility(8);
        if ((paramcd.XnC.getVisibility() != 8) || (paramcd.XnD.getVisibility() != 8)) {
          break label1284;
        }
        paramcd.Xnz.setVisibility(8);
        paramcd.Xny.setVisibility(8);
        paramcd.XnB.setVisibility(8);
        if ((paramcd.XnC.getVisibility() != 0) || (paramcd.XnD.getVisibility() != 0)) {
          break label1547;
        }
        paramcd.XnE.setVisibility(0);
        label684:
        paramca = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
        str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
        if ((com.tencent.mm.storage.as.OS(paramca)) || (paramcd.XnC.getVisibility() == 8) || (paramcd.XnD.getVisibility() != 8) || (i != 1) || (!com.tencent.mm.storage.as.OS(str1))) {
          break label1577;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(str1);
        if (localObject1 != null) {
          break label1559;
        }
        paramca = null;
        label802:
        if (localObject1 != null) {
          break label1568;
        }
      }
    }
    label1284:
    label1547:
    label1559:
    label1568:
    for (paramMap = str1;; paramMap = ((WxaAttributes)localObject1).field_nickname)
    {
      com.tencent.mm.ay.q.bml().a(paramca, paramcd.XnL, this.VQC);
      paramcd.XnM.setText(paramMap);
      if (localObject1 == null) {
        ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a(str1, new q.a()
        {
          public final void b(WxaAttributes paramAnonymousWxaAttributes)
          {
            AppMethodBeat.i(267098);
            if (paramAnonymousWxaAttributes == null)
            {
              AppMethodBeat.o(267098);
              return;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(290401);
                com.tencent.mm.ay.q.bml().a(this.uDI, ar.37.this.Xja.XnL, ar.o(ar.this));
                if (TextUtils.isEmpty(this.nif)) {}
                for (String str = ar.37.this.Xjp;; str = this.nif)
                {
                  ar.37.this.Xja.XnM.setText(str);
                  AppMethodBeat.o(290401);
                  return;
                }
              }
            });
            AppMethodBeat.o(267098);
          }
        });
      }
      paramcd.XnK.setVisibility(0);
      paramcd.Xnz.setVisibility(8);
      AppMethodBeat.o(37251);
      return;
      paramcd.XnH.setVisibility(0);
      o(paramcd.XnH, str1);
      paramcd.XnF.setPadding(0, 0, com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 16), 0);
      break;
      label934:
      final int j;
      if ((i == 1) && (!TextUtils.isEmpty(str2)))
      {
        str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
        j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
        localObject1 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(274354);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            localObject = (by)paramAnonymousView.getTag();
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.fvd = (((by)localObject).fNz.field_msgSvrId + ":" + ((by)localObject).userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + this.Xfh);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(((by)localObject).userName))
            {
              localAppBrandStatObject.scene = ar.amL(this.Xfh);
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ar.b(ar.this).WQv.getContext(), str2, null, j, i, str3, localAppBrandStatObject);
              ar.od(ar.d(ar.this), ar.a(ar.this));
              com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), this.Qry, Integer.valueOf(1) });
              ar.a(ar.this, 7, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).fNz);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(274354);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.ao.g.gu(((by)localObject).userName);
            r localr = (r)com.tencent.mm.kernel.h.ae(r.class);
            Activity localActivity = ar.b(ar.this).WQv.getContext();
            String str1 = str2;
            int i = j;
            int j = i;
            String str2 = str3;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localr.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        };
        paramcd.XnC.setOnClickListener((View.OnClickListener)localObject1);
        paramcd.XnK.setOnClickListener((View.OnClickListener)localObject1);
        break label342;
      }
      paramcd.XnC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279832);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (!Util.isNullOrNil(str3))
          {
            paramAnonymousView = (by)paramAnonymousView.getTag();
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", str3);
            ((Intent)localObject).putExtra("geta8key_username", this.Qry);
            c.q((Intent)localObject, ar.b(ar.this).getTalkerUserName());
            com.tencent.mm.by.c.b(ar.b(ar.this).WQv.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), this.Qry, Integer.valueOf(1) });
            ar.a(ar.this, 7, paramAnonymousView.fNz);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279832);
        }
      });
      paramcd.XnK.setOnClickListener(null);
      break label342;
      paramcd.XnC.setVisibility(8);
      break label350;
      label1096:
      paramcd.XnI.setVisibility(0);
      o(paramcd.XnI, (String)localObject1);
      paramcd.XnG.setPadding(0, 0, com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 16), 0);
      break label475;
      label1141:
      if ((i == 1) && (!TextUtils.isEmpty(str3)))
      {
        paramca = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
        j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
        localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
        paramcd.XnD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(286513);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            localObject = (by)paramAnonymousView.getTag();
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str3 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.fvd = (((by)localObject).fNz.field_msgSvrId + ":" + ((by)localObject).userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + this.Xfh);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(((by)localObject).userName))
            {
              localAppBrandStatObject.scene = ar.amL(this.Xfh);
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ar.b(ar.this).WQv.getContext(), str3, null, j, i, paramca, localAppBrandStatObject);
              ar.od(ar.d(ar.this), ar.a(ar.this));
              com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), str2, Integer.valueOf(2) });
              ar.a(ar.this, 7, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).fNz);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(286513);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.ao.g.gu(((by)localObject).userName);
            r localr = (r)com.tencent.mm.kernel.h.ae(r.class);
            Activity localActivity = ar.b(ar.this).WQv.getContext();
            String str1 = str3;
            int i = j;
            int j = i;
            String str2 = paramca;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localr.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        });
        break label588;
      }
      paramcd.XnD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268968);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (!Util.isNullOrNil(this.val$url))
          {
            paramAnonymousView = (by)paramAnonymousView.getTag();
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.val$url);
            c.q((Intent)localObject, ar.b(ar.this).getTalkerUserName());
            com.tencent.mm.by.c.b(ar.b(ar.this).WQv.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), str2, Integer.valueOf(2) });
            ar.a(ar.this, 7, paramAnonymousView.fNz);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268968);
        }
      });
      break label588;
      label1272:
      paramcd.XnD.setVisibility(8);
      break label596;
      paramcd.XnB.setVisibility(0);
      i = this.WBq.WQv.getMMResources().getDimensionPixelOffset(R.f.LargePadding);
      if ((paramcd.XnC.getVisibility() == 0) && (paramcd.XnD.getVisibility() == 0))
      {
        paramcd.XnC.setGravity(17);
        paramcd.XnD.setGravity(17);
        paramcd.XnC.setPadding(i, 0, i, 0);
        paramcd.XnD.setPadding(i, 0, i, 0);
      }
      for (;;)
      {
        paramcd.Xnz.setVisibility(0);
        paramcd.Xny.setVisibility(0);
        break;
        if (paramcd.XnC.getVisibility() == 0)
        {
          if (Util.isNullOrNil(str1))
          {
            paramcd.XnC.setGravity(19);
            paramcd.XnC.setPadding(i, 0, 0, 0);
            paramcd.XnJ.setVisibility(0);
          }
          else
          {
            paramcd.XnC.setGravity(17);
            paramcd.XnC.setPadding(i, 0, i, 0);
          }
        }
        else if (Util.isNullOrNil((String)localObject1))
        {
          paramcd.XnD.setGravity(19);
          paramcd.XnD.setPadding(this.WBq.WQv.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0, 0);
          paramcd.XnJ.setVisibility(0);
        }
        else
        {
          paramcd.XnD.setGravity(17);
          paramcd.XnD.setPadding(i, 0, i, 0);
        }
      }
      paramcd.XnE.setVisibility(8);
      break label684;
      paramca = ((WxaAttributes)localObject1).field_brandIconURL;
      break label802;
    }
    label1577:
    paramcd.XnK.setVisibility(8);
    AppMethodBeat.o(37251);
  }
  
  private void a(cd paramcd, final String paramString1, String paramString2, final Map<String, String> paramMap, com.tencent.mm.storage.ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    paramcd.Xni.setText(l.b(this.WBq.WQv.getContext(), paramString2, paramcd.Xni.getTextSize()));
    com.tencent.mm.ay.q.bml().a(paramString1, paramcd.Xnh, this.VQC);
    paramcd.Xnh.setTag(null);
    paramcd.Xnh.setOnClickListener(null);
    paramcd.Xng.setTag(null);
    paramcd.Xng.setOnClickListener(null);
    paramcd.Xng.setVisibility(0);
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_type"), -1);
    if (i == -1)
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
      paramString2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
      if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        paramcd.Xng.setTag(new by(paramca, paramString1));
        paramcd.Xng.setOnClickListener(this.XiD);
      }
    }
    for (;;)
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (Util.isNullOrNil(paramString1))) {
        break;
      }
      ((View)paramcd.Xnk.getParent()).setVisibility(0);
      com.tencent.mm.ay.q.bml().a(paramString1, paramcd.Xnk, this.VQC);
      AppMethodBeat.o(37247);
      return;
      if ((i == 1) || (i == 2))
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        paramcd.Xng.setTag(new by(paramca, paramString1));
        paramcd.Xng.setOnClickListener(this.XiD);
      }
      else if (i == 3)
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"));
        paramcd.Xng.setTag(new by(paramca, paramString1));
        paramcd.Xng.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(282224);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().aM(ar.b(ar.this).WQv.getContext(), paramString1);
            ar.a(ar.this, 2, paramMap, "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(282224);
          }
        });
      }
      else
      {
        paramcd.Xng.setTag(null);
        paramcd.Xng.setOnClickListener(null);
      }
    }
    ((View)paramcd.Xnk.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(cd paramcd, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37250);
    int i;
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_finder_feed_entry"), 0) == 1)
    {
      i = 1;
      if (i == 0) {
        break label235;
      }
      String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feed_thumnail"));
      i = com.tencent.mm.ui.ar.au(this.WBq.WQv.getContext()).x - com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 64);
      int j = (int)(i / 1.7525F);
      ViewGroup.LayoutParams localLayoutParams = paramcd.Xne.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = i;
        localLayoutParams.height = j;
        paramcd.Xne.setLayoutParams(localLayoutParams);
      }
      o(paramcd.Xne, str);
      paramcd.Xne.setVisibility(0);
      paramcd.Xne.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(271178);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"));
          localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_nonceid"));
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().F(ar.b(ar.this).WQv.getContext(), paramAnonymousView, (String)localObject);
          ar.a(ar.this, 3, paramMap, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271178);
        }
      });
      if (com.tencent.mm.compatible.util.d.qV(23)) {
        paramcd.Xne.setForeground(this.WBq.WQv.getContext().getDrawable(R.g.dnr));
      }
      paramcd.Xnf.setVisibility(0);
    }
    for (;;)
    {
      paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      paramcd.Xnp.setText(paramMap);
      AppMethodBeat.o(37250);
      return;
      i = 0;
      break;
      label235:
      paramcd.Xne.setImageBitmap(null);
      paramcd.Xnf.setVisibility(8);
    }
  }
  
  private void a(cd paramcd, Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(268896);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {}
    for (int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      int j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      paramcd.Xnn.setVisibility(8);
      if ((i == 0) && (j == 0))
      {
        paramcd.Xnn.setVisibility(0);
        this.XiI = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.title"));
        j = c(paramMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        paramcd.Xnn.setTextColor(com.tencent.mm.ui.ar.iV(j));
        paramcd.Xnn.setText(this.XiI);
      }
      String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      j = c(paramMap, ".msg.appmsg.mmreader.template_header.first_color", XiP);
      if (Util.isNullOrNil(str)) {
        paramcd.Xnp.setVisibility(8);
      }
      while ((i != 0) && (Util.isNullOrNil(str)))
      {
        paramcd.Xnq.setVisibility(8);
        AppMethodBeat.o(268896);
        return;
        paramcd.Xnp.setTextColor(com.tencent.mm.ui.ar.iV(j));
        paramcd.Xnp.setText(str);
        paramcd.Xnp.setVisibility(0);
        if (paramInt == 2) {
          paramcd.Xnp.setPadding(0, this.WBq.WQv.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0);
        } else {
          paramcd.Xnp.setPadding(0, 0, 0, 0);
        }
      }
      paramcd.Xnq.setVisibility(0);
      AppMethodBeat.o(268896);
      return;
    }
  }
  
  private void a(cd paramcd, Map<String, String> paramMap, com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268883);
    label103:
    int i;
    label126:
    Object localObject;
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
    {
      a(paramcd, Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), paramMap, paramca, false);
      paramca = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.display_name_desc"));
      if (Util.isNullOrNil(paramca)) {
        break label733;
      }
      paramcd.XnP.setText(paramca);
      paramcd.XnP.setVisibility(0);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_right_icon_and_desc_name"), 0) != 1) {
        break label755;
      }
      i = 1;
      if (i == 0) {
        break label820;
      }
      paramcd.XnQ.setVisibility(0);
      paramca = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.right_icon_url"));
      localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.right_desc_name"));
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_type"), -1) != 3) {
        break label761;
      }
      paramcd.XnR.setImageResource(R.g.dnF);
      paramcd.XnR.setVisibility(0);
      label210:
      if (Util.isNullOrNil((String)localObject)) {
        break label807;
      }
      paramcd.XnS.setText((CharSequence)localObject);
      label227:
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
        break label832;
      }
      paramcd.Xng.setBackgroundResource(R.g.mm_trans);
    }
    for (;;)
    {
      if (com.tencent.mm.compatible.util.d.qV(23)) {
        paramcd.Xng.setForeground(this.WBq.WQv.getContext().getDrawable(R.g.dns));
      }
      AppMethodBeat.o(268883);
      return;
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
      {
        a(paramcd, Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.icon_url")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.display_name")), paramMap, paramca, true);
        break;
      }
      ((View)paramcd.Xnk.getParent()).setVisibility(8);
      if (("notifymessage".equals(paramca.field_talker)) && (!this.XiN))
      {
        final String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        WxaAttributes localWxaAttributes;
        if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str))
        {
          localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(str);
          if (localWxaAttributes == null)
          {
            localObject = null;
            label451:
            a(paramcd.Xnh, this.WBq, str, paramca, (String)localObject, paramMap);
            if (localWxaAttributes != null) {
              break label575;
            }
            localObject = str;
            label478:
            paramcd.Xni.setText(l.b(this.WBq.WQv.getContext(), (CharSequence)localObject, paramcd.Xni.getTextSize()));
            if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str)) {
              break label627;
            }
            paramcd.Xng.setTag(new by(paramca, str));
            paramcd.Xng.setOnClickListener(this.XcK);
          }
        }
        for (;;)
        {
          paramcd.Xng.setVisibility(0);
          break;
          localObject = localWxaAttributes.field_brandIconURL;
          break label451;
          label575:
          localObject = localWxaAttributes.field_nickname;
          break label478;
          a(paramcd.Xnh, this.WBq, str, paramca, null, paramMap);
          localObject = ((com.tencent.mm.ui.chatting.d.b.f)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(str);
          break label478;
          label627:
          localObject = paramcd.Xng;
          if (this.WBq.hRi()) {}
          for (paramca = this.WBq.getTalkerUserName();; paramca = null)
          {
            ((View)localObject).setTag(new by(str, paramca));
            if (!Util.getBoolean((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
              break label701;
            }
            paramcd.Xng.setOnClickListener(null);
            break;
          }
          label701:
          paramcd.Xng.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(278722);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              localObject = ar.this.e(ar.b(ar.this));
              if (localObject != null) {
                ((t.b)localObject).onClick(paramAnonymousView);
              }
              ar.a(ar.this, 10, ar.b(ar.this).getTalkerUserName(), str);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(278722);
            }
          });
        }
      }
      paramcd.Xng.setVisibility(8);
      break;
      label733:
      paramcd.XnP.setText("");
      paramcd.XnP.setVisibility(8);
      break label103;
      label755:
      i = 0;
      break label126;
      label761:
      if (!Util.isNullOrNil(paramca))
      {
        o(paramcd.XnR, paramca);
        paramcd.XnR.setVisibility(0);
        break label210;
      }
      paramcd.XnR.setImageBitmap(null);
      paramcd.XnR.setVisibility(8);
      break label210;
      label807:
      paramcd.XnS.setText("");
      break label227;
      label820:
      paramcd.XnQ.setVisibility(8);
      break label227;
      label832:
      i = paramcd.Xng.getPaddingLeft();
      paramcd.Xng.setBackgroundResource(R.g.list_item_normal);
      paramcd.Xng.setPadding(i, 0, 0, 0);
    }
  }
  
  private void a(final Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca, final cd paramcd, final ISubscribeMsgService.c paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(268894);
    boolean bool1;
    if (!paramc.moD)
    {
      bool1 = true;
      boolean bool2 = paramc.moE;
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), this.XiF, this.XiI, Boolean.valueOf(bool2) });
      localObject = paramcd.XnN;
      if (!this.XiL) {
        break label212;
      }
      i = 0;
      label91:
      ((LinearLayout)localObject).setVisibility(i);
      if ((!bool1) && ((!paramBoolean) || (bool2))) {
        break label227;
      }
      a(paramcd, 0);
      localObject = paramcd.XnO;
      localResources = this.WBq.WQv.getMMResources();
      if (!paramBoolean) {
        break label219;
      }
    }
    label212:
    label219:
    for (int i = R.l.eOx;; i = R.l.eOq)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      paramcd.XnN.setTag(R.h.dNL, paramca);
      if (this.XiL) {
        paramcd.XnN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(260387);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ar.a(ar.this, paramca, paramMap, true, paramBoolean, paramc, paramcd);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260387);
          }
        });
      }
      AppMethodBeat.o(268894);
      return;
      bool1 = false;
      break;
      i = 8;
      break label91;
    }
    label227:
    a(paramcd, 8);
    Object localObject = paramcd.XnO;
    Resources localResources = this.WBq.WQv.getMMResources();
    if (paramBoolean) {}
    for (i = R.l.eOv;; i = R.l.eNR)
    {
      ((TextView)localObject).setText(localResources.getString(i));
      break;
    }
  }
  
  private void a(final Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca, final String paramString, final cd paramcd, final boolean paramBoolean)
  {
    AppMethodBeat.i(268890);
    e locale = new e(this.WBq.WQv.getContext(), 1, true);
    if (paramBoolean) {
      locale.j(String.format(this.WBq.WQv.getMMResources().getString(R.l.eOw), new Object[] { this.XiI }), 17, 0);
    }
    for (;;)
    {
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(228861);
          if (paramBoolean)
          {
            paramAnonymouso.a(0, ar.b(ar.this).WQv.getMMResources().getColor(R.e.red_text_color), ar.b(ar.this).WQv.getMMResources().getString(R.l.eNV));
            AppMethodBeat.o(228861);
            return;
          }
          paramAnonymouso.a(1, ar.b(ar.this).WQv.getMMResources().getColor(R.e.brand_text_color), ar.b(ar.this).WQv.getMMResources().getString(R.l.eOt));
          AppMethodBeat.o(228861);
        }
      };
      locale.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(227935);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(227935);
            return;
            ar.a(ar.this, 8, paramca.field_talker, paramString);
            ar.a(ar.this, paramMap, true, this.Xjc, paramcd, paramString, false);
            AppMethodBeat.o(227935);
            return;
            ar.a(ar.this, 9, paramca.field_talker, paramString);
            ar.a(ar.this, paramMap, false, this.Xjc, paramcd, paramString, false);
          }
        }
      };
      locale.eik();
      AppMethodBeat.o(268890);
      return;
      locale.j(String.format(this.WBq.WQv.getMMResources().getString(R.l.eOy), new Object[] { this.XiI }), 17, 0);
    }
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final com.tencent.mm.storage.ca paramca, final Map<String, String> paramMap, final String paramString, final cd paramcd, final boolean paramBoolean3)
  {
    AppMethodBeat.i(268895);
    e locale = new e(this.WBq.WQv.getContext(), 1, true);
    Object localObject = this.WBq.WQv.getContext().getResources();
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (localObject = String.format(((Resources)localObject).getString(R.l.eOs), new Object[] { this.XiI });; localObject = ((Resources)localObject).getString(R.l.eOr))
      {
        locale.j((CharSequence)localObject, 17, 0);
        locale.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
          {
            AppMethodBeat.i(201750);
            if (paramBoolean1)
            {
              paramAnonymouso.a(1, ar.b(ar.this).WQv.getMMResources().getColor(R.e.brand_text_color), ar.b(ar.this).WQv.getMMResources().getString(R.l.eOt));
              AppMethodBeat.o(201750);
              return;
            }
            int j = ar.b(ar.this).WQv.getMMResources().getColor(R.e.red_text_color);
            Resources localResources = ar.b(ar.this).WQv.getMMResources();
            if (paramBoolean2) {}
            for (int i = R.l.eNV;; i = R.l.eNW)
            {
              paramAnonymouso.a(0, j, localResources.getString(i));
              AppMethodBeat.o(201750);
              return;
            }
          }
        };
        locale.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(264517);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(264517);
              return;
              ar.a(ar.this, 8, paramca.field_talker, paramString);
              if (paramBoolean2)
              {
                ar.a(ar.this, paramMap, true, paramBoolean3, paramcd, paramString, true);
                AppMethodBeat.o(264517);
                return;
              }
              ar.a(ar.this, true, paramcd, paramString, paramca);
              AppMethodBeat.o(264517);
              return;
              ar.a(ar.this, 9, paramca.field_talker, paramString);
              if (paramBoolean2)
              {
                ar.a(ar.this, paramMap, false, paramBoolean3, paramcd, paramString, true);
                AppMethodBeat.o(264517);
                return;
              }
              ar.a(ar.this, false, paramcd, paramString, paramca);
            }
          }
        };
        locale.eik();
        AppMethodBeat.o(268895);
        return;
      }
    }
    if (paramBoolean2) {}
    for (localObject = String.format(((Resources)localObject).getString(R.l.eNT), new Object[] { this.XiI });; localObject = ((Resources)localObject).getString(R.l.eNU))
    {
      locale.j((CharSequence)localObject, 17, 0);
      break;
    }
  }
  
  private static String aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(268899);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(268899);
      return "";
    }
    Object localObject = null;
    com.tencent.mm.storage.as localas;
    if (ab.Lj(paramString1))
    {
      bh.beI();
      localas = com.tencent.mm.model.c.bbL().RG(paramString1);
      if (localas != null)
      {
        if (Util.isNullOrNil(localas.field_conRemark)) {
          localObject = localas.field_nickname;
        }
      }
      else
      {
        if (!Util.isNullOrNil((String)localObject)) {
          break label165;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { paramString1, paramString2 });
        paramString1 = paramString2;
        if (!Util.isNullOrNil(paramString2)) {}
      }
    }
    label165:
    for (paramString1 = MMApplicationContext.getContext().getString(R.l.ewS);; paramString1 = (String)localObject)
    {
      AppMethodBeat.o(268899);
      return paramString1;
      localObject = localas.field_conRemark;
      break;
      bh.beI();
      localObject = com.tencent.mm.model.c.bbL().RG(paramString1);
      if (((com.tencent.mm.storage.as)localObject).ays() == null)
      {
        localObject = ((com.tencent.mm.storage.as)localObject).ayr();
        break;
      }
      localObject = ((com.tencent.mm.storage.as)localObject).ays();
      break;
    }
  }
  
  private void ab(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(268881);
    if (!uF(this.XiJ))
    {
      AppMethodBeat.o(268881);
      return;
    }
    if (!ab.QQ(paramString1))
    {
      AppMethodBeat.o(268881);
      return;
    }
    if (!com.tencent.mm.ao.g.Ux(paramString2))
    {
      AppMethodBeat.o(268881);
      return;
    }
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.XiK);
    AppMethodBeat.o(268881);
  }
  
  private static void ac(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    Log.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.IzE.a(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(37253);
  }
  
  private static void b(int paramInt, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(268912);
    long l2;
    long l1;
    if (paramInt == 4)
    {
      l2 = 0L;
      l1 = l2;
    }
    for (;;)
    {
      try
      {
        paramMap = new com.tencent.mm.ad.i(Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string")));
        l1 = l2;
        l2 = com.tencent.mm.ae.d.Nb(paramMap.optString("live_id"));
        l1 = l2;
        paramMap = paramMap.optString("force_push_info");
        if (paramMap == null) {
          break label173;
        }
        l1 = l2;
        paramMap = new com.tencent.mm.ad.i(paramMap).optString("forcePushId");
        l1 = l2;
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.ChattingItemDyeingTemplate", "opExtraInfo, liveId, crash: %s", new Object[] { paramMap.getMessage() });
        paramMap = "";
        continue;
        com.tencent.mm.plugin.finder.live.report.m localm = com.tencent.mm.plugin.finder.live.report.m.yCt;
        com.tencent.mm.plugin.finder.live.report.m.a(s.bn.yNb, paramString, l1, "", paramMap, Long.valueOf(1L), "", "", "");
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.awv(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l1)))
      {
        AppMethodBeat.o(268912);
        return;
      }
      AppMethodBeat.o(268912);
      return;
      label173:
      paramMap = "";
    }
  }
  
  private void b(cd paramcd, final com.tencent.mm.storage.ca paramca, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(268902);
    LinearLayout localLinearLayout = paramcd.XnA;
    int k = localLinearLayout.getChildCount();
    final int i = 0;
    final String str2;
    final String str3;
    final int j;
    label194:
    Object localObject;
    label254:
    a locala;
    final String str1;
    if (i < 10)
    {
      if (i == 0) {}
      for (paramcd = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; paramcd = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str2 = (String)paramMap.get(paramcd + ".word");
        str3 = (String)paramMap.get(paramcd + ".hint_word");
        if (!Util.isNullOrNil(str2)) {
          break label194;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label1330;
        }
        if (i != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
        AppMethodBeat.o(268902);
        return;
      }
      localLinearLayout.removeViews(i, j - i);
      AppMethodBeat.o(268902);
      return;
      if (i < k) {
        localObject = (LinearLayout)localLinearLayout.getChildAt(i);
      }
      for (;;)
      {
        if (!h(paramMap, i)) {
          break label254;
        }
        ((LinearLayout)localObject).setVisibility(8);
        i += 1;
        break;
        localObject = hTS();
        localLinearLayout.addView((View)localObject);
      }
      ((LinearLayout)localObject).setVisibility(0);
      locala = (a)((LinearLayout)localObject).getTag();
      localObject = (String)paramMap.get(paramcd + ".icon");
      if (!com.tencent.mm.ui.ar.isDarkMode()) {
        break label1337;
      }
      str1 = (String)paramMap.get(paramcd + ".dmicon");
      if (Util.isNullOrNil(str1)) {
        break label1337;
      }
      localObject = str1;
    }
    label564:
    label1337:
    for (;;)
    {
      j = com.tencent.mm.ui.ar.iV(c(paramMap, paramcd + ".color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
      locala.jMg.setTextColor(j);
      label474:
      final int m;
      if (Util.getInt((String)paramMap.get(paramcd + ".is_rich_text"), 0) == 0)
      {
        locala.jMg.setSingleLine(true);
        locala.jMg.setEllipsize(TextUtils.TruncateAt.END);
        locala.jMg.setText(str2);
        locala.mSz.setText(str3);
        locala.mSz.setTextColor(this.WBq.WQv.getContext().getResources().getColor(R.e.FG_1));
        m = Util.getInt((String)paramMap.get(paramcd + ".is_show_red_dot"), 0);
        if (cm.bfD() - paramca.field_createTime <= 604800000L) {
          break label967;
        }
        j = 1;
        if ((!p(paramca, i)) || (m != 1) || (j != 0)) {
          break label995;
        }
        if (Util.isNullOrNil(str3)) {
          break label973;
        }
        locala.XbS.setVisibility(8);
        locala.XbT.setVisibility(0);
        label611:
        if (!Util.isNullOrNil((String)localObject)) {
          break label1018;
        }
        locala.bwJ.setVisibility(8);
        locala.jMg.setPadding(0, 0, 0, 0);
      }
      final int n;
      for (;;)
      {
        str2 = (String)paramMap.get(paramcd + ".url");
        localObject = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        n = Util.getInt((String)paramMap.get(paramcd + ".op_type"), 0);
        str1 = (String)paramMap.get(paramcd + ".weapp_username");
        str3 = Util.nullAsNil((String)paramMap.get(paramcd + ".general_string"));
        by localby = new by(paramca, (String)localObject, str2);
        localby.XmT = i;
        localby.XmU = m;
        locala.VYV.setTag(localby);
        j = i + 1;
        if ((n != 3) && (n != 4) && (n != 5)) {
          break label1066;
        }
        a(locala.VYV, paramca, paramMap, n, 2);
        break;
        j = Util.getInt((String)paramMap.get(paramcd + ".display_line_number"), 1);
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(j) });
        locala.jMg.setSingleLine(false);
        locala.jMg.setText(str2);
        locala.jMg.setMaxLines(j);
        l.a(locala.jMg, false, null);
        break label474;
        label967:
        j = 0;
        break label564;
        label973:
        locala.XbS.setVisibility(0);
        locala.XbT.setVisibility(8);
        break label611;
        label995:
        locala.XbS.setVisibility(8);
        locala.XbT.setVisibility(8);
        break label611;
        label1018:
        locala.bwJ.setVisibility(0);
        o(locala.bwJ, (String)localObject);
        locala.jMg.setPadding(0, 0, com.tencent.mm.ci.a.fromDPToPix(this.WBq.WQv.getContext(), 28), 0);
      }
      if ((n == 1) && (!TextUtils.isEmpty(str1)))
      {
        str2 = (String)paramMap.get(paramcd + ".weapp_path");
        n = Util.getInt((String)paramMap.get(paramcd + ".weapp_version"), 0);
        final int i1 = Util.getInt((String)paramMap.get(paramcd + ".weapp_state"), 0);
        paramcd = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(291419);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = (by)paramAnonymousView.getTag();
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str1 });
            localObject = new AppBrandStatObject();
            ((AppBrandStatObject)localObject).fvd = (paramAnonymousView.fNz.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ar.b(ar.this).getTalkerUserName() + ":" + this.Xfh);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(paramAnonymousView.userName))
            {
              ((AppBrandStatObject)localObject).scene = ar.amL(this.Xfh);
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ar.b(ar.this).WQv.getContext(), str1, null, i1, n, str2, (AppBrandStatObject)localObject);
              if (m == 1) {
                ar.q(paramca, i);
              }
              ar.od(ar.d(ar.this), ar.a(ar.this));
              com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), this.Qry, Integer.valueOf(j) });
              ar.f(paramMap, String.valueOf(i), "");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(291419);
              return;
            }
            ((AppBrandStatObject)localObject).scene = 1043;
            paramAnonymousView = com.tencent.mm.ao.g.gu(paramAnonymousView.userName);
            r localr = (r)com.tencent.mm.kernel.h.ae(r.class);
            Activity localActivity = ar.b(ar.this).WQv.getContext();
            String str1 = str1;
            int i = i1;
            int j = n;
            String str2 = str2;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localr.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
              break;
            }
          }
        };
        locala.VYV.setOnClickListener(paramcd);
        break;
      }
      if (n == 2)
      {
        locala.VYV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(267904);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (j == 1)
            {
              localObject = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
              long l = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
              ar.h(paramAnonymousView.getContext(), (String)localObject, l);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 2L, 1L, false);
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject, Long.valueOf(l) });
            }
            for (;;)
            {
              ar.f(paramMap, String.valueOf(i), "");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(267904);
              return;
              if (j == 2) {
                com.tencent.mm.by.c.f(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
              }
            }
          }
        });
        break;
      }
      if (n == 6)
      {
        locala.VYV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(277798);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            try
            {
              localObject = new com.tencent.mm.ad.i(str3);
              paramAnonymousView = ((com.tencent.mm.ad.i)localObject).optString("feedID");
              localObject = ((com.tencent.mm.ad.i)localObject).optString("nonceID");
              ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().F(ar.b(ar.this).WQv.getContext(), paramAnonymousView, (String)localObject);
              ar.f(paramMap, String.valueOf(i), paramAnonymousView);
              if (m == 1) {
                ar.q(paramca, i);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(277798);
              return;
            }
            catch (com.tencent.mm.ad.g paramAnonymousView)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", paramAnonymousView, "", new Object[0]);
              }
            }
          }
        });
        break;
      }
      locala.VYV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(269148);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!Util.isNullOrNil(str2))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", str2);
            c.q(paramAnonymousView, ar.b(ar.this).getTalkerUserName());
            com.tencent.mm.by.c.b(ar.b(ar.this).WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ar.a(ar.this), this.Qry, Integer.valueOf(j) });
            ar.a(ar.this, 5, paramMap, String.valueOf(i));
            if (m == 1) {
              ar.q(paramca, i);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(269148);
        }
      });
      break;
      AppMethodBeat.o(268902);
      return;
    }
  }
  
  private void b(cd paramcd, Map<String, String> paramMap)
  {
    AppMethodBeat.i(268897);
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
    String str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
    String str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
    if (!Util.isNullOrNil(str2))
    {
      int i = com.tencent.mm.ui.ar.iV(c(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
      int j = com.tencent.mm.ui.ar.iV(c(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
      int k = com.tencent.mm.ui.ar.iV(c(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
      int m = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
      paramcd.Xns.setTextColor(i);
      paramcd.Xnu.setTextColor(j);
      paramcd.Xnv.setTextColor(k);
      paramcd.Xnv.getPaint().setFlags(16);
      paramcd.Xns.setText(str1);
      if ((m > 0) && (m < str2.length()))
      {
        paramcd.Xnt.setVisibility(0);
        paramcd.Xnt.setText(str2.substring(0, m));
        paramcd.Xnt.setTextColor(j);
        paramcd.Xnt.setTypeface(com.tencent.mm.wallet_core.ui.g.bl(this.WBq.WQv.getContext(), 0));
        paramcd.Xnu.setTypeface(com.tencent.mm.wallet_core.ui.g.bl(this.WBq.WQv.getContext(), 0));
        paramcd.Xnu.setTextSize(1, 40.0F);
        paramcd.Xnt.setTextSize(1, 40.0F);
        paramcd.Xnu.setIncludeFontPadding(true);
        paramcd.Xnu.setText(str2.substring(m));
        if (Util.isNullOrNil(str3)) {
          break label546;
        }
        paramcd.Xnv.setText(str3);
        paramcd.Xnv.setVisibility(0);
      }
      for (;;)
      {
        paramcd.Xnr.setVisibility(0);
        AppMethodBeat.o(268897);
        return;
        paramcd.Xnt.setTypeface(Typeface.DEFAULT);
        paramcd.Xnt.setVisibility(8);
        if ((str2.contains("￥")) || (str2.contains("¥")) || (str2.contains("$")) || (str2.contains("＄")))
        {
          paramcd.Xnu.setTypeface(com.tencent.mm.wallet_core.ui.g.bl(this.WBq.WQv.getContext(), 0));
          paramcd.Xnu.setTextSize(1, 40.0F);
          paramcd.Xnu.setIncludeFontPadding(true);
        }
        for (;;)
        {
          paramcd.Xnu.setText(str2);
          break;
          paramcd.Xnu.setTypeface(Typeface.DEFAULT);
          com.tencent.mm.ui.ar.a(paramcd.Xnu.getPaint(), 0.8F);
          paramcd.Xnu.setTextSize(1, 32.0F);
          paramcd.Xnu.setIncludeFontPadding(false);
        }
        label546:
        paramcd.Xnv.setVisibility(8);
      }
    }
    paramcd.Xnr.setVisibility(8);
    AppMethodBeat.o(268897);
  }
  
  private void b(cd paramcd, Map<String, String> paramMap, com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268885);
    String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    boolean bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str);
    if ((this.XiN) && (paramcd.Xnl.getTag(R.h.dOp) != null))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app single talker chat");
      paramcd.Xnm.setTag(R.h.dOp, paramca);
      paramcd.Xnm.setOnClickListener(this.Xiy);
      paramcd.Xnm.setVisibility(0);
      paramcd.Xnl.setVisibility(8);
      paramcd = paramcd.Xnq;
      paramcd.setPadding(paramcd.getPaddingLeft(), paramcd.getPaddingTop(), paramcd.getPaddingRight(), 0);
      AppMethodBeat.o(268885);
      return;
    }
    if ((bool) && ("notifymessage".equals(paramca.field_talker)))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
      paramcd.Xnm.setTag(null);
      paramcd.Xnm.setVisibility(8);
      AppMethodBeat.o(268885);
      return;
    }
    if ((ab.QQ(paramca.field_talker)) && (com.tencent.mm.ao.g.Ux(str)) && (uF(p(paramMap))))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by biz subscribe msg");
      paramcd.Xnm.setTag(null);
      paramcd.Xnm.setVisibility(8);
      AppMethodBeat.o(268885);
      return;
    }
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
      paramcd.Xnl.setTag(null);
      paramcd.Xnm.setTag(null);
      paramcd.Xnl.setVisibility(8);
      paramcd.Xnm.setVisibility(8);
      AppMethodBeat.o(268885);
      return;
    }
    if (paramcd.Xng.getVisibility() == 0)
    {
      paramcd.Xnl.setTag(paramca);
      paramcd.Xnl.setOnClickListener(this.Xiz);
      paramcd.Xnl.setVisibility(0);
      paramcd.Xnm.setVisibility(8);
      AppMethodBeat.o(268885);
      return;
    }
    if (paramcd.Xnq.getVisibility() == 0)
    {
      paramcd.Xnm.setTag(paramca);
      paramcd.Xnm.setOnClickListener(this.Xiz);
      paramcd.Xnm.setVisibility(0);
      paramcd.Xnl.setVisibility(8);
      AppMethodBeat.o(268885);
      return;
    }
    paramcd.Xnl.setTag(null);
    paramcd.Xnm.setTag(null);
    paramcd.Xnl.setVisibility(8);
    paramcd.Xnm.setVisibility(8);
    AppMethodBeat.o(268885);
  }
  
  private static int bzJ(String paramString)
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
  
  private static int bzK(String paramString)
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
  
  private static void c(cd paramcd, Map<String, String> paramMap)
  {
    AppMethodBeat.i(268898);
    Log.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
    paramcd.Xnx.setVisibility(8);
    Object localObject1 = (ViewGroup)paramcd.Xnx.getParent();
    paramcd = ((ViewGroup)localObject1).findViewById(R.h.dDB);
    Object localObject2;
    if (paramcd == null)
    {
      paramcd = LayoutInflater.from(((ViewGroup)localObject1).getContext()).inflate(R.i.ekx, null);
      localObject2 = new bs();
      ((bs)localObject2).bwJ = ((ImageView)paramcd.findViewById(R.h.avatar));
      ((bs)localObject2).zai = ((TextView)paramcd.findViewById(R.h.nickname));
      ((bs)localObject2).jMg = ((TextView)paramcd.findViewById(R.h.title));
      paramcd.setTag(localObject2);
      ((ViewGroup)localObject1).addView(paramcd);
    }
    for (;;)
    {
      paramcd.setVisibility(0);
      paramcd = (bs)paramcd.getTag();
      localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
      localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
      String str = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
      paramMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
      int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
      paramcd.jMg.setText(l.c(paramcd.jMg.getContext(), (CharSequence)localObject1));
      paramcd.zai.setText(l.c(paramcd.jMg.getContext(), aL((String)localObject2, str)));
      if (i == 2)
      {
        paramcd.bwJ.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.app_add_to_favorite));
        AppMethodBeat.o(268898);
        return;
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(paramcd.bwJ, (String)localObject2);
      AppMethodBeat.o(268898);
      return;
    }
  }
  
  private void c(final cd paramcd, final Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268888);
    if (!"notifymessage".equals(paramca.field_talker)) {
      i = 1;
    }
    for (int j = 0;; j = 1)
    {
      if ((j == 0) || (i == 0))
      {
        paramcd.XnN.setVisibility(8);
        a(paramcd, 8);
      }
      if ((j != 0) && (i != 0))
      {
        paramcd.Xnl.setVisibility(0);
        paramcd.Xnl.setTag(R.h.dOp, paramca);
        a(paramcd);
      }
      AppMethodBeat.o(268888);
      return;
      if (uF(this.XiJ)) {
        break;
      }
      i = 0;
    }
    String str1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    this.XiK.setUsername(Util.nullAs(str1, ""));
    this.XiK.type = 1;
    Object localObject = this.XiK;
    String str2 = Util.nullAs(this.XiF, "");
    p.k(str2, "<set-?>");
    ((com.tencent.mm.msgsubscription.c.a.b)localObject).lnb = str2;
    this.XiK.mod = this.XiJ;
    localObject = this.XiK;
    str2 = Util.nullAs(this.XiI, "");
    p.k(str2, "<set-?>");
    ((com.tencent.mm.msgsubscription.c.a.b)localObject).mqc = str2;
    localObject = paramcd.XnN;
    if (this.XiL) {}
    for (int i = 0;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      a(paramcd, 8);
      paramcd.XnO.setText(this.WBq.WQv.getMMResources().getString(R.l.eOv));
      localObject = com.tencent.mm.msgsubscription.b.a.mpf;
      a.a.bK(this.XiF, paramcd.XnN.hashCode());
      localObject = com.tencent.mm.msgsubscription.b.a.mpf;
      a.a.a(this.XiF, paramcd.XnN.hashCode(), new ISubscribeMsgService.b()
      {
        public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
        {
          AppMethodBeat.i(271669);
          if (paramAnonymousString.equals(ar.a(ar.this)))
          {
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onUpdated templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousc.moD), Boolean.valueOf(paramAnonymousc.moE) });
            ar.a(ar.this, new ISubscribeMsgService.c(paramAnonymousc.moD, paramAnonymousc.moE));
            ar.f(ar.this).mnH = paramAnonymousc.mnH;
            ar.f(ar.this).mok = paramAnonymousc.mok;
            ar.a(ar.this, paramMap, paramca, paramcd, paramAnonymousc);
            if ((!ar.e(ar.this)) && (ar.g(ar.this) != null) && (ar.g(ar.this).isShowing())) {
              ar.g(ar.this).eik();
            }
          }
          AppMethodBeat.o(271669);
        }
        
        public final void onError()
        {
          AppMethodBeat.i(271670);
          Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
          AppMethodBeat.o(271670);
        }
      });
      this.mpC.bJ(str1, this.XiF);
      i = 1;
      j = 1;
      break;
    }
  }
  
  private void d(cd paramcd, Map<String, String> paramMap)
  {
    AppMethodBeat.i(268900);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    Object localObject1;
    label37:
    Object localObject2;
    Object localObject3;
    label223:
    int k;
    label241:
    ca localca;
    if (j < 100)
    {
      if (j == 0)
      {
        localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
        localObject2 = (String)paramMap.get((String)localObject1 + ".value.word");
        localObject3 = (String)paramMap.get((String)localObject1 + ".key.word");
        if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject3))) {
          break label405;
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
      localObject2 = paramcd.Xnx;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)paramcd.Xnx.getParent()).findViewById(R.h.dDB);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((LinearLayout)localObject2).getChildCount() > localArrayList.size())
      {
        if (localArrayList.size() != 0) {
          break label865;
        }
        ((LinearLayout)localObject2).removeAllViews();
      }
      localObject3 = new StringBuilder();
      k = ((LinearLayout)localObject2).getChildCount();
      i = 0;
      if (i >= localArrayList.size()) {
        break label962;
      }
      localca = (ca)localArrayList.get(i);
      if (i >= k) {
        break label895;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject2).getChildAt(i);
      label282:
      localObject1 = (cb)((LinearLayout)localObject1).getTag();
      if (!localca.Xna) {
        break label911;
      }
      ((cb)localObject1).Xnb.setVisibility(8);
    }
    for (;;)
    {
      ((cb)localObject1).Xnc.setTextColor(com.tencent.mm.ui.ar.iV(localca.XmZ));
      ((cb)localObject1).Xnc.setText(localca.XmX);
      ((StringBuilder)localObject3).append(Util.nullAs(localca.XmW, "")).append(":").append(Util.nullAs(localca.XmX, "")).append("\n");
      i += 1;
      break label241;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label405:
      localca = new ca();
      localca.XmX = ((String)localObject2);
      localca.XmW = Util.nullAsNil((String)localObject3);
      label569:
      boolean bool;
      if (!com.tencent.mm.ui.ar.isDarkMode())
      {
        localca.XmY = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", XiO));
        localca.XmZ = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color)));
        if (Util.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label856;
        }
        bool = true;
        label609:
        localca.Xna = bool;
        k = (bzK(localca.XmW) + 1) / 2;
        if (k <= i) {
          break label862;
        }
        i = k;
      }
      label856:
      label862:
      for (;;)
      {
        localArrayList.add(localca);
        j += 1;
        break;
        localca.XmY = c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".key.color", XiO)));
        localca.XmZ = c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", c(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", c(paramMap, (String)localObject1 + ".value.color", this.WBq.WQv.getContext().getResources().getColor(R.e.normal_text_color))));
        localca.XmZ = com.tencent.mm.ui.ar.iV(localca.XmZ);
        break label569;
        bool = false;
        break label609;
      }
      label865:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label223;
      label895:
      localObject1 = hTR();
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label282;
      label911:
      ((cb)localObject1).Xnb.setVisibility(0);
      ((cb)localObject1).Xnb.setEms(j);
      ((cb)localObject1).Xnb.setTextColor(com.tencent.mm.ui.ar.iV(localca.XmY));
      ((cb)localObject1).Xnb.setText(localca.XmW);
    }
    label962:
    this.XiK.YW(((StringBuilder)localObject3).toString());
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      paramcd.Xnw.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(268900);
      return;
    }
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      paramcd.Xnw.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(268900);
      return;
      paramcd.Xnw.setVisibility(0);
    }
  }
  
  private void d(cd paramcd, Map<String, String> paramMap, com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268892);
    this.XiK.reset();
    String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str))
    {
      e(paramcd, paramMap, paramca);
      AppMethodBeat.o(268892);
      return;
    }
    if (com.tencent.mm.ao.g.Ux(str))
    {
      c(paramcd, paramMap, paramca);
      AppMethodBeat.o(268892);
      return;
    }
    paramcd.XnN.setVisibility(8);
    a(paramcd, 8);
    AppMethodBeat.o(268892);
  }
  
  private void e(final cd paramcd, final Map<String, String> paramMap, final com.tencent.mm.storage.ca paramca)
  {
    boolean bool2 = true;
    AppMethodBeat.i(268893);
    boolean bool3 = uF(p(paramMap));
    Object localObject1;
    final boolean bool1;
    if ("notifymessage".equals(paramca.field_talker))
    {
      localObject1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.is_audio_template"), 0) != 1) {
        break label350;
      }
      bool1 = true;
      this.XiK.setUsername((String)localObject1);
      this.XiK.type = 2;
      ((j)this.WBq.bC(j.class)).a(this.XiC);
      EventCenter.instance.addListener(this.WQk);
      if (!bool3) {
        break label390;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW((String)localObject1);
      if (localObject2 == null) {
        break label356;
      }
      this.mAppId = ((WxaAttributes)localObject2).field_appId;
      label158:
      localObject2 = paramcd.XnN;
      if (!this.XiL) {
        break label383;
      }
    }
    label350:
    label356:
    label383:
    for (int i = 0;; i = 8)
    {
      ((LinearLayout)localObject2).setVisibility(i);
      a(paramcd, 8);
      paramcd.XnO.setText(this.WBq.WQv.getMMResources().getString(R.l.eOv));
      this.XiE.moD = true;
      this.XiE.moE = true;
      localObject2 = com.tencent.mm.msgsubscription.b.a.mpf;
      a.a.bK(this.XiF, paramcd.XnN.hashCode());
      localObject2 = com.tencent.mm.msgsubscription.b.a.mpf;
      a.a.a(this.XiF, paramcd.XnN.hashCode(), new ISubscribeMsgService.b()
      {
        public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
        {
          AppMethodBeat.i(285329);
          if (paramAnonymousString.equals(ar.a(ar.this)))
          {
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b, isSwitchOpened: %b", new Object[] { this.Qry, paramAnonymousString, Boolean.valueOf(paramAnonymousc.moD), Boolean.valueOf(paramAnonymousc.moE), Boolean.valueOf(paramAnonymousc.mnH) });
            ar.a(ar.this, new ISubscribeMsgService.c(paramAnonymousc.moD, paramAnonymousc.moE));
            ar.f(ar.this).mnH = paramAnonymousc.mnH;
            ar.f(ar.this).mok = bool1;
            ar.a(ar.this, paramMap, paramca, paramcd, ar.f(ar.this), true);
            if ((!ar.e(ar.this)) && (ar.g(ar.this) != null) && (ar.g(ar.this).isShowing())) {
              ar.g(ar.this).eik();
            }
          }
          AppMethodBeat.o(285329);
        }
        
        public final void onError()
        {
          AppMethodBeat.i(285330);
          Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
          AppMethodBeat.o(285330);
        }
      });
      this.XiH.bJ((String)localObject1, this.XiF);
      paramcd.Xnl.setVisibility(0);
      paramcd.Xnl.setTag(R.h.dOp, paramca);
      a(paramcd);
      AppMethodBeat.o(268893);
      return;
      bool1 = false;
      break;
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a((String)localObject1, new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(275937);
          if (paramAnonymousWxaAttributes != null)
          {
            Log.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ar.d(ar.this) });
            ar.c(ar.this, paramAnonymousWxaAttributes.field_appId);
          }
          AppMethodBeat.o(275937);
        }
      });
      break label158;
    }
    label390:
    this.XiE.moE = false;
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW((String)localObject1);
    if (localObject2 != null)
    {
      this.mAppId = ((WxaAttributes)localObject2).field_appId;
      if ((((WxaAttributes)localObject2).field_appOpt & 0x1) > 0)
      {
        i = 1;
        label443:
        localObject1 = this.XiE;
        if (i != 0) {
          break label486;
        }
        bool1 = bool2;
        label458:
        ((ISubscribeMsgService.c)localObject1).moD = bool1;
      }
    }
    for (;;)
    {
      a(paramMap, paramca, paramcd, this.XiE, false);
      break;
      i = 0;
      break label443;
      label486:
      bool1 = false;
      break label458;
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { localObject1 });
      this.XiE.moD = true;
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a((String)localObject1, new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          boolean bool = true;
          AppMethodBeat.i(288177);
          if (paramAnonymousWxaAttributes == null)
          {
            AppMethodBeat.o(288177);
            return;
          }
          ar.c(ar.this, paramAnonymousWxaAttributes.field_appId);
          int i;
          if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0)
          {
            i = 1;
            paramAnonymousWxaAttributes = ar.f(ar.this);
            if (i != 0) {
              break label79;
            }
          }
          for (;;)
          {
            paramAnonymousWxaAttributes.moD = bool;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(271683);
                ar.a(ar.this, ar.26.this.iVZ, ar.26.this.lrk, ar.26.this.Xja, ar.f(ar.this), false);
                AppMethodBeat.o(271683);
              }
            });
            AppMethodBeat.o(288177);
            return;
            i = 0;
            break;
            label79:
            bool = false;
          }
        }
      });
    }
  }
  
  private static boolean h(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(268910);
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
          break label119;
        }
        AppMethodBeat.o(268910);
        return false;
        localObject1 = Integer.valueOf(paramInt);
        break;
      }
      label119:
      if (Util.getInt((String)paramMap.get((String)localObject1 + ".device_type"), 0) == 2)
      {
        i = Util.getInt((String)paramMap.get((String)localObject1 + ".device_op_type"), 0);
        int j = Util.getInt((String)paramMap.get((String)localObject1 + ".device_client_version"), 0);
        Log.v("MicroMsg.ChattingItemDyeingTemplate", "checkButtonShouldHide opItemIndex: %s, deviceOpType: %s, deviceClientVersion: %x", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
        if ((i == 1) && (com.tencent.mm.protocal.d.RAD >= j))
        {
          AppMethodBeat.o(268910);
          return true;
        }
        AppMethodBeat.o(268910);
        return false;
      }
      i += 1;
      if (i > 10)
      {
        AppMethodBeat.o(268910);
        return false;
      }
    }
  }
  
  private LinearLayout hTR()
  {
    AppMethodBeat.i(268901);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.WBq.WQv.getContext()).inflate(R.i.ecn, null, false);
    cb localcb = new cb();
    localcb.Xnb = ((TextView)localLinearLayout.findViewById(R.h.dLk));
    localcb.Xnc = ((TextView)localLinearLayout.findViewById(R.h.dLm));
    localLinearLayout.setTag(localcb);
    AppMethodBeat.o(268901);
    return localLinearLayout;
  }
  
  private LinearLayout hTS()
  {
    AppMethodBeat.i(268906);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.WBq.WQv.getContext()).inflate(R.i.ecm, null, false);
    a locala = new a();
    locala.jMg = ((TextView)localLinearLayout.findViewById(R.h.dNY));
    locala.bwJ = ((ImageView)localLinearLayout.findViewById(R.h.dNV));
    locala.VYV = ((LinearLayout)localLinearLayout.findViewById(R.h.dNT));
    locala.mSz = ((TextView)localLinearLayout.findViewById(R.h.dNU));
    locala.XbS = ((ImageView)localLinearLayout.findViewById(R.h.dNW));
    locala.XbT = ((ImageView)localLinearLayout.findViewById(R.h.dNX));
    localLinearLayout.setTag(locala);
    AppMethodBeat.o(268906);
    return localLinearLayout;
  }
  
  private static void j(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(268909);
    if (!Util.isNullOrNil(paramString2)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(22516, new Object[] { Integer.valueOf(paramInt), paramString1, Integer.valueOf(i), paramString2, paramString3, paramString4 });
      AppMethodBeat.o(268909);
      return;
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
    Object localObject = new com.tencent.mm.ay.a.a.c.a();
    bh.beI();
    ((com.tencent.mm.ay.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.bbX();
    ((com.tencent.mm.ay.a.a.c.a)localObject).lRD = true;
    ((com.tencent.mm.ay.a.a.c.a)localObject).kOl = true;
    localObject = ((com.tencent.mm.ay.a.a.c.a)localObject).bmL();
    com.tencent.mm.ay.q.bml().a(paramString, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
    AppMethodBeat.o(37252);
  }
  
  private static int p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(268887);
    int i = bzJ((String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
    AppMethodBeat.o(268887);
    return i;
  }
  
  private static boolean p(com.tencent.mm.storage.ca paramca, int paramInt)
  {
    AppMethodBeat.i(268904);
    int i = paramca.ily & 1 << paramInt;
    Log.d("MicroMsg.ChattingItemDyeingTemplate", "get reddot state: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(268904);
      return true;
    }
    AppMethodBeat.o(268904);
    return false;
  }
  
  private static boolean uF(int paramInt)
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
      localObject = new be(new aq(paramLayoutInflater, R.i.ecC)).XkJ;
      ((View)localObject).setTag(new bt().iu((View)localObject));
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.ca paramca, String paramString)
  {
    AppMethodBeat.i(37242);
    this.WBq = parama1;
    XiO = parama1.WQv.getContext().getResources().getColor(R.e.desc_text_color);
    XiP = parama1.WQv.getContext().getResources().getColor(R.e.desc_text_color);
    this.XiN = ((com.tencent.mm.ui.chatting.d.b.o)parama1.bC(com.tencent.mm.ui.chatting.d.b.o.class)).hOZ();
    parama = (bv)parama;
    Map localMap = XmlParser.parseXml(paramca.field_content, "msg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      parama.sHk.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    parama.sHk.setVisibility(0);
    int j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.XiF = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.XiJ = p(localMap);
    this.XiG = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    EventCenter.instance.removeListener(this.WQk);
    ((j)parama1.bC(j.class)).b(this.XiC);
    if ((parama instanceof bt))
    {
      final bt localbt = (bt)parama;
      localbt.Xmw.setVisibility(8);
      parama1 = (com.tencent.mm.ui.chatting.d.b.o)parama1.bC(com.tencent.mm.ui.chatting.d.b.o.class);
      if (parama1 != null)
      {
        long l1 = paramca.field_msgId;
        if (parama1.VI(l1))
        {
          long l2 = parama1.VF(l1);
          if (l2 >= 0L)
          {
            int i;
            if (parama1.VG(l2) == null)
            {
              i = 0;
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "filling end of group, id: %d, head id: %d, group size: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
              parama1 = new by(paramca, paramString);
              parama1.position = paramInt;
              localbt.Xmw.setVisibility(0);
              localbt.Xmw.setText(localbt.Xmw.getContext().getString(R.l.exf, new Object[] { Integer.valueOf(i) }));
              localbt.Xmw.setTag(parama1);
              localbt.Xmy.Xmz.setTag(parama1);
              localbt.Xmw.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(267298);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                  localbt.Xmw.setVisibility(8);
                  paramAnonymousView = (by)paramAnonymousView.getTag();
                  localObject = paramAnonymousView.fNz;
                  ar.a(ar.this, 2, (com.tencent.mm.storage.ca)localObject);
                  ar.a(ar.this, localbt, paramAnonymousView, paramAnonymousView.position);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(267298);
                }
              });
              localbt.Xmy.Xmz.setOnBackgroundCardClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(285870);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                  localbt.Xmw.setVisibility(8);
                  paramAnonymousView = (by)localbt.Xmy.Xmz.getTag();
                  localObject = paramAnonymousView.fNz;
                  ar.a(ar.this, 3, (com.tencent.mm.storage.ca)localObject);
                  ar.a(ar.this, localbt, paramAnonymousView, paramAnonymousView.position);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(285870);
                }
              });
              localbt.timeTV.setVisibility(0);
              localbt.timeTV.setText(com.tencent.mm.pluginsdk.j.f.d(parama.timeTV.getContext(), paramca.field_createTime, false));
              localbt.Xmx.ybY.setVisibility(8);
              if (i > 0)
              {
                paramString = localbt.Xmy.Xmz;
                paramString.setBackgroundCardLayout(R.i.ecD);
                paramString.setBackgroundFillCardNum(i - 1);
                parama = null;
                if (paramString.getChildCount() > 0) {
                  parama = paramString.getChildAt(paramString.getChildCount() - 1);
                }
                if (parama != null)
                {
                  parama1 = parama;
                  if (parama.getTag() != null) {}
                }
                else
                {
                  parama1 = new aq(LayoutInflater.from(localbt.Xmy.Xmz.getContext()), R.i.ecB);
                  parama1.setTag(new bv().iu(parama1));
                  paramString.b(parama1, new FrameLayout.LayoutParams(-2, -2));
                }
                parama = (bv)parama1.getTag();
                parama.checkBox.setVisibility(8);
                parama.timeTV.setVisibility(8);
                if (j == 0) {
                  break label752;
                }
                parama.XmA.sEi.setVisibility(8);
                a(parama, localMap, paramca, paramInt, j);
                parama.XmB.Xnd.setVisibility(0);
              }
            }
            for (;;)
            {
              localbt.Xmy.Xmz.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              i = parama1.VG(l2).size();
              break;
              label752:
              parama.XmB.Xnd.setVisibility(8);
              a(parama, localMap, paramca, paramInt);
              parama.XmA.sEi.setVisibility(0);
            }
          }
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "filling content of group, id: %d", new Object[] { Long.valueOf(l1) });
          localbt.sHk.setVisibility(8);
          localbt.timeTV.setVisibility(8);
          localbt.Xmx.ybY.setVisibility(8);
          localbt.Xmy.Xmz.setVisibility(8);
          AppMethodBeat.o(37242);
          return;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "normal msg, id: %d", new Object[] { Long.valueOf(l1) });
      }
      localbt.Xmx.ybY.setVisibility(0);
      localbt.Xmy.Xmz.setVisibility(8);
    }
    if (j != 0)
    {
      parama.XmA.sEi.setVisibility(8);
      a(parama, localMap, paramca, paramInt, j);
      parama.XmB.Xnd.setVisibility(0);
      AppMethodBeat.o(37242);
      return;
    }
    parama.XmB.Xnd.setVisibility(8);
    a(parama, localMap, paramca, paramInt);
    parama.XmA.sEi.setVisibility(0);
    AppMethodBeat.o(37242);
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.ca paramca, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(paramString);
    a(parama, l.b(parama1.WQv.getContext(), paramca, parama.userTV.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.ca paramca)
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
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(268872);
    paramca = (by)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(268872);
      return false;
    }
    int i = paramca.position;
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
    }
    AppMethodBeat.o(268872);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
  
  protected final boolean hTH()
  {
    return this.XiG == 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(37238);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (!(paramView.getTag() instanceof com.tencent.mm.storage.ca))
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      localObject = (com.tencent.mm.storage.ca)paramView.getTag();
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = XmlParser.parseXml(((et)localObject).field_content, "msg", null);
      if ((localMap == null) || (localMap.size() == 0))
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37238);
        return;
      }
      final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
      e locale = new e(paramView.getContext(), 1, false);
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(37233);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OS(str)) {}
          for (String str = paramView.getResources().getString(R.l.eOe);; str = paramView.getResources().getString(R.l.eOc))
          {
            paramAnonymouso.add(0, 2, 0, str);
            AppMethodBeat.o(37233);
            return;
          }
        }
      };
      locale.ODU = new q.g()
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
            ar.a(ar.this, paramView, this.lrk, localMap, str);
          }
        }
      };
      locale.eik();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
    }
  }
  
  public static final class b
  {
    public String gbn;
    public String lnb;
    public String lpI;
    public String lpJ;
    public String lpK;
    public String lpL;
    public String lpM;
    public long time;
    public String title;
    public int type;
    public String url;
    
    public static b co(Map<String, String> paramMap)
    {
      AppMethodBeat.i(37239);
      b localb = new b();
      localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
      localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
      localb.gbn = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
      localb.lpI = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
      localb.lpJ = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
      localb.time = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
      localb.lpK = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
      localb.lpL = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
      localb.lpM = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
      localb.type = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
      localb.lnb = ((String)paramMap.get(".msg.appmsg.template_id"));
      AppMethodBeat.o(37239);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar
 * JD-Core Version:    0.7.0.1
 */