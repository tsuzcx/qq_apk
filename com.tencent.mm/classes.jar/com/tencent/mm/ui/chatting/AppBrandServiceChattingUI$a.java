package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.w;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.le;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.appbrand.c.4;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.q;
import java.util.List;

@SuppressLint({"ValidFragment"})
public final class AppBrandServiceChattingUI$a
  extends y
{
  private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
  private String appId;
  private WxaAttributes.b fRa;
  private int fromScene;
  private String gpM;
  private String gpN;
  private String gpO;
  private boolean gpP;
  private String gpQ;
  private boolean gpR;
  private WxaExposedParams hdB;
  private String mSceneId;
  private boolean vhe;
  private String vhf = "";
  private com.tencent.mm.sdk.b.c<le> vhg;
  private final ChatFooter.e vhh = new AppBrandServiceChattingUI.a.1(this);
  private com.tencent.mm.pluginsdk.ui.d.g vhi = new AppBrandServiceChattingUI.a.2(this);
  private com.tencent.mm.ui.appbrand.c vhj;
  
  public AppBrandServiceChattingUI$a() {}
  
  public AppBrandServiceChattingUI$a(byte paramByte)
  {
    super((byte)0);
  }
  
  private float Eo(int paramInt)
  {
    return TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private String getAppId()
  {
    if (bk.bl(this.appId))
    {
      localObject = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(this.byx.getTalkerUserName());
      if (localObject != null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bk.bl(this.appId)) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
      }
      return this.appId;
    }
  }
  
  public final void cBR()
  {
    super.cBR();
    this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.isCurrentActivity)
    {
      localObject1 = localObject2;
      if (thisActivity() != null) {
        localObject1 = thisActivity().getIntent().getParcelableExtra("app_brand_chatting_expose_params");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (getArguments() != null) {
        localObject2 = super.getArguments().getParcelable("app_brand_chatting_expose_params");
      }
    }
    this.hdB = ((WxaExposedParams)localObject2);
    this.mSceneId = bk.pm(getStringExtra("key_scene_id"));
    this.gpM = getStringExtra("sendMessageTitle");
    this.gpN = getStringExtra("sendMessagePath");
    this.gpO = getStringExtra("sendMessageImg");
    this.gpQ = getStringExtra("sendMessageLocalImg");
    this.gpP = getBooleanExtra("showMessageCard", false).booleanValue();
    this.gpR = getBooleanExtra("needDelThumb", false).booleanValue();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.hdB });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[] { this.mSceneId, this.gpM, this.gpN, this.gpO, Boolean.valueOf(this.gpP), Boolean.valueOf(this.gpR) });
  }
  
  public final void cBS()
  {
    super.cBS();
    j.a(this.vhi);
    if (TextUtils.isEmpty(this.vhf)) {
      this.vhf = com.tencent.mm.ui.appbrand.b.ada(com.tencent.mm.ui.appbrand.b.acZ(this.byx.getTalkerUserName()));
    }
    if (TextUtils.isEmpty(this.vhf))
    {
      setMMSubTitle(R.l.app_brand_service_sub_title);
      return;
    }
    setMMSubTitle(getResources().getString(R.l.app_brand_service_sub_title) + "-" + this.vhf);
  }
  
  protected final void cBT()
  {
    super.cBT();
    jd localjd = new jd();
    localjd.bRx.bRs = 0;
    localjd.bRx.auI = x.cqJ();
    if (s.fn(this.byx.getTalkerUserName())) {}
    for (localjd.bRx.bRz = true;; localjd.bRx.bRz = false)
    {
      com.tencent.mm.sdk.b.a.udP.m(localjd);
      return;
    }
  }
  
  public final void cBU()
  {
    super.cBU();
    j.b(this.vhi);
  }
  
  public final void cBV()
  {
    super.cBV();
    com.tencent.mm.sdk.b.a.udP.d(this.vhg);
  }
  
  public final void cyT()
  {
    Object localObject2 = null;
    super.cyT();
    Object localObject1 = ((n)this.byx.ac(n.class)).cEq();
    ((ChatFooter)localObject1).cnc();
    ((ChatFooter)localObject1).cnj();
    ((ChatFooter)localObject1).cnv();
    ((ChatFooter)localObject1).cny();
    ((ChatFooter)localObject1).cnp();
    ((ChatFooter)localObject1).cnl();
    ((ChatFooter)localObject1).cnn();
    ((ChatFooter)localObject1).cno();
    ((ChatFooter)localObject1).cnm();
    ((ChatFooter)localObject1).cnp();
    ((ChatFooter)localObject1).cnl();
    ((ChatFooter)localObject1).cnx();
    ((ChatFooter)localObject1).sk();
    ((ChatFooter)localObject1).cnq();
    ((ChatFooter)localObject1).T(true, true);
    ((ChatFooter)localObject1).mb(true);
    ((ChatFooter)localObject1).mc(true);
    ((ChatFooter)localObject1).cnr();
    ((ChatFooter)localObject1).cns();
    ((ChatFooter)localObject1).cnt();
    ((ChatFooter)localObject1).cno();
    ((ChatFooter)localObject1).cnu();
    ((ChatFooter)localObject1).ma(d.coz());
    localObject1 = this.byx.getTalkerUserName();
    label233:
    boolean bool;
    label272:
    label286:
    label318:
    int i;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = null;
      this.fRa = ((WxaAttributes.b)localObject1);
      if ((this.fRa == null) || (this.fRa.fRi.size() != 1)) {
        break label716;
      }
      localObject1 = ((n)this.byx.ac(n.class)).cEq();
      ((ChatFooter)localObject1).setSwitchButtonMode(1);
      ((ChatFooter)localObject1).setOnFooterSwitchListener(this.vhh);
      localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(this.byx.getTalkerUserName());
      if ((localObject1 == null) || ((((WxaAttributes)localObject1).field_appOpt & 0x2) <= 0)) {
        break label777;
      }
      bool = true;
      this.vhe = bool;
      if (localObject1 != null) {
        break label782;
      }
      localObject1 = localObject2;
      this.appId = ((String)localObject1);
      if (!this.vhe) {
        break label792;
      }
      ((q)this.byx.ac(q.class)).Hb(0);
      if (this.fromScene == 2)
      {
        localObject1 = getAppId();
        localObject2 = this.byx.getTalkerUserName();
        i = this.fromScene;
        au.Hx();
        localObject3 = com.tencent.mm.model.c.FB().abv((String)localObject2);
        if (localObject3 != null) {
          break label815;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { localObject2 });
      }
      label384:
      this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(getContext());
      if (this.fromScene == 2)
      {
        localObject1 = new com.tencent.mm.modelsimple.g(this.byx.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"));
        au.Dk().a((m)localObject1, 0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
      }
      this.vhg = new AppBrandServiceChattingUI.a.3(this);
      com.tencent.mm.sdk.b.a.udP.c(this.vhg);
      setMMSubTitle(R.l.app_brand_service_sub_title);
      setMMTitle(this.byx.cDP());
      if (!this.vhe) {
        break label924;
      }
      ((q)this.byx.ac(q.class)).Hb(0);
      label517:
      addIconOptionMenu(0, R.l.app_brand_notify_setting_title, R.g.mm_title_btn_menu, new AppBrandServiceChattingUI.a.5(this));
      showOptionMenu(true);
      localObject1 = new b.a();
      ((b.a)localObject1).ecG = 2912;
      ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      ((b.a)localObject1).ecJ = 0;
      ((b.a)localObject1).ecK = 0;
      localObject2 = new agv();
      localObject3 = com.tencent.mm.ui.appbrand.b.acZ(this.byx.getTalkerUserName());
      if (!bk.bl((String)localObject3)) {
        break label947;
      }
      ((agv)localObject2).bOL = getAppId();
    }
    for (((agv)localObject2).teq = "";; ((agv)localObject2).teq = getAppId())
    {
      ((b.a)localObject1).ecH = ((com.tencent.mm.bv.a)localObject2);
      ((b.a)localObject1).ecI = new agw();
      w.a(((b.a)localObject1).Kt(), new AppBrandServiceChattingUI.a.4(this));
      return;
      localObject3 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so((String)localObject1);
      if (localObject3 != null)
      {
        localObject1 = ((WxaAttributes)localObject3).aer();
        break;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[] { localObject1 });
      localObject1 = null;
      break;
      label716:
      if ((this.fRa != null) && (this.fRa.fRi != null))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[] { Integer.valueOf(this.fRa.fRi.size()) });
        break label233;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
      break label233;
      label777:
      bool = false;
      break label272;
      label782:
      localObject1 = ((WxaAttributes)localObject1).field_appId;
      break label286;
      label792:
      ((q)this.byx.ac(q.class)).Hb(8);
      break label318;
      label815:
      int j = ((as)localObject3).field_unReadCount;
      localObject2 = bk.pm(this.mSceneId);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject1, Integer.valueOf(i), Integer.valueOf(j), localObject2 });
      h.nFQ.f(13799, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), localObject2, Long.valueOf(bk.UX()) });
      break label384;
      label924:
      ((q)this.byx.ac(q.class)).Hb(8);
      break label517;
      label947:
      ((agv)localObject2).bOL = com.tencent.mm.ui.appbrand.b.sv((String)localObject3);
    }
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    super.onViewAttachedToWindow(paramView);
    boolean bool;
    if ((this.fromScene == 2) && (this.gpP))
    {
      if (this.vhj == null)
      {
        paramView = ((n)this.byx.ac(n.class)).cEq();
        FragmentActivity localFragmentActivity = getActivity();
        View localView = paramView.getRootView();
        if (bk.bl(paramView.getLastText())) {
          break label208;
        }
        bool = true;
        this.vhj = new com.tencent.mm.ui.appbrand.c(localFragmentActivity, localView, paramView, bool);
        this.vhj.sgy = false;
      }
      if (bk.bl(this.gpQ)) {
        break label213;
      }
      com.tencent.mm.modelappbrand.a.b.JD().a(this.vhj, "file://" + this.gpQ, null, ((i)com.tencent.mm.kernel.g.r(i.class)).bk((int)Eo(75), (int)Eo(60)));
    }
    for (;;)
    {
      this.vhj.uRR = new AppBrandServiceChattingUI.a.7(this);
      paramView = this.vhj;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandServiceImageBubble", "show");
      au.DS().O(new c.4(paramView));
      return;
      label208:
      bool = false;
      break;
      label213:
      com.tencent.mm.modelappbrand.a.b.JD().a(this.vhj, this.gpO, null, ((i)com.tencent.mm.kernel.g.r(i.class)).bk((int)Eo(75), (int)Eo(60)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a
 * JD-Core Version:    0.7.0.1
 */