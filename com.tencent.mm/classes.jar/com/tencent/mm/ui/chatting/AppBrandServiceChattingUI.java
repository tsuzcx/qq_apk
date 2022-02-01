package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.appbrand.f.4;
import com.tencent.mm.ui.appbrand.f.a;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment fEA()
  {
    AppMethodBeat.i(34219);
    AppBrandServiceChattingFmUI localAppBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI((byte)0);
    AppMethodBeat.o(34219);
    return localAppBrandServiceChattingFmUI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34218);
    overridePendingTransition(0, 0);
    super.onCreate(null);
    AppMethodBeat.o(34218);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"ValidFragment"})
  public static class AppBrandServiceChattingFmUI
    extends ChattingUIFragment
  {
    private byte[] JSL;
    private final ChatFooter.g JSM;
    private f JSN;
    private com.tencent.mm.ui.chatting.d.c.b JSO;
    private String appId;
    private int fromScene;
    private String kNo;
    private String kNp;
    private String kNq;
    private boolean kNr;
    private String kNs;
    private boolean kNt;
    private WxaAttributes.b kcN;
    private WxaExposedParams mIR;
    private String mSceneId;
    private com.tencent.mm.pluginsdk.ui.span.h ohO;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.JSM = new ChatFooter.g()
      {
        public final boolean wo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kcW.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ae.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dlk });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dlk);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((p)com.tencent.mm.kernel.g.ab(p.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dlk, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ae.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.ohO = new com.tencent.mm.pluginsdk.ui.span.h()
      {
        public final Object a(u paramAnonymousu)
        {
          AppMethodBeat.i(34200);
          switch (paramAnonymousu.type)
          {
          default: 
            AppMethodBeat.o(34200);
            return null;
          }
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cXJ.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bu.bI((String)paramAnonymousu.aY(String.class), ""), 0));
            ae.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ae.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((p)com.tencent.mm.kernel.g.ab(p.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.JSO = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.JSM = new ChatFooter.g()
      {
        public final boolean wo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kcW.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ae.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dlk });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dlk);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((p)com.tencent.mm.kernel.g.ab(p.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dlk, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ae.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.ohO = new com.tencent.mm.pluginsdk.ui.span.h()
      {
        public final Object a(u paramAnonymousu)
        {
          AppMethodBeat.i(34200);
          switch (paramAnonymousu.type)
          {
          default: 
            AppMethodBeat.o(34200);
            return null;
          }
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cXJ.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bu.bI((String)paramAnonymousu.aY(String.class), ""), 0));
            ae.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ae.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((p)com.tencent.mm.kernel.g.ab(p.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.JSO = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34206);
    }
    
    private float ZR(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private static byte[] fEC()
    {
      AppMethodBeat.i(187127);
      try
      {
        Object localObject = com.tencent.mm.sdk.platformtools.h.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(187127);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(187127);
      }
      return new byte[0];
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (bu.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(this.cXJ.getTalkerUserName());
        if (localObject != null) {
          break label76;
        }
      }
      label76:
      for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
      {
        this.appId = ((String)localObject);
        if (bu.isNullOrNil(this.appId)) {
          ae.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
        }
        localObject = this.appId;
        AppMethodBeat.o(34210);
        return localObject;
      }
    }
    
    public final void dFr()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        bc.aCg();
        localObject = com.tencent.mm.model.c.azL().aVa("appbrandcustomerservicemsg");
        if ((localObject != null) && (!bu.isNullOrNil(((ba)localObject).field_username)))
        {
          int i = ((ba)localObject).field_unReadCount;
          l locall = new l();
          locall.dkX.dkZ = this.cXJ.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IvT.l(locall);
          int j = locall.dkY.dla;
          ae.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((au)localObject).kr(Math.max(0, i - j));
          bc.aCg();
          if (com.tencent.mm.model.c.azL().a((au)localObject, ((ba)localObject).field_username) == -1) {
            ae.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.dFr();
        AppMethodBeat.o(34212);
        return;
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dlp.dkZ = this.cXJ.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dlp.dla = 0;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        continue;
        ae.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        ae.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.cXJ.getTalkerUserName() });
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dlp.dkZ = this.cXJ.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dlp.dla = 0;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    
    public final void ehQ()
    {
      AppMethodBeat.i(34215);
      super.ehQ();
      com.tencent.mm.pluginsdk.ui.span.k.b(this.ohO);
      AppMethodBeat.o(34215);
    }
    
    public final void fEB()
    {
      AppMethodBeat.i(34207);
      if (!this.cXJ.KjZ.KrM.containsKey(com.tencent.mm.ui.chatting.d.b.a.class)) {
        this.cXJ.a(com.tencent.mm.ui.chatting.d.b.a.class, this.JSO);
      }
      super.fEB();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.mIR = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = bu.nullAsNil(getStringExtra("key_scene_id"));
      this.kNo = getStringExtra("sendMessageTitle");
      this.kNp = getStringExtra("sendMessagePath");
      this.kNq = getStringExtra("sendMessageImg");
      this.JSL = fEC();
      this.kNs = getStringExtra("sendMessageLocalImg");
      this.kNr = getBooleanExtra("showMessageCard", false).booleanValue();
      this.kNt = getBooleanExtra("needDelThumb", false).booleanValue();
      ae.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      ae.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.mIR });
      ae.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.kNo, this.kNp, this.kNq, Boolean.valueOf(this.kNr), Boolean.valueOf(this.kNt) });
      AppMethodBeat.o(34207);
    }
    
    public final void fED()
    {
      AppMethodBeat.i(34208);
      super.fED();
      com.tencent.mm.pluginsdk.ui.span.k.a(this.ohO);
      AppMethodBeat.o(34208);
    }
    
    protected final void fEE()
    {
      AppMethodBeat.i(34211);
      super.fEE();
      li localli = new li();
      localli.dzI.dzC = 0;
      localli.dzI.language = ad.fom();
      if (x.wb(this.cXJ.getTalkerUserName())) {}
      for (localli.dzI.dzK = true;; localli.dzI.dzK = false)
      {
        com.tencent.mm.sdk.b.a.IvT.l(localli);
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void onEnterBegin()
    {
      String str = null;
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = this.cXJ.getTalkerUserName();
      label90:
      int i;
      label132:
      Object localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.kcN = ((WxaAttributes.b)localObject1);
        if ((this.kcN == null) || (this.kcN.kcW.size() != 1)) {
          break label256;
        }
        localObject1 = ((s)this.cXJ.bh(s.class)).fHF();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.JSM);
        if (this.fromScene != 2) {
          break label317;
        }
        localObject1 = new com.tencent.mm.modelsimple.k(this.cXJ.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
        bc.ajj().a((n)localObject1, 0);
        localObject1 = getAppId();
        str = this.cXJ.getTalkerUserName();
        i = this.fromScene;
        bc.aCg();
        localObject2 = com.tencent.mm.model.c.azL().aVa(str);
        if (localObject2 != null) {
          break label388;
        }
        ae.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
      }
      for (;;)
      {
        ae.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
        AppMethodBeat.o(34209);
        return;
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).beX();
          break;
        }
        ae.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label256:
        if ((this.kcN != null) && (this.kcN.kcW != null))
        {
          ae.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.kcN.kcW.size()) });
          break label90;
        }
        ae.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
        break label90;
        label317:
        if (this.fromScene != 3) {
          break label132;
        }
        localObject1 = getStringExtra("sns_landing_pages_ux_info");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (localObject1 = str;; localObject1 = ((String)localObject1).getBytes())
        {
          localObject1 = new com.tencent.mm.modelsimple.k(this.cXJ.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
          bc.ajj().a((n)localObject1, 0);
          break;
        }
        label388:
        int j = ((ba)localObject2).field_unReadCount;
        str = bu.nullAsNil(this.mSceneId);
        ae.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
        com.tencent.mm.plugin.report.service.g.yxI.f(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bu.aRi()) });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if (((this.fromScene == 2) || (this.fromScene == 3)) && (this.kNr))
      {
        if (this.JSN == null)
        {
          paramView = ((s)this.cXJ.bh(s.class)).fHF();
          this.JSN = new f(getActivity(), paramView, paramView);
          this.JSN.Fwo = false;
        }
        if (bu.isNullOrNil(this.kNs)) {
          break label206;
        }
        com.tencent.mm.modelappbrand.a.b.aEl().a(this.JSN, "file://" + this.kNs, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de((int)ZR(75), (int)ZR(60)));
      }
      for (;;)
      {
        this.JSN.JCn = new f.a()
        {
          public final void fCo()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.hFc = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (bu.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.hFb = ((String)localObject);
              localb.hFd = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.hFr = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jLV;
              localb.hFs = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.hFf = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kdI;
              localb.hFe = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kdJ;
              localb.hFt = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.dIz = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
              localb.dIt = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.dIu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cXJ.getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              bc.ajU().aw((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        paramView = this.JSN;
        ae.d("MicroMsg.AppBrandServiceImageBubble", "show");
        bc.ajU().aw(new f.4(paramView));
        AppMethodBeat.o(34213);
        return;
        label206:
        com.tencent.mm.modelappbrand.a.b.aEl().a(this.JSN, this.kNq, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de((int)ZR(75), (int)ZR(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private byte[] JSL;
      private String JSQ;
      private k.b dFz;
      private String dwb;
      private String kNo;
      private String kNq;
      private String kNs;
      private boolean kNt;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!bu.isNullOrNil(this.kNs))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.aEl().a("file://" + this.kNs, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = com.tencent.mm.sdk.platformtools.h.aRC(this.kNq);
            localObject1 = localObject2;
            if (this.kNt)
            {
              boolean bool2 = com.tencent.mm.vfs.o.deleteFile(this.kNs);
              ae.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.kNq, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.aEl().a(this.kNq, null))
        {
          ae.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          m.a(this.dFz, this.dwb, this.kNo, this.JSQ, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.JSL != null) {}
        for (;;)
        {
          ae.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.JSL;
          break;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */