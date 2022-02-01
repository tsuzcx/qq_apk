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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.b;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.appbrand.f.4;
import com.tencent.mm.ui.appbrand.f.a;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment fAy()
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
    private byte[] JxV;
    private final ChatFooter.g JxW;
    private f JxX;
    private com.tencent.mm.ui.chatting.d.c.b JxY;
    private String appId;
    private int fromScene;
    private WxaAttributes.b jZw;
    private String kJZ;
    private String kKa;
    private String kKb;
    private boolean kKc;
    private String kKd;
    private boolean kKe;
    private WxaExposedParams mDM;
    private String mSceneId;
    private h oca;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.JxW = new ChatFooter.g()
      {
        public final boolean wg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jZF.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dki });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dki);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dki, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ad.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.oca = new h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cWM.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bt.bI((String)paramAnonymousu.aY(String.class), ""), 0));
            ad.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.JxY = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.JxW = new ChatFooter.g()
      {
        public final boolean wg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jZF.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dki });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dki);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dki, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ad.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.oca = new h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cWM.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bt.bI((String)paramAnonymousu.aY(String.class), ""), 0));
            ad.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.JxY = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34206);
    }
    
    private float Zl(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private static byte[] fAA()
    {
      AppMethodBeat.i(193831);
      try
      {
        Object localObject = com.tencent.mm.sdk.platformtools.g.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = com.tencent.mm.sdk.platformtools.g.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(193831);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(193831);
      }
      return new byte[0];
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (bt.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(this.cWM.getTalkerUserName());
        if (localObject != null) {
          break label76;
        }
      }
      label76:
      for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
      {
        this.appId = ((String)localObject);
        if (bt.isNullOrNil(this.appId)) {
          ad.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
        }
        localObject = this.appId;
        AppMethodBeat.o(34210);
        return localObject;
      }
    }
    
    public final void dCa()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        com.tencent.mm.model.ba.aBQ();
        localObject = com.tencent.mm.model.c.azv().aTz("appbrandcustomerservicemsg");
        if ((localObject != null) && (!bt.isNullOrNil(((com.tencent.mm.g.c.ba)localObject).field_username)))
        {
          int i = ((com.tencent.mm.g.c.ba)localObject).field_unReadCount;
          l locall = new l();
          locall.djV.djX = this.cWM.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IbL.l(locall);
          int j = locall.djW.djY;
          ad.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((at)localObject).kp(Math.max(0, i - j));
          com.tencent.mm.model.ba.aBQ();
          if (com.tencent.mm.model.c.azv().a((at)localObject, ((com.tencent.mm.g.c.ba)localObject).field_username) == -1) {
            ad.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.dCa();
        AppMethodBeat.o(34212);
        return;
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dkn.djX = this.cWM.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dkn.djY = 0;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        continue;
        ad.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        ad.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.cWM.getTalkerUserName() });
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dkn.djX = this.cWM.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dkn.djY = 0;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    
    public final void eei()
    {
      AppMethodBeat.i(34215);
      super.eei();
      com.tencent.mm.pluginsdk.ui.span.k.b(this.oca);
      AppMethodBeat.o(34215);
    }
    
    public final void fAB()
    {
      AppMethodBeat.i(34208);
      super.fAB();
      com.tencent.mm.pluginsdk.ui.span.k.a(this.oca);
      AppMethodBeat.o(34208);
    }
    
    protected final void fAC()
    {
      AppMethodBeat.i(34211);
      super.fAC();
      lh locallh = new lh();
      locallh.dyD.dyx = 0;
      locallh.dyD.language = ac.fks();
      if (w.vF(this.cWM.getTalkerUserName())) {}
      for (locallh.dyD.dyF = true;; locallh.dyD.dyF = false)
      {
        com.tencent.mm.sdk.b.a.IbL.l(locallh);
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void fAz()
    {
      AppMethodBeat.i(34207);
      if (!this.cWM.JON.JVu.containsKey(com.tencent.mm.ui.chatting.d.b.a.class)) {
        this.cWM.a(com.tencent.mm.ui.chatting.d.b.a.class, this.JxY);
      }
      super.fAz();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.mDM = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = bt.nullAsNil(getStringExtra("key_scene_id"));
      this.kJZ = getStringExtra("sendMessageTitle");
      this.kKa = getStringExtra("sendMessagePath");
      this.kKb = getStringExtra("sendMessageImg");
      this.JxV = fAA();
      this.kKd = getStringExtra("sendMessageLocalImg");
      this.kKc = getBooleanExtra("showMessageCard", false).booleanValue();
      this.kKe = getBooleanExtra("needDelThumb", false).booleanValue();
      ad.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      ad.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.mDM });
      ad.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.kJZ, this.kKa, this.kKb, Boolean.valueOf(this.kKc), Boolean.valueOf(this.kKe) });
      AppMethodBeat.o(34207);
    }
    
    public final void onEnterBegin()
    {
      String str = null;
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = this.cWM.getTalkerUserName();
      label90:
      int i;
      label132:
      Object localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.jZw = ((WxaAttributes.b)localObject1);
        if ((this.jZw == null) || (this.jZw.jZF.size() != 1)) {
          break label256;
        }
        localObject1 = ((s)this.cWM.bh(s.class)).fDC();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.JxW);
        if (this.fromScene != 2) {
          break label317;
        }
        localObject1 = new j(this.cWM.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
        com.tencent.mm.model.ba.aiU().a((com.tencent.mm.al.n)localObject1, 0);
        localObject1 = getAppId();
        str = this.cWM.getTalkerUserName();
        i = this.fromScene;
        com.tencent.mm.model.ba.aBQ();
        localObject2 = com.tencent.mm.model.c.azv().aTz(str);
        if (localObject2 != null) {
          break label388;
        }
        ad.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
      }
      for (;;)
      {
        ad.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
        AppMethodBeat.o(34209);
        return;
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).bep();
          break;
        }
        ad.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label256:
        if ((this.jZw != null) && (this.jZw.jZF != null))
        {
          ad.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.jZw.jZF.size()) });
          break label90;
        }
        ad.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
        break label90;
        label317:
        if (this.fromScene != 3) {
          break label132;
        }
        localObject1 = getStringExtra("sns_landing_pages_ux_info");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (localObject1 = str;; localObject1 = ((String)localObject1).getBytes())
        {
          localObject1 = new j(this.cWM.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
          com.tencent.mm.model.ba.aiU().a((com.tencent.mm.al.n)localObject1, 0);
          break;
        }
        label388:
        int j = ((com.tencent.mm.g.c.ba)localObject2).field_unReadCount;
        str = bt.nullAsNil(this.mSceneId);
        ad.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
        com.tencent.mm.plugin.report.service.g.yhR.f(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bt.aQJ()) });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if (((this.fromScene == 2) || (this.fromScene == 3)) && (this.kKc))
      {
        if (this.JxX == null)
        {
          paramView = ((s)this.cWM.bh(s.class)).fDC();
          this.JxX = new f(getActivity(), paramView, paramView);
          this.JxX.FdQ = false;
        }
        if (bt.isNullOrNil(this.kKd)) {
          break label206;
        }
        com.tencent.mm.modelappbrand.a.b.aDV().a(this.JxX, "file://" + this.kKd, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de((int)Zl(75), (int)Zl(60)));
      }
      for (;;)
      {
        this.JxX.JhC = new f.a()
        {
          public final void fym()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.hCn = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (bt.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.hCm = ((String)localObject);
              localb.hCo = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.hCz = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jIU;
              localb.hCA = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.hCq = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kar;
              localb.hCp = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kas;
              localb.hCB = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.dHu = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
              localb.dHo = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.dHp = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cWM.getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              com.tencent.mm.model.ba.ajF().ay((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        paramView = this.JxX;
        ad.d("MicroMsg.AppBrandServiceImageBubble", "show");
        com.tencent.mm.model.ba.ajF().ay(new f.4(paramView));
        AppMethodBeat.o(34213);
        return;
        label206:
        com.tencent.mm.modelappbrand.a.b.aDV().a(this.JxX, this.kKb, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de((int)Zl(75), (int)Zl(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private byte[] JxV;
      private String Jya;
      private k.b dEu;
      private String duW;
      private String kJZ;
      private String kKb;
      private String kKd;
      private boolean kKe;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!bt.isNullOrNil(this.kKd))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.aDV().a("file://" + this.kKd, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = com.tencent.mm.sdk.platformtools.g.aQf(this.kKb);
            localObject1 = localObject2;
            if (this.kKe)
            {
              boolean bool2 = i.deleteFile(this.kKd);
              ad.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.kKb, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.aDV().a(this.kKb, null))
        {
          ad.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          m.a(this.dEu, this.duW, this.kJZ, this.Jya, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.JxV != null) {}
        for (;;)
        {
          ad.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.JxV;
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