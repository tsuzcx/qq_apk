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
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
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
  protected final ChattingUIFragment fkj()
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
    private byte[] HKe;
    private final ChatFooter.g HKf;
    private com.tencent.mm.ui.appbrand.f HKg;
    private com.tencent.mm.ui.chatting.c.c.b HKh;
    private String appId;
    private int fromScene;
    private WxaAttributes.b jFr;
    private String koZ;
    private String kpa;
    private String kpb;
    private boolean kpc;
    private String kpd;
    private boolean kpe;
    private String mSceneId;
    private WxaExposedParams mdC;
    private com.tencent.mm.pluginsdk.ui.span.h nAR;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.HKf = new ChatFooter.g()
      {
        public final boolean vu(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jFA.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ac.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.cYQ });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.cYQ);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.cYQ, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ac.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.nAR = new com.tencent.mm.pluginsdk.ui.span.h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cLy.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bs.bG((String)paramAnonymousu.aW(String.class), ""), 0));
            ac.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ac.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
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
      this.HKh = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.HKf = new ChatFooter.g()
      {
        public final boolean vu(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jFA.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              ac.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.cYQ });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.cYQ);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.cYQ, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            ac.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.nAR = new com.tencent.mm.pluginsdk.ui.span.h()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cLy.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(bs.bG((String)paramAnonymousu.aW(String.class), ""), 0));
            ac.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              ac.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
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
      this.HKh = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
      AppMethodBeat.o(34206);
    }
    
    private float Xp(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private static byte[] fkl()
    {
      AppMethodBeat.i(196412);
      try
      {
        Object localObject = com.tencent.mm.sdk.platformtools.f.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(196412);
        return localObject;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(196412);
      }
      return new byte[0];
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (bs.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(this.cLy.getTalkerUserName());
        if (localObject != null) {
          break label76;
        }
      }
      label76:
      for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
      {
        this.appId = ((String)localObject);
        if (bs.isNullOrNil(this.appId)) {
          ac.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
        }
        localObject = this.appId;
        AppMethodBeat.o(34210);
        return localObject;
      }
    }
    
    public final void dRO()
    {
      AppMethodBeat.i(34215);
      super.dRO();
      com.tencent.mm.pluginsdk.ui.span.k.b(this.nAR);
      AppMethodBeat.o(34215);
    }
    
    public final void dry()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        com.tencent.mm.model.az.ayM();
        localObject = com.tencent.mm.model.c.awG().aNI("appbrandcustomerservicemsg");
        if ((localObject != null) && (!bs.isNullOrNil(((com.tencent.mm.g.c.az)localObject).field_username)))
        {
          int i = ((com.tencent.mm.g.c.az)localObject).field_unReadCount;
          l locall = new l();
          locall.cYD.cYF = this.cLy.getTalkerUserName();
          com.tencent.mm.sdk.b.a.GpY.l(locall);
          int j = locall.cYE.cYG;
          ac.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((com.tencent.mm.storage.ap)localObject).jR(Math.max(0, i - j));
          com.tencent.mm.model.az.ayM();
          if (com.tencent.mm.model.c.awG().a((com.tencent.mm.storage.ap)localObject, ((com.tencent.mm.g.c.az)localObject).field_username) == -1) {
            ac.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.dry();
        AppMethodBeat.o(34212);
        return;
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).cYV.cYF = this.cLy.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).cYV.cYG = 0;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        continue;
        ac.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        ac.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.cLy.getTalkerUserName() });
        localObject = new com.tencent.mm.g.a.q();
        ((com.tencent.mm.g.a.q)localObject).cYV.cYF = this.cLy.getTalkerUserName();
        ((com.tencent.mm.g.a.q)localObject).cYV.cYG = 0;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    
    public final void fkk()
    {
      AppMethodBeat.i(34207);
      if (!this.cLy.HZB.Ifh.containsKey(com.tencent.mm.ui.chatting.c.b.a.class)) {
        this.cLy.a(com.tencent.mm.ui.chatting.c.b.a.class, this.HKh);
      }
      super.fkk();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.mdC = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = bs.nullAsNil(getStringExtra("key_scene_id"));
      this.koZ = getStringExtra("sendMessageTitle");
      this.kpa = getStringExtra("sendMessagePath");
      this.kpb = getStringExtra("sendMessageImg");
      this.HKe = fkl();
      this.kpd = getStringExtra("sendMessageLocalImg");
      this.kpc = getBooleanExtra("showMessageCard", false).booleanValue();
      this.kpe = getBooleanExtra("needDelThumb", false).booleanValue();
      ac.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      ac.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.mdC });
      ac.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.koZ, this.kpa, this.kpb, Boolean.valueOf(this.kpc), Boolean.valueOf(this.kpe) });
      AppMethodBeat.o(34207);
    }
    
    public final void fkm()
    {
      AppMethodBeat.i(34208);
      super.fkm();
      com.tencent.mm.pluginsdk.ui.span.k.a(this.nAR);
      AppMethodBeat.o(34208);
    }
    
    protected final void fkn()
    {
      AppMethodBeat.i(34211);
      super.fkn();
      ky localky = new ky();
      localky.dmP.dmJ = 0;
      localky.dmP.aTm = ab.eUO();
      if (w.sQ(this.cLy.getTalkerUserName())) {}
      for (localky.dmP.dmR = true;; localky.dmP.dmR = false)
      {
        com.tencent.mm.sdk.b.a.GpY.l(localky);
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void onEnterBegin()
    {
      String str = null;
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = this.cLy.getTalkerUserName();
      label90:
      int i;
      label132:
      Object localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.jFr = ((WxaAttributes.b)localObject1);
        if ((this.jFr == null) || (this.jFr.jFA.size() != 1)) {
          break label256;
        }
        localObject1 = ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.HKf);
        if (this.fromScene != 2) {
          break label317;
        }
        localObject1 = new j(this.cLy.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
        com.tencent.mm.model.az.agi().a((com.tencent.mm.ak.n)localObject1, 0);
        localObject1 = getAppId();
        str = this.cLy.getTalkerUserName();
        i = this.fromScene;
        com.tencent.mm.model.az.ayM();
        localObject2 = com.tencent.mm.model.c.awG().aNI(str);
        if (localObject2 != null) {
          break label388;
        }
        ac.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
      }
      for (;;)
      {
        ac.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
        AppMethodBeat.o(34209);
        return;
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).baP();
          break;
        }
        ac.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label256:
        if ((this.jFr != null) && (this.jFr.jFA != null))
        {
          ac.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.jFr.jFA.size()) });
          break label90;
        }
        ac.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
        break label90;
        label317:
        if (this.fromScene != 3) {
          break label132;
        }
        localObject1 = getStringExtra("sns_landing_pages_ux_info");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (localObject1 = str;; localObject1 = ((String)localObject1).getBytes())
        {
          localObject1 = new j(this.cLy.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
          com.tencent.mm.model.az.agi().a((com.tencent.mm.ak.n)localObject1, 0);
          break;
        }
        label388:
        int j = ((com.tencent.mm.g.c.az)localObject2).field_unReadCount;
        str = bs.nullAsNil(this.mSceneId);
        ac.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
        com.tencent.mm.plugin.report.service.h.wUl.f(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bs.aNx()) });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if (((this.fromScene == 2) || (this.fromScene == 3)) && (this.kpc))
      {
        if (this.HKg == null)
        {
          paramView = ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne();
          this.HKg = new com.tencent.mm.ui.appbrand.f(getActivity(), paramView, paramView);
          this.HKg.DyH = false;
        }
        if (bs.isNullOrNil(this.kpd)) {
          break label206;
        }
        com.tencent.mm.modelappbrand.a.b.aAS().a(this.HKg, "file://" + this.kpd, null, ((com.tencent.mm.modelappbrand.k)g.ab(com.tencent.mm.modelappbrand.k.class)).dc((int)Xp(75), (int)Xp(60)));
      }
      for (;;)
      {
        this.HKg.HtM = new f.a()
        {
          public final void fhW()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.hke = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (bs.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.hkd = ((String)localObject);
              localb.hkf = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.hkq = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jpa;
              localb.hkr = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.hkh = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jGi;
              localb.hkg = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).jGj;
              localb.hks = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.dvr = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
              localb.dvl = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.dvm = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.cLy.getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              com.tencent.mm.model.az.agU().az((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        paramView = this.HKg;
        ac.d("MicroMsg.AppBrandServiceImageBubble", "show");
        com.tencent.mm.model.az.agU().az(new f.4(paramView));
        AppMethodBeat.o(34213);
        return;
        label206:
        com.tencent.mm.modelappbrand.a.b.aAS().a(this.HKg, this.kpb, null, ((com.tencent.mm.modelappbrand.k)g.ab(com.tencent.mm.modelappbrand.k.class)).dc((int)Xp(75), (int)Xp(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private byte[] HKe;
      private String HKj;
      private String djj;
      private k.b dsB;
      private String koZ;
      private String kpb;
      private String kpd;
      private boolean kpe;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!bs.isNullOrNil(this.kpd))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.aAS().a("file://" + this.kpd, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = com.tencent.mm.sdk.platformtools.f.aKz(this.kpb);
            localObject1 = localObject2;
            if (this.kpe)
            {
              boolean bool2 = i.deleteFile(this.kpd);
              ac.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.kpb, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.aAS().a(this.kpb, null))
        {
          ac.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          com.tencent.mm.pluginsdk.model.app.m.a(this.dsB, this.djj, this.koZ, this.HKj, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.HKe != null) {}
        for (;;)
        {
          ac.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.HKe;
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