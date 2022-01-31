package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.appbrand.c.4;
import com.tencent.mm.ui.chatting.c.b.o;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"ValidFragment"})
public class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI
  extends ChattingUIFragment
{
  private String appId;
  private int fromScene;
  private boolean hKA;
  private String hKv;
  private String hKw;
  private String hKx;
  private boolean hKy;
  private String hKz;
  private WxaAttributes.b hjL;
  private WxaExposedParams iOe;
  private String mSceneId;
  private final ChatFooter.e zwc;
  private com.tencent.mm.pluginsdk.ui.d.g zwd;
  private com.tencent.mm.ui.appbrand.c zwe;
  private com.tencent.mm.ui.chatting.c.c.b zwf;
  
  public AppBrandServiceChattingUI$AppBrandServiceChattingFmUI()
  {
    AppMethodBeat.i(30354);
    this.zwc = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.1(this);
    this.zwd = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.2(this);
    this.zwf = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
    AppMethodBeat.o(30354);
  }
  
  public AppBrandServiceChattingUI$AppBrandServiceChattingFmUI(byte paramByte)
  {
    super((byte)0);
    AppMethodBeat.i(30355);
    this.zwc = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.1(this);
    this.zwd = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.2(this);
    this.zwf = new com.tencent.mm.ui.chatting.c.c.b(new com.tencent.mm.ui.chatting.c.c.a());
    AppMethodBeat.o(30355);
  }
  
  private float Mm(int paramInt)
  {
    AppMethodBeat.i(30363);
    float f = TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
    AppMethodBeat.o(30363);
    return f;
  }
  
  private String getAppId()
  {
    AppMethodBeat.i(30359);
    if (bo.isNullOrNil(this.appId))
    {
      localObject = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(this.caz.getTalkerUserName());
      if (localObject != null) {
        break label78;
      }
    }
    label78:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bo.isNullOrNil(this.appId)) {
        ab.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
      }
      localObject = this.appId;
      AppMethodBeat.o(30359);
      return localObject;
    }
  }
  
  public final void cdy()
  {
    AppMethodBeat.i(30361);
    Object localObject;
    if ((this.fromScene == 2) || (this.fromScene == 3))
    {
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH("appbrandcustomerservicemsg");
      if ((localObject != null) && (!bo.isNullOrNil(((au)localObject).field_username)))
      {
        int i = ((au)localObject).field_unReadCount;
        l locall = new l();
        locall.cmv.cmx = this.caz.getTalkerUserName();
        com.tencent.mm.sdk.b.a.ymk.l(locall);
        int j = locall.cmw.cmy;
        ab.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        ((ak)localObject).hJ(Math.max(0, i - j));
        aw.aaz();
        if (com.tencent.mm.model.c.YF().a((ak)localObject, ((au)localObject).field_username) == -1) {
          ab.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
        }
      }
    }
    for (;;)
    {
      super.cdy();
      AppMethodBeat.o(30361);
      return;
      localObject = new com.tencent.mm.g.a.p();
      ((com.tencent.mm.g.a.p)localObject).cmL.cmx = this.caz.getTalkerUserName();
      ((com.tencent.mm.g.a.p)localObject).cmL.cmy = 0;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      continue;
      ab.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
      continue;
      ab.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.caz.getTalkerUserName() });
      localObject = new com.tencent.mm.g.a.p();
      ((com.tencent.mm.g.a.p)localObject).cmL.cmx = this.caz.getTalkerUserName();
      ((com.tencent.mm.g.a.p)localObject).cmL.cmy = 0;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final void dFC()
  {
    AppMethodBeat.i(30356);
    if (!this.caz.zJw.zOP.containsKey(com.tencent.mm.ui.chatting.c.b.a.class)) {
      this.caz.a(com.tencent.mm.ui.chatting.c.b.a.class, this.zwf);
    }
    super.dFC();
    this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
    this.iOe = ((WxaExposedParams)getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bo.nullAsNil(getStringExtra("key_scene_id"));
    this.hKv = getStringExtra("sendMessageTitle");
    this.hKw = getStringExtra("sendMessagePath");
    this.hKx = getStringExtra("sendMessageImg");
    this.hKz = getStringExtra("sendMessageLocalImg");
    this.hKy = getBooleanExtra("showMessageCard", false).booleanValue();
    this.hKA = getBooleanExtra("needDelThumb", false).booleanValue();
    ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.iOe });
    ab.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.hKv, this.hKw, this.hKx, Boolean.valueOf(this.hKy), Boolean.valueOf(this.hKA) });
    AppMethodBeat.o(30356);
  }
  
  public final void dFD()
  {
    AppMethodBeat.i(30357);
    super.dFD();
    j.a(this.zwd);
    AppMethodBeat.o(30357);
  }
  
  protected final void dFE()
  {
    AppMethodBeat.i(30360);
    super.dFE();
    jm localjm = new jm();
    localjm.cyZ.cyU = 0;
    localjm.cyZ.axa = aa.dsG();
    if (t.lA(this.caz.getTalkerUserName())) {}
    for (localjm.cyZ.czb = true;; localjm.cyZ.czb = false)
    {
      com.tencent.mm.sdk.b.a.ymk.l(localjm);
      AppMethodBeat.o(30360);
      return;
    }
  }
  
  public final void dFF()
  {
    AppMethodBeat.i(30364);
    super.dFF();
    j.b(this.zwd);
    AppMethodBeat.o(30364);
  }
  
  public final void onEnterBegin()
  {
    String str = null;
    AppMethodBeat.i(30358);
    super.onEnterBegin();
    Object localObject1 = this.caz.getTalkerUserName();
    label90:
    int i;
    label132:
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = null;
      this.hjL = ((WxaAttributes.b)localObject1);
      if ((this.hjL == null) || (this.hjL.hjU.size() != 1)) {
        break label256;
      }
      localObject1 = ((o)this.caz.ay(o.class)).dIg();
      ((ChatFooter)localObject1).setSwitchButtonMode(1);
      ((ChatFooter)localObject1).setOnFooterSwitchListener(this.zwc);
      if (this.fromScene != 2) {
        break label317;
      }
      localObject1 = new com.tencent.mm.modelsimple.i(this.caz.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null);
      aw.Rc().a((m)localObject1, 0);
      localObject1 = getAppId();
      str = this.caz.getTalkerUserName();
      i = this.fromScene;
      aw.aaz();
      localObject2 = com.tencent.mm.model.c.YF().arH(str);
      if (localObject2 != null) {
        break label388;
      }
      ab.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
      AppMethodBeat.o(30358);
      return;
      localObject2 = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae((String)localObject1);
      if (localObject2 != null)
      {
        localObject1 = ((WxaAttributes)localObject2).ayG();
        break;
      }
      ab.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
      localObject1 = null;
      break;
      label256:
      if ((this.hjL != null) && (this.hjL.hjU != null))
      {
        ab.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.hjL.hjU.size()) });
        break label90;
      }
      ab.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
      break label90;
      label317:
      if (this.fromScene != 3) {
        break label132;
      }
      localObject1 = getStringExtra("sns_landing_pages_ux_info");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = str;; localObject1 = ((String)localObject1).getBytes())
      {
        localObject1 = new com.tencent.mm.modelsimple.i(this.caz.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), (byte[])localObject1);
        aw.Rc().a((m)localObject1, 0);
        break;
      }
      label388:
      int j = ((au)localObject2).field_unReadCount;
      str = bo.nullAsNil(this.mSceneId);
      ab.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), str });
      h.qsU.e(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bo.aox()) });
    }
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(30362);
    super.onViewAttachedToWindow(paramView);
    if ((this.fromScene == 2) && (this.hKy))
    {
      if (this.zwe == null)
      {
        paramView = ((o)this.caz.ay(o.class)).dIg();
        this.zwe = new com.tencent.mm.ui.appbrand.c(getActivity(), paramView, paramView);
        this.zwe.vYQ = false;
      }
      if (bo.isNullOrNil(this.hKz)) {
        break label198;
      }
      com.tencent.mm.modelappbrand.a.b.acD().a(this.zwe, "file://" + this.hKz, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu((int)Mm(75), (int)Mm(60)));
    }
    for (;;)
    {
      this.zwe.zgs = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.4(this);
      paramView = this.zwe;
      ab.d("MicroMsg.AppBrandServiceImageBubble", "show");
      aw.RO().ac(new c.4(paramView));
      AppMethodBeat.o(30362);
      return;
      label198:
      com.tencent.mm.modelappbrand.a.b.acD().a(this.zwe, this.hKx, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu((int)Mm(75), (int)Mm(60)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI
 * JD-Core Version:    0.7.0.1
 */