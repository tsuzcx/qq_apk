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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.abz;
import com.tencent.mm.autogen.a.abz.a;
import com.tencent.mm.autogen.a.qz;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.c.b.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.r;
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
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.protocal.protobuf.gnc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.u.j;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.l;
import com.tencent.mm.ui.chatting.component.api.q;
import com.tencent.mm.ui.chatting.v.b;
import com.tencent.mm.ui.chatting.v.o;
import com.tencent.mm.ui.chatting.v.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout.ViewWrapperForAnim;
import com.tencent.mm.ui.chatting.view.FoldableCellLayout.a;
import com.tencent.mm.ui.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ah;

public final class aq
  extends c
{
  private static final String aeMG;
  private static final String aeSC;
  private static final String aeSD;
  private static Integer aeSU;
  private static Integer aeSV;
  private static Integer aeSW;
  private static int aeTa;
  private static int aeTb;
  private int LW;
  private w Sub;
  private com.tencent.mm.modelimage.loader.a.c aduK;
  private View.OnClickListener aeMI;
  private View.OnClickListener aeSE;
  private View.OnClickListener aeSF;
  private View.OnClickListener aeSG;
  private View.OnClickListener aeSH;
  private o aeSI;
  private View.OnClickListener aeSJ;
  private final int aeSK;
  private ISubscribeMsgService.c aeSL;
  private String aeSM;
  private int aeSN;
  private com.tencent.mm.msgsubscription.b.a aeSO;
  private String aeSP;
  private boolean aeSQ;
  private boolean aeSR;
  private int aeSS;
  private int aeST;
  private com.tencent.mm.msgsubscription.c.a.b aeSX;
  private com.tencent.mm.ui.widget.a.f aeSY;
  private boolean aeSZ;
  private aq.d aeTc;
  private e aeTd;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private IListener<qz> aezD;
  private final int avatarSize;
  private final int iconSize;
  private w lKp;
  private String mAppId;
  private com.tencent.mm.msgsubscription.b.a pjs;
  private int sJv;
  private View.OnClickListener yAH;
  
  static
  {
    AppMethodBeat.i(37267);
    aeMG = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    aeSC = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    aeSD = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect";
    aeSU = null;
    aeSV = null;
    aeSW = null;
    aeTa = MMApplicationContext.getContext().getResources().getColor(R.e.desc_text_color);
    aeTb = MMApplicationContext.getContext().getResources().getColor(R.e.desc_text_color);
    AppMethodBeat.o(37267);
  }
  
  public aq()
  {
    AppMethodBeat.i(37240);
    this.avatarSize = 132;
    this.aeSK = 42;
    this.iconSize = 72;
    this.aeSL = new ISubscribeMsgService.c(true, false);
    this.aeSP = "";
    this.LW = -1;
    this.aeSQ = false;
    this.aeSR = false;
    this.aeSS = -1;
    this.aeST = -1;
    this.sJv = 0;
    this.aeSX = new com.tencent.mm.msgsubscription.c.a.b();
    this.aeSY = null;
    this.aeSZ = false;
    Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nrc = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(132, 132);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKB = R.g.brand_default_head;
    this.aduK = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
    this.sJv = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    localObject = com.tencent.mm.msgsubscription.api.b.piw;
    this.pjs = com.tencent.mm.msgsubscription.api.b.QW("name_biz");
    localObject = com.tencent.mm.msgsubscription.api.b.piw;
    this.aeSO = com.tencent.mm.msgsubscription.api.b.QW("name_wxa");
    this.aeSF = new aq.a(this, (byte)0);
    this.aeSJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousView = (bz)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = XmlParser.parseXml(paramAnonymousView.hTm.field_content, "msg", null);
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), localObject1, Integer.valueOf(66666) });
        localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (Util.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("key_enable_teen_mode_check", true);
            c.s((Intent)localObject1, aq.b(aq.this).getTalkerUserName());
            com.tencent.mm.br.c.b(aq.b(aq.this).aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
          localAppBrandStatObject.hzx = (paramAnonymousView.hTm.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + (String)localObject2);
          localAppBrandStatObject.scene = aq.afW((String)localObject2);
          ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(aq.b(aq.this).aezO.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        }
      }
    };
    this.aeMI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        localObject1 = (bz)paramAnonymousView.getTag();
        Object localObject2 = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).hTm.field_content, "msg", null);
        if ((localObject2 != null) && (((Map)localObject2).size() != 0))
        {
          Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
          if (!aq.a(aq.this, (Map)localObject2)) {}
        }
        for (boolean bool = Util.getBoolean((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false);; bool = false)
        {
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click, blockProfile: %b", new Object[] { ((bz)localObject1).userName, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject2 = aq.this;
            paramAnonymousView.getContext();
            aq.a((aq)localObject2, ((bz)localObject1).userName);
            aq.a(aq.this, 10, aq.b(aq.this).getTalkerUserName(), ((bz)localObject1).userName);
          }
          aq.a(aq.this, 4, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).hTm);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37215);
          return;
        }
      }
    };
    this.aezD = new ChattingItemDyeingTemplate.3(this, com.tencent.mm.app.f.hfK);
    this.aeSI = new o()
    {
      public final void jjf() {}
      
      public final void jjg() {}
      
      public final void jjh() {}
      
      public final void jji() {}
      
      public final void jjj() {}
      
      public final void jjk()
      {
        AppMethodBeat.i(255374);
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        aq.c(aq.this).dead();
        if (aq.b(aq.this) != null) {
          ((l)aq.b(aq.this).cm(l.class)).b(this);
        }
        AppMethodBeat.o(255374);
      }
      
      public final void jjl() {}
    };
    this.aeSG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(255387);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        bz localbz = (bz)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbz.userName });
        zp localzp = new zp();
        localzp.icM.userName = localbz.userName;
        localzp.icM.icO = localbz.pageUrl;
        Map localMap = XmlParser.parseXml(localbz.hTm.field_content, "msg", null);
        localObject = "";
        paramAnonymousView = (View)localObject;
        if (localMap != null)
        {
          paramAnonymousView = (View)localObject;
          if (localMap.size() > 0)
          {
            localzp.icM.icP = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localzp.icM.icT = true;
        localzp.icM.scene = aq.afW(paramAnonymousView);
        localzp.icM.hzx = (localbz.hTm.field_msgSvrId + ":" + localbz.userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + paramAnonymousView);
        localzp.publish();
        aq.qb(aq.d(aq.this), aq.a(aq.this));
        com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), localbz.userName, Integer.valueOf(0) });
        aq.a(aq.this, 2, aq.b(aq.this).getTalkerUserName(), localbz.userName);
        aq.a(aq.this, 8, localbz.userName, 1, 0);
        aq.a(aq.this, 4, localMap, "");
        aq.a(aq.this, 6, localbz.hTm);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255387);
      }
    };
    this.yAH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = (bz)paramAnonymousView.getTag();
        Map localMap = XmlParser.parseXml(((com.tencent.mm.pluginsdk.ui.chat.c)localObject).hTm.field_content, "msg", null);
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
          localAppBrandStatObject.hzx = (((bz)localObject).hTm.field_msgSvrId + ":" + ((bz)localObject).userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(((bz)localObject).userName))
          {
            localAppBrandStatObject.scene = aq.afW(paramAnonymousView);
            ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(aq.b(aq.this).aezO.getContext(), str1, null, k, j, str2, localAppBrandStatObject);
            aq.qb(aq.d(aq.this), aq.a(aq.this));
            com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), ((bz)localObject).userName, Integer.valueOf(0) });
            aq.a(aq.this, 2, aq.b(aq.this).getTalkerUserName(), ((bz)localObject).userName);
            label428:
            paramAnonymousView = aq.this;
            str1 = ((bz)localObject).userName;
            if (i != 1) {
              break label660;
            }
          }
        }
        label660:
        for (i = 1;; i = 2)
        {
          aq.a(paramAnonymousView, 8, str1, i, 0);
          aq.a(aq.this, 4, localMap, "");
          aq.a(aq.this, 6, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).hTm);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37231);
          return;
          localAppBrandStatObject.scene = 1043;
          paramAnonymousView = com.tencent.mm.an.g.hU(((bz)localObject).userName);
          com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
          Activity localActivity = aq.b(aq.this).aezO.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localt.a(localActivity, str1, null, k, j, str2, localAppBrandStatObject, paramAnonymousView);
            break;
          }
          if (i != 2) {
            break label428;
          }
          str1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
          long l = Util.getLong((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
          aq.h(paramAnonymousView.getContext(), str1, l);
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str1, Long.valueOf(l) });
          break label428;
        }
      }
    };
    this.aeSH = new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 29	com/tencent/mm/hellhoundlib/b/b
        //   8: dup
        //   9: invokespecial 30	com/tencent/mm/hellhoundlib/b/b:<init>	()V
        //   12: astore 8
        //   14: aload 8
        //   16: aload_1
        //   17: invokevirtual 34	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
        //   20: ldc 36
        //   22: ldc 37
        //   24: ldc 38
        //   26: ldc 39
        //   28: aload_0
        //   29: aload 8
        //   31: invokevirtual 43	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
        //   34: invokestatic 49	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   37: aload_1
        //   38: invokevirtual 55	android/view/View:getTag	()Ljava/lang/Object;
        //   41: checkcast 57	com/tencent/mm/ui/chatting/viewitems/bz
        //   44: astore 9
        //   46: aload 9
        //   48: getfield 61	com/tencent/mm/ui/chatting/viewitems/bz:opType	I
        //   51: istore_2
        //   52: aload 9
        //   54: getfield 65	com/tencent/mm/ui/chatting/viewitems/bz:aeXW	Ljava/lang/String;
        //   57: astore 10
        //   59: ldc 67
        //   61: ldc 69
        //   63: iconst_2
        //   64: anewarray 4	java/lang/Object
        //   67: dup
        //   68: iconst_0
        //   69: aload 9
        //   71: getfield 61	com/tencent/mm/ui/chatting/viewitems/bz:opType	I
        //   74: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   77: aastore
        //   78: dup
        //   79: iconst_1
        //   80: aload 9
        //   82: getfield 65	com/tencent/mm/ui/chatting/viewitems/bz:aeXW	Ljava/lang/String;
        //   85: aastore
        //   86: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   89: iload_2
        //   90: iconst_3
        //   91: if_icmpne +331 -> 422
        //   94: aload 9
        //   96: getfield 86	com/tencent/mm/pluginsdk/ui/chat/c:hTm	Lcom/tencent/mm/storage/cc;
        //   99: getfield 91	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
        //   102: ldc 93
        //   104: aconst_null
        //   105: invokestatic 99	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   108: astore 11
        //   110: ldc 101
        //   112: astore 8
        //   114: aload 8
        //   116: astore_1
        //   117: aload 11
        //   119: ifnull +32 -> 151
        //   122: aload 8
        //   124: astore_1
        //   125: aload 11
        //   127: invokeinterface 107 1 0
        //   132: ifle +19 -> 151
        //   135: aload 11
        //   137: ldc 109
        //   139: invokeinterface 113 2 0
        //   144: checkcast 115	java/lang/String
        //   147: invokestatic 121	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   150: astore_1
        //   151: new 123	java/lang/StringBuilder
        //   154: dup
        //   155: invokespecial 124	java/lang/StringBuilder:<init>	()V
        //   158: aload 9
        //   160: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   163: getfield 129	com/tencent/mm/autogen/b/fi:field_msgSvrId	J
        //   166: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   169: ldc 135
        //   171: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   174: aload 9
        //   176: getfield 141	com/tencent/mm/ui/chatting/viewitems/bz:userName	Ljava/lang/String;
        //   179: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: ldc 135
        //   184: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: aload_0
        //   188: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   191: invokestatic 145	com/tencent/mm/ui/chatting/viewitems/aq:b	(Lcom/tencent/mm/ui/chatting/viewitems/aq;)Lcom/tencent/mm/ui/chatting/d/a;
        //   194: invokevirtual 151	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
        //   197: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: ldc 135
        //   202: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: aload_1
        //   206: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   209: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   212: astore_1
        //   213: aload_0
        //   214: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   217: invokestatic 145	com/tencent/mm/ui/chatting/viewitems/aq:b	(Lcom/tencent/mm/ui/chatting/viewitems/aq;)Lcom/tencent/mm/ui/chatting/d/a;
        //   220: getfield 158	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
        //   223: invokevirtual 164	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
        //   226: aload 10
        //   228: aload_1
        //   229: invokestatic 170	com/tencent/mm/plugin/sns/ad/d/a:O	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
        //   232: aload 9
        //   234: getfield 174	com/tencent/mm/ui/chatting/viewitems/bz:OMx	Landroid/os/Bundle;
        //   237: astore_1
        //   238: aload_1
        //   239: ifnull +84 -> 323
        //   242: aload_1
        //   243: ldc 176
        //   245: invokevirtual 182	android/os/Bundle:getInt	(Ljava/lang/String;)I
        //   248: istore_3
        //   249: iload_3
        //   250: iconst_1
        //   251: if_icmpne +459 -> 710
        //   254: aload_0
        //   255: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   258: astore 8
        //   260: aload 9
        //   262: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   265: ifnull +439 -> 704
        //   268: aload 9
        //   270: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   273: getfield 185	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
        //   276: astore_1
        //   277: aload 8
        //   279: iconst_2
        //   280: aload_1
        //   281: aload 9
        //   283: getfield 141	com/tencent/mm/ui/chatting/viewitems/bz:userName	Ljava/lang/String;
        //   286: invokestatic 189	com/tencent/mm/ui/chatting/viewitems/aq:a	(Lcom/tencent/mm/ui/chatting/viewitems/aq;ILjava/lang/String;Ljava/lang/String;)V
        //   289: aload 9
        //   291: getfield 192	com/tencent/mm/ui/chatting/viewitems/bz:aeXX	Ljava/lang/String;
        //   294: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   297: ifne +26 -> 323
        //   300: iconst_4
        //   301: aload 9
        //   303: getfield 192	com/tencent/mm/ui/chatting/viewitems/bz:aeXX	Ljava/lang/String;
        //   306: aload 9
        //   308: getfield 199	com/tencent/mm/ui/chatting/viewitems/bz:finderUsername	Ljava/lang/String;
        //   311: aload 9
        //   313: getfield 202	com/tencent/mm/ui/chatting/viewitems/bz:aeXY	Ljava/lang/String;
        //   316: ldc 101
        //   318: ldc 101
        //   320: invokestatic 205	com/tencent/mm/ui/chatting/viewitems/aq:b	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   323: aload_0
        //   324: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   327: astore_1
        //   328: aload 9
        //   330: getfield 141	com/tencent/mm/ui/chatting/viewitems/bz:userName	Ljava/lang/String;
        //   333: astore 8
        //   335: iload_2
        //   336: iconst_1
        //   337: if_icmpne +488 -> 825
        //   340: iconst_1
        //   341: istore_2
        //   342: aload_1
        //   343: bipush 8
        //   345: aload 8
        //   347: iload_2
        //   348: iconst_0
        //   349: invokestatic 208	com/tencent/mm/ui/chatting/viewitems/aq:a	(Lcom/tencent/mm/ui/chatting/viewitems/aq;ILjava/lang/String;II)V
        //   352: aload_0
        //   353: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   356: bipush 7
        //   358: aload 9
        //   360: getfield 86	com/tencent/mm/pluginsdk/ui/chat/c:hTm	Lcom/tencent/mm/storage/cc;
        //   363: invokestatic 211	com/tencent/mm/ui/chatting/viewitems/aq:a	(Lcom/tencent/mm/ui/chatting/viewitems/aq;ILcom/tencent/mm/storage/cc;)V
        //   366: aload_0
        //   367: ldc 36
        //   369: ldc 37
        //   371: ldc 38
        //   373: ldc 39
        //   375: invokestatic 214	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   378: ldc 21
        //   380: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   383: return
        //   384: astore_1
        //   385: ldc 67
        //   387: new 123	java/lang/StringBuilder
        //   390: dup
        //   391: ldc 219
        //   393: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   396: aload 10
        //   398: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   401: ldc 224
        //   403: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   406: aload_1
        //   407: invokevirtual 227	java/lang/Throwable:toString	()Ljava/lang/String;
        //   410: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   413: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   416: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   419: goto -187 -> 232
        //   422: iload_2
        //   423: iconst_4
        //   424: if_icmpne +171 -> 595
        //   427: new 233	com/tencent/mm/ad/i
        //   430: dup
        //   431: aload 9
        //   433: getfield 65	com/tencent/mm/ui/chatting/viewitems/bz:aeXW	Ljava/lang/String;
        //   436: invokespecial 234	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
        //   439: astore_1
        //   440: aload_1
        //   441: ldc 236
        //   443: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   446: invokestatic 245	com/tencent/mm/ae/d:FK	(Ljava/lang/String;)J
        //   449: lstore 4
        //   451: aload_1
        //   452: ldc 247
        //   454: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   457: invokestatic 245	com/tencent/mm/ae/d:FK	(Ljava/lang/String;)J
        //   460: lstore 6
        //   462: aload_1
        //   463: ldc 249
        //   465: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   468: astore 8
        //   470: aload_1
        //   471: ldc 251
        //   473: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   476: astore 10
        //   478: ldc 101
        //   480: astore_1
        //   481: aload 10
        //   483: invokestatic 257	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   486: ifne +19 -> 505
        //   489: new 233	com/tencent/mm/ad/i
        //   492: dup
        //   493: aload 10
        //   495: invokespecial 234	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
        //   498: ldc_w 259
        //   501: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   504: astore_1
        //   505: ldc_w 261
        //   508: invokestatic 267	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   511: checkcast 261	com/tencent/d/a/a/a/b
        //   514: aconst_null
        //   515: aload_0
        //   516: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   519: invokestatic 145	com/tencent/mm/ui/chatting/viewitems/aq:b	(Lcom/tencent/mm/ui/chatting/viewitems/aq;)Lcom/tencent/mm/ui/chatting/d/a;
        //   522: getfield 158	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
        //   525: invokevirtual 164	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
        //   528: lload 4
        //   530: lload 6
        //   532: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   535: ldc 101
        //   537: aload 8
        //   539: ldc 101
        //   541: ldc 101
        //   543: ldc 101
        //   545: ldc 101
        //   547: iconst_0
        //   548: ldc 101
        //   550: iconst_1
        //   551: iconst_1
        //   552: invokeinterface 276 16 0
        //   557: lload 4
        //   559: lload 6
        //   561: aload 9
        //   563: getfield 141	com/tencent/mm/ui/chatting/viewitems/bz:userName	Ljava/lang/String;
        //   566: aload 9
        //   568: getfield 279	com/tencent/mm/ui/chatting/viewitems/bz:position	I
        //   571: aload_1
        //   572: invokestatic 282	com/tencent/mm/ui/chatting/viewitems/aq:a	(JJLjava/lang/String;ILjava/lang/String;)V
        //   575: goto -343 -> 232
        //   578: astore_1
        //   579: ldc 67
        //   581: aload_1
        //   582: ldc_w 284
        //   585: iconst_0
        //   586: anewarray 4	java/lang/Object
        //   589: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   592: goto -360 -> 232
        //   595: iload_2
        //   596: iconst_5
        //   597: if_icmpne -365 -> 232
        //   600: new 233	com/tencent/mm/ad/i
        //   603: dup
        //   604: aload 9
        //   606: getfield 65	com/tencent/mm/ui/chatting/viewitems/bz:aeXW	Ljava/lang/String;
        //   609: invokespecial 234	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
        //   612: ldc_w 290
        //   615: invokevirtual 239	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   618: astore_1
        //   619: aload_1
        //   620: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   623: ifne -391 -> 232
        //   626: new 292	android/content/Intent
        //   629: dup
        //   630: invokespecial 293	android/content/Intent:<init>	()V
        //   633: astore 8
        //   635: aload 8
        //   637: ldc_w 295
        //   640: aload_1
        //   641: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   644: pop
        //   645: aload 8
        //   647: ldc_w 301
        //   650: iconst_1
        //   651: invokevirtual 304	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   654: pop
        //   655: ldc_w 261
        //   658: invokestatic 267	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
        //   661: checkcast 261	com/tencent/d/a/a/a/b
        //   664: aload_0
        //   665: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   668: invokestatic 145	com/tencent/mm/ui/chatting/viewitems/aq:b	(Lcom/tencent/mm/ui/chatting/viewitems/aq;)Lcom/tencent/mm/ui/chatting/d/a;
        //   671: getfield 158	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
        //   674: invokevirtual 164	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
        //   677: aload 8
        //   679: invokeinterface 308 3 0
        //   684: goto -452 -> 232
        //   687: astore_1
        //   688: ldc 67
        //   690: aload_1
        //   691: ldc_w 310
        //   694: iconst_0
        //   695: anewarray 4	java/lang/Object
        //   698: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   701: goto -469 -> 232
        //   704: ldc 101
        //   706: astore_1
        //   707: goto -430 -> 277
        //   710: iload_3
        //   711: iconst_2
        //   712: if_icmpne -389 -> 323
        //   715: aload_0
        //   716: getfield 16	com/tencent/mm/ui/chatting/viewitems/aq$39:aeTe	Lcom/tencent/mm/ui/chatting/viewitems/aq;
        //   719: astore 8
        //   721: aload 9
        //   723: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   726: ifnull +93 -> 819
        //   729: aload 9
        //   731: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   734: getfield 185	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
        //   737: astore_1
        //   738: aload 8
        //   740: iconst_3
        //   741: aload_1
        //   742: aload 9
        //   744: getfield 141	com/tencent/mm/ui/chatting/viewitems/bz:userName	Ljava/lang/String;
        //   747: invokestatic 189	com/tencent/mm/ui/chatting/viewitems/aq:a	(Lcom/tencent/mm/ui/chatting/viewitems/aq;ILjava/lang/String;Ljava/lang/String;)V
        //   750: aload 9
        //   752: getfield 192	com/tencent/mm/ui/chatting/viewitems/bz:aeXX	Ljava/lang/String;
        //   755: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   758: ifne +28 -> 786
        //   761: iconst_5
        //   762: aload 9
        //   764: getfield 192	com/tencent/mm/ui/chatting/viewitems/bz:aeXX	Ljava/lang/String;
        //   767: aload 9
        //   769: getfield 199	com/tencent/mm/ui/chatting/viewitems/bz:finderUsername	Ljava/lang/String;
        //   772: aconst_null
        //   773: aload 9
        //   775: getfield 313	com/tencent/mm/ui/chatting/viewitems/bz:extId	Ljava/lang/String;
        //   778: aload 9
        //   780: getfield 316	com/tencent/mm/ui/chatting/viewitems/bz:businessId	Ljava/lang/String;
        //   783: invokestatic 205	com/tencent/mm/ui/chatting/viewitems/aq:b	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   786: aload 9
        //   788: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   791: ifnull -468 -> 323
        //   794: aload 9
        //   796: getfield 319	com/tencent/mm/ui/chatting/viewitems/bz:aeYa	I
        //   799: iconst_1
        //   800: if_icmpne -477 -> 323
        //   803: aload 9
        //   805: getfield 125	com/tencent/mm/ui/chatting/viewitems/bz:hTm	Lcom/tencent/mm/storage/cc;
        //   808: aload 9
        //   810: getfield 322	com/tencent/mm/ui/chatting/viewitems/bz:aeXZ	I
        //   813: invokestatic 326	com/tencent/mm/ui/chatting/viewitems/aq:r	(Lcom/tencent/mm/storage/cc;I)V
        //   816: goto -493 -> 323
        //   819: ldc 101
        //   821: astore_1
        //   822: goto -84 -> 738
        //   825: iconst_2
        //   826: istore_2
        //   827: goto -485 -> 342
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	830	0	this	39
        //   0	830	1	paramAnonymousView	View
        //   51	776	2	i	int
        //   248	465	3	j	int
        //   449	109	4	l1	long
        //   460	100	6	l2	long
        //   12	727	8	localObject	Object
        //   44	765	9	localbz	bz
        //   57	437	10	str	String
        //   108	28	11	localMap	Map
        // Exception table:
        //   from	to	target	type
        //   94	110	384	finally
        //   125	151	384	finally
        //   151	232	384	finally
        //   427	478	578	finally
        //   481	505	578	finally
        //   505	575	578	finally
        //   600	684	687	finally
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(255346);
    if (!Util.isNullOrNil(paramString2)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(22516, new Object[] { Integer.valueOf(paramInt), paramString1, Integer.valueOf(i), paramString2, paramString3, paramString4, paramString5 });
      AppMethodBeat.o(255346);
      return;
    }
  }
  
  private static void a(int paramInt, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(255340);
    a(paramInt, paramMap, paramString, "", "");
    AppMethodBeat.o(255340);
  }
  
  private static void a(int paramInt, Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(255343);
    String str1 = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.transaction_id"), "");
    String str2 = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"), "");
    paramMap = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"), "");
    if (!Util.isNullOrNil(paramString2)) {
      paramMap = paramString2;
    }
    if (!Util.isNullOrNil(str1)) {
      a(paramInt, str1, str2, paramMap, paramString1, paramString3);
    }
    AppMethodBeat.o(255343);
  }
  
  private void a(View paramView, com.tencent.mm.storage.cc paramcc, Map<String, String> paramMap, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(255241);
    if (paramcc == null)
    {
      AppMethodBeat.o(255241);
      return;
    }
    if (!"notifymessage".equals(paramcc.field_talker))
    {
      AppMethodBeat.o(255241);
      return;
    }
    paramcc = (bz)paramView.getTag();
    paramcc.opType = paramInt1;
    paramcc.aeXW = paramString;
    paramString = new Bundle();
    paramString.putInt("click_area_type", paramInt2);
    paramcc.OMx = paramString;
    paramString = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.transaction_id"), "");
    if (!Util.isNullOrNil(paramString))
    {
      String str = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"), "");
      paramMap = Util.nullAs((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"), "");
      paramcc.aeXX = paramString;
      paramcc.finderUsername = str;
      paramcc.aeXY = paramMap;
    }
    paramView.setTag(paramcc);
    paramView.setOnClickListener(this.aeSH);
    AppMethodBeat.o(255241);
  }
  
  private void a(ImageView paramImageView, final com.tencent.mm.ui.chatting.d.a parama, final String paramString1, final com.tencent.mm.storage.cc paramcc, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(255225);
    if (paramImageView == null)
    {
      AppMethodBeat.o(255225);
      return;
    }
    if (ab.IV(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(255225);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(paramString1))
    {
      r.bKe().a(paramString2, paramImageView, this.aduK);
      paramImageView.setTag(new bz(paramcc, paramString1));
      paramImageView.setOnClickListener(this.aeMI);
    }
    for (;;)
    {
      paramImageView.setOnLongClickListener(f(parama));
      AppMethodBeat.o(255225);
      return;
      com.tencent.mm.pluginsdk.ui.a.b.h(paramImageView, paramString1);
      if (parama.juG()) {}
      for (paramString2 = parama.getTalkerUserName();; paramString2 = null)
      {
        paramImageView.setTag(new bz(paramString1, paramString2));
        if (!Util.getBoolean((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
          break label177;
        }
        paramImageView.setOnClickListener(null);
        break;
      }
      label177:
      paramImageView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255598);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = aq.this.e(parama);
          if (localObject != null) {
            ((v.b)localObject).onClick(paramAnonymousView);
          }
          aq.a(aq.this, 10, parama.getTalkerUserName(), paramString1);
          aq.a(aq.this, 4, paramcc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255598);
        }
      });
    }
  }
  
  private void a(com.tencent.mm.storage.cc paramcc, ce paramce, ISubscribeMsgService.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(255291);
    boolean bool1;
    if (!paramc.piu)
    {
      bool1 = true;
      boolean bool2 = paramc.piv;
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean), this.aeSM, this.aeSP, Boolean.valueOf(bool2) });
      paramce.aeYR.setVisibility(8);
      if ((!bool1) && ((!paramBoolean) || (bool2))) {
        break label190;
      }
      a(paramce, 0);
      localTextView = paramce.aeYS;
      localResources = this.aeiK.aezO.getMMResources();
      if (!paramBoolean) {
        break label182;
      }
    }
    label182:
    for (int i = R.l.gQJ;; i = R.l.gQD)
    {
      localTextView.setText(localResources.getString(i));
      paramce.aeYR.setTag(R.h.fPy, paramcc);
      if (!paramc.phY) {
        break label248;
      }
      paramce.aeYr.setVisibility(0);
      AppMethodBeat.o(255291);
      return;
      bool1 = false;
      break;
    }
    label190:
    a(paramce, 8);
    TextView localTextView = paramce.aeYS;
    Resources localResources = this.aeiK.aezO.getMMResources();
    if (paramBoolean) {}
    for (i = R.l.gQI;; i = R.l.gQf)
    {
      localTextView.setText(localResources.getString(i));
      break;
    }
    label248:
    paramce.aeYr.setVisibility(8);
    AppMethodBeat.o(255291);
  }
  
  private void a(bw parambw, Map<String, String> paramMap)
  {
    AppMethodBeat.i(255252);
    String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
    a(parambw, com.tencent.mm.pluginsdk.ui.span.p.b(this.aeiK.aezO.getContext(), paramMap, parambw.userTV.getTextSize()));
    parambw.avatarIV.setTag(null);
    parambw.avatarIV.setOnClickListener(null);
    r.bKe().a(str, parambw.avatarIV, this.aduK);
    AppMethodBeat.o(255252);
  }
  
  private void a(bw parambw, Map<String, String> paramMap, final com.tencent.mm.storage.cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255229);
    Object localObject1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
    Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
    label152:
    Object localObject2;
    String str;
    label240:
    Object localObject3;
    Object localObject4;
    if (i == 1)
    {
      a(parambw, paramMap);
      Log.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { paramcc.field_talker });
      if ((!"notifymessage".equals(paramcc.field_talker)) && (i != 1)) {
        break label808;
      }
      parambw.aeXD.aeXI.setVisibility(0);
      parambw.aeXD.mll.setTextSize(0, com.tencent.mm.cd.a.br(parambw.aeXD.mll.getContext(), R.f.NormalTextSize));
      parambw.aeXD.vJU.setVisibility(0);
      localObject2 = aq.c.cM(paramMap);
      parambw.aeXD.mll.setText(((aq.c)localObject2).title);
      ar.a(parambw.aeXD.aeXL, paramMap);
      str = null;
      if (!Util.isNullOrNil((String)localObject1))
      {
        bh.bCz();
        str = com.tencent.mm.model.c.bzA().JE((String)localObject1).aSU();
      }
      if (Util.isNullOrNil(((aq.c)localObject2).url)) {
        break label851;
      }
      i = 1;
      int j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
      localObject3 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
      if (((q)this.aeiK.cm(q.class)).jrQ())
      {
        if (!aDq(j)) {
          break label857;
        }
        if (parambw.aeXD.vJU != null) {
          parambw.aeXD.vJU.setBackgroundResource(R.g.fnE);
        }
        if ((parambw.aeXD.aeXL != null) && (parambw.aeXD.aeXL.getVisibility() == 0))
        {
          parambw.aeXD.aeXL.setBackgroundResource(R.g.chatting_item_dyeing_line_data_bg);
          localObject4 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.digest");
          parambw.aeXD.aeXL.setTag(new b((String)localObject4));
          parambw.aeXD.aeXL.setOnLongClickListener(o(this.aeiK));
          parambw.aeXD.aeXL.setOnClickListener(jxx());
        }
      }
      label425:
      if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject3))) {
        break label972;
      }
      localObject1 = new bz(paramcc, (String)localObject1, ((aq.c)localObject2).url);
      ((bz)localObject1).position = paramInt;
      parambw.aeXD.vJU.setTag(localObject1);
      parambw.aeXD.vJU.setOnClickListener(this.yAH);
      i = 1;
      label492:
      if (!((q)this.aeiK.cm(q.class)).zQ(paramcc.field_msgId)) {
        parambw.aeXD.vJU.setOnLongClickListener(c(this.aeiK));
      }
      parambw.aeXD.vJU.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
      if (i != 0) {
        break label1104;
      }
      parambw.aeXD.aeXM.setVisibility(8);
      parambw.aeXD.DTW.setVisibility(8);
    }
    for (;;)
    {
      if (com.tencent.mm.k.i.aRD().aRs())
      {
        parambw.aeNu.setVisibility(0);
        c(this.aeiK, parambw.aeNu, new v.o(((aq.c)localObject2).nSg, paramcc, str));
      }
      a(parambw.aeXD, paramMap, paramcc);
      AppMethodBeat.o(255229);
      return;
      a(parambw, this.aeiK, paramcc, (String)localObject1);
      a(parambw.avatarIV, this.aeiK, (String)localObject1, paramcc, null, paramMap);
      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh((String)localObject1))
      {
        parambw.aeXD.aeXI.setTag(new bz(paramcc, (String)localObject1));
        parambw.aeXD.aeXI.setOnClickListener(this.aeMI);
        break;
      }
      localObject2 = parambw.aeXD.aeXI;
      if (this.aeiK.juG()) {}
      for (str = this.aeiK.getTalkerUserName();; str = null)
      {
        ((View)localObject2).setTag(new bz((String)localObject1, str));
        parambw.aeXD.aeXI.setOnClickListener(e(this.aeiK));
        break;
      }
      label808:
      parambw.aeXD.aeXI.setVisibility(8);
      parambw.aeXD.mll.setTextSize(0, com.tencent.mm.cd.a.br(parambw.aeXD.mll.getContext(), R.f.ActionBarTextSize));
      break label152;
      label851:
      i = 0;
      break label240;
      label857:
      if (parambw.aeXD.vJU != null) {
        parambw.aeXD.vJU.setBackgroundResource(R.g.fnG);
      }
      if ((parambw.aeXD.aeXL == null) || (parambw.aeXD.aeXL.getVisibility() != 0)) {
        break label425;
      }
      parambw.aeXD.aeXL.setTag(null);
      parambw.aeXD.aeXL.setOnLongClickListener(null);
      parambw.aeXD.aeXL.setOnClickListener(null);
      if (com.tencent.mm.compatible.util.d.rb(16))
      {
        parambw.aeXD.aeXL.setBackground(null);
        break label425;
      }
      parambw.aeXD.aeXL.setBackgroundDrawable(null);
      break label425;
      label972:
      if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(((aq.c)localObject2).url)) {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(((aq.c)localObject2).url, -1, 2, new Object[0]);
      }
      localObject3 = parambw.aeXD.vJU;
      localObject4 = new bz(paramcc, false, paramInt, ((aq.c)localObject2).url, false, this.aeiK.jrh(), (String)localObject1, str, ((aq.c)localObject2).title);
      ((bz)localObject4).ihx = ((aq.c)localObject2).ihx;
      ((View)localObject3).setTag(localObject4);
      parambw.aeXD.vJU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37213);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = aq.this.h(aq.b(aq.this));
          if (localObject != null) {
            ((v.p)localObject).onClick(paramAnonymousView);
          }
          if (aq.i(aq.this)) {
            aq.a(aq.this, 8, this.XjR, 2, 0);
          }
          aq.a(aq.this, 6, paramcc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37213);
        }
      });
      break label492;
      label1104:
      parambw.aeXD.aeXM.setVisibility(0);
      parambw.aeXD.DTW.setVisibility(0);
    }
  }
  
  private void a(bw parambw, final Map<String, String> paramMap, final com.tencent.mm.storage.cc paramcc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255237);
    ce localce = parambw.aeXE;
    a(localce, paramMap, paramcc);
    a(localce, paramMap, paramInt2);
    d(localce, paramMap, paramcc);
    a(localce, paramMap);
    b(localce, paramMap);
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
    final String str2;
    String str1;
    Object localObject3;
    Object localObject1;
    String str4;
    String str3;
    if (i == 2)
    {
      c(localce, paramMap);
      a(localce, paramcc, paramMap);
      str2 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
      str1 = null;
      if (!Util.isNullOrNil(str2))
      {
        bh.bCz();
        str1 = com.tencent.mm.model.c.bzA().JE(str2).aSU();
      }
      localObject3 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.title");
      localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.url");
      str4 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url");
      str3 = (String)paramMap.get(".msg.appmsg.template_id");
      localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
      paramInt2 = 0;
      if ((i != 3) && (i != 4) && (i != 5)) {
        break label590;
      }
      localObject1 = new bz(paramcc, str2);
      ((bz)localObject1).position = paramInt1;
      localce.aeYg.setTag(localObject1);
      localObject1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.category.item.general_string"));
      a(localce.aeYg, paramcc, paramMap, i, (String)localObject1, 1);
      b(i, paramMap, str2);
      localObject1 = "";
      paramInt1 = 3;
    }
    for (;;)
    {
      if (localce.aeZb)
      {
        if (localce.aeYY != null)
        {
          localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_detail_word");
          paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_detail_url");
          if (Util.isNullOrNil((String)localObject2)) {
            break label979;
          }
          localce.aeYZ.setText((CharSequence)localObject2);
          localce.aeYY.setVisibility(0);
        }
        label372:
        if (localce.aeZa != null)
        {
          localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_middle_tips_word");
          if (Util.isNullOrNil((String)localObject2)) {
            break label992;
          }
          localce.aeZa.setText((CharSequence)localObject2);
          localce.aeZa.setVisibility(0);
        }
      }
      label421:
      if (!((q)this.aeiK.cm(q.class)).zQ(paramcc.field_msgId)) {
        localce.aeYg.setOnLongClickListener(c(this.aeiK));
      }
      localce.aeYg.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
      if (com.tencent.mm.k.i.aRD().aRs())
      {
        parambw.aeNu.setVisibility(0);
        c(this.aeiK, parambw.aeNu, new v.o(str3, paramcc, str1));
      }
      a(1, paramMap, "");
      b(localce, paramMap, paramcc);
      this.aeSX.jumpType = paramInt1;
      this.aeSX.Rc((String)localObject1);
      ae(1, paramcc.field_talker, str2);
      AppMethodBeat.o(255237);
      return;
      d(localce, paramMap);
      break;
      label590:
      if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = new bz(paramcc, str2, (String)localObject1);
        ((bz)localObject1).position = paramInt1;
        localce.aeYg.setTag(localObject1);
        localce.aeYg.setOnClickListener(this.yAH);
        localObject1 = Util.nullAs((String)localObject2, "");
        paramInt1 = 2;
      }
      else if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str2)))
      {
        localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
        localObject2 = localce.aeYg;
        localObject3 = new bz(paramcc, false, paramInt1, str2, false, this.aeiK.jrh(), str2, str1, (String)localObject3);
        ((bz)localObject3).ihx = str4;
        ((bz)localObject3).pageUrl = ((String)localObject1);
        ((View)localObject2).setTag(localObject3);
        localce.aeYg.setOnClickListener(this.aeSG);
        localObject1 = Util.nullAs(str2, "");
        paramInt1 = 2;
      }
      else
      {
        if (i != 2) {
          break label848;
        }
        localObject1 = new bz(paramcc, str2, (String)localObject1);
        ((bz)localObject1).position = paramInt1;
        localce.aeYg.setTag(localObject1);
        localce.aeYg.setOnClickListener(this.yAH);
        localObject1 = "";
        paramInt1 = paramInt2;
      }
    }
    label848:
    Object localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_detail_url");
    if (!Util.isNullOrNil((String)localObject2)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localce.aeYg;
      localObject3 = new bz(paramcc, false, paramInt1, (String)localObject1, false, this.aeiK.jrh(), str2, str1, (String)localObject3);
      ((bz)localObject3).ihx = str4;
      ((View)localObject2).setTag(localObject3);
      localce.aeYg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169886);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = aq.this.h(aq.b(aq.this));
          if (localObject != null) {
            ((v.p)localObject).onClick(paramAnonymousView);
          }
          aq.a(aq.this, 2, paramcc.field_talker, str2);
          aq.a(aq.this, 8, str2, 2, 0);
          aq.a(aq.this, 4, paramMap, "");
          aq.a(aq.this, 6, paramcc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169886);
        }
      });
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = Util.nullAs((String)localObject1, "");
        paramInt1 = 1;
        break;
      }
      localObject1 = "";
      paramInt1 = 0;
      break;
      label979:
      localce.aeYY.setVisibility(8);
      break label372;
      label992:
      localce.aeZa.setVisibility(8);
      break label421;
    }
  }
  
  private void a(by paramby, Map<String, String> paramMap, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255259);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.show_complaint_button"), 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
      paramby.aeXJ.setTag(null);
      paramby.aeXK.setTag(null);
      paramby.aeXJ.setVisibility(8);
      paramby.aeXK.setVisibility(8);
      AppMethodBeat.o(255259);
      return;
    }
    if (paramby.aeXI.getVisibility() == 0)
    {
      paramby.aeXJ.setTag(paramcc);
      paramby.aeXJ.setOnClickListener(this.aeSF);
      paramby.aeXJ.setVisibility(0);
      paramby.aeXK.setVisibility(8);
      AppMethodBeat.o(255259);
      return;
    }
    paramby.aeXK.setTag(paramcc);
    paramby.aeXK.setOnClickListener(this.aeSF);
    paramby.aeXK.setVisibility(0);
    paramby.aeXJ.setVisibility(8);
    AppMethodBeat.o(255259);
  }
  
  private void a(final ce paramce)
  {
    AppMethodBeat.i(255223);
    this.aeSE = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(255220);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = (com.tencent.mm.storage.cc)paramAnonymousView.getTag(R.h.fQi);
        if (localObject == null)
        {
          Log.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255220);
          return;
        }
        final Map localMap = XmlParser.parseXml(((fi)localObject).field_content, "msg", null);
        if ((localMap == null) || (localMap.size() == 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255220);
          return;
        }
        final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
        final boolean bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str);
        aq.a(aq.this, new com.tencent.mm.ui.widget.a.f(paramAnonymousView.getContext(), 1, false));
        aq.e(aq.this).Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(255366);
            paramAnonymous2s.clear();
            aq.a(aq.this, this.oiL, localMap, aq.e(aq.this), paramAnonymous2s, aq.f(aq.this));
            if (bool) {}
            for (String str = paramAnonymousView.getResources().getString(R.l.gQq);; str = paramAnonymousView.getResources().getString(R.l.gQo))
            {
              paramAnonymous2s.add(0, 2, 0, str);
              AppMethodBeat.o(255366);
              return;
            }
          }
        };
        aq.e(aq.this).GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(255362);
            int j = paramAnonymous2MenuItem.getItemId();
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected. msgId: %s, v: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymous2Int), Long.valueOf(this.oiL.field_msgId), paramAnonymousView });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              if (aq.i(aq.this))
              {
                paramAnonymous2Int = 0;
                if (j != 2) {
                  break label702;
                }
                paramAnonymous2Int = 1;
              }
              break;
            }
            for (;;)
            {
              aq.a(aq.this, 9, str, 0, paramAnonymous2Int);
              AppMethodBeat.o(255362);
              return;
              aq.a(aq.this, paramAnonymousView, this.oiL, localMap, str);
              break;
              if (!aq.g(aq.this))
              {
                Log.e("MicroMsg.ChattingItemDyeingTemplate", "checkNetwork no network");
                break;
              }
              boolean bool1 = aq.a(aq.this, localMap);
              boolean bool2 = aq.f(aq.this).piv;
              aq.a(aq.this, 8, this.oiL.field_talker, str);
              paramAnonymous2MenuItem = com.tencent.mm.msgsubscription.c.a.pjH;
              paramAnonymous2MenuItem = str;
              String str1 = aq.a(aq.this);
              String str2 = aq.h(aq.this);
              if (bool) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 2)
              {
                com.tencent.mm.msgsubscription.c.a.a(paramAnonymous2MenuItem, 1, str1, 1, str2, paramAnonymous2Int);
                if (!bool1) {
                  break label351;
                }
                aq.a(aq.this, localMap, true, bool2, aq.40.this.aeTo, str, bool);
                break;
              }
              label351:
              aq.a(aq.this, aq.40.this.aeTo, str, this.oiL);
              break;
              if (!aq.g(aq.this))
              {
                Log.e("MicroMsg.ChattingItemDyeingTemplate", "checkNetwork no network");
                break;
              }
              bool1 = aq.a(aq.this, localMap);
              bool2 = aq.f(aq.this).piv;
              if (bool1) {
                if (!bool2)
                {
                  paramAnonymous2Int = 2;
                  aq.a(aq.this, bool, str);
                  label463:
                  aq.a(aq.this, 9, this.oiL.field_talker, str);
                  paramAnonymous2MenuItem = com.tencent.mm.msgsubscription.c.a.pjH;
                  paramAnonymous2MenuItem = str;
                  str1 = aq.a(aq.this);
                  str2 = aq.h(aq.this);
                  if (!bool) {
                    break label598;
                  }
                }
              }
              label598:
              for (int i = 1;; i = 2)
              {
                com.tencent.mm.msgsubscription.c.a.a(paramAnonymous2MenuItem, paramAnonymous2Int, str1, 0, str2, i);
                break;
                aq.a(aq.this, localMap, false, true, aq.40.this.aeTo, str, bool);
                paramAnonymous2Int = 1;
                break label463;
                paramAnonymous2Int = 2;
                aq.a(aq.this, true, str);
                break label463;
              }
              if (!aq.a(aq.this, localMap)) {
                break;
              }
              if (!aq.f(aq.this).piv)
              {
                aq.a(aq.this, true, str);
                break;
              }
              bool1 = aq.f(aq.this).phu;
              aq.a(aq.this, bool1, str, localMap, aq.f(aq.this));
              break;
              label702:
              if (j == 1) {
                paramAnonymous2Int = 2;
              } else if (j == 0) {
                paramAnonymous2Int = 3;
              }
            }
          }
        };
        aq.e(aq.this).dDn();
        aq.a(aq.this, 4, ((fi)localObject).field_talker, str);
        aq.a(aq.this, 5, (com.tencent.mm.storage.cc)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255220);
      }
    };
    paramce.aeYo.setOnClickListener(this.aeSE);
    AppMethodBeat.o(255223);
  }
  
  private void a(ce paramce, int paramInt)
  {
    AppMethodBeat.i(255351);
    boolean bool = this.aeSZ;
    if (this.aeSR)
    {
      paramce.aeYm.setVisibility(8);
      if (this.aeSQ)
      {
        ViewGroup.LayoutParams localLayoutParams = paramce.aeYq.getLayoutParams();
        if (paramInt == 0)
        {
          paramce.aeYs.setVisibility(paramInt);
          paramce.aeYs.measure(0, 0);
          int i = this.sJv;
          int j = aeSV.intValue();
          int k = aeSU.intValue();
          int m = paramce.aeYs.getMeasuredWidth();
          if (bool) {}
          for (paramInt = aeSW.intValue();; paramInt = 0)
          {
            this.aeST = (i - j * 4 - k - m - paramInt);
            Log.v("MicroMsg.ChattingItemDyeingTemplate", "setBanViewVisibility screenWidth: %s, size8Dp: %s, 16dp: %s, 32dp: %s, templateTitleMeasuredWith: %s, templateTitleMaxWidth: %s, ban.width: %s", new Object[] { Integer.valueOf(this.sJv), aeSU, aeSV, aeSW, Integer.valueOf(this.aeSS), Integer.valueOf(this.aeST), Integer.valueOf(paramce.aeYs.getMeasuredWidth()) });
            if (this.aeSS <= this.aeST) {
              break;
            }
            if (localLayoutParams.width == this.aeST) {
              break label353;
            }
            localLayoutParams.width = this.aeST;
            paramce.aeYq.setEllipsize(TextUtils.TruncateAt.END);
            paramce.aeYq.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(255351);
            return;
          }
          paramce.aeYq.setEllipsize(null);
          if (localLayoutParams.width != this.aeSS)
          {
            localLayoutParams.width = this.aeSS;
            paramce.aeYq.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(255351);
          }
        }
        else
        {
          paramce.aeYs.setVisibility(paramInt);
          paramce.aeYq.setEllipsize(TextUtils.TruncateAt.END);
          if (localLayoutParams.width != -2)
          {
            localLayoutParams.width = -2;
            paramce.aeYq.setLayoutParams(localLayoutParams);
          }
        }
        label353:
        AppMethodBeat.o(255351);
        return;
      }
      paramce.aeYs.setVisibility(8);
      b(paramce, paramInt);
      AppMethodBeat.o(255351);
      return;
    }
    paramce.aeYq.setEllipsize(null);
    paramce.aeYs.setVisibility(8);
    b(paramce, paramInt);
    AppMethodBeat.o(255351);
  }
  
  private void a(final ce paramce, final com.tencent.mm.storage.cc paramcc, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0)
    {
      paramce.aeYO.setVisibility(8);
      paramce.aeYD.setVisibility(8);
      paramce.aeYF.setVisibility(8);
      paramce.aeYE.setVisibility(0);
      paramce.aeYC.setVisibility(0);
      b(paramce, paramcc, paramMap);
      AppMethodBeat.o(37251);
      return;
    }
    paramce.aeYE.setVisibility(8);
    Object localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
    final String str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
    boolean bool = i(paramMap, 0);
    final int i;
    final String str3;
    final String str2;
    Object localObject2;
    if ((!Util.isNullOrNil((String)localObject1)) && (!bool))
    {
      i = aw.mx(d(paramMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
      paramce.aeYJ.setTextColor(i);
      paramce.aeYJ.setText((CharSequence)localObject1);
      if (Util.isNullOrNil(str1))
      {
        paramce.aeYL.setVisibility(8);
        paramce.aeYJ.setPadding(0, 0, 0, 0);
        str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
        localObject1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
        str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
        localObject2 = new bz(paramcc, (String)localObject1, str3);
        paramce.aeYG.setTag(localObject2);
        paramce.aeYO.setTag(localObject2);
        if ((i != 3) && (i != 4) && (i != 5)) {
          break label976;
        }
        localObject1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.general_string"));
        a(paramce.aeYG, paramcc, paramMap, i, (String)localObject1, 2);
        label361:
        paramce.aeYG.setVisibility(0);
        label369:
        str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
        localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
        bool = i(paramMap, 1);
        if ((Util.isNullOrNil(str2)) || (bool)) {
          break label1318;
        }
        i = aw.mx(d(paramMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
        paramce.aeYK.setTextColor(i);
        paramce.aeYK.setText(str2);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1138;
        }
        paramce.aeYM.setVisibility(8);
        paramce.aeYK.setPadding(0, 0, 0, 0);
        label494:
        localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
        str2 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
        str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
        paramce.aeYH.setTag(new bz(paramcc, str2, (String)localObject2));
        if ((i != 3) && (i != 4) && (i != 5)) {
          break label1187;
        }
        str2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.general_string"));
        a(paramce.aeYH, paramcc, paramMap, i, str2, 2);
        label626:
        paramce.aeYH.setVisibility(0);
        label634:
        paramce.aeYN.setVisibility(8);
        if ((paramce.aeYG.getVisibility() != 8) || (paramce.aeYH.getVisibility() != 8)) {
          break label1330;
        }
        paramce.aeYD.setVisibility(8);
        paramce.aeYC.setVisibility(8);
        paramce.aeYF.setVisibility(8);
        if ((paramce.aeYG.getVisibility() != 0) || (paramce.aeYH.getVisibility() != 0)) {
          break label1593;
        }
        paramce.aeYI.setVisibility(0);
        label722:
        paramcc = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
        str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
        if ((au.Hh(paramcc)) || (paramce.aeYG.getVisibility() == 8) || (paramce.aeYH.getVisibility() != 8) || (i != 1) || (!au.Hh(str1))) {
          break label1623;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(str1);
        if (localObject1 != null) {
          break label1605;
        }
        paramcc = null;
        label840:
        if (localObject1 != null) {
          break label1614;
        }
      }
    }
    label1187:
    label1318:
    label1330:
    label1593:
    label1605:
    label1614:
    for (paramMap = str1;; paramMap = ((WxaAttributes)localObject1).field_nickname)
    {
      r.bKe().a(paramcc, paramce.aeYP, this.aduK);
      paramce.aeYQ.setText(paramMap);
      if (localObject1 == null) {
        ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(str1, new s.a()
        {
          public final void onGetWeAppInfo(WxaAttributes paramAnonymousWxaAttributes)
          {
            AppMethodBeat.i(255370);
            if (paramAnonymousWxaAttributes == null)
            {
              AppMethodBeat.o(255370);
              return;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(255583);
                r.bKe().a(this.xMa, aq.30.this.aeTo.aeYP, aq.p(aq.this));
                if (TextUtils.isEmpty(this.qfz)) {}
                for (String str = aq.30.this.aeTz;; str = this.qfz)
                {
                  aq.30.this.aeTo.aeYQ.setText(str);
                  AppMethodBeat.o(255583);
                  return;
                }
              }
            });
            AppMethodBeat.o(255370);
          }
        });
      }
      paramce.aeYO.setVisibility(0);
      paramce.aeYD.setVisibility(8);
      AppMethodBeat.o(37251);
      return;
      paramce.aeYL.setVisibility(0);
      c(paramce.aeYL, str1, 42, 42);
      paramce.aeYJ.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 16), 0);
      break;
      label976:
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
            AppMethodBeat.i(255508);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            localObject = (bz)paramAnonymousView.getTag();
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.hzx = (((bz)localObject).hTm.field_msgSvrId + ":" + ((bz)localObject).userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + this.aePk);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(((bz)localObject).userName))
            {
              localAppBrandStatObject.scene = aq.afW(this.aePk);
              ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(aq.b(aq.this).aezO.getContext(), str2, null, j, i, str3, localAppBrandStatObject);
              aq.qb(aq.d(aq.this), aq.a(aq.this));
              com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), this.XjR, Integer.valueOf(1) });
              aq.a(aq.this, 7, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).hTm);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(255508);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.an.g.hU(((bz)localObject).userName);
            com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
            Activity localActivity = aq.b(aq.this).aezO.getContext();
            String str1 = str2;
            int i = j;
            int j = i;
            String str2 = str3;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localt.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        };
        paramce.aeYG.setOnClickListener((View.OnClickListener)localObject1);
        paramce.aeYO.setOnClickListener((View.OnClickListener)localObject1);
        break label361;
      }
      paramce.aeYG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255488);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!Util.isNullOrNil(str3))
          {
            paramAnonymousView = (bz)paramAnonymousView.getTag();
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", str3);
            ((Intent)localObject).putExtra("geta8key_username", this.XjR);
            ((Intent)localObject).putExtra("key_enable_teen_mode_check", true);
            c.s((Intent)localObject, aq.b(aq.this).getTalkerUserName());
            com.tencent.mm.br.c.b(aq.b(aq.this).aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), this.XjR, Integer.valueOf(1) });
            aq.a(aq.this, 7, paramAnonymousView.hTm);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255488);
        }
      });
      paramce.aeYO.setOnClickListener(null);
      break label361;
      paramce.aeYG.setVisibility(8);
      break label369;
      label1138:
      paramce.aeYM.setVisibility(0);
      c(paramce.aeYM, (String)localObject1, 42, 42);
      paramce.aeYK.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 16), 0);
      break label494;
      if ((i == 1) && (!TextUtils.isEmpty(str3)))
      {
        paramcc = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
        i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
        j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
        localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
        paramce.aeYH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(255495);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            localObject = (bz)paramAnonymousView.getTag();
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str3 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.hzx = (((bz)localObject).hTm.field_msgSvrId + ":" + ((bz)localObject).userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + this.aePk);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(((bz)localObject).userName))
            {
              localAppBrandStatObject.scene = aq.afW(this.aePk);
              ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(aq.b(aq.this).aezO.getContext(), str3, null, j, i, paramcc, localAppBrandStatObject);
              aq.qb(aq.d(aq.this), aq.a(aq.this));
              com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), str2, Integer.valueOf(2) });
              aq.a(aq.this, 7, ((com.tencent.mm.pluginsdk.ui.chat.c)localObject).hTm);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(255495);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.an.g.hU(((bz)localObject).userName);
            com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
            Activity localActivity = aq.b(aq.this).aezO.getContext();
            String str1 = str3;
            int i = j;
            int j = i;
            String str2 = paramcc;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localt.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        });
        break label626;
      }
      paramce.aeYH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255525);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!Util.isNullOrNil(this.val$url))
          {
            paramAnonymousView = (bz)paramAnonymousView.getTag();
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.val$url);
            ((Intent)localObject).putExtra("key_enable_teen_mode_check", true);
            c.s((Intent)localObject, aq.b(aq.this).getTalkerUserName());
            com.tencent.mm.br.c.b(aq.b(aq.this).aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), str2, Integer.valueOf(2) });
            aq.a(aq.this, 7, paramAnonymousView.hTm);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255525);
        }
      });
      break label626;
      paramce.aeYH.setVisibility(8);
      break label634;
      paramce.aeYF.setVisibility(0);
      i = this.aeiK.aezO.getMMResources().getDimensionPixelOffset(R.f.LargePadding);
      if ((paramce.aeYG.getVisibility() == 0) && (paramce.aeYH.getVisibility() == 0))
      {
        paramce.aeYG.setGravity(17);
        paramce.aeYH.setGravity(17);
        paramce.aeYG.setPadding(i, 0, i, 0);
        paramce.aeYH.setPadding(i, 0, i, 0);
      }
      for (;;)
      {
        paramce.aeYD.setVisibility(0);
        paramce.aeYC.setVisibility(0);
        break;
        if (paramce.aeYG.getVisibility() == 0)
        {
          if (Util.isNullOrNil(str1))
          {
            paramce.aeYG.setGravity(19);
            paramce.aeYG.setPadding(i, 0, 0, 0);
            paramce.aeYN.setVisibility(0);
          }
          else
          {
            paramce.aeYG.setGravity(17);
            paramce.aeYG.setPadding(i, 0, i, 0);
          }
        }
        else if (Util.isNullOrNil((String)localObject1))
        {
          paramce.aeYH.setGravity(19);
          paramce.aeYH.setPadding(this.aeiK.aezO.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0, 0);
          paramce.aeYN.setVisibility(0);
        }
        else
        {
          paramce.aeYH.setGravity(17);
          paramce.aeYH.setPadding(i, 0, i, 0);
        }
      }
      paramce.aeYI.setVisibility(8);
      break label722;
      paramcc = ((WxaAttributes)localObject1).field_brandIconURL;
      break label840;
    }
    label1623:
    paramce.aeYO.setVisibility(8);
    AppMethodBeat.o(37251);
  }
  
  private void a(ce paramce, final String paramString1, String paramString2, final Map<String, String> paramMap, com.tencent.mm.storage.cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    paramce.aeYl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.aeiK.aezO.getContext(), paramString2, paramce.aeYl.getTextSize()));
    r.bKe().a(paramString1, paramce.aeYk, this.aduK);
    paramce.aeYk.setTag(null);
    paramce.aeYk.setOnClickListener(null);
    paramce.aeYj.setTag(null);
    paramce.aeYj.setOnClickListener(null);
    paramce.aeYj.setVisibility(0);
    int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_type"), -1);
    if (i == -1)
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
      paramString2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
      if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        paramce.aeYj.setTag(new bz(paramcc, paramString1));
        paramce.aeYj.setOnClickListener(this.aeSJ);
      }
    }
    for (;;)
    {
      paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (Util.isNullOrNil(paramString1))) {
        break;
      }
      ((View)paramce.aeYn.getParent()).setVisibility(0);
      r.bKe().a(paramString1, paramce.aeYn, this.aduK);
      AppMethodBeat.o(37247);
      return;
      if ((i == 1) || (i == 2))
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        paramce.aeYj.setTag(new bz(paramcc, paramString1));
        paramce.aeYj.setOnClickListener(this.aeSJ);
      }
      else if (i == 3)
      {
        paramString1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_user_name"));
        paramce.aeYj.setTag(new bz(paramcc, paramString1));
        paramce.aeYj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(255631);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().G(aq.b(aq.this).aezO.getContext(), paramString1, com.tencent.mm.plugin.wallet_core.utils.m.asD(2));
            aq.a(aq.this, 2, paramMap, "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255631);
          }
        });
      }
      else
      {
        paramce.aeYj.setTag(null);
        paramce.aeYj.setOnClickListener(null);
      }
    }
    ((View)paramce.aeYn.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(ce paramce, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37250);
    int i;
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_finder_feed_entry"), 0) == 1)
    {
      i = 1;
      if (i == 0) {
        break label238;
      }
      String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feed_thumnail"));
      i = aw.bf(this.aeiK.aezO.getContext()).x - com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 64);
      int j = (int)(i / 1.7525F);
      ViewGroup.LayoutParams localLayoutParams = paramce.aeYh.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = i;
        localLayoutParams.height = j;
        paramce.aeYh.setLayoutParams(localLayoutParams);
      }
      c(paramce.aeYh, str, i, j);
      paramce.aeYh.setVisibility(0);
      paramce.aeYh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255494);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_feedid"));
          localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.finder_nonceid"));
          ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().h(aq.b(aq.this).aezO.getContext(), paramAnonymousView, (String)localObject, com.tencent.mm.plugin.wallet_core.utils.m.asD(2));
          aq.a(aq.this, 3, paramMap, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255494);
        }
      });
      if (com.tencent.mm.compatible.util.d.rb(23)) {
        paramce.aeYh.setForeground(this.aeiK.aezO.getContext().getDrawable(R.g.fnD));
      }
      paramce.aeYi.setVisibility(0);
    }
    for (;;)
    {
      paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      paramce.aeYt.setText(paramMap);
      AppMethodBeat.o(37250);
      return;
      i = 0;
      break;
      label238:
      paramce.aeYh.setImageBitmap(null);
      paramce.aeYi.setVisibility(8);
    }
  }
  
  private void a(ce paramce, Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(255295);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {}
    for (int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      int j = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      paramce.aeYq.setVisibility(8);
      if ((i == 0) && (j == 0))
      {
        this.aeSQ = true;
        paramce.aeYq.setVisibility(0);
        this.aeSP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = d(paramMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        paramce.aeYq.setTextColor(aw.mx(k));
        paramce.aeYq.setText(this.aeSP);
        paramce.aeYq.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.aeSS = paramce.aeYq.getMeasuredWidth();
      }
      String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      int k = d(paramMap, ".msg.appmsg.mmreader.template_header.first_color", aeTb);
      if (Util.isNullOrNil(str)) {
        paramce.aeYt.setVisibility(8);
      }
      while ((i != 0) && (Util.isNullOrNil(str)))
      {
        paramce.aeYu.setVisibility(8);
        AppMethodBeat.o(255295);
        return;
        paramce.aeYt.setTextColor(aw.mx(k));
        paramce.aeYt.setText(str);
        paramce.aeYt.setVisibility(0);
        if (paramInt == 2) {
          paramce.aeYt.setPadding(0, this.aeiK.aezO.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0);
        } else {
          paramce.aeYt.setPadding(0, 0, 0, 0);
        }
      }
      if ((j != 0) && (Util.isNullOrNil(str)))
      {
        paramce.aeYu.setVisibility(8);
        AppMethodBeat.o(255295);
        return;
      }
      this.aeSQ = true;
      paramce.aeYu.setVisibility(0);
      AppMethodBeat.o(255295);
      return;
    }
  }
  
  private void a(ce paramce, Map<String, String> paramMap, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255246);
    label103:
    int i;
    label126:
    Object localObject;
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
    {
      a(paramce, Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), paramMap, paramcc, false);
      paramcc = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.display_name_desc"));
      if (Util.isNullOrNil(paramcc)) {
        break label733;
      }
      paramce.aeYT.setText(paramcc);
      paramce.aeYT.setVisibility(0);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_right_icon_and_desc_name"), 0) != 1) {
        break label755;
      }
      i = 1;
      if (i == 0) {
        break label824;
      }
      paramce.aeYU.setVisibility(0);
      paramcc = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.right_icon_url"));
      localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.right_desc_name"));
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_type"), -1) != 3) {
        break label761;
      }
      paramce.aeYV.setImageResource(R.g.icons_outlined_channel);
      paramce.aeYV.setVisibility(0);
      label210:
      if (Util.isNullOrNil((String)localObject)) {
        break label811;
      }
      paramce.aeYW.setText((CharSequence)localObject);
      label227:
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
        break label836;
      }
      paramce.aeYj.setBackgroundResource(R.g.mm_trans);
    }
    for (;;)
    {
      if (com.tencent.mm.compatible.util.d.rb(23)) {
        paramce.aeYj.setForeground(this.aeiK.aezO.getContext().getDrawable(R.g.fnF));
      }
      AppMethodBeat.o(255246);
      return;
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
      {
        a(paramce, Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.icon_url")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.display_name")), paramMap, paramcc, true);
        break;
      }
      ((View)paramce.aeYn.getParent()).setVisibility(8);
      if (("notifymessage".equals(paramcc.field_talker)) && (!this.aeSZ))
      {
        final String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        WxaAttributes localWxaAttributes;
        if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str))
        {
          localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(str);
          if (localWxaAttributes == null)
          {
            localObject = null;
            label451:
            a(paramce.aeYk, this.aeiK, str, paramcc, (String)localObject, paramMap);
            if (localWxaAttributes != null) {
              break label575;
            }
            localObject = str;
            label478:
            paramce.aeYl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.aeiK.aezO.getContext(), (CharSequence)localObject, paramce.aeYl.getTextSize()));
            if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str)) {
              break label627;
            }
            paramce.aeYj.setTag(new bz(paramcc, str));
            paramce.aeYj.setOnClickListener(this.aeMI);
          }
        }
        for (;;)
        {
          paramce.aeYj.setVisibility(0);
          break;
          localObject = localWxaAttributes.field_brandIconURL;
          break label451;
          label575:
          localObject = localWxaAttributes.field_nickname;
          break label478;
          a(paramce.aeYk, this.aeiK, str, paramcc, null, paramMap);
          localObject = ((com.tencent.mm.ui.chatting.component.api.g)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.g.class)).bAK(str);
          break label478;
          label627:
          localObject = paramce.aeYj;
          if (this.aeiK.juG()) {}
          for (paramcc = this.aeiK.getTalkerUserName();; paramcc = null)
          {
            ((View)localObject).setTag(new bz(str, paramcc));
            if (!Util.getBoolean((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
              break label701;
            }
            paramce.aeYj.setOnClickListener(null);
            break;
          }
          label701:
          paramce.aeYj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(255639);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              localObject = aq.this.e(aq.b(aq.this));
              if (localObject != null) {
                ((v.b)localObject).onClick(paramAnonymousView);
              }
              aq.a(aq.this, 10, aq.b(aq.this).getTalkerUserName(), str);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(255639);
            }
          });
        }
      }
      paramce.aeYj.setVisibility(8);
      break;
      label733:
      paramce.aeYT.setText("");
      paramce.aeYT.setVisibility(8);
      break label103;
      label755:
      i = 0;
      break label126;
      label761:
      if (!Util.isNullOrNil(paramcc))
      {
        c(paramce.aeYV, paramcc, 72, 72);
        paramce.aeYV.setVisibility(0);
        break label210;
      }
      paramce.aeYV.setImageBitmap(null);
      paramce.aeYV.setVisibility(8);
      break label210;
      label811:
      paramce.aeYW.setText("");
      break label227;
      label824:
      paramce.aeYU.setVisibility(8);
      break label227;
      label836:
      i = paramce.aeYj.getPaddingLeft();
      paramce.aeYj.setBackgroundResource(R.g.list_item_normal);
      paramce.aeYj.setPadding(i, 0, 0, 0);
    }
  }
  
  private void a(com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(255272);
    Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo addAppBrandSubscribeOperateMenu title: %s", new Object[] { this.aeSP });
    Object localObject;
    TextView localTextView;
    ImageView localImageView;
    if ((!paramBoolean1) || ((paramBoolean3) && (!paramBoolean2))) {
      if (paramBoolean3)
      {
        localObject = String.format(this.aeiK.aezO.getMMResources().getString(R.l.gQF), new Object[] { this.aeSP });
        params = params.c(1, (CharSequence)localObject);
        l(params);
        localObject = af.mU(this.aeiK.aezO.getContext()).inflate(R.i.ghy, null);
        localTextView = (TextView)((View)localObject).findViewById(R.h.fYo);
        localImageView = (ImageView)((View)localObject).findViewById(R.h.fYn);
        aw.d(localTextView.getPaint());
        paramString = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString);
        if (paramString != null) {
          break label363;
        }
        params = null;
        label169:
        if (paramString != null) {
          break label371;
        }
      }
    }
    label363:
    label371:
    for (paramString = null;; paramString = paramString.field_brandIconURL)
    {
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.aeiK.aezO.getContext(), params, localTextView.getTextSize()));
      params = new com.tencent.mm.modelimage.loader.a.c.a();
      params.oKI = 0.0F;
      params.nrc = false;
      params.oKB = R.g.brand_default_head;
      params = params.bKx();
      r.bKe().a(paramString, localImageView, params);
      paramf.af((View)localObject, false);
      AppMethodBeat.o(255272);
      return;
      localObject = this.aeiK.aezO.getMMResources().getString(R.l.gQG);
      break;
      int i = this.aeiK.aezO.getMMResources().getColor(R.e.red_text_color);
      if (paramBoolean3) {}
      for (localObject = String.format(this.aeiK.aezO.getMMResources().getString(R.l.gQh), new Object[] { this.aeSP });; localObject = this.aeiK.aezO.getMMResources().getString(R.l.gQj))
      {
        params = params.a(0, i, (CharSequence)localObject);
        break;
      }
      params = paramString.field_nickname;
      break label169;
    }
  }
  
  private static boolean aDq(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3);
  }
  
  private static String aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255309);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(255309);
      return "";
    }
    Object localObject = null;
    au localau;
    if (au.bwE(paramString1))
    {
      bh.bCz();
      localau = com.tencent.mm.model.c.bzA().JE(paramString1);
      if (localau != null)
      {
        if (Util.isNullOrNil(localau.field_conRemark)) {
          localObject = localau.field_nickname;
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
    for (paramString1 = MMApplicationContext.getContext().getString(R.l.gzv);; paramString1 = (String)localObject)
    {
      AppMethodBeat.o(255309);
      return paramString1;
      localObject = localau.field_conRemark;
      break;
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().JE(paramString1);
      if (((au)localObject).aSV() == null)
      {
        localObject = ((au)localObject).aSU();
        break;
      }
      localObject = ((au)localObject).aSV();
      break;
    }
  }
  
  private void ae(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(255238);
    if (!uF(this.LW))
    {
      AppMethodBeat.o(255238);
      return;
    }
    if (!au.bwu(paramString1))
    {
      AppMethodBeat.o(255238);
      return;
    }
    if (!com.tencent.mm.an.g.Mw(paramString2))
    {
      AppMethodBeat.o(255238);
      return;
    }
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.aeSX);
    AppMethodBeat.o(255238);
  }
  
  private static void af(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    Log.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.OAn.b(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(37253);
  }
  
  private static void b(int paramInt, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(255365);
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
        l2 = com.tencent.mm.ae.d.FK(paramMap.optString("live_id"));
        l1 = l2;
        paramMap = paramMap.optString("force_push_info");
        if (paramMap == null) {
          break label174;
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
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cg.DFu, paramString, l1, "", paramMap, Long.valueOf(1L), "", "", "", "");
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.aqy(com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1)))
      {
        AppMethodBeat.o(255365);
        return;
      }
      AppMethodBeat.o(255365);
      return;
      label174:
      paramMap = "";
    }
  }
  
  private static void b(ce paramce, int paramInt)
  {
    AppMethodBeat.i(255354);
    paramce.aeYm.setVisibility(paramInt);
    if (paramInt == 0)
    {
      paramce.aeYm.setText(MMApplicationContext.getResources().getString(R.l.gQs));
      AppMethodBeat.o(255354);
      return;
    }
    paramce.aeYm.setText("");
    AppMethodBeat.o(255354);
  }
  
  private void b(ce paramce, final com.tencent.mm.storage.cc paramcc, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(255330);
    LinearLayout localLinearLayout = paramce.aeYE;
    int i2 = localLinearLayout.getChildCount();
    final int j = 0;
    Object localObject1;
    final String str4;
    final String str5;
    final int i;
    label198:
    Object localObject2;
    label258:
    a locala;
    final String str2;
    if (j < 10)
    {
      if (j == 0) {}
      for (localObject1 = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; localObject1 = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(j)))
      {
        str4 = (String)paramMap.get((String)localObject1 + ".word");
        str5 = (String)paramMap.get((String)localObject1 + ".hint_word");
        if (!Util.isNullOrNil(str4)) {
          break label198;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(j) });
        i = localLinearLayout.getChildCount();
        if (i <= j) {
          break label2178;
        }
        if (j != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
        AppMethodBeat.o(255330);
        return;
      }
      localLinearLayout.removeViews(j, i - j);
      AppMethodBeat.o(255330);
      return;
      if (j < i2) {
        localObject2 = (LinearLayout)localLinearLayout.getChildAt(j);
      }
      for (;;)
      {
        if (!i(paramMap, j)) {
          break label258;
        }
        ((LinearLayout)localObject2).setVisibility(8);
        j += 1;
        break;
        localObject2 = jxw();
        localLinearLayout.addView((View)localObject2);
      }
      ((LinearLayout)localObject2).setVisibility(0);
      locala = (a)((LinearLayout)localObject2).getTag(R.h.place_holder);
      localObject2 = (String)paramMap.get((String)localObject1 + ".icon");
      if (!aw.isDarkMode()) {
        break label2185;
      }
      str2 = (String)paramMap.get((String)localObject1 + ".dmicon");
      if (Util.isNullOrNil(str2)) {
        break label2185;
      }
      localObject2 = str2;
    }
    label2178:
    label2185:
    for (;;)
    {
      for (;;)
      {
        final int k = 0;
        i = aw.mx(d(paramMap, (String)localObject1 + ".color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
        locala.mll.setTextColor(i);
        label488:
        final int i3;
        final String str3;
        label656:
        Object localObject3;
        label727:
        final int m;
        label730:
        int n;
        int i1;
        label976:
        String str6;
        if (Util.getInt((String)paramMap.get((String)localObject1 + ".is_rich_text"), 0) == 0)
        {
          locala.mll.setSingleLine(true);
          locala.mll.setEllipsize(TextUtils.TruncateAt.END);
          locala.mll.setText(str4);
          if (!Util.isNullOrNil(str5)) {
            k = 1;
          }
          locala.pPe.setTextColor(this.aeiK.aezO.getContext().getResources().getColor(R.e.FG_1));
          i3 = Util.getInt((String)paramMap.get((String)localObject1 + ".is_show_red_dot"), 0);
          str2 = Util.nullAs((String)paramMap.get((String)localObject1 + ".ext_id"), "");
          str3 = Util.nullAs((String)paramMap.get((String)localObject1 + ".business_id"), "");
          if (com.tencent.mm.model.cn.bDv() - paramcc.getCreateTime() <= 604800000L) {
            break label1551;
          }
          i = 1;
          localObject3 = (FlexboxLayout.LayoutParams)locala.aeLP.getLayoutParams();
          if (localObject3 != null) {
            ((FlexboxLayout.LayoutParams)localObject3).dmW = 0.0F;
          }
          if ((!q(paramcc, j)) || (i3 != 1) || (i != 0)) {
            break label1590;
          }
          if (Util.isNullOrNil(str5)) {
            break label1557;
          }
          locala.aeLN.setVisibility(8);
          locala.aeLO.setVisibility(0);
          m = 1;
          locala.aeLP.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          if (!Util.isNullOrNil((String)localObject2)) {
            break label1616;
          }
          locala.dpM.setVisibility(8);
          locala.aeLH.setVisibility(8);
          locala.mll.setPadding(0, 0, 0, 0);
          n = 0;
          if (!paramce.aeZb) {
            break label1762;
          }
          i = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_2A);
          locala.aeLM.setPadding(0, i, 0, i);
          i = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_1_7_5_A);
          locala.mll.setTextSize(0, i);
          locala.pPe.setTextSize(0, i);
          if (!com.tencent.mm.cd.a.mp(MMApplicationContext.getContext())) {
            break label1749;
          }
          i = (int)locala.mll.getPaint().measureText(str4);
          i1 = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()) - com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_9A) - i;
          i = i1;
          if (n != 0) {
            i = i1 - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 30);
          }
          n = i;
          if (m != 0) {
            n = i - com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_2A);
          }
          if (k != 0)
          {
            if (n >= (int)locala.pPe.getPaint().measureText(str5)) {
              break label1736;
            }
            locala.pPe.setText("");
          }
          locala.aeLI.setVisibility(8);
          localObject3 = (String)paramMap.get((String)localObject1 + ".url");
          str4 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
          m = Util.getInt((String)paramMap.get((String)localObject1 + ".op_type"), 0);
          str5 = (String)paramMap.get((String)localObject1 + ".weapp_username");
          str6 = Util.nullAsNil((String)paramMap.get((String)localObject1 + ".general_string"));
          localObject2 = new bz(paramcc, str4, (String)localObject3);
          ((bz)localObject2).aeXZ = j;
          ((bz)localObject2).extId = str2;
          ((bz)localObject2).businessId = str3;
          ((bz)localObject2).aeYa = i3;
          locala.aeLL.setTag(localObject2);
          k = j + 1;
        }
        try
        {
          localObject2 = new com.tencent.mm.ad.i(str6);
          String str7 = Util.nullAs((String)paramMap.get((String)localObject1 + ".thumbnail"), "");
          if (!Util.isNullOrNil(str7)) {
            if (Util.getInt((String)paramMap.get((String)localObject1 + ".is_show_play_btn"), 0) == 1)
            {
              i = 1;
              locala.aeLI.setVisibility(0);
              n = aw.bf(this.aeiK.aezO.getContext()).x - com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 64);
              i1 = (int)(n / 4.425F);
              ViewGroup.LayoutParams localLayoutParams = locala.aeLJ.getLayoutParams();
              if (localLayoutParams != null)
              {
                localLayoutParams.width = n;
                localLayoutParams.height = i1;
                locala.aeLJ.setLayoutParams(localLayoutParams);
              }
              c(locala.aeLJ, str7, n, i1);
              if (i == 0) {
                break label1864;
              }
              locala.aeLK.setVisibility(0);
              if ((m != 3) && (m != 4) && (m != 5)) {
                break label1890;
              }
              a(locala.aeLL, paramcc, paramMap, m, str6, 2);
              break;
              i = Util.getInt((String)paramMap.get((String)localObject1 + ".display_line_number"), 1);
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(i) });
              locala.mll.setSingleLine(false);
              locala.mll.setText(str4);
              locala.mll.setMaxLines(i);
              com.tencent.mm.pluginsdk.ui.span.p.a(locala.mll, false, null);
              break label488;
              label1551:
              i = 0;
              break label656;
              label1557:
              locala.aeLN.setVisibility(0);
              locala.aeLO.setVisibility(8);
              if (localObject3 == null) {
                break label727;
              }
              ((FlexboxLayout.LayoutParams)localObject3).dmW = 1.0F;
              break label727;
              label1590:
              locala.aeLN.setVisibility(8);
              locala.aeLO.setVisibility(8);
              m = 0;
              break label730;
              label1616:
              if (paramce.aeZb)
              {
                locala.dpM.setVisibility(8);
                locala.aeLH.setVisibility(0);
                c(locala.aeLH, (String)localObject2, 72, 72);
                locala.mll.setPadding(0, 0, 0, 0);
              }
              for (;;)
              {
                n = 1;
                break;
                locala.dpM.setVisibility(0);
                locala.aeLH.setVisibility(8);
                c(locala.dpM, (String)localObject2, 72, 72);
                locala.mll.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 28), 0);
              }
              label1736:
              locala.pPe.setText(str5);
              break label976;
              label1749:
              locala.pPe.setText(str5);
              break label976;
              label1762:
              i = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_1_2_5_A);
              locala.aeLM.setPadding(0, i, 0, i);
              i = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.small_normal_textsize);
              locala.mll.setTextSize(0, i);
              locala.pPe.setTextSize(0, i);
              locala.pPe.setText(str5);
            }
          }
        }
        catch (com.tencent.mm.ad.g localg)
        {
          final String str1;
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", localg, "", new Object[0]);
            str1 = null;
            continue;
            i = 0;
            continue;
            label1864:
            locala.aeLK.setVisibility(8);
            continue;
            locala.aeLI.setVisibility(8);
          }
          label1890:
          if ((m == 1) && (!TextUtils.isEmpty(str5)))
          {
            str1 = (String)paramMap.get((String)localObject1 + ".weapp_path");
            i = Util.getInt((String)paramMap.get((String)localObject1 + ".weapp_version"), 0);
            m = Util.getInt((String)paramMap.get((String)localObject1 + ".weapp_state"), 0);
            localObject1 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(255363);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                paramAnonymousView = (bz)paramAnonymousView.getTag();
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str5 });
                localObject = new AppBrandStatObject();
                ((AppBrandStatObject)localObject).hzx = (paramAnonymousView.hTm.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + aq.b(aq.this).getTalkerUserName() + ":" + this.aePk);
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(paramAnonymousView.userName))
                {
                  ((AppBrandStatObject)localObject).scene = aq.afW(this.aePk);
                  ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(aq.b(aq.this).aezO.getContext(), str5, null, m, i, str1, (AppBrandStatObject)localObject);
                  if (i3 == 1) {
                    aq.r(paramcc, j);
                  }
                  aq.qb(aq.d(aq.this), aq.a(aq.this));
                  com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), str4, Integer.valueOf(k) });
                  aq.c(paramMap, str2, "", str3);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(255363);
                  return;
                }
                ((AppBrandStatObject)localObject).scene = 1043;
                paramAnonymousView = com.tencent.mm.an.g.hU(paramAnonymousView.userName);
                com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
                Activity localActivity = aq.b(aq.this).aezO.getContext();
                String str1 = str5;
                int i = m;
                int j = i;
                String str2 = str1;
                if (paramAnonymousView == null) {}
                for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                {
                  localt.a(localActivity, str1, null, i, j, str2, (AppBrandStatObject)localObject, paramAnonymousView);
                  break;
                }
              }
            };
            locala.aeLL.setOnClickListener((View.OnClickListener)localObject1);
            break;
          }
          if (m == 2)
          {
            locala.aeLL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(255355);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                if (k == 1)
                {
                  localObject = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                  long l = Util.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                  aq.h(paramAnonymousView.getContext(), (String)localObject, l);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 2L, 1L, false);
                  Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject, Long.valueOf(l) });
                }
                for (;;)
                {
                  aq.c(paramMap, str2, "", str3);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(255355);
                  return;
                  if (k == 2) {
                    com.tencent.mm.br.c.g(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
                  }
                }
              }
            });
            break;
          }
          if (m == 6)
          {
            if (str1 == null) {
              break;
            }
            locala.aeLL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(255390);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                if (str1 != null)
                {
                  paramAnonymousView = str1.optString("feedID");
                  localObject = str1.optString("nonceID");
                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().h(aq.b(aq.this).aezO.getContext(), paramAnonymousView, (String)localObject, com.tencent.mm.plugin.wallet_core.utils.m.asD(2));
                  aq.c(paramMap, str2, paramAnonymousView, str3);
                  if (i3 == 1) {
                    aq.r(paramcc, j);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255390);
              }
            });
            break;
          }
          locala.aeLL.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(255391);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (!Util.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                paramAnonymousView.putExtra("key_enable_teen_mode_check", true);
                c.s(paramAnonymousView, aq.b(aq.this).getTalkerUserName());
                com.tencent.mm.br.c.b(aq.b(aq.this).aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { aq.a(aq.this), str4, Integer.valueOf(k) });
                aq.c(paramMap, str2, "", str3);
                if (i3 == 1) {
                  aq.r(paramcc, j);
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(255391);
            }
          });
        }
      }
      break;
      AppMethodBeat.o(255330);
      return;
    }
  }
  
  private void b(ce paramce, Map<String, String> paramMap)
  {
    AppMethodBeat.i(255300);
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
    String str2 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
    String str3 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
    if (!Util.isNullOrNil(str2))
    {
      int i = aw.mx(d(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
      int j = aw.mx(d(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
      int k = aw.mx(d(paramMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.aeiK.aezO.getContext().getResources().getColor(R.e.half_alpha_black)));
      int m = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
      paramce.aeYw.setTextColor(i);
      paramce.aeYy.setTextColor(j);
      paramce.aeYz.setTextColor(k);
      paramce.aeYz.getPaint().setFlags(16);
      paramce.aeYz.getPaint().setAntiAlias(true);
      paramce.aeYz.setTextSize(0, com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.Edge_1_7_5_A));
      paramce.aeYw.setText(str1);
      if ((m > 0) && (m < str2.length()))
      {
        paramce.aeYx.setVisibility(0);
        paramce.aeYx.setText(str2.substring(0, m));
        paramce.aeYx.setTextColor(j);
        paramce.aeYx.setTypeface(com.tencent.mm.wallet_core.ui.i.bE(this.aeiK.aezO.getContext(), 0));
        paramce.aeYy.setTypeface(com.tencent.mm.wallet_core.ui.i.bE(this.aeiK.aezO.getContext(), 0));
        paramce.aeYy.setTextSize(1, 40.0F);
        paramce.aeYx.setTextSize(1, 40.0F);
        paramce.aeYy.setIncludeFontPadding(true);
        paramce.aeYy.setText(str2.substring(m));
        if (Util.isNullOrNil(str3)) {
          break label774;
        }
        paramce.aeYz.setText(str3);
        if (!paramce.aeZb) {
          break label761;
        }
        paramce.aeYz.setTypeface(com.tencent.mm.wallet_core.ui.i.bE(this.aeiK.aezO.getContext(), 7));
        label421:
        paramce.aeYz.setVisibility(0);
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (!Util.isNullOrNil(str1)) {
          localStringBuilder.append(str1);
        }
        if (!Util.isNullOrNil(str2)) {
          localStringBuilder.append(str2);
        }
        if (!Util.isNullOrNil(str3))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(this.aeiK.aezO.getMMResources().getString(R.l.gyd));
          localStringBuilder.append(str3);
        }
        str1 = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_middle_tips_word");
        if (!Util.isNullOrNil(str1)) {
          localStringBuilder.append(str1);
        }
        paramMap = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.pay_recepit_detail_word");
        if (!Util.isNullOrNil(paramMap)) {
          localStringBuilder.append(paramMap);
        }
        paramce.aeYv.setContentDescription(localStringBuilder.toString());
        paramce.aeYv.setVisibility(0);
        AppMethodBeat.o(255300);
        return;
        paramce.aeYx.setTypeface(Typeface.DEFAULT);
        paramce.aeYx.setVisibility(8);
        if ((str2.contains("￥")) || (str2.contains("¥")) || (str2.contains("$")) || (str2.contains("＄")))
        {
          paramce.aeYy.setTypeface(com.tencent.mm.wallet_core.ui.i.bE(this.aeiK.aezO.getContext(), 0));
          paramce.aeYy.setTextSize(1, 40.0F);
          paramce.aeYy.setIncludeFontPadding(true);
        }
        for (;;)
        {
          paramce.aeYy.setText(str2);
          break;
          paramce.aeYy.setTypeface(Typeface.DEFAULT);
          aw.a(paramce.aeYy.getPaint(), 0.8F);
          paramce.aeYy.setTextSize(1, 32.0F);
          paramce.aeYy.setIncludeFontPadding(false);
        }
        label761:
        paramce.aeYz.setTypeface(Typeface.DEFAULT);
        break label421;
        label774:
        paramce.aeYz.setVisibility(8);
      }
    }
    paramce.aeYv.setVisibility(8);
    AppMethodBeat.o(255300);
  }
  
  private void b(ce paramce, Map<String, String> paramMap, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255255);
    String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    boolean bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str);
    if ((this.aeSZ) && (paramce.aeYo.getTag(R.h.fQi) != null))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app single talker chat");
      paramce.aeYp.setTag(R.h.fQi, paramcc);
      paramce.aeYp.setOnClickListener(this.aeSE);
      paramce.aeYp.setVisibility(0);
      paramce.aeYo.setVisibility(8);
      paramce = paramce.aeYu;
      paramce.setPadding(paramce.getPaddingLeft(), paramce.getPaddingTop(), paramce.getPaddingRight(), 0);
      AppMethodBeat.o(255255);
      return;
    }
    if ((bool) && ("notifymessage".equals(paramcc.field_talker)))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
      paramce.aeYp.setTag(null);
      paramce.aeYp.setVisibility(8);
      AppMethodBeat.o(255255);
      return;
    }
    if ((au.bwu(paramcc.field_talker)) && (com.tencent.mm.an.g.Mw(str)) && (uF(w(paramMap))))
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by biz subscribe msg");
      paramce.aeYp.setTag(null);
      paramce.aeYp.setVisibility(8);
      AppMethodBeat.o(255255);
      return;
    }
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
      paramce.aeYo.setTag(null);
      paramce.aeYp.setTag(null);
      paramce.aeYo.setVisibility(8);
      paramce.aeYp.setVisibility(8);
      AppMethodBeat.o(255255);
      return;
    }
    if (paramce.aeYj.getVisibility() == 0)
    {
      paramce.aeYo.setTag(paramcc);
      paramce.aeYo.setOnClickListener(this.aeSF);
      paramce.aeYo.setVisibility(0);
      paramce.aeYp.setVisibility(8);
      AppMethodBeat.o(255255);
      return;
    }
    if (paramce.aeYu.getVisibility() == 0)
    {
      paramce.aeYp.setTag(paramcc);
      paramce.aeYp.setOnClickListener(this.aeSF);
      paramce.aeYp.setVisibility(0);
      paramce.aeYo.setVisibility(8);
      AppMethodBeat.o(255255);
      return;
    }
    paramce.aeYo.setTag(null);
    paramce.aeYp.setTag(null);
    paramce.aeYo.setVisibility(8);
    paramce.aeYp.setVisibility(8);
    AppMethodBeat.o(255255);
  }
  
  private static int bBx(String paramString)
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
  
  private static int bBy(String paramString)
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
  
  private static void c(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255350);
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(255350);
      return;
    }
    Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
    bh.bCz();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.bzM();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nqa = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(paramInt1, paramInt2);
    localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
    r.bKe().a(paramString, paramImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
    AppMethodBeat.o(255350);
  }
  
  private static void c(ce paramce, Map<String, String> paramMap)
  {
    AppMethodBeat.i(255305);
    Log.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
    paramce.aeYB.setVisibility(8);
    Object localObject1 = (ViewGroup)paramce.aeYB.getParent();
    paramce = ((ViewGroup)localObject1).findViewById(R.h.fEs);
    Object localObject2;
    if (paramce == null)
    {
      paramce = LayoutInflater.from(((ViewGroup)localObject1).getContext()).inflate(R.i.gnC, null);
      localObject2 = new bt();
      ((bt)localObject2).dpM = ((ImageView)paramce.findViewById(R.h.avatar));
      ((bt)localObject2).DTO = ((TextView)paramce.findViewById(R.h.nickname));
      ((bt)localObject2).mll = ((TextView)paramce.findViewById(R.h.title));
      paramce.setTag(localObject2);
      ((ViewGroup)localObject1).addView(paramce);
    }
    for (;;)
    {
      paramce.setVisibility(0);
      paramce = (bt)paramce.getTag();
      localObject1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
      localObject2 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
      String str = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
      paramMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
      int i = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
      paramce.mll.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramce.mll.getContext(), (CharSequence)localObject1));
      paramce.DTO.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramce.mll.getContext(), aV((String)localObject2, str)));
      if (i == 2)
      {
        paramce.dpM.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.app_add_to_favorite));
        AppMethodBeat.o(255305);
        return;
      }
      com.tencent.mm.pluginsdk.ui.a.b.g(paramce.dpM, (String)localObject2);
      AppMethodBeat.o(255305);
      return;
    }
  }
  
  private void c(final ce paramce, final Map<String, String> paramMap, final com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255269);
    this.aeSR = true;
    int i;
    int j;
    if (!"notifymessage".equals(paramcc.field_talker))
    {
      i = 1;
      j = 0;
    }
    for (;;)
    {
      if ((j == 0) || (i == 0))
      {
        paramce.aeYR.setVisibility(8);
        a(paramce, 8);
      }
      if ((j != 0) && (i != 0))
      {
        paramce.aeYo.setVisibility(0);
        paramce.aeYo.setTag(R.h.fQi, paramcc);
        a(paramce);
      }
      AppMethodBeat.o(255269);
      return;
      if (!uF(this.LW))
      {
        this.aeSR = false;
        i = 0;
        j = 1;
      }
      else
      {
        String str1 = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
        this.aeSX.setUsername(Util.nullAs(str1, ""));
        this.aeSX.type = 1;
        Object localObject = this.aeSX;
        String str2 = Util.nullAs(this.aeSM, "");
        kotlin.g.b.s.u(str2, "<set-?>");
        ((com.tencent.mm.msgsubscription.c.a.b)localObject).nSg = str2;
        this.aeSX.phR = this.LW;
        localObject = this.aeSX;
        str2 = Util.nullAs(this.aeSP, "");
        kotlin.g.b.s.u(str2, "<set-?>");
        ((com.tencent.mm.msgsubscription.c.a.b)localObject).pjO = str2;
        paramce.aeYR.setVisibility(8);
        a(paramce, 8);
        paramce.aeYS.setText(this.aeiK.aezO.getMMResources().getString(R.l.gQI));
        localObject = com.tencent.mm.msgsubscription.b.a.piP;
        a.a.bW(this.aeSM, paramce.aeYR.hashCode());
        localObject = com.tencent.mm.msgsubscription.b.a.piP;
        a.a.a(this.aeSM, paramce.aeYR.hashCode(), new ISubscribeMsgService.b()
        {
          public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
          {
            AppMethodBeat.i(255636);
            if (paramAnonymousString.equals(aq.a(aq.this)))
            {
              Log.d("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onUpdated templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousc.piu), Boolean.valueOf(paramAnonymousc.piv) });
              aq.a(aq.this, new ISubscribeMsgService.c(paramAnonymousc.piu, paramAnonymousc.piv));
              aq.f(aq.this).phu = paramAnonymousc.phu;
              aq.f(aq.this).phY = paramAnonymousc.phY;
              aq.a(aq.this, paramcc, paramce, paramAnonymousc);
              if ((aq.e(aq.this) != null) && (aq.e(aq.this).isShowing())) {
                aq.e(aq.this).dDn();
              }
            }
            AppMethodBeat.o(255636);
          }
          
          public final void atR()
          {
            AppMethodBeat.i(255640);
            Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
            AppMethodBeat.o(255640);
          }
        });
        this.pjs.bV(str1, this.aeSM);
        i = 1;
        j = 1;
      }
    }
  }
  
  private static int d(Map<String, String> paramMap, String paramString, int paramInt)
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
  
  private void d(ce paramce, Map<String, String> paramMap)
  {
    AppMethodBeat.i(255315);
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
    cb localcb;
    if (j < 100)
    {
      if (j == 0)
      {
        localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
        localObject2 = (String)paramMap.get((String)localObject1 + ".value.word");
        localObject3 = (String)paramMap.get((String)localObject1 + ".key.word");
        if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject3))) {
          break label538;
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
      localObject2 = paramce.aeYB;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)paramce.aeYB.getParent()).findViewById(R.h.fEs);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((LinearLayout)localObject2).getChildCount() > localArrayList.size())
      {
        if (localArrayList.size() != 0) {
          break label998;
        }
        ((LinearLayout)localObject2).removeAllViews();
      }
      localObject3 = new StringBuilder();
      k = ((LinearLayout)localObject2).getChildCount();
      i = 0;
      if (i >= localArrayList.size()) {
        break label1177;
      }
      localcb = (cb)localArrayList.get(i);
      if (i >= k) {
        break label1028;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject2).getChildAt(i);
      label282:
      localObject1 = (cc)((LinearLayout)localObject1).getTag();
      if (!localcb.nVR) {
        break label1050;
      }
      ((cc)localObject1).aeYe.setVisibility(8);
      label310:
      ((cc)localObject1).aeYf.setTextColor(aw.mx(localcb.aeYd));
      ((cc)localObject1).aeYf.setText(localcb.nVQ);
      if (((q)this.aeiK.cm(q.class)).jrQ())
      {
        if (!aDq(Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1))) {
          break label1101;
        }
        if (paramce.aeYg != null) {
          paramce.aeYg.setBackgroundResource(R.g.fnE);
        }
        ((cc)localObject1).aeYf.setBackgroundResource(R.g.chatting_item_dyeing_line_data_bg);
        aq.f localf = new aq.f(localcb.nVP, localcb.nVQ, localcb.nVR);
        ((cc)localObject1).aeYf.setTag(localf);
        ((cc)localObject1).aeYf.setOnLongClickListener(o(this.aeiK));
        ((cc)localObject1).aeYf.setOnClickListener(jxx());
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject3).append(Util.nullAs(localcb.nVP, "")).append(":").append(Util.nullAs(localcb.nVQ, "")).append("\n");
      i += 1;
      break label241;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label538:
      localcb = new cb();
      localcb.nVQ = ((String)localObject2);
      localcb.nVP = Util.nullAsNil((String)localObject3);
      label702:
      boolean bool;
      if (!aw.isDarkMode())
      {
        localcb.aeYc = d(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", d(paramMap, (String)localObject1 + ".key.color", aeTa));
        localcb.aeYd = d(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", d(paramMap, (String)localObject1 + ".value.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color)));
        if (Util.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label989;
        }
        bool = true;
        label742:
        localcb.nVR = bool;
        k = (bBy(localcb.nVP) + 1) / 2;
        if (k <= i) {
          break label995;
        }
        i = k;
      }
      label989:
      label995:
      for (;;)
      {
        localArrayList.add(localcb);
        j += 1;
        break;
        localcb.aeYc = d(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", d(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", d(paramMap, (String)localObject1 + ".key.color", aeTa)));
        localcb.aeYd = d(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", d(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", d(paramMap, (String)localObject1 + ".value.color", this.aeiK.aezO.getContext().getResources().getColor(R.e.normal_text_color))));
        localcb.aeYd = aw.mx(localcb.aeYd);
        break label702;
        bool = false;
        break label742;
      }
      label998:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label223;
      label1028:
      localObject1 = jxv();
      ((LinearLayout)localObject1).setImportantForAccessibility(1);
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label282;
      label1050:
      ((cc)localObject1).aeYe.setVisibility(0);
      ((cc)localObject1).aeYe.setEms(j);
      ((cc)localObject1).aeYe.setTextColor(aw.mx(localcb.aeYc));
      ((cc)localObject1).aeYe.setText(localcb.nVP);
      break label310;
      label1101:
      if (paramce.aeYg != null) {
        paramce.aeYg.setBackgroundResource(R.g.fnG);
      }
      ((cc)localObject1).aeYf.setTag(null);
      ((cc)localObject1).aeYf.setOnLongClickListener(null);
      ((cc)localObject1).aeYf.setOnClickListener(null);
      if (com.tencent.mm.compatible.util.d.rb(16)) {
        ((cc)localObject1).aeYf.setBackground(null);
      } else {
        ((cc)localObject1).aeYf.setBackgroundDrawable(null);
      }
    }
    label1177:
    this.aeSX.Rb(((StringBuilder)localObject3).toString());
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      paramce.aeYA.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(255315);
      return;
    }
    if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      paramce.aeYA.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(255315);
      return;
      paramce.aeYA.setVisibility(0);
    }
  }
  
  private void d(ce paramce, Map<String, String> paramMap, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255278);
    this.aeSX.reset();
    this.aeSR = false;
    String str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str))
    {
      e(paramce, paramMap, paramcc);
      AppMethodBeat.o(255278);
      return;
    }
    if (com.tencent.mm.an.g.Mw(str))
    {
      c(paramce, paramMap, paramcc);
      AppMethodBeat.o(255278);
      return;
    }
    paramce.aeYR.setVisibility(8);
    a(paramce, 8);
    AppMethodBeat.o(255278);
  }
  
  private void e(final ce paramce, final Map<String, String> paramMap, final com.tencent.mm.storage.cc paramcc)
  {
    boolean bool2 = true;
    AppMethodBeat.i(255285);
    boolean bool3 = uF(w(paramMap));
    final String str;
    final boolean bool1;
    if ("notifymessage".equals(paramcc.field_talker))
    {
      this.aeSR = true;
      str = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
      if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_ext.is_audio_template"), 0) != 1) {
        break label337;
      }
      bool1 = true;
      this.aeSX.setUsername(str);
      this.aeSX.type = 2;
      ((l)this.aeiK.cm(l.class)).a(this.aeSI);
      this.aezD.alive();
      if (!bool3) {
        break label370;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(str);
      if (localObject == null) {
        break label343;
      }
      this.mAppId = ((WxaAttributes)localObject).field_appId;
    }
    for (;;)
    {
      paramce.aeYR.setVisibility(8);
      a(paramce, 8);
      paramce.aeYS.setText(this.aeiK.aezO.getMMResources().getString(R.l.gQI));
      this.aeSL.piu = true;
      this.aeSL.piv = true;
      localObject = com.tencent.mm.msgsubscription.b.a.piP;
      a.a.bW(this.aeSM, paramce.aeYR.hashCode());
      localObject = com.tencent.mm.msgsubscription.b.a.piP;
      a.a.a(this.aeSM, paramce.aeYR.hashCode(), new ISubscribeMsgService.b()
      {
        public final void a(String paramAnonymousString, ISubscribeMsgService.c paramAnonymousc)
        {
          AppMethodBeat.i(255577);
          if (paramAnonymousString.equals(aq.a(aq.this)))
          {
            Log.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b, isSwitchOpened: %b", new Object[] { str, paramAnonymousString, Boolean.valueOf(paramAnonymousc.piu), Boolean.valueOf(paramAnonymousc.piv), Boolean.valueOf(paramAnonymousc.phu) });
            aq.a(aq.this, new ISubscribeMsgService.c(paramAnonymousc.piu, paramAnonymousc.piv));
            aq.f(aq.this).phu = paramAnonymousc.phu;
            aq.f(aq.this).phY = bool1;
            aq.a(aq.this, paramcc, paramce, aq.f(aq.this), true);
            if ((aq.e(aq.this) != null) && (aq.e(aq.this).isShowing())) {
              aq.e(aq.this).dDn();
            }
          }
          AppMethodBeat.o(255577);
        }
        
        public final void atR()
        {
          AppMethodBeat.i(255579);
          Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
          AppMethodBeat.o(255579);
        }
      });
      this.aeSO.bV(str, this.aeSM);
      paramce.aeYo.setVisibility(0);
      paramce.aeYo.setTag(R.h.fQi, paramcc);
      a(paramce);
      AppMethodBeat.o(255285);
      return;
      label337:
      bool1 = false;
      break;
      label343:
      ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(str, new s.a()
      {
        public final void onGetWeAppInfo(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(255563);
          if (paramAnonymousWxaAttributes != null)
          {
            Log.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { aq.d(aq.this) });
            aq.b(aq.this, paramAnonymousWxaAttributes.field_appId);
          }
          AppMethodBeat.o(255563);
        }
      });
    }
    label370:
    this.aeSL.piv = false;
    Object localObject = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(str);
    int i;
    if (localObject != null)
    {
      this.mAppId = ((WxaAttributes)localObject).field_appId;
      if ((((WxaAttributes)localObject).field_appOpt & 0x1) > 0)
      {
        i = 1;
        label423:
        paramMap = this.aeSL;
        if (i != 0) {
          break label463;
        }
        bool1 = bool2;
        label437:
        paramMap.piu = bool1;
      }
    }
    for (;;)
    {
      a(paramcc, paramce, this.aeSL, false);
      break;
      i = 0;
      break label423;
      label463:
      bool1 = false;
      break label437;
      Log.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { str });
      this.aeSL.piu = true;
      ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(str, new s.a()
      {
        public final void onGetWeAppInfo(WxaAttributes paramAnonymousWxaAttributes)
        {
          boolean bool = true;
          AppMethodBeat.i(255554);
          if (paramAnonymousWxaAttributes == null)
          {
            AppMethodBeat.o(255554);
            return;
          }
          aq.b(aq.this, paramAnonymousWxaAttributes.field_appId);
          int i;
          if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0)
          {
            i = 1;
            paramAnonymousWxaAttributes = aq.f(aq.this);
            if (i != 0) {
              break label79;
            }
          }
          for (;;)
          {
            paramAnonymousWxaAttributes.piu = bool;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(255398);
                aq.a(aq.this, aq.23.this.oiL, aq.23.this.aeTo, aq.f(aq.this), false);
                AppMethodBeat.o(255398);
              }
            });
            AppMethodBeat.o(255554);
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
  
  private static boolean i(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(255348);
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
        AppMethodBeat.o(255348);
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
        if ((i == 1) && (com.tencent.mm.protocal.d.Yxh >= j))
        {
          AppMethodBeat.o(255348);
          return true;
        }
        AppMethodBeat.o(255348);
        return false;
      }
      i += 1;
      if (i > 10)
      {
        AppMethodBeat.o(255348);
        return false;
      }
    }
  }
  
  private LinearLayout jxv()
  {
    AppMethodBeat.i(255316);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.aeiK.aezO.getContext()).inflate(R.i.geU, null, false);
    cc localcc = new cc();
    localcc.aeYe = ((TextView)localLinearLayout.findViewById(R.h.fMP));
    localcc.aeYf = ((TextView)localLinearLayout.findViewById(R.h.fMR));
    localLinearLayout.setTag(localcc);
    AppMethodBeat.o(255316);
    return localLinearLayout;
  }
  
  private LinearLayout jxw()
  {
    AppMethodBeat.i(255337);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.aeiK.aezO.getContext()).inflate(R.i.geT, null, false);
    a locala = new a();
    locala.mll = ((TextView)localLinearLayout.findViewById(R.h.fPQ));
    locala.dpM = ((ImageView)localLinearLayout.findViewById(R.h.fPK));
    locala.aeLL = localLinearLayout;
    locala.aeLM = ((ViewGroup)localLinearLayout.findViewById(R.h.fPR));
    locala.pPe = ((TextView)localLinearLayout.findViewById(R.h.fPJ));
    locala.aeLN = ((ImageView)localLinearLayout.findViewById(R.h.fPO));
    locala.aeLO = ((ImageView)localLinearLayout.findViewById(R.h.fPP));
    locala.aeLH = ((ImageView)localLinearLayout.findViewById(R.h.fPI));
    locala.aeLP = ((FlexboxLayout)localLinearLayout.findViewById(R.h.fPB));
    locala.aeLI = ((ViewGroup)localLinearLayout.findViewById(R.h.fPM));
    locala.aeLJ = ((ImageView)localLinearLayout.findViewById(R.h.fPL));
    locala.aeLJ.setClipToOutline(true);
    locala.aeLJ.setOutlineProvider(new aq.36(this));
    if (Build.VERSION.SDK_INT >= 23) {
      locala.aeLJ.setForeground(MMApplicationContext.getResources().getDrawable(R.e.UN_BW_0_Alpha_0_3));
    }
    locala.aeLK = ((ImageView)localLinearLayout.findViewById(R.h.fPN));
    localLinearLayout.setTag(R.h.place_holder, locala);
    AppMethodBeat.o(255337);
    return localLinearLayout;
  }
  
  private aq.d jxx()
  {
    AppMethodBeat.i(255373);
    if (this.aeTc == null) {
      this.aeTc = new aq.d((byte)0);
    }
    aq.d locald = this.aeTc;
    AppMethodBeat.o(255373);
    return locald;
  }
  
  private void l(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(255275);
    if ((paramMenuItem instanceof com.tencent.mm.ui.base.t)) {
      ((com.tencent.mm.ui.base.t)paramMenuItem).adSf = new u.j()
      {
        public final void onMenuItemViewCustomize(View paramAnonymousView)
        {
          AppMethodBeat.i(255647);
          if (paramAnonymousView != null)
          {
            paramAnonymousView = (TextView)paramAnonymousView.findViewById(R.h.title);
            if (paramAnonymousView != null)
            {
              paramAnonymousView.setMaxLines(1);
              paramAnonymousView.setEllipsize(TextUtils.TruncateAt.END);
              paramAnonymousView.setPadding(aq.jxy().intValue(), paramAnonymousView.getPaddingTop(), aq.jxy().intValue(), paramAnonymousView.getPaddingBottom());
            }
          }
          AppMethodBeat.o(255647);
        }
      };
    }
    AppMethodBeat.o(255275);
  }
  
  private e o(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(255369);
    if (this.aeTd == null) {
      this.aeTd = new e(parama);
    }
    parama = this.aeTd;
    AppMethodBeat.o(255369);
    return parama;
  }
  
  private static boolean q(com.tencent.mm.storage.cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255332);
    int i = paramcc.kLx & 1 << paramInt;
    Log.d("MicroMsg.ChattingItemDyeingTemplate", "get reddot state: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(255332);
      return true;
    }
    AppMethodBeat.o(255332);
    return false;
  }
  
  private static boolean uF(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int w(Map<String, String> paramMap)
  {
    AppMethodBeat.i(255262);
    int i = bBx((String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
    AppMethodBeat.o(255262);
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
      localObject = new bf(new ap(paramLayoutInflater, R.i.gfs)).aeVv;
      ((View)localObject).setTag(new bu().lR((View)localObject));
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, com.tencent.mm.storage.cc paramcc, String paramString)
  {
    AppMethodBeat.i(37242);
    this.aeiK = parama1;
    if (aeSU == null)
    {
      aeSU = Integer.valueOf(com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_A));
      aeSV = Integer.valueOf(com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_2A));
      aeSW = Integer.valueOf(com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_4A));
    }
    aeTa = parama1.aezO.getContext().getResources().getColor(R.e.desc_text_color);
    aeTb = parama1.aezO.getContext().getResources().getColor(R.e.desc_text_color);
    this.aeSZ = ((q)parama1.cm(q.class)).jrP();
    parama = (bw)parama;
    Map localMap = XmlParser.parseXml(paramcc.field_content, "msg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      parama.vMH.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    parama.vMH.setVisibility(0);
    int j = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    int i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.is_pay_recepit"), 0);
    this.aeSM = Util.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.LW = w(localMap);
    this.aeSN = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    this.aezD.dead();
    ((l)parama1.cm(l.class)).b(this.aeSI);
    if ((parama instanceof bu))
    {
      final bu localbu = (bu)parama;
      localbu.aeXz.setVisibility(8);
      parama1 = (q)parama1.cm(q.class);
      if (parama1 != null)
      {
        long l1 = paramcc.field_msgId;
        if (parama1.zQ(l1))
        {
          long l2 = parama1.zN(l1);
          if (l2 >= 0L)
          {
            if (parama1.zO(l2) == null)
            {
              i = 0;
              Log.i("MicroMsg.ChattingItemDyeingTemplate", "filling end of group, id: %d, head id: %d, group size: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
              parama1 = new bz(paramcc, paramString);
              parama1.position = paramInt;
              localbu.aeXz.setVisibility(0);
              localbu.aeXz.setText(localbu.aeXz.getContext().getString(R.l.gzJ, new Object[] { Integer.valueOf(i) }));
              localbu.aeXz.setTag(parama1);
              localbu.aeXB.aeXC.setTag(parama1);
              localbu.aeXz.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(255221);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                  localbu.aeXz.setVisibility(8);
                  paramAnonymousView = (bz)paramAnonymousView.getTag();
                  localObject = paramAnonymousView.hTm;
                  aq.a(aq.this, 2, (com.tencent.mm.storage.cc)localObject);
                  aq.a(aq.this, localbu, paramAnonymousView, paramAnonymousView.position);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(255221);
                }
              });
              localbu.aeXB.aeXC.setOnBackgroundCardClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(255652);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                  localbu.aeXz.setVisibility(8);
                  paramAnonymousView = (bz)localbu.aeXB.aeXC.getTag();
                  localObject = paramAnonymousView.hTm;
                  aq.a(aq.this, 3, (com.tencent.mm.storage.cc)localObject);
                  aq.a(aq.this, localbu, paramAnonymousView, paramAnonymousView.position);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(255652);
                }
              });
              localbu.timeTV.setVisibility(0);
              localbu.timeTV.setText(com.tencent.mm.pluginsdk.platformtools.f.d(parama.timeTV.getContext(), paramcc.getCreateTime(), false));
              localbu.aeXA.CAj.setVisibility(8);
              if (i > 0)
              {
                paramString = localbu.aeXB.aeXC;
                paramString.setBackgroundCardLayout(R.i.gft);
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
                  parama1 = new ap(LayoutInflater.from(localbu.aeXB.aeXC.getContext()), R.i.gfr);
                  parama1.setTag(new bw().lR(parama1));
                  paramString.c(parama1, new FrameLayout.LayoutParams(-2, -2));
                }
                parama = (bw)parama1.getTag();
                parama.checkBox.setVisibility(8);
                parama.timeTV.setVisibility(8);
                i = Util.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.is_pay_recepit"), 0);
                if (j == 0) {
                  break label912;
                }
                parama.aeXD.vJU.setVisibility(8);
                if (i != 1) {
                  break label886;
                }
                parama.aeXE.aeYg.setVisibility(8);
                parama.aeXF.aeYg.setVisibility(0);
                parama.aeXE = parama.aeXF;
                label826:
                a(parama, localMap, paramcc, paramInt, j);
                parama.aeXE.aeYg.setVisibility(0);
              }
            }
            for (;;)
            {
              localbu.aeXB.aeXC.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              i = parama1.zO(l2).size();
              break;
              label886:
              parama.aeXE.aeYg.setVisibility(0);
              parama.aeXF.aeYg.setVisibility(8);
              break label826;
              label912:
              parama.aeXE.aeYg.setVisibility(8);
              parama.aeXF.aeYg.setVisibility(8);
              a(parama, localMap, paramcc, paramInt);
              parama.aeXD.vJU.setVisibility(0);
            }
          }
          Log.i("MicroMsg.ChattingItemDyeingTemplate", "filling content of group, id: %d", new Object[] { Long.valueOf(l1) });
          localbu.vMH.setVisibility(8);
          localbu.timeTV.setVisibility(8);
          localbu.aeXA.CAj.setVisibility(8);
          localbu.aeXB.aeXC.setVisibility(8);
          AppMethodBeat.o(37242);
          return;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "normal msg, id: %d", new Object[] { Long.valueOf(l1) });
      }
      localbu.aeXA.CAj.setVisibility(0);
      localbu.aeXB.aeXC.setVisibility(8);
    }
    parama.aeXE = parama.aeXG;
    if (j != 0)
    {
      parama.aeXD.vJU.setVisibility(8);
      if (i == 1)
      {
        parama.aeXE.aeYg.setVisibility(8);
        parama.aeXF.aeYg.setVisibility(0);
        parama.aeXE = parama.aeXF;
      }
      for (;;)
      {
        a(parama, localMap, paramcc, paramInt, j);
        parama.aeXE.aeYg.setVisibility(0);
        AppMethodBeat.o(37242);
        return;
        parama.aeXE.aeYg.setVisibility(0);
        parama.aeXF.aeYg.setVisibility(8);
      }
    }
    parama.aeXE.aeYg.setVisibility(8);
    parama.aeXF.aeYg.setVisibility(8);
    a(parama, localMap, paramcc, paramInt);
    parama.aeXD.vJU.setVisibility(0);
    AppMethodBeat.o(37242);
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, com.tencent.mm.storage.cc paramcc, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    paramcc = ((com.tencent.mm.ui.chatting.component.api.g)parama1.cm(com.tencent.mm.ui.chatting.component.api.g.class)).bAK(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), paramcc, parama.userTV.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(37244);
    if (paramcc == null)
    {
      AppMethodBeat.o(37244);
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37244);
      return false;
      paramcc = com.tencent.mm.message.c.b.Ht(paramcc.field_content);
      if ((((q)parama.cm(q.class)).jrQ()) && (aDq(paramcc.opType)))
      {
        int i = paramcc.nRz;
        paramMenuItem = new StringBuilder();
        paramMenuItem.append(paramcc.title).append("\n");
        if (i != 0)
        {
          paramcc = paramcc.nVO;
          if ((paramcc != null) && (!paramcc.isEmpty()))
          {
            paramcc = paramcc.iterator();
            while (paramcc.hasNext())
            {
              b.a locala = (b.a)paramcc.next();
              paramMenuItem.append(locala.nVP).append(":").append(locala.nVQ).append("\n");
            }
            if (paramMenuItem.length() > 0) {
              paramMenuItem.setLength(paramMenuItem.length() - 1);
            }
            paramMenuItem = paramMenuItem.toString();
            ClipboardHelper.setText(MMApplicationContext.getContext(), paramMenuItem, paramMenuItem);
            Toast.makeText(parama.aezO.getContext(), R.l.app_copy_ok, 0).show();
          }
        }
        else if (!Util.isNullOrNil(paramcc.nUO))
        {
          paramMenuItem.append(paramcc.nUO);
          paramMenuItem = paramMenuItem.toString();
          ClipboardHelper.setText(MMApplicationContext.getContext(), paramMenuItem, paramMenuItem);
          Toast.makeText(parama.aezO.getContext(), R.l.app_copy_ok, 0).show();
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(255594);
    paramContextMenuInfo = (bz)paramView.getTag();
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(255594);
      return false;
    }
    int i = paramContextMenuInfo.position;
    paramContextMenuInfo = com.tencent.mm.message.c.b.Ht(paramcc.field_content);
    if ((((q)this.aeiK.cm(q.class)).jrQ()) && (aDq(paramContextMenuInfo.opType))) {
      params.a(i, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
    }
    if (!this.aeiK.juH()) {
      params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255594);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
  
  protected final boolean jxk()
  {
    return this.aeSN == 0;
  }
  
  static final class b
    extends bz
  {
    public String nUO;
    
    public b(String paramString)
    {
      this.nUO = paramString;
    }
  }
  
  static final class e
    implements View.OnLongClickListener
  {
    private com.tencent.mm.ui.widget.b.a GAa;
    private u.f aeMx;
    private boolean aeTL;
    private String aeTM;
    private String aeTN;
    private String aeTO;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    private u.i vGU;
    
    public e(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255413);
      this.aeiK = parama;
      this.aeMx = new u.f()
      {
        public final void OnCreateContextMMMenu(com.tencent.mm.ui.base.s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(255361);
          paramAnonymousView = (bz)paramAnonymousView.getTag();
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(255361);
            return;
          }
          int i = paramAnonymousView.position;
          if ((paramAnonymousView instanceof aq.f))
          {
            aq.e.a(aq.e.this, ((aq.f)paramAnonymousView).aeTQ.nVP);
            aq.e.b(aq.e.this, ((aq.f)paramAnonymousView).aeTQ.nVQ);
            aq.e.a(aq.e.this, false);
          }
          for (;;)
          {
            paramAnonymouss.a(i, 100, aq.e.a(aq.e.this).aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
            AppMethodBeat.o(255361);
            return;
            if ((paramAnonymousView instanceof aq.b))
            {
              aq.e.c(aq.e.this, ((aq.b)paramAnonymousView).nUO);
              aq.e.a(aq.e.this, true);
            }
          }
        }
      };
      this.vGU = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(255356);
          if (aq.e.b(aq.e.this)) {}
          for (paramAnonymousMenuItem = aq.e.c(aq.e.this);; paramAnonymousMenuItem = String.format("%s:%s", new Object[] { aq.e.d(aq.e.this), aq.e.e(aq.e.this) }))
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), paramAnonymousMenuItem, paramAnonymousMenuItem);
            Toast.makeText(aq.e.a(aq.e.this).aezO.getContext(), R.l.app_copy_ok, 0).show();
            AppMethodBeat.o(255356);
            return;
          }
        }
      };
      AppMethodBeat.o(255413);
    }
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(255451);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$LineDataLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      if ((bz)paramView.getTag() == null)
      {
        Log.w("MicroMsg.ChattingItemDyeingTemplate", "open menu but tag is null");
        if (paramView.findViewById(R.h.fMR) == null) {
          break label255;
        }
        paramView.findViewById(R.h.fMR).setBackgroundColor(paramView.getResources().getColor(R.e.BW_0_Alpha_0_1));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$LineDataLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(255451);
        return true;
        if (this.GAa != null)
        {
          this.GAa.diW();
          this.GAa = null;
        }
        this.GAa = new com.tencent.mm.ui.widget.b.a(this.aeiK.aezO.getContext());
        this.GAa.agjw = true;
        this.GAa.afLp = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(255393);
            if (paramView.findViewById(R.h.fMR) != null) {
              paramView.findViewById(R.h.fMR).setBackgroundResource(R.g.chatting_item_dyeing_line_data_bg);
            }
            for (;;)
            {
              aq.e.a(aq.e.this).aE(true);
              AppMethodBeat.o(255393);
              return;
              if (paramView.findViewById(R.h.fFR) != null) {
                paramView.findViewById(R.h.fFR).setBackgroundResource(R.g.chatting_item_dyeing_line_data_bg);
              }
            }
          }
        };
        localObject = new int[2];
        paramView.getLocationInWindow((int[])localObject);
        int i = localObject[0];
        int j = (int)(paramView.getWidth() / 2.0F);
        int k = localObject[1];
        this.GAa.a(paramView, this.aeMx, this.vGU, i + j, k);
        if (this.aeiK == null) {
          break;
        }
        this.aeiK.aE(false);
        this.aeiK.Mh(false);
        this.aeiK.aezV = false;
        break;
        label255:
        if (paramView.findViewById(R.h.fFR) != null) {
          paramView.findViewById(R.h.fFR).setBackgroundColor(paramView.getResources().getColor(R.e.BW_0_Alpha_0_1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq
 * JD-Core Version:    0.7.0.1
 */