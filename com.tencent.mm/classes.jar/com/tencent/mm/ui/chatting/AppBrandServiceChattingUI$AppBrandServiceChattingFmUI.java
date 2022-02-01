package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.m.b;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
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

@SuppressLint({"ValidFragment"})
public class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI
  extends ChattingUIFragment
{
  private byte[] Wxh;
  private int Wxi;
  private String Wxj;
  private String Wxk;
  private final ChatFooter.g Wxl;
  private f Wxm;
  private com.tencent.mm.ui.chatting.d.c.b Wxn;
  private String appId;
  private int fromScene;
  private String mSceneId;
  private String oOK;
  private String oOL;
  private String oOM;
  private boolean oON;
  private String oOO;
  private boolean oOP;
  private WxaAttributes.b oaS;
  private WxaExposedParams qXo;
  private i sCG;
  
  public AppBrandServiceChattingUI$AppBrandServiceChattingFmUI()
  {
    AppMethodBeat.i(34205);
    this.Wxl = new ChatFooter.g()
    {
      public final boolean Et(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(34199);
        if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
        {
          WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).obd.get(0);
          if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
          {
            Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.fve });
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.fve);
            AppMethodBeat.o(34199);
            return true;
          }
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1080;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.fve, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(34199);
          return true;
          Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
        }
      }
    };
    this.sCG = new i()
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
        paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.fgR.getTalkerUserName();
        AppMethodBeat.o(34200);
        return paramAnonymousu;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(34201);
        if (paramAnonymousu.type == 45)
        {
          String str = new String(Base64.decode(paramAnonymousu.url, 0));
          paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.bv(String.class), ""), 0));
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
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
        }
        AppMethodBeat.o(34201);
        return null;
      }
    };
    this.Wxn = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
    AppMethodBeat.o(34205);
  }
  
  public AppBrandServiceChattingUI$AppBrandServiceChattingFmUI(byte paramByte)
  {
    super((byte)0);
    AppMethodBeat.i(34206);
    this.Wxl = new ChatFooter.g()
    {
      public final boolean Et(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(34199);
        if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) != null)
        {
          WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).obd.get(0);
          if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username.equals(locala.userName)))
          {
            Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.fve });
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this, locala.fve);
            AppMethodBeat.o(34199);
            return true;
          }
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1080;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), locala.userName, "", 0, locala.version, locala.fve, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(34199);
          return true;
          Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
        }
      }
    };
    this.sCG = new i()
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
        paramAnonymousu = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.fgR.getTalkerUserName();
        AppMethodBeat.o(34200);
        return paramAnonymousu;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(34201);
        if (paramAnonymousu.type == 45)
        {
          String str = new String(Base64.decode(paramAnonymousu.url, 0));
          paramAnonymousu = new String(Base64.decode(Util.nullAs((String)paramAnonymousu.bv(String.class), ""), 0));
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
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, paramAnonymousu, localAppBrandStatObject);
        }
        AppMethodBeat.o(34201);
        return null;
      }
    };
    this.Wxn = new com.tencent.mm.ui.chatting.d.c.b(new com.tencent.mm.ui.chatting.d.c.a());
    AppMethodBeat.o(34206);
  }
  
  private float DI(int paramInt)
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
      localObject = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(this.fgR.getTalkerUserName());
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
  
  private static byte[] hLT()
  {
    AppMethodBeat.i(282357);
    try
    {
      Object localObject = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawColor(-1);
      localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);
      AppMethodBeat.o(282357);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", new Object[] { localException });
      AppMethodBeat.o(282357);
    }
    return new byte[0];
  }
  
  public final void doPause()
  {
    AppMethodBeat.i(34215);
    super.doPause();
    l.b(this.sCG);
    AppMethodBeat.o(34215);
  }
  
  public final void doResume()
  {
    AppMethodBeat.i(34208);
    super.doResume();
    l.a(this.sCG);
    AppMethodBeat.o(34208);
  }
  
  public final void fsh()
  {
    AppMethodBeat.i(34212);
    Object localObject;
    if ((this.fromScene == 2) || (this.fromScene == 3))
    {
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().bwx("appbrandcustomerservicemsg");
      if ((localObject != null) && (!Util.isNullOrNil(((bb)localObject).field_username)))
      {
        int i = ((bb)localObject).field_unReadCount;
        com.tencent.mm.f.a.m localm = new com.tencent.mm.f.a.m();
        localm.fuM.fuO = this.fgR.getTalkerUserName();
        EventCenter.instance.publish(localm);
        int j = localm.fuN.fuP;
        Log.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        ((az)localObject).pH(Math.max(0, i - j));
        bh.beI();
        if (com.tencent.mm.model.c.bbR().a((az)localObject, ((bb)localObject).field_username) == -1) {
          Log.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
        }
      }
    }
    for (;;)
    {
      super.fsh();
      AppMethodBeat.o(34212);
      return;
      localObject = new com.tencent.mm.f.a.t();
      ((com.tencent.mm.f.a.t)localObject).fvm.fuO = this.fgR.getTalkerUserName();
      ((com.tencent.mm.f.a.t)localObject).fvm.fuP = 0;
      EventCenter.instance.publish((IEvent)localObject);
      continue;
      Log.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
      continue;
      Log.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.fgR.getTalkerUserName() });
      localObject = new com.tencent.mm.f.a.t();
      ((com.tencent.mm.f.a.t)localObject).fvm.fuO = this.fgR.getTalkerUserName();
      ((com.tencent.mm.f.a.t)localObject).fvm.fuP = 0;
      EventCenter.instance.publish((IEvent)localObject);
    }
  }
  
  public final void hLS()
  {
    AppMethodBeat.i(34207);
    if (!this.fgR.WQs.WYH.containsKey(com.tencent.mm.ui.chatting.d.b.a.class)) {
      this.fgR.a(com.tencent.mm.ui.chatting.d.b.a.class, this.Wxn);
    }
    super.hLS();
    this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
    this.qXo = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = Util.nullAsNil(getStringExtra("key_scene_id"));
    this.oOK = getStringExtra("sendMessageTitle");
    this.oOL = getStringExtra("sendMessagePath");
    this.oOM = getStringExtra("sendMessageImg");
    this.Wxh = hLT();
    this.oOO = getStringExtra("sendMessageLocalImg");
    this.oON = getBooleanExtra("showMessageCard", false).booleanValue();
    this.oOP = getBooleanExtra("needDelThumb", false).booleanValue();
    this.Wxi = getIntExtra("app_brand_chatting_from_scene_new", 3);
    this.Wxj = getStringExtra("app_brand_chatting_from_scene_note_new");
    this.Wxk = getStringExtra("app_brand_chatting_from_app_id");
    Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.qXo });
    Log.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.oOK, this.oOL, this.oOM, Boolean.valueOf(this.oON), Boolean.valueOf(this.oOP) });
    Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate newScene: %d, newSceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(this.Wxi), this.Wxj, this.Wxk });
    AppMethodBeat.o(34207);
  }
  
  protected final void hLU()
  {
    AppMethodBeat.i(34211);
    super.hLU();
    mp localmp = new mp();
    localmp.fKL.fKG = 0;
    localmp.fKL.language = LocaleUtil.getApplicationLanguage();
    if (ab.Lj(this.fgR.getTalkerUserName())) {}
    for (localmp.fKL.fKN = true;; localmp.fKL.fKN = false)
    {
      EventCenter.instance.publish(localmp);
      AppMethodBeat.o(34211);
      return;
    }
  }
  
  public final void onEnterBegin()
  {
    AppMethodBeat.i(34209);
    super.onEnterBegin();
    Object localObject1 = this.fgR.getTalkerUserName();
    label94:
    String str1;
    label138:
    String str2;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = null;
      this.oaS = ((WxaAttributes.b)localObject1);
      if ((this.oaS == null) || (this.oaS.obd.size() != 1)) {
        break label284;
      }
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPj();
      ((ChatFooter)localObject1).setSwitchButtonMode(1);
      ((ChatFooter)localObject1).setOnFooterSwitchListener(this.Wxl);
      if (this.fromScene != 2) {
        break label345;
      }
      localObject1 = new com.tencent.mm.modelsimple.k(this.fgR.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
      bh.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      str1 = getAppId();
      str2 = this.fgR.getTalkerUserName();
      i = this.fromScene;
      j = this.Wxi;
      localObject2 = this.Wxj;
      localObject1 = this.Wxk;
      bh.beI();
      localObject3 = com.tencent.mm.model.c.bbR().bwx(str2);
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
      localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW((String)localObject1);
      if (localObject2 != null)
      {
        localObject1 = ((WxaAttributes)localObject2).bLJ();
        break;
      }
      Log.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
      localObject1 = null;
      break;
      label284:
      if ((this.oaS != null) && (this.oaS.obd != null))
      {
        Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.oaS.obd.size()) });
        break label94;
      }
      Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
      break label94;
      label345:
      if (this.fromScene != 3) {
        break label138;
      }
      localObject1 = getStringExtra("sns_landing_pages_ux_info");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = null;; localObject1 = ((String)localObject1).getBytes())
      {
        localObject1 = new com.tencent.mm.modelsimple.k(this.fgR.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
        bh.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        break;
      }
      label423:
      int k = ((bb)localObject3).field_unReadCount;
      str2 = Util.nullAsNil(this.mSceneId);
      localObject2 = Util.nullAsNil((String)localObject2);
      localObject3 = Util.nullAsNil((String)localObject1);
      localObject1 = localObject2;
      if (((String)localObject2).length() > 1024) {
        localObject1 = ((String)localObject2).substring(0, 1024);
      }
      Log.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s, newScene: %d, newSceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(13799), str1, Integer.valueOf(i), Integer.valueOf(k), str2, Integer.valueOf(j), localObject1, localObject3 });
      com.tencent.mm.plugin.report.service.h.IzE.a(13799, new Object[] { str1, Integer.valueOf(i), Integer.valueOf(k), str2, Long.valueOf(Util.nowSecond()), Integer.valueOf(j), localObject1, localObject3 });
    }
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(34213);
    super.onViewAttachedToWindow(paramView);
    if (((this.fromScene == 2) || (this.fromScene == 3)) && (this.oON))
    {
      if (this.Wxm == null)
      {
        paramView = ((com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPj();
        this.Wxm = new f(getActivity(), paramView, paramView);
        this.Wxm.RnV = false;
      }
      if (Util.isNullOrNil(this.oOO)) {
        break label206;
      }
      com.tencent.mm.modelappbrand.a.b.bhh().a(this.Wxm, "file://" + this.oOO, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK((int)DI(75), (int)DI(60)));
    }
    for (;;)
    {
      this.Wxm.WgD = new f.a()
      {
        public final void hJo()
        {
          AppMethodBeat.i(34203);
          AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.hideVKB();
          k.b localb = new k.b();
          localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this);
          localb.type = 33;
          localb.loA = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
          if (Util.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))) {}
          for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this))
          {
            localb.loz = ((String)localObject);
            localb.loB = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId;
            localb.loT = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nHY;
            localb.loU = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pkgVersion;
            localb.loD = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).obW;
            localb.loC = 2;
            localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).obX;
            localb.loV = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).iconUrl;
            localb.fUj = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).pageId);
            localb.fUd = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).username;
            localb.fUe = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this).nickname;
            localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this.fgR.getTalkerUserName());
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.j(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.this));
            bh.aHJ().postToWorker((Runnable)localObject);
            AppMethodBeat.o(34203);
            return;
          }
        }
      };
      paramView = this.Wxm;
      Log.d("MicroMsg.AppBrandServiceImageBubble", "show");
      bh.aHJ().postToWorker(new f.4(paramView));
      AppMethodBeat.o(34213);
      return;
      label206:
      com.tencent.mm.modelappbrand.a.b.bhh().a(this.Wxm, this.oOM, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK((int)DI(75), (int)DI(60)));
    }
  }
  
  static final class a
    implements Runnable
  {
    private String HDR;
    private byte[] Wxh;
    private String appid;
    private k.b fQY;
    private String oOK;
    private String oOM;
    private String oOO;
    private boolean oOP;
    
    public final void run()
    {
      boolean bool1 = true;
      AppMethodBeat.i(34204);
      Object localObject2;
      if (!Util.isNullOrNil(this.oOO))
      {
        localObject2 = com.tencent.mm.modelappbrand.a.b.bhh().a("file://" + this.oOO, null);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {}
        }
        else
        {
          localObject2 = BitmapUtil.getBitmapNative(this.oOM);
          localObject1 = localObject2;
          if (this.oOP)
          {
            boolean bool2 = com.tencent.mm.vfs.u.deleteFile(this.oOO);
            Log.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.oOM, Boolean.valueOf(bool2) });
          }
        }
      }
      for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.bhh().a(this.oOM, null))
      {
        Log.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
        localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
        localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        com.tencent.mm.pluginsdk.model.app.m.a(this.fQY, this.appid, this.oOK, this.HDR, null, (byte[])localObject1);
        AppMethodBeat.o(34204);
        return;
      }
      if (this.Wxh != null) {}
      for (;;)
      {
        Log.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
        localObject1 = this.Wxh;
        break;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI
 * JD-Core Version:    0.7.0.1
 */