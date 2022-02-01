package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.c;
import com.tencent.mm.msgsubscription.storage.a.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.o;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import d.g.b.v.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ah
  extends c
{
  private static int Ins;
  private static int Int;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private com.tencent.mm.sdk.b.c<no> HZt;
  private com.tencent.mm.av.a.a.c HfF;
  private View.OnClickListener Iii;
  private View.OnClickListener Ini;
  private View.OnClickListener Inj;
  private View.OnClickListener Ink;
  private com.tencent.mm.ui.l Inl;
  private View.OnClickListener Inm;
  private String Inn;
  private int Ino;
  private com.tencent.mm.msgsubscription.storage.a Inp;
  private com.tencent.mm.msgsubscription.storage.a Inq;
  private String Inr;
  private p fxw;
  private String mAppId;
  private View.OnClickListener pGY;
  private p zDG;
  
  static
  {
    AppMethodBeat.i(37267);
    Ins = com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getColor(2131100212);
    Int = com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getColor(2131100212);
    AppMethodBeat.o(37267);
  }
  
  public ah()
  {
    AppMethodBeat.i(37240);
    this.Inr = "";
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    ((com.tencent.mm.av.a.a.c.a)localObject).gLt = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).hKI = 2131231342;
    this.HfF = ((com.tencent.mm.av.a.a.c.a)localObject).aFT();
    localObject = com.tencent.mm.msgsubscription.storage.f.iix;
    this.Inp = com.tencent.mm.msgsubscription.storage.f.ES("name_biz");
    localObject = com.tencent.mm.msgsubscription.storage.f.iix;
    this.Inq = com.tencent.mm.msgsubscription.storage.f.ES("name_wxa");
    this.Inj = new a((byte)0);
    this.Ini = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(37198);
        final com.tencent.mm.storage.bo localbo = (com.tencent.mm.storage.bo)paramAnonymousView.getTag(2131302771);
        if (localbo == null)
        {
          ac.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          AppMethodBeat.o(37198);
          return;
        }
        Object localObject = bv.L(localbo.field_content, "msg");
        if ((localObject == null) || (((Map)localObject).size() == 0))
        {
          AppMethodBeat.o(37198);
          return;
        }
        final String str = bs.nullAsNil((String)((Map)localObject).get(".msg.fromusername"));
        final int i = bs.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
        final int j = bs.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
        localObject = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.getContext(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject).ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(37193);
            paramAnonymous2l.add(0, 2, 0, paramAnonymousView.getResources().getString(2131761750));
            AppMethodBeat.o(37193);
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).ISv = new n.d()
        {
          public final void onMMMenuItemSelected(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(37197);
            ac.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(paramAnonymous2Int) });
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(37197);
              return;
              az.agi().a(1198, new com.tencent.mm.ak.g()
              {
                public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, final String paramAnonymous3String, com.tencent.mm.ak.n paramAnonymous3n)
                {
                  AppMethodBeat.i(37195);
                  az.agi().b(1198, this);
                  ac.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, Boolean.FALSE });
                  if (ah.a(ah.this) != null)
                  {
                    ah.a(ah.this).dismiss();
                    ah.a(ah.this, null);
                  }
                  if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0))
                  {
                    t.makeText(ah.1.2.this.cCm.getContext(), 2131761751, 0).show();
                    AppMethodBeat.o(37195);
                    return;
                  }
                  paramAnonymous3String = ((s)paramAnonymous3n).aAL();
                  if (paramAnonymous3String == null)
                  {
                    t.makeText(ah.1.2.this.cCm.getContext(), 2131761751, 0).show();
                    AppMethodBeat.o(37195);
                    return;
                  }
                  paramAnonymous3String = paramAnonymous3String.GhQ;
                  ac.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { ah.1.2.this.CIt });
                  ((m)com.tencent.mm.kernel.g.ab(m.class)).a(ah.1.2.this.CIt, new m.a()
                  {
                    public final void b(WxaAttributes paramAnonymous4WxaAttributes)
                    {
                      AppMethodBeat.i(37194);
                      if (paramAnonymous4WxaAttributes == null)
                      {
                        t.makeText(ah.1.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                        return;
                      }
                      Object localObject = paramAnonymous4WxaAttributes.field_appId;
                      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous3String)))
                      {
                        ac.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous3String });
                        t.makeText(ah.1.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                        return;
                      }
                      try
                      {
                        paramAnonymous4WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous3String, "utf-8"), Integer.valueOf(1), Integer.valueOf(ah.1.2.this.Inw), Integer.valueOf(ah.1.2.this.jLa) });
                        ac.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous3String, localObject, paramAnonymous4WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous4WxaAttributes);
                        c.t((Intent)localObject, ah.b(ah.this).getTalkerUserName());
                        com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37194);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous4WxaAttributes)
                      {
                        ac.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ah.1.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37194);
                      }
                    }
                  });
                  AppMethodBeat.o(37195);
                }
              });
              paramAnonymous2MenuItem = new s(localbo.field_content);
              ah localah = ah.this;
              Context localContext = paramAnonymousView.getContext();
              paramAnonymousView.getResources().getString(2131755906);
              ah.a(localah, com.tencent.mm.ui.base.h.b(localContext, paramAnonymousView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(37196);
                  az.agi().a(paramAnonymous2MenuItem);
                  AppMethodBeat.o(37196);
                }
              }));
              az.agi().a(paramAnonymous2MenuItem, 0);
              ah.T(4, ah.c(ah.this), ah.d(ah.this));
            }
          }
        };
        ((com.tencent.mm.ui.widget.a.e)localObject).cED();
        AppMethodBeat.o(37198);
      }
    };
    this.Inm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37215);
        paramAnonymousView = (bj)paramAnonymousView.getTag();
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = bv.L(paramAnonymousView.dpq.field_content, "msg");
        Object localObject1 = bs.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), localObject1, Integer.valueOf(66666) });
        localObject1 = bs.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bs.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = bs.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!bs.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            c.t((Intent)localObject1, ah.b(ah.this).getTalkerUserName());
            com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
          AppMethodBeat.o(37215);
          return;
        }
        String str = bs.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
        int i = bs.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
        int j = bs.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
        localObject2 = bs.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.cYP = (paramAnonymousView.dpq.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + (String)localObject2);
        localAppBrandStatObject.scene = ah.aQK((String)localObject2);
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ah.b(ah.this).HZF.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        AppMethodBeat.o(37215);
      }
    };
    this.Iii = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37227);
        bj localbj = (bj)paramAnonymousView.getTag();
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[] { localbj.userName });
        Object localObject = bv.L(localbj.dpq.field_content, "msg");
        if ((localObject != null) && (((Map)localObject).size() != 0)) {
          bs.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        }
        localObject = ah.this;
        paramAnonymousView.getContext();
        ah.a((ah)localObject, localbj.userName);
        AppMethodBeat.o(37227);
      }
    };
    this.HZt = new com.tencent.mm.sdk.b.c() {};
    this.Inl = new com.tencent.mm.ui.l()
    {
      public final void fgg() {}
      
      public final void fgh() {}
      
      public final void fgi() {}
      
      public final void fgj() {}
      
      public final void fgk() {}
      
      public final void fgl()
      {
        AppMethodBeat.i(37230);
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
        com.tencent.mm.sdk.b.a.GpY.d(ah.e(ah.this));
        if (ah.b(ah.this) != null) {
          ((com.tencent.mm.ui.chatting.c.b.h)ah.b(ah.this).bf(com.tencent.mm.ui.chatting.c.b.h.class)).b(this);
        }
        AppMethodBeat.o(37230);
      }
      
      public final void fgm() {}
    };
    this.Ink = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37231);
        bj localbj = (bj)paramAnonymousView.getTag();
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localbj.userName });
        ut localut = new ut();
        localut.dxt.userName = localbj.userName;
        localut.dxt.dxv = localbj.pageUrl;
        Map localMap = bv.L(localbj.dpq.field_content, "msg");
        String str = "";
        paramAnonymousView = str;
        if (localMap != null)
        {
          paramAnonymousView = str;
          if (localMap.size() > 0)
          {
            localut.dxt.dxw = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = bs.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localut.dxt.dxz = true;
        localut.dxt.scene = ah.aQK(paramAnonymousView);
        localut.dxt.cYP = (localbj.dpq.field_msgSvrId + ":" + localbj.userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + paramAnonymousView);
        com.tencent.mm.sdk.b.a.GpY.l(localut);
        ah.T(9, ah.c(ah.this), ah.d(ah.this));
        com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), localbj.userName, Integer.valueOf(0) });
        AppMethodBeat.o(37231);
      }
    };
    this.pGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37232);
        Object localObject1 = (bj)paramAnonymousView.getTag();
        Object localObject2 = bv.L(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dpq.field_content, "msg");
        if (localObject2 == null)
        {
          ac.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          AppMethodBeat.o(37232);
          return;
        }
        int i = bs.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        if (i == 1)
        {
          String str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
          String str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
          i = bs.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
          int j = bs.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
          paramAnonymousView = bs.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
          ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).cYP = (((bj)localObject1).dpq.field_msgSvrId + ":" + ((bj)localObject1).userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + paramAnonymousView);
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(((bj)localObject1).userName))
          {
            ((AppBrandStatObject)localObject2).scene = ah.aQK(paramAnonymousView);
            ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ah.b(ah.this).HZF.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
            ah.T(9, ah.c(ah.this), ah.d(ah.this));
            com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), ((bj)localObject1).userName, Integer.valueOf(0) });
            AppMethodBeat.o(37232);
            return;
          }
          ((AppBrandStatObject)localObject2).scene = 1043;
          paramAnonymousView = com.tencent.mm.al.f.dX(((bj)localObject1).userName);
          com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
          Activity localActivity = ah.b(ah.this).HZF.getContext();
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
          long l = bs.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
          ah.c(paramAnonymousView.getContext(), (String)localObject1, l);
          ac.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
        }
        AppMethodBeat.o(37232);
      }
    };
    AppMethodBeat.o(37240);
  }
  
  private static void S(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37253);
    ac.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.wUl.f(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bs.aNx()) });
    AppMethodBeat.o(37253);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.d.a parama, String paramString1, com.tencent.mm.storage.bo parambo, String paramString2)
  {
    AppMethodBeat.i(37246);
    if (paramImageView == null)
    {
      AppMethodBeat.o(37246);
      return;
    }
    if (w.xr(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(37246);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramString1))
    {
      o.aFB().a(paramString2, paramImageView, this.HfF);
      paramImageView.setTag(new bj(parambo, paramString1));
      paramImageView.setOnClickListener(this.Iii);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(v.wk(paramString1) + parama.HZF.getContext().getString(2131756087));
      AppMethodBeat.o(37246);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString1);
    if (parama.foQ()) {}
    for (parambo = parama.getTalkerUserName();; parambo = null)
    {
      paramImageView.setTag(new bj(paramString1, parambo));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(bo parambo, com.tencent.mm.storage.bo parambo1, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(37251);
    LinearLayout localLinearLayout = parambo.IrD;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      final String str1;
      final String str2;
      for (parambo = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambo = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str1 = (String)paramMap.get(parambo + ".word");
        str2 = (String)paramMap.get(parambo + ".hint_word");
        if (!bs.isNullOrNil(str1)) {
          break label193;
        }
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
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
        localObject2 = (String)paramMap.get(parambo + ".icon");
        k = aj.gy(e(paramMap, parambo + ".color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
        ((a)localObject1).fUk.setTextColor(k);
        if (bs.getInt((String)paramMap.get(parambo + ".is_rich_text"), 0) != 0) {
          break label846;
        }
        ((a)localObject1).fUk.setSingleLine(true);
        ((a)localObject1).fUk.setEllipsize(TextUtils.TruncateAt.END);
        ((a)localObject1).fUk.setText(str1);
        ((a)localObject1).iGZ.setText(str2);
        if (!bs.isNullOrNil((String)localObject2)) {
          break label944;
        }
        ((a)localObject1).ig.setVisibility(8);
        ((a)localObject1).fUk.setPadding(0, 0, 0, 0);
        label417:
        localObject2 = (String)paramMap.get(parambo + ".url");
        str1 = bs.nullAsNil((String)paramMap.get(".msg.fromusername"));
        m = bs.getInt((String)paramMap.get(parambo + ".op_type"), 0);
        str2 = (String)paramMap.get(parambo + ".weapp_username");
        bj localbj = new bj(parambo1, str1, (String)localObject2);
        ((a)localObject1).HmR.setTag(localbj);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty(str2))) {
          break label992;
        }
        localObject2 = (String)paramMap.get(parambo + ".weapp_path");
        m = bs.getInt((String)paramMap.get(parambo + ".weapp_version"), 0);
        final int n = bs.getInt((String)paramMap.get(parambo + ".weapp_state"), 0);
        parambo = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37225);
            paramAnonymousView = (bj)paramAnonymousView.getTag();
            ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { str2 });
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.cYP = (paramAnonymousView.dpq.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + this.IkF);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramAnonymousView.userName))
            {
              localAppBrandStatObject.scene = ah.aQK(this.IkF);
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ah.b(ah.this).HZF.getContext(), str2, null, n, m, this.InR, localAppBrandStatObject);
              ah.T(9, ah.c(ah.this), ah.d(ah.this));
              com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), str1, Integer.valueOf(k) });
              AppMethodBeat.o(37225);
              return;
            }
            localAppBrandStatObject.scene = 1043;
            paramAnonymousView = com.tencent.mm.al.f.dX(paramAnonymousView.userName);
            com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
            Activity localActivity = ah.b(ah.this).HZF.getContext();
            String str1 = str2;
            int i = n;
            int j = m;
            String str2 = this.InR;
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
            {
              localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
              break;
            }
          }
        };
        ((a)localObject1).HmR.setOnClickListener(parambo);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.HNS.HZF.getContext()).inflate(2131493393, null, false);
        localObject2 = new a();
        ((a)localObject2).fUk = ((TextView)((LinearLayout)localObject1).findViewById(2131302757));
        ((a)localObject2).ig = ((ImageView)((LinearLayout)localObject1).findViewById(2131302756));
        ((a)localObject2).HmR = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131302754));
        ((a)localObject2).iGZ = ((TextView)((LinearLayout)localObject1).findViewById(2131302755));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label212;
        label846:
        k = bs.getInt((String)paramMap.get(parambo + ".display_line_number"), 1);
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
        ((a)localObject1).fUk.setSingleLine(false);
        ((a)localObject1).fUk.setText(str1);
        ((a)localObject1).fUk.setMaxLines(k);
        com.tencent.mm.pluginsdk.ui.span.k.a(((a)localObject1).fUk, false, null);
        break label377;
        label944:
        ((a)localObject1).ig.setVisibility(0);
        l(((a)localObject1).ig, (String)localObject2);
        ((a)localObject1).fUk.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 28), 0);
        break label417;
        label992:
        if (m == 2) {
          ((a)localObject1).HmR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37226);
              if (k == 1)
              {
                String str = (String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
                long l = bs.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
                ah.c(paramAnonymousView.getContext(), str, l);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 2L, 1L, false);
                ac.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str, Long.valueOf(l) });
                AppMethodBeat.o(37226);
                return;
              }
              if (k == 2) {
                com.tencent.mm.br.d.e(paramAnonymousView.getContext(), ".ui.AllRemindMsgUI", new Intent());
              }
              AppMethodBeat.o(37226);
            }
          });
        } else {
          ((a)localObject1).HmR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(169893);
              if (!bs.isNullOrNil(this.val$url))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", this.val$url);
                c.t(paramAnonymousView, ah.b(ah.this).getTalkerUserName());
                com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), str1, Integer.valueOf(k) });
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
  
  private void a(bo parambo, String paramString1, String paramString2, Map<String, String> paramMap, com.tencent.mm.storage.bo parambo1, boolean paramBoolean)
  {
    AppMethodBeat.i(37247);
    parambo.Irm.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.HNS.HZF.getContext(), paramString2, parambo.Irm.getTextSize()));
    o.aFB().a(paramString1, parambo.Irl, this.HfF);
    parambo.Irl.setTag(null);
    parambo.Irl.setOnClickListener(null);
    parambo.Irk.setTag(null);
    parambo.Irk.setOnClickListener(null);
    parambo.Irk.setVisibility(0);
    paramString1 = bs.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bs.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bs.isNullOrNil(paramString1)) || (!bs.isNullOrNil(paramString2)))
    {
      paramString1 = bs.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambo.Irk.setTag(new bj(parambo1, paramString1));
      parambo.Irk.setOnClickListener(this.Inm);
    }
    for (;;)
    {
      paramString1 = bs.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bs.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambo.Iro.getParent()).setVisibility(0);
      o.aFB().a(paramString1, parambo.Iro, this.HfF);
      AppMethodBeat.o(37247);
      return;
      parambo.Irk.setOnClickListener(null);
    }
    ((View)parambo.Iro.getParent()).setVisibility(8);
    AppMethodBeat.o(37247);
  }
  
  private void a(bo parambo, Map<String, String> paramMap)
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
        if ((!bs.isNullOrNil((String)localObject2)) || (!bs.isNullOrNil((String)localObject3))) {
          break label352;
        }
        ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
      }
    }
    else
    {
      j = i;
      if (i > 8) {
        j = 8;
      }
      localObject2 = parambo.IrA;
      ((LinearLayout)localObject2).setVisibility(0);
      localObject1 = ((ViewGroup)parambo.IrA.getParent()).findViewById(2131298909);
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
      localObject3 = (bl)localArrayList.get(i);
      if (i >= k) {
        break label842;
      }
      localObject1 = (LinearLayout)((LinearLayout)localObject2).getChildAt(i);
      label272:
      localObject1 = (bm)((LinearLayout)localObject1).getTag();
      if (!((bl)localObject3).Ire) {
        break label926;
      }
      ((bm)localObject1).Irf.setVisibility(8);
    }
    for (;;)
    {
      ((bm)localObject1).Irg.setTextColor(aj.gy(((bl)localObject3).Ird));
      ((bm)localObject1).Irg.setText(((bl)localObject3).Irb);
      i += 1;
      break label231;
      localObject1 = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
      break label37;
      label352:
      Object localObject4 = new bl();
      ((bl)localObject4).Irb = ((String)localObject2);
      ((bl)localObject4).Ira = bs.nullAsNil((String)localObject3);
      label516:
      boolean bool;
      if (!aj.DT())
      {
        ((bl)localObject4).Irc = e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".key.color", Ins));
        ((bl)localObject4).Ird = e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".value.color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
        if (bs.getInt((String)paramMap.get((String)localObject1 + ".key.hide"), 0) == 0) {
          break label803;
        }
        bool = true;
        label556:
        ((bl)localObject4).Ire = bool;
        k = (aQJ(((bl)localObject4).Ira) + 1) / 2;
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
        ((bl)localObject4).Irc = e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor1", e(paramMap, (String)localObject1 + ".key.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".key.color", Ins)));
        ((bl)localObject4).Ird = e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor1", e(paramMap, (String)localObject1 + ".value.wxcolors.wxcolor", e(paramMap, (String)localObject1 + ".value.color", this.HNS.HZF.getContext().getResources().getColor(2131100711))));
        ((bl)localObject4).Ird = aj.gy(((bl)localObject4).Ird);
        break label516;
        bool = false;
        break label556;
      }
      label812:
      i = ((LinearLayout)localObject2).getChildCount();
      ((LinearLayout)localObject2).removeViews(localArrayList.size(), i - localArrayList.size());
      break label222;
      label842:
      localObject1 = (LinearLayout)LayoutInflater.from(this.HNS.HZF.getContext()).inflate(2131493394, null, false);
      localObject4 = new bm();
      ((bm)localObject4).Irf = ((TextView)((LinearLayout)localObject1).findViewById(2131301424));
      ((bm)localObject4).Irg = ((TextView)((LinearLayout)localObject1).findViewById(2131301431));
      ((LinearLayout)localObject1).setTag(localObject4);
      ((LinearLayout)localObject2).addView((View)localObject1);
      break label272;
      label926:
      ((bm)localObject1).Irf.setVisibility(0);
      ((bm)localObject1).Irf.setEms(j);
      ((bm)localObject1).Irf.setTextColor(aj.gy(((bl)localObject3).Irc));
      ((bm)localObject1).Irf.setText(((bl)localObject3).Ira);
    }
    label977:
    if (((LinearLayout)localObject2).getChildCount() == 0)
    {
      parambo.Irz.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(8);
      AppMethodBeat.o(37250);
      return;
    }
    if (bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
      parambo.Irz.setVisibility(8);
    }
    for (;;)
    {
      ((LinearLayout)localObject2).setVisibility(0);
      AppMethodBeat.o(37250);
      return;
      parambo.Irz.setVisibility(0);
    }
  }
  
  private void a(Map<String, String> paramMap, com.tencent.mm.storage.bo parambo, bo parambo1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(37249);
    ac.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), this.Inn, this.Inr, Boolean.valueOf(paramBoolean2) });
    parambo1.IrQ.setVisibility(0);
    if ((paramBoolean1) || ((paramBoolean3) && (!paramBoolean2)))
    {
      parambo1.Irn.setVisibility(0);
      localTextView = parambo1.IrR;
      localResources = this.HNS.HZF.getMMResources();
      if (paramBoolean3) {}
      for (i = 2131761768;; i = 2131761761)
      {
        localTextView.setText(localResources.getString(i));
        parambo1.IrQ.setTag(2131302745, parambo);
        parambo1.IrQ.setOnClickListener(new ah.9(this, paramMap, paramBoolean3, paramBoolean1, paramBoolean2, parambo, parambo1));
        AppMethodBeat.o(37249);
        return;
      }
    }
    parambo1.Irn.setVisibility(8);
    TextView localTextView = parambo1.IrR;
    Resources localResources = this.HNS.HZF.getMMResources();
    if (paramBoolean3) {}
    for (int i = 2131761766;; i = 2131761736)
    {
      localTextView.setText(localResources.getString(i));
      break;
    }
  }
  
  private static int aQI(String paramString)
  {
    AppMethodBeat.i(37248);
    String str = paramString;
    if (paramString == null) {
      str = "-1";
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      i = bs.l(Integer.valueOf(i), -1);
      AppMethodBeat.o(37248);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.ChattingItemDyeingTemplate", paramString.getMessage());
        int i = -1;
      }
    }
  }
  
  private static int aQJ(String paramString)
  {
    AppMethodBeat.i(37255);
    if (bs.isNullOrNil(paramString))
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
    if ((paramMap == null) || (bs.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(37254);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bs.nullAsNil((String)paramMap.get(paramString)));
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
    if ((bs.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(37252);
      return;
    }
    Object localObject = new com.tencent.mm.av.a.a.c.a();
    az.ayM();
    ((com.tencent.mm.av.a.a.c.a)localObject).prefixPath = com.tencent.mm.model.c.awM();
    ((com.tencent.mm.av.a.a.c.a)localObject).hKx = true;
    ((com.tencent.mm.av.a.a.c.a)localObject).gKm = true;
    localObject = ((com.tencent.mm.av.a.a.c.a)localObject).aFT();
    o.aFB().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
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
      localObject = new ag(paramLayoutInflater, 2131493426);
      paramLayoutInflater = new bh();
      paramLayoutInflater.ijt = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramLayoutInflater.gGk = ((View)localObject).findViewById(2131298147);
      paramLayoutInflater.xpH = ((TextView)((View)localObject).findViewById(2131298185));
      paramLayoutInflater.IhT = ((AvatarImageView)((View)localObject).findViewById(2131298056));
      paramLayoutInflater.fAz = ((TextView)((View)localObject).findViewById(2131298178));
      paramLayoutInflater.nCR = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramLayoutInflater.IqI.nBh = ((View)localObject).findViewById(2131298119);
      paramLayoutInflater.IqI.IqL = ((View)localObject).findViewById(2131300702);
      paramLayoutInflater.IqI.fUk = ((TextView)paramLayoutInflater.IqI.nBh.findViewById(2131305902));
      paramLayoutInflater.IqI.IqO = ((LinearLayout)paramLayoutInflater.IqI.nBh.findViewById(2131299136));
      paramLayoutInflater.IqI.nyM = ((TextView)paramLayoutInflater.nCR.findViewById(2131299035));
      paramLayoutInflater.IqI.IqP = paramLayoutInflater.nCR.findViewById(2131304592);
      paramLayoutInflater.IqI.IqM = ((View)localObject).findViewById(2131302486);
      paramLayoutInflater.IqI.IqN = ((View)localObject).findViewById(2131302487);
      paramLayoutInflater.IqJ.Iri = ((View)localObject).findViewById(2131298118);
      paramLayoutInflater.IqJ.Irj = ((ImageView)((View)localObject).findViewById(2131302769));
      paramLayoutInflater.IqJ.Irk = ((View)localObject).findViewById(2131302767);
      paramLayoutInflater.IqJ.Irm = ((TextView)((View)localObject).findViewById(2131302785));
      paramLayoutInflater.IqJ.Irl = ((ImageView)((View)localObject).findViewById(2131302743));
      paramLayoutInflater.IqJ.Irn = ((View)localObject).findViewById(2131302746);
      paramLayoutInflater.IqJ.Iro = ((ImageView)((View)localObject).findViewById(2131302773));
      paramLayoutInflater.IqJ.Irp = ((View)localObject).findViewById(2131302771);
      paramLayoutInflater.IqJ.Irq = ((View)localObject).findViewById(2131302772);
      paramLayoutInflater.IqJ.Irr = ((TextView)((View)localObject).findViewById(2131302778));
      paramLayoutInflater.IqJ.Irs = ((TextView)((View)localObject).findViewById(2131302766));
      paramLayoutInflater.IqJ.Irt = ((View)localObject).findViewById(2131302768);
      paramLayoutInflater.IqJ.Iru = ((LinearLayout)((View)localObject).findViewById(2131302779));
      paramLayoutInflater.IqJ.Irv = ((TextView)((View)localObject).findViewById(2131302781));
      paramLayoutInflater.IqJ.Irx = ((TextView)((View)localObject).findViewById(2131302782));
      paramLayoutInflater.IqJ.Irw = ((TextView)((View)localObject).findViewById(2131302783));
      paramLayoutInflater.IqJ.Iry = ((TextView)((View)localObject).findViewById(2131302784));
      paramLayoutInflater.IqJ.Irz = ((View)localObject).findViewById(2131302780);
      paramLayoutInflater.IqJ.IrA = ((LinearLayout)((View)localObject).findViewById(2131302770));
      paramLayoutInflater.IqJ.IrE = ((View)localObject).findViewById(2131302760);
      paramLayoutInflater.IqJ.IrB = ((View)localObject).findViewById(2131297440);
      paramLayoutInflater.IqJ.IrC = ((LinearLayout)((View)localObject).findViewById(2131302758));
      paramLayoutInflater.IqJ.IrD = ((LinearLayout)((View)localObject).findViewById(2131299239));
      paramLayoutInflater.IqJ.IrF = ((LinearLayout)((View)localObject).findViewById(2131302748));
      paramLayoutInflater.IqJ.IrI = ((TextView)((View)localObject).findViewById(2131302750));
      paramLayoutInflater.IqJ.IrK = ((ImageView)((View)localObject).findViewById(2131302749));
      paramLayoutInflater.IqJ.IrH = ((View)localObject).findViewById(2131302759);
      paramLayoutInflater.IqJ.IrG = ((LinearLayout)((View)localObject).findViewById(2131302751));
      paramLayoutInflater.IqJ.IrJ = ((TextView)((View)localObject).findViewById(2131302753));
      paramLayoutInflater.IqJ.IrL = ((ImageView)((View)localObject).findViewById(2131302752));
      paramLayoutInflater.IqJ.IrM = ((ImageView)((View)localObject).findViewById(2131302742));
      paramLayoutInflater.IiT = ((ImageView)((View)localObject).findViewById(2131298117));
      paramLayoutInflater.IqJ.IrN = ((View)localObject).findViewById(2131302774);
      paramLayoutInflater.IqJ.IrO = ((ImageView)((View)localObject).findViewById(2131302775));
      paramLayoutInflater.IqJ.IrP = ((TextView)((View)localObject).findViewById(2131302776));
      paramLayoutInflater.IqJ.IrQ = ((LinearLayout)((View)localObject).findViewById(2131302744));
      paramLayoutInflater.IqJ.IrR = ((TextView)((View)localObject).findViewById(2131302745));
      paramLayoutInflater.IqK.Ihy = ((LinearLayout)((View)localObject).findViewById(2131302763));
      paramLayoutInflater.IqK.Ihz = ((CdnImageView)((View)localObject).findViewById(2131302762));
      paramLayoutInflater.IqK.IhA = ((TextView)((View)localObject).findViewById(2131302764));
      paramLayoutInflater.IqK.IhB = ((TextView)((View)localObject).findViewById(2131302761));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37241);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final com.tencent.mm.storage.bo parambo, final String paramString)
  {
    AppMethodBeat.i(37242);
    this.HNS = parama1;
    Ins = parama1.HZF.getContext().getResources().getColor(2131100212);
    Int = parama1.HZF.getContext().getResources().getColor(2131100212);
    bh localbh = (bh)parama;
    final Map localMap = bv.L(parambo.field_content, "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ac.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localbh.nCR.setVisibility(8);
      AppMethodBeat.o(37242);
      return;
    }
    localbh.nCR.setVisibility(0);
    final int j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.Inn = bs.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.Ino = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.GpY.d(this.HZt);
    ((com.tencent.mm.ui.chatting.c.b.h)parama1.bf(com.tencent.mm.ui.chatting.c.b.h.class)).b(this.Inl);
    Object localObject1;
    if (j != 0)
    {
      localbh.IqI.nBh.setVisibility(8);
      localObject1 = localbh.IqJ;
      if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bo)localObject1, bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambo, false);
        if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2825;
        }
        ((bo)localObject1).Irk.setBackgroundResource(2131233299);
        label325:
        if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
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
    for (int i = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      final int k = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      ((bo)localObject1).Irr.setVisibility(8);
      if ((i == 0) && (k == 0))
      {
        ((bo)localObject1).Irr.setVisibility(0);
        this.Inr = bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
        k = e(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        ((bo)localObject1).Irr.setTextColor(aj.gy(k));
        ((bo)localObject1).Irr.setText(this.Inr);
      }
      parama = bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = e(localMap, ".msg.appmsg.mmreader.template_header.first_color", Int);
      Object localObject2;
      Object localObject3;
      if (bs.isNullOrNil(parama))
      {
        ((bo)localObject1).Irs.setVisibility(8);
        if ((i == 0) || (!bs.isNullOrNil(parama))) {
          break label2944;
        }
        ((bo)localObject1).Irt.setVisibility(8);
        parama = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
        if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(parama)) {
          break label3207;
        }
        i = aQI((String)localMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
        if ((i != 2) && (i != 3)) {
          break label2956;
        }
        i = 1;
        if ("notifymessage".equals(parambo.field_talker))
        {
          parama1 = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
          ((com.tencent.mm.ui.chatting.c.b.h)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.h.class)).a(this.Inl);
          com.tencent.mm.sdk.b.a.GpY.c(this.HZt);
          if (i == 0) {
            break label3093;
          }
          parama = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(parama1);
          if (parama == null) {
            break label2962;
          }
          this.mAppId = parama.field_appId;
          ((bo)localObject1).IrQ.setVisibility(0);
          ((bo)localObject1).Irn.setVisibility(8);
          ((bo)localObject1).IrR.setText(this.HNS.HZF.getMMResources().getString(2131761766));
          parama = com.tencent.mm.msgsubscription.storage.a.ihQ;
          paramString = this.Inn;
          parama = ((bo)localObject1).IrQ.hashCode();
          d.g.b.k.h(paramString, "templateId");
          d.g.b.k.h(parama, "viewKey");
          localObject2 = (HashMap)com.tencent.mm.msgsubscription.storage.a.aLg().get(paramString);
          if (localObject2 != null) {
            ((HashMap)localObject2).remove(parama);
          }
          if (localObject2 == null) {
            break label2988;
          }
          parama = Integer.valueOf(((HashMap)localObject2).size());
          ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo unregisterNotifyCallback templateId: %s, size: %s", new Object[] { paramString, parama });
          parama = com.tencent.mm.msgsubscription.storage.a.ihQ;
          paramString = this.Inn;
          localObject2 = ((bo)localObject1).IrQ.hashCode();
          localObject3 = new ah.7(this, parama1, localMap, parambo, (bo)localObject1);
          d.g.b.k.h(paramString, "templateId");
          d.g.b.k.h(localObject2, "viewKey");
          d.g.b.k.h(localObject3, "callback");
          parama = (HashMap)com.tencent.mm.msgsubscription.storage.a.aLg().get(paramString);
          if (parama != null) {
            break label6495;
          }
          parama = new HashMap();
        }
      }
      for (;;)
      {
        ((Map)parama).put(localObject2, localObject3);
        ((Map)com.tencent.mm.msgsubscription.storage.a.aLg()).put(paramString, parama);
        ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo registerNotifyCallback templateId: %s, size: %d", new Object[] { paramString, Integer.valueOf(parama.size()) });
        parama = this.Inq;
        paramString = this.Inn;
        d.g.b.k.h(parama1, "bizUsername");
        d.g.b.k.h(paramString, "templateId");
        localObject2 = parama.ihO;
        d.g.b.k.h(parama1, "bizUsername");
        d.g.b.k.h(paramString, "templateId");
        localObject3 = ((com.tencent.mm.msgsubscription.storage.e)localObject2).iiu.bl(parama1, paramString);
        localObject2 = new v.f();
        ((v.f)localObject2).KUQ = localObject3;
        Object localObject4 = parama.ihO;
        d.g.b.k.h(parama1, "bizUsername");
        boolean bool2 = ((com.tencent.mm.msgsubscription.storage.e)localObject4).iiu.BD(parama1);
        boolean bool1;
        if (localObject3 != null)
        {
          ac.v("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject3).igY) });
          if (((SubscribeMsgTmpItem)localObject3).igY == 1)
          {
            bool1 = true;
            com.tencent.mm.msgsubscription.storage.a.a(paramString, new IBrandSubscribeMsgService.c(bool1, bool2));
            localObject3 = (SubscribeMsgTmpItem)((v.f)localObject2).KUQ;
            localObject2 = (SubscribeMsgTmpItem)((v.f)localObject2).KUQ;
            if (localObject2 == null) {
              break label2999;
            }
            i = ((SubscribeMsgTmpItem)localObject2).igY;
            parama.a((SubscribeMsgTmpItem)localObject3, new com.tencent.mm.msgsubscription.storage.a.b(parama1, paramString, i));
            ((bo)localObject1).Irp.setVisibility(0);
            ((bo)localObject1).Irp.setTag(2131302771, parambo);
            ((bo)localObject1).Irp.setOnClickListener(this.Ini);
            label1255:
            ((bo)localObject1).Irj.setVisibility(8);
            parama = bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
            ((bo)localObject1).Irs.setText(parama);
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bs.isNullOrNil(parama1)) {
              break label3287;
            }
            i = aj.gy(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
            j = aj.gy(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
            k = aj.gy(e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
            int m = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
            ((bo)localObject1).Irv.setTextColor(i);
            ((bo)localObject1).Irx.setTextColor(j);
            ((bo)localObject1).Iry.setTextColor(k);
            ((bo)localObject1).Iry.getPaint().setFlags(16);
            ((bo)localObject1).Irv.setText(parama);
            if ((m <= 0) || (m >= parama1.length())) {
              break label3230;
            }
            ((bo)localObject1).Irw.setVisibility(0);
            ((bo)localObject1).Irw.setText(parama1.substring(0, m));
            ((bo)localObject1).Irw.setTextColor(j);
            ((bo)localObject1).Irw.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fK(this.HNS.HZF.getContext()));
            ((bo)localObject1).Irx.setTypeface(((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).fK(this.HNS.HZF.getContext()));
            ((bo)localObject1).Irx.setText(parama1.substring(m));
            label1634:
            if (bs.isNullOrNil(paramString)) {
              break label3274;
            }
            ((bo)localObject1).Iry.setText(paramString);
            ((bo)localObject1).Iry.setVisibility(0);
            label1661:
            ((bo)localObject1).Iru.setVisibility(0);
            i = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i != 2) {
              break label3452;
            }
            ac.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
            ((bo)localObject1).IrA.setVisibility(8);
            parama1 = (ViewGroup)((bo)localObject1).IrA.getParent();
            parama = parama1.findViewById(2131298909);
            if (parama != null) {
              break label6492;
            }
            parama = LayoutInflater.from(parama1.getContext()).inflate(2131495249, null);
            paramString = new bg();
            paramString.ig = ((ImageView)parama.findViewById(2131296996));
            paramString.IqH = ((TextView)parama.findViewById(2131302863));
            paramString.fUk = ((TextView)parama.findViewById(2131305902));
            parama.setTag(paramString);
            parama1.addView(parama);
          }
        }
        for (;;)
        {
          parama.setVisibility(0);
          paramString = (bg)parama.getTag();
          parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
          localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
          parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
          localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
          j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
          paramString.fUk.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.fUk.getContext(), parama));
          localObject3 = paramString.IqH;
          localObject4 = paramString.fUk.getContext();
          if (bs.isNullOrNil((String)localObject2)) {
            parama = "";
          }
          for (;;)
          {
            ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, parama));
            Object localObject5;
            if (j == 2)
            {
              paramString.ig.setImageDrawable(com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getDrawable(2131230943));
              if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
                break label3463;
              }
              ((bo)localObject1).IrN.setVisibility(8);
              ((bo)localObject1).IrC.setVisibility(8);
              ((bo)localObject1).IrE.setVisibility(8);
              ((bo)localObject1).IrD.setVisibility(0);
              ((bo)localObject1).IrB.setVisibility(0);
              a((bo)localObject1, parambo, localMap);
              paramString = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
              parama = null;
              if (!bs.isNullOrNil(paramString))
              {
                az.ayM();
                parama = com.tencent.mm.model.c.awB().aNt(paramString).aaR();
              }
              localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
              localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
              parama1 = (String)localMap.get(".msg.appmsg.template_id");
              localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject5))) {
                break label4951;
              }
              paramString = new bj(parambo, paramString, (String)localObject4);
              paramString.position = paramInt;
              ((bo)localObject1).Iri.setTag(paramString);
              ((bo)localObject1).Iri.setOnClickListener(this.pGY);
              ((bo)localObject1).Iri.setOnLongClickListener(c(this.HNS));
              ((bo)localObject1).Iri.setOnTouchListener(((i)this.HNS.bf(i.class)).fmb());
              if (com.tencent.mm.m.g.ZZ().ZP())
              {
                localbh.IiT.setVisibility(0);
                c(this.HNS, localbh.IiT, new s.o(parama1, parambo, parama));
              }
              parama = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
              if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(parama)) || (!"notifymessage".equals(parambo.field_talker))) {
                break label5182;
              }
              ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
              ((bo)localObject1).Irq.setTag(null);
              ((bo)localObject1).Irq.setVisibility(8);
            }
            for (;;)
            {
              localbh.IqJ.Iri.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
              {
                a((bo)localObject1, bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambo, true);
                break;
              }
              ((View)((bo)localObject1).Iro.getParent()).setVisibility(8);
              if ("notifymessage".equals(parambo.field_talker))
              {
                parama1 = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(parama1))
                {
                  paramString = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(parama1);
                  if (paramString == null)
                  {
                    parama = null;
                    a(((bo)localObject1).Irl, this.HNS, parama1, parambo, parama);
                    if (paramString != null) {
                      break label2700;
                    }
                    parama = parama1;
                  }
                }
                for (;;)
                {
                  ((bo)localObject1).Irm.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.HNS.HZF.getContext(), parama, ((bo)localObject1).Irm.getTextSize()));
                  if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(parama1)) {
                    break label2749;
                  }
                  ((bo)localObject1).Irk.setTag(new bj(parambo, parama1));
                  ((bo)localObject1).Irk.setOnClickListener(this.Iii);
                  ((bo)localObject1).Irk.setVisibility(0);
                  break;
                  parama = paramString.field_brandIconURL;
                  break label2577;
                  parama = paramString.field_nickname;
                  continue;
                  a(((bo)localObject1).Irl, this.HNS, parama1, parambo, null);
                  parama = ((com.tencent.mm.ui.chatting.c.b.f)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.f.class)).aQj(parama1);
                }
                paramString = ((bo)localObject1).Irk;
                if (this.HNS.foQ()) {}
                for (parama = this.HNS.getTalkerUserName();; parama = null)
                {
                  paramString.setTag(new bj(parama1, parama));
                  ((bo)localObject1).Irk.setOnClickListener(e(this.HNS));
                  break;
                }
              }
              ((bo)localObject1).Irk.setVisibility(8);
              break;
              i = ((bo)localObject1).Irk.getPaddingLeft();
              ((bo)localObject1).Irk.setBackgroundResource(2131232867);
              ((bo)localObject1).Irk.setPadding(i, 0, 0, 0);
              break label325;
              ((bo)localObject1).Irs.setTextColor(aj.gy(k));
              ((bo)localObject1).Irs.setText(parama);
              ((bo)localObject1).Irs.setVisibility(0);
              if (j == 2)
              {
                ((bo)localObject1).Irs.setPadding(0, this.HNS.HZF.getMMResources().getDimensionPixelOffset(2131165480), 0, 0);
                break label517;
              }
              ((bo)localObject1).Irs.setPadding(0, 0, 0, 0);
              break label517;
              ((bo)localObject1).Irt.setVisibility(0);
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
                    ac.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", new Object[] { ah.c(ah.this) });
                    ah.c(ah.this, paramAnonymousWxaAttributes.field_appId);
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
              ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo isTemplateMsgSubscribed read from local");
              localObject3 = parama.ihO;
              parama = (e.b)new a.d(parama, paramString, (v.f)localObject2);
              d.g.b.k.h(parama1, "username");
              ac.i("Mp.SubscribeMsgDataLoader", "alvinluo loadSubscribeMsgListByUsername username: %s", new Object[] { parama1 });
              paramString = com.tencent.mm.msgsubscription.storage.g.iiz;
              com.tencent.mm.msgsubscription.storage.g.a(((com.tencent.mm.msgsubscription.storage.e)localObject3).iiu, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.f(parama1, ((com.tencent.mm.msgsubscription.storage.e)localObject3).iiu, parama));
              break label1221;
              parama = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(parama1);
              if (parama != null)
              {
                this.mAppId = parama.field_appId;
                if ((parama.field_appOpt & 0x1) > 0) {
                  bool1 = true;
                }
              }
              for (;;)
              {
                a(localMap, parambo, (bo)localObject1, bool1, false, false);
                break;
                bool1 = false;
                continue;
                ac.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama1 });
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
                    ah.c(ah.this, paramAnonymousWxaAttributes.field_appId);
                    if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0) {}
                    for (final boolean bool = true;; bool = false)
                    {
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(169884);
                          ah.a(ah.this, ah.8.this.frY, ah.8.this.hmq, ah.8.this.InF, bool, false, false);
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
              ((bo)localObject1).IrQ.setVisibility(8);
              ((bo)localObject1).Irn.setVisibility(8);
              break label1255;
              ((bo)localObject1).Irw.setTypeface(Typeface.DEFAULT);
              ((bo)localObject1).Irw.setVisibility(8);
              ((bo)localObject1).Irx.setTypeface(Typeface.DEFAULT);
              ((bo)localObject1).Irx.setText(parama1);
              break label1634;
              ((bo)localObject1).Iry.setVisibility(8);
              break label1661;
              ((bo)localObject1).Iru.setVisibility(8);
              break label1670;
              parama = null;
              if (w.sQ((String)localObject2))
              {
                az.ayM();
                localObject5 = com.tencent.mm.model.c.awB().aNt((String)localObject2);
                if (localObject5 != null)
                {
                  if (((com.tencent.mm.storage.ai)localObject5).aaS() != null) {
                    break label3392;
                  }
                  parama = ((com.tencent.mm.storage.ai)localObject5).aaR();
                }
              }
              for (;;)
              {
                if (!bs.isNullOrNil(parama)) {
                  break label6489;
                }
                ac.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
                parama = parama1;
                if (parama1 != null) {
                  break;
                }
                parama = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757293);
                break;
                parama = ((com.tencent.mm.storage.ai)localObject5).aaS();
                continue;
                az.ayM();
                parama = com.tencent.mm.model.c.awB().aNt((String)localObject2);
                if (parama.aaS() == null) {
                  parama = parama.aaR();
                } else {
                  parama = parama.aaS();
                }
              }
              com.tencent.mm.pluginsdk.ui.a.b.c(paramString.ig, (String)localObject2);
              break label1989;
              label3452:
              a((bo)localObject1, localMap);
              break label1989;
              ((bo)localObject1).IrD.setVisibility(8);
              parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
              parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
              if (!bs.isNullOrNil(parama1))
              {
                j = aj.gy(e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
                ((bo)localObject1).IrI.setTextColor(j);
                ((bo)localObject1).IrI.setText(parama1);
                if (bs.isNullOrNil(parama))
                {
                  ((bo)localObject1).IrK.setVisibility(8);
                  ((bo)localObject1).IrI.setPadding(0, 0, 0, 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                  parama1 = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  localObject3 = new bj(parambo, parama1, (String)localObject2);
                  ((bo)localObject1).IrF.setTag(localObject3);
                  ((bo)localObject1).IrN.setTag(localObject3);
                  if ((j != 1) || (TextUtils.isEmpty(paramString))) {
                    break label4499;
                  }
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                  j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                  k = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                  parama1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37219);
                      paramAnonymousView = (bj)paramAnonymousView.getTag();
                      ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                      localAppBrandStatObject.cYP = (paramAnonymousView.dpq.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + this.IkF);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramAnonymousView.userName))
                      {
                        localAppBrandStatObject.scene = ah.aQK(this.IkF);
                        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ah.b(ah.this).HZF.getContext(), paramString, null, k, j, this.InR, localAppBrandStatObject);
                        ah.T(9, ah.c(ah.this), ah.d(ah.this));
                        com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), parama1, Integer.valueOf(1) });
                        AppMethodBeat.o(37219);
                        return;
                      }
                      localAppBrandStatObject.scene = 1043;
                      paramAnonymousView = com.tencent.mm.al.f.dX(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                      Activity localActivity = ah.b(ah.this).HZF.getContext();
                      String str1 = paramString;
                      int i = k;
                      int j = j;
                      String str2 = this.InR;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
                        break;
                      }
                    }
                  };
                  ((bo)localObject1).IrF.setOnClickListener(parama1);
                  ((bo)localObject1).IrN.setOnClickListener(parama1);
                  ((bo)localObject1).IrF.setVisibility(0);
                  label3816:
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                  parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                  if (bs.isNullOrNil(paramString)) {
                    break label4613;
                  }
                  j = aj.gy(e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.HNS.HZF.getContext().getResources().getColor(2131100711)));
                  ((bo)localObject1).IrJ.setTextColor(j);
                  ((bo)localObject1).IrJ.setText(paramString);
                  if (!bs.isNullOrNil(parama1)) {
                    break label4543;
                  }
                  ((bo)localObject1).IrL.setVisibility(8);
                  ((bo)localObject1).IrJ.setPadding(0, 0, 0, 0);
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                  paramString = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                  localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                  ((bo)localObject1).IrG.setTag(new bj(parambo, paramString, (String)localObject3));
                  if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                    break label4590;
                  }
                  localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                  j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                  k = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                  localObject4 = bs.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                  ((bo)localObject1).IrG.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(37221);
                      paramAnonymousView = (bj)paramAnonymousView.getTag();
                      ac.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.InO });
                      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                      localAppBrandStatObject.cYP = (paramAnonymousView.dpq.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + ah.b(ah.this).getTalkerUserName() + ":" + this.IkF);
                      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramAnonymousView.userName))
                      {
                        localAppBrandStatObject.scene = ah.aQK(this.IkF);
                        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(ah.b(ah.this).HZF.getContext(), this.InO, null, k, j, this.InR, localAppBrandStatObject);
                        ah.T(9, ah.c(ah.this), ah.d(ah.this));
                        com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), paramString, Integer.valueOf(2) });
                        AppMethodBeat.o(37221);
                        return;
                      }
                      localAppBrandStatObject.scene = 1043;
                      paramAnonymousView = com.tencent.mm.al.f.dX(paramAnonymousView.userName);
                      com.tencent.mm.plugin.appbrand.service.n localn = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
                      Activity localActivity = ah.b(ah.this).HZF.getContext();
                      String str1 = this.InO;
                      int i = k;
                      int j = j;
                      String str2 = this.InR;
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                      {
                        localn.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
                        break;
                      }
                    }
                  });
                  ((bo)localObject1).IrG.setVisibility(0);
                  ((bo)localObject1).IrM.setVisibility(8);
                  if ((((bo)localObject1).IrF.getVisibility() != 8) || (((bo)localObject1).IrG.getVisibility() != 8)) {
                    break label4626;
                  }
                  ((bo)localObject1).IrC.setVisibility(8);
                  ((bo)localObject1).IrB.setVisibility(8);
                  ((bo)localObject1).IrE.setVisibility(8);
                  if ((((bo)localObject1).IrF.getVisibility() != 0) || (((bo)localObject1).IrG.getVisibility() != 0)) {
                    break label4907;
                  }
                  ((bo)localObject1).IrH.setVisibility(0);
                  parama = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
                  j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                  paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                  if ((com.tencent.mm.storage.ai.vC(parama)) || (((bo)localObject1).IrF.getVisibility() == 8) || (((bo)localObject1).IrG.getVisibility() != 8) || (j != 1) || (!com.tencent.mm.storage.ai.vC(paramString))) {
                    break label4938;
                  }
                  localObject2 = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(paramString);
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
                o.aFB().a(parama, ((bo)localObject1).IrO, this.HfF);
                ((bo)localObject1).IrP.setText(parama1);
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
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(169891);
                          o.aFB().a(this.oZR, ah.18.this.InF.IrO, ah.k(ah.this));
                          if (TextUtils.isEmpty(this.mBc)) {}
                          for (String str = ah.18.this.InO;; str = this.mBc)
                          {
                            ah.18.this.InF.IrP.setText(str);
                            AppMethodBeat.o(169891);
                            return;
                          }
                        }
                      });
                      AppMethodBeat.o(169892);
                    }
                  });
                }
                ((bo)localObject1).IrN.setVisibility(0);
                ((bo)localObject1).IrC.setVisibility(8);
                break;
                ((bo)localObject1).IrK.setVisibility(0);
                l(((bo)localObject1).IrK, parama);
                ((bo)localObject1).IrI.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 16), 0);
                break label3588;
                ((bo)localObject1).IrF.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(37220);
                    if (!bs.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      paramAnonymousView.putExtra("geta8key_username", parama1);
                      c.t(paramAnonymousView, ah.b(ah.this).getTalkerUserName());
                      com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), parama1, Integer.valueOf(1) });
                    }
                    AppMethodBeat.o(37220);
                  }
                });
                ((bo)localObject1).IrN.setOnClickListener(null);
                break label3807;
                ((bo)localObject1).IrF.setVisibility(8);
                break label3816;
                ((bo)localObject1).IrL.setVisibility(0);
                l(((bo)localObject1).IrL, parama1);
                ((bo)localObject1).IrJ.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 16), 0);
                break label3934;
                label4590:
                ((bo)localObject1).IrG.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(169890);
                    if (!bs.isNullOrNil(this.val$url))
                    {
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("rawUrl", this.val$url);
                      c.t(paramAnonymousView, ah.b(ah.this).getTalkerUserName());
                      com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.wUl.f(11608, new Object[] { ah.d(ah.this), paramString, Integer.valueOf(2) });
                    }
                    AppMethodBeat.o(169890);
                  }
                });
                break label4135;
                ((bo)localObject1).IrG.setVisibility(8);
                break label4144;
                ((bo)localObject1).IrE.setVisibility(0);
                j = this.HNS.HZF.getMMResources().getDimensionPixelOffset(2131165480);
                if ((((bo)localObject1).IrF.getVisibility() == 0) && (((bo)localObject1).IrG.getVisibility() == 0))
                {
                  ((bo)localObject1).IrF.setGravity(17);
                  ((bo)localObject1).IrG.setGravity(17);
                  ((bo)localObject1).IrF.setPadding(j, 0, j, 0);
                  ((bo)localObject1).IrG.setPadding(j, 0, j, 0);
                }
                for (;;)
                {
                  ((bo)localObject1).IrC.setVisibility(0);
                  ((bo)localObject1).IrB.setVisibility(0);
                  break;
                  if (((bo)localObject1).IrF.getVisibility() == 0)
                  {
                    if (bs.isNullOrNil(parama))
                    {
                      ((bo)localObject1).IrF.setGravity(19);
                      ((bo)localObject1).IrF.setPadding(j, 0, 0, 0);
                      ((bo)localObject1).IrM.setVisibility(0);
                    }
                    else
                    {
                      ((bo)localObject1).IrF.setGravity(17);
                      ((bo)localObject1).IrF.setPadding(j, 0, j, 0);
                    }
                  }
                  else if (bs.isNullOrNil(parama1))
                  {
                    ((bo)localObject1).IrG.setGravity(19);
                    ((bo)localObject1).IrG.setPadding(this.HNS.HZF.getMMResources().getDimensionPixelOffset(2131165480), 0, 0, 0);
                    ((bo)localObject1).IrM.setVisibility(0);
                  }
                  else
                  {
                    ((bo)localObject1).IrG.setGravity(17);
                    ((bo)localObject1).IrG.setPadding(j, 0, j, 0);
                  }
                }
                ((bo)localObject1).IrH.setVisibility(8);
                break label4241;
                parama = ((WxaAttributes)localObject2).field_brandIconURL;
                break label4364;
              }
              ((bo)localObject1).IrN.setVisibility(8);
              break label2067;
              if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramString)))
              {
                localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                localObject5 = ((bo)localObject1).Iri;
                paramString = new bj(parambo, false, paramInt, paramString, false, this.HNS.fmy(), paramString, parama, (String)localObject3);
                paramString.dBy = ((String)localObject2);
                paramString.pageUrl = ((String)localObject4);
                ((View)localObject5).setTag(paramString);
                ((bo)localObject1).Iri.setOnClickListener(this.Ink);
                break label2244;
              }
              if (i == 2)
              {
                paramString = new bj(parambo, paramString, (String)localObject4);
                paramString.position = paramInt;
                ((bo)localObject1).Iri.setTag(paramString);
                ((bo)localObject1).Iri.setOnClickListener(this.pGY);
                break label2244;
              }
              localObject5 = ((bo)localObject1).Iri;
              paramString = new bj(parambo, false, paramInt, (String)localObject4, false, this.HNS.fmy(), paramString, parama, (String)localObject3);
              paramString.dBy = ((String)localObject2);
              ((View)localObject5).setTag(paramString);
              ((bo)localObject1).Iri.setOnClickListener(h(this.HNS));
              break label2244;
              if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label5263;
                }
                ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              }
              do
              {
                ((bo)localObject1).Irp.setTag(null);
                ((bo)localObject1).Irq.setTag(null);
                ((bo)localObject1).Irp.setVisibility(8);
                ((bo)localObject1).Irq.setVisibility(8);
                break;
                paramInt = 0;
                break label5205;
                if (((bo)localObject1).Irk.getVisibility() == 0)
                {
                  ((bo)localObject1).Irp.setTag(parambo);
                  ((bo)localObject1).Irp.setOnClickListener(this.Inj);
                  ((bo)localObject1).Irp.setVisibility(0);
                  ((bo)localObject1).Irq.setVisibility(8);
                  break;
                }
              } while (((bo)localObject1).Irt.getVisibility() != 0);
              ((bo)localObject1).Irq.setTag(parambo);
              ((bo)localObject1).Irq.setOnClickListener(this.Inj);
              ((bo)localObject1).Irq.setVisibility(0);
              ((bo)localObject1).Irp.setVisibility(8);
            }
            localbh.IqJ.Iri.setVisibility(8);
            parama1 = bs.nullAsNil((String)localMap.get(".msg.fromusername"));
            i = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
            ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
            if (i == 1)
            {
              parama = bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
              paramString = bs.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
              a(localbh, com.tencent.mm.pluginsdk.ui.span.k.b(this.HNS.HZF.getContext(), paramString, localbh.xpH.getTextSize()));
              localbh.IhT.setTag(null);
              localbh.IhT.setOnClickListener(null);
              o.aFB().a(parama, localbh.IhT, this.HfF);
              ac.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambo.field_talker });
              if ((!"notifymessage".equals(parambo.field_talker)) && (i != 1)) {
                break label6189;
              }
              localbh.IqI.IqL.setVisibility(0);
              localbh.IqI.fUk.setTextSize(0, com.tencent.mm.cc.a.au(localbh.IqI.fUk.getContext(), 2131165517));
              label5627:
              localbh.IqI.nBh.setVisibility(0);
              paramString = b.bR(localMap);
              localbh.IqI.fUk.setText(paramString.title);
              ai.a(localbh.IqI.IqO, localMap);
              parama = null;
              if (!bs.isNullOrNil(parama1))
              {
                az.ayM();
                parama = com.tencent.mm.model.c.awB().aNt(parama1).aaR();
              }
              if (bs.isNullOrNil(paramString.url)) {
                break label6235;
              }
              i = 1;
              j = bs.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
              localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
              if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label6241;
              }
              parama1 = new bj(parambo, parama1, paramString.url);
              parama1.position = paramInt;
              localbh.IqI.nBh.setTag(parama1);
              localbh.IqI.nBh.setOnClickListener(this.pGY);
              i = 1;
              localbh.IqI.nBh.setOnLongClickListener(c(this.HNS));
              localbh.IqI.nBh.setOnTouchListener(((i)this.HNS.bf(i.class)).fmb());
              if (i != 0) {
                break label6367;
              }
              localbh.IqI.IqP.setVisibility(8);
              localbh.IqI.nyM.setVisibility(8);
              if (com.tencent.mm.m.g.ZZ().ZP())
              {
                localbh.IiT.setVisibility(0);
                c(this.HNS, localbh.IiT, new s.o(paramString.hiK, parambo, parama));
              }
              parama = localbh.IqI;
              if (bs.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
                break label6394;
              }
              paramInt = 1;
              if (paramInt != 0) {
                break label6399;
              }
              ac.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
              parama.IqM.setTag(null);
              parama.IqN.setTag(null);
              parama.IqM.setVisibility(8);
              parama.IqN.setVisibility(8);
            }
            for (;;)
            {
              localbh.IqI.nBh.setVisibility(0);
              AppMethodBeat.o(37242);
              return;
              a(localbh, this.HNS, parambo, parama1);
              a(localbh.IhT, this.HNS, parama1, parambo, null);
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(parama1))
              {
                localbh.IqI.IqL.setTag(new bj(parambo, parama1));
                localbh.IqI.IqL.setOnClickListener(this.Iii);
                break;
              }
              paramString = localbh.IqI.IqL;
              if (this.HNS.foQ()) {}
              for (parama = this.HNS.getTalkerUserName();; parama = null)
              {
                paramString.setTag(new bj(parama1, parama));
                localbh.IqI.IqL.setOnClickListener(e(this.HNS));
                break;
              }
              localbh.IqI.IqL.setVisibility(8);
              localbh.IqI.fUk.setTextSize(0, com.tencent.mm.cc.a.au(localbh.IqI.fUk.getContext(), 2131165184));
              break label5627;
              i = 0;
              break label5716;
              if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg(paramString.url)) {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramString.url, -1, 2, new Object[0]);
              }
              localObject1 = localbh.IqI.nBh;
              parama1 = new bj(parambo, false, paramInt, paramString.url, false, this.HNS.fmy(), parama1, parama, paramString.title);
              parama1.dBy = paramString.dBy;
              ((View)localObject1).setTag(parama1);
              localbh.IqI.nBh.setOnClickListener(h(this.HNS));
              break label5815;
              localbh.IqI.IqP.setVisibility(0);
              localbh.IqI.nyM.setVisibility(0);
              break label5894;
              label6394:
              paramInt = 0;
              break label5968;
              label6399:
              if (parama.IqL.getVisibility() == 0)
              {
                parama.IqM.setTag(parambo);
                parama.IqM.setOnClickListener(this.Inj);
                parama.IqM.setVisibility(0);
                parama.IqN.setVisibility(8);
              }
              else
              {
                parama.IqN.setTag(parambo);
                parama.IqN.setOnClickListener(this.Inj);
                parama.IqN.setVisibility(0);
                parama.IqM.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, com.tencent.mm.storage.bo parambo, String paramString)
  {
    AppMethodBeat.i(37245);
    if ((paramString == null) || (parama.xpH == null))
    {
      AppMethodBeat.o(37245);
      return;
    }
    parambo = ((com.tencent.mm.ui.chatting.c.b.f)parama1.bf(com.tencent.mm.ui.chatting.c.b.f.class)).aQj(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), parambo, parama.xpH.getTextSize()));
    AppMethodBeat.o(37245);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, com.tencent.mm.storage.bo parambo)
  {
    AppMethodBeat.i(37243);
    parambo = (bj)paramView.getTag();
    if (parambo == null)
    {
      AppMethodBeat.o(37243);
      return false;
    }
    int i = parambo.position;
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
      paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
    }
    AppMethodBeat.o(37243);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.bo parambo)
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
      paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.storage.bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  protected final boolean fqx()
  {
    return this.Ino == 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(37238);
      if (!(paramView.getTag() instanceof com.tencent.mm.storage.bo))
      {
        ac.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        AppMethodBeat.o(37238);
        return;
      }
      final com.tencent.mm.storage.bo localbo = (com.tencent.mm.storage.bo)paramView.getTag();
      if (localbo == null)
      {
        ac.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
        AppMethodBeat.o(37238);
        return;
      }
      final Map localMap = bv.L(localbo.field_content, "msg");
      if ((localMap == null) || (localMap.size() == 0))
      {
        ac.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
        AppMethodBeat.o(37238);
        return;
      }
      bs.nullAsNil((String)localMap.get(".msg.fromusername"));
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramView.getContext(), 1, false);
      locale.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(37233);
          paramAnonymousl.add(0, 1, 0, paramView.getResources().getString(2131761750));
          AppMethodBeat.o(37233);
        }
      };
      locale.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(37237);
          ac.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()), Integer.valueOf(paramAnonymousInt) });
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37237);
            return;
            az.agi().a(1198, new com.tencent.mm.ak.g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, final String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
              {
                AppMethodBeat.i(37235);
                az.agi().b(1198, this);
                ac.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, Boolean.FALSE });
                if (ah.a(ah.this) != null)
                {
                  ah.a(ah.this).dismiss();
                  ah.a(ah.this, null);
                }
                if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
                {
                  t.makeText(ah.a.2.this.cCm.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                if (ah.a.2.this.hmq != ah.a.2.this.cCm.getTag())
                {
                  ac.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(ah.a.2.this.hmq.field_msgId) });
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = ((s)paramAnonymous2n).aAL();
                if (paramAnonymous2String == null)
                {
                  t.makeText(ah.a.2.this.cCm.getContext(), 2131761751, 0).show();
                  AppMethodBeat.o(37235);
                  return;
                }
                paramAnonymous2String = paramAnonymous2String.GhQ;
                paramAnonymous2n = bs.nullAsNil((String)ah.a.2.this.frY.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).vC(paramAnonymous2n))
                {
                  ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramAnonymous2n, new m.a()
                  {
                    public final void b(WxaAttributes paramAnonymous3WxaAttributes)
                    {
                      AppMethodBeat.i(37234);
                      if (paramAnonymous3WxaAttributes == null)
                      {
                        t.makeText(ah.a.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      Object localObject = paramAnonymous3WxaAttributes.field_appId;
                      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous2String)))
                      {
                        ac.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous2String });
                        t.makeText(ah.a.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                        return;
                      }
                      try
                      {
                        int i = bs.getInt((String)ah.a.2.this.frY.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                        int j = bs.getInt((String)ah.a.2.this.frY.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                        paramAnonymous3WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8"), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
                        ac.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, localObject, paramAnonymous3WxaAttributes });
                        localObject = new Intent();
                        ((Intent)localObject).putExtra("rawUrl", paramAnonymous3WxaAttributes);
                        c.t((Intent)localObject, ah.b(ah.this).getTalkerUserName());
                        com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                        AppMethodBeat.o(37234);
                        return;
                      }
                      catch (UnsupportedEncodingException paramAnonymous3WxaAttributes)
                      {
                        ac.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        t.makeText(ah.a.2.this.cCm.getContext(), 2131761756, 0).show();
                        AppMethodBeat.o(37234);
                      }
                    }
                  });
                  AppMethodBeat.o(37235);
                  return;
                }
                ac.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { paramAnonymous2n });
                try
                {
                  paramAnonymous2n = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { paramAnonymous2n, URLEncoder.encode(ah.d(ah.this), "utf-8"), URLEncoder.encode(paramAnonymous2String, "utf-8") });
                  ac.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous2String, ah.d(ah.this), paramAnonymous2n });
                  paramAnonymous2String = new Intent();
                  paramAnonymous2String.putExtra("rawUrl", paramAnonymous2n);
                  c.t(paramAnonymous2String, ah.b(ah.this).getTalkerUserName());
                  com.tencent.mm.br.d.b(ah.b(ah.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2String);
                  AppMethodBeat.o(37235);
                  return;
                }
                catch (UnsupportedEncodingException paramAnonymous2String)
                {
                  ac.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                  t.makeText(ah.a.2.this.cCm.getContext(), 2131761756, 0).show();
                  AppMethodBeat.o(37235);
                }
              }
            });
            paramAnonymousMenuItem = new s(localbo.field_content);
            ah localah = ah.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            ah.a(localah, com.tencent.mm.ui.base.h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(37236);
                az.agi().a(paramAnonymousMenuItem);
                AppMethodBeat.o(37236);
              }
            }));
            az.agi().a(paramAnonymousMenuItem, 0);
          }
        }
      };
      locale.cED();
      AppMethodBeat.o(37238);
    }
  }
  
  public static final class b
  {
    public String dBy;
    public String hiK;
    public String hlb;
    public String hlc;
    public String hld;
    public String hle;
    public String hlf;
    public long time;
    public String title;
    public int type;
    public String url;
    
    public static b bR(Map<String, String> paramMap)
    {
      AppMethodBeat.i(37239);
      b localb = new b();
      localb.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
      localb.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
      localb.dBy = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
      localb.hlb = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
      localb.hlc = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
      localb.time = bs.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
      localb.hld = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
      localb.hle = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
      localb.hlf = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
      localb.type = bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
      localb.hiK = ((String)paramMap.get(".msg.appmsg.template_id"));
      AppMethodBeat.o(37239);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah
 * JD-Core Version:    0.7.0.1
 */