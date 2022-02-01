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
import android.view.ContextMenu;
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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
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
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.o;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import d.g.b.v.e;
import d.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ag
  extends c
{
  private static int GNq;
  private static int GNr;
  private com.tencent.mm.aw.a.a.c FGx;
  private View.OnClickListener GIl;
  private View.OnClickListener GNg;
  private View.OnClickListener GNh;
  private View.OnClickListener GNi;
  private com.tencent.mm.ui.l GNj;
  private View.OnClickListener GNk;
  private String GNl;
  private int GNm;
  private com.tencent.mm.msgsubscription.storage.a GNn;
  private com.tencent.mm.msgsubscription.storage.a GNo;
  private String GNp;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private com.tencent.mm.sdk.b.c<nf> Gzy;
  private p ftP;
  private String mAppId;
  private View.OnClickListener pdN;
  private p yqi;
  
  static
  {
    AppMethodBeat.i(37267);
    GNq = aj.getContext().getResources().getColor(2131100212);
    GNr = aj.getContext().getResources().getColor(2131100212);
    AppMethodBeat.o(37267);
  }
  
  public ag()
  {
    AppMethodBeat.i(37240);
    this.GNp = "";
    Object localObject = new com.tencent.mm.aw.a.a.c.a();
    ((com.tencent.mm.aw.a.a.c.a)localObject).gkG = true;
    ((com.tencent.mm.aw.a.a.c.a)localObject).hkf = 2131231342;
    this.FGx = ((com.tencent.mm.aw.a.a.c.a)localObject).azc();
    localObject = com.tencent.mm.msgsubscription.storage.f.hHV;
    this.GNn = com.tencent.mm.msgsubscription.storage.f.AN("name_biz");
    localObject = com.tencent.mm.msgsubscription.storage.f.hHV;
    this.GNo = com.tencent.mm.msgsubscription.storage.f.AN("name_wxa");
    this.GNh = new a((byte)0);
    this.GNg = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        final com.tencent.mm.storage.bl localbl = (com.tencent.mm.storage.bl)paramAnonymousView.getTag(2131302771);
        if (localbl == null)
        {
          ad.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          AppMethodBeat.o(37198);
          return;
        }
        Object localObject = bw.K(localbl.field_content, "msg");
        if ((localObject == null) || (((Map)localObject).size() == 0))
        {
          AppMethodBeat.o(37198);
          return;
        }
        final String str = bt.nullAsNil((String)((Map)localObject).get(".msg.fromusername"));
        final int i = bt.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
        final int j = bt.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
        localObject = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(37193);
            paramAnonymous2l.add(0, 2, 0, paramAnonymousView.getResources().getString(2131761750));
            AppMethodBeat.o(37193);
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).HrY = new n.d()
        {
          public final void onMMMenuItemSelected(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(37197);
            ad.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(37197);
              return;
              az.aeS().a(1198, new com.tencent.mm.al.g()
              {
                public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, final String paramAnonymous3String, com.tencent.mm.al.n paramAnonymous3n)
                {
                  AppMethodBeat.i(37195);
                  az.aeS().b(1198, this);
                  ad.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, Boolean.FALSE });
                  if (ag.a(ag.this) != null)
                  {
                    ag.a(ag.this).dismiss();
                    ag.a(ag.this, null);
                  }
                  if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0))
                  {
                    t.makeText(ag.1.2.this.cFe.getContext(), 2131761751, 0).show();
                    AppMethodBeat.o(37195);
                    return;
                  }
                  paramAnonymous3String = ((s)paramAnonymous3n).atU();
                  if (paramAnonymous3String == null)
                  {
                    t.makeText(ag.1.2.this.cFe.getContext(), 2131761751, 0).show();
                    AppMethodBeat.o(37195);
                    return;
                  }
                  paramAnonymous3String = paramAnonymous3String.EKE;
                  ad.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { ag.1.2.this.Bql });
                  ((m)com.tencent.mm.kernel.g.ab(m.class)).a(ag.1.2.this.Bql, new m.a()
                  {
                    public final void b(WxaAttributes paramAnonymous4WxaAttributes)
                    {
                      AppMethodBeat.i(37194);
                      if (paramAnonymous4WxaAttributes == null)
                      {
                        t.makeText(ag.1.2.this.cFe.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                        return;
                      }
                      Object localObject = paramAnonymous4WxaAttributes.field_appId;
                      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous3String)))
                      {
                        ad.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous3String });
                        t.makeText(ag.1.2.this.cFe.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                        return;
                      }
                      try
                      {
                        paramAnonymous4WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous3String, "utf-8"), Integer.valueOf(1), Integer.valueOf(ag.1.2.this.GNu), Integer.valueOf(ag.1.2.this.jkN) });
                        ad.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous3String, localObject, paramAnonymous4WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous4WxaAttributes);
                        c.t((Intent)localObject, ag.b(ag.this).getTalkerUserName());
                        com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37194);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous4WxaAttributes)
                      {
                        ad.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ag.1.2.this.cFe.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                      }
                    }
                  });
                  AppMethodBeat.o(37195);
                }
              });
              paramAnonymous2MenuItem = new s(localbl.field_content);
              ag localag = ag.this;
              Context localContext = paramAnonymousView.getContext();
              paramAnonymousView.getResources().getString(2131755906);
              ag.a(localag, com.tencent.mm.ui.base.h.b(localContext, paramAnonymousView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(37196);
                  az.aeS().a(paramAnonymous2MenuItem);
                  AppMethodBeat.o(37196);
                }
              }));
              az.aeS().a(paramAnonymous2MenuItem, 0);
              ag.T(4, ag.c(ag.this), ag.d(ag.this));
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).csG();
        AppMethodBeat.o(37198);
      }
    };
    this.GNk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        paramAnonymousView = (bi)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = bw.K(paramAnonymousView.drF.field_content, "msg");
        Object localObject1 = bt.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), localObject1, Integer.valueOf(66666) });
        localObject1 = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bt.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!bt.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.t((Intent)localObject1, ag.b(ag.this).getTalkerUserName());
            com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
          AppMethodBeat.o(37215);
          return;
        }
        String str = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
        int i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
        int j = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
        localObject2 = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.dbt = (paramAnonymousView.drF.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + (String)localObject2);
        localAppBrandStatObject.scene = ag.aLg((String)localObject2);
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ag.b(ag.this).GzJ.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        AppMethodBeat.o(37215);
      }
    };
    this.GIl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37227);
        bi localbi = (bi)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[] { localbi.userName });
        Object localObject = bw.K(localbi.drF.field_content, "msg");
        if ((localObject != null) && (((Map)localObject).size() != 0)) {
          bt.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        }
        localObject = ag.this;
        paramAnonymousView.getContext();
        ag.a((ag)localObject, localbi.userName);
        AppMethodBeat.o(37227);
      }
    };
    this.Gzy = new com.tencent.mm.sdk.b.c() {};
    this.GNj = new com.tencent.mm.ui.l()
    {
      public final void eQA() {}
      
      public final void eQB() {}
      
      public final void eQC() {}
      
      public final void eQD() {}
      
      public final void eQE() {}
      
      public final void eQF()
      {
        AppMethodBeat.i(37230);
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        com.tencent.mm.sdk.b.a.ESL.d(ag.e(ag.this));
        if (ag.b(ag.this) != null) {
          ((com.tencent.mm.ui.chatting.c.b.h)ag.b(ag.this).be(com.tencent.mm.ui.chatting.c.b.h.class)).b(this);
        }
        AppMethodBeat.o(37230);
      }
      
      public final void eQG() {}
    };
    this.GNi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        bi localbi = (bi)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbi.userName });
        uj localuj = new uj();
        localuj.dzH.userName = localbi.userName;
        localuj.dzH.dzJ = localbi.jzG;
        Map localMap = bw.K(localbi.drF.field_content, "msg");
        String str = "";
        paramAnonymousView = str;
        if (localMap != null)
        {
          paramAnonymousView = str;
          if (localMap.size() > 0)
          {
            localuj.dzH.dzK = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localuj.dzH.dzN = true;
        localuj.dzH.scene = ag.aLg(paramAnonymousView);
        localuj.dzH.dbt = (localbi.drF.field_msgSvrId + ":" + localbi.userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + paramAnonymousView);
        com.tencent.mm.sdk.b.a.ESL.l(localuj);
        ag.T(9, ag.c(ag.this), ag.d(ag.this));
        com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), localbi.userName, Integer.valueOf(0) });
        AppMethodBeat.o(37231);
      }
    };
    this.pdN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = (bi)paramAnonymousView.getTag();
        Object localObject2 = bw.K(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).drF.field_content, "msg");
        if (localObject2 == null)
        {
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          AppMethodBeat.o(37232);
          return;
        }
        int i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        if (i == 1)
        {
          String str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
          String str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
          i = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          int j = bt.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = bt.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).dbt = (((bi)localObject1).drF.field_msgSvrId + ":" + ((bi)localObject1).userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(((bi)localObject1).userName))
          {
            ((AppBrandStatObject)localObject2).scene = ag.aLg(paramAnonymousView);
            ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ag.b(ag.this).GzJ.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
            ag.T(9, ag.c(ag.this), ag.d(ag.this));
            com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), ((bi)localObject1).userName, Integer.valueOf(0) });
            AppMethodBeat.o(37232);
            return;
          }
          ((AppBrandStatObject)localObject2).scene = 1043;
          paramAnonymousView = com.tencent.mm.am.f.ei(((bi)localObject1).userName);
          com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
          Activity localActivity = ag.b(ag.this).GzJ.getContext();
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
          {
            localn.a(localActivity, str1, null, j, i, str2, (AppBrandStatObject)localObject2, paramAnonymousView);
            break;
          }
        }
        if (i == 2)
        {
          localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
          long l = bt.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
          ag.c(paramAnonymousView.getContext(), (String)localObject1, l);
          ad.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
        }
        AppMethodBeat.o(37232);
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private static void S(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    ad.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.vKh.f(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bt.aGK()) });
    AppMethodBeat.o(37253);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.d.a parama, String paramString1, com.tencent.mm.storage.bl parambl, String paramString2)
  {
    AppMethodBeat.i(37246);
    if (paramImageView == null)
    {
      AppMethodBeat.o(37246);
      return;
    }
    if (w.to(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(37246);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramString1))
    {
      o.ayJ().a(paramString2, paramImageView, this.FGx);
      paramImageView.setTag(new bi(parambl, paramString1));
      paramImageView.setOnClickListener(this.GIl);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(v.sh(paramString1) + parama.GzJ.getContext().getString(2131756087));
      AppMethodBeat.o(37246);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
    if (parama.eZb()) {}
    for (parambl = parama.getTalkerUserName();; parambl = null)
    {
      paramImageView.setTag(new bi(paramString1, parambl));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(bn parambn, com.tencent.mm.storage.bl parambl, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    LinearLayout localLinearLayout = parambn.GRC;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      final String str1;
      final String str2;
      for (parambn = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambn = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str1 = (String)paramMap.get(parambn + ".word");
        str2 = (String)paramMap.get(parambn + ".hint_word");
        if (!bt.isNullOrNil(str1)) {
          break label193;
        }
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label1045;
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
      label193:
      Object localObject1;
      label212:
      Object localObject2;
      final int k;
      label377:
      final int m;
      if (i < j)
      {
        localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
        localObject1 = (a)((LinearLayout)localObject1).getTag();
        localObject2 = (String)paramMap.get(parambn + ".icon");
        k = ai.gO(e(paramMap, parambn + ".color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
        ((a)localObject1).fQp.setTextColor(k);
        if (bt.getInt((String)paramMap.get(parambn + ".is_rich_text"), 0) != 0) {
          break label846;
        }
        ((a)localObject1).fQp.setSingleLine(true);
        ((a)localObject1).fQp.setEllipsize(TextUtils.TruncateAt.END);
        ((a)localObject1).fQp.setText(str1);
        ((a)localObject1).igQ.setText(str2);
        if (!bt.isNullOrNil((String)localObject2)) {
          break label944;
        }
        ((a)localObject1).hg.setVisibility(8);
        ((a)localObject1).fQp.setPadding(0, 0, 0, 0);
        label417:
        localObject2 = (String)paramMap.get(parambn + ".url");
        str1 = bt.nullAsNil((String)paramMap.get(".msg.fromusername"));
        m = bt.getInt((String)paramMap.get(parambn + ".op_type"), 0);
        str2 = (String)paramMap.get(parambn + ".weapp_username");
        bi localbi = new bi(parambl, str1, (String)localObject2);
        ((a)localObject1).GHC.setTag(localbi);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty(str2))) {
          break label992;
        }
        localObject2 = (String)paramMap.get(parambn + ".weapp_path");
        m = bt.getInt((String)paramMap.get(parambn + ".weapp_version"), 0);
        final int n = bt.getInt((String)paramMap.get(parambn + ".weapp_state"), 0);
        parambn = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37225);
            paramAnonymousView = (bi)paramAnonymousView.getTag();
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.dbt = (paramAnonymousView.drF.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + this.GKI);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramAnonymousView.userName))
            {
              localAppBrandStatObject.scene = ag.aLg(this.GKI);
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ag.b(ag.this).GzJ.getContext(), str2, null, n, m, this.GNP, localAppBrandStatObject);
              ag.T(9, ag.c(ag.this), ag.d(ag.this));
              com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), str1, Integer.valueOf(k) });
              AppMethodBeat.o(37225);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.am.f.ei(paramAnonymousView.userName);
            com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
            Activity localActivity = ag.b(ag.this).GzJ.getContext();
            String str1 = str2;
            int i = n;
            int j = m;
            String str2 = this.GNP;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        };
        ((a)localObject1).GHC.setOnClickListener(parambn);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.Gob.GzJ.getContext()).inflate(2131493393, null, false);
        localObject2 = new a();
        ((a)localObject2).fQp = ((TextView)((LinearLayout)localObject1).findViewById(2131302757));
        ((a)localObject2).hg = ((ImageView)((LinearLayout)localObject1).findViewById(2131302756));
        ((a)localObject2).GHC = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131302754));
        ((a)localObject2).igQ = ((TextView)((LinearLayout)localObject1).findViewById(2131302755));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label212;
        label846:
        k = bt.getInt((String)paramMap.get(parambn + ".display_line_number"), 1);
        ad.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
        ((a)localObject1).fQp.setSingleLine(false);
        ((a)localObject1).fQp.setText(str1);
        ((a)localObject1).fQp.setMaxLines(k);
        com.tencent.mm.pluginsdk.ui.span.k.a(((a)localObject1).fQp, false, null);
        break label377;
        label944:
        ((a)localObject1).hg.setVisibility(0);
        l(((a)localObject1).hg, (String)localObject2);
        ((a)localObject1).fQp.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 28), 0);
        break label417;
        label992:
        if (m == 2) {
          ((a)localObject1).GHC.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37226);
              if (k == 1)
              {
                String str = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                long l = bt.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                ag.c(paramAnonymousView.getContext(), str, l);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 2L, 1L, false);
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str, Long.valueOf(l) });
                AppMethodBeat.o(37226);
                return;
              }
              if (k == 2) {
                com.tencent.mm.bs.d.e(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
              }
              AppMethodBeat.o(37226);
            }
          });
        } else {
          ((a)localObject1).GHC.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(169893);
              if (!bt.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                c.t(paramAnonymousView, ag.b(ag.this).getTalkerUserName());
                com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), str1, Integer.valueOf(k) });
              }
              AppMethodBeat.o(169893);
            }
          });
        }
      }
    }
    label1045:
    AppMethodBeat.o(37251);
  }
  
  private void a(bn parambn, String paramString1, String paramString2, Map<String, String> paramMap, com.tencent.mm.storage.bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    parambn.GRl.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.Gob.GzJ.getContext(), paramString2, parambn.GRl.getTextSize()));
    o.ayJ().a(paramString1, parambn.GRk, this.FGx);
    parambn.GRk.setTag(null);
    parambn.GRk.setOnClickListener(null);
    parambn.GRj.setTag(null);
    parambn.GRj.setOnClickListener(null);
    parambn.GRj.setVisibility(0);
    paramString1 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bt.isNullOrNil(paramString1)) || (!bt.isNullOrNil(paramString2)))
    {
      paramString1 = bt.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambn.GRj.setTag(new bi(parambl, paramString1));
      parambn.GRj.setOnClickListener(this.GNk);
    }
    for (;;)
    {
      paramString1 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bt.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambn.GRn.getParent()).setVisibility(0);
      o.ayJ().a(paramString1, parambn.GRn, this.FGx);
      AppMethodBeat.o(37247);
      return;
      parambn.GRj.setOnClickListener(null);
    }
    ((View)parambn.GRn.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(bn parambn, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37250);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    Object localObject1;
    label37:
    Object localObject2;
    Object localObject3;
    label222:
    int k;
    if (j < 100)
    {
      if (j == 0)
      {
        localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
        localObject2 = (String)paramMap.get((String)localObject1 + ".value.word");
        localObject3 = (String)paramMap.get((String)localObject1 + ".key.word");
        if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject3))) {
          break label352;
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
      localObject2 = parambn.GRz;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)parambn.GRz.getParent()).findViewById(2131298909);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((LinearLayout)localObject2).getChildCount() > localArrayList.size())
      {
        if (localArrayList.size() != 0) {
          break label812;
        }
        ((LinearLayout)localObject2).removeAllViews();
      }
      k = ((LinearLayout)localObject2).getChildCount();
      i = 0;
      label231:
      if (i >= localArrayList.size()) {
        break label977;
      }
      localObject3 = (bk)localArrayList.get(i);
      if (i >= k) {
        break label842;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject2).getChildAt(i);
      label272:
      localObject1 = (bl)((LinearLayout)localObject1).getTag();
      if (!((bk)localObject3).GRd) {
        break label926;
      }
      ((bl)localObject1).GRe.setVisibility(8);
    }
    for (;;)
    {
      ((bl)localObject1).GRf.setTextColor(ai.gO(((bk)localObject3).GRc));
      ((bl)localObject1).GRf.setText(((bk)localObject3).GRa);
      i += 1;
      break label231;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label352:
      Object localObject4 = new bk();
      ((bk)localObject4).GRa = ((String)localObject2);
      ((bk)localObject4).GQZ = bt.nullAsNil((String)localObject3);
      label516:
      boolean bool;
      if (!ai.Eq())
      {
        ((bk)localObject4).GRb = e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".key.color", GNq));
        ((bk)localObject4).GRc = e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".value.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
        if (bt.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label803;
        }
        bool = true;
        label556:
        ((bk)localObject4).GRd = bool;
        k = (aLf(((bk)localObject4).GQZ) + 1) / 2;
        if (k <= i) {
          break label809;
        }
        i = k;
      }
      label803:
      label809:
      for (;;)
      {
        localArrayList.add(localObject4);
        j += 1;
        break;
        ((bk)localObject4).GRb = e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".key.color", GNq)));
        ((bk)localObject4).GRc = e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".value.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711))));
        ((bk)localObject4).GRc = ai.gO(((bk)localObject4).GRc);
        break label516;
        bool = false;
        break label556;
      }
      label812:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label222;
      label842:
      localObject1 = (LinearLayout)LayoutInflater.from(this.Gob.GzJ.getContext()).inflate(2131493394, null, false);
      localObject4 = new bl();
      ((bl)localObject4).GRe = ((TextView)((LinearLayout)localObject1).findViewById(2131301424));
      ((bl)localObject4).GRf = ((TextView)((LinearLayout)localObject1).findViewById(2131301431));
      ((LinearLayout)localObject1).setTag(localObject4);
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label272;
      label926:
      ((bl)localObject1).GRe.setVisibility(0);
      ((bl)localObject1).GRe.setEms(j);
      ((bl)localObject1).GRe.setTextColor(ai.gO(((bk)localObject3).GRb));
      ((bl)localObject1).GRe.setText(((bk)localObject3).GQZ);
    }
    label977:
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      parambn.GRy.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(37250);
      return;
    }
    if (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      parambn.GRy.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(37250);
      return;
      parambn.GRy.setVisibility(0);
    }
  }
  
  private void a(final Map<String, String> paramMap, final com.tencent.mm.storage.bl parambl, final bn parambn, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(37249);
    ad.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), this.GNl, this.GNp, Boolean.valueOf(paramBoolean2) });
    parambn.GRP.setVisibility(0);
    if ((paramBoolean1) || ((paramBoolean3) && (!paramBoolean2)))
    {
      parambn.GRm.setVisibility(0);
      localTextView = parambn.GRQ;
      localResources = this.Gob.GzJ.getMMResources();
      if (paramBoolean3) {}
      for (i = 2131761768;; i = 2131761761)
      {
        localTextView.setText(localResources.getString(i));
        parambn.GRP.setTag(2131302745, parambl);
        parambn.GRP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 1;
            AppMethodBeat.i(169886);
            paramAnonymousView = bt.nullAsNil((String)paramMap.get(".msg.fromusername"));
            if (paramBoolean3)
            {
              int i;
              if ((!paramBoolean1) && (paramBoolean2))
              {
                ag.a(ag.this, paramBoolean1, paramBoolean3, parambl, paramMap, paramAnonymousView, parambn, paramBoolean2);
                i = 1;
              }
              for (;;)
              {
                Object localObject = com.tencent.mm.msgsubscription.b.a.hHk;
                localObject = ag.d(ag.this);
                if (paramBoolean1) {
                  j = 0;
                }
                com.tencent.mm.msgsubscription.b.a.a(paramAnonymousView, i, (String)localObject, j, ag.f(ag.this));
                AppMethodBeat.o(169886);
                return;
                if (paramBoolean2)
                {
                  ag.a(ag.this, paramBoolean1, paramBoolean3, parambl, paramMap, paramAnonymousView, parambn, paramBoolean2);
                  i = 1;
                }
                else
                {
                  i = 2;
                  ag.b(ag.this, paramAnonymousView);
                }
              }
            }
            if (!paramBoolean1)
            {
              ag.a(ag.this, paramBoolean1, paramBoolean3, parambl, paramMap, paramAnonymousView, parambn, paramBoolean2);
              AppMethodBeat.o(169886);
              return;
            }
            ag.b(ag.this, paramAnonymousView);
            AppMethodBeat.o(169886);
          }
        });
        AppMethodBeat.o(37249);
        return;
      }
    }
    parambn.GRm.setVisibility(8);
    TextView localTextView = parambn.GRQ;
    Resources localResources = this.Gob.GzJ.getMMResources();
    if (paramBoolean3) {}
    for (int i = 2131761766;; i = 2131761736)
    {
      localTextView.setText(localResources.getString(i));
      break;
    }
  }
  
  private static int aLe(String paramString)
  {
    AppMethodBeat.i(37248);
    String str = paramString;
    if (paramString == null) {
      str = "-1";
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      i = bt.i(Integer.valueOf(i), -1);
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
  
  private static int aLf(String paramString)
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
  
  private static int e(Map<String, String> paramMap, String paramString, int paramInt)
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
    az.arV();
    ((com.tencent.mm.aw.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.apX();
    ((com.tencent.mm.aw.a.a.c.a)localObject).hjU = true;
    ((com.tencent.mm.aw.a.a.c.a)localObject).gjA = true;
    localObject = ((com.tencent.mm.aw.a.a.c.a)localObject).azc();
    o.ayJ().a(paramString, paramImageView, (com.tencent.mm.aw.a.a.c)localObject);
    AppMethodBeat.o(37252);
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
      localObject = new af(paramLayoutInflater, 2131493426);
      paramLayoutInflater = new bg();
      paramLayoutInflater.hIS = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramLayoutInflater.lRB = ((View)localObject).findViewById(2131298147);
      paramLayoutInflater.wet = ((TextView)((View)localObject).findViewById(2131298185));
      paramLayoutInflater.GHW = ((AvatarImageView)((View)localObject).findViewById(2131298056));
      paramLayoutInflater.fwS = ((TextView)((View)localObject).findViewById(2131298178));
      paramLayoutInflater.nat = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramLayoutInflater.GQH.mYI = ((View)localObject).findViewById(2131298119);
      paramLayoutInflater.GQH.GQK = ((View)localObject).findViewById(2131300702);
      paramLayoutInflater.GQH.fQp = ((TextView)paramLayoutInflater.GQH.mYI.findViewById(2131305902));
      paramLayoutInflater.GQH.GQN = ((LinearLayout)paramLayoutInflater.GQH.mYI.findViewById(2131299136));
      paramLayoutInflater.GQH.mWn = ((TextView)paramLayoutInflater.nat.findViewById(2131299035));
      paramLayoutInflater.GQH.GQO = paramLayoutInflater.nat.findViewById(2131304592);
      paramLayoutInflater.GQH.GQL = ((View)localObject).findViewById(2131302486);
      paramLayoutInflater.GQH.GQM = ((View)localObject).findViewById(2131302487);
      paramLayoutInflater.GQI.GRh = ((View)localObject).findViewById(2131298118);
      paramLayoutInflater.GQI.GRi = ((ImageView)((View)localObject).findViewById(2131302769));
      paramLayoutInflater.GQI.GRj = ((View)localObject).findViewById(2131302767);
      paramLayoutInflater.GQI.GRl = ((TextView)((View)localObject).findViewById(2131302785));
      paramLayoutInflater.GQI.GRk = ((ImageView)((View)localObject).findViewById(2131302743));
      paramLayoutInflater.GQI.GRm = ((View)localObject).findViewById(2131302746);
      paramLayoutInflater.GQI.GRn = ((ImageView)((View)localObject).findViewById(2131302773));
      paramLayoutInflater.GQI.GRo = ((View)localObject).findViewById(2131302771);
      paramLayoutInflater.GQI.GRp = ((View)localObject).findViewById(2131302772);
      paramLayoutInflater.GQI.GRq = ((TextView)((View)localObject).findViewById(2131302778));
      paramLayoutInflater.GQI.GRr = ((TextView)((View)localObject).findViewById(2131302766));
      paramLayoutInflater.GQI.GRs = ((View)localObject).findViewById(2131302768);
      paramLayoutInflater.GQI.GRt = ((LinearLayout)((View)localObject).findViewById(2131302779));
      paramLayoutInflater.GQI.GRu = ((TextView)((View)localObject).findViewById(2131302781));
      paramLayoutInflater.GQI.GRw = ((TextView)((View)localObject).findViewById(2131302782));
      paramLayoutInflater.GQI.GRv = ((TextView)((View)localObject).findViewById(2131302783));
      paramLayoutInflater.GQI.GRx = ((TextView)((View)localObject).findViewById(2131302784));
      paramLayoutInflater.GQI.GRy = ((View)localObject).findViewById(2131302780);
      paramLayoutInflater.GQI.GRz = ((LinearLayout)((View)localObject).findViewById(2131302770));
      paramLayoutInflater.GQI.GRD = ((View)localObject).findViewById(2131302760);
      paramLayoutInflater.GQI.GRA = ((View)localObject).findViewById(2131297440);
      paramLayoutInflater.GQI.GRB = ((LinearLayout)((View)localObject).findViewById(2131302758));
      paramLayoutInflater.GQI.GRC = ((LinearLayout)((View)localObject).findViewById(2131299239));
      paramLayoutInflater.GQI.GRE = ((LinearLayout)((View)localObject).findViewById(2131302748));
      paramLayoutInflater.GQI.GRH = ((TextView)((View)localObject).findViewById(2131302750));
      paramLayoutInflater.GQI.GRJ = ((ImageView)((View)localObject).findViewById(2131302749));
      paramLayoutInflater.GQI.GRG = ((View)localObject).findViewById(2131302759);
      paramLayoutInflater.GQI.GRF = ((LinearLayout)((View)localObject).findViewById(2131302751));
      paramLayoutInflater.GQI.GRI = ((TextView)((View)localObject).findViewById(2131302753));
      paramLayoutInflater.GQI.GRK = ((ImageView)((View)localObject).findViewById(2131302752));
      paramLayoutInflater.GQI.GRL = ((ImageView)((View)localObject).findViewById(2131302742));
      paramLayoutInflater.GIW = ((ImageView)((View)localObject).findViewById(2131298117));
      paramLayoutInflater.GQI.GRM = ((View)localObject).findViewById(2131302774);
      paramLayoutInflater.GQI.GRN = ((ImageView)((View)localObject).findViewById(2131302775));
      paramLayoutInflater.GQI.GRO = ((TextView)((View)localObject).findViewById(2131302776));
      paramLayoutInflater.GQI.GRP = ((LinearLayout)((View)localObject).findViewById(2131302744));
      paramLayoutInflater.GQI.GRQ = ((TextView)((View)localObject).findViewById(2131302745));
      paramLayoutInflater.GQJ.GHD = ((LinearLayout)((View)localObject).findViewById(2131302763));
      paramLayoutInflater.GQJ.GHE = ((CdnImageView)((View)localObject).findViewById(2131302762));
      paramLayoutInflater.GQJ.GHF = ((TextView)((View)localObject).findViewById(2131302764));
      paramLayoutInflater.GQJ.GHG = ((TextView)((View)localObject).findViewById(2131302761));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final com.tencent.mm.storage.bl parambl, final String paramString)
  {
    AppMethodBeat.i(37242);
    this.Gob = parama1;
    GNq = parama1.GzJ.getContext().getResources().getColor(2131100212);
    GNr = parama1.GzJ.getContext().getResources().getColor(2131100212);
    bg localbg = (bg)parama;
    final Map localMap = bw.K(parambl.field_content, "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localbg.nat.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    localbg.nat.setVisibility(0);
    final int j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.GNl = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.GNm = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.ESL.d(this.Gzy);
    ((com.tencent.mm.ui.chatting.c.b.h)parama1.be(com.tencent.mm.ui.chatting.c.b.h.class)).b(this.GNj);
    Object localObject1;
    if (j != 0)
    {
      localbg.GQH.mYI.setVisibility(8);
      localObject1 = localbg.GQI;
      if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bn)localObject1, bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambl, false);
        if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2825;
        }
        ((bn)localObject1).GRj.setBackgroundResource(2131233299);
        label325:
        if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6498;
        }
      }
    }
    label517:
    label539:
    label607:
    label3807:
    label6241:
    label6498:
    for (int i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      final int k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      ((bn)localObject1).GRq.setVisibility(8);
      if ((i == 0) && (k == 0))
      {
        ((bn)localObject1).GRq.setVisibility(0);
        this.GNp = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = e(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        ((bn)localObject1).GRq.setTextColor(ai.gO(k));
        ((bn)localObject1).GRq.setText(this.GNp);
      }
      parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = e(localMap, ".msg.appmsg.mmreader.template_header.first_color", GNr);
      Object localObject2;
      Object localObject3;
      if (bt.isNullOrNil(parama))
      {
        ((bn)localObject1).GRr.setVisibility(8);
        if ((i == 0) || (!bt.isNullOrNil(parama))) {
          break label2944;
        }
        ((bn)localObject1).GRs.setVisibility(8);
        parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
        if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(parama)) {
          break label3207;
        }
        i = aLe((String)localMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
        if ((i != 2) && (i != 3)) {
          break label2956;
        }
        i = 1;
        if ("notifymessage".equals(parambl.field_talker))
        {
          parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
          ((com.tencent.mm.ui.chatting.c.b.h)this.Gob.be(com.tencent.mm.ui.chatting.c.b.h.class)).a(this.GNj);
          com.tencent.mm.sdk.b.a.ESL.c(this.Gzy);
          if (i == 0) {
            break label3093;
          }
          parama = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(parama1);
          if (parama == null) {
            break label2962;
          }
          this.mAppId = parama.field_appId;
          ((bn)localObject1).GRP.setVisibility(0);
          ((bn)localObject1).GRm.setVisibility(8);
          ((bn)localObject1).GRQ.setText(this.Gob.GzJ.getMMResources().getString(2131761766));
          parama = com.tencent.mm.msgsubscription.storage.a.hHo;
          paramString = this.GNl;
          parama = ((bn)localObject1).GRP.hashCode();
          d.g.b.k.h(paramString, "templateId");
          d.g.b.k.h(parama, "viewKey");
          localObject2 = (HashMap)com.tencent.mm.msgsubscription.storage.a.aEp().get(paramString);
          if (localObject2 != null) {
            ((HashMap)localObject2).remove(parama);
          }
          if (localObject2 == null) {
            break label2988;
          }
          parama = Integer.valueOf(((HashMap)localObject2).size());
          ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString, parama });
          parama = com.tencent.mm.msgsubscription.storage.a.hHo;
          paramString = this.GNl;
          localObject2 = ((bn)localObject1).GRP.hashCode();
          localObject3 = new IBrandSubscribeMsgService.b()
          {
            public final void c(String paramAnonymousString, IBrandSubscribeMsgService.c paramAnonymousc)
            {
              boolean bool = false;
              AppMethodBeat.i(169882);
              if (paramAnonymousString.equals(ag.d(ag.this)))
              {
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", new Object[] { parama1, paramAnonymousString, Boolean.valueOf(paramAnonymousc.hHQ), Boolean.valueOf(paramAnonymousc.hHR) });
                paramAnonymousString = ag.this;
                Map localMap = localMap;
                com.tencent.mm.storage.bl localbl = parambl;
                bn localbn = this.GND;
                if (!paramAnonymousc.hHQ) {
                  bool = true;
                }
                ag.a(paramAnonymousString, localMap, localbl, localbn, bool, paramAnonymousc.hHR, true);
              }
              AppMethodBeat.o(169882);
            }
            
            public final void onError()
            {
              AppMethodBeat.i(169883);
              ad.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
              AppMethodBeat.o(169883);
            }
          };
          d.g.b.k.h(paramString, "templateId");
          d.g.b.k.h(localObject2, "viewKey");
          d.g.b.k.h(localObject3, "callback");
          parama = (HashMap)com.tencent.mm.msgsubscription.storage.a.aEp().get(paramString);
          if (parama != null) {
            break label6495;
          }
          parama = new HashMap();
        }
      }
      for (;;)
      {
        ((Map)parama).put(localObject2, localObject3);
        ((Map)com.tencent.mm.msgsubscription.storage.a.aEp()).put(paramString, parama);
        ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString, Integer.valueOf(parama.size()) });
        parama = this.GNo;
        paramString = this.GNl;
        d.g.b.k.h(parama1, "bizUsername");
        d.g.b.k.h(paramString, "templateId");
        localObject2 = parama.hHm;
        d.g.b.k.h(parama1, "bizUsername");
        d.g.b.k.h(paramString, "templateId");
        localObject3 = ((com.tencent.mm.msgsubscription.storage.e)localObject2).hHS.bd(parama1, paramString);
        localObject2 = new v.e();
        ((v.e)localObject2).Jhw = localObject3;
        Object localObject4 = parama.hHm;
        d.g.b.k.h(parama1, "bizUsername");
        boolean bool2 = ((com.tencent.mm.msgsubscription.storage.e)localObject4).hHS.xx(parama1);
        boolean bool1;
        if (localObject3 != null)
        {
          ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject3).hGw) });
          if (((SubscribeMsgTmpItem)localObject3).hGw == 1)
          {
            bool1 = true;
            com.tencent.mm.msgsubscription.storage.a.a(paramString, new IBrandSubscribeMsgService.c(bool1, bool2));
            localObject3 = (SubscribeMsgTmpItem)((v.e)localObject2).Jhw;
            localObject2 = (SubscribeMsgTmpItem)((v.e)localObject2).Jhw;
            if (localObject2 == null) {
              break label2999;
            }
            i = ((SubscribeMsgTmpItem)localObject2).hGw;
            parama.a((SubscribeMsgTmpItem)localObject3, new com.tencent.mm.msgsubscription.storage.a.b(parama1, paramString, i));
            ((bn)localObject1).GRo.setVisibility(0);
            ((bn)localObject1).GRo.setTag(2131302771, parambl);
            ((bn)localObject1).GRo.setOnClickListener(this.GNg);
            label1255:
            ((bn)localObject1).GRi.setVisibility(8);
            parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
            ((bn)localObject1).GRr.setText(parama);
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bt.isNullOrNil(parama1)) {
              break label3287;
            }
            i = ai.gO(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
            j = ai.gO(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
            k = ai.gO(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
            int m = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
            ((bn)localObject1).GRu.setTextColor(i);
            ((bn)localObject1).GRw.setTextColor(j);
            ((bn)localObject1).GRx.setTextColor(k);
            ((bn)localObject1).GRx.getPaint().setFlags(16);
            ((bn)localObject1).GRu.setText(parama);
            if ((m <= 0) || (m >= parama1.length())) {
              break label3230;
            }
            ((bn)localObject1).GRv.setVisibility(0);
            ((bn)localObject1).GRv.setText(parama1.substring(0, m));
            ((bn)localObject1).GRv.setTextColor(j);
            ((bn)localObject1).GRv.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fy(this.Gob.GzJ.getContext()));
            ((bn)localObject1).GRw.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fy(this.Gob.GzJ.getContext()));
            ((bn)localObject1).GRw.setText(parama1.substring(m));
            label1634:
            if (bt.isNullOrNil(paramString)) {
              break label3274;
            }
            ((bn)localObject1).GRx.setText(paramString);
            ((bn)localObject1).GRx.setVisibility(0);
            label1661:
            ((bn)localObject1).GRt.setVisibility(0);
            i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i != 2) {
              break label3452;
            }
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
            ((bn)localObject1).GRz.setVisibility(8);
            parama1 = (ViewGroup)((bn)localObject1).GRz.getParent();
            parama = parama1.findViewById(2131298909);
            if (parama != null) {
              break label6492;
            }
            parama = LayoutInflater.from(parama1.getContext()).inflate(2131495249, null);
            paramString = new bf();
            paramString.hg = ((ImageView)parama.findViewById(2131296996));
            paramString.GQG = ((TextView)parama.findViewById(2131302863));
            paramString.fQp = ((TextView)parama.findViewById(2131305902));
            parama.setTag(paramString);
            parama1.addView(parama);
          }
        }
        for (;;)
        {
          parama.setVisibility(0);
          paramString = (bf)parama.getTag();
          parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
          localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
          parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
          localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
          j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
          paramString.fQp.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.fQp.getContext(), parama));
          localObject3 = paramString.GQG;
          localObject4 = paramString.fQp.getContext();
          if (bt.isNullOrNil((String)localObject2)) {
            parama = "";
          }
          for (;;)
          {
            ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, parama));
            Object localObject5;
            if (j == 2)
            {
              paramString.hg.setImageDrawable(aj.getContext().getResources().getDrawable(2131230943));
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
                break label3463;
              }
              ((bn)localObject1).GRM.setVisibility(8);
              ((bn)localObject1).GRB.setVisibility(8);
              ((bn)localObject1).GRD.setVisibility(8);
              ((bn)localObject1).GRC.setVisibility(0);
              ((bn)localObject1).GRA.setVisibility(0);
              a((bn)localObject1, parambl, localMap);
              paramString = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
              parama = null;
              if (!bt.isNullOrNil(paramString))
              {
                az.arV();
                parama = com.tencent.mm.model.c.apM().aHY(paramString).ZW();
              }
              localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
              localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
              parama1 = (String)localMap.get(".msg.appmsg.template_id");
              localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject5))) {
                break label4951;
              }
              paramString = new bi(parambl, paramString, (String)localObject4);
              paramString.position = paramInt;
              ((bn)localObject1).GRh.setTag(paramString);
              ((bn)localObject1).GRh.setOnClickListener(this.pdN);
              ((bn)localObject1).GRh.setOnLongClickListener(c(this.Gob));
              ((bn)localObject1).GRh.setOnTouchListener(((i)this.Gob.be(i.class)).eWp());
              if (com.tencent.mm.m.g.Ze().YS())
              {
                localbg.GIW.setVisibility(0);
                c(this.Gob, localbg.GIW, new s.o(parama1, parambl, parama));
              }
              parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
              if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(parama)) || (!"notifymessage".equals(parambl.field_talker))) {
                break label5182;
              }
              ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
              ((bn)localObject1).GRp.setTag(null);
              ((bn)localObject1).GRp.setVisibility(8);
            }
            for (;;)
            {
              localbg.GQI.GRh.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
              {
                a((bn)localObject1, bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambl, true);
                break;
              }
              ((View)((bn)localObject1).GRn.getParent()).setVisibility(8);
              if ("notifymessage".equals(parambl.field_talker))
              {
                parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(parama1))
                {
                  paramString = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(parama1);
                  if (paramString == null)
                  {
                    parama = null;
                    a(((bn)localObject1).GRk, this.Gob, parama1, parambl, parama);
                    if (paramString != null) {
                      break label2700;
                    }
                    parama = parama1;
                  }
                }
                for (;;)
                {
                  ((bn)localObject1).GRl.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.Gob.GzJ.getContext(), parama, ((bn)localObject1).GRl.getTextSize()));
                  if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(parama1)) {
                    break label2749;
                  }
                  ((bn)localObject1).GRj.setTag(new bi(parambl, parama1));
                  ((bn)localObject1).GRj.setOnClickListener(this.GIl);
                  ((bn)localObject1).GRj.setVisibility(0);
                  break;
                  parama = paramString.field_brandIconURL;
                  break label2577;
                  parama = paramString.field_nickname;
                  continue;
                  a(((bn)localObject1).GRk, this.Gob, parama1, parambl, null);
                  parama = ((com.tencent.mm.ui.chatting.c.b.f)this.Gob.be(com.tencent.mm.ui.chatting.c.b.f.class)).aKG(parama1);
                }
                paramString = ((bn)localObject1).GRj;
                if (this.Gob.eZb()) {}
                for (parama = this.Gob.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bi(parama1, parama));
                  ((bn)localObject1).GRj.setOnClickListener(e(this.Gob));
                  break;
                }
              }
              ((bn)localObject1).GRj.setVisibility(8);
              break;
              i = ((bn)localObject1).GRj.getPaddingLeft();
              ((bn)localObject1).GRj.setBackgroundResource(2131232867);
              ((bn)localObject1).GRj.setPadding(i, 0, 0, 0);
              break label325;
              ((bn)localObject1).GRr.setTextColor(ai.gO(k));
              ((bn)localObject1).GRr.setText(parama);
              ((bn)localObject1).GRr.setVisibility(0);
              if (j == 2)
              {
                ((bn)localObject1).GRr.setPadding(0, this.Gob.GzJ.getMMResources().getDimensionPixelOffset(2131165480), 0, 0);
                break label517;
              }
              ((bn)localObject1).GRr.setPadding(0, 0, 0, 0);
              break label517;
              ((bn)localObject1).GRs.setVisibility(0);
              break label539;
              i = 0;
              break label607;
              ((m)com.tencent.mm.kernel.g.ab(m.class)).a(parama1, new m.a()
              {
                public final void b(WxaAttributes paramAnonymousWxaAttributes)
                {
                  AppMethodBeat.i(169881);
                  if (paramAnonymousWxaAttributes != null)
                  {
                    ad.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ag.c(ag.this) });
                    ag.c(ag.this, paramAnonymousWxaAttributes.field_appId);
                  }
                  AppMethodBeat.o(169881);
                }
              });
              break label704;
              parama = null;
              break label833;
              bool1 = false;
              break label1155;
              i = -1;
              break label1203;
              ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from local");
              localObject3 = parama.hHm;
              parama = (e.b)new a.d(parama, paramString, (v.e)localObject2);
              d.g.b.k.h(parama1, "username");
              ad.i("Mp.SubscribeMsgDataLoader", "alvinluo loadSubscribeMsgListByUsername username: %s", new Object[] { parama1 });
              paramString = com.tencent.mm.msgsubscription.storage.g.hHX;
              com.tencent.mm.msgsubscription.storage.g.a(((com.tencent.mm.msgsubscription.storage.e)localObject3).hHS, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.f(parama1, ((com.tencent.mm.msgsubscription.storage.e)localObject3).hHS, parama));
              break label1221;
              parama = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(parama1);
              if (parama != null)
              {
                this.mAppId = parama.field_appId;
                if ((parama.field_appOpt & 0x1) > 0) {
                  bool1 = true;
                }
              }
              for (;;)
              {
                a(localMap, parambl, (bn)localObject1, bool1, false, false);
                break;
                bool1 = false;
                continue;
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama1 });
                ((m)com.tencent.mm.kernel.g.ab(m.class)).a(parama1, new m.a()
                {
                  public final void b(WxaAttributes paramAnonymousWxaAttributes)
                  {
                    AppMethodBeat.i(169885);
                    if (paramAnonymousWxaAttributes == null)
                    {
                      AppMethodBeat.o(169885);
                      return;
                    }
                    ag.c(ag.this, paramAnonymousWxaAttributes.field_appId);
                    if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0) {}
                    for (final boolean bool = true;; bool = false)
                    {
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(169884);
                          ag.a(ag.this, ag.8.this.foD, ag.8.this.gLQ, ag.8.this.GND, bool, false, false);
                          AppMethodBeat.o(169884);
                        }
                      });
                      AppMethodBeat.o(169885);
                      return;
                    }
                  }
                });
                bool1 = false;
              }
              ((bn)localObject1).GRP.setVisibility(8);
              ((bn)localObject1).GRm.setVisibility(8);
              break label1255;
              ((bn)localObject1).GRv.setTypeface(Typeface.DEFAULT);
              ((bn)localObject1).GRv.setVisibility(8);
              ((bn)localObject1).GRw.setTypeface(Typeface.DEFAULT);
              ((bn)localObject1).GRw.setText(parama1);
              break label1634;
              ((bn)localObject1).GRx.setVisibility(8);
              break label1661;
              ((bn)localObject1).GRt.setVisibility(8);
              break label1670;
              parama = null;
              if (w.pF((String)localObject2))
              {
                az.arV();
                localObject5 = com.tencent.mm.model.c.apM().aHY((String)localObject2);
                if (localObject5 != null)
                {
                  if (((com.tencent.mm.storage.af)localObject5).ZX() != null) {
                    break label3392;
                  }
                  parama = ((com.tencent.mm.storage.af)localObject5).ZW();
                }
              }
              for (;;)
              {
                if (!bt.isNullOrNil(parama)) {
                  break label6489;
                }
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
                parama = parama1;
                if (parama1 != null) {
                  break;
                }
                parama = aj.getContext().getString(2131757293);
                break;
                parama = ((com.tencent.mm.storage.af)localObject5).ZX();
                continue;
                az.arV();
                parama = com.tencent.mm.model.c.apM().aHY((String)localObject2);
                if (parama.ZX() == null) {
                  parama = parama.ZW();
                } else {
                  parama = parama.ZX();
                }
              }
              com.tencent.mm.pluginsdk.ui.a.b.c(paramString.hg, (String)localObject2);
              break label1989;
              label3452:
              a((bn)localObject1, localMap);
              break label1989;
              ((bn)localObject1).GRC.setVisibility(8);
              parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
              parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
              if (!bt.isNullOrNil(parama1))
              {
                j = ai.gO(e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
                ((bn)localObject1).GRH.setTextColor(j);
                ((bn)localObject1).GRH.setText(parama1);
                if (bt.isNullOrNil(parama))
                {
                  ((bn)localObject1).GRJ.setVisibility(8);
                  ((bn)localObject1).GRH.setPadding(0, 0, 0, 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                  parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  localObject3 = new bi(parambl, parama1, (String)localObject2);
                  ((bn)localObject1).GRE.setTag(localObject3);
                  ((bn)localObject1).GRM.setTag(localObject3);
                  if ((j != 1) || (TextUtils.isEmpty(paramString))) {
                    break label4499;
                  }
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                  j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                  k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                  parama1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37219);
                      paramAnonymousView = (bi)paramAnonymousView.getTag();
                      ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                      localAppBrandStatObject.dbt = (paramAnonymousView.drF.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + this.GKI);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramAnonymousView.userName))
                      {
                        localAppBrandStatObject.scene = ag.aLg(this.GKI);
                        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ag.b(ag.this).GzJ.getContext(), paramString, null, k, j, this.GNP, localAppBrandStatObject);
                        ag.T(9, ag.c(ag.this), ag.d(ag.this));
                        com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), parama1, Integer.valueOf(1) });
                        AppMethodBeat.o(37219);
                        return;
                      }
                      localAppBrandStatObject.scene = 1043;
                      paramAnonymousView = com.tencent.mm.am.f.ei(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                      Activity localActivity = ag.b(ag.this).GzJ.getContext();
                      String str1 = paramString;
                      int i = k;
                      int j = j;
                      String str2 = this.GNP;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
                        break;
                      }
                    }
                  };
                  ((bn)localObject1).GRE.setOnClickListener(parama1);
                  ((bn)localObject1).GRM.setOnClickListener(parama1);
                  ((bn)localObject1).GRE.setVisibility(0);
                  label3816:
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                  parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                  if (bt.isNullOrNil(paramString)) {
                    break label4613;
                  }
                  j = ai.gO(e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.Gob.GzJ.getContext().getResources().getColor(2131100711)));
                  ((bn)localObject1).GRI.setTextColor(j);
                  ((bn)localObject1).GRI.setText(paramString);
                  if (!bt.isNullOrNil(parama1)) {
                    break label4543;
                  }
                  ((bn)localObject1).GRK.setVisibility(8);
                  ((bn)localObject1).GRI.setPadding(0, 0, 0, 0);
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                  paramString = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                  ((bn)localObject1).GRF.setTag(new bi(parambl, paramString, (String)localObject3));
                  if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                    break label4590;
                  }
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                  j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                  k = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                  localObject4 = bt.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                  ((bn)localObject1).GRF.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37221);
                      paramAnonymousView = (bi)paramAnonymousView.getTag();
                      ad.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.GNM });
                      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                      localAppBrandStatObject.dbt = (paramAnonymousView.drF.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ag.b(ag.this).getTalkerUserName() + ":" + this.GKI);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramAnonymousView.userName))
                      {
                        localAppBrandStatObject.scene = ag.aLg(this.GKI);
                        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ag.b(ag.this).GzJ.getContext(), this.GNM, null, k, j, this.GNP, localAppBrandStatObject);
                        ag.T(9, ag.c(ag.this), ag.d(ag.this));
                        com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), paramString, Integer.valueOf(2) });
                        AppMethodBeat.o(37221);
                        return;
                      }
                      localAppBrandStatObject.scene = 1043;
                      paramAnonymousView = com.tencent.mm.am.f.ei(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                      Activity localActivity = ag.b(ag.this).GzJ.getContext();
                      String str1 = this.GNM;
                      int i = k;
                      int j = j;
                      String str2 = this.GNP;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
                        break;
                      }
                    }
                  });
                  ((bn)localObject1).GRF.setVisibility(0);
                  ((bn)localObject1).GRL.setVisibility(8);
                  if ((((bn)localObject1).GRE.getVisibility() != 8) || (((bn)localObject1).GRF.getVisibility() != 8)) {
                    break label4626;
                  }
                  ((bn)localObject1).GRB.setVisibility(8);
                  ((bn)localObject1).GRA.setVisibility(8);
                  ((bn)localObject1).GRD.setVisibility(8);
                  if ((((bn)localObject1).GRE.getVisibility() != 0) || (((bn)localObject1).GRF.getVisibility() != 0)) {
                    break label4907;
                  }
                  ((bn)localObject1).GRG.setVisibility(0);
                  parama = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  if ((com.tencent.mm.storage.af.rz(parama)) || (((bn)localObject1).GRE.getVisibility() == 8) || (((bn)localObject1).GRF.getVisibility() != 8) || (j != 1) || (!com.tencent.mm.storage.af.rz(paramString))) {
                    break label4938;
                  }
                  localObject2 = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(paramString);
                  if (localObject2 != null) {
                    break label4920;
                  }
                  parama = null;
                  if (localObject2 != null) {
                    break label4929;
                  }
                }
              }
              for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
              {
                o.ayJ().a(parama, ((bn)localObject1).GRN, this.FGx);
                ((bn)localObject1).GRO.setText(parama1);
                if (localObject2 == null) {
                  ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramString, new m.a()
                  {
                    public final void b(WxaAttributes paramAnonymousWxaAttributes)
                    {
                      AppMethodBeat.i(169892);
                      if (paramAnonymousWxaAttributes == null)
                      {
                        AppMethodBeat.o(169892);
                        return;
                      }
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(169891);
                          o.ayJ().a(this.owr, ag.18.this.GND.GRN, ag.k(ag.this));
                          if (TextUtils.isEmpty(this.lZa)) {}
                          for (String str = ag.18.this.GNM;; str = this.lZa)
                          {
                            ag.18.this.GND.GRO.setText(str);
                            AppMethodBeat.o(169891);
                            return;
                          }
                        }
                      });
                      AppMethodBeat.o(169892);
                    }
                  });
                }
                ((bn)localObject1).GRM.setVisibility(0);
                ((bn)localObject1).GRB.setVisibility(8);
                break;
                ((bn)localObject1).GRJ.setVisibility(0);
                l(((bn)localObject1).GRJ, parama);
                ((bn)localObject1).GRH.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 16), 0);
                break label3588;
                ((bn)localObject1).GRE.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37220);
                    if (!bt.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      paramAnonymousView.putExtra("geta8key_username", parama1);
                      c.t(paramAnonymousView, ag.b(ag.this).getTalkerUserName());
                      com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), parama1, Integer.valueOf(1) });
                    }
                    AppMethodBeat.o(37220);
                  }
                });
                ((bn)localObject1).GRM.setOnClickListener(null);
                break label3807;
                ((bn)localObject1).GRE.setVisibility(8);
                break label3816;
                ((bn)localObject1).GRK.setVisibility(0);
                l(((bn)localObject1).GRK, parama1);
                ((bn)localObject1).GRI.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 16), 0);
                break label3934;
                label4590:
                ((bn)localObject1).GRF.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(169890);
                    if (!bt.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      c.t(paramAnonymousView, ag.b(ag.this).getTalkerUserName());
                      com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.vKh.f(11608, new Object[] { ag.d(ag.this), paramString, Integer.valueOf(2) });
                    }
                    AppMethodBeat.o(169890);
                  }
                });
                break label4135;
                ((bn)localObject1).GRF.setVisibility(8);
                break label4144;
                ((bn)localObject1).GRD.setVisibility(0);
                j = this.Gob.GzJ.getMMResources().getDimensionPixelOffset(2131165480);
                if ((((bn)localObject1).GRE.getVisibility() == 0) && (((bn)localObject1).GRF.getVisibility() == 0))
                {
                  ((bn)localObject1).GRE.setGravity(17);
                  ((bn)localObject1).GRF.setGravity(17);
                  ((bn)localObject1).GRE.setPadding(j, 0, j, 0);
                  ((bn)localObject1).GRF.setPadding(j, 0, j, 0);
                }
                for (;;)
                {
                  ((bn)localObject1).GRB.setVisibility(0);
                  ((bn)localObject1).GRA.setVisibility(0);
                  break;
                  if (((bn)localObject1).GRE.getVisibility() == 0)
                  {
                    if (bt.isNullOrNil(parama))
                    {
                      ((bn)localObject1).GRE.setGravity(19);
                      ((bn)localObject1).GRE.setPadding(j, 0, 0, 0);
                      ((bn)localObject1).GRL.setVisibility(0);
                    }
                    else
                    {
                      ((bn)localObject1).GRE.setGravity(17);
                      ((bn)localObject1).GRE.setPadding(j, 0, j, 0);
                    }
                  }
                  else if (bt.isNullOrNil(parama1))
                  {
                    ((bn)localObject1).GRF.setGravity(19);
                    ((bn)localObject1).GRF.setPadding(this.Gob.GzJ.getMMResources().getDimensionPixelOffset(2131165480), 0, 0, 0);
                    ((bn)localObject1).GRL.setVisibility(0);
                  }
                  else
                  {
                    ((bn)localObject1).GRF.setGravity(17);
                    ((bn)localObject1).GRF.setPadding(j, 0, j, 0);
                  }
                }
                ((bn)localObject1).GRG.setVisibility(8);
                break label4241;
                parama = ((WxaAttributes)localObject2).field_brandIconURL;
                break label4364;
              }
              ((bn)localObject1).GRM.setVisibility(8);
              break label2067;
              if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramString)))
              {
                localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                localObject5 = ((bn)localObject1).GRh;
                paramString = new bi(parambl, false, paramInt, paramString, false, this.Gob.eWM(), paramString, parama, (String)localObject3);
                paramString.dDM = ((String)localObject2);
                paramString.jzG = ((String)localObject4);
                ((View)localObject5).setTag(paramString);
                ((bn)localObject1).GRh.setOnClickListener(this.GNi);
                break label2244;
              }
              if (i == 2)
              {
                paramString = new bi(parambl, paramString, (String)localObject4);
                paramString.position = paramInt;
                ((bn)localObject1).GRh.setTag(paramString);
                ((bn)localObject1).GRh.setOnClickListener(this.pdN);
                break label2244;
              }
              localObject5 = ((bn)localObject1).GRh;
              paramString = new bi(parambl, false, paramInt, (String)localObject4, false, this.Gob.eWM(), paramString, parama, (String)localObject3);
              paramString.dDM = ((String)localObject2);
              ((View)localObject5).setTag(paramString);
              ((bn)localObject1).GRh.setOnClickListener(h(this.Gob));
              break label2244;
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label5263;
                }
                ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              }
              do
              {
                ((bn)localObject1).GRo.setTag(null);
                ((bn)localObject1).GRp.setTag(null);
                ((bn)localObject1).GRo.setVisibility(8);
                ((bn)localObject1).GRp.setVisibility(8);
                break;
                paramInt = 0;
                break label5205;
                if (((bn)localObject1).GRj.getVisibility() == 0)
                {
                  ((bn)localObject1).GRo.setTag(parambl);
                  ((bn)localObject1).GRo.setOnClickListener(this.GNh);
                  ((bn)localObject1).GRo.setVisibility(0);
                  ((bn)localObject1).GRp.setVisibility(8);
                  break;
                }
              } while (((bn)localObject1).GRs.getVisibility() != 0);
              ((bn)localObject1).GRp.setTag(parambl);
              ((bn)localObject1).GRp.setOnClickListener(this.GNh);
              ((bn)localObject1).GRp.setVisibility(0);
              ((bn)localObject1).GRo.setVisibility(8);
            }
            localbg.GQI.GRh.setVisibility(8);
            parama1 = bt.nullAsNil((String)localMap.get(".msg.fromusername"));
            i = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
            ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
            if (i == 1)
            {
              parama = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
              paramString = bt.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
              a(localbg, com.tencent.mm.pluginsdk.ui.span.k.b(this.Gob.GzJ.getContext(), paramString, localbg.wet.getTextSize()));
              localbg.GHW.setTag(null);
              localbg.GHW.setOnClickListener(null);
              o.ayJ().a(parama, localbg.GHW, this.FGx);
              ad.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambl.field_talker });
              if ((!"notifymessage".equals(parambl.field_talker)) && (i != 1)) {
                break label6189;
              }
              localbg.GQH.GQK.setVisibility(0);
              localbg.GQH.fQp.setTextSize(0, com.tencent.mm.cd.a.ao(localbg.GQH.fQp.getContext(), 2131165517));
              label5627:
              localbg.GQH.mYI.setVisibility(0);
              paramString = ag.b.bM(localMap);
              localbg.GQH.fQp.setText(paramString.title);
              ah.a(localbg.GQH.GQN, localMap);
              parama = null;
              if (!bt.isNullOrNil(parama1))
              {
                az.arV();
                parama = com.tencent.mm.model.c.apM().aHY(parama1).ZW();
              }
              if (bt.isNullOrNil(paramString.url)) {
                break label6235;
              }
              i = 1;
              j = bt.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
              localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label6241;
              }
              parama1 = new bi(parambl, parama1, paramString.url);
              parama1.position = paramInt;
              localbg.GQH.mYI.setTag(parama1);
              localbg.GQH.mYI.setOnClickListener(this.pdN);
              i = 1;
              localbg.GQH.mYI.setOnLongClickListener(c(this.Gob));
              localbg.GQH.mYI.setOnTouchListener(((i)this.Gob.be(i.class)).eWp());
              if (i != 0) {
                break label6367;
              }
              localbg.GQH.GQO.setVisibility(8);
              localbg.GQH.mWn.setVisibility(8);
              if (com.tencent.mm.m.g.Ze().YS())
              {
                localbg.GIW.setVisibility(0);
                c(this.Gob, localbg.GIW, new s.o(paramString.gIj, parambl, parama));
              }
              parama = localbg.GQH;
              if (bt.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
                break label6394;
              }
              paramInt = 1;
              if (paramInt != 0) {
                break label6399;
              }
              ad.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              parama.GQL.setTag(null);
              parama.GQM.setTag(null);
              parama.GQL.setVisibility(8);
              parama.GQM.setVisibility(8);
            }
            for (;;)
            {
              localbg.GQH.mYI.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              a(localbg, this.Gob, parambl, parama1);
              a(localbg.GHW, this.Gob, parama1, parambl, null);
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(parama1))
              {
                localbg.GQH.GQK.setTag(new bi(parambl, parama1));
                localbg.GQH.GQK.setOnClickListener(this.GIl);
                break;
              }
              paramString = localbg.GQH.GQK;
              if (this.Gob.eZb()) {}
              for (parama = this.Gob.getTalkerUserName();; parama = null)
              {
                paramString.setTag(new bi(parama1, parama));
                localbg.GQH.GQK.setOnClickListener(e(this.Gob));
                break;
              }
              localbg.GQH.GQK.setVisibility(8);
              localbg.GQH.fQp.setTextSize(0, com.tencent.mm.cd.a.ao(localbg.GQH.fQp.getContext(), 2131165184));
              break label5627;
              i = 0;
              break label5716;
              if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OW(paramString.url)) {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramString.url, -1, 2, new Object[0]);
              }
              localObject1 = localbg.GQH.mYI;
              parama1 = new bi(parambl, false, paramInt, paramString.url, false, this.Gob.eWM(), parama1, parama, paramString.title);
              parama1.dDM = paramString.dDM;
              ((View)localObject1).setTag(parama1);
              localbg.GQH.mYI.setOnClickListener(h(this.Gob));
              break label5815;
              localbg.GQH.GQO.setVisibility(0);
              localbg.GQH.mWn.setVisibility(0);
              break label5894;
              label6394:
              paramInt = 0;
              break label5968;
              label6399:
              if (parama.GQK.getVisibility() == 0)
              {
                parama.GQL.setTag(parambl);
                parama.GQL.setOnClickListener(this.GNh);
                parama.GQL.setVisibility(0);
                parama.GQM.setVisibility(8);
              }
              else
              {
                parama.GQM.setTag(parambl);
                parama.GQM.setOnClickListener(this.GNh);
                parama.GQM.setVisibility(0);
                parama.GQL.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, com.tencent.mm.storage.bl parambl, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.wet == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    parambl = ((com.tencent.mm.ui.chatting.c.b.f)parama1.be(com.tencent.mm.ui.chatting.c.b.f.class)).aKG(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), parambl, parama.wet.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, com.tencent.mm.storage.bl parambl)
  {
    AppMethodBeat.i(37243);
    parambl = (bi)paramView.getTag();
    if (parambl == null)
    {
      AppMethodBeat.o(37243);
      return false;
    }
    int i = parambl.position;
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
      paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
    }
    AppMethodBeat.o(37243);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.bl parambl)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.bl parambl)
  {
    return false;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  protected final boolean faH()
  {
    return this.GNm == 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(37238);
      if (!(paramView.getTag() instanceof com.tencent.mm.storage.bl))
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        AppMethodBeat.o(37238);
        return;
      }
      final com.tencent.mm.storage.bl localbl = (com.tencent.mm.storage.bl)paramView.getTag();
      if (localbl == null)
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = bw.K(localbl.field_content, "msg");
      if ((localMap == null) || (localMap.size() == 0))
      {
        ad.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        AppMethodBeat.o(37238);
        return;
      }
      bt.nullAsNil((String)localMap.get(".msg.fromusername"));
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(37233);
          paramAnonymousl.add(0, 1, 0, paramView.getResources().getString(2131761750));
          AppMethodBeat.o(37233);
        }
      };
      locale.HrY = new n.d()
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
            az.aeS().a(1198, new com.tencent.mm.al.g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, final String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
              {
                AppMethodBeat.i(37235);
                az.aeS().b(1198, this);
                ad.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, Boolean.FALSE });
                if (ag.a(ag.this) != null)
                {
                  ag.a(ag.this).dismiss();
                  ag.a(ag.this, null);
                }
                if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
                {
                  t.makeText(ag.a.2.this.cFe.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                if (ag.a.2.this.gLQ != ag.a.2.this.cFe.getTag())
                {
                  ad.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(ag.a.2.this.gLQ.field_msgId) });
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = ((s)paramAnonymous2n).atU();
                if (paramAnonymous2String == null)
                {
                  t.makeText(ag.a.2.this.cFe.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = paramAnonymous2String.EKE;
                paramAnonymous2n = bt.nullAsNil((String)ag.a.2.this.foD.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).rz(paramAnonymous2n))
                {
                  ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramAnonymous2n, new m.a()
                  {
                    public final void b(WxaAttributes paramAnonymous3WxaAttributes)
                    {
                      AppMethodBeat.i(37234);
                      if (paramAnonymous3WxaAttributes == null)
                      {
                        t.makeText(ag.a.2.this.cFe.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      Object localObject = paramAnonymous3WxaAttributes.field_appId;
                      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous2String)))
                      {
                        ad.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous2String });
                        t.makeText(ag.a.2.this.cFe.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      try
                      {
                        int i = bt.getInt((String)ag.a.2.this.foD.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                        int j = bt.getInt((String)ag.a.2.this.foD.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                        paramAnonymous3WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8"), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
                        ad.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, localObject, paramAnonymous3WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous3WxaAttributes);
                        c.t((Intent)localObject, ag.b(ag.this).getTalkerUserName());
                        com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37234);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous3WxaAttributes)
                      {
                        ad.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ag.a.2.this.cFe.getContext(), 2131761756, 0).show();
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
                  paramAnonymous2n = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { paramAnonymous2n, URLEncoder.encode(ag.d(ag.this), "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8") });
                  ad.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, ag.d(ag.this), paramAnonymous2n });
                  paramAnonymous2String = new Intent();
                  paramAnonymous2String.putExtra("rawUrl", paramAnonymous2n);
                  c.t(paramAnonymous2String, ag.b(ag.this).getTalkerUserName());
                  com.tencent.mm.bs.d.b(ag.b(ag.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2String);
                  AppMethodBeat.o(37235);
                  return;
                }
                catch (UnsupportedEncodingException paramAnonymous2String)
                {
                  ad.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                  t.makeText(ag.a.2.this.cFe.getContext(), 2131761756, 0).show();
                  AppMethodBeat.o(37235);
                }
              }
            });
            paramAnonymousMenuItem = new s(localbl.field_content);
            ag localag = ag.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            ag.a(localag, com.tencent.mm.ui.base.h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(37236);
                az.aeS().a(paramAnonymousMenuItem);
                AppMethodBeat.o(37236);
              }
            }));
            az.aeS().a(paramAnonymousMenuItem, 0);
          }
        }
      };
      locale.csG();
      AppMethodBeat.o(37238);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */