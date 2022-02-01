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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.m.b;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.appbrand.f.4;
import com.tencent.mm.ui.appbrand.f.a;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class AppBrandServiceChattingUI
  extends ChattingUI
{
  protected final ChattingUIFragment gMI()
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
    private byte[] PdQ;
    private final ChatFooter.g PdR;
    private f PdS;
    private com.tencent.mm.ui.chatting.d.c.b PdT;
    private String appId;
    private int fromScene;
    private String lSf;
    private String lSg;
    private String lSh;
    private boolean lSi;
    private String lSj;
    private boolean lSk;
    private WxaAttributes.b lgs;
    private String mSceneId;
    private WxaExposedParams nVO;
    private i ptq;
    
    public AppBrandServiceChattingFmUI()
    {
      AppMethodBeat.i(34205);
      this.PdR = new ChatFooter.g()
      {
        public final boolean An(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).lgB.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dCx });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dCx);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((r)g.af(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dCx, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.ptq = new i()
      {
        public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
        {
          AppMethodBeat.i(34200);
          switch (paramAnonymousu.type)
          {
          default: 
            AppMethodBeat.o(34200);
            return null;
          }
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.dom.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.ba(String.class), ""), 0));
            Log.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((r)g.af(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.PdT = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34205);
    }
    
    public AppBrandServiceChattingFmUI(byte paramByte)
    {
      super();
      AppMethodBeat.i(34206);
      this.PdR = new ChatFooter.g()
      {
        public final boolean An(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(34199);
          if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
          {
            WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).lgB.get(0);
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.dCx });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.dCx);
              AppMethodBeat.o(34199);
              return true;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1080;
            ((r)g.af(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.dCx, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(34199);
            return true;
            Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
          }
        }
      };
      this.ptq = new i()
      {
        public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
        {
          AppMethodBeat.i(34200);
          switch (paramAnonymousu.type)
          {
          default: 
            AppMethodBeat.o(34200);
            return null;
          }
          paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.dom.getTalkerUserName();
          AppMethodBeat.o(34200);
          return paramAnonymousu;
        }
        
        public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
        {
          AppMethodBeat.i(34201);
          if (paramAnonymousu.type == 45)
          {
            String str = new String(Base64.decode(paramAnonymousu.url, 0));
            paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.ba(String.class), ""), 0));
            Log.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramAnonymousu });
            if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId.equals(str)))
            {
              Log.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramAnonymousu });
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, paramAnonymousu);
              paramAnonymousu = Boolean.TRUE;
              AppMethodBeat.o(34201);
              return paramAnonymousu;
            }
            AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
            localAppBrandStatObject.scene = 1081;
            ((r)g.af(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
          }
          AppMethodBeat.o(34201);
          return null;
        }
      };
      this.PdT = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
      AppMethodBeat.o(34206);
    }
    
    private float aiE(int paramInt)
    {
      AppMethodBeat.i(34214);
      float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
      AppMethodBeat.o(34214);
      return f;
    }
    
    private static byte[] gMK()
    {
      AppMethodBeat.i(232831);
      try
      {
        Object localObject = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(232831);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
        AppMethodBeat.o(232831);
      }
      return new byte[0];
    }
    
    private String getAppId()
    {
      AppMethodBeat.i(34210);
      if (Util.isNullOrNil(this.appId))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(this.dom.getTalkerUserName());
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
    
    public final void doPause()
    {
      AppMethodBeat.i(34215);
      super.doPause();
      l.b(this.ptq);
      AppMethodBeat.o(34215);
    }
    
    public final void doResume()
    {
      AppMethodBeat.i(34208);
      super.doResume();
      l.a(this.ptq);
      AppMethodBeat.o(34208);
    }
    
    public final void eGg()
    {
      AppMethodBeat.i(34212);
      Object localObject;
      if ((this.fromScene == 2) || (this.fromScene == 3))
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aST().bjY("appbrandcustomerservicemsg");
        if ((localObject != null) && (!Util.isNullOrNil(((bb)localObject).field_username)))
        {
          int i = ((bb)localObject).field_unReadCount;
          com.tencent.mm.g.a.m localm = new com.tencent.mm.g.a.m();
          localm.dCj.dCl = this.dom.getTalkerUserName();
          EventCenter.instance.publish(localm);
          int j = localm.dCk.dCm;
          Log.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((az)localObject).nt(Math.max(0, i - j));
          bg.aVF();
          if (com.tencent.mm.model.c.aST().a((az)localObject, ((bb)localObject).field_username) == -1) {
            Log.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        super.eGg();
        AppMethodBeat.o(34212);
        return;
        localObject = new com.tencent.mm.g.a.s();
        ((com.tencent.mm.g.a.s)localObject).dCF.dCl = this.dom.getTalkerUserName();
        ((com.tencent.mm.g.a.s)localObject).dCF.dCm = 0;
        EventCenter.instance.publish((IEvent)localObject);
        continue;
        Log.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        Log.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.dom.getTalkerUserName() });
        localObject = new com.tencent.mm.g.a.s();
        ((com.tencent.mm.g.a.s)localObject).dCF.dCl = this.dom.getTalkerUserName();
        ((com.tencent.mm.g.a.s)localObject).dCF.dCm = 0;
        EventCenter.instance.publish((IEvent)localObject);
      }
    }
    
    public final void gMJ()
    {
      AppMethodBeat.i(34207);
      if (!this.dom.PvZ.PDU.containsKey(com.tencent.mm.ui.chatting.d.b.a.class)) {
        this.dom.a(com.tencent.mm.ui.chatting.d.b.a.class, this.PdT);
      }
      super.gMJ();
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      this.nVO = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
      this.mSceneId = Util.nullAsNil(getStringExtra("key_scene_id"));
      this.lSf = getStringExtra("sendMessageTitle");
      this.lSg = getStringExtra("sendMessagePath");
      this.lSh = getStringExtra("sendMessageImg");
      this.PdQ = gMK();
      this.lSj = getStringExtra("sendMessageLocalImg");
      this.lSi = getBooleanExtra("showMessageCard", false).booleanValue();
      this.lSk = getBooleanExtra("needDelThumb", false).booleanValue();
      Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.nVO });
      Log.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.lSf, this.lSg, this.lSh, Boolean.valueOf(this.lSi), Boolean.valueOf(this.lSk) });
      AppMethodBeat.o(34207);
    }
    
    protected final void gML()
    {
      AppMethodBeat.i(34211);
      super.gML();
      ly locally = new ly();
      locally.dRv.dRq = 0;
      locally.dRv.language = LocaleUtil.getApplicationLanguage();
      if (ab.Eq(this.dom.getTalkerUserName())) {}
      for (locally.dRv.dRx = true;; locally.dRv.dRx = false)
      {
        EventCenter.instance.publish(locally);
        AppMethodBeat.o(34211);
        return;
      }
    }
    
    public final void onEnterBegin()
    {
      String str = null;
      AppMethodBeat.i(34209);
      super.onEnterBegin();
      Object localObject1 = this.dom.getTalkerUserName();
      label90:
      int i;
      label132:
      Object localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = null;
        this.lgs = ((WxaAttributes.b)localObject1);
        if ((this.lgs == null) || (this.lgs.lgB.size() != 1)) {
          break label256;
        }
        localObject1 = ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
        ((ChatFooter)localObject1).setSwitchButtonMode(1);
        ((ChatFooter)localObject1).setOnFooterSwitchListener(this.PdR);
        if (this.fromScene != 2) {
          break label317;
        }
        localObject1 = new com.tencent.mm.modelsimple.k(this.dom.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
        bg.azz().a((com.tencent.mm.ak.q)localObject1, 0);
        localObject1 = getAppId();
        str = this.dom.getTalkerUserName();
        i = this.fromScene;
        bg.aVF();
        localObject2 = com.tencent.mm.model.c.aST().bjY(str);
        if (localObject2 != null) {
          break label388;
        }
        Log.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
        AppMethodBeat.o(34209);
        return;
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = ((WxaAttributes)localObject2).bAr();
          break;
        }
        Log.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
        localObject1 = null;
        break;
        label256:
        if ((this.lgs != null) && (this.lgs.lgB != null))
        {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.lgs.lgB.size()) });
          break label90;
        }
        Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
        break label90;
        label317:
        if (this.fromScene != 3) {
          break label132;
        }
        localObject1 = getStringExtra("sns_landing_pages_ux_info");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (localObject1 = str;; localObject1 = ((String)localObject1).getBytes())
        {
          localObject1 = new com.tencent.mm.modelsimple.k(this.dom.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
          bg.azz().a((com.tencent.mm.ak.q)localObject1, 0);
          break;
        }
        label388:
        int j = ((bb)localObject2).field_unReadCount;
        str = Util.nullAsNil(this.mSceneId);
        Log.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
        h.CyF.a(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(Util.nowSecond()) });
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(34213);
      super.onViewAttachedToWindow(paramView);
      if (((this.fromScene == 2) || (this.fromScene == 3)) && (this.lSi))
      {
        if (this.PdS == null)
        {
          paramView = ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
          this.PdS = new f(getActivity(), paramView, paramView);
          this.PdS.Knj = false;
        }
        if (Util.isNullOrNil(this.lSj)) {
          break label206;
        }
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.PdS, "file://" + this.lSj, null, ((com.tencent.mm.modelappbrand.k)g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do((int)aiE(75), (int)aiE(60)));
      }
      for (;;)
      {
        this.PdS.ONf = new f.a()
        {
          public final void gKm()
          {
            AppMethodBeat.i(34203);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
            k.b localb = new k.b();
            localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
            localb.type = 33;
            localb.izi = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            if (Util.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
            for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
            {
              localb.izh = ((String)localObject);
              localb.izj = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
              localb.izz = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).kNW;
              localb.izA = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
              localb.izl = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).lhn;
              localb.izk = 2;
              localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).lho;
              localb.izB = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
              localb.eam = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
              localb.eag = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
              localb.eah = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
              localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.dom.getTalkerUserName());
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
              bg.aAk().postToWorker((Runnable)localObject);
              AppMethodBeat.o(34203);
              return;
            }
          }
        };
        paramView = this.PdS;
        Log.d("MicroMsg.AppBrandServiceImageBubble", "show");
        bg.aAk().postToWorker(new f.4(paramView));
        AppMethodBeat.o(34213);
        return;
        label206:
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.PdS, this.lSh, null, ((com.tencent.mm.modelappbrand.k)g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do((int)aiE(75), (int)aiE(60)));
      }
    }
    
    static final class a
      implements Runnable
    {
      private byte[] PdQ;
      private String PdV;
      private String dNI;
      private k.b dXm;
      private String lSf;
      private String lSh;
      private String lSj;
      private boolean lSk;
      
      public final void run()
      {
        boolean bool1 = true;
        AppMethodBeat.i(34204);
        Object localObject2;
        if (!Util.isNullOrNil(this.lSj))
        {
          localObject2 = com.tencent.mm.modelappbrand.a.b.aXY().a("file://" + this.lSj, null);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject2 = BitmapUtil.getBitmapNative(this.lSh);
            localObject1 = localObject2;
            if (this.lSk)
            {
              boolean bool2 = com.tencent.mm.vfs.s.deleteFile(this.lSj);
              Log.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.lSh, Boolean.valueOf(bool2) });
            }
          }
        }
        for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.aXY().a(this.lSh, null))
        {
          Log.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          com.tencent.mm.pluginsdk.model.app.m.a(this.dXm, this.dNI, this.lSf, this.PdV, null, (byte[])localObject1);
          AppMethodBeat.o(34204);
          return;
        }
        if (this.PdQ != null) {}
        for (;;)
        {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
          localObject1 = this.PdQ;
          break;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */