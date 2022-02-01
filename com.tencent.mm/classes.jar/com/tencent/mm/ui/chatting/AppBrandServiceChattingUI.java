package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.o;
import com.tencent.mm.autogen.a.o.b;
import com.tencent.mm.autogen.a.v;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.appbrand.f.a;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment jot()
  {
    AppMethodBeat.i(34219);
    AppBrandServiceChattingFmUI localAppBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI((byte)0);
    AppMethodBeat.o(34219);
    return localAppBrandServiceChattingFmUI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34218);
    if (!getIntent().getBooleanExtra("enableAnimation", false)) {
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      super.onCreate(null);
      AppMethodBeat.o(34218);
      return;
      initNavigationSwipeBack();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class AppBrandServiceChattingFmUI
    extends ChattingUIFragment
  {
    private int aeeA;
    private String aeeB;
    private String aeeC;
    private final ChatFooter.g aeeD;
    private f aeeE;
    private com.tencent.mm.ui.chatting.component.appbrand.b aeeF;
    private byte[] aeez;
    private String appId;
    private int fromScene;
    private String mSceneId;
    private String rSA;
    private boolean rSB;
    private String rSC;
    private boolean rSD;
    private String rSy;
    private String rSz;
    private WxaAttributes.b rbE;
    private WxaExposedParams ucN;
    private com.tencent.mm.pluginsdk.ui.span.m vIA;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.aeeD = new ChatFooter.g()
      {
        public final boolean Ke(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).rbP.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.hzy });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.hzy);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((t)com.tencent.mm.kernel.h.ax(t.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.hzy, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.vIA = new com.tencent.mm.pluginsdk.ui.span.m()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.iNh().getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = (String)paramAnonymousu.cf(String.class);
            try
            {
              paramAnonymousu = new String(Base64.decode(Util.nullAs(new i(paramAnonymousu).optString("path"), ""), 0));
              Log.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
              if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
              {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
                AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
                paramAnonymousu = Boolean.TRUE;
                AppMethodBeat.o(34201);
                return paramAnonymousu;
              }
            }
            catch (Exception paramAnonymousu)
            {
              for (;;)
              {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "json parse fail: e = %s", new Object[] { paramAnonymousu });
                paramAnonymousu = "";
              }
              AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
              localAppBrandStatObject.scene = 1081;
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
            }
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.aeeF = new com.tencent.mm.ui.chatting.component.appbrand.b(new com.tencent.mm.ui.chatting.component.appbrand.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.aeeD = new ChatFooter.g()
      {
        public final boolean Ke(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).rbP.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.hzy });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.hzy);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((t)com.tencent.mm.kernel.h.ax(t.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.hzy, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.vIA = new com.tencent.mm.pluginsdk.ui.span.m()
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
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.iNh().getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = (String)paramAnonymousu.cf(String.class);
            try
            {
              paramAnonymousu = new String(Base64.decode(Util.nullAs(new i(paramAnonymousu).optString("path"), ""), 0));
              Log.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
              if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
              {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
                AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
                paramAnonymousu = Boolean.TRUE;
                AppMethodBeat.o(34201);
                return paramAnonymousu;
              }
            }
            catch (Exception paramAnonymousu)
            {
              for (;;)
              {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "json parse fail: e = %s", new Object[] { paramAnonymousu });
                paramAnonymousu = "";
              }
              AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
              localAppBrandStatObject.scene = 1081;
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
            }
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.aeeF = new com.tencent.mm.ui.chatting.component.appbrand.b(new com.tencent.mm.ui.chatting.component.appbrand.a());
      AppMethodBeat.o(34206);
    }
    
    private float Ei(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (Util.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(iNh().getTalkerUserName());
        if (localObject != null) {
          break label76;
        }
      }
      label76:
      for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
      {
        this.appId = ((String)localObject);
        if (Util.isNullOrNil(this.appId)) {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
        }
        localObject = this.appId;
        AppMethodBeat.o(34210);
        return localObject;
      }
    }
    
    private static byte[] jov()
    {
      AppMethodBeat.i(253655);
      try
      {
        Object localObject = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(253655);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(253655);
      }
      return new byte[0];
    }
    
    public final void doPause()
    {
      AppMethodBeat.i(34215);
      super.doPause();
      com.tencent.mm.pluginsdk.ui.span.p.b(this.vIA);
      AppMethodBeat.o(34215);
    }
    
    public final void doResume()
    {
      AppMethodBeat.i(34208);
      super.doResume();
      com.tencent.mm.pluginsdk.ui.span.p.a(this.vIA);
      AppMethodBeat.o(34208);
    }
    
    public final void gDP()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzG().bxM("appbrandcustomerservicemsg");
        if ((localObject != null) && (!Util.isNullOrNil(((bd)localObject).field_username)))
        {
          int i = ((bd)localObject).field_unReadCount;
          o localo = new o();
          localo.hzg.hzi = iNh().getTalkerUserName();
          localo.publish();
          int j = localo.hzh.hzj;
          Log.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((bb)localObject).pG(Math.max(0, i - j));
          bh.bCz();
          if (com.tencent.mm.model.c.bzG().c((bb)localObject, ((bd)localObject).field_username) == -1) {
            Log.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.gDP();
        AppMethodBeat.o(34212);
        return;
        localObject = new v();
        ((v)localObject).hzG.hzi = iNh().getTalkerUserName();
        ((v)localObject).hzG.hzj = 0;
        ((v)localObject).publish();
        continue;
        Log.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        Log.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { iNh().getTalkerUserName() });
        localObject = new v();
        ((v)localObject).hzG.hzi = iNh().getTalkerUserName();
        ((v)localObject).hzG.hzj = 0;
        ((v)localObject).publish();
      }
    }
    
    public final void jou()
    {
      AppMethodBeat.i(34207);
      if (!iNh().aezL.aeIh.containsKey(com.tencent.mm.ui.chatting.component.api.a.class)) {
        iNh().a(com.tencent.mm.ui.chatting.component.api.a.class, this.aeeF);
      }
      super.jou();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.ucN = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = Util.nullAsNil(getStringExtra("key_scene_id"));
      this.rSy = getStringExtra("sendMessageTitle");
      this.rSz = getStringExtra("sendMessagePath");
      this.rSA = getStringExtra("sendMessageImg");
      this.aeez = jov();
      this.rSC = getStringExtra("sendMessageLocalImg");
      this.rSB = getBooleanExtra("showMessageCard", false).booleanValue();
      this.rSD = getBooleanExtra("needDelThumb", false).booleanValue();
      this.aeeA = getIntExtra("app_brand_chatting_from_scene_new", 3);
      this.aeeB = getStringExtra("app_brand_chatting_from_scene_note_new");
      this.aeeC = getStringExtra("app_brand_chatting_from_app_id");
      Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.ucN });
      Log.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.rSy, this.rSz, this.rSA, Boolean.valueOf(this.rSB), Boolean.valueOf(this.rSD) });
      Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate newScene: %d, newSceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(this.aeeA), this.aeeB, this.aeeC });
      AppMethodBeat.o(34207);
    }
    
    protected final void jow()
    {
      AppMethodBeat.i(34211);
      super.jow();
      nw localnw = new nw();
      localnw.hQs.hQm = 0;
      localnw.hQs.language = LocaleUtil.getApplicationLanguage();
      if (au.bwE(iNh().getTalkerUserName())) {}
      for (localnw.hQs.hQu = true;; localnw.hQs.hQu = false)
      {
        localnw.publish();
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void onEnterBegin()
    {
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = iNh().getTalkerUserName();
      label94:
      label122:
      String str1;
      label163:
      String str2;
      int i;
      int j;
      Object localObject2;
      Object localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.rbE = ((WxaAttributes.b)localObject1);
        if ((this.rbE == null) || (this.rbE.rbP.size() != 1)) {
          break label309;
        }
        localObject1 = ((x)iNh().cm(x.class)).jsd();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.aeeD);
        if (this.fromScene != 3) {
          break label380;
        }
        localObject1 = getStringExtra("sns_landing_pages_ux_info");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label370;
        }
        localObject1 = null;
        localObject1 = new com.tencent.mm.modelsimple.m(iNh().getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1, this.aeeA);
        bh.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        str1 = getAppId();
        str2 = iNh().getTalkerUserName();
        i = this.fromScene;
        j = this.aeeA;
        localObject2 = this.aeeB;
        localObject1 = this.aeeC;
        bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzG().bxM(str2);
        if (localObject3 != null) {
          break label423;
        }
        Log.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str2 });
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
        AppMethodBeat.o(34209);
        return;
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).clh();
          break;
        }
        Log.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label309:
        if ((this.rbE != null) && (this.rbE.rbP != null))
        {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.rbE.rbP.size()) });
          break label94;
        }
        Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
        break label94;
        label370:
        localObject1 = ((String)localObject1).getBytes();
        break label122;
        label380:
        localObject1 = new com.tencent.mm.modelsimple.m(iNh().getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null, this.aeeA);
        bh.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        break label163;
        label423:
        int k = ((bd)localObject3).field_unReadCount;
        str2 = Util.nullAsNil(this.mSceneId);
        localObject2 = Util.nullAsNil((String)localObject2);
        localObject3 = Util.nullAsNil((String)localObject1);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 1024) {
          localObject1 = ((String)localObject2).substring(0, 1024);
        }
        Log.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s, newScene: %d, newSceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(13799), str1, Integer.valueOf(i), Integer.valueOf(k), str2, Integer.valueOf(j), localObject1, localObject3 });
        com.tencent.mm.plugin.report.service.h.OAn.b(13799, new Object[] { str1, Integer.valueOf(i), Integer.valueOf(k), str2, Long.valueOf(Util.nowSecond()), Integer.valueOf(j), localObject1, localObject3 });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if (((this.fromScene == 2) || (this.fromScene == 3) || (this.fromScene == 4)) && (this.rSB))
      {
        if (this.aeeE == null)
        {
          paramView = ((x)iNh().cm(x.class)).jsd();
          this.aeeE = new f(getActivity(), paramView, paramView);
          this.aeeE.Ykm = false;
        }
        if (Util.isNullOrNil(this.rSC)) {
          break label192;
        }
        com.tencent.mm.modelappbrand.a.b.bEY().a(this.aeeE, "file://" + this.rSC, null, ((k)com.tencent.mm.kernel.h.ax(k.class)).eE((int)Ei(75), (int)Ei(60)));
      }
      for (;;)
      {
        this.aeeE.adNz = new f.a()
        {
          public final void onSendImg()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.nTD = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (Util.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).hUf;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.nTC = ((String)localObject);
              localb.nTE = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.nTW = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).qHO;
              localb.nTX = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.nTG = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).rcM;
              localb.nTF = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).rcN;
              localb.nTY = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.iag = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).hUf);
              localb.iaa = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.iab = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.iNh().getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              bh.baH().postToWorker((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        this.aeeE.show();
        AppMethodBeat.o(34213);
        return;
        label192:
        com.tencent.mm.modelappbrand.a.b.bEY().a(this.aeeE, this.rSA, null, ((k)com.tencent.mm.kernel.h.ax(k.class)).eE((int)Ei(75), (int)Ei(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private String NBt;
      private byte[] aeez;
      private String appid;
      private k.b hWV;
      private String rSA;
      private String rSC;
      private boolean rSD;
      private String rSy;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!Util.isNullOrNil(this.rSC))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.bEY().a("file://" + this.rSC, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = BitmapUtil.getBitmapNative(this.rSA);
            localObject1 = localObject2;
            if (this.rSD)
            {
              boolean bool2 = y.deleteFile(this.rSC);
              Log.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.rSA, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.bEY().a(this.rSA, null))
        {
          Log.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          n.a(this.hWV, this.appid, this.rSy, this.NBt, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.aeez != null) {}
        for (;;)
        {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.aeez;
          break;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */