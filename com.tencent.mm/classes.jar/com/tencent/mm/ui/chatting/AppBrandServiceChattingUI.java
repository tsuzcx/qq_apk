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
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.b;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.appbrand.f.4;
import com.tencent.mm.ui.appbrand.f.a;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment eUw()
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
    private byte[] Gkp;
    private final ChatFooter.g Gkq;
    private com.tencent.mm.ui.appbrand.f Gkr;
    private com.tencent.mm.ui.chatting.c.c.b Gks;
    private String appId;
    private int fromScene;
    private String jOA;
    private boolean jOB;
    private String jOC;
    private boolean jOD;
    private String jOy;
    private String jOz;
    private WxaAttributes.b jfc;
    private WxaExposedParams lBG;
    private String mSceneId;
    private com.tencent.mm.pluginsdk.ui.span.h mYs;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.Gkq = new ChatFooter.g()
      {
        public final boolean us(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jfl.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dbu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dbu);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dbu, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ad.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.mYs = new com.tencent.mm.pluginsdk.ui.span.h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cOd.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bt.by((String)paramAnonymousu.aV(String.class), ""), 0));
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
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.Gks = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.Gkq = new ChatFooter.g()
      {
        public final boolean us(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jfl.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ad.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dbu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dbu);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dbu, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ad.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.mYs = new com.tencent.mm.pluginsdk.ui.span.h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cOd.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bt.by((String)paramAnonymousu.aV(String.class), ""), 0));
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
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.Gks = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
      AppMethodBeat.o(34206);
    }
    
    private float Vg(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private static byte[] eUy()
    {
      AppMethodBeat.i(191470);
      try
      {
        Object localObject = com.tencent.mm.sdk.platformtools.f.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(191470);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(191470);
      }
      return new byte[0];
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (bt.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(this.cOd.getTalkerUserName());
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
    
    public final void dDq()
    {
      AppMethodBeat.i(34215);
      super.dDq();
      com.tencent.mm.pluginsdk.ui.span.k.b(this.mYs);
      AppMethodBeat.o(34215);
    }
    
    public final void ddQ()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        az.arV();
        localObject = com.tencent.mm.model.c.apR().aIn("appbrandcustomerservicemsg");
        if ((localObject != null) && (!bt.isNullOrNil(((ay)localObject).field_username)))
        {
          int i = ((ay)localObject).field_unReadCount;
          l locall = new l();
          locall.dbh.dbj = this.cOd.getTalkerUserName();
          com.tencent.mm.sdk.b.a.ESL.l(locall);
          int j = locall.dbi.dbk;
          ad.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((am)localObject).jT(Math.max(0, i - j));
          az.arV();
          if (com.tencent.mm.model.c.apR().a((am)localObject, ((ay)localObject).field_username) == -1) {
            ad.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.ddQ();
        AppMethodBeat.o(34212);
        return;
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dby.dbj = this.cOd.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dby.dbk = 0;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        continue;
        ad.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        ad.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.cOd.getTalkerUserName() });
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).dby.dbj = this.cOd.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).dby.dbk = 0;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    
    protected final void eUA()
    {
      AppMethodBeat.i(34211);
      super.eUA();
      kp localkp = new kp();
      localkp.dpf.doZ = 0;
      localkp.dpf.aSt = ac.eFu();
      if (w.pF(this.cOd.getTalkerUserName())) {}
      for (localkp.dpf.dph = true;; localkp.dpf.dph = false)
      {
        com.tencent.mm.sdk.b.a.ESL.l(localkp);
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void eUx()
    {
      AppMethodBeat.i(34207);
      if (!this.cOd.GzF.GFl.containsKey(com.tencent.mm.ui.chatting.c.b.a.class)) {
        this.cOd.a(com.tencent.mm.ui.chatting.c.b.a.class, this.Gks);
      }
      super.eUx();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.lBG = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = bt.nullAsNil(getStringExtra("key_scene_id"));
      this.jOy = getStringExtra("sendMessageTitle");
      this.jOz = getStringExtra("sendMessagePath");
      this.jOA = getStringExtra("sendMessageImg");
      this.Gkp = eUy();
      this.jOC = getStringExtra("sendMessageLocalImg");
      this.jOB = getBooleanExtra("showMessageCard", false).booleanValue();
      this.jOD = getBooleanExtra("needDelThumb", false).booleanValue();
      ad.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      ad.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.lBG });
      ad.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.jOy, this.jOz, this.jOA, Boolean.valueOf(this.jOB), Boolean.valueOf(this.jOD) });
      AppMethodBeat.o(34207);
    }
    
    public final void eUz()
    {
      AppMethodBeat.i(34208);
      super.eUz();
      com.tencent.mm.pluginsdk.ui.span.k.a(this.mYs);
      AppMethodBeat.o(34208);
    }
    
    public final void onEnterBegin()
    {
      String str = null;
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = this.cOd.getTalkerUserName();
      label90:
      int i;
      label132:
      Object localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.jfc = ((WxaAttributes.b)localObject1);
        if ((this.jfc == null) || (this.jfc.jfl.size() != 1)) {
          break label256;
        }
        localObject1 = ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.Gkq);
        if (this.fromScene != 2) {
          break label317;
        }
        localObject1 = new j(this.cOd.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
        az.aeS().a((com.tencent.mm.al.n)localObject1, 0);
        localObject1 = getAppId();
        str = this.cOd.getTalkerUserName();
        i = this.fromScene;
        az.arV();
        localObject2 = com.tencent.mm.model.c.apR().aIn(str);
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
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).aTR();
          break;
        }
        ad.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label256:
        if ((this.jfc != null) && (this.jfc.jfl != null))
        {
          ad.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.jfc.jfl.size()) });
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
          localObject1 = new j(this.cOd.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
          az.aeS().a((com.tencent.mm.al.n)localObject1, 0);
          break;
        }
        label388:
        int j = ((ay)localObject2).field_unReadCount;
        str = bt.nullAsNil(this.mSceneId);
        ad.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
        com.tencent.mm.plugin.report.service.h.vKh.f(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bt.aGK()) });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if ((this.fromScene == 2) && (this.jOB))
      {
        if (this.Gkr == null)
        {
          paramView = ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs();
          this.Gkr = new com.tencent.mm.ui.appbrand.f(getActivity(), paramView, paramView);
          this.Gkr.Cgq = false;
        }
        if (bt.isNullOrNil(this.jOC)) {
          break label198;
        }
        com.tencent.mm.modelappbrand.a.b.aub().a(this.Gkr, "file://" + this.jOC, null, ((com.tencent.mm.modelappbrand.k)g.ab(com.tencent.mm.modelappbrand.k.class)).dc((int)Vg(75), (int)Vg(60)));
      }
      for (;;)
      {
        this.Gkr.FTX = new f.a()
        {
          public final void eSm()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.gJE = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (bt.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.gJD = ((String)localObject);
              localb.gJF = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.gJQ = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iOQ;
              localb.gJR = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.gJH = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jfT;
              localb.gJG = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jfU;
              localb.gJS = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.dxF = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
              localb.dxz = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.dxA = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cOd.getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              az.afE().ax((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        paramView = this.Gkr;
        ad.d("MicroMsg.AppBrandServiceImageBubble", "show");
        az.afE().ax(new f.4(paramView));
        AppMethodBeat.o(34213);
        return;
        label198:
        com.tencent.mm.modelappbrand.a.b.aub().a(this.Gkr, this.jOA, null, ((com.tencent.mm.modelappbrand.k)g.ab(com.tencent.mm.modelappbrand.k.class)).dc((int)Vg(75), (int)Vg(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private byte[] Gkp;
      private String Gku;
      private String dlB;
      private k.b duP;
      private String jOA;
      private String jOC;
      private boolean jOD;
      private String jOy;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!bt.isNullOrNil(this.jOC))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.aub().a("file://" + this.jOC, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = com.tencent.mm.sdk.platformtools.f.aFi(this.jOA);
            localObject1 = localObject2;
            if (this.jOD)
            {
              boolean bool2 = i.deleteFile(this.jOC);
              ad.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.jOA, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.aub().a(this.jOA, null))
        {
          ad.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          com.tencent.mm.pluginsdk.model.app.m.a(this.duP, this.dlB, this.jOy, this.Gku, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.Gkp != null) {}
        for (;;)
        {
          ad.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.Gkp;
          break;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */